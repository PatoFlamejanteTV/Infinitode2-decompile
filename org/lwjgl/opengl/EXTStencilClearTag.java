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
/*    */ public class EXTStencilClearTag
/*    */ {
/*    */   public static final int GL_STENCIL_TAG_BITS_EXT = 35058;
/*    */   public static final int GL_STENCIL_CLEAR_TAG_VALUE_EXT = 35059;
/*    */   
/*    */   static {
/* 48 */     GL.initialize();
/*    */   }
/*    */ 
/*    */   
/*    */   public static native void glStencilClearTagEXT(@NativeType("GLsizei") int paramInt1, @NativeType("GLuint") int paramInt2);
/*    */ 
/*    */   
/*    */   protected EXTStencilClearTag() {
/* 56 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTStencilClearTag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */