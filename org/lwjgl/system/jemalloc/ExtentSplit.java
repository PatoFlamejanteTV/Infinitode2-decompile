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
/*    */ 
/*    */ public abstract class ExtentSplit
/*    */   extends Callback
/*    */   implements ExtentSplitI
/*    */ {
/*    */   public static ExtentSplit create(long paramLong) {
/*    */     ExtentSplitI extentSplitI;
/* 39 */     return (extentSplitI = (ExtentSplitI)Callback.get(paramLong) instanceof ExtentSplit) ? (ExtentSplit)extentSplitI : new Container(paramLong, extentSplitI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentSplit createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentSplit create(ExtentSplitI paramExtentSplitI) {
/* 52 */     return (paramExtentSplitI instanceof ExtentSplit) ? (ExtentSplit)paramExtentSplitI : new Container(paramExtentSplitI
/*    */         
/* 54 */         .address(), paramExtentSplitI);
/*    */   }
/*    */   
/*    */   protected ExtentSplit() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentSplit(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentSplit {
/*    */     private final ExtentSplitI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentSplitI param1ExtentSplitI) {
/* 70 */       super(param1Long);
/* 71 */       this.delegate = param1ExtentSplitI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, boolean param1Boolean, int param1Int) {
/* 76 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Long4, param1Long5, param1Boolean, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentSplit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */