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
/*    */ @FunctionalInterface
/*    */ @NativeType("GLFWkeyfun")
/*    */ public interface GLFWKeyCallbackI
/*    */   extends CallbackI
/*    */ {
/* 33 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_sint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_sint32 });
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
/* 44 */     invoke(
/* 45 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)), 
/* 46 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 47 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 48 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))), 
/* 49 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (4 * POINTER_SIZE))));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("GLFWwindow *") long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\glfw\GLFWKeyCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */