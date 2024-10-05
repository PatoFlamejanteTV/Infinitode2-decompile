/*      */ package com.prineside.tdi2.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.graphics.Color;
/*      */ import com.badlogic.gdx.graphics.g2d.Batch;
/*      */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Pool;
/*      */ import com.badlogic.gdx.utils.Pools;
/*      */ import com.badlogic.gdx.utils.SnapshotArray;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ import com.prineside.tdi2.scene2d.Group;
/*      */ import com.prineside.tdi2.scene2d.Touchable;
/*      */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*      */ import com.prineside.tdi2.scene2d.utils.Layout;
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
/*      */ public class Table
/*      */   extends WidgetGroup
/*      */ {
/*   48 */   public static Color debugTableColor = new Color(0.0F, 0.0F, 1.0F, 1.0F);
/*   49 */   public static Color debugCellColor = new Color(1.0F, 0.0F, 0.0F, 1.0F);
/*   50 */   public static Color debugActorColor = new Color(0.0F, 1.0F, 0.0F, 1.0F);
/*      */   
/*   52 */   private static Pool<Cell> k = new Pool<Cell>() {
/*      */       private static Cell a() {
/*   54 */         return new Cell<>();
/*      */       }
/*      */     };
/*      */   private static float[] l;
/*      */   private static float[] n;
/*      */   private int o;
/*      */   private int p;
/*      */   private boolean q;
/*   62 */   private final Array<Cell> r = new Array(4);
/*      */   private final Cell s;
/*   64 */   private final Array<Cell> t = new Array(2); private Cell u; private boolean v = true; private float[] w; private float[] x;
/*      */   private float[] y;
/*      */   private float[] z;
/*      */   private float A;
/*      */   private float B;
/*      */   private float C;
/*      */   private float D;
/*      */   private float[] E;
/*      */   private float[] F;
/*      */   private float[] G;
/*      */   private float[] H;
/*   75 */   private Value I = backgroundTop; private Value J = backgroundLeft; private Value K = backgroundBottom; private Value L = backgroundRight;
/*   76 */   private int M = 1;
/*      */   
/*   78 */   private Debug N = Debug.none;
/*      */   private Array<DebugRect> O;
/*      */   @Null
/*      */   Drawable m;
/*      */   private boolean P;
/*      */   private boolean Q = true;
/*      */   
/*      */   public Table() {
/*   86 */     this.s = d();
/*      */     
/*   88 */     setTransform(false);
/*   89 */     setTouchable(Touchable.childrenOnly);
/*      */   }
/*      */   
/*      */   private Cell d() {
/*      */     Cell<Actor> cell;
/*   94 */     (cell = (Cell<Actor>)k.obtain()).setTable(this);
/*   95 */     return cell;
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*   99 */     validate();
/*  100 */     if (isTransform()) {
/*  101 */       a(paramBatch, b());
/*  102 */       a(paramBatch, paramFloat, 0.0F, 0.0F);
/*  103 */       if (this.P) {
/*  104 */         paramBatch.flush();
/*  105 */         float f1 = this.J.get((Actor)this), f2 = this.K.get((Actor)this);
/*  106 */         if (clipBegin(f1, f2, getWidth() - f1 - this.L.get((Actor)this), 
/*  107 */             getHeight() - f2 - this.I.get((Actor)this))) {
/*  108 */           a(paramBatch, paramFloat);
/*  109 */           paramBatch.flush();
/*  110 */           clipEnd();
/*      */         } 
/*      */       } else {
/*  113 */         a(paramBatch, paramFloat);
/*  114 */       }  a(paramBatch); return;
/*      */     } 
/*  116 */     a(paramBatch, paramFloat, getX(), getY());
/*  117 */     super.draw(paramBatch, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  124 */     if (this.m == null)
/*  125 */       return;  Color color = getColor();
/*  126 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat1);
/*  127 */     this.m.draw(paramBatch, paramFloat2, paramFloat3, getWidth(), getHeight());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setBackground(@Null Drawable paramDrawable) {
/*  132 */     if (this.m == paramDrawable)
/*  133 */       return;  float f2 = getPadTop(), f3 = getPadLeft(), f4 = getPadBottom(), f5 = getPadRight();
/*  134 */     this.m = paramDrawable;
/*  135 */     float f1 = getPadTop(), f6 = getPadLeft(), f7 = getPadBottom(), f8 = getPadRight();
/*  136 */     if (f2 + f4 != f1 + f7 || f3 + f5 != f6 + f8) {
/*  137 */       invalidateHierarchy(); return;
/*  138 */     }  if (f2 != f1 || f3 != f6 || f4 != f7 || f5 != f8) {
/*  139 */       invalidate();
/*      */     }
/*      */   }
/*      */   
/*      */   public Table background(@Null Drawable paramDrawable) {
/*  144 */     setBackground(paramDrawable);
/*  145 */     return this;
/*      */   }
/*      */   @Null
/*      */   public Drawable getBackground() {
/*  149 */     return this.m;
/*      */   }
/*      */   @Null
/*      */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  153 */     if (this.P) {
/*  154 */       if (paramBoolean && getTouchable() == Touchable.disabled) return null; 
/*  155 */       if (paramFloat1 < 0.0F || paramFloat1 >= getWidth() || paramFloat2 < 0.0F || paramFloat2 >= getHeight()) return null; 
/*      */     } 
/*  157 */     return super.hit(paramFloat1, paramFloat2, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public Table clip() {
/*  162 */     setClip(true);
/*  163 */     return this;
/*      */   }
/*      */   
/*      */   public Table clip(boolean paramBoolean) {
/*  167 */     setClip(paramBoolean);
/*  168 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setClip(boolean paramBoolean) {
/*  174 */     this.P = paramBoolean;
/*  175 */     setTransform(paramBoolean);
/*  176 */     invalidate();
/*      */   }
/*      */   
/*      */   public boolean getClip() {
/*  180 */     return this.P;
/*      */   }
/*      */   
/*      */   public void invalidate() {
/*  184 */     this.v = true;
/*  185 */     super.invalidate();
/*      */   }
/*      */ 
/*      */   
/*      */   public <T extends Actor> Cell<T> add(@Null T paramT) {
/*      */     Cell<T> cell;
/*  191 */     (cell = d()).w = (Actor)paramT;
/*      */ 
/*      */     
/*  194 */     if (this.q) {
/*  195 */       this.q = false;
/*  196 */       this.p--;
/*  197 */       ((Cell)this.r.peek()).B = false;
/*      */     } 
/*      */     
/*      */     int i;
/*  201 */     if ((i = this.r.size) > 0) {
/*      */       Cell cell1;
/*      */       
/*  204 */       if (!(cell1 = (Cell)this.r.peek()).B) {
/*  205 */         cell1.C += cell1.t.intValue();
/*  206 */         cell.D = cell1.D;
/*      */       } else {
/*  208 */         cell.C = 0;
/*  209 */         cell1.D++;
/*      */       } 
/*      */       
/*  212 */       if (cell.D > 0) {
/*  213 */         Object[] arrayOfObject = this.r.items;
/*      */         
/*  215 */         for (; --i >= 0; i--) {
/*      */           Cell cell2; int k;
/*  217 */           for (int j = (k = (cell2 = (Cell)arrayOfObject[i]).C) + cell2.t.intValue(); k < j; k++) {
/*  218 */             if (k == cell.C) {
/*  219 */               cell.E = i;
/*      */               // Byte code: goto -> 223
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*  226 */       cell.C = 0;
/*  227 */       cell.D = 0;
/*      */     } 
/*  229 */     this.r.add(cell);
/*      */     
/*  231 */     cell.a(this.s);
/*  232 */     if (cell.C < this.t.size) cell.b((Cell)this.t.get(cell.C)); 
/*  233 */     cell.b(this.u);
/*      */     
/*  235 */     if (paramT != null) addActor((Actor)paramT);
/*      */     
/*  237 */     return cell;
/*      */   } public Table add(Actor... paramVarArgs) {
/*      */     byte b;
/*      */     int i;
/*  241 */     for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  242 */       add(paramVarArgs[b]); 
/*  243 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell add() {
/*  248 */     return add((Actor)null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<Stack> stack(@Null Actor... paramVarArgs) {
/*  254 */     Stack stack = new Stack();
/*  255 */     if (paramVarArgs != null) {
/*  256 */       byte b; int i; for (b = 0, i = paramVarArgs.length; b < i; b++)
/*  257 */         stack.addActor(paramVarArgs[b]); 
/*      */     } 
/*  259 */     return add(stack);
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor) {
/*  263 */     return removeActor(paramActor, true);
/*      */   }
/*      */   
/*      */   public boolean removeActor(Actor paramActor, boolean paramBoolean) {
/*  267 */     if (!super.removeActor(paramActor, paramBoolean)) return false; 
/*      */     Cell<Actor> cell;
/*  269 */     if ((cell = getCell(paramActor)) != null) cell.w = null; 
/*  270 */     return true;
/*      */   }
/*      */   
/*      */   public Actor removeActorAt(int paramInt, boolean paramBoolean) {
/*  274 */     Actor actor = super.removeActorAt(paramInt, paramBoolean);
/*      */     Cell<Actor> cell;
/*  276 */     if ((cell = getCell(actor)) != null) cell.w = null; 
/*  277 */     return actor;
/*      */   }
/*      */ 
/*      */   
/*      */   public void clearChildren(boolean paramBoolean) {
/*  282 */     Object[] arrayOfObject = this.r.items;
/*  283 */     for (int i = this.r.size - 1; i >= 0; i--) {
/*      */       Cell cell;
/*      */       Actor actor;
/*  286 */       if ((actor = (cell = (Cell)arrayOfObject[i]).w) != null) actor.remove(); 
/*      */     } 
/*  288 */     k.freeAll(this.r);
/*  289 */     this.r.clear();
/*  290 */     this.p = 0;
/*  291 */     this.o = 0;
/*  292 */     if (this.u != null) k.free(this.u); 
/*  293 */     this.u = null;
/*  294 */     this.q = false;
/*      */     
/*  296 */     super.clearChildren(paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void reset() {
/*  302 */     clearChildren();
/*  303 */     this.I = backgroundTop;
/*  304 */     this.J = backgroundLeft;
/*  305 */     this.K = backgroundBottom;
/*  306 */     this.L = backgroundRight;
/*  307 */     this.M = 1;
/*  308 */     debug(Debug.none);
/*  309 */     this.s.reset(); byte b; int i;
/*  310 */     for (b = 0, i = this.t.size; b < i; b++) {
/*      */       Cell cell;
/*  312 */       if ((cell = (Cell)this.t.get(b)) != null) k.free(cell); 
/*      */     } 
/*  314 */     this.t.clear();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell row() {
/*  320 */     if (this.r.size > 0) {
/*  321 */       if (!this.q) {
/*  322 */         if (((Cell)this.r.peek()).B) return this.u; 
/*  323 */         e();
/*      */       } 
/*  325 */       invalidate();
/*      */     } 
/*  327 */     this.q = false;
/*  328 */     if (this.u != null) k.free(this.u); 
/*  329 */     this.u = d();
/*  330 */     this.u.a();
/*  331 */     return this.u;
/*      */   }
/*      */   
/*      */   private void e() {
/*  335 */     Object[] arrayOfObject = this.r.items;
/*  336 */     int i = 0; Cell cell;
/*  337 */     for (int j = this.r.size - 1; j >= 0 && 
/*      */       
/*  339 */       !(cell = (Cell)arrayOfObject[j]).B; j--) {
/*  340 */       i += cell.t.intValue();
/*      */     }
/*  342 */     this.o = Math.max(this.o, i);
/*  343 */     this.p++;
/*  344 */     ((Cell)this.r.peek()).B = true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell columnDefaults(int paramInt) {
/*      */     Cell<Actor> cell;
/*  351 */     if ((cell = (Cell<Actor>)((this.t.size > paramInt) ? this.t.get(paramInt) : null)) == null) {
/*      */       
/*  353 */       (cell = d()).a();
/*  354 */       if (paramInt >= this.t.size) {
/*  355 */         for (int i = this.t.size; i < paramInt; i++)
/*  356 */           this.t.add(null); 
/*  357 */         this.t.add(cell);
/*      */       } else {
/*  359 */         this.t.set(paramInt, cell);
/*      */       } 
/*  361 */     }  return cell;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public <T extends Actor> Cell<T> getCell(T paramT) {
/*  366 */     if (paramT == null) throw new IllegalArgumentException("actor cannot be null."); 
/*  367 */     Object[] arrayOfObject = this.r.items; byte b; int i;
/*  368 */     for (b = 0, i = this.r.size; b < i; b++) {
/*      */       Cell<T> cell;
/*  370 */       if ((cell = (Cell)arrayOfObject[b]).w == paramT) return cell; 
/*      */     } 
/*  372 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public Array<Cell> getCells() {
/*  377 */     return this.r;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  381 */     if (this.v) f(); 
/*  382 */     float f = this.C;
/*  383 */     if (this.m != null) return Math.max(f, this.m.getMinWidth()); 
/*  384 */     return f;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  388 */     if (this.v) f(); 
/*  389 */     float f = this.D;
/*  390 */     if (this.m != null) return Math.max(f, this.m.getMinHeight()); 
/*  391 */     return f;
/*      */   }
/*      */   
/*      */   public float getMinWidth() {
/*  395 */     if (this.v) f(); 
/*  396 */     return this.A;
/*      */   }
/*      */   
/*      */   public float getMinHeight() {
/*  400 */     if (this.v) f(); 
/*  401 */     return this.B;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell defaults() {
/*  406 */     return this.s;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table pad(Value paramValue) {
/*  411 */     if (paramValue == null) throw new IllegalArgumentException("pad cannot be null."); 
/*  412 */     this.I = paramValue;
/*  413 */     this.J = paramValue;
/*  414 */     this.K = paramValue;
/*  415 */     this.L = paramValue;
/*  416 */     this.v = true;
/*  417 */     return this;
/*      */   }
/*      */   
/*      */   public Table pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/*  421 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/*  422 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/*  423 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/*  424 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/*  425 */     this.I = paramValue1;
/*  426 */     this.J = paramValue2;
/*  427 */     this.K = paramValue3;
/*  428 */     this.L = paramValue4;
/*  429 */     this.v = true;
/*  430 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padTop(Value paramValue) {
/*  435 */     if (paramValue == null) throw new IllegalArgumentException("padTop cannot be null."); 
/*  436 */     this.I = paramValue;
/*  437 */     this.v = true;
/*  438 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padLeft(Value paramValue) {
/*  443 */     if (paramValue == null) throw new IllegalArgumentException("padLeft cannot be null."); 
/*  444 */     this.J = paramValue;
/*  445 */     this.v = true;
/*  446 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padBottom(Value paramValue) {
/*  451 */     if (paramValue == null) throw new IllegalArgumentException("padBottom cannot be null."); 
/*  452 */     this.K = paramValue;
/*  453 */     this.v = true;
/*  454 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padRight(Value paramValue) {
/*  459 */     if (paramValue == null) throw new IllegalArgumentException("padRight cannot be null."); 
/*  460 */     this.L = paramValue;
/*  461 */     this.v = true;
/*  462 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table pad(float paramFloat) {
/*  467 */     pad(Value.Fixed.valueOf(paramFloat));
/*  468 */     return this;
/*      */   }
/*      */   
/*      */   public Table pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  472 */     this.I = Value.Fixed.valueOf(paramFloat1);
/*  473 */     this.J = Value.Fixed.valueOf(paramFloat2);
/*  474 */     this.K = Value.Fixed.valueOf(paramFloat3);
/*  475 */     this.L = Value.Fixed.valueOf(paramFloat4);
/*  476 */     this.v = true;
/*  477 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padTop(float paramFloat) {
/*  482 */     this.I = Value.Fixed.valueOf(paramFloat);
/*  483 */     this.v = true;
/*  484 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padLeft(float paramFloat) {
/*  489 */     this.J = Value.Fixed.valueOf(paramFloat);
/*  490 */     this.v = true;
/*  491 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padBottom(float paramFloat) {
/*  496 */     this.K = Value.Fixed.valueOf(paramFloat);
/*  497 */     this.v = true;
/*  498 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table padRight(float paramFloat) {
/*  503 */     this.L = Value.Fixed.valueOf(paramFloat);
/*  504 */     this.v = true;
/*  505 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Table align(int paramInt) {
/*  511 */     this.M = paramInt;
/*  512 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table center() {
/*  517 */     this.M = 1;
/*  518 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table top() {
/*  523 */     this.M |= 0x2;
/*  524 */     this.M &= 0xFFFFFFFB;
/*  525 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table left() {
/*  530 */     this.M |= 0x8;
/*  531 */     this.M &= 0xFFFFFFEF;
/*  532 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table bottom() {
/*  537 */     this.M |= 0x4;
/*  538 */     this.M &= 0xFFFFFFFD;
/*  539 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table right() {
/*  544 */     this.M |= 0x10;
/*  545 */     this.M &= 0xFFFFFFF7;
/*  546 */     return this;
/*      */   }
/*      */   
/*      */   public void setDebug(boolean paramBoolean) {
/*  550 */     debug(paramBoolean ? Debug.all : Debug.none);
/*      */   }
/*      */   
/*      */   public Table debug() {
/*  554 */     super.debug();
/*  555 */     return this;
/*      */   }
/*      */   
/*      */   public Table debugAll() {
/*  559 */     super.debugAll();
/*  560 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debugTable() {
/*  565 */     super.setDebug(true);
/*  566 */     if (this.N != Debug.table) {
/*  567 */       this.N = Debug.table;
/*  568 */       invalidate();
/*      */     } 
/*  570 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debugCell() {
/*  575 */     super.setDebug(true);
/*  576 */     if (this.N != Debug.cell) {
/*  577 */       this.N = Debug.cell;
/*  578 */       invalidate();
/*      */     } 
/*  580 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debugActor() {
/*  585 */     super.setDebug(true);
/*  586 */     if (this.N != Debug.actor) {
/*  587 */       this.N = Debug.actor;
/*  588 */       invalidate();
/*      */     } 
/*  590 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Table debug(Debug paramDebug) {
/*  595 */     super.setDebug((paramDebug != Debug.none));
/*  596 */     if (this.N != paramDebug) {
/*  597 */       this.N = paramDebug;
/*  598 */       if (paramDebug == Debug.none) {
/*  599 */         g();
/*      */       } else {
/*  601 */         invalidate();
/*      */       } 
/*  603 */     }  return this;
/*      */   }
/*      */   
/*      */   public Debug getTableDebug() {
/*  607 */     return this.N;
/*      */   }
/*      */   
/*      */   public Value getPadTopValue() {
/*  611 */     return this.I;
/*      */   }
/*      */   
/*      */   public float getPadTop() {
/*  615 */     return this.I.get((Actor)this);
/*      */   }
/*      */   
/*      */   public Value getPadLeftValue() {
/*  619 */     return this.J;
/*      */   }
/*      */   
/*      */   public float getPadLeft() {
/*  623 */     return this.J.get((Actor)this);
/*      */   }
/*      */   
/*      */   public Value getPadBottomValue() {
/*  627 */     return this.K;
/*      */   }
/*      */   
/*      */   public float getPadBottom() {
/*  631 */     return this.K.get((Actor)this);
/*      */   }
/*      */   
/*      */   public Value getPadRightValue() {
/*  635 */     return this.L;
/*      */   }
/*      */   
/*      */   public float getPadRight() {
/*  639 */     return this.L.get((Actor)this);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadX() {
/*  644 */     return this.J.get((Actor)this) + this.L.get((Actor)this);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadY() {
/*  649 */     return this.I.get((Actor)this) + this.K.get((Actor)this);
/*      */   }
/*      */   
/*      */   public int getAlign() {
/*  653 */     return this.M;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRow(float paramFloat) {
/*      */     int i;
/*  660 */     if ((i = this.r.size) == 0) return -1; 
/*  661 */     paramFloat += getPadTop();
/*  662 */     Object[] arrayOfObject = this.r.items;
/*  663 */     for (byte b1 = 0, b2 = 0; b1 < i; ) {
/*      */       Cell cell;
/*  665 */       if ((cell = (Cell)arrayOfObject[b1++]).y + cell.F < paramFloat) return b2; 
/*  666 */       if (cell.B) b2++; 
/*      */     } 
/*  668 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setRound(boolean paramBoolean) {
/*  673 */     this.Q = paramBoolean;
/*      */   }
/*      */   
/*      */   public int getRows() {
/*  677 */     return this.p;
/*      */   }
/*      */   
/*      */   public int getColumns() {
/*  681 */     return this.o;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRowHeight(int paramInt) {
/*  686 */     if (this.F == null) return 0.0F; 
/*  687 */     return this.F[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRowMinHeight(int paramInt) {
/*  692 */     if (this.v) f(); 
/*  693 */     return this.x[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRowPrefHeight(int paramInt) {
/*  698 */     if (this.v) f(); 
/*  699 */     return this.z[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnWidth(int paramInt) {
/*  704 */     if (this.E == null) return 0.0F; 
/*  705 */     return this.E[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnMinWidth(int paramInt) {
/*  710 */     if (this.v) f(); 
/*  711 */     return this.w[paramInt];
/*      */   }
/*      */ 
/*      */   
/*      */   public float getColumnPrefWidth(int paramInt) {
/*  716 */     if (this.v) f(); 
/*  717 */     return this.y[paramInt];
/*      */   }
/*      */   
/*      */   private static float[] a(float[] paramArrayOffloat, int paramInt) {
/*  721 */     if (paramArrayOffloat == null || paramArrayOffloat.length < paramInt) return new float[paramInt]; 
/*  722 */     Arrays.fill(paramArrayOffloat, 0, paramInt, 0.0F);
/*  723 */     return paramArrayOffloat;
/*      */   }
/*      */   
/*      */   private void f() {
/*  727 */     this.v = false;
/*      */     
/*  729 */     Object[] arrayOfObject = this.r.items;
/*      */     
/*      */     int i;
/*      */     
/*  733 */     if ((i = this.r.size) > 0 && !((Cell)arrayOfObject[i - 1]).B) {
/*  734 */       e();
/*  735 */       this.q = true;
/*      */     } 
/*      */     
/*  738 */     int j = this.o, k = this.p;
/*  739 */     float[] arrayOfFloat1 = this.w = a(this.w, j);
/*  740 */     float[] arrayOfFloat2 = this.x = a(this.x, k);
/*  741 */     float[] arrayOfFloat3 = this.y = a(this.y, j);
/*  742 */     float[] arrayOfFloat4 = this.z = a(this.z, k);
/*  743 */     this.E = a(this.E, j);
/*  744 */     this.F = a(this.F, k);
/*  745 */     float[] arrayOfFloat5 = this.G = a(this.G, j);
/*  746 */     float[] arrayOfFloat6 = this.H = a(this.H, k);
/*      */     
/*  748 */     float f1 = 0.0F;
/*  749 */     for (byte b2 = 0; b2 < i; b2++) {
/*      */       Cell cell;
/*  751 */       int m = (cell = (Cell)arrayOfObject[b2]).C, n = cell.D, i1 = cell.t.intValue();
/*  752 */       Actor actor = cell.w;
/*      */ 
/*      */       
/*  755 */       if (cell.s.intValue() != 0 && arrayOfFloat6[n] == 0.0F) arrayOfFloat6[n] = cell.s.intValue(); 
/*  756 */       if (i1 == 1 && cell.r.intValue() != 0 && arrayOfFloat5[m] == 0.0F) arrayOfFloat5[m] = cell.r.intValue();
/*      */ 
/*      */ 
/*      */       
/*  760 */       cell.G = cell.l.get(actor) + ((m == 0) ? 0.0F : Math.max(0.0F, cell.h.get(actor) - f1));
/*  761 */       cell.F = cell.k.get(actor);
/*  762 */       if (cell.E != -1) {
/*  763 */         Cell cell1 = (Cell)arrayOfObject[cell.E];
/*  764 */         cell.F += Math.max(0.0F, cell.g.get(actor) - cell1.i.get(actor));
/*      */       } 
/*  766 */       f1 = cell.j.get(actor);
/*  767 */       cell.I = cell.n.get(actor) + ((m + i1 == j) ? 0.0F : f1);
/*  768 */       cell.H = cell.m.get(actor) + ((n == k - 1) ? 0.0F : cell.i.get(actor));
/*  769 */       f1 = f1;
/*      */ 
/*      */       
/*  772 */       float f9 = cell.c.get(actor), f10 = cell.d.get(actor);
/*  773 */       float f11 = cell.a.get(actor), f12 = cell.b.get(actor);
/*  774 */       float f13 = cell.e.get(actor), f8 = cell.f.get(actor);
/*  775 */       if (f9 < f11) f9 = f11; 
/*  776 */       if (f10 < f12) f10 = f12; 
/*  777 */       if (f13 > 0.0F && f9 > f13) f9 = f13; 
/*  778 */       if (f8 > 0.0F && f10 > f8) f10 = f8; 
/*  779 */       if (this.Q) {
/*  780 */         f11 = (float)Math.ceil(f11);
/*  781 */         f12 = (float)Math.ceil(f12);
/*  782 */         f9 = (float)Math.ceil(f9);
/*  783 */         f10 = (float)Math.ceil(f10);
/*      */       } 
/*      */       
/*  786 */       if (i1 == 1) {
/*  787 */         f13 = cell.G + cell.I;
/*  788 */         arrayOfFloat3[m] = Math.max(arrayOfFloat3[m], f9 + f13);
/*  789 */         arrayOfFloat1[m] = Math.max(arrayOfFloat1[m], f11 + f13);
/*      */       } 
/*  791 */       f13 = cell.F + cell.H;
/*  792 */       arrayOfFloat4[n] = Math.max(arrayOfFloat4[n], f10 + f13);
/*  793 */       arrayOfFloat2[n] = Math.max(arrayOfFloat2[n], f12 + f13);
/*      */     } 
/*      */     
/*  796 */     float f2 = 0.0F, f3 = 0.0F;
/*  797 */     float f4 = 0.0F, f5 = 0.0F; byte b3;
/*  798 */     label129: for (b3 = 0; b3 < i; b3++) {
/*      */       Cell cell;
/*  800 */       int m = (cell = (Cell)arrayOfObject[b3]).C;
/*      */ 
/*      */       
/*      */       int n;
/*      */       
/*  805 */       if ((n = cell.r.intValue()) != 0) {
/*  806 */         int i1 = m + cell.t.intValue(); int i2;
/*  807 */         for (i2 = m; i2 < i1; ) {
/*  808 */           if (arrayOfFloat5[i2] == 0.0F) { i2++; continue; }  continue label129;
/*  809 */         }  for (i2 = m; i2 < i1; i2++) {
/*  810 */           arrayOfFloat5[i2] = n;
/*      */         }
/*      */       } 
/*      */       
/*  814 */       if (cell.u == Boolean.TRUE && cell.t.intValue() == 1) {
/*  815 */         float f = cell.G + cell.I;
/*  816 */         f2 = Math.max(f2, arrayOfFloat1[m] - f);
/*  817 */         f4 = Math.max(f4, arrayOfFloat3[m] - f);
/*      */       } 
/*  819 */       if (cell.v == Boolean.TRUE) {
/*  820 */         float f = cell.F + cell.H;
/*  821 */         f3 = Math.max(f3, arrayOfFloat2[cell.D] - f);
/*  822 */         f5 = Math.max(f5, arrayOfFloat4[cell.D] - f);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  827 */     if (f4 > 0.0F || f5 > 0.0F) {
/*  828 */       for (b3 = 0; b3 < i; b3++) {
/*  829 */         Cell cell = (Cell)arrayOfObject[b3];
/*  830 */         if (f4 > 0.0F && cell.u == Boolean.TRUE && cell.t.intValue() == 1) {
/*  831 */           f1 = cell.G + cell.I;
/*  832 */           arrayOfFloat1[cell.C] = f2 + f1;
/*  833 */           arrayOfFloat3[cell.C] = f4 + f1;
/*      */         } 
/*  835 */         if (f5 > 0.0F && cell.v == Boolean.TRUE) {
/*  836 */           f1 = cell.F + cell.H;
/*  837 */           arrayOfFloat2[cell.D] = f3 + f1;
/*  838 */           arrayOfFloat4[cell.D] = f5 + f1;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  844 */     for (b3 = 0; b3 < i; b3++) {
/*      */       int m;
/*      */       Cell cell;
/*  847 */       if ((m = (cell = (Cell)arrayOfObject[b3]).t.intValue()) != 1) {
/*  848 */         int i4 = cell.C;
/*      */         
/*  850 */         Actor actor = cell.w;
/*  851 */         float f12 = cell.a.get(actor), f13 = cell.c.get(actor), f14 = cell.e.get(actor);
/*  852 */         if (f13 < f12) f13 = f12; 
/*  853 */         if (f14 > 0.0F && f13 > f14) f13 = f14; 
/*  854 */         if (this.Q) {
/*  855 */           f12 = (float)Math.ceil(f12);
/*  856 */           f13 = (float)Math.ceil(f13);
/*      */         } 
/*      */         
/*  859 */         float f11 = -(cell.G + cell.I);
/*  860 */         float f8 = 0.0F; int n;
/*  861 */         for (int i1 = (n = i4) + m; n < i1; n++) {
/*  862 */           f11 += arrayOfFloat1[n];
/*  863 */           f14 += arrayOfFloat3[n];
/*  864 */           f8 += arrayOfFloat5[n];
/*      */         } 
/*      */         
/*  867 */         float f9 = Math.max(0.0F, f12 - f11);
/*  868 */         float f10 = Math.max(0.0F, f13 - f14); int i2;
/*  869 */         for (int i3 = (i2 = i4) + m; i2 < i3; i2++) {
/*  870 */           f11 = (f8 == 0.0F) ? (1.0F / m) : (arrayOfFloat5[i2] / f8);
/*  871 */           arrayOfFloat1[i2] = arrayOfFloat1[i2] + f9 * f11;
/*  872 */           arrayOfFloat3[i2] = arrayOfFloat3[i2] + f10 * f11;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  877 */     float f6 = this.J.get((Actor)this) + this.L.get((Actor)this);
/*  878 */     float f7 = this.I.get((Actor)this) + this.K.get((Actor)this);
/*  879 */     this.A = f6;
/*  880 */     this.C = f6; byte b1;
/*  881 */     for (b1 = 0; b1 < j; b1++) {
/*  882 */       this.A += arrayOfFloat1[b1];
/*  883 */       this.C += arrayOfFloat3[b1];
/*      */     } 
/*  885 */     this.B = f7;
/*  886 */     this.D = f7;
/*  887 */     for (b1 = 0; b1 < k; b1++) {
/*  888 */       this.B += arrayOfFloat2[b1];
/*  889 */       this.D += Math.max(arrayOfFloat2[b1], arrayOfFloat4[b1]);
/*      */     } 
/*  891 */     this.C = Math.max(this.A, this.C);
/*  892 */     this.D = Math.max(this.B, this.D);
/*      */   }
/*      */ 
/*      */   
/*      */   public void layout() {
/*      */     float[] arrayOfFloat3, arrayOfFloat4;
/*  898 */     if (this.v) f();
/*      */     
/*  900 */     float f1 = getWidth(), f2 = getHeight();
/*  901 */     int i = this.o, j = this.p;
/*  902 */     float[] arrayOfFloat1 = this.E, arrayOfFloat2 = this.F;
/*  903 */     float f3, f4 = (f3 = this.J.get((Actor)this)) + this.L.get((Actor)this);
/*  904 */     float f5, f6 = (f5 = this.I.get((Actor)this)) + this.K.get((Actor)this);
/*      */ 
/*      */     
/*      */     float f7;
/*      */     
/*  909 */     if ((f7 = this.C - this.A) == 0.0F) {
/*  910 */       arrayOfFloat3 = this.w;
/*      */     } else {
/*  912 */       float f = Math.min(f7, Math.max(0.0F, f1 - this.A));
/*  913 */       arrayOfFloat3 = l = a(l, i);
/*  914 */       float[] arrayOfFloat7 = this.w, arrayOfFloat8 = this.y;
/*  915 */       for (byte b = 0; b < i; b++) {
/*      */         
/*  917 */         float f14, f15 = (f14 = arrayOfFloat8[b] - arrayOfFloat7[b]) / f7;
/*  918 */         arrayOfFloat3[b] = arrayOfFloat7[b] + f * f15;
/*      */       } 
/*      */     } 
/*      */     
/*      */     float f8;
/*      */     
/*  924 */     if ((f8 = this.D - this.B) == 0.0F) {
/*  925 */       arrayOfFloat4 = this.x;
/*      */     } else {
/*  927 */       arrayOfFloat4 = n = a(n, j);
/*  928 */       float f = Math.min(f8, Math.max(0.0F, f2 - this.B));
/*  929 */       float[] arrayOfFloat7 = this.x, arrayOfFloat8 = this.z;
/*  930 */       for (byte b = 0; b < j; b++) {
/*      */         
/*  932 */         float f14 = (f7 = arrayOfFloat8[b] - arrayOfFloat7[b]) / f8;
/*  933 */         arrayOfFloat4[b] = arrayOfFloat7[b] + f * f14;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  938 */     Object[] arrayOfObject = this.r.items;
/*  939 */     int k = this.r.size;
/*  940 */     for (byte b1 = 0; b1 < k; b1++) {
/*      */       Cell cell;
/*  942 */       int i1 = (cell = (Cell)arrayOfObject[b1]).C, i2 = cell.D;
/*  943 */       Actor actor = cell.w;
/*      */       
/*  945 */       float f14 = 0.0F;
/*  946 */       int i3 = cell.t.intValue(); int i4;
/*  947 */       for (int i5 = (i4 = i1) + i3; i4 < i5; i4++)
/*  948 */         f14 += arrayOfFloat3[i4]; 
/*  949 */       float f15 = arrayOfFloat4[i2];
/*      */       
/*  951 */       float f16 = cell.c.get(actor), f17 = cell.d.get(actor);
/*  952 */       float f18 = cell.a.get(actor), f19 = cell.b.get(actor);
/*  953 */       float f20 = cell.e.get(actor), f21 = cell.f.get(actor);
/*  954 */       if (f16 < f18) f16 = f18; 
/*  955 */       if (f17 < f19) f17 = f19; 
/*  956 */       if (f20 > 0.0F && f16 > f20) f16 = f20; 
/*  957 */       if (f21 > 0.0F && f17 > f21) f17 = f21;
/*      */       
/*  959 */       cell.z = Math.min(f14 - cell.G - cell.I, f16);
/*  960 */       cell.A = Math.min(f15 - cell.F - cell.H, f17);
/*      */       
/*  962 */       if (i3 == 1) arrayOfFloat1[i1] = Math.max(arrayOfFloat1[i1], f14); 
/*  963 */       arrayOfFloat2[i2] = Math.max(arrayOfFloat2[i2], f15);
/*      */     } 
/*      */ 
/*      */     
/*  967 */     float[] arrayOfFloat5 = this.G, arrayOfFloat6 = this.H;
/*  968 */     f7 = 0.0F; byte b2;
/*  969 */     for (b2 = 0; b2 < i; b2++)
/*  970 */       f7 += arrayOfFloat5[b2]; 
/*  971 */     if (f7 > 0.0F) {
/*  972 */       float f = f1 - f4;
/*  973 */       for (byte b = 0; b < i; b++)
/*  974 */         f -= arrayOfFloat1[b]; 
/*  975 */       if (f > 0.0F) {
/*  976 */         float f14 = 0.0F;
/*  977 */         byte b5 = 0;
/*  978 */         for (byte b6 = 0; b6 < i; b6++) {
/*  979 */           if (arrayOfFloat5[b6] != 0.0F) {
/*  980 */             float f15 = f * arrayOfFloat5[b6] / f7;
/*  981 */             arrayOfFloat1[b6] = arrayOfFloat1[b6] + f15;
/*  982 */             f14 += f15;
/*  983 */             b5 = b6;
/*      */           } 
/*  985 */         }  arrayOfFloat1[b5] = arrayOfFloat1[b5] + f - f14;
/*      */       } 
/*      */     } 
/*      */     
/*  989 */     f7 = 0.0F;
/*  990 */     for (b2 = 0; b2 < j; b2++)
/*  991 */       f7 += arrayOfFloat6[b2]; 
/*  992 */     if (f7 > 0.0F) {
/*  993 */       float f = f2 - f6;
/*  994 */       for (byte b = 0; b < j; b++)
/*  995 */         f -= arrayOfFloat2[b]; 
/*  996 */       if (f > 0.0F) {
/*  997 */         float f14 = 0.0F;
/*  998 */         byte b5 = 0;
/*  999 */         for (byte b6 = 0; b6 < j; b6++) {
/* 1000 */           if (arrayOfFloat6[b6] != 0.0F) {
/* 1001 */             float f15 = f * arrayOfFloat6[b6] / f7;
/* 1002 */             arrayOfFloat2[b6] = arrayOfFloat2[b6] + f15;
/* 1003 */             f14 += f15;
/* 1004 */             b5 = b6;
/*      */           } 
/* 1006 */         }  arrayOfFloat2[b5] = arrayOfFloat2[b5] + f - f14;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1011 */     for (b2 = 0; b2 < k; b2++) {
/*      */       Cell cell;
/*      */       int i1;
/* 1014 */       if ((i1 = (cell = (Cell)arrayOfObject[b2]).t.intValue()) != 1) {
/*      */         
/* 1016 */         float f = 0.0F; int i2, i3;
/* 1017 */         for (i3 = (i2 = cell.C) + i1; i2 < i3; i2++) {
/* 1018 */           f += arrayOfFloat3[i2] - arrayOfFloat1[i2];
/*      */         }
/*      */ 
/*      */         
/* 1022 */         if ((f = (f = f - Math.max(0.0F, cell.G + cell.I)) / i1) > 0.0F) {
/* 1023 */           for (i3 = (i2 = cell.C) + i1; i2 < i3; i2++) {
/* 1024 */             arrayOfFloat1[i2] = arrayOfFloat1[i2] + f;
/*      */           }
/*      */         }
/*      */       } 
/*      */     } 
/* 1029 */     float f9 = f4; f8 = f6; int m;
/* 1030 */     for (m = 0; m < i; m++)
/* 1031 */       f9 += arrayOfFloat1[m]; 
/* 1032 */     for (m = 0; m < j; m++) {
/* 1033 */       f8 += arrayOfFloat2[m];
/*      */     }
/*      */     
/* 1036 */     m = this.M;
/* 1037 */     float f10 = f3;
/* 1038 */     if ((m & 0x10) != 0) {
/* 1039 */       f10 = f3 + f1 - f9;
/* 1040 */     } else if ((m & 0x8) == 0) {
/* 1041 */       f10 = f3 + (f1 - f9) / 2.0F;
/*      */     } 
/* 1043 */     float f11 = f5;
/* 1044 */     if ((m & 0x4) != 0) {
/* 1045 */       f11 = f5 + f2 - f8;
/* 1046 */     } else if ((m & 0x2) == 0) {
/* 1047 */       f11 = f5 + (f2 - f8) / 2.0F;
/*      */     } 
/*      */     
/* 1050 */     float f12 = f10, f13 = f11;
/* 1051 */     for (byte b3 = 0; b3 < k; b3++) {
/* 1052 */       Cell cell = (Cell)arrayOfObject[b3];
/*      */       
/* 1054 */       float f16 = 0.0F; int i2;
/* 1055 */       for (int i1 = (i2 = cell.C) + cell.t.intValue(); i2 < i1; i2++)
/* 1056 */         f16 += arrayOfFloat1[i2]; 
/* 1057 */       f16 -= cell.G + cell.I;
/*      */       
/* 1059 */       f12 += cell.G;
/*      */       
/* 1061 */       float f17 = cell.o.floatValue(), f14 = cell.p.floatValue();
/*      */       
/* 1063 */       cell.z = Math.max(f16 * f17, cell.a.get(cell.w));
/*      */       float f15;
/* 1065 */       if (f17 > 0.0F && (f15 = cell.e.get(cell.w)) > 0.0F) cell.z = Math.min(cell.z, f15);
/*      */ 
/*      */       
/* 1068 */       cell.A = Math.max(arrayOfFloat2[cell.D] * f14 - cell.F - cell.H, cell.b.get(cell.w));
/*      */       
/* 1070 */       if (f14 > 0.0F && (f15 = cell.f.get(cell.w)) > 0.0F) cell.A = Math.min(cell.A, f15);
/*      */ 
/*      */ 
/*      */       
/* 1074 */       if (((m = cell.q.intValue()) & 0x8) != 0) {
/* 1075 */         cell.x = f12;
/* 1076 */       } else if ((m & 0x10) != 0) {
/* 1077 */         cell.x = f12 + f16 - cell.z;
/*      */       } else {
/* 1079 */         cell.x = f12 + (f16 - cell.z) / 2.0F;
/*      */       } 
/* 1081 */       if ((m & 0x2) != 0) {
/* 1082 */         cell.y = cell.F;
/* 1083 */       } else if ((m & 0x4) != 0) {
/* 1084 */         cell.y = arrayOfFloat2[cell.D] - cell.A - cell.H;
/*      */       } else {
/* 1086 */         cell.y = (arrayOfFloat2[cell.D] - cell.A + cell.F - cell.H) / 2.0F;
/* 1087 */       }  cell.y = f2 - f13 - cell.y - cell.A;
/*      */       
/* 1089 */       if (this.Q) {
/* 1090 */         cell.z = (float)Math.ceil(cell.z);
/* 1091 */         cell.A = (float)Math.ceil(cell.A);
/* 1092 */         cell.x = (float)Math.floor(cell.x);
/* 1093 */         cell.y = (float)Math.floor(cell.y);
/*      */       } 
/*      */       
/* 1096 */       if (cell.w != null) cell.w.setBounds(cell.x, cell.y, cell.z, cell.A);
/*      */       
/* 1098 */       if (cell.B) {
/* 1099 */         f12 = f10;
/* 1100 */         f13 += arrayOfFloat2[cell.D];
/*      */       } else {
/* 1102 */         f12 += f16 + cell.I;
/*      */       } 
/*      */     } 
/*      */     
/*      */     SnapshotArray snapshotArray;
/* 1107 */     Actor[] arrayOfActor = (Actor[])((Array)(snapshotArray = getChildren())).items; byte b4; int n;
/* 1108 */     for (b4 = 0, n = ((Array)snapshotArray).size; b4 < n; b4++) {
/*      */       Actor actor;
/* 1110 */       if (actor = arrayOfActor[b4] instanceof Layout) ((Layout)actor).validate();
/*      */     
/*      */     } 
/*      */     
/* 1114 */     if (this.N != Debug.none) a(f10, f11, f9 - f4, f8 - f6); 
/*      */   }
/*      */   
/*      */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 1118 */     g();
/* 1119 */     if (this.N == Debug.table || this.N == Debug.all) {
/*      */       
/* 1121 */       a(0.0F, 0.0F, getWidth(), getHeight(), debugTableColor);
/*      */       
/* 1123 */       a(paramFloat1, getHeight() - paramFloat2, paramFloat3, -paramFloat4, debugTableColor);
/*      */     } 
/* 1125 */     paramFloat3 = paramFloat1; byte b; int i;
/* 1126 */     for (b = 0, i = this.r.size; b < i; b++) {
/* 1127 */       Cell cell = (Cell)this.r.get(b);
/*      */ 
/*      */       
/* 1130 */       if (this.N == Debug.actor || this.N == Debug.all) {
/* 1131 */         a(cell.x, cell.y, cell.z, cell.A, debugActorColor);
/*      */       }
/*      */       
/* 1134 */       float f = 0.0F; int j;
/* 1135 */       for (int k = (j = cell.C) + cell.t.intValue(); j < k; j++)
/* 1136 */         f += this.E[j]; 
/* 1137 */       f -= cell.G + cell.I;
/* 1138 */       paramFloat1 += cell.G;
/* 1139 */       if (this.N == Debug.cell || this.N == Debug.all) {
/* 1140 */         float f1 = this.F[cell.D] - cell.F - cell.H;
/* 1141 */         float f2 = paramFloat2 + cell.F;
/* 1142 */         a(paramFloat1, getHeight() - f2, f, -f1, debugCellColor);
/*      */       } 
/*      */       
/* 1145 */       if (cell.B) {
/* 1146 */         paramFloat1 = paramFloat3;
/* 1147 */         paramFloat2 += this.F[cell.D];
/*      */       } else {
/* 1149 */         paramFloat1 += f + cell.I;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private void g() {
/* 1154 */     if (this.O == null) this.O = new Array(); 
/* 1155 */     DebugRect.a.freeAll(this.O);
/* 1156 */     this.O.clear();
/*      */   }
/*      */   
/*      */   private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Color paramColor) {
/*      */     DebugRect debugRect;
/* 1161 */     (debugRect = (DebugRect)DebugRect.a.obtain()).b = paramColor;
/* 1162 */     debugRect.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/* 1163 */     this.O.add(debugRect);
/*      */   }
/*      */   
/*      */   public void drawDebug(ShapeRenderer paramShapeRenderer) {
/* 1167 */     if (isTransform()) {
/* 1168 */       a(paramShapeRenderer, b());
/* 1169 */       d(paramShapeRenderer);
/* 1170 */       if (this.P) {
/* 1171 */         paramShapeRenderer.flush();
/* 1172 */         float f1 = 0.0F, f2 = 0.0F, f3 = getWidth(), f4 = getHeight();
/* 1173 */         if (this.m != null) {
/* 1174 */           f1 = this.J.get((Actor)this);
/* 1175 */           f2 = this.K.get((Actor)this);
/* 1176 */           f3 -= f1 + this.L.get((Actor)this);
/* 1177 */           f4 -= f2 + this.I.get((Actor)this);
/*      */         } 
/* 1179 */         if (clipBegin(f1, f2, f3, f4)) {
/* 1180 */           b(paramShapeRenderer);
/* 1181 */           clipEnd();
/*      */         } 
/*      */       } else {
/* 1184 */         b(paramShapeRenderer);
/* 1185 */       }  c(paramShapeRenderer); return;
/*      */     } 
/* 1187 */     d(paramShapeRenderer);
/* 1188 */     super.drawDebug(paramShapeRenderer);
/*      */   }
/*      */ 
/*      */   
/*      */   protected final void a(ShapeRenderer paramShapeRenderer) {}
/*      */ 
/*      */   
/*      */   private void d(ShapeRenderer paramShapeRenderer) {
/* 1196 */     if (this.O == null || !getDebug())
/* 1197 */       return;  paramShapeRenderer.set(ShapeRenderer.ShapeType.Line);
/* 1198 */     if (getStage() != null) paramShapeRenderer.setColor(getStage().getDebugColor()); 
/* 1199 */     float f1 = 0.0F, f2 = 0.0F;
/* 1200 */     if (!isTransform()) {
/* 1201 */       f1 = getX();
/* 1202 */       f2 = getY();
/*      */     }  byte b; int i;
/* 1204 */     for (b = 0, i = this.O.size; b < i; b++) {
/* 1205 */       DebugRect debugRect = (DebugRect)this.O.get(b);
/* 1206 */       paramShapeRenderer.setColor(debugRect.b);
/* 1207 */       paramShapeRenderer.rect(f1 + debugRect.x, f2 + debugRect.y, debugRect.width, debugRect.height);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static class DebugRect
/*      */     extends Rectangle {
/* 1213 */     static Pool<DebugRect> a = Pools.get(DebugRect.class);
/*      */     Color b;
/*      */   }
/*      */   
/*      */   public enum Debug
/*      */   {
/* 1219 */     none, all, table, cell, actor;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1224 */   public static Value backgroundTop = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1227 */         return ((drawable = ((Table)param1Actor).m) == null) ? 0.0F : drawable.getTopHeight();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/* 1233 */   public static Value backgroundLeft = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1236 */         return ((drawable = ((Table)param1Actor).m) == null) ? 0.0F : drawable.getLeftWidth();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/* 1242 */   public static Value backgroundBottom = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1245 */         return ((drawable = ((Table)param1Actor).m) == null) ? 0.0F : drawable.getBottomHeight();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */   
/* 1251 */   public static Value backgroundRight = new Value() {
/*      */       public float get(@Null Actor param1Actor) {
/*      */         Drawable drawable;
/* 1254 */         return ((drawable = ((Table)param1Actor).m) == null) ? 0.0F : drawable.getRightWidth();
/*      */       }
/*      */     };
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Table.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */