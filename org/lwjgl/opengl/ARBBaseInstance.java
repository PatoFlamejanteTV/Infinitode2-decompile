/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ARBBaseInstance
/*     */ {
/*     */   static {
/*  29 */     GL.initialize();
/*     */   }
/*     */   protected ARBBaseInstance() {
/*  32 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawArraysInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5) {
/*  47 */     GL42C.glDrawArraysInstancedBaseInstance(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsInstancedBaseInstance(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5) {
/*  59 */     GL42C.nglDrawElementsInstancedBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4, @NativeType("GLuint") int paramInt5) {
/*  73 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLuint") int paramInt4) {
/*  86 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint") int paramInt3) {
/*  98 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramByteBuffer, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 110 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramShortBuffer, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLuint") int paramInt3) {
/* 122 */     GL42C.glDrawElementsInstancedBaseInstance(paramInt1, paramIntBuffer, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglDrawElementsInstancedBaseVertexBaseInstance(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4, int paramInt5, int paramInt6) {
/* 134 */     GL42C.nglDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLsizei") int paramInt2, @NativeType("GLenum") int paramInt3, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLuint") int paramInt6) {
/* 149 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramInt2, paramInt3, paramLong, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLuint") int paramInt5) {
/* 163 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 176 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramByteBuffer, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ShortBuffer paramShortBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 189 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramShortBuffer, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glDrawElementsInstancedBaseVertexBaseInstance(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLuint") int paramInt4) {
/* 202 */     GL42C.glDrawElementsInstancedBaseVertexBaseInstance(paramInt1, paramIntBuffer, paramInt2, paramInt3, paramInt4);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBBaseInstance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */