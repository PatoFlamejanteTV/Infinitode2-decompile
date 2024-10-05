/*    */ package org.lwjgl.system.windows;
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
/*    */ @NativeType("WNDPROC")
/*    */ public interface WindowProcI
/*    */   extends CallbackI
/*    */ {
/* 32 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(
/* 33 */       APIUtil.apiStdcall(), LibFFI.ffi_type_pointer, new FFIType[] { LibFFI.ffi_type_pointer, LibFFI.ffi_type_uint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer });
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 39 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 43 */     long l = invoke(
/* 44 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)), 
/* 45 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 46 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 47 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))));
/*    */     
/* 49 */     APIUtil.apiClosureRetP(paramLong1, l);
/*    */   }
/*    */   
/*    */   @NativeType("LRESULT")
/*    */   long invoke(@NativeType("HWND") long paramLong1, @NativeType("UINT") int paramInt, @NativeType("WPARAM") long paramLong2, @NativeType("LPARAM") long paramLong3);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WindowProcI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */