/*     */ package com.badlogic.gdx.graphics;
/*     */ 
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Colors
/*     */ {
/*  27 */   private static final ObjectMap<String, Color> map = new ObjectMap();
/*     */   
/*     */   static {
/*  30 */     reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public static ObjectMap<String, Color> getColors() {
/*  35 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color get(String paramString) {
/*  45 */     return (Color)map.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Color put(String paramString, Color paramColor) {
/*  56 */     return (Color)map.put(paramString, paramColor);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void reset() {
/*  61 */     map.clear();
/*  62 */     map.put("CLEAR", Color.CLEAR);
/*  63 */     map.put("CLEAR_WHITE", Color.CLEAR_WHITE);
/*  64 */     map.put("BLACK", Color.BLACK);
/*     */     
/*  66 */     map.put("WHITE", Color.WHITE);
/*  67 */     map.put("LIGHT_GRAY", Color.LIGHT_GRAY);
/*  68 */     map.put("GRAY", Color.GRAY);
/*  69 */     map.put("DARK_GRAY", Color.DARK_GRAY);
/*     */     
/*  71 */     map.put("BLUE", Color.BLUE);
/*  72 */     map.put("NAVY", Color.NAVY);
/*  73 */     map.put("ROYAL", Color.ROYAL);
/*  74 */     map.put("SLATE", Color.SLATE);
/*  75 */     map.put("SKY", Color.SKY);
/*  76 */     map.put("CYAN", Color.CYAN);
/*  77 */     map.put("TEAL", Color.TEAL);
/*     */     
/*  79 */     map.put("GREEN", Color.GREEN);
/*  80 */     map.put("CHARTREUSE", Color.CHARTREUSE);
/*  81 */     map.put("LIME", Color.LIME);
/*  82 */     map.put("FOREST", Color.FOREST);
/*  83 */     map.put("OLIVE", Color.OLIVE);
/*     */     
/*  85 */     map.put("YELLOW", Color.YELLOW);
/*  86 */     map.put("GOLD", Color.GOLD);
/*  87 */     map.put("GOLDENROD", Color.GOLDENROD);
/*  88 */     map.put("ORANGE", Color.ORANGE);
/*     */     
/*  90 */     map.put("BROWN", Color.BROWN);
/*  91 */     map.put("TAN", Color.TAN);
/*  92 */     map.put("FIREBRICK", Color.FIREBRICK);
/*     */     
/*  94 */     map.put("RED", Color.RED);
/*  95 */     map.put("SCARLET", Color.SCARLET);
/*  96 */     map.put("CORAL", Color.CORAL);
/*  97 */     map.put("SALMON", Color.SALMON);
/*  98 */     map.put("PINK", Color.PINK);
/*  99 */     map.put("MAGENTA", Color.MAGENTA);
/*     */     
/* 101 */     map.put("PURPLE", Color.PURPLE);
/* 102 */     map.put("VIOLET", Color.VIOLET);
/* 103 */     map.put("MAROON", Color.MAROON);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\Colors.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */