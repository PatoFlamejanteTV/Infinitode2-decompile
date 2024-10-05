/*    */ package com.google.common.base;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ElementTypesAreNonnullByDefault
/*    */ public abstract class Ticker
/*    */ {
/*    */   public abstract long read();
/*    */   
/*    */   public static Ticker systemTicker() {
/* 45 */     return SYSTEM_TICKER;
/*    */   }
/*    */   
/* 48 */   private static final Ticker SYSTEM_TICKER = new Ticker()
/*    */     {
/*    */       public long read()
/*    */       {
/* 52 */         return Platform.systemNanoTime();
/*    */       }
/*    */     };
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Ticker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */