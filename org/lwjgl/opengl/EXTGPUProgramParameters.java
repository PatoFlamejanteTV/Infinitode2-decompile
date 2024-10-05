/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public class EXTGPUProgramParameters
/*    */ {
/*    */   static {
/* 28 */     GL.initialize();
/*    */   }
/*    */   protected EXTGPUProgramParameters() {
/* 31 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProgramEnvParameters4fvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 39 */     nglProgramEnvParameters4fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glProgramLocalParameters4fvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") FloatBuffer paramFloatBuffer) {
/* 47 */     nglProgramLocalParameters4fvEXT(paramInt1, paramInt2, paramFloatBuffer.remaining() >> 2, MemoryUtil.memAddress(paramFloatBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glProgramEnvParameters4fvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 52 */     long l = (GL.getICD()).glProgramEnvParameters4fvEXT;
/* 53 */     if (Checks.CHECKS) {
/* 54 */       Checks.check(l);
/*    */     }
/* 56 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glProgramLocalParameters4fvEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat const *") float[] paramArrayOffloat) {
/* 61 */     long l = (GL.getICD()).glProgramLocalParameters4fvEXT;
/* 62 */     if (Checks.CHECKS) {
/* 63 */       Checks.check(l);
/*    */     }
/* 65 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat.length >> 2, paramArrayOffloat, l);
/*    */   }
/*    */   
/*    */   public static native void nglProgramEnvParameters4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void nglProgramLocalParameters4fvEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTGPUProgramParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */