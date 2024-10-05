/*    */ package com.vladsch.flexmark.ext.gfm.tasklist.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.BulletListItem;
/*    */ import com.vladsch.flexmark.ast.ListItem;
/*    */ import com.vladsch.flexmark.ast.OrderedListItem;
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
/*    */ import com.vladsch.flexmark.parser.block.BlockPreProcessor;
/*    */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*    */ import com.vladsch.flexmark.parser.block.ParserState;
/*    */ import com.vladsch.flexmark.util.ast.Block;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskListItemBlockPreProcessor
/*    */   implements BlockPreProcessor
/*    */ {
/*    */   public TaskListItemBlockPreProcessor(DataHolder paramDataHolder) {}
/*    */   
/*    */   public void preProcess(ParserState paramParserState, Block paramBlock) {
/* 26 */     if (paramBlock instanceof BulletListItem || paramBlock instanceof OrderedListItem) {
/*    */       ListItem listItem;
/*    */ 
/*    */       
/*    */       BasedSequence basedSequence;
/*    */ 
/*    */       
/* 33 */       if ((basedSequence = (listItem = (ListItem)paramBlock).getMarkerSuffix()).matches("[ ]") || basedSequence.matches("[x]") || basedSequence.matches("[X]")) {
/*    */         TaskListItem taskListItem;
/* 35 */         (taskListItem = new TaskListItem(listItem)).setTight(listItem.isOwnTight());
/* 36 */         listItem.insertBefore((Node)taskListItem);
/* 37 */         listItem.unlink();
/* 38 */         paramParserState.blockAdded((Block)taskListItem);
/* 39 */         paramParserState.blockRemoved((Block)listItem);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static class Factory
/*    */     implements BlockPreProcessorFactory
/*    */   {
/*    */     public Set<Class<? extends Block>> getBlockTypes() {
/*    */       HashSet<Class<BulletListItem>> hashSet;
/* 49 */       (hashSet = new HashSet<>()).add(BulletListItem.class);
/* 50 */       hashSet.add(OrderedListItem.class);
/* 51 */       return (Set)hashSet;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getAfterDependents() {
/* 57 */       return null;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public Set<Class<?>> getBeforeDependents() {
/* 63 */       return null;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean affectsGlobalScope() {
/* 68 */       return true;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public BlockPreProcessor apply(ParserState param1ParserState) {
/* 74 */       return new TaskListItemBlockPreProcessor((DataHolder)param1ParserState.getProperties());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\tasklist\internal\TaskListItemBlockPreProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */