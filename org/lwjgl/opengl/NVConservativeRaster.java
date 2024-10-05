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
/*    */ public class NVConservativeRaster
/*    */ {
/*    */   public static final int GL_CONSERVATIVE_RASTERIZATION_NV = 37702;
/*    */   public static final int GL_SUBPIXEL_PRECISION_BIAS_X_BITS_NV = 37703;
/*    */   public static final int GL_SUBPIXEL_PRECISION_BIAS_Y_BITS_NV = 37704;
/*    */   public static final int GL_MAX_SUBPIXEL_PRECISION_BIAS_BITS_NV = 37705;
/*    */   
/*    */   static {
/* 25 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glSubpixelPrecisionBiasNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVConservativeRaster() {
/* 37 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVConservativeRaster.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */