/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.Rectangle;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Cullable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.UIUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.OrderedSet;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
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
/*     */   ListStyle style;
/*  49 */   final Array<T> items = new Array();
/*  50 */   ArraySelection<T> selection = new ArraySelection(this.items); private Rectangle cullingArea;
/*     */   private float prefWidth;
/*     */   private float prefHeight;
/*     */   float itemHeight;
/*  54 */   private int alignment = 8;
/*  55 */   int pressedIndex = -1; int overIndex = -1;
/*     */   private InputListener keyListener;
/*     */   boolean typeToSelect;
/*     */   
/*     */   public List(Skin paramSkin) {
/*  60 */     this(paramSkin.<ListStyle>get(ListStyle.class));
/*     */   }
/*     */   
/*     */   public List(Skin paramSkin, String paramString) {
/*  64 */     this(paramSkin.<ListStyle>get(paramString, ListStyle.class));
/*     */   }
/*     */   
/*     */   public List(ListStyle paramListStyle) {
/*  68 */     this.selection.setActor(this);
/*  69 */     this.selection.setRequired(true);
/*     */     
/*  71 */     setStyle(paramListStyle);
/*  72 */     setSize(getPrefWidth(), getPrefHeight());
/*     */     
/*  74 */     addListener((EventListener)(this.keyListener = new InputListener() { long typeTimeout;
/*     */           String prefix;
/*     */           
/*     */           public boolean keyDown(InputEvent param1InputEvent, int param1Int) {
/*     */             int i;
/*  79 */             if (List.this.items.isEmpty()) return false;
/*     */             
/*  81 */             switch (param1Int) {
/*     */               case 29:
/*  83 */                 if (UIUtils.ctrl() && List.this.selection.getMultiple()) {
/*  84 */                   List.this.selection.clear();
/*  85 */                   List.this.selection.addAll(List.this.items);
/*  86 */                   return true;
/*     */                 } 
/*     */                 break;
/*     */               case 3:
/*  90 */                 List.this.setSelectedIndex(0);
/*  91 */                 return true;
/*     */               case 123:
/*  93 */                 List.this.setSelectedIndex(List.this.items.size - 1);
/*  94 */                 return true;
/*     */               
/*     */               case 20:
/*  97 */                 if ((i = List.this.items.indexOf(List.this.getSelected(), false) + 1) >= List.this.items.size) i = 0; 
/*  98 */                 List.this.setSelectedIndex(i);
/*  99 */                 return true;
/*     */               
/*     */               case 19:
/* 102 */                 if ((i = List.this.items.indexOf(List.this.getSelected(), false) - 1) < 0) i = List.this.items.size - 1; 
/* 103 */                 List.this.setSelectedIndex(i);
/* 104 */                 return true;
/*     */               case 111:
/* 106 */                 if (List.this.getStage() != null) List.this.getStage().setKeyboardFocus(null); 
/* 107 */                 return true;
/*     */             } 
/* 109 */             return false;
/*     */           }
/*     */           
/*     */           public boolean keyTyped(InputEvent param1InputEvent, char param1Char) {
/* 113 */             if (!List.this.typeToSelect) return false; 
/*     */             long l;
/* 115 */             if ((l = System.currentTimeMillis()) > this.typeTimeout) this.prefix = ""; 
/* 116 */             this.typeTimeout = l + 300L;
/* 117 */             this.prefix += Character.toLowerCase(param1Char); byte b; int i;
/* 118 */             for (b = 0, i = List.this.items.size; b < i; b++) {
/* 119 */               if (List.this.toString(List.this.items.get(b)).toLowerCase().startsWith(this.prefix)) {
/* 120 */                 List.this.setSelectedIndex(b);
/*     */                 break;
/*     */               } 
/*     */             } 
/* 124 */             return false;
/*     */           } }
/*     */         ));
/*     */     
/* 128 */     addListener((EventListener)new InputListener() {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 130 */             if (param1Int1 != 0 || param1Int2 != 0) return true; 
/* 131 */             if (List.this.selection.isDisabled()) return true; 
/* 132 */             if (List.this.getStage() != null) List.this.getStage().setKeyboardFocus(List.this); 
/* 133 */             if (List.this.items.size == 0) return true; 
/*     */             int i;
/* 135 */             if ((i = List.this.getItemIndexAt(param1Float2)) == -1) return true; 
/* 136 */             List.this.selection.choose(List.this.items.get(i));
/* 137 */             List.this.pressedIndex = i;
/* 138 */             return true;
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/* 142 */             if (param1Int1 != 0 || param1Int2 != 0)
/* 143 */               return;  List.this.pressedIndex = -1;
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/* 147 */             List.this.overIndex = List.this.getItemIndexAt(param1Float2);
/*     */           }
/*     */           
/*     */           public boolean mouseMoved(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/* 151 */             List.this.overIndex = List.this.getItemIndexAt(param1Float2);
/* 152 */             return false;
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, Actor param1Actor) {
/* 156 */             if (param1Int == 0) List.this.pressedIndex = -1; 
/* 157 */             if (param1Int == -1) List.this.overIndex = -1; 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void setStyle(ListStyle paramListStyle) {
/* 163 */     if (paramListStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 164 */     this.style = paramListStyle;
/* 165 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListStyle getStyle() {
/* 171 */     return this.style;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 175 */     BitmapFont bitmapFont = this.style.font;
/* 176 */     Drawable drawable1 = this.style.selection;
/*     */     
/* 178 */     this.itemHeight = bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0F;
/* 179 */     this.itemHeight += drawable1.getTopHeight() + drawable1.getBottomHeight();
/*     */     
/* 181 */     this.prefWidth = 0.0F;
/*     */     Pool pool;
/* 183 */     GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 184 */     for (byte b = 0; b < this.items.size; b++) {
/* 185 */       glyphLayout.setText(bitmapFont, toString((T)this.items.get(b)));
/* 186 */       this.prefWidth = Math.max(glyphLayout.width, this.prefWidth);
/*     */     } 
/* 188 */     pool.free(glyphLayout);
/* 189 */     this.prefWidth += drawable1.getLeftWidth() + drawable1.getRightWidth();
/* 190 */     this.prefHeight = this.items.size * this.itemHeight;
/*     */     
/*     */     Drawable drawable2;
/* 193 */     if ((drawable2 = this.style.background) != null) {
/* 194 */       this.prefWidth = Math.max(this.prefWidth + drawable2.getLeftWidth() + drawable2.getRightWidth(), drawable2.getMinWidth());
/* 195 */       this.prefHeight = Math.max(this.prefHeight + drawable2.getTopHeight() + drawable2.getBottomHeight(), drawable2.getMinHeight());
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
/*     */     //   7: invokevirtual drawBackground : (Lcom/badlogic/gdx/graphics/g2d/Batch;F)V
/*     */     //   10: aload_0
/*     */     //   11: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   14: getfield font : Lcom/badlogic/gdx/graphics/g2d/BitmapFont;
/*     */     //   17: astore_3
/*     */     //   18: aload_0
/*     */     //   19: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   22: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   25: astore #4
/*     */     //   27: aload_0
/*     */     //   28: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   31: getfield fontColorSelected : Lcom/badlogic/gdx/graphics/Color;
/*     */     //   34: astore #5
/*     */     //   36: aload_0
/*     */     //   37: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
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
/*     */     //   107: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   110: getfield background : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
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
/*     */     //   232: getfield items : Lcom/badlogic/gdx/utils/Array;
/*     */     //   235: getfield size : I
/*     */     //   238: if_icmpge -> 522
/*     */     //   241: aload_0
/*     */     //   242: getfield cullingArea : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   245: ifnull -> 287
/*     */     //   248: fload #11
/*     */     //   250: aload_0
/*     */     //   251: getfield itemHeight : F
/*     */     //   254: fsub
/*     */     //   255: aload_0
/*     */     //   256: getfield cullingArea : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   259: getfield y : F
/*     */     //   262: aload_0
/*     */     //   263: getfield cullingArea : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   266: getfield height : F
/*     */     //   269: fadd
/*     */     //   270: fcmpg
/*     */     //   271: ifgt -> 494
/*     */     //   274: fload #11
/*     */     //   276: aload_0
/*     */     //   277: getfield cullingArea : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   280: getfield y : F
/*     */     //   283: fcmpl
/*     */     //   284: iflt -> 494
/*     */     //   287: aload_0
/*     */     //   288: getfield items : Lcom/badlogic/gdx/utils/Array;
/*     */     //   291: iload #14
/*     */     //   293: invokevirtual get : (I)Ljava/lang/Object;
/*     */     //   296: astore #15
/*     */     //   298: aload_0
/*     */     //   299: getfield selection : Lcom/badlogic/gdx/scenes/scene2d/utils/ArraySelection;
/*     */     //   302: aload #15
/*     */     //   304: invokevirtual contains : (Ljava/lang/Object;)Z
/*     */     //   307: istore #16
/*     */     //   309: aconst_null
/*     */     //   310: astore #17
/*     */     //   312: aload_0
/*     */     //   313: getfield pressedIndex : I
/*     */     //   316: iload #14
/*     */     //   318: if_icmpne -> 343
/*     */     //   321: aload_0
/*     */     //   322: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   325: getfield down : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   328: ifnull -> 343
/*     */     //   331: aload_0
/*     */     //   332: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   335: getfield down : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
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
/*     */     //   382: getfield overIndex : I
/*     */     //   385: iload #14
/*     */     //   387: if_icmpne -> 409
/*     */     //   390: aload_0
/*     */     //   391: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   394: getfield over : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   397: ifnull -> 409
/*     */     //   400: aload_0
/*     */     //   401: getfield style : Lcom/badlogic/gdx/scenes/scene2d/ui/List$ListStyle;
/*     */     //   404: getfield over : Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;
/*     */     //   407: astore #17
/*     */     //   409: aload_0
/*     */     //   410: aload_1
/*     */     //   411: aload #17
/*     */     //   413: fload #7
/*     */     //   415: fload #8
/*     */     //   417: fload #11
/*     */     //   419: fadd
/*     */     //   420: aload_0
/*     */     //   421: getfield itemHeight : F
/*     */     //   424: fsub
/*     */     //   425: fload #9
/*     */     //   427: aload_0
/*     */     //   428: getfield itemHeight : F
/*     */     //   431: invokevirtual drawSelection : (Lcom/badlogic/gdx/graphics/g2d/Batch;Lcom/badlogic/gdx/scenes/scene2d/utils/Drawable;FFFF)V
/*     */     //   434: aload_0
/*     */     //   435: aload_1
/*     */     //   436: aload_3
/*     */     //   437: iload #14
/*     */     //   439: aload #15
/*     */     //   441: fload #7
/*     */     //   443: fload #13
/*     */     //   445: fadd
/*     */     //   446: fload #8
/*     */     //   448: fload #11
/*     */     //   450: fadd
/*     */     //   451: fload #12
/*     */     //   453: fsub
/*     */     //   454: fload #10
/*     */     //   456: invokevirtual drawItem : (Lcom/badlogic/gdx/graphics/g2d/Batch;Lcom/badlogic/gdx/graphics/g2d/BitmapFont;ILjava/lang/Object;FFF)Lcom/badlogic/gdx/graphics/g2d/GlyphLayout;
/*     */     //   459: pop
/*     */     //   460: iload #16
/*     */     //   462: ifeq -> 491
/*     */     //   465: aload_3
/*     */     //   466: aload #6
/*     */     //   468: getfield r : F
/*     */     //   471: aload #6
/*     */     //   473: getfield g : F
/*     */     //   476: aload #6
/*     */     //   478: getfield b : F
/*     */     //   481: aload #6
/*     */     //   483: getfield a : F
/*     */     //   486: fload_2
/*     */     //   487: fmul
/*     */     //   488: invokevirtual setColor : (FFFF)V
/*     */     //   491: goto -> 507
/*     */     //   494: fload #11
/*     */     //   496: aload_0
/*     */     //   497: getfield cullingArea : Lcom/badlogic/gdx/math/Rectangle;
/*     */     //   500: getfield y : F
/*     */     //   503: fcmpg
/*     */     //   504: iflt -> 522
/*     */     //   507: fload #11
/*     */     //   509: aload_0
/*     */     //   510: getfield itemHeight : F
/*     */     //   513: fsub
/*     */     //   514: fstore #11
/*     */     //   516: iinc #14, 1
/*     */     //   519: goto -> 229
/*     */     //   522: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #200	-> 0
/*     */     //   #202	-> 4
/*     */     //   #204	-> 10
/*     */     //   #205	-> 18
/*     */     //   #206	-> 27
/*     */     //   #207	-> 36
/*     */     //   #209	-> 45
/*     */     //   #210	-> 51
/*     */     //   #212	-> 79
/*     */     //   #213	-> 102
/*     */     //   #215	-> 106
/*     */     //   #216	-> 114
/*     */     //   #217	-> 119
/*     */     //   #218	-> 128
/*     */     //   #219	-> 135
/*     */     //   #220	-> 147
/*     */     //   #223	-> 162
/*     */     //   #224	-> 186
/*     */     //   #226	-> 200
/*     */     //   #227	-> 226
/*     */     //   #228	-> 241
/*     */     //   #229	-> 287
/*     */     //   #230	-> 298
/*     */     //   #231	-> 309
/*     */     //   #232	-> 312
/*     */     //   #233	-> 331
/*     */     //   #234	-> 343
/*     */     //   #235	-> 348
/*     */     //   #236	-> 352
/*     */     //   #237	-> 381
/*     */     //   #238	-> 400
/*     */     //   #239	-> 409
/*     */     //   #240	-> 434
/*     */     //   #241	-> 460
/*     */     //   #242	-> 465
/*     */     //   #245	-> 491
/*     */     //   #248	-> 507
/*     */     //   #227	-> 516
/*     */     //   #250	-> 522
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
/*     */   protected void drawSelection(Batch paramBatch, @Null Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 253 */     if (paramDrawable != null) paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   
/*     */   }
/*     */   
/*     */   protected void drawBackground(Batch paramBatch, float paramFloat) {
/* 258 */     if (this.style.background != null) {
/* 259 */       Color color = getColor();
/* 260 */       paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/* 261 */       this.style.background.draw(paramBatch, getX(), getY(), getWidth(), getHeight());
/*     */     } 
/*     */   }
/*     */   
/*     */   protected GlyphLayout drawItem(Batch paramBatch, BitmapFont paramBitmapFont, int paramInt, T paramT, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 266 */     String str = toString(paramT);
/* 267 */     return paramBitmapFont.draw(paramBatch, str, paramFloat1, paramFloat2, 0, str.length(), paramFloat3, this.alignment, false, "...");
/*     */   }
/*     */   
/*     */   public ArraySelection<T> getSelection() {
/* 271 */     return this.selection;
/*     */   }
/*     */   
/*     */   public void setSelection(ArraySelection<T> paramArraySelection) {
/* 275 */     this.selection = paramArraySelection;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getSelected() {
/* 280 */     return (T)this.selection.first();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelected(@Null T paramT) {
/* 286 */     if (this.items.contains(paramT, false)) {
/* 287 */       this.selection.set(paramT); return;
/* 288 */     }  if (this.selection.getRequired() && this.items.size > 0) {
/* 289 */       this.selection.set(this.items.first()); return;
/*     */     } 
/* 291 */     this.selection.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSelectedIndex() {
/*     */     OrderedSet orderedSet;
/* 297 */     return (((ObjectSet)(orderedSet = this.selection.items())).size == 0) ? -1 : this.items.indexOf(orderedSet.first(), false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelectedIndex(int paramInt) {
/* 303 */     if (paramInt < -1 || paramInt >= this.items.size)
/* 304 */       throw new IllegalArgumentException("index must be >= -1 and < " + this.items.size + ": " + paramInt); 
/* 305 */     if (paramInt == -1) {
/* 306 */       this.selection.clear(); return;
/*     */     } 
/* 308 */     this.selection.set(this.items.get(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T getOverItem() {
/* 314 */     return (T)((this.overIndex == -1) ? null : this.items.get(this.overIndex));
/*     */   }
/*     */ 
/*     */   
/*     */   public T getPressedItem() {
/* 319 */     return (T)((this.pressedIndex == -1) ? null : this.items.get(this.pressedIndex));
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getItemAt(float paramFloat) {
/*     */     int i;
/* 325 */     if ((i = getItemIndexAt(paramFloat)) == -1) return null; 
/* 326 */     return (T)this.items.get(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getItemIndexAt(float paramFloat) {
/* 331 */     float f = getHeight();
/*     */     Drawable drawable;
/* 333 */     if ((drawable = this.style.background) != null) {
/* 334 */       f -= drawable.getTopHeight() + drawable.getBottomHeight();
/* 335 */       paramFloat -= drawable.getBottomHeight();
/*     */     } 
/*     */     int i;
/* 338 */     if ((i = (int)((f - paramFloat) / this.itemHeight)) < 0 || i >= this.items.size) return -1; 
/* 339 */     return i;
/*     */   }
/*     */   
/*     */   public void setItems(T... paramVarArgs) {
/* 343 */     if (paramVarArgs == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 344 */     float f1 = getPrefWidth(), f2 = getPrefHeight();
/*     */     
/* 346 */     this.items.clear();
/* 347 */     this.items.addAll((Object[])paramVarArgs);
/* 348 */     this.overIndex = -1;
/* 349 */     this.pressedIndex = -1;
/* 350 */     this.selection.validate();
/*     */     
/* 352 */     invalidate();
/* 353 */     if (f1 != getPrefWidth() || f2 != getPrefHeight()) invalidateHierarchy();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItems(Array<T> paramArray) {
/* 360 */     if (paramArray == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 361 */     float f1 = getPrefWidth(), f2 = getPrefHeight();
/*     */     
/* 363 */     if (paramArray != this.items) {
/* 364 */       this.items.clear();
/* 365 */       this.items.addAll(paramArray);
/*     */     } 
/* 367 */     this.overIndex = -1;
/* 368 */     this.pressedIndex = -1;
/* 369 */     this.selection.validate();
/*     */     
/* 371 */     invalidate();
/* 372 */     if (f1 != getPrefWidth() || f2 != getPrefHeight()) invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   public void clearItems() {
/* 376 */     if (this.items.size == 0)
/* 377 */       return;  this.items.clear();
/* 378 */     this.overIndex = -1;
/* 379 */     this.pressedIndex = -1;
/* 380 */     this.selection.clear();
/* 381 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<T> getItems() {
/* 386 */     return this.items;
/*     */   }
/*     */   
/*     */   public float getItemHeight() {
/* 390 */     return this.itemHeight;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 394 */     validate();
/* 395 */     return this.prefWidth;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 399 */     validate();
/* 400 */     return this.prefHeight;
/*     */   }
/*     */   
/*     */   public String toString(T paramT) {
/* 404 */     return paramT.toString();
/*     */   }
/*     */   
/*     */   public void setCullingArea(@Null Rectangle paramRectangle) {
/* 408 */     this.cullingArea = paramRectangle;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Rectangle getCullingArea() {
/* 414 */     return this.cullingArea;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 420 */     this.alignment = paramInt;
/*     */   }
/*     */   
/*     */   public int getAlignment() {
/* 424 */     return this.alignment;
/*     */   }
/*     */   
/*     */   public void setTypeToSelect(boolean paramBoolean) {
/* 428 */     this.typeToSelect = paramBoolean;
/*     */   }
/*     */   
/*     */   public InputListener getKeyListener() {
/* 432 */     return this.keyListener;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ListStyle
/*     */   {
/*     */     public BitmapFont font;
/*     */     
/* 440 */     public Color fontColorSelected = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/* 441 */     public Color fontColorUnselected = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*     */     public Drawable selection;
/*     */     
/*     */     @Null
/*     */     public Drawable down;
/*     */     
/*     */     public ListStyle(BitmapFont param1BitmapFont, Color param1Color1, Color param1Color2, Drawable param1Drawable) {
/* 449 */       this.font = param1BitmapFont;
/* 450 */       this.fontColorSelected.set(param1Color1);
/* 451 */       this.fontColorUnselected.set(param1Color2);
/* 452 */       this.selection = param1Drawable;
/*     */     } @Null
/*     */     public Drawable over; @Null
/*     */     public Drawable background; public ListStyle() {} public ListStyle(ListStyle param1ListStyle) {
/* 456 */       this.font = param1ListStyle.font;
/* 457 */       this.fontColorSelected.set(param1ListStyle.fontColorSelected);
/* 458 */       this.fontColorUnselected.set(param1ListStyle.fontColorUnselected);
/* 459 */       this.selection = param1ListStyle.selection;
/*     */       
/* 461 */       this.down = param1ListStyle.down;
/* 462 */       this.over = param1ListStyle.over;
/* 463 */       this.background = param1ListStyle.background;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\List.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */