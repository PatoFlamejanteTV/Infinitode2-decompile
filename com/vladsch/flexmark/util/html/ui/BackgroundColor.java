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
/*    */ 
/*    */ 
/*    */ public class BackgroundColor
/*    */   extends Color
/*    */ {
/* 24 */   public static final BackgroundColor NULL = new BackgroundColor(new Color(0, true));
/* 25 */   public static final BackgroundColor WHITE = new BackgroundColor(Color.WHITE);
/* 26 */   public static final BackgroundColor LIGHT_GRAY = new BackgroundColor(Color.LIGHT_GRAY);
/* 27 */   public static final BackgroundColor GRAY = new BackgroundColor(Color.GRAY);
/* 28 */   public static final BackgroundColor DARK_GRAY = new BackgroundColor(Color.DARK_GRAY);
/* 29 */   public static final BackgroundColor BLACK = new BackgroundColor(Color.BLACK);
/* 30 */   public static final BackgroundColor RED = new BackgroundColor(Color.RED);
/* 31 */   public static final BackgroundColor PINK = new BackgroundColor(Color.PINK);
/* 32 */   public static final BackgroundColor ORANGE = new BackgroundColor(Color.ORANGE);
/* 33 */   public static final BackgroundColor YELLOW = new BackgroundColor(Color.YELLOW);
/* 34 */   public static final BackgroundColor GREEN = new BackgroundColor(Color.GREEN);
/* 35 */   public static final BackgroundColor MAGENTA = new BackgroundColor(Color.MAGENTA);
/* 36 */   public static final BackgroundColor CYAN = new BackgroundColor(Color.CYAN);
/* 37 */   public static final BackgroundColor BLUE = new BackgroundColor(Color.BLUE);
/*    */   protected BackgroundColor(Color paramColor) {
/* 39 */     super(paramColor.getRGB());
/*    */   } protected BackgroundColor(int paramInt) {
/* 41 */     super(paramInt);
/*    */   } public static BackgroundColor of(Color paramColor) {
/* 43 */     return new BackgroundColor(paramColor);
/*    */   } public static BackgroundColor of(int paramInt) {
/* 45 */     return new BackgroundColor(paramInt);
/*    */   }
/*    */   public static BackgroundColor of(String paramString) {
/*    */     Color color;
/* 49 */     return ((color = ColorStyler.getNamedColor(paramString)) == null) ? NULL : new BackgroundColor(color);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\htm\\ui\BackgroundColor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */