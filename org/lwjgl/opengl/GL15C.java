/*      */ package org.lwjgl.opengl;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.DoubleBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.LongBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.APIUtil;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ public class GL15C extends GL14C {
/*      */   public static final int GL_SRC1_ALPHA = 34185;
/*      */   public static final int GL_ARRAY_BUFFER = 34962;
/*      */   public static final int GL_ELEMENT_ARRAY_BUFFER = 34963;
/*      */   public static final int GL_ARRAY_BUFFER_BINDING = 34964;
/*      */   public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 34965;
/*      */   public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 34975;
/*      */   public static final int GL_STREAM_DRAW = 35040;
/*      */   public static final int GL_STREAM_READ = 35041;
/*      */   public static final int GL_STREAM_COPY = 35042;
/*      */   public static final int GL_STATIC_DRAW = 35044;
/*      */   public static final int GL_STATIC_READ = 35045;
/*      */   public static final int GL_STATIC_COPY = 35046;
/*      */   public static final int GL_DYNAMIC_DRAW = 35048;
/*      */   public static final int GL_DYNAMIC_READ = 35049;
/*      */   
/*      */   static {
/*   35 */     GL.initialize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_DYNAMIC_COPY = 35050;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_READ_ONLY = 35000;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_WRITE_ONLY = 35001;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_READ_WRITE = 35002;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BUFFER_SIZE = 34660;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BUFFER_USAGE = 34661;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BUFFER_ACCESS = 35003;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BUFFER_MAPPED = 35004;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_BUFFER_MAP_POINTER = 35005;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_SAMPLES_PASSED = 35092;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_QUERY_COUNTER_BITS = 34916;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_CURRENT_QUERY = 34917;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_QUERY_RESULT = 34918;
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int GL_QUERY_RESULT_AVAILABLE = 34919;
/*      */ 
/*      */ 
/*      */   
/*      */   protected GL15C() {
/*   98 */     throw new UnsupportedOperationException();
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
/*      */   public static void glDeleteBuffers(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  130 */     nglDeleteBuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteBuffers(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  139 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  141 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  142 */       nglDeleteBuffers(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  144 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGenBuffers(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  165 */     nglGenBuffers(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenBuffers() {
/*      */     MemoryStack memoryStack;
/*  175 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  177 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  178 */       nglGenBuffers(1, MemoryUtil.memAddress(intBuffer));
/*  179 */       return intBuffer.get(0);
/*      */     } finally {
/*  181 */       memoryStack.setPointer(i);
/*      */     } 
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
/*  235 */     nglBufferData(paramInt1, paramLong, 0L, paramInt2);
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
/*  267 */     nglBufferData(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
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
/*  299 */     nglBufferData(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
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
/*  331 */     nglBufferData(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
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
/*  363 */     nglBufferData(paramInt1, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramLongBuffer), paramInt2);
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
/*  395 */     nglBufferData(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
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
/*  427 */     nglBufferData(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
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
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  449 */     nglBufferSubData(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*  462 */     nglBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
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
/*  475 */     nglBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
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
/*  488 */     nglBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramLongBuffer));
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
/*  501 */     nglBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
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
/*  514 */     nglBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/*  536 */     nglGetBufferSubData(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
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
/*  549 */     nglGetBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
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
/*  562 */     nglGetBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
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
/*  575 */     nglGetBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramLongBuffer));
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
/*  588 */     nglGetBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
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
/*  601 */     nglGetBufferSubData(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer glMapBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*      */     long l;
/*  629 */     return MemoryUtil.memByteBufferSafe(l = nglMapBuffer(paramInt1, paramInt2), glGetBufferParameteri(paramInt1, 34660));
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
/*  651 */     long l = nglMapBuffer(paramInt1, paramInt2);
/*  652 */     paramInt1 = glGetBufferParameteri(paramInt1, 34660);
/*  653 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, paramInt1);
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
/*  675 */     long l = nglMapBuffer(paramInt1, paramInt2);
/*  676 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  711 */     if (Checks.CHECKS) {
/*  712 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  714 */     nglGetBufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  727 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  729 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  730 */       nglGetBufferParameteriv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  731 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  733 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetBufferPointerv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/*  752 */     if (Checks.CHECKS) {
/*  753 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  755 */     nglGetBufferPointerv(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  768 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  770 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/*  771 */       nglGetBufferPointerv(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/*  772 */       return pointerBuffer.get(0);
/*      */     } finally {
/*  774 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGenQueries(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  795 */     nglGenQueries(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void")
/*      */   public static int glGenQueries() {
/*      */     MemoryStack memoryStack;
/*  805 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  807 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  808 */       nglGenQueries(1, MemoryUtil.memAddress(intBuffer));
/*  809 */       return intBuffer.get(0);
/*      */     } finally {
/*  811 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glDeleteQueries(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/*  832 */     nglDeleteQueries(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteQueries(@NativeType("GLuint const *") int paramInt) {
/*      */     MemoryStack memoryStack;
/*  841 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  843 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/*  844 */       nglDeleteQueries(1, MemoryUtil.memAddress(intBuffer)); return;
/*      */     } finally {
/*  846 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetQueryiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  900 */     if (Checks.CHECKS) {
/*  901 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  903 */     nglGetQueryiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  916 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  918 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  919 */       nglGetQueryiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  920 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  922 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetQueryObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/*  941 */     if (Checks.CHECKS) {
/*  942 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  944 */     nglGetQueryObjectiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/*  957 */     nglGetQueryObjectiv(paramInt1, paramInt2, paramLong);
/*      */   }
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
/*      */     MemoryStack memoryStack;
/*  970 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  972 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*  973 */       nglGetQueryObjectiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/*  974 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/*  976 */       memoryStack.setPointer(i);
/*      */     } 
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
/*      */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/*  995 */     if (Checks.CHECKS) {
/*  996 */       Checks.check(paramIntBuffer, 1);
/*      */     }
/*  998 */     nglGetQueryObjectuiv(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
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
/* 1011 */     nglGetQueryObjectuiv(paramInt1, paramInt2, paramLong);
/*      */   }
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
/*      */     MemoryStack memoryStack;
/* 1024 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1026 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 1027 */       nglGetQueryObjectuiv(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 1028 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*      */     } finally {
/* 1030 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteBuffers(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1040 */     long l = (GL.getICD()).glDeleteBuffers;
/* 1041 */     if (Checks.CHECKS) {
/* 1042 */       Checks.check(l);
/*      */     }
/* 1044 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenBuffers(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1053 */     long l = (GL.getICD()).glGenBuffers;
/* 1054 */     if (Checks.CHECKS) {
/* 1055 */       Checks.check(l);
/*      */     }
/* 1057 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 1066 */     long l = (GL.getICD()).glBufferData;
/* 1067 */     if (Checks.CHECKS) {
/* 1068 */       Checks.check(l);
/*      */     }
/* 1070 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 1079 */     long l = (GL.getICD()).glBufferData;
/* 1080 */     if (Checks.CHECKS) {
/* 1081 */       Checks.check(l);
/*      */     }
/* 1083 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long[] paramArrayOflong, @NativeType("GLenum") int paramInt2) {
/* 1092 */     long l = (GL.getICD()).glBufferData;
/* 1093 */     if (Checks.CHECKS) {
/* 1094 */       Checks.check(l);
/*      */     }
/* 1096 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOflong.length) << 3L, paramArrayOflong, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 1105 */     long l = (GL.getICD()).glBufferData;
/* 1106 */     if (Checks.CHECKS) {
/* 1107 */       Checks.check(l);
/*      */     }
/* 1109 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferData(@NativeType("GLenum") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 1118 */     long l = (GL.getICD()).glBufferData;
/* 1119 */     if (Checks.CHECKS) {
/* 1120 */       Checks.check(l);
/*      */     }
/* 1122 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 1131 */     long l = (GL.getICD()).glBufferSubData;
/* 1132 */     if (Checks.CHECKS) {
/* 1133 */       Checks.check(l);
/*      */     }
/* 1135 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 1144 */     long l = (GL.getICD()).glBufferSubData;
/* 1145 */     if (Checks.CHECKS) {
/* 1146 */       Checks.check(l);
/*      */     }
/* 1148 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") long[] paramArrayOflong) {
/* 1157 */     long l = (GL.getICD()).glBufferSubData;
/* 1158 */     if (Checks.CHECKS) {
/* 1159 */       Checks.check(l);
/*      */     }
/* 1161 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOflong.length) << 3L, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 1170 */     long l = (GL.getICD()).glBufferSubData;
/* 1171 */     if (Checks.CHECKS) {
/* 1172 */       Checks.check(l);
/*      */     }
/* 1174 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 1183 */     long l = (GL.getICD()).glBufferSubData;
/* 1184 */     if (Checks.CHECKS) {
/* 1185 */       Checks.check(l);
/*      */     }
/* 1187 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 1196 */     long l = (GL.getICD()).glGetBufferSubData;
/* 1197 */     if (Checks.CHECKS) {
/* 1198 */       Checks.check(l);
/*      */     }
/* 1200 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 1209 */     long l = (GL.getICD()).glGetBufferSubData;
/* 1210 */     if (Checks.CHECKS) {
/* 1211 */       Checks.check(l);
/*      */     }
/* 1213 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") long[] paramArrayOflong) {
/* 1222 */     long l = (GL.getICD()).glGetBufferSubData;
/* 1223 */     if (Checks.CHECKS) {
/* 1224 */       Checks.check(l);
/*      */     }
/* 1226 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOflong.length) << 3L, paramArrayOflong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 1235 */     long l = (GL.getICD()).glGetBufferSubData;
/* 1236 */     if (Checks.CHECKS) {
/* 1237 */       Checks.check(l);
/*      */     }
/* 1239 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferSubData(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 1248 */     long l = (GL.getICD()).glGetBufferSubData;
/* 1249 */     if (Checks.CHECKS) {
/* 1250 */       Checks.check(l);
/*      */     }
/* 1252 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetBufferParameteriv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1261 */     long l = (GL.getICD()).glGetBufferParameteriv;
/* 1262 */     if (Checks.CHECKS) {
/* 1263 */       Checks.check(l);
/* 1264 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1266 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGenQueries(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 1275 */     long l = (GL.getICD()).glGenQueries;
/* 1276 */     if (Checks.CHECKS) {
/* 1277 */       Checks.check(l);
/*      */     }
/* 1279 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glDeleteQueries(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 1288 */     long l = (GL.getICD()).glDeleteQueries;
/* 1289 */     if (Checks.CHECKS) {
/* 1290 */       Checks.check(l);
/*      */     }
/* 1292 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryiv(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1301 */     long l = (GL.getICD()).glGetQueryiv;
/* 1302 */     if (Checks.CHECKS) {
/* 1303 */       Checks.check(l);
/* 1304 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1306 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 1315 */     long l = (GL.getICD()).glGetQueryObjectiv;
/* 1316 */     if (Checks.CHECKS) {
/* 1317 */       Checks.check(l);
/* 1318 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1320 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void glGetQueryObjectuiv(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 1329 */     long l = (GL.getICD()).glGetQueryObjectuiv;
/* 1330 */     if (Checks.CHECKS) {
/* 1331 */       Checks.check(l);
/* 1332 */       Checks.check(paramArrayOfint, 1);
/*      */     } 
/* 1334 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*      */   }
/*      */   
/*      */   public static native void glBindBuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void nglDeleteBuffers(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglGenBuffers(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsBuffer(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void nglBufferData(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native void nglBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void nglGetBufferSubData(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long nglMapBuffer(int paramInt1, int paramInt2);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glUnmapBuffer(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglGetBufferParameteriv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetBufferPointerv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGenQueries(int paramInt, long paramLong);
/*      */   
/*      */   public static native void nglDeleteQueries(int paramInt, long paramLong);
/*      */   
/*      */   @NativeType("GLboolean")
/*      */   public static native boolean glIsQuery(@NativeType("GLuint") int paramInt);
/*      */   
/*      */   public static native void glBeginQuery(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*      */   
/*      */   public static native void glEndQuery(@NativeType("GLenum") int paramInt);
/*      */   
/*      */   public static native void nglGetQueryiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetQueryObjectiv(int paramInt1, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void nglGetQueryObjectuiv(int paramInt1, int paramInt2, long paramLong);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GL15C.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */