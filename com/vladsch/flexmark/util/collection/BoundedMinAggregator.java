/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.function.BiFunction;
/*    */ 
/*    */ public class BoundedMinAggregator
/*    */   implements BiFunction<Integer, Integer, Integer>
/*    */ {
/*    */   public final int minBound;
/*    */   
/*    */   public BoundedMinAggregator(int paramInt) {
/* 11 */     this.minBound = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer apply(Integer paramInteger1, Integer paramInteger2) {
/* 16 */     if (paramInteger2 != null && paramInteger2.intValue() > this.minBound) return MinAggregator.INSTANCE.apply(paramInteger1, paramInteger2); 
/* 17 */     return paramInteger1;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\BoundedMinAggregator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */