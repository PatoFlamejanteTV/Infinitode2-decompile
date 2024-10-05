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
/*    */ @FunctionalInterface
/*    */ @NativeType("extent_destroy_t")
/*    */ public interface ExtentDestroyI
/*    */   extends CallbackI
/*    */ {
/* 33 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_uint8, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint8, LibFFI.ffi_type_uint32 });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 40 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 44 */     boolean bool = invoke(
/* 45 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)), 
/* 46 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 47 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 48 */         (MemoryUtil.memGetByte(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))) != 0), 
/* 49 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (4 * POINTER_SIZE))));
/*    */     
/* 51 */     APIUtil.apiClosureRet(paramLong1, bool);
/*    */   }
/*    */   
/*    */   @NativeType("bool")
/*    */   boolean invoke(@NativeType("extent_hooks_t *") long paramLong1, @NativeType("void *") long paramLong2, @NativeType("size_t") long paramLong3, @NativeType("bool") boolean paramBoolean, @NativeType("unsigned int") int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentDestroyI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */