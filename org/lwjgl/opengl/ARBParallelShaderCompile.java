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
/*    */ public class ARBParallelShaderCompile
/*    */ {
/*    */   public static final int GL_MAX_SHADER_COMPILER_THREADS_ARB = 37296;
/*    */   public static final int GL_COMPLETION_STATUS_ARB = 37297;
/*    */   
/*    */   static {
/* 21 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glMaxShaderCompilerThreadsARB(@NativeType("GLuint") int paramInt);
/*    */ 
/*    */   
/*    */   protected ARBParallelShaderCompile() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBParallelShaderCompile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */