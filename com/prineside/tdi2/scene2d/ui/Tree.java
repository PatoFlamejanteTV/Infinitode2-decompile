/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.Group;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.Layout;
/*     */ import com.prineside.tdi2.scene2d.utils.Selection;
/*     */ import com.prineside.tdi2.scene2d.utils.UIUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tree<N extends Tree.Node, V>
/*     */   extends WidgetGroup
/*     */ {
/*  47 */   private static final Vector2 o = new Vector2();
/*     */   
/*     */   private TreeStyle p;
/*  50 */   final Array<N> k = new Array();
/*     */   final Selection<N> l;
/*  52 */   private float q = 4.0F; private float r = 2.0F; float m = 2.0F; private float s; private float t; private float u; private float v; private float w;
/*     */   private boolean x = true;
/*     */   private N y;
/*     */   private N z;
/*     */   N n;
/*     */   private ClickListener A;
/*     */   
/*     */   public Tree(TreeStyle paramTreeStyle) {
/*  60 */     this.l = new Selection<N>(this) {
/*     */         protected final void a() {
/*  62 */           switch (size()) {
/*     */             case 0:
/*  64 */               this.e.n = null;
/*     */               return;
/*     */             case 1:
/*  67 */               this.e.n = (N)first();
/*     */               break;
/*     */           } 
/*     */         }
/*     */       };
/*  72 */     this.l.setActor((Actor)this);
/*  73 */     this.l.setMultiple(true);
/*  74 */     setStyle(paramTreeStyle);
/*  75 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/*  79 */     addListener((EventListener)(this.A = new ClickListener(this)
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*     */             // Byte code:
/*     */             //   0: aload_0
/*     */             //   1: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   4: fload_3
/*     */             //   5: invokevirtual getNodeAt : (F)Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   8: dup
/*     */             //   9: astore_1
/*     */             //   10: ifnonnull -> 14
/*     */             //   13: return
/*     */             //   14: aload_1
/*     */             //   15: aload_0
/*     */             //   16: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   19: aload_0
/*     */             //   20: invokevirtual getTouchDownY : ()F
/*     */             //   23: invokevirtual getNodeAt : (F)Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   26: if_acmpeq -> 30
/*     */             //   29: return
/*     */             //   30: aload_0
/*     */             //   31: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   34: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   37: invokevirtual getMultiple : ()Z
/*     */             //   40: ifeq -> 197
/*     */             //   43: aload_0
/*     */             //   44: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   47: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   50: invokevirtual notEmpty : ()Z
/*     */             //   53: ifeq -> 197
/*     */             //   56: invokestatic shift : ()Z
/*     */             //   59: ifeq -> 197
/*     */             //   62: aload_0
/*     */             //   63: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   66: getfield n : Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   69: ifnonnull -> 80
/*     */             //   72: aload_0
/*     */             //   73: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   76: aload_1
/*     */             //   77: putfield n : Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   80: aload_0
/*     */             //   81: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   84: getfield n : Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   87: astore_3
/*     */             //   88: invokestatic ctrl : ()Z
/*     */             //   91: ifne -> 104
/*     */             //   94: aload_0
/*     */             //   95: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   98: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   101: invokevirtual clear : ()V
/*     */             //   104: aload_3
/*     */             //   105: getfield a : Lcom/prineside/tdi2/scene2d/Actor;
/*     */             //   108: invokevirtual getY : ()F
/*     */             //   111: fstore_2
/*     */             //   112: aload_1
/*     */             //   113: getfield a : Lcom/prineside/tdi2/scene2d/Actor;
/*     */             //   116: invokevirtual getY : ()F
/*     */             //   119: fstore_1
/*     */             //   120: fload_2
/*     */             //   121: fload_1
/*     */             //   122: fcmpl
/*     */             //   123: ifle -> 145
/*     */             //   126: aload_0
/*     */             //   127: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   130: aload_0
/*     */             //   131: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   134: getfield k : Lcom/badlogic/gdx/utils/Array;
/*     */             //   137: fload_1
/*     */             //   138: fload_2
/*     */             //   139: invokevirtual a : (Lcom/badlogic/gdx/utils/Array;FF)V
/*     */             //   142: goto -> 177
/*     */             //   145: aload_0
/*     */             //   146: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   149: aload_0
/*     */             //   150: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   153: getfield k : Lcom/badlogic/gdx/utils/Array;
/*     */             //   156: fload_2
/*     */             //   157: fload_1
/*     */             //   158: invokevirtual a : (Lcom/badlogic/gdx/utils/Array;FF)V
/*     */             //   161: aload_0
/*     */             //   162: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   165: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   168: invokevirtual items : ()Lcom/badlogic/gdx/utils/OrderedSet;
/*     */             //   171: invokevirtual orderedItems : ()Lcom/badlogic/gdx/utils/Array;
/*     */             //   174: invokevirtual reverse : ()V
/*     */             //   177: aload_0
/*     */             //   178: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   181: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   184: invokevirtual fireChangeEvent : ()Z
/*     */             //   187: pop
/*     */             //   188: aload_0
/*     */             //   189: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   192: aload_3
/*     */             //   193: putfield n : Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   196: return
/*     */             //   197: aload_1
/*     */             //   198: getfield c : Lcom/badlogic/gdx/utils/Array;
/*     */             //   201: getfield size : I
/*     */             //   204: ifle -> 284
/*     */             //   207: aload_0
/*     */             //   208: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   211: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   214: invokevirtual getMultiple : ()Z
/*     */             //   217: ifeq -> 226
/*     */             //   220: invokestatic ctrl : ()Z
/*     */             //   223: ifne -> 284
/*     */             //   226: aload_1
/*     */             //   227: getfield a : Lcom/prineside/tdi2/scene2d/Actor;
/*     */             //   230: invokevirtual getX : ()F
/*     */             //   233: fstore_3
/*     */             //   234: aload_1
/*     */             //   235: getfield e : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */             //   238: ifnull -> 261
/*     */             //   241: fload_3
/*     */             //   242: aload_0
/*     */             //   243: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   246: getfield m : F
/*     */             //   249: aload_1
/*     */             //   250: getfield e : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */             //   253: invokeinterface getMinWidth : ()F
/*     */             //   258: fadd
/*     */             //   259: fsub
/*     */             //   260: fstore_3
/*     */             //   261: fload_2
/*     */             //   262: fload_3
/*     */             //   263: fcmpg
/*     */             //   264: ifge -> 284
/*     */             //   267: aload_1
/*     */             //   268: dup
/*     */             //   269: getfield d : Z
/*     */             //   272: ifne -> 279
/*     */             //   275: iconst_1
/*     */             //   276: goto -> 280
/*     */             //   279: iconst_0
/*     */             //   280: invokevirtual setExpanded : (Z)V
/*     */             //   283: return
/*     */             //   284: aload_1
/*     */             //   285: invokevirtual isSelectable : ()Z
/*     */             //   288: ifne -> 292
/*     */             //   291: return
/*     */             //   292: aload_0
/*     */             //   293: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   296: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   299: aload_1
/*     */             //   300: invokevirtual choose : (Ljava/lang/Object;)V
/*     */             //   303: aload_0
/*     */             //   304: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   307: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */             //   310: invokevirtual isEmpty : ()Z
/*     */             //   313: ifne -> 324
/*     */             //   316: aload_0
/*     */             //   317: getfield a : Lcom/prineside/tdi2/scene2d/ui/Tree;
/*     */             //   320: aload_1
/*     */             //   321: putfield n : Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */             //   324: return
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #81	-> 0
/*     */             //   #82	-> 9
/*     */             //   #83	-> 14
/*     */             //   #84	-> 30
/*     */             //   #86	-> 62
/*     */             //   #87	-> 80
/*     */             //   #88	-> 88
/*     */             //   #89	-> 104
/*     */             //   #90	-> 120
/*     */             //   #91	-> 126
/*     */             //   #93	-> 145
/*     */             //   #94	-> 161
/*     */             //   #97	-> 177
/*     */             //   #98	-> 188
/*     */             //   #99	-> 196
/*     */             //   #101	-> 197
/*     */             //   #103	-> 226
/*     */             //   #104	-> 234
/*     */             //   #105	-> 261
/*     */             //   #106	-> 267
/*     */             //   #107	-> 283
/*     */             //   #110	-> 284
/*     */             //   #111	-> 292
/*     */             //   #112	-> 303
/*     */             //   #113	-> 324
/*     */           }
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
/*     */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 116 */             this.a.setOverNode(this.a.getNodeAt(param1Float2));
/* 117 */             return false;
/*     */           }
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 121 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/* 122 */             this.a.setOverNode(this.a.getNodeAt(param1Float2));
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 126 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/* 127 */             if (param1Actor == null || !param1Actor.isDescendantOf((Actor)this.a)) this.a.setOverNode((Object)null); 
/*     */           }
/*     */         }));
/*     */   }
/*     */   
/*     */   public void setStyle(TreeStyle paramTreeStyle) {
/* 133 */     this.p = paramTreeStyle;
/*     */ 
/*     */     
/* 136 */     if (this.u == 0.0F) this.u = e(); 
/*     */   }
/*     */   
/*     */   public void add(N paramN) {
/* 140 */     insert(this.k.size, paramN);
/*     */   }
/*     */   public void insert(int paramInt, N paramN) {
/*     */     int i;
/* 144 */     if (((Node)paramN).b != null) {
/* 145 */       ((Node)paramN).b.remove(paramN);
/* 146 */       ((Node)paramN).b = null;
/*     */     
/*     */     }
/* 149 */     else if ((i = this.k.indexOf(paramN, true)) != -1) {
/* 150 */       if (i == paramInt)
/* 151 */         return;  if (i < paramInt) paramInt--; 
/* 152 */       this.k.removeIndex(i);
/*     */       
/* 154 */       if ((i = ((Node)paramN).a.getZIndex()) != -1) paramN.b(this, i);
/*     */     
/*     */     } 
/*     */     
/* 158 */     this.k.insert(paramInt, paramN);
/*     */ 
/*     */     
/* 161 */     if (paramInt == 0) {
/* 162 */       i = 0;
/* 163 */     } else if (paramInt < this.k.size - 1) {
/* 164 */       i = ((Node)this.k.get(paramInt + 1)).a.getZIndex();
/*     */     } else {
/*     */       Node node;
/* 167 */       i = (node = (Node)this.k.get(paramInt - 1)).a.getZIndex() + node.a();
/*     */     } 
/* 169 */     paramN.a(this, i);
/*     */   }
/*     */   
/*     */   public void remove(N paramN) {
/* 173 */     if (((Node)paramN).b != null) {
/* 174 */       ((Node)paramN).b.remove(paramN);
/*     */       return;
/*     */     } 
/* 177 */     if (!this.k.removeValue(paramN, true))
/*     */       return;  int i;
/* 179 */     if ((i = ((Node)paramN).a.getZIndex()) != -1) paramN.b(this, i);
/*     */   
/*     */   }
/*     */   
/*     */   public void clearChildren(boolean paramBoolean) {
/* 184 */     super.clearChildren(paramBoolean);
/* 185 */     setOverNode((N)null);
/* 186 */     this.k.clear();
/* 187 */     this.l.clear();
/*     */   }
/*     */   
/*     */   public void invalidate() {
/* 191 */     super.invalidate();
/* 192 */     this.x = true;
/*     */   }
/*     */   
/*     */   private float e() {
/* 196 */     float f = Math.max(this.p.plus.getMinWidth(), this.p.minus.getMinWidth());
/* 197 */     if (this.p.plusOver != null) f = Math.max(f, this.p.plusOver.getMinWidth()); 
/* 198 */     if (this.p.minusOver != null) f = Math.max(f, this.p.minusOver.getMinWidth()); 
/* 199 */     return f;
/*     */   }
/*     */   
/*     */   private void f() {
/* 203 */     this.x = false;
/* 204 */     this.v = e();
/* 205 */     this.w = 0.0F;
/* 206 */     b(this.k, 0.0F, this.v);
/* 207 */     this.v += this.s + this.t;
/*     */   }
/*     */   
/*     */   private void b(Array<N> paramArray, float paramFloat1, float paramFloat2) {
/* 211 */     float f1 = this.q;
/* 212 */     float f2 = this.r + this.m; byte b; int i;
/* 213 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 214 */       Layout layout; Node node = (Node)paramArray.get(b);
/* 215 */       float f = paramFloat1 + paramFloat2;
/*     */       A a;
/* 217 */       if (a = node.a instanceof Layout) {
/* 218 */         layout = (Layout)a;
/* 219 */         f += layout.getPrefWidth();
/* 220 */         node.f = layout.getPrefHeight();
/*     */       } else {
/* 222 */         f += layout.getWidth();
/* 223 */         node.f = layout.getHeight();
/*     */       } 
/* 225 */       if (node.e != null) {
/* 226 */         f += f2 + node.e.getMinWidth();
/* 227 */         node.f = Math.max(node.f, node.e.getMinHeight());
/*     */       } 
/* 229 */       this.v = Math.max(this.v, f);
/* 230 */       this.w += node.f + f1;
/* 231 */       if (node.d) b(node.c, paramFloat1 + this.u, paramFloat2); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void layout() {
/* 236 */     if (this.x) f(); 
/* 237 */     a(this.k, this.s, getHeight() - this.q / 2.0F, e());
/*     */   }
/*     */   
/*     */   private float a(Array<N> paramArray, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 241 */     float f1 = this.q;
/*     */     
/* 243 */     float f2, f3 = (f2 = this.r) + this.m; byte b; int i;
/* 244 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 245 */       Node node = (Node)paramArray.get(b);
/* 246 */       float f = paramFloat1 + paramFloat3;
/* 247 */       if (node.e != null) {
/* 248 */         f += f3 + node.e.getMinWidth();
/*     */       } else {
/* 250 */         f += f2;
/* 251 */       }  if (node.a instanceof Layout) ((Layout)node.a).pack(); 
/* 252 */       paramFloat2 -= node.getHeight();
/* 253 */       node.a.setPosition(f, paramFloat2);
/* 254 */       paramFloat2 -= f1;
/* 255 */       if (node.d) paramFloat2 = a(node.c, paramFloat1 + this.u, paramFloat2, paramFloat3); 
/*     */     } 
/* 257 */     return paramFloat2;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 261 */     b(paramBatch, paramFloat);
/*     */     Color color;
/* 263 */     float f = (color = getColor()).a * paramFloat;
/* 264 */     paramBatch.setColor(color.r, color.g, color.b, f);
/* 265 */     a(paramBatch, color.r, color.g, color.b, f, this.k, this.s, e());
/* 266 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(Batch paramBatch, float paramFloat) {
/* 271 */     if (this.p.background != null) {
/* 272 */       Color color = getColor();
/* 273 */       paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/* 274 */       this.p.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
/*     */     } 
/*     */   }
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
/*     */ 
/*     */   
/*     */   private float a(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Array<N> paramArray, float paramFloat5, float paramFloat6) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual getCullingArea : ()Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   4: astore #9
/*     */     //   6: fconst_0
/*     */     //   7: fstore #10
/*     */     //   9: fconst_0
/*     */     //   10: fstore #11
/*     */     //   12: aload #9
/*     */     //   14: ifnull -> 33
/*     */     //   17: aload #9
/*     */     //   19: getfield y : F
/*     */     //   22: dup
/*     */     //   23: fstore #10
/*     */     //   25: aload #9
/*     */     //   27: getfield height : F
/*     */     //   30: fadd
/*     */     //   31: fstore #11
/*     */     //   33: aload_0
/*     */     //   34: getfield p : Lcom/prineside/tdi2/scene2d/ui/Tree$TreeStyle;
/*     */     //   37: astore #12
/*     */     //   39: aload_0
/*     */     //   40: invokevirtual getX : ()F
/*     */     //   43: fstore #13
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual getY : ()F
/*     */     //   49: fstore #14
/*     */     //   51: fload #13
/*     */     //   53: fload #7
/*     */     //   55: fadd
/*     */     //   56: dup
/*     */     //   57: fstore #15
/*     */     //   59: fload #8
/*     */     //   61: fadd
/*     */     //   62: aload_0
/*     */     //   63: getfield r : F
/*     */     //   66: fadd
/*     */     //   67: fstore #16
/*     */     //   69: fconst_0
/*     */     //   70: fstore #17
/*     */     //   72: iconst_0
/*     */     //   73: istore #18
/*     */     //   75: aload #6
/*     */     //   77: getfield size : I
/*     */     //   80: istore #19
/*     */     //   82: iload #18
/*     */     //   84: iload #19
/*     */     //   86: if_icmpge -> 465
/*     */     //   89: aload #6
/*     */     //   91: iload #18
/*     */     //   93: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   96: checkcast com/prineside/tdi2/scene2d/ui/Tree$Node
/*     */     //   99: dup
/*     */     //   100: astore #20
/*     */     //   102: getfield a : Lcom/prineside/tdi2/scene2d/Actor;
/*     */     //   105: dup
/*     */     //   106: astore #21
/*     */     //   108: invokevirtual getY : ()F
/*     */     //   111: fstore #17
/*     */     //   113: aload #20
/*     */     //   115: getfield f : F
/*     */     //   118: fstore #22
/*     */     //   120: aload #9
/*     */     //   122: ifnull -> 144
/*     */     //   125: fload #17
/*     */     //   127: fload #22
/*     */     //   129: fadd
/*     */     //   130: fload #10
/*     */     //   132: fcmpl
/*     */     //   133: iflt -> 406
/*     */     //   136: fload #17
/*     */     //   138: fload #11
/*     */     //   140: fcmpg
/*     */     //   141: ifgt -> 406
/*     */     //   144: aload_0
/*     */     //   145: getfield l : Lcom/prineside/tdi2/scene2d/utils/Selection;
/*     */     //   148: aload #20
/*     */     //   150: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   153: ifeq -> 201
/*     */     //   156: aload #12
/*     */     //   158: getfield selection : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   161: ifnull -> 201
/*     */     //   164: aload #12
/*     */     //   166: getfield selection : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   169: aload_1
/*     */     //   170: fload #13
/*     */     //   172: fload #14
/*     */     //   174: fload #17
/*     */     //   176: fadd
/*     */     //   177: aload_0
/*     */     //   178: getfield q : F
/*     */     //   181: fconst_2
/*     */     //   182: fdiv
/*     */     //   183: fsub
/*     */     //   184: aload_0
/*     */     //   185: invokevirtual getWidth : ()F
/*     */     //   188: fload #22
/*     */     //   190: aload_0
/*     */     //   191: getfield q : F
/*     */     //   194: fadd
/*     */     //   195: invokestatic a : (Lcom/prineside/tdi2/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FFFF)V
/*     */     //   198: goto -> 252
/*     */     //   201: aload #20
/*     */     //   203: aload_0
/*     */     //   204: getfield z : Lcom/prineside/tdi2/scene2d/ui/Tree$Node;
/*     */     //   207: if_acmpne -> 252
/*     */     //   210: aload #12
/*     */     //   212: getfield over : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   215: ifnull -> 252
/*     */     //   218: aload #12
/*     */     //   220: getfield over : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   223: aload_1
/*     */     //   224: fload #13
/*     */     //   226: fload #14
/*     */     //   228: fload #17
/*     */     //   230: fadd
/*     */     //   231: aload_0
/*     */     //   232: getfield q : F
/*     */     //   235: fconst_2
/*     */     //   236: fdiv
/*     */     //   237: fsub
/*     */     //   238: aload_0
/*     */     //   239: invokevirtual getWidth : ()F
/*     */     //   242: fload #22
/*     */     //   244: aload_0
/*     */     //   245: getfield q : F
/*     */     //   248: fadd
/*     */     //   249: invokestatic b : (Lcom/prineside/tdi2/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FFFF)V
/*     */     //   252: aload #20
/*     */     //   254: getfield e : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   257: ifnull -> 348
/*     */     //   260: fload #14
/*     */     //   262: fload #17
/*     */     //   264: fadd
/*     */     //   265: fload #22
/*     */     //   267: aload #20
/*     */     //   269: getfield e : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   272: invokeinterface getMinHeight : ()F
/*     */     //   277: fsub
/*     */     //   278: fconst_2
/*     */     //   279: fdiv
/*     */     //   280: invokestatic round : (F)I
/*     */     //   283: i2f
/*     */     //   284: fadd
/*     */     //   285: fstore #23
/*     */     //   287: aload #21
/*     */     //   289: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   292: astore #21
/*     */     //   294: aload_1
/*     */     //   295: aload #21
/*     */     //   297: getfield r : F
/*     */     //   300: aload #21
/*     */     //   302: getfield g : F
/*     */     //   305: aload #21
/*     */     //   307: getfield b : F
/*     */     //   310: aload #21
/*     */     //   312: getfield a : F
/*     */     //   315: fload #5
/*     */     //   317: fmul
/*     */     //   318: invokeinterface setColor : (FFFF)V
/*     */     //   323: aload #20
/*     */     //   325: getfield e : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   328: aload_1
/*     */     //   329: fload #16
/*     */     //   331: fload #23
/*     */     //   333: invokestatic b : (Lcom/prineside/tdi2/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FF)V
/*     */     //   336: aload_1
/*     */     //   337: fload_2
/*     */     //   338: fload_3
/*     */     //   339: fload #4
/*     */     //   341: fload #5
/*     */     //   343: invokeinterface setColor : (FFFF)V
/*     */     //   348: aload #20
/*     */     //   350: getfield c : Lcom/badlogic/gdx/utils/Array;
/*     */     //   353: getfield size : I
/*     */     //   356: ifle -> 414
/*     */     //   359: aload_0
/*     */     //   360: aload #20
/*     */     //   362: fload #16
/*     */     //   364: invokevirtual a : (Lcom/prineside/tdi2/scene2d/ui/Tree$Node;F)Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   367: astore #23
/*     */     //   369: fload #14
/*     */     //   371: fload #17
/*     */     //   373: fadd
/*     */     //   374: fload #22
/*     */     //   376: aload #23
/*     */     //   378: invokeinterface getMinHeight : ()F
/*     */     //   383: fsub
/*     */     //   384: fconst_2
/*     */     //   385: fdiv
/*     */     //   386: invokestatic round : (F)I
/*     */     //   389: i2f
/*     */     //   390: fadd
/*     */     //   391: fstore #21
/*     */     //   393: aload #23
/*     */     //   395: aload_1
/*     */     //   396: fload #15
/*     */     //   398: fload #21
/*     */     //   400: invokestatic a : (Lcom/prineside/tdi2/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FF)V
/*     */     //   403: goto -> 414
/*     */     //   406: fload #17
/*     */     //   408: fload #10
/*     */     //   410: fcmpg
/*     */     //   411: iflt -> 465
/*     */     //   414: aload #20
/*     */     //   416: getfield d : Z
/*     */     //   419: ifeq -> 459
/*     */     //   422: aload #20
/*     */     //   424: getfield c : Lcom/badlogic/gdx/utils/Array;
/*     */     //   427: getfield size : I
/*     */     //   430: ifle -> 459
/*     */     //   433: aload_0
/*     */     //   434: aload_1
/*     */     //   435: fload_2
/*     */     //   436: fload_3
/*     */     //   437: fload #4
/*     */     //   439: fload #5
/*     */     //   441: aload #20
/*     */     //   443: getfield c : Lcom/badlogic/gdx/utils/Array;
/*     */     //   446: fload #7
/*     */     //   448: aload_0
/*     */     //   449: getfield u : F
/*     */     //   452: fadd
/*     */     //   453: fload #8
/*     */     //   455: invokevirtual a : (Lcom/badlogic/gdx/graphics/g2d/Batch;FFFFLcom/badlogic/gdx/utils/Array;FF)F
/*     */     //   458: pop
/*     */     //   459: iinc #18, 1
/*     */     //   462: goto -> 82
/*     */     //   465: fload #17
/*     */     //   467: freturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #284	-> 0
/*     */     //   #285	-> 6
/*     */     //   #286	-> 12
/*     */     //   #287	-> 17
/*     */     //   #288	-> 23
/*     */     //   #290	-> 33
/*     */     //   #291	-> 39
/*     */     //   #292	-> 72
/*     */     //   #293	-> 89
/*     */     //   #294	-> 100
/*     */     //   #295	-> 106
/*     */     //   #296	-> 113
/*     */     //   #297	-> 120
/*     */     //   #298	-> 144
/*     */     //   #299	-> 164
/*     */     //   #300	-> 201
/*     */     //   #301	-> 218
/*     */     //   #304	-> 252
/*     */     //   #305	-> 260
/*     */     //   #306	-> 287
/*     */     //   #307	-> 294
/*     */     //   #308	-> 323
/*     */     //   #309	-> 336
/*     */     //   #312	-> 348
/*     */     //   #313	-> 359
/*     */     //   #314	-> 369
/*     */     //   #315	-> 393
/*     */     //   #316	-> 403
/*     */     //   #317	-> 406
/*     */     //   #319	-> 414
/*     */     //   #320	-> 433
/*     */     //   #292	-> 459
/*     */     //   #322	-> 465
/*     */   }
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
/*     */   
/*     */   private static void a(Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 326 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   private static void b(Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 330 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   private static void a(Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 334 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramDrawable.getMinWidth(), paramDrawable.getMinHeight());
/*     */   }
/*     */   
/*     */   private static void b(Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 338 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramDrawable.getMinWidth(), paramDrawable.getMinHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Drawable a(N paramN, float paramFloat) {
/* 346 */     if (paramN == this.z && Gdx.app
/* 347 */       .getType() == Application.ApplicationType.Desktop && (
/* 348 */       !this.l.getMultiple() || (!UIUtils.ctrl() && !UIUtils.shift()))) {
/*     */       float f;
/*     */       
/* 351 */       if ((f = (screenToLocalCoordinates(o.set(Gdx.input.getX(), 0.0F))).x + getX()) >= 0.0F && f < paramFloat) {
/*     */         Drawable drawable;
/* 353 */         if ((drawable = (Drawable)(((Node)paramN).d ? this.p.minusOver : this.p.plusOver)) != null) return drawable; 
/*     */       } 
/*     */     } 
/* 356 */     return ((Node)paramN).d ? this.p.minus : this.p.plus;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N getNodeAt(float paramFloat) {
/* 361 */     this.y = null;
/* 362 */     c(this.k, paramFloat, getHeight());
/*     */     try {
/* 364 */       return this.y;
/*     */     } finally {
/* 366 */       this.y = null;
/*     */     } 
/*     */   }
/*     */   private float c(Array<N> paramArray, float paramFloat1, float paramFloat2) { byte b;
/*     */     int i;
/* 371 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node node;
/* 373 */       float f = (node = (Node)paramArray.get(b)).f;
/* 374 */       paramFloat2 -= node.getHeight() - f;
/* 375 */       if (paramFloat1 >= paramFloat2 - f - this.q && paramFloat1 < paramFloat2) {
/* 376 */         this.y = (N)node;
/* 377 */         return -1.0F;
/*     */       } 
/* 379 */       paramFloat2 -= f + this.q;
/* 380 */       if (node.d && (
/*     */         
/* 382 */         paramFloat2 = c(node.c, paramFloat1, paramFloat2)) == -1.0F) return -1.0F;
/*     */     
/*     */     } 
/* 385 */     return paramFloat2; } final void a(Array<N> paramArray, float paramFloat1, float paramFloat2) {
/*     */     byte b;
/*     */     int i;
/*     */     Node node;
/* 389 */     for (b = 0, i = paramArray.size; b < i && 
/*     */       
/* 391 */       (node = (Node)paramArray.get(b)).a.getY() >= paramFloat1; b++) {
/* 392 */       if (node.isSelectable()) {
/* 393 */         if (node.a.getY() <= paramFloat2) this.l.add(node); 
/* 394 */         if (node.d) a(node.c, paramFloat1, paramFloat2); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public Selection<N> getSelection() {
/* 399 */     return this.l;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N getSelectedNode() {
/* 404 */     return (N)this.l.first();
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V getSelectedValue() {
/*     */     Node node;
/* 410 */     return (V)(((node = (Node)this.l.first()) == null) ? null : node.getValue());
/*     */   }
/*     */   
/*     */   public TreeStyle getStyle() {
/* 414 */     return this.p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<N> getRootNodes() {
/* 420 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Array<N> getNodes() {
/* 426 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRootNodes() {
/*     */     byte b;
/*     */     int i;
/* 433 */     for (b = 0, i = this.k.size; b < i; b++) {
/*     */       Node node;
/*     */       int k;
/* 436 */       if ((k = (node = (Node)this.k.get(b)).a.getZIndex()) != -1) node.b(this, k); 
/*     */     }  int j;
/* 438 */     for (b = 0, i = this.k.size, j = 0; b < i; b++)
/* 439 */       j += ((Node)this.k.get(b)).a(this, j); 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N getOverNode() {
/* 444 */     return this.z;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V getOverValue() {
/* 449 */     if (this.z == null) return null; 
/* 450 */     return (V)this.z.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOverNode(@Null N paramN) {
/* 455 */     this.z = paramN;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadding(float paramFloat) {
/* 460 */     this.s = paramFloat;
/* 461 */     this.t = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadding(float paramFloat1, float paramFloat2) {
/* 466 */     this.s = paramFloat1;
/* 467 */     this.t = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setIndentSpacing(float paramFloat) {
/* 471 */     this.u = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getIndentSpacing() {
/* 476 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setYSpacing(float paramFloat) {
/* 481 */     this.q = paramFloat;
/*     */   }
/*     */   
/*     */   public float getYSpacing() {
/* 485 */     return this.q;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIconSpacing(float paramFloat1, float paramFloat2) {
/* 491 */     this.r = paramFloat1;
/* 492 */     this.m = paramFloat2;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 496 */     if (this.x) f(); 
/* 497 */     return this.v;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 501 */     if (this.x) f(); 
/* 502 */     return this.w;
/*     */   }
/*     */   
/*     */   public void findExpandedValues(Array<V> paramArray) {
/* 506 */     a(this.k, paramArray);
/*     */   } public void restoreExpandedValues(Array<V> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 510 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       N n;
/* 512 */       if ((n = findNode((V)paramArray.get(b))) != null) {
/* 513 */         n.setExpanded(true);
/* 514 */         n.expandTo();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   static boolean a(Array<? extends Node> paramArray, Array paramArray1) {
/*     */     byte b;
/*     */     int i;
/* 521 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node node;
/* 523 */       if ((node = (Node)paramArray.get(b)).d) { a(node.c, paramArray1); paramArray1.add(node.g); }
/*     */     
/* 525 */     }  return false;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N findNode(V paramV) {
/* 530 */     if (paramV == null) throw new IllegalArgumentException("value cannot be null."); 
/* 531 */     return (N)a(this.k, paramV); } @Null
/*     */   static Node a(Array<? extends Node> paramArray, Object paramObject) {
/*     */     byte b;
/*     */     int i;
/* 535 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 536 */       Node node = (Node)paramArray.get(b);
/* 537 */       if (paramObject.equals(node.g)) return node; 
/*     */     } 
/* 539 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node node;
/*     */       
/* 542 */       if ((node = a((node = (Node)paramArray.get(b)).c, paramObject)) != null) return node; 
/*     */     } 
/* 544 */     return null;
/*     */   }
/*     */   
/*     */   public void collapseAll() {
/* 548 */     a(this.k);
/*     */   } static void a(Array<? extends Node> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 552 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node<Node, ?, Actor> node;
/* 554 */       (node = (Node<Node, ?, Actor>)paramArray.get(b)).setExpanded(false);
/* 555 */       a(node.c);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void expandAll() {
/* 560 */     b(this.k);
/*     */   } static void b(Array<? extends Node> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 564 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 565 */       ((Node)paramArray.get(b)).expandAll();
/*     */     }
/*     */   }
/*     */   
/*     */   public ClickListener getClickListener() {
/* 570 */     return this.A;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Node<N extends Node, V, A extends Actor>
/*     */   {
/*     */     A a;
/*     */ 
/*     */     
/*     */     N b;
/*     */ 
/*     */     
/* 583 */     final Array<N> c = new Array(0);
/*     */     private boolean h = true;
/*     */     boolean d;
/*     */     Drawable e;
/*     */     float f;
/*     */     V g;
/*     */     
/*     */     public Node(A param1A) {
/* 591 */       if (param1A == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 592 */       this.a = param1A;
/*     */     }
/*     */ 
/*     */     
/*     */     public Node() {}
/*     */ 
/*     */     
/*     */     public void setExpanded(boolean param1Boolean) {
/* 600 */       if (param1Boolean == this.d)
/* 601 */         return;  this.d = param1Boolean;
/* 602 */       if (this.c.size == 0)
/*     */         return;  Tree<N, V> tree;
/* 604 */       if ((tree = getTree()) == null)
/* 605 */         return;  Object[] arrayOfObject = this.c.items;
/* 606 */       int i = this.a.getZIndex() + 1;
/* 607 */       if (param1Boolean) {
/* 608 */         int k; for (param1Boolean = false, k = this.c.size; param1Boolean < k; param1Boolean++)
/* 609 */           i += ((Node<N, V, Actor>)arrayOfObject[param1Boolean]).a(tree, i);  return;
/*     */       }  int j;
/* 611 */       for (param1Boolean = false, j = this.c.size; param1Boolean < j; param1Boolean++) {
/* 612 */         ((Node<N, V, Actor>)arrayOfObject[param1Boolean]).b(tree, i);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected final int a(Tree<N, V> param1Tree, int param1Int) {
/* 619 */       param1Tree.addActorAt(param1Int, (Actor)this.a);
/* 620 */       if (!this.d) return 1; 
/* 621 */       int i = param1Int + 1;
/* 622 */       Object[] arrayOfObject = this.c.items; byte b; int j;
/* 623 */       for (b = 0, j = this.c.size; b < j; b++)
/* 624 */         i += ((Node<N, V, Actor>)arrayOfObject[b]).a(param1Tree, i); 
/* 625 */       return i - param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final void b(Tree<N, V> param1Tree, int param1Int) {
/* 630 */       param1Tree.removeActorAt(param1Int, true);
/*     */       
/* 632 */       if (!this.d)
/* 633 */         return;  Object[] arrayOfObject = this.c.items; byte b; int i;
/* 634 */       for (b = 0, i = this.c.size; b < i; b++)
/* 635 */         ((Node<N, V, Actor>)arrayOfObject[b]).b(param1Tree, param1Int); 
/*     */     }
/*     */     
/*     */     public void add(N param1N) {
/* 639 */       insert(this.c.size, param1N);
/*     */     } public void addAll(Array<N> param1Array) {
/*     */       byte b;
/*     */       int i;
/* 643 */       for (b = 0, i = param1Array.size; b < i; b++)
/* 644 */         insert(this.c.size, (N)param1Array.get(b)); 
/*     */     }
/*     */     
/*     */     public void insert(int param1Int, N param1N) {
/* 648 */       ((Node)param1N).b = (N)this;
/* 649 */       this.c.insert(param1Int, param1N);
/* 650 */       if (!this.d)
/*     */         return;  Tree<N, V> tree;
/* 652 */       if ((tree = getTree()) != null) {
/*     */         int i;
/* 654 */         if (param1Int == 0) {
/* 655 */           param1Int = this.a.getZIndex() + 1;
/* 656 */         } else if (param1Int < this.c.size - 1) {
/* 657 */           param1Int = ((Node)this.c.get(param1Int + 1)).a.getZIndex();
/*     */         } else {
/*     */           Node node;
/* 660 */           i = (node = (Node)this.c.get(param1Int - 1)).a.getZIndex() + node.a();
/*     */         } 
/* 662 */         param1N.a(tree, i);
/*     */       } 
/*     */     }
/*     */     
/*     */     final int a() {
/* 667 */       if (!this.d) return 1; 
/* 668 */       int i = 1;
/* 669 */       Object[] arrayOfObject = this.c.items; byte b; int j;
/* 670 */       for (b = 0, j = this.c.size; b < j; b++)
/* 671 */         i += ((Node<Node, ?, Actor>)arrayOfObject[b]).a(); 
/* 672 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/*     */       Tree<N, V> tree;
/* 678 */       if ((tree = getTree()) != null) {
/* 679 */         tree.remove((N)this); return;
/* 680 */       }  if (this.b != null) {
/* 681 */         this.b.remove(this);
/*     */       }
/*     */     }
/*     */     
/*     */     public void remove(N param1N) {
/* 686 */       if (!this.c.removeValue(param1N, true))
/* 687 */         return;  if (!this.d)
/*     */         return;  Tree<N, V> tree;
/* 689 */       if ((tree = getTree()) != null) param1N.b(tree, ((Node)param1N).a.getZIndex()); 
/*     */     }
/*     */     
/*     */     public void clearChildren() {
/*     */       Tree<N, V> tree;
/* 694 */       if (this.d && (
/*     */         
/* 696 */         tree = getTree()) != null) {
/* 697 */         int i = this.a.getZIndex() + 1;
/* 698 */         Object[] arrayOfObject = this.c.items; byte b; int j;
/* 699 */         for (b = 0, j = this.c.size; b < j; b++) {
/* 700 */           ((Node<N, V, Actor>)arrayOfObject[b]).b(tree, i);
/*     */         }
/*     */       } 
/* 703 */       this.c.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     @Null
/*     */     public Tree<N, V> getTree() {
/*     */       Group group;
/* 710 */       if (group = this.a.getParent() instanceof Tree) return (Tree<N, V>)group; 
/* 711 */       return null;
/*     */     }
/*     */     public void setActor(A param1A) {
/*     */       Tree<N, V> tree;
/* 715 */       if (this.a != null && (
/*     */         
/* 717 */         tree = getTree()) != null) {
/* 718 */         int i = this.a.getZIndex();
/* 719 */         tree.removeActorAt(i, true);
/* 720 */         tree.addActorAt(i, (Actor)param1A);
/*     */       } 
/*     */       
/* 723 */       this.a = param1A;
/*     */     }
/*     */     
/*     */     public A getActor() {
/* 727 */       return this.a;
/*     */     }
/*     */     
/*     */     public boolean isExpanded() {
/* 731 */       return this.d;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Array<N> getChildren() {
/* 738 */       return this.c;
/*     */     }
/*     */     
/*     */     public boolean hasChildren() {
/* 742 */       return (this.c.size > 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void updateChildren() {
/* 749 */       if (!this.d)
/*     */         return;  Tree<N, V> tree;
/* 751 */       if ((tree = getTree()) == null)
/* 752 */         return;  Object[] arrayOfObject = this.c.items;
/* 753 */       int i = this.c.size;
/* 754 */       int j = this.a.getZIndex() + 1; byte b;
/* 755 */       for (b = 0; b < i; b++)
/* 756 */         ((Node<N, V, Actor>)arrayOfObject[b]).b(tree, j); 
/* 757 */       for (b = 0; b < i; b++)
/* 758 */         j += ((Node<N, V, Actor>)arrayOfObject[b]).a(tree, j); 
/*     */     }
/*     */     
/*     */     @Null
/*     */     public N getParent() {
/* 763 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setIcon(@Null Drawable param1Drawable) {
/* 768 */       this.e = param1Drawable;
/*     */     }
/*     */     @Null
/*     */     public V getValue() {
/* 772 */       return this.g;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setValue(@Null V param1V) {
/* 777 */       this.g = param1V;
/*     */     }
/*     */     @Null
/*     */     public Drawable getIcon() {
/* 781 */       return this.e;
/*     */     }
/*     */     
/*     */     public int getLevel() {
/* 785 */       byte b = 0;
/* 786 */       Node node = this;
/*     */       do {
/* 788 */         b++;
/*     */       }
/* 790 */       while ((node = (Node)node.getParent()) != null);
/* 791 */       return b;
/*     */     }
/*     */     
/*     */     @Null
/*     */     public N findNode(V param1V) {
/* 796 */       if (param1V == null) throw new IllegalArgumentException("value cannot be null."); 
/* 797 */       if (param1V.equals(this.g)) return (N)this; 
/* 798 */       return (N)Tree.a(this.c, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public void collapseAll() {
/* 803 */       setExpanded(false);
/* 804 */       Tree.a(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public void expandAll() {
/* 809 */       setExpanded(true);
/* 810 */       if (this.c.size > 0) Tree.b(this.c);
/*     */     
/*     */     }
/*     */     
/*     */     public void expandTo() {
/* 815 */       N n = this.b;
/* 816 */       while (n != null) {
/* 817 */         n.setExpanded(true);
/* 818 */         n = ((Node)n).b;
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isSelectable() {
/* 823 */       return this.h;
/*     */     }
/*     */     
/*     */     public void setSelectable(boolean param1Boolean) {
/* 827 */       this.h = param1Boolean;
/*     */     }
/*     */     
/*     */     public void findExpandedValues(Array<V> param1Array) {
/* 831 */       if (this.d) { Tree.a(this.c, param1Array); param1Array.add(this.g); }
/*     */        } public void restoreExpandedValues(Array<V> param1Array) {
/*     */       byte b;
/*     */       int i;
/* 835 */       for (b = 0, i = param1Array.size; b < i; b++) {
/*     */         N n;
/* 837 */         if ((n = findNode((V)param1Array.get(b))) != null) {
/* 838 */           n.setExpanded(true);
/* 839 */           n.expandTo();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public float getHeight() {
/* 847 */       return this.f;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isAscendantOf(N param1N) {
/* 852 */       if (param1N == null) throw new IllegalArgumentException("node cannot be null."); 
/* 853 */       param1N = param1N;
/*     */       while (true) {
/* 855 */         if (param1N == this) return true;
/*     */         
/* 857 */         if ((param1N = ((Node)param1N).b) == null)
/* 858 */           return false; 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isDescendantOf(N param1N) {
/* 863 */       if (param1N == null) throw new IllegalArgumentException("node cannot be null."); 
/* 864 */       Node node = this;
/*     */       while (true) {
/* 866 */         if (node == param1N) return true; 
/*     */         N n;
/* 868 */         if ((n = node.b) == null)
/* 869 */           return false; 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TreeStyle
/*     */   {
/*     */     public Drawable plus;
/*     */     public Drawable minus;
/*     */     @Null
/*     */     public Drawable plusOver;
/*     */     @Null
/*     */     public Drawable minusOver;
/*     */     
/*     */     public TreeStyle(Drawable param1Drawable1, Drawable param1Drawable2, @Null Drawable param1Drawable3) {
/* 884 */       this.plus = param1Drawable1;
/* 885 */       this.minus = param1Drawable2;
/* 886 */       this.selection = param1Drawable3; } @Null
/*     */     public Drawable over; @Null
/*     */     public Drawable selection; @Null
/*     */     public Drawable background; public TreeStyle() {} public TreeStyle(TreeStyle param1TreeStyle) {
/* 890 */       this.plus = param1TreeStyle.plus;
/* 891 */       this.minus = param1TreeStyle.minus;
/*     */       
/* 893 */       this.plusOver = param1TreeStyle.plusOver;
/* 894 */       this.minusOver = param1TreeStyle.minusOver;
/*     */       
/* 896 */       this.over = param1TreeStyle.over;
/* 897 */       this.selection = param1TreeStyle.selection;
/* 898 */       this.background = param1TreeStyle.background;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Tree.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */