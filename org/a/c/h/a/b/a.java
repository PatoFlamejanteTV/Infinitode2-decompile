/*     */ package org.a.c.h.a.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.g;
/*     */ import org.a.c.h.a.i;
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
/*     */ public abstract class a
/*     */   implements c
/*     */ {
/*  40 */   private i a = null;
/*  41 */   private d b = null;
/*  42 */   private org.a.c.b.a c = null;
/*  43 */   private org.a.c.b.a d = null;
/*  44 */   private int e = -1;
/*  45 */   private int f = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(b paramb) {
/*  55 */     if (paramb instanceof p) {
/*     */       
/*  57 */       this.a = new i((p)paramb);
/*  58 */       this.a.a().a(j.dN, (b)j.br); return;
/*     */     } 
/*  60 */     if (paramb instanceof d)
/*     */     {
/*  62 */       this.b = (d)paramb;
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
/*     */   public final d b() {
/*  87 */     if (this.a != null)
/*     */     {
/*  89 */       return (d)this.a.a();
/*     */     }
/*     */ 
/*     */     
/*  93 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final i c() {
/* 103 */     return this.a;
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
/*     */   public static a a(b paramb) {
/* 116 */     if (paramb == j.bB)
/*     */     {
/* 118 */       return new f();
/*     */     }
/*     */     
/* 121 */     b b1 = paramb;
/* 122 */     if (paramb instanceof m)
/*     */     {
/* 124 */       b1 = ((m)paramb).a();
/*     */     }
/* 126 */     if (!(b1 instanceof d))
/*     */     {
/* 128 */       throw new IOException("Error: Function must be a Dictionary, but is " + b1
/* 129 */           .getClass().getSimpleName());
/*     */     }
/*     */     d d1;
/*     */     int j;
/* 133 */     switch (j = (d1 = (d)b1).j(j.bs)) {
/*     */       
/*     */       case 0:
/* 136 */         return new b((b)d1);
/*     */       case 2:
/* 138 */         return new c((b)d1);
/*     */       case 3:
/* 140 */         return new d((b)d1);
/*     */       case 4:
/* 142 */         return new e((b)d1);
/*     */     } 
/* 144 */     throw new IOException("Error: Unknown function type " + j);
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
/*     */   public final int d() {
/* 160 */     if (this.f == -1) {
/*     */       
/* 162 */       org.a.c.b.a a1 = g();
/* 163 */       this.f = a1.b() / 2;
/*     */     } 
/* 165 */     return this.f;
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
/*     */   public final g a(int paramInt) {
/* 179 */     org.a.c.b.a a1 = g();
/* 180 */     return new g(a1, paramInt);
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
/*     */   
/*     */   public final int e() {
/* 203 */     if (this.e == -1) {
/*     */       
/* 205 */       org.a.c.b.a a1 = h();
/* 206 */       this.e = a1.b() / 2;
/*     */     } 
/* 208 */     return this.e;
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
/*     */   public final g b(int paramInt) {
/* 222 */     org.a.c.b.a a1 = h();
/* 223 */     return new g(a1, paramInt);
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
/*     */   
/*     */   protected final org.a.c.b.a g() {
/* 275 */     if (this.d == null)
/*     */     {
/* 277 */       this.d = (org.a.c.b.a)b().a(j.db);
/*     */     }
/* 279 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.a.c.b.a h() {
/* 289 */     if (this.c == null)
/*     */     {
/* 291 */       this.c = (org.a.c.b.a)b().a(j.aI);
/*     */     }
/* 293 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final float[] b(float[] paramArrayOffloat) {
/*     */     float[] arrayOfFloat;
/*     */     org.a.c.b.a a1;
/* 306 */     if ((a1 = g()) != null) {
/*     */       float[] arrayOfFloat1;
/*     */       
/*     */       int j;
/* 310 */       arrayOfFloat = new float[j = (arrayOfFloat1 = a1.d()).length / 2];
/* 311 */       for (byte b = 0; b < j; b++)
/*     */       {
/* 313 */         int k = b << 1;
/* 314 */         arrayOfFloat[b] = a(paramArrayOffloat[b], arrayOfFloat1[k], arrayOfFloat1[k + 1]);
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 319 */       arrayOfFloat = paramArrayOffloat;
/*     */     } 
/* 321 */     return arrayOfFloat;
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
/*     */   protected static float a(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 335 */     if (paramFloat1 < paramFloat2)
/*     */     {
/* 337 */       return paramFloat2;
/*     */     }
/* 339 */     if (paramFloat1 > paramFloat3)
/*     */     {
/* 341 */       return paramFloat3;
/*     */     }
/* 343 */     return paramFloat1;
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
/*     */   protected static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/* 360 */     return paramFloat4 + (paramFloat1 - paramFloat2) * (paramFloat5 - paramFloat4) / (paramFloat3 - paramFloat2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 369 */     return "FunctionType" + a();
/*     */   }
/*     */   
/*     */   public abstract int a();
/*     */   
/*     */   public abstract float[] a(float[] paramArrayOffloat);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */