/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.IOException;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.i;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.k;
/*     */ import org.a.c.b.l;
/*     */ import org.a.c.b.s;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.j;
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
/*     */ public final class p
/*     */   extends v
/*     */ {
/*  45 */   private final e a = new e(new float[] { 0.0F }, this);
/*     */   
/*  47 */   private f b = null;
/*     */ 
/*     */   
/*     */   private byte[] c;
/*     */ 
/*     */   
/*     */   private float[][] d;
/*     */   
/*     */   private int f;
/*     */   
/*     */   private int[][] g;
/*     */ 
/*     */   
/*     */   public p() {
/*  61 */     this.e = new a();
/*  62 */     this.e.a((b)j.bH);
/*  63 */     this.e.a((b)j.aD);
/*  64 */     this.e.a((b)i.a(255L));
/*  65 */     this.e.a((b)k.a);
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
/*     */   public p(a parama, j paramj) {
/*  86 */     this.e = parama;
/*     */ 
/*     */     
/*  89 */     this.b = f.a(this.e.b(1), paramj);
/*  90 */     h();
/*  91 */     d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  97 */     return j.bH.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 103 */     return 1;
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
/*     */   public final e c() {
/* 115 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/*     */     WritableRaster writableRaster1;
/* 123 */     int i = this.b.b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 130 */       writableRaster1 = Raster.createBandedRaster(0, this.f + 1, 1, i, new Point(0, 0));
/*     */     
/*     */     }
/* 133 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */       
/* 136 */       throw new IOException(illegalArgumentException);
/*     */     } 
/*     */     
/* 139 */     int[] arrayOfInt1 = new int[i]; byte b; int k;
/* 140 */     for (b = 0, k = this.f; b <= k; b++) {
/*     */       
/* 142 */       for (byte b1 = 0; b1 < i; b1++)
/*     */       {
/* 144 */         arrayOfInt1[b1] = (int)(this.d[b][b1] * 255.0F);
/*     */       }
/* 146 */       writableRaster1.setPixel(b, 0, arrayOfInt1);
/*     */     } 
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */     
/* 151 */     WritableRaster writableRaster2 = (bufferedImage = this.b.a(writableRaster1)).getRaster();
/*     */ 
/*     */     
/* 154 */     this.g = new int[this.f + 1][3];
/* 155 */     int[] arrayOfInt2 = null;
/*     */     int j;
/* 157 */     for (i = 0, j = this.f; i <= j; i++)
/*     */     {
/* 159 */       this.g[i] = writableRaster2.getPixel(i, 0, arrayOfInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 169 */     if (paramArrayOffloat.length > 1)
/*     */     {
/* 171 */       throw new IllegalArgumentException("Indexed color spaces must have one color value");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     int i = Math.min(i = Math.max(i = Math.round(paramArrayOffloat[0]), 0), this.f);
/*     */ 
/*     */     
/* 180 */     int[] arrayOfInt = this.g[i];
/* 181 */     return new float[] { arrayOfInt[0] / 255.0F, arrayOfInt[1] / 255.0F, arrayOfInt[2] / 255.0F };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 191 */     int i = paramWritableRaster.getWidth();
/* 192 */     int j = paramWritableRaster.getHeight();
/*     */     
/*     */     BufferedImage bufferedImage;
/* 195 */     WritableRaster writableRaster = (bufferedImage = new BufferedImage(i, j, 1)).getRaster();
/*     */     
/* 197 */     int[] arrayOfInt = new int[1];
/* 198 */     for (byte b = 0; b < j; b++) {
/*     */       
/* 200 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         
/* 202 */         paramWritableRaster.getPixel(b1, b, arrayOfInt);
/*     */ 
/*     */         
/* 205 */         int k = Math.min(arrayOfInt[0], this.f);
/* 206 */         writableRaster.setPixel(b1, b, this.g[k]);
/*     */       } 
/*     */     } 
/*     */     
/* 210 */     return bufferedImage;
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
/*     */   private int e() {
/* 225 */     return ((l)this.e.a(2)).c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] g() {
/* 231 */     if (this.c == null) {
/*     */       b b;
/*     */       
/* 234 */       if (b = this.e.a(3) instanceof s) {
/*     */         
/* 236 */         this.c = ((s)b).c();
/*     */       }
/* 238 */       else if (b instanceof org.a.c.b.p) {
/*     */         
/* 240 */         this.c = (new i((org.a.c.b.p)b)).g();
/*     */       }
/* 242 */       else if (b == null) {
/*     */         
/* 244 */         this.c = new byte[0];
/*     */       }
/*     */       else {
/*     */         
/* 248 */         throw new IOException("Error: Unknown type for lookup table " + b);
/*     */       } 
/*     */     } 
/* 251 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void h() {
/* 259 */     byte[] arrayOfByte = g();
/* 260 */     int i = Math.min(e(), 255);
/* 261 */     int j = this.b.b();
/*     */ 
/*     */     
/* 264 */     if (arrayOfByte.length / j < i + 1)
/*     */     {
/* 266 */       i = arrayOfByte.length / j - 1;
/*     */     }
/* 268 */     this.f = i;
/*     */     
/* 270 */     this.d = new float[i + 1][j];
/* 271 */     for (byte b1 = 0, b2 = 0; b1 <= i; b1++) {
/*     */       
/* 273 */       for (byte b = 0; b < j; b++) {
/*     */         
/* 275 */         this.d[b1][b] = (arrayOfByte[b2] & 0xFF) / 255.0F;
/* 276 */         b2++;
/*     */       } 
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
/*     */   
/*     */   public final String toString() {
/* 303 */     return "Indexed{base:" + this.b + " hival:" + 
/* 304 */       e() + " lookup:(" + this.d.length + " entries)}";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */