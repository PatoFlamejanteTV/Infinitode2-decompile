/*    */ package org.lwjgl.system.jemalloc;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class ExtentCommit
/*    */   extends Callback
/*    */   implements ExtentCommitI
/*    */ {
/*    */   public static ExtentCommit create(long paramLong) {
/*    */     ExtentCommitI extentCommitI;
/* 38 */     return (extentCommitI = (ExtentCommitI)Callback.get(paramLong) instanceof ExtentCommit) ? (ExtentCommit)extentCommitI : new Container(paramLong, extentCommitI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentCommit createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentCommit create(ExtentCommitI paramExtentCommitI) {
/* 51 */     return (paramExtentCommitI instanceof ExtentCommit) ? (ExtentCommit)paramExtentCommitI : new Container(paramExtentCommitI
/*    */         
/* 53 */         .address(), paramExtentCommitI);
/*    */   }
/*    */   
/*    */   protected ExtentCommit() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentCommit(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentCommit {
/*    */     private final ExtentCommitI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentCommitI param1ExtentCommitI) {
/* 69 */       super(param1Long);
/* 70 */       this.delegate = param1ExtentCommitI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, int param1Int) {
/* 75 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Long4, param1Long5, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentCommit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */