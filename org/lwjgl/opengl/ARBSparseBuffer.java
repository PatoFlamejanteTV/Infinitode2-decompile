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
/*    */ public class ARBSparseBuffer
/*    */ {
/*    */   public static final int GL_SPARSE_STORAGE_BIT_ARB = 1024;
/*    */   public static final int GL_SPARSE_BUFFER_PAGE_SIZE_ARB = 33528;
/*    */   
/*    */   static {
/* 21 */     GL.initialize();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static native void glNamedBufferPageCommitmentARB(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLboolean") boolean paramBoolean);
/*    */ 
/*    */   
/*    */   protected ARBSparseBuffer() {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static native void glNamedBufferPageCommitmentEXT(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLboolean") boolean paramBoolean);
/*    */   
/*    */   public static native void glBufferPageCommitmentARB(@NativeType("GLenum") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLboolean") boolean paramBoolean);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBSparseBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */