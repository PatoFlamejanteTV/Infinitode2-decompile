/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.WritableRaster;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.f;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.h.a.g;
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
/*     */ public final class r
/*     */   extends b
/*     */ {
/*     */   private e f;
/*     */   
/*     */   public r() {
/*  42 */     super(j.bT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public r(a parama) {
/*  51 */     super(parama);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  57 */     return j.bT.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/*  66 */     int i = paramWritableRaster.getWidth();
/*  67 */     int j = paramWritableRaster.getHeight();
/*     */     
/*     */     BufferedImage bufferedImage;
/*  70 */     WritableRaster writableRaster = (bufferedImage = new BufferedImage(i, j, 1)).getRaster();
/*     */     
/*  72 */     float f1 = e().a();
/*  73 */     float f2 = e().b();
/*  74 */     float f3 = g().a();
/*  75 */     float f4 = g().b();
/*     */ 
/*     */     
/*  78 */     float[] arrayOfFloat = new float[3];
/*  79 */     for (byte b1 = 0; b1 < j; b1++) {
/*     */       
/*  81 */       for (byte b2 = 0; b2 < i; b2++) {
/*     */         
/*  83 */         paramWritableRaster.getPixel(b2, b1, arrayOfFloat);
/*     */ 
/*     */         
/*  86 */         arrayOfFloat[0] = arrayOfFloat[0] / 255.0F;
/*  87 */         arrayOfFloat[1] = arrayOfFloat[1] / 255.0F;
/*  88 */         arrayOfFloat[2] = arrayOfFloat[2] / 255.0F;
/*     */ 
/*     */         
/*  91 */         arrayOfFloat[0] = arrayOfFloat[0] * 100.0F;
/*  92 */         arrayOfFloat[1] = f1 + arrayOfFloat[1] * (f2 - f1);
/*  93 */         arrayOfFloat[2] = f3 + arrayOfFloat[2] * (f4 - f3);
/*     */ 
/*     */         
/*     */         float[] arrayOfFloat1;
/*     */         
/*  98 */         (arrayOfFloat1 = a(arrayOfFloat))[0] = (arrayOfFloat1 = a(arrayOfFloat))[0] * 255.0F;
/*  99 */         arrayOfFloat1[1] = arrayOfFloat1[1] * 255.0F;
/* 100 */         arrayOfFloat1[2] = arrayOfFloat1[2] * 255.0F;
/*     */         
/* 102 */         writableRaster.setPixel(b2, b1, arrayOfFloat1);
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 115 */     float f2 = (paramArrayOffloat[0] + 16.0F) * 0.00862069F;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     float f3 = this.b * a(f2 + paramArrayOffloat[1] * 0.002F);
/* 121 */     float f4 = this.c * a(f2);
/* 122 */     float f1 = this.d * a(f2 - paramArrayOffloat[2] * 0.005F);
/*     */     
/* 124 */     return a(f3, f4, f1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static float a(float paramFloat) {
/* 130 */     if (paramFloat > 0.20689655172413793D)
/*     */     {
/* 132 */       return paramFloat * paramFloat * paramFloat;
/*     */     }
/*     */ 
/*     */     
/* 136 */     return 0.12841855F * (paramFloat - 0.13793103F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 143 */     return 3;
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
/*     */   public final e c() {
/* 157 */     if (this.f == null)
/*     */     {
/* 159 */       this
/*     */ 
/*     */         
/* 162 */         .f = new e(new float[] { 0.0F, Math.max(0.0F, e().a()), Math.max(0.0F, g().a()) }this);
/*     */     }
/*     */     
/* 165 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static a d() {
/*     */     a a;
/* 175 */     (a = new a()).a((b)new f(-100.0F));
/* 176 */     a.a((b)new f(100.0F));
/* 177 */     a.a((b)new f(-100.0F));
/* 178 */     a.a((b)new f(100.0F));
/* 179 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private g e() {
/*     */     a a;
/* 190 */     if ((a = (a)this.a.a(j.db)) == null)
/*     */     {
/* 192 */       a = d();
/*     */     }
/* 194 */     return new g(a, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private g g() {
/*     */     a a;
/* 205 */     if ((a = (a)this.a.a(j.db)) == null)
/*     */     {
/* 207 */       a = d();
/*     */     }
/* 209 */     return new g(a, 1);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */