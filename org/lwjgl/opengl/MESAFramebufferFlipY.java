/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.IntBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
/*    */ import org.lwjgl.system.MemoryUtil;
/*    */ import org.lwjgl.system.NativeType;
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
/*    */ public class MESAFramebufferFlipY
/*    */ {
/*    */   public static final int GL_FRAMEBUFFER_FLIP_Y_MESA = 35771;
/*    */   
/*    */   static {
/* 31 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected MESAFramebufferFlipY() {
/* 37 */     throw new UnsupportedOperationException();
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
/*    */   public static void glGetFramebufferParameterivMESA(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") IntBuffer paramIntBuffer) {
/* 49 */     if (Checks.CHECKS) {
/* 50 */       Checks.check(paramIntBuffer, 1);
/*    */     }
/* 52 */     nglGetFramebufferParameterivMESA(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glGetFramebufferParameterivMESA(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint *") int[] paramArrayOfint) {
/* 57 */     long l = (GL.getICD()).glGetFramebufferParameterivMESA;
/* 58 */     if (Checks.CHECKS) {
/* 59 */       Checks.check(l);
/* 60 */       Checks.check(paramArrayOfint, 1);
/*    */     } 
/* 62 */     JNI.callPV(paramInt1, paramInt2, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void glFramebufferParameteriMESA(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3);
/*    */   
/*    */   public static native void nglGetFramebufferParameterivMESA(int paramInt1, int paramInt2, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\MESAFramebufferFlipY.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */