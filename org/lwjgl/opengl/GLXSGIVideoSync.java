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
/*     */ public class GLXSGIVideoSync
/*     */ {
/*     */   protected GLXSGIVideoSync() {
/*  24 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXGetVideoSyncSGI(long paramLong) {
/*  31 */     long l = (GL.getCapabilitiesGLXClient()).glXGetVideoSyncSGI;
/*  32 */     if (Checks.CHECKS) {
/*  33 */       Checks.check(l);
/*     */     }
/*  35 */     return JNI.callPI(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glXGetVideoSyncSGI(@NativeType("unsigned int *") IntBuffer paramIntBuffer) {
/*  45 */     if (Checks.CHECKS) {
/*  46 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  48 */     return nglXGetVideoSyncSGI(MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXWaitVideoSyncSGI(int paramInt1, int paramInt2, long paramLong) {
/*  55 */     long l = (GL.getCapabilitiesGLXClient()).glXWaitVideoSyncSGI;
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.check(l);
/*     */     }
/*  59 */     return JNI.callPI(paramInt1, paramInt2, paramLong, l);
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
/*     */   @NativeType("GLint")
/*     */   public static int glXWaitVideoSyncSGI(int paramInt1, int paramInt2, @NativeType("unsigned int *") IntBuffer paramIntBuffer) {
/*  77 */     if (Checks.CHECKS) {
/*  78 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  80 */     return nglXWaitVideoSyncSGI(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glXGetVideoSyncSGI(@NativeType("unsigned int *") int[] paramArrayOfint) {
/*  86 */     long l = (GL.getCapabilitiesGLXClient()).glXGetVideoSyncSGI;
/*  87 */     if (Checks.CHECKS) {
/*  88 */       Checks.check(l);
/*  89 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/*  91 */     return JNI.callPI(paramArrayOfint, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("GLint")
/*     */   public static int glXWaitVideoSyncSGI(int paramInt1, int paramInt2, @NativeType("unsigned int *") int[] paramArrayOfint) {
/*  97 */     long l = (GL.getCapabilitiesGLXClient()).glXWaitVideoSyncSGI;
/*  98 */     if (Checks.CHECKS) {
/*  99 */       Checks.check(l);
/* 100 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 102 */     return JNI.callPI(paramInt1, paramInt2, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXSGIVideoSync.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */