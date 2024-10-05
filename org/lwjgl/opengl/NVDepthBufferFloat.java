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
/*    */ 
/*    */ 
/*    */ public class NVDepthBufferFloat
/*    */ {
/*    */   public static final int GL_DEPTH_COMPONENT32F_NV = 36267;
/*    */   public static final int GL_DEPTH32F_STENCIL8_NV = 36268;
/*    */   public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV_NV = 36269;
/*    */   public static final int GL_DEPTH_BUFFER_FLOAT_MODE_NV = 36271;
/*    */   
/*    */   static {
/* 30 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glDepthBoundsdNV(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glClearDepthdNV(@NativeType("GLdouble") double paramDouble);
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glDepthRangedNV(@NativeType("GLdouble") double paramDouble1, @NativeType("GLdouble") double paramDouble2);
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVDepthBufferFloat() {
/* 50 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVDepthBufferFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */