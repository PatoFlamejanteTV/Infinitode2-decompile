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
/*    */ public class NVPointSprite
/*    */ {
/*    */   public static final int GL_POINT_SPRITE_NV = 34913;
/*    */   public static final int GL_COORD_REPLACE_NV = 34914;
/*    */   public static final int GL_POINT_SPRITE_R_MODE_NV = 34915;
/*    */   
/*    */   static {
/* 36 */     GL.initialize();
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected NVPointSprite() {
/* 57 */     throw new UnsupportedOperationException();
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
/*    */   public static void glPointParameterivNV(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") IntBuffer paramIntBuffer) {
/* 69 */     if (Checks.CHECKS) {
/* 70 */       Checks.check(paramIntBuffer, 1);
/*    */     }
/* 72 */     nglPointParameterivNV(paramInt, MemoryUtil.memAddress(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glPointParameterivNV(@NativeType("GLenum") int paramInt, @NativeType("GLint const *") int[] paramArrayOfint) {
/* 77 */     long l = (GL.getICD()).glPointParameterivNV;
/* 78 */     if (Checks.CHECKS) {
/* 79 */       Checks.check(l);
/* 80 */       Checks.check(paramArrayOfint, 1);
/*    */     } 
/* 82 */     JNI.callPV(paramInt, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void glPointParameteriNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2);
/*    */   
/*    */   public static native void nglPointParameterivNV(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVPointSprite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */