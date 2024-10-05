/*    */ package com.vladsch.flexmark.util.html.ui;
/*    */ 
/*    */ import java.awt.Color;
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
/*    */ public class Color
/*    */   extends Color
/*    */ {
/* 22 */   public static final Color NULL = new Color(new Color(0, true));
/* 23 */   public static final Color WHITE = new Color(Color.WHITE);
/* 24 */   public static final Color LIGHT_GRAY = new Color(Color.LIGHT_GRAY);
/* 25 */   public static final Color GRAY = new Color(Color.GRAY);
/* 26 */   public static final Color DARK_GRAY = new Color(Color.DARK_GRAY);
/* 27 */   public static final Color BLACK = new Color(Color.BLACK);
/* 28 */   public static final Color RED = new Color(Color.RED);
/* 29 */   public static final Color PINK = new Color(Color.PINK);
/* 30 */   public static final Color ORANGE = new Color(Color.ORANGE);
/* 31 */   public static final Color YELLOW = new Color(Color.YELLOW);
/* 32 */   public static final Color GREEN = new Color(Color.GREEN);
/* 33 */   public static final Color MAGENTA = new Color(Color.MAGENTA);
/* 34 */   public static final Color CYAN = new Color(Color.CYAN);
/* 35 */   public static final Color BLUE = new Color(Color.BLUE);
/*    */   protected Color(Color paramColor) {
/* 37 */     super(paramColor.getRGB());
/*    */   } protected Color(int paramInt) {
/* 39 */     super(paramInt);
/*    */   } public static Color of(Color paramColor) {
/* 41 */     return new Color(paramColor);
/*    */   } public static Color of(int paramInt) {
/* 43 */     return new Color(paramInt);
/*    */   }
/*    */   public static Color of(String paramString) {
/*    */     Color color;
/* 47 */     return ((color = ColorStyler.getNamedColor(paramString)) == null) ? NULL : new Color(color);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 52 */     return "Color { " + HtmlHelpers.toHtmlString(this) + " " + HtmlHelpers.toRgbString(this) + "}";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\Color.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */