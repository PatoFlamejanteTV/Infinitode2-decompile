/*      */ package org.lwjgl.system.jemalloc;
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
/*      */ import org.lwjgl.system.Configuration;
/*      */ import org.lwjgl.system.CustomBuffer;
/*      */ import org.lwjgl.system.FunctionProvider;
/*      */ import org.lwjgl.system.JNI;
/*      */ import org.lwjgl.system.Library;
/*      */ import org.lwjgl.system.MemoryStack;
/*      */ import org.lwjgl.system.MemoryUtil;
/*      */ import org.lwjgl.system.NativeType;
/*      */ import org.lwjgl.system.Platform;
/*      */ import org.lwjgl.system.Pointer;
/*      */ import org.lwjgl.system.SharedLibrary;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class JEmalloc
/*      */ {
/*      */   public static final int JEMALLOC_VERSION_MAJOR = 5;
/*      */   public static final int JEMALLOC_VERSION_MINOR = 2;
/*      */   public static final int JEMALLOC_VERSION_BUGFIX = 1;
/*      */   public static final int JEMALLOC_VERSION_NREV = 0;
/*   34 */   private static final SharedLibrary JEMALLOC = Library.loadNative(JEmalloc.class, "org.lwjgl.jemalloc", (String)Configuration.JEMALLOC_LIBRARY_NAME.get(Platform.mapLibraryNameBundled("jemalloc")), true);
/*      */   
/*      */   public static final String JEMALLOC_VERSION_GID = "ea6b3e973b477b8061e0076bb257dbd7f3faa756";
/*      */   
/*      */   public static final String JEMALLOC_VERSION = "5.2.1-0-gea6b3e973b477b8061e0076bb257dbd7f3faa756";
/*      */   public static final int MALLOCX_ZERO = 64;
/*      */   
/*      */   public static final class Functions
/*      */   {
/*   43 */     public static final long malloc_message = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_malloc_message");
/*   44 */     public static final long malloc = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_malloc");
/*   45 */     public static final long calloc = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_calloc");
/*   46 */     public static final long posix_memalign = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_posix_memalign");
/*   47 */     public static final long aligned_alloc = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_aligned_alloc");
/*   48 */     public static final long realloc = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_realloc");
/*   49 */     public static final long free = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_free");
/*   50 */     public static final long free_sized = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_free_sized");
/*   51 */     public static final long free_aligned_sized = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_free_aligned_sized");
/*   52 */     public static final long mallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_mallocx");
/*   53 */     public static final long rallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_rallocx");
/*   54 */     public static final long xallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_xallocx");
/*   55 */     public static final long sallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_sallocx");
/*   56 */     public static final long dallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_dallocx");
/*   57 */     public static final long sdallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_sdallocx");
/*   58 */     public static final long nallocx = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_nallocx");
/*   59 */     public static final long mallctl = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_mallctl");
/*   60 */     public static final long mallctlnametomib = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_mallctlnametomib");
/*   61 */     public static final long mallctlbymib = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_mallctlbymib");
/*   62 */     public static final long malloc_stats_print = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_malloc_stats_print");
/*   63 */     public static final long malloc_usable_size = APIUtil.apiGetFunctionAddress((FunctionProvider)JEmalloc.JEMALLOC, "je_malloc_usable_size");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static SharedLibrary getLibrary() {
/*   69 */     return JEMALLOC;
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
/*  100 */   public static final int MALLOCX_TCACHE_NONE = MALLOCX_TCACHE(-1);
/*      */ 
/*      */   
/*      */   public static final int MALLCTL_ARENAS_ALL = 4096;
/*      */ 
/*      */   
/*      */   public static final int MALLCTL_ARENAS_DESTROYED = 4097;
/*      */ 
/*      */ 
/*      */   
/*      */   static {
/*  111 */     if (Platform.get() == Platform.WINDOWS) {
/*  112 */       JNI.invokePV(JNI.invokePP(8L, APIUtil.apiGetFunctionAddress((FunctionProvider)JEMALLOC, "je_malloc")), APIUtil.apiGetFunctionAddress((FunctionProvider)JEMALLOC, "je_free"));
/*      */     }
/*      */   }
/*      */   
/*      */   protected JEmalloc() {
/*  117 */     throw new UnsupportedOperationException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void (*) (void *, char const *) *")
/*      */   public static PointerBuffer je_malloc_message() {
/*      */     long l;
/*  126 */     return MemoryUtil.memPointerBuffer(l = Functions.malloc_message, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_malloc(long paramLong) {
/*  133 */     long l = Functions.malloc;
/*  134 */     return JNI.invokePP(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_malloc(@NativeType("size_t") long paramLong) {
/*      */     long l;
/*  147 */     return MemoryUtil.memByteBufferSafe(l = nje_malloc(paramLong), (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_calloc(long paramLong1, long paramLong2) {
/*  154 */     long l = Functions.calloc;
/*  155 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_calloc(@NativeType("size_t") long paramLong1, @NativeType("size_t") long paramLong2) {
/*      */     long l;
/*  169 */     return MemoryUtil.memByteBufferSafe(l = nje_calloc(paramLong1, paramLong2), (int)paramLong1 * (int)paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nje_posix_memalign(long paramLong1, long paramLong2, long paramLong3) {
/*  176 */     long l = Functions.posix_memalign;
/*  177 */     return JNI.invokePPPI(paramLong1, paramLong2, paramLong3, l);
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
/*      */   public static int je_posix_memalign(@NativeType("void **") PointerBuffer paramPointerBuffer, @NativeType("size_t") long paramLong1, @NativeType("size_t") long paramLong2) {
/*  189 */     if (Checks.CHECKS) {
/*  190 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*      */     }
/*  192 */     return nje_posix_memalign(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_aligned_alloc(long paramLong1, long paramLong2) {
/*  199 */     long l = Functions.aligned_alloc;
/*  200 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_aligned_alloc(@NativeType("size_t") long paramLong1, @NativeType("size_t") long paramLong2) {
/*      */     long l;
/*  214 */     return MemoryUtil.memByteBufferSafe(l = nje_aligned_alloc(paramLong1, paramLong2), (int)paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_realloc(long paramLong1, long paramLong2) {
/*  221 */     long l = Functions.realloc;
/*  222 */     return JNI.invokePPP(paramLong1, paramLong2, l);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_realloc(@NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("size_t") long paramLong) {
/*      */     long l;
/*  239 */     return MemoryUtil.memByteBufferSafe(l = nje_realloc(MemoryUtil.memAddressSafe(paramByteBuffer), paramLong), (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nje_free(long paramLong) {
/*  246 */     long l = Functions.free;
/*  247 */     JNI.invokePV(paramLong, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") ByteBuffer paramByteBuffer) {
/*  256 */     nje_free(MemoryUtil.memAddressSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") ShortBuffer paramShortBuffer) {
/*  265 */     nje_free(MemoryUtil.memAddressSafe(paramShortBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") IntBuffer paramIntBuffer) {
/*  274 */     nje_free(MemoryUtil.memAddressSafe(paramIntBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") LongBuffer paramLongBuffer) {
/*  283 */     nje_free(MemoryUtil.memAddressSafe(paramLongBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  292 */     nje_free(MemoryUtil.memAddressSafe(paramFloatBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/*  301 */     nje_free(MemoryUtil.memAddressSafe(paramDoubleBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free(@NativeType("void *") PointerBuffer paramPointerBuffer) {
/*  310 */     nje_free(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nje_free_sized(long paramLong1, long paramLong2) {
/*  317 */     long l = Functions.free_sized;
/*  318 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") ByteBuffer paramByteBuffer) {
/*  326 */     nje_free_sized(MemoryUtil.memAddressSafe(paramByteBuffer), Checks.remainingSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") ShortBuffer paramShortBuffer) {
/*  334 */     nje_free_sized(MemoryUtil.memAddressSafe(paramShortBuffer), Integer.toUnsignedLong(Checks.remainingSafe(paramShortBuffer)) << 1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") IntBuffer paramIntBuffer) {
/*  342 */     nje_free_sized(MemoryUtil.memAddressSafe(paramIntBuffer), Integer.toUnsignedLong(Checks.remainingSafe(paramIntBuffer)) << 2L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") LongBuffer paramLongBuffer) {
/*  350 */     nje_free_sized(MemoryUtil.memAddressSafe(paramLongBuffer), Integer.toUnsignedLong(Checks.remainingSafe(paramLongBuffer)) << 3L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") FloatBuffer paramFloatBuffer) {
/*  358 */     nje_free_sized(MemoryUtil.memAddressSafe(paramFloatBuffer), Integer.toUnsignedLong(Checks.remainingSafe(paramFloatBuffer)) << 2L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") DoubleBuffer paramDoubleBuffer) {
/*  366 */     nje_free_sized(MemoryUtil.memAddressSafe(paramDoubleBuffer), Integer.toUnsignedLong(Checks.remainingSafe(paramDoubleBuffer)) << 3L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_sized(@NativeType("void *") PointerBuffer paramPointerBuffer) {
/*  374 */     nje_free_sized(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), Integer.toUnsignedLong(Checks.remainingSafe((CustomBuffer)paramPointerBuffer)) << MemoryStack.POINTER_SHIFT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nje_free_aligned_sized(long paramLong1, long paramLong2, long paramLong3) {
/*  381 */     long l = Functions.free_aligned_sized;
/*  382 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("size_t") long paramLong) {
/*  390 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe(paramByteBuffer), paramLong, Checks.remainingSafe(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") ShortBuffer paramShortBuffer, @NativeType("size_t") long paramLong) {
/*  398 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe(paramShortBuffer), paramLong, Integer.toUnsignedLong(Checks.remainingSafe(paramShortBuffer)) << 1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") IntBuffer paramIntBuffer, @NativeType("size_t") long paramLong) {
/*  406 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe(paramIntBuffer), paramLong, Integer.toUnsignedLong(Checks.remainingSafe(paramIntBuffer)) << 2L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") LongBuffer paramLongBuffer, @NativeType("size_t") long paramLong) {
/*  414 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe(paramLongBuffer), paramLong, Integer.toUnsignedLong(Checks.remainingSafe(paramLongBuffer)) << 3L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") FloatBuffer paramFloatBuffer, @NativeType("size_t") long paramLong) {
/*  422 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe(paramFloatBuffer), paramLong, Integer.toUnsignedLong(Checks.remainingSafe(paramFloatBuffer)) << 2L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") DoubleBuffer paramDoubleBuffer, @NativeType("size_t") long paramLong) {
/*  430 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe(paramDoubleBuffer), paramLong, Integer.toUnsignedLong(Checks.remainingSafe(paramDoubleBuffer)) << 3L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_free_aligned_sized(@NativeType("void *") PointerBuffer paramPointerBuffer, @NativeType("size_t") long paramLong) {
/*  438 */     nje_free_aligned_sized(MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), paramLong, Integer.toUnsignedLong(Checks.remainingSafe((CustomBuffer)paramPointerBuffer)) << MemoryStack.POINTER_SHIFT);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_mallocx(long paramLong, int paramInt) {
/*  445 */     long l = Functions.mallocx;
/*  446 */     return JNI.invokePP(paramLong, paramInt, l);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_mallocx(@NativeType("size_t") long paramLong, int paramInt) {
/*      */     long l;
/*  460 */     return MemoryUtil.memByteBufferSafe(l = nje_mallocx(paramLong, paramInt), (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_rallocx(long paramLong1, long paramLong2, int paramInt) {
/*  467 */     long l = Functions.rallocx;
/*  468 */     return JNI.invokePPP(paramLong1, paramLong2, paramInt, l);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_rallocx(@NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("size_t") long paramLong, int paramInt) {
/*      */     long l;
/*  484 */     return MemoryUtil.memByteBufferSafe(l = nje_rallocx(MemoryUtil.memAddressSafe(paramByteBuffer), paramLong, paramInt), (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_xallocx(long paramLong1, long paramLong2, long paramLong3, int paramInt) {
/*  491 */     long l = Functions.xallocx;
/*  492 */     return JNI.invokePPPP(paramLong1, paramLong2, paramLong3, paramInt, l);
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
/*      */   @NativeType("size_t")
/*      */   public static long je_xallocx(@NativeType("void *") ByteBuffer paramByteBuffer, @NativeType("size_t") long paramLong1, @NativeType("size_t") long paramLong2, int paramInt) {
/*  507 */     return nje_xallocx(MemoryUtil.memAddressSafe(paramByteBuffer), paramLong1, paramLong2, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_sallocx(long paramLong, int paramInt) {
/*  514 */     long l = Functions.sallocx;
/*  515 */     return JNI.invokePP(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @NativeType("size_t")
/*      */   public static long je_sallocx(@NativeType("void const *") ByteBuffer paramByteBuffer, int paramInt) {
/*  526 */     return nje_sallocx(MemoryUtil.memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nje_dallocx(long paramLong, int paramInt) {
/*  533 */     long l = Functions.dallocx;
/*  534 */     JNI.invokePV(paramLong, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") ByteBuffer paramByteBuffer, int paramInt) {
/*  544 */     nje_dallocx(MemoryUtil.memAddress(paramByteBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") ShortBuffer paramShortBuffer, int paramInt) {
/*  554 */     nje_dallocx(MemoryUtil.memAddress(paramShortBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") IntBuffer paramIntBuffer, int paramInt) {
/*  564 */     nje_dallocx(MemoryUtil.memAddress(paramIntBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") LongBuffer paramLongBuffer, int paramInt) {
/*  574 */     nje_dallocx(MemoryUtil.memAddress(paramLongBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") FloatBuffer paramFloatBuffer, int paramInt) {
/*  584 */     nje_dallocx(MemoryUtil.memAddress(paramFloatBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") DoubleBuffer paramDoubleBuffer, int paramInt) {
/*  594 */     nje_dallocx(MemoryUtil.memAddress(paramDoubleBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_dallocx(@NativeType("void *") PointerBuffer paramPointerBuffer, int paramInt) {
/*  604 */     nje_dallocx(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nje_sdallocx(long paramLong1, long paramLong2, int paramInt) {
/*  615 */     long l = Functions.sdallocx;
/*  616 */     JNI.invokePPV(paramLong1, paramLong2, paramInt, l);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") ByteBuffer paramByteBuffer, int paramInt) {
/*  626 */     nje_sdallocx(MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") ShortBuffer paramShortBuffer, int paramInt) {
/*  636 */     nje_sdallocx(MemoryUtil.memAddress(paramShortBuffer), Integer.toUnsignedLong(paramShortBuffer.remaining()) << 1L, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") IntBuffer paramIntBuffer, int paramInt) {
/*  646 */     nje_sdallocx(MemoryUtil.memAddress(paramIntBuffer), Integer.toUnsignedLong(paramIntBuffer.remaining()) << 2L, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") LongBuffer paramLongBuffer, int paramInt) {
/*  656 */     nje_sdallocx(MemoryUtil.memAddress(paramLongBuffer), Integer.toUnsignedLong(paramLongBuffer.remaining()) << 3L, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") FloatBuffer paramFloatBuffer, int paramInt) {
/*  666 */     nje_sdallocx(MemoryUtil.memAddress(paramFloatBuffer), Integer.toUnsignedLong(paramFloatBuffer.remaining()) << 2L, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") DoubleBuffer paramDoubleBuffer, int paramInt) {
/*  676 */     nje_sdallocx(MemoryUtil.memAddress(paramDoubleBuffer), Integer.toUnsignedLong(paramDoubleBuffer.remaining()) << 3L, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void je_sdallocx(@NativeType("void *") PointerBuffer paramPointerBuffer, int paramInt) {
/*  686 */     nje_sdallocx(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), Integer.toUnsignedLong(paramPointerBuffer.remaining()) << MemoryStack.POINTER_SHIFT, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_nallocx(long paramLong, int paramInt) {
/*  693 */     long l = Functions.nallocx;
/*  694 */     return JNI.invokePP(paramLong, paramInt, l);
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
/*      */   @NativeType("void *")
/*      */   public static ByteBuffer je_nallocx(@NativeType("size_t") long paramLong, int paramInt) {
/*      */     long l;
/*  709 */     return MemoryUtil.memByteBufferSafe(l = nje_nallocx(paramLong, paramInt), (int)paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int nje_mallctl(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
/*  720 */     long l = Functions.mallctl;
/*  721 */     return JNI.invokePPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, l);
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
/*      */   public static int je_mallctl(@NativeType("char const *") ByteBuffer paramByteBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer2, @NativeType("size_t *") PointerBuffer paramPointerBuffer, @NativeType("void *") ByteBuffer paramByteBuffer3) {
/*  738 */     if (Checks.CHECKS) {
/*  739 */       Checks.checkNT1(paramByteBuffer1);
/*  740 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1);
/*      */     } 
/*  742 */     return nje_mallctl(MemoryUtil.memAddress(paramByteBuffer1), MemoryUtil.memAddressSafe(paramByteBuffer2), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramByteBuffer3), Checks.remainingSafe(paramByteBuffer3));
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
/*      */   public static int je_mallctl(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("size_t *") PointerBuffer paramPointerBuffer, @NativeType("void *") ByteBuffer paramByteBuffer2) {
/*  759 */     if (Checks.CHECKS)
/*  760 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer, 1); 
/*      */     MemoryStack memoryStack;
/*  762 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  764 */       memoryStack.nASCII(paramCharSequence, true);
/*      */       long l;
/*  766 */       return nje_mallctl(l = memoryStack.getPointerAddress(), MemoryUtil.memAddressSafe(paramByteBuffer1), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramByteBuffer2), Checks.remainingSafe(paramByteBuffer2));
/*      */     } finally {
/*  768 */       memoryStack.setPointer(i);
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
/*      */   public static int nje_mallctlnametomib(long paramLong1, long paramLong2, long paramLong3) {
/*  780 */     long l = Functions.mallctlnametomib;
/*  781 */     return JNI.invokePPPI(paramLong1, paramLong2, paramLong3, l);
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
/*      */   public static int je_mallctlnametomib(@NativeType("char const *") ByteBuffer paramByteBuffer, @NativeType("size_t *") PointerBuffer paramPointerBuffer1, @NativeType("size_t *") PointerBuffer paramPointerBuffer2) {
/*  816 */     if (Checks.CHECKS) {
/*  817 */       Checks.checkNT1(paramByteBuffer);
/*  818 */       Checks.check((CustomBuffer)paramPointerBuffer2, 1);
/*  819 */       Checks.check((CustomBuffer)paramPointerBuffer1, paramPointerBuffer2.get(paramPointerBuffer2.position()));
/*      */     } 
/*  821 */     return nje_mallctlnametomib(MemoryUtil.memAddress(paramByteBuffer), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer1), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer2));
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
/*      */   public static int je_mallctlnametomib(@NativeType("char const *") CharSequence paramCharSequence, @NativeType("size_t *") PointerBuffer paramPointerBuffer1, @NativeType("size_t *") PointerBuffer paramPointerBuffer2) {
/*  856 */     if (Checks.CHECKS) {
/*  857 */       Checks.check((CustomBuffer)paramPointerBuffer2, 1);
/*  858 */       Checks.check((CustomBuffer)paramPointerBuffer1, paramPointerBuffer2.get(paramPointerBuffer2.position()));
/*      */     }  MemoryStack memoryStack;
/*  860 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  862 */       memoryStack.nASCII(paramCharSequence, true);
/*      */       long l;
/*  864 */       return nje_mallctlnametomib(l = memoryStack.getPointerAddress(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer1), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer2));
/*      */     } finally {
/*  866 */       memoryStack.setPointer(i);
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
/*      */   public static int nje_mallctlbymib(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6) {
/*  879 */     long l = Functions.mallctlbymib;
/*  880 */     return JNI.invokePPPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, paramLong6, l);
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
/*      */   public static int je_mallctlbymib(@NativeType("size_t const *") PointerBuffer paramPointerBuffer1, @NativeType("void *") ByteBuffer paramByteBuffer1, @NativeType("size_t *") PointerBuffer paramPointerBuffer2, @NativeType("void *") ByteBuffer paramByteBuffer2) {
/*  892 */     if (Checks.CHECKS) {
/*  893 */       Checks.checkSafe((CustomBuffer)paramPointerBuffer2, 1);
/*      */     }
/*  895 */     return nje_mallctlbymib(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer1), paramPointerBuffer1.remaining(), MemoryUtil.memAddressSafe(paramByteBuffer1), MemoryUtil.memAddressSafe((Pointer)paramPointerBuffer2), MemoryUtil.memAddressSafe(paramByteBuffer2), Checks.remainingSafe(paramByteBuffer2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void nje_malloc_stats_print(long paramLong1, long paramLong2, long paramLong3) {
/*  902 */     long l = Functions.malloc_stats_print;
/*  903 */     JNI.invokePPPV(paramLong1, paramLong2, paramLong3, l);
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
/*      */   public static void je_malloc_stats_print(@NativeType("void (*) (void *, char const *)") MallocMessageCallbackI paramMallocMessageCallbackI, @NativeType("void *") long paramLong, @NativeType("char const *") ByteBuffer paramByteBuffer) {
/*  920 */     if (Checks.CHECKS) {
/*  921 */       Checks.checkNT1Safe(paramByteBuffer);
/*      */     }
/*  923 */     nje_malloc_stats_print(MemoryUtil.memAddressSafe((Pointer)paramMallocMessageCallbackI), paramLong, MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*      */   public static void je_malloc_stats_print(@NativeType("void (*) (void *, char const *)") MallocMessageCallbackI paramMallocMessageCallbackI, @NativeType("void *") long paramLong, @NativeType("char const *") CharSequence paramCharSequence) {
/*      */     MemoryStack memoryStack;
/*  940 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*      */     try {
/*  942 */       memoryStack.nASCIISafe(paramCharSequence, true);
/*  943 */       long l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/*  944 */       nje_malloc_stats_print(MemoryUtil.memAddressSafe((Pointer)paramMallocMessageCallbackI), paramLong, l); return;
/*      */     } finally {
/*  946 */       memoryStack.setPointer(i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long nje_malloc_usable_size(long paramLong) {
/*  954 */     long l = Functions.malloc_usable_size;
/*  955 */     return JNI.invokePP(paramLong, l);
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
/*      */   @NativeType("size_t")
/*      */   public static long je_malloc_usable_size(@NativeType("void const *") ByteBuffer paramByteBuffer) {
/*  968 */     return nje_malloc_usable_size(MemoryUtil.memAddress(paramByteBuffer));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int MALLOCX_LG_ALIGN(int paramInt) {
/*  978 */     return paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int MALLOCX_ALIGN(int paramInt) {
/*  988 */     return Integer.numberOfTrailingZeros(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int MALLOCX_TCACHE(int paramInt) {
/*  998 */     return paramInt + 2 << 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int MALLOCX_ARENA(int paramInt) {
/* 1008 */     return paramInt + 1 << 20;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\JEmalloc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */