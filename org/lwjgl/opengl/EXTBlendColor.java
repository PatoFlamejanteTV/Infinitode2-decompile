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
/*    */ public class EXTBlendColor
/*    */ {
/*    */   public static final int GL_CONSTANT_COLOR_EXT = 32769;
/*    */   public static final int GL_ONE_MINUS_CONSTANT_COLOR_EXT = 32770;
/*    */   public static final int GL_CONSTANT_ALPHA_EXT = 32771;
/*    */   public static final int GL_ONE_MINUS_CONSTANT_ALPHA_EXT = 32772;
/*    */   public static final int GL_BLEND_COLOR_EXT = 32773;
/*    */   
/*    */   static {
/* 20 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glBlendColorEXT(@NativeType("GLfloat") float paramFloat1, @NativeType("GLfloat") float paramFloat2, @NativeType("GLfloat") float paramFloat3, @NativeType("GLfloat") float paramFloat4);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTBlendColor() {
/* 33 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTBlendColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */