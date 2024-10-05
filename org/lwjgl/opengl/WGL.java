/*     */ package org.lwjgl.opengl;public class WGL { public static final int WGL_FONT_LINES = 0; public static final int WGL_FONT_POLYGONS = 1; public static final int WGL_SWAP_MAIN_PLANE = 1; public static final int WGL_SWAP_OVERLAY1 = 2; public static final int WGL_SWAP_OVERLAY2 = 4; public static final int WGL_SWAP_OVERLAY3 = 8; public static final int WGL_SWAP_OVERLAY4 = 16;
/*     */   public static final int WGL_SWAP_OVERLAY5 = 32;
/*     */   public static final int WGL_SWAP_OVERLAY6 = 64;
/*     */   public static final int WGL_SWAP_OVERLAY7 = 128;
/*     */   public static final int WGL_SWAP_OVERLAY8 = 256;
/*     */   public static final int WGL_SWAP_OVERLAY9 = 512;
/*     */   public static final int WGL_SWAP_OVERLAY10 = 1024;
/*     */   public static final int WGL_SWAP_OVERLAY11 = 2048;
/*     */   public static final int WGL_SWAP_OVERLAY12 = 4096;
/*     */   public static final int WGL_SWAP_OVERLAY13 = 8192;
/*     */   public static final int WGL_SWAP_OVERLAY14 = 16384;
/*     */   public static final int WGL_SWAP_OVERLAY15 = 32768;
/*     */   public static final int WGL_SWAP_UNDERLAY1 = 65536;
/*     */   public static final int WGL_SWAP_UNDERLAY2 = 131072;
/*     */   public static final int WGL_SWAP_UNDERLAY3 = 262144;
/*     */   public static final int WGL_SWAP_UNDERLAY4 = 524288;
/*     */   public static final int WGL_SWAP_UNDERLAY5 = 1048576;
/*     */   public static final int WGL_SWAP_UNDERLAY6 = 2097152;
/*     */   public static final int WGL_SWAP_UNDERLAY7 = 4194304;
/*     */   
/*     */   static {
/*  22 */     GL.initialize();
/*     */   }
/*     */   public static final int WGL_SWAP_UNDERLAY8 = 8388608; public static final int WGL_SWAP_UNDERLAY9 = 16777216; public static final int WGL_SWAP_UNDERLAY10 = 33554432;
/*     */   public static final int WGL_SWAP_UNDERLAY11 = 67108864;
/*     */   public static final int WGL_SWAP_UNDERLAY12 = 134217728;
/*     */   public static final int WGL_SWAP_UNDERLAY13 = 268435456;
/*     */   public static final int WGL_SWAP_UNDERLAY14 = 536870912;
/*     */   public static final int WGL_SWAP_UNDERLAY15 = 1073741824;
/*     */   
/*  31 */   public static final class Functions { public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCreateContext");
/*  32 */     public static final long CreateLayerContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCreateLayerContext");
/*  33 */     public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCopyContext");
/*  34 */     public static final long DeleteContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglDeleteContext");
/*  35 */     public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetCurrentContext");
/*  36 */     public static final long GetCurrentDC = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetCurrentDC");
/*  37 */     public static final long GetProcAddress = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetProcAddress");
/*  38 */     public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglMakeCurrent");
/*  39 */     public static final long ShareLists = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglShareLists"); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected WGL() {
/*  83 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateContext(@NativeType("HDC") long paramLong) {
/*  99 */     long l = Functions.CreateContext;
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(paramLong);
/*     */     }
/* 103 */     return nwglCreateContext(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglCreateLayerContext(@NativeType("HDC") long paramLong, int paramInt) {
/* 123 */     long l = Functions.CreateLayerContext;
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(paramLong);
/*     */     }
/* 127 */     return nwglCreateLayerContext(paramLong, paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglCopyContext(@NativeType("HGLRC") long paramLong1, @NativeType("HGLRC") long paramLong2, @NativeType("UINT") int paramInt) {
/* 145 */     long l = Functions.CopyContext;
/* 146 */     if (Checks.CHECKS) {
/* 147 */       Checks.check(paramLong1);
/* 148 */       Checks.check(paramLong2);
/*     */     } 
/* 150 */     return (nwglCopyContext(paramLong1, paramLong2, paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDeleteContext(@NativeType("HGLRC") long paramLong) {
/* 165 */     long l = Functions.DeleteContext;
/* 166 */     if (Checks.CHECKS) {
/* 167 */       Checks.check(paramLong);
/*     */     }
/* 169 */     return (nwglDeleteContext(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HGLRC")
/*     */   public static long wglGetCurrentContext() {
/*     */     long l;
/* 181 */     return nwglGetCurrentContext(l = Functions.GetCurrentContext);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HDC")
/*     */   public static long wglGetCurrentDC() {
/*     */     long l;
/* 193 */     return nwglGetCurrentDC(l = Functions.GetCurrentDC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglGetProcAddress(long paramLong) {
/* 203 */     long l = Functions.GetProcAddress;
/* 204 */     return nwglGetProcAddress(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("PROC")
/*     */   public static long wglGetProcAddress(@NativeType("LPCSTR") ByteBuffer paramByteBuffer) {
/* 215 */     if (Checks.CHECKS) {
/* 216 */       Checks.checkNT1(paramByteBuffer);
/*     */     }
/* 218 */     return nwglGetProcAddress(MemoryUtil.memAddress(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("PROC")
/*     */   public static long wglGetProcAddress(@NativeType("LPCSTR") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 229 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 231 */       memoryStack.nASCII(paramCharSequence, true);
/*     */       long l;
/* 233 */       return nwglGetProcAddress(l = memoryStack.getPointerAddress());
/*     */     } finally {
/* 235 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglMakeCurrent(@NativeType("HDC") long paramLong1, @NativeType("HGLRC") long paramLong2) {
/* 255 */     long l = Functions.MakeCurrent;
/* 256 */     return (nwglMakeCurrent(paramLong1, paramLong2, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglShareLists(@NativeType("HGLRC") long paramLong1, @NativeType("HGLRC") long paramLong2) {
/* 273 */     long l = Functions.ShareLists;
/* 274 */     if (Checks.CHECKS) {
/* 275 */       Checks.check(paramLong1);
/* 276 */       Checks.check(paramLong2);
/*     */     } 
/* 278 */     return (nwglShareLists(paramLong1, paramLong2, l) != 0);
/*     */   }
/*     */   
/*     */   public static native long nwglCreateContext(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nwglCreateLayerContext(long paramLong1, int paramInt, long paramLong2);
/*     */   
/*     */   public static native int nwglCopyContext(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*     */   
/*     */   public static native int nwglDeleteContext(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nwglGetCurrentContext(long paramLong);
/*     */   
/*     */   public static native long nwglGetCurrentDC(long paramLong);
/*     */   
/*     */   public static native long nwglGetProcAddress(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native int nwglMakeCurrent(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nwglShareLists(long paramLong1, long paramLong2, long paramLong3); }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */