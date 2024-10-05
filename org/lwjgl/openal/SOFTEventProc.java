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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SOFTEventProc
/*    */   extends Callback
/*    */   implements SOFTEventProcI
/*    */ {
/*    */   public static SOFTEventProc create(long paramLong) {
/*    */     SOFTEventProcI sOFTEventProcI;
/* 36 */     return (sOFTEventProcI = (SOFTEventProcI)Callback.get(paramLong) instanceof SOFTEventProc) ? (SOFTEventProc)sOFTEventProcI : new Container(paramLong, sOFTEventProcI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SOFTEventProc createSafe(long paramLong) {
/* 44 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static SOFTEventProc create(SOFTEventProcI paramSOFTEventProcI) {
/* 49 */     return (paramSOFTEventProcI instanceof SOFTEventProc) ? (SOFTEventProc)paramSOFTEventProcI : new Container(paramSOFTEventProcI
/*    */         
/* 51 */         .address(), paramSOFTEventProcI);
/*    */   }
/*    */   
/*    */   protected SOFTEventProc() {
/* 55 */     super(CIF);
/*    */   }
/*    */   
/*    */   SOFTEventProc(long paramLong) {
/* 59 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends SOFTEventProc {
/*    */     private final SOFTEventProcI delegate;
/*    */     
/*    */     Container(long param1Long, SOFTEventProcI param1SOFTEventProcI) {
/* 67 */       super(param1Long);
/* 68 */       this.delegate = param1SOFTEventProcI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final void invoke(int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long1, long param1Long2) {
/* 73 */       this.delegate.invoke(param1Int1, param1Int2, param1Int3, param1Int4, param1Long1, param1Long2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\openal\SOFTEventProc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */