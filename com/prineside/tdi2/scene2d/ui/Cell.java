/*      */ package com.prineside.tdi2.scene2d.ui;
/*      */ 
/*      */ import com.badlogic.gdx.Files;
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.badlogic.gdx.utils.Pool;
/*      */ import com.prineside.tdi2.scene2d.Actor;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Cell<T extends Actor>
/*      */   implements Pool.Poolable
/*      */ {
/*   15 */   private static final Float J = Float.valueOf(0.0F); private static final Float K = Float.valueOf(1.0F);
/*   16 */   private static final Integer L = Integer.valueOf(0); private static final Integer M;
/*   17 */   private static final Integer N = M = Integer.valueOf(1), O = Integer.valueOf(2), P = Integer.valueOf(4), Q = Integer.valueOf(8); private static Files S; private static Cell T; Value a; Value b; Value c; Value d; Value e; Value f; Value g; Value h; Value i; Value j; Value k; Value l; Value m; Value n; Float o;
/*   18 */   private static final Integer R = Integer.valueOf(16);
/*      */   
/*      */   Float p;
/*      */   
/*      */   Integer q;
/*      */   
/*      */   Integer r;
/*      */   
/*      */   Integer s;
/*      */   
/*      */   Integer t;
/*      */   
/*      */   Boolean u;
/*      */   
/*      */   Boolean v;
/*      */   
/*      */   @Null
/*      */   Actor w;
/*      */   
/*      */   float x;
/*      */   
/*      */   float y;
/*      */   float z;
/*      */   float A;
/*      */   private Table U;
/*      */   boolean B;
/*      */   int C;
/*      */   int D;
/*   46 */   int E = -1; float F; float G; float H; float I; public Cell() {
/*      */     Cell cell;
/*   48 */     if ((cell = defaults()) != null) a(cell); 
/*      */   }
/*      */   
/*      */   public void setTable(Table paramTable) {
/*   52 */     this.U = paramTable;
/*      */   }
/*      */ 
/*      */   
/*      */   public <A extends Actor> Cell<A> setActor(@Null A paramA) {
/*   57 */     if (this.w != paramA) {
/*   58 */       if (this.w != null && this.w.getParent() == this.U) this.w.remove(); 
/*   59 */       this.w = (Actor)paramA;
/*   60 */       if (paramA != null) this.U.addActor((Actor)paramA); 
/*      */     } 
/*   62 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> clearActor() {
/*   67 */     setActor(null);
/*   68 */     return this;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public T getActor() {
/*   73 */     return (T)this.w;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasActor() {
/*   78 */     return (this.w != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(Value paramValue) {
/*   83 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*   84 */     this.a = paramValue;
/*   85 */     this.b = paramValue;
/*   86 */     this.c = paramValue;
/*   87 */     this.d = paramValue;
/*   88 */     this.e = paramValue;
/*   89 */     this.f = paramValue;
/*   90 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(Value paramValue1, Value paramValue2) {
/*   95 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*   96 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*   97 */     this.a = paramValue1;
/*   98 */     this.b = paramValue2;
/*   99 */     this.c = paramValue1;
/*  100 */     this.d = paramValue2;
/*  101 */     this.e = paramValue1;
/*  102 */     this.f = paramValue2;
/*  103 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(float paramFloat) {
/*  108 */     size(Value.Fixed.valueOf(paramFloat));
/*  109 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> size(float paramFloat1, float paramFloat2) {
/*  114 */     size(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  115 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> width(Value paramValue) {
/*  120 */     if (paramValue == null) throw new IllegalArgumentException("width cannot be null."); 
/*  121 */     this.a = paramValue;
/*  122 */     this.c = paramValue;
/*  123 */     this.e = paramValue;
/*  124 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> width(float paramFloat) {
/*  129 */     width(Value.Fixed.valueOf(paramFloat));
/*  130 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> height(Value paramValue) {
/*  135 */     if (paramValue == null) throw new IllegalArgumentException("height cannot be null."); 
/*  136 */     this.b = paramValue;
/*  137 */     this.d = paramValue;
/*  138 */     this.f = paramValue;
/*  139 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> height(float paramFloat) {
/*  144 */     height(Value.Fixed.valueOf(paramFloat));
/*  145 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(Value paramValue) {
/*  150 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*  151 */     this.a = paramValue;
/*  152 */     this.b = paramValue;
/*  153 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(Value paramValue1, Value paramValue2) {
/*  158 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*  159 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*  160 */     this.a = paramValue1;
/*  161 */     this.b = paramValue2;
/*  162 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minWidth(Value paramValue) {
/*  166 */     if (paramValue == null) throw new IllegalArgumentException("minWidth cannot be null."); 
/*  167 */     this.a = paramValue;
/*  168 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minHeight(Value paramValue) {
/*  172 */     if (paramValue == null) throw new IllegalArgumentException("minHeight cannot be null."); 
/*  173 */     this.b = paramValue;
/*  174 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(float paramFloat) {
/*  179 */     minSize(Value.Fixed.valueOf(paramFloat));
/*  180 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> minSize(float paramFloat1, float paramFloat2) {
/*  185 */     minSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  186 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minWidth(float paramFloat) {
/*  190 */     this.a = Value.Fixed.valueOf(paramFloat);
/*  191 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> minHeight(float paramFloat) {
/*  195 */     this.b = Value.Fixed.valueOf(paramFloat);
/*  196 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(Value paramValue) {
/*  201 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*  202 */     this.c = paramValue;
/*  203 */     this.d = paramValue;
/*  204 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(Value paramValue1, Value paramValue2) {
/*  209 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*  210 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*  211 */     this.c = paramValue1;
/*  212 */     this.d = paramValue2;
/*  213 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefWidth(Value paramValue) {
/*  217 */     if (paramValue == null) throw new IllegalArgumentException("prefWidth cannot be null."); 
/*  218 */     this.c = paramValue;
/*  219 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefHeight(Value paramValue) {
/*  223 */     if (paramValue == null) throw new IllegalArgumentException("prefHeight cannot be null."); 
/*  224 */     this.d = paramValue;
/*  225 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(float paramFloat1, float paramFloat2) {
/*  230 */     prefSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  231 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> prefSize(float paramFloat) {
/*  236 */     prefSize(Value.Fixed.valueOf(paramFloat));
/*  237 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefWidth(float paramFloat) {
/*  241 */     this.c = Value.Fixed.valueOf(paramFloat);
/*  242 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> prefHeight(float paramFloat) {
/*  246 */     this.d = Value.Fixed.valueOf(paramFloat);
/*  247 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(Value paramValue) {
/*  252 */     if (paramValue == null) throw new IllegalArgumentException("size cannot be null."); 
/*  253 */     this.e = paramValue;
/*  254 */     this.f = paramValue;
/*  255 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(Value paramValue1, Value paramValue2) {
/*  260 */     if (paramValue1 == null) throw new IllegalArgumentException("width cannot be null."); 
/*  261 */     if (paramValue2 == null) throw new IllegalArgumentException("height cannot be null."); 
/*  262 */     this.e = paramValue1;
/*  263 */     this.f = paramValue2;
/*  264 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxWidth(Value paramValue) {
/*  269 */     if (paramValue == null) throw new IllegalArgumentException("maxWidth cannot be null."); 
/*  270 */     this.e = paramValue;
/*  271 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxHeight(Value paramValue) {
/*  276 */     if (paramValue == null) throw new IllegalArgumentException("maxHeight cannot be null."); 
/*  277 */     this.f = paramValue;
/*  278 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(float paramFloat) {
/*  283 */     maxSize(Value.Fixed.valueOf(paramFloat));
/*  284 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxSize(float paramFloat1, float paramFloat2) {
/*  289 */     maxSize(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2));
/*  290 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxWidth(float paramFloat) {
/*  295 */     this.e = Value.Fixed.valueOf(paramFloat);
/*  296 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> maxHeight(float paramFloat) {
/*  301 */     this.f = Value.Fixed.valueOf(paramFloat);
/*  302 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> space(Value paramValue) {
/*  307 */     if (paramValue == null) throw new IllegalArgumentException("space cannot be null."); 
/*  308 */     this.g = paramValue;
/*  309 */     this.h = paramValue;
/*  310 */     this.i = paramValue;
/*  311 */     this.j = paramValue;
/*  312 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> space(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/*  316 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/*  317 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/*  318 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/*  319 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/*  320 */     this.g = paramValue1;
/*  321 */     this.h = paramValue2;
/*  322 */     this.i = paramValue3;
/*  323 */     this.j = paramValue4;
/*  324 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceTop(Value paramValue) {
/*  328 */     if (paramValue == null) throw new IllegalArgumentException("spaceTop cannot be null."); 
/*  329 */     this.g = paramValue;
/*  330 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceLeft(Value paramValue) {
/*  334 */     if (paramValue == null) throw new IllegalArgumentException("spaceLeft cannot be null."); 
/*  335 */     this.h = paramValue;
/*  336 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceBottom(Value paramValue) {
/*  340 */     if (paramValue == null) throw new IllegalArgumentException("spaceBottom cannot be null."); 
/*  341 */     this.i = paramValue;
/*  342 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> spaceRight(Value paramValue) {
/*  346 */     if (paramValue == null) throw new IllegalArgumentException("spaceRight cannot be null."); 
/*  347 */     this.j = paramValue;
/*  348 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> space(float paramFloat) {
/*  353 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("space cannot be < 0: " + paramFloat); 
/*  354 */     space(Value.Fixed.valueOf(paramFloat));
/*  355 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> space(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  360 */     if (paramFloat1 < 0.0F) throw new IllegalArgumentException("top cannot be < 0: " + paramFloat1); 
/*  361 */     if (paramFloat2 < 0.0F) throw new IllegalArgumentException("left cannot be < 0: " + paramFloat2); 
/*  362 */     if (paramFloat3 < 0.0F) throw new IllegalArgumentException("bottom cannot be < 0: " + paramFloat3); 
/*  363 */     if (paramFloat4 < 0.0F) throw new IllegalArgumentException("right cannot be < 0: " + paramFloat4); 
/*  364 */     space(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2), Value.Fixed.valueOf(paramFloat3), Value.Fixed.valueOf(paramFloat4));
/*  365 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceTop(float paramFloat) {
/*  370 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceTop cannot be < 0: " + paramFloat); 
/*  371 */     this.g = Value.Fixed.valueOf(paramFloat);
/*  372 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceLeft(float paramFloat) {
/*  377 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceLeft cannot be < 0: " + paramFloat); 
/*  378 */     this.h = Value.Fixed.valueOf(paramFloat);
/*  379 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceBottom(float paramFloat) {
/*  384 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceBottom cannot be < 0: " + paramFloat); 
/*  385 */     this.i = Value.Fixed.valueOf(paramFloat);
/*  386 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> spaceRight(float paramFloat) {
/*  391 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("spaceRight cannot be < 0: " + paramFloat); 
/*  392 */     this.j = Value.Fixed.valueOf(paramFloat);
/*  393 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> pad(Value paramValue) {
/*  398 */     if (paramValue == null) throw new IllegalArgumentException("pad cannot be null."); 
/*  399 */     this.k = paramValue;
/*  400 */     this.l = paramValue;
/*  401 */     this.m = paramValue;
/*  402 */     this.n = paramValue;
/*  403 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> pad(Value paramValue1, Value paramValue2, Value paramValue3, Value paramValue4) {
/*  407 */     if (paramValue1 == null) throw new IllegalArgumentException("top cannot be null."); 
/*  408 */     if (paramValue2 == null) throw new IllegalArgumentException("left cannot be null."); 
/*  409 */     if (paramValue3 == null) throw new IllegalArgumentException("bottom cannot be null."); 
/*  410 */     if (paramValue4 == null) throw new IllegalArgumentException("right cannot be null."); 
/*  411 */     this.k = paramValue1;
/*  412 */     this.l = paramValue2;
/*  413 */     this.m = paramValue3;
/*  414 */     this.n = paramValue4;
/*  415 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padTop(Value paramValue) {
/*  419 */     if (paramValue == null) throw new IllegalArgumentException("padTop cannot be null."); 
/*  420 */     this.k = paramValue;
/*  421 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padLeft(Value paramValue) {
/*  425 */     if (paramValue == null) throw new IllegalArgumentException("padLeft cannot be null."); 
/*  426 */     this.l = paramValue;
/*  427 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padBottom(Value paramValue) {
/*  431 */     if (paramValue == null) throw new IllegalArgumentException("padBottom cannot be null."); 
/*  432 */     this.m = paramValue;
/*  433 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padRight(Value paramValue) {
/*  437 */     if (paramValue == null) throw new IllegalArgumentException("padRight cannot be null."); 
/*  438 */     this.n = paramValue;
/*  439 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> pad(float paramFloat) {
/*  444 */     pad(Value.Fixed.valueOf(paramFloat));
/*  445 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> pad(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  449 */     pad(Value.Fixed.valueOf(paramFloat1), Value.Fixed.valueOf(paramFloat2), Value.Fixed.valueOf(paramFloat3), Value.Fixed.valueOf(paramFloat4));
/*  450 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padTop(float paramFloat) {
/*  454 */     this.k = Value.Fixed.valueOf(paramFloat);
/*  455 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padLeft(float paramFloat) {
/*  459 */     this.l = Value.Fixed.valueOf(paramFloat);
/*  460 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padBottom(float paramFloat) {
/*  464 */     this.m = Value.Fixed.valueOf(paramFloat);
/*  465 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> padRight(float paramFloat) {
/*  469 */     this.n = Value.Fixed.valueOf(paramFloat);
/*  470 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fill() {
/*  475 */     this.o = K;
/*  476 */     this.p = K;
/*  477 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fillX() {
/*  482 */     this.o = K;
/*  483 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fillY() {
/*  488 */     this.p = K;
/*  489 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> fill(float paramFloat1, float paramFloat2) {
/*  493 */     this.o = Float.valueOf(paramFloat1);
/*  494 */     this.p = Float.valueOf(paramFloat2);
/*  495 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fill(boolean paramBoolean1, boolean paramBoolean2) {
/*  500 */     this.o = paramBoolean1 ? K : J;
/*  501 */     this.p = paramBoolean2 ? K : J;
/*  502 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> fill(boolean paramBoolean) {
/*  507 */     this.o = paramBoolean ? K : J;
/*  508 */     this.p = paramBoolean ? K : J;
/*  509 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Cell<T> align(int paramInt) {
/*  515 */     this.q = Integer.valueOf(paramInt);
/*  516 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> center() {
/*  521 */     this.q = N;
/*  522 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> top() {
/*  527 */     if (this.q == null) {
/*  528 */       this.q = O;
/*      */     } else {
/*  530 */       this.q = Integer.valueOf((this.q.intValue() | 0x2) & 0xFFFFFFFB);
/*  531 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> left() {
/*  536 */     if (this.q == null) {
/*  537 */       this.q = Q;
/*      */     } else {
/*  539 */       this.q = Integer.valueOf((this.q.intValue() | 0x8) & 0xFFFFFFEF);
/*  540 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> bottom() {
/*  545 */     if (this.q == null) {
/*  546 */       this.q = P;
/*      */     } else {
/*  548 */       this.q = Integer.valueOf((this.q.intValue() | 0x4) & 0xFFFFFFFD);
/*  549 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> right() {
/*  554 */     if (this.q == null) {
/*  555 */       this.q = R;
/*      */     } else {
/*  557 */       this.q = Integer.valueOf((this.q.intValue() | 0x10) & 0xFFFFFFF7);
/*  558 */     }  return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> grow() {
/*  563 */     this.r = M;
/*  564 */     this.s = M;
/*  565 */     this.o = K;
/*  566 */     this.p = K;
/*  567 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> growX() {
/*  572 */     this.r = M;
/*  573 */     this.o = K;
/*  574 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> growY() {
/*  579 */     this.s = M;
/*  580 */     this.p = K;
/*  581 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expand() {
/*  586 */     this.r = M;
/*  587 */     this.s = M;
/*  588 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expandX() {
/*  593 */     this.r = M;
/*  594 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expandY() {
/*  599 */     this.s = M;
/*  600 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> expand(int paramInt1, int paramInt2) {
/*  604 */     this.r = Integer.valueOf(paramInt1);
/*  605 */     this.s = Integer.valueOf(paramInt2);
/*  606 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> expand(boolean paramBoolean1, boolean paramBoolean2) {
/*  611 */     this.r = paramBoolean1 ? M : L;
/*  612 */     this.s = paramBoolean2 ? M : L;
/*  613 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> colspan(int paramInt) {
/*  617 */     this.t = Integer.valueOf(paramInt);
/*  618 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> uniform() {
/*  623 */     this.u = Boolean.TRUE;
/*  624 */     this.v = Boolean.TRUE;
/*  625 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> uniformX() {
/*  630 */     this.u = Boolean.TRUE;
/*  631 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Cell<T> uniformY() {
/*  636 */     this.v = Boolean.TRUE;
/*  637 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> uniform(boolean paramBoolean) {
/*  641 */     this.u = Boolean.valueOf(paramBoolean);
/*  642 */     this.v = Boolean.valueOf(paramBoolean);
/*  643 */     return this;
/*      */   }
/*      */   
/*      */   public Cell<T> uniform(boolean paramBoolean1, boolean paramBoolean2) {
/*  647 */     this.u = Boolean.valueOf(paramBoolean1);
/*  648 */     this.v = Boolean.valueOf(paramBoolean2);
/*  649 */     return this;
/*      */   }
/*      */   
/*      */   public void setActorBounds(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*  653 */     this.x = paramFloat1;
/*  654 */     this.y = paramFloat2;
/*  655 */     this.z = paramFloat3;
/*  656 */     this.A = paramFloat4;
/*      */   }
/*      */   
/*      */   public float getActorX() {
/*  660 */     return this.x;
/*      */   }
/*      */   
/*      */   public void setActorX(float paramFloat) {
/*  664 */     this.x = paramFloat;
/*      */   }
/*      */   
/*      */   public float getActorY() {
/*  668 */     return this.y;
/*      */   }
/*      */   
/*      */   public void setActorY(float paramFloat) {
/*  672 */     this.y = paramFloat;
/*      */   }
/*      */   
/*      */   public float getActorWidth() {
/*  676 */     return this.z;
/*      */   }
/*      */   
/*      */   public void setActorWidth(float paramFloat) {
/*  680 */     this.z = paramFloat;
/*      */   }
/*      */   
/*      */   public float getActorHeight() {
/*  684 */     return this.A;
/*      */   }
/*      */   
/*      */   public void setActorHeight(float paramFloat) {
/*  688 */     this.A = paramFloat;
/*      */   }
/*      */   
/*      */   public int getColumn() {
/*  692 */     return this.C;
/*      */   }
/*      */   
/*      */   public int getRow() {
/*  696 */     return this.D;
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMinWidthValue() {
/*  701 */     return this.a;
/*      */   }
/*      */   
/*      */   public float getMinWidth() {
/*  705 */     return this.a.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMinHeightValue() {
/*  710 */     return this.b;
/*      */   }
/*      */   
/*      */   public float getMinHeight() {
/*  714 */     return this.b.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPrefWidthValue() {
/*  719 */     return this.c;
/*      */   }
/*      */   
/*      */   public float getPrefWidth() {
/*  723 */     return this.c.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPrefHeightValue() {
/*  728 */     return this.d;
/*      */   }
/*      */   
/*      */   public float getPrefHeight() {
/*  732 */     return this.d.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMaxWidthValue() {
/*  737 */     return this.e;
/*      */   }
/*      */   
/*      */   public float getMaxWidth() {
/*  741 */     return this.e.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getMaxHeightValue() {
/*  746 */     return this.f;
/*      */   }
/*      */   
/*      */   public float getMaxHeight() {
/*  750 */     return this.f.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceTopValue() {
/*  755 */     return this.g;
/*      */   }
/*      */   
/*      */   public float getSpaceTop() {
/*  759 */     return this.g.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceLeftValue() {
/*  764 */     return this.h;
/*      */   }
/*      */   
/*      */   public float getSpaceLeft() {
/*  768 */     return this.h.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceBottomValue() {
/*  773 */     return this.i;
/*      */   }
/*      */   
/*      */   public float getSpaceBottom() {
/*  777 */     return this.i.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getSpaceRightValue() {
/*  782 */     return this.j;
/*      */   }
/*      */   
/*      */   public float getSpaceRight() {
/*  786 */     return this.j.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadTopValue() {
/*  791 */     return this.k;
/*      */   }
/*      */   
/*      */   public float getPadTop() {
/*  795 */     return this.k.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadLeftValue() {
/*  800 */     return this.l;
/*      */   }
/*      */   
/*      */   public float getPadLeft() {
/*  804 */     return this.l.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadBottomValue() {
/*  809 */     return this.m;
/*      */   }
/*      */   
/*      */   public float getPadBottom() {
/*  813 */     return this.m.get(this.w);
/*      */   }
/*      */   
/*      */   @Null
/*      */   public Value getPadRightValue() {
/*  818 */     return this.n;
/*      */   }
/*      */   
/*      */   public float getPadRight() {
/*  822 */     return this.n.get(this.w);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadX() {
/*  827 */     return this.l.get(this.w) + this.n.get(this.w);
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPadY() {
/*  832 */     return this.k.get(this.w) + this.m.get(this.w);
/*      */   }
/*      */   @Null
/*      */   public Float getFillX() {
/*  836 */     return this.o;
/*      */   }
/*      */   @Null
/*      */   public Float getFillY() {
/*  840 */     return this.p;
/*      */   }
/*      */   @Null
/*      */   public Integer getAlign() {
/*  844 */     return this.q;
/*      */   }
/*      */   @Null
/*      */   public Integer getExpandX() {
/*  848 */     return this.r;
/*      */   }
/*      */   @Null
/*      */   public Integer getExpandY() {
/*  852 */     return this.s;
/*      */   }
/*      */   @Null
/*      */   public Integer getColspan() {
/*  856 */     return this.t;
/*      */   }
/*      */   @Null
/*      */   public Boolean getUniformX() {
/*  860 */     return this.u;
/*      */   }
/*      */   @Null
/*      */   public Boolean getUniformY() {
/*  864 */     return this.v;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isEndRow() {
/*  869 */     return this.B;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadTop() {
/*  874 */     return this.F;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadLeft() {
/*  879 */     return this.G;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadBottom() {
/*  884 */     return this.H;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getComputedPadRight() {
/*  889 */     return this.I;
/*      */   }
/*      */   
/*      */   public void row() {
/*  893 */     this.U.row();
/*      */   }
/*      */   
/*      */   public Table getTable() {
/*  897 */     return this.U;
/*      */   }
/*      */ 
/*      */   
/*      */   final void a() {
/*  902 */     this.a = null;
/*  903 */     this.b = null;
/*  904 */     this.c = null;
/*  905 */     this.d = null;
/*  906 */     this.e = null;
/*  907 */     this.f = null;
/*  908 */     this.g = null;
/*  909 */     this.h = null;
/*  910 */     this.i = null;
/*  911 */     this.j = null;
/*  912 */     this.k = null;
/*  913 */     this.l = null;
/*  914 */     this.m = null;
/*  915 */     this.n = null;
/*  916 */     this.o = null;
/*  917 */     this.p = null;
/*  918 */     this.q = null;
/*  919 */     this.r = null;
/*  920 */     this.s = null;
/*  921 */     this.t = null;
/*  922 */     this.u = null;
/*  923 */     this.v = null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void reset() {
/*  928 */     this.w = null;
/*  929 */     this.U = null;
/*  930 */     this.B = false;
/*  931 */     this.E = -1;
/*  932 */     a(defaults());
/*      */   }
/*      */   
/*      */   final void a(Cell paramCell) {
/*  936 */     this.a = paramCell.a;
/*  937 */     this.b = paramCell.b;
/*  938 */     this.c = paramCell.c;
/*  939 */     this.d = paramCell.d;
/*  940 */     this.e = paramCell.e;
/*  941 */     this.f = paramCell.f;
/*  942 */     this.g = paramCell.g;
/*  943 */     this.h = paramCell.h;
/*  944 */     this.i = paramCell.i;
/*  945 */     this.j = paramCell.j;
/*  946 */     this.k = paramCell.k;
/*  947 */     this.l = paramCell.l;
/*  948 */     this.m = paramCell.m;
/*  949 */     this.n = paramCell.n;
/*  950 */     this.o = paramCell.o;
/*  951 */     this.p = paramCell.p;
/*  952 */     this.q = paramCell.q;
/*  953 */     this.r = paramCell.r;
/*  954 */     this.s = paramCell.s;
/*  955 */     this.t = paramCell.t;
/*  956 */     this.u = paramCell.u;
/*  957 */     this.v = paramCell.v;
/*      */   }
/*      */   
/*      */   final void b(@Null Cell paramCell) {
/*  961 */     if (paramCell == null)
/*  962 */       return;  if (paramCell.a != null) this.a = paramCell.a; 
/*  963 */     if (paramCell.b != null) this.b = paramCell.b; 
/*  964 */     if (paramCell.c != null) this.c = paramCell.c; 
/*  965 */     if (paramCell.d != null) this.d = paramCell.d; 
/*  966 */     if (paramCell.e != null) this.e = paramCell.e; 
/*  967 */     if (paramCell.f != null) this.f = paramCell.f; 
/*  968 */     if (paramCell.g != null) this.g = paramCell.g; 
/*  969 */     if (paramCell.h != null) this.h = paramCell.h; 
/*  970 */     if (paramCell.i != null) this.i = paramCell.i; 
/*  971 */     if (paramCell.j != null) this.j = paramCell.j; 
/*  972 */     if (paramCell.k != null) this.k = paramCell.k; 
/*  973 */     if (paramCell.l != null) this.l = paramCell.l; 
/*  974 */     if (paramCell.m != null) this.m = paramCell.m; 
/*  975 */     if (paramCell.n != null) this.n = paramCell.n; 
/*  976 */     if (paramCell.o != null) this.o = paramCell.o; 
/*  977 */     if (paramCell.p != null) this.p = paramCell.p; 
/*  978 */     if (paramCell.q != null) this.q = paramCell.q; 
/*  979 */     if (paramCell.r != null) this.r = paramCell.r; 
/*  980 */     if (paramCell.s != null) this.s = paramCell.s; 
/*  981 */     if (paramCell.t != null) this.t = paramCell.t; 
/*  982 */     if (paramCell.u != null) this.u = paramCell.u; 
/*  983 */     if (paramCell.v != null) this.v = paramCell.v; 
/*      */   }
/*      */   
/*      */   public String toString() {
/*  987 */     return (this.w != null) ? this.w.toString() : super.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Cell defaults() {
/*  993 */     if (S == null || S != Gdx.files) {
/*  994 */       S = Gdx.files;
/*      */       
/*  996 */       (T = new Cell<>()).a = Value.minWidth;
/*  997 */       T.b = Value.minHeight;
/*  998 */       T.c = Value.prefWidth;
/*  999 */       T.d = Value.prefHeight;
/* 1000 */       T.e = Value.maxWidth;
/* 1001 */       T.f = Value.maxHeight;
/* 1002 */       T.g = Value.zero;
/* 1003 */       T.h = Value.zero;
/* 1004 */       T.i = Value.zero;
/* 1005 */       T.j = Value.zero;
/* 1006 */       T.k = Value.zero;
/* 1007 */       T.l = Value.zero;
/* 1008 */       T.m = Value.zero;
/* 1009 */       T.n = Value.zero;
/* 1010 */       T.o = J;
/* 1011 */       T.p = J;
/* 1012 */       T.q = N;
/* 1013 */       T.r = L;
/* 1014 */       T.s = L;
/* 1015 */       T.t = M;
/* 1016 */       T.u = null;
/* 1017 */       T.v = null;
/*      */     } 
/* 1019 */     return T;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Cell.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */