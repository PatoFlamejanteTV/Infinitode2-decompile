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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVBindlessMultiDrawIndirect
/*     */ {
/*     */   static {
/*  33 */     GL.initialize();
/*     */   }
/*     */   protected NVBindlessMultiDrawIndirect() {
/*  36 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiDrawArraysIndirectBindlessNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  68 */     if (Checks.CHECKS) {
/*  69 */       Checks.check(paramByteBuffer, paramInt2 * ((paramInt3 == 0) ? (16 + paramInt4 * 24) : paramInt3));
/*     */     }
/*  71 */     nglMultiDrawArraysIndirectBindlessNV(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawArraysIndirectBindlessNV(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3, @NativeType("GLint") int paramInt4) {
/*  98 */     nglMultiDrawArraysIndirectBindlessNV(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectBindlessNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 133 */     if (Checks.CHECKS) {
/* 134 */       Checks.check(paramByteBuffer, paramInt3 * ((paramInt4 == 0) ? ((paramInt5 + 2) * 24) : paramInt4));
/*     */     }
/* 136 */     nglMultiDrawElementsIndirectBindlessNV(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramInt4, paramInt5);
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
/*     */   public static void glMultiDrawElementsIndirectBindlessNV(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4, @NativeType("GLint") int paramInt5) {
/* 166 */     nglMultiDrawElementsIndirectBindlessNV(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, paramInt5);
/*     */   }
/*     */   
/*     */   public static native void nglMultiDrawArraysIndirectBindlessNV(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native void nglMultiDrawElementsIndirectBindlessNV(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4, int paramInt5);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\NVBindlessMultiDrawIndirect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */