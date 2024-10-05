/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.lang.ref.WeakReference;
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
/*    */ 
/*    */ 
/*    */ @ElementTypesAreNonnullByDefault
/*    */ public abstract class FinalizableWeakReference<T>
/*    */   extends WeakReference<T>
/*    */   implements FinalizableReference
/*    */ {
/*    */   protected FinalizableWeakReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue) {
/* 41 */     super(paramT, paramFinalizableReferenceQueue.queue);
/* 42 */     paramFinalizableReferenceQueue.cleanUp();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\FinalizableWeakReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */