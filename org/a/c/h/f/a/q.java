/*    */ package org.a.c.h.f.a;
/*    */ 
/*    */ import java.awt.color.ColorSpace;
/*    */ import java.awt.image.BufferedImage;
/*    */ import java.awt.image.WritableRaster;
/*    */ import org.a.c.b.b;
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
/*    */ public final class q
/*    */   extends f
/*    */ {
/*    */   private final ColorSpace a;
/*    */   
/*    */   public q(ColorSpace paramColorSpace) {
/* 42 */     this.a = paramColorSpace;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final String a() {
/* 48 */     return "JPX";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final int b() {
/* 54 */     return this.a.getNumComponents();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final e c() {
/* 73 */     throw new UnsupportedOperationException("JPX color spaces don't support drawing");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final float[] a(float[] paramArrayOffloat) {
/* 79 */     throw new UnsupportedOperationException("JPX color spaces don't support drawing");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final BufferedImage a(WritableRaster paramWritableRaster) {
/* 85 */     return a(paramWritableRaster, this.a);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final b f() {
/* 91 */     throw new UnsupportedOperationException("JPX color spaces don't have COS objects");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\f\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */