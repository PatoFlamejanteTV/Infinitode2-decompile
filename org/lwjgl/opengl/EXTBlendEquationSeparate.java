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
/*    */ public class EXTBlendEquationSeparate
/*    */ {
/*    */   public static final int GL_BLEND_EQUATION_RGB_EXT = 32777;
/*    */   public static final int GL_BLEND_EQUATION_ALPHA_EXT = 34877;
/*    */   
/*    */   static {
/* 26 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glBlendEquationSeparateEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2);
/*    */ 
/*    */   
/*    */   protected EXTBlendEquationSeparate() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTBlendEquationSeparate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */