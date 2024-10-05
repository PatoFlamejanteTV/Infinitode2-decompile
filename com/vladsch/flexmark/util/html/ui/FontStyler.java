/*    */ package com.vladsch.flexmark.util.html.ui;
/*    */ 
/*    */ import java.awt.Font;
/*    */ import java.util.Locale;
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
/*    */ public class FontStyler
/*    */   extends HtmlStylerBase<Font>
/*    */ {
/*    */   public String getStyle(Font paramFont) {
/* 26 */     return (paramFont == null) ? "" : String.format(Locale.US, "font-family:%s;font-size:%dpt;font-style:normal;font-weight:normal", new Object[] { paramFont.getFamily(), Integer.valueOf(paramFont.getSize()) });
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\FontStyler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */