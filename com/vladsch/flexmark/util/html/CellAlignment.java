/*    */ package com.vladsch.flexmark.util.html;
/*    */ 
/*    */ public enum CellAlignment {
/*  4 */   NONE,
/*  5 */   LEFT,
/*  6 */   CENTER,
/*  7 */   RIGHT; public static CellAlignment getAlignment(String paramString) { CellAlignment[] arrayOfCellAlignment;
/*    */     int i;
/*    */     byte b;
/* 10 */     for (i = (arrayOfCellAlignment = values()).length, b = 0; b < i; b++) {
/* 11 */       CellAlignment cellAlignment; if ((cellAlignment = arrayOfCellAlignment[b]).name().equalsIgnoreCase(paramString)) {
/* 12 */         return cellAlignment;
/*    */       }
/*    */     } 
/* 15 */     return NONE; }
/*    */ 
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\html\CellAlignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */