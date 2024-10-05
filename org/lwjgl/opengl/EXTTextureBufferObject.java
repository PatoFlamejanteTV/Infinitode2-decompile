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
/*    */ public class EXTTextureBufferObject
/*    */ {
/*    */   public static final int GL_TEXTURE_BUFFER_EXT = 35882;
/*    */   public static final int GL_MAX_TEXTURE_BUFFER_SIZE_EXT = 35883;
/*    */   public static final int GL_TEXTURE_BINDING_BUFFER_EXT = 35884;
/*    */   public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING_EXT = 35885;
/*    */   public static final int GL_TEXTURE_BUFFER_FORMAT_EXT = 35886;
/*    */   
/*    */   static {
/* 36 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glTexBufferEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected EXTTextureBufferObject() {
/* 52 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTTextureBufferObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */