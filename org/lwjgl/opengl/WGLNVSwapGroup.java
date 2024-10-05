/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
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
/*     */ public class WGLNVSwapGroup
/*     */ {
/*     */   protected WGLNVSwapGroup() {
/*  30 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglJoinSwapGroupNV(@NativeType("HDC") long paramLong, @NativeType("GLuint") int paramInt) {
/*  37 */     long l = (GL.getCapabilitiesWGL()).wglJoinSwapGroupNV;
/*  38 */     if (Checks.CHECKS) {
/*  39 */       Checks.check(l);
/*  40 */       Checks.check(paramLong);
/*     */     } 
/*  42 */     return (JNI.callPI(paramLong, paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglBindSwapBarrierNV(@NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  49 */     long l = (GL.getCapabilitiesWGL()).wglBindSwapBarrierNV;
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(l);
/*     */     }
/*  53 */     return (JNI.callI(paramInt1, paramInt2, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQuerySwapGroupNV(long paramLong1, long paramLong2, long paramLong3) {
/*  59 */     long l = (GL.getCapabilitiesWGL()).wglQuerySwapGroupNV;
/*  60 */     if (Checks.CHECKS) {
/*  61 */       Checks.check(l);
/*  62 */       Checks.check(paramLong1);
/*     */     } 
/*  64 */     return JNI.callPPPI(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQuerySwapGroupNV(@NativeType("HDC") long paramLong, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2) {
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(paramIntBuffer1, 1);
/*  71 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/*  73 */     return (nwglQuerySwapGroupNV(paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQueryMaxSwapGroupsNV(long paramLong1, long paramLong2, long paramLong3) {
/*  79 */     long l = (GL.getCapabilitiesWGL()).wglQueryMaxSwapGroupsNV;
/*  80 */     if (Checks.CHECKS) {
/*  81 */       Checks.check(l);
/*  82 */       Checks.check(paramLong1);
/*     */     } 
/*  84 */     return JNI.callPPPI(paramLong1, paramLong2, paramLong3, l);
/*     */   }
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryMaxSwapGroupsNV(@NativeType("HDC") long paramLong, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2) {
/*  89 */     if (Checks.CHECKS) {
/*  90 */       Checks.check(paramIntBuffer1, 1);
/*  91 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/*  93 */     return (nwglQueryMaxSwapGroupsNV(paramLong, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nwglQueryFrameCountNV(long paramLong1, long paramLong2) {
/*  99 */     long l = (GL.getCapabilitiesWGL()).wglQueryFrameCountNV;
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(l);
/* 102 */       Checks.check(paramLong1);
/*     */     } 
/* 104 */     return JNI.callPPI(paramLong1, paramLong2, l);
/*     */   }
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryFrameCountNV(@NativeType("HDC") long paramLong, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 109 */     if (Checks.CHECKS) {
/* 110 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 112 */     return (nwglQueryFrameCountNV(paramLong, MemoryUtil.memAddress(paramIntBuffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglResetFrameCountNV(@NativeType("HDC") long paramLong) {
/* 119 */     long l = (GL.getCapabilitiesWGL()).wglResetFrameCountNV;
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(l);
/* 122 */       Checks.check(paramLong);
/*     */     } 
/* 124 */     return (JNI.callPI(paramLong, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQuerySwapGroupNV(@NativeType("HDC") long paramLong, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 130 */     long l = (GL.getCapabilitiesWGL()).wglQuerySwapGroupNV;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(l);
/* 133 */       Checks.check(paramLong);
/* 134 */       Checks.check(paramArrayOfint1, 1);
/* 135 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 137 */     return (JNI.callPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryMaxSwapGroupsNV(@NativeType("HDC") long paramLong, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 143 */     long l = (GL.getCapabilitiesWGL()).wglQueryMaxSwapGroupsNV;
/* 144 */     if (Checks.CHECKS) {
/* 145 */       Checks.check(l);
/* 146 */       Checks.check(paramLong);
/* 147 */       Checks.check(paramArrayOfint1, 1);
/* 148 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 150 */     return (JNI.callPPPI(paramLong, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("BOOL")
/*     */   public static boolean wglQueryFrameCountNV(@NativeType("HDC") long paramLong, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 156 */     long l = (GL.getCapabilitiesWGL()).wglQueryFrameCountNV;
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(l);
/* 159 */       Checks.check(paramLong);
/* 160 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 162 */     return (JNI.callPPI(paramLong, paramArrayOfint, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\WGLNVSwapGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */