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
/*    */ public class NVCopyImage
/*    */ {
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */   protected NVCopyImage() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glCopyImageSubDataNV(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLenum") int paramInt8, @NativeType("GLint") int paramInt9, @NativeType("GLint") int paramInt10, @NativeType("GLint") int paramInt11, @NativeType("GLint") int paramInt12, @NativeType("GLsizei") int paramInt13, @NativeType("GLsizei") int paramInt14, @NativeType("GLsizei") int paramInt15);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVCopyImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */