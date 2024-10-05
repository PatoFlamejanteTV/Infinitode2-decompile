/*    */ package org.lwjgl.openal;
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
/*    */ public abstract class SOFTCallbackBufferType
/*    */   extends Callback
/*    */   implements SOFTCallbackBufferTypeI
/*    */ {
/*    */   public static SOFTCallbackBufferType create(long paramLong) {
/*    */     SOFTCallbackBufferTypeI sOFTCallbackBufferTypeI;
/* 33 */     return (sOFTCallbackBufferTypeI = (SOFTCallbackBufferTypeI)Callback.get(paramLong) instanceof SOFTCallbackBufferType) ? (SOFTCallbackBufferType)sOFTCallbackBufferTypeI : new Container(paramLong, sOFTCallbackBufferTypeI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SOFTCallbackBufferType createSafe(long paramLong) {
/* 41 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SOFTCallbackBufferType create(SOFTCallbackBufferTypeI paramSOFTCallbackBufferTypeI) {
/* 46 */     return (paramSOFTCallbackBufferTypeI instanceof SOFTCallbackBufferType) ? (SOFTCallbackBufferType)paramSOFTCallbackBufferTypeI : new Container(paramSOFTCallbackBufferTypeI
/*    */         
/* 48 */         .address(), paramSOFTCallbackBufferTypeI);
/*    */   }
/*    */   
/*    */   protected SOFTCallbackBufferType() {
/* 52 */     super(CIF);
/*    */   }
/*    */   
/*    */   SOFTCallbackBufferType(long paramLong) {
/* 56 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends SOFTCallbackBufferType {
/*    */     private final SOFTCallbackBufferTypeI delegate;
/*    */     
/*    */     Container(long param1Long, SOFTCallbackBufferTypeI param1SOFTCallbackBufferTypeI) {
/* 64 */       super(param1Long);
/* 65 */       this.delegate = param1SOFTCallbackBufferTypeI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, long param1Long2, int param1Int) {
/* 70 */       return this.delegate.invoke(param1Long1, param1Long2, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTCallbackBufferType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */