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
/*    */ public class NVMemoryObjectSparse
/*    */ {
/*    */   static {
/* 19 */     GL.initialize();
/*    */   }
/*    */   protected NVMemoryObjectSparse() {
/* 22 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glTexturePageCommitmentMemNV(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLuint") int paramInt10, @NativeType("GLuint64") long paramLong, @NativeType("GLboolean") boolean paramBoolean);
/*    */   
/*    */   public static native void glTexPageCommitmentMemNV(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLint") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8, @NativeType("GLsizei") int paramInt9, @NativeType("GLuint") int paramInt10, @NativeType("GLuint64") long paramLong, @NativeType("GLboolean") boolean paramBoolean);
/*    */   
/*    */   public static native void glNamedBufferPageCommitmentMemNV(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong3, @NativeType("GLboolean") boolean paramBoolean);
/*    */   
/*    */   public static native void glBufferPageCommitmentMemNV(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLuint") int paramInt2, @NativeType("GLuint64") long paramLong3, @NativeType("GLboolean") boolean paramBoolean);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVMemoryObjectSparse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */