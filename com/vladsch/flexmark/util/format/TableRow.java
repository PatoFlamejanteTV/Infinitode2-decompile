/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import com.vladsch.flexmark.util.misc.Utils;
/*     */ import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableRow
/*     */ {
/*     */   protected final List<TableCell> cells;
/*  15 */   protected int beforeOffset = Integer.MAX_VALUE;
/*  16 */   protected int afterOffset = Integer.MAX_VALUE;
/*     */   private boolean normalized = true;
/*     */   
/*     */   public TableRow() {
/*  20 */     this.cells = new ArrayList<>();
/*     */   }
/*     */   
/*     */   public List<TableCell> getCells() {
/*  24 */     return this.cells;
/*     */   }
/*     */   
/*     */   public void forAllCells(TableCellConsumer paramTableCellConsumer) {
/*  28 */     forAllCells(0, 2147483647, paramTableCellConsumer);
/*     */   }
/*     */   
/*     */   public void forAllCells(int paramInt, TableCellConsumer paramTableCellConsumer) {
/*  32 */     forAllCells(paramInt, 2147483647, paramTableCellConsumer);
/*     */   }
/*     */   
/*     */   public void forAllCells(int paramInt1, int paramInt2, TableCellConsumer paramTableCellConsumer) {
/*  36 */     forAllCells(paramInt1, paramInt2, (paramTableCell, paramInt1, paramInt2, paramInt3) -> {
/*     */           paramTableCellConsumer.accept(paramTableCell, paramInt1, paramInt2);
/*     */           return 0;
/*     */         });
/*     */   }
/*     */   
/*     */   public void forAllCells(TableCellManipulator paramTableCellManipulator) {
/*  43 */     forAllCells(0, 2147483647, paramTableCellManipulator);
/*     */   }
/*     */   
/*     */   public void forAllCells(int paramInt, TableCellManipulator paramTableCellManipulator) {
/*  47 */     forAllCells(paramInt, 2147483647, paramTableCellManipulator);
/*     */   }
/*     */   
/*     */   public void forAllCells(int paramInt1, int paramInt2, TableCellManipulator paramTableCellManipulator) {
/*  51 */     int i = this.cells.size();
/*  52 */     if (paramInt1 < i && paramInt2 > 0) {
/*  53 */       int j = 0;
/*  54 */       paramInt2 = paramInt2;
/*  55 */       int k = 0;
/*     */       
/*  57 */       for (int m = 0; m < i; ) {
/*  58 */         TableCell tableCell = this.cells.get(m);
/*     */         
/*  60 */         if (m >= paramInt1) {
/*     */           int n;
/*     */           
/*  63 */           if ((n = paramTableCellManipulator.apply(tableCell, m, j, k)) == Integer.MIN_VALUE)
/*     */             return; 
/*  65 */           if (n < 0) {
/*  66 */             k -= n;
/*  67 */             paramInt2 += n;
/*  68 */             i += n;
/*     */           } else {
/*  70 */             m += n + 1;
/*  71 */             j += tableCell.columnSpan;
/*  72 */             paramInt2--;
/*  73 */             i += n;
/*     */           } 
/*     */           
/*  76 */           k++;
/*     */           
/*  78 */           if (paramInt2 > 0)
/*     */             continue;  break;
/*  80 */         }  m++;
/*  81 */         k++;
/*  82 */         j += tableCell.columnSpan;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumns() {
/*  89 */     return this.cells.size();
/*     */   }
/*     */   
/*     */   public int getTotalColumns() {
/*  93 */     return getSpannedColumns();
/*     */   }
/*     */   
/*     */   public int getSpannedColumns() {
/*  97 */     int i = 0;
/*  98 */     for (Iterator<TableCell> iterator = this.cells.iterator(); iterator.hasNext();) {
/*  99 */       if ((tableCell = iterator.next()) != null)
/* 100 */         i += tableCell.columnSpan; 
/*     */     } 
/* 102 */     return i;
/*     */   }
/*     */   
/*     */   public int getBeforeOffset() {
/* 106 */     return this.beforeOffset;
/*     */   }
/*     */   
/*     */   public void setBeforeOffset(int paramInt) {
/* 110 */     this.beforeOffset = paramInt;
/*     */   }
/*     */   
/*     */   public int getAfterOffset() {
/* 114 */     return this.afterOffset;
/*     */   }
/*     */   
/*     */   public void setAfterOffset(int paramInt) {
/* 118 */     this.afterOffset = paramInt;
/*     */   }
/*     */   
/*     */   public int columnOf(int paramInt) {
/* 122 */     return columnOfOrNull(Integer.valueOf(paramInt)).intValue();
/*     */   }
/*     */   
/*     */   public Integer columnOfOrNull(Integer paramInteger) {
/* 126 */     if (paramInteger == null) return null;
/*     */     
/* 128 */     int j = 0;
/*     */     
/* 130 */     int i = Utils.maxLimit(paramInteger.intValue(), new int[] { this.cells.size() });
/* 131 */     for (byte b = 0; b < i; b++) {
/* 132 */       TableCell tableCell = this.cells.get(b);
/* 133 */       j += tableCell.columnSpan;
/*     */     } 
/*     */     
/* 136 */     return Integer.valueOf(j);
/*     */   }
/*     */   
/*     */   public void appendColumns(int paramInt) {
/* 140 */     appendColumns(paramInt, null);
/*     */   }
/*     */   
/*     */   public void appendColumns(int paramInt, TableCell paramTableCell) {
/* 144 */     if (paramTableCell == null || paramTableCell.columnSpan == 0) paramTableCell = defaultCell();
/*     */     
/* 146 */     for (byte b = 0; b < paramInt; b++)
/*     */     {
/* 148 */       this.cells.add(this.cells.size(), paramTableCell);
/*     */     }
/*     */   }
/*     */   
/*     */   public TableCell defaultCell() {
/* 153 */     return new TableCell(" ", 1, 1);
/*     */   }
/*     */   
/*     */   public void addColumn(int paramInt) {
/* 157 */     this.cells.add(paramInt, defaultCell());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertColumns(int paramInt1, int paramInt2) {
/* 165 */     insertColumns(paramInt1, paramInt2, null);
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
/*     */   public void insertColumns(int paramInt1, int paramInt2, TableCell paramTableCell) {
/* 177 */     if (paramInt2 <= 0 || paramInt1 < 0)
/*     */       return; 
/* 179 */     normalizeIfNeeded();
/*     */     
/* 181 */     if (paramTableCell == null || paramTableCell.columnSpan == 0) paramTableCell = defaultCell();
/*     */     
/* 183 */     int j = getTotalColumns();
/* 184 */     if (paramInt1 >= j) {
/*     */       
/* 186 */       appendColumns(paramInt2, paramTableCell);
/*     */       return;
/*     */     } 
/*     */     MarkdownTable.IndexSpanOffset indexSpanOffset;
/* 190 */     j = (indexSpanOffset = indexOf(paramInt1)).index;
/*     */     
/*     */     int i;
/* 193 */     if ((i = indexSpanOffset.spanOffset) > 0 && j < this.cells.size()) {
/*     */       
/* 195 */       TableCell tableCell = this.cells.get(j);
/*     */ 
/*     */       
/* 198 */       if (paramTableCell.text.isBlank() || paramInt2 > 1) {
/*     */         
/* 200 */         this.cells.remove(j);
/* 201 */         this.cells.add(j, tableCell.withColumnSpan(tableCell.columnSpan + paramInt2));
/*     */       } else {
/*     */         
/* 204 */         this.cells.remove(j);
/* 205 */         this.cells.add(j, tableCell.withColumnSpan(i));
/* 206 */         this.cells.add(j + 1, paramTableCell.withColumnSpan(Utils.minLimit(1, new int[] { tableCell.columnSpan - i + 1 }))); return;
/*     */       } 
/*     */     } else {
/* 209 */       for (byte b = 0; b < paramInt2; b++) {
/* 210 */         this.cells.add(j, paramTableCell);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void deleteColumns(int paramInt1, int paramInt2) {
/* 221 */     if (paramInt2 <= 0 || paramInt1 < 0)
/*     */       return; 
/* 223 */     normalizeIfNeeded();
/*     */     
/* 225 */     paramInt2 = paramInt2;
/*     */     MarkdownTable.IndexSpanOffset indexSpanOffset;
/* 227 */     int j = (indexSpanOffset = indexOf(paramInt1)).index;
/* 228 */     int i = indexSpanOffset.spanOffset;
/*     */     
/* 230 */     while (j < this.cells.size() && paramInt2 > 0) {
/* 231 */       TableCell tableCell = this.cells.get(j);
/* 232 */       this.cells.remove(j);
/*     */       
/* 234 */       if (i > 0) {
/*     */         
/* 236 */         if (tableCell.columnSpan - i > paramInt2) {
/* 237 */           this.cells.add(j, tableCell.withColumnSpan(tableCell.columnSpan - paramInt2));
/*     */           
/*     */           return;
/*     */         } 
/* 241 */         this.cells.add(j, tableCell.withColumnSpan(i));
/* 242 */         j++;
/*     */       }
/* 244 */       else if (tableCell.columnSpan - i > paramInt2) {
/*     */         
/* 246 */         this.cells.add(j, defaultCell().withColumnSpan(tableCell.columnSpan - paramInt2));
/*     */         
/*     */         return;
/*     */       } 
/* 250 */       paramInt2 -= tableCell.columnSpan - i;
/* 251 */       i = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void moveColumn(int paramInt1, int paramInt2) {
/* 256 */     if (paramInt1 < 0 || paramInt2 < 0)
/*     */       return; 
/* 258 */     normalizeIfNeeded();
/*     */     
/* 260 */     int j = getTotalColumns();
/*     */     
/* 262 */     if (paramInt1 >= j)
/* 263 */       return;  if (paramInt2 >= j) paramInt2 = j - 1;
/*     */ 
/*     */     
/*     */     MarkdownTable.IndexSpanOffset indexSpanOffset1;
/* 267 */     int k = (indexSpanOffset1 = indexOf(paramInt1)).index;
/* 268 */     int i = indexSpanOffset1.spanOffset;
/* 269 */     TableCell tableCell = ((TableCell)this.cells.get(k)).withColumnSpan(1);
/*     */     
/*     */     int m;
/*     */     
/*     */     MarkdownTable.IndexSpanOffset indexSpanOffset2;
/* 274 */     if (paramInt1 != paramInt2 && paramInt2 < j && (m = (indexSpanOffset2 = indexOf(paramInt2)).index) != k) {
/* 275 */       if (i > 0) {
/*     */         
/* 277 */         insertColumns(paramInt2 + ((paramInt1 <= paramInt2) ? 1 : 0), 1, defaultCell());
/*     */       } else {
/* 279 */         insertColumns(paramInt2 + ((paramInt1 <= paramInt2) ? 1 : 0), 1, tableCell.withColumnSpan(1));
/*     */       } 
/* 281 */       deleteColumns(paramInt1 + ((paramInt2 <= paramInt1) ? 1 : 0), 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableRow expandTo(int paramInt) {
/* 289 */     return expandTo(paramInt, TableCell.NULL);
/*     */   }
/*     */   
/*     */   public TableRow expandTo(int paramInt, TableCell paramTableCell) {
/* 293 */     if (paramTableCell == null || paramTableCell.columnSpan == 0) this.normalized = false;
/*     */     
/* 295 */     while (paramInt >= this.cells.size()) {
/* 296 */       this.cells.add(paramTableCell);
/*     */     }
/* 298 */     return this;
/*     */   }
/*     */   
/*     */   void fillMissingColumns(Integer paramInteger, int paramInt) {
/*     */     int i;
/* 303 */     if ((i = getSpannedColumns()) < paramInt) {
/* 304 */       int j = (paramInteger == null) ? this.cells.size() : paramInteger.intValue();
/* 305 */       paramInt -= i;
/*     */       
/* 307 */       if (paramInteger == null || paramInteger.intValue() >= i) {
/* 308 */         j = this.cells.size();
/*     */       }
/*     */       
/* 311 */       TableCell tableCell1 = defaultCell();
/* 312 */       TableCell tableCell2 = (j > 0) ? this.cells.get(j - 1) : tableCell1;
/*     */       
/* 314 */       while (paramInt-- > 0) {
/*     */         
/* 316 */         int k = tableCell2.getEndOffset();
/*     */         
/* 318 */         tableCell1 = tableCell1.withText((CharSequence)PrefixedSubSequence.prefixOf(" ", tableCell2.getLastSegment().getBaseSequence(), k, k));
/*     */         
/* 320 */         this.cells.add(Math.min(j, this.cells.size()), tableCell1);
/* 321 */         tableCell2 = tableCell1;
/* 322 */         j++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void set(int paramInt, TableCell paramTableCell) {
/* 328 */     expandTo(paramInt, null);
/* 329 */     this.cells.set(paramInt, paramTableCell);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmptyColumn(int paramInt) {
/* 334 */     if ((paramInt = (indexOf(paramInt)).index) >= this.cells.size() || ((TableCell)this.cells.get(paramInt)).text.isBlank()) return true;  return false;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 338 */     for (Iterator<TableCell> iterator = this.cells.iterator(); iterator.hasNext();) {
/* 339 */       if ((tableCell = iterator.next()) != null && !tableCell.text.isBlank()) return false; 
/*     */     } 
/* 341 */     return true;
/*     */   }
/*     */   
/*     */   public MarkdownTable.IndexSpanOffset indexOf(int paramInt) {
/* 345 */     return indexOfOrNull(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public MarkdownTable.IndexSpanOffset indexOfOrNull(Integer paramInteger) {
/* 349 */     if (paramInteger == null) return null;
/*     */     
/* 351 */     int i = paramInteger.intValue();
/* 352 */     byte b = 0;
/*     */     
/* 354 */     for (Iterator<TableCell> iterator = this.cells.iterator(); iterator.hasNext(); ) {
/* 355 */       TableCell tableCell; if ((tableCell = iterator.next()).columnSpan > i) {
/* 356 */         return new MarkdownTable.IndexSpanOffset(b, i);
/*     */       }
/*     */       
/* 359 */       i -= tableCell.columnSpan;
/*     */       
/* 361 */       if (tableCell.columnSpan > 0) b++;
/*     */     
/*     */     } 
/* 364 */     return new MarkdownTable.IndexSpanOffset(b, 0);
/*     */   }
/*     */   
/*     */   public void normalizeIfNeeded() {
/* 368 */     if (!this.normalized) {
/* 369 */       normalize();
/*     */     }
/*     */   }
/*     */   
/*     */   public void normalize() {
/* 374 */     byte b = 0;
/* 375 */     while (b < this.cells.size()) {
/*     */       TableCell tableCell;
/* 377 */       if ((tableCell = this.cells.get(b)) == null || tableCell == TableCell.NULL) { this.cells.remove(b); continue; }
/* 378 */        b++;
/*     */     } 
/* 380 */     this.normalized = true;
/*     */   }
/*     */   
/*     */   private CharSequence dumpCells() {
/* 384 */     StringBuilder stringBuilder = new StringBuilder();
/* 385 */     for (TableCell tableCell : this.cells) {
/* 386 */       stringBuilder.append("    ").append(tableCell.toString()).append("\n");
/*     */     }
/* 388 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 394 */     return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "{ beforeOffset=" + this.beforeOffset + ", afterOffset=" + this.afterOffset + ", normalized=" + this.normalized + ", cells=[\n" + 
/*     */ 
/*     */ 
/*     */       
/* 398 */       dumpCells() + "    ]\n  }";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableRow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */