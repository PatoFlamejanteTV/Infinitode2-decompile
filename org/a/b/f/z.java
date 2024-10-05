/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.b.h.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class z
/*     */   extends an
/*     */ {
/*     */   private List<y> c;
/*     */   private Map<Integer, Map<Integer, Map<Integer, Map<Integer, String>>>> d;
/*  44 */   private String e = null;
/*  45 */   private String f = null;
/*  46 */   private String g = null;
/*     */ 
/*     */   
/*     */   z(ap paramap) {
/*  50 */     super(paramap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ap paramap, ak paramak) {
/*  63 */     paramak.c();
/*  64 */     int i = paramak.c();
/*  65 */     paramak.c();
/*  66 */     this.c = new ArrayList<y>(i);
/*  67 */     for (byte b = 0; b < i; b++) {
/*     */       y y;
/*     */       
/*  70 */       (y = new y()).a(paramak);
/*  71 */       this.c.add(y);
/*     */     } 
/*     */     
/*  74 */     for (null = this.c.iterator(); null.hasNext(); ) {
/*     */       y y;
/*     */       
/*  77 */       if ((y = null.next()).b() > C()) {
/*     */         
/*  79 */         y.a((String)null);
/*     */         
/*     */         continue;
/*     */       } 
/*  83 */       paramak.a(D() + 6L + ((i << 1) * 6) + y.b());
/*  84 */       int j = y.f();
/*  85 */       int k = y.e();
/*  86 */       Charset charset = b.a;
/*  87 */       if (j == 3 && (k == 0 || k == 1)) {
/*     */         
/*  89 */         charset = b.b;
/*     */       }
/*  91 */       else if (j == 0) {
/*     */         
/*  93 */         charset = b.b;
/*     */       }
/*  95 */       else if (j == 2) {
/*     */         
/*  97 */         switch (k) {
/*     */           
/*     */           case 0:
/* 100 */             charset = b.d;
/*     */             break;
/*     */           
/*     */           case 1:
/* 104 */             charset = b.e;
/*     */             break;
/*     */           case 2:
/* 107 */             charset = b.a;
/*     */             break;
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/* 113 */       String str = paramak.a(y.a(), charset);
/* 114 */       y.a(str);
/*     */     } 
/*     */ 
/*     */     
/* 118 */     this.d = new HashMap<Integer, Map<Integer, Map<Integer, Map<Integer, String>>>>(this.c.size());
/* 119 */     for (y y : this.c) {
/*     */       Map<Object, Object> map1;
/*     */ 
/*     */       
/* 123 */       if ((map1 = (Map)this.d.get(Integer.valueOf(y.d()))) == null) {
/*     */         
/* 125 */         map1 = new HashMap<Object, Object>();
/* 126 */         this.d.put(Integer.valueOf(y.d()), map1);
/*     */       } 
/*     */       
/*     */       Map<Object, Object> map2;
/* 130 */       if ((map2 = (Map)map1.get(Integer.valueOf(y.f()))) == null) {
/*     */         
/* 132 */         map2 = new HashMap<Object, Object>();
/* 133 */         map1.put(Integer.valueOf(y.f()), map2);
/*     */       } 
/*     */       
/*     */       Map<Object, Object> map3;
/* 137 */       if ((map3 = (Map)map2.get(Integer.valueOf(y.e()))) == null) {
/*     */         
/* 139 */         map3 = new HashMap<Object, Object>();
/* 140 */         map2.put(Integer.valueOf(y.e()), map3);
/*     */       } 
/*     */       
/* 143 */       map3.put(Integer.valueOf(y.c()), y.g());
/*     */     } 
/*     */ 
/*     */     
/* 147 */     this.e = a(1);
/* 148 */     this.f = a(2);
/*     */ 
/*     */     
/* 151 */     this.g = a(6, 1, 0, 0);
/*     */ 
/*     */ 
/*     */     
/* 155 */     if (this.g == null)
/*     */     {
/* 157 */       this.g = a(6, 3, 1, 1033);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 162 */     if (this.g != null)
/*     */     {
/* 164 */       this.g = this.g.trim();
/*     */     }
/*     */     
/* 167 */     this.a = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String a(int paramInt) {
/* 176 */     for (byte b = 4; b >= 0; b--) {
/*     */       String str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 183 */       if ((str = a(paramInt, 0, b, 0)) != null)
/*     */       {
/* 185 */         return str;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     String str1;
/*     */ 
/*     */ 
/*     */     
/* 195 */     if ((str1 = a(paramInt, 3, 1, 1033)) != null)
/*     */     {
/* 197 */       return str1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     String str2;
/*     */ 
/*     */ 
/*     */     
/* 206 */     if ((str2 = a(paramInt, 1, 0, 0)) != null)
/*     */     {
/* 208 */       return str2;
/*     */     }
/*     */     
/* 211 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     Map map;
/* 226 */     if ((map = this.d.get(Integer.valueOf(paramInt1))) == null)
/*     */     {
/* 228 */       return null;
/*     */     }
/*     */     
/* 231 */     if ((map = (Map)map.get(Integer.valueOf(paramInt2))) == null)
/*     */     {
/* 233 */       return null;
/*     */     }
/*     */     
/* 236 */     if ((map = (Map)map.get(Integer.valueOf(paramInt3))) == null)
/*     */     {
/* 238 */       return null;
/*     */     }
/* 240 */     return (String)map.get(Integer.valueOf(paramInt4));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<y> a() {
/* 250 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String b() {
/* 260 */     return this.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String c() {
/* 270 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String d() {
/* 280 */     return this.g;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */