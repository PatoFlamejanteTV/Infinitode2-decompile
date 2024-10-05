/*     */ package org.a.c.h.f.a;
/*     */ 
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.color.ICC_ColorSpace;
/*     */ import java.awt.color.ICC_Profile;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Arrays;
/*     */ import org.a.c.b.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   extends h
/*     */ {
/*  45 */   public static g a = new g();
/*     */ 
/*     */   
/*  48 */   private final e b = new e(new float[] { 0.0F, 0.0F, 0.0F, 1.0F }, this);
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile ICC_ColorSpace c;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d() {
/*  62 */     if (this.c != null) {
/*     */       return;
/*     */     }
/*     */     
/*  66 */     synchronized (this) {
/*     */ 
/*     */       
/*  69 */       if (this.c != null) {
/*     */         return;
/*     */       }
/*     */       
/*     */       ICC_Profile iCC_Profile;
/*     */       
/*  75 */       if ((iCC_Profile = e()) == null)
/*     */       {
/*  77 */         throw new IOException("Default CMYK color profile could not be loaded");
/*     */       }
/*  79 */       this.c = new ICC_ColorSpace(iCC_Profile);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  84 */       this.c.toRGB(new float[] { 0.0F, 0.0F, 0.0F, 0.0F });
/*  85 */       this
/*  86 */         .d = (System.getProperty("org.apache.pdfbox.rendering.UsePureJavaCMYKConversion") != null);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ICC_Profile e() {
/*  97 */     String str = "/org/apache/pdfbox/resources/icc/ISOcoated_v2_300_bas.icc";
/*     */     
/*     */     InputStream inputStream;
/* 100 */     if ((inputStream = g.class.getResourceAsStream(str)) == null)
/*     */     {
/* 102 */       throw new IOException("Error loading resource: " + str);
/*     */     }
/* 104 */     ICC_Profile iCC_Profile = ICC_Profile.getInstance(inputStream);
/* 105 */     inputStream.close();
/*     */     
/* 107 */     return iCC_Profile;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 113 */     return j.aA.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int b() {
/* 119 */     return 4;
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
/* 131 */     return this.b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float[] a(float[] paramArrayOffloat) {
/* 137 */     d();
/* 138 */     return this.c.toRGB(paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 144 */     d();
/* 145 */     return a(paramWritableRaster, this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final BufferedImage a(WritableRaster paramWritableRaster, ColorSpace paramColorSpace) {
/* 151 */     if (this.d) {
/*     */       BufferedImage bufferedImage;
/*     */ 
/*     */       
/* 155 */       ColorSpace colorSpace = (bufferedImage = new BufferedImage(paramWritableRaster.getWidth(), paramWritableRaster.getHeight(), 1)).getColorModel().getColorSpace();
/* 156 */       WritableRaster writableRaster = bufferedImage.getRaster();
/* 157 */       float[] arrayOfFloat1 = new float[4];
/* 158 */       float[] arrayOfFloat2 = { -1.0F, -1.0F, -1.0F, -1.0F };
/* 159 */       float[] arrayOfFloat3 = new float[3];
/* 160 */       int i = paramWritableRaster.getWidth();
/* 161 */       int j = paramWritableRaster.getMinX();
/* 162 */       int k = paramWritableRaster.getHeight();
/* 163 */       int m = paramWritableRaster.getMinY();
/* 164 */       for (int n = j; n < i + j; n++) {
/*     */         
/* 166 */         for (int i1 = m; i1 < k + m; i1++) {
/*     */           
/* 168 */           paramWritableRaster.getPixel(n, i1, arrayOfFloat1);
/*     */           
/* 170 */           if (!Arrays.equals(arrayOfFloat2, arrayOfFloat1)) {
/*     */             byte b;
/* 172 */             for (b = 0; b < 4; b++) {
/*     */               
/* 174 */               arrayOfFloat2[b] = arrayOfFloat1[b];
/* 175 */               arrayOfFloat1[b] = arrayOfFloat1[b] / 255.0F;
/*     */             } 
/*     */             
/* 178 */             arrayOfFloat3 = colorSpace.fromCIEXYZ(paramColorSpace.toCIEXYZ(arrayOfFloat1));
/* 179 */             for (b = 0; b < arrayOfFloat3.length; b++)
/*     */             {
/* 181 */               arrayOfFloat3[b] = arrayOfFloat3[b] * 255.0F;
/*     */             }
/*     */           } 
/* 184 */           writableRaster.setPixel(n, i1, arrayOfFloat3);
/*     */         } 
/*     */       } 
/* 187 */       return bufferedImage;
/*     */     } 
/*     */ 
/*     */     
/* 191 */     return super.a(paramWritableRaster, paramColorSpace);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */