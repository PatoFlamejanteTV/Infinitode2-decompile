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
/*    */ public class ARBTextureBufferObject
/*    */ {
/*    */   public static final int GL_TEXTURE_BUFFER_ARB = 35882;
/*    */   public static final int GL_MAX_TEXTURE_BUFFER_SIZE_ARB = 35883;
/*    */   public static final int GL_TEXTURE_BINDING_BUFFER_ARB = 35884;
/*    */   public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_ARB = 35885;
/*    */   public static final int GL_TEXTURE_BUFFER_FORMAT_ARB = 35886;
/*    */   
/*    */   static {
/* 35 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glTexBufferARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBTextureBufferObject() {
/* 52 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTextureBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */