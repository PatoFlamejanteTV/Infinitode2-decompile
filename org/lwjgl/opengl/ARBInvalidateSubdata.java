/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.IntBuffer;
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
/*     */ 
/*     */ public class ARBInvalidateSubdata
/*     */ {
/*     */   static {
/*  47 */     GL.initialize();
/*     */   }
/*     */   protected ARBInvalidateSubdata() {
/*  50 */     throw new UnsupportedOperationException();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glInvalidateTexSubImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLint") int paramInt5, @NativeType("GLsizei") int paramInt6, @NativeType("GLsizei") int paramInt7, @NativeType("GLsizei") int paramInt8) {
/*  68 */     GL43C.glInvalidateTexSubImage(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
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
/*     */   public static void glInvalidateTexImage(@NativeType("GLuint") int paramInt1, @NativeType("GLint") int paramInt2) {
/*  80 */     GL43C.glInvalidateTexImage(paramInt1, paramInt2);
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
/*     */   public static void glInvalidateBufferSubData(@NativeType("GLuint") int paramInt, @NativeType("GLintptr") long paramLong1, @NativeType("GLsizeiptr") long paramLong2) {
/*  93 */     GL43C.glInvalidateBufferSubData(paramInt, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glInvalidateBufferData(@NativeType("GLuint") int paramInt) {
/* 104 */     GL43C.glInvalidateBufferData(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglInvalidateFramebuffer(int paramInt1, int paramInt2, long paramLong) {
/* 115 */     GL43C.nglInvalidateFramebuffer(paramInt1, paramInt2, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt, @NativeType("GLenum const *") IntBuffer paramIntBuffer) {
/* 125 */     GL43C.glInvalidateFramebuffer(paramInt, paramIntBuffer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int paramInt2) {
/* 134 */     GL43C.glInvalidateFramebuffer(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglInvalidateSubFramebuffer(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
/* 145 */     GL43C.nglInvalidateSubFramebuffer(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5, paramInt6);
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
/*     */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") IntBuffer paramIntBuffer, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 159 */     GL43C.glInvalidateSubFramebuffer(paramInt1, paramIntBuffer, paramInt2, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLint") int paramInt4, @NativeType("GLsizei") int paramInt5, @NativeType("GLsizei") int paramInt6) {
/* 172 */     GL43C.glInvalidateSubFramebuffer(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glInvalidateFramebuffer(@NativeType("GLenum") int paramInt, @NativeType("GLenum const *") int[] paramArrayOfint) {
/* 177 */     GL43C.glInvalidateFramebuffer(paramInt, paramArrayOfint);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glInvalidateSubFramebuffer(@NativeType("GLenum") int paramInt1, @NativeType("GLenum const *") int[] paramArrayOfint, @NativeType("GLint") int paramInt2, @NativeType("GLint") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLsizei") int paramInt5) {
/* 182 */     GL43C.glInvalidateSubFramebuffer(paramInt1, paramArrayOfint, paramInt2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBInvalidateSubdata.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */