/*     */ package org.lwjgl.openal;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOFTHRTF
/*     */ {
/*     */   public static final int ALC_HRTF_SOFT = 6546;
/*     */   public static final int ALC_HRTF_ID_SOFT = 6550;
/*     */   public static final int ALC_DONT_CARE_SOFT = 2;
/*     */   public static final int ALC_HRTF_STATUS_SOFT = 6547;
/*     */   public static final int ALC_NUM_HRTF_SPECIFIERS_SOFT = 6548;
/*     */   public static final int ALC_HRTF_SPECIFIER_SOFT = 6549;
/*     */   public static final int ALC_HRTF_DISABLED_SOFT = 0;
/*     */   public static final int ALC_HRTF_ENABLED_SOFT = 1;
/*     */   public static final int ALC_HRTF_DENIED_SOFT = 2;
/*     */   public static final int ALC_HRTF_REQUIRED_SOFT = 3;
/*     */   public static final int ALC_HRTF_HEADPHONES_DETECTED_SOFT = 4;
/*     */   public static final int ALC_HRTF_UNSUPPORTED_FORMAT_SOFT = 5;
/*     */   
/*     */   protected SOFTHRTF() {
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long nalcGetStringiSOFT(long paramLong, int paramInt1, int paramInt2) {
/*  67 */     long l = (ALC.getICD()).alcGetStringiSOFT;
/*  68 */     if (Checks.CHECKS) {
/*  69 */       Checks.check(l);
/*  70 */       Checks.check(paramLong);
/*     */     } 
/*  72 */     return JNI.invokePP(paramLong, paramInt1, paramInt2, l);
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
/*     */   @NativeType("ALCchar const *")
/*     */   public static String alcGetStringiSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCenum") int paramInt1, @NativeType("ALCsizei") int paramInt2) {
/*     */     long l;
/*  89 */     return MemoryUtil.memUTF8Safe(l = nalcGetStringiSOFT(paramLong, paramInt1, paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean nalcResetDeviceSOFT(long paramLong1, long paramLong2) {
/*  96 */     long l = (ALC.getICD()).alcResetDeviceSOFT;
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check(l);
/*  99 */       Checks.check(paramLong1);
/*     */     } 
/* 101 */     return JNI.invokePPZ(paramLong1, paramLong2, l);
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
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcResetDeviceSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCint const *") IntBuffer paramIntBuffer) {
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.checkNTSafe(paramIntBuffer);
/*     */     }
/* 120 */     return nalcResetDeviceSOFT(paramLong, MemoryUtil.memAddressSafe(paramIntBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   @NativeType("ALCboolean")
/*     */   public static boolean alcResetDeviceSOFT(@NativeType("ALCdevice *") long paramLong, @NativeType("ALCint const *") int[] paramArrayOfint) {
/* 126 */     long l = (ALC.getICD()).alcResetDeviceSOFT;
/* 127 */     if (Checks.CHECKS) {
/* 128 */       Checks.check(l);
/* 129 */       Checks.check(paramLong);
/* 130 */       Checks.checkNTSafe(paramArrayOfint);
/*     */     } 
/* 132 */     return JNI.invokePPZ(paramLong, paramArrayOfint, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTHRTF.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */