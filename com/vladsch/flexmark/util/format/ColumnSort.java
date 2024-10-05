/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ 
/*    */ public final class ColumnSort
/*    */ {
/*    */   public final int column;
/*    */   public final Sort sort;
/*    */   
/*    */   private ColumnSort(int paramInt, Sort paramSort) {
/* 10 */     this.column = paramInt;
/* 11 */     this.sort = paramSort;
/*    */   }
/*    */ 
/*    */   
/*    */   public static ColumnSort columnSort(int paramInt, Sort paramSort) {
/* 16 */     return new ColumnSort(paramInt, paramSort);
/*    */   }
/*    */ 
/*    */   
/*    */   public static ColumnSort columnSort(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
/* 21 */     if (paramBoolean2) {
/* 22 */       if (paramBoolean3) {
/* 23 */         return new ColumnSort(paramInt, paramBoolean1 ? Sort.DESCENDING_NUMERIC_LAST : Sort.ASCENDING_NUMERIC_LAST);
/*    */       }
/* 25 */       return new ColumnSort(paramInt, paramBoolean1 ? Sort.DESCENDING_NUMERIC : Sort.ASCENDING_NUMERIC);
/*    */     } 
/*    */     
/* 28 */     return new ColumnSort(paramInt, paramBoolean1 ? Sort.DESCENDING : Sort.ASCENDING);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\ColumnSort.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */