/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Circle;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Event;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
/*     */ import com.prineside.tdi2.scene2d.Touchable;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
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
/*     */ public class Touchpad
/*     */   extends Widget
/*     */ {
/*     */   private TouchpadStyle l;
/*     */   boolean j;
/*     */   boolean k = true;
/*     */   private float m;
/*  45 */   private final Circle n = new Circle(0.0F, 0.0F, 0.0F);
/*  46 */   private final Circle o = new Circle(0.0F, 0.0F, 0.0F);
/*  47 */   private final Circle p = new Circle(0.0F, 0.0F, 0.0F);
/*  48 */   private final Vector2 q = new Vector2();
/*  49 */   private final Vector2 r = new Vector2();
/*     */ 
/*     */   
/*     */   public Touchpad(float paramFloat, TouchpadStyle paramTouchpadStyle) {
/*  53 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("deadzoneRadius must be > 0"); 
/*  54 */     this.m = paramFloat;
/*     */     
/*  56 */     this.q.set(getWidth() / 2.0F, getHeight() / 2.0F);
/*     */     
/*  58 */     setStyle(paramTouchpadStyle);
/*  59 */     setSize(getPrefWidth(), getPrefHeight());
/*     */     
/*  61 */     addListener((EventListener)new InputListener(this) {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  63 */             if (this.a.j) return false; 
/*  64 */             this.a.j = true;
/*  65 */             this.a.a(param1Float1, param1Float2, false);
/*  66 */             return true;
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  70 */             this.a.a(param1Float1, param1Float2, false);
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  74 */             this.a.j = false;
/*  75 */             this.a.a(param1Float1, param1Float2, this.a.k);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   final void a(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/*  81 */     float f1 = this.q.x;
/*  82 */     float f2 = this.q.y;
/*  83 */     float f3 = this.r.x;
/*  84 */     float f4 = this.r.y;
/*  85 */     float f5 = this.n.x;
/*  86 */     float f6 = this.n.y;
/*  87 */     this.q.set(f5, f6);
/*  88 */     this.r.set(0.0F, 0.0F);
/*  89 */     if (!paramBoolean && 
/*  90 */       !this.p.contains(paramFloat1, paramFloat2)) {
/*  91 */       this.r.set((paramFloat1 - f5) / this.n.radius, (paramFloat2 - f6) / this.n.radius);
/*     */       float f;
/*  93 */       if ((f = this.r.len()) > 1.0F) this.r.scl(1.0F / f); 
/*  94 */       if (this.n.contains(paramFloat1, paramFloat2)) {
/*  95 */         this.q.set(paramFloat1, paramFloat2);
/*     */       } else {
/*  97 */         this.q.set(this.r).nor().scl(this.n.radius).add(this.n.x, this.n.y);
/*     */       } 
/*     */     } 
/*     */     
/* 101 */     if (f3 != this.r.x || f4 != this.r.y) {
/* 102 */       ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/* 103 */       if (fire((Event)changeEvent)) {
/* 104 */         this.r.set(f3, f4);
/* 105 */         this.q.set(f1, f2);
/*     */       } 
/* 107 */       Pools.free(changeEvent);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setStyle(TouchpadStyle paramTouchpadStyle) {
/* 112 */     if (paramTouchpadStyle == null) throw new IllegalArgumentException("style cannot be null"); 
/* 113 */     this.l = paramTouchpadStyle;
/* 114 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TouchpadStyle getStyle() {
/* 120 */     return this.l;
/*     */   }
/*     */   
/*     */   public Actor hit(float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 124 */     if (paramBoolean && getTouchable() != Touchable.enabled) return null; 
/* 125 */     if (!isVisible()) return null; 
/* 126 */     return this.o.contains(paramFloat1, paramFloat2) ? this : null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void layout() {
/* 131 */     float f1 = getWidth() / 2.0F;
/* 132 */     float f2 = getHeight() / 2.0F;
/* 133 */     float f3 = Math.min(f1, f2);
/* 134 */     this.o.set(f1, f2, f3);
/* 135 */     if (this.l.knob != null) f3 -= Math.max(this.l.knob.getMinWidth(), this.l.knob.getMinHeight()) / 2.0F; 
/* 136 */     this.n.set(f1, f2, f3);
/* 137 */     this.p.set(f1, f2, this.m);
/*     */     
/* 139 */     this.q.set(f1, f2);
/* 140 */     this.r.set(0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/* 144 */     validate();
/*     */     
/* 146 */     Color color = getColor();
/* 147 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/*     */     
/* 149 */     paramFloat = getX();
/* 150 */     float f1 = getY();
/* 151 */     float f2 = getWidth();
/* 152 */     float f3 = getHeight();
/*     */     
/*     */     Drawable drawable2;
/* 155 */     if ((drawable2 = this.l.background) != null) drawable2.draw(paramBatch, paramFloat, f1, f2, f3);
/*     */     
/*     */     Drawable drawable1;
/* 158 */     if ((drawable1 = this.l.knob) != null) {
/* 159 */       paramFloat += this.q.x - drawable1.getMinWidth() / 2.0F;
/* 160 */       f1 += this.q.y - drawable1.getMinHeight() / 2.0F;
/* 161 */       drawable1.draw(paramBatch, paramFloat, f1, drawable1.getMinWidth(), drawable1.getMinHeight());
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 166 */     return (this.l.background != null) ? this.l.background.getMinWidth() : 0.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 170 */     return (this.l.background != null) ? this.l.background.getMinHeight() : 0.0F;
/*     */   }
/*     */   
/*     */   public boolean isTouched() {
/* 174 */     return this.j;
/*     */   }
/*     */   
/*     */   public boolean getResetOnTouchUp() {
/* 178 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setResetOnTouchUp(boolean paramBoolean) {
/* 183 */     this.k = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDeadzone(float paramFloat) {
/* 188 */     if (paramFloat < 0.0F) throw new IllegalArgumentException("deadzoneRadius must be > 0"); 
/* 189 */     this.m = paramFloat;
/* 190 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public float getKnobX() {
/* 195 */     return this.q.x;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getKnobY() {
/* 200 */     return this.q.y;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getKnobPercentX() {
/* 206 */     return this.r.x;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float getKnobPercentY() {
/* 212 */     return this.r.y;
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
/* 226 */       this.background = param1Drawable1;
/* 227 */       this.knob = param1Drawable2;
/*     */     }
/*     */     
/*     */     public TouchpadStyle(TouchpadStyle param1TouchpadStyle) {
/* 231 */       this.background = param1TouchpadStyle.background;
/* 232 */       this.knob = param1TouchpadStyle.knob;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Touchpad.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */