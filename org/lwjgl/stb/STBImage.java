/*      */ package org.lwjgl.stb;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.FloatBuffer;
/*      */ import java.nio.IntBuffer;
/*      */ import java.nio.ShortBuffer;
/*      */ import org.lwjgl.PointerBuffer;
/*      */ import org.lwjgl.system.Checks;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class STBImage
/*      */ {
/*      */   public static final int STBI_default = 0;
/*      */   public static final int STBI_grey = 1;
/*      */   public static final int STBI_grey_alpha = 2;
/*      */   public static final int STBI_rgb = 3;
/*      */   public static final int STBI_rgb_alpha = 4;
/*      */   
/*      */   static {
/*  108 */     LibSTB.initialize();
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
/*      */   protected STBImage() {
/*  131 */     throw new UnsupportedOperationException();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  192 */     if (Checks.CHECKS) {
/*  193 */       Checks.checkNT1(paramByteBuffer);
/*  194 */       Checks.check(paramIntBuffer1, 1);
/*  195 */       Checks.check(paramIntBuffer2, 1);
/*  196 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*      */     long l;
/*  199 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  255 */     if (Checks.CHECKS) {
/*  256 */       Checks.check(paramIntBuffer1, 1);
/*  257 */       Checks.check(paramIntBuffer2, 1);
/*  258 */       Checks.check(paramIntBuffer3, 1);
/*      */     }  MemoryStack memoryStack;
/*  260 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  262 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/*  265 */       return MemoryUtil.memByteBufferSafe(l2 = nstbi_load(l1 = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
/*      */     } finally {
/*  267 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  292 */     if (Checks.CHECKS) {
/*  293 */       Checks.check(paramIntBuffer1, 1);
/*  294 */       Checks.check(paramIntBuffer2, 1);
/*  295 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*      */     long l;
/*  298 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  325 */     if (Checks.CHECKS) {
/*  326 */       Checks.check(paramIntBuffer1, 1);
/*  327 */       Checks.check(paramIntBuffer2, 1);
/*  328 */       Checks.check(paramIntBuffer3, 1);
/*  329 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*      */     long l;
/*  332 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load_gif_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int **") PointerBuffer paramPointerBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, @NativeType("int *") IntBuffer paramIntBuffer4, int paramInt) {
/*  358 */     if (Checks.CHECKS) {
/*  359 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*  360 */       Checks.check(paramIntBuffer1, 1);
/*  361 */       Checks.check(paramIntBuffer2, 1);
/*  362 */       Checks.check(paramIntBuffer3, 1);
/*  363 */       Checks.check(paramIntBuffer4, 1);
/*      */     } 
/*      */     long l;
/*  366 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load_gif_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), MemoryUtil.memAddress(paramIntBuffer4), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * paramIntBuffer3.get(paramIntBuffer3.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer4.get(paramIntBuffer4.position())));
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
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  386 */     if (Checks.CHECKS) {
/*  387 */       Checks.checkNT1(paramByteBuffer);
/*  388 */       Checks.check(paramIntBuffer1, 1);
/*  389 */       Checks.check(paramIntBuffer2, 1);
/*  390 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*      */     long l;
/*  393 */     return MemoryUtil.memShortBufferSafe(l = nstbi_load_16(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  408 */     if (Checks.CHECKS) {
/*  409 */       Checks.check(paramIntBuffer1, 1);
/*  410 */       Checks.check(paramIntBuffer2, 1);
/*  411 */       Checks.check(paramIntBuffer3, 1);
/*      */     }  MemoryStack memoryStack;
/*  413 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  415 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/*  418 */       return MemoryUtil.memShortBufferSafe(l2 = nstbi_load_16(l1 = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
/*      */     } finally {
/*  420 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  445 */     if (Checks.CHECKS) {
/*  446 */       Checks.check(paramIntBuffer1, 1);
/*  447 */       Checks.check(paramIntBuffer2, 1);
/*  448 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*      */     long l;
/*  451 */     return MemoryUtil.memShortBufferSafe(l = nstbi_load_16_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  472 */     if (Checks.CHECKS) {
/*  473 */       Checks.check(paramIntBuffer1, 1);
/*  474 */       Checks.check(paramIntBuffer2, 1);
/*  475 */       Checks.check(paramIntBuffer3, 1);
/*  476 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*      */     long l;
/*  479 */     return MemoryUtil.memShortBufferSafe(l = nstbi_load_16_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  499 */     if (Checks.CHECKS) {
/*  500 */       Checks.checkNT1(paramByteBuffer);
/*  501 */       Checks.check(paramIntBuffer1, 1);
/*  502 */       Checks.check(paramIntBuffer2, 1);
/*  503 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*      */     long l;
/*  506 */     return MemoryUtil.memFloatBufferSafe(l = nstbi_loadf(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  521 */     if (Checks.CHECKS) {
/*  522 */       Checks.check(paramIntBuffer1, 1);
/*  523 */       Checks.check(paramIntBuffer2, 1);
/*  524 */       Checks.check(paramIntBuffer3, 1);
/*      */     }  MemoryStack memoryStack;
/*  526 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  528 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/*  531 */       return MemoryUtil.memFloatBufferSafe(l2 = nstbi_loadf(l1 = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
/*      */     } finally {
/*  533 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  558 */     if (Checks.CHECKS) {
/*  559 */       Checks.check(paramIntBuffer1, 1);
/*  560 */       Checks.check(paramIntBuffer2, 1);
/*  561 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*      */     long l;
/*  564 */     return MemoryUtil.memFloatBufferSafe(l = nstbi_loadf_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3, int paramInt) {
/*  585 */     if (Checks.CHECKS) {
/*  586 */       Checks.check(paramIntBuffer1, 1);
/*  587 */       Checks.check(paramIntBuffer2, 1);
/*  588 */       Checks.check(paramIntBuffer3, 1);
/*  589 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*      */     long l;
/*  592 */     return MemoryUtil.memFloatBufferSafe(l = nstbi_loadf_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3), paramInt), paramIntBuffer1.get(paramIntBuffer1.position()) * paramIntBuffer2.get(paramIntBuffer2.position()) * ((paramInt != 0) ? paramInt : paramIntBuffer3.get(paramIntBuffer3.position())));
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_hdr(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  645 */     if (Checks.CHECKS) {
/*  646 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  648 */     return (nstbi_is_hdr(MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_hdr(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  660 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  662 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*      */         
/*  664 */         (nstbi_is_hdr(l = memoryStack.getPointerAddress()) != 0);
/*      */     } finally {
/*  666 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_hdr_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer) {
/*  686 */     return (nstbi_is_hdr_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining()) != 0);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_hdr_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong) {
/*  702 */     if (Checks.CHECKS) {
/*  703 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     }
/*  705 */     return (nstbi_is_hdr_from_callbacks(paramSTBIIOCallbacks.address(), paramLong) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char const *")
/*      */   public static String stbi_failure_reason() {
/*      */     long l;
/*  718 */     return MemoryUtil.memASCIISafe(l = nstbi_failure_reason());
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
/*      */   public static void stbi_image_free(@NativeType("void *") ByteBuffer paramByteBuffer) {
/*  732 */     nstbi_image_free(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbi_image_free(@NativeType("void *") ShortBuffer paramShortBuffer) {
/*  741 */     nstbi_image_free(MemoryUtil.memAddress(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbi_image_free(@NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  750 */     nstbi_image_free(MemoryUtil.memAddress(paramFloatBuffer));
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/*  770 */     if (Checks.CHECKS) {
/*  771 */       Checks.checkNT1(paramByteBuffer);
/*  772 */       Checks.check(paramIntBuffer1, 1);
/*  773 */       Checks.check(paramIntBuffer2, 1);
/*  774 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*  776 */     return (nstbi_info(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3)) != 0);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/*  791 */     if (Checks.CHECKS) {
/*  792 */       Checks.check(paramIntBuffer1, 1);
/*  793 */       Checks.check(paramIntBuffer2, 1);
/*  794 */       Checks.check(paramIntBuffer3, 1);
/*      */     }  MemoryStack memoryStack;
/*  796 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  798 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*      */         
/*  800 */         (nstbi_info(l = memoryStack.getPointerAddress(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3)) != 0);
/*      */     } finally {
/*  802 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/*  825 */     if (Checks.CHECKS) {
/*  826 */       Checks.check(paramIntBuffer1, 1);
/*  827 */       Checks.check(paramIntBuffer2, 1);
/*  828 */       Checks.check(paramIntBuffer3, 1);
/*      */     } 
/*  830 */     return (nstbi_info_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3)) != 0);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") IntBuffer paramIntBuffer1, @NativeType("int *") IntBuffer paramIntBuffer2, @NativeType("int *") IntBuffer paramIntBuffer3) {
/*  849 */     if (Checks.CHECKS) {
/*  850 */       Checks.check(paramIntBuffer1, 1);
/*  851 */       Checks.check(paramIntBuffer2, 1);
/*  852 */       Checks.check(paramIntBuffer3, 1);
/*  853 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*  855 */     return (nstbi_info_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2), MemoryUtil.memAddress(paramIntBuffer3)) != 0);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_16_bit(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  870 */     if (Checks.CHECKS) {
/*  871 */       Checks.checkNT1(paramByteBuffer);
/*      */     }
/*  873 */     return (nstbi_is_16_bit(MemoryUtil.memAddress(paramByteBuffer)) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_16_bit(@NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  883 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  885 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*      */         
/*  887 */         (nstbi_is_16_bit(l = memoryStack.getPointerAddress()) != 0);
/*      */     } finally {
/*  889 */       memoryStack.setPointer(i);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_16_bit_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer) {
/*  909 */     return (nstbi_is_16_bit_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining()) != 0);
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
/*      */   @NativeType("int")
/*      */   public static boolean stbi_is_16_bit_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong) {
/*  925 */     if (Checks.CHECKS) {
/*  926 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     }
/*  928 */     return (nstbi_is_16_bit_from_callbacks(paramSTBIIOCallbacks.address(), paramLong) != 0);
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
/*      */   public static void stbi_set_unpremultiply_on_load(@NativeType("int") boolean paramBoolean) {
/*  943 */     nstbi_set_unpremultiply_on_load(paramBoolean ? 1 : 0);
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
/*      */   public static void stbi_convert_iphone_png_to_rgb(@NativeType("int") boolean paramBoolean) {
/*  957 */     nstbi_convert_iphone_png_to_rgb(paramBoolean ? 1 : 0);
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
/*      */   public static void stbi_set_flip_vertically_on_load(@NativeType("int") boolean paramBoolean) {
/*  971 */     nstbi_set_flip_vertically_on_load(paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbi_set_unpremultiply_on_load_thread(@NativeType("int") boolean paramBoolean) {
/*  981 */     nstbi_set_unpremultiply_on_load_thread(paramBoolean ? 1 : 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void stbi_convert_iphone_png_to_rgb_thread(@NativeType("int") boolean paramBoolean) {
/*  991 */     nstbi_convert_iphone_png_to_rgb_thread(paramBoolean ? 1 : 0);
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
/*      */   @NativeType("char *")
/*      */   public static ByteBuffer stbi_zlib_decode_malloc_guesssize(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt) {
/*      */     MemoryStack memoryStack;
/* 1012 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1014 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */       long l;
/* 1016 */       paramByteBuffer = MemoryUtil.memByteBufferSafe(l = nstbi_zlib_decode_malloc_guesssize(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt, MemoryUtil.memAddress(intBuffer)), intBuffer.get(0)); return paramByteBuffer;
/*      */     } finally {
/* 1018 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char *")
/*      */   public static ByteBuffer stbi_zlib_decode_malloc_guesssize_headerflag(@NativeType("char const *") ByteBuffer paramByteBuffer, int paramInt, @NativeType("int") boolean paramBoolean) {
/*      */     MemoryStack memoryStack;
/* 1031 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1033 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */       long l;
/* 1035 */       paramByteBuffer = MemoryUtil.memByteBufferSafe(l = nstbi_zlib_decode_malloc_guesssize_headerflag(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt, MemoryUtil.memAddress(intBuffer), paramBoolean ? 1 : 0), intBuffer.get(0)); return paramByteBuffer;
/*      */     } finally {
/* 1037 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char *")
/*      */   public static ByteBuffer stbi_zlib_decode_malloc(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*      */     MemoryStack memoryStack;
/* 1050 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1052 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */       long l;
/* 1054 */       paramByteBuffer = MemoryUtil.memByteBufferSafe(l = nstbi_zlib_decode_malloc(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(intBuffer)), intBuffer.get(0)); return paramByteBuffer;
/*      */     } finally {
/* 1056 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbi_zlib_decode_buffer(@NativeType("char *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1067 */     return nstbi_zlib_decode_buffer(MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("char *")
/*      */   public static ByteBuffer stbi_zlib_decode_noheader_malloc(@NativeType("char const *") ByteBuffer paramByteBuffer) {
/*      */     MemoryStack memoryStack;
/* 1079 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1081 */       IntBuffer intBuffer = memoryStack.callocInt(1);
/*      */       long l;
/* 1083 */       paramByteBuffer = MemoryUtil.memByteBufferSafe(l = nstbi_zlib_decode_noheader_malloc(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress(intBuffer)), intBuffer.get(0)); return paramByteBuffer;
/*      */     } finally {
/* 1085 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stbi_zlib_decode_noheader_buffer(@NativeType("char *") ByteBuffer paramByteBuffer1, @NativeType("char const *") ByteBuffer paramByteBuffer2) {
/* 1096 */     return nstbi_zlib_decode_noheader_buffer(MemoryUtil.memAddress(paramByteBuffer1), paramByteBuffer1.remaining(), MemoryUtil.memAddress(paramByteBuffer2), paramByteBuffer2.remaining());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1106 */     if (Checks.CHECKS) {
/* 1107 */       Checks.checkNT1(paramByteBuffer);
/* 1108 */       Checks.check(paramArrayOfint1, 1);
/* 1109 */       Checks.check(paramArrayOfint2, 1);
/* 1110 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/*      */     long l;
/* 1113 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1120 */     if (Checks.CHECKS) {
/* 1121 */       Checks.check(paramArrayOfint1, 1);
/* 1122 */       Checks.check(paramArrayOfint2, 1);
/* 1123 */       Checks.check(paramArrayOfint3, 1);
/*      */     }  MemoryStack memoryStack;
/* 1125 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1127 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/* 1130 */       return MemoryUtil.memByteBufferSafe(l2 = nstbi_load(l1 = memoryStack.getPointerAddress(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */     } finally {
/* 1132 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1143 */     if (Checks.CHECKS) {
/* 1144 */       Checks.check(paramArrayOfint1, 1);
/* 1145 */       Checks.check(paramArrayOfint2, 1);
/* 1146 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/*      */     long l;
/* 1149 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1159 */     if (Checks.CHECKS) {
/* 1160 */       Checks.check(paramArrayOfint1, 1);
/* 1161 */       Checks.check(paramArrayOfint2, 1);
/* 1162 */       Checks.check(paramArrayOfint3, 1);
/* 1163 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*      */     long l;
/* 1166 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_uc *")
/*      */   public static ByteBuffer stbi_load_gif_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int **") PointerBuffer paramPointerBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, @NativeType("int *") int[] paramArrayOfint4, int paramInt) {
/* 1176 */     if (Checks.CHECKS) {
/* 1177 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 1178 */       Checks.check(paramArrayOfint1, 1);
/* 1179 */       Checks.check(paramArrayOfint2, 1);
/* 1180 */       Checks.check(paramArrayOfint3, 1);
/* 1181 */       Checks.check(paramArrayOfint4, 1);
/*      */     } 
/*      */     long l;
/* 1184 */     return MemoryUtil.memByteBufferSafe(l = nstbi_load_gif_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramArrayOfint4, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * paramArrayOfint3[0] * ((paramInt != 0) ? paramInt : paramArrayOfint4[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1194 */     if (Checks.CHECKS) {
/* 1195 */       Checks.checkNT1(paramByteBuffer);
/* 1196 */       Checks.check(paramArrayOfint1, 1);
/* 1197 */       Checks.check(paramArrayOfint2, 1);
/* 1198 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/*      */     long l;
/* 1201 */     return MemoryUtil.memShortBufferSafe(l = nstbi_load_16(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1208 */     if (Checks.CHECKS) {
/* 1209 */       Checks.check(paramArrayOfint1, 1);
/* 1210 */       Checks.check(paramArrayOfint2, 1);
/* 1211 */       Checks.check(paramArrayOfint3, 1);
/*      */     }  MemoryStack memoryStack;
/* 1213 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1215 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/* 1218 */       return MemoryUtil.memShortBufferSafe(l2 = nstbi_load_16(l1 = memoryStack.getPointerAddress(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */     } finally {
/* 1220 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1231 */     if (Checks.CHECKS) {
/* 1232 */       Checks.check(paramArrayOfint1, 1);
/* 1233 */       Checks.check(paramArrayOfint2, 1);
/* 1234 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/*      */     long l;
/* 1237 */     return MemoryUtil.memShortBufferSafe(l = nstbi_load_16_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("stbi_us *")
/*      */   public static ShortBuffer stbi_load_16_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1247 */     if (Checks.CHECKS) {
/* 1248 */       Checks.check(paramArrayOfint1, 1);
/* 1249 */       Checks.check(paramArrayOfint2, 1);
/* 1250 */       Checks.check(paramArrayOfint3, 1);
/* 1251 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*      */     long l;
/* 1254 */     return MemoryUtil.memShortBufferSafe(l = nstbi_load_16_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1264 */     if (Checks.CHECKS) {
/* 1265 */       Checks.checkNT1(paramByteBuffer);
/* 1266 */       Checks.check(paramArrayOfint1, 1);
/* 1267 */       Checks.check(paramArrayOfint2, 1);
/* 1268 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/*      */     long l;
/* 1271 */     return MemoryUtil.memFloatBufferSafe(l = nstbi_loadf(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1278 */     if (Checks.CHECKS) {
/* 1279 */       Checks.check(paramArrayOfint1, 1);
/* 1280 */       Checks.check(paramArrayOfint2, 1);
/* 1281 */       Checks.check(paramArrayOfint3, 1);
/*      */     }  MemoryStack memoryStack;
/* 1283 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1285 */       memoryStack.nUTF8(paramCharSequence, true);
/*      */       
/*      */       long l1, l2;
/* 1288 */       return MemoryUtil.memFloatBufferSafe(l2 = nstbi_loadf(l1 = memoryStack.getPointerAddress(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */     } finally {
/* 1290 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1301 */     if (Checks.CHECKS) {
/* 1302 */       Checks.check(paramArrayOfint1, 1);
/* 1303 */       Checks.check(paramArrayOfint2, 1);
/* 1304 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/*      */     long l;
/* 1307 */     return MemoryUtil.memFloatBufferSafe(l = nstbi_loadf_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("float *")
/*      */   public static FloatBuffer stbi_loadf_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3, int paramInt) {
/* 1317 */     if (Checks.CHECKS) {
/* 1318 */       Checks.check(paramArrayOfint1, 1);
/* 1319 */       Checks.check(paramArrayOfint2, 1);
/* 1320 */       Checks.check(paramArrayOfint3, 1);
/* 1321 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/*      */     long l;
/* 1324 */     return MemoryUtil.memFloatBufferSafe(l = nstbi_loadf_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3, paramInt), paramArrayOfint1[0] * paramArrayOfint2[0] * ((paramInt != 0) ? paramInt : paramArrayOfint3[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 1333 */     if (Checks.CHECKS) {
/* 1334 */       Checks.checkNT1(paramByteBuffer);
/* 1335 */       Checks.check(paramArrayOfint1, 1);
/* 1336 */       Checks.check(paramArrayOfint2, 1);
/* 1337 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 1339 */     return (nstbi_info(MemoryUtil.memAddress(paramByteBuffer), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3) != 0);
/*      */   }
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 1345 */     if (Checks.CHECKS) {
/* 1346 */       Checks.check(paramArrayOfint1, 1);
/* 1347 */       Checks.check(paramArrayOfint2, 1);
/* 1348 */       Checks.check(paramArrayOfint3, 1);
/*      */     }  MemoryStack memoryStack;
/* 1350 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/* 1352 */       memoryStack.nUTF8(paramCharSequence, true); long l; return 
/*      */         
/* 1354 */         (nstbi_info(l = memoryStack.getPointerAddress(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3) != 0);
/*      */     } finally {
/* 1356 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info_from_memory(@NativeType("stbi_uc const *") ByteBuffer paramByteBuffer, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 1366 */     if (Checks.CHECKS) {
/* 1367 */       Checks.check(paramArrayOfint1, 1);
/* 1368 */       Checks.check(paramArrayOfint2, 1);
/* 1369 */       Checks.check(paramArrayOfint3, 1);
/*      */     } 
/* 1371 */     return (nstbi_info_from_memory(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramArrayOfint1, paramArrayOfint2, paramArrayOfint3) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("int")
/*      */   public static boolean stbi_info_from_callbacks(@NativeType("stbi_io_callbacks const *") STBIIOCallbacks paramSTBIIOCallbacks, @NativeType("void *") long paramLong, @NativeType("int *") int[] paramArrayOfint1, @NativeType("int *") int[] paramArrayOfint2, @NativeType("int *") int[] paramArrayOfint3) {
/* 1380 */     if (Checks.CHECKS) {
/* 1381 */       Checks.check(paramArrayOfint1, 1);
/* 1382 */       Checks.check(paramArrayOfint2, 1);
/* 1383 */       Checks.check(paramArrayOfint3, 1);
/* 1384 */       STBIIOCallbacks.validate(paramSTBIIOCallbacks.address());
/*      */     } 
/* 1386 */     return (nstbi_info_from_callbacks(paramSTBIIOCallbacks.address(), paramLong, paramArrayOfint1, paramArrayOfint2, paramArrayOfint3) != 0);
/*      */   }
/*      */   
/*      */   public static native long nstbi_load(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*      */   
/*      */   public static native long nstbi_load_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt);
/*      */   
/*      */   public static native long nstbi_load_gif_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load_16(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*      */   
/*      */   public static native long nstbi_load_16_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load_16_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt);
/*      */   
/*      */   public static native long nstbi_loadf(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt);
/*      */   
/*      */   public static native long nstbi_loadf_from_memory(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2);
/*      */   
/*      */   public static native long nstbi_loadf_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt);
/*      */   
/*      */   public static native void stbi_hdr_to_ldr_gamma(float paramFloat);
/*      */   
/*      */   public static native void stbi_hdr_to_ldr_scale(float paramFloat);
/*      */   
/*      */   public static native void stbi_ldr_to_hdr_gamma(float paramFloat);
/*      */   
/*      */   public static native void stbi_ldr_to_hdr_scale(float paramFloat);
/*      */   
/*      */   public static native int nstbi_is_hdr(long paramLong);
/*      */   
/*      */   public static native int nstbi_is_hdr_from_memory(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbi_is_hdr_from_callbacks(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native long nstbi_failure_reason();
/*      */   
/*      */   public static native void nstbi_image_free(long paramLong);
/*      */   
/*      */   public static native int nstbi_info(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nstbi_info_from_memory(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int nstbi_info_from_callbacks(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int nstbi_is_16_bit(long paramLong);
/*      */   
/*      */   public static native int nstbi_is_16_bit_from_memory(long paramLong, int paramInt);
/*      */   
/*      */   public static native int nstbi_is_16_bit_from_callbacks(long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void nstbi_set_unpremultiply_on_load(int paramInt);
/*      */   
/*      */   public static native void nstbi_convert_iphone_png_to_rgb(int paramInt);
/*      */   
/*      */   public static native void nstbi_set_flip_vertically_on_load(int paramInt);
/*      */   
/*      */   public static native void nstbi_set_unpremultiply_on_load_thread(int paramInt);
/*      */   
/*      */   public static native void nstbi_convert_iphone_png_to_rgb_thread(int paramInt);
/*      */   
/*      */   public static native void stbi_set_flip_vertically_on_load_thread(int paramInt);
/*      */   
/*      */   public static native long nstbi_zlib_decode_malloc_guesssize(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native long nstbi_zlib_decode_malloc_guesssize_headerflag(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3);
/*      */   
/*      */   public static native long nstbi_zlib_decode_malloc(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nstbi_zlib_decode_buffer(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native long nstbi_zlib_decode_noheader_malloc(long paramLong1, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int nstbi_zlib_decode_noheader_buffer(long paramLong1, int paramInt1, long paramLong2, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*      */   
/*      */   public static native long nstbi_load_from_memory(long paramLong, int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*      */   
/*      */   public static native long nstbi_load_gif_from_memory(long paramLong1, int paramInt1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load_16(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*      */   
/*      */   public static native long nstbi_load_16_from_memory(long paramLong, int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2);
/*      */   
/*      */   public static native long nstbi_load_16_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*      */   
/*      */   public static native long nstbi_loadf(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*      */   
/*      */   public static native long nstbi_loadf_from_memory(long paramLong, int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2);
/*      */   
/*      */   public static native long nstbi_loadf_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt);
/*      */   
/*      */   public static native int nstbi_info(long paramLong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */   
/*      */   public static native int nstbi_info_from_memory(long paramLong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */   
/*      */   public static native int nstbi_info_from_callbacks(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */