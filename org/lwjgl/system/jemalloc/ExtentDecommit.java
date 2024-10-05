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
/*    */ public abstract class ExtentDecommit
/*    */   extends Callback
/*    */   implements ExtentDecommitI
/*    */ {
/*    */   public static ExtentDecommit create(long paramLong) {
/*    */     ExtentDecommitI extentDecommitI;
/* 38 */     return (extentDecommitI = (ExtentDecommitI)Callback.get(paramLong) instanceof ExtentDecommit) ? (ExtentDecommit)extentDecommitI : new Container(paramLong, extentDecommitI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentDecommit createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentDecommit create(ExtentDecommitI paramExtentDecommitI) {
/* 51 */     return (paramExtentDecommitI instanceof ExtentDecommit) ? (ExtentDecommit)paramExtentDecommitI : new Container(paramExtentDecommitI
/*    */         
/* 53 */         .address(), paramExtentDecommitI);
/*    */   }
/*    */   
/*    */   protected ExtentDecommit() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentDecommit(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentDecommit {
/*    */     private final ExtentDecommitI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentDecommitI param1ExtentDecommitI) {
/* 69 */       super(param1Long);
/* 70 */       this.delegate = param1ExtentDecommitI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, int param1Int) {
/* 75 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Long4, param1Long5, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentDecommit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */