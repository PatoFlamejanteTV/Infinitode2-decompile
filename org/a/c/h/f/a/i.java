/*    */ package org.a.c.h.f.a;
/*    */ 
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.awt.image.WritableRaster;
/*    */ import org.a.c.b.j;
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
/*    */ public final class i
/*    */   extends h
/*    */ {
/* 34 */   public static final i a = new i();
/*    */   
/* 36 */   private final e b = new e(new float[] { 0.0F }, this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String a() {
/* 45 */     return j.aB.a();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final int b() {
/* 51 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final e c() {
/* 63 */     return this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final float[] a(float[] paramArrayOffloat) {
/* 69 */     return new float[] { paramArrayOffloat[0], paramArrayOffloat[0], paramArrayOffloat[0] };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 75 */     int j = paramWritableRaster.getWidth();
/* 76 */     int k = paramWritableRaster.getHeight();
/*    */     
/* 78 */     BufferedImage bufferedImage = new BufferedImage(j, k, 1);
/*    */     
/* 80 */     int[] arrayOfInt1 = new int[1];
/* 81 */     int[] arrayOfInt2 = new int[3];
/* 82 */     for (byte b = 0; b < k; b++) {
/*    */       
/* 84 */       for (byte b1 = 0; b1 < j; b1++) {
/*    */         
/* 86 */         paramWritableRaster.getPixel(b1, b, arrayOfInt1);
/* 87 */         arrayOfInt2[0] = arrayOfInt1[0];
/* 88 */         arrayOfInt2[1] = arrayOfInt1[0];
/* 89 */         arrayOfInt2[2] = arrayOfInt1[0];
/* 90 */         bufferedImage.getRaster().setPixel(b1, b, arrayOfInt2);
/*    */       } 
/*    */     } 
/*    */     
/* 94 */     return bufferedImage;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */