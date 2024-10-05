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
/*     */ public class GLXEXTImportContext
/*     */ {
/*     */   public static final int GLX_SHARE_CONTEXT_EXT = 32778;
/*     */   public static final int GLX_VISUAL_ID_EXT = 32779;
/*     */   public static final int GLX_SCREEN_EXT = 32780;
/*     */   
/*     */   protected GLXEXTImportContext() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("Display *")
/*     */   public static long glXGetCurrentDisplayEXT() {
/*  40 */     long l = (GL.getCapabilitiesGLXClient()).glXGetCurrentDisplayEXT;
/*  41 */     if (Checks.CHECKS) {
/*  42 */       Checks.check(l);
/*     */     }
/*  44 */     return JNI.callP(l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int nglXQueryContextInfoEXT(long paramLong1, long paramLong2, int paramInt, long paramLong3) {
/*  51 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryContextInfoEXT;
/*  52 */     if (Checks.CHECKS) {
/*  53 */       Checks.check(l);
/*  54 */       Checks.check(paramLong1);
/*  55 */       Checks.check(paramLong2);
/*     */     } 
/*  57 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramLong3, l);
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
/*     */   public static int glXQueryContextInfoEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, int paramInt, @NativeType("int *") IntBuffer paramIntBuffer) {
/*  69 */     if (Checks.CHECKS) {
/*  70 */       Checks.check(paramIntBuffer, 1);
/*     */     }
/*  72 */     return nglXQueryContextInfoEXT(paramLong1, paramLong2, paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("GLXContextID")
/*     */   public static long glXGetContextIDEXT(@NativeType("GLXContext const") long paramLong) {
/*  84 */     long l = (GL.getCapabilitiesGLXClient()).glXGetContextIDEXT;
/*  85 */     if (Checks.CHECKS) {
/*  86 */       Checks.check(l);
/*  87 */       Checks.check(paramLong);
/*     */     } 
/*  89 */     return JNI.callPN(paramLong, l);
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
/*     */   @NativeType("GLXContext")
/*     */   public static long glXImportContextEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXContextID") long paramLong2) {
/* 102 */     long l = (GL.getCapabilitiesGLXClient()).glXImportContextEXT;
/* 103 */     if (Checks.CHECKS) {
/* 104 */       Checks.check(l);
/* 105 */       Checks.check(paramLong1);
/*     */     } 
/* 107 */     return JNI.callPNP(paramLong1, paramLong2, l);
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
/*     */   public static void glXFreeContextEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2) {
/* 119 */     long l = (GL.getCapabilitiesGLXClient()).glXFreeContextEXT;
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(l);
/* 122 */       Checks.check(paramLong1);
/* 123 */       Checks.check(paramLong2);
/*     */     } 
/* 125 */     JNI.callPPV(paramLong1, paramLong2, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int glXQueryContextInfoEXT(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, int paramInt, @NativeType("int *") int[] paramArrayOfint) {
/* 130 */     long l = (GL.getCapabilitiesGLXClient()).glXQueryContextInfoEXT;
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(l);
/* 133 */       Checks.check(paramLong1);
/* 134 */       Checks.check(paramLong2);
/* 135 */       Checks.check(paramArrayOfint, 1);
/*     */     } 
/* 137 */     return JNI.callPPPI(paramLong1, paramLong2, paramInt, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXEXTImportContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */