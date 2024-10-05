/*    */ package com.vladsch.flexmark.ext.gfm.tasklist;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListItemBlockPreProcessor;
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeRenderer;
/*    */ import com.vladsch.flexmark.formatter.Formatter;
/*    */ import com.vladsch.flexmark.formatter.NodeFormatterFactory;
/*    */ import com.vladsch.flexmark.html.HtmlRenderer;
/*    */ import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
/*    */ import com.vladsch.flexmark.parser.ListOptions;
/*    */ import com.vladsch.flexmark.parser.Parser;
/*    */ import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
/*    */ import com.vladsch.flexmark.util.data.DataKey;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TaskListExtension
/*    */   implements Formatter.FormatterExtension, HtmlRenderer.HtmlRendererExtension, Parser.ParserExtension
/*    */ {
/*    */   public static final Map<Character, Integer> DEFAULT_PRIORITIES;
/*    */   
/*    */   static {
/* 27 */     (DEFAULT_PRIORITIES = new HashMap<>()).put(Character.valueOf('+'), Integer.valueOf(1));
/* 28 */     DEFAULT_PRIORITIES.put(Character.valueOf('*'), Integer.valueOf(0));
/* 29 */     DEFAULT_PRIORITIES.put(Character.valueOf('-'), Integer.valueOf(-1));
/*    */   }
/*    */   
/* 32 */   public static final DataKey<String> ITEM_DONE_MARKER = new DataKey("ITEM_DONE_MARKER", "<input type=\"checkbox\" class=\"task-list-item-checkbox\" checked=\"checked\" disabled=\"disabled\" readonly=\"readonly\" />&nbsp;");
/* 33 */   public static final DataKey<String> ITEM_NOT_DONE_MARKER = new DataKey("ITEM_NOT_DONE_MARKER", "<input type=\"checkbox\" class=\"task-list-item-checkbox\" disabled=\"disabled\" readonly=\"readonly\" />&nbsp;");
/* 34 */   public static final DataKey<String> TIGHT_ITEM_CLASS = new DataKey("TIGHT_ITEM_CLASS", "task-list-item");
/*    */   
/* 36 */   public static final DataKey<String> LOOSE_ITEM_CLASS = new DataKey("LOOSE_ITEM_CLASS", TIGHT_ITEM_CLASS);
/* 37 */   public static final DataKey<String> PARAGRAPH_CLASS = new DataKey("PARAGRAPH_CLASS", "");
/* 38 */   public static final DataKey<String> ITEM_DONE_CLASS = new DataKey("ITEM_DONE_CLASS", "");
/* 39 */   public static final DataKey<String> ITEM_NOT_DONE_CLASS = new DataKey("ITEM_NOT_DONE_CLASS", "");
/*    */ 
/*    */   
/* 42 */   public static final DataKey<TaskListItemCase> FORMAT_LIST_ITEM_CASE = new DataKey("FORMAT_LIST_ITEM_CASE", TaskListItemCase.AS_IS);
/* 43 */   public static final DataKey<TaskListItemPlacement> FORMAT_LIST_ITEM_PLACEMENT = new DataKey("FORMAT_LIST_ITEM_PLACEMENT", TaskListItemPlacement.AS_IS);
/* 44 */   public static final DataKey<Integer> FORMAT_ORDERED_TASK_ITEM_PRIORITY = new DataKey("FORMAT_ORDERED_TASK_ITEM_PRIORITY", Integer.valueOf(0));
/* 45 */   public static final DataKey<Integer> FORMAT_DEFAULT_TASK_ITEM_PRIORITY = new DataKey("FORMAT_DEFAULT_TASK_ITEM_PRIORITY", Integer.valueOf(0));
/* 46 */   public static final DataKey<Boolean> FORMAT_PRIORITIZED_TASK_ITEMS = new DataKey("FORMAT_PRIORITIZED_TASK_ITEMS", Boolean.FALSE);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 51 */   public static final DataKey<Map<Character, Integer>> FORMAT_TASK_ITEM_PRIORITIES = new DataKey("FORMAT_TASK_ITEM_PRIORITIES", DEFAULT_PRIORITIES);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static TaskListExtension create() {
/* 57 */     return new TaskListExtension();
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Formatter.Builder paramBuilder) {
/* 62 */     paramBuilder.nodeFormatterFactory(com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeFormatter::new);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void rendererOptions(MutableDataHolder paramMutableDataHolder) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void parserOptions(MutableDataHolder paramMutableDataHolder) {
/* 72 */     ListOptions.addItemMarkerSuffixes(paramMutableDataHolder, new String[] { "[ ]", "[x]", "[X]" });
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(Parser.Builder paramBuilder) {
/* 77 */     paramBuilder.blockPreProcessorFactory((BlockPreProcessorFactory)new TaskListItemBlockPreProcessor.Factory());
/*    */   }
/*    */ 
/*    */   
/*    */   public void extend(HtmlRenderer.Builder paramBuilder, String paramString) {
/* 82 */     if (paramBuilder.isRendererType("HTML")) {
/* 83 */       paramBuilder.nodeRendererFactory((NodeRendererFactory)new TaskListNodeRenderer.Factory()); return;
/* 84 */     }  paramBuilder.isRendererType("JIRA");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\tasklist\TaskListExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */