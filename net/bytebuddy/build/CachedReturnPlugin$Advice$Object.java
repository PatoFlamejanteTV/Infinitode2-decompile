/*    */ package net.bytebuddy.build;
/*    */ 
/*    */ import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
/*    */ import net.bytebuddy.asm.Advice;
/*    */ import net.bytebuddy.asm.Advice.OnMethodEnter;
/*    */ import net.bytebuddy.asm.Advice.OnMethodExit;
/*    */ import net.bytebuddy.asm.Advice.Return;
/*    */ import net.bytebuddy.implementation.bytecode.assign.Assigner;
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
/*    */ class CachedReturnPlugin$Advice$Object
/*    */ {
/*    */   private CachedReturnPlugin$Advice$Object() {
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
/*    */   protected static Object enter(@CacheField Object paramObject) {
/* 42 */     return paramObject;
/*    */   }
/*    */   
/*    */   @OnMethodExit
/*    */   @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
/*    */   protected static void exit(@Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object paramObject1, @CacheField Object paramObject2) {}
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\net\bytebuddy\build\CachedReturnPlugin$Advice$Object.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */