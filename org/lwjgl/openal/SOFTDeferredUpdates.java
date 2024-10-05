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
/*    */ 
/*    */ 
/*    */ public class SOFTDeferredUpdates
/*    */ {
/*    */   public static final int AL_DEFERRED_UPDATES_SOFT = 49154;
/*    */   
/*    */   protected SOFTDeferredUpdates() {
/* 27 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("ALvoid")
/*    */   public static void alDeferUpdatesSOFT() {
/* 43 */     long l = (AL.getICD()).alDeferUpdatesSOFT;
/* 44 */     if (Checks.CHECKS) {
/* 45 */       Checks.check(l);
/*    */     }
/* 47 */     JNI.invokeV(l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALvoid")
/*    */   public static void alProcessUpdatesSOFT() {
/* 59 */     long l = (AL.getICD()).alProcessUpdatesSOFT;
/* 60 */     if (Checks.CHECKS) {
/* 61 */       Checks.check(l);
/*    */     }
/* 63 */     JNI.invokeV(l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTDeferredUpdates.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */