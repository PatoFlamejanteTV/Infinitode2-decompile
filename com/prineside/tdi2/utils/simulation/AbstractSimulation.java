/*    */ package com.prineside.tdi2.utils.simulation;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ public abstract class AbstractSimulation
/*    */   implements Simulation {
/*  8 */   private static final TLog a = TLog.forClass(AbstractSimulation.class);
/*    */   private SimLogListener b = (paramByte, paramString) -> {
/*    */     
/*    */     };
/*    */   
/*    */   public void setSimLogListener(SimLogListener paramSimLogListener) {
/* 14 */     Preconditions.checkNotNull(paramSimLogListener);
/* 15 */     this.b = paramSimLogListener;
/*    */   }
/*    */   
/*    */   public void logThrowable(byte paramByte, String paramString, Throwable paramThrowable) {
/* 19 */     switch (paramByte) {
/*    */       case 1:
/*    */       case 2:
/* 22 */         a.i(getClass().getSimpleName(), new Object[] { paramString, paramThrowable });
/*    */         break;
/*    */       case 3:
/* 25 */         a.e(getClass().getSimpleName(), new Object[] { paramString, paramThrowable });
/*    */         break;
/*    */     } 
/* 28 */     this.b.onLog(paramByte, paramString);
/*    */   }
/*    */   
/*    */   public void log(byte paramByte, String paramString) {
/* 32 */     switch (paramByte) {
/*    */       case 1:
/*    */       case 2:
/* 35 */         a.i(getClass().getSimpleName(), new Object[] { paramString });
/*    */         break;
/*    */       case 3:
/* 38 */         a.e(getClass().getSimpleName(), new Object[] { paramString });
/*    */         break;
/*    */     } 
/* 41 */     this.b.onLog(paramByte, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\AbstractSimulation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */