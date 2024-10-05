/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
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
/*    */ public class NVScissorExclusive
/*    */ {
/*    */   public static final int GL_SCISSOR_TEST_EXCLUSIVE_NV = 38229;
/*    */   public static final int GL_SCISSOR_BOX_EXCLUSIVE_NV = 38230;
/*    */   
/*    */   static {
/* 31 */     GL.initialize();
/*    */   }
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
/*    */   protected NVScissorExclusive() {
/* 49 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glScissorExclusiveArrayvNV(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 57 */     nglScissorExclusiveArrayvNV(paramInt, paramIntBuffer.remaining() >> 2, MemoryUtil.memAddress(paramIntBuffer));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glScissorExclusiveArrayvNV(@NativeType("GLuint") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 66 */     long l = (GL.getICD()).glScissorExclusiveArrayvNV;
/* 67 */     if (Checks.CHECKS) {
/* 68 */       Checks.check(l);
/*    */     }
/* 70 */     JNI.callPV(paramInt, paramArrayOfint.length >> 2, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void nglScissorExclusiveArrayvNV(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void glScissorExclusiveNV(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVScissorExclusive.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */