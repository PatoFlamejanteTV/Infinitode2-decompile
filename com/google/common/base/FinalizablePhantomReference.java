/*    */ package com.google.common.base;
/*    */ 
/*    */ import java.lang.ref.PhantomReference;
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
/*    */ 
/*    */ 
/*    */ @ElementTypesAreNonnullByDefault
/*    */ public abstract class FinalizablePhantomReference<T>
/*    */   extends PhantomReference<T>
/*    */   implements FinalizableReference
/*    */ {
/*    */   protected FinalizablePhantomReference(T paramT, FinalizableReferenceQueue paramFinalizableReferenceQueue) {
/* 43 */     super(paramT, paramFinalizableReferenceQueue.queue);
/* 44 */     paramFinalizableReferenceQueue.cleanUp();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\FinalizablePhantomReference.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */