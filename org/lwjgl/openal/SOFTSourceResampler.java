/*    */ package org.lwjgl.openal;
/*    */ 
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
/*    */ public class SOFTSourceResampler
/*    */ {
/*    */   public static final int AL_NUM_RESAMPLERS_SOFT = 4624;
/*    */   public static final int AL_DEFAULT_RESAMPLER_SOFT = 4625;
/*    */   public static final int AL_SOURCE_RESAMPLER_SOFT = 4626;
/*    */   public static final int AL_RESAMPLER_NAME_SOFT = 4627;
/*    */   
/*    */   protected SOFTSourceResampler() {
/* 38 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static long nalGetStringiSOFT(int paramInt1, int paramInt2) {
/* 44 */     long l = (AL.getICD()).alGetStringiSOFT;
/* 45 */     if (Checks.CHECKS) {
/* 46 */       Checks.check(l);
/*    */     }
/* 48 */     return JNI.invokeP(paramInt1, paramInt2, l);
/*    */   }
/*    */ 
/*    */   
/*    */   @NativeType("ALchar const *")
/*    */   public static String alGetStringiSOFT(@NativeType("ALenum") int paramInt1, @NativeType("ALsizei") int paramInt2) {
/*    */     long l;
/* 55 */     return MemoryUtil.memUTF8Safe(l = nalGetStringiSOFT(paramInt1, paramInt2));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTSourceResampler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */