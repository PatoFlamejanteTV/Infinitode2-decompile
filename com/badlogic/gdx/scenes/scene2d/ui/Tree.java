/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Group;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Layout;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Selection;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*  47 */   private static final Vector2 tmp = new Vector2();
/*     */   
/*     */   TreeStyle style;
/*  50 */   final Array<N> rootNodes = new Array();
/*     */   final Selection<N> selection;
/*  52 */   float ySpacing = 4.0F; float iconSpacingLeft = 2.0F; float iconSpacingRight = 2.0F; float paddingLeft; float paddingRight; float indentSpacing; private float prefWidth; private float prefHeight;
/*     */   private boolean sizeInvalid = true;
/*     */   private N foundNode;
/*     */   private N overNode;
/*     */   N rangeStart;
/*     */   private ClickListener clickListener;
/*     */   
/*     */   public Tree(Skin paramSkin) {
/*  60 */     this(paramSkin.<TreeStyle>get(TreeStyle.class));
/*     */   }
/*     */   
/*     */   public Tree(Skin paramSkin, String paramString) {
/*  64 */     this(paramSkin.<TreeStyle>get(paramString, TreeStyle.class));
/*     */   }
/*     */   
/*     */   public Tree(TreeStyle paramTreeStyle) {
/*  68 */     this.selection = new Selection<N>() {
/*     */         protected void changed() {
/*  70 */           switch (size()) {
/*     */             case 0:
/*  72 */               Tree.this.rangeStart = null;
/*     */               return;
/*     */             case 1:
/*  75 */               Tree.this.rangeStart = (N)first();
/*     */               break;
/*     */           } 
/*     */         }
/*     */       };
/*  80 */     this.selection.setActor((Actor)this);
/*  81 */     this.selection.setMultiple(true);
/*  82 */     setStyle(paramTreeStyle);
/*  83 */     initialize();
/*     */   }
/*     */   
/*     */   private void initialize() {
/*  87 */     addListener((EventListener)(this.clickListener = new ClickListener()
/*     */         {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*     */             // Byte code:
/*     */             //   0: aload_0
/*     */             //   1: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   4: fload_3
/*     */             //   5: invokevirtual getNodeAt : (F)Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   8: dup
/*     */             //   9: astore_1
/*     */             //   10: ifnonnull -> 14
/*     */             //   13: return
/*     */             //   14: aload_1
/*     */             //   15: aload_0
/*     */             //   16: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   19: aload_0
/*     */             //   20: invokevirtual getTouchDownY : ()F
/*     */             //   23: invokevirtual getNodeAt : (F)Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   26: if_acmpeq -> 30
/*     */             //   29: return
/*     */             //   30: aload_0
/*     */             //   31: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   34: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   37: invokevirtual getMultiple : ()Z
/*     */             //   40: ifeq -> 197
/*     */             //   43: aload_0
/*     */             //   44: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   47: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   50: invokevirtual notEmpty : ()Z
/*     */             //   53: ifeq -> 197
/*     */             //   56: invokestatic shift : ()Z
/*     */             //   59: ifeq -> 197
/*     */             //   62: aload_0
/*     */             //   63: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   66: getfield rangeStart : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   69: ifnonnull -> 80
/*     */             //   72: aload_0
/*     */             //   73: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   76: aload_1
/*     */             //   77: putfield rangeStart : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   80: aload_0
/*     */             //   81: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   84: getfield rangeStart : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   87: astore_3
/*     */             //   88: invokestatic ctrl : ()Z
/*     */             //   91: ifne -> 104
/*     */             //   94: aload_0
/*     */             //   95: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   98: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   101: invokevirtual clear : ()V
/*     */             //   104: aload_3
/*     */             //   105: getfield actor : Lcom/badlogic/gdx/scenes/scene2d/Actor;
/*     */             //   108: invokevirtual getY : ()F
/*     */             //   111: fstore_2
/*     */             //   112: aload_1
/*     */             //   113: getfield actor : Lcom/badlogic/gdx/scenes/scene2d/Actor;
/*     */             //   116: invokevirtual getY : ()F
/*     */             //   119: fstore_1
/*     */             //   120: fload_2
/*     */             //   121: fload_1
/*     */             //   122: fcmpl
/*     */             //   123: ifle -> 145
/*     */             //   126: aload_0
/*     */             //   127: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   130: aload_0
/*     */             //   131: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   134: getfield rootNodes : Lcom/badlogic/gdx/utils/Array;
/*     */             //   137: fload_1
/*     */             //   138: fload_2
/*     */             //   139: invokevirtual selectNodes : (Lcom/badlogic/gdx/utils/Array;FF)V
/*     */             //   142: goto -> 177
/*     */             //   145: aload_0
/*     */             //   146: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   149: aload_0
/*     */             //   150: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   153: getfield rootNodes : Lcom/badlogic/gdx/utils/Array;
/*     */             //   156: fload_2
/*     */             //   157: fload_1
/*     */             //   158: invokevirtual selectNodes : (Lcom/badlogic/gdx/utils/Array;FF)V
/*     */             //   161: aload_0
/*     */             //   162: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   165: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   168: invokevirtual items : ()Lcom/badlogic/gdx/utils/OrderedSet;
/*     */             //   171: invokevirtual orderedItems : ()Lcom/badlogic/gdx/utils/Array;
/*     */             //   174: invokevirtual reverse : ()V
/*     */             //   177: aload_0
/*     */             //   178: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   181: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   184: invokevirtual fireChangeEvent : ()Z
/*     */             //   187: pop
/*     */             //   188: aload_0
/*     */             //   189: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   192: aload_3
/*     */             //   193: putfield rangeStart : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   196: return
/*     */             //   197: aload_1
/*     */             //   198: getfield children : Lcom/badlogic/gdx/utils/Array;
/*     */             //   201: getfield size : I
/*     */             //   204: ifle -> 284
/*     */             //   207: aload_0
/*     */             //   208: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   211: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   214: invokevirtual getMultiple : ()Z
/*     */             //   217: ifeq -> 226
/*     */             //   220: invokestatic ctrl : ()Z
/*     */             //   223: ifne -> 284
/*     */             //   226: aload_1
/*     */             //   227: getfield actor : Lcom/badlogic/gdx/scenes/scene2d/Actor;
/*     */             //   230: invokevirtual getX : ()F
/*     */             //   233: fstore_3
/*     */             //   234: aload_1
/*     */             //   235: getfield icon : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */             //   238: ifnull -> 261
/*     */             //   241: fload_3
/*     */             //   242: aload_0
/*     */             //   243: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   246: getfield iconSpacingRight : F
/*     */             //   249: aload_1
/*     */             //   250: getfield icon : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
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
/*     */             //   269: getfield expanded : Z
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
/*     */             //   293: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   296: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   299: aload_1
/*     */             //   300: invokevirtual choose : (Ljava/lang/Object;)V
/*     */             //   303: aload_0
/*     */             //   304: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   307: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */             //   310: invokevirtual isEmpty : ()Z
/*     */             //   313: ifne -> 324
/*     */             //   316: aload_0
/*     */             //   317: getfield this$0 : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree;
/*     */             //   320: aload_1
/*     */             //   321: putfield rangeStart : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */             //   324: return
/*     */             // Line number table:
/*     */             //   Java source line number -> byte code offset
/*     */             //   #89	-> 0
/*     */             //   #90	-> 9
/*     */             //   #91	-> 14
/*     */             //   #92	-> 30
/*     */             //   #94	-> 62
/*     */             //   #95	-> 80
/*     */             //   #96	-> 88
/*     */             //   #97	-> 104
/*     */             //   #98	-> 120
/*     */             //   #99	-> 126
/*     */             //   #101	-> 145
/*     */             //   #102	-> 161
/*     */             //   #105	-> 177
/*     */             //   #106	-> 188
/*     */             //   #107	-> 196
/*     */             //   #109	-> 197
/*     */             //   #111	-> 226
/*     */             //   #112	-> 234
/*     */             //   #113	-> 261
/*     */             //   #114	-> 267
/*     */             //   #115	-> 283
/*     */             //   #118	-> 284
/*     */             //   #119	-> 292
/*     */             //   #120	-> 303
/*     */             //   #121	-> 324
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
/* 124 */             Tree.this.setOverNode(Tree.this.getNodeAt(param1Float2));
/* 125 */             return false;
/*     */           }
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 129 */             super.enter(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/* 130 */             Tree.this.setOverNode(Tree.this.getNodeAt(param1Float2));
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 134 */             super.exit(param1InputEvent, param1Float1, param1Float2, param1Int, param1Actor);
/* 135 */             if (param1Actor == null || !param1Actor.isDescendantOf((Actor)Tree.this)) Tree.this.setOverNode((Object)null); 
/*     */           }
/*     */         }));
/*     */   }
/*     */   
/*     */   public void setStyle(TreeStyle paramTreeStyle) {
/* 141 */     this.style = paramTreeStyle;
/*     */ 
/*     */     
/* 144 */     if (this.indentSpacing == 0.0F) this.indentSpacing = plusMinusWidth(); 
/*     */   }
/*     */   
/*     */   public void add(N paramN) {
/* 148 */     insert(this.rootNodes.size, paramN);
/*     */   }
/*     */   public void insert(int paramInt, N paramN) {
/*     */     int i;
/* 152 */     if (((Node)paramN).parent != null) {
/* 153 */       ((Node)paramN).parent.remove(paramN);
/* 154 */       ((Node)paramN).parent = null;
/*     */     
/*     */     }
/* 157 */     else if ((i = this.rootNodes.indexOf(paramN, true)) != -1) {
/* 158 */       if (i == paramInt)
/* 159 */         return;  if (i < paramInt) paramInt--; 
/* 160 */       this.rootNodes.removeIndex(i);
/*     */       
/* 162 */       if ((i = ((Node)paramN).actor.getZIndex()) != -1) paramN.removeFromTree(this, i);
/*     */     
/*     */     } 
/*     */     
/* 166 */     this.rootNodes.insert(paramInt, paramN);
/*     */ 
/*     */     
/* 169 */     if (paramInt == 0) {
/* 170 */       i = 0;
/* 171 */     } else if (paramInt < this.rootNodes.size - 1) {
/* 172 */       i = ((Node)this.rootNodes.get(paramInt + 1)).actor.getZIndex();
/*     */     } else {
/*     */       Node node;
/* 175 */       i = (node = (Node)this.rootNodes.get(paramInt - 1)).actor.getZIndex() + node.countActors();
/*     */     } 
/* 177 */     paramN.addToTree(this, i);
/*     */   }
/*     */   
/*     */   public void remove(N paramN) {
/* 181 */     if (((Node)paramN).parent != null) {
/* 182 */       ((Node)paramN).parent.remove(paramN);
/*     */       return;
/*     */     } 
/* 185 */     if (!this.rootNodes.removeValue(paramN, true))
/*     */       return;  int i;
/* 187 */     if ((i = ((Node)paramN).actor.getZIndex()) != -1) paramN.removeFromTree(this, i);
/*     */   
/*     */   }
/*     */   
/*     */   public void clearChildren(boolean paramBoolean) {
/* 192 */     super.clearChildren(paramBoolean);
/* 193 */     setOverNode((N)null);
/* 194 */     this.rootNodes.clear();
/* 195 */     this.selection.clear();
/*     */   }
/*     */   
/*     */   public void invalidate() {
/* 199 */     super.invalidate();
/* 200 */     this.sizeInvalid = true;
/*     */   }
/*     */   
/*     */   private float plusMinusWidth() {
/* 204 */     float f = Math.max(this.style.plus.getMinWidth(), this.style.minus.getMinWidth());
/* 205 */     if (this.style.plusOver != null) f = Math.max(f, this.style.plusOver.getMinWidth()); 
/* 206 */     if (this.style.minusOver != null) f = Math.max(f, this.style.minusOver.getMinWidth()); 
/* 207 */     return f;
/*     */   }
/*     */   
/*     */   private void computeSize() {
/* 211 */     this.sizeInvalid = false;
/* 212 */     this.prefWidth = plusMinusWidth();
/* 213 */     this.prefHeight = 0.0F;
/* 214 */     computeSize(this.rootNodes, 0.0F, this.prefWidth);
/* 215 */     this.prefWidth += this.paddingLeft + this.paddingRight;
/*     */   }
/*     */   
/*     */   private void computeSize(Array<N> paramArray, float paramFloat1, float paramFloat2) {
/* 219 */     float f1 = this.ySpacing;
/* 220 */     float f2 = this.iconSpacingLeft + this.iconSpacingRight; byte b; int i;
/* 221 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 222 */       Layout layout; Node node = (Node)paramArray.get(b);
/* 223 */       float f = paramFloat1 + paramFloat2;
/*     */       A a;
/* 225 */       if (a = node.actor instanceof Layout) {
/* 226 */         layout = (Layout)a;
/* 227 */         f += layout.getPrefWidth();
/* 228 */         node.height = layout.getPrefHeight();
/*     */       } else {
/* 230 */         f += layout.getWidth();
/* 231 */         node.height = layout.getHeight();
/*     */       } 
/* 233 */       if (node.icon != null) {
/* 234 */         f += f2 + node.icon.getMinWidth();
/* 235 */         node.height = Math.max(node.height, node.icon.getMinHeight());
/*     */       } 
/* 237 */       this.prefWidth = Math.max(this.prefWidth, f);
/* 238 */       this.prefHeight += node.height + f1;
/* 239 */       if (node.expanded) computeSize(node.children, paramFloat1 + this.indentSpacing, paramFloat2); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void layout() {
/* 244 */     if (this.sizeInvalid) computeSize(); 
/* 245 */     layout(this.rootNodes, this.paddingLeft, getHeight() - this.ySpacing / 2.0F, plusMinusWidth());
/*     */   }
/*     */   
/*     */   private float layout(Array<N> paramArray, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 249 */     float f1 = this.ySpacing;
/*     */     
/* 251 */     float f2, f3 = (f2 = this.iconSpacingLeft) + this.iconSpacingRight; byte b; int i;
/* 252 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 253 */       Node node = (Node)paramArray.get(b);
/* 254 */       float f = paramFloat1 + paramFloat3;
/* 255 */       if (node.icon != null) {
/* 256 */         f += f3 + node.icon.getMinWidth();
/*     */       } else {
/* 258 */         f += f2;
/* 259 */       }  if (node.actor instanceof Layout) ((Layout)node.actor).pack(); 
/* 260 */       paramFloat2 -= node.getHeight();
/* 261 */       node.actor.setPosition(f, paramFloat2);
/* 262 */       paramFloat2 -= f1;
/* 263 */       if (node.expanded) paramFloat2 = layout(node.children, paramFloat1 + this.indentSpacing, paramFloat2, paramFloat3); 
/*     */     } 
/* 265 */     return paramFloat2;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 269 */     drawBackground(paramBatch, paramFloat);
/*     */     Color color;
/* 271 */     float f = (color = getColor()).a * paramFloat;
/* 272 */     paramBatch.setColor(color.r, color.g, color.b, f);
/* 273 */     drawIcons(paramBatch, color.r, color.g, color.b, f, (N)null, this.rootNodes, this.paddingLeft, plusMinusWidth());
/* 274 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void drawBackground(Batch paramBatch, float paramFloat) {
/* 279 */     if (this.style.background != null) {
/* 280 */       Color color = getColor();
/* 281 */       paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/* 282 */       this.style.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
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
/*     */   protected float drawIcons(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, @Null N paramN, Array<N> paramArray, float paramFloat5, float paramFloat6) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual getCullingArea : ()Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   4: astore #6
/*     */     //   6: fconst_0
/*     */     //   7: fstore #10
/*     */     //   9: fconst_0
/*     */     //   10: fstore #11
/*     */     //   12: aload #6
/*     */     //   14: ifnull -> 33
/*     */     //   17: aload #6
/*     */     //   19: getfield y : F
/*     */     //   22: dup
/*     */     //   23: fstore #10
/*     */     //   25: aload #6
/*     */     //   27: getfield height : F
/*     */     //   30: fadd
/*     */     //   31: fstore #11
/*     */     //   33: aload_0
/*     */     //   34: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$TreeStyle;
/*     */     //   37: astore #12
/*     */     //   39: aload_0
/*     */     //   40: invokevirtual getX : ()F
/*     */     //   43: fstore #13
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual getY : ()F
/*     */     //   49: fstore #14
/*     */     //   51: fload #13
/*     */     //   53: fload #8
/*     */     //   55: fadd
/*     */     //   56: dup
/*     */     //   57: fstore #15
/*     */     //   59: fload #9
/*     */     //   61: fadd
/*     */     //   62: aload_0
/*     */     //   63: getfield iconSpacingLeft : F
/*     */     //   66: fadd
/*     */     //   67: fstore #16
/*     */     //   69: fconst_0
/*     */     //   70: fstore #17
/*     */     //   72: iconst_0
/*     */     //   73: istore #18
/*     */     //   75: aload #7
/*     */     //   77: getfield size : I
/*     */     //   80: istore #19
/*     */     //   82: iload #18
/*     */     //   84: iload #19
/*     */     //   86: if_icmpge -> 477
/*     */     //   89: aload #7
/*     */     //   91: iload #18
/*     */     //   93: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   96: checkcast com/badlogic/gdx/scenes/scene2d/ui/Tree$Node
/*     */     //   99: dup
/*     */     //   100: astore #20
/*     */     //   102: getfield actor : Lcom/badlogic/gdx/scenes/scene2d/Actor;
/*     */     //   105: dup
/*     */     //   106: astore #21
/*     */     //   108: invokevirtual getY : ()F
/*     */     //   111: fstore #17
/*     */     //   113: aload #20
/*     */     //   115: getfield height : F
/*     */     //   118: fstore #22
/*     */     //   120: aload #6
/*     */     //   122: ifnull -> 144
/*     */     //   125: fload #17
/*     */     //   127: fload #22
/*     */     //   129: fadd
/*     */     //   130: fload #10
/*     */     //   132: fcmpl
/*     */     //   133: iflt -> 417
/*     */     //   136: fload #17
/*     */     //   138: fload #11
/*     */     //   140: fcmpg
/*     */     //   141: ifgt -> 417
/*     */     //   144: aload_0
/*     */     //   145: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Selection;
/*     */     //   148: aload #20
/*     */     //   150: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   153: ifeq -> 204
/*     */     //   156: aload #12
/*     */     //   158: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   161: ifnull -> 204
/*     */     //   164: aload_0
/*     */     //   165: aload #20
/*     */     //   167: aload #12
/*     */     //   169: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   172: aload_1
/*     */     //   173: fload #13
/*     */     //   175: fload #14
/*     */     //   177: fload #17
/*     */     //   179: fadd
/*     */     //   180: aload_0
/*     */     //   181: getfield ySpacing : F
/*     */     //   184: fconst_2
/*     */     //   185: fdiv
/*     */     //   186: fsub
/*     */     //   187: aload_0
/*     */     //   188: invokevirtual getWidth : ()F
/*     */     //   191: fload #22
/*     */     //   193: aload_0
/*     */     //   194: getfield ySpacing : F
/*     */     //   197: fadd
/*     */     //   198: invokevirtual drawSelection : (Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FFFF)V
/*     */     //   201: goto -> 258
/*     */     //   204: aload #20
/*     */     //   206: aload_0
/*     */     //   207: getfield overNode : Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;
/*     */     //   210: if_acmpne -> 258
/*     */     //   213: aload #12
/*     */     //   215: getfield over : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   218: ifnull -> 258
/*     */     //   221: aload_0
/*     */     //   222: aload #20
/*     */     //   224: aload #12
/*     */     //   226: getfield over : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   229: aload_1
/*     */     //   230: fload #13
/*     */     //   232: fload #14
/*     */     //   234: fload #17
/*     */     //   236: fadd
/*     */     //   237: aload_0
/*     */     //   238: getfield ySpacing : F
/*     */     //   241: fconst_2
/*     */     //   242: fdiv
/*     */     //   243: fsub
/*     */     //   244: aload_0
/*     */     //   245: invokevirtual getWidth : ()F
/*     */     //   248: fload #22
/*     */     //   250: aload_0
/*     */     //   251: getfield ySpacing : F
/*     */     //   254: fadd
/*     */     //   255: invokevirtual drawOver : (Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FFFF)V
/*     */     //   258: aload #20
/*     */     //   260: getfield icon : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   263: ifnull -> 356
/*     */     //   266: fload #14
/*     */     //   268: fload #17
/*     */     //   270: fadd
/*     */     //   271: fload #22
/*     */     //   273: aload #20
/*     */     //   275: getfield icon : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   278: invokeinterface getMinHeight : ()F
/*     */     //   283: fsub
/*     */     //   284: fconst_2
/*     */     //   285: fdiv
/*     */     //   286: invokestatic round : (F)I
/*     */     //   289: i2f
/*     */     //   290: fadd
/*     */     //   291: fstore #23
/*     */     //   293: aload #21
/*     */     //   295: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   298: astore #21
/*     */     //   300: aload_1
/*     */     //   301: aload #21
/*     */     //   303: getfield r : F
/*     */     //   306: aload #21
/*     */     //   308: getfield g : F
/*     */     //   311: aload #21
/*     */     //   313: getfield b : F
/*     */     //   316: aload #21
/*     */     //   318: getfield a : F
/*     */     //   321: fload #5
/*     */     //   323: fmul
/*     */     //   324: invokeinterface setColor : (FFFF)V
/*     */     //   329: aload_0
/*     */     //   330: aload #20
/*     */     //   332: dup
/*     */     //   333: getfield icon : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   336: aload_1
/*     */     //   337: fload #16
/*     */     //   339: fload #23
/*     */     //   341: invokevirtual drawIcon : (Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FF)V
/*     */     //   344: aload_1
/*     */     //   345: fload_2
/*     */     //   346: fload_3
/*     */     //   347: fload #4
/*     */     //   349: fload #5
/*     */     //   351: invokeinterface setColor : (FFFF)V
/*     */     //   356: aload #20
/*     */     //   358: getfield children : Lcom/badlogic/gdx/utils/Array;
/*     */     //   361: getfield size : I
/*     */     //   364: ifle -> 425
/*     */     //   367: aload_0
/*     */     //   368: aload #20
/*     */     //   370: fload #16
/*     */     //   372: invokevirtual getExpandIcon : (Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;F)Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   375: astore #23
/*     */     //   377: fload #14
/*     */     //   379: fload #17
/*     */     //   381: fadd
/*     */     //   382: fload #22
/*     */     //   384: aload #23
/*     */     //   386: invokeinterface getMinHeight : ()F
/*     */     //   391: fsub
/*     */     //   392: fconst_2
/*     */     //   393: fdiv
/*     */     //   394: invokestatic round : (F)I
/*     */     //   397: i2f
/*     */     //   398: fadd
/*     */     //   399: fstore #21
/*     */     //   401: aload_0
/*     */     //   402: aload #20
/*     */     //   404: aload #23
/*     */     //   406: aload_1
/*     */     //   407: fload #15
/*     */     //   409: fload #21
/*     */     //   411: invokevirtual drawExpandIcon : (Lcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;Lcom/badlogic/gdx/graphics/g2d/Batch;FF)V
/*     */     //   414: goto -> 425
/*     */     //   417: fload #17
/*     */     //   419: fload #10
/*     */     //   421: fcmpg
/*     */     //   422: iflt -> 477
/*     */     //   425: aload #20
/*     */     //   427: getfield expanded : Z
/*     */     //   430: ifeq -> 471
/*     */     //   433: aload #20
/*     */     //   435: getfield children : Lcom/badlogic/gdx/utils/Array;
/*     */     //   438: getfield size : I
/*     */     //   441: ifle -> 471
/*     */     //   444: aload_0
/*     */     //   445: aload_1
/*     */     //   446: fload_2
/*     */     //   447: fload_3
/*     */     //   448: fload #4
/*     */     //   450: fload #5
/*     */     //   452: aload #20
/*     */     //   454: dup
/*     */     //   455: getfield children : Lcom/badlogic/gdx/utils/Array;
/*     */     //   458: fload #8
/*     */     //   460: aload_0
/*     */     //   461: getfield indentSpacing : F
/*     */     //   464: fadd
/*     */     //   465: fload #9
/*     */     //   467: invokevirtual drawIcons : (Lcom/badlogic/gdx/graphics/g2d/Batch;FFFFLcom/badlogic/gdx/scenes/scene2d/ui/Tree$Node;Lcom/badlogic/gdx/utils/Array;FF)F
/*     */     //   470: pop
/*     */     //   471: iinc #18, 1
/*     */     //   474: goto -> 82
/*     */     //   477: fload #17
/*     */     //   479: freturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #292	-> 0
/*     */     //   #293	-> 6
/*     */     //   #294	-> 12
/*     */     //   #295	-> 17
/*     */     //   #296	-> 23
/*     */     //   #298	-> 33
/*     */     //   #299	-> 39
/*     */     //   #300	-> 72
/*     */     //   #301	-> 89
/*     */     //   #302	-> 100
/*     */     //   #303	-> 106
/*     */     //   #304	-> 113
/*     */     //   #305	-> 120
/*     */     //   #306	-> 144
/*     */     //   #307	-> 164
/*     */     //   #308	-> 204
/*     */     //   #309	-> 221
/*     */     //   #312	-> 258
/*     */     //   #313	-> 266
/*     */     //   #314	-> 293
/*     */     //   #315	-> 300
/*     */     //   #316	-> 329
/*     */     //   #317	-> 344
/*     */     //   #320	-> 356
/*     */     //   #321	-> 367
/*     */     //   #322	-> 377
/*     */     //   #323	-> 401
/*     */     //   #324	-> 414
/*     */     //   #325	-> 417
/*     */     //   #327	-> 425
/*     */     //   #328	-> 444
/*     */     //   #300	-> 471
/*     */     //   #330	-> 477
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
/*     */   protected void drawSelection(N paramN, Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 334 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   protected void drawOver(N paramN, Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 338 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   protected void drawExpandIcon(N paramN, Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 342 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramDrawable.getMinWidth(), paramDrawable.getMinHeight());
/*     */   }
/*     */   
/*     */   protected void drawIcon(N paramN, Drawable paramDrawable, Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 346 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramDrawable.getMinWidth(), paramDrawable.getMinHeight());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Drawable getExpandIcon(N paramN, float paramFloat) {
/* 354 */     if (paramN == this.overNode && Gdx.app
/* 355 */       .getType() == Application.ApplicationType.Desktop && (
/* 356 */       !this.selection.getMultiple() || (!UIUtils.ctrl() && !UIUtils.shift()))) {
/*     */       float f;
/*     */       
/* 359 */       if ((f = (screenToLocalCoordinates(tmp.set(Gdx.input.getX(), 0.0F))).x + getX()) >= 0.0F && f < paramFloat) {
/*     */         Drawable drawable;
/* 361 */         if ((drawable = (Drawable)(((Node)paramN).expanded ? this.style.minusOver : this.style.plusOver)) != null) return drawable; 
/*     */       } 
/*     */     } 
/* 364 */     return ((Node)paramN).expanded ? this.style.minus : this.style.plus;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N getNodeAt(float paramFloat) {
/* 369 */     this.foundNode = null;
/* 370 */     getNodeAt(this.rootNodes, paramFloat, getHeight());
/*     */     try {
/* 372 */       return this.foundNode;
/*     */     } finally {
/* 374 */       this.foundNode = null;
/*     */     } 
/*     */   }
/*     */   private float getNodeAt(Array<N> paramArray, float paramFloat1, float paramFloat2) { byte b;
/*     */     int i;
/* 379 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node node;
/* 381 */       float f = (node = (Node)paramArray.get(b)).height;
/* 382 */       paramFloat2 -= node.getHeight() - f;
/* 383 */       if (paramFloat1 >= paramFloat2 - f - this.ySpacing && paramFloat1 < paramFloat2) {
/* 384 */         this.foundNode = (N)node;
/* 385 */         return -1.0F;
/*     */       } 
/* 387 */       paramFloat2 -= f + this.ySpacing;
/* 388 */       if (node.expanded && (
/*     */         
/* 390 */         paramFloat2 = getNodeAt(node.children, paramFloat1, paramFloat2)) == -1.0F) return -1.0F;
/*     */     
/*     */     } 
/* 393 */     return paramFloat2; } void selectNodes(Array<N> paramArray, float paramFloat1, float paramFloat2) {
/*     */     byte b;
/*     */     int i;
/*     */     Node node;
/* 397 */     for (b = 0, i = paramArray.size; b < i && 
/*     */       
/* 399 */       (node = (Node)paramArray.get(b)).actor.getY() >= paramFloat1; b++) {
/* 400 */       if (node.isSelectable()) {
/* 401 */         if (node.actor.getY() <= paramFloat2) this.selection.add(node); 
/* 402 */         if (node.expanded) selectNodes(node.children, paramFloat1, paramFloat2); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public Selection<N> getSelection() {
/* 407 */     return this.selection;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N getSelectedNode() {
/* 412 */     return (N)this.selection.first();
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V getSelectedValue() {
/*     */     Node node;
/* 418 */     return (V)(((node = (Node)this.selection.first()) == null) ? null : node.getValue());
/*     */   }
/*     */   
/*     */   public TreeStyle getStyle() {
/* 422 */     return this.style;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<N> getRootNodes() {
/* 428 */     return this.rootNodes;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public Array<N> getNodes() {
/* 434 */     return this.rootNodes;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateRootNodes() {
/*     */     byte b;
/*     */     int i;
/* 441 */     for (b = 0, i = this.rootNodes.size; b < i; b++) {
/*     */       Node node;
/*     */       int k;
/* 444 */       if ((k = (node = (Node)this.rootNodes.get(b)).actor.getZIndex()) != -1) node.removeFromTree(this, k); 
/*     */     }  int j;
/* 446 */     for (b = 0, i = this.rootNodes.size, j = 0; b < i; b++)
/* 447 */       j += ((Node)this.rootNodes.get(b)).addToTree(this, j); 
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N getOverNode() {
/* 452 */     return this.overNode;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public V getOverValue() {
/* 457 */     if (this.overNode == null) return null; 
/* 458 */     return (V)this.overNode.getValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOverNode(@Null N paramN) {
/* 463 */     this.overNode = paramN;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadding(float paramFloat) {
/* 468 */     this.paddingLeft = paramFloat;
/* 469 */     this.paddingRight = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPadding(float paramFloat1, float paramFloat2) {
/* 474 */     this.paddingLeft = paramFloat1;
/* 475 */     this.paddingRight = paramFloat2;
/*     */   }
/*     */   
/*     */   public void setIndentSpacing(float paramFloat) {
/* 479 */     this.indentSpacing = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getIndentSpacing() {
/* 484 */     return this.indentSpacing;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setYSpacing(float paramFloat) {
/* 489 */     this.ySpacing = paramFloat;
/*     */   }
/*     */   
/*     */   public float getYSpacing() {
/* 493 */     return this.ySpacing;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIconSpacing(float paramFloat1, float paramFloat2) {
/* 499 */     this.iconSpacingLeft = paramFloat1;
/* 500 */     this.iconSpacingRight = paramFloat2;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 504 */     if (this.sizeInvalid) computeSize(); 
/* 505 */     return this.prefWidth;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 509 */     if (this.sizeInvalid) computeSize(); 
/* 510 */     return this.prefHeight;
/*     */   }
/*     */   
/*     */   public void findExpandedValues(Array<V> paramArray) {
/* 514 */     findExpandedValues(this.rootNodes, paramArray);
/*     */   } public void restoreExpandedValues(Array<V> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 518 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       N n;
/* 520 */       if ((n = findNode((V)paramArray.get(b))) != null) {
/* 521 */         n.setExpanded(true);
/* 522 */         n.expandTo();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   static boolean findExpandedValues(Array<? extends Node> paramArray, Array paramArray1) {
/*     */     byte b;
/*     */     int i;
/* 529 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node node;
/* 531 */       if ((node = (Node)paramArray.get(b)).expanded && !findExpandedValues(node.children, paramArray1)) paramArray1.add(node.value); 
/*     */     } 
/* 533 */     return false;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public N findNode(V paramV) {
/* 538 */     if (paramV == null) throw new IllegalArgumentException("value cannot be null."); 
/* 539 */     return (N)findNode(this.rootNodes, paramV); } @Null
/*     */   static Node findNode(Array<? extends Node> paramArray, Object paramObject) {
/*     */     byte b;
/*     */     int i;
/* 543 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 544 */       Node node = (Node)paramArray.get(b);
/* 545 */       if (paramObject.equals(node.value)) return node; 
/*     */     } 
/* 547 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node node;
/*     */       
/* 550 */       if ((node = findNode((node = (Node)paramArray.get(b)).children, paramObject)) != null) return node; 
/*     */     } 
/* 552 */     return null;
/*     */   }
/*     */   
/*     */   public void collapseAll() {
/* 556 */     collapseAll(this.rootNodes);
/*     */   } static void collapseAll(Array<? extends Node> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 560 */     for (b = 0, i = paramArray.size; b < i; b++) {
/*     */       Node<Node, ?, Actor> node;
/* 562 */       (node = (Node<Node, ?, Actor>)paramArray.get(b)).setExpanded(false);
/* 563 */       collapseAll(node.children);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void expandAll() {
/* 568 */     expandAll(this.rootNodes);
/*     */   } static void expandAll(Array<? extends Node> paramArray) {
/*     */     byte b;
/*     */     int i;
/* 572 */     for (b = 0, i = paramArray.size; b < i; b++) {
/* 573 */       ((Node)paramArray.get(b)).expandAll();
/*     */     }
/*     */   }
/*     */   
/*     */   public ClickListener getClickListener() {
/* 578 */     return this.clickListener;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class Node<N extends Node, V, A extends Actor>
/*     */   {
/*     */     A actor;
/*     */ 
/*     */     
/*     */     N parent;
/*     */ 
/*     */     
/* 591 */     final Array<N> children = new Array(0);
/*     */     boolean selectable = true;
/*     */     boolean expanded;
/*     */     Drawable icon;
/*     */     float height;
/*     */     V value;
/*     */     
/*     */     public Node(A param1A) {
/* 599 */       if (param1A == null) throw new IllegalArgumentException("actor cannot be null."); 
/* 600 */       this.actor = param1A;
/*     */     }
/*     */ 
/*     */     
/*     */     public Node() {}
/*     */ 
/*     */     
/*     */     public void setExpanded(boolean param1Boolean) {
/* 608 */       if (param1Boolean == this.expanded)
/* 609 */         return;  this.expanded = param1Boolean;
/* 610 */       if (this.children.size == 0)
/*     */         return;  Tree<N, V> tree;
/* 612 */       if ((tree = getTree()) == null)
/* 613 */         return;  Object[] arrayOfObject = this.children.items;
/* 614 */       int i = this.actor.getZIndex() + 1;
/* 615 */       if (param1Boolean) {
/* 616 */         int k; for (param1Boolean = false, k = this.children.size; param1Boolean < k; param1Boolean++)
/* 617 */           i += ((Node<N, V, Actor>)arrayOfObject[param1Boolean]).addToTree(tree, i);  return;
/*     */       }  int j;
/* 619 */       for (param1Boolean = false, j = this.children.size; param1Boolean < j; param1Boolean++) {
/* 620 */         ((Node<N, V, Actor>)arrayOfObject[param1Boolean]).removeFromTree(tree, i);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected int addToTree(Tree<N, V> param1Tree, int param1Int) {
/* 627 */       param1Tree.addActorAt(param1Int, (Actor)this.actor);
/* 628 */       if (!this.expanded) return 1; 
/* 629 */       int i = param1Int + 1;
/* 630 */       Object[] arrayOfObject = this.children.items; byte b; int j;
/* 631 */       for (b = 0, j = this.children.size; b < j; b++)
/* 632 */         i += ((Node<N, V, Actor>)arrayOfObject[b]).addToTree(param1Tree, i); 
/* 633 */       return i - param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void removeFromTree(Tree<N, V> param1Tree, int param1Int) {
/* 638 */       param1Tree.removeActorAt(param1Int, true);
/*     */       
/* 640 */       if (!this.expanded)
/* 641 */         return;  Object[] arrayOfObject = this.children.items; byte b; int i;
/* 642 */       for (b = 0, i = this.children.size; b < i; b++)
/* 643 */         ((Node<N, V, Actor>)arrayOfObject[b]).removeFromTree(param1Tree, param1Int); 
/*     */     }
/*     */     
/*     */     public void add(N param1N) {
/* 647 */       insert(this.children.size, param1N);
/*     */     } public void addAll(Array<N> param1Array) {
/*     */       byte b;
/*     */       int i;
/* 651 */       for (b = 0, i = param1Array.size; b < i; b++)
/* 652 */         insert(this.children.size, (N)param1Array.get(b)); 
/*     */     }
/*     */     
/*     */     public void insert(int param1Int, N param1N) {
/* 656 */       ((Node)param1N).parent = (N)this;
/* 657 */       this.children.insert(param1Int, param1N);
/* 658 */       if (!this.expanded)
/*     */         return;  Tree<N, V> tree;
/* 660 */       if ((tree = getTree()) != null) {
/*     */         int i;
/* 662 */         if (param1Int == 0) {
/* 663 */           param1Int = this.actor.getZIndex() + 1;
/* 664 */         } else if (param1Int < this.children.size - 1) {
/* 665 */           param1Int = ((Node)this.children.get(param1Int + 1)).actor.getZIndex();
/*     */         } else {
/*     */           Node node;
/* 668 */           i = (node = (Node)this.children.get(param1Int - 1)).actor.getZIndex() + node.countActors();
/*     */         } 
/* 670 */         param1N.addToTree(tree, i);
/*     */       } 
/*     */     }
/*     */     
/*     */     int countActors() {
/* 675 */       if (!this.expanded) return 1; 
/* 676 */       int i = 1;
/* 677 */       Object[] arrayOfObject = this.children.items; byte b; int j;
/* 678 */       for (b = 0, j = this.children.size; b < j; b++)
/* 679 */         i += ((Node<Node, ?, Actor>)arrayOfObject[b]).countActors(); 
/* 680 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/*     */       Tree<N, V> tree;
/* 686 */       if ((tree = getTree()) != null) {
/* 687 */         tree.remove((N)this); return;
/* 688 */       }  if (this.parent != null) {
/* 689 */         this.parent.remove(this);
/*     */       }
/*     */     }
/*     */     
/*     */     public void remove(N param1N) {
/* 694 */       if (!this.children.removeValue(param1N, true))
/* 695 */         return;  if (!this.expanded)
/*     */         return;  Tree<N, V> tree;
/* 697 */       if ((tree = getTree()) != null) param1N.removeFromTree(tree, ((Node)param1N).actor.getZIndex()); 
/*     */     }
/*     */     
/*     */     public void clearChildren() {
/*     */       Tree<N, V> tree;
/* 702 */       if (this.expanded && (
/*     */         
/* 704 */         tree = getTree()) != null) {
/* 705 */         int i = this.actor.getZIndex() + 1;
/* 706 */         Object[] arrayOfObject = this.children.items; byte b; int j;
/* 707 */         for (b = 0, j = this.children.size; b < j; b++) {
/* 708 */           ((Node<N, V, Actor>)arrayOfObject[b]).removeFromTree(tree, i);
/*     */         }
/*     */       } 
/* 711 */       this.children.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     @Null
/*     */     public Tree<N, V> getTree() {
/*     */       Group group;
/* 718 */       if (group = this.actor.getParent() instanceof Tree) return (Tree<N, V>)group; 
/* 719 */       return null;
/*     */     }
/*     */     public void setActor(A param1A) {
/*     */       Tree<N, V> tree;
/* 723 */       if (this.actor != null && (
/*     */         
/* 725 */         tree = getTree()) != null) {
/* 726 */         int i = this.actor.getZIndex();
/* 727 */         tree.removeActorAt(i, true);
/* 728 */         tree.addActorAt(i, (Actor)param1A);
/*     */       } 
/*     */       
/* 731 */       this.actor = param1A;
/*     */     }
/*     */     
/*     */     public A getActor() {
/* 735 */       return this.actor;
/*     */     }
/*     */     
/*     */     public boolean isExpanded() {
/* 739 */       return this.expanded;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Array<N> getChildren() {
/* 746 */       return this.children;
/*     */     }
/*     */     
/*     */     public boolean hasChildren() {
/* 750 */       return (this.children.size > 0);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void updateChildren() {
/* 757 */       if (!this.expanded)
/*     */         return;  Tree<N, V> tree;
/* 759 */       if ((tree = getTree()) == null)
/* 760 */         return;  Object[] arrayOfObject = this.children.items;
/* 761 */       int i = this.children.size;
/* 762 */       int j = this.actor.getZIndex() + 1; byte b;
/* 763 */       for (b = 0; b < i; b++)
/* 764 */         ((Node<N, V, Actor>)arrayOfObject[b]).removeFromTree(tree, j); 
/* 765 */       for (b = 0; b < i; b++)
/* 766 */         j += ((Node<N, V, Actor>)arrayOfObject[b]).addToTree(tree, j); 
/*     */     }
/*     */     
/*     */     @Null
/*     */     public N getParent() {
/* 771 */       return this.parent;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setIcon(@Null Drawable param1Drawable) {
/* 776 */       this.icon = param1Drawable;
/*     */     }
/*     */     @Null
/*     */     public V getValue() {
/* 780 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setValue(@Null V param1V) {
/* 785 */       this.value = param1V;
/*     */     }
/*     */     @Null
/*     */     public Drawable getIcon() {
/* 789 */       return this.icon;
/*     */     }
/*     */     
/*     */     public int getLevel() {
/* 793 */       byte b = 0;
/* 794 */       Node node = this;
/*     */       do {
/* 796 */         b++;
/*     */       }
/* 798 */       while ((node = (Node)node.getParent()) != null);
/* 799 */       return b;
/*     */     }
/*     */     
/*     */     @Null
/*     */     public N findNode(V param1V) {
/* 804 */       if (param1V == null) throw new IllegalArgumentException("value cannot be null."); 
/* 805 */       if (param1V.equals(this.value)) return (N)this; 
/* 806 */       return (N)Tree.findNode(this.children, param1V);
/*     */     }
/*     */ 
/*     */     
/*     */     public void collapseAll() {
/* 811 */       setExpanded(false);
/* 812 */       Tree.collapseAll(this.children);
/*     */     }
/*     */ 
/*     */     
/*     */     public void expandAll() {
/* 817 */       setExpanded(true);
/* 818 */       if (this.children.size > 0) Tree.expandAll(this.children);
/*     */     
/*     */     }
/*     */     
/*     */     public void expandTo() {
/* 823 */       N n = this.parent;
/* 824 */       while (n != null) {
/* 825 */         n.setExpanded(true);
/* 826 */         n = ((Node)n).parent;
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isSelectable() {
/* 831 */       return this.selectable;
/*     */     }
/*     */     
/*     */     public void setSelectable(boolean param1Boolean) {
/* 835 */       this.selectable = param1Boolean;
/*     */     }
/*     */     
/*     */     public void findExpandedValues(Array<V> param1Array) {
/* 839 */       if (this.expanded && !Tree.findExpandedValues(this.children, param1Array)) param1Array.add(this.value); 
/*     */     } public void restoreExpandedValues(Array<V> param1Array) {
/*     */       byte b;
/*     */       int i;
/* 843 */       for (b = 0, i = param1Array.size; b < i; b++) {
/*     */         N n;
/* 845 */         if ((n = findNode((V)param1Array.get(b))) != null) {
/* 846 */           n.setExpanded(true);
/* 847 */           n.expandTo();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public float getHeight() {
/* 855 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isAscendantOf(N param1N) {
/* 860 */       if (param1N == null) throw new IllegalArgumentException("node cannot be null."); 
/* 861 */       param1N = param1N;
/*     */       while (true) {
/* 863 */         if (param1N == this) return true;
/*     */         
/* 865 */         if ((param1N = ((Node)param1N).parent) == null)
/* 866 */           return false; 
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean isDescendantOf(N param1N) {
/* 871 */       if (param1N == null) throw new IllegalArgumentException("node cannot be null."); 
/* 872 */       Node node = this;
/*     */       while (true) {
/* 874 */         if (node == param1N) return true; 
/*     */         N n;
/* 876 */         if ((n = node.parent) == null)
/* 877 */           return false; 
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
/* 892 */       this.plus = param1Drawable1;
/* 893 */       this.minus = param1Drawable2;
/* 894 */       this.selection = param1Drawable3; } @Null
/*     */     public Drawable over; @Null
/*     */     public Drawable selection; @Null
/*     */     public Drawable background; public TreeStyle() {} public TreeStyle(TreeStyle param1TreeStyle) {
/* 898 */       this.plus = param1TreeStyle.plus;
/* 899 */       this.minus = param1TreeStyle.minus;
/*     */       
/* 901 */       this.plusOver = param1TreeStyle.plusOver;
/* 902 */       this.minusOver = param1TreeStyle.minusOver;
/*     */       
/* 904 */       this.over = param1TreeStyle.over;
/* 905 */       this.selection = param1TreeStyle.selection;
/* 906 */       this.background = param1TreeStyle.background;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Tree.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */