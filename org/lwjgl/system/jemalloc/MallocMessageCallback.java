/*    */ package org.lwjgl.system.jemalloc;
/*    */ 
/*    */ import org.lwjgl.system.Callback;
/*    */ import org.lwjgl.system.MemoryUtil;
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
/*    */ public abstract class MallocMessageCallback
/*    */   extends Callback
/*    */   implements MallocMessageCallbackI
/*    */ {
/*    */   public static MallocMessageCallback create(long paramLong) {
/*    */     MallocMessageCallbackI mallocMessageCallbackI;
/* 34 */     return (mallocMessageCallbackI = (MallocMessageCallbackI)Callback.get(paramLong) instanceof MallocMessageCallback) ? (MallocMessageCallback)mallocMessageCallbackI : new Container(paramLong, mallocMessageCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static MallocMessageCallback createSafe(long paramLong) {
/* 42 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static MallocMessageCallback create(MallocMessageCallbackI paramMallocMessageCallbackI) {
/* 47 */     return (paramMallocMessageCallbackI instanceof MallocMessageCallback) ? (MallocMessageCallback)paramMallocMessageCallbackI : new Container(paramMallocMessageCallbackI
/*    */         
/* 49 */         .address(), paramMallocMessageCallbackI);
/*    */   }
/*    */   
/*    */   protected MallocMessageCallback() {
/* 53 */     super(CIF);
/*    */   }
/*    */   
/*    */   MallocMessageCallback(long paramLong) {
/* 57 */     super(paramLong);
/*    */   }
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
/*    */   public static String getMessage(long paramLong) {
/* 70 */     return MemoryUtil.memASCII(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends MallocMessageCallback {
/*    */     private final MallocMessageCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, MallocMessageCallbackI param1MallocMessageCallbackI) {
/* 78 */       super(param1Long);
/* 79 */       this.delegate = param1MallocMessageCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long1, long param1Long2) {
/* 84 */       this.delegate.invoke(param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\jemalloc\MallocMessageCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */