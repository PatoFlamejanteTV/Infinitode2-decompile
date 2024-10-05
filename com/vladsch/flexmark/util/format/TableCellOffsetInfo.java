/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.BoundedMaxAggregator;
/*     */ import com.vladsch.flexmark.util.collection.BoundedMinAggregator;
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.BasedSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.function.BiFunction;
/*     */ 
/*     */ 
/*     */ public class TableCellOffsetInfo
/*     */ {
/*     */   public static final int ROW_START = 1;
/*     */   public static final int TEXT_START = 2;
/*     */   public static final int TEXT_END = 4;
/*     */   public static final int ROW_END = 8;
/*     */   private static final HashMap<TableSectionType, Integer> DEFAULT_STOP_POINTS_MAP;
/*     */   public final MarkdownTable table;
/*     */   public final int offset;
/*     */   
/*     */   static {
/*  25 */     (DEFAULT_STOP_POINTS_MAP = new HashMap<>()).put(TableSectionType.HEADER, Integer.valueOf(4));
/*  26 */     DEFAULT_STOP_POINTS_MAP.put(TableSectionType.SEPARATOR, Integer.valueOf(6));
/*  27 */     DEFAULT_STOP_POINTS_MAP.put(TableSectionType.BODY, Integer.valueOf(4));
/*  28 */     DEFAULT_STOP_POINTS_MAP.put(TableSectionType.CAPTION, Integer.valueOf(4));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final TableSection section;
/*     */ 
/*     */   
/*     */   public final TableRow tableRow;
/*     */ 
/*     */   
/*     */   public final TableCell tableCell;
/*     */ 
/*     */   
/*     */   public final int row;
/*     */   
/*     */   public final int column;
/*     */   
/*     */   public final Integer insideColumn;
/*     */   
/*     */   public final Integer insideOffset;
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo(int paramInt1, MarkdownTable paramMarkdownTable, TableSection paramTableSection, TableRow paramTableRow, TableCell paramTableCell, int paramInt2, int paramInt3, Integer paramInteger1, Integer paramInteger2) {
/*  52 */     this.offset = paramInt1;
/*  53 */     this.table = paramMarkdownTable;
/*  54 */     this.section = paramTableSection;
/*  55 */     this.tableRow = paramTableRow;
/*  56 */     this.tableCell = paramTableCell;
/*  57 */     this.row = paramInt2;
/*  58 */     this.column = paramInt3;
/*  59 */     this.insideColumn = paramInteger1;
/*  60 */     this.insideOffset = paramInteger2;
/*     */   }
/*     */   
/*     */   public boolean isCaptionLine() {
/*  64 */     return (this.tableRow instanceof TableCaptionRow && this.section == this.table.caption);
/*     */   }
/*     */   
/*     */   public boolean isSeparatorLine() {
/*  68 */     return (this.section.sectionType == TableSectionType.SEPARATOR);
/*     */   }
/*     */   
/*     */   public boolean isInsideCaption() {
/*  72 */     return (isCaptionLine() && getInsideColumn());
/*     */   }
/*     */   
/*     */   public boolean isAfterCaption() {
/*  76 */     return (isCaptionLine() && isAfterCells());
/*     */   }
/*     */   
/*     */   public boolean isBeforeCaption() {
/*  80 */     return (isCaptionLine() && isBeforeCells());
/*     */   }
/*     */   
/*     */   public boolean isInsideCell() {
/*  84 */     return (this.tableRow != null && this.tableCell != null && this.insideColumn != null);
/*     */   }
/*     */   
/*     */   public boolean getInsideColumn() {
/*  88 */     return (this.insideColumn != null);
/*     */   }
/*     */   
/*     */   public boolean isBeforeCells() {
/*  92 */     return (this.tableRow != null && this.tableCell != null && this.insideColumn == null && this.column < this.tableRow.cells.size() && this.offset <= this.tableCell.getStartOffset(getPreviousCell()));
/*     */   }
/*     */   
/*     */   public TableCell getPreviousCell() {
/*  96 */     return getPreviousCell(1);
/*     */   }
/*     */   
/*     */   public TableCell getPreviousCell(int paramInt) {
/* 100 */     return getPreviousCell(this.tableRow, paramInt);
/*     */   }
/*     */   
/*     */   public TableCell getPreviousCell(TableRow paramTableRow, int paramInt) {
/* 104 */     return (this.column >= paramInt && paramTableRow != null) ? paramTableRow.cells.get(this.column - paramInt) : null;
/*     */   }
/*     */   
/*     */   public boolean isInCellSpan() {
/* 108 */     return (this.tableRow != null && this.tableCell != null && this.insideColumn == null && this.offset >= this.tableCell.getStartOffset(getPreviousCell()) && this.offset < this.tableCell.getEndOffset());
/*     */   }
/*     */   
/*     */   public boolean isAfterCells() {
/* 112 */     return (this.tableRow != null && this.tableCell != null && this.insideColumn == null && this.column == this.tableRow.cells.size() && this.offset >= this.tableCell.getEndOffset());
/*     */   }
/*     */   
/*     */   public boolean canDeleteColumn() {
/* 116 */     return (this.insideColumn != null && this.table.getMinColumnsWithoutColumns(true, new int[] { this.column }) > 0);
/*     */   }
/*     */   
/*     */   public boolean canDeleteRow() {
/* 120 */     return (this.tableRow != null && this.section != this.table.separator && this.table.body.rows.size() + this.table.header.rows.size() > 1);
/*     */   }
/*     */   
/*     */   public boolean isFirstCell() {
/* 124 */     return (getInsideColumn() && this.column == 0);
/*     */   }
/*     */   
/*     */   public boolean isLastCell() {
/* 128 */     return (getInsideColumn() && this.column + 1 == this.tableRow.cells.size());
/*     */   }
/*     */   
/*     */   public boolean isLastRow() {
/* 132 */     return (this.row + 1 == this.table.getAllRowsCount());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo previousCellOffset(Integer paramInteger) {
/* 145 */     if (getInsideColumn() && this.column > 0) {
/* 146 */       TableCell tableCell1 = getPreviousCell();
/* 147 */       TableCell tableCell2 = getPreviousCell(2);
/* 148 */       if (paramInteger == null) {
/* 149 */         tableCell1.textToInsideOffset(this.tableCell.insideToTextOffset((this.insideOffset == null) ? 0 : this.insideOffset.intValue(), tableCell2), tableCell2);
/*     */       }
/* 151 */       return this.table.getCellOffsetInfo(tableCell1.getTextStartOffset(tableCell2) + Utils.maxLimit(tableCell1.getCellSize(tableCell2), new int[] { Utils.minLimit(0, new int[] { paramInteger.intValue() }) }));
/*     */     } 
/* 153 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo nextCellOffset(Integer paramInteger) {
/* 165 */     if (getInsideColumn() && this.column + 1 < this.tableRow.cells.size()) {
/* 166 */       TableCell tableCell1 = getPreviousCell();
/* 167 */       TableCell tableCell2 = getPreviousCell(2);
/* 168 */       if (paramInteger == null)
/* 169 */         tableCell1.textToInsideOffset(this.tableCell.insideToTextOffset((this.insideOffset == null) ? 0 : this.insideOffset.intValue(), tableCell2), tableCell2); 
/* 170 */       return this.table.getCellOffsetInfo(tableCell1.getTextStartOffset(tableCell2) + Utils.maxLimit(tableCell1.getCellSize(tableCell2), new int[] { Utils.minLimit(0, new int[] { paramInteger.intValue() }) }));
/*     */     } 
/* 172 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo previousRowOffset(Integer paramInteger) {
/* 184 */     if (this.row > 0) {
/*     */       TableCell tableCell; List<TableRow> list;
/* 186 */       TableRow tableRow = (list = this.table.getAllRows()).get(this.row - 1);
/* 187 */       if (getInsideColumn() && this.column < tableRow.cells.size()) {
/*     */         
/* 189 */         tableCell = getPreviousCell();
/* 190 */         TableCell tableCell1 = getPreviousCell(2);
/* 191 */         if (paramInteger == null)
/* 192 */           tableCell.textToInsideOffset(this.tableCell.insideToTextOffset((this.insideOffset == null) ? 0 : this.insideOffset.intValue(), tableCell1), tableCell1); 
/* 193 */         return this.table.getCellOffsetInfo(tableCell.getTextStartOffset(tableCell1) + Utils.maxLimit(tableCell.getCellSize(tableCell1), new int[] { Utils.minLimit(0, new int[] { paramInteger.intValue() }) }));
/*     */       } 
/* 195 */       if (isBeforeCells()) {
/* 196 */         return this.table.getCellOffsetInfo(((TableCell)((TableRow)tableCell).cells.get(0)).getStartOffset(null));
/*     */       }
/* 198 */       return this.table.getCellOffsetInfo(((TableCell)((TableRow)tableCell).cells.get(((TableRow)tableCell).cells.size() - 1)).getEndOffset());
/*     */     } 
/*     */ 
/*     */     
/* 202 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo nextRowOffset(Integer paramInteger) {
/* 214 */     if (this.row + 1 < this.table.getAllRowsCount()) {
/*     */       TableCell tableCell; List<TableRow> list;
/* 216 */       TableRow tableRow = (list = this.table.getAllRows()).get(this.row + 1);
/* 217 */       if (getInsideColumn() && this.column < tableRow.cells.size()) {
/*     */         
/* 219 */         TableCell tableCell1 = tableRow.cells.get(this.column);
/* 220 */         tableCell = getPreviousCell(tableRow, 1);
/* 221 */         if (paramInteger == null)
/* 222 */           tableCell1.textToInsideOffset(this.tableCell.insideToTextOffset((this.insideOffset == null) ? 0 : this.insideOffset.intValue(), tableCell), tableCell); 
/* 223 */         return this.table.getCellOffsetInfo(tableCell1.getTextStartOffset(tableCell) + Utils.maxLimit(tableCell1.getCellSize(tableCell), new int[] { Utils.minLimit(0, new int[] { paramInteger.intValue() }) }));
/*     */       } 
/* 225 */       if (isBeforeCells()) {
/* 226 */         return this.table.getCellOffsetInfo(((TableCell)((TableRow)tableCell).cells.get(0)).getStartOffset(null));
/*     */       }
/* 228 */       return this.table.getCellOffsetInfo(((TableCell)((TableRow)tableCell).cells.get(((TableRow)tableCell).cells.size() - 1)).getEndOffset());
/*     */     } 
/*     */ 
/*     */     
/* 232 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo nextOffsetStop(Map<TableSectionType, Integer> paramMap) {
/*     */     int i;
/* 243 */     if ((i = getStopOffset(this.offset, this.table, paramMap, true)) != -1) {
/* 244 */       return this.table.getCellOffsetInfo(i);
/*     */     }
/*     */     
/*     */     TableCell tableCell;
/*     */     
/*     */     List<TableRow> list;
/*     */     TableRow tableRow;
/* 251 */     int j = (tableCell = (tableRow = (list = this.table.getAllSectionRows()).get(list.size() - 1)).cells.get(tableRow.cells.size() - 1)).getEndOffset();
/*     */     
/*     */     BasedSequence basedSequence;
/* 254 */     int k = (basedSequence = tableCell.text.getBaseSequence()).endOfLineAnyEOL(j);
/* 255 */     return this.table.getCellOffsetInfo((k == -1) ? j : (k + basedSequence.eolStartLength(k)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableCellOffsetInfo previousOffsetStop(Map<TableSectionType, Integer> paramMap) {
/*     */     int i;
/* 266 */     if ((i = getStopOffset(this.offset, this.table, paramMap, false)) != -1) {
/* 267 */       return this.table.getCellOffsetInfo(i);
/*     */     }
/* 269 */     return this.table.getCellOffsetInfo(this.table.getTableStartOffset());
/*     */   }
/*     */   
/*     */   private static boolean haveStopPoint(int paramInt1, int paramInt2) {
/* 273 */     return ((paramInt1 & paramInt2) != 0);
/*     */   }
/*     */   
/*     */   private static boolean haveRowStart(int paramInt) {
/* 277 */     return ((paramInt & 0x1) != 0);
/*     */   }
/*     */   
/*     */   private static boolean haveRowEnd(int paramInt) {
/* 281 */     return ((paramInt & 0x8) != 0);
/*     */   }
/*     */   
/*     */   private static boolean haveTextStart(int paramInt) {
/* 285 */     return ((paramInt & 0x2) != 0);
/*     */   }
/*     */   
/*     */   private static boolean haveTextEnd(int paramInt) {
/* 289 */     return ((paramInt & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int getStopOffset(int paramInt, MarkdownTable paramMarkdownTable, Map<TableSectionType, Integer> paramMap, boolean paramBoolean) {
/* 311 */     Integer[] arrayOfInteger = { null };
/*     */     
/* 313 */     paramMap = (paramMap == null) ? DEFAULT_STOP_POINTS_MAP : paramMap;
/* 314 */     paramInt = paramBoolean ? new BoundedMinAggregator(paramInt) : new BoundedMaxAggregator(paramInt);
/*     */     
/* 316 */     paramMarkdownTable.forAllSectionRows((paramTableRow, paramInt1, paramArrayList, paramInt2) -> {
/*     */           TableSection tableSection = paramMarkdownTable.getAllRowsSection(paramInt1);
/*     */           
/*     */           int i;
/*     */           
/*     */           if (!paramTableRow.cells.isEmpty() && paramMap.containsKey(tableSection.sectionType) && (i = ((Integer)paramMap.get(tableSection.sectionType)).intValue()) != 0) {
/*     */             int j = ((TableCell)paramTableRow.cells.get(0)).getStartOffset(null);
/*     */             
/*     */             paramInt1 = ((TableCell)paramTableRow.cells.get(paramTableRow.cells.size() - 1)).getEndOffset();
/*     */             
/*     */             if (haveRowStart(i)) {
/*     */               paramArrayOfInteger[0] = paramBiFunction.apply(paramArrayOfInteger[0], Integer.valueOf(j));
/*     */             }
/*     */             
/*     */             if (haveStopPoint(i, 6)) {
/*     */               TableCell tableCell = null;
/*     */               for (TableCell tableCell1 : paramTableRow.cells) {
/*     */                 if (haveTextStart(i)) {
/*     */                   paramInt2 = tableCell1.getTextStartOffset(tableCell);
/*     */                   paramArrayOfInteger[0] = paramBiFunction.apply(paramArrayOfInteger[0], Integer.valueOf(paramInt2));
/*     */                 } 
/*     */                 if (haveTextEnd(i)) {
/*     */                   paramInt2 = tableCell1.getTextEndOffset(tableCell);
/*     */                   paramArrayOfInteger[0] = paramBiFunction.apply(paramArrayOfInteger[0], Integer.valueOf(paramInt2));
/*     */                 } 
/*     */                 tableCell = tableCell1;
/*     */               } 
/*     */             } 
/*     */             if (haveRowEnd(i)) {
/*     */               paramArrayOfInteger[0] = paramBiFunction.apply(paramArrayOfInteger[0], Integer.valueOf(paramInt1));
/*     */             }
/*     */           } 
/*     */           return 0;
/*     */         });
/* 350 */     return (arrayOfInteger[0] == null) ? -1 : arrayOfInteger[0].intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 355 */     return "CellOffsetInfo{ offset=" + this.offset + ", row=" + this.row + ", column=" + this.column + ", insideColumn=" + this.insideColumn + ", insideOffset=" + this.insideOffset + '}';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableCellOffsetInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */