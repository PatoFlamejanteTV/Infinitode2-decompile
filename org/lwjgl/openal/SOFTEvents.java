/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
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
/*     */ public class SOFTEvents
/*     */ {
/*     */   public static final int AL_EVENT_CALLBACK_FUNCTION_SOFT = 6562;
/*     */   public static final int AL_EVENT_CALLBACK_USER_PARAM_SOFT = 6563;
/*     */   public static final int AL_EVENT_TYPE_BUFFER_COMPLETED_SOFT = 6564;
/*     */   public static final int AL_EVENT_TYPE_SOURCE_STATE_CHANGED_SOFT = 6565;
/*     */   public static final int AL_EVENT_TYPE_DISCONNECTED_SOFT = 6566;
/*     */   
/*     */   protected SOFTEvents() {
/*  44 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalEventControlSOFT(int paramInt, long paramLong, boolean paramBoolean) {
/*  50 */     long l = (AL.getICD()).alEventControlSOFT;
/*  51 */     if (Checks.CHECKS) {
/*  52 */       Checks.check(l);
/*     */     }
/*  54 */     JNI.invokePV(paramInt, paramLong, paramBoolean, l);
/*     */   }
/*     */   
/*     */   public static void alEventControlSOFT(@NativeType("ALenum const *") IntBuffer paramIntBuffer, @NativeType("ALboolean") boolean paramBoolean) {
/*  58 */     nalEventControlSOFT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalEventCallbackSOFT(long paramLong1, long paramLong2) {
/*  64 */     long l = (AL.getICD()).alEventCallbackSOFT;
/*  65 */     if (Checks.CHECKS) {
/*  66 */       Checks.check(l);
/*     */     }
/*  68 */     JNI.invokePPV(paramLong1, paramLong2, l);
/*     */   }
/*     */   
/*     */   public static void alEventCallbackSOFT(@NativeType("ALEVENTPROCSOFT") SOFTEventProcI paramSOFTEventProcI, @NativeType("ALvoid *") ByteBuffer paramByteBuffer) {
/*  72 */     nalEventCallbackSOFT(paramSOFTEventProcI.address(), MemoryUtil.memAddressSafe(paramByteBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ALvoid *")
/*     */   public static long alGetPointerSOFT(@NativeType("ALenum") int paramInt) {
/*  79 */     long l = (AL.getICD()).alGetPointerSOFT;
/*  80 */     if (Checks.CHECKS) {
/*  81 */       Checks.check(l);
/*     */     }
/*  83 */     return JNI.invokeP(paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void nalGetPointervSOFT(int paramInt, long paramLong) {
/*  89 */     long l = (AL.getICD()).alGetPointervSOFT;
/*  90 */     if (Checks.CHECKS) {
/*  91 */       Checks.check(l);
/*     */     }
/*  93 */     JNI.invokePV(paramInt, paramLong, l);
/*     */   }
/*     */   
/*     */   public static void alGetPointervSOFT(@NativeType("ALenum") int paramInt, @NativeType("ALvoid **") PointerBuffer paramPointerBuffer) {
/*  97 */     if (Checks.CHECKS) {
/*  98 */       Checks.check((CustomBuffer)paramPointerBuffer, 1);
/*     */     }
/* 100 */     nalGetPointervSOFT(paramInt, MemoryUtil.memAddress((CustomBuffer)paramPointerBuffer));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void alEventControlSOFT(@NativeType("ALenum const *") int[] paramArrayOfint, @NativeType("ALboolean") boolean paramBoolean) {
/* 105 */     long l = (AL.getICD()).alEventControlSOFT;
/* 106 */     if (Checks.CHECKS) {
/* 107 */       Checks.check(l);
/*     */     }
/* 109 */     JNI.invokePV(paramArrayOfint.length, paramArrayOfint, paramBoolean, l);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTEvents.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */