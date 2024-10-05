/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GL42
/*     */   extends GL41
/*     */ {
/*     */   public static final int GL_COPY_READ_BUFFER_BINDING = 36662;
/*     */   public static final int GL_COPY_WRITE_BUFFER_BINDING = 36663;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 36388;
/*     */   public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 36387;
/*     */   public static final int GL_COMPRESSED_RGBA_BPTC_UNORM = 36492;
/*     */   public static final int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM = 36493;
/*     */   public static final int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT = 36494;
/*     */   public static final int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT = 36495;
/*     */   public static final int GL_UNPACK_COMPRESSED_BLOCK_WIDTH = 37159;
/*     */   public static final int GL_UNPACK_COMPRESSED_BLOCK_HEIGHT = 37160;
/*     */   public static final int GL_UNPACK_COMPRESSED_BLOCK_DEPTH = 37161;
/*     */   public static final int GL_UNPACK_COMPRESSED_BLOCK_SIZE = 37162;
/*     */   public static final int GL_PACK_COMPRESSED_BLOCK_WIDTH = 37163;
/*     */   public static final int GL_PACK_COMPRESSED_BLOCK_HEIGHT = 37164;
/*     */   
/*     */   static {
/*  34 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int GL_PACK_COMPRESSED_BLOCK_DEPTH = 37165;
/*     */   
/*     */   public static final int GL_PACK_COMPRESSED_BLOCK_SIZE = 37166;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER = 37568;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 37569;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_START = 37570;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 37571;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE = 37572;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS = 37573;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES = 37574;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER = 37575;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER = 37576;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER = 37577;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER = 37578;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER = 37579;
/*     */   
/*     */   public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 37580;
/*     */   
/*     */   public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 37581;
/*     */   
/*     */   public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 37582;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 37583;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 37584;
/*     */   
/*     */   public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 37585;
/*     */   
/*     */   public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 37586;
/*     */   
/*     */   public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 37587;
/*     */   
/*     */   public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 37588;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 37589;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 37590;
/*     */   
/*     */   public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 37591;
/*     */   
/*     */   public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 37592;
/*     */   
/*     */   public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 37596;
/*     */   
/*     */   public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 37593;
/*     */   
/*     */   public static final int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = 37594;
/*     */   
/*     */   public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 37595;
/*     */   
/*     */   public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 37167;
/*     */   
/*     */   public static final int GL_MAX_IMAGE_UNITS = 36664;
/*     */   
/*     */   public static final int GL_MAX_COMBINED_IMAGE_UNITS_AND_FRAGMENT_OUTPUTS = 36665;
/*     */   
/*     */   public static final int GL_MAX_IMAGE_SAMPLES = 36973;
/*     */   
/*     */   public static final int GL_MAX_VERTEX_IMAGE_UNIFORMS = 37066;
/*     */   
/*     */   public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 37067;
/*     */   
/*     */   public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 37068;
/*     */   
/*     */   public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 37069;
/*     */   
/*     */   public static final int GL_MAX_FRAGMENT_IMAGE_UNIFORMS = 37070;
/*     */   
/*     */   public static final int GL_MAX_COMBINED_IMAGE_UNIFORMS = 37071;
/*     */   
/*     */   public static final int GL_IMAGE_BINDING_NAME = 36666;
/*     */   
/*     */   public static final int GL_IMAGE_BINDING_LEVEL = 36667;
/*     */   
/*     */   public static final int GL_IMAGE_BINDING_LAYERED = 36668;
/*     */   
/*     */   public static final int GL_IMAGE_BINDING_LAYER = 36669;
/*     */   
/*     */   public static final int GL_IMAGE_BINDING_ACCESS = 36670;
/*     */   
/*     */   public static final int GL_IMAGE_BINDING_FORMAT = 36974;
/*     */   
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT = 1;
/*     */   
/*     */   public static final int GL_ELEMENT_ARRAY_BARRIER_BIT = 2;
/*     */   
/*     */   public static final int GL_UNIFORM_BARRIER_BIT = 4;
/*     */   
/*     */   public static final int GL_TEXTURE_FETCH_BARRIER_BIT = 8;
/*     */   
/*     */   public static final int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT = 32;
/*     */   
/*     */   public static final int GL_COMMAND_BARRIER_BIT = 64;
/*     */   
/*     */   public static final int GL_PIXEL_BUFFER_BARRIER_BIT = 128;
/*     */   
/*     */   public static final int GL_TEXTURE_UPDATE_BARRIER_BIT = 256;
/*     */   
/*     */   public static final int GL_BUFFER_UPDATE_BARRIER_BIT = 512;
/*     */   
/*     */   public static final int GL_FRAMEBUFFER_BARRIER_BIT = 1024;
/*     */   
/*     */   public static final int GL_TRANSFORM_FEEDBACK_BARRIER_BIT = 2048;
/*     */   
/*     */   public static final int GL_ATOMIC_COUNTER_BARRIER_BIT = 4096;
/*     */   
/*     */   public static final int GL_ALL_BARRIER_BITS = -1;
/*     */   
/*     */   public static final int GL_IMAGE_1D = 36940;
/*     */   
/*     */   public static final int GL_IMAGE_2D = 36941;
/*     */   
/*     */   public static final int GL_IMAGE_3D = 36942;
/*     */   
/*     */   public static final int GL_IMAGE_2D_RECT = 36943;
/*     */   
/*     */   public static final int GL_IMAGE_CUBE = 36944;
/*     */   
/*     */   public static final int GL_IMAGE_BUFFER = 36945;
/*     */   
/*     */   public static final int GL_IMAGE_1D_ARRAY = 36946;
/*     */   
/*     */   public static final int GL_IMAGE_2D_ARRAY = 36947;
/*     */   
/*     */   public static final int GL_IMAGE_CUBE_MAP_ARRAY = 36948;
/*     */   
/*     */   public static final int GL_IMAGE_2D_MULTISAMPLE = 36949;
/*     */   
/*     */   public static final int GL_IMAGE_2D_MULTISAMPLE_ARRAY = 36950;
/*     */   
/*     */   public static final int GL_INT_IMAGE_1D = 36951;
/*     */   public static final int GL_INT_IMAGE_2D = 36952;
/*     */   public static final int GL_INT_IMAGE_3D = 36953;
/*     */   public static final int GL_INT_IMAGE_2D_RECT = 36954;
/*     */   public static final int GL_INT_IMAGE_CUBE = 36955;
/*     */   public static final int GL_INT_IMAGE_BUFFER = 36956;
/*     */   public static final int GL_INT_IMAGE_1D_ARRAY = 36957;
/*     */   public static final int GL_INT_IMAGE_2D_ARRAY = 36958;
/*     */   public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 36959;
/*     */   public static final int GL_INT_IMAGE_2D_MULTISAMPLE = 36960;
/*     */   public static final int GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 36961;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_1D = 36962;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_2D = 36963;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_3D = 36964;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_2D_RECT = 36965;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_CUBE = 36966;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 36967;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_1D_ARRAY = 36968;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_2D_ARRAY = 36969;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 36970;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = 36971;
/*     */   public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 36972;
/*     */   public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 37063;
/*     */   public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = 37064;
/*     */   public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 37065;
/*     */   public static final int GL_NUM_SAMPLE_COUNTS = 37760;
/*     */   public static final int GL_MIN_MAP_BUFFER_ALIGNMENT = 37052;
/*     */   
/*     */   protected GL42() {
/* 209 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetActiveAtomicCounterBufferiv(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
/* 216 */     GL42C.nglGetActiveAtomicCounterBufferiv(paramInt1, paramInt2, paramInt3, paramLong);
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
/*     */   public static void glGetActiveAtomicCounterBufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 230 */     GL42C.glGetActiveAtomicCounterBufferiv(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*     */   public static int glGetActiveAtomicCounterBufferi(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 244 */     return GL42C.glGetActiveAtomicCounterBufferi(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glTexStorage1D(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 260 */     GL42C.glTexStorage1D(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glTexStorage2D(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 277 */     GL42C.glTexStorage2D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glTexStorage3D(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 295 */     GL42C.glTexStorage3D(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*     */   public static void glDrawTransformFeedbackInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 310 */     GL42C.glDrawTransformFeedbackInstanced(paramInt1, paramInt2, paramInt3);
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
/*     */   public static void glDrawTransformFeedbackStreamInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 326 */     GL42C.glDrawTransformFeedbackStreamInstanced(paramInt1, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glDrawArraysInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 343 */     GL42C.glDrawArraysInstancedBaseInstance(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void nglDrawElementsInstancedBaseInstance(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5) {
/* 355 */     GL42C.nglDrawElementsInstancedBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
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
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 371 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
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
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 386 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4);
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
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 400 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramByteBuffer, paramInt2, paramInt3);
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
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 414 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramShortBuffer, paramInt2, paramInt3);
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
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 428 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramIntBuffer, paramInt2, paramInt3);
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
/*     */   public static void nglDrawElementsInstancedBaseVertexBaseInstance(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6) {
/* 440 */     GL42C.nglDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6);
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
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLuint") int paramInt6) {
/* 457 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6);
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
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 473 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 488 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramByteBuffer, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 503 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramShortBuffer, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 518 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramIntBuffer, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glBindImageTexture(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLboolean") boolean paramBoolean, @NativeType("GLint") int paramInt4, @NativeType("GLenum") int paramInt5, @NativeType("GLenum") int paramInt6) {
/* 537 */     GL42C.glBindImageTexture(paramInt1, paramInt2, paramInt3, paramBoolean, paramInt4, paramInt5, paramInt6);
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
/*     */   public static void glMemoryBarrier(@NativeType("GLbitfield") int paramInt) {
/* 550 */     GL42C.glMemoryBarrier(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglGetInternalformativ(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong) {
/* 561 */     GL42C.nglGetInternalformativ(paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
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
/*     */   public static void glGetInternalformativ(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 575 */     GL42C.glGetInternalformativ(paramInt1, paramInt2, paramInt3, paramIntBuffer);
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
/*     */   public static int glGetInternalformati(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/* 589 */     return GL42C.glGetInternalformati(paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetActiveAtomicCounterBufferiv(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 598 */     GL42C.glGetActiveAtomicCounterBufferiv(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetInternalformativ(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLint *") int[] paramArrayOfint) {
/* 607 */     GL42C.glGetInternalformativ(paramInt1, paramInt2, paramInt3, paramArrayOfint);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL42.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */