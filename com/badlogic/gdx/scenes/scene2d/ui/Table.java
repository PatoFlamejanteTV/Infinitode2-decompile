/*      */ package com.badlogic.gdx.scenes.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*      */ import com.badlogic.gdx.scenes.scene2d.Group;
/*      */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*      */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Pool;
/*      */ import com.badlogic.gdx.utils.Pools;
/*      */ import com.badlogic.gdx.utils.SnapshotArray;
/*      */ import java.util.Arrays;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Table
/*      */   extends WidgetGroup
/*      */ {
/*   49 */   public static Color debugTableColor = new Color(0.0F, 0.0F, 1.0F, 1.0F);
/*   50 */   public static Color debugCellColor = new Color(1.0F, 0.0F, 0.0F, 1.0F);
/*   51 */   public static Color debugActorColor = new Color(0.0F, 1.0F, 0.0F, 1.0F);
/*      */   
/*   53 */   static final Pool<Cell> cellPool = new Pool<Cell>() {
/*      */       protected Cell newObject() {
/*   55 */         return new Cell<>();
/*      */       }
/*      */     };
/*      */   private static float[] columnWeightedWidth;
/*      */   private static float[] rowWeightedHeight;
/*      */   private int columns;
/*      */   private int rows;
/*      */   private boolean implicitEndRow;
/*   63 */   private final Array<Cell> cells = new Array(4);
/*      */   private final Cell cellDefaults;
/*   65 */   private final Array<Cell> columnDefaults = new Array(2); private Cell rowDefaults; private boolean sizeInvalid = true; private float[] columnMinWidth; private float[] rowMinHeight;
/*      */   private float[] columnPrefWidth;
/*      */   private float[] rowPrefHeight;
/*      */   private float tableMinWidth;
/*      */   private float tableMinHeight;
/*      */   private float tablePrefWidth;
/*      */   private float tablePrefHeight;
/*      */   private float[] columnWidth;
/*      */   private float[] rowHeight;
/*      */   private float[] expandWidth;
/*      */   private float[] expandHeight;
/*   76 */   Value padTop = backgroundTop; Value padLeft = backgroundLeft; Value padBottom = backgroundBottom; Value padRight = backgroundRight;
/*   77 */   int align = 1;
/*      */   
/*   79 */   Debug debug = Debug.none; Array<DebugRect> debugRects;
/*      */   @Null
/*      */   Drawable background;
/*      */   private boolean clip;
/*      */   @Null
/*      */   private Skin skin;
/*      */   boolean round = true;
/*      */   
/*      */   public Table() {
/*   88 */     this((Skin)null);
/*      */   }
/*      */ 
/*      */   
/*      */   public Table(@Null Skin paramSkin) {
/*   93 */     this.skin = paramSkin;
/*      */     
/*   95 */     this.cellDefaults = obtainCell();
/*      */     
/*   97 */     setTransform(false);
/*   98 */     setTouchable(Touchable.childrenOnly);
/*      */   }
/*      */   
/*      */   private Cell obtainCell() {
/*      */     Cell<Actor> cell;
/*  103 */     (cell = (Cell<Actor>)cellPool.obtain()).setTable(this);
/*  104 */     return cell;
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*  108 */     validate();
/*  109 */     if (isTransform()) {
/*  110 */       applyTransform(paramBatch, computeTransform());
/*  111 */       drawBackground(paramBatch, paramFloat, 0.0F, 0.0F);
/*  112 */       if (this.clip) {
/*  113 */         paramBatch.flush();
/*  114 */         float f1 = this.padLeft.get((Actor)this), f2 = this.padBottom.get((Actor)this);
/*  115 */         if (clipBegin(f1, f2, getWidth() - f1 - this.padRight.get((Actor)this), 
/*  116 */             getHeight() - f2 - this.padTop.get((Actor)this))) {
/*  117 */           drawChildren(paramBatch, paramFloat);
/*  118 */           paramBatch.flush();
/*  119 */           clipEnd();
/*      */         } 
/*      */       } else {
/*  122 */         drawChildren(paramBatch, paramFloat);
/*  123 */       }  resetTransform(paramBatch); return;
/*      */     } 
/*  125 */     drawBackground(paramBatch, paramFloat, getX(), getY());
/*  126 */     super.draw(paramBatch, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void drawBackground(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  133 */     if (this.background == null)
/*  134 */       return;  Color color = getColor();
/*  135 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat1);
/*  136 */     this.background.draw(paramBatch, paramFloat2, paramFloat3, getWidth(), getHeight());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBackground(String paramString) {
/*  143 */     if (this.skin == null) throw new IllegalStateException("Table must have a skin set to use this method."); 
/*  144 */     setBackground(this.skin.getDrawable(paramString));
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBackground(@Null Drawable paramDrawable) {
/*  149 */     if (this.background == paramDrawable)
/*  150 */       return;  float f2 = getPadTop(), f3 = getPadLeft(), f4 = getPadBottom(), f5 = getPadRight();
/*  151 */     this.background = paramDrawable;
/*  152 */     float f1 = getPadTop(), f6 = getPadLeft(), f7 = getPadBottom(), f8 = getPadRight();
/*  153 */     if (f2 + f4 != f1 + f7 || f3 + f5 != f6 + f8) {
/*  154 */       invalidateHierarchy(); return;
/*  155 */     }  if (f2 != f1 || f3 != f6 || f4 != f7 || f5 != f8) {
/*  156 */       invalidate();
/*      */     }
/*      */   }
/*      */   
/*      */   public Table background(@Null Drawable paramDrawable) {
/*  161 */     setBackground(paramDrawable);
/*  162 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table background(String paramString) {
/*  167 */     setBackground(paramString);
/*  168 */     return this;
/*      */   }
/*      */   @Null
/*      */   public Drawable getBackground() {
/*  172 */     return this.background;
/*      */   }
/*      */   @Null
/*      */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  176 */     if (this.clip) {
/*  177 */       if (paramBoolean && getTouchable() == Touchable.disabled) return null; 
/*  178 */       if (paramFloat1 < 0.0F || paramFloat1 >= getWidth() || paramFloat2 < 0.0F || paramFloat2 >= getHeight()) return null; 
/*      */     } 
/*  180 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public Table clip() {
/*  185 */     setClip(true);
/*  186 */     return this;
/*      */   }
/*      */   
/*      */   public Table clip(boolean paramBoolean) {
/*  190 */     setClip(paramBoolean);
/*  191 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClip(boolean paramBoolean) {
/*  197 */     this.clip = paramBoolean;
/*  198 */     setTransform(paramBoolean);
/*  199 */     invalidate();
/*      */   }
/*      */   
/*      */   public boolean getClip() {
/*  203 */     return this.clip;
/*      */   }
/*      */   
/*      */   public void invalidate() {
/*  207 */     this.sizeInvalid = true;
/*  208 */     super.invalidate();
/*      */   }
/*      */ 
/*      */   
/*      */   public <T extends Actor> Cell<T> add(@Null T paramT) {
/*      */     Cell<T> cell;
/*  214 */     (cell = obtainCell()).actor = (Actor)paramT;
/*      */ 
/*      */     
/*  217 */     if (this.implicitEndRow) {
/*  218 */       this.implicitEndRow = false;
/*  219 */       this.rows--;
/*  220 */       ((Cell)this.cells.peek()).endRow = false;
/*      */     } 
/*      */     
/*      */     int i;
/*  224 */     if ((i = this.cells.size) > 0) {
/*      */       Cell cell1;
/*      */       
/*  227 */       if (!(cell1 = (Cell)this.cells.peek()).endRow) {
/*  228 */         cell1.column += cell1.colspan.intValue();
/*  229 */         cell.row = cell1.row;
/*      */       } else {
/*  231 */         cell.column = 0;
/*  232 */         cell1.row++;
/*      */       } 
/*      */       
/*  235 */       if (cell.row > 0) {
/*  236 */         Object[] arrayOfObject = this.cells.items;
/*      */         
/*  238 */         for (; --i >= 0; i--) {
/*      */           Cell cell2; int k;
/*  240 */           for (int j = (k = (cell2 = (Cell)arrayOfObject[i]).column) + cell2.colspan.intValue(); k < j; k++) {
/*  241 */             if (k == cell.column) {
/*  242 */               cell.cellAboveIndex = i;
/*      */               // Byte code: goto -> 223
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*  249 */       cell.column = 0;
/*  250 */       cell.row = 0;
/*      */     } 
/*  252 */     this.cells.add(cell);
/*      */     
/*  254 */     cell.set(this.cellDefaults);
/*  255 */     if (cell.column < this.columnDefaults.size) cell.merge((Cell)this.columnDefaults.get(cell.column)); 
/*  256 */     cell.merge(this.rowDefaults);
/*      */     
/*  258 */     if (paramT != null) addActor((Actor)paramT);
/*      */     
/*  260 */     return cell;
/*      */   } public Table add(Actor... paramVarArgs) {
/*      */     byte b;
/*      */     int i;
/*  264 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  265 */       add(paramVarArgs[b]); 
/*  266 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<Label> add(@Null CharSequence paramCharSequence) {
/*  272 */     if (this.skin == null) throw new IllegalStateException("Table must have a skin set to use this method."); 
/*  273 */     return add(new Label(paramCharSequence, this.skin));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<Label> add(@Null CharSequence paramCharSequence, String paramString) {
/*  279 */     if (this.skin == null) throw new IllegalStateException("Table must have a skin set to use this method."); 
/*  280 */     return add(new Label(paramCharSequence, this.skin.<Label.LabelStyle>get(paramString, Label.LabelStyle.class)));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<Label> add(@Null CharSequence paramCharSequence, String paramString, @Null Color paramColor) {
/*  286 */     if (this.skin == null) throw new IllegalStateException("Table must have a skin set to use this method."); 
/*  287 */     return add(new Label(paramCharSequence, new Label.LabelStyle(this.skin.getFont(paramString), paramColor)));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<Label> add(@Null CharSequence paramCharSequence, String paramString1, String paramString2) {
/*  293 */     if (this.skin == null) throw new IllegalStateException("Table must have a skin set to use this method."); 
/*  294 */     return add(new Label(paramCharSequence, new Label.LabelStyle(this.skin.getFont(paramString1), this.skin.getColor(paramString2))));
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell add() {
/*  299 */     return add((Actor)null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<Stack> stack(@Null Actor... paramVarArgs) {
/*  305 */     Stack stack = new Stack();
/*  306 */     if (paramVarArgs != null) {
/*  307 */       byte b; int i; for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  308 */         stack.addActor(paramVarArgs[b]); 
/*      */     } 
/*  310 */     return add(stack);
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor) {
/*  314 */     return removeActor(paramActor, true);
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/*  318 */     if (!super.removeActor(paramActor, paramBoolean)) return false; 
/*      */     Cell<Actor> cell;
/*  320 */     if ((cell = getCell(paramActor)) != null) cell.actor = null; 
/*  321 */     return true;
/*      */   }
/*      */   
/*      */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*  325 */     Actor actor = super.removeActorAt(paramInt, paramBoolean);
/*      */     Cell<Actor> cell;
/*  327 */     if ((cell = getCell(actor)) != null) cell.actor = null; 
/*  328 */     return actor;
/*      */   }
/*      */ 
/*      */   
/*      */   public void clearChildren(boolean paramBoolean) {
/*  333 */     Object[] arrayOfObject = this.cells.items;
/*  334 */     for (int i = this.cells.size - 1; i >= 0; i--) {
/*      */       Cell cell;
/*      */       Actor actor;
/*  337 */       if ((actor = (cell = (Cell)arrayOfObject[i]).actor) != null) actor.remove(); 
/*      */     } 
/*  339 */     cellPool.freeAll(this.cells);
/*  340 */     this.cells.clear();
/*  341 */     this.rows = 0;
/*  342 */     this.columns = 0;
/*  343 */     if (this.rowDefaults != null) cellPool.free(this.rowDefaults); 
/*  344 */     this.rowDefaults = null;
/*  345 */     this.implicitEndRow = false;
/*      */     
/*  347 */     super.clearChildren(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  353 */     clearChildren();
/*  354 */     this.padTop = backgroundTop;
/*  355 */     this.padLeft = backgroundLeft;
/*  356 */     this.padBottom = backgroundBottom;
/*  357 */     this.padRight = backgroundRight;
/*  358 */     this.align = 1;
/*  359 */     debug(Debug.none);
/*  360 */     this.cellDefaults.reset(); byte b; int i;
/*  361 */     for (b = 0, i = this.columnDefaults.size; b < i; b++) {
/*      */       Cell cell;
/*  363 */       if ((cell = (Cell)this.columnDefaults.get(b)) != null) cellPool.free(cell); 
/*      */     } 
/*  365 */     this.columnDefaults.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell row() {
/*  371 */     if (this.cells.size > 0) {
/*  372 */       if (!this.implicitEndRow) {
/*  373 */         if (((Cell)this.cells.peek()).endRow) return this.rowDefaults; 
/*  374 */         endRow();
/*      */       } 
/*  376 */       invalidate();
/*      */     } 
/*  378 */     this.implicitEndRow = false;
/*  379 */     if (this.rowDefaults != null) cellPool.free(this.rowDefaults); 
/*  380 */     this.rowDefaults = obtainCell();
/*  381 */     this.rowDefaults.clear();
/*  382 */     return this.rowDefaults;
/*      */   }
/*      */   
/*      */   private void endRow() {
/*  386 */     Object[] arrayOfObject = this.cells.items;
/*  387 */     int i = 0; Cell cell;
/*  388 */     for (int j = this.cells.size - 1; j >= 0 && 
/*      */       
/*  390 */       !(cell = (Cell)arrayOfObject[j]).endRow; j--) {
/*  391 */       i += cell.colspan.intValue();
/*      */     }
/*  393 */     this.columns = Math.max(this.columns, i);
/*  394 */     this.rows++;
/*  395 */     ((Cell)this.cells.peek()).endRow = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell columnDefaults(int paramInt) {
/*      */     Cell<Actor> cell;
/*  402 */     if ((cell = (Cell<Actor>)((this.columnDefaults.size > paramInt) ? this.columnDefaults.get(paramInt) : null)) == null) {
/*      */       
/*  404 */       (cell = obtainCell()).clear();
/*  405 */       if (paramInt >= this.columnDefaults.size) {
/*  406 */         for (int i = this.columnDefaults.size; i < paramInt; i++)
/*  407 */           this.columnDefaults.add(null); 
/*  408 */         this.columnDefaults.add(cell);
/*      */       } else {
/*  410 */         this.columnDefaults.set(paramInt, cell);
/*      */       } 
/*  412 */     }  return cell;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public <T extends Actor> Cell<T> getCell(T paramT) {
/*  417 */     if (paramT == null) throw new IllegalArgumentException("actor cannot be null."); 
/*  418 */     Object[] arrayOfObject = this.cells.items; byte b; int i;
/*  419 */     for (b = 0, i = this.cells.size; b < i; b++) {
/*      */       Cell<T> cell;
/*  421 */       if ((cell = (Cell)arrayOfObject[b]).actor == paramT) return cell; 
/*      */     } 
/*  423 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public Array<Cell> getCells() {
/*  428 */     return this.cells;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  432 */     if (this.sizeInvalid) computeSize(); 
/*  433 */     float f = this.tablePrefWidth;
/*  434 */     if (this.background != null) return Math.max(f, this.background.getMinWidth()); 
/*  435 */     return f;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  439 */     if (this.sizeInvalid) computeSize(); 
/*  440 */     float f = this.tablePrefHeight;
/*  441 */     if (this.background != null) return Math.max(f, this.background.getMinHeight()); 
/*  442 */     return f;
/*      */   }
/*      */   
/*      */   public float getMinWidth() {
/*  446 */     if (this.sizeInvalid) computeSize(); 
/*  447 */     return this.tableMinWidth;
/*      */   }
/*      */   
/*      */   public float getMinHeight() {
/*  451 */     if (this.sizeInvalid) computeSize(); 
/*  452 */     return this.tableMinHeight;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell defaults() {
/*  457 */     return this.cellDefaults;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table pad(Value paramValue) {
/*  462 */     if (paramValue == null) throw new IllegalArgumentException("pad cannot be null."); 
/*  463 */     this.padTop = paramValue;
/*  464 */     this.padLeft = paramValue;
/*  465 */     this.padBottom = paramValue;
/*  466 */     this.padRight = paramValue;
/*  467 */     this.sizeInvalid = true;
/*  468 */     return this;
/*      */   }
/*      */   
/*      */   public Table pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/*  472 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/*  473 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/*  474 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/*  475 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/*  476 */     this.padTop = paramValue1;
/*  477 */     this.padLeft = paramValue2;
/*  478 */     this.padBottom = paramValue3;
/*  479 */     this.padRight = paramValue4;
/*  480 */     this.sizeInvalid = true;
/*  481 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padTop(Value paramValue) {
/*  486 */     if (paramValue == null) throw new IllegalArgumentException("padTop cannot be null."); 
/*  487 */     this.padTop = paramValue;
/*  488 */     this.sizeInvalid = true;
/*  489 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padLeft(Value paramValue) {
/*  494 */     if (paramValue == null) throw new IllegalArgumentException("padLeft cannot be null."); 
/*  495 */     this.padLeft = paramValue;
/*  496 */     this.sizeInvalid = true;
/*  497 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padBottom(Value paramValue) {
/*  502 */     if (paramValue == null) throw new IllegalArgumentException("padBottom cannot be null."); 
/*  503 */     this.padBottom = paramValue;
/*  504 */     this.sizeInvalid = true;
/*  505 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padRight(Value paramValue) {
/*  510 */     if (paramValue == null) throw new IllegalArgumentException("padRight cannot be null."); 
/*  511 */     this.padRight = paramValue;
/*  512 */     this.sizeInvalid = true;
/*  513 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table pad(float paramFloat) {
/*  518 */     pad(Value.Fixed.valueOf(paramFloat));
/*  519 */     return this;
/*      */   }
/*      */   
/*      */   public Table pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  523 */     this.padTop = Value.Fixed.valueOf(paramFloat1);
/*  524 */     this.padLeft = Value.Fixed.valueOf(paramFloat2);
/*  525 */     this.padBottom = Value.Fixed.valueOf(paramFloat3);
/*  526 */     this.padRight = Value.Fixed.valueOf(paramFloat4);
/*  527 */     this.sizeInvalid = true;
/*  528 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padTop(float paramFloat) {
/*  533 */     this.padTop = Value.Fixed.valueOf(paramFloat);
/*  534 */     this.sizeInvalid = true;
/*  535 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padLeft(float paramFloat) {
/*  540 */     this.padLeft = Value.Fixed.valueOf(paramFloat);
/*  541 */     this.sizeInvalid = true;
/*  542 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padBottom(float paramFloat) {
/*  547 */     this.padBottom = Value.Fixed.valueOf(paramFloat);
/*  548 */     this.sizeInvalid = true;
/*  549 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padRight(float paramFloat) {
/*  554 */     this.padRight = Value.Fixed.valueOf(paramFloat);
/*  555 */     this.sizeInvalid = true;
/*  556 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Table align(int paramInt) {
/*  562 */     this.align = paramInt;
/*  563 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table center() {
/*  568 */     this.align = 1;
/*  569 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table top() {
/*  574 */     this.align |= 0x2;
/*  575 */     this.align &= 0xFFFFFFFB;
/*  576 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table left() {
/*  581 */     this.align |= 0x8;
/*  582 */     this.align &= 0xFFFFFFEF;
/*  583 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table bottom() {
/*  588 */     this.align |= 0x4;
/*  589 */     this.align &= 0xFFFFFFFD;
/*  590 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table right() {
/*  595 */     this.align |= 0x10;
/*  596 */     this.align &= 0xFFFFFFF7;
/*  597 */     return this;
/*      */   }
/*      */   
/*      */   public void setDebug(boolean paramBoolean) {
/*  601 */     debug(paramBoolean ? Debug.all : Debug.none);
/*      */   }
/*      */   
/*      */   public Table debug() {
/*  605 */     super.debug();
/*  606 */     return this;
/*      */   }
/*      */   
/*      */   public Table debugAll() {
/*  610 */     super.debugAll();
/*  611 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debugTable() {
/*  616 */     super.setDebug(true);
/*  617 */     if (this.debug != Debug.table) {
/*  618 */       this.debug = Debug.table;
/*  619 */       invalidate();
/*      */     } 
/*  621 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debugCell() {
/*  626 */     super.setDebug(true);
/*  627 */     if (this.debug != Debug.cell) {
/*  628 */       this.debug = Debug.cell;
/*  629 */       invalidate();
/*      */     } 
/*  631 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debugActor() {
/*  636 */     super.setDebug(true);
/*  637 */     if (this.debug != Debug.actor) {
/*  638 */       this.debug = Debug.actor;
/*  639 */       invalidate();
/*      */     } 
/*  641 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debug(Debug paramDebug) {
/*  646 */     super.setDebug((paramDebug != Debug.none));
/*  647 */     if (this.debug != paramDebug) {
/*  648 */       this.debug = paramDebug;
/*  649 */       if (paramDebug == Debug.none) {
/*  650 */         clearDebugRects();
/*      */       } else {
/*  652 */         invalidate();
/*      */       } 
/*  654 */     }  return this;
/*      */   }
/*      */   
/*      */   public Debug getTableDebug() {
/*  658 */     return this.debug;
/*      */   }
/*      */   
/*      */   public Value getPadTopValue() {
/*  662 */     return this.padTop;
/*      */   }
/*      */   
/*      */   public float getPadTop() {
/*  666 */     return this.padTop.get((Actor)this);
/*      */   }
/*      */   
/*      */   public Value getPadLeftValue() {
/*  670 */     return this.padLeft;
/*      */   }
/*      */   
/*      */   public float getPadLeft() {
/*  674 */     return this.padLeft.get((Actor)this);
/*      */   }
/*      */   
/*      */   public Value getPadBottomValue() {
/*  678 */     return this.padBottom;
/*      */   }
/*      */   
/*      */   public float getPadBottom() {
/*  682 */     return this.padBottom.get((Actor)this);
/*      */   }
/*      */   
/*      */   public Value getPadRightValue() {
/*  686 */     return this.padRight;
/*      */   }
/*      */   
/*      */   public float getPadRight() {
/*  690 */     return this.padRight.get((Actor)this);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadX() {
/*  695 */     return this.padLeft.get((Actor)this) + this.padRight.get((Actor)this);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadY() {
/*  700 */     return this.padTop.get((Actor)this) + this.padBottom.get((Actor)this);
/*      */   }
/*      */   
/*      */   public int getAlign() {
/*  704 */     return this.align;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRow(float paramFloat) {
/*      */     int i;
/*  711 */     if ((i = this.cells.size) == 0) return -1; 
/*  712 */     paramFloat += getPadTop();
/*  713 */     Object[] arrayOfObject = this.cells.items;
/*  714 */     for (byte b1 = 0, b2 = 0; b1 < i; ) {
/*      */       Cell cell;
/*  716 */       if ((cell = (Cell)arrayOfObject[b1++]).actorY + cell.computedPadTop < paramFloat) return b2; 
/*  717 */       if (cell.endRow) b2++; 
/*      */     } 
/*  719 */     return -1;
/*      */   }
/*      */   
/*      */   public void setSkin(@Null Skin paramSkin) {
/*  723 */     this.skin = paramSkin;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRound(boolean paramBoolean) {
/*  728 */     this.round = paramBoolean;
/*      */   }
/*      */   
/*      */   public int getRows() {
/*  732 */     return this.rows;
/*      */   }
/*      */   
/*      */   public int getColumns() {
/*  736 */     return this.columns;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRowHeight(int paramInt) {
/*  741 */     if (this.rowHeight == null) return 0.0F; 
/*  742 */     return this.rowHeight[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRowMinHeight(int paramInt) {
/*  747 */     if (this.sizeInvalid) computeSize(); 
/*  748 */     return this.rowMinHeight[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRowPrefHeight(int paramInt) {
/*  753 */     if (this.sizeInvalid) computeSize(); 
/*  754 */     return this.rowPrefHeight[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnWidth(int paramInt) {
/*  759 */     if (this.columnWidth == null) return 0.0F; 
/*  760 */     return this.columnWidth[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnMinWidth(int paramInt) {
/*  765 */     if (this.sizeInvalid) computeSize(); 
/*  766 */     return this.columnMinWidth[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnPrefWidth(int paramInt) {
/*  771 */     if (this.sizeInvalid) computeSize(); 
/*  772 */     return this.columnPrefWidth[paramInt];
/*      */   }
/*      */   
/*      */   private float[] ensureSize(float[] paramArrayOffloat, int paramInt) {
/*  776 */     if (paramArrayOffloat == null || paramArrayOffloat.length < paramInt) return new float[paramInt]; 
/*  777 */     Arrays.fill(paramArrayOffloat, 0, paramInt, 0.0F);
/*  778 */     return paramArrayOffloat;
/*      */   }
/*      */   
/*      */   private void computeSize() {
/*  782 */     this.sizeInvalid = false;
/*      */     
/*  784 */     Object[] arrayOfObject = this.cells.items;
/*      */     
/*      */     int i;
/*      */     
/*  788 */     if ((i = this.cells.size) > 0 && !((Cell)arrayOfObject[i - 1]).endRow) {
/*  789 */       endRow();
/*  790 */       this.implicitEndRow = true;
/*      */     } 
/*      */     
/*  793 */     int j = this.columns, k = this.rows;
/*  794 */     float[] arrayOfFloat1 = this.columnMinWidth = ensureSize(this.columnMinWidth, j);
/*  795 */     float[] arrayOfFloat2 = this.rowMinHeight = ensureSize(this.rowMinHeight, k);
/*  796 */     float[] arrayOfFloat3 = this.columnPrefWidth = ensureSize(this.columnPrefWidth, j);
/*  797 */     float[] arrayOfFloat4 = this.rowPrefHeight = ensureSize(this.rowPrefHeight, k);
/*  798 */     this.columnWidth = ensureSize(this.columnWidth, j);
/*  799 */     this.rowHeight = ensureSize(this.rowHeight, k);
/*  800 */     float[] arrayOfFloat5 = this.expandWidth = ensureSize(this.expandWidth, j);
/*  801 */     float[] arrayOfFloat6 = this.expandHeight = ensureSize(this.expandHeight, k);
/*      */     
/*  803 */     float f1 = 0.0F;
/*  804 */     for (byte b2 = 0; b2 < i; b2++) {
/*      */       Cell cell;
/*  806 */       int m = (cell = (Cell)arrayOfObject[b2]).column, n = cell.row, i1 = cell.colspan.intValue();
/*  807 */       Actor actor = cell.actor;
/*      */ 
/*      */       
/*  810 */       if (cell.expandY.intValue() != 0 && arrayOfFloat6[n] == 0.0F) arrayOfFloat6[n] = cell.expandY.intValue(); 
/*  811 */       if (i1 == 1 && cell.expandX.intValue() != 0 && arrayOfFloat5[m] == 0.0F) arrayOfFloat5[m] = cell.expandX.intValue();
/*      */ 
/*      */ 
/*      */       
/*  815 */       cell.computedPadLeft = cell.padLeft.get(actor) + ((m == 0) ? 0.0F : Math.max(0.0F, cell.spaceLeft.get(actor) - f1));
/*  816 */       cell.computedPadTop = cell.padTop.get(actor);
/*  817 */       if (cell.cellAboveIndex != -1) {
/*  818 */         Cell cell1 = (Cell)arrayOfObject[cell.cellAboveIndex];
/*  819 */         cell.computedPadTop += Math.max(0.0F, cell.spaceTop.get(actor) - cell1.spaceBottom.get(actor));
/*      */       } 
/*  821 */       f1 = cell.spaceRight.get(actor);
/*  822 */       cell.computedPadRight = cell.padRight.get(actor) + ((m + i1 == j) ? 0.0F : f1);
/*  823 */       cell.computedPadBottom = cell.padBottom.get(actor) + ((n == k - 1) ? 0.0F : cell.spaceBottom.get(actor));
/*  824 */       f1 = f1;
/*      */ 
/*      */       
/*  827 */       float f9 = cell.prefWidth.get(actor), f10 = cell.prefHeight.get(actor);
/*  828 */       float f11 = cell.minWidth.get(actor), f12 = cell.minHeight.get(actor);
/*  829 */       float f13 = cell.maxWidth.get(actor), f8 = cell.maxHeight.get(actor);
/*  830 */       if (f9 < f11) f9 = f11; 
/*  831 */       if (f10 < f12) f10 = f12; 
/*  832 */       if (f13 > 0.0F && f9 > f13) f9 = f13; 
/*  833 */       if (f8 > 0.0F && f10 > f8) f10 = f8; 
/*  834 */       if (this.round) {
/*  835 */         f11 = (float)Math.ceil(f11);
/*  836 */         f12 = (float)Math.ceil(f12);
/*  837 */         f9 = (float)Math.ceil(f9);
/*  838 */         f10 = (float)Math.ceil(f10);
/*      */       } 
/*      */       
/*  841 */       if (i1 == 1) {
/*  842 */         f13 = cell.computedPadLeft + cell.computedPadRight;
/*  843 */         arrayOfFloat3[m] = Math.max(arrayOfFloat3[m], f9 + f13);
/*  844 */         arrayOfFloat1[m] = Math.max(arrayOfFloat1[m], f11 + f13);
/*      */       } 
/*  846 */       f13 = cell.computedPadTop + cell.computedPadBottom;
/*  847 */       arrayOfFloat4[n] = Math.max(arrayOfFloat4[n], f10 + f13);
/*  848 */       arrayOfFloat2[n] = Math.max(arrayOfFloat2[n], f12 + f13);
/*      */     } 
/*      */     
/*  851 */     float f2 = 0.0F, f3 = 0.0F;
/*  852 */     float f4 = 0.0F, f5 = 0.0F; byte b3;
/*  853 */     label129: for (b3 = 0; b3 < i; b3++) {
/*      */       Cell cell;
/*  855 */       int m = (cell = (Cell)arrayOfObject[b3]).column;
/*      */ 
/*      */       
/*      */       int n;
/*      */       
/*  860 */       if ((n = cell.expandX.intValue()) != 0) {
/*  861 */         int i1 = m + cell.colspan.intValue(); int i2;
/*  862 */         for (i2 = m; i2 < i1; ) {
/*  863 */           if (arrayOfFloat5[i2] == 0.0F) { i2++; continue; }  continue label129;
/*  864 */         }  for (i2 = m; i2 < i1; i2++) {
/*  865 */           arrayOfFloat5[i2] = n;
/*      */         }
/*      */       } 
/*      */       
/*  869 */       if (cell.uniformX == Boolean.TRUE && cell.colspan.intValue() == 1) {
/*  870 */         float f = cell.computedPadLeft + cell.computedPadRight;
/*  871 */         f2 = Math.max(f2, arrayOfFloat1[m] - f);
/*  872 */         f4 = Math.max(f4, arrayOfFloat3[m] - f);
/*      */       } 
/*  874 */       if (cell.uniformY == Boolean.TRUE) {
/*  875 */         float f = cell.computedPadTop + cell.computedPadBottom;
/*  876 */         f3 = Math.max(f3, arrayOfFloat2[cell.row] - f);
/*  877 */         f5 = Math.max(f5, arrayOfFloat4[cell.row] - f);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  882 */     if (f4 > 0.0F || f5 > 0.0F) {
/*  883 */       for (b3 = 0; b3 < i; b3++) {
/*  884 */         Cell cell = (Cell)arrayOfObject[b3];
/*  885 */         if (f4 > 0.0F && cell.uniformX == Boolean.TRUE && cell.colspan.intValue() == 1) {
/*  886 */           f1 = cell.computedPadLeft + cell.computedPadRight;
/*  887 */           arrayOfFloat1[cell.column] = f2 + f1;
/*  888 */           arrayOfFloat3[cell.column] = f4 + f1;
/*      */         } 
/*  890 */         if (f5 > 0.0F && cell.uniformY == Boolean.TRUE) {
/*  891 */           f1 = cell.computedPadTop + cell.computedPadBottom;
/*  892 */           arrayOfFloat2[cell.row] = f3 + f1;
/*  893 */           arrayOfFloat4[cell.row] = f5 + f1;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  899 */     for (b3 = 0; b3 < i; b3++) {
/*      */       int m;
/*      */       Cell cell;
/*  902 */       if ((m = (cell = (Cell)arrayOfObject[b3]).colspan.intValue()) != 1) {
/*  903 */         int i4 = cell.column;
/*      */         
/*  905 */         Actor actor = cell.actor;
/*  906 */         float f12 = cell.minWidth.get(actor), f13 = cell.prefWidth.get(actor), f14 = cell.maxWidth.get(actor);
/*  907 */         if (f13 < f12) f13 = f12; 
/*  908 */         if (f14 > 0.0F && f13 > f14) f13 = f14; 
/*  909 */         if (this.round) {
/*  910 */           f12 = (float)Math.ceil(f12);
/*  911 */           f13 = (float)Math.ceil(f13);
/*      */         } 
/*      */         
/*  914 */         float f11 = -(cell.computedPadLeft + cell.computedPadRight);
/*  915 */         float f8 = 0.0F; int n;
/*  916 */         for (int i1 = (n = i4) + m; n < i1; n++) {
/*  917 */           f11 += arrayOfFloat1[n];
/*  918 */           f14 += arrayOfFloat3[n];
/*  919 */           f8 += arrayOfFloat5[n];
/*      */         } 
/*      */         
/*  922 */         float f9 = Math.max(0.0F, f12 - f11);
/*  923 */         float f10 = Math.max(0.0F, f13 - f14); int i2;
/*  924 */         for (int i3 = (i2 = i4) + m; i2 < i3; i2++) {
/*  925 */           f11 = (f8 == 0.0F) ? (1.0F / m) : (arrayOfFloat5[i2] / f8);
/*  926 */           arrayOfFloat1[i2] = arrayOfFloat1[i2] + f9 * f11;
/*  927 */           arrayOfFloat3[i2] = arrayOfFloat3[i2] + f10 * f11;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  932 */     float f6 = this.padLeft.get((Actor)this) + this.padRight.get((Actor)this);
/*  933 */     float f7 = this.padTop.get((Actor)this) + this.padBottom.get((Actor)this);
/*  934 */     this.tableMinWidth = f6;
/*  935 */     this.tablePrefWidth = f6; byte b1;
/*  936 */     for (b1 = 0; b1 < j; b1++) {
/*  937 */       this.tableMinWidth += arrayOfFloat1[b1];
/*  938 */       this.tablePrefWidth += arrayOfFloat3[b1];
/*      */     } 
/*  940 */     this.tableMinHeight = f7;
/*  941 */     this.tablePrefHeight = f7;
/*  942 */     for (b1 = 0; b1 < k; b1++) {
/*  943 */       this.tableMinHeight += arrayOfFloat2[b1];
/*  944 */       this.tablePrefHeight += Math.max(arrayOfFloat2[b1], arrayOfFloat4[b1]);
/*      */     } 
/*  946 */     this.tablePrefWidth = Math.max(this.tableMinWidth, this.tablePrefWidth);
/*  947 */     this.tablePrefHeight = Math.max(this.tableMinHeight, this.tablePrefHeight);
/*      */   }
/*      */ 
/*      */   
/*      */   public void layout() {
/*      */     float[] arrayOfFloat3, arrayOfFloat4;
/*  953 */     if (this.sizeInvalid) computeSize();
/*      */     
/*  955 */     float f1 = getWidth(), f2 = getHeight();
/*  956 */     int i = this.columns, j = this.rows;
/*  957 */     float[] arrayOfFloat1 = this.columnWidth, arrayOfFloat2 = this.rowHeight;
/*  958 */     float f3, f4 = (f3 = this.padLeft.get((Actor)this)) + this.padRight.get((Actor)this);
/*  959 */     float f5, f6 = (f5 = this.padTop.get((Actor)this)) + this.padBottom.get((Actor)this);
/*      */ 
/*      */     
/*      */     float f7;
/*      */     
/*  964 */     if ((f7 = this.tablePrefWidth - this.tableMinWidth) == 0.0F) {
/*  965 */       arrayOfFloat3 = this.columnMinWidth;
/*      */     } else {
/*  967 */       float f = Math.min(f7, Math.max(0.0F, f1 - this.tableMinWidth));
/*  968 */       arrayOfFloat3 = columnWeightedWidth = ensureSize(columnWeightedWidth, i);
/*  969 */       float[] arrayOfFloat7 = this.columnMinWidth, arrayOfFloat8 = this.columnPrefWidth;
/*  970 */       for (byte b = 0; b < i; b++) {
/*      */         
/*  972 */         float f14, f15 = (f14 = arrayOfFloat8[b] - arrayOfFloat7[b]) / f7;
/*  973 */         arrayOfFloat3[b] = arrayOfFloat7[b] + f * f15;
/*      */       } 
/*      */     } 
/*      */     
/*      */     float f8;
/*      */     
/*  979 */     if ((f8 = this.tablePrefHeight - this.tableMinHeight) == 0.0F) {
/*  980 */       arrayOfFloat4 = this.rowMinHeight;
/*      */     } else {
/*  982 */       arrayOfFloat4 = rowWeightedHeight = ensureSize(rowWeightedHeight, j);
/*  983 */       float f = Math.min(f8, Math.max(0.0F, f2 - this.tableMinHeight));
/*  984 */       float[] arrayOfFloat7 = this.rowMinHeight, arrayOfFloat8 = this.rowPrefHeight;
/*  985 */       for (byte b = 0; b < j; b++) {
/*      */         
/*  987 */         float f14 = (f7 = arrayOfFloat8[b] - arrayOfFloat7[b]) / f8;
/*  988 */         arrayOfFloat4[b] = arrayOfFloat7[b] + f * f14;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  993 */     Object[] arrayOfObject = this.cells.items;
/*  994 */     int k = this.cells.size;
/*  995 */     for (byte b1 = 0; b1 < k; b1++) {
/*      */       Cell cell;
/*  997 */       int i1 = (cell = (Cell)arrayOfObject[b1]).column, i2 = cell.row;
/*  998 */       Actor actor = cell.actor;
/*      */       
/* 1000 */       float f14 = 0.0F;
/* 1001 */       int i3 = cell.colspan.intValue(); int i4;
/* 1002 */       for (int i5 = (i4 = i1) + i3; i4 < i5; i4++)
/* 1003 */         f14 += arrayOfFloat3[i4]; 
/* 1004 */       float f15 = arrayOfFloat4[i2];
/*      */       
/* 1006 */       float f16 = cell.prefWidth.get(actor), f17 = cell.prefHeight.get(actor);
/* 1007 */       float f18 = cell.minWidth.get(actor), f19 = cell.minHeight.get(actor);
/* 1008 */       float f20 = cell.maxWidth.get(actor), f21 = cell.maxHeight.get(actor);
/* 1009 */       if (f16 < f18) f16 = f18; 
/* 1010 */       if (f17 < f19) f17 = f19; 
/* 1011 */       if (f20 > 0.0F && f16 > f20) f16 = f20; 
/* 1012 */       if (f21 > 0.0F && f17 > f21) f17 = f21;
/*      */       
/* 1014 */       cell.actorWidth = Math.min(f14 - cell.computedPadLeft - cell.computedPadRight, f16);
/* 1015 */       cell.actorHeight = Math.min(f15 - cell.computedPadTop - cell.computedPadBottom, f17);
/*      */       
/* 1017 */       if (i3 == 1) arrayOfFloat1[i1] = Math.max(arrayOfFloat1[i1], f14); 
/* 1018 */       arrayOfFloat2[i2] = Math.max(arrayOfFloat2[i2], f15);
/*      */     } 
/*      */ 
/*      */     
/* 1022 */     float[] arrayOfFloat5 = this.expandWidth, arrayOfFloat6 = this.expandHeight;
/* 1023 */     f7 = 0.0F; byte b2;
/* 1024 */     for (b2 = 0; b2 < i; b2++)
/* 1025 */       f7 += arrayOfFloat5[b2]; 
/* 1026 */     if (f7 > 0.0F) {
/* 1027 */       float f = f1 - f4;
/* 1028 */       for (byte b = 0; b < i; b++)
/* 1029 */         f -= arrayOfFloat1[b]; 
/* 1030 */       if (f > 0.0F) {
/* 1031 */         float f14 = 0.0F;
/* 1032 */         byte b5 = 0;
/* 1033 */         for (byte b6 = 0; b6 < i; b6++) {
/* 1034 */           if (arrayOfFloat5[b6] != 0.0F) {
/* 1035 */             float f15 = f * arrayOfFloat5[b6] / f7;
/* 1036 */             arrayOfFloat1[b6] = arrayOfFloat1[b6] + f15;
/* 1037 */             f14 += f15;
/* 1038 */             b5 = b6;
/*      */           } 
/* 1040 */         }  arrayOfFloat1[b5] = arrayOfFloat1[b5] + f - f14;
/*      */       } 
/*      */     } 
/*      */     
/* 1044 */     f7 = 0.0F;
/* 1045 */     for (b2 = 0; b2 < j; b2++)
/* 1046 */       f7 += arrayOfFloat6[b2]; 
/* 1047 */     if (f7 > 0.0F) {
/* 1048 */       float f = f2 - f6;
/* 1049 */       for (byte b = 0; b < j; b++)
/* 1050 */         f -= arrayOfFloat2[b]; 
/* 1051 */       if (f > 0.0F) {
/* 1052 */         float f14 = 0.0F;
/* 1053 */         byte b5 = 0;
/* 1054 */         for (byte b6 = 0; b6 < j; b6++) {
/* 1055 */           if (arrayOfFloat6[b6] != 0.0F) {
/* 1056 */             float f15 = f * arrayOfFloat6[b6] / f7;
/* 1057 */             arrayOfFloat2[b6] = arrayOfFloat2[b6] + f15;
/* 1058 */             f14 += f15;
/* 1059 */             b5 = b6;
/*      */           } 
/* 1061 */         }  arrayOfFloat2[b5] = arrayOfFloat2[b5] + f - f14;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1066 */     for (b2 = 0; b2 < k; b2++) {
/*      */       Cell cell;
/*      */       int i1;
/* 1069 */       if ((i1 = (cell = (Cell)arrayOfObject[b2]).colspan.intValue()) != 1) {
/*      */         
/* 1071 */         float f = 0.0F; int i2, i3;
/* 1072 */         for (i3 = (i2 = cell.column) + i1; i2 < i3; i2++) {
/* 1073 */           f += arrayOfFloat3[i2] - arrayOfFloat1[i2];
/*      */         }
/*      */ 
/*      */         
/* 1077 */         if ((f = (f = f - Math.max(0.0F, cell.computedPadLeft + cell.computedPadRight)) / i1) > 0.0F) {
/* 1078 */           for (i3 = (i2 = cell.column) + i1; i2 < i3; i2++) {
/* 1079 */             arrayOfFloat1[i2] = arrayOfFloat1[i2] + f;
/*      */           }
/*      */         }
/*      */       } 
/*      */     } 
/* 1084 */     float f9 = f4; f8 = f6; int m;
/* 1085 */     for (m = 0; m < i; m++)
/* 1086 */       f9 += arrayOfFloat1[m]; 
/* 1087 */     for (m = 0; m < j; m++) {
/* 1088 */       f8 += arrayOfFloat2[m];
/*      */     }
/*      */     
/* 1091 */     m = this.align;
/* 1092 */     float f10 = f3;
/* 1093 */     if ((m & 0x10) != 0) {
/* 1094 */       f10 = f3 + f1 - f9;
/* 1095 */     } else if ((m & 0x8) == 0) {
/* 1096 */       f10 = f3 + (f1 - f9) / 2.0F;
/*      */     } 
/* 1098 */     float f11 = f5;
/* 1099 */     if ((m & 0x4) != 0) {
/* 1100 */       f11 = f5 + f2 - f8;
/* 1101 */     } else if ((m & 0x2) == 0) {
/* 1102 */       f11 = f5 + (f2 - f8) / 2.0F;
/*      */     } 
/*      */     
/* 1105 */     float f12 = f10, f13 = f11;
/* 1106 */     for (byte b3 = 0; b3 < k; b3++) {
/* 1107 */       Cell cell = (Cell)arrayOfObject[b3];
/*      */       
/* 1109 */       float f16 = 0.0F; int i2;
/* 1110 */       for (int i1 = (i2 = cell.column) + cell.colspan.intValue(); i2 < i1; i2++)
/* 1111 */         f16 += arrayOfFloat1[i2]; 
/* 1112 */       f16 -= cell.computedPadLeft + cell.computedPadRight;
/*      */       
/* 1114 */       f12 += cell.computedPadLeft;
/*      */       
/* 1116 */       float f17 = cell.fillX.floatValue(), f14 = cell.fillY.floatValue();
/*      */       
/* 1118 */       cell.actorWidth = Math.max(f16 * f17, cell.minWidth.get(cell.actor));
/*      */       float f15;
/* 1120 */       if (f17 > 0.0F && (f15 = cell.maxWidth.get(cell.actor)) > 0.0F) cell.actorWidth = Math.min(cell.actorWidth, f15);
/*      */ 
/*      */       
/* 1123 */       cell.actorHeight = Math.max(arrayOfFloat2[cell.row] * f14 - cell.computedPadTop - cell.computedPadBottom, cell.minHeight.get(cell.actor));
/*      */       
/* 1125 */       if (f14 > 0.0F && (f15 = cell.maxHeight.get(cell.actor)) > 0.0F) cell.actorHeight = Math.min(cell.actorHeight, f15);
/*      */ 
/*      */ 
/*      */       
/* 1129 */       if (((m = cell.align.intValue()) & 0x8) != 0) {
/* 1130 */         cell.actorX = f12;
/* 1131 */       } else if ((m & 0x10) != 0) {
/* 1132 */         cell.actorX = f12 + f16 - cell.actorWidth;
/*      */       } else {
/* 1134 */         cell.actorX = f12 + (f16 - cell.actorWidth) / 2.0F;
/*      */       } 
/* 1136 */       if ((m & 0x2) != 0) {
/* 1137 */         cell.actorY = cell.computedPadTop;
/* 1138 */       } else if ((m & 0x4) != 0) {
/* 1139 */         cell.actorY = arrayOfFloat2[cell.row] - cell.actorHeight - cell.computedPadBottom;
/*      */       } else {
/* 1141 */         cell.actorY = (arrayOfFloat2[cell.row] - cell.actorHeight + cell.computedPadTop - cell.computedPadBottom) / 2.0F;
/* 1142 */       }  cell.actorY = f2 - f13 - cell.actorY - cell.actorHeight;
/*      */       
/* 1144 */       if (this.round) {
/* 1145 */         cell.actorWidth = (float)Math.ceil(cell.actorWidth);
/* 1146 */         cell.actorHeight = (float)Math.ceil(cell.actorHeight);
/* 1147 */         cell.actorX = (float)Math.floor(cell.actorX);
/* 1148 */         cell.actorY = (float)Math.floor(cell.actorY);
/*      */       } 
/*      */       
/* 1151 */       if (cell.actor != null) cell.actor.setBounds(cell.actorX, cell.actorY, cell.actorWidth, cell.actorHeight);
/*      */       
/* 1153 */       if (cell.endRow) {
/* 1154 */         f12 = f10;
/* 1155 */         f13 += arrayOfFloat2[cell.row];
/*      */       } else {
/* 1157 */         f12 += f16 + cell.computedPadRight;
/*      */       } 
/*      */     } 
/*      */     
/*      */     SnapshotArray snapshotArray;
/* 1162 */     Actor[] arrayOfActor = (Actor[])((Array)(snapshotArray = getChildren())).items; byte b4; int n;
/* 1163 */     for (b4 = 0, n = ((Array)snapshotArray).size; b4 < n; b4++) {
/*      */       Actor actor;
/* 1165 */       if (actor = arrayOfActor[b4] instanceof Layout) ((Layout)actor).validate();
/*      */     
/*      */     } 
/*      */     
/* 1169 */     if (this.debug != Debug.none) addDebugRects(f10, f11, f9 - f4, f8 - f6); 
/*      */   }
/*      */   
/*      */   private void addDebugRects(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1173 */     clearDebugRects();
/* 1174 */     if (this.debug == Debug.table || this.debug == Debug.all) {
/*      */       
/* 1176 */       addDebugRect(0.0F, 0.0F, getWidth(), getHeight(), debugTableColor);
/*      */       
/* 1178 */       addDebugRect(paramFloat1, getHeight() - paramFloat2, paramFloat3, -paramFloat4, debugTableColor);
/*      */     } 
/* 1180 */     paramFloat3 = paramFloat1; byte b; int i;
/* 1181 */     for (b = 0, i = this.cells.size; b < i; b++) {
/* 1182 */       Cell cell = (Cell)this.cells.get(b);
/*      */ 
/*      */       
/* 1185 */       if (this.debug == Debug.actor || this.debug == Debug.all) {
/* 1186 */         addDebugRect(cell.actorX, cell.actorY, cell.actorWidth, cell.actorHeight, debugActorColor);
/*      */       }
/*      */       
/* 1189 */       float f = 0.0F; int j;
/* 1190 */       for (int k = (j = cell.column) + cell.colspan.intValue(); j < k; j++)
/* 1191 */         f += this.columnWidth[j]; 
/* 1192 */       f -= cell.computedPadLeft + cell.computedPadRight;
/* 1193 */       paramFloat1 += cell.computedPadLeft;
/* 1194 */       if (this.debug == Debug.cell || this.debug == Debug.all) {
/* 1195 */         float f1 = this.rowHeight[cell.row] - cell.computedPadTop - cell.computedPadBottom;
/* 1196 */         float f2 = paramFloat2 + cell.computedPadTop;
/* 1197 */         addDebugRect(paramFloat1, getHeight() - f2, f, -f1, debugCellColor);
/*      */       } 
/*      */       
/* 1200 */       if (cell.endRow) {
/* 1201 */         paramFloat1 = paramFloat3;
/* 1202 */         paramFloat2 += this.rowHeight[cell.row];
/*      */       } else {
/* 1204 */         paramFloat1 += f + cell.computedPadRight;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void clearDebugRects() {
/* 1209 */     if (this.debugRects == null) this.debugRects = new Array(); 
/* 1210 */     DebugRect.pool.freeAll(this.debugRects);
/* 1211 */     this.debugRects.clear();
/*      */   }
/*      */   
/*      */   private void addDebugRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor) {
/*      */     DebugRect debugRect;
/* 1216 */     (debugRect = (DebugRect)DebugRect.pool.obtain()).color = paramColor;
/* 1217 */     debugRect.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1218 */     this.debugRects.add(debugRect);
/*      */   }
/*      */   
/*      */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 1222 */     if (isTransform()) {
/* 1223 */       applyTransform(paramShapeRenderer, computeTransform());
/* 1224 */       drawDebugRects(paramShapeRenderer);
/* 1225 */       if (this.clip) {
/* 1226 */         paramShapeRenderer.flush();
/* 1227 */         float f1 = 0.0F, f2 = 0.0F, f3 = getWidth(), f4 = getHeight();
/* 1228 */         if (this.background != null) {
/* 1229 */           f1 = this.padLeft.get((Actor)this);
/* 1230 */           f2 = this.padBottom.get((Actor)this);
/* 1231 */           f3 -= f1 + this.padRight.get((Actor)this);
/* 1232 */           f4 -= f2 + this.padTop.get((Actor)this);
/*      */         } 
/* 1234 */         if (clipBegin(f1, f2, f3, f4)) {
/* 1235 */           drawDebugChildren(paramShapeRenderer);
/* 1236 */           clipEnd();
/*      */         } 
/*      */       } else {
/* 1239 */         drawDebugChildren(paramShapeRenderer);
/* 1240 */       }  resetTransform(paramShapeRenderer); return;
/*      */     } 
/* 1242 */     drawDebugRects(paramShapeRenderer);
/* 1243 */     super.drawDebug(paramShapeRenderer);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void drawDebugBounds(ShapeRenderer paramShapeRenderer) {}
/*      */ 
/*      */   
/*      */   private void drawDebugRects(ShapeRenderer paramShapeRenderer) {
/* 1251 */     if (this.debugRects == null || !getDebug())
/* 1252 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 1253 */     if (getStage() != null) paramShapeRenderer.setColor(getStage().getDebugColor()); 
/* 1254 */     float f1 = 0.0F, f2 = 0.0F;
/* 1255 */     if (!isTransform()) {
/* 1256 */       f1 = getX();
/* 1257 */       f2 = getY();
/*      */     }  byte b; int i;
/* 1259 */     for (b = 0, i = this.debugRects.size; b < i; b++) {
/* 1260 */       DebugRect debugRect = (DebugRect)this.debugRects.get(b);
/* 1261 */       paramShapeRenderer.setColor(debugRect.color);
/* 1262 */       paramShapeRenderer.rect(f1 + debugRect.x, f2 + debugRect.y, debugRect.width, debugRect.height);
/*      */     } 
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Skin getSkin() {
/* 1268 */     return this.skin;
/*      */   }
/*      */   
/*      */   public static class DebugRect
/*      */     extends Rectangle {
/* 1273 */     static Pool<DebugRect> pool = Pools.get(DebugRect.class);
/*      */     Color color;
/*      */   }
/*      */   
/*      */   public enum Debug
/*      */   {
/* 1279 */     none, all, table, cell, actor;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1284 */   public static Value backgroundTop = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1287 */         return ((drawable = ((Table)param1Actor).background) == null) ? 0.0F : drawable.getTopHeight();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/* 1293 */   public static Value backgroundLeft = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1296 */         return ((drawable = ((Table)param1Actor).background) == null) ? 0.0F : drawable.getLeftWidth();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/* 1302 */   public static Value backgroundBottom = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1305 */         return ((drawable = ((Table)param1Actor).background) == null) ? 0.0F : drawable.getBottomHeight();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/* 1311 */   public static Value backgroundRight = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1314 */         return ((drawable = ((Table)param1Actor).background) == null) ? 0.0F : drawable.getRightWidth();
/*      */       }
/*      */     };
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Table.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */