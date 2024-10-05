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
/*    */ public class AMDStencilOperationExtended
/*    */ {
/*    */   public static final int GL_SET_AMD = 34634;
/*    */   public static final int GL_REPLACE_VALUE_AMD = 34635;
/*    */   public static final int GL_STENCIL_OP_VALUE_AMD = 34636;
/*    */   public static final int GL_STENCIL_BACK_OP_VALUE_AMD = 34637;
/*    */   
/*    */   static {
/* 24 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glStencilOpValueAMD(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected AMDStencilOperationExtended() {
/* 37 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDStencilOperationExtended.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */