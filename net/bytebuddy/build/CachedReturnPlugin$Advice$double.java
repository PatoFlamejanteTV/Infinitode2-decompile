/*    */ package net.bytebuddy.build;
/*    */ 
/*    */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*    */ import net.bytebuddy.asm.Advice;
/*    */ import net.bytebuddy.asm.Advice.OnMethodEnter;
/*    */ import net.bytebuddy.asm.Advice.OnMethodExit;
/*    */ import net.bytebuddy.asm.Advice.Return;
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
/*    */ @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
/*    */ class CachedReturnPlugin$Advice$double
/*    */ {
/*    */   private CachedReturnPlugin$Advice$double() {
/* 31 */     throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
/*    */   protected static double enter(@CacheField double paramDouble) {
/* 42 */     return paramDouble;
/*    */   }
/*    */   
/*    */   @OnMethodExit
/*    */   @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
/*    */   protected static void exit(@Return(readOnly = false) double paramDouble1, @CacheField double paramDouble2) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\CachedReturnPlugin$Advice$double.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */