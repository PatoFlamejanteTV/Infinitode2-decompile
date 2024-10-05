/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Event;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.badlogic.gdx.utils.SnapshotArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private ButtonStyle style;
/*     */   boolean isChecked;
/*     */   boolean isDisabled;
/*     */   ButtonGroup buttonGroup;
/*     */   private ClickListener clickListener;
/*     */   private boolean programmaticChangeEvents = true;
/*     */   
/*     */   public Button(Skin paramSkin) {
/*  52 */     super(paramSkin);
/*  53 */     initialize();
/*  54 */     setStyle(paramSkin.<ButtonStyle>get(ButtonStyle.class));
/*  55 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public Button(Skin paramSkin, String paramString) {
/*  59 */     super(paramSkin);
/*  60 */     initialize();
/*  61 */     setStyle(paramSkin.<ButtonStyle>get(paramString, ButtonStyle.class));
/*  62 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public Button(Actor paramActor, Skin paramSkin, String paramString) {
/*  66 */     this(paramActor, paramSkin.<ButtonStyle>get(paramString, ButtonStyle.class));
/*  67 */     setSkin(paramSkin);
/*     */   }
/*     */   
/*     */   public Button(Actor paramActor, ButtonStyle paramButtonStyle) {
/*  71 */     initialize();
/*  72 */     add(paramActor);
/*  73 */     setStyle(paramButtonStyle);
/*  74 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public Button(ButtonStyle paramButtonStyle) {
/*  78 */     initialize();
/*  79 */     setStyle(paramButtonStyle);
/*  80 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public Button() {
/*  85 */     initialize();
/*     */   }
/*     */   
/*     */   private void initialize() {
/*  89 */     setTouchable(Touchable.enabled);
/*  90 */     addListener((EventListener)(this.clickListener = new ClickListener() {
/*     */           public void clicked(InputEvent param1InputEvent, float param1Float1, float param1Float2) {
/*  92 */             if (Button.this.isDisabled())
/*  93 */               return;  Button.this.setChecked(!Button.this.isChecked, true);
/*     */           }
/*     */         }));
/*     */   }
/*     */   
/*     */   public Button(@Null Drawable paramDrawable) {
/*  99 */     this(new ButtonStyle(paramDrawable, null, null));
/*     */   }
/*     */   
/*     */   public Button(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2) {
/* 103 */     this(new ButtonStyle(paramDrawable1, paramDrawable2, null));
/*     */   }
/*     */   
/*     */   public Button(@Null Drawable paramDrawable1, @Null Drawable paramDrawable2, @Null Drawable paramDrawable3) {
/* 107 */     this(new ButtonStyle(paramDrawable1, paramDrawable2, paramDrawable3));
/*     */   }
/*     */   
/*     */   public Button(Actor paramActor, Skin paramSkin) {
/* 111 */     this(paramActor, paramSkin.<ButtonStyle>get(ButtonStyle.class));
/*     */   }
/*     */   
/*     */   public void setChecked(boolean paramBoolean) {
/* 115 */     setChecked(paramBoolean, this.programmaticChangeEvents);
/*     */   }
/*     */   
/*     */   void setChecked(boolean paramBoolean1, boolean paramBoolean2) {
/* 119 */     if (this.isChecked == paramBoolean1)
/* 120 */       return;  if (this.buttonGroup != null && !this.buttonGroup.canCheck(this, paramBoolean1))
/* 121 */       return;  this.isChecked = paramBoolean1;
/*     */     
/* 123 */     if (paramBoolean2) {
/* 124 */       ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/* 125 */       if (fire((Event)changeEvent)) this.isChecked = !paramBoolean1; 
/* 126 */       Pools.free(changeEvent);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void toggle() {
/* 133 */     setChecked(!this.isChecked);
/*     */   }
/*     */   
/*     */   public boolean isChecked() {
/* 137 */     return this.isChecked;
/*     */   }
/*     */   
/*     */   public boolean isPressed() {
/* 141 */     return this.clickListener.isVisualPressed();
/*     */   }
/*     */   
/*     */   public boolean isOver() {
/* 145 */     return this.clickListener.isOver();
/*     */   }
/*     */   
/*     */   public ClickListener getClickListener() {
/* 149 */     return this.clickListener;
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 153 */     return this.isDisabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 158 */     this.isDisabled = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/* 164 */     this.programmaticChangeEvents = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setStyle(ButtonStyle paramButtonStyle) {
/* 168 */     if (paramButtonStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/* 169 */     this.style = paramButtonStyle;
/*     */     
/* 171 */     setBackground(getBackgroundDrawable());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ButtonStyle getStyle() {
/* 177 */     return this.style;
/*     */   }
/*     */   
/*     */   @Null
/*     */   public ButtonGroup getButtonGroup() {
/* 182 */     return this.buttonGroup;
/*     */   }
/*     */   
/*     */   @Null
/*     */   protected Drawable getBackgroundDrawable() {
/* 187 */     if (isDisabled() && this.style.disabled != null) return this.style.disabled; 
/* 188 */     if (isPressed()) {
/* 189 */       if (isChecked() && this.style.checkedDown != null) return this.style.checkedDown; 
/* 190 */       if (this.style.down != null) return this.style.down; 
/*     */     } 
/* 192 */     if (isOver()) {
/* 193 */       if (isChecked())
/* 194 */       { if (this.style.checkedOver != null) return this.style.checkedOver;
/*     */          }
/* 196 */       else if (this.style.over != null) { return this.style.over; }
/*     */     
/*     */     }
/* 199 */     boolean bool = hasKeyboardFocus();
/* 200 */     if (isChecked()) {
/* 201 */       if (bool && this.style.checkedFocused != null) return this.style.checkedFocused; 
/* 202 */       if (this.style.checked != null) return this.style.checked; 
/* 203 */       if (isOver() && this.style.over != null) return this.style.over; 
/*     */     } 
/* 205 */     if (bool && this.style.focused != null) return this.style.focused; 
/* 206 */     return this.style.up;
/*     */   }
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     float f1, f2;
/* 210 */     validate();
/*     */     
/* 212 */     setBackground(getBackgroundDrawable());
/*     */ 
/*     */     
/* 215 */     if (isPressed() && !isDisabled()) {
/* 216 */       f1 = this.style.pressedOffsetX;
/* 217 */       f2 = this.style.pressedOffsetY;
/* 218 */     } else if (isChecked() && !isDisabled()) {
/* 219 */       f1 = this.style.checkedOffsetX;
/* 220 */       f2 = this.style.checkedOffsetY;
/*     */     } else {
/* 222 */       f1 = this.style.unpressedOffsetX;
/* 223 */       f2 = this.style.unpressedOffsetY;
/*     */     } 
/* 225 */     boolean bool = (f1 != 0.0F || f2 != 0.0F) ? true : false;
/*     */     
/* 227 */     SnapshotArray snapshotArray = getChildren();
/* 228 */     if (bool)
/* 229 */       for (byte b = 0; b < ((Array)snapshotArray).size; b++) {
/* 230 */         ((Actor)snapshotArray.get(b)).moveBy(f1, f2);
/*     */       } 
/* 232 */     super.draw(paramBatch, paramFloat);
/* 233 */     if (bool) {
/* 234 */       for (byte b = 0; b < ((Array)snapshotArray).size; b++) {
/* 235 */         ((Actor)snapshotArray.get(b)).moveBy(-f1, -f2);
/*     */       }
/*     */     }
/*     */     Stage stage;
/* 239 */     if ((stage = getStage()) != null && stage.getActionsRequestRendering() && isPressed() != this.clickListener.isPressed())
/* 240 */       Gdx.graphics.requestRendering(); 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 244 */     float f = super.getPrefWidth();
/* 245 */     if (this.style.up != null) f = Math.max(f, this.style.up.getMinWidth()); 
/* 246 */     if (this.style.down != null) f = Math.max(f, this.style.down.getMinWidth()); 
/* 247 */     if (this.style.checked != null) f = Math.max(f, this.style.checked.getMinWidth()); 
/* 248 */     return f;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 252 */     float f = super.getPrefHeight();
/* 253 */     if (this.style.up != null) f = Math.max(f, this.style.up.getMinHeight()); 
/* 254 */     if (this.style.down != null) f = Math.max(f, this.style.down.getMinHeight()); 
/* 255 */     if (this.style.checked != null) f = Math.max(f, this.style.checked.getMinHeight()); 
/* 256 */     return f;
/*     */   }
/*     */   
/*     */   public float getMinWidth() {
/* 260 */     return getPrefWidth();
/*     */   }
/*     */   
/*     */   public float getMinHeight() {
/* 264 */     return getPrefHeight();
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
/* 278 */       this.up = param1Drawable1;
/* 279 */       this.down = param1Drawable2;
/* 280 */       this.checked = param1Drawable3;
/*     */     } @Null
/*     */     public Drawable checkedFocused; public float pressedOffsetX; public float pressedOffsetY; public float unpressedOffsetX; public float unpressedOffsetY; public float checkedOffsetX; public float checkedOffsetY; public ButtonStyle() {}
/*     */     public ButtonStyle(ButtonStyle param1ButtonStyle) {
/* 284 */       this.up = param1ButtonStyle.up;
/* 285 */       this.down = param1ButtonStyle.down;
/* 286 */       this.over = param1ButtonStyle.over;
/* 287 */       this.focused = param1ButtonStyle.focused;
/* 288 */       this.disabled = param1ButtonStyle.disabled;
/*     */       
/* 290 */       this.checked = param1ButtonStyle.checked;
/* 291 */       this.checkedOver = param1ButtonStyle.checkedOver;
/* 292 */       this.checkedDown = param1ButtonStyle.checkedDown;
/* 293 */       this.checkedFocused = param1ButtonStyle.checkedFocused;
/*     */       
/* 295 */       this.pressedOffsetX = param1ButtonStyle.pressedOffsetX;
/* 296 */       this.pressedOffsetY = param1ButtonStyle.pressedOffsetY;
/* 297 */       this.unpressedOffsetX = param1ButtonStyle.unpressedOffsetX;
/* 298 */       this.unpressedOffsetY = param1ButtonStyle.unpressedOffsetY;
/* 299 */       this.checkedOffsetX = param1ButtonStyle.checkedOffsetX;
/* 300 */       this.checkedOffsetY = param1ButtonStyle.checkedOffsetY;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Button.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */