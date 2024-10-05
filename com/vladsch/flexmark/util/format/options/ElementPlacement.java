/*    */ package com.vladsch.flexmark.util.format.options;
/*    */ 
/*    */ public enum ElementPlacement {
/*  4 */   AS_IS,
/*  5 */   DOCUMENT_TOP,
/*  6 */   GROUP_WITH_FIRST,
/*  7 */   GROUP_WITH_LAST,
/*  8 */   DOCUMENT_BOTTOM;
/*    */ 
/*    */   
/*    */   public final boolean isNoChange() {
/* 12 */     return (this == AS_IS);
/*    */   }
/*    */   
/*    */   public final boolean isChange() {
/* 16 */     return (this != AS_IS);
/*    */   }
/*    */   
/*    */   public final boolean isTop() {
/* 20 */     return (this == DOCUMENT_TOP);
/*    */   }
/*    */   
/*    */   public final boolean isBottom() {
/* 24 */     return (this == DOCUMENT_BOTTOM);
/*    */   }
/*    */   
/*    */   public final boolean isGroupFirst() {
/* 28 */     return (this == GROUP_WITH_FIRST);
/*    */   }
/*    */   
/*    */   public final boolean isGroupLast() {
/* 32 */     return (this == GROUP_WITH_LAST);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\options\ElementPlacement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */