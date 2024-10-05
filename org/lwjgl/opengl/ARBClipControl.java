/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.NativeType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBClipControl
/*    */ {
/*    */   public static final int GL_LOWER_LEFT = 36001;
/*    */   public static final int GL_UPPER_LEFT = 36002;
/*    */   public static final int GL_NEGATIVE_ONE_TO_ONE = 37726;
/*    */   public static final int GL_ZERO_TO_ONE = 37727;
/*    */   public static final int GL_CLIP_ORIGIN = 37724;
/*    */   public static final int GL_CLIP_DEPTH_MODE = 37725;
/*    */   
/*    */   static {
/* 20 */     GL.initialize();
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
/*    */   protected ARBClipControl() {
/* 38 */     throw new UnsupportedOperationException();
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
/*    */   public static void glClipControl(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2) {
/* 56 */     GL45C.glClipControl(paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBClipControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */