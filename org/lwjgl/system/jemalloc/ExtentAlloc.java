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
/*    */ public abstract class ExtentAlloc
/*    */   extends Callback
/*    */   implements ExtentAllocI
/*    */ {
/*    */   public static ExtentAlloc create(long paramLong) {
/*    */     ExtentAllocI extentAllocI;
/* 39 */     return (extentAllocI = (ExtentAllocI)Callback.get(paramLong) instanceof ExtentAlloc) ? (ExtentAlloc)extentAllocI : new Container(paramLong, extentAllocI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentAlloc createSafe(long paramLong) {
/* 47 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentAlloc create(ExtentAllocI paramExtentAllocI) {
/* 52 */     return (paramExtentAllocI instanceof ExtentAlloc) ? (ExtentAlloc)paramExtentAllocI : new Container(paramExtentAllocI
/*    */         
/* 54 */         .address(), paramExtentAllocI);
/*    */   }
/*    */   
/*    */   protected ExtentAlloc() {
/* 58 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentAlloc(long paramLong) {
/* 62 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentAlloc {
/*    */     private final ExtentAllocI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentAllocI param1ExtentAllocI) {
/* 70 */       super(param1Long);
/* 71 */       this.delegate = param1ExtentAllocI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, long param1Long6, int param1Int) {
/* 76 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Long4, param1Long5, param1Long6, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentAlloc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */