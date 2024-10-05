/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
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
/*    */ public class EXTExternalBuffer
/*    */ {
/*    */   static {
/* 41 */     GL.initialize();
/*    */   }
/*    */   protected EXTExternalBuffer() {
/* 44 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glBufferStorageExternalEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLeglClientBufferEXT") long paramLong3, @NativeType("GLbitfield") int paramInt2) {
/* 52 */     if (Checks.CHECKS) {
/* 53 */       Checks.check(paramLong3);
/*    */     }
/* 55 */     nglBufferStorageExternalEXT(paramInt1, paramLong1, paramLong2, paramLong3, paramInt2);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void glNamedBufferStorageExternalEXT(@NativeType("GLuint") int paramInt1, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2, @NativeType("GLeglClientBufferEXT") long paramLong3, @NativeType("GLbitfield") int paramInt2) {
/* 63 */     if (Checks.CHECKS) {
/* 64 */       Checks.check(paramLong3);
/*    */     }
/* 66 */     nglNamedBufferStorageExternalEXT(paramInt1, paramLong1, paramLong2, paramLong3, paramInt2);
/*    */   }
/*    */   
/*    */   public static native void nglBufferStorageExternalEXT(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
/*    */   
/*    */   public static native void nglNamedBufferStorageExternalEXT(int paramInt1, long paramLong1, long paramLong2, long paramLong3, int paramInt2);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTExternalBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */