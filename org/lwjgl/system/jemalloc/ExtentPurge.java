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
/*    */ public abstract class ExtentPurge
/*    */   extends Callback
/*    */   implements ExtentPurgeI
/*    */ {
/*    */   public static ExtentPurge create(long paramLong) {
/*    */     ExtentPurgeI extentPurgeI;
/* 38 */     return (extentPurgeI = (ExtentPurgeI)Callback.get(paramLong) instanceof ExtentPurge) ? (ExtentPurge)extentPurgeI : new Container(paramLong, extentPurgeI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static ExtentPurge createSafe(long paramLong) {
/* 46 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExtentPurge create(ExtentPurgeI paramExtentPurgeI) {
/* 51 */     return (paramExtentPurgeI instanceof ExtentPurge) ? (ExtentPurge)paramExtentPurgeI : new Container(paramExtentPurgeI
/*    */         
/* 53 */         .address(), paramExtentPurgeI);
/*    */   }
/*    */   
/*    */   protected ExtentPurge() {
/* 57 */     super(CIF);
/*    */   }
/*    */   
/*    */   ExtentPurge(long paramLong) {
/* 61 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends ExtentPurge {
/*    */     private final ExtentPurgeI delegate;
/*    */     
/*    */     Container(long param1Long, ExtentPurgeI param1ExtentPurgeI) {
/* 69 */       super(param1Long);
/* 70 */       this.delegate = param1ExtentPurgeI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final boolean invoke(long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5, int param1Int) {
/* 75 */       return this.delegate.invoke(param1Long1, param1Long2, param1Long3, param1Long4, param1Long5, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\ExtentPurge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */