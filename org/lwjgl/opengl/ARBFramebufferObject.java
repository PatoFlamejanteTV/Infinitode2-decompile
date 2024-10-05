/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
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
/*     */ public class ARBFramebufferObject
/*     */ {
/*     */   public static final int GL_FRAMEBUFFER = 36160;
/*     */   public static final int GL_READ_FRAMEBUFFER = 36008;
/*     */   public static final int GL_DRAW_FRAMEBUFFER = 36009;
/*     */   public static final int GL_RENDERBUFFER = 36161;
/*     */   public static final int GL_STENCIL_INDEX1 = 36166;
/*     */   public static final int GL_STENCIL_INDEX4 = 36167;
/*     */   public static final int GL_STENCIL_INDEX8 = 36168;
/*     */   public static final int GL_STENCIL_INDEX16 = 36169;
/*     */   public static final int GL_RENDERBUFFER_WIDTH = 36162;
/*     */   public static final int GL_RENDERBUFFER_HEIGHT = 36163;
/*     */   public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 36164;
/*     */   public static final int GL_RENDERBUFFER_RED_SIZE = 36176;
/*     */   public static final int GL_RENDERBUFFER_GREEN_SIZE = 36177;
/*     */   public static final int GL_RENDERBUFFER_BLUE_SIZE = 36178;
/*     */   public static final int GL_RENDERBUFFER_ALPHA_SIZE = 36179;
/*     */   public static final int GL_RENDERBUFFER_DEPTH_SIZE = 36180;
/*     */   public static final int GL_RENDERBUFFER_STENCIL_SIZE = 36181;
/*     */   public static final int GL_RENDERBUFFER_SAMPLES = 36011;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 36048;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 36049;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 36050;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 36051;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 36052;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 33296;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 33297;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 33298;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 33299;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 33300;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 33301;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 33302;
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 33303;
/*     */   public static final int GL_UNSIGNED_NORMALIZED = 35863;
/*     */   public static final int GL_FRAMEBUFFER_DEFAULT = 33304;
/*     */   public static final int GL_INDEX = 33314;
/*     */   public static final int GL_COLOR_ATTACHMENT0 = 36064;
/*     */   public static final int GL_COLOR_ATTACHMENT1 = 36065;
/*     */   public static final int GL_COLOR_ATTACHMENT2 = 36066;
/*     */   public static final int GL_COLOR_ATTACHMENT3 = 36067;
/*     */   public static final int GL_COLOR_ATTACHMENT4 = 36068;
/*     */   public static final int GL_COLOR_ATTACHMENT5 = 36069;
/*     */   public static final int GL_COLOR_ATTACHMENT6 = 36070;
/*     */   public static final int GL_COLOR_ATTACHMENT7 = 36071;
/*     */   public static final int GL_COLOR_ATTACHMENT8 = 36072;
/*     */   public static final int GL_COLOR_ATTACHMENT9 = 36073;
/*     */   public static final int GL_COLOR_ATTACHMENT10 = 36074;
/*     */   public static final int GL_COLOR_ATTACHMENT11 = 36075;
/*     */   public static final int GL_COLOR_ATTACHMENT12 = 36076;
/*     */   public static final int GL_COLOR_ATTACHMENT13 = 36077;
/*     */   public static final int GL_COLOR_ATTACHMENT14 = 36078;
/*     */   public static final int GL_COLOR_ATTACHMENT15 = 36079;
/*     */   public static final int GL_DEPTH_ATTACHMENT = 36096;
/*     */   public static final int GL_STENCIL_ATTACHMENT = 36128;
/*     */   public static final int GL_DEPTH_STENCIL_ATTACHMENT = 33306;
/*     */   public static final int GL_MAX_SAMPLES = 36183;
/*     */   public static final int GL_FRAMEBUFFER_COMPLETE = 36053;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 36055;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 36059;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 36060;
/*     */   public static final int GL_FRAMEBUFFER_UNSUPPORTED = 36061;
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 36182;
/*     */   public static final int GL_FRAMEBUFFER_UNDEFINED = 33305;
/*     */   public static final int GL_FRAMEBUFFER_BINDING = 36006;
/*     */   public static final int GL_DRAW_FRAMEBUFFER_BINDING = 36006;
/*     */   public static final int GL_READ_FRAMEBUFFER_BINDING = 36010;
/*     */   public static final int GL_RENDERBUFFER_BINDING = 36007;
/*     */   public static final int GL_MAX_COLOR_ATTACHMENTS = 36063;
/*     */   public static final int GL_MAX_RENDERBUFFER_SIZE = 34024;
/*     */   public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 1286;
/*     */   public static final int GL_DEPTH_STENCIL = 34041;
/*     */   public static final int GL_UNSIGNED_INT_24_8 = 34042;
/*     */   public static final int GL_DEPTH24_STENCIL8 = 35056;
/*     */   public static final int GL_TEXTURE_STENCIL_SIZE = 35057;
/*     */   
/*     */   static {
/* 197 */     GL.initialize();
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
/*     */   protected ARBFramebufferObject() {
/* 327 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsRenderbuffer(@NativeType("GLuint") int paramInt) {
/* 339 */     return GL30C.glIsRenderbuffer(paramInt);
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
/*     */   public static void glBindRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 351 */     GL30C.glBindRenderbuffer(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteRenderbuffers(int paramInt, long paramLong) {
/* 362 */     GL30C.nglDeleteRenderbuffers(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 371 */     GL30C.glDeleteRenderbuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int paramInt) {
/* 376 */     GL30C.glDeleteRenderbuffers(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenRenderbuffers(int paramInt, long paramLong) {
/* 387 */     GL30C.nglGenRenderbuffers(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 396 */     GL30C.glGenRenderbuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenRenderbuffers() {
/* 402 */     return GL30C.glGenRenderbuffers();
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
/*     */   public static void glRenderbufferStorage(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 416 */     GL30C.glRenderbufferStorage(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glRenderbufferStorageMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 433 */     GL30C.glRenderbufferStorageMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetRenderbufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/* 440 */     GL30C.nglGetRenderbufferParameteriv(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 451 */     GL30C.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetRenderbufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 462 */     return GL30C.glGetRenderbufferParameteri(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static boolean glIsFramebuffer(@NativeType("GLuint") int paramInt) {
/* 474 */     return GL30C.glIsFramebuffer(paramInt);
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
/*     */   public static void glBindFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 486 */     GL30C.glBindFramebuffer(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteFramebuffers(int paramInt, long paramLong) {
/* 497 */     GL30C.nglDeleteFramebuffers(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 506 */     GL30C.glDeleteFramebuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int paramInt) {
/* 511 */     GL30C.glDeleteFramebuffers(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGenFramebuffers(int paramInt, long paramLong) {
/* 522 */     GL30C.nglGenFramebuffers(paramInt, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 531 */     GL30C.glGenFramebuffers(paramIntBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenFramebuffers() {
/* 537 */     return GL30C.glGenFramebuffers();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLenum")
/*     */   public static int glCheckFramebufferStatus(@NativeType("GLenum") int paramInt) {
/* 549 */     return GL30C.glCheckFramebufferStatus(paramInt);
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
/*     */   public static void glFramebufferTexture1D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 564 */     GL30C.glFramebufferTexture1D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glFramebufferTexture2D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 579 */     GL30C.glFramebufferTexture2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glFramebufferTexture3D(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6) {
/* 595 */     GL30C.glFramebufferTexture3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*     */   public static void glFramebufferTextureLayer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 610 */     GL30C.glFramebufferTextureLayer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glFramebufferRenderbuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 624 */     GL30C.glFramebufferRenderbuffer(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetFramebufferAttachmentParameteriv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 631 */     GL30C.nglGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 643 */     GL30C.glGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetFramebufferAttachmentParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 655 */     return GL30C.glGetFramebufferAttachmentParameteri(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glBlitFramebuffer(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10) {
/* 675 */     GL30C.glBlitFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGenerateMipmap(@NativeType("GLenum") int paramInt) {
/* 686 */     GL30C.glGenerateMipmap(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteRenderbuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 691 */     GL30C.glDeleteRenderbuffers(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenRenderbuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 696 */     GL30C.glGenRenderbuffers(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetRenderbufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 701 */     GL30C.glGetRenderbufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteFramebuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 706 */     GL30C.glDeleteFramebuffers(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenFramebuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 711 */     GL30C.glGenFramebuffers(paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetFramebufferAttachmentParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 716 */     GL30C.glGetFramebufferAttachmentParameteriv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBFramebufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */