/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.GlyphLayout;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Action;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.scenes.scene2d.actions.Actions;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SelectBox<T>
/*     */   extends Widget
/*     */   implements Disableable
/*     */ {
/*  57 */   static final Vector2 temp = new Vector2();
/*     */   
/*     */   SelectBoxStyle style;
/*  60 */   final Array<T> items = new Array(); SelectBoxScrollPane<T> scrollPane;
/*     */   private float prefWidth;
/*     */   private float prefHeight;
/*     */   private ClickListener clickListener;
/*     */   boolean disabled;
/*  65 */   private int alignment = 8;
/*     */   boolean selectedPrefWidth;
/*     */   
/*  68 */   final ArraySelection<T> selection = new ArraySelection(this.items) {
/*     */       public boolean fireChangeEvent() {
/*  70 */         if (SelectBox.this.selectedPrefWidth) SelectBox.this.invalidateHierarchy(); 
/*  71 */         return super.fireChangeEvent();
/*     */       }
/*     */     };
/*     */   
/*     */   public SelectBox(Skin paramSkin) {
/*  76 */     this(paramSkin.<SelectBoxStyle>get(SelectBoxStyle.class));
/*     */   }
/*     */   
/*     */   public SelectBox(Skin paramSkin, String paramString) {
/*  80 */     this(paramSkin.<SelectBoxStyle>get(paramString, SelectBoxStyle.class));
/*     */   }
/*     */   
/*     */   public SelectBox(SelectBoxStyle paramSelectBoxStyle) {
/*  84 */     setStyle(paramSelectBoxStyle);
/*  85 */     setSize(getPrefWidth(), getPrefHeight());
/*     */     
/*  87 */     this.selection.setActor(this);
/*  88 */     this.selection.setRequired(true);
/*     */     
/*  90 */     this.scrollPane = newScrollPane();
/*     */     
/*  92 */     addListener((EventListener)(this.clickListener = new ClickListener() {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  94 */             if (param1Int1 == 0 && param1Int2 != 0) return false; 
/*  95 */             if (SelectBox.this.isDisabled()) return false; 
/*  96 */             if (SelectBox.this.scrollPane.hasParent()) {
/*  97 */               SelectBox.this.hideScrollPane();
/*     */             } else {
/*  99 */               SelectBox.this.showScrollPane();
/* 100 */             }  return true;
/*     */           }
/*     */         }));
/*     */   }
/*     */ 
/*     */   
/*     */   protected SelectBoxScrollPane<T> newScrollPane() {
/* 107 */     return new SelectBoxScrollPane<>(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxListCount(int paramInt) {
/* 113 */     this.scrollPane.maxListCount = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxListCount() {
/* 118 */     return this.scrollPane.maxListCount;
/*     */   }
/*     */   
/*     */   protected void setStage(Stage paramStage) {
/* 122 */     if (paramStage == null) this.scrollPane.hide(); 
/* 123 */     super.setStage(paramStage);
/*     */   }
/*     */   
/*     */   public void setStyle(SelectBoxStyle paramSelectBoxStyle) {
/* 127 */     if (paramSelectBoxStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 128 */     this.style = paramSelectBoxStyle;
/*     */     
/* 130 */     if (this.scrollPane != null) {
/* 131 */       this.scrollPane.setStyle(paramSelectBoxStyle.scrollStyle);
/* 132 */       this.scrollPane.list.setStyle(paramSelectBoxStyle.listStyle);
/*     */     } 
/* 134 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectBoxStyle getStyle() {
/* 140 */     return this.style;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setItems(T... paramVarArgs) {
/* 145 */     if (paramVarArgs == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 146 */     float f = getPrefWidth();
/*     */     
/* 148 */     this.items.clear();
/* 149 */     this.items.addAll((Object[])paramVarArgs);
/* 150 */     this.selection.validate();
/* 151 */     this.scrollPane.list.setItems(this.items);
/*     */     
/* 153 */     invalidate();
/* 154 */     if (f != getPrefWidth()) invalidateHierarchy();
/*     */   
/*     */   }
/*     */   
/*     */   public void setItems(Array<T> paramArray) {
/* 159 */     if (paramArray == null) throw new IllegalArgumentException("newItems cannot be null."); 
/* 160 */     float f = getPrefWidth();
/*     */     
/* 162 */     if (paramArray != this.items) {
/* 163 */       this.items.clear();
/* 164 */       this.items.addAll(paramArray);
/*     */     } 
/* 166 */     this.selection.validate();
/* 167 */     this.scrollPane.list.setItems(this.items);
/*     */     
/* 169 */     invalidate();
/* 170 */     if (f != getPrefWidth()) invalidateHierarchy(); 
/*     */   }
/*     */   
/*     */   public void clearItems() {
/* 174 */     if (this.items.size == 0)
/* 175 */       return;  this.items.clear();
/* 176 */     this.selection.clear();
/* 177 */     this.scrollPane.list.clearItems();
/* 178 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<T> getItems() {
/* 183 */     return this.items;
/*     */   }
/*     */   
/*     */   public void layout() {
/* 187 */     Drawable drawable = this.style.background;
/* 188 */     BitmapFont bitmapFont = this.style.font;
/*     */     
/* 190 */     if (drawable != null) {
/* 191 */       this.prefHeight = Math.max(drawable.getTopHeight() + drawable.getBottomHeight() + bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0F, drawable
/* 192 */           .getMinHeight());
/*     */     } else {
/* 194 */       this.prefHeight = bitmapFont.getCapHeight() - bitmapFont.getDescent() * 2.0F;
/*     */     } 
/*     */     Pool pool;
/* 197 */     GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 198 */     if (this.selectedPrefWidth) {
/* 199 */       this.prefWidth = 0.0F;
/* 200 */       if (drawable != null) this.prefWidth = drawable.getLeftWidth() + drawable.getRightWidth(); 
/*     */       T t;
/* 202 */       if ((t = getSelected()) != null) {
/* 203 */         glyphLayout.setText(bitmapFont, toString(t));
/* 204 */         this.prefWidth += glyphLayout.width;
/*     */       } 
/*     */     } else {
/* 207 */       float f2 = 0.0F;
/* 208 */       for (byte b = 0; b < this.items.size; b++) {
/* 209 */         glyphLayout.setText(bitmapFont, toString((T)this.items.get(b)));
/* 210 */         f2 = Math.max(glyphLayout.width, f2);
/*     */       } 
/*     */       
/* 213 */       this.prefWidth = f2;
/* 214 */       if (drawable != null) this.prefWidth = Math.max(this.prefWidth + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth());
/*     */       
/* 216 */       List.ListStyle listStyle = this.style.listStyle;
/* 217 */       ScrollPane.ScrollPaneStyle scrollPaneStyle = this.style.scrollStyle;
/* 218 */       float f1 = f2 + listStyle.selection.getLeftWidth() + listStyle.selection.getRightWidth();
/*     */       Drawable drawable1;
/* 220 */       if ((drawable1 = scrollPaneStyle.background) != null) f1 = Math.max(f1 + drawable1.getLeftWidth() + drawable1.getRightWidth(), drawable1.getMinWidth()); 
/* 221 */       if (this.scrollPane == null || !this.scrollPane.disableY) {
/* 222 */         f1 += Math.max((this.style.scrollStyle.vScroll != null) ? this.style.scrollStyle.vScroll.getMinWidth() : 0.0F, 
/* 223 */             (this.style.scrollStyle.vScrollKnob != null) ? this.style.scrollStyle.vScrollKnob.getMinWidth() : 0.0F);
/*     */       }
/* 225 */       this.prefWidth = Math.max(this.prefWidth, f1);
/*     */     } 
/* 227 */     pool.free(glyphLayout);
/*     */   }
/*     */   
/*     */   @Null
/*     */   protected Drawable getBackgroundDrawable() {
/* 232 */     if (isDisabled() && this.style.backgroundDisabled != null) return this.style.backgroundDisabled; 
/* 233 */     if (this.scrollPane.hasParent() && this.style.backgroundOpen != null) return this.style.backgroundOpen; 
/* 234 */     if (isOver() && this.style.backgroundOver != null) return this.style.backgroundOver; 
/* 235 */     return this.style.background;
/*     */   }
/*     */ 
/*     */   
/*     */   protected Color getFontColor() {
/* 240 */     if (isDisabled() && this.style.disabledFontColor != null) return this.style.disabledFontColor; 
/* 241 */     if (this.style.overFontColor != null && (isOver() || this.scrollPane.hasParent())) return this.style.overFontColor; 
/* 242 */     return this.style.fontColor;
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 246 */     validate();
/*     */     
/* 248 */     Drawable drawable = getBackgroundDrawable();
/* 249 */     Color color1 = getFontColor();
/* 250 */     BitmapFont bitmapFont = this.style.font;
/*     */     
/* 252 */     Color color2 = getColor();
/* 253 */     float f1 = getX(), f2 = getY();
/* 254 */     float f3 = getWidth(), f4 = getHeight();
/*     */     
/* 256 */     paramBatch.setColor(color2.r, color2.g, color2.b, color2.a * paramFloat);
/* 257 */     if (drawable != null) drawable.draw(paramBatch, f1, f2, f3, f4);
/*     */     
/*     */     Object object;
/* 260 */     if ((object = this.selection.first()) != null) {
/* 261 */       if (drawable != null) {
/* 262 */         f3 -= drawable.getLeftWidth() + drawable.getRightWidth();
/* 263 */         f4 -= drawable.getBottomHeight() + drawable.getTopHeight();
/* 264 */         f1 += drawable.getLeftWidth();
/* 265 */         f2 += (int)(f4 / 2.0F + drawable.getBottomHeight() + (bitmapFont.getData()).capHeight / 2.0F);
/*     */       } else {
/* 267 */         f2 += (int)(f4 / 2.0F + (bitmapFont.getData()).capHeight / 2.0F);
/*     */       } 
/* 269 */       bitmapFont.setColor(color1.r, color1.g, color1.b, color1.a * paramFloat);
/* 270 */       drawItem(paramBatch, bitmapFont, (T)object, f1, f2, f3);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected GlyphLayout drawItem(Batch paramBatch, BitmapFont paramBitmapFont, T paramT, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 275 */     String str = toString(paramT);
/* 276 */     return paramBitmapFont.draw(paramBatch, str, paramFloat1, paramFloat2, 0, str.length(), paramFloat3, this.alignment, false, "...");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAlignment(int paramInt) {
/* 283 */     this.alignment = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArraySelection<T> getSelection() {
/* 289 */     return this.selection;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public T getSelected() {
/* 294 */     return (T)this.selection.first();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelected(@Null T paramT) {
/* 299 */     if (this.items.contains(paramT, false)) {
/* 300 */       this.selection.set(paramT); return;
/* 301 */     }  if (this.items.size > 0) {
/* 302 */       this.selection.set(this.items.first()); return;
/*     */     } 
/* 304 */     this.selection.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSelectedIndex() {
/*     */     OrderedSet orderedSet;
/* 310 */     return (((ObjectSet)(orderedSet = this.selection.items())).size == 0) ? -1 : this.items.indexOf(orderedSet.first(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectedIndex(int paramInt) {
/* 315 */     this.selection.set(this.items.get(paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSelectedPrefWidth(boolean paramBoolean) {
/* 320 */     this.selectedPrefWidth = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean getSelectedPrefWidth() {
/* 324 */     return this.selectedPrefWidth;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaxSelectedPrefWidth() {
/*     */     Pool pool;
/* 331 */     GlyphLayout glyphLayout = (GlyphLayout)(pool = Pools.get(GlyphLayout.class)).obtain();
/* 332 */     float f = 0.0F;
/* 333 */     for (byte b = 0; b < this.items.size; b++) {
/* 334 */       glyphLayout.setText(this.style.font, toString((T)this.items.get(b)));
/* 335 */       f = Math.max(glyphLayout.width, f);
/*     */     } 
/*     */     Drawable drawable;
/* 338 */     if ((drawable = this.style.background) != null) f = Math.max(f + drawable.getLeftWidth() + drawable.getRightWidth(), drawable.getMinWidth()); 
/* 339 */     return f;
/*     */   }
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 343 */     if (paramBoolean && !this.disabled) hideScrollPane(); 
/* 344 */     this.disabled = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 348 */     return this.disabled;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 352 */     validate();
/* 353 */     return this.prefWidth;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 357 */     validate();
/* 358 */     return this.prefHeight;
/*     */   }
/*     */   
/*     */   protected String toString(T paramT) {
/* 362 */     return paramT.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void showList() {
/* 368 */     showScrollPane();
/*     */   }
/*     */   
/*     */   public void showScrollPane() {
/* 372 */     if (this.items.size == 0)
/* 373 */       return;  if (getStage() != null) this.scrollPane.show(getStage());
/*     */   
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void hideList() {
/* 379 */     hideScrollPane();
/*     */   }
/*     */   
/*     */   public void hideScrollPane() {
/* 383 */     this.scrollPane.hide();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<T> getList() {
/* 388 */     return this.scrollPane.list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setScrollingDisabled(boolean paramBoolean) {
/* 393 */     this.scrollPane.setScrollingDisabled(true, paramBoolean);
/* 394 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */   
/*     */   public SelectBoxScrollPane getScrollPane() {
/* 399 */     return this.scrollPane;
/*     */   }
/*     */   
/*     */   public boolean isOver() {
/* 403 */     return this.clickListener.isOver();
/*     */   }
/*     */   
/*     */   public ClickListener getClickListener() {
/* 407 */     return this.clickListener;
/*     */   }
/*     */   
/*     */   protected void onShow(Actor paramActor, boolean paramBoolean) {
/* 411 */     (paramActor.getColor()).a = 0.0F;
/* 412 */     paramActor.addAction((Action)Actions.fadeIn(0.3F, Interpolation.fade));
/*     */   }
/*     */   
/*     */   protected void onHide(Actor paramActor) {
/* 416 */     (paramActor.getColor()).a = 1.0F;
/* 417 */     paramActor.addAction((Action)Actions.sequence((Action)Actions.fadeOut(0.15F, Interpolation.fade), (Action)Actions.removeActor()));
/*     */   }
/*     */   
/*     */   public static class SelectBoxScrollPane<T>
/*     */     extends ScrollPane
/*     */   {
/*     */     final SelectBox<T> selectBox;
/*     */     int maxListCount;
/* 425 */     private final Vector2 stagePosition = new Vector2();
/*     */     final List<T> list;
/*     */     private InputListener hideListener;
/*     */     private Actor previousScrollFocus;
/*     */     
/*     */     public SelectBoxScrollPane(final SelectBox<T> selectBox) {
/* 431 */       super((Actor)null, selectBox.style.scrollStyle);
/* 432 */       this.selectBox = selectBox;
/*     */       
/* 434 */       setOverscroll(false, false);
/* 435 */       setFadeScrollBars(false);
/* 436 */       setScrollingDisabled(true, false);
/*     */       
/* 438 */       this.list = newList();
/* 439 */       this.list.setTouchable(Touchable.disabled);
/* 440 */       this.list.setTypeToSelect(true);
/* 441 */       setActor(this.list);
/*     */       
/* 443 */       this.list.addListener((EventListener)new ClickListener()
/*     */           {
/*     */             public void clicked(InputEvent param2InputEvent, float param2Float1, float param2Float2)
/*     */             {
/* 447 */               if ((param2InputEvent = SelectBox.SelectBoxScrollPane.this.list.getSelected()) != null) selectBox.selection.items().clear(51); 
/* 448 */               selectBox.selection.choose(param2InputEvent);
/* 449 */               SelectBox.SelectBoxScrollPane.this.hide();
/*     */             }
/*     */             
/*     */             public boolean mouseMoved(InputEvent param2InputEvent, float param2Float1, float param2Float2) {
/*     */               int i;
/* 454 */               if ((i = SelectBox.SelectBoxScrollPane.this.list.getItemIndexAt(param2Float2)) != -1) SelectBox.SelectBoxScrollPane.this.list.setSelectedIndex(i); 
/* 455 */               return true;
/*     */             }
/*     */           });
/*     */       
/* 459 */       addListener((EventListener)new InputListener() {
/*     */             public void exit(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int, @Null Actor param2Actor) {
/* 461 */               if ((param2Actor == null || !SelectBox.SelectBoxScrollPane.this.isAscendantOf(param2Actor)) && (
/*     */                 
/* 463 */                 param2InputEvent = selectBox.getSelected()) != null) SelectBox.SelectBoxScrollPane.this.list.selection.set(param2InputEvent);
/*     */             
/*     */             }
/*     */           });
/*     */       
/* 468 */       this.hideListener = new InputListener() {
/*     */           public boolean touchDown(InputEvent param2InputEvent, float param2Float1, float param2Float2, int param2Int1, int param2Int2) {
/* 470 */             Actor actor = param2InputEvent.getTarget();
/* 471 */             if (SelectBox.SelectBoxScrollPane.this.isAscendantOf(actor)) return false; 
/* 472 */             SelectBox.SelectBoxScrollPane.this.list.selection.set(selectBox.getSelected());
/* 473 */             SelectBox.SelectBoxScrollPane.this.hide();
/* 474 */             return false;
/*     */           }
/*     */           
/*     */           public boolean keyDown(InputEvent param2InputEvent, int param2Int) {
/* 478 */             switch (param2Int) {
/*     */               case 66:
/*     */               case 160:
/* 481 */                 selectBox.selection.choose(SelectBox.SelectBoxScrollPane.this.list.getSelected());
/*     */               
/*     */               case 111:
/* 484 */                 SelectBox.SelectBoxScrollPane.this.hide();
/* 485 */                 param2InputEvent.stop();
/* 486 */                 return true;
/*     */             } 
/* 488 */             return false;
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected List<T> newList() {
/* 496 */       return new List<T>(this.selectBox.style.listStyle) {
/*     */           public String toString(T param2T) {
/* 498 */             return SelectBox.SelectBoxScrollPane.this.selectBox.toString(param2T);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     public void show(Stage param1Stage) {
/* 504 */       if (this.list.isTouchable())
/*     */         return; 
/* 506 */       param1Stage.addActor((Actor)this);
/* 507 */       param1Stage.addCaptureListener((EventListener)this.hideListener);
/* 508 */       param1Stage.addListener((EventListener)this.list.getKeyListener());
/*     */       
/* 510 */       this.selectBox.localToStageCoordinates(this.stagePosition.set(0.0F, 0.0F));
/*     */ 
/*     */ 
/*     */       
/* 514 */       float f1, f2 = (f1 = this.list.getItemHeight()) * ((this.maxListCount <= 0) ? this.selectBox.items.size : Math.min(this.maxListCount, this.selectBox.items.size));
/*     */       Drawable drawable;
/* 516 */       if ((drawable = (getStyle()).background) != null) f2 += drawable.getTopHeight() + drawable.getBottomHeight();
/*     */       
/* 518 */       if ((drawable = (this.list.getStyle()).background) != null) f2 += drawable.getTopHeight() + drawable.getBottomHeight();
/*     */       
/* 520 */       float f3 = this.stagePosition.y;
/* 521 */       float f4 = param1Stage.getHeight() - f3 - this.selectBox.getHeight();
/* 522 */       boolean bool = true;
/* 523 */       if (f2 > f3) {
/* 524 */         if (f4 > f3) {
/* 525 */           bool = false;
/* 526 */           f2 = Math.min(f2, f4);
/*     */         } else {
/* 528 */           f2 = f3;
/*     */         } 
/*     */       }
/* 531 */       if (bool) {
/* 532 */         setY(this.stagePosition.y - f2);
/*     */       } else {
/* 534 */         setY(this.stagePosition.y + this.selectBox.getHeight());
/*     */       } 
/* 536 */       setHeight(f2);
/* 537 */       validate();
/* 538 */       f2 = Math.max(getPrefWidth(), this.selectBox.getWidth());
/* 539 */       setWidth(f2);
/*     */ 
/*     */       
/* 542 */       if ((f3 = this.stagePosition.x) + f2 > param1Stage.getWidth() && (
/*     */         
/* 544 */         f3 = f3 - getWidth() - this.selectBox.getWidth() - 1.0F) < 0.0F) f3 = 0.0F;
/*     */       
/* 546 */       setX(f3);
/*     */       
/* 548 */       validate();
/* 549 */       scrollTo(0.0F, this.list.getHeight() - this.selectBox.getSelectedIndex() * f1 - f1 / 2.0F, 0.0F, 0.0F, true, true);
/* 550 */       updateVisualScroll();
/*     */       
/* 552 */       this.previousScrollFocus = null;
/*     */       Actor actor;
/* 554 */       if ((actor = param1Stage.getScrollFocus()) != null && !actor.isDescendantOf((Actor)this)) this.previousScrollFocus = actor; 
/* 555 */       param1Stage.setScrollFocus((Actor)this);
/*     */       
/* 557 */       this.list.selection.set(this.selectBox.getSelected());
/* 558 */       this.list.setTouchable(Touchable.enabled);
/* 559 */       clearActions();
/* 560 */       this.selectBox.onShow((Actor)this, bool);
/*     */     }
/*     */     
/*     */     public void hide() {
/* 564 */       if (!this.list.isTouchable() || !hasParent())
/* 565 */         return;  this.list.setTouchable(Touchable.disabled);
/*     */       
/*     */       Stage stage;
/* 568 */       if ((stage = getStage()) != null) {
/* 569 */         stage.removeCaptureListener((EventListener)this.hideListener);
/* 570 */         stage.removeListener((EventListener)this.list.getKeyListener());
/* 571 */         if (this.previousScrollFocus != null && this.previousScrollFocus.getStage() == null) this.previousScrollFocus = null; 
/*     */         Actor actor;
/* 573 */         if ((actor = stage.getScrollFocus()) == null || isAscendantOf(actor)) stage.setScrollFocus(this.previousScrollFocus);
/*     */       
/*     */       } 
/* 576 */       clearActions();
/* 577 */       this.selectBox.onHide((Actor)this);
/*     */     }
/*     */     
/*     */     public void draw(Batch param1Batch, float param1Float) {
/* 581 */       this.selectBox.localToStageCoordinates(SelectBox.temp.set(0.0F, 0.0F));
/* 582 */       if (!SelectBox.temp.equals(this.stagePosition)) hide(); 
/* 583 */       super.draw(param1Batch, param1Float);
/*     */     }
/*     */     
/*     */     public void act(float param1Float) {
/* 587 */       super.act(param1Float);
/* 588 */       toFront();
/*     */     }
/*     */     
/*     */     protected void setStage(Stage param1Stage) {
/*     */       Stage stage;
/* 593 */       if ((stage = getStage()) != null) {
/* 594 */         stage.removeCaptureListener((EventListener)this.hideListener);
/* 595 */         stage.removeListener((EventListener)this.list.getKeyListener());
/*     */       } 
/* 597 */       super.setStage(param1Stage);
/*     */     }
/*     */     
/*     */     public List<T> getList() {
/* 601 */       return this.list;
/*     */     }
/*     */     
/*     */     public SelectBox<T> getSelectBox() {
/* 605 */       return this.selectBox;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SelectBoxStyle
/*     */   {
/*     */     public BitmapFont font;
/*     */     
/* 614 */     public Color fontColor = new Color(1.0F, 1.0F, 1.0F, 1.0F);
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
/* 626 */       this.font = param1BitmapFont;
/* 627 */       this.fontColor.set(param1Color);
/* 628 */       this.background = param1Drawable;
/* 629 */       this.scrollStyle = param1ScrollPaneStyle;
/* 630 */       this.listStyle = param1ListStyle; } public List.ListStyle listStyle; @Null
/*     */     public Drawable backgroundOver; @Null
/*     */     public Drawable backgroundOpen; @Null
/*     */     public Drawable backgroundDisabled; public SelectBoxStyle() {} public SelectBoxStyle(SelectBoxStyle param1SelectBoxStyle) {
/* 634 */       this.font = param1SelectBoxStyle.font;
/* 635 */       this.fontColor.set(param1SelectBoxStyle.fontColor);
/*     */       
/* 637 */       if (param1SelectBoxStyle.overFontColor != null) this.overFontColor = new Color(param1SelectBoxStyle.overFontColor); 
/* 638 */       if (param1SelectBoxStyle.disabledFontColor != null) this.disabledFontColor = new Color(param1SelectBoxStyle.disabledFontColor);
/*     */       
/* 640 */       this.background = param1SelectBoxStyle.background;
/* 641 */       this.scrollStyle = new ScrollPane.ScrollPaneStyle(param1SelectBoxStyle.scrollStyle);
/* 642 */       this.listStyle = new List.ListStyle(param1SelectBoxStyle.listStyle);
/*     */       
/* 644 */       this.backgroundOver = param1SelectBoxStyle.backgroundOver;
/* 645 */       this.backgroundOpen = param1SelectBoxStyle.backgroundOpen;
/* 646 */       this.backgroundDisabled = param1SelectBoxStyle.backgroundDisabled;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\SelectBox.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */