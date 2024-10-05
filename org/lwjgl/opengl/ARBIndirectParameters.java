/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
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
/*     */ public class ARBIndirectParameters
/*     */ {
/*     */   public static final int GL_PARAMETER_BUFFER_ARB = 33006;
/*     */   public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 33007;
/*     */   
/*     */   static {
/*  34 */     GL.initialize();
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
/*     */   protected ARBIndirectParameters() {
/*  46 */     throw new UnsupportedOperationException();
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
/*     */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/*  67 */     if (Checks.CHECKS) {
/*  68 */       Checks.check(paramByteBuffer, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3));
/*     */     }
/*  70 */     nglMultiDrawArraysIndirectCountARB(paramInt1, MemoryUtil.memAddress(paramByteBuffer), paramLong, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/*  86 */     nglMultiDrawArraysIndirectCountARB(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 102 */     if (Checks.CHECKS) {
/* 103 */       Checks.check(paramIntBuffer, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3) >> 2);
/*     */     }
/* 105 */     nglMultiDrawArraysIndirectCountARB(paramInt1, MemoryUtil.memAddress(paramIntBuffer), paramLong, paramInt2, paramInt3);
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
/*     */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") ByteBuffer paramByteBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(paramByteBuffer, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4));
/*     */     }
/* 130 */     nglMultiDrawElementsIndirectCountARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramLong, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") long paramLong1, @NativeType("GLintptr") long paramLong2, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 147 */     nglMultiDrawElementsIndirectCountARB(paramInt1, paramInt2, paramLong1, paramLong2, paramInt3, paramInt4);
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
/*     */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") IntBuffer paramIntBuffer, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(paramIntBuffer, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4) >> 2);
/*     */     }
/* 167 */     nglMultiDrawElementsIndirectCountARB(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), paramLong, paramInt3, paramInt4);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawArraysIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt2, @NativeType("GLsizei") int paramInt3) {
/* 172 */     long l = (GL.getICD()).glMultiDrawArraysIndirectCountARB;
/* 173 */     if (Checks.CHECKS) {
/* 174 */       Checks.check(l);
/* 175 */       Checks.check(paramArrayOfint, paramInt2 * ((paramInt3 == 0) ? 16 : paramInt3) >> 2);
/*     */     } 
/* 177 */     JNI.callPPV(paramInt1, paramArrayOfint, paramLong, paramInt2, paramInt3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiDrawElementsIndirectCountARB(@NativeType("GLenum") int paramInt1, @NativeType("GLenum") int paramInt2, @NativeType("void const *") int[] paramArrayOfint, @NativeType("GLintptr") long paramLong, @NativeType("GLsizei") int paramInt3, @NativeType("GLsizei") int paramInt4) {
/* 182 */     long l = (GL.getICD()).glMultiDrawElementsIndirectCountARB;
/* 183 */     if (Checks.CHECKS) {
/* 184 */       Checks.check(l);
/* 185 */       Checks.check(paramArrayOfint, paramInt3 * ((paramInt4 == 0) ? 20 : paramInt4) >> 2);
/*     */     } 
/* 187 */     JNI.callPPV(paramInt1, paramInt2, paramArrayOfint, paramLong, paramInt3, paramInt4, l);
/*     */   }
/*     */   
/*     */   public static native void nglMultiDrawArraysIndirectCountARB(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3);
/*     */   
/*     */   public static native void nglMultiDrawElementsIndirectCountARB(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\opengl\ARBIndirectParameters.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */