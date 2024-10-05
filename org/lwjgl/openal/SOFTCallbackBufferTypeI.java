/*    */ package org.lwjgl.openal;
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
/*    */ @FunctionalInterface
/*    */ @NativeType("ALBUFFERCALLBACKTYPESOFT")
/*    */ public interface SOFTCallbackBufferTypeI
/*    */   extends CallbackI
/*    */ {
/* 29 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32 });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 36 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 40 */     long l = invoke(
/* 41 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)), 
/* 42 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 43 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))));
/*    */     
/* 45 */     APIUtil.apiClosureRetP(paramLong1, l);
/*    */   }
/*    */   
/*    */   @NativeType("void *")
/*    */   long invoke(@NativeType("ALvoid *") long paramLong1, @NativeType("ALvoid *") long paramLong2, @NativeType("ALsizei") int paramInt);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTCallbackBufferTypeI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */