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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WGLNVGPUAffinity
/*     */ {
/*     */   public static final int ERROR_INCOMPATIBLE_AFFINITY_MASKS_NV = 8400;
/*     */   public static final int ERROR_MISSING_AFFINITY_MASK_NV = 8401;
/*     */   
/*     */   protected WGLNVGPUAffinity() {
/*  37 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglEnumGpusNV(int paramInt, long paramLong) {
/*  44 */     long l = (GL.getCapabilitiesWGL()).wglEnumGpusNV;
/*  45 */     if (Checks.CHECKS) {
/*  46 */       Checks.check(l);
/*     */     }
/*  48 */     return JNI.callPI(paramInt, paramLong, l);
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
/*     */   public static boolean wglEnumGpusNV(@NativeType("UINT") int paramInt, @NativeType("HGPUNV *") PointerBuffer paramPointerBuffer) {
/*  63 */     if (Checks.CHECKS) {
/*  64 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/*  66 */     return (nwglEnumGpusNV(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglEnumGpuDevicesNV(long paramLong1, int paramInt, long paramLong2) {
/*  73 */     long l = (GL.getCapabilitiesWGL()).wglEnumGpuDevicesNV;
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(l);
/*  76 */       Checks.check(paramLong1);
/*     */     } 
/*  78 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglEnumGpuDevicesNV(@NativeType("HGPUNV") long paramLong, @NativeType("UINT") int paramInt, @NativeType("PGPU_DEVICE") GPU_DEVICE paramGPU_DEVICE) {
/*  90 */     return (nwglEnumGpuDevicesNV(paramLong, paramInt, paramGPU_DEVICE.address()) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nwglCreateAffinityDCNV(long paramLong) {
/*  97 */     long l = (GL.getCapabilitiesWGL()).wglCreateAffinityDCNV;
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(l);
/*     */     }
/* 101 */     return JNI.callPP(paramLong, l);
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
/*     */   @NativeType("HDC")
/*     */   public static long wglCreateAffinityDCNV(@NativeType("HGPUNV const *") PointerBuffer paramPointerBuffer) {
/* 116 */     if (Checks.CHECKS) {
/* 117 */       Checks.checkNT(paramPointerBuffer);
/*     */     }
/* 119 */     return nwglCreateAffinityDCNV(MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglEnumGpusFromAffinityDCNV(long paramLong1, int paramInt, long paramLong2) {
/* 126 */     long l = (GL.getCapabilitiesWGL()).wglEnumGpusFromAffinityDCNV;
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(l);
/* 129 */       Checks.check(paramLong1);
/*     */     } 
/* 131 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
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
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglEnumGpusFromAffinityDCNV(@NativeType("HDC") long paramLong, @NativeType("UINT") int paramInt, @NativeType("HGPUNV *") PointerBuffer paramPointerBuffer) {
/* 147 */     if (Checks.CHECKS) {
/* 148 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/* 150 */     return (nwglEnumGpusFromAffinityDCNV(paramLong, paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglDeleteDCNV(@NativeType("HDC") long paramLong) {
/* 162 */     long l = (GL.getCapabilitiesWGL()).wglDeleteDCNV;
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.check(l);
/* 165 */       Checks.check(paramLong);
/*     */     } 
/* 167 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLNVGPUAffinity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */