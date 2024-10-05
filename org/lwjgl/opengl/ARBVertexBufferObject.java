/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBVertexBufferObject
/*     */ {
/*     */   public static final int GL_ARRAY_BUFFER_ARB = 34962;
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER_ARB = 34963;
/*     */   public static final int GL_ARRAY_BUFFER_BINDING_ARB = 34964;
/*     */   public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING_ARB = 34965;
/*     */   public static final int GL_VERTEX_ARRAY_BUFFER_BINDING_ARB = 34966;
/*     */   public static final int GL_NORMAL_ARRAY_BUFFER_BINDING_ARB = 34967;
/*     */   public static final int GL_COLOR_ARRAY_BUFFER_BINDING_ARB = 34968;
/*     */   public static final int GL_INDEX_ARRAY_BUFFER_BINDING_ARB = 34969;
/*     */   public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING_ARB = 34970;
/*     */   public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING_ARB = 34971;
/*     */   public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING_ARB = 34972;
/*     */   public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING_ARB = 34973;
/*     */   public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING_ARB = 34974;
/*     */   public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING_ARB = 34975;
/*     */   public static final int GL_STREAM_DRAW_ARB = 35040;
/*     */   public static final int GL_STREAM_READ_ARB = 35041;
/*     */   public static final int GL_STREAM_COPY_ARB = 35042;
/*     */   public static final int GL_STATIC_DRAW_ARB = 35044;
/*     */   public static final int GL_STATIC_READ_ARB = 35045;
/*     */   public static final int GL_STATIC_COPY_ARB = 35046;
/*     */   public static final int GL_DYNAMIC_DRAW_ARB = 35048;
/*     */   public static final int GL_DYNAMIC_READ_ARB = 35049;
/*     */   public static final int GL_DYNAMIC_COPY_ARB = 35050;
/*     */   public static final int GL_READ_ONLY_ARB = 35000;
/*     */   public static final int GL_WRITE_ONLY_ARB = 35001;
/*     */   public static final int GL_READ_WRITE_ARB = 35002;
/*     */   public static final int GL_BUFFER_SIZE_ARB = 34660;
/*     */   public static final int GL_BUFFER_USAGE_ARB = 34661;
/*     */   public static final int GL_BUFFER_ACCESS_ARB = 35003;
/*     */   public static final int GL_BUFFER_MAPPED_ARB = 35004;
/*     */   public static final int GL_BUFFER_MAP_POINTER_ARB = 35005;
/*     */   
/*     */   static {
/*  61 */     GL.initialize();
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
/*     */   protected ARBVertexBufferObject() {
/* 117 */     throw new UnsupportedOperationException();
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
/*     */   public static void glDeleteBuffersARB(@NativeType("GLuint const *") IntBuffer paramIntBuffer) {
/* 145 */     nglDeleteBuffersARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   public static void glDeleteBuffersARB(@NativeType("GLuint const *") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 150 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 152 */       IntBuffer intBuffer = memoryStack.ints(paramInt);
/* 153 */       nglDeleteBuffersARB(1, MemoryUtil.memAddress(intBuffer)); return;
/*     */     } finally {
/* 155 */       memoryStack.setPointer(i);
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
/*     */   public static void glGenBuffersARB(@NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 174 */     nglGenBuffersARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGenBuffersARB() {
/*     */     MemoryStack memoryStack;
/* 180 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 182 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 183 */       nglGenBuffersARB(1, MemoryUtil.memAddress(intBuffer));
/* 184 */       return intBuffer.get(0);
/*     */     } finally {
/* 186 */       memoryStack.setPointer(i);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("GLsizeiptrARB") long paramLong, @NativeType("GLenum") int paramInt2) {
/* 236 */     nglBufferDataARB(paramInt1, paramLong, 0L, paramInt2);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLenum") int paramInt2) {
/* 266 */     nglBufferDataARB(paramInt1, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer), paramInt2);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLenum") int paramInt2) {
/* 296 */     nglBufferDataARB(paramInt1, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLenum") int paramInt2) {
/* 326 */     nglBufferDataARB(paramInt1, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") FloatBuffer paramFloatBuffer, @NativeType("GLenum") int paramInt2) {
/* 356 */     nglBufferDataARB(paramInt1, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer), paramInt2);
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
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") DoubleBuffer paramDoubleBuffer, @NativeType("GLenum") int paramInt2) {
/* 386 */     nglBufferDataARB(paramInt1, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer), paramInt2);
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
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") ByteBuffer paramByteBuffer) {
/* 406 */     nglBufferSubDataARB(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") ShortBuffer paramShortBuffer) {
/* 417 */     nglBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") IntBuffer paramIntBuffer) {
/* 428 */     nglBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") FloatBuffer paramFloatBuffer) {
/* 439 */     nglBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") DoubleBuffer paramDoubleBuffer) {
/* 450 */     nglBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") ByteBuffer paramByteBuffer) {
/* 470 */     nglGetBufferSubDataARB(paramInt, paramLong, paramByteBuffer.remaining(), MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") ShortBuffer paramShortBuffer) {
/* 481 */     nglGetBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, MemoryUtil.memAddress(paramShortBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") IntBuffer paramIntBuffer) {
/* 492 */     nglGetBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") FloatBuffer paramFloatBuffer) {
/* 503 */     nglGetBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, MemoryUtil.memAddress(paramFloatBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/* 514 */     nglGetBufferSubDataARB(paramInt, paramLong, Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, MemoryUtil.memAddress(paramDoubleBuffer));
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     long l;
/* 540 */     return MemoryUtil.memByteBufferSafe(l = nglMapBufferARB(paramInt1, paramInt2), glGetBufferParameteriARB(paramInt1, 34660));
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, ByteBuffer paramByteBuffer) {
/* 560 */     long l = nglMapBufferARB(paramInt1, paramInt2);
/* 561 */     paramInt1 = glGetBufferParameteriARB(paramInt1, 34660);
/* 562 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, paramInt1);
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
/*     */   @NativeType("void *")
/*     */   public static ByteBuffer glMapBufferARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, long paramLong, ByteBuffer paramByteBuffer) {
/* 582 */     long l = nglMapBufferARB(paramInt1, paramInt2);
/* 583 */     return APIUtil.apiGetMappedBuffer(paramByteBuffer, l, (int)paramLong);
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
/*     */   public static void glGetBufferParameterivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 614 */     if (Checks.CHECKS) {
/* 615 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 617 */     nglGetBufferParameterivARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static int glGetBufferParameteriARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 628 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 630 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/* 631 */       nglGetBufferParameterivARB(paramInt1, paramInt2, MemoryUtil.memAddress(intBuffer));
/* 632 */       paramInt1 = intBuffer.get(0); return paramInt1;
/*     */     } finally {
/* 634 */       memoryStack.setPointer(i);
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
/*     */   public static void glGetBufferPointervARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void **") PointerBuffer paramPointerBuffer) {
/* 651 */     if (Checks.CHECKS) {
/* 652 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/* 654 */     nglGetBufferPointervARB(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void")
/*     */   public static long glGetBufferPointerARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/*     */     MemoryStack memoryStack;
/* 665 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 667 */       PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
/* 668 */       nglGetBufferPointervARB(paramInt1, paramInt2, MemoryUtil.memAddress((CustomBuffer)pointerBuffer));
/* 669 */       return pointerBuffer.get(0);
/*     */     } finally {
/* 671 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glDeleteBuffersARB(@NativeType("GLuint const *") int[] paramArrayOfint) {
/* 677 */     long l = (GL.getICD()).glDeleteBuffersARB;
/* 678 */     if (Checks.CHECKS) {
/* 679 */       Checks.check(l);
/*     */     }
/* 681 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGenBuffersARB(@NativeType("GLuint *") int[] paramArrayOfint) {
/* 686 */     long l = (GL.getICD()).glGenBuffersARB;
/* 687 */     if (Checks.CHECKS) {
/* 688 */       Checks.check(l);
/*     */     }
/* 690 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") short[] paramArrayOfshort, @NativeType("GLenum") int paramInt2) {
/* 695 */     long l = (GL.getICD()).glBufferDataARB;
/* 696 */     if (Checks.CHECKS) {
/* 697 */       Checks.check(l);
/*     */     }
/* 699 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLenum") int paramInt2) {
/* 704 */     long l = (GL.getICD()).glBufferDataARB;
/* 705 */     if (Checks.CHECKS) {
/* 706 */       Checks.check(l);
/*     */     }
/* 708 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") float[] paramArrayOffloat, @NativeType("GLenum") int paramInt2) {
/* 713 */     long l = (GL.getICD()).glBufferDataARB;
/* 714 */     if (Checks.CHECKS) {
/* 715 */       Checks.check(l);
/*     */     }
/* 717 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferDataARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") double[] paramArrayOfdouble, @NativeType("GLenum") int paramInt2) {
/* 722 */     long l = (GL.getICD()).glBufferDataARB;
/* 723 */     if (Checks.CHECKS) {
/* 724 */       Checks.check(l);
/*     */     }
/* 726 */     JNI.callPPV(paramInt1, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, paramInt2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") short[] paramArrayOfshort) {
/* 731 */     long l = (GL.getICD()).glBufferSubDataARB;
/* 732 */     if (Checks.CHECKS) {
/* 733 */       Checks.check(l);
/*     */     }
/* 735 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") int[] paramArrayOfint) {
/* 740 */     long l = (GL.getICD()).glBufferSubDataARB;
/* 741 */     if (Checks.CHECKS) {
/* 742 */       Checks.check(l);
/*     */     }
/* 744 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") float[] paramArrayOffloat) {
/* 749 */     long l = (GL.getICD()).glBufferSubDataARB;
/* 750 */     if (Checks.CHECKS) {
/* 751 */       Checks.check(l);
/*     */     }
/* 753 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void const *") double[] paramArrayOfdouble) {
/* 758 */     long l = (GL.getICD()).glBufferSubDataARB;
/* 759 */     if (Checks.CHECKS) {
/* 760 */       Checks.check(l);
/*     */     }
/* 762 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") short[] paramArrayOfshort) {
/* 767 */     long l = (GL.getICD()).glGetBufferSubDataARB;
/* 768 */     if (Checks.CHECKS) {
/* 769 */       Checks.check(l);
/*     */     }
/* 771 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfshort.length) << 1L, paramArrayOfshort, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") int[] paramArrayOfint) {
/* 776 */     long l = (GL.getICD()).glGetBufferSubDataARB;
/* 777 */     if (Checks.CHECKS) {
/* 778 */       Checks.check(l);
/*     */     }
/* 780 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfint.length) << 2L, paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") float[] paramArrayOffloat) {
/* 785 */     long l = (GL.getICD()).glGetBufferSubDataARB;
/* 786 */     if (Checks.CHECKS) {
/* 787 */       Checks.check(l);
/*     */     }
/* 789 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOffloat.length) << 2L, paramArrayOffloat, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferSubDataARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptrARB") long paramLong, @NativeType("void *") double[] paramArrayOfdouble) {
/* 794 */     long l = (GL.getICD()).glGetBufferSubDataARB;
/* 795 */     if (Checks.CHECKS) {
/* 796 */       Checks.check(l);
/*     */     }
/* 798 */     JNI.callPPPV(paramInt, paramLong, Integer.toUnsignedLong(paramArrayOfdouble.length) << 3L, paramArrayOfdouble, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glGetBufferParameterivARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 803 */     long l = (GL.getICD()).glGetBufferParameterivARB;
/* 804 */     if (Checks.CHECKS) {
/* 805 */       Checks.check(l);
/* 806 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 808 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void glBindBufferARB(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2);
/*     */   
/*     */   public static native void nglDeleteBuffersARB(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglGenBuffersARB(int paramInt, long paramLong);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glIsBufferARB(@NativeType("GLuint") int paramInt);
/*     */   
/*     */   public static native void nglBufferDataARB(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
/*     */   
/*     */   public static native void nglBufferSubDataARB(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nglGetBufferSubDataARB(int paramInt, long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native long nglMapBufferARB(int paramInt1, int paramInt2);
/*     */   
/*     */   @NativeType("GLboolean")
/*     */   public static native boolean glUnmapBufferARB(@NativeType("GLenum") int paramInt);
/*     */   
/*     */   public static native void nglGetBufferParameterivARB(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglGetBufferPointervARB(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBVertexBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */