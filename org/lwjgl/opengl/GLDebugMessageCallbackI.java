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
/*    */ 
/*    */ @FunctionalInterface
/*    */ @NativeType("GLDEBUGPROC")
/*    */ public interface GLDebugMessageCallbackI
/*    */   extends CallbackI
/*    */ {
/* 35 */   public static final FFICIF CIF = APIUtil.apiCreateCIF(
/* 36 */       APIUtil.apiStdcall(), LibFFI.ffi_type_void, new FFIType[] { LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_uint32, LibFFI.ffi_type_sint32, LibFFI.ffi_type_pointer, LibFFI.ffi_type_pointer });
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default FFICIF getCallInterface() {
/* 42 */     return CIF;
/*    */   }
/*    */   
/*    */   default void callback(long paramLong1, long paramLong2) {
/* 46 */     invoke(
/* 47 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2)), 
/* 48 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + POINTER_SIZE)), 
/* 49 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (2 * POINTER_SIZE))), 
/* 50 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (3 * POINTER_SIZE))), 
/* 51 */         MemoryUtil.memGetInt(MemoryUtil.memGetAddress(paramLong2 + (4 * POINTER_SIZE))), 
/* 52 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (5 * POINTER_SIZE))), 
/* 53 */         MemoryUtil.memGetAddress(MemoryUtil.memGetAddress(paramLong2 + (6 * POINTER_SIZE))));
/*    */   }
/*    */   
/*    */   void invoke(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLchar const *") long paramLong1, @NativeType("void const *") long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLDebugMessageCallbackI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */