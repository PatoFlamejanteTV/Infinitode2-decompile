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
/*    */ public class ARBDrawBuffers
/*    */ {
/*    */   public static final int GL_MAX_DRAW_BUFFERS_ARB = 34852;
/*    */   public static final int GL_DRAW_BUFFER0_ARB = 34853;
/*    */   public static final int GL_DRAW_BUFFER1_ARB = 34854;
/*    */   public static final int GL_DRAW_BUFFER2_ARB = 34855;
/*    */   public static final int GL_DRAW_BUFFER3_ARB = 34856;
/*    */   public static final int GL_DRAW_BUFFER4_ARB = 34857;
/*    */   public static final int GL_DRAW_BUFFER5_ARB = 34858;
/*    */   public static final int GL_DRAW_BUFFER6_ARB = 34859;
/*    */   
/*    */   static {
/* 26 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static final int GL_DRAW_BUFFER7_ARB = 34860;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER8_ARB = 34861;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER9_ARB = 34862;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER10_ARB = 34863;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER11_ARB = 34864;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER12_ARB = 34865;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER13_ARB = 34866;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER14_ARB = 34867;
/*    */   
/*    */   public static final int GL_DRAW_BUFFER15_ARB = 34868;
/*    */   
/*    */   protected ARBDrawBuffers() {
/* 49 */     throw new UnsupportedOperationException();
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
/*    */   public static void glDrawBuffersARB(@NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 67 */     nglDrawBuffersARB(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void glDrawBuffersARB(@NativeType("GLenum const *") int[] paramArrayOfint) {
/* 72 */     long l = (GL.getICD()).glDrawBuffersARB;
/* 73 */     if (Checks.CHECKS) {
/* 74 */       Checks.check(l);
/*    */     }
/* 76 */     JNI.callPV(paramArrayOfint.length, paramArrayOfint, l);
/*    */   }
/*    */   
/*    */   public static native void nglDrawBuffersARB(int paramInt, long paramLong);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBDrawBuffers.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */