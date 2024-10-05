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
/*    */ public class ARBDrawBuffersBlend
/*    */ {
/*    */   static {
/* 23 */     GL.initialize();
/*    */   }
/*    */   protected ARBDrawBuffersBlend() {
/* 26 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glBlendFuncSeparateiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*    */   
/*    */   public static native void glBlendFunciARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */   
/*    */   public static native void glBlendEquationSeparateiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */   
/*    */   public static native void glBlendEquationiARB(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBDrawBuffersBlend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */