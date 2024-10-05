/*    */ package com.vladsch.flexmark.util.format.options;
/*    */ 
/*    */ public enum ElementPlacementSort {
/*  4 */   AS_IS,
/*  5 */   SORT,
/*  6 */   SORT_UNUSED_LAST,
/*  7 */   SORT_DELETE_UNUSED,
/*  8 */   DELETE_UNUSED;
/*    */ 
/*    */   
/*    */   public final boolean isUnused() {
/* 12 */     return (this == SORT_UNUSED_LAST || this == SORT_DELETE_UNUSED || this == DELETE_UNUSED);
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isDeleteUnused() {
/* 17 */     return (this == SORT_DELETE_UNUSED || this == DELETE_UNUSED);
/*    */   }
/*    */   
/*    */   public final boolean isSort() {
/* 21 */     return (this == SORT_UNUSED_LAST || this == SORT_DELETE_UNUSED || this == SORT);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\options\ElementPlacementSort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */