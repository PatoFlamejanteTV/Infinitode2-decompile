/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.LongBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTDeviceClock
/*     */ {
/*     */   public static final int ALC_DEVICE_CLOCK_SOFT = 5632;
/*     */   public static final int ALC_DEVICE_LATENCY_SOFT = 5633;
/*     */   public static final int ALC_DEVICE_CLOCK_LATENCY_SOFT = 5634;
/*     */   public static final int AL_SAMPLE_OFFSET_CLOCK_SOFT = 4610;
/*     */   public static final int AL_SEC_OFFSET_CLOCK_SOFT = 4611;
/*     */   
/*     */   protected SOFTDeviceClock() {
/*  63 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalcGetInteger64vSOFT(long paramLong1, int paramInt1, int paramInt2, long paramLong2) {
/*  70 */     long l = (ALC.getICD()).alcGetInteger64vSOFT;
/*  71 */     if (Checks.CHECKS) {
/*  72 */       Checks.check(l);
/*     */     }
/*  74 */     JNI.invokePPV(paramLong1, paramInt1, paramInt2, paramLong2, l);
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
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcGetInteger64vSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt, @NativeType("ALCint64SOFT *") LongBuffer paramLongBuffer) {
/*  93 */     nalcGetInteger64vSOFT(paramLong, paramInt, paramLongBuffer.remaining(), MemoryUtil.memAddress(paramLongBuffer));
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
/*     */   @NativeType("ALCvoid")
/*     */   public static long alcGetInteger64vSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt) {
/*     */     MemoryStack memoryStack;
/* 112 */     int i = (memoryStack = MemoryStack.stackGet()).getPointer();
/*     */     try {
/* 114 */       LongBuffer longBuffer = memoryStack.callocLong(1);
/* 115 */       nalcGetInteger64vSOFT(paramLong, paramInt, 1, MemoryUtil.memAddress(longBuffer));
/* 116 */       return longBuffer.get(0);
/*     */     } finally {
/* 118 */       memoryStack.setPointer(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCvoid")
/*     */   public static void alcGetInteger64vSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt, @NativeType("ALCint64SOFT *") long[] paramArrayOflong) {
/* 125 */     long l = (ALC.getICD()).alcGetInteger64vSOFT;
/* 126 */     if (Checks.CHECKS) {
/* 127 */       Checks.check(l);
/*     */     }
/* 129 */     JNI.invokePPV(paramLong, paramInt, paramArrayOflong.length, paramArrayOflong, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTDeviceClock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */