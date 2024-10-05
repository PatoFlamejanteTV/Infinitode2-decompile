/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.DataKeyBase;
/*    */ import com.vladsch.flexmark.util.data.NullableDataKey;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.builder.SegmentedSequenceStats;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface BasedOptionsHolder
/*    */ {
/*    */   public enum Options
/*    */   {
/* 18 */     COLLECT_SEGMENTED_STATS,
/* 19 */     COLLECT_FIRST256_STATS,
/* 20 */     NO_ANCHORS,
/* 21 */     FULL_SEGMENTED_SEQUENCES,
/* 22 */     TREE_SEGMENTED_SEQUENCES;
/*    */   }
/*    */   
/* 25 */   public static final Options O_COLLECT_SEGMENTED_STATS = Options.COLLECT_SEGMENTED_STATS;
/* 26 */   public static final Options O_COLLECT_FIRST256_STATS = Options.COLLECT_FIRST256_STATS;
/* 27 */   public static final Options O_NO_ANCHORS = Options.NO_ANCHORS;
/* 28 */   public static final Options O_FULL_SEGMENTED_SEQUENCES = Options.FULL_SEGMENTED_SEQUENCES;
/* 29 */   public static final Options O_TREE_SEGMENTED_SEQUENCES = Options.TREE_SEGMENTED_SEQUENCES;
/*    */ 
/*    */   
/* 32 */   public static final int F_COLLECT_SEGMENTED_STATS = BitFieldSet.intMask(O_COLLECT_SEGMENTED_STATS);
/* 33 */   public static final int F_COLLECT_FIRST256_STATS = BitFieldSet.intMask(O_COLLECT_FIRST256_STATS);
/* 34 */   public static final int F_NO_ANCHORS = BitFieldSet.intMask(O_NO_ANCHORS);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   public static final int F_FULL_SEGMENTED_SEQUENCES = BitFieldSet.intMask(O_FULL_SEGMENTED_SEQUENCES);
/* 40 */   public static final int F_TREE_SEGMENTED_SEQUENCES = BitFieldSet.intMask(O_TREE_SEGMENTED_SEQUENCES);
/*    */   
/*    */   public static final int F_LIBRARY_OPTIONS = 65535;
/*    */   
/*    */   public static final int F_APPLICATION_OPTIONS = -65536;
/*    */   
/* 46 */   public static final NullableDataKey<SegmentedSequenceStats> SEGMENTED_STATS = new NullableDataKey("SEGMENTED_STATS", null);
/*    */   
/*    */   static String optionsToString(int paramInt) {
/* 49 */     return BitFieldSet.of(Options.class, paramInt).toString();
/*    */   }
/*    */   
/*    */   int getOptionFlags();
/*    */   
/*    */   boolean allOptions(int paramInt);
/*    */   
/*    */   boolean anyOptions(int paramInt);
/*    */   
/*    */   <T> T getOption(DataKeyBase<T> paramDataKeyBase);
/*    */   
/*    */   DataHolder getOptions();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\BasedOptionsHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */