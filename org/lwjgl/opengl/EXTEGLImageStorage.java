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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EXTEGLImageStorage
/*    */ {
/*    */   static {
/* 35 */     GL.initialize();
/*    */   }
/*    */   protected EXTEGLImageStorage() {
/* 38 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTexStorageEXT(@NativeType("GLenum") int paramInt, @NativeType("GLeglImageOES") long paramLong, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 46 */     if (Checks.CHECKS) {
/* 47 */       Checks.check(paramLong);
/* 48 */       Checks.checkNTSafe(paramIntBuffer);
/*    */     } 
/* 50 */     nglEGLImageTargetTexStorageEXT(paramInt, paramLong, MemoryUtil.memAddressSafe(paramIntBuffer));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTextureStorageEXT(@NativeType("GLuint") int paramInt, @NativeType("GLeglImageOES") long paramLong, @NativeType("int const *") IntBuffer paramIntBuffer) {
/* 58 */     if (Checks.CHECKS) {
/* 59 */       Checks.check(paramLong);
/* 60 */       Checks.checkNTSafe(paramIntBuffer);
/*    */     } 
/* 62 */     nglEGLImageTargetTextureStorageEXT(paramInt, paramLong, MemoryUtil.memAddressSafe(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTexStorageEXT(@NativeType("GLenum") int paramInt, @NativeType("GLeglImageOES") long paramLong, @NativeType("int const *") int[] paramArrayOfint) {
/* 67 */     long l = (GL.getICD()).glEGLImageTargetTexStorageEXT;
/* 68 */     if (Checks.CHECKS) {
/* 69 */       Checks.check(l);
/* 70 */       Checks.check(paramLong);
/* 71 */       Checks.checkNTSafe(paramArrayOfint);
/*    */     } 
/* 73 */     JNI.callPPV(paramInt, paramLong, paramArrayOfint, l);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glEGLImageTargetTextureStorageEXT(@NativeType("GLuint") int paramInt, @NativeType("GLeglImageOES") long paramLong, @NativeType("int const *") int[] paramArrayOfint) {
/* 78 */     long l = (GL.getICD()).glEGLImageTargetTextureStorageEXT;
/* 79 */     if (Checks.CHECKS) {
/* 80 */       Checks.check(l);
/* 81 */       Checks.check(paramLong);
/* 82 */       Checks.checkNTSafe(paramArrayOfint);
/*    */     } 
/* 84 */     JNI.callPPV(paramInt, paramLong, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void nglEGLImageTargetTexStorageEXT(int paramInt, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native void nglEGLImageTargetTextureStorageEXT(int paramInt, long paramLong1, long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTEGLImageStorage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */