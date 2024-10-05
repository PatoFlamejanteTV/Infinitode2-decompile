/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.nio.FloatBuffer;
/*    */ import java.nio.IntBuffer;
/*    */ import java.nio.ShortBuffer;
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class SOFTBufferSubData
/*    */ {
/*    */   public static final int AL_BYTE_RW_OFFSETS_SOFT = 4145;
/*    */   public static final int AL_SAMPLE_RW_OFFSETS_SOFT = 4146;
/*    */   
/*    */   protected SOFTBufferSubData() {
/* 29 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nalBufferSubDataSOFT(int paramInt1, int paramInt2, long paramLong, int paramInt3, int paramInt4) {
/* 35 */     long l = (AL.getICD()).alBufferSubDataSOFT;
/* 36 */     if (Checks.CHECKS) {
/* 37 */       Checks.check(l);
/*    */     }
/* 39 */     JNI.invokePV(paramInt1, paramInt2, paramLong, paramInt3, paramInt4, l);
/*    */   }
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") ByteBuffer paramByteBuffer, @NativeType("ALsizei") int paramInt3) {
/* 43 */     nalBufferSubDataSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramByteBuffer), paramInt3, paramByteBuffer.remaining());
/*    */   }
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") ShortBuffer paramShortBuffer, @NativeType("ALsizei") int paramInt3) {
/* 47 */     nalBufferSubDataSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramShortBuffer), paramInt3, paramShortBuffer.remaining() << 1);
/*    */   }
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") IntBuffer paramIntBuffer, @NativeType("ALsizei") int paramInt3) {
/* 51 */     nalBufferSubDataSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramIntBuffer), paramInt3, paramIntBuffer.remaining() << 2);
/*    */   }
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") FloatBuffer paramFloatBuffer, @NativeType("ALsizei") int paramInt3) {
/* 55 */     nalBufferSubDataSOFT(paramInt1, paramInt2, MemoryUtil.memAddress(paramFloatBuffer), paramInt3, paramFloatBuffer.remaining() << 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") short[] paramArrayOfshort, @NativeType("ALsizei") int paramInt3) {
/* 60 */     long l = (AL.getICD()).alBufferSubDataSOFT;
/* 61 */     if (Checks.CHECKS) {
/* 62 */       Checks.check(l);
/*    */     }
/* 64 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfshort, paramInt3, paramArrayOfshort.length << 1, l);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") int[] paramArrayOfint, @NativeType("ALsizei") int paramInt3) {
/* 69 */     long l = (AL.getICD()).alBufferSubDataSOFT;
/* 70 */     if (Checks.CHECKS) {
/* 71 */       Checks.check(l);
/*    */     }
/* 73 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOfint, paramInt3, paramArrayOfint.length << 2, l);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void alBufferSubDataSOFT(@NativeType("ALuint") int paramInt1, @NativeType("ALenum") int paramInt2, @NativeType("ALvoid const *") float[] paramArrayOffloat, @NativeType("ALsizei") int paramInt3) {
/* 78 */     long l = (AL.getICD()).alBufferSubDataSOFT;
/* 79 */     if (Checks.CHECKS) {
/* 80 */       Checks.check(l);
/*    */     }
/* 82 */     JNI.invokePV(paramInt1, paramInt2, paramArrayOffloat, paramInt3, paramArrayOffloat.length << 2, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTBufferSubData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */