/*    */ package com.vladsch.flexmark.ext.tables.internal;
/*    */ 
/*    */ import com.vladsch.flexmark.ext.tables.TablesExtension;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ 
/*    */ class TableParserOptions {
/*    */   public final int maxHeaderRows;
/*    */   public final int minHeaderRows;
/*    */   public final int minSeparatorDashes;
/*    */   public final boolean appendMissingColumns;
/*    */   public final boolean discardExtraColumns;
/*    */   public final boolean columnSpans;
/*    */   public final boolean trimCellWhitespace;
/*    */   public final boolean headerSeparatorColumnMatch;
/*    */   public final String className;
/*    */   public final boolean withCaption;
/*    */   
/*    */   TableParserOptions(DataHolder paramDataHolder) {
/* 19 */     this.maxHeaderRows = ((Integer)TablesExtension.MAX_HEADER_ROWS.get(paramDataHolder)).intValue();
/* 20 */     this.minHeaderRows = ((Integer)TablesExtension.MIN_HEADER_ROWS.get(paramDataHolder)).intValue();
/* 21 */     this.minSeparatorDashes = ((Integer)TablesExtension.MIN_SEPARATOR_DASHES.get(paramDataHolder)).intValue();
/* 22 */     this.appendMissingColumns = ((Boolean)TablesExtension.APPEND_MISSING_COLUMNS.get(paramDataHolder)).booleanValue();
/* 23 */     this.discardExtraColumns = ((Boolean)TablesExtension.DISCARD_EXTRA_COLUMNS.get(paramDataHolder)).booleanValue();
/* 24 */     this.columnSpans = ((Boolean)TablesExtension.COLUMN_SPANS.get(paramDataHolder)).booleanValue();
/* 25 */     this.trimCellWhitespace = ((Boolean)TablesExtension.TRIM_CELL_WHITESPACE.get(paramDataHolder)).booleanValue();
/* 26 */     this.headerSeparatorColumnMatch = ((Boolean)TablesExtension.HEADER_SEPARATOR_COLUMN_MATCH.get(paramDataHolder)).booleanValue();
/* 27 */     this.className = (String)TablesExtension.CLASS_NAME.get(paramDataHolder);
/* 28 */     this.withCaption = ((Boolean)TablesExtension.WITH_CAPTION.get(paramDataHolder)).booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\internal\TableParserOptions.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */