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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NVClipSpaceWScaling
/*    */ {
/*    */   public static final int GL_VIEWPORT_POSITION_W_SCALE_NV = 37756;
/*    */   public static final int GL_VIEWPORT_POSITION_W_SCALE_X_COEFF = 37757;
/*    */   public static final int GL_VIEWPORT_POSITION_W_SCALE_Y_COEFF = 37758;
/*    */   
/*    */   static {
/* 32 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glViewportPositionWScaleNV(@NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2);
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVClipSpaceWScaling() {
/* 43 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVClipSpaceWScaling.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */