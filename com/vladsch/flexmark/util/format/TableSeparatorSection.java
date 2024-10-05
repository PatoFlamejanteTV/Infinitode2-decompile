/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ public class TableSeparatorSection extends TableSection {
/*  4 */   public static final TableCell DEFAULT_CELL = new TableCell("---", 1, 1);
/*    */   
/*    */   public TableSeparatorSection(TableSectionType paramTableSectionType) {
/*  7 */     super(paramTableSectionType);
/*    */   }
/*    */ 
/*    */   
/*    */   public TableRow defaultRow() {
/* 12 */     return new TableSeparatorRow();
/*    */   }
/*    */ 
/*    */   
/*    */   public TableCell defaultCell() {
/* 17 */     return DEFAULT_CELL;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableSeparatorSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */