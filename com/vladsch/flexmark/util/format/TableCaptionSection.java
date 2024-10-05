/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*    */ 
/*    */ public class TableCaptionSection extends TableSection {
/*  6 */   public static final TableCell NULL_CELL = new TableCell(null, (CharSequence)BasedSequence.NULL, (CharSequence)BasedSequence.NULL, (CharSequence)BasedSequence.NULL, 1, 0);
/*  7 */   public static final TableCell DEFAULT_CELL = new TableCell(null, "[", "", "]", 1, 1);
/*    */   
/*    */   public TableCaptionSection(TableSectionType paramTableSectionType) {
/* 10 */     super(paramTableSectionType);
/*    */   }
/*    */ 
/*    */   
/*    */   public TableRow defaultRow() {
/* 15 */     return new TableCaptionRow();
/*    */   }
/*    */ 
/*    */   
/*    */   public TableCell defaultCell() {
/* 20 */     return DEFAULT_CELL;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableCaptionSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */