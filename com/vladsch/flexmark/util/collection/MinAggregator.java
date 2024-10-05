/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.function.BiFunction;
/*    */ 
/*    */ public class MinAggregator
/*    */   implements BiFunction<Integer, Integer, Integer>
/*    */ {
/*  8 */   public static final MinAggregator INSTANCE = new MinAggregator();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer apply(Integer paramInteger1, Integer paramInteger2) {
/* 15 */     return (paramInteger2 == null || (paramInteger1 != null && paramInteger1.intValue() <= paramInteger2.intValue())) ? paramInteger1 : paramInteger2;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\MinAggregator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */