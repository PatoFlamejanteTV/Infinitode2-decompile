/*     */ package org.a.c.c;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.awt.image.DataBuffer;
/*     */ import java.awt.image.DataBufferByte;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.SequenceInputStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.ImageReadParam;
/*     */ import javax.imageio.ImageReader;
/*     */ import javax.imageio.stream.ImageInputStream;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
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
/*     */ final class p
/*     */   extends l
/*     */ {
/*  48 */   private static final a a = c.a(p.class);
/*     */   
/*     */   private static boolean b = false;
/*     */ 
/*     */   
/*     */   private static synchronized void b() {
/*  54 */     if (!b)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/*  59 */       b = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt, j paramj) {
/*     */     ImageInputStream imageInputStream;
/*     */     org.a.c.b.p p1;
/*     */     ImageReader imageReader;
/*  68 */     if ((imageReader = a("JBIG2", "jbig2-imageio is not installed")).getClass().getName().contains("levigo"))
/*     */     {
/*  70 */       b();
/*     */     }
/*     */     
/*  73 */     int i = paramd.b(j.z, 1);
/*  74 */     d d1 = a(paramd, paramInt);
/*     */     
/*     */     ImageReadParam imageReadParam;
/*  77 */     (imageReadParam = imageReader.getDefaultReadParam()).setSourceSubsampling(paramj.b(), paramj.c(), paramj
/*  78 */         .d(), paramj.e());
/*  79 */     imageReadParam.setSourceRegion(paramj.a());
/*     */ 
/*     */     
/*  82 */     paramj = null;
/*  83 */     if (d1 != null)
/*     */     {
/*  85 */       p1 = (org.a.c.b.p)d1.a(j.bM);
/*     */     }
/*     */     
/*  88 */     d1 = null;
/*     */     try {
/*     */       BufferedImage bufferedImage;
/*  91 */       if (p1 != null) {
/*     */         
/*  93 */         imageInputStream = ImageIO.createImageInputStream(new SequenceInputStream((InputStream)p1
/*  94 */               .k(), paramInputStream));
/*  95 */         imageReader.setInput(imageInputStream);
/*     */       }
/*     */       else {
/*     */         
/*  99 */         imageInputStream = ImageIO.createImageInputStream(paramInputStream);
/* 100 */         imageReader.setInput(imageInputStream);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 106 */         bufferedImage = imageReader.read(0, imageReadParam);
/*     */       }
/* 108 */       catch (Exception exception) {
/*     */ 
/*     */         
/* 111 */         throw new IOException("Could not read JBIG2 image", exception);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 116 */       if (bufferedImage.getColorModel().getPixelSize() != i) {
/*     */         BufferedImage bufferedImage1;
/*     */ 
/*     */ 
/*     */         
/*     */         Graphics graphics;
/*     */ 
/*     */ 
/*     */         
/* 125 */         (graphics = (bufferedImage1 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), 12)).getGraphics()).drawImage(bufferedImage, 0, 0, null);
/* 126 */         graphics.dispose();
/* 127 */         bufferedImage = bufferedImage1;
/*     */       } 
/*     */       
/*     */       DataBuffer dataBuffer;
/* 131 */       if ((dataBuffer = bufferedImage.getData().getDataBuffer()).getDataType() == 0)
/*     */       {
/* 133 */         paramOutputStream.write(((DataBufferByte)dataBuffer).getData());
/*     */       }
/*     */       else
/*     */       {
/* 137 */         throw new IOException("Unexpected image buffer type");
/*     */       }
/*     */     
/*     */     } finally {
/*     */       
/* 142 */       if (imageInputStream != null)
/*     */       {
/* 144 */         imageInputStream.close();
/*     */       }
/* 146 */       imageReader.dispose();
/*     */     } 
/* 148 */     return new k(paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final k a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd, int paramInt) {
/* 155 */     return a(paramInputStream, paramOutputStream, paramd, paramInt, j.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(InputStream paramInputStream, OutputStream paramOutputStream, d paramd) {
/* 162 */     throw new UnsupportedOperationException("JBIG2 encoding not implemented");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */