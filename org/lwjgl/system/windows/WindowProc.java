/*    */ package org.lwjgl.system.windows;
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
/*    */ public abstract class WindowProc
/*    */   extends Callback
/*    */   implements WindowProcI
/*    */ {
/*    */   public static WindowProc create(long paramLong) {
/*    */     WindowProcI windowProcI;
/* 36 */     return (windowProcI = (WindowProcI)Callback.get(paramLong) instanceof WindowProc) ? (WindowProc)windowProcI : new Container(paramLong, windowProcI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static WindowProc createSafe(long paramLong) {
/* 44 */     return (paramLong == 0L) ? null : create(paramLong);
/*    */   }
/*    */ 
/*    */   
/*    */   public static WindowProc create(WindowProcI paramWindowProcI) {
/* 49 */     return (paramWindowProcI instanceof WindowProc) ? (WindowProc)paramWindowProcI : new Container(paramWindowProcI
/*    */         
/* 51 */         .address(), paramWindowProcI);
/*    */   }
/*    */   
/*    */   protected WindowProc() {
/* 55 */     super(CIF);
/*    */   }
/*    */   
/*    */   WindowProc(long paramLong) {
/* 59 */     super(paramLong);
/*    */   }
/*    */   
/*    */   private static final class Container
/*    */     extends WindowProc {
/*    */     private final WindowProcI delegate;
/*    */     
/*    */     Container(long param1Long, WindowProcI param1WindowProcI) {
/* 67 */       super(param1Long);
/* 68 */       this.delegate = param1WindowProcI;
/*    */     }
/*    */ 
/*    */     
/*    */     public final long invoke(long param1Long1, int param1Int, long param1Long2, long param1Long3) {
/* 73 */       return this.delegate.invoke(param1Long1, param1Int, param1Long2, param1Long3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\lwjgl\system\windows\WindowProc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */