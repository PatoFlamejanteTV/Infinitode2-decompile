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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTLoopback
/*     */ {
/*     */   public static final int ALC_BYTE_SOFT = 5120;
/*     */   public static final int ALC_UNSIGNED_BYTE_SOFT = 5121;
/*     */   public static final int ALC_SHORT_SOFT = 5122;
/*     */   public static final int ALC_UNSIGNED_SHORT_SOFT = 5123;
/*     */   public static final int ALC_INT_SOFT = 5124;
/*     */   public static final int ALC_UNSIGNED_INT_SOFT = 5125;
/*     */   public static final int ALC_FLOAT_SOFT = 5126;
/*     */   public static final int ALC_MONO_SOFT = 5376;
/*     */   public static final int ALC_STEREO_SOFT = 5377;
/*     */   public static final int ALC_QUAD_SOFT = 5379;
/*     */   public static final int ALC_5POINT1_SOFT = 5380;
/*     */   public static final int ALC_6POINT1_SOFT = 5381;
/*     */   public static final int ALC_7POINT1_SOFT = 5382;
/*     */   public static final int ALC_FORMAT_CHANNELS_SOFT = 6544;
/*     */   public static final int ALC_FORMAT_TYPE_SOFT = 6545;
/*     */   
/*     */   protected SOFTLoopback() {
/*  52 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcLoopbackOpenDeviceSOFT(long paramLong) {
/*  59 */     long l = (ALC.getICD()).alcLoopbackOpenDeviceSOFT;
/*  60 */     if (Checks.CHECKS) {
/*  61 */       Checks.check(l);
/*     */     }
/*  63 */     return JNI.invokePP(paramLong, l);
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
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcLoopbackOpenDeviceSOFT(@NativeType("ALCchar const *") ByteBuffer paramByteBuffer) {
/*  84 */     if (Checks.CHECKS) {
/*  85 */       Checks.checkNT1Safe(paramByteBuffer);
/*     */     }
/*  87 */     return nalcLoopbackOpenDeviceSOFT(MemoryUtil.memAddressSafe(paramByteBuffer));
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
/*     */   @NativeType("ALCdevice *")
/*     */   public static long alcLoopbackOpenDeviceSOFT(@NativeType("ALCchar const *") CharSequence paramCharSequence) {
/*     */     MemoryStack memoryStack;
/* 108 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 110 */       memoryStack.nUTF8Safe(paramCharSequence, true);
/*     */       long l;
/* 112 */       return nalcLoopbackOpenDeviceSOFT(l = (paramCharSequence == null) ? 0L : memoryStack.getPointerAddress());
/*     */     } finally {
/* 114 */       memoryStack.setPointer(i);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcIsRenderFormatSupportedSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCsizei") int paramInt1, @NativeType("ALCenum") int paramInt2, @NativeType("ALCenum") int paramInt3) {
/* 133 */     long l = (ALC.getICD()).alcIsRenderFormatSupportedSOFT;
/* 134 */     if (Checks.CHECKS) {
/* 135 */       Checks.check(l);
/* 136 */       Checks.check(paramLong);
/*     */     } 
/* 138 */     return JNI.invokePZ(paramLong, paramInt1, paramInt2, paramInt3, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcRenderSamplesSOFT(long paramLong1, long paramLong2, int paramInt) {
/* 145 */     long l = (ALC.getICD()).alcRenderSamplesSOFT;
/* 146 */     if (Checks.CHECKS) {
/* 147 */       Checks.check(l);
/* 148 */       Checks.check(paramLong1);
/*     */     } 
/* 150 */     JNI.invokePPV(paramLong1, paramLong2, paramInt, l);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") ByteBuffer paramByteBuffer, @NativeType("ALCsizei") int paramInt) {
/* 163 */     nalcRenderSamplesSOFT(paramLong, MemoryUtil.memAddress(paramByteBuffer), paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") ShortBuffer paramShortBuffer, @NativeType("ALCsizei") int paramInt) {
/* 176 */     nalcRenderSamplesSOFT(paramLong, MemoryUtil.memAddress(paramShortBuffer), paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") IntBuffer paramIntBuffer, @NativeType("ALCsizei") int paramInt) {
/* 189 */     nalcRenderSamplesSOFT(paramLong, MemoryUtil.memAddress(paramIntBuffer), paramInt);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") FloatBuffer paramFloatBuffer, @NativeType("ALCsizei") int paramInt) {
/* 202 */     nalcRenderSamplesSOFT(paramLong, MemoryUtil.memAddress(paramFloatBuffer), paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") short[] paramArrayOfshort, @NativeType("ALCsizei") int paramInt) {
/* 208 */     long l = (ALC.getICD()).alcRenderSamplesSOFT;
/* 209 */     if (Checks.CHECKS) {
/* 210 */       Checks.check(l);
/* 211 */       Checks.check(paramLong);
/*     */     } 
/* 213 */     JNI.invokePPV(paramLong, paramArrayOfshort, paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") int[] paramArrayOfint, @NativeType("ALCsizei") int paramInt) {
/* 219 */     long l = (ALC.getICD()).alcRenderSamplesSOFT;
/* 220 */     if (Checks.CHECKS) {
/* 221 */       Checks.check(l);
/* 222 */       Checks.check(paramLong);
/*     */     } 
/* 224 */     JNI.invokePPV(paramLong, paramArrayOfint, paramInt, l);
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcRenderSamplesSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCvoid *") float[] paramArrayOffloat, @NativeType("ALCsizei") int paramInt) {
/* 230 */     long l = (ALC.getICD()).alcRenderSamplesSOFT;
/* 231 */     if (Checks.CHECKS) {
/* 232 */       Checks.check(l);
/* 233 */       Checks.check(paramLong);
/*     */     } 
/* 235 */     JNI.invokePPV(paramLong, paramArrayOffloat, paramInt, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTLoopback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */