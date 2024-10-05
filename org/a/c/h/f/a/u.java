/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.Point;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.k;
/*     */ import org.a.c.h.a.b.a;
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
/*     */ public final class u
/*     */   extends v
/*     */ {
/*  45 */   private final e a = new e(new float[] { 1.0F }, this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   private f b = null;
/*  54 */   private a c = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private Map<Integer, float[]> d = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u() {
/*  69 */     this.e = new a();
/*  70 */     this.e.a((b)j.dp);
/*  71 */     this.e.a((b)j.a(""));
/*     */     
/*  73 */     this.e.a((b)k.a);
/*  74 */     this.e.a((b)k.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public u(a parama) {
/*  84 */     this.e = parama;
/*  85 */     this.b = f.a(this.e.a(2));
/*  86 */     this.c = a.a(this.e.a(3));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/*  92 */     return j.dp.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/*  98 */     return 1;
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
/* 110 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 116 */     if (this.d == null)
/*     */     {
/* 118 */       this.d = (Map)new HashMap<Integer, float>();
/*     */     }
/* 120 */     int i = (int)(paramArrayOffloat[0] * 255.0F);
/*     */     float[] arrayOfFloat;
/* 122 */     if ((arrayOfFloat = this.d.get(Integer.valueOf(i))) != null)
/*     */     {
/* 124 */       return arrayOfFloat;
/*     */     }
/* 126 */     paramArrayOffloat = this.c.a(paramArrayOffloat);
/* 127 */     arrayOfFloat = this.b.a(paramArrayOffloat);
/* 128 */     this.d.put(Integer.valueOf(i), arrayOfFloat);
/* 129 */     return arrayOfFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 138 */     if (this.b instanceof r)
/*     */     {
/*     */       
/* 141 */       return b(paramWritableRaster);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 146 */     WritableRaster writableRaster = Raster.createBandedRaster(0, paramWritableRaster
/* 147 */         .getWidth(), paramWritableRaster.getHeight(), this.b
/* 148 */         .b(), new Point(0, 0));
/*     */ 
/*     */     
/* 151 */     int i = this.b.b();
/* 152 */     int j = paramWritableRaster.getWidth();
/* 153 */     int k = paramWritableRaster.getHeight();
/* 154 */     float[] arrayOfFloat = new float[1];
/*     */     
/* 156 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 158 */     for (byte b = 0; b < k; b++) {
/*     */       
/* 160 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 162 */         paramWritableRaster.getPixel(b1, b, arrayOfFloat); Integer integer;
/*     */         int[] arrayOfInt;
/* 164 */         if ((arrayOfInt = (int[])hashMap.get(integer = Integer.valueOf(Float.floatToIntBits(arrayOfFloat[0])))) == null) {
/*     */           
/* 166 */           arrayOfInt = new int[i];
/* 167 */           a(arrayOfFloat, arrayOfInt);
/* 168 */           hashMap.put(integer, arrayOfInt);
/*     */         } 
/* 170 */         writableRaster.setPixel(b1, b, arrayOfInt);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 175 */     return this.b.a(writableRaster);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BufferedImage b(WritableRaster paramWritableRaster) {
/* 181 */     int i = paramWritableRaster.getWidth();
/* 182 */     int j = paramWritableRaster.getHeight();
/*     */     BufferedImage bufferedImage;
/* 184 */     WritableRaster writableRaster = (bufferedImage = new BufferedImage(i, j, 1)).getRaster();
/* 185 */     float[] arrayOfFloat = new float[1];
/*     */     
/* 187 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/*     */     
/* 189 */     for (byte b = 0; b < j; b++) {
/*     */       
/* 191 */       for (byte b1 = 0; b1 < i; b1++) {
/*     */         
/* 193 */         paramWritableRaster.getPixel(b1, b, arrayOfFloat); Integer integer;
/*     */         int[] arrayOfInt;
/* 195 */         if ((arrayOfInt = (int[])hashMap.get(integer = Integer.valueOf(Float.floatToIntBits(arrayOfFloat[0])))) == null) {
/*     */           
/* 197 */           arrayOfFloat[0] = arrayOfFloat[0] / 255.0F;
/* 198 */           float[] arrayOfFloat1 = this.c.a(arrayOfFloat);
/* 199 */           float[] arrayOfFloat2 = this.b.a(arrayOfFloat1);
/*     */           
/* 201 */           (arrayOfInt = new int[3])[0] = (int)(arrayOfFloat2[0] * 255.0F);
/* 202 */           arrayOfInt[1] = (int)(arrayOfFloat2[1] * 255.0F);
/* 203 */           arrayOfInt[2] = (int)(arrayOfFloat2[2] * 255.0F);
/* 204 */           hashMap.put(integer, arrayOfInt);
/*     */         } 
/* 206 */         writableRaster.setPixel(b1, b, arrayOfInt);
/*     */       } 
/*     */     } 
/* 209 */     return bufferedImage;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(float[] paramArrayOffloat, int[] paramArrayOfint) {
/* 214 */     paramArrayOffloat[0] = paramArrayOffloat[0] / 255.0F;
/* 215 */     paramArrayOffloat = this.c.a(paramArrayOffloat);
/* 216 */     for (byte b = 0; b < paramArrayOfint.length; b++)
/*     */     {
/*     */       
/* 219 */       paramArrayOfint[b] = (int)(paramArrayOffloat[b] * 255.0F);
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
/*     */   private String d() {
/*     */     j j;
/* 239 */     return (j = (j)this.e.a(1)).a();
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
/*     */   public final String toString() {
/* 279 */     return a() + "{\"" + 
/* 280 */       d() + "\" " + this.b
/* 281 */       .a() + " " + this.c + "}";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */