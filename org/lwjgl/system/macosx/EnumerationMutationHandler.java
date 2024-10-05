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
/*    */ public abstract class EnumerationMutationHandler
/*    */   extends Callback
/*    */   implements EnumerationMutationHandlerI
/*    */ {
/*    */   public static EnumerationMutationHandler create(long paramLong) {
/*    */     EnumerationMutationHandlerI enumerationMutationHandlerI;
/* 33 */     return (enumerationMutationHandlerI = (EnumerationMutationHandlerI)Callback.get(paramLong) instanceof EnumerationMutationHandler) ? (EnumerationMutationHandler)enumerationMutationHandlerI : new Container(paramLong, enumerationMutationHandlerI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static EnumerationMutationHandler createSafe(long paramLong) {
/* 41 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static EnumerationMutationHandler create(EnumerationMutationHandlerI paramEnumerationMutationHandlerI) {
/* 46 */     return (paramEnumerationMutationHandlerI instanceof EnumerationMutationHandler) ? (EnumerationMutationHandler)paramEnumerationMutationHandlerI : new Container(paramEnumerationMutationHandlerI
/*    */         
/* 48 */         .address(), paramEnumerationMutationHandlerI);
/*    */   }
/*    */   
/*    */   protected EnumerationMutationHandler() {
/* 52 */     super(CIF);
/*    */   }
/*    */   
/*    */   EnumerationMutationHandler(long paramLong) {
/* 56 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends EnumerationMutationHandler {
/*    */     private final EnumerationMutationHandlerI delegate;
/*    */     
/*    */     Container(long param1Long, EnumerationMutationHandlerI param1EnumerationMutationHandlerI) {
/* 64 */       super(param1Long);
/* 65 */       this.delegate = param1EnumerationMutationHandlerI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long) {
/* 70 */       this.delegate.invoke(param1Long);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\macosx\EnumerationMutationHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */