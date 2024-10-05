/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTSemaphoreWin32
/*    */ {
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_EXT = 38279;
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_KMT_EXT = 38280;
/*    */   public static final int GL_DEVICE_LUID_EXT = 38297;
/*    */   public static final int GL_DEVICE_NODE_MASK_EXT = 38298;
/*    */   public static final int GL_LUID_SIZE_EXT = 8;
/*    */   public static final int GL_HANDLE_TYPE_D3D12_FENCE_EXT = 38292;
/*    */   public static final int GL_D3D12_FENCE_VALUE_EXT = 38293;
/*    */   
/*    */   static {
/* 20 */     GL.initialize();
/*    */   }
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
/*    */   protected EXTSemaphoreWin32() {
/* 49 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportSemaphoreWin32HandleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void *") long paramLong) {
/* 57 */     if (Checks.CHECKS) {
/* 58 */       Checks.check(paramLong);
/*    */     }
/* 60 */     nglImportSemaphoreWin32HandleEXT(paramInt1, paramInt2, paramLong);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportSemaphoreWin32NameEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong) {
/* 68 */     if (Checks.CHECKS) {
/* 69 */       Checks.check(paramLong);
/*    */     }
/* 71 */     nglImportSemaphoreWin32NameEXT(paramInt1, paramInt2, paramLong);
/*    */   }
/*    */   
/*    */   public static native void nglImportSemaphoreWin32HandleEXT(int paramInt1, int paramInt2, long paramLong);
/*    */   
/*    */   public static native void nglImportSemaphoreWin32NameEXT(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTSemaphoreWin32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */