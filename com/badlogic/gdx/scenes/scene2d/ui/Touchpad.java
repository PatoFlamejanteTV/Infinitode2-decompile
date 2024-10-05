/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Circle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Event;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.Touchable;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
/*     */ import com.badlogic.gdx.utils.Null;
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
/*     */ public class Touchpad
/*     */   extends Widget
/*     */ {
/*     */   private TouchpadStyle style;
/*     */   boolean touched;
/*     */   boolean resetOnTouchUp = true;
/*     */   private float deadzoneRadius;
/*  45 */   private final Circle knobBounds = new Circle(0.0F, 0.0F, 0.0F);
/*  46 */   private final Circle touchBounds = new Circle(0.0F, 0.0F, 0.0F);
/*  47 */   private final Circle deadzoneBounds = new Circle(0.0F, 0.0F, 0.0F);
/*  48 */   private final Vector2 knobPosition = new Vector2();
/*  49 */   private final Vector2 knobPercent = new Vector2();
/*     */ 
/*     */   
/*     */   public Touchpad(float paramFloat, Skin paramSkin) {
/*  53 */     this(paramFloat, paramSkin.<TouchpadStyle>get(TouchpadStyle.class));
/*     */   }
/*     */ 
/*     */   
/*     */   public Touchpad(float paramFloat, Skin paramSkin, String paramString) {
/*  58 */     this(paramFloat, paramSkin.<TouchpadStyle>get(paramString, TouchpadStyle.class));
/*     */   }
/*     */ 
/*     */   
/*     */   public Touchpad(float paramFloat, TouchpadStyle paramTouchpadStyle) {
/*  63 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("deadzoneRadius must be > 0"); 
/*  64 */     this.deadzoneRadius = paramFloat;
/*     */     
/*  66 */     this.knobPosition.set(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     
/*  68 */     setStyle(paramTouchpadStyle);
/*  69 */     setSize(getPrefWidth(), getPrefHeight());
/*     */     
/*  71 */     addListener((EventListener)new InputListener() {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  73 */             if (Touchpad.this.touched) return false; 
/*  74 */             Touchpad.this.touched = true;
/*  75 */             Touchpad.this.calculatePositionAndValue(param1Float1, param1Float2, false);
/*  76 */             return true;
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  80 */             Touchpad.this.calculatePositionAndValue(param1Float1, param1Float2, false);
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  84 */             Touchpad.this.touched = false;
/*  85 */             Touchpad.this.calculatePositionAndValue(param1Float1, param1Float2, Touchpad.this.resetOnTouchUp);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   void calculatePositionAndValue(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  91 */     float f1 = this.knobPosition.x;
/*  92 */     float f2 = this.knobPosition.y;
/*  93 */     float f3 = this.knobPercent.x;
/*  94 */     float f4 = this.knobPercent.y;
/*  95 */     float f5 = this.knobBounds.x;
/*  96 */     float f6 = this.knobBounds.y;
/*  97 */     this.knobPosition.set(f5, f6);
/*  98 */     this.knobPercent.set(0.0F, 0.0F);
/*  99 */     if (!paramBoolean && 
/* 100 */       !this.deadzoneBounds.contains(paramFloat1, paramFloat2)) {
/* 101 */       this.knobPercent.set((paramFloat1 - f5) / this.knobBounds.radius, (paramFloat2 - f6) / this.knobBounds.radius);
/*     */       float f;
/* 103 */       if ((f = this.knobPercent.len()) > 1.0F) this.knobPercent.scl(1.0F / f); 
/* 104 */       if (this.knobBounds.contains(paramFloat1, paramFloat2)) {
/* 105 */         this.knobPosition.set(paramFloat1, paramFloat2);
/*     */       } else {
/* 107 */         this.knobPosition.set(this.knobPercent).nor().scl(this.knobBounds.radius).add(this.knobBounds.x, this.knobBounds.y);
/*     */       } 
/*     */     } 
/*     */     
/* 111 */     if (f3 != this.knobPercent.x || f4 != this.knobPercent.y) {
/* 112 */       ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/* 113 */       if (fire((Event)changeEvent)) {
/* 114 */         this.knobPercent.set(f3, f4);
/* 115 */         this.knobPosition.set(f1, f2);
/*     */       } 
/* 117 */       Pools.free(changeEvent);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setStyle(TouchpadStyle paramTouchpadStyle) {
/* 122 */     if (paramTouchpadStyle == null) throw new IllegalArgumentException("style cannot be null"); 
/* 123 */     this.style = paramTouchpadStyle;
/* 124 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TouchpadStyle getStyle() {
/* 130 */     return this.style;
/*     */   }
/*     */   
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 134 */     if (paramBoolean && getTouchable() != Touchable.enabled) return null; 
/* 135 */     if (!isVisible()) return null; 
/* 136 */     return this.touchBounds.contains(paramFloat1, paramFloat2) ? this : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void layout() {
/* 141 */     float f1 = getWidth() / 2.0F;
/* 142 */     float f2 = getHeight() / 2.0F;
/* 143 */     float f3 = Math.min(f1, f2);
/* 144 */     this.touchBounds.set(f1, f2, f3);
/* 145 */     if (this.style.knob != null) f3 -= Math.max(this.style.knob.getMinWidth(), this.style.knob.getMinHeight()) / 2.0F; 
/* 146 */     this.knobBounds.set(f1, f2, f3);
/* 147 */     this.deadzoneBounds.set(f1, f2, this.deadzoneRadius);
/*     */     
/* 149 */     this.knobPosition.set(f1, f2);
/* 150 */     this.knobPercent.set(0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 154 */     validate();
/*     */     
/* 156 */     Color color = getColor();
/* 157 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/*     */     
/* 159 */     paramFloat = getX();
/* 160 */     float f1 = getY();
/* 161 */     float f2 = getWidth();
/* 162 */     float f3 = getHeight();
/*     */     
/*     */     Drawable drawable2;
/* 165 */     if ((drawable2 = this.style.background) != null) drawable2.draw(paramBatch, paramFloat, f1, f2, f3);
/*     */     
/*     */     Drawable drawable1;
/* 168 */     if ((drawable1 = this.style.knob) != null) {
/* 169 */       paramFloat += this.knobPosition.x - drawable1.getMinWidth() / 2.0F;
/* 170 */       f1 += this.knobPosition.y - drawable1.getMinHeight() / 2.0F;
/* 171 */       drawable1.draw(paramBatch, paramFloat, f1, drawable1.getMinWidth(), drawable1.getMinHeight());
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 176 */     return (this.style.background != null) ? this.style.background.getMinWidth() : 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 180 */     return (this.style.background != null) ? this.style.background.getMinHeight() : 0.0F;
/*     */   }
/*     */   
/*     */   public boolean isTouched() {
/* 184 */     return this.touched;
/*     */   }
/*     */   
/*     */   public boolean getResetOnTouchUp() {
/* 188 */     return this.resetOnTouchUp;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setResetOnTouchUp(boolean paramBoolean) {
/* 193 */     this.resetOnTouchUp = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeadzone(float paramFloat) {
/* 198 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("deadzoneRadius must be > 0"); 
/* 199 */     this.deadzoneRadius = paramFloat;
/* 200 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getKnobX() {
/* 205 */     return this.knobPosition.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getKnobY() {
/* 210 */     return this.knobPosition.y;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getKnobPercentX() {
/* 216 */     return this.knobPercent.x;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getKnobPercentY() {
/* 222 */     return this.knobPercent.y;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class TouchpadStyle
/*     */   {
/*     */     @Null
/*     */     public Drawable background;
/*     */     @Null
/*     */     public Drawable knob;
/*     */     
/*     */     public TouchpadStyle() {}
/*     */     
/*     */     public TouchpadStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2) {
/* 236 */       this.background = param1Drawable1;
/* 237 */       this.knob = param1Drawable2;
/*     */     }
/*     */     
/*     */     public TouchpadStyle(TouchpadStyle param1TouchpadStyle) {
/* 241 */       this.background = param1TouchpadStyle.background;
/* 242 */       this.knob = param1TouchpadStyle.knob;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Touchpad.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */