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
/*    */ public abstract class STBIEOFCallback
/*    */   extends Callback
/*    */   implements STBIEOFCallbackI
/*    */ {
/*    */   public static STBIEOFCallback create(long paramLong) {
/*    */     STBIEOFCallbackI sTBIEOFCallbackI;
/* 33 */     return (sTBIEOFCallbackI = (STBIEOFCallbackI)Callback.get(paramLong) instanceof STBIEOFCallback) ? (STBIEOFCallback)sTBIEOFCallbackI : new Container(paramLong, sTBIEOFCallbackI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static STBIEOFCallback createSafe(long paramLong) {
/* 41 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static STBIEOFCallback create(STBIEOFCallbackI paramSTBIEOFCallbackI) {
/* 46 */     return (paramSTBIEOFCallbackI instanceof STBIEOFCallback) ? (STBIEOFCallback)paramSTBIEOFCallbackI : new Container(paramSTBIEOFCallbackI
/*    */         
/* 48 */         .address(), paramSTBIEOFCallbackI);
/*    */   }
/*    */   
/*    */   protected STBIEOFCallback() {
/* 52 */     super(CIF);
/*    */   }
/*    */   
/*    */   STBIEOFCallback(long paramLong) {
/* 56 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends STBIEOFCallback {
/*    */     private final STBIEOFCallbackI delegate;
/*    */     
/*    */     Container(long param1Long, STBIEOFCallbackI param1STBIEOFCallbackI) {
/* 64 */       super(param1Long);
/* 65 */       this.delegate = param1STBIEOFCallbackI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final int invoke(long param1Long) {
/* 70 */       return this.delegate.invoke(param1Long);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\stb\STBIEOFCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */