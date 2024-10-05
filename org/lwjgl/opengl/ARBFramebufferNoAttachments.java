/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBFramebufferNoAttachments
/*     */ {
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 37648;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 37649;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 37650;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 37651;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 37652;
/*     */   public static final int GL_MAX_FRAMEBUFFER_WIDTH = 37653;
/*     */   public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 37654;
/*     */   public static final int GL_MAX_FRAMEBUFFER_LAYERS = 37655;
/*     */   public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 37656;
/*     */   
/*     */   static {
/*  48 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ARBFramebufferNoAttachments() {
/*  69 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3) {
/*  82 */     GL43C.glFramebufferParameteri(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetFramebufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/*  89 */     GL43C.nglGetFramebufferParameteriv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 100 */     GL43C.glGetFramebufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFramebufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 111 */     return GL43C.glGetFramebufferParameteri(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetNamedFramebufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 141 */     nglGetNamedFramebufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetNamedFramebufferParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 152 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 154 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 155 */       nglGetNamedFramebufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 156 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 158 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 164 */     GL43C.glGetFramebufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetNamedFramebufferParameterivEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 169 */     long l = (GL.getICD()).glGetNamedFramebufferParameterivEXT;
/* 170 */     if (Checks.CHECKS) {
/* 171 */       Checks.check(l);
/* 172 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 174 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glNamedFramebufferParameteriEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*     */   
/*     */   public static native void nglGetNamedFramebufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBFramebufferNoAttachments.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */