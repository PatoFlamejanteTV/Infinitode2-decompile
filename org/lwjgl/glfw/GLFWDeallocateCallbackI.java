/*    */ package org.lwjgl.glfw;
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
/*    */ @NativeType("GLFWdeallocatefun")
/*    */ public interface GLFWDeallocateCallbackI
/*    */   extends CallbackI
/*    */ {
/* 52 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 59 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 63 */     invoke(
/* 64 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)), 
/* 65 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("void *") long paramLong1, @NativeType("void *") long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWDeallocateCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */