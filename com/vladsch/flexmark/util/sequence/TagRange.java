/*    */ package com.vladsch.flexmark.util.sequence;
/*    */ 
/*    */ public class TagRange extends Range {
/*    */   protected final String tag;
/*    */   
/*    */   public static TagRange of(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  7 */     return new TagRange(paramCharSequence, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   public TagRange(CharSequence paramCharSequence, Range paramRange) {
/* 11 */     super(paramRange);
/* 12 */     this.tag = String.valueOf(paramCharSequence);
/*    */   }
/*    */   
/*    */   public TagRange(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 16 */     super(paramInt1, paramInt2);
/* 17 */     this.tag = String.valueOf(paramCharSequence);
/*    */   }
/*    */   
/*    */   public String getTag() {
/* 21 */     return this.tag;
/*    */   }
/*    */   
/*    */   public TagRange withTag(CharSequence paramCharSequence) {
/* 25 */     return this.tag.equals(String.valueOf(paramCharSequence)) ? this : new TagRange(paramCharSequence, getStart(), getEnd());
/*    */   }
/*    */ 
/*    */   
/*    */   public TagRange withStart(int paramInt) {
/* 30 */     return (paramInt == getStart()) ? this : new TagRange(getTag(), paramInt, getEnd());
/*    */   }
/*    */ 
/*    */   
/*    */   public TagRange withEnd(int paramInt) {
/* 35 */     return (paramInt == getEnd()) ? this : new TagRange(getTag(), getStart(), paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public TagRange withRange(int paramInt1, int paramInt2) {
/* 40 */     return (paramInt1 == getStart() && paramInt2 == getEnd()) ? this : new TagRange(getTag(), paramInt1, paramInt2);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\sequence\TagRange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */