/*    */ package org.lwjgl.opengl;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import java.nio.ShortBuffer;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public class EXTDrawInstanced
/*    */ {
/*    */   static {
/* 24 */     GL.initialize();
/*    */   }
/*    */   protected EXTDrawInstanced() {
/* 27 */     throw new UnsupportedOperationException();
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
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4) {
/* 39 */     nglDrawElementsInstancedEXT(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
/*    */   }
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3) {
/* 43 */     nglDrawElementsInstancedEXT(paramInt1, paramByteBuffer.remaining() >> GLChecks.typeToByteShift(paramInt2), paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3);
/*    */   }
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2) {
/* 47 */     nglDrawElementsInstancedEXT(paramInt1, paramByteBuffer.remaining(), 5121, MemoryUtil.memAddress(paramByteBuffer), paramInt2);
/*    */   }
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2) {
/* 51 */     nglDrawElementsInstancedEXT(paramInt1, paramShortBuffer.remaining(), 5123, MemoryUtil.memAddress(paramShortBuffer), paramInt2);
/*    */   }
/*    */   
/*    */   public static void glDrawElementsInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2) {
/* 55 */     nglDrawElementsInstancedEXT(paramInt1, paramIntBuffer.remaining(), 5125, MemoryUtil.memAddress(paramIntBuffer), paramInt2);
/*    */   }
/*    */   
/*    */   public static native void glDrawArraysInstancedEXT(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4);
/*    */   
/*    */   public static native void nglDrawElementsInstancedEXT(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\EXTDrawInstanced.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */