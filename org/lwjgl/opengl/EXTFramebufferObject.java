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
/*     */ public class EXTFramebufferObject
/*     */ {
/*     */   public static final int GL_FRAMEBUFFER_EXT = 36160;
/*     */   public static final int GL_RENDERBUFFER_EXT = 36161;
/*     */   public static final int GL_STENCIL_INDEX1_EXT = 36166;
/*     */   public static final int GL_STENCIL_INDEX4_EXT = 36167;
/*     */   public static final int GL_STENCIL_INDEX8_EXT = 36168;
/*     */   public static final int GL_STENCIL_INDEX16_EXT = 36169;
/*     */   public static final int GL_RENDERBUFFER_WIDTH_EXT = 36162;
/*     */   public static final int GL_RENDERBUFFER_HEIGHT_EXT = 36163;
/*     */   public static final int GL_RENDERBUFFER_INTERNAL_FORMAT_EXT = 36164;
/*     */   public static final int GL_RENDERBUFFER_RED_SIZE_EXT = 36176;
/*     */   public static final int GL_RENDERBUFFER_GREEN_SIZE_EXT = 36177;
/*     */   public static final int GL_RENDERBUFFER_BLUE_SIZE_EXT = 36178;
/*     */   public static final int GL_RENDERBUFFER_ALPHA_SIZE_EXT = 36179;
/*     */   public static final int GL_RENDERBUFFER_DEPTH_SIZE_EXT = 36180;
/*     */   public static final int GL_RENDERBUFFER_STENCIL_SIZE_EXT = 36181;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE_EXT = 36048;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME_EXT = 36049;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL_EXT = 36050;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE_EXT = 36051;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_3D_ZOFFSET_EXT = 36052;
/*     */   public static final int GL_COLOR_ATTACHMENT0_EXT = 36064;
/*     */   public static final int GL_COLOR_ATTACHMENT1_EXT = 36065;
/*     */   public static final int GL_COLOR_ATTACHMENT2_EXT = 36066;
/*     */   public static final int GL_COLOR_ATTACHMENT3_EXT = 36067;
/*     */   public static final int GL_COLOR_ATTACHMENT4_EXT = 36068;
/*     */   
/*     */   static {
/*  63 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT5_EXT = 36069;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT6_EXT = 36070;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT7_EXT = 36071;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT8_EXT = 36072;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT9_EXT = 36073;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT10_EXT = 36074;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT11_EXT = 36075;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT12_EXT = 36076;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT13_EXT = 36077;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT14_EXT = 36078;
/*     */ 
/*     */   
/*     */   public static final int GL_COLOR_ATTACHMENT15_EXT = 36079;
/*     */ 
/*     */   
/*     */   public static final int GL_DEPTH_ATTACHMENT_EXT = 36096;
/*     */ 
/*     */   
/*     */   public static final int GL_STENCIL_ATTACHMENT_EXT = 36128;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_COMPLETE_EXT = 36053;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT_EXT = 36054;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT_EXT = 36055;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS_EXT = 36057;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_FORMATS_EXT = 36058;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER_EXT = 36059;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER_EXT = 36060;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_UNSUPPORTED_EXT = 36061;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_BINDING_EXT = 36006;
/*     */ 
/*     */   
/*     */   public static final int GL_RENDERBUFFER_BINDING_EXT = 36007;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COLOR_ATTACHMENTS_EXT = 36063;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_RENDERBUFFER_SIZE_EXT = 34024;
/*     */ 
/*     */   
/*     */   public static final int GL_INVALID_FRAMEBUFFER_OPERATION_EXT = 1286;
/*     */ 
/*     */   
/*     */   protected EXTFramebufferObject() {
/* 147 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDeleteRenderbuffersEXT(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 164 */     nglDeleteRenderbuffersEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteRenderbuffersEXT(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 168 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 170 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 171 */       nglDeleteRenderbuffersEXT(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 173 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffersEXT(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 182 */     nglGenRenderbuffersEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenRenderbuffersEXT() {
/*     */     MemoryStack memoryStack;
/* 187 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 189 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 190 */       nglGenRenderbuffersEXT(1, MemoryUtil.memAddress(intBuffer));
/* 191 */       return intBuffer.get(0);
/*     */     } finally {
/* 193 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glGetRenderbufferParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 206 */     if (Checks.CHECKS) {
/* 207 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 209 */     nglGetRenderbufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetRenderbufferParameteriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 214 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 216 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 217 */       nglGetRenderbufferParameterivEXT(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 218 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 220 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */   public static void glDeleteFramebuffersEXT(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 238 */     nglDeleteFramebuffersEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   public static void glDeleteFramebuffersEXT(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 242 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 244 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 245 */       nglDeleteFramebuffersEXT(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 247 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffersEXT(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 256 */     nglGenFramebuffersEXT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGenFramebuffersEXT() {
/*     */     MemoryStack memoryStack;
/* 261 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 263 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 264 */       nglGenFramebuffersEXT(1, MemoryUtil.memAddress(intBuffer));
/* 265 */       return intBuffer.get(0);
/*     */     } finally {
/* 267 */       memoryStack.setPointer(i);
/*     */     } 
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
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferAttachmentParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 297 */     if (Checks.CHECKS) {
/* 298 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 300 */     nglGetFramebufferAttachmentParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   @NativeType("void")
/*     */   public static int glGetFramebufferAttachmentParameteriEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*     */     MemoryStack memoryStack;
/* 305 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 307 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 308 */       nglGetFramebufferAttachmentParameterivEXT(paramInt1, paramInt2, paramInt3, MemoryUtil.memAddress(intBuffer));
/* 309 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 311 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffersEXT(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 321 */     long l = (GL.getICD()).glDeleteRenderbuffersEXT;
/* 322 */     if (Checks.CHECKS) {
/* 323 */       Checks.check(l);
/*     */     }
/* 325 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffersEXT(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 330 */     long l = (GL.getICD()).glGenRenderbuffersEXT;
/* 331 */     if (Checks.CHECKS) {
/* 332 */       Checks.check(l);
/*     */     }
/* 334 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetRenderbufferParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 339 */     long l = (GL.getICD()).glGetRenderbufferParameterivEXT;
/* 340 */     if (Checks.CHECKS) {
/* 341 */       Checks.check(l);
/* 342 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 344 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffersEXT(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 349 */     long l = (GL.getICD()).glDeleteFramebuffersEXT;
/* 350 */     if (Checks.CHECKS) {
/* 351 */       Checks.check(l);
/*     */     }
/* 353 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffersEXT(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 358 */     long l = (GL.getICD()).glGenFramebuffersEXT;
/* 359 */     if (Checks.CHECKS) {
/* 360 */       Checks.check(l);
/*     */     }
/* 362 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferAttachmentParameterivEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 367 */     long l = (GL.getICD()).glGetFramebufferAttachmentParameterivEXT;
/* 368 */     if (Checks.CHECKS) {
/* 369 */       Checks.check(l);
/* 370 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 372 */     JNI.callPV(paramInt1, paramInt2, paramInt3, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsRenderbufferEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBindRenderbufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteRenderbuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenRenderbuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glRenderbufferStorageEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*     */   
/*     */   public static native void nglGetRenderbufferParameterivEXT(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsFramebufferEXT(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void glBindFramebufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteFramebuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenFramebuffersEXT(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static native int glCheckFramebufferStatusEXT(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glFramebufferTexture1DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glFramebufferTexture2DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5);
/*     */   
/*     */   public static native void glFramebufferTexture3DEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6);
/*     */   
/*     */   public static native void glFramebufferRenderbufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4);
/*     */   
/*     */   public static native void nglGetFramebufferAttachmentParameterivEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong);
/*     */   
/*     */   public static native void glGenerateMipmapEXT(@NativeType("GLenum") int paramInt);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTFramebufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */