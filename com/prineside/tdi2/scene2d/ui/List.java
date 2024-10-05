/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.OrderedSet;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.utils.ArraySelection;
/*     */ import com.prineside.tdi2.scene2d.utils.Cullable;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
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
/*     */ public class List<T>
/*     */   extends Widget
/*     */   implements Cullable
/*     */ {
/*     */   private ListStyle o;
/*  49 */   final Array<T> j = new Array();
/*  50 */   ArraySelection<T> k = new ArraySelection(this.j); private Rectangle p;
/*     */   private float q;
/*     */   private float r;
/*     */   private float s;
/*  54 */   private int t = 8;
/*  55 */   int l = -1; int m = -1;
/*     */   private InputListener u;
/*     */   boolean n;
/*     */   
/*     */   public List(ListStyle paramListStyle) {
/*  60 */     this.k.setActor(this);
/*  61 */     this.k.setRequired(true);
/*     */     
/*  63 */     setStyle(paramListStyle);
/*  64 */     setSize(getPrefWidth(), getPrefHeight());
/*     */     
/*  66 */     addListener((EventListener)(this.u = new InputListener(this) { private long a;
/*     */           private String b;
/*     */           
/*     */           public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/*     */             int i;
/*  71 */             if (this.c.j.isEmpty()) return false;
/*     */             
/*  73 */             switch (param1Int) {
/*     */               case 29:
/*  75 */                 if (UIUtils.ctrl() && this.c.k.getMultiple()) {
/*  76 */                   this.c.k.clear();
/*  77 */                   this.c.k.addAll(this.c.j);
/*  78 */                   return true;
/*     */                 } 
/*     */                 break;
/*     */               case 3:
/*  82 */                 this.c.setSelectedIndex(0);
/*  83 */                 return true;
/*     */               case 123:
/*  85 */                 this.c.setSelectedIndex(this.c.j.size - 1);
/*  86 */                 return true;
/*     */               
/*     */               case 20:
/*  89 */                 if ((i = this.c.j.indexOf(this.c.getSelected(), false) + 1) >= this.c.j.size) i = 0; 
/*  90 */                 this.c.setSelectedIndex(i);
/*  91 */                 return true;
/*     */               
/*     */               case 19:
/*  94 */                 if ((i = this.c.j.indexOf(this.c.getSelected(), false) - 1) < 0) i = this.c.j.size - 1; 
/*  95 */                 this.c.setSelectedIndex(i);
/*  96 */                 return true;
/*     */               case 111:
/*  98 */                 if (this.c.getStage() != null) this.c.getStage().setKeyboardFocus(null); 
/*  99 */                 return true;
/*     */             } 
/* 101 */             return false;
/*     */           }
/*     */           
/*     */           public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 105 */             if (!this.c.n) return false; 
/*     */             long l;
/* 107 */             if ((l = System.currentTimeMillis()) > this.a) this.b = ""; 
/* 108 */             this.a = l + 300L;
/* 109 */             this.b += Character.toLowerCase(param1Char); byte b; int i;
/* 110 */             for (b = 0, i = this.c.j.size; b < i; b++) {
/* 111 */               if (this.c.toString(this.c.j.get(b)).toLowerCase().startsWith(this.b)) {
/* 112 */                 this.c.setSelectedIndex(b);
/*     */                 break;
/*     */               } 
/*     */             } 
/* 116 */             return false;
/*     */           } }
/*     */         ));
/*     */     
/* 120 */     addListener((EventListener)new InputListener(this) {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 122 */             if (param1Int1 != 0 || param1Int2 != 0) return true; 
/* 123 */             if (this.a.k.isDisabled()) return true; 
/* 124 */             if (this.a.getStage() != null) this.a.getStage().setKeyboardFocus(this.a); 
/* 125 */             if (this.a.j.size == 0) return true; 
/*     */             int i;
/* 127 */             if ((i = this.a.getItemIndexAt(param1Float2)) == -1) return true; 
/* 128 */             this.a.k.choose(this.a.j.get(i));
/* 129 */             this.a.l = i;
/* 130 */             return true;
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 134 */             if (param1Int1 != 0 || param1Int2 != 0)
/* 135 */               return;  this.a.l = -1;
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 139 */             this.a.m = this.a.getItemIndexAt(param1Float2);
/*     */           }
/*     */           
/*     */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 143 */             this.a.m = this.a.getItemIndexAt(param1Float2);
/* 144 */             return false;
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 148 */             if (param1Int == 0) this.a.l = -1; 
/* 149 */             if (param1Int == -1) this.a.m = -1; 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setStyle(ListStyle paramListStyle) {
/* 155 */     if (paramListStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 156 */     this.o = paramListStyle;
/* 157 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListStyle getStyle() {
/* 163 */     return this.o;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 167 */     BitmapFont bitmapFont = this.o.font;
/* 168 */     Drawable drawable1 = this.o.selection;
/*     */     
/* 170 */     this.s = bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0F;
/* 171 */     this.s += drawable1.getTopHeight() + drawable1.getBottomHeight();
/*     */     
/* 173 */     this.q = 0.0F;
/*     */     Pool pool;
/* 175 */     GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 176 */     for (byte b = 0; b < this.j.size; b++) {
/* 177 */       glyphLayout.setText(bitmapFont, toString((T)this.j.get(b)));
/* 178 */       this.q = Math.max(glyphLayout.width, this.q);
/*     */     } 
/* 180 */     pool.free(glyphLayout);
/* 181 */     this.q += drawable1.getLeftWidth() + drawable1.getRightWidth();
/* 182 */     this.r = this.j.size * this.s;
/*     */     
/*     */     Drawable drawable2;
/* 185 */     if ((drawable2 = this.o.background) != null) {
/* 186 */       this.q = Math.max(this.q + drawable2.getLeftWidth() + drawable2.getRightWidth(), drawable2.getMinWidth());
/* 187 */       this.r = Math.max(this.r + drawable2.getTopHeight() + drawable2.getBottomHeight(), drawable2.getMinHeight());
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokevirtual validate : ()V
/*     */     //   4: aload_0
/*     */     //   5: aload_1
/*     */     //   6: fload_2
/*     */     //   7: invokevirtual a : (Lcom/badlogic/gdx/graphics/g2d/Batch;F)V
/*     */     //   10: aload_0
/*     */     //   11: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   14: getfield font : Lcom/badlogic/gdx/graphics/g2d/BitmapFont;
/*     */     //   17: astore_3
/*     */     //   18: aload_0
/*     */     //   19: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   22: getfield selection : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   25: astore #4
/*     */     //   27: aload_0
/*     */     //   28: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   31: getfield fontColorSelected : Lcom/badlogic/gdx/graphics/Color;
/*     */     //   34: astore #5
/*     */     //   36: aload_0
/*     */     //   37: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   40: getfield fontColorUnselected : Lcom/badlogic/gdx/graphics/Color;
/*     */     //   43: astore #6
/*     */     //   45: aload_0
/*     */     //   46: invokevirtual getColor : ()Lcom/badlogic/gdx/graphics/Color;
/*     */     //   49: astore #7
/*     */     //   51: aload_1
/*     */     //   52: aload #7
/*     */     //   54: getfield r : F
/*     */     //   57: aload #7
/*     */     //   59: getfield g : F
/*     */     //   62: aload #7
/*     */     //   64: getfield b : F
/*     */     //   67: aload #7
/*     */     //   69: getfield a : F
/*     */     //   72: fload_2
/*     */     //   73: fmul
/*     */     //   74: invokeinterface setColor : (FFFF)V
/*     */     //   79: aload_0
/*     */     //   80: invokevirtual getX : ()F
/*     */     //   83: fstore #7
/*     */     //   85: aload_0
/*     */     //   86: invokevirtual getY : ()F
/*     */     //   89: fstore #8
/*     */     //   91: aload_0
/*     */     //   92: invokevirtual getWidth : ()F
/*     */     //   95: fstore #9
/*     */     //   97: aload_0
/*     */     //   98: invokevirtual getHeight : ()F
/*     */     //   101: dup
/*     */     //   102: fstore #10
/*     */     //   104: fstore #11
/*     */     //   106: aload_0
/*     */     //   107: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   110: getfield background : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   113: dup
/*     */     //   114: astore #12
/*     */     //   116: ifnull -> 162
/*     */     //   119: aload #12
/*     */     //   121: invokeinterface getLeftWidth : ()F
/*     */     //   126: fstore #13
/*     */     //   128: fload #7
/*     */     //   130: fload #13
/*     */     //   132: fadd
/*     */     //   133: fstore #7
/*     */     //   135: fload #10
/*     */     //   137: aload #12
/*     */     //   139: invokeinterface getTopHeight : ()F
/*     */     //   144: fsub
/*     */     //   145: fstore #11
/*     */     //   147: fload #9
/*     */     //   149: fload #13
/*     */     //   151: aload #12
/*     */     //   153: invokeinterface getRightWidth : ()F
/*     */     //   158: fadd
/*     */     //   159: fsub
/*     */     //   160: fstore #9
/*     */     //   162: aload #4
/*     */     //   164: invokeinterface getLeftWidth : ()F
/*     */     //   169: fstore #13
/*     */     //   171: fload #9
/*     */     //   173: fload #13
/*     */     //   175: fsub
/*     */     //   176: aload #4
/*     */     //   178: invokeinterface getRightWidth : ()F
/*     */     //   183: fsub
/*     */     //   184: fstore #10
/*     */     //   186: aload #4
/*     */     //   188: invokeinterface getTopHeight : ()F
/*     */     //   193: aload_3
/*     */     //   194: invokevirtual getDescent : ()F
/*     */     //   197: fsub
/*     */     //   198: fstore #12
/*     */     //   200: aload_3
/*     */     //   201: aload #6
/*     */     //   203: getfield r : F
/*     */     //   206: aload #6
/*     */     //   208: getfield g : F
/*     */     //   211: aload #6
/*     */     //   213: getfield b : F
/*     */     //   216: aload #6
/*     */     //   218: getfield a : F
/*     */     //   221: fload_2
/*     */     //   222: fmul
/*     */     //   223: invokevirtual setColor : (FFFF)V
/*     */     //   226: iconst_0
/*     */     //   227: istore #14
/*     */     //   229: iload #14
/*     */     //   231: aload_0
/*     */     //   232: getfield j : Lcom/badlogic/gdx/utils/Array;
/*     */     //   235: getfield size : I
/*     */     //   238: if_icmpge -> 519
/*     */     //   241: aload_0
/*     */     //   242: getfield p : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   245: ifnull -> 287
/*     */     //   248: fload #11
/*     */     //   250: aload_0
/*     */     //   251: getfield s : F
/*     */     //   254: fsub
/*     */     //   255: aload_0
/*     */     //   256: getfield p : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   259: getfield y : F
/*     */     //   262: aload_0
/*     */     //   263: getfield p : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   266: getfield height : F
/*     */     //   269: fadd
/*     */     //   270: fcmpg
/*     */     //   271: ifgt -> 491
/*     */     //   274: fload #11
/*     */     //   276: aload_0
/*     */     //   277: getfield p : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   280: getfield y : F
/*     */     //   283: fcmpl
/*     */     //   284: iflt -> 491
/*     */     //   287: aload_0
/*     */     //   288: getfield j : Lcom/badlogic/gdx/utils/Array;
/*     */     //   291: iload #14
/*     */     //   293: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   296: astore #15
/*     */     //   298: aload_0
/*     */     //   299: getfield k : Lcom/prineside/tdi2/scene2d/utils/ArraySelection;
/*     */     //   302: aload #15
/*     */     //   304: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   307: istore #16
/*     */     //   309: aconst_null
/*     */     //   310: astore #17
/*     */     //   312: aload_0
/*     */     //   313: getfield l : I
/*     */     //   316: iload #14
/*     */     //   318: if_icmpne -> 343
/*     */     //   321: aload_0
/*     */     //   322: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   325: getfield down : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   328: ifnull -> 343
/*     */     //   331: aload_0
/*     */     //   332: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   335: getfield down : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   338: astore #17
/*     */     //   340: goto -> 409
/*     */     //   343: iload #16
/*     */     //   345: ifeq -> 381
/*     */     //   348: aload #4
/*     */     //   350: astore #17
/*     */     //   352: aload_3
/*     */     //   353: aload #5
/*     */     //   355: getfield r : F
/*     */     //   358: aload #5
/*     */     //   360: getfield g : F
/*     */     //   363: aload #5
/*     */     //   365: getfield b : F
/*     */     //   368: aload #5
/*     */     //   370: getfield a : F
/*     */     //   373: fload_2
/*     */     //   374: fmul
/*     */     //   375: invokevirtual setColor : (FFFF)V
/*     */     //   378: goto -> 409
/*     */     //   381: aload_0
/*     */     //   382: getfield m : I
/*     */     //   385: iload #14
/*     */     //   387: if_icmpne -> 409
/*     */     //   390: aload_0
/*     */     //   391: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   394: getfield over : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   397: ifnull -> 409
/*     */     //   400: aload_0
/*     */     //   401: getfield o : Lcom/prineside/tdi2/scene2d/ui/List$ListStyle;
/*     */     //   404: getfield over : Lcom/prineside/tdi2/scene2d/utils/Drawable;
/*     */     //   407: astore #17
/*     */     //   409: aload_1
/*     */     //   410: aload #17
/*     */     //   412: fload #7
/*     */     //   414: fload #8
/*     */     //   416: fload #11
/*     */     //   418: fadd
/*     */     //   419: aload_0
/*     */     //   420: getfield s : F
/*     */     //   423: fsub
/*     */     //   424: fload #9
/*     */     //   426: aload_0
/*     */     //   427: getfield s : F
/*     */     //   430: invokestatic a : (Lcom/badlogic/gdx/graphics/g2d/Batch;Lcom/prineside/tdi2/scene2d/utils/Drawable;FFFF)V
/*     */     //   433: aload_0
/*     */     //   434: aload_1
/*     */     //   435: aload_3
/*     */     //   436: aload #15
/*     */     //   438: fload #7
/*     */     //   440: fload #13
/*     */     //   442: fadd
/*     */     //   443: fload #8
/*     */     //   445: fload #11
/*     */     //   447: fadd
/*     */     //   448: fload #12
/*     */     //   450: fsub
/*     */     //   451: fload #10
/*     */     //   453: invokevirtual a : (Lcom/badlogic/gdx/graphics/g2d/Batch;Lcom/badlogic/gdx/graphics/g2d/BitmapFont;Ljava/lang/Object;FFF)Lcom/badlogic/gdx/graphics/g2d/GlyphLayout;
/*     */     //   456: pop
/*     */     //   457: iload #16
/*     */     //   459: ifeq -> 488
/*     */     //   462: aload_3
/*     */     //   463: aload #6
/*     */     //   465: getfield r : F
/*     */     //   468: aload #6
/*     */     //   470: getfield g : F
/*     */     //   473: aload #6
/*     */     //   475: getfield b : F
/*     */     //   478: aload #6
/*     */     //   480: getfield a : F
/*     */     //   483: fload_2
/*     */     //   484: fmul
/*     */     //   485: invokevirtual setColor : (FFFF)V
/*     */     //   488: goto -> 504
/*     */     //   491: fload #11
/*     */     //   493: aload_0
/*     */     //   494: getfield p : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   497: getfield y : F
/*     */     //   500: fcmpg
/*     */     //   501: iflt -> 519
/*     */     //   504: fload #11
/*     */     //   506: aload_0
/*     */     //   507: getfield s : F
/*     */     //   510: fsub
/*     */     //   511: fstore #11
/*     */     //   513: iinc #14, 1
/*     */     //   516: goto -> 229
/*     */     //   519: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #192	-> 0
/*     */     //   #194	-> 4
/*     */     //   #196	-> 10
/*     */     //   #197	-> 18
/*     */     //   #198	-> 27
/*     */     //   #199	-> 36
/*     */     //   #201	-> 45
/*     */     //   #202	-> 51
/*     */     //   #204	-> 79
/*     */     //   #205	-> 102
/*     */     //   #207	-> 106
/*     */     //   #208	-> 114
/*     */     //   #209	-> 119
/*     */     //   #210	-> 128
/*     */     //   #211	-> 135
/*     */     //   #212	-> 147
/*     */     //   #215	-> 162
/*     */     //   #216	-> 186
/*     */     //   #218	-> 200
/*     */     //   #219	-> 226
/*     */     //   #220	-> 241
/*     */     //   #221	-> 287
/*     */     //   #222	-> 298
/*     */     //   #223	-> 309
/*     */     //   #224	-> 312
/*     */     //   #225	-> 331
/*     */     //   #226	-> 343
/*     */     //   #227	-> 348
/*     */     //   #228	-> 352
/*     */     //   #229	-> 381
/*     */     //   #230	-> 400
/*     */     //   #231	-> 409
/*     */     //   #232	-> 433
/*     */     //   #233	-> 457
/*     */     //   #234	-> 462
/*     */     //   #237	-> 488
/*     */     //   #240	-> 504
/*     */     //   #219	-> 513
/*     */     //   #242	-> 519
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
/*     */ 
/*     */   
/*     */   private static void a(Batch paramBatch, @Null Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 245 */     if (paramDrawable != null) paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   
/*     */   }
/*     */   
/*     */   private void a(Batch paramBatch, float paramFloat) {
/* 250 */     if (this.o.background != null) {
/* 251 */       Color color = getColor();
/* 252 */       paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/* 253 */       this.o.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
/*     */     } 
/*     */   }
/*     */   
/*     */   private GlyphLayout a(Batch paramBatch, BitmapFont paramBitmapFont, T paramT, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 258 */     String str = toString(paramT);
/* 259 */     return paramBitmapFont.draw(paramBatch, str, paramFloat1, paramFloat2, 0, str.length(), paramFloat3, this.t, false, "...");
/*     */   }
/*     */   
/*     */   public ArraySelection<T> getSelection() {
/* 263 */     return this.k;
/*     */   }
/*     */   
/*     */   public void setSelection(ArraySelection<T> paramArraySelection) {
/* 267 */     this.k = paramArraySelection;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getSelected() {
/* 272 */     return (T)this.k.first();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelected(@Null T paramT) {
/* 278 */     if (this.j.contains(paramT, false)) {
/* 279 */       this.k.set(paramT); return;
/* 280 */     }  if (this.k.getRequired() && this.j.size > 0) {
/* 281 */       this.k.set(this.j.first()); return;
/*     */     } 
/* 283 */     this.k.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSelectedIndex() {
/*     */     OrderedSet orderedSet;
/* 289 */     return (((ObjectSet)(orderedSet = this.k.items())).size == 0) ? -1 : this.j.indexOf(orderedSet.first(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectedIndex(int paramInt) {
/* 295 */     if (paramInt < -1 || paramInt >= this.j.size)
/* 296 */       throw new IllegalArgumentException("index must be >= -1 and < " + this.j.size + ": " + paramInt); 
/* 297 */     if (paramInt == -1) {
/* 298 */       this.k.clear(); return;
/*     */     } 
/* 300 */     this.k.set(this.j.get(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getOverItem() {
/* 306 */     return (T)((this.m == -1) ? null : this.j.get(this.m));
/*     */   }
/*     */ 
/*     */   
/*     */   public T getPressedItem() {
/* 311 */     return (T)((this.l == -1) ? null : this.j.get(this.l));
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getItemAt(float paramFloat) {
/*     */     int i;
/* 317 */     if ((i = getItemIndexAt(paramFloat)) == -1) return null; 
/* 318 */     return (T)this.j.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getItemIndexAt(float paramFloat) {
/* 323 */     float f = getHeight();
/*     */     Drawable drawable;
/* 325 */     if ((drawable = this.o.background) != null) {
/* 326 */       f -= drawable.getTopHeight() + drawable.getBottomHeight();
/* 327 */       paramFloat -= drawable.getBottomHeight();
/*     */     } 
/*     */     int i;
/* 330 */     if ((i = (int)((f - paramFloat) / this.s)) < 0 || i >= this.j.size) return -1; 
/* 331 */     return i;
/*     */   }
/*     */   
/*     */   public void setItems(T... paramVarArgs) {
/* 335 */     if (paramVarArgs == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 336 */     float f1 = getPrefWidth(), f2 = getPrefHeight();
/*     */     
/* 338 */     this.j.clear();
/* 339 */     this.j.addAll((Object[])paramVarArgs);
/* 340 */     this.m = -1;
/* 341 */     this.l = -1;
/* 342 */     this.k.validate();
/*     */     
/* 344 */     invalidate();
/* 345 */     if (f1 != getPrefWidth() || f2 != getPrefHeight()) invalidateHierarchy();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItems(Array<T> paramArray) {
/* 352 */     if (paramArray == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 353 */     float f1 = getPrefWidth(), f2 = getPrefHeight();
/*     */     
/* 355 */     if (paramArray != this.j) {
/* 356 */       this.j.clear();
/* 357 */       this.j.addAll(paramArray);
/*     */     } 
/* 359 */     this.m = -1;
/* 360 */     this.l = -1;
/* 361 */     this.k.validate();
/*     */     
/* 363 */     invalidate();
/* 364 */     if (f1 != getPrefWidth() || f2 != getPrefHeight()) invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   public void clearItems() {
/* 368 */     if (this.j.size == 0)
/* 369 */       return;  this.j.clear();
/* 370 */     this.m = -1;
/* 371 */     this.l = -1;
/* 372 */     this.k.clear();
/* 373 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<T> getItems() {
/* 378 */     return this.j;
/*     */   }
/*     */   
/*     */   public float getItemHeight() {
/* 382 */     return this.s;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 386 */     validate();
/* 387 */     return this.q;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 391 */     validate();
/* 392 */     return this.r;
/*     */   }
/*     */   
/*     */   public String toString(T paramT) {
/* 396 */     return paramT.toString();
/*     */   }
/*     */   
/*     */   public void setCullingArea(@Null Rectangle paramRectangle) {
/* 400 */     this.p = paramRectangle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getCullingArea() {
/* 406 */     return this.p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 412 */     this.t = paramInt;
/*     */   }
/*     */   
/*     */   public int getAlignment() {
/* 416 */     return this.t;
/*     */   }
/*     */   
/*     */   public void setTypeToSelect(boolean paramBoolean) {
/* 420 */     this.n = paramBoolean;
/*     */   }
/*     */   
/*     */   public InputListener getKeyListener() {
/* 424 */     return this.u;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ListStyle
/*     */   {
/*     */     public BitmapFont font;
/*     */     
/* 432 */     public Color fontColorSelected = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/* 433 */     public Color fontColorUnselected = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*     */     public Drawable selection;
/*     */     
/*     */     @Null
/*     */     public Drawable down;
/*     */     
/*     */     public ListStyle(BitmapFont param1BitmapFont, Color param1Color1, Color param1Color2, Drawable param1Drawable) {
/* 441 */       this.font = param1BitmapFont;
/* 442 */       this.fontColorSelected.set(param1Color1);
/* 443 */       this.fontColorUnselected.set(param1Color2);
/* 444 */       this.selection = param1Drawable;
/*     */     } @Null
/*     */     public Drawable over; @Null
/*     */     public Drawable background; public ListStyle() {} public ListStyle(ListStyle param1ListStyle) {
/* 448 */       this.font = param1ListStyle.font;
/* 449 */       this.fontColorSelected.set(param1ListStyle.fontColorSelected);
/* 450 */       this.fontColorUnselected.set(param1ListStyle.fontColorUnselected);
/* 451 */       this.selection = param1ListStyle.selection;
/*     */       
/* 453 */       this.down = param1ListStyle.down;
/* 454 */       this.over = param1ListStyle.over;
/* 455 */       this.background = param1ListStyle.background;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\List.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */