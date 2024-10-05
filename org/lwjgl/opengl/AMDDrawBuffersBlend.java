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
/*    */ public class AMDDrawBuffersBlend
/*    */ {
/*    */   static {
/* 23 */     GL.initialize();
/*    */   }
/*    */   protected AMDDrawBuffersBlend() {
/* 26 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glBlendEquationSeparateIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */   
/*    */   public static native void glBlendEquationIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */   
/*    */   public static native void glBlendFuncSeparateIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLenum") int paramInt5);
/*    */   
/*    */   public static native void glBlendFuncIndexedAMD(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\AMDDrawBuffersBlend.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */