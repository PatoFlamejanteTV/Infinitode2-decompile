/*    */ package org.lwjgl.system.macosx;
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
/*    */ @NativeType("EnumerationMutationHandler")
/*    */ public interface EnumerationMutationHandlerI
/*    */   extends CallbackI
/*    */ {
/* 29 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(LibFFI.FFI_DEFAULT_ABI, LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_pointer });
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
/* 40 */     invoke(
/* 41 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2)));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("id") long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\EnumerationMutationHandlerI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */