/*      */ package com.badlogic.gdx.scenes.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.Files;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Pool;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Cell<T extends Actor>
/*      */   implements Pool.Poolable
/*      */ {
/*   15 */   private static final Float zerof = Float.valueOf(0.0F); private static final Float onef = Float.valueOf(1.0F);
/*   16 */   private static final Integer zeroi = Integer.valueOf(0); private static final Integer onei;
/*   17 */   private static final Integer centeri = onei = Integer.valueOf(1), topi = Integer.valueOf(2), bottomi = Integer.valueOf(4), lefti = Integer.valueOf(8); private static Files files; private static Cell defaults; Value minWidth; Value minHeight; Value prefWidth; Value prefHeight; Value maxWidth; Value maxHeight; Value spaceTop; Value spaceLeft; Value spaceBottom; Value spaceRight; Value padTop; Value padLeft; Value padBottom; Value padRight; Float fillX;
/*   18 */   private static final Integer righti = Integer.valueOf(16);
/*      */   
/*      */   Float fillY;
/*      */   
/*      */   Integer align;
/*      */   
/*      */   Integer expandX;
/*      */   
/*      */   Integer expandY;
/*      */   
/*      */   Integer colspan;
/*      */   
/*      */   Boolean uniformX;
/*      */   
/*      */   Boolean uniformY;
/*      */   
/*      */   @Null
/*      */   Actor actor;
/*      */   
/*      */   float actorX;
/*      */   float actorY;
/*      */   float actorWidth;
/*      */   float actorHeight;
/*      */   private Table table;
/*      */   boolean endRow;
/*      */   int column;
/*      */   int row;
/*   45 */   int cellAboveIndex = -1; float computedPadTop; float computedPadLeft; float computedPadBottom; float computedPadRight; public Cell() {
/*      */     Cell cell;
/*   47 */     if ((cell = defaults()) != null) set(cell); 
/*      */   }
/*      */   
/*      */   public void setTable(Table paramTable) {
/*   51 */     this.table = paramTable;
/*      */   }
/*      */ 
/*      */   
/*      */   public <A extends Actor> Cell<A> setActor(@Null A paramA) {
/*   56 */     if (this.actor != paramA) {
/*   57 */       if (this.actor != null && this.actor.getParent() == this.table) this.actor.remove(); 
/*   58 */       this.actor = (Actor)paramA;
/*   59 */       if (paramA != null) this.table.addActor((Actor)paramA); 
/*      */     } 
/*   61 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> clearActor() {
/*   66 */     setActor(null);
/*   67 */     return this;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public T getActor() {
/*   72 */     return (T)this.actor;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasActor() {
/*   77 */     return (this.actor != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(Value paramValue) {
/*   82 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*   83 */     this.minWidth = paramValue;
/*   84 */     this.minHeight = paramValue;
/*   85 */     this.prefWidth = paramValue;
/*   86 */     this.prefHeight = paramValue;
/*   87 */     this.maxWidth = paramValue;
/*   88 */     this.maxHeight = paramValue;
/*   89 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(Value paramValue1, Value paramValue2) {
/*   94 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*   95 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*   96 */     this.minWidth = paramValue1;
/*   97 */     this.minHeight = paramValue2;
/*   98 */     this.prefWidth = paramValue1;
/*   99 */     this.prefHeight = paramValue2;
/*  100 */     this.maxWidth = paramValue1;
/*  101 */     this.maxHeight = paramValue2;
/*  102 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(float paramFloat) {
/*  107 */     size(Value.Fixed.valueOf(paramFloat));
/*  108 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(float paramFloat1, float paramFloat2) {
/*  113 */     size(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  114 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> width(Value paramValue) {
/*  119 */     if (paramValue == null) throw new IllegalArgumentException("width cannot be null."); 
/*  120 */     this.minWidth = paramValue;
/*  121 */     this.prefWidth = paramValue;
/*  122 */     this.maxWidth = paramValue;
/*  123 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> width(float paramFloat) {
/*  128 */     width(Value.Fixed.valueOf(paramFloat));
/*  129 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> height(Value paramValue) {
/*  134 */     if (paramValue == null) throw new IllegalArgumentException("height cannot be null."); 
/*  135 */     this.minHeight = paramValue;
/*  136 */     this.prefHeight = paramValue;
/*  137 */     this.maxHeight = paramValue;
/*  138 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> height(float paramFloat) {
/*  143 */     height(Value.Fixed.valueOf(paramFloat));
/*  144 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(Value paramValue) {
/*  149 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*  150 */     this.minWidth = paramValue;
/*  151 */     this.minHeight = paramValue;
/*  152 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(Value paramValue1, Value paramValue2) {
/*  157 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*  158 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*  159 */     this.minWidth = paramValue1;
/*  160 */     this.minHeight = paramValue2;
/*  161 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minWidth(Value paramValue) {
/*  165 */     if (paramValue == null) throw new IllegalArgumentException("minWidth cannot be null."); 
/*  166 */     this.minWidth = paramValue;
/*  167 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minHeight(Value paramValue) {
/*  171 */     if (paramValue == null) throw new IllegalArgumentException("minHeight cannot be null."); 
/*  172 */     this.minHeight = paramValue;
/*  173 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(float paramFloat) {
/*  178 */     minSize(Value.Fixed.valueOf(paramFloat));
/*  179 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(float paramFloat1, float paramFloat2) {
/*  184 */     minSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  185 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minWidth(float paramFloat) {
/*  189 */     this.minWidth = Value.Fixed.valueOf(paramFloat);
/*  190 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minHeight(float paramFloat) {
/*  194 */     this.minHeight = Value.Fixed.valueOf(paramFloat);
/*  195 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(Value paramValue) {
/*  200 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*  201 */     this.prefWidth = paramValue;
/*  202 */     this.prefHeight = paramValue;
/*  203 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(Value paramValue1, Value paramValue2) {
/*  208 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*  209 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*  210 */     this.prefWidth = paramValue1;
/*  211 */     this.prefHeight = paramValue2;
/*  212 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefWidth(Value paramValue) {
/*  216 */     if (paramValue == null) throw new IllegalArgumentException("prefWidth cannot be null."); 
/*  217 */     this.prefWidth = paramValue;
/*  218 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefHeight(Value paramValue) {
/*  222 */     if (paramValue == null) throw new IllegalArgumentException("prefHeight cannot be null."); 
/*  223 */     this.prefHeight = paramValue;
/*  224 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(float paramFloat1, float paramFloat2) {
/*  229 */     prefSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  230 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(float paramFloat) {
/*  235 */     prefSize(Value.Fixed.valueOf(paramFloat));
/*  236 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefWidth(float paramFloat) {
/*  240 */     this.prefWidth = Value.Fixed.valueOf(paramFloat);
/*  241 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefHeight(float paramFloat) {
/*  245 */     this.prefHeight = Value.Fixed.valueOf(paramFloat);
/*  246 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(Value paramValue) {
/*  251 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*  252 */     this.maxWidth = paramValue;
/*  253 */     this.maxHeight = paramValue;
/*  254 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(Value paramValue1, Value paramValue2) {
/*  259 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*  260 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*  261 */     this.maxWidth = paramValue1;
/*  262 */     this.maxHeight = paramValue2;
/*  263 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxWidth(Value paramValue) {
/*  268 */     if (paramValue == null) throw new IllegalArgumentException("maxWidth cannot be null."); 
/*  269 */     this.maxWidth = paramValue;
/*  270 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxHeight(Value paramValue) {
/*  275 */     if (paramValue == null) throw new IllegalArgumentException("maxHeight cannot be null."); 
/*  276 */     this.maxHeight = paramValue;
/*  277 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(float paramFloat) {
/*  282 */     maxSize(Value.Fixed.valueOf(paramFloat));
/*  283 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(float paramFloat1, float paramFloat2) {
/*  288 */     maxSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  289 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxWidth(float paramFloat) {
/*  294 */     this.maxWidth = Value.Fixed.valueOf(paramFloat);
/*  295 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxHeight(float paramFloat) {
/*  300 */     this.maxHeight = Value.Fixed.valueOf(paramFloat);
/*  301 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> space(Value paramValue) {
/*  306 */     if (paramValue == null) throw new IllegalArgumentException("space cannot be null."); 
/*  307 */     this.spaceTop = paramValue;
/*  308 */     this.spaceLeft = paramValue;
/*  309 */     this.spaceBottom = paramValue;
/*  310 */     this.spaceRight = paramValue;
/*  311 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> space(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/*  315 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/*  316 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/*  317 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/*  318 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/*  319 */     this.spaceTop = paramValue1;
/*  320 */     this.spaceLeft = paramValue2;
/*  321 */     this.spaceBottom = paramValue3;
/*  322 */     this.spaceRight = paramValue4;
/*  323 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceTop(Value paramValue) {
/*  327 */     if (paramValue == null) throw new IllegalArgumentException("spaceTop cannot be null."); 
/*  328 */     this.spaceTop = paramValue;
/*  329 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceLeft(Value paramValue) {
/*  333 */     if (paramValue == null) throw new IllegalArgumentException("spaceLeft cannot be null."); 
/*  334 */     this.spaceLeft = paramValue;
/*  335 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceBottom(Value paramValue) {
/*  339 */     if (paramValue == null) throw new IllegalArgumentException("spaceBottom cannot be null."); 
/*  340 */     this.spaceBottom = paramValue;
/*  341 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceRight(Value paramValue) {
/*  345 */     if (paramValue == null) throw new IllegalArgumentException("spaceRight cannot be null."); 
/*  346 */     this.spaceRight = paramValue;
/*  347 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> space(float paramFloat) {
/*  352 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("space cannot be < 0: " + paramFloat); 
/*  353 */     space(Value.Fixed.valueOf(paramFloat));
/*  354 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> space(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  359 */     if (paramFloat1 < 0.0F) throw new IllegalArgumentException("top cannot be < 0: " + paramFloat1); 
/*  360 */     if (paramFloat2 < 0.0F) throw new IllegalArgumentException("left cannot be < 0: " + paramFloat2); 
/*  361 */     if (paramFloat3 < 0.0F) throw new IllegalArgumentException("bottom cannot be < 0: " + paramFloat3); 
/*  362 */     if (paramFloat4 < 0.0F) throw new IllegalArgumentException("right cannot be < 0: " + paramFloat4); 
/*  363 */     space(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2), Value.Fixed.valueOf(paramFloat3), Value.Fixed.valueOf(paramFloat4));
/*  364 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceTop(float paramFloat) {
/*  369 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceTop cannot be < 0: " + paramFloat); 
/*  370 */     this.spaceTop = Value.Fixed.valueOf(paramFloat);
/*  371 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceLeft(float paramFloat) {
/*  376 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceLeft cannot be < 0: " + paramFloat); 
/*  377 */     this.spaceLeft = Value.Fixed.valueOf(paramFloat);
/*  378 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceBottom(float paramFloat) {
/*  383 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceBottom cannot be < 0: " + paramFloat); 
/*  384 */     this.spaceBottom = Value.Fixed.valueOf(paramFloat);
/*  385 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceRight(float paramFloat) {
/*  390 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceRight cannot be < 0: " + paramFloat); 
/*  391 */     this.spaceRight = Value.Fixed.valueOf(paramFloat);
/*  392 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> pad(Value paramValue) {
/*  397 */     if (paramValue == null) throw new IllegalArgumentException("pad cannot be null."); 
/*  398 */     this.padTop = paramValue;
/*  399 */     this.padLeft = paramValue;
/*  400 */     this.padBottom = paramValue;
/*  401 */     this.padRight = paramValue;
/*  402 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/*  406 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/*  407 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/*  408 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/*  409 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/*  410 */     this.padTop = paramValue1;
/*  411 */     this.padLeft = paramValue2;
/*  412 */     this.padBottom = paramValue3;
/*  413 */     this.padRight = paramValue4;
/*  414 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padTop(Value paramValue) {
/*  418 */     if (paramValue == null) throw new IllegalArgumentException("padTop cannot be null."); 
/*  419 */     this.padTop = paramValue;
/*  420 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padLeft(Value paramValue) {
/*  424 */     if (paramValue == null) throw new IllegalArgumentException("padLeft cannot be null."); 
/*  425 */     this.padLeft = paramValue;
/*  426 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padBottom(Value paramValue) {
/*  430 */     if (paramValue == null) throw new IllegalArgumentException("padBottom cannot be null."); 
/*  431 */     this.padBottom = paramValue;
/*  432 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padRight(Value paramValue) {
/*  436 */     if (paramValue == null) throw new IllegalArgumentException("padRight cannot be null."); 
/*  437 */     this.padRight = paramValue;
/*  438 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> pad(float paramFloat) {
/*  443 */     pad(Value.Fixed.valueOf(paramFloat));
/*  444 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  448 */     pad(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2), Value.Fixed.valueOf(paramFloat3), Value.Fixed.valueOf(paramFloat4));
/*  449 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padTop(float paramFloat) {
/*  453 */     this.padTop = Value.Fixed.valueOf(paramFloat);
/*  454 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padLeft(float paramFloat) {
/*  458 */     this.padLeft = Value.Fixed.valueOf(paramFloat);
/*  459 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padBottom(float paramFloat) {
/*  463 */     this.padBottom = Value.Fixed.valueOf(paramFloat);
/*  464 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padRight(float paramFloat) {
/*  468 */     this.padRight = Value.Fixed.valueOf(paramFloat);
/*  469 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fill() {
/*  474 */     this.fillX = onef;
/*  475 */     this.fillY = onef;
/*  476 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fillX() {
/*  481 */     this.fillX = onef;
/*  482 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fillY() {
/*  487 */     this.fillY = onef;
/*  488 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> fill(float paramFloat1, float paramFloat2) {
/*  492 */     this.fillX = Float.valueOf(paramFloat1);
/*  493 */     this.fillY = Float.valueOf(paramFloat2);
/*  494 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fill(boolean paramBoolean1, boolean paramBoolean2) {
/*  499 */     this.fillX = paramBoolean1 ? onef : zerof;
/*  500 */     this.fillY = paramBoolean2 ? onef : zerof;
/*  501 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fill(boolean paramBoolean) {
/*  506 */     this.fillX = paramBoolean ? onef : zerof;
/*  507 */     this.fillY = paramBoolean ? onef : zerof;
/*  508 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<T> align(int paramInt) {
/*  514 */     this.align = Integer.valueOf(paramInt);
/*  515 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> center() {
/*  520 */     this.align = centeri;
/*  521 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> top() {
/*  526 */     if (this.align == null) {
/*  527 */       this.align = topi;
/*      */     } else {
/*  529 */       this.align = Integer.valueOf((this.align.intValue() | 0x2) & 0xFFFFFFFB);
/*  530 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> left() {
/*  535 */     if (this.align == null) {
/*  536 */       this.align = lefti;
/*      */     } else {
/*  538 */       this.align = Integer.valueOf((this.align.intValue() | 0x8) & 0xFFFFFFEF);
/*  539 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> bottom() {
/*  544 */     if (this.align == null) {
/*  545 */       this.align = bottomi;
/*      */     } else {
/*  547 */       this.align = Integer.valueOf((this.align.intValue() | 0x4) & 0xFFFFFFFD);
/*  548 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> right() {
/*  553 */     if (this.align == null) {
/*  554 */       this.align = righti;
/*      */     } else {
/*  556 */       this.align = Integer.valueOf((this.align.intValue() | 0x10) & 0xFFFFFFF7);
/*  557 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> grow() {
/*  562 */     this.expandX = onei;
/*  563 */     this.expandY = onei;
/*  564 */     this.fillX = onef;
/*  565 */     this.fillY = onef;
/*  566 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> growX() {
/*  571 */     this.expandX = onei;
/*  572 */     this.fillX = onef;
/*  573 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> growY() {
/*  578 */     this.expandY = onei;
/*  579 */     this.fillY = onef;
/*  580 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expand() {
/*  585 */     this.expandX = onei;
/*  586 */     this.expandY = onei;
/*  587 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expandX() {
/*  592 */     this.expandX = onei;
/*  593 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expandY() {
/*  598 */     this.expandY = onei;
/*  599 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> expand(int paramInt1, int paramInt2) {
/*  603 */     this.expandX = Integer.valueOf(paramInt1);
/*  604 */     this.expandY = Integer.valueOf(paramInt2);
/*  605 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expand(boolean paramBoolean1, boolean paramBoolean2) {
/*  610 */     this.expandX = paramBoolean1 ? onei : zeroi;
/*  611 */     this.expandY = paramBoolean2 ? onei : zeroi;
/*  612 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> colspan(int paramInt) {
/*  616 */     this.colspan = Integer.valueOf(paramInt);
/*  617 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> uniform() {
/*  622 */     this.uniformX = Boolean.TRUE;
/*  623 */     this.uniformY = Boolean.TRUE;
/*  624 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> uniformX() {
/*  629 */     this.uniformX = Boolean.TRUE;
/*  630 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> uniformY() {
/*  635 */     this.uniformY = Boolean.TRUE;
/*  636 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> uniform(boolean paramBoolean) {
/*  640 */     this.uniformX = Boolean.valueOf(paramBoolean);
/*  641 */     this.uniformY = Boolean.valueOf(paramBoolean);
/*  642 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> uniform(boolean paramBoolean1, boolean paramBoolean2) {
/*  646 */     this.uniformX = Boolean.valueOf(paramBoolean1);
/*  647 */     this.uniformY = Boolean.valueOf(paramBoolean2);
/*  648 */     return this;
/*      */   }
/*      */   
/*      */   public void setActorBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  652 */     this.actorX = paramFloat1;
/*  653 */     this.actorY = paramFloat2;
/*  654 */     this.actorWidth = paramFloat3;
/*  655 */     this.actorHeight = paramFloat4;
/*      */   }
/*      */   
/*      */   public float getActorX() {
/*  659 */     return this.actorX;
/*      */   }
/*      */   
/*      */   public void setActorX(float paramFloat) {
/*  663 */     this.actorX = paramFloat;
/*      */   }
/*      */   
/*      */   public float getActorY() {
/*  667 */     return this.actorY;
/*      */   }
/*      */   
/*      */   public void setActorY(float paramFloat) {
/*  671 */     this.actorY = paramFloat;
/*      */   }
/*      */   
/*      */   public float getActorWidth() {
/*  675 */     return this.actorWidth;
/*      */   }
/*      */   
/*      */   public void setActorWidth(float paramFloat) {
/*  679 */     this.actorWidth = paramFloat;
/*      */   }
/*      */   
/*      */   public float getActorHeight() {
/*  683 */     return this.actorHeight;
/*      */   }
/*      */   
/*      */   public void setActorHeight(float paramFloat) {
/*  687 */     this.actorHeight = paramFloat;
/*      */   }
/*      */   
/*      */   public int getColumn() {
/*  691 */     return this.column;
/*      */   }
/*      */   
/*      */   public int getRow() {
/*  695 */     return this.row;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMinWidthValue() {
/*  700 */     return this.minWidth;
/*      */   }
/*      */   
/*      */   public float getMinWidth() {
/*  704 */     return this.minWidth.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMinHeightValue() {
/*  709 */     return this.minHeight;
/*      */   }
/*      */   
/*      */   public float getMinHeight() {
/*  713 */     return this.minHeight.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPrefWidthValue() {
/*  718 */     return this.prefWidth;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  722 */     return this.prefWidth.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPrefHeightValue() {
/*  727 */     return this.prefHeight;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  731 */     return this.prefHeight.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMaxWidthValue() {
/*  736 */     return this.maxWidth;
/*      */   }
/*      */   
/*      */   public float getMaxWidth() {
/*  740 */     return this.maxWidth.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMaxHeightValue() {
/*  745 */     return this.maxHeight;
/*      */   }
/*      */   
/*      */   public float getMaxHeight() {
/*  749 */     return this.maxHeight.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceTopValue() {
/*  754 */     return this.spaceTop;
/*      */   }
/*      */   
/*      */   public float getSpaceTop() {
/*  758 */     return this.spaceTop.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceLeftValue() {
/*  763 */     return this.spaceLeft;
/*      */   }
/*      */   
/*      */   public float getSpaceLeft() {
/*  767 */     return this.spaceLeft.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceBottomValue() {
/*  772 */     return this.spaceBottom;
/*      */   }
/*      */   
/*      */   public float getSpaceBottom() {
/*  776 */     return this.spaceBottom.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceRightValue() {
/*  781 */     return this.spaceRight;
/*      */   }
/*      */   
/*      */   public float getSpaceRight() {
/*  785 */     return this.spaceRight.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadTopValue() {
/*  790 */     return this.padTop;
/*      */   }
/*      */   
/*      */   public float getPadTop() {
/*  794 */     return this.padTop.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadLeftValue() {
/*  799 */     return this.padLeft;
/*      */   }
/*      */   
/*      */   public float getPadLeft() {
/*  803 */     return this.padLeft.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadBottomValue() {
/*  808 */     return this.padBottom;
/*      */   }
/*      */   
/*      */   public float getPadBottom() {
/*  812 */     return this.padBottom.get(this.actor);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadRightValue() {
/*  817 */     return this.padRight;
/*      */   }
/*      */   
/*      */   public float getPadRight() {
/*  821 */     return this.padRight.get(this.actor);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadX() {
/*  826 */     return this.padLeft.get(this.actor) + this.padRight.get(this.actor);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadY() {
/*  831 */     return this.padTop.get(this.actor) + this.padBottom.get(this.actor);
/*      */   }
/*      */   @Null
/*      */   public Float getFillX() {
/*  835 */     return this.fillX;
/*      */   }
/*      */   @Null
/*      */   public Float getFillY() {
/*  839 */     return this.fillY;
/*      */   }
/*      */   @Null
/*      */   public Integer getAlign() {
/*  843 */     return this.align;
/*      */   }
/*      */   @Null
/*      */   public Integer getExpandX() {
/*  847 */     return this.expandX;
/*      */   }
/*      */   @Null
/*      */   public Integer getExpandY() {
/*  851 */     return this.expandY;
/*      */   }
/*      */   @Null
/*      */   public Integer getColspan() {
/*  855 */     return this.colspan;
/*      */   }
/*      */   @Null
/*      */   public Boolean getUniformX() {
/*  859 */     return this.uniformX;
/*      */   }
/*      */   @Null
/*      */   public Boolean getUniformY() {
/*  863 */     return this.uniformY;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isEndRow() {
/*  868 */     return this.endRow;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadTop() {
/*  873 */     return this.computedPadTop;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadLeft() {
/*  878 */     return this.computedPadLeft;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadBottom() {
/*  883 */     return this.computedPadBottom;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadRight() {
/*  888 */     return this.computedPadRight;
/*      */   }
/*      */   
/*      */   public void row() {
/*  892 */     this.table.row();
/*      */   }
/*      */   
/*      */   public Table getTable() {
/*  896 */     return this.table;
/*      */   }
/*      */ 
/*      */   
/*      */   void clear() {
/*  901 */     this.minWidth = null;
/*  902 */     this.minHeight = null;
/*  903 */     this.prefWidth = null;
/*  904 */     this.prefHeight = null;
/*  905 */     this.maxWidth = null;
/*  906 */     this.maxHeight = null;
/*  907 */     this.spaceTop = null;
/*  908 */     this.spaceLeft = null;
/*  909 */     this.spaceBottom = null;
/*  910 */     this.spaceRight = null;
/*  911 */     this.padTop = null;
/*  912 */     this.padLeft = null;
/*  913 */     this.padBottom = null;
/*  914 */     this.padRight = null;
/*  915 */     this.fillX = null;
/*  916 */     this.fillY = null;
/*  917 */     this.align = null;
/*  918 */     this.expandX = null;
/*  919 */     this.expandY = null;
/*  920 */     this.colspan = null;
/*  921 */     this.uniformX = null;
/*  922 */     this.uniformY = null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void reset() {
/*  927 */     this.actor = null;
/*  928 */     this.table = null;
/*  929 */     this.endRow = false;
/*  930 */     this.cellAboveIndex = -1;
/*  931 */     set(defaults());
/*      */   }
/*      */   
/*      */   void set(Cell paramCell) {
/*  935 */     this.minWidth = paramCell.minWidth;
/*  936 */     this.minHeight = paramCell.minHeight;
/*  937 */     this.prefWidth = paramCell.prefWidth;
/*  938 */     this.prefHeight = paramCell.prefHeight;
/*  939 */     this.maxWidth = paramCell.maxWidth;
/*  940 */     this.maxHeight = paramCell.maxHeight;
/*  941 */     this.spaceTop = paramCell.spaceTop;
/*  942 */     this.spaceLeft = paramCell.spaceLeft;
/*  943 */     this.spaceBottom = paramCell.spaceBottom;
/*  944 */     this.spaceRight = paramCell.spaceRight;
/*  945 */     this.padTop = paramCell.padTop;
/*  946 */     this.padLeft = paramCell.padLeft;
/*  947 */     this.padBottom = paramCell.padBottom;
/*  948 */     this.padRight = paramCell.padRight;
/*  949 */     this.fillX = paramCell.fillX;
/*  950 */     this.fillY = paramCell.fillY;
/*  951 */     this.align = paramCell.align;
/*  952 */     this.expandX = paramCell.expandX;
/*  953 */     this.expandY = paramCell.expandY;
/*  954 */     this.colspan = paramCell.colspan;
/*  955 */     this.uniformX = paramCell.uniformX;
/*  956 */     this.uniformY = paramCell.uniformY;
/*      */   }
/*      */   
/*      */   void merge(@Null Cell paramCell) {
/*  960 */     if (paramCell == null)
/*  961 */       return;  if (paramCell.minWidth != null) this.minWidth = paramCell.minWidth; 
/*  962 */     if (paramCell.minHeight != null) this.minHeight = paramCell.minHeight; 
/*  963 */     if (paramCell.prefWidth != null) this.prefWidth = paramCell.prefWidth; 
/*  964 */     if (paramCell.prefHeight != null) this.prefHeight = paramCell.prefHeight; 
/*  965 */     if (paramCell.maxWidth != null) this.maxWidth = paramCell.maxWidth; 
/*  966 */     if (paramCell.maxHeight != null) this.maxHeight = paramCell.maxHeight; 
/*  967 */     if (paramCell.spaceTop != null) this.spaceTop = paramCell.spaceTop; 
/*  968 */     if (paramCell.spaceLeft != null) this.spaceLeft = paramCell.spaceLeft; 
/*  969 */     if (paramCell.spaceBottom != null) this.spaceBottom = paramCell.spaceBottom; 
/*  970 */     if (paramCell.spaceRight != null) this.spaceRight = paramCell.spaceRight; 
/*  971 */     if (paramCell.padTop != null) this.padTop = paramCell.padTop; 
/*  972 */     if (paramCell.padLeft != null) this.padLeft = paramCell.padLeft; 
/*  973 */     if (paramCell.padBottom != null) this.padBottom = paramCell.padBottom; 
/*  974 */     if (paramCell.padRight != null) this.padRight = paramCell.padRight; 
/*  975 */     if (paramCell.fillX != null) this.fillX = paramCell.fillX; 
/*  976 */     if (paramCell.fillY != null) this.fillY = paramCell.fillY; 
/*  977 */     if (paramCell.align != null) this.align = paramCell.align; 
/*  978 */     if (paramCell.expandX != null) this.expandX = paramCell.expandX; 
/*  979 */     if (paramCell.expandY != null) this.expandY = paramCell.expandY; 
/*  980 */     if (paramCell.colspan != null) this.colspan = paramCell.colspan; 
/*  981 */     if (paramCell.uniformX != null) this.uniformX = paramCell.uniformX; 
/*  982 */     if (paramCell.uniformY != null) this.uniformY = paramCell.uniformY; 
/*      */   }
/*      */   
/*      */   public String toString() {
/*  986 */     return (this.actor != null) ? this.actor.toString() : super.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Cell defaults() {
/*  992 */     if (files == null || files != Gdx.files) {
/*  993 */       files = Gdx.files;
/*      */       
/*  995 */       (defaults = new Cell<>()).minWidth = Value.minWidth;
/*  996 */       defaults.minHeight = Value.minHeight;
/*  997 */       defaults.prefWidth = Value.prefWidth;
/*  998 */       defaults.prefHeight = Value.prefHeight;
/*  999 */       defaults.maxWidth = Value.maxWidth;
/* 1000 */       defaults.maxHeight = Value.maxHeight;
/* 1001 */       defaults.spaceTop = Value.zero;
/* 1002 */       defaults.spaceLeft = Value.zero;
/* 1003 */       defaults.spaceBottom = Value.zero;
/* 1004 */       defaults.spaceRight = Value.zero;
/* 1005 */       defaults.padTop = Value.zero;
/* 1006 */       defaults.padLeft = Value.zero;
/* 1007 */       defaults.padBottom = Value.zero;
/* 1008 */       defaults.padRight = Value.zero;
/* 1009 */       defaults.fillX = zerof;
/* 1010 */       defaults.fillY = zerof;
/* 1011 */       defaults.align = centeri;
/* 1012 */       defaults.expandX = zeroi;
/* 1013 */       defaults.expandY = zeroi;
/* 1014 */       defaults.colspan = onei;
/* 1015 */       defaults.uniformX = null;
/* 1016 */       defaults.uniformY = null;
/*      */     } 
/* 1018 */     return defaults;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Cell.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */