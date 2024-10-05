/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
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
/*     */ public class ARBMultiDrawIndirect
/*     */ {
/*     */   static {
/*  27 */     GL.initialize();
/*     */   }
/*     */   protected ARBMultiDrawIndirect() {
/*  30 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawArraysIndirect(int paramInt1, long paramLong, int paramInt2, int paramInt3) {
/*  37 */     GL43C.nglMultiDrawArraysIndirect(paramInt1, paramLong, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/*  71 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramByteBuffer, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 105 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramLong, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 139 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramIntBuffer, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nglMultiDrawElementsIndirect(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4) {
/* 146 */     GL43C.nglMultiDrawElementsIndirect(paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 182 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramByteBuffer, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 218 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramLong, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 254 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramIntBuffer, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirect(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 259 */     GL43C.glMultiDrawArraysIndirect(paramInt1, paramArrayOfint, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirect(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 264 */     GL43C.glMultiDrawElementsIndirect(paramInt1, paramInt2, paramArrayOfint, paramInt3, paramInt4);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBMultiDrawIndirect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */