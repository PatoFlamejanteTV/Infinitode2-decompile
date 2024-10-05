/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ public enum TableConversion {
/*  4 */   NONE,
/*  5 */   MARKDOWN,
/*  6 */   MARKDOWN_NO_SINGLE_CELL,
/*  7 */   MARKDOWN_MACROS,
/*  8 */   MARKDOWN_MACROS_NO_SINGLE_CELL,
/*  9 */   TEXT,
/* 10 */   HTML;
/*    */   final boolean isParsed() {
/* 12 */     return (this != HTML);
/*    */   } final boolean isTextOnly() {
/* 14 */     return (this == TEXT);
/*    */   } final boolean isSuppressed() {
/* 16 */     return (this == NONE);
/*    */   } final boolean isUnwrapSingleCell() {
/* 18 */     return (this == MARKDOWN_NO_SINGLE_CELL || this == MARKDOWN_MACROS_NO_SINGLE_CELL);
/*    */   } final boolean isMacros() {
/* 20 */     return (this == MARKDOWN_MACROS || this == MARKDOWN_MACROS_NO_SINGLE_CELL);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\TableConversion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */