/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ public class GL32C
/*     */   extends GL31C
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
/*  42 */     GL.initialize();
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
/*     */   protected GL32C() {
/* 198 */     throw new UnsupportedOperationException();
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
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 216 */     if (Checks.CHECKS) {
/* 217 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 219 */     nglGetBufferParameteri64v(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static long glGetBufferParameteri64(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 232 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 234 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 235 */       nglGetBufferParameteri64v(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 236 */       return longBuffer.get(0);
/*     */     } finally {
/* 238 */       memoryStack.setPointer(i);
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
/*     */   public static void glDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLint") int paramInt4) {
/* 264 */     nglDrawElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
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
/* 278 */     nglDrawElementsBaseVertex(paramInt1, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3);
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
/* 291 */     nglDrawElementsBaseVertex(paramInt1, paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer), paramInt2);
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
/* 304 */     nglDrawElementsBaseVertex(paramInt1, paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
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
/* 317 */     nglDrawElementsBaseVertex(paramInt1, paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
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
/*     */   public static void glDrawRangeElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("void const *") long paramLong, @NativeType("GLint") int paramInt6) {
/* 344 */     nglDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramLong, paramInt6);
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
/* 360 */     nglDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt4), paramInt4, MemoryUtil.memAddress(paramByteBuffer), paramInt5);
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
/* 375 */     nglDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer), paramInt4);
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
/* 390 */     nglDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer), paramInt4);
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
/* 405 */     nglDrawRangeElementsBaseVertex(paramInt1, paramInt2, paramInt3, paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer), paramInt4);
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
/*     */   public static void glDrawElementsInstancedBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 431 */     nglDrawElementsInstancedBaseVertex(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
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
/* 446 */     nglDrawElementsInstancedBaseVertex(paramInt1, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4);
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
/* 460 */     nglDrawElementsInstancedBaseVertex(paramInt1, paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3);
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
/* 474 */     nglDrawElementsInstancedBaseVertex(paramInt1, paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer), paramInt2, paramInt3);
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
/* 488 */     nglDrawElementsInstancedBaseVertex(paramInt1, paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer), paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei const *") IntBuffer paramIntBuffer1, @NativeType("GLenum") int paramInt2, @NativeType("void const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 514 */     if (Checks.CHECKS) {
/* 515 */       Checks.check((CustomBuffer)paramPointerBuffer, paramIntBuffer1.remaining());
/* 516 */       Checks.check(paramIntBuffer2, paramIntBuffer1.remaining());
/*     */     } 
/* 518 */     nglMultiDrawElementsBaseVertex(paramInt1, MemoryUtil.memAddress(paramIntBuffer1), paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramIntBuffer1.remaining(), MemoryUtil.memAddress(paramIntBuffer2));
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
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") FloatBuffer paramFloatBuffer) {
/* 584 */     if (Checks.CHECKS) {
/* 585 */       Checks.check(paramFloatBuffer, 1);
/*     */     }
/* 587 */     nglGetMultisamplefv(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer));
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
/*     */   public static float glGetMultisamplef(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 600 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 602 */       FloatBuffer floatBuffer = memoryStack.callocFloat(1);
/* 603 */       nglGetMultisamplefv(paramInt1, paramInt2, MemoryUtil.memAddress(floatBuffer));
/* 604 */       return floatBuffer.get(0);
/*     */     } finally {
/* 606 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 664 */     if (Checks.CHECKS) {
/* 665 */       Checks.check(paramLong);
/*     */     }
/* 667 */     return nglIsSync(paramLong);
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
/*     */   public static void glDeleteSync(@NativeType("GLsync") long paramLong) {
/* 683 */     if (Checks.CHECKS) {
/* 684 */       Checks.check(paramLong);
/*     */     }
/* 686 */     nglDeleteSync(paramLong);
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
/*     */   @NativeType("GLenum")
/*     */   public static int glClientWaitSync(@NativeType("GLsync") long paramLong1, @NativeType("GLbitfield") int paramInt, @NativeType("GLuint64") long paramLong2) {
/* 715 */     if (Checks.CHECKS) {
/* 716 */       Checks.check(paramLong1);
/*     */     }
/* 718 */     return nglClientWaitSync(paramLong1, paramInt, paramLong2);
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
/*     */   public static void glWaitSync(@NativeType("GLsync") long paramLong1, @NativeType("GLbitfield") int paramInt, @NativeType("GLuint64") long paramLong2) {
/* 742 */     if (Checks.CHECKS) {
/* 743 */       Checks.check(paramLong1);
/*     */     }
/* 745 */     nglWaitSync(paramLong1, paramInt, paramLong2);
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
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int paramInt, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 762 */     if (Checks.CHECKS) {
/* 763 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 765 */     nglGetInteger64v(paramInt, MemoryUtil.memAddress(paramLongBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetInteger64(@NativeType("GLenum") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 777 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 779 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 780 */       nglGetInteger64v(paramInt, MemoryUtil.memAddress(longBuffer));
/* 781 */       return longBuffer.get(0);
/*     */     } finally {
/* 783 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint64 *") LongBuffer paramLongBuffer) {
/* 802 */     if (Checks.CHECKS) {
/* 803 */       Checks.check(paramLongBuffer, 1);
/*     */     }
/* 805 */     nglGetInteger64i_v(paramInt1, paramInt2, MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   public static long glGetInteger64i(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 818 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 820 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 821 */       nglGetInteger64i_v(paramInt1, paramInt2, MemoryUtil.memAddress(longBuffer));
/* 822 */       return longBuffer.get(0);
/*     */     } finally {
/* 824 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetSynciv(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") IntBuffer paramIntBuffer1, @NativeType("GLint *") IntBuffer paramIntBuffer2) {
/* 848 */     if (Checks.CHECKS) {
/* 849 */       Checks.check(paramLong);
/* 850 */       Checks.checkSafe(paramIntBuffer1, 1);
/*     */     } 
/* 852 */     nglGetSynciv(paramLong, paramInt, paramIntBuffer2.remaining(), MemoryUtil.memAddressSafe(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2));
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
/* 866 */     if (Checks.CHECKS) {
/* 867 */       Checks.check(paramLong);
/* 868 */       Checks.checkSafe(paramIntBuffer, 1);
/*     */     }  MemoryStack memoryStack;
/* 870 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 872 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 873 */       nglGetSynciv(paramLong, paramInt, 1, MemoryUtil.memAddressSafe(paramIntBuffer), MemoryUtil.memAddress(intBuffer));
/* 874 */       return intBuffer.get(0);
/*     */     } finally {
/* 876 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameteri64v(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 886 */     long l = (GL.getICD()).glGetBufferParameteri64v;
/* 887 */     if (Checks.CHECKS) {
/* 888 */       Checks.check(l);
/* 889 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 891 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsBaseVertex(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei const *") int[] paramArrayOfint1, @NativeType("GLenum") int paramInt2, @NativeType("void const * const *") PointerBuffer paramPointerBuffer, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 900 */     long l = (GL.getICD()).glMultiDrawElementsBaseVertex;
/* 901 */     if (Checks.CHECKS) {
/* 902 */       Checks.check(l);
/* 903 */       Checks.check((CustomBuffer)paramPointerBuffer, paramArrayOfint1.length);
/* 904 */       Checks.check(paramArrayOfint2, paramArrayOfint1.length);
/*     */     } 
/* 906 */     JNI.callPPPV(paramInt1, paramArrayOfint1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint1.length, paramArrayOfint2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetMultisamplefv(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLfloat *") float[] paramArrayOffloat) {
/* 915 */     long l = (GL.getICD()).glGetMultisamplefv;
/* 916 */     if (Checks.CHECKS) {
/* 917 */       Checks.check(l);
/* 918 */       Checks.check(paramArrayOffloat, 1);
/*     */     } 
/* 920 */     JNI.callPV(paramInt1, paramInt2, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64v(@NativeType("GLenum") int paramInt, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 929 */     long l = (GL.getICD()).glGetInteger64v;
/* 930 */     if (Checks.CHECKS) {
/* 931 */       Checks.check(l);
/* 932 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 934 */     JNI.callPV(paramInt, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInteger64i_v(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint64 *") long[] paramArrayOflong) {
/* 943 */     long l = (GL.getICD()).glGetInteger64i_v;
/* 944 */     if (Checks.CHECKS) {
/* 945 */       Checks.check(l);
/* 946 */       Checks.check(paramArrayOflong, 1);
/*     */     } 
/* 948 */     JNI.callPV(paramInt1, paramInt2, paramArrayOflong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetSynciv(@NativeType("GLsync") long paramLong, @NativeType("GLenum") int paramInt, @NativeType("GLsizei *") int[] paramArrayOfint1, @NativeType("GLint *") int[] paramArrayOfint2) {
/* 957 */     long l = (GL.getICD()).glGetSynciv;
/* 958 */     if (Checks.CHECKS) {
/* 959 */       Checks.check(l);
/* 960 */       Checks.check(paramLong);
/* 961 */       Checks.checkSafe(paramArrayOfint1, 1);
/*     */     } 
/* 963 */     JNI.callPPPV(paramLong, paramInt, paramArrayOfint2.length, paramArrayOfint1, paramArrayOfint2, l);
/*     */   }
/*     */   
/*     */   public static native void nglGetBufferParameteri64v(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglDrawElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
/*     */   
/*     */   public static native void nglDrawRangeElementsBaseVertex(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong, int paramInt6);
/*     */   
/*     */   public static native void nglDrawElementsInstancedBaseVertex(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5);
/*     */   
/*     */   public static native void nglMultiDrawElementsBaseVertex(int paramInt1, long paramLong1, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*     */   
/*     */   public static native void glProvokingVertex(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void glTexImage2DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void glTexImage3DMultisample(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLboolean") boolean paramBoolean);
/*     */   
/*     */   public static native void nglGetMultisamplefv(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void glSampleMaski(@NativeType("GLuint") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*     */   
/*     */   public static native void glFramebufferTexture(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLint") int paramInt4);
/*     */   
/*     */   @NativeType("GLsync")
/*     */   public static native long glFenceSync(@NativeType("GLenum") int paramInt1, @NativeType("GLbitfield") int paramInt2);
/*     */   
/*     */   public static native boolean nglIsSync(long paramLong);
/*     */   
/*     */   public static native void nglDeleteSync(long paramLong);
/*     */   
/*     */   public static native int nglClientWaitSync(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nglWaitSync(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nglGetInteger64v(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGetInteger64i_v(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetSynciv(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL32C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */