/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
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
/*    */ public class GLX14
/*    */   extends GLX13
/*    */ {
/*    */   public static final int GLX_SAMPLE_BUFFERS = 100000;
/*    */   public static final int GLX_SAMPLES = 100001;
/*    */   
/*    */   protected GLX14() {
/* 26 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nglXGetProcAddress(long paramLong) {
/* 33 */     long l = (GL.getCapabilitiesGLXClient()).glXGetProcAddress;
/* 34 */     if (Checks.CHECKS) {
/* 35 */       Checks.check(l);
/*    */     }
/* 37 */     return JNI.callPP(paramLong, l);
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
/*    */   @NativeType("void *")
/*    */   public static long glXGetProcAddress(@NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 63 */     if (Checks.CHECKS) {
/* 64 */       Checks.checkNT1(paramByteBuffer);
/*    */     }
/* 66 */     return nglXGetProcAddress(MemoryUtil.memAddress(paramByteBuffer));
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
/*    */   @NativeType("void *")
/*    */   public static long glXGetProcAddress(@NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 92 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 94 */       memoryStack.nASCII(paramCharSequence, true);
/*    */       long l;
/* 96 */       return nglXGetProcAddress(l = memoryStack.getPointerAddress());
/*    */     } finally {
/* 98 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLX14.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */