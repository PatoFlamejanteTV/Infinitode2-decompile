/*    */ package com.vladsch.flexmark.ext.gfm.tasklist.internal;
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
/*    */ import com.vladsch.flexmark.html.HtmlWriter;
/*    */ import com.vladsch.flexmark.html.renderer.AttributablePart;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererContext;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ 
/*    */ public class TaskListNodeRenderer implements NodeRenderer {
/* 16 */   public static final AttributablePart TASK_ITEM_PARAGRAPH = new AttributablePart("TASK_ITEM_PARAGRAPH");
/*    */   
/*    */   final String doneMarker;
/*    */   final String notDoneMarker;
/*    */   private final String tightItemClass;
/*    */   private final String looseItemClass;
/*    */   private final String itemDoneClass;
/*    */   private final String itemNotDoneClass;
/*    */   final String paragraphClass;
/*    */   private final ListOptions listOptions;
/*    */   
/*    */   public TaskListNodeRenderer(DataHolder paramDataHolder) {
/* 28 */     this.doneMarker = (String)TaskListExtension.ITEM_DONE_MARKER.get(paramDataHolder);
/* 29 */     this.notDoneMarker = (String)TaskListExtension.ITEM_NOT_DONE_MARKER.get(paramDataHolder);
/* 30 */     this.tightItemClass = (String)TaskListExtension.TIGHT_ITEM_CLASS.get(paramDataHolder);
/* 31 */     this.looseItemClass = (String)TaskListExtension.LOOSE_ITEM_CLASS.get(paramDataHolder);
/* 32 */     this.itemDoneClass = (String)TaskListExtension.ITEM_DONE_CLASS.get(paramDataHolder);
/* 33 */     this.itemNotDoneClass = (String)TaskListExtension.ITEM_NOT_DONE_CLASS.get(paramDataHolder);
/* 34 */     this.paragraphClass = (String)TaskListExtension.PARAGRAPH_CLASS.get(paramDataHolder);
/* 35 */     this.listOptions = ListOptions.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
/*    */     HashSet<NodeRenderingHandler> hashSet;
/* 41 */     (hashSet = new HashSet<>()).add(new NodeRenderingHandler(TaskListItem.class, this::render));
/* 42 */     return (Set)hashSet;
/*    */   }
/*    */   
/*    */   void render(TaskListItem paramTaskListItem, NodeRendererContext paramNodeRendererContext, HtmlWriter paramHtmlWriter) {
/* 46 */     BasedSequence basedSequence = ((paramNodeRendererContext.getHtmlOptions()).sourcePositionParagraphLines || paramTaskListItem.getFirstChild() == null) ? paramTaskListItem.getChars() : paramTaskListItem.getFirstChild().getChars();
/* 47 */     String str = paramTaskListItem.isItemDoneMarker() ? this.itemDoneClass : this.itemNotDoneClass;
/* 48 */     if (this.listOptions.isTightListItem((ListItem)paramTaskListItem)) {
/* 49 */       if (!this.tightItemClass.isEmpty()) paramHtmlWriter.attr("class", this.tightItemClass); 
/* 50 */       if (!str.isEmpty() && !str.equals(this.tightItemClass)) paramHtmlWriter.attr("class", str); 
/* 51 */       ((HtmlWriter)paramHtmlWriter.srcPos(basedSequence.getStartOffset(), basedSequence.getEndOffset()).withAttr(CoreNodeRenderer.TIGHT_LIST_ITEM).withCondIndent()).tagLine("li", () -> {
/*    */             paramHtmlWriter.raw(paramTaskListItem.isItemDoneMarker() ? this.doneMarker : this.notDoneMarker); paramNodeRendererContext.renderChildren((Node)paramTaskListItem);
/*    */           });
/*    */       return;
/*    */     } 
/* 56 */     if (!this.looseItemClass.isEmpty()) paramHtmlWriter.attr("class", this.looseItemClass); 
/* 57 */     if (!str.isEmpty() && !str.equals(this.looseItemClass)) paramHtmlWriter.attr("class", str); 
/* 58 */     paramHtmlWriter.withAttr(CoreNodeRenderer.LOOSE_LIST_ITEM).tagIndent("li", () -> {
/*    */           if (!this.paragraphClass.isEmpty()) {
/*    */             paramHtmlWriter.attr("class", this.paragraphClass);
/*    */           }
/*    */           paramHtmlWriter.srcPos(paramBasedSequence.getStartOffset(), paramBasedSequence.getEndOffset()).withAttr(TASK_ITEM_PARAGRAPH).tagLine("p", ());
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static class Factory
/*    */     implements NodeRendererFactory
/*    */   {
/*    */     public NodeRenderer apply(DataHolder param1DataHolder) {
/* 72 */       return new TaskListNodeRenderer(param1DataHolder);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\tasklist\internal\TaskListNodeRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */