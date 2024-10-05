/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.scenes.scene2d.Event;
/*     */ import com.badlogic.gdx.scenes.scene2d.Stage;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.utils.Disableable;
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
/*     */ 
/*     */ public class ProgressBar
/*     */   extends Widget
/*     */   implements Disableable
/*     */ {
/*     */   private ProgressBarStyle style;
/*     */   float min;
/*     */   float max;
/*     */   float stepSize;
/*     */   private float value;
/*     */   private float animateFromValue;
/*     */   float position;
/*     */   final boolean vertical;
/*     */   private float animateDuration;
/*     */   private float animateTime;
/*  51 */   private Interpolation animateInterpolation = Interpolation.linear; private Interpolation visualInterpolation = Interpolation.linear;
/*     */   boolean disabled;
/*     */   private boolean round = true, programmaticChangeEvents = true;
/*     */   
/*     */   public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin) {
/*  56 */     this(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSkin.<ProgressBarStyle>get("default-" + (paramBoolean ? "vertical" : "horizontal"), ProgressBarStyle.class));
/*     */   }
/*     */   
/*     */   public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin, String paramString) {
/*  60 */     this(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSkin.<ProgressBarStyle>get(paramString, ProgressBarStyle.class));
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
/*     */   public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, ProgressBarStyle paramProgressBarStyle) {
/*  74 */     if (paramFloat1 > paramFloat2) throw new IllegalArgumentException("max must be > min. min,max: " + paramFloat1 + ", " + paramFloat2); 
/*  75 */     if (paramFloat3 <= 0.0F) throw new IllegalArgumentException("stepSize must be > 0: " + paramFloat3); 
/*  76 */     setStyle(paramProgressBarStyle);
/*  77 */     this.min = paramFloat1;
/*  78 */     this.max = paramFloat2;
/*  79 */     this.stepSize = paramFloat3;
/*  80 */     this.vertical = paramBoolean;
/*  81 */     this.value = paramFloat1;
/*  82 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public void setStyle(ProgressBarStyle paramProgressBarStyle) {
/*  86 */     if (paramProgressBarStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  87 */     this.style = paramProgressBarStyle;
/*  88 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ProgressBarStyle getStyle() {
/*  94 */     return this.style;
/*     */   }
/*     */   
/*     */   public void act(float paramFloat) {
/*  98 */     super.act(paramFloat);
/*     */     
/* 100 */     this.animateTime -= paramFloat;
/*     */     Stage stage;
/* 102 */     if (this.animateTime > 0.0F && (stage = getStage()) != null && stage.getActionsRequestRendering()) Gdx.graphics.requestRendering();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     ProgressBarStyle progressBarStyle;
/* 109 */     Drawable drawable1 = (progressBarStyle = this.style).knob, drawable2 = getKnobDrawable();
/* 110 */     Drawable drawable3 = getBackgroundDrawable();
/* 111 */     Drawable drawable4 = getKnobBeforeDrawable();
/* 112 */     Drawable drawable5 = getKnobAfterDrawable();
/*     */     
/* 114 */     Color color = getColor();
/* 115 */     float f3 = getX(), f4 = getY();
/* 116 */     float f5 = getWidth(), f6 = getHeight();
/* 117 */     float f7 = (drawable1 == null) ? 0.0F : drawable1.getMinHeight();
/* 118 */     float f1 = (drawable1 == null) ? 0.0F : drawable1.getMinWidth();
/* 119 */     float f8 = getVisualPercent();
/*     */     
/* 121 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/*     */     
/* 123 */     if (this.vertical) {
/* 124 */       float f10 = 0.0F;
/* 125 */       if (drawable3 != null) {
/* 126 */         drawRound(paramBatch, drawable3, f3 + (f5 - drawable3.getMinWidth()) * 0.5F, f4, drawable3.getMinWidth(), f6);
/* 127 */         paramFloat = drawable3.getTopHeight();
/* 128 */         f10 = drawable3.getBottomHeight();
/* 129 */         f6 -= paramFloat + f10;
/*     */       } 
/*     */ 
/*     */       
/* 133 */       f8 = MathUtils.clamp((f2 = f6 - f7) * f8, 0.0F, f2);
/* 134 */       this.position = f10 + f8;
/*     */       
/* 136 */       float f11 = f7 * 0.5F;
/* 137 */       if (drawable4 != null) {
/* 138 */         drawRound(paramBatch, drawable4, f3 + (f5 - drawable4
/* 139 */             .getMinWidth()) * 0.5F, f4 + f10, drawable4
/*     */             
/* 141 */             .getMinWidth(), f8 + f11);
/*     */       }
/* 143 */       if (drawable5 != null) {
/* 144 */         drawRound(paramBatch, drawable5, f3 + (f5 - drawable5
/* 145 */             .getMinWidth()) * 0.5F, f4 + this.position + f11, drawable5
/*     */             
/* 147 */             .getMinWidth(), f2 - (
/* 148 */             this.round ? (float)Math.ceil((f8 - f11)) : (f8 - f11)));
/*     */       }
/* 150 */       if (drawable2 != null) {
/* 151 */         paramFloat = drawable2.getMinWidth(); f2 = drawable2.getMinHeight();
/* 152 */         drawRound(paramBatch, drawable2, f3 + (f5 - paramFloat) * 0.5F, f4 + this.position + (f7 - f2) * 0.5F, paramFloat, f2);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 158 */     paramFloat = 0.0F;
/* 159 */     if (f2 != null) {
/* 160 */       drawRound(paramBatch, f2, f3, Math.round(f4 + (f6 - f2.getMinHeight()) * 0.5F), f5, Math.round(f2.getMinHeight()));
/* 161 */       paramFloat = f2.getLeftWidth();
/* 162 */       float f = f2.getRightWidth();
/* 163 */       f5 -= paramFloat + f;
/*     */     } 
/*     */     
/*     */     float f2;
/* 167 */     f8 = MathUtils.clamp((f2 = f5 - f1) * f8, 0.0F, f2);
/* 168 */     this.position = paramFloat + f8;
/*     */     
/* 170 */     float f9 = f1 * 0.5F;
/* 171 */     if (drawable4 != null) {
/* 172 */       drawRound(paramBatch, drawable4, f3 + paramFloat, f4 + (f6 - drawable4
/*     */           
/* 174 */           .getMinHeight()) * 0.5F, f8 + f9, drawable4
/* 175 */           .getMinHeight());
/*     */     }
/* 177 */     if (drawable5 != null) {
/* 178 */       drawRound(paramBatch, drawable5, f3 + this.position + f9, f4 + (f6 - drawable5
/*     */           
/* 180 */           .getMinHeight()) * 0.5F, f2 - (
/* 181 */           this.round ? (float)Math.ceil((f8 - f9)) : (f8 - f9)), drawable5
/* 182 */           .getMinHeight());
/*     */     }
/* 184 */     if (drawable2 != null) {
/* 185 */       paramFloat = drawable2.getMinWidth(); f2 = drawable2.getMinHeight();
/* 186 */       drawRound(paramBatch, drawable2, f3 + this.position + (f1 - paramFloat) * 0.5F, f4 + (f6 - f2) * 0.5F, paramFloat, f2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawRound(Batch paramBatch, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 195 */     if (this.round) {
/* 196 */       paramFloat1 = (float)Math.floor(paramFloat1);
/* 197 */       paramFloat2 = (float)Math.floor(paramFloat2);
/* 198 */       paramFloat3 = (float)Math.ceil(paramFloat3);
/* 199 */       paramFloat4 = (float)Math.ceil(paramFloat4);
/*     */     } 
/* 201 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public float getValue() {
/* 205 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getVisualValue() {
/* 210 */     if (this.animateTime > 0.0F) return this.animateInterpolation.apply(this.animateFromValue, this.value, 1.0F - this.animateTime / this.animateDuration); 
/* 211 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateVisualValue() {
/* 216 */     this.animateTime = 0.0F;
/*     */   }
/*     */   
/*     */   public float getPercent() {
/* 220 */     if (this.min == this.max) return 0.0F; 
/* 221 */     return (this.value - this.min) / (this.max - this.min);
/*     */   }
/*     */   
/*     */   public float getVisualPercent() {
/* 225 */     if (this.min == this.max) return 0.0F; 
/* 226 */     return this.visualInterpolation.apply((getVisualValue() - this.min) / (this.max - this.min));
/*     */   }
/*     */   @Null
/*     */   protected Drawable getBackgroundDrawable() {
/* 230 */     if (this.disabled && this.style.disabledBackground != null) return this.style.disabledBackground; 
/* 231 */     return this.style.background;
/*     */   }
/*     */   @Null
/*     */   protected Drawable getKnobDrawable() {
/* 235 */     if (this.disabled && this.style.disabledKnob != null) return this.style.disabledKnob; 
/* 236 */     return this.style.knob;
/*     */   }
/*     */   
/*     */   protected Drawable getKnobBeforeDrawable() {
/* 240 */     if (this.disabled && this.style.disabledKnobBefore != null) return this.style.disabledKnobBefore; 
/* 241 */     return this.style.knobBefore;
/*     */   }
/*     */   
/*     */   protected Drawable getKnobAfterDrawable() {
/* 245 */     if (this.disabled && this.style.disabledKnobAfter != null) return this.style.disabledKnobAfter; 
/* 246 */     return this.style.knobAfter;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float getKnobPosition() {
/* 251 */     return this.position;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setValue(float paramFloat) {
/* 259 */     paramFloat = clamp(round(paramFloat));
/* 260 */     float f1 = this.value;
/* 261 */     if (paramFloat == f1) return false; 
/* 262 */     float f2 = getVisualValue();
/* 263 */     this.value = paramFloat;
/*     */     
/* 265 */     if (this.programmaticChangeEvents) {
/* 266 */       ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/* 267 */       boolean bool = fire((Event)changeEvent);
/* 268 */       Pools.free(changeEvent);
/* 269 */       if (bool) {
/* 270 */         this.value = f1;
/* 271 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 275 */     if (this.animateDuration > 0.0F) {
/* 276 */       this.animateFromValue = f2;
/* 277 */       this.animateTime = this.animateDuration;
/*     */     } 
/* 279 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected float round(float paramFloat) {
/* 284 */     return Math.round(paramFloat / this.stepSize) * this.stepSize;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float clamp(float paramFloat) {
/* 290 */     return MathUtils.clamp(paramFloat, this.min, this.max);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRange(float paramFloat1, float paramFloat2) {
/* 295 */     if (paramFloat1 > paramFloat2) throw new IllegalArgumentException("min must be <= max: " + paramFloat1 + " <= " + paramFloat2); 
/* 296 */     this.min = paramFloat1;
/* 297 */     this.max = paramFloat2;
/* 298 */     if (this.value < paramFloat1) {
/* 299 */       setValue(paramFloat1); return;
/* 300 */     }  if (this.value > paramFloat2)
/* 301 */       setValue(paramFloat2); 
/*     */   }
/*     */   
/*     */   public void setStepSize(float paramFloat) {
/* 305 */     if (paramFloat <= 0.0F) throw new IllegalArgumentException("steps must be > 0: " + paramFloat); 
/* 306 */     this.stepSize = paramFloat;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 310 */     if (this.vertical) {
/* 311 */       Drawable drawable1 = this.style.knob, drawable2 = getBackgroundDrawable();
/* 312 */       return Math.max((drawable1 == null) ? 0.0F : drawable1.getMinWidth(), (drawable2 == null) ? 0.0F : drawable2.getMinWidth());
/*     */     } 
/* 314 */     return 140.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 318 */     if (this.vertical) {
/* 319 */       return 140.0F;
/*     */     }
/* 321 */     Drawable drawable1 = this.style.knob, drawable2 = getBackgroundDrawable();
/* 322 */     return Math.max((drawable1 == null) ? 0.0F : drawable1.getMinHeight(), (drawable2 == null) ? 0.0F : drawable2.getMinHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMinValue() {
/* 327 */     return this.min;
/*     */   }
/*     */   
/*     */   public float getMaxValue() {
/* 331 */     return this.max;
/*     */   }
/*     */   
/*     */   public float getStepSize() {
/* 335 */     return this.stepSize;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimateDuration(float paramFloat) {
/* 340 */     this.animateDuration = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimateInterpolation(Interpolation paramInterpolation) {
/* 345 */     if (paramInterpolation == null) throw new IllegalArgumentException("animateInterpolation cannot be null."); 
/* 346 */     this.animateInterpolation = paramInterpolation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisualInterpolation(Interpolation paramInterpolation) {
/* 351 */     this.visualInterpolation = paramInterpolation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRound(boolean paramBoolean) {
/* 356 */     this.round = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 360 */     this.disabled = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isAnimating() {
/* 364 */     return (this.animateTime > 0.0F);
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 368 */     return this.disabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVertical() {
/* 373 */     return this.vertical;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/* 379 */     this.programmaticChangeEvents = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ProgressBarStyle
/*     */   {
/*     */     @Null
/*     */     public Drawable background;
/*     */     
/*     */     @Null
/*     */     public Drawable disabledBackground;
/*     */     @Null
/*     */     public Drawable knob;
/*     */     @Null
/*     */     public Drawable disabledKnob;
/*     */     
/*     */     public ProgressBarStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2) {
/* 396 */       this.background = param1Drawable1;
/* 397 */       this.knob = param1Drawable2; } @Null
/*     */     public Drawable knobBefore; @Null
/*     */     public Drawable disabledKnobBefore; @Null
/*     */     public Drawable knobAfter; @Null
/* 401 */     public Drawable disabledKnobAfter; public ProgressBarStyle() {} public ProgressBarStyle(ProgressBarStyle param1ProgressBarStyle) { this.background = param1ProgressBarStyle.background;
/* 402 */       this.disabledBackground = param1ProgressBarStyle.disabledBackground;
/*     */       
/* 404 */       this.knob = param1ProgressBarStyle.knob;
/* 405 */       this.disabledKnob = param1ProgressBarStyle.disabledKnob;
/*     */       
/* 407 */       this.knobBefore = param1ProgressBarStyle.knobBefore;
/* 408 */       this.disabledKnobBefore = param1ProgressBarStyle.disabledKnobBefore;
/*     */       
/* 410 */       this.knobAfter = param1ProgressBarStyle.knobAfter;
/* 411 */       this.disabledKnobAfter = param1ProgressBarStyle.disabledKnobAfter; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\ProgressBar.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */