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
/*    */ public abstract class ExtentDalloc
/*    */   extends Callback
/*    */   implements ExtentDallocI
/*    */ {
/*    */   public static ExtentDalloc create(long paramLong) {
/*    */     ExtentDallocI extentDallocI;
/* 37 */     return (extentDallocI = (ExtentDallocI)Callback.get(paramLong) instanceof ExtentDalloc) ? (ExtentDalloc)extentDallocI : new Container(paramLong, extentDallocI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentDalloc createSafe(long paramLong) {
/* 45 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentDalloc create(ExtentDallocI paramExtentDallocI) {
/* 50 */     return (paramExtentDallocI instanceof ExtentDalloc) ? (ExtentDalloc)paramExtentDallocI : new Container(paramExtentDallocI
/*    */         
/* 52 */         .address(), paramExtentDallocI);
/*    */   }
/*    */   
/*    */   protected ExtentDalloc() {
/* 56 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentDalloc(long paramLong) {
/* 60 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentDalloc {
/*    */     private final ExtentDallocI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentDallocI param1ExtentDallocI) {
/* 68 */       super(param1Long);
/* 69 */       this.delegate = param1ExtentDallocI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, boolean param1Boolean, int param1Int) {
/* 74 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Boolean, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentDalloc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */