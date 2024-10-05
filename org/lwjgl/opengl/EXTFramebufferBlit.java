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
/*    */ public class EXTFramebufferBlit
/*    */ {
/*    */   public static final int GL_READ_FRAMEBUFFER_EXT = 36008;
/*    */   public static final int GL_DRAW_FRAMEBUFFER_EXT = 36009;
/*    */   public static final int GL_DRAW_FRAMEBUFFER_BINDING_EXT = 36006;
/*    */   public static final int GL_READ_FRAMEBUFFER_BINDING_EXT = 36010;
/*    */   
/*    */   static {
/* 21 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glBlitFramebufferEXT(@NativeType("GLint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLint") int paramInt7, @NativeType("GLint") int paramInt8, @NativeType("GLbitfield") int paramInt9, @NativeType("GLenum") int paramInt10);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTFramebufferBlit() {
/* 37 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTFramebufferBlit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */