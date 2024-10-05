/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryStack;
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
/*    */ public class EXTDebugLabel
/*    */ {
/*    */   public static final int GL_BUFFER_OBJECT_EXT = 37201;
/*    */   public static final int GL_SHADER_OBJECT_EXT = 35656;
/*    */   public static final int GL_PROGRAM_OBJECT_EXT = 35648;
/*    */   public static final int GL_VERTEX_ARRAY_OBJECT_EXT = 37204;
/*    */   public static final int GL_QUERY_OBJECT_EXT = 37203;
/*    */   public static final int GL_PROGRAM_PIPELINE_OBJECT_EXT = 35407;
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
/*    */   protected EXTDebugLabel() {
/* 43 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glLabelObjectEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 51 */     nglLabelObjectEXT(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   public static void glLabelObjectEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 55 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 57 */       int j = memoryStack.nUTF8(paramCharSequence, false);
/* 58 */       long l = memoryStack.getPointerAddress();
/* 59 */       nglLabelObjectEXT(paramInt1, paramInt2, j, l); return;
/*    */     } finally {
/* 61 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glGetObjectLabelEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") IntBuffer paramIntBuffer, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 70 */     if (Checks.CHECKS) {
/* 71 */       Checks.check(paramIntBuffer, 1);
/*    */     }
/* 73 */     nglGetObjectLabelEXT(paramInt1, paramInt2, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   @NativeType("void")
/*    */   public static String glGetObjectLabelEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/*    */     MemoryStack memoryStack;
/* 78 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 80 */       IntBuffer intBuffer = memoryStack.ints(0);
/* 81 */       ByteBuffer byteBuffer = memoryStack.malloc(paramInt3);
/* 82 */       nglGetObjectLabelEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(byteBuffer));
/* 83 */       return MemoryUtil.memUTF8(byteBuffer, intBuffer.get(0));
/*    */     } finally {
/* 85 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetObjectLabelEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei *") int[] paramArrayOfint, @NativeType("GLchar *") ByteBuffer paramByteBuffer) {
/* 91 */     long l = (GL.getICD()).glGetObjectLabelEXT;
/* 92 */     if (Checks.CHECKS) {
/* 93 */       Checks.check(l);
/* 94 */       Checks.check(paramArrayOfint, 1);
/*    */     } 
/* 96 */     JNI.callPPV(paramInt1, paramInt2, paramByteBuffer.remaining(), paramArrayOfint, MemoryUtil.memAddress(paramByteBuffer), l);
/*    */   }
/*    */   
/*    */   public static native void nglLabelObjectEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*    */   
/*    */   public static native void nglGetObjectLabelEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTDebugLabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */