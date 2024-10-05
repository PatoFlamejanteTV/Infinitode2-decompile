/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ public class EXTMemoryObjectWin32
/*    */ {
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_EXT = 38279;
/*    */   public static final int GL_HANDLE_TYPE_OPAQUE_WIN32_KMT_EXT = 38280;
/*    */   public static final int GL_DEVICE_LUID_EXT = 38297;
/*    */   public static final int GL_DEVICE_NODE_MASK_EXT = 38298;
/*    */   public static final int GL_LUID_SIZE_EXT = 8;
/*    */   public static final int GL_HANDLE_TYPE_D3D12_TILEPOOL_EXT = 38281;
/*    */   public static final int GL_HANDLE_TYPE_D3D12_RESOURCE_EXT = 38282;
/*    */   public static final int GL_HANDLE_TYPE_D3D11_IMAGE_EXT = 38283;
/*    */   public static final int GL_HANDLE_TYPE_D3D11_IMAGE_KMT_EXT = 38284;
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
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTMemoryObjectWin32() {
/* 52 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportMemoryWin32HandleEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint64") long paramLong1, @NativeType("GLenum") int paramInt2, @NativeType("void *") long paramLong2) {
/* 60 */     if (Checks.CHECKS) {
/* 61 */       Checks.check(paramLong2);
/*    */     }
/* 63 */     nglImportMemoryWin32HandleEXT(paramInt1, paramLong1, paramInt2, paramLong2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glImportMemoryWin32NameEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLuint64") long paramLong1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong2) {
/* 71 */     if (Checks.CHECKS) {
/* 72 */       Checks.check(paramLong2);
/*    */     }
/* 74 */     nglImportMemoryWin32NameEXT(paramInt1, paramLong1, paramInt2, paramLong2);
/*    */   }
/*    */   
/*    */   public static native void nglImportMemoryWin32HandleEXT(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */   
/*    */   public static native void nglImportMemoryWin32NameEXT(int paramInt1, long paramLong1, int paramInt2, long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTMemoryObjectWin32.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */