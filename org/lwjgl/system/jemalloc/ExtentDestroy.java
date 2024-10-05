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
/*    */ public abstract class ExtentDestroy
/*    */   extends Callback
/*    */   implements ExtentDestroyI
/*    */ {
/*    */   public static ExtentDestroy create(long paramLong) {
/*    */     ExtentDestroyI extentDestroyI;
/* 37 */     return (extentDestroyI = (ExtentDestroyI)Callback.get(paramLong) instanceof ExtentDestroy) ? (ExtentDestroy)extentDestroyI : new Container(paramLong, extentDestroyI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentDestroy createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentDestroy create(ExtentDestroyI paramExtentDestroyI) {
/* 50 */     return (paramExtentDestroyI instanceof ExtentDestroy) ? (ExtentDestroy)paramExtentDestroyI : new Container(paramExtentDestroyI
/*    */         
/* 52 */         .address(), paramExtentDestroyI);
/*    */   }
/*    */   
/*    */   protected ExtentDestroy() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentDestroy(long paramLong) {
/* 60 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentDestroy {
/*    */     private final ExtentDestroyI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentDestroyI param1ExtentDestroyI) {
/* 68 */       super(param1Long);
/* 69 */       this.delegate = param1ExtentDestroyI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, boolean param1Boolean, int param1Int) {
/* 74 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Boolean, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentDestroy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */