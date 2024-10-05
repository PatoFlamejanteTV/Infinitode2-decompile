/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
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
/*     */ public class EXTCapture
/*     */ {
/*     */   public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
/*     */   public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
/*     */   public static final int ALC_CAPTURE_SAMPLES = 786;
/*     */   
/*     */   protected EXTCapture() {
/*  33 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcCaptureOpenDevice(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/*  40 */     return ALC11.nalcCaptureOpenDevice(paramLong, paramInt1, paramInt2, paramInt3);
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
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") ByteBuffer paramByteBuffer, @NativeType("ALCuint") int paramInt1, @NativeType("ALCenum") int paramInt2, @NativeType("ALCsizei") int paramInt3) {
/*  56 */     return ALC11.alcCaptureOpenDevice(paramByteBuffer, paramInt1, paramInt2, paramInt3);
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
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") CharSequence paramCharSequence, @NativeType("ALCuint") int paramInt1, @NativeType("ALCenum") int paramInt2, @NativeType("ALCsizei") int paramInt3) {
/*  72 */     return ALC11.alcCaptureOpenDevice(paramCharSequence, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcCaptureCloseDevice(@NativeType("ALCdevice *") long paramLong) {
/*  84 */     return ALC11.alcCaptureCloseDevice(paramLong);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureStart(@NativeType("ALCdevice *") long paramLong) {
/* 100 */     ALC11.alcCaptureStart(paramLong);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureStop(@NativeType("ALCdevice *") long paramLong) {
/* 115 */     ALC11.alcCaptureStop(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcCaptureSamples(long paramLong1, long paramLong2, int paramInt) {
/* 122 */     ALC11.nalcCaptureSamples(paramLong1, paramLong2, paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") ByteBuffer paramByteBuffer, @NativeType("ALCsizei") int paramInt) {
/* 136 */     ALC11.alcCaptureSamples(paramLong, paramByteBuffer, paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") ShortBuffer paramShortBuffer, @NativeType("ALCsizei") int paramInt) {
/* 150 */     ALC11.alcCaptureSamples(paramLong, paramShortBuffer, paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") IntBuffer paramIntBuffer, @NativeType("ALCsizei") int paramInt) {
/* 164 */     ALC11.alcCaptureSamples(paramLong, paramIntBuffer, paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") FloatBuffer paramFloatBuffer, @NativeType("ALCsizei") int paramInt) {
/* 178 */     ALC11.alcCaptureSamples(paramLong, paramFloatBuffer, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") short[] paramArrayOfshort, @NativeType("ALCsizei") int paramInt) {
/* 184 */     ALC11.alcCaptureSamples(paramLong, paramArrayOfshort, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") int[] paramArrayOfint, @NativeType("ALCsizei") int paramInt) {
/* 190 */     ALC11.alcCaptureSamples(paramLong, paramArrayOfint, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") float[] paramArrayOffloat, @NativeType("ALCsizei") int paramInt) {
/* 196 */     ALC11.alcCaptureSamples(paramLong, paramArrayOffloat, paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\EXTCapture.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */