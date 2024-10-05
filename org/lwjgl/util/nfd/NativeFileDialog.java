/*     */ package org.lwjgl.util.nfd;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NativeFileDialog
/*     */ {
/*     */   public static final int NFD_ERROR = 0;
/*     */   public static final int NFD_OKAY = 1;
/*     */   public static final int NFD_CANCEL = 2;
/*     */   
/*     */   static {
/*  93 */     LibNFD.initialize();
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
/*     */   protected NativeFileDialog() {
/* 112 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void NFD_FreePath(@NativeType("nfdchar_t *") ByteBuffer paramByteBuffer) {
/* 122 */     if (Checks.CHECKS) {
/* 123 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 125 */     nNFD_FreePath(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void NFD_FreePath(@NativeType("nfdchar_t *") long paramLong) {
/* 130 */     nNFD_FreePath(paramLong);
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_OpenDialog(@NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer, @NativeType("nfdfilteritem_t const *") NFDFilterItem.Buffer paramBuffer, @NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer) {
/* 162 */     if (Checks.CHECKS) {
/* 163 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 164 */       Checks.checkNT1Safe(paramByteBuffer);
/* 165 */       if (paramBuffer != null) Struct.validate(paramBuffer.address(), Checks.remainingSafe((CustomBuffer)paramBuffer), NFDFilterItem.SIZEOF, NFDFilterItem::validate); 
/*     */     } 
/* 167 */     return nNFD_OpenDialog(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), Checks.remainingSafe((CustomBuffer)paramBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_OpenDialog(@NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer, @NativeType("nfdfilteritem_t const *") NFDFilterItem.Buffer paramBuffer, @NativeType("nfdchar_t const *") CharSequence paramCharSequence) {
/* 179 */     if (Checks.CHECKS) {
/* 180 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 181 */       if (paramBuffer != null) Struct.validate(paramBuffer.address(), Checks.remainingSafe((CustomBuffer)paramBuffer), NFDFilterItem.SIZEOF, NFDFilterItem::validate); 
/*     */     }  MemoryStack memoryStack;
/* 183 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 185 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/* 186 */       long l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/* 187 */       return nNFD_OpenDialog(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), Checks.remainingSafe((CustomBuffer)paramBuffer), l);
/*     */     } finally {
/* 189 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_OpenDialogMultiple(@NativeType("nfdpathset_t const **") PointerBuffer paramPointerBuffer, @NativeType("nfdfilteritem_t const *") NFDFilterItem.Buffer paramBuffer, @NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer) {
/* 211 */     if (Checks.CHECKS) {
/* 212 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 213 */       Checks.checkNT1Safe(paramByteBuffer);
/* 214 */       if (paramBuffer != null) Struct.validate(paramBuffer.address(), Checks.remainingSafe((CustomBuffer)paramBuffer), NFDFilterItem.SIZEOF, NFDFilterItem::validate); 
/*     */     } 
/* 216 */     return nNFD_OpenDialogMultiple(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), Checks.remainingSafe((CustomBuffer)paramBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_OpenDialogMultiple(@NativeType("nfdpathset_t const **") PointerBuffer paramPointerBuffer, @NativeType("nfdfilteritem_t const *") NFDFilterItem.Buffer paramBuffer, @NativeType("nfdchar_t const *") CharSequence paramCharSequence) {
/* 228 */     if (Checks.CHECKS) {
/* 229 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 230 */       if (paramBuffer != null) Struct.validate(paramBuffer.address(), Checks.remainingSafe((CustomBuffer)paramBuffer), NFDFilterItem.SIZEOF, NFDFilterItem::validate); 
/*     */     }  MemoryStack memoryStack;
/* 232 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 234 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/* 235 */       long l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/* 236 */       return nNFD_OpenDialogMultiple(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), Checks.remainingSafe((CustomBuffer)paramBuffer), l);
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_SaveDialog(@NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer, @NativeType("nfdfilteritem_t const *") NFDFilterItem.Buffer paramBuffer, @NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer1, @NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer2) {
/* 260 */     if (Checks.CHECKS) {
/* 261 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 262 */       Checks.checkNT1Safe(paramByteBuffer1);
/* 263 */       Checks.checkNT1Safe(paramByteBuffer2);
/* 264 */       if (paramBuffer != null) Struct.validate(paramBuffer.address(), Checks.remainingSafe((CustomBuffer)paramBuffer), NFDFilterItem.SIZEOF, NFDFilterItem::validate); 
/*     */     } 
/* 266 */     return nNFD_SaveDialog(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), Checks.remainingSafe((CustomBuffer)paramBuffer), MemoryUtil.memAddressSafe(paramByteBuffer1), MemoryUtil.memAddressSafe(paramByteBuffer2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_SaveDialog(@NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer, @NativeType("nfdfilteritem_t const *") NFDFilterItem.Buffer paramBuffer, @NativeType("nfdchar_t const *") CharSequence paramCharSequence1, @NativeType("nfdchar_t const *") CharSequence paramCharSequence2) {
/* 278 */     if (Checks.CHECKS) {
/* 279 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 280 */       if (paramBuffer != null) Struct.validate(paramBuffer.address(), Checks.remainingSafe((CustomBuffer)paramBuffer), NFDFilterItem.SIZEOF, NFDFilterItem::validate); 
/*     */     }  MemoryStack memoryStack;
/* 282 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 284 */       memoryStack.nUTF8Safe(paramCharSequence1, true);
/* 285 */       long l1 = (paramCharSequence1 == null) ? 0L : memoryStack.getPointerAddress();
/* 286 */       memoryStack.nUTF8Safe(paramCharSequence2, true);
/* 287 */       long l2 = (paramCharSequence2 == null) ? 0L : memoryStack.getPointerAddress();
/* 288 */       return nNFD_SaveDialog(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe((Pointer)paramBuffer), Checks.remainingSafe((CustomBuffer)paramBuffer), l1, l2);
/*     */     } finally {
/* 290 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PickFolder(@NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer, @NativeType("nfdchar_t const *") ByteBuffer paramByteBuffer) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/* 310 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     } 
/* 312 */     return nNFD_PickFolder(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PickFolder(@NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer, @NativeType("nfdchar_t const *") CharSequence paramCharSequence) {
/* 324 */     if (Checks.CHECKS)
/* 325 */       Checks.check((CustomBuffer)paramPointerBuffer, 1); 
/*     */     MemoryStack memoryStack;
/* 327 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 329 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/* 330 */       long l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress();
/* 331 */       return nNFD_PickFolder(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer), l);
/*     */     } finally {
/* 333 */       memoryStack.setPointer(i);
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
/*     */   @NativeType("char const *")
/*     */   public static String NFD_GetError() {
/*     */     long l;
/* 352 */     return MemoryUtil.memUTF8Safe(l = nNFD_GetError());
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PathSet_GetCount(@NativeType("nfdpathset_t const *") long paramLong, @NativeType("nfdpathsetsize_t *") IntBuffer paramIntBuffer) {
/* 372 */     if (Checks.CHECKS) {
/* 373 */       Checks.check(paramLong);
/* 374 */       Checks.check(paramIntBuffer, 1);
/*     */     } 
/* 376 */     return nNFD_PathSet_GetCount(paramLong, MemoryUtil.memAddress(paramIntBuffer));
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PathSet_GetPath(@NativeType("nfdpathset_t const *") long paramLong, @NativeType("nfdpathsetsize_t") int paramInt, @NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer) {
/* 391 */     if (Checks.CHECKS) {
/* 392 */       Checks.check(paramLong);
/* 393 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     } 
/* 395 */     return nNFD_PathSet_GetPath(paramLong, paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void NFD_PathSet_FreePath(@NativeType("nfdchar_t *") ByteBuffer paramByteBuffer) {
/* 405 */     if (Checks.CHECKS) {
/* 406 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 408 */     nNFD_PathSet_FreePath(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void NFD_PathSet_FreePath(@NativeType("nfdchar_t *") long paramLong) {
/* 413 */     nNFD_PathSet_FreePath(paramLong);
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PathSet_GetEnum(@NativeType("nfdpathset_t const *") long paramLong, @NativeType("nfdpathsetenum_t *") NFDPathSetEnum paramNFDPathSetEnum) {
/* 429 */     if (Checks.CHECKS) {
/* 430 */       Checks.check(paramLong);
/*     */     }
/* 432 */     return nNFD_PathSet_GetEnum(paramLong, paramNFDPathSetEnum.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void NFD_PathSet_FreeEnum(@NativeType("nfdpathsetenum_t *") NFDPathSetEnum paramNFDPathSetEnum) {
/* 442 */     nNFD_PathSet_FreeEnum(paramNFDPathSetEnum.address());
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
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PathSet_EnumNext(@NativeType("nfdpathsetenum_t *") NFDPathSetEnum paramNFDPathSetEnum, @NativeType("nfdchar_t **") PointerBuffer paramPointerBuffer) {
/* 459 */     if (Checks.CHECKS) {
/* 460 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/* 462 */     return nNFD_PathSet_EnumNext(paramNFDPathSetEnum.address(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void NFD_PathSet_Free(@NativeType("nfdpathset_t const *") long paramLong) {
/* 472 */     if (Checks.CHECKS) {
/* 473 */       Checks.check(paramLong);
/*     */     }
/* 475 */     nNFD_PathSet_Free(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("nfdresult_t")
/*     */   public static int NFD_PathSet_GetCount(@NativeType("nfdpathset_t const *") long paramLong, @NativeType("nfdpathsetsize_t *") int[] paramArrayOfint) {
/* 484 */     if (Checks.CHECKS) {
/* 485 */       Checks.check(paramLong);
/* 486 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 488 */     return nNFD_PathSet_GetCount(paramLong, paramArrayOfint);
/*     */   }
/*     */   
/*     */   public static native void nNFD_FreePath(long paramLong);
/*     */   
/*     */   @NativeType("nfdresult_t")
/*     */   public static native int NFD_Init();
/*     */   
/*     */   public static native void NFD_Quit();
/*     */   
/*     */   public static native int nNFD_OpenDialog(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*     */   
/*     */   public static native int nNFD_OpenDialogMultiple(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*     */   
/*     */   public static native int nNFD_SaveDialog(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nNFD_PickFolder(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nNFD_GetError();
/*     */   
/*     */   public static native void NFD_ClearError();
/*     */   
/*     */   public static native int nNFD_PathSet_GetCount(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nNFD_PathSet_GetPath(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native void nNFD_PathSet_FreePath(long paramLong);
/*     */   
/*     */   public static native int nNFD_PathSet_GetEnum(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nNFD_PathSet_FreeEnum(long paramLong);
/*     */   
/*     */   public static native int nNFD_PathSet_EnumNext(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nNFD_PathSet_Free(long paramLong);
/*     */   
/*     */   public static native int nNFD_PathSet_GetCount(long paramLong, int[] paramArrayOfint);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjg\\util\nfd\NativeFileDialog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */