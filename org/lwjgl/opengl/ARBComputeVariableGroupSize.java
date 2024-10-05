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
/*    */ public class ARBComputeVariableGroupSize
/*    */ {
/*    */   public static final int GL_MAX_COMPUTE_VARIABLE_GROUP_INVOCATIONS_ARB = 37700;
/*    */   public static final int GL_MAX_COMPUTE_FIXED_GROUP_INVOCATIONS_ARB = 37099;
/*    */   public static final int GL_MAX_COMPUTE_VARIABLE_GROUP_SIZE_ARB = 37701;
/*    */   public static final int GL_MAX_COMPUTE_FIXED_GROUP_SIZE_ARB = 37311;
/*    */   
/*    */   static {
/* 26 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glDispatchComputeGroupSizeARB(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBComputeVariableGroupSize() {
/* 39 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBComputeVariableGroupSize.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */