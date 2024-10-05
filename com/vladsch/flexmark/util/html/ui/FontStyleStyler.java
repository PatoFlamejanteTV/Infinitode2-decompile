/*    */ package com.vladsch.flexmark.util.html.ui;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FontStyleStyler
/*    */   extends HtmlStylerBase<FontStyle>
/*    */ {
/*    */   public String getStyle(FontStyle paramFontStyle) {
/* 23 */     return (paramFontStyle == null) ? "" : ((
/* 24 */       paramFontStyle.isItalic() ? "font-style:italic;" : "font-style:normal;") + (
/* 25 */       paramFontStyle.isBold() ? "font-weight:bold" : "font-weight:normal"));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\FontStyleStyler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */