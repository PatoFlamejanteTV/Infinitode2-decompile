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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVConservativeRasterPreSnapTriangles
/*    */ {
/*    */   public static final int GL_CONSERVATIVE_RASTER_MODE_NV = 38221;
/*    */   public static final int GL_CONSERVATIVE_RASTER_MODE_POST_SNAP_NV = 38222;
/*    */   public static final int GL_CONSERVATIVE_RASTER_MODE_PRE_SNAP_TRIANGLES_NV = 38223;
/*    */   
/*    */   static {
/* 27 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glConservativeRasterParameteriNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVConservativeRasterPreSnapTriangles() {
/* 38 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVConservativeRasterPreSnapTriangles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */