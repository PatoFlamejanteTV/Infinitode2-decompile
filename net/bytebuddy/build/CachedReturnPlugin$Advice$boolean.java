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
/*    */ class CachedReturnPlugin$Advice$boolean
/*    */ {
/*    */   private CachedReturnPlugin$Advice$boolean() {
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
/*    */   protected static boolean enter(@CacheField boolean paramBoolean) {
/* 42 */     return paramBoolean;
/*    */   }
/*    */   
/*    */   @OnMethodExit
/*    */   @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "IP_PARAMETER_IS_DEAD_BUT_OVERWRITTEN"}, justification = "Advice method serves as a template")
/*    */   protected static void exit(@Return(readOnly = false) boolean paramBoolean1, @CacheField boolean paramBoolean2) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\CachedReturnPlugin$Advice$boolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */