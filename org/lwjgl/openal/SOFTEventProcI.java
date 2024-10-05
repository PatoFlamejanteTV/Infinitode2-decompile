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
/*    */ 
/*    */ 
/*    */ 
/*    */ @FunctionalInterface
/*    */ @NativeType("ALEVENTPROCSOFT")
/*    */ public interface SOFTEventProcI
/*    */   extends CallbackI
/*    */ {
/* 32 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_sint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 39 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 43 */     invoke(
/* 44 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2)), 
/* 45 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 46 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 47 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))), 
/* 48 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (4 * POINTER_SIZE))), 
/* 49 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (5 * POINTER_SIZE))));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("ALenum") int paramInt1, @NativeType("ALuint") int paramInt2, @NativeType("ALuint") int paramInt3, @NativeType("ALsizei") int paramInt4, @NativeType("ALchar const *") long paramLong1, @NativeType("ALvoid *") long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTEventProcI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */