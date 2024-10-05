/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
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
/*     */ public class ALC11
/*     */   extends ALC10
/*     */ {
/*     */   public static final int ALC_MONO_SOURCES = 4112;
/*     */   public static final int ALC_STEREO_SOURCES = 4113;
/*     */   public static final int ALC_DEFAULT_ALL_DEVICES_SPECIFIER = 4114;
/*     */   public static final int ALC_ALL_DEVICES_SPECIFIER = 4115;
/*     */   public static final int ALC_CAPTURE_DEVICE_SPECIFIER = 784;
/*     */   public static final int ALC_CAPTURE_DEFAULT_DEVICE_SPECIFIER = 785;
/*     */   public static final int ALC_CAPTURE_SAMPLES = 786;
/*     */   
/*     */   protected ALC11() {
/*  38 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcCaptureOpenDevice(long paramLong, int paramInt1, int paramInt2, int paramInt3) {
/*  45 */     long l = (ALC.getICD()).alcCaptureOpenDevice;
/*  46 */     if (Checks.CHECKS) {
/*  47 */       Checks.check(l);
/*     */     }
/*  49 */     return JNI.invokePP(paramLong, paramInt1, paramInt2, paramInt3, l);
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
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     }
/*  68 */     return nalcCaptureOpenDevice(MemoryUtil.memAddressSafe(paramByteBuffer), paramInt1, paramInt2, paramInt3);
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
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcCaptureOpenDevice(@NativeType("ALCchar const *") CharSequence paramCharSequence, @NativeType("ALCuint") int paramInt1, @NativeType("ALCenum") int paramInt2, @NativeType("ALCsizei") int paramInt3) {
/*     */     MemoryStack memoryStack;
/*  84 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/*  86 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/*     */       long l;
/*  88 */       return nalcCaptureOpenDevice(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress(), paramInt1, paramInt2, paramInt3);
/*     */     } finally {
/*  90 */       memoryStack.setPointer(i);
/*     */     } 
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
/* 103 */     long l = (ALC.getICD()).alcCaptureCloseDevice;
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check(l);
/* 106 */       Checks.check(paramLong);
/*     */     } 
/* 108 */     return JNI.invokePZ(paramLong, l);
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
/* 124 */     long l = (ALC.getICD()).alcCaptureStart;
/* 125 */     if (Checks.CHECKS) {
/* 126 */       Checks.check(l);
/* 127 */       Checks.check(paramLong);
/*     */     } 
/* 129 */     JNI.invokePV(paramLong, l);
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
/* 144 */     long l = (ALC.getICD()).alcCaptureStop;
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(l);
/* 147 */       Checks.check(paramLong);
/*     */     } 
/* 149 */     JNI.invokePV(paramLong, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcCaptureSamples(long paramLong1, long paramLong2, int paramInt) {
/* 156 */     long l = (ALC.getICD()).alcCaptureSamples;
/* 157 */     if (Checks.CHECKS) {
/* 158 */       Checks.check(l);
/* 159 */       Checks.check(paramLong1);
/*     */     } 
/* 161 */     JNI.invokePPV(paramLong1, paramLong2, paramInt, l);
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
/* 175 */     nalcCaptureSamples(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramInt);
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
/* 189 */     nalcCaptureSamples(paramLong, MemoryUtil.memAddress(paramShortBuffer), paramInt);
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
/* 203 */     nalcCaptureSamples(paramLong, MemoryUtil.memAddress(paramIntBuffer), paramInt);
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
/* 217 */     nalcCaptureSamples(paramLong, MemoryUtil.memAddress(paramFloatBuffer), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") short[] paramArrayOfshort, @NativeType("ALCsizei") int paramInt) {
/* 223 */     long l = (ALC.getICD()).alcCaptureSamples;
/* 224 */     if (Checks.CHECKS) {
/* 225 */       Checks.check(l);
/* 226 */       Checks.check(paramLong);
/*     */     } 
/* 228 */     JNI.invokePPV(paramLong, paramArrayOfshort, paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") int[] paramArrayOfint, @NativeType("ALCsizei") int paramInt) {
/* 234 */     long l = (ALC.getICD()).alcCaptureSamples;
/* 235 */     if (Checks.CHECKS) {
/* 236 */       Checks.check(l);
/* 237 */       Checks.check(paramLong);
/*     */     } 
/* 239 */     JNI.invokePPV(paramLong, paramArrayOfint, paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcCaptureSamples(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") float[] paramArrayOffloat, @NativeType("ALCsizei") int paramInt) {
/* 245 */     long l = (ALC.getICD()).alcCaptureSamples;
/* 246 */     if (Checks.CHECKS) {
/* 247 */       Checks.check(l);
/* 248 */       Checks.check(paramLong);
/*     */     } 
/* 250 */     JNI.invokePPV(paramLong, paramArrayOffloat, paramInt, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\ALC11.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */