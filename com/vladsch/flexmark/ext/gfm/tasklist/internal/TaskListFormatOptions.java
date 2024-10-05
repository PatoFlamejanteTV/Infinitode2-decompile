/*    */ package com.vladsch.flexmark.ext.gfm.tasklist.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemCase;
/*    */ import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemPlacement;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataHolder;
/*    */ import com.vladsch.flexmark.util.data.MutableDataSetter;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public class TaskListFormatOptions
/*    */   implements MutableDataSetter
/*    */ {
/*    */   public final TaskListItemCase taskListItemCase;
/*    */   public final TaskListItemPlacement taskListItemPlacement;
/*    */   public final int formatOrderedTaskItemPriority;
/*    */   public final int formatDefaultTaskItemPriority;
/*    */   public final boolean formatPrioritizedTaskItems;
/*    */   public final Map<Character, Integer> formatTaskItemPriorities;
/*    */   
/*    */   public TaskListFormatOptions() {
/* 23 */     this(null);
/*    */   }
/*    */   
/*    */   public TaskListFormatOptions(DataHolder paramDataHolder) {
/* 27 */     this.taskListItemCase = (TaskListItemCase)TaskListExtension.FORMAT_LIST_ITEM_CASE.get(paramDataHolder);
/* 28 */     this.taskListItemPlacement = (TaskListItemPlacement)TaskListExtension.FORMAT_LIST_ITEM_PLACEMENT.get(paramDataHolder);
/* 29 */     this.formatOrderedTaskItemPriority = ((Integer)TaskListExtension.FORMAT_ORDERED_TASK_ITEM_PRIORITY.get(paramDataHolder)).intValue();
/* 30 */     this.formatDefaultTaskItemPriority = ((Integer)TaskListExtension.FORMAT_DEFAULT_TASK_ITEM_PRIORITY.get(paramDataHolder)).intValue();
/* 31 */     this.formatTaskItemPriorities = (Map<Character, Integer>)TaskListExtension.FORMAT_TASK_ITEM_PRIORITIES.get(paramDataHolder);
/* 32 */     this.formatPrioritizedTaskItems = ((Boolean)TaskListExtension.FORMAT_PRIORITIZED_TASK_ITEMS.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 38 */     paramMutableDataHolder.set(TaskListExtension.FORMAT_LIST_ITEM_CASE, this.taskListItemCase);
/* 39 */     paramMutableDataHolder.set(TaskListExtension.FORMAT_LIST_ITEM_PLACEMENT, this.taskListItemPlacement);
/* 40 */     paramMutableDataHolder.set(TaskListExtension.FORMAT_ORDERED_TASK_ITEM_PRIORITY, Integer.valueOf(this.formatOrderedTaskItemPriority));
/* 41 */     paramMutableDataHolder.set(TaskListExtension.FORMAT_TASK_ITEM_PRIORITIES, this.formatTaskItemPriorities);
/* 42 */     paramMutableDataHolder.set(TaskListExtension.FORMAT_PRIORITIZED_TASK_ITEMS, Boolean.valueOf(this.formatPrioritizedTaskItems));
/* 43 */     return paramMutableDataHolder;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gfm\tasklist\internal\TaskListFormatOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */