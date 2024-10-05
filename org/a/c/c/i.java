/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.awt.image.Raster;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReadParam;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.metadata.IIOMetadata;
/*     */ import javax.imageio.metadata.IIOMetadataNode;
/*     */ import javax.imageio.stream.ImageInputStream;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.d;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.NodeList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class i
/*     */   extends l
/*     */ {
/*     */   static {
/*  49 */     c.a(i.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt, j paramj) {
/*  58 */     ImageReader imageReader = a("JPEG", "a suitable JAI I/O image filter is not installed");
/*  59 */     ImageInputStream imageInputStream = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/*  65 */       if ((imageInputStream = ImageIO.createImageInputStream(paramInputStream)).read() != 10)
/*     */       {
/*  67 */         imageInputStream.seek(0L);
/*     */       }
/*     */       
/*  70 */       imageReader.setInput(imageInputStream);
/*     */       ImageReadParam imageReadParam;
/*  72 */       (imageReadParam = imageReader.getDefaultReadParam()).setSourceSubsampling(paramj.b(), paramj.c(), paramj
/*  73 */           .d(), paramj.e());
/*  74 */       imageReadParam.setSourceRegion(paramj.a());
/*     */ 
/*     */       
/*  77 */       String str = a(imageReader);
/*     */ 
/*     */       
/*  80 */       ImageIO.setUseCache(false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     finally {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 156 */       if (imageInputStream != null)
/*     */       {
/* 158 */         imageInputStream.close();
/*     */       }
/* 160 */       imageReader.dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/* 169 */     return a(paramInputStream, paramOutputStream, paramd, paramInt, j.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Integer a(IIOMetadata paramIIOMetadata) {
/*     */     NodeList nodeList;
/*     */     Element element;
/* 178 */     if ((nodeList = (element = (Element)(element = (Element)paramIIOMetadata.getAsTree("javax_imageio_jpeg_image_1.0")).getElementsByTagName("markerSequence").item(0)).getElementsByTagName("app14Adobe")) != null && nodeList.getLength() > 0) {
/*     */       Element element1;
/*     */       
/* 181 */       return Integer.valueOf(Integer.parseInt((element1 = (Element)nodeList.item(0)).getAttribute("transform")));
/*     */     } 
/* 183 */     return Integer.valueOf(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(ImageInputStream paramImageInputStream) {
/* 190 */     byte b = 0;
/* 191 */     paramImageInputStream.seek(0L);
/*     */     int j;
/* 193 */     while ((j = paramImageInputStream.read()) != -1) {
/*     */       
/* 195 */       if ("Adobe".charAt(b) == j) {
/*     */         
/* 197 */         b++;
/* 198 */         if (b == 5) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 203 */           b = 0;
/* 204 */           long l1 = paramImageInputStream.getStreamPosition();
/* 205 */           paramImageInputStream.seek(paramImageInputStream.getStreamPosition() - 9L);
/*     */           
/* 207 */           if ((j = paramImageInputStream.readUnsignedShort()) != 65518) {
/*     */             
/* 209 */             paramImageInputStream.seek(l1);
/*     */             
/*     */             continue;
/*     */           } 
/* 213 */           if ((j = paramImageInputStream.readUnsignedShort()) >= 12) {
/*     */             
/* 215 */             byte[] arrayOfByte = new byte[Math.max(j, 12)];
/* 216 */             if (paramImageInputStream.read(arrayOfByte) >= 12)
/*     */             {
/* 218 */               return arrayOfByte[11];
/*     */             }
/*     */           } 
/*     */         } 
/*     */         continue;
/*     */       } 
/* 224 */       b = 0;
/*     */     } 
/*     */     
/* 227 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private WritableRaster a(Raster paramRaster) {
/* 235 */     WritableRaster writableRaster = paramRaster.createCompatibleWritableRaster();
/*     */     
/* 237 */     int[] arrayOfInt = new int[4]; byte b; int j;
/* 238 */     for (b = 0, j = paramRaster.getHeight(); b < j; b++) {
/*     */       byte b1; int k;
/* 240 */       for (b1 = 0, k = paramRaster.getWidth(); b1 < k; b1++) {
/*     */         
/* 242 */         paramRaster.getPixel(b1, b, arrayOfInt);
/*     */ 
/*     */         
/* 245 */         float f1 = arrayOfInt[0];
/* 246 */         float f2 = arrayOfInt[1];
/* 247 */         float f3 = arrayOfInt[2];
/* 248 */         float f4 = arrayOfInt[3];
/*     */ 
/*     */         
/* 251 */         int i2 = a(f1 + 1.402F * f3 - 179.456F);
/* 252 */         int i1 = a(f1 - 0.34414F * f2 - 0.71414F * f3 + 135.45984F);
/* 253 */         int m = a(f1 + 1.772F * f2 - 226.816F);
/*     */ 
/*     */         
/* 256 */         int n = 255 - i2;
/* 257 */         i1 = 255 - i1;
/* 258 */         m = 255 - m;
/*     */ 
/*     */         
/* 261 */         arrayOfInt[0] = n;
/* 262 */         arrayOfInt[1] = i1;
/* 263 */         arrayOfInt[2] = m;
/* 264 */         arrayOfInt[3] = (int)f4;
/* 265 */         writableRaster.setPixel(b1, b, arrayOfInt);
/*     */       } 
/*     */     } 
/* 268 */     return writableRaster;
/*     */   }
/*     */ 
/*     */   
/*     */   private WritableRaster b(Raster paramRaster) {
/* 273 */     WritableRaster writableRaster = paramRaster.createCompatibleWritableRaster();
/*     */     
/* 275 */     int[] arrayOfInt = new int[4]; byte b; int j;
/* 276 */     for (b = 0, j = paramRaster.getHeight(); b < j; b++) {
/*     */       byte b1; int k;
/* 278 */       for (b1 = 0, k = paramRaster.getWidth(); b1 < k; b1++) {
/*     */         
/* 280 */         paramRaster.getPixel(b1, b, arrayOfInt);
/*     */ 
/*     */         
/* 283 */         float f1 = arrayOfInt[0];
/* 284 */         float f2 = arrayOfInt[1];
/* 285 */         float f3 = arrayOfInt[2];
/* 286 */         float f4 = arrayOfInt[3];
/*     */ 
/*     */         
/* 289 */         int i2 = a(1.164F * (f1 - 16.0F) + 1.596F * (f3 - 128.0F));
/* 290 */         int i1 = a(1.164F * (f1 - 16.0F) + -0.392F * (f2 - 128.0F) + -0.813F * (f3 - 128.0F));
/* 291 */         int m = a(1.164F * (f1 - 16.0F) + 2.017F * (f2 - 128.0F));
/*     */ 
/*     */         
/* 294 */         int n = 255 - i2;
/* 295 */         i1 = 255 - i1;
/* 296 */         m = 255 - m;
/*     */ 
/*     */         
/* 299 */         arrayOfInt[0] = n;
/* 300 */         arrayOfInt[1] = i1;
/* 301 */         arrayOfInt[2] = m;
/* 302 */         arrayOfInt[3] = (int)f4;
/* 303 */         writableRaster.setPixel(b1, b, arrayOfInt);
/*     */       } 
/*     */     } 
/* 306 */     return writableRaster;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static WritableRaster c(Raster paramRaster) {
/* 312 */     WritableRaster writableRaster = paramRaster.createCompatibleWritableRaster();
/*     */     
/* 314 */     int j = paramRaster.getWidth();
/* 315 */     int k = paramRaster.getHeight();
/*     */     
/* 317 */     int m, arrayOfInt[] = new int[m = j * 3];
/*     */     
/* 319 */     for (byte b = 0; b < k; b++) {
/*     */       
/* 321 */       paramRaster.getPixels(0, b, j, 1, arrayOfInt);
/* 322 */       for (byte b1 = 0; b1 < m; b1 += 3) {
/*     */         
/* 324 */         int n = arrayOfInt[b1];
/* 325 */         arrayOfInt[b1] = arrayOfInt[b1 + 2];
/* 326 */         arrayOfInt[b1 + 2] = n;
/*     */       } 
/* 328 */       writableRaster.setPixels(0, b, j, 1, arrayOfInt);
/*     */     } 
/* 330 */     return writableRaster;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String a(ImageReader paramImageReader) {
/*     */     try {
/*     */       IIOMetadata iIOMetadata;
/* 339 */       if ((iIOMetadata = paramImageReader.getImageMetadata(0)) == null)
/*     */       {
/* 341 */         return "";
/*     */       }
/*     */       IIOMetadataNode iIOMetadataNode;
/*     */       Element element;
/* 345 */       if ((element = (Element)(iIOMetadataNode = (IIOMetadataNode)iIOMetadata.getAsTree("javax_imageio_1.0")).getElementsByTagName("NumChannels").item(0)) == null)
/*     */       {
/* 347 */         return "";
/*     */       }
/* 349 */       return element.getAttribute("value");
/*     */     }
/* 351 */     catch (IOException iOException) {
/*     */       
/* 353 */       return "";
/*     */     }
/* 355 */     catch (NegativeArraySizeException negativeArraySizeException) {
/*     */       
/* 357 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(float paramFloat) {
/* 364 */     return (int)((paramFloat < 0.0F) ? 0.0F : ((paramFloat > 255.0F) ? 255.0F : paramFloat));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 371 */     throw new UnsupportedOperationException("DCTFilter encoding not implemented, use the JPEGFactory methods instead");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */