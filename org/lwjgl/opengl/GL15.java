/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL15
/*      */   extends GL14
/*      */ {
/*      */   public static final int GL_FOG_COORD_SRC = 33872;
/*      */   public static final int GL_FOG_COORD = 33873;
/*      */   public static final int GL_CURRENT_FOG_COORD = 33875;
/*      */   public static final int GL_FOG_COORD_ARRAY_TYPE = 33876;
/*      */   public static final int GL_FOG_COORD_ARRAY_STRIDE = 33877;
/*      */   public static final int GL_FOG_COORD_ARRAY_POINTER = 33878;
/*      */   public static final int GL_FOG_COORD_ARRAY = 33879;
/*      */   public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 34973;
/*      */   public static final int GL_SRC0_RGB = 34176;
/*      */   public static final int GL_SRC1_RGB = 34177;
/*      */   public static final int GL_SRC2_RGB = 34178;
/*      */   public static final int GL_SRC0_ALPHA = 34184;
/*      */   
/*      */   static {
/*   29 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SRC1_ALPHA = 34185;
/*      */ 
/*      */   
/*      */   public static final int GL_SRC2_ALPHA = 34186;
/*      */ 
/*      */   
/*      */   public static final int GL_ARRAY_BUFFER = 34962;
/*      */ 
/*      */   
/*      */   public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
/*      */   
/*      */   public static final int GL_ARRAY_BUFFER_BINDING = 34964;
/*      */   
/*      */   public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
/*      */   
/*      */   public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 34966;
/*      */   
/*      */   public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 34967;
/*      */   
/*      */   public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 34968;
/*      */   
/*      */   public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 34969;
/*      */   
/*      */   public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 34970;
/*      */   
/*      */   public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 34971;
/*      */   
/*      */   public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 34972;
/*      */   
/*      */   public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 34973;
/*      */   
/*      */   public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 34974;
/*      */   
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
/*      */   
/*      */   public static final int GL_STREAM_DRAW = 35040;
/*      */   
/*      */   public static final int GL_STREAM_READ = 35041;
/*      */   
/*      */   public static final int GL_STREAM_COPY = 35042;
/*      */   
/*      */   public static final int GL_STATIC_DRAW = 35044;
/*      */   
/*      */   public static final int GL_STATIC_READ = 35045;
/*      */   
/*      */   public static final int GL_STATIC_COPY = 35046;
/*      */   
/*      */   public static final int GL_DYNAMIC_DRAW = 35048;
/*      */   
/*      */   public static final int GL_DYNAMIC_READ = 35049;
/*      */   
/*      */   public static final int GL_DYNAMIC_COPY = 35050;
/*      */   
/*      */   public static final int GL_READ_ONLY = 35000;
/*      */   
/*      */   public static final int GL_WRITE_ONLY = 35001;
/*      */   
/*      */   public static final int GL_READ_WRITE = 35002;
/*      */   
/*      */   public static final int GL_BUFFER_SIZE = 34660;
/*      */   
/*      */   public static final int GL_BUFFER_USAGE = 34661;
/*      */   
/*      */   public static final int GL_BUFFER_ACCESS = 35003;
/*      */   
/*      */   public static final int GL_BUFFER_MAPPED = 35004;
/*      */   
/*      */   public static final int GL_BUFFER_MAP_POINTER = 35005;
/*      */   
/*      */   public static final int GL_SAMPLES_PASSED = 35092;
/*      */   
/*      */   public static final int GL_QUERY_COUNTER_BITS = 34916;
/*      */   
/*      */   public static final int GL_CURRENT_QUERY = 34917;
/*      */   
/*      */   public static final int GL_QUERY_RESULT = 34918;
/*      */   
/*      */   public static final int GL_QUERY_RESULT_AVAILABLE = 34919;
/*      */ 
/*      */   
/*      */   protected GL15() {
/*  115 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBindBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  129 */     GL15C.glBindBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteBuffers(int paramInt, long paramLong) {
/*  140 */     GL15C.nglDeleteBuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteBuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  151 */     GL15C.glDeleteBuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteBuffers(@NativeType("GLuint const *") int paramInt) {
/*  160 */     GL15C.glDeleteBuffers(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenBuffers(int paramInt, long paramLong) {
/*  171 */     GL15C.nglGenBuffers(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenBuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  182 */     GL15C.glGenBuffers(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenBuffers() {
/*  192 */     return GL15C.glGenBuffers();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsBuffer(@NativeType("GLuint") int paramInt) {
/*  206 */     return GL15C.glIsBuffer(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBufferData(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {
/*  217 */     GL15C.nglBufferData(paramInt1, paramLong1, paramLong2, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("GLsizeiptr") long paramLong, @NativeType("GLenum") int paramInt2) {
/*  249 */     GL15C.glBufferData(paramInt1, paramLong, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2) {
/*  281 */     GL15C.glBufferData(paramInt1, paramByteBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLenum") int paramInt2) {
/*  313 */     GL15C.glBufferData(paramInt1, paramShortBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2) {
/*  345 */     GL15C.glBufferData(paramInt1, paramIntBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") LongBuffer paramLongBuffer, @NativeType("GLenum") int paramInt2) {
/*  377 */     GL15C.glBufferData(paramInt1, paramLongBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLenum") int paramInt2) {
/*  409 */     GL15C.glBufferData(paramInt1, paramFloatBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLenum") int paramInt2) {
/*  441 */     GL15C.glBufferData(paramInt1, paramDoubleBuffer, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3) {
/*  452 */     GL15C.nglBufferSubData(paramInt, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  465 */     GL15C.glBufferSubData(paramInt, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/*  478 */     GL15C.glBufferSubData(paramInt, paramLong, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") IntBuffer paramIntBuffer) {
/*  491 */     GL15C.glBufferSubData(paramInt, paramLong, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") LongBuffer paramLongBuffer) {
/*  504 */     GL15C.glBufferSubData(paramInt, paramLong, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/*  517 */     GL15C.glBufferSubData(paramInt, paramLong, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/*  530 */     GL15C.glBufferSubData(paramInt, paramLong, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3) {
/*  541 */     GL15C.nglGetBufferSubData(paramInt, paramLong1, paramLong2, paramLong3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  554 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ShortBuffer paramShortBuffer) {
/*  567 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramShortBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") IntBuffer paramIntBuffer) {
/*  580 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") LongBuffer paramLongBuffer) {
/*  593 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramLongBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  606 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramFloatBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/*  619 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramDoubleBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nglMapBuffer(int paramInt1, int paramInt2) {
/*  626 */     return GL15C.nglMapBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  648 */     return GL15C.glMapBuffer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, ByteBuffer paramByteBuffer) {
/*  670 */     return GL15C.glMapBuffer(paramInt1, paramInt2, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, long paramLong, ByteBuffer paramByteBuffer) {
/*  692 */     return GL15C.glMapBuffer(paramInt1, paramInt2, paramLong, paramByteBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glUnmapBuffer(@NativeType("GLenum") int paramInt) {
/*  711 */     return GL15C.glUnmapBuffer(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBufferParameteriv(int paramInt1, int paramInt2, long paramLong) {
/*  718 */     GL15C.nglGetBufferParameteriv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  731 */     GL15C.glGetBufferParameteriv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetBufferParameteri(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  744 */     return GL15C.glGetBufferParameteri(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetBufferPointerv(int paramInt1, int paramInt2, long paramLong) {
/*  751 */     GL15C.nglGetBufferPointerv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferPointerv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  764 */     GL15C.glGetBufferPointerv(paramInt1, paramInt2, paramPointerBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static long glGetBufferPointer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  777 */     return GL15C.glGetBufferPointer(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGenQueries(int paramInt, long paramLong) {
/*  788 */     GL15C.nglGenQueries(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenQueries(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  799 */     GL15C.glGenQueries(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenQueries() {
/*  809 */     return GL15C.glGenQueries();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglDeleteQueries(int paramInt, long paramLong) {
/*  820 */     GL15C.nglDeleteQueries(paramInt, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteQueries(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  831 */     GL15C.glDeleteQueries(paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteQueries(@NativeType("GLuint const *") int paramInt) {
/*  840 */     GL15C.glDeleteQueries(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static boolean glIsQuery(@NativeType("GLuint") int paramInt) {
/*  854 */     return GL15C.glIsQuery(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBeginQuery(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  868 */     GL15C.glBeginQuery(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glEndQuery(@NativeType("GLenum") int paramInt) {
/*  881 */     GL15C.glEndQuery(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetQueryiv(int paramInt1, int paramInt2, long paramLong) {
/*  888 */     GL15C.nglGetQueryiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  901 */     GL15C.glGetQueryiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetQueryi(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  914 */     return GL15C.glGetQueryi(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetQueryObjectiv(int paramInt1, int paramInt2, long paramLong) {
/*  921 */     GL15C.nglGetQueryObjectiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  934 */     GL15C.glGetQueryObjectiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") long paramLong) {
/*  947 */     GL15C.glGetQueryObjectiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetQueryObjecti(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*  960 */     return GL15C.glGetQueryObjecti(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nglGetQueryObjectuiv(int paramInt1, int paramInt2, long paramLong) {
/*  967 */     GL15C.nglGetQueryObjectuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  980 */     GL15C.glGetQueryObjectuiv(paramInt1, paramInt2, paramIntBuffer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") long paramLong) {
/*  993 */     GL15C.glGetQueryObjectuiv(paramInt1, paramInt2, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGetQueryObjectui(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 1006 */     return GL15C.glGetQueryObjectui(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteBuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1015 */     GL15C.glDeleteBuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenBuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1024 */     GL15C.glGenBuffers(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 1033 */     GL15C.glBufferData(paramInt1, paramArrayOfshort, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 1042 */     GL15C.glBufferData(paramInt1, paramArrayOfint, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long[] paramArrayOflong, @NativeType("GLenum") int paramInt2) {
/* 1051 */     GL15C.glBufferData(paramInt1, paramArrayOflong, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 1060 */     GL15C.glBufferData(paramInt1, paramArrayOffloat, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 1069 */     GL15C.glBufferData(paramInt1, paramArrayOfdouble, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1078 */     GL15C.glBufferSubData(paramInt, paramLong, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 1087 */     GL15C.glBufferSubData(paramInt, paramLong, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") long[] paramArrayOflong) {
/* 1096 */     GL15C.glBufferSubData(paramInt, paramLong, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1105 */     GL15C.glBufferSubData(paramInt, paramLong, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 1114 */     GL15C.glBufferSubData(paramInt, paramLong, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 1123 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramArrayOfshort);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 1132 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") long[] paramArrayOflong) {
/* 1141 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramArrayOflong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 1150 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramArrayOffloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 1159 */     GL15C.glGetBufferSubData(paramInt, paramLong, paramArrayOfdouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1168 */     GL15C.glGetBufferParameteriv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenQueries(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1177 */     GL15C.glGenQueries(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteQueries(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1186 */     GL15C.glDeleteQueries(paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1195 */     GL15C.glGetQueryiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1204 */     GL15C.glGetQueryObjectiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1213 */     GL15C.glGetQueryObjectuiv(paramInt1, paramInt2, paramArrayOfint);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL15.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */