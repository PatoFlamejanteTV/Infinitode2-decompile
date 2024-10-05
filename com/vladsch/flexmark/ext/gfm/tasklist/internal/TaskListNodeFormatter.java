/*     */ package com.vladsch.flexmark.ext.gfm.tasklist.internal;
/*     */ import com.vladsch.flexmark.ast.BulletList;
/*     */ import com.vladsch.flexmark.ast.ListBlock;
/*     */ import com.vladsch.flexmark.ast.ListItem;
/*     */ import com.vladsch.flexmark.ast.OrderedList;
/*     */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
/*     */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemCase;
/*     */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemPlacement;
/*     */ import com.vladsch.flexmark.formatter.FormatterUtils;
/*     */ import com.vladsch.flexmark.formatter.MarkdownWriter;
/*     */ import com.vladsch.flexmark.formatter.NodeFormatterContext;
/*     */ import com.vladsch.flexmark.formatter.NodeFormattingHandler;
/*     */ import com.vladsch.flexmark.parser.ListOptions;
/*     */ import com.vladsch.flexmark.util.ast.BlankLine;
/*     */ import com.vladsch.flexmark.util.ast.Node;
/*     */ import com.vladsch.flexmark.util.data.DataHolder;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import com.vladsch.flexmark.util.sequence.builder.SequenceBuilder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class TaskListNodeFormatter implements NodeFormatter {
/*     */   public TaskListNodeFormatter(DataHolder paramDataHolder) {
/*  26 */     this.taskListFormatOptions = new TaskListFormatOptions(paramDataHolder);
/*  27 */     this.listOptions = ListOptions.get(paramDataHolder);
/*     */   }
/*     */   private final TaskListFormatOptions taskListFormatOptions;
/*     */   private final ListOptions listOptions;
/*     */   
/*     */   public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
/*  33 */     return new HashSet<>(Arrays.asList((NodeFormattingHandler<?>[])new NodeFormattingHandler[] { new NodeFormattingHandler(TaskListItem.class, this::render), new NodeFormattingHandler(BulletList.class, this::render), new NodeFormattingHandler(OrderedList.class, this::render) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Class<?>> getNodeClasses() {
/*  43 */     return null;
/*     */   }
/*     */   
/*     */   private void render(TaskListItem paramTaskListItem, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  47 */     if (paramNodeFormatterContext.isTransformingText()) {
/*  48 */       FormatterUtils.renderListItem((ListItem)paramTaskListItem, paramNodeFormatterContext, paramMarkdownWriter, this.listOptions, paramTaskListItem.getMarkerSuffix(), false); return;
/*     */     } 
/*  50 */     BasedSequence basedSequence = paramTaskListItem.getMarkerSuffix();
/*  51 */     switch (this.taskListFormatOptions.taskListItemCase) {
/*     */       case AS_IS:
/*     */         break;
/*     */       
/*     */       case INCOMPLETE_FIRST:
/*  56 */         basedSequence = (BasedSequence)basedSequence.toLowerCase();
/*     */         break;
/*     */       
/*     */       case INCOMPLETE_NESTED_FIRST:
/*  60 */         basedSequence = (BasedSequence)basedSequence.toUpperCase();
/*     */         break;
/*     */       
/*     */       default:
/*  64 */         throw new IllegalStateException("Missing case for TaskListItemCase " + this.taskListFormatOptions.taskListItemCase.name());
/*     */     } 
/*     */     
/*  67 */     if (paramTaskListItem.isItemDoneMarker()) {
/*  68 */       switch (this.taskListFormatOptions.taskListItemPlacement) {
/*     */         case AS_IS:
/*     */         case INCOMPLETE_FIRST:
/*     */         case INCOMPLETE_NESTED_FIRST:
/*     */           break;
/*     */         
/*     */         case COMPLETE_TO_NON_TASK:
/*     */         case COMPLETE_NESTED_TO_NON_TASK:
/*  76 */           basedSequence = basedSequence.getEmptySuffix();
/*     */           break;
/*     */         
/*     */         default:
/*  80 */           throw new IllegalStateException("Missing case for ListItemPlacement " + this.taskListFormatOptions.taskListItemPlacement.name());
/*     */       } 
/*     */     
/*     */     }
/*  84 */     if (basedSequence.isNotEmpty() && this.taskListFormatOptions.formatPrioritizedTaskItems) {
/*  85 */       paramTaskListItem.setCanChangeMarker(false);
/*     */     }
/*     */ 
/*     */     
/*  89 */     boolean bool = (paramTaskListItem.isLoose() && paramTaskListItem.hasChildren() && paramTaskListItem.getFirstChildAnyNot(new Class[] { BlankLine.class }) != null) ? true : false;
/*  90 */     FormatterUtils.renderListItem((ListItem)paramTaskListItem, paramNodeFormatterContext, paramMarkdownWriter, this.listOptions, basedSequence.isEmpty() ? basedSequence : ((SequenceBuilder)((SequenceBuilder)((SequenceBuilder)basedSequence
/*  91 */         .getBuilder().append((CharSequence)basedSequence)).append(" ")).append((CharSequence)basedSequence.baseSubSequence(basedSequence.getEndOffset() + 1, basedSequence.getEndOffset() + 1))).toSequence(), bool);
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(BulletList paramBulletList, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/*  96 */     renderList((ListBlock)paramBulletList, paramNodeFormatterContext, paramMarkdownWriter);
/*     */   }
/*     */   
/*     */   private void render(OrderedList paramOrderedList, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 100 */     renderList((ListBlock)paramOrderedList, paramNodeFormatterContext, paramMarkdownWriter);
/*     */   }
/*     */   
/*     */   public static boolean hasIncompleteDescendants(Node paramNode) {
/* 104 */     paramNode = paramNode.getFirstChild();
/* 105 */     while (paramNode != null) {
/* 106 */       if (paramNode instanceof TaskListItem && 
/* 107 */         !((TaskListItem)paramNode).isItemDoneMarker()) {
/* 108 */         return true;
/*     */       }
/*     */       
/* 111 */       if (paramNode instanceof com.vladsch.flexmark.util.ast.Block && !(paramNode instanceof com.vladsch.flexmark.ast.Paragraph) && hasIncompleteDescendants(paramNode)) {
/* 112 */         return true;
/*     */       }
/* 114 */       paramNode = paramNode.getNext();
/*     */     } 
/*     */     
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   public int taskItemPriority(Node paramNode) {
/* 121 */     if (paramNode instanceof TaskListItem) {
/* 122 */       if (((TaskListItem)paramNode).isOrderedItem()) {
/* 123 */         return this.taskListFormatOptions.formatOrderedTaskItemPriority;
/*     */       }
/*     */       BasedSequence basedSequence;
/* 126 */       if ((basedSequence = ((ListItem)paramNode).getOpeningMarker()).length() > 0) {
/*     */         Integer integer;
/* 128 */         if ((integer = this.taskListFormatOptions.formatTaskItemPriorities.get(Character.valueOf(basedSequence.charAt(0)))) != null) {
/* 129 */           return integer.intValue();
/*     */         }
/* 131 */         return this.taskListFormatOptions.formatDefaultTaskItemPriority;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 136 */     return Integer.MIN_VALUE;
/*     */   }
/*     */   
/*     */   public int itemPriority(Node paramNode) {
/* 140 */     Node node = paramNode.getFirstChild();
/* 141 */     int i = Integer.MIN_VALUE;
/*     */     
/* 143 */     if (paramNode instanceof TaskListItem && 
/* 144 */       !((TaskListItem)paramNode).isItemDoneMarker()) {
/* 145 */       i = Math.max(-2147483648, taskItemPriority(paramNode));
/*     */     }
/*     */ 
/*     */     
/* 149 */     while (node != null) {
/* 150 */       if (node instanceof TaskListItem && 
/* 151 */         !((TaskListItem)node).isItemDoneMarker()) {
/* 152 */         i = Math.max(i, taskItemPriority(node));
/*     */       }
/*     */       
/* 155 */       if (node instanceof com.vladsch.flexmark.util.ast.Block && !(node instanceof com.vladsch.flexmark.ast.Paragraph)) {
/* 156 */         i = Math.max(i, itemPriority(node));
/*     */       }
/* 158 */       node = node.getNext();
/*     */     } 
/*     */     
/* 161 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderList(ListBlock paramListBlock, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter) {
/* 169 */     if (paramNodeFormatterContext.isTransformingText()) {
/* 170 */       paramNodeFormatterContext.renderChildren((Node)paramListBlock); return;
/*     */     } 
/* 172 */     ArrayList<ListItem> arrayList = new ArrayList();
/*     */     
/*     */     TaskListItemPlacement taskListItemPlacement;
/* 175 */     if ((taskListItemPlacement = this.taskListFormatOptions.taskListItemPlacement) != TaskListItemPlacement.AS_IS) {
/* 176 */       ArrayList<ListItem> arrayList1 = new ArrayList();
/* 177 */       ArrayList<ListItem> arrayList2 = new ArrayList();
/* 178 */       boolean bool = (taskListItemPlacement == TaskListItemPlacement.INCOMPLETE_NESTED_FIRST || taskListItemPlacement == TaskListItemPlacement.COMPLETE_NESTED_TO_NON_TASK) ? true : false;
/*     */       
/* 180 */       Node node = paramListBlock.getFirstChild();
/* 181 */       while (node != null) {
/* 182 */         if (node instanceof TaskListItem) {
/*     */           TaskListItem taskListItem;
/* 184 */           if (!(taskListItem = (TaskListItem)node).isItemDoneMarker() || (bool && hasIncompleteDescendants(node))) {
/* 185 */             arrayList1.add((ListItem)node);
/*     */           } else {
/* 187 */             arrayList2.add((ListItem)node);
/*     */           } 
/* 189 */         } else if (node instanceof ListItem) {
/* 190 */           if (bool && hasIncompleteDescendants(node)) {
/* 191 */             arrayList1.add((ListItem)node);
/*     */           } else {
/* 193 */             arrayList2.add((ListItem)node);
/*     */           } 
/*     */         } 
/* 196 */         node = node.getNext();
/*     */       } 
/*     */       
/* 199 */       if (this.taskListFormatOptions.formatPrioritizedTaskItems) {
/*     */         
/* 201 */         for (Iterator<ListItem> iterator = arrayList1.iterator(); iterator.hasNext();) {
/* 202 */           (listItem = iterator.next()).setPriority(itemPriority((Node)listItem));
/*     */         }
/*     */         
/* 205 */         arrayList1.sort((paramListItem1, paramListItem2) -> Integer.compare(paramListItem2.getPriority(), paramListItem1.getPriority()));
/* 206 */         arrayList.addAll(arrayList1);
/*     */       } else {
/* 208 */         arrayList.addAll(arrayList1);
/*     */       } 
/*     */       
/* 211 */       arrayList.addAll(arrayList2);
/*     */     } else {
/* 213 */       Node node = paramListBlock.getFirstChild();
/* 214 */       while (node != null) {
/* 215 */         arrayList.add(node);
/* 216 */         node = node.getNext();
/*     */       } 
/*     */     } 
/*     */     
/* 220 */     FormatterUtils.renderList(paramListBlock, paramNodeFormatterContext, paramMarkdownWriter, arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\tasklist\internal\TaskListNodeFormatter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */