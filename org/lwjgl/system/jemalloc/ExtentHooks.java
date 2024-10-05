/*     */ package org.lwjgl.system.jemalloc;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ import org.lwjgl.system.Struct;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NativeType("struct extent_hooks_t")
/*     */ public class ExtentHooks
/*     */   extends Struct<ExtentHooks>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int ALLOC;
/*     */   public static final int DALLOC;
/*     */   public static final int DESTROY;
/*     */   public static final int COMMIT;
/*     */   public static final int DECOMMIT;
/*     */   public static final int PURGE_LAZY;
/*     */   public static final int PURGE_FORCED;
/*     */   public static final int SPLIT;
/*     */   public static final int MERGE;
/*     */   
/*     */   static {
/*     */     Struct.Layout layout;
/*  76 */     SIZEOF = (layout = __struct(new Struct.Member[] { __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE), __member(POINTER_SIZE) })).getSize();
/*  77 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  79 */     ALLOC = layout.offsetof(0);
/*  80 */     DALLOC = layout.offsetof(1);
/*  81 */     DESTROY = layout.offsetof(2);
/*  82 */     COMMIT = layout.offsetof(3);
/*  83 */     DECOMMIT = layout.offsetof(4);
/*  84 */     PURGE_LAZY = layout.offsetof(5);
/*  85 */     PURGE_FORCED = layout.offsetof(6);
/*  86 */     SPLIT = layout.offsetof(7);
/*  87 */     MERGE = layout.offsetof(8);
/*     */   }
/*     */   
/*     */   protected ExtentHooks(long paramLong, ByteBuffer paramByteBuffer) {
/*  91 */     super(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   protected ExtentHooks create(long paramLong, ByteBuffer paramByteBuffer) {
/*  96 */     return new ExtentHooks(paramLong, paramByteBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtentHooks(ByteBuffer paramByteBuffer) {
/* 106 */     super(MemoryUtil.memAddress(paramByteBuffer), __checkContainer(paramByteBuffer, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/* 110 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("extent_alloc_t")
/*     */   public ExtentAlloc alloc() {
/* 114 */     return nalloc(address());
/*     */   }
/*     */   @NativeType("extent_dalloc_t")
/*     */   public ExtentDalloc dalloc() {
/* 118 */     return ndalloc(address());
/*     */   }
/*     */   @NativeType("extent_destroy_t")
/*     */   public ExtentDestroy destroy() {
/* 122 */     return ndestroy(address());
/*     */   }
/*     */   @NativeType("extent_commit_t")
/*     */   public ExtentCommit commit() {
/* 126 */     return ncommit(address());
/*     */   }
/*     */   @NativeType("extent_decommit_t")
/*     */   public ExtentDecommit decommit() {
/* 130 */     return ndecommit(address());
/*     */   }
/*     */   @NativeType("extent_purge_t")
/*     */   public ExtentPurge purge_lazy() {
/* 134 */     return npurge_lazy(address());
/*     */   }
/*     */   @NativeType("extent_purge_t")
/*     */   public ExtentPurge purge_forced() {
/* 138 */     return npurge_forced(address());
/*     */   }
/*     */   @NativeType("extent_split_t")
/*     */   public ExtentSplit split() {
/* 142 */     return nsplit(address());
/*     */   }
/*     */   @NativeType("extent_merge_t")
/*     */   public ExtentMerge merge() {
/* 146 */     return nmerge(address());
/*     */   }
/*     */   public ExtentHooks alloc(@NativeType("extent_alloc_t") ExtentAllocI paramExtentAllocI) {
/* 149 */     nalloc(address(), paramExtentAllocI); return this;
/*     */   } public ExtentHooks dalloc(@NativeType("extent_dalloc_t") ExtentDallocI paramExtentDallocI) {
/* 151 */     ndalloc(address(), paramExtentDallocI); return this;
/*     */   } public ExtentHooks destroy(@NativeType("extent_destroy_t") ExtentDestroyI paramExtentDestroyI) {
/* 153 */     ndestroy(address(), paramExtentDestroyI); return this;
/*     */   } public ExtentHooks commit(@NativeType("extent_commit_t") ExtentCommitI paramExtentCommitI) {
/* 155 */     ncommit(address(), paramExtentCommitI); return this;
/*     */   } public ExtentHooks decommit(@NativeType("extent_decommit_t") ExtentDecommitI paramExtentDecommitI) {
/* 157 */     ndecommit(address(), paramExtentDecommitI); return this;
/*     */   } public ExtentHooks purge_lazy(@NativeType("extent_purge_t") ExtentPurgeI paramExtentPurgeI) {
/* 159 */     npurge_lazy(address(), paramExtentPurgeI); return this;
/*     */   } public ExtentHooks purge_forced(@NativeType("extent_purge_t") ExtentPurgeI paramExtentPurgeI) {
/* 161 */     npurge_forced(address(), paramExtentPurgeI); return this;
/*     */   } public ExtentHooks split(@NativeType("extent_split_t") ExtentSplitI paramExtentSplitI) {
/* 163 */     nsplit(address(), paramExtentSplitI); return this;
/*     */   } public ExtentHooks merge(@NativeType("extent_merge_t") ExtentMergeI paramExtentMergeI) {
/* 165 */     nmerge(address(), paramExtentMergeI); return this;
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
/*     */   public ExtentHooks set(ExtentAllocI paramExtentAllocI, ExtentDallocI paramExtentDallocI, ExtentDestroyI paramExtentDestroyI, ExtentCommitI paramExtentCommitI, ExtentDecommitI paramExtentDecommitI, ExtentPurgeI paramExtentPurgeI1, ExtentPurgeI paramExtentPurgeI2, ExtentSplitI paramExtentSplitI, ExtentMergeI paramExtentMergeI) {
/* 179 */     alloc(paramExtentAllocI);
/* 180 */     dalloc(paramExtentDallocI);
/* 181 */     destroy(paramExtentDestroyI);
/* 182 */     commit(paramExtentCommitI);
/* 183 */     decommit(paramExtentDecommitI);
/* 184 */     purge_lazy(paramExtentPurgeI1);
/* 185 */     purge_forced(paramExtentPurgeI2);
/* 186 */     split(paramExtentSplitI);
/* 187 */     merge(paramExtentMergeI);
/*     */     
/* 189 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExtentHooks set(ExtentHooks paramExtentHooks) {
/* 200 */     MemoryUtil.memCopy(paramExtentHooks.address(), address(), SIZEOF);
/* 201 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExtentHooks malloc() {
/* 208 */     return new ExtentHooks(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ExtentHooks calloc() {
/* 213 */     return new ExtentHooks(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ExtentHooks create() {
/* 218 */     ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
/* 219 */     return new ExtentHooks(MemoryUtil.memAddress(byteBuffer), byteBuffer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ExtentHooks create(long paramLong) {
/* 224 */     return new ExtentHooks(paramLong, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExtentHooks createSafe(long paramLong) {
/* 230 */     return (paramLong == 0L) ? null : new ExtentHooks(paramLong, null);
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static ExtentHooks mallocStack() {
/* 236 */     return malloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 238 */   public static ExtentHooks callocStack() { return calloc(MemoryStack.stackGet()); }
/*     */   @Deprecated
/* 240 */   public static ExtentHooks mallocStack(MemoryStack paramMemoryStack) { return malloc(paramMemoryStack); } @Deprecated
/*     */   public static ExtentHooks callocStack(MemoryStack paramMemoryStack) {
/* 242 */     return calloc(paramMemoryStack);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExtentHooks malloc(MemoryStack paramMemoryStack) {
/* 251 */     return new ExtentHooks(paramMemoryStack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExtentHooks calloc(MemoryStack paramMemoryStack) {
/* 260 */     return new ExtentHooks(paramMemoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static ExtentAlloc nalloc(long paramLong) {
/* 266 */     return ExtentAlloc.create(MemoryUtil.memGetAddress(paramLong + ALLOC));
/*     */   } public static ExtentDalloc ndalloc(long paramLong) {
/* 268 */     return ExtentDalloc.createSafe(MemoryUtil.memGetAddress(paramLong + DALLOC));
/*     */   } public static ExtentDestroy ndestroy(long paramLong) {
/* 270 */     return ExtentDestroy.createSafe(MemoryUtil.memGetAddress(paramLong + DESTROY));
/*     */   } public static ExtentCommit ncommit(long paramLong) {
/* 272 */     return ExtentCommit.createSafe(MemoryUtil.memGetAddress(paramLong + COMMIT));
/*     */   } public static ExtentDecommit ndecommit(long paramLong) {
/* 274 */     return ExtentDecommit.createSafe(MemoryUtil.memGetAddress(paramLong + DECOMMIT));
/*     */   } public static ExtentPurge npurge_lazy(long paramLong) {
/* 276 */     return ExtentPurge.createSafe(MemoryUtil.memGetAddress(paramLong + PURGE_LAZY));
/*     */   } public static ExtentPurge npurge_forced(long paramLong) {
/* 278 */     return ExtentPurge.createSafe(MemoryUtil.memGetAddress(paramLong + PURGE_FORCED));
/*     */   } public static ExtentSplit nsplit(long paramLong) {
/* 280 */     return ExtentSplit.createSafe(MemoryUtil.memGetAddress(paramLong + SPLIT));
/*     */   } public static ExtentMerge nmerge(long paramLong) {
/* 282 */     return ExtentMerge.createSafe(MemoryUtil.memGetAddress(paramLong + MERGE));
/*     */   }
/*     */   public static void nalloc(long paramLong, ExtentAllocI paramExtentAllocI) {
/* 285 */     MemoryUtil.memPutAddress(paramLong + ALLOC, paramExtentAllocI.address());
/*     */   } public static void ndalloc(long paramLong, ExtentDallocI paramExtentDallocI) {
/* 287 */     MemoryUtil.memPutAddress(paramLong + DALLOC, MemoryUtil.memAddressSafe((Pointer)paramExtentDallocI));
/*     */   } public static void ndestroy(long paramLong, ExtentDestroyI paramExtentDestroyI) {
/* 289 */     MemoryUtil.memPutAddress(paramLong + DESTROY, MemoryUtil.memAddressSafe((Pointer)paramExtentDestroyI));
/*     */   } public static void ncommit(long paramLong, ExtentCommitI paramExtentCommitI) {
/* 291 */     MemoryUtil.memPutAddress(paramLong + COMMIT, MemoryUtil.memAddressSafe((Pointer)paramExtentCommitI));
/*     */   } public static void ndecommit(long paramLong, ExtentDecommitI paramExtentDecommitI) {
/* 293 */     MemoryUtil.memPutAddress(paramLong + DECOMMIT, MemoryUtil.memAddressSafe((Pointer)paramExtentDecommitI));
/*     */   } public static void npurge_lazy(long paramLong, ExtentPurgeI paramExtentPurgeI) {
/* 295 */     MemoryUtil.memPutAddress(paramLong + PURGE_LAZY, MemoryUtil.memAddressSafe((Pointer)paramExtentPurgeI));
/*     */   } public static void npurge_forced(long paramLong, ExtentPurgeI paramExtentPurgeI) {
/* 297 */     MemoryUtil.memPutAddress(paramLong + PURGE_FORCED, MemoryUtil.memAddressSafe((Pointer)paramExtentPurgeI));
/*     */   } public static void nsplit(long paramLong, ExtentSplitI paramExtentSplitI) {
/* 299 */     MemoryUtil.memPutAddress(paramLong + SPLIT, MemoryUtil.memAddressSafe((Pointer)paramExtentSplitI));
/*     */   } public static void nmerge(long paramLong, ExtentMergeI paramExtentMergeI) {
/* 301 */     MemoryUtil.memPutAddress(paramLong + MERGE, MemoryUtil.memAddressSafe((Pointer)paramExtentMergeI));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long paramLong) {
/* 309 */     Checks.check(MemoryUtil.memGetAddress(paramLong + ALLOC));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentHooks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */