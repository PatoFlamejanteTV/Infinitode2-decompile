/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
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
/*     */ public class EXTStaticBuffer
/*     */ {
/*     */   protected EXTStaticBuffer() {
/*  26 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalBufferDataStatic(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4) {
/*  37 */     long l = (AL.getICD()).alBufferDataStatic;
/*  38 */     if (Checks.CHECKS) {
/*  39 */       Checks.check(l);
/*     */     }
/*  41 */     JNI.invokePV(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, l);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") ByteBuffer paramByteBuffer, @NativeType("ALsizei") int paramInt3) {
/*  54 */     nalBufferDataStatic(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramByteBuffer.remaining(), paramInt3);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") ShortBuffer paramShortBuffer, @NativeType("ALsizei") int paramInt3) {
/*  67 */     nalBufferDataStatic(paramInt1, paramInt2, MemoryUtil.memAddress(paramShortBuffer), paramShortBuffer.remaining() << 1, paramInt3);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") IntBuffer paramIntBuffer, @NativeType("ALsizei") int paramInt3) {
/*  80 */     nalBufferDataStatic(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), paramIntBuffer.remaining() << 2, paramInt3);
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
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") FloatBuffer paramFloatBuffer, @NativeType("ALsizei") int paramInt3) {
/*  93 */     nalBufferDataStatic(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer), paramFloatBuffer.remaining() << 2, paramInt3);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") short[] paramArrayOfshort, @NativeType("ALsizei") int paramInt3) {
/*  99 */     long l = (AL.getICD()).alBufferDataStatic;
/* 100 */     if (Checks.CHECKS) {
/* 101 */       Checks.check(l);
/*     */     }
/* 103 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfshort, paramArrayOfshort.length << 1, paramInt3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") int[] paramArrayOfint, @NativeType("ALsizei") int paramInt3) {
/* 109 */     long l = (AL.getICD()).alBufferDataStatic;
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(l);
/*     */     }
/* 113 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, paramArrayOfint.length << 2, paramInt3, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid")
/*     */   public static void alBufferDataStatic(@NativeType("ALint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid *") float[] paramArrayOffloat, @NativeType("ALsizei") int paramInt3) {
/* 119 */     long l = (AL.getICD()).alBufferDataStatic;
/* 120 */     if (Checks.CHECKS) {
/* 121 */       Checks.check(l);
/*     */     }
/* 123 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, paramArrayOffloat.length << 2, paramInt3, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\EXTStaticBuffer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */