/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Event;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
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
/*     */ public class Button
/*     */   extends Table
/*     */   implements Disableable
/*     */ {
/*     */   private ButtonStyle n;
/*     */   boolean k;
/*     */   private boolean o;
/*     */   ButtonGroup l;
/*     */   private ClickListener p;
/*     */   private boolean q = true;
/*     */   
/*     */   public Button(Actor paramActor, ButtonStyle paramButtonStyle) {
/*  52 */     d();
/*  53 */     add(paramActor);
/*  54 */     setStyle(paramButtonStyle);
/*  55 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public Button(ButtonStyle paramButtonStyle) {
/*  59 */     d();
/*  60 */     setStyle(paramButtonStyle);
/*  61 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public Button() {
/*  66 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/*  70 */     setTouchable(Touchable.enabled);
/*  71 */     addListener((EventListener)(this.p = new ClickListener(this) {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  73 */             if (this.a.isDisabled())
/*  74 */               return;  this.a.a(!this.a.k, true);
/*     */           }
/*     */         }));
/*     */   }
/*     */   
/*     */   public Button(@Null Drawable paramDrawable) {
/*  80 */     this(new ButtonStyle(paramDrawable, null, null));
/*     */   }
/*     */   
/*     */   public Button(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2) {
/*  84 */     this(new ButtonStyle(paramDrawable1, paramDrawable2, null));
/*     */   }
/*     */   
/*     */   public Button(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2, @Null Drawable paramDrawable3) {
/*  88 */     this(new ButtonStyle(paramDrawable1, paramDrawable2, paramDrawable3));
/*     */   }
/*     */   
/*     */   public void setChecked(boolean paramBoolean) {
/*  92 */     a(paramBoolean, this.q);
/*     */   }
/*     */   
/*     */   final void a(boolean paramBoolean1, boolean paramBoolean2) {
/*  96 */     if (this.k == paramBoolean1)
/*  97 */       return;  if (this.l != null && !this.l.a(this, paramBoolean1))
/*  98 */       return;  this.k = paramBoolean1;
/*     */     
/* 100 */     if (paramBoolean2) {
/* 101 */       ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/* 102 */       if (fire((Event)changeEvent)) this.k = !paramBoolean1; 
/* 103 */       Pools.free(changeEvent);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toggle() {
/* 110 */     setChecked(!this.k);
/*     */   }
/*     */   
/*     */   public boolean isChecked() {
/* 114 */     return this.k;
/*     */   }
/*     */   
/*     */   public boolean isPressed() {
/* 118 */     return this.p.isVisualPressed();
/*     */   }
/*     */   
/*     */   public boolean isOver() {
/* 122 */     return this.p.isOver();
/*     */   }
/*     */   
/*     */   public ClickListener getClickListener() {
/* 126 */     return this.p;
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 130 */     return this.o;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 135 */     this.o = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/* 141 */     this.q = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setStyle(ButtonStyle paramButtonStyle) {
/* 145 */     if (paramButtonStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 146 */     this.n = paramButtonStyle;
/*     */     
/* 148 */     setBackground(e());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ButtonStyle getStyle() {
/* 154 */     return this.n;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public ButtonGroup getButtonGroup() {
/* 159 */     return this.l;
/*     */   }
/*     */   
/*     */   @Null
/*     */   private Drawable e() {
/* 164 */     if (isDisabled() && this.n.disabled != null) return this.n.disabled; 
/* 165 */     if (isPressed()) {
/* 166 */       if (isChecked() && this.n.checkedDown != null) return this.n.checkedDown; 
/* 167 */       if (this.n.down != null) return this.n.down; 
/*     */     } 
/* 169 */     if (isOver()) {
/* 170 */       if (isChecked())
/* 171 */       { if (this.n.checkedOver != null) return this.n.checkedOver;
/*     */          }
/* 173 */       else if (this.n.over != null) { return this.n.over; }
/*     */     
/*     */     }
/* 176 */     boolean bool = hasKeyboardFocus();
/* 177 */     if (isChecked()) {
/* 178 */       if (bool && this.n.checkedFocused != null) return this.n.checkedFocused; 
/* 179 */       if (this.n.checked != null) return this.n.checked; 
/* 180 */       if (isOver() && this.n.over != null) return this.n.over; 
/*     */     } 
/* 182 */     if (bool && this.n.focused != null) return this.n.focused; 
/* 183 */     return this.n.up;
/*     */   }
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     float f1, f2;
/* 187 */     validate();
/*     */     
/* 189 */     setBackground(e());
/*     */ 
/*     */     
/* 192 */     if (isPressed() && !isDisabled()) {
/* 193 */       f1 = this.n.pressedOffsetX;
/* 194 */       f2 = this.n.pressedOffsetY;
/* 195 */     } else if (isChecked() && !isDisabled()) {
/* 196 */       f1 = this.n.checkedOffsetX;
/* 197 */       f2 = this.n.checkedOffsetY;
/*     */     } else {
/* 199 */       f1 = this.n.unpressedOffsetX;
/* 200 */       f2 = this.n.unpressedOffsetY;
/*     */     } 
/* 202 */     boolean bool = (f1 != 0.0F || f2 != 0.0F) ? true : false;
/*     */     
/* 204 */     SnapshotArray snapshotArray = getChildren();
/* 205 */     if (bool)
/* 206 */       for (byte b = 0; b < ((Array)snapshotArray).size; b++) {
/* 207 */         ((Actor)snapshotArray.get(b)).moveBy(f1, f2);
/*     */       } 
/* 209 */     super.draw(paramBatch, paramFloat);
/* 210 */     if (bool) {
/* 211 */       for (byte b = 0; b < ((Array)snapshotArray).size; b++) {
/* 212 */         ((Actor)snapshotArray.get(b)).moveBy(-f1, -f2);
/*     */       }
/*     */     }
/*     */     Stage stage;
/* 216 */     if ((stage = getStage()) != null && stage.getActionsRequestRendering() && isPressed() != this.p.isPressed())
/* 217 */       Gdx.graphics.requestRendering(); 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 221 */     float f = super.getPrefWidth();
/* 222 */     if (this.n.up != null) f = Math.max(f, this.n.up.getMinWidth()); 
/* 223 */     if (this.n.down != null) f = Math.max(f, this.n.down.getMinWidth()); 
/* 224 */     if (this.n.checked != null) f = Math.max(f, this.n.checked.getMinWidth()); 
/* 225 */     return f;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 229 */     float f = super.getPrefHeight();
/* 230 */     if (this.n.up != null) f = Math.max(f, this.n.up.getMinHeight()); 
/* 231 */     if (this.n.down != null) f = Math.max(f, this.n.down.getMinHeight()); 
/* 232 */     if (this.n.checked != null) f = Math.max(f, this.n.checked.getMinHeight()); 
/* 233 */     return f;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 237 */     return getPrefWidth();
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 241 */     return getPrefHeight();
/*     */   }
/*     */   public static class ButtonStyle { @Null
/*     */     public Drawable up; @Null
/*     */     public Drawable down; @Null
/*     */     public Drawable over; @Null
/*     */     public Drawable focused; @Null
/*     */     public Drawable disabled; @Null
/*     */     public Drawable checked; @Null
/*     */     public Drawable checkedOver;
/*     */     @Null
/*     */     public Drawable checkedDown;
/*     */     
/*     */     public ButtonStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2, @Null Drawable param1Drawable3) {
/* 255 */       this.up = param1Drawable1;
/* 256 */       this.down = param1Drawable2;
/* 257 */       this.checked = param1Drawable3;
/*     */     } @Null
/*     */     public Drawable checkedFocused; public float pressedOffsetX; public float pressedOffsetY; public float unpressedOffsetX; public float unpressedOffsetY; public float checkedOffsetX; public float checkedOffsetY; public ButtonStyle() {}
/*     */     public ButtonStyle(ButtonStyle param1ButtonStyle) {
/* 261 */       this.up = param1ButtonStyle.up;
/* 262 */       this.down = param1ButtonStyle.down;
/* 263 */       this.over = param1ButtonStyle.over;
/* 264 */       this.focused = param1ButtonStyle.focused;
/* 265 */       this.disabled = param1ButtonStyle.disabled;
/*     */       
/* 267 */       this.checked = param1ButtonStyle.checked;
/* 268 */       this.checkedOver = param1ButtonStyle.checkedOver;
/* 269 */       this.checkedDown = param1ButtonStyle.checkedDown;
/* 270 */       this.checkedFocused = param1ButtonStyle.checkedFocused;
/*     */       
/* 272 */       this.pressedOffsetX = param1ButtonStyle.pressedOffsetX;
/* 273 */       this.pressedOffsetY = param1ButtonStyle.pressedOffsetY;
/* 274 */       this.unpressedOffsetX = param1ButtonStyle.unpressedOffsetX;
/* 275 */       this.unpressedOffsetY = param1ButtonStyle.unpressedOffsetY;
/* 276 */       this.checkedOffsetX = param1ButtonStyle.checkedOffsetX;
/* 277 */       this.checkedOffsetY = param1ButtonStyle.checkedOffsetY;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Button.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */