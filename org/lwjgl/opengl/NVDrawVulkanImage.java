/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import org.lwjgl.system.Checks;
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
/*    */ public class NVDrawVulkanImage
/*    */ {
/*    */   static {
/* 36 */     GL.initialize();
/*    */   }
/*    */   protected NVDrawVulkanImage() {
/* 39 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("VULKANPROCNV")
/*    */   public static long glGetVkProcAddrNV(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 73 */     if (Checks.CHECKS) {
/* 74 */       Checks.checkNT1(paramByteBuffer);
/*    */     }
/* 76 */     return nglGetVkProcAddrNV(MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("VULKANPROCNV")
/*    */   public static long glGetVkProcAddrNV(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 86 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 88 */       memoryStack.nASCII(paramCharSequence, true);
/*    */       long l;
/* 90 */       return nglGetVkProcAddrNV(l = memoryStack.getPointerAddress());
/*    */     } finally {
/* 92 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void glDrawVkImageNV(@NativeType("GLuint64") long paramLong, @NativeType("GLuint") int paramInt, @NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4, @NativeType("GLfloat") float paramFloat5, @NativeType("GLfloat") float paramFloat6, @NativeType("GLfloat") float paramFloat7, @NativeType("GLfloat") float paramFloat8, @NativeType("GLfloat") float paramFloat9);
/*    */   
/*    */   public static native long nglGetVkProcAddrNV(long paramLong);
/*    */   
/*    */   public static native void glWaitVkSemaphoreNV(@NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glSignalVkSemaphoreNV(@NativeType("GLuint64") long paramLong);
/*    */   
/*    */   public static native void glSignalVkFenceNV(@NativeType("GLuint64") long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVDrawVulkanImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */