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
/*    */ public class KHRParallelShaderCompile
/*    */ {
/*    */   public static final int GL_MAX_SHADER_COMPILER_THREADS_KHR = 37296;
/*    */   public static final int GL_COMPLETION_STATUS_KHR = 37297;
/*    */   
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glMaxShaderCompilerThreadsKHR(@NativeType("GLuint") int paramInt);
/*    */ 
/*    */   
/*    */   protected KHRParallelShaderCompile() {
/* 28 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\KHRParallelShaderCompile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */