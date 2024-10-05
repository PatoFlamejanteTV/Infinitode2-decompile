/*    */ package com.vladsch.flexmark.ast;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OrderedList
/*    */   extends ListBlock
/*    */ {
/*    */   private int startNumber;
/*    */   private char delimiter;
/*    */   
/*    */   public BasedSequence[] getSegments() {
/* 16 */     return EMPTY_SEGMENTS;
/*    */   }
/*    */ 
/*    */   
/*    */   public OrderedList() {}
/*    */   
/*    */   public OrderedList(BasedSequence paramBasedSequence) {
/* 23 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public OrderedList(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 27 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public OrderedList(BlockContent paramBlockContent) {
/* 31 */     super(paramBlockContent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 36 */     super.getAstExtra(paramStringBuilder);
/* 37 */     if (this.startNumber > 1) paramStringBuilder.append(" start:").append(this.startNumber); 
/* 38 */     paramStringBuilder.append(" delimiter:'").append(this.delimiter).append("'");
/*    */   }
/*    */   
/*    */   public int getStartNumber() {
/* 42 */     return this.startNumber;
/*    */   }
/*    */   
/*    */   public void setStartNumber(int paramInt) {
/* 46 */     this.startNumber = paramInt;
/*    */   }
/*    */   
/*    */   public char getDelimiter() {
/* 50 */     return this.delimiter;
/*    */   }
/*    */   
/*    */   public void setDelimiter(char paramChar) {
/* 54 */     this.delimiter = paramChar;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\OrderedList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */