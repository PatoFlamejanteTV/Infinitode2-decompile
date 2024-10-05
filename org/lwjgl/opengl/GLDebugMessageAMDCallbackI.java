/*    */ package org.lwjgl.opengl;
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
/*    */ @FunctionalInterface
/*    */ @NativeType("GLDEBUGPROCAMD")
/*    */ public interface GLDebugMessageAMDCallbackI
/*    */   extends CallbackI
/*    */ {
/* 34 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(
/* 35 */       APIUtil.apiStdcall(), LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer });
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 41 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 45 */     invoke(
/* 46 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2)), 
/* 47 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 48 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 49 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))), 
/* 50 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (4 * POINTER_SIZE))), 
/* 51 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (5 * POINTER_SIZE))));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLchar const *") long paramLong1, @NativeType("void *") long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLDebugMessageAMDCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */