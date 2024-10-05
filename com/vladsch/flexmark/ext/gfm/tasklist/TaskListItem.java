/*    */ package com.vladsch.flexmark.ext.gfm.tasklist;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.ListItem;
/*    */ import com.vladsch.flexmark.ast.Paragraph;
/*    */ import com.vladsch.flexmark.parser.ListOptions;
/*    */ import com.vladsch.flexmark.util.ast.BlockContent;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskListItem
/*    */   extends ListItem
/*    */ {
/*    */   protected boolean isOrderedItem = false;
/*    */   protected boolean canChangeMarker = true;
/*    */   
/*    */   public void getAstExtra(StringBuilder paramStringBuilder) {
/* 24 */     super.getAstExtra(paramStringBuilder);
/* 25 */     if (this.isOrderedItem) paramStringBuilder.append(" isOrderedItem"); 
/* 26 */     paramStringBuilder.append(isItemDoneMarker() ? " isDone" : " isNotDone");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isParagraphWrappingDisabled(Paragraph paramParagraph, ListOptions paramListOptions, DataHolder paramDataHolder) {
/* 31 */     assert paramParagraph.getParent() == this;
/*    */ 
/*    */     
/* 34 */     Node node = getFirstChild();
/* 35 */     for (; node != null && !(node instanceof Paragraph); node = node.getNext());
/* 36 */     return (node == paramParagraph);
/*    */   }
/*    */ 
/*    */   
/*    */   public TaskListItem() {}
/*    */   
/*    */   public TaskListItem(BasedSequence paramBasedSequence) {
/* 43 */     super(paramBasedSequence);
/*    */   }
/*    */   
/*    */   public TaskListItem(BasedSequence paramBasedSequence, List<BasedSequence> paramList) {
/* 47 */     super(paramBasedSequence, paramList);
/*    */   }
/*    */   
/*    */   public TaskListItem(BlockContent paramBlockContent) {
/* 51 */     super(paramBlockContent);
/*    */   }
/*    */   
/*    */   public TaskListItem(ListItem paramListItem) {
/* 55 */     super(paramListItem);
/* 56 */     this.isOrderedItem = paramListItem instanceof com.vladsch.flexmark.ast.OrderedListItem;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setOpeningMarker(BasedSequence paramBasedSequence) {
/* 61 */     throw new IllegalStateException();
/*    */   }
/*    */   
/*    */   public boolean isItemDoneMarker() {
/* 65 */     return !this.markerSuffix.matches("[ ]");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isOrderedItem() {
/* 70 */     return this.isOrderedItem;
/*    */   }
/*    */   
/*    */   public void setOrderedItem(boolean paramBoolean) {
/* 74 */     this.isOrderedItem = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canChangeMarker() {
/* 79 */     return this.canChangeMarker;
/*    */   }
/*    */   
/*    */   public void setCanChangeMarker(boolean paramBoolean) {
/* 83 */     this.canChangeMarker = paramBoolean;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\tasklist\TaskListItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */