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
/*    */ public class EXTThreadLocalContext
/*    */ {
/*    */   protected EXTThreadLocalContext() {
/* 22 */     throw new UnsupportedOperationException();
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
/*    */   @NativeType("ALCboolean")
/*    */   public static boolean alcSetThreadContext(@NativeType("ALCcontext *") long paramLong) {
/* 35 */     long l = (ALC.getICD()).alcSetThreadContext;
/* 36 */     if (Checks.CHECKS) {
/* 37 */       Checks.check(l);
/*    */     }
/* 39 */     return JNI.invokePZ(paramLong, l);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @NativeType("ALCcontext *")
/*    */   public static long alcGetThreadContext() {
/* 47 */     long l = (ALC.getICD()).alcGetThreadContext;
/* 48 */     if (Checks.CHECKS) {
/* 49 */       Checks.check(l);
/*    */     }
/* 51 */     return JNI.invokeP(l);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\EXTThreadLocalContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */