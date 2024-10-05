/*    */ package org.lwjgl.system.macosx;
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
/*    */ public abstract class CGEventTapCallBack
/*    */   extends Callback
/*    */   implements CGEventTapCallBackI
/*    */ {
/*    */   public static CGEventTapCallBack create(long paramLong) {
/*    */     CGEventTapCallBackI cGEventTapCallBackI;
/* 36 */     return (cGEventTapCallBackI = (CGEventTapCallBackI)Callback.get(paramLong) instanceof CGEventTapCallBack) ? (CGEventTapCallBack)cGEventTapCallBackI : new Container(paramLong, cGEventTapCallBackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static CGEventTapCallBack createSafe(long paramLong) {
/* 44 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CGEventTapCallBack create(CGEventTapCallBackI paramCGEventTapCallBackI) {
/* 49 */     return (paramCGEventTapCallBackI instanceof CGEventTapCallBack) ? (CGEventTapCallBack)paramCGEventTapCallBackI : new Container(paramCGEventTapCallBackI
/*    */         
/* 51 */         .address(), paramCGEventTapCallBackI);
/*    */   }
/*    */   
/*    */   protected CGEventTapCallBack() {
/* 55 */     super(CIF);
/*    */   }
/*    */   
/*    */   CGEventTapCallBack(long paramLong) {
/* 59 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends CGEventTapCallBack {
/*    */     private final CGEventTapCallBackI delegate;
/*    */     
/*    */     Container(long param1Long, CGEventTapCallBackI param1CGEventTapCallBackI) {
/* 67 */       super(param1Long);
/* 68 */       this.delegate = param1CGEventTapCallBackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, int param1Int, long param1Long2, long param1Long3) {
/* 73 */       return this.delegate.invoke(param1Long1, param1Int, param1Long2, param1Long3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\CGEventTapCallBack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */