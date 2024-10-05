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
/*     */ public class GLXNVSwapGroup
/*     */ {
/*     */   protected GLXNVSwapGroup() {
/*  30 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXJoinSwapGroupNV(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLuint") int paramInt) {
/*  38 */     long l = (GL.getCapabilitiesGLXClient()).glXJoinSwapGroupNV;
/*  39 */     if (Checks.CHECKS) {
/*  40 */       Checks.check(l);
/*  41 */       Checks.check(paramLong1);
/*  42 */       Checks.check(paramLong2);
/*     */     } 
/*  44 */     return (JNI.callPPI(paramLong1, paramLong2, paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXBindSwapBarrierNV(@NativeType("Display *") long paramLong, @NativeType("GLuint") int paramInt1, @NativeType("GLuint") int paramInt2) {
/*  52 */     long l = (GL.getCapabilitiesGLXClient()).glXBindSwapBarrierNV;
/*  53 */     if (Checks.CHECKS) {
/*  54 */       Checks.check(l);
/*  55 */       Checks.check(paramLong);
/*     */     } 
/*  57 */     return (JNI.callPI(paramLong, paramInt1, paramInt2, l) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQuerySwapGroupNV(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  64 */     long l = (GL.getCapabilitiesGLXClient()).glXQuerySwapGroupNV;
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(l);
/*  67 */       Checks.check(paramLong1);
/*  68 */       Checks.check(paramLong2);
/*     */     } 
/*  70 */     return JNI.callPPPPI(paramLong1, paramLong2, paramLong3, paramLong4, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQuerySwapGroupNV(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2) {
/*  76 */     if (Checks.CHECKS) {
/*  77 */       Checks.check(paramIntBuffer1, 1);
/*  78 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/*  80 */     return (nglXQuerySwapGroupNV(paramLong1, paramLong2, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryMaxSwapGroupsNV(long paramLong1, int paramInt, long paramLong2, long paramLong3) {
/*  87 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapGroupsNV;
/*  88 */     if (Checks.CHECKS) {
/*  89 */       Checks.check(l);
/*  90 */       Checks.check(paramLong1);
/*     */     } 
/*  92 */     return JNI.callPPPI(paramLong1, paramInt, paramLong2, paramLong3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryMaxSwapGroupsNV(@NativeType("Display *") long paramLong, int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer1, @NativeType("GLuint *") IntBuffer paramIntBuffer2) {
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(paramIntBuffer1, 1);
/* 100 */       Checks.check(paramIntBuffer2, 1);
/*     */     } 
/* 102 */     return (nglXQueryMaxSwapGroupsNV(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer1), MemoryUtil.memAddress(paramIntBuffer2)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryFrameCountNV(long paramLong1, int paramInt, long paramLong2) {
/* 109 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryFrameCountNV;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(l);
/* 112 */       Checks.check(paramLong1);
/*     */     } 
/* 114 */     return JNI.callPPI(paramLong1, paramInt, paramLong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryFrameCountNV(@NativeType("Display *") long paramLong, int paramInt, @NativeType("GLuint *") IntBuffer paramIntBuffer) {
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/* 123 */     return (nglXQueryFrameCountNV(paramLong, paramInt, MemoryUtil.memAddress(paramIntBuffer)) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXResetFrameCountNV(@NativeType("Display *") long paramLong, int paramInt) {
/* 131 */     long l = (GL.getCapabilitiesGLXClient()).glXResetFrameCountNV;
/* 132 */     if (Checks.CHECKS) {
/* 133 */       Checks.check(l);
/* 134 */       Checks.check(paramLong);
/*     */     } 
/* 136 */     return (JNI.callPI(paramLong, paramInt, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQuerySwapGroupNV(@NativeType("Display *") long paramLong1, @NativeType("GLXDrawable") long paramLong2, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 142 */     long l = (GL.getCapabilitiesGLXClient()).glXQuerySwapGroupNV;
/* 143 */     if (Checks.CHECKS) {
/* 144 */       Checks.check(l);
/* 145 */       Checks.check(paramLong1);
/* 146 */       Checks.check(paramLong2);
/* 147 */       Checks.check(paramArrayOfint1, 1);
/* 148 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 150 */     return (JNI.callPPPPI(paramLong1, paramLong2, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryMaxSwapGroupsNV(@NativeType("Display *") long paramLong, int paramInt, @NativeType("GLuint *") int[] paramArrayOfint1, @NativeType("GLuint *") int[] paramArrayOfint2) {
/* 156 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryMaxSwapGroupsNV;
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(l);
/* 159 */       Checks.check(paramLong);
/* 160 */       Checks.check(paramArrayOfint1, 1);
/* 161 */       Checks.check(paramArrayOfint2, 1);
/*     */     } 
/* 163 */     return (JNI.callPPPI(paramLong, paramInt, paramArrayOfint1, paramArrayOfint2, l) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("Bool")
/*     */   public static boolean glXQueryFrameCountNV(@NativeType("Display *") long paramLong, int paramInt, @NativeType("GLuint *") int[] paramArrayOfint) {
/* 169 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryFrameCountNV;
/* 170 */     if (Checks.CHECKS) {
/* 171 */       Checks.check(l);
/* 172 */       Checks.check(paramLong);
/* 173 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 175 */     return (JNI.callPPI(paramLong, paramInt, paramArrayOfint, l) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXNVSwapGroup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */