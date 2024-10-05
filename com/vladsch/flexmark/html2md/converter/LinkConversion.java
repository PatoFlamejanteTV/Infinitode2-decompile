/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ public enum LinkConversion {
/*  4 */   NONE,
/*  5 */   MARKDOWN_EXPLICIT,
/*  6 */   MARKDOWN_REFERENCE,
/*  7 */   TEXT,
/*  8 */   HTML;
/*    */   public final boolean isParsed() {
/* 10 */     return (this != HTML);
/*    */   } public final boolean isTextOnly() {
/* 12 */     return (this == TEXT);
/*    */   } public final boolean isSuppressed() {
/* 14 */     return (this == NONE);
/*    */   } public final boolean isReference() {
/* 16 */     return (this == MARKDOWN_REFERENCE);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\LinkConversion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */