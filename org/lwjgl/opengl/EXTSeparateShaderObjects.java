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
/*    */ public class EXTSeparateShaderObjects
/*    */ {
/*    */   public static final int GL_ACTIVE_PROGRAM_EXT = 35725;
/*    */   
/*    */   static {
/* 55 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTSeparateShaderObjects() {
/* 61 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("GLuint")
/*    */   public static int glCreateShaderProgramEXT(@NativeType("GLenum") int paramInt, @NativeType("GLchar const *") ByteBuffer paramByteBuffer) {
/* 78 */     if (Checks.CHECKS) {
/* 79 */       Checks.checkNT1(paramByteBuffer);
/*    */     }
/* 81 */     return nglCreateShaderProgramEXT(paramInt, MemoryUtil.memAddress(paramByteBuffer));
/*    */   }
/*    */   @NativeType("GLuint")
/*    */   public static int glCreateShaderProgramEXT(@NativeType("GLenum") int paramInt, @NativeType("GLchar const *") CharSequence paramCharSequence) {
/*    */     MemoryStack memoryStack;
/* 86 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*    */     try {
/* 88 */       memoryStack.nUTF8(paramCharSequence, true);
/* 89 */       long l = memoryStack.getPointerAddress();
/* 90 */       paramInt = nglCreateShaderProgramEXT(paramInt, l); return paramInt;
/*    */     } finally {
/* 92 */       memoryStack.setPointer(i);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native void glUseShaderProgramEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */   
/*    */   public static native void glActiveProgramEXT(@NativeType("GLuint") int paramInt);
/*    */   
/*    */   public static native int nglCreateShaderProgramEXT(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTSeparateShaderObjects.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */