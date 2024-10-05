/*     */ package org.a.b.b;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.a.b.a;
/*     */ import org.a.b.d.b;
/*     */ import org.a.b.g.c;
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
/*     */ public final class o
/*     */   extends i
/*     */   implements a
/*     */ {
/*  36 */   private final Map<String, Object> f = new LinkedHashMap<String, Object>();
/*     */   
/*     */   private e g;
/*  39 */   private final Map<Integer, w> h = new ConcurrentHashMap<Integer, w>();
/*     */ 
/*     */   
/*  42 */   private final a i = new a((byte)0);
/*     */ 
/*     */ 
/*     */   
/*     */   class a
/*     */     implements c
/*     */   {
/*     */     private a(o this$0) {}
/*     */ 
/*     */     
/*     */     public final t a_(String param1String) {
/*  53 */       return this.a.c(param1String);
/*     */     }
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
/*     */   public final float a(String paramString) {
/*  66 */     return c(paramString).a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b(String paramString) {
/*  72 */     int j = this.c.a(paramString);
/*     */     
/*  74 */     return ((j = this.c.b(j)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final List<Number> d() {
/*  80 */     return (List<Number>)this.b.get("FontMatrix");
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
/*     */   public final t c(String paramString) {
/*  92 */     int j = d(paramString);
/*     */ 
/*     */     
/*  95 */     return a(j, paramString);
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
/*     */   private int d(String paramString) {
/* 107 */     int j = this.c.a(paramString);
/* 108 */     return this.c.b(j);
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
/*     */   public final w c(int paramInt) {
/* 120 */     String str = "GID+" + paramInt;
/* 121 */     return a(paramInt, str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private w a(int paramInt, String paramString) {
/*     */     w w;
/* 128 */     if ((w = this.h.get(Integer.valueOf(paramInt))) == null) {
/*     */       byte[] arrayOfByte;
/* 130 */       w = null;
/* 131 */       if (paramInt < this.d.length)
/*     */       {
/* 133 */         arrayOfByte = this.d[paramInt];
/*     */       }
/* 135 */       if (arrayOfByte == null)
/*     */       {
/*     */         
/* 138 */         arrayOfByte = this.d[0];
/*     */       }
/*     */       y y;
/* 141 */       List<Object> list = (y = new y(this.a, paramString)).a(arrayOfByte, this.e, f());
/*     */       
/* 143 */       w = new w(this.i, this.a, paramString, paramInt, list, g(), h());
/* 144 */       this.h.put(Integer.valueOf(paramInt), w);
/*     */     } 
/* 146 */     return w;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void b(String paramString, Object paramObject) {
/* 168 */     if (paramObject != null)
/*     */     {
/* 170 */       this.f.put(paramString, paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e e() {
/* 182 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final void a(e parame) {
/* 192 */     this.g = parame;
/*     */   }
/*     */ 
/*     */   
/*     */   private byte[][] f() {
/* 197 */     return (byte[][])this.f.get("Subrs");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Object f(String paramString) {
/*     */     Object object;
/* 204 */     if ((object = this.b.get(paramString)) != null)
/*     */     {
/* 206 */       return object;
/*     */     }
/*     */     
/* 209 */     if ((paramString = (String)this.f.get(paramString)) != null)
/*     */     {
/* 211 */       return paramString;
/*     */     }
/* 213 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private int g() {
/*     */     Number number;
/* 219 */     if ((number = (Number)f("defaultWidthX")) == null)
/*     */     {
/* 221 */       return 1000;
/*     */     }
/* 223 */     return number.intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   private int h() {
/*     */     Number number;
/* 229 */     if ((number = (Number)f("nominalWidthX")) == null)
/*     */     {
/* 231 */       return 0;
/*     */     }
/* 233 */     return number.intValue();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */