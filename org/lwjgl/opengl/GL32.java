/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL32
/*     */   extends GL31
/*     */ {
/*     */   public static final int GL_CONTEXT_PROFILE_MASK = 37158;
/*     */   public static final int GL_CONTEXT_CORE_PROFILE_BIT = 1;
/*     */   public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 2;
/*     */   public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 37154;
/*     */   public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 37155;
/*     */   public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 37156;
/*     */   public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 37157;
/*     */   public static final int GL_FIRST_VERTEX_CONVENTION = 36429;
/*     */   public static final int GL_LAST_VERTEX_CONVENTION = 36430;
/*     */   public static final int GL_PROVOKING_VERTEX = 36431;
/*     */   public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 36428;
/*     */   public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 34895;
/*     */   public static final int GL_SAMPLE_POSITION = 36432;
/*     */   public static final int GL_SAMPLE_MASK = 36433;
/*     */   public static final int GL_SAMPLE_MASK_VALUE = 36434;
/*     */   public static final int GL_TEXTURE_2D_MULTISAMPLE = 37120;
/*     */   
/*     */   static {
/*  37 */     GL.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 37121;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 37122;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 37123;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_SAMPLE_MASK_WORDS = 36441;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 37134;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 37135;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_INTEGER_SAMPLES = 37136;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 37124;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 37125;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_SAMPLES = 37126;
/*     */ 
/*     */   
/*     */   public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 37127;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_MULTISAMPLE = 37128;
/*     */ 
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 37129;
/*     */ 
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 37130;
/*     */ 
/*     */   
/*     */   public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 37131;
/*     */ 
/*     */   
/*     */   public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37132;
/*     */ 
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 37133;
/*     */ 
/*     */   
/*     */   public static final int GL_DEPTH_CLAMP = 34383;
/*     */ 
/*     */   
/*     */   public static final int GL_GEOMETRY_SHADER = 36313;
/*     */ 
/*     */   
/*     */   public static final int GL_GEOMETRY_VERTICES_OUT = 36314;
/*     */ 
/*     */   
/*     */   public static final int GL_GEOMETRY_INPUT_TYPE = 36315;
/*     */ 
/*     */   
/*     */   public static final int GL_GEOMETRY_OUTPUT_TYPE = 36316;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 35881;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 36319;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 36320;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 36321;
/*     */ 
/*     */   
/*     */   public static final int GL_LINES_ADJACENCY = 10;
/*     */ 
/*     */   
/*     */   public static final int GL_LINE_STRIP_ADJACENCY = 11;
/*     */ 
/*     */   
/*     */   public static final int GL_TRIANGLES_ADJACENCY = 12;
/*     */ 
/*     */   
/*     */   public static final int GL_TRIANGLE_STRIP_ADJACENCY = 13;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 36264;
/*     */ 
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 36263;
/*     */ 
/*     */   
/*     */   public static final int GL_PROGRAM_POINT_SIZE = 34370;
/*     */ 
/*     */   
/*     */   public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 37137;
/*     */ 
/*     */   
/*     */   public static final int GL_OBJECT_TYPE = 37138;
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_CONDITION = 37139;
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_STATUS = 37140;
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_FLAGS = 37141;
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_FENCE = 37142;
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 37143;
/*     */ 
/*     */   
/*     */   public static final int GL_UNSIGNALED = 37144;
/*     */ 
/*     */   
/*     */   public static final int GL_SIGNALED = 37145;
/*     */ 
/*     */   
/*     */   public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 1;
/*     */ 
/*     */   
/*     */   public static final long GL_TIMEOUT_IGNORED = -1L;
/*     */ 
/*     */   
/*     */   public static final int GL_ALREADY_SIGNALED = 37146;
/*     */ 
/*     */   
/*     */   public static final int GL_TIMEOUT_EXPIRED = 37147;
/*     */ 
/*     */   
/*     */   public static final int GL_CONDITION_SATISFIED = 37148;
/*     */ 
/*     */   
/*     */   public static final int GL_WAIT_FAILED = 37149;
/*     */ 
/*     */ 
/*     */   
/*     */   protected GL32() {
/* 193 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetBufferParameteri64v(int paramInt1, int paramInt2, long paramLong) {
/* 200 */     GL32C.nglGetBufferParameteri64v(paramInt1, paramInt2, paramLong);
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
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 213 */     GL32C.glGetBufferParameteri64v(paramInt1, paramInt2, paramLongBuffer);
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
/*     */   @NativeType("void")
/*     */   public static long glGetBufferParameteri64(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 226 */     return GL32C.glGetBufferParameteri64(paramInt1, paramInt2);
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
/*     */   public static void nglDrawElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4) {
/* 238 */     GL32C.nglDrawElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLint") int paramInt4) {
/* 253 */     GL32C.glDrawElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLint") int paramInt3) {
/* 267 */     GL32C.glDrawElementsBaseVertex(paramInt1, paramInt2, paramByteBuffer, paramInt3);
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
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLint") int paramInt2) {
/* 280 */     GL32C.glDrawElementsBaseVertex(paramInt1, paramByteBuffer, paramInt2);
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
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLint") int paramInt2) {
/* 293 */     GL32C.glDrawElementsBaseVertex(paramInt1, paramShortBuffer, paramInt2);
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
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2) {
/* 306 */     GL32C.glDrawElementsBaseVertex(paramInt1, paramIntBuffer, paramInt2);
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
/*     */   public static void nglDrawRangeElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6) {
/* 318 */     GL32C.nglDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramInt6);
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
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") long paramLong, @NativeType("GLint") int paramInt6) {
/* 335 */     GL32C.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramInt6);
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
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLint") int paramInt5) {
/* 351 */     GL32C.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramByteBuffer, paramInt5);
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
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLint") int paramInt4) {
/* 366 */     GL32C.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramByteBuffer, paramInt4);
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
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLint") int paramInt4) {
/* 381 */     GL32C.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramShortBuffer, paramInt4);
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
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt4) {
/* 396 */     GL32C.glDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramIntBuffer, paramInt4);
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
/*     */   public static void nglDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5) {
/* 408 */     GL32C.nglDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
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
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 424 */     GL32C.glDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
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
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4) {
/* 439 */     GL32C.glDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4);
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
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 453 */     GL32C.glDrawElementsInstancedBaseVertex(paramInt1, paramByteBuffer, paramInt2, paramInt3);
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
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 467 */     GL32C.glDrawElementsInstancedBaseVertex(paramInt1, paramShortBuffer, paramInt2, paramInt3);
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
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3) {
/* 481 */     GL32C.glDrawElementsInstancedBaseVertex(paramInt1, paramIntBuffer, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawElementsBaseVertex(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, long paramLong3) {
/* 492 */     GL32C.nglMultiDrawElementsBaseVertex(paramInt1, paramLong1, paramInt2, paramLong2, paramInt3, paramLong3);
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
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei const *") IntBuffer paramIntBuffer1, @NativeType("GLenum") int paramInt2, @NativeType("void const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 509 */     GL32C.glMultiDrawElementsBaseVertex(paramInt1, paramIntBuffer1, paramInt2, paramPointerBuffer, paramIntBuffer2);
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
/*     */   public static void glProvokingVertex(@NativeType("GLenum") int paramInt) {
/* 522 */     GL32C.glProvokingVertex(paramInt);
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
/*     */   public static void glTexImage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean) {
/* 542 */     GL32C.glTexImage2DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
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
/*     */   public static void glTexImage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean) {
/* 563 */     GL32C.glTexImage3DMultisample(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetMultisamplefv(int paramInt1, int paramInt2, long paramLong) {
/* 570 */     GL32C.nglGetMultisamplefv(paramInt1, paramInt2, paramLong);
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
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 583 */     GL32C.glGetMultisamplefv(paramInt1, paramInt2, paramFloatBuffer);
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
/*     */   @NativeType("void")
/*     */   public static float glGetMultisamplef(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 596 */     return GL32C.glGetMultisamplef(paramInt1, paramInt2);
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
/*     */   public static void glSampleMaski(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2) {
/* 610 */     GL32C.glSampleMaski(paramInt1, paramInt2);
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
/*     */   public static void glFramebufferTexture(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4) {
/* 626 */     GL32C.glFramebufferTexture(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   @NativeType("GLsync")
/*     */   public static long glFenceSync(@NativeType("GLenum") int paramInt1, @NativeType("GLbitfield") int paramInt2) {
/* 642 */     return GL32C.glFenceSync(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nglIsSync(long paramLong) {
/* 649 */     return GL32C.nglIsSync(paramLong);
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
/*     */   public static boolean glIsSync(@NativeType("GLsync") long paramLong) {
/* 661 */     return GL32C.glIsSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDeleteSync(long paramLong) {
/* 668 */     GL32C.nglDeleteSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDeleteSync(@NativeType("GLsync") long paramLong) {
/* 679 */     GL32C.glDeleteSync(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglClientWaitSync(long paramLong1, int paramInt, long paramLong2) {
/* 686 */     return GL32C.nglClientWaitSync(paramLong1, paramInt, paramLong2);
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
/*     */   @NativeType("GLenum")
/*     */   public static int glClientWaitSync(@NativeType("GLsync") long paramLong1, @NativeType("GLbitfield") int paramInt, @NativeType("GLuint64") long paramLong2) {
/* 710 */     return GL32C.glClientWaitSync(paramLong1, paramInt, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglWaitSync(long paramLong1, int paramInt, long paramLong2) {
/* 717 */     GL32C.nglWaitSync(paramLong1, paramInt, paramLong2);
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
/*     */   public static void glWaitSync(@NativeType("GLsync") long paramLong1, @NativeType("GLbitfield") int paramInt, @NativeType("GLuint64") long paramLong2) {
/* 736 */     GL32C.glWaitSync(paramLong1, paramInt, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInteger64v(int paramInt, long paramLong) {
/* 743 */     GL32C.nglGetInteger64v(paramInt, paramLong);
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
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 755 */     GL32C.glGetInteger64v(paramInt, paramLongBuffer);
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
/*     */   public static long glGetInteger64(@NativeType("GLenum") int paramInt) {
/* 767 */     return GL32C.glGetInteger64(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInteger64i_v(int paramInt1, int paramInt2, long paramLong) {
/* 774 */     GL32C.nglGetInteger64i_v(paramInt1, paramInt2, paramLong);
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
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 787 */     GL32C.glGetInteger64i_v(paramInt1, paramInt2, paramLongBuffer);
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
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64i(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/* 800 */     return GL32C.glGetInteger64i(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetSynciv(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3) {
/* 811 */     GL32C.nglGetSynciv(paramLong1, paramInt1, paramInt2, paramLong2, paramLong3);
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
/*     */   public static void glGetSynciv(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 825 */     GL32C.glGetSynciv(paramLong, paramInt, paramIntBuffer1, paramIntBuffer2);
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
/*     */   @NativeType("void")
/*     */   public static int glGetSynci(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer) {
/* 839 */     return GL32C.glGetSynci(paramLong, paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 848 */     GL32C.glGetBufferParameteri64v(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei const *") int[] paramArrayOfint1, @NativeType("GLenum") int paramInt2, @NativeType("void const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 857 */     GL32C.glMultiDrawElementsBaseVertex(paramInt1, paramArrayOfint1, paramInt2, paramPointerBuffer, paramArrayOfint2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 866 */     GL32C.glGetMultisamplefv(paramInt1, paramInt2, paramArrayOffloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 875 */     GL32C.glGetInteger64v(paramInt, paramArrayOflong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 884 */     GL32C.glGetInteger64i_v(paramInt1, paramInt2, paramArrayOflong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 893 */     GL32C.glGetSynciv(paramLong, paramInt, paramArrayOfint1, paramArrayOfint2);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */