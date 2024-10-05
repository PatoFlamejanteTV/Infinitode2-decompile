/*    */ package com.vladsch.flexmark.util.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.misc.BitField;
/*    */ import com.vladsch.flexmark.util.misc.BitFieldSet;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import com.vladsch.flexmark.util.sequence.builder.ISequenceBuilder;
/*    */ 
/*    */ public interface TextContainer {
/*    */   public enum Flags implements BitField {
/* 10 */     LINK_TEXT_TYPE(3),
/* 11 */     NODE_TEXT,
/* 12 */     FOR_HEADING_ID,
/* 13 */     NO_TRIM_REF_TEXT_START,
/* 14 */     NO_TRIM_REF_TEXT_END,
/* 15 */     ADD_SPACES_BETWEEN_NODES;
/*    */ 
/*    */ 
/*    */     
/*    */     final int bits;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     Flags(int param1Int1) {
/* 25 */       this.bits = param1Int1;
/*    */     }
/*    */ 
/*    */     
/*    */     public final int getBits() {
/* 30 */       return this.bits;
/*    */     }
/*    */   }
/*    */   
/* 34 */   public static final int F_LINK_TEXT_TYPE = BitFieldSet.intMask(Flags.LINK_TEXT_TYPE);
/*    */   
/*    */   public static final int F_LINK_TEXT = 0;
/*    */   public static final int F_LINK_PAGE_REF = 1;
/*    */   public static final int F_LINK_ANCHOR = 2;
/*    */   public static final int F_LINK_URL = 3;
/*    */   public static final int F_LINK_NODE_TEXT = 4;
/* 41 */   public static final int F_NODE_TEXT = BitFieldSet.intMask(Flags.NODE_TEXT);
/* 42 */   public static final int F_FOR_HEADING_ID = BitFieldSet.intMask(Flags.FOR_HEADING_ID);
/* 43 */   public static final int F_NO_TRIM_REF_TEXT_START = BitFieldSet.intMask(Flags.NO_TRIM_REF_TEXT_START);
/* 44 */   public static final int F_NO_TRIM_REF_TEXT_END = BitFieldSet.intMask(Flags.NO_TRIM_REF_TEXT_END);
/* 45 */   public static final int F_ADD_SPACES_BETWEEN_NODES = BitFieldSet.intMask(Flags.ADD_SPACES_BETWEEN_NODES);
/*    */   
/*    */   boolean collectText(ISequenceBuilder<? extends ISequenceBuilder<?, BasedSequence>, BasedSequence> paramISequenceBuilder, int paramInt, NodeVisitor paramNodeVisitor);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\TextContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */