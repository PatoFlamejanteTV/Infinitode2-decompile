/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.OrderedSet;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.Action;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.actions.Actions;
/*     */ import com.prineside.tdi2.scene2d.utils.ArraySelection;
/*     */ import com.prineside.tdi2.scene2d.utils.ClickListener;
/*     */ import com.prineside.tdi2.scene2d.utils.Disableable;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
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
/*     */ public class SelectBox<T>
/*     */   extends Widget
/*     */   implements Disableable
/*     */ {
/*  57 */   static final Vector2 j = new Vector2();
/*     */   
/*     */   SelectBoxStyle k;
/*  60 */   final Array<T> l = new Array(); SelectBoxScrollPane<T> m;
/*     */   private float p;
/*     */   private float q;
/*     */   private ClickListener r;
/*     */   private boolean s;
/*  65 */   private int t = 8;
/*     */   boolean n;
/*     */   
/*  68 */   final ArraySelection<T> o = new ArraySelection(this, this.l) {
/*     */       public boolean fireChangeEvent() {
/*  70 */         if (this.e.n) this.e.invalidateHierarchy(); 
/*  71 */         return super.fireChangeEvent();
/*     */       }
/*     */     };
/*     */   
/*     */   public SelectBox(SelectBoxStyle paramSelectBoxStyle) {
/*  76 */     setStyle(paramSelectBoxStyle);
/*  77 */     setSize(getPrefWidth(), getPrefHeight());
/*     */     
/*  79 */     this.o.setActor(this);
/*  80 */     this.o.setRequired(true);
/*     */     
/*  82 */     this.m = b();
/*     */     
/*  84 */     addListener((EventListener)(this.r = new ClickListener(this) {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  86 */             if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  87 */             if (this.a.isDisabled()) return false; 
/*  88 */             if (this.a.m.hasParent()) {
/*  89 */               this.a.hideScrollPane();
/*     */             } else {
/*  91 */               this.a.showScrollPane();
/*  92 */             }  return true;
/*     */           }
/*     */         }));
/*     */   }
/*     */ 
/*     */   
/*     */   private SelectBoxScrollPane<T> b() {
/*  99 */     return new SelectBoxScrollPane<>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxListCount(int paramInt) {
/* 105 */     this.m.F = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxListCount() {
/* 110 */     return this.m.F;
/*     */   }
/*     */   
/*     */   protected final void a(Stage paramStage) {
/* 114 */     if (paramStage == null) this.m.hide(); 
/* 115 */     super.a(paramStage);
/*     */   }
/*     */   
/*     */   public void setStyle(SelectBoxStyle paramSelectBoxStyle) {
/* 119 */     if (paramSelectBoxStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 120 */     this.k = paramSelectBoxStyle;
/*     */     
/* 122 */     if (this.m != null) {
/* 123 */       this.m.setStyle(paramSelectBoxStyle.scrollStyle);
/* 124 */       this.m.G.setStyle(paramSelectBoxStyle.listStyle);
/*     */     } 
/* 126 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectBoxStyle getStyle() {
/* 132 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItems(T... paramVarArgs) {
/* 137 */     if (paramVarArgs == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 138 */     float f = getPrefWidth();
/*     */     
/* 140 */     this.l.clear();
/* 141 */     this.l.addAll((Object[])paramVarArgs);
/* 142 */     this.o.validate();
/* 143 */     this.m.G.setItems(this.l);
/*     */     
/* 145 */     invalidate();
/* 146 */     if (f != getPrefWidth()) invalidateHierarchy();
/*     */   
/*     */   }
/*     */   
/*     */   public void setItems(Array<T> paramArray) {
/* 151 */     if (paramArray == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 152 */     float f = getPrefWidth();
/*     */     
/* 154 */     if (paramArray != this.l) {
/* 155 */       this.l.clear();
/* 156 */       this.l.addAll(paramArray);
/*     */     } 
/* 158 */     this.o.validate();
/* 159 */     this.m.G.setItems(this.l);
/*     */     
/* 161 */     invalidate();
/* 162 */     if (f != getPrefWidth()) invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   public void clearItems() {
/* 166 */     if (this.l.size == 0)
/* 167 */       return;  this.l.clear();
/* 168 */     this.o.clear();
/* 169 */     this.m.G.clearItems();
/* 170 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<T> getItems() {
/* 175 */     return this.l;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 179 */     Drawable drawable = this.k.background;
/* 180 */     BitmapFont bitmapFont = this.k.font;
/*     */     
/* 182 */     if (drawable != null) {
/* 183 */       this.q = Math.max(drawable.getTopHeight() + drawable.getBottomHeight() + bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0F, drawable
/* 184 */           .getMinHeight());
/*     */     } else {
/* 186 */       this.q = bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0F;
/*     */     } 
/*     */     Pool pool;
/* 189 */     GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 190 */     if (this.n) {
/* 191 */       this.p = 0.0F;
/* 192 */       if (drawable != null) this.p = drawable.getLeftWidth() + drawable.getRightWidth(); 
/*     */       T t;
/* 194 */       if ((t = getSelected()) != null) {
/* 195 */         glyphLayout.setText(bitmapFont, a(t));
/* 196 */         this.p += glyphLayout.width;
/*     */       } 
/*     */     } else {
/* 199 */       float f2 = 0.0F;
/* 200 */       for (byte b = 0; b < this.l.size; b++) {
/* 201 */         glyphLayout.setText(bitmapFont, a((T)this.l.get(b)));
/* 202 */         f2 = Math.max(glyphLayout.width, f2);
/*     */       } 
/*     */       
/* 205 */       this.p = f2;
/* 206 */       if (drawable != null) this.p = Math.max(this.p + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
/*     */       
/* 208 */       List.ListStyle listStyle = this.k.listStyle;
/* 209 */       ScrollPane.ScrollPaneStyle scrollPaneStyle = this.k.scrollStyle;
/* 210 */       float f1 = f2 + listStyle.selection.getLeftWidth() + listStyle.selection.getRightWidth();
/*     */       Drawable drawable1;
/* 212 */       if ((drawable1 = scrollPaneStyle.background) != null) f1 = Math.max(f1 + drawable1.getLeftWidth() + drawable1.getRightWidth(), drawable1.getMinWidth()); 
/* 213 */       if (this.m == null || !this.m.C) {
/* 214 */         f1 += Math.max((this.k.scrollStyle.vScroll != null) ? this.k.scrollStyle.vScroll.getMinWidth() : 0.0F, 
/* 215 */             (this.k.scrollStyle.vScrollKnob != null) ? this.k.scrollStyle.vScrollKnob.getMinWidth() : 0.0F);
/*     */       }
/* 217 */       this.p = Math.max(this.p, f1);
/*     */     } 
/* 219 */     pool.free(glyphLayout);
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Drawable c() {
/* 224 */     if (isDisabled() && this.k.backgroundDisabled != null) return this.k.backgroundDisabled; 
/* 225 */     if (this.m.hasParent() && this.k.backgroundOpen != null) return this.k.backgroundOpen; 
/* 226 */     if (isOver() && this.k.backgroundOver != null) return this.k.backgroundOver; 
/* 227 */     return this.k.background;
/*     */   }
/*     */ 
/*     */   
/*     */   private Color d() {
/* 232 */     if (isDisabled() && this.k.disabledFontColor != null) return this.k.disabledFontColor; 
/* 233 */     if (this.k.overFontColor != null && (isOver() || this.m.hasParent())) return this.k.overFontColor; 
/* 234 */     return this.k.fontColor;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 238 */     validate();
/*     */     
/* 240 */     Drawable drawable = c();
/* 241 */     Color color1 = d();
/* 242 */     BitmapFont bitmapFont = this.k.font;
/*     */     
/* 244 */     Color color2 = getColor();
/* 245 */     float f1 = getX(), f2 = getY();
/* 246 */     float f3 = getWidth(), f4 = getHeight();
/*     */     
/* 248 */     paramBatch.setColor(color2.r, color2.g, color2.b, color2.a * paramFloat);
/* 249 */     if (drawable != null) drawable.draw(paramBatch, f1, f2, f3, f4);
/*     */     
/*     */     Object object;
/* 252 */     if ((object = this.o.first()) != null) {
/* 253 */       if (drawable != null) {
/* 254 */         f3 -= drawable.getLeftWidth() + drawable.getRightWidth();
/* 255 */         f4 -= drawable.getBottomHeight() + drawable.getTopHeight();
/* 256 */         f1 += drawable.getLeftWidth();
/* 257 */         f2 += (int)(f4 / 2.0F + drawable.getBottomHeight() + (bitmapFont.getData()).capHeight / 2.0F);
/*     */       } else {
/* 259 */         f2 += (int)(f4 / 2.0F + (bitmapFont.getData()).capHeight / 2.0F);
/*     */       } 
/* 261 */       bitmapFont.setColor(color1.r, color1.g, color1.b, color1.a * paramFloat);
/* 262 */       a(paramBatch, bitmapFont, (T)object, f1, f2, f3);
/*     */     } 
/*     */   }
/*     */   
/*     */   private GlyphLayout a(Batch paramBatch, BitmapFont paramBitmapFont, T paramT, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 267 */     String str = a(paramT);
/* 268 */     return paramBitmapFont.draw(paramBatch, str, paramFloat1, paramFloat2, 0, str.length(), paramFloat3, this.t, false, "...");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 275 */     this.t = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArraySelection<T> getSelection() {
/* 281 */     return this.o;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getSelected() {
/* 286 */     return (T)this.o.first();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelected(@Null T paramT) {
/* 291 */     if (this.l.contains(paramT, false)) {
/* 292 */       this.o.set(paramT); return;
/* 293 */     }  if (this.l.size > 0) {
/* 294 */       this.o.set(this.l.first()); return;
/*     */     } 
/* 296 */     this.o.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSelectedIndex() {
/*     */     OrderedSet orderedSet;
/* 302 */     return (((ObjectSet)(orderedSet = this.o.items())).size == 0) ? -1 : this.l.indexOf(orderedSet.first(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectedIndex(int paramInt) {
/* 307 */     this.o.set(this.l.get(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectedPrefWidth(boolean paramBoolean) {
/* 312 */     this.n = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getSelectedPrefWidth() {
/* 316 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxSelectedPrefWidth() {
/*     */     Pool pool;
/* 323 */     GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 324 */     float f = 0.0F;
/* 325 */     for (byte b = 0; b < this.l.size; b++) {
/* 326 */       glyphLayout.setText(this.k.font, a((T)this.l.get(b)));
/* 327 */       f = Math.max(glyphLayout.width, f);
/*     */     } 
/*     */     Drawable drawable;
/* 330 */     if ((drawable = this.k.background) != null) f = Math.max(f + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth()); 
/* 331 */     return f;
/*     */   }
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 335 */     if (paramBoolean && !this.s) hideScrollPane(); 
/* 336 */     this.s = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 340 */     return this.s;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 344 */     validate();
/* 345 */     return this.p;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 349 */     validate();
/* 350 */     return this.q;
/*     */   }
/*     */   
/*     */   protected static String a(T paramT) {
/* 354 */     return paramT.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void showList() {
/* 360 */     showScrollPane();
/*     */   }
/*     */   
/*     */   public void showScrollPane() {
/* 364 */     if (this.l.size == 0)
/* 365 */       return;  if (getStage() != null) this.m.show(getStage());
/*     */   
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void hideList() {
/* 371 */     hideScrollPane();
/*     */   }
/*     */   
/*     */   public void hideScrollPane() {
/* 375 */     this.m.hide();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<T> getList() {
/* 380 */     return this.m.G;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScrollingDisabled(boolean paramBoolean) {
/* 385 */     this.m.setScrollingDisabled(true, paramBoolean);
/* 386 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public SelectBoxScrollPane getScrollPane() {
/* 391 */     return this.m;
/*     */   }
/*     */   
/*     */   public boolean isOver() {
/* 395 */     return this.r.isOver();
/*     */   }
/*     */   
/*     */   public ClickListener getClickListener() {
/* 399 */     return this.r;
/*     */   }
/*     */   
/*     */   protected static void a(Actor paramActor) {
/* 403 */     (paramActor.getColor()).a = 0.0F;
/* 404 */     paramActor.addAction((Action)Actions.fadeIn(0.3F, Interpolation.fade));
/*     */   }
/*     */   
/*     */   protected static void b(Actor paramActor) {
/* 408 */     (paramActor.getColor()).a = 1.0F;
/* 409 */     paramActor.addAction((Action)Actions.sequence((Action)Actions.fadeOut(0.15F, Interpolation.fade), (Action)Actions.removeActor()));
/*     */   }
/*     */   
/*     */   public static class SelectBoxScrollPane<T>
/*     */     extends ScrollPane
/*     */   {
/*     */     final SelectBox<T> E;
/*     */     int F;
/* 417 */     private final Vector2 H = new Vector2();
/*     */     final List<T> G;
/*     */     private InputListener I;
/*     */     private Actor J;
/*     */     
/*     */     public SelectBoxScrollPane(SelectBox<T> param1SelectBox) {
/* 423 */       super((Actor)null, param1SelectBox.k.scrollStyle);
/* 424 */       this.E = param1SelectBox;
/*     */       
/* 426 */       setOverscroll(false, false);
/* 427 */       setFadeScrollBars(false);
/* 428 */       setScrollingDisabled(true, false);
/*     */       
/* 430 */       this.G = g();
/* 431 */       this.G.setTouchable(Touchable.disabled);
/* 432 */       this.G.setTypeToSelect(true);
/* 433 */       setActor(this.G);
/*     */       
/* 435 */       this.G.addListener((EventListener)new ClickListener(this, param1SelectBox)
/*     */           {
/*     */             public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2)
/*     */             {
/* 439 */               if ((param2InputEvent = this.b.G.getSelected()) != null) this.a.o.items().clear(51); 
/* 440 */               this.a.o.choose(param2InputEvent);
/* 441 */               this.b.hide();
/*     */             }
/*     */             
/*     */             public boolean mouseMoved(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/*     */               int i;
/* 446 */               if ((i = this.b.G.getItemIndexAt(param2Float2)) != -1) this.b.G.setSelectedIndex(i); 
/* 447 */               return true;
/*     */             }
/*     */           });
/*     */       
/* 451 */       addListener((EventListener)new InputListener(this, param1SelectBox) {
/*     */             public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, @Null Actor param2Actor) {
/* 453 */               if ((param2Actor == null || !this.b.isAscendantOf(param2Actor)) && (
/*     */                 
/* 455 */                 param2InputEvent = this.a.getSelected()) != null) this.b.G.k.set(param2InputEvent);
/*     */             
/*     */             }
/*     */           });
/*     */       
/* 460 */       this.I = new InputListener(this, param1SelectBox) {
/*     */           public boolean touchDown(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 462 */             Actor actor = param2InputEvent.getTarget();
/* 463 */             if (this.b.isAscendantOf(actor)) return false; 
/* 464 */             this.b.G.k.set(this.a.getSelected());
/* 465 */             this.b.hide();
/* 466 */             return false;
/*     */           }
/*     */           
/*     */           public boolean keyDown(InputEvent param2InputEvent, int param2Int) {
/* 470 */             switch (param2Int) {
/*     */               case 66:
/*     */               case 160:
/* 473 */                 this.a.o.choose(this.b.G.getSelected());
/*     */               
/*     */               case 111:
/* 476 */                 this.b.hide();
/* 477 */                 param2InputEvent.stop();
/* 478 */                 return true;
/*     */             } 
/* 480 */             return false;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private List<T> g() {
/* 488 */       return new List<T>(this, this.E.k.listStyle) {
/*     */           public String toString(T param2T) {
/* 490 */             return SelectBox.a(param2T);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public void show(Stage param1Stage) {
/* 496 */       if (this.G.isTouchable())
/*     */         return; 
/* 498 */       param1Stage.addActor((Actor)this);
/* 499 */       param1Stage.addCaptureListener((EventListener)this.I);
/* 500 */       param1Stage.addListener((EventListener)this.G.getKeyListener());
/*     */       
/* 502 */       this.E.localToStageCoordinates(this.H.set(0.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 506 */       float f1, f2 = (f1 = this.G.getItemHeight()) * ((this.F <= 0) ? this.E.l.size : Math.min(this.F, this.E.l.size));
/*     */       Drawable drawable;
/* 508 */       if ((drawable = (getStyle()).background) != null) f2 += drawable.getTopHeight() + drawable.getBottomHeight();
/*     */       
/* 510 */       if ((drawable = (this.G.getStyle()).background) != null) f2 += drawable.getTopHeight() + drawable.getBottomHeight();
/*     */       
/* 512 */       float f3 = this.H.y;
/* 513 */       float f4 = param1Stage.getHeight() - f3 - this.E.getHeight();
/* 514 */       boolean bool = true;
/* 515 */       if (f2 > f3) {
/* 516 */         if (f4 > f3) {
/* 517 */           bool = false;
/* 518 */           f2 = Math.min(f2, f4);
/*     */         } else {
/* 520 */           f2 = f3;
/*     */         } 
/*     */       }
/* 523 */       if (bool) {
/* 524 */         setY(this.H.y - f2);
/*     */       } else {
/* 526 */         setY(this.H.y + this.E.getHeight());
/*     */       } 
/* 528 */       setHeight(f2);
/* 529 */       validate();
/* 530 */       f2 = Math.max(getPrefWidth(), this.E.getWidth());
/* 531 */       setWidth(f2);
/*     */ 
/*     */       
/* 534 */       if ((f3 = this.H.x) + f2 > param1Stage.getWidth() && (
/*     */         
/* 536 */         f3 = f3 - getWidth() - this.E.getWidth() - 1.0F) < 0.0F) f3 = 0.0F;
/*     */       
/* 538 */       setX(f3);
/*     */       
/* 540 */       validate();
/* 541 */       scrollTo(0.0F, this.G.getHeight() - this.E.getSelectedIndex() * f1 - f1 / 2.0F, 0.0F, 0.0F, true, true);
/* 542 */       updateVisualScroll();
/*     */       
/* 544 */       this.J = null;
/*     */       Actor actor;
/* 546 */       if ((actor = param1Stage.getScrollFocus()) != null && !actor.isDescendantOf((Actor)this)) this.J = actor; 
/* 547 */       param1Stage.setScrollFocus((Actor)this);
/*     */       
/* 549 */       this.G.k.set(this.E.getSelected());
/* 550 */       this.G.setTouchable(Touchable.enabled);
/* 551 */       clearActions();
/* 552 */       SelectBox.a((Actor)this);
/*     */     }
/*     */     
/*     */     public void hide() {
/* 556 */       if (!this.G.isTouchable() || !hasParent())
/* 557 */         return;  this.G.setTouchable(Touchable.disabled);
/*     */       
/*     */       Stage stage;
/* 560 */       if ((stage = getStage()) != null) {
/* 561 */         stage.removeCaptureListener((EventListener)this.I);
/* 562 */         stage.removeListener((EventListener)this.G.getKeyListener());
/* 563 */         if (this.J != null && this.J.getStage() == null) this.J = null; 
/*     */         Actor actor;
/* 565 */         if ((actor = stage.getScrollFocus()) == null || isAscendantOf(actor)) stage.setScrollFocus(this.J);
/*     */       
/*     */       } 
/* 568 */       clearActions();
/* 569 */       SelectBox.b((Actor)this);
/*     */     }
/*     */     
/*     */     public void draw(Batch param1Batch, float param1Float) {
/* 573 */       this.E.localToStageCoordinates(SelectBox.j.set(0.0F, 0.0F));
/* 574 */       if (!SelectBox.j.equals(this.H)) hide(); 
/* 575 */       super.draw(param1Batch, param1Float);
/*     */     }
/*     */     
/*     */     public void act(float param1Float) {
/* 579 */       super.act(param1Float);
/* 580 */       toFront();
/*     */     }
/*     */     
/*     */     protected final void a(Stage param1Stage) {
/*     */       Stage stage;
/* 585 */       if ((stage = getStage()) != null) {
/* 586 */         stage.removeCaptureListener((EventListener)this.I);
/* 587 */         stage.removeListener((EventListener)this.G.getKeyListener());
/*     */       } 
/* 589 */       super.a(param1Stage);
/*     */     }
/*     */     
/*     */     public List<T> getList() {
/* 593 */       return this.G;
/*     */     }
/*     */     
/*     */     public SelectBox<T> getSelectBox() {
/* 597 */       return this.E;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SelectBoxStyle
/*     */   {
/*     */     public BitmapFont font;
/*     */     
/* 606 */     public Color fontColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*     */     @Null
/*     */     public Color overFontColor;
/*     */     
/*     */     @Null
/*     */     public Color disabledFontColor;
/*     */     @Null
/*     */     public Drawable background;
/*     */     public ScrollPane.ScrollPaneStyle scrollStyle;
/*     */     
/*     */     public SelectBoxStyle(BitmapFont param1BitmapFont, Color param1Color, @Null Drawable param1Drawable, ScrollPane.ScrollPaneStyle param1ScrollPaneStyle, List.ListStyle param1ListStyle) {
/* 618 */       this.font = param1BitmapFont;
/* 619 */       this.fontColor.set(param1Color);
/* 620 */       this.background = param1Drawable;
/* 621 */       this.scrollStyle = param1ScrollPaneStyle;
/* 622 */       this.listStyle = param1ListStyle; } public List.ListStyle listStyle; @Null
/*     */     public Drawable backgroundOver; @Null
/*     */     public Drawable backgroundOpen; @Null
/*     */     public Drawable backgroundDisabled; public SelectBoxStyle() {} public SelectBoxStyle(SelectBoxStyle param1SelectBoxStyle) {
/* 626 */       this.font = param1SelectBoxStyle.font;
/* 627 */       this.fontColor.set(param1SelectBoxStyle.fontColor);
/*     */       
/* 629 */       if (param1SelectBoxStyle.overFontColor != null) this.overFontColor = new Color(param1SelectBoxStyle.overFontColor); 
/* 630 */       if (param1SelectBoxStyle.disabledFontColor != null) this.disabledFontColor = new Color(param1SelectBoxStyle.disabledFontColor);
/*     */       
/* 632 */       this.background = param1SelectBoxStyle.background;
/* 633 */       this.scrollStyle = new ScrollPane.ScrollPaneStyle(param1SelectBoxStyle.scrollStyle);
/* 634 */       this.listStyle = new List.ListStyle(param1SelectBoxStyle.listStyle);
/*     */       
/* 636 */       this.backgroundOver = param1SelectBoxStyle.backgroundOver;
/* 637 */       this.backgroundOpen = param1SelectBoxStyle.backgroundOpen;
/* 638 */       this.backgroundDisabled = param1SelectBoxStyle.backgroundDisabled;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\SelectBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */