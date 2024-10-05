/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
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
/*     */ public class WGLNVDXInterop
/*     */ {
/*     */   public static final int WGL_ACCESS_READ_ONLY_NV = 0;
/*     */   public static final int WGL_ACCESS_READ_WRITE_NV = 1;
/*     */   public static final int WGL_ACCESS_WRITE_DISCARD_NV = 2;
/*     */   
/*     */   protected WGLNVDXInterop() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXSetResourceShareHandleNV(@NativeType("void *") long paramLong1, @NativeType("HANDLE") long paramLong2) {
/*  44 */     long l = (GL.getCapabilitiesWGL()).wglDXSetResourceShareHandleNV;
/*  45 */     if (Checks.CHECKS) {
/*  46 */       Checks.check(l);
/*  47 */       Checks.check(paramLong1);
/*  48 */       Checks.check(paramLong2);
/*     */     } 
/*  50 */     return (JNI.callPPI(paramLong1, paramLong2, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("HANDLE")
/*     */   public static long wglDXOpenDeviceNV(@NativeType("void *") long paramLong) {
/*  62 */     long l = (GL.getCapabilitiesWGL()).wglDXOpenDeviceNV;
/*  63 */     if (Checks.CHECKS) {
/*  64 */       Checks.check(l);
/*  65 */       Checks.check(paramLong);
/*     */     } 
/*  67 */     return JNI.callPP(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXCloseDeviceNV(@NativeType("HANDLE") long paramLong) {
/*  74 */     long l = (GL.getCapabilitiesWGL()).wglDXCloseDeviceNV;
/*  75 */     if (Checks.CHECKS) {
/*  76 */       Checks.check(l);
/*  77 */       Checks.check(paramLong);
/*     */     } 
/*  79 */     return (JNI.callPI(paramLong, l) != 0);
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
/*     */   @NativeType("HANDLE")
/*     */   public static long wglDXRegisterObjectNV(@NativeType("HANDLE") long paramLong1, @NativeType("void *") long paramLong2, @NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3) {
/*  95 */     long l = (GL.getCapabilitiesWGL()).wglDXRegisterObjectNV;
/*  96 */     if (Checks.CHECKS) {
/*  97 */       Checks.check(l);
/*  98 */       Checks.check(paramLong1);
/*  99 */       Checks.check(paramLong2);
/*     */     } 
/* 101 */     return JNI.callPPP(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXUnregisterObjectNV(@NativeType("HANDLE") long paramLong1, @NativeType("HANDLE") long paramLong2) {
/* 108 */     long l = (GL.getCapabilitiesWGL()).wglDXUnregisterObjectNV;
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(l);
/* 111 */       Checks.check(paramLong1);
/* 112 */       Checks.check(paramLong2);
/*     */     } 
/* 114 */     return (JNI.callPPI(paramLong1, paramLong2, l) != 0);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXObjectAccessNV(@NativeType("HANDLE") long paramLong, @NativeType("GLenum") int paramInt) {
/* 127 */     long l = (GL.getCapabilitiesWGL()).wglDXObjectAccessNV;
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(l);
/* 130 */       Checks.check(paramLong);
/*     */     } 
/* 132 */     return (JNI.callPI(paramLong, paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglDXLockObjectsNV(long paramLong1, int paramInt, long paramLong2) {
/* 143 */     long l = (GL.getCapabilitiesWGL()).wglDXLockObjectsNV;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(l);
/* 146 */       Checks.check(paramLong1);
/*     */     } 
/* 148 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
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
/*     */   public static boolean wglDXLockObjectsNV(@NativeType("HANDLE") long paramLong, @NativeType("HANDLE *") PointerBuffer paramPointerBuffer) {
/* 166 */     return (nwglDXLockObjectsNV(paramLong, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglDXUnlockObjectsNV(long paramLong1, int paramInt, long paramLong2) {
/* 177 */     long l = (GL.getCapabilitiesWGL()).wglDXUnlockObjectsNV;
/* 178 */     if (Checks.CHECKS) {
/* 179 */       Checks.check(l);
/* 180 */       Checks.check(paramLong1);
/*     */     } 
/* 182 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDXUnlockObjectsNV(@NativeType("HANDLE") long paramLong, @NativeType("HANDLE *") PointerBuffer paramPointerBuffer) {
/* 193 */     return (nwglDXUnlockObjectsNV(paramLong, paramPointerBuffer.remaining(), MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer)) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLNVDXInterop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */