/*    */ package org.lwjgl.system.jemalloc;
/*    */ 
/*    */ import org.lwjgl.system.APIUtil;
/*    */ import org.lwjgl.system.CallbackI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
/*    */ import org.lwjgl.system.libffi.FFICIF;
/*    */ import org.lwjgl.system.libffi.FFIType;
/*    */ import org.lwjgl.system.libffi.LibFFI;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ @NativeType("extent_split_t")
/*    */ public interface ExtentSplitI
/*    */   extends CallbackI
/*    */ {
/* 35 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_uint8, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint8, LibFFI.ffi_type_uint32 });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 42 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 46 */     boolean bool = invoke(
/* 47 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)), 
/* 48 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 49 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 50 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))), 
/* 51 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (4 * POINTER_SIZE))), 
/* 52 */         (MemoryUtil.memGetByte(MemoryUtil.memGetAddress(paramLong2 + (5 * POINTER_SIZE))) != 0), 
/* 53 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (6 * POINTER_SIZE))));
/*    */     
/* 55 */     APIUtil.apiClosureRet(paramLong1, bool);
/*    */   }
/*    */   
/*    */   @NativeType("bool")
/*    */   boolean invoke(@NativeType("extent_hooks_t *") long paramLong1, @NativeType("void *") long paramLong2, @NativeType("size_t") long paramLong3, @NativeType("size_t") long paramLong4, @NativeType("size_t") long paramLong5, @NativeType("bool") boolean paramBoolean, @NativeType("unsigned int") int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentSplitI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */