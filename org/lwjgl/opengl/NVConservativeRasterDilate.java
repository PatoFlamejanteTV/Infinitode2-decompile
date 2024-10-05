/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class NVConservativeRasterDilate
/*    */ {
/*    */   public static final int GL_CONSERVATIVE_RASTER_DILATE_NV = 37753;
/*    */   public static final int GL_CONSERVATIVE_RASTER_DILATE_RANGE_NV = 37754;
/*    */   public static final int GL_CONSERVATIVE_RASTER_DILATE_GRANULARITY_NV = 37755;
/*    */   
/*    */   static {
/* 24 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glConservativeRasterParameterfNV(@NativeType("GLenum") int paramInt, @NativeType("GLfloat") float paramFloat);
/*    */ 
/*    */   
/*    */   protected NVConservativeRasterDilate() {
/* 33 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVConservativeRasterDilate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */