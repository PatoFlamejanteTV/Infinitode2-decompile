/*    */ package com.vladsch.flexmark.util.sequence.builder;
/*    */ 
/*    */ 
/*    */ public class PlainSegmentBuilder
/*    */   extends SegmentBuilderBase<PlainSegmentBuilder>
/*    */ {
/*    */   public PlainSegmentBuilder() {}
/*    */   
/*    */   public PlainSegmentBuilder(int paramInt) {
/* 10 */     super(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlainSegmentBuilder emptyBuilder() {
/* 15 */     return new PlainSegmentBuilder();
/*    */   }
/*    */ 
/*    */   
/*    */   public static PlainSegmentBuilder emptyBuilder(int paramInt) {
/* 20 */     return new PlainSegmentBuilder(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\builder\PlainSegmentBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */