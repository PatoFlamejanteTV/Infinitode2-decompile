/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ public enum ExtensionConversion {
/*  4 */   NONE,
/*  5 */   MARKDOWN,
/*  6 */   TEXT,
/*  7 */   HTML;
/*    */   public final boolean isParsed() {
/*  9 */     return (this != HTML);
/*    */   } public final boolean isTextOnly() {
/* 11 */     return (this == TEXT);
/*    */   } public final boolean isSuppressed() {
/* 13 */     return (this == NONE);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\ExtensionConversion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */