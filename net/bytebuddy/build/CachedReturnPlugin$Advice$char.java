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
/*    */ class CachedReturnPlugin$Advice$char
/*    */ {
/*    */   private CachedReturnPlugin$Advice$char() {
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
/*    */   protected static char enter(@CacheField char paramChar) {
/* 42 */     return paramChar;
/*    */   }
/*    */   
/*    */   @OnMethodExit
/*    */   @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
/*    */   protected static void exit(@Return(readOnly = false) char paramChar1, @CacheField char paramChar2) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\CachedReturnPlugin$Advice$char.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */