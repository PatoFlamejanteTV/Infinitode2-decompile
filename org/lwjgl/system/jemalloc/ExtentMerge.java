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
/*    */ public abstract class ExtentMerge
/*    */   extends Callback
/*    */   implements ExtentMergeI
/*    */ {
/*    */   public static ExtentMerge create(long paramLong) {
/*    */     ExtentMergeI extentMergeI;
/* 39 */     return (extentMergeI = (ExtentMergeI)Callback.get(paramLong) instanceof ExtentMerge) ? (ExtentMerge)extentMergeI : new Container(paramLong, extentMergeI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentMerge createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentMerge create(ExtentMergeI paramExtentMergeI) {
/* 52 */     return (paramExtentMergeI instanceof ExtentMerge) ? (ExtentMerge)paramExtentMergeI : new Container(paramExtentMergeI
/*    */         
/* 54 */         .address(), paramExtentMergeI);
/*    */   }
/*    */   
/*    */   protected ExtentMerge() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentMerge(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentMerge {
/*    */     private final ExtentMergeI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentMergeI param1ExtentMergeI) {
/* 70 */       super(param1Long);
/* 71 */       this.delegate = param1ExtentMergeI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, boolean param1Boolean, int param1Int) {
/* 76 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Long4, param1Long5, param1Boolean, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentMerge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */