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
/*    */ public class EXTStencilTwoSide
/*    */ {
/*    */   public static final int GL_STENCIL_TEST_TWO_SIDE_EXT = 35088;
/*    */   public static final int GL_ACTIVE_STENCIL_FACE_EXT = 35089;
/*    */   
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glActiveStencilFaceEXT(@NativeType("GLenum") int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTStencilTwoSide() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTStencilTwoSide.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */