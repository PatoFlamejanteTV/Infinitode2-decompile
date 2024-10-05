/*    */ package org.lwjgl.opengl;
/*    */ 
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
/*    */ public class ARBTransformFeedbackInstanced
/*    */ {
/*    */   static {
/* 24 */     GL.initialize();
/*    */   }
/*    */   protected ARBTransformFeedbackInstanced() {
/* 27 */     throw new UnsupportedOperationException();
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
/*    */   public static void glDrawTransformFeedbackInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 40 */     GL42C.glDrawTransformFeedbackInstanced(paramInt1, paramInt2, paramInt3);
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
/*    */   public static void glDrawTransformFeedbackStreamInstanced(@NativeType("GLenum") int paramInt1, @NativeType("GLuint") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 54 */     GL42C.glDrawTransformFeedbackStreamInstanced(paramInt1, paramInt2, paramInt3, paramInt4);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTransformFeedbackInstanced.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */