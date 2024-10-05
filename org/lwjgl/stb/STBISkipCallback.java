/*    */ package org.lwjgl.stb;
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
/*    */ public abstract class STBISkipCallback
/*    */   extends Callback
/*    */   implements STBISkipCallbackI
/*    */ {
/*    */   public static STBISkipCallback create(long paramLong) {
/*    */     STBISkipCallbackI sTBISkipCallbackI;
/* 34 */     return (sTBISkipCallbackI = (STBISkipCallbackI)Callback.get(paramLong) instanceof STBISkipCallback) ? (STBISkipCallback)sTBISkipCallbackI : new Container(paramLong, sTBISkipCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBISkipCallback createSafe(long paramLong) {
/* 42 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBISkipCallback create(STBISkipCallbackI paramSTBISkipCallbackI) {
/* 47 */     return (paramSTBISkipCallbackI instanceof STBISkipCallback) ? (STBISkipCallback)paramSTBISkipCallbackI : new Container(paramSTBISkipCallbackI
/*    */         
/* 49 */         .address(), paramSTBISkipCallbackI);
/*    */   }
/*    */   
/*    */   protected STBISkipCallback() {
/* 53 */     super(CIF);
/*    */   }
/*    */   
/*    */   STBISkipCallback(long paramLong) {
/* 57 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBISkipCallback {
/*    */     private final STBISkipCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, STBISkipCallbackI param1STBISkipCallbackI) {
/* 65 */       super(param1Long);
/* 66 */       this.delegate = param1STBISkipCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(long param1Long, int param1Int) {
/* 71 */       this.delegate.invoke(param1Long, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBISkipCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */