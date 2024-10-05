/*    */ package org.lwjgl.openal;
/*    */ 
/*    */ import org.lwjgl.system.Checks;
/*    */ import org.lwjgl.system.JNI;
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
/*    */ public class SOFTPauseDevice
/*    */ {
/*    */   protected SOFTPauseDevice() {
/* 23 */     throw new UnsupportedOperationException();
/*    */   }
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
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcDevicePauseSOFT(@NativeType("ALCdevice *") long paramLong) {
/* 38 */     long l = (ALC.getICD()).alcDevicePauseSOFT;
/* 39 */     if (Checks.CHECKS) {
/* 40 */       Checks.check(l);
/* 41 */       Checks.check(paramLong);
/*    */     } 
/* 43 */     JNI.invokePV(paramLong, l);
/*    */   }
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
/*    */   @NativeType("ALCvoid")
/*    */   public static void alcDeviceResumeSOFT(@NativeType("ALCdevice *") long paramLong) {
/* 61 */     long l = (ALC.getICD()).alcDeviceResumeSOFT;
/* 62 */     if (Checks.CHECKS) {
/* 63 */       Checks.check(l);
/* 64 */       Checks.check(paramLong);
/*    */     } 
/* 66 */     JNI.invokePV(paramLong, l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTPauseDevice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */