/*     */ package org.a.b.f;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
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
/*     */ public class h
/*     */   extends i
/*     */ {
/*  43 */   private static final a a = c.a(h.class);
/*     */ 
/*     */   
/*     */   private final List<e> b;
/*     */   
/*     */   private final Map<Integer, l> c;
/*     */   
/*     */   private p d;
/*     */   
/*     */   private boolean e;
/*     */   
/*     */   private boolean f;
/*     */   
/*     */   private int g;
/*     */   
/*     */   private int h;
/*     */ 
/*     */   
/*     */   public h(ak paramak, p paramp) {
/*  62 */     super((short)-1); e e; this.b = new ArrayList<e>(); this.c = new HashMap<Integer, l>(); this.d = null; this.e = false; this.f = false; this.g = -1;
/*     */     this.h = -1;
/*  64 */     this.d = paramp;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  70 */       e = new e(paramak);
/*  71 */       this.b.add(e);
/*     */     }
/*  73 */     while ((e.c() & 0x20) != 0);
/*     */ 
/*     */     
/*  76 */     if ((e.c() & 0x100) != 0)
/*     */     {
/*  78 */       a(paramak, paramak.c());
/*     */     }
/*  80 */     e();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a() {
/*  89 */     if (this.f) {
/*     */       return;
/*     */     }
/*     */     
/*  93 */     if (this.e) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*  98 */     this.e = true;
/*     */     
/* 100 */     int j = 0;
/* 101 */     int k = 0;
/*     */     
/* 103 */     for (Iterator<e> iterator = this.b.iterator(); iterator.hasNext(); ) {
/*     */       e e;
/* 105 */       (e = iterator.next()).a(j);
/* 106 */       e.b(k);
/*     */       
/*     */       l l;
/* 109 */       if ((l = this.c.get(Integer.valueOf(e.d()))) != null) {
/*     */         
/* 111 */         l.a();
/* 112 */         j += l.c();
/* 113 */         k += l.d();
/*     */       } 
/*     */     } 
/* 116 */     this.f = true;
/* 117 */     this.e = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int a(int paramInt) {
/*     */     e e;
/* 127 */     if ((e = f(paramInt)) != null) {
/*     */       l l;
/*     */       
/* 130 */       return (l = this.c.get(Integer.valueOf(e.d()))).a(paramInt - e.b()) + e.a();
/*     */     } 
/* 132 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte b(int paramInt) {
/*     */     e e;
/* 142 */     if ((e = e(paramInt)) != null) {
/*     */       l l;
/*     */       
/* 145 */       return (l = this.c.get(Integer.valueOf(e.d()))).b(paramInt - e.a());
/*     */     } 
/* 147 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short c(int paramInt) {
/*     */     e e;
/* 157 */     if ((e = e(paramInt)) != null) {
/*     */       
/* 159 */       l l = this.c.get(Integer.valueOf(e.d()));
/* 160 */       paramInt -= e.a();
/* 161 */       short s = l.c(paramInt);
/* 162 */       paramInt = l.d(paramInt);
/*     */ 
/*     */       
/* 165 */       return paramInt = (short)((paramInt = (short)e.a(s, paramInt)) + e.e());
/*     */     } 
/* 167 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final short d(int paramInt) {
/*     */     e e;
/* 177 */     if ((e = e(paramInt)) != null) {
/*     */       
/* 179 */       l l = this.c.get(Integer.valueOf(e.d()));
/* 180 */       paramInt -= e.a();
/* 181 */       short s = l.c(paramInt);
/* 182 */       paramInt = l.d(paramInt);
/*     */ 
/*     */       
/* 185 */       return paramInt = (short)((paramInt = (short)e.b(s, paramInt)) + e.f());
/*     */     } 
/* 187 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/* 196 */     return true;
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
/*     */   public final int c() {
/* 209 */     if (this.g < 0) {
/*     */       
/* 211 */       e e = this.b.get(this.b.size() - 1);
/*     */       l l;
/* 213 */       if ((l = this.c.get(Integer.valueOf(e.d()))) == null) {
/*     */         
/* 215 */         (new StringBuilder("GlyphDescription for index ")).append(e.d()).append(" is null, returning 0");
/* 216 */         this.g = 0;
/*     */       }
/*     */       else {
/*     */         
/* 220 */         this.g = e.a() + l.c();
/*     */       } 
/*     */     } 
/* 223 */     return this.g;
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
/*     */   public final int d() {
/* 236 */     if (this.h < 0) {
/*     */       
/* 238 */       e e = this.b.get(this.b.size() - 1);
/* 239 */       this.h = e.b() + ((l)this.c.get(Integer.valueOf(e.d()))).d();
/*     */     } 
/* 241 */     return this.h;
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
/*     */   
/*     */   private e e(int paramInt) {
/* 256 */     for (e e : this.b) {
/*     */       
/* 258 */       l l = this.c.get(Integer.valueOf(e.d()));
/* 259 */       if (e.a() <= paramInt && l != null && paramInt < e.a() + l.c())
/*     */       {
/* 261 */         return e;
/*     */       }
/*     */     } 
/* 264 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private e f(int paramInt) {
/* 269 */     for (e e : this.b) {
/*     */       
/* 271 */       l l = this.c.get(Integer.valueOf(e.d()));
/* 272 */       if (e.b() <= paramInt && l != null && paramInt < e.b() + l.d())
/*     */       {
/* 274 */         return e;
/*     */       }
/*     */     } 
/* 277 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void e() {
/* 282 */     for (e e : this.b) {
/*     */ 
/*     */       
/*     */       try {
/* 286 */         int j = e.d();
/*     */         k k;
/* 288 */         if ((k = this.d.a(j)) != null)
/*     */         {
/* 290 */           this.c.put(Integer.valueOf(j), k.a());
/*     */         }
/*     */       }
/* 293 */       catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */