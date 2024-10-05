/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ public enum Sort {
/*  4 */   NONE,
/*  5 */   ASCENDING,
/*  6 */   DESCENDING,
/*  7 */   ASCENDING_NUMERIC,
/*  8 */   DESCENDING_NUMERIC,
/*  9 */   ASCENDING_NUMERIC_LAST,
/* 10 */   DESCENDING_NUMERIC_LAST;
/*    */ 
/*    */   
/*    */   public final boolean isDescending() {
/* 14 */     return (this == DESCENDING || this == DESCENDING_NUMERIC || this == DESCENDING_NUMERIC_LAST);
/*    */   }
/*    */   
/*    */   public final boolean isNumeric() {
/* 18 */     return (this == ASCENDING_NUMERIC || this == ASCENDING_NUMERIC_LAST || this == DESCENDING_NUMERIC || this == DESCENDING_NUMERIC_LAST);
/*    */   }
/*    */   
/*    */   public final boolean isNumericLast() {
/* 22 */     return (this == ASCENDING_NUMERIC_LAST || this == DESCENDING_NUMERIC_LAST);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\Sort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */