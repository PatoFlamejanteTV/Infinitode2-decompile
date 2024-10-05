/*     */ package com.vladsch.flexmark.util.format;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class TableSection {
/*     */   public final TableSectionType sectionType;
/*   8 */   public final ArrayList<TableRow> rows = new ArrayList<>();
/*     */   protected int row;
/*     */   protected int column;
/*     */   
/*     */   public TableSection(TableSectionType paramTableSectionType) {
/*  13 */     this.sectionType = paramTableSectionType;
/*     */     
/*  15 */     this.row = 0;
/*  16 */     this.column = 0;
/*     */   }
/*     */   
/*     */   public ArrayList<TableRow> getRows() {
/*  20 */     return this.rows;
/*     */   }
/*     */   
/*     */   public int getRow() {
/*  24 */     return this.row;
/*     */   }
/*     */   
/*     */   public int getColumn() {
/*  28 */     return this.column;
/*     */   }
/*     */   
/*     */   public void nextRow() {
/*  32 */     this.row++;
/*  33 */     this.column = 0;
/*     */   }
/*     */   
/*     */   public void setCell(int paramInt1, int paramInt2, TableCell paramTableCell) {
/*  37 */     expandTo(paramInt1).set(paramInt2, paramTableCell);
/*     */   }
/*     */   
/*     */   public void normalize() {
/*  41 */     for (Iterator<TableRow> iterator = this.rows.iterator(); iterator.hasNext();) {
/*  42 */       (tableRow = iterator.next()).normalize();
/*     */     }
/*     */   }
/*     */   
/*     */   public TableRow expandTo(int paramInt) {
/*  47 */     return expandTo(paramInt, (TableCell)null);
/*     */   }
/*     */   
/*     */   public TableRow expandTo(int paramInt, TableCell paramTableCell) {
/*  51 */     while (paramInt >= this.rows.size()) {
/*  52 */       TableRow tableRow = defaultRow();
/*  53 */       this.rows.add(tableRow);
/*     */     } 
/*  55 */     return this.rows.get(paramInt);
/*     */   }
/*     */   
/*     */   public TableRow expandTo(int paramInt1, int paramInt2) {
/*  59 */     return expandTo(paramInt1, paramInt2, null);
/*     */   }
/*     */   
/*     */   public TableRow expandTo(int paramInt1, int paramInt2, TableCell paramTableCell) {
/*  63 */     while (paramInt1 >= this.rows.size()) {
/*     */       TableRow tableRow;
/*  65 */       (tableRow = defaultRow()).expandTo(paramInt2, paramTableCell);
/*  66 */       this.rows.add(tableRow);
/*     */     } 
/*  68 */     return ((TableRow)this.rows.get(paramInt1)).expandTo(paramInt2);
/*     */   }
/*     */   
/*     */   public TableRow defaultRow() {
/*  72 */     return new TableRow();
/*     */   }
/*     */   
/*     */   public TableCell defaultCell() {
/*  76 */     return TableCell.NULL;
/*     */   }
/*     */   
/*     */   public TableRow get(int paramInt) {
/*  80 */     return expandTo(paramInt, (TableCell)null);
/*     */   }
/*     */   
/*     */   public int getMaxColumns() {
/*  84 */     int i = 0;
/*  85 */     for (Iterator<TableRow> iterator = this.rows.iterator(); iterator.hasNext(); ) {
/*  86 */       TableRow tableRow; int j = (tableRow = iterator.next()).getSpannedColumns();
/*  87 */       if (i < j) i = j; 
/*     */     } 
/*  89 */     return i;
/*     */   }
/*     */   
/*     */   public int getMinColumns() {
/*  93 */     int i = 0;
/*  94 */     for (Iterator<TableRow> iterator = this.rows.iterator(); iterator.hasNext(); ) {
/*  95 */       TableRow tableRow; int j = (tableRow = iterator.next()).getSpannedColumns();
/*  96 */       if (i > j || i == 0) i = j; 
/*     */     } 
/*  98 */     return i;
/*     */   }
/*     */   
/*     */   private CharSequence dumpRows() {
/* 102 */     StringBuilder stringBuilder = new StringBuilder();
/* 103 */     for (TableRow tableRow : this.rows) {
/* 104 */       stringBuilder.append("  ").append(tableRow.toString()).append("\n");
/*     */     }
/* 106 */     return stringBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 112 */     return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "[sectionType=" + this.sectionType + ", rows=[\n" + 
/*     */       
/* 114 */       dumpRows() + ']';
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableSection.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */