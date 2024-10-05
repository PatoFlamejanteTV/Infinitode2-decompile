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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EXTWindowRectangles
/*     */ {
/*     */   public static final int GL_INCLUSIVE_EXT = 36624;
/*     */   public static final int GL_EXCLUSIVE_EXT = 36625;
/*     */   public static final int GL_WINDOW_RECTANGLE_EXT = 36626;
/*     */   public static final int GL_WINDOW_RECTANGLE_MODE_EXT = 36627;
/*     */   public static final int GL_MAX_WINDOW_RECTANGLES_EXT = 36628;
/*     */   public static final int GL_NUM_WINDOW_RECTANGLES_EXT = 36629;
/*     */   
/*     */   static {
/*  40 */     GL.initialize();
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
/*     */   
/*     */   protected EXTWindowRectangles() {
/*  60 */     throw new UnsupportedOperationException();
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
/*     */   public static void glWindowRectanglesEXT(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 104 */     nglWindowRectanglesEXT(paramInt, Checks.remainingSafe(paramIntBuffer) >> 2, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glWindowRectanglesEXT(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 109 */     long l = (GL.getICD()).glWindowRectanglesEXT;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(l);
/*     */     }
/* 113 */     JNI.callPV(paramInt, Checks.lengthSafe(paramArrayOfint) >> 2, paramArrayOfint, l);
/*     */   }
/*     */   
/*     */   public static native void nglWindowRectanglesEXT(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTWindowRectangles.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */