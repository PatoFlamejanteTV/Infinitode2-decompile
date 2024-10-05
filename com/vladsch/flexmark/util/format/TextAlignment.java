/*    */ package com.vladsch.flexmark.util.format;
/*    */ 
/*    */ public enum TextAlignment {
/*  4 */   LEFT,
/*  5 */   CENTER,
/*  6 */   RIGHT,
/*  7 */   JUSTIFIED; public static TextAlignment getAlignment(String paramString) { TextAlignment[] arrayOfTextAlignment;
/*    */     int i;
/*    */     byte b;
/* 10 */     for (i = (arrayOfTextAlignment = values()).length, b = 0; b < i; b++) {
/* 11 */       TextAlignment textAlignment; if ((textAlignment = arrayOfTextAlignment[b]).name().equalsIgnoreCase(paramString)) {
/* 12 */         return textAlignment;
/*    */       }
/*    */     } 
/* 15 */     return LEFT; }
/*    */ 
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TextAlignment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */