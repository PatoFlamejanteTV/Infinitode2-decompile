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
/*    */ public class ARBTextureBufferRange
/*    */ {
/*    */   public static final int GL_TEXTURE_BUFFER_OFFSET = 37277;
/*    */   public static final int GL_TEXTURE_BUFFER_SIZE = 37278;
/*    */   public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 37279;
/*    */   
/*    */   static {
/* 22 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected ARBTextureBufferRange() {
/* 33 */     throw new UnsupportedOperationException();
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
/*    */   public static void glTexBufferRange(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLuint") int paramInt3, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/* 48 */     GL43C.glTexBufferRange(paramInt1, paramInt2, paramInt3, paramLong1, paramLong2);
/*    */   }
/*    */   
/*    */   public static native void glTextureBufferRangeEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("GLuint") int paramInt4, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBTextureBufferRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */