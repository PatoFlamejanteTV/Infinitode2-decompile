/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import java.nio.IntBuffer;
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
/*    */ public class SOFTSourceStartDelay
/*    */ {
/*    */   protected SOFTSourceStartDelay() {
/* 35 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alSourcePlayAtTimeSOFT(@NativeType("ALuint") int paramInt, @NativeType("ALint64SOFT") long paramLong) {
/* 42 */     long l = (AL.getICD()).alSourcePlayAtTimeSOFT;
/* 43 */     if (Checks.CHECKS) {
/* 44 */       Checks.check(l);
/*    */     }
/* 46 */     JNI.invokeJV(paramInt, paramLong, l);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void nalSourcePlayAtTimevSOFT(int paramInt, long paramLong1, long paramLong2) {
/* 52 */     long l = (AL.getICD()).alSourcePlayAtTimevSOFT;
/* 53 */     if (Checks.CHECKS) {
/* 54 */       Checks.check(l);
/*    */     }
/* 56 */     JNI.invokePJV(paramInt, paramLong1, paramLong2, l);
/*    */   }
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alSourcePlayAtTimevSOFT(@NativeType("ALuint const *") IntBuffer paramIntBuffer, @NativeType("ALint64SOFT") long paramLong) {
/* 61 */     nalSourcePlayAtTimevSOFT(paramIntBuffer.remaining(), MemoryUtil.memAddress(paramIntBuffer), paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alSourcePlayAtTimevSOFT(@NativeType("ALuint const *") int[] paramArrayOfint, @NativeType("ALint64SOFT") long paramLong) {
/* 67 */     long l = (AL.getICD()).alSourcePlayAtTimevSOFT;
/* 68 */     if (Checks.CHECKS) {
/* 69 */       Checks.check(l);
/*    */     }
/* 71 */     JNI.invokePJV(paramArrayOfint.length, paramArrayOfint, paramLong, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTSourceStartDelay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */