/*    */ package org.a.c.h.f.a;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.awt.image.WritableRaster;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class a
/*    */   extends f
/*    */ {
/*    */   public BufferedImage a(WritableRaster paramWritableRaster) {
/* 42 */     int i = paramWritableRaster.getWidth();
/* 43 */     int j = paramWritableRaster.getHeight();
/*    */     
/*    */     BufferedImage bufferedImage;
/* 46 */     WritableRaster writableRaster = (bufferedImage = new BufferedImage(i, j, 1)).getRaster();
/*    */ 
/*    */     
/* 49 */     float[] arrayOfFloat = new float[3];
/* 50 */     for (byte b = 0; b < j; b++) {
/*    */       
/* 52 */       for (byte b1 = 0; b1 < i; b1++) {
/*    */         
/* 54 */         paramWritableRaster.getPixel(b1, b, arrayOfFloat);
/*    */ 
/*    */         
/* 57 */         arrayOfFloat[0] = arrayOfFloat[0] / 255.0F;
/* 58 */         arrayOfFloat[1] = arrayOfFloat[1] / 255.0F;
/* 59 */         arrayOfFloat[2] = arrayOfFloat[2] / 255.0F;
/*    */ 
/*    */         
/*    */         float[] arrayOfFloat1;
/*    */         
/* 64 */         (arrayOfFloat1 = a(arrayOfFloat))[0] = (arrayOfFloat1 = a(arrayOfFloat))[0] * 255.0F;
/* 65 */         arrayOfFloat1[1] = arrayOfFloat1[1] * 255.0F;
/* 66 */         arrayOfFloat1[2] = arrayOfFloat1[2] * 255.0F;
/*    */         
/* 68 */         writableRaster.setPixel(b1, b, arrayOfFloat1);
/*    */       } 
/*    */     } 
/*    */     
/* 72 */     return bufferedImage;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     return a();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */