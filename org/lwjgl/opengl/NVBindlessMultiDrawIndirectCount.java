/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ public class NVBindlessMultiDrawIndirectCount
/*     */ {
/*     */   static {
/*  25 */     GL.initialize();
/*     */   }
/*     */   protected NVBindlessMultiDrawIndirectCount() {
/*  28 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  50 */     if (Checks.CHECKS) {
/*  51 */       Checks.check(paramByteBuffer, paramInt2 * ((paramInt3 == 0) ? (16 + paramInt4 * 24) : paramInt3));
/*     */     }
/*  53 */     nglMultiDrawArraysIndirectBindlessCountNV(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramLong, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawArraysIndirectBindlessCountNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  70 */     nglMultiDrawArraysIndirectBindlessCountNV(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5) {
/*  93 */     if (Checks.CHECKS) {
/*  94 */       Checks.check(paramByteBuffer, paramInt3 * ((paramInt4 == 0) ? ((paramInt5 + 2) * 24) : paramInt4));
/*     */     }
/*  96 */     nglMultiDrawElementsIndirectBindlessCountNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramLong, paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glMultiDrawElementsIndirectBindlessCountNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 114 */     nglMultiDrawElementsIndirectBindlessCountNV(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public static native void nglMultiDrawArraysIndirectBindlessCountNV(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native void nglMultiDrawElementsIndirectBindlessCountNV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int paramInt5);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVBindlessMultiDrawIndirectCount.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */