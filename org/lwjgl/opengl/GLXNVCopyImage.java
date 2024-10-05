/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class GLXNVCopyImage
/*    */ {
/*    */   protected GLXNVCopyImage() {
/* 23 */     throw new UnsupportedOperationException();
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
/*    */   public static void glXCopyImageSubDataNV(@NativeType("Display *") long paramLong1, @NativeType("GLXContext") long paramLong2, @NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLXContext") long paramLong3, @NativeType("GLuint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLsizei") int paramInt13, @NativeType("GLsizei") int paramInt14, @NativeType("GLsizei") int paramInt15) {
/* 38 */     long l = (GL.getCapabilitiesGLXClient()).glXCopyImageSubDataNV;
/* 39 */     if (Checks.CHECKS) {
/* 40 */       Checks.check(l);
/* 41 */       Checks.check(paramLong1);
/*    */     } 
/* 43 */     JNI.callPPPV(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong3, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12, paramInt13, paramInt14, paramInt15, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\GLXNVCopyImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */