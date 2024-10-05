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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FontStyle
/*    */ {
/* 24 */   public static final FontStyle PLAIN = new FontStyle(0);
/* 25 */   public static final FontStyle BOLD = new FontStyle(1);
/* 26 */   public static final FontStyle ITALIC = new FontStyle(2);
/* 27 */   public static final FontStyle BOLD_ITALIC = new FontStyle(3);
/*    */   
/*    */   public final int fontStyle;
/*    */   
/*    */   private FontStyle(int paramInt) {
/* 32 */     this.fontStyle = paramInt;
/*    */   }
/*    */   
/*    */   public boolean isItalic() {
/* 36 */     return ((this.fontStyle & 0x2) != 0);
/*    */   }
/*    */   
/*    */   public boolean isBold() {
/* 40 */     return ((this.fontStyle & 0x1) != 0);
/*    */   }
/*    */   
/*    */   public static FontStyle of(int paramInt) {
/* 44 */     if ((paramInt & 0x3) == 3) return BOLD_ITALIC; 
/* 45 */     if ((paramInt & 0x1) == 1) return BOLD; 
/* 46 */     if ((paramInt & 0x2) == 2) return ITALIC; 
/* 47 */     return PLAIN;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\FontStyle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */