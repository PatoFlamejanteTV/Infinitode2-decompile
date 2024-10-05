/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.awt.color.ColorSpace;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DataBufferByte;
/*     */ import java.awt.image.DataBufferUShort;
/*     */ import java.awt.image.WritableRaster;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import javax.imageio.ImageReadParam;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.stream.MemoryCacheImageInputStream;
/*     */ import org.a.c.b.d;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */   extends l
/*     */ {
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt, j paramj) {
/*     */     DataBufferByte dataBufferByte;
/*     */     DataBufferUShort dataBufferUShort;
/*     */     short[] arrayOfShort;
/*     */     int arrayOfInt[], i;
/*     */     byte b;
/*     */     k k;
/*  63 */     (k = new k(new d())).a().a(paramd);
/*     */     
/*     */     BufferedImage bufferedImage;
/*     */     WritableRaster writableRaster;
/*  67 */     switch ((writableRaster = (bufferedImage = a(paramInputStream, paramj, k)).getRaster()).getDataBuffer().getDataType()) {
/*     */       
/*     */       case 0:
/*  70 */         dataBufferByte = (DataBufferByte)writableRaster.getDataBuffer();
/*  71 */         paramOutputStream.write(dataBufferByte.getData());
/*  72 */         return k;
/*     */ 
/*     */       
/*     */       case 1:
/*  76 */         for (i = (arrayOfShort = (dataBufferUShort = (DataBufferUShort)writableRaster.getDataBuffer()).getData()).length, b = 0; b < i; ) { short s = arrayOfShort[b];
/*     */           
/*  78 */           paramOutputStream.write(s >> 8);
/*  79 */           paramOutputStream.write(s); b++; }
/*     */         
/*  81 */         return k;
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/*  86 */         arrayOfInt = new int[writableRaster.getNumBands()];
/*  87 */         for (i = 0; i < dataBufferUShort.getHeight(); i++) {
/*     */           
/*  89 */           for (b = 0; b < dataBufferUShort.getWidth(); b++) {
/*     */             
/*  91 */             writableRaster.getPixel(b, i, arrayOfInt);
/*  92 */             for (byte b1 = 0; b1 < arrayOfInt.length; b1++)
/*     */             {
/*  94 */               paramOutputStream.write(arrayOfInt[b1]);
/*     */             }
/*     */           } 
/*     */         } 
/*  98 */         return k;
/*     */     } 
/*     */     
/* 101 */     throw new IOException("Data type " + writableRaster.getDataBuffer().getDataType() + " not implemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/* 109 */     return a(paramInputStream, paramOutputStream, paramd, paramInt, j.a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static BufferedImage a(InputStream paramInputStream, j paramj, k paramk) {
/* 115 */     ImageReader imageReader = a("JPEG2000", "Java Advanced Imaging (JAI) Image I/O Tools are not installed");
/* 116 */     MemoryCacheImageInputStream memoryCacheImageInputStream = null;
/*     */ 
/*     */     
/*     */     try {
/* 120 */       memoryCacheImageInputStream = new MemoryCacheImageInputStream(paramInputStream);
/*     */       
/* 122 */       imageReader.setInput(memoryCacheImageInputStream, true, true);
/*     */       ImageReadParam imageReadParam;
/* 124 */       (imageReadParam = imageReader.getDefaultReadParam()).setSourceRegion(paramj.a());
/* 125 */       imageReadParam.setSourceSubsampling(paramj.b(), paramj.c(), paramj
/* 126 */           .d(), paramj.e());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 132 */         bufferedImage = imageReader.read(0, imageReadParam);
/*     */       }
/* 134 */       catch (Exception exception) {
/*     */ 
/*     */         
/* 137 */         throw new IOException("Could not read JPEG 2000 (JPX) image", exception);
/*     */       } 
/*     */       
/* 140 */       d d = paramk.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 146 */       int i = bufferedImage.getColorModel().getPixelSize() / bufferedImage.getRaster().getNumBands();
/* 147 */       d.a(j.z, i);
/*     */ 
/*     */       
/* 150 */       if (!d.b(j.bF, false))
/*     */       {
/* 152 */         d.a(j.aq, null);
/*     */       }
/*     */ 
/*     */       
/* 156 */       d.a(j.ea, imageReader.getWidth(0));
/* 157 */       d.a(j.bx, imageReader.getHeight(0));
/*     */ 
/*     */       
/* 160 */       if (!d.o(j.ac))
/*     */       {
/* 162 */         if (bufferedImage.getSampleModel() instanceof java.awt.image.MultiPixelPackedSampleModel && bufferedImage
/* 163 */           .getColorModel().getPixelSize() == 1 && bufferedImage
/* 164 */           .getRaster().getNumBands() == 1 && bufferedImage
/* 165 */           .getColorModel() instanceof java.awt.image.IndexColorModel) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 171 */           paramk.a(new org.a.c.h.f.a.q(ColorSpace.getInstance(1003)));
/*     */         }
/*     */         else {
/*     */           
/* 175 */           paramk.a(new org.a.c.h.f.a.q(bufferedImage.getColorModel().getColorSpace()));
/*     */         } 
/*     */       }
/*     */       
/* 179 */       BufferedImage bufferedImage = bufferedImage; return bufferedImage;
/*     */     }
/*     */     finally {
/*     */       
/* 183 */       if (memoryCacheImageInputStream != null)
/*     */       {
/* 185 */         memoryCacheImageInputStream.close();
/*     */       }
/* 187 */       imageReader.dispose();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 198 */     throw new UnsupportedOperationException("JPX encoding not implemented");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */