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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ARBTextureView
/*    */ {
/*    */   public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 33499;
/*    */   public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 33500;
/*    */   public static final int GL_TEXTURE_VIEW_MIN_LAYER = 33501;
/*    */   public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 33502;
/*    */   public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 33503;
/*    */   
/*    */   static {
/* 37 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBTextureView() {
/* 48 */     throw new UnsupportedOperationException();
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
/*    */   public static void glTextureView(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLenum") int paramInt4, @NativeType("GLuint") int paramInt5, @NativeType("GLuint") int paramInt6, @NativeType("GLuint") int paramInt7, @NativeType("GLuint") int paramInt8) {
/* 66 */     GL43C.glTextureView(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTextureView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */