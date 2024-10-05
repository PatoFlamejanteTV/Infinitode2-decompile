/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.Event;
/*     */ import com.prineside.tdi2.scene2d.Stage;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
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
/*     */ public class ProgressBar
/*     */   extends Widget
/*     */   implements Disableable
/*     */ {
/*     */   private ProgressBarStyle o;
/*     */   float j;
/*     */   float k;
/*     */   private float p;
/*     */   private float q;
/*     */   private float r;
/*     */   float l;
/*     */   final boolean m;
/*     */   private float s;
/*     */   private float t;
/*  51 */   private Interpolation u = Interpolation.linear; private Interpolation v = Interpolation.linear;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean n;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean w = true, x = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProgressBar(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, ProgressBarStyle paramProgressBarStyle) {
/*  66 */     if (paramFloat1 > paramFloat2) throw new IllegalArgumentException("max must be > min. min,max: " + paramFloat1 + ", " + paramFloat2); 
/*  67 */     if (paramFloat3 <= 0.0F) throw new IllegalArgumentException("stepSize must be > 0: " + paramFloat3); 
/*  68 */     setStyle(paramProgressBarStyle);
/*  69 */     this.j = paramFloat1;
/*  70 */     this.k = paramFloat2;
/*  71 */     this.p = paramFloat3;
/*  72 */     this.m = paramBoolean;
/*  73 */     this.q = paramFloat1;
/*  74 */     setSize(getPrefWidth(), getPrefHeight());
/*     */   }
/*     */   
/*     */   public void setStyle(ProgressBarStyle paramProgressBarStyle) {
/*  78 */     if (paramProgressBarStyle == null) throw new IllegalArgumentException("style cannot be null."); 
/*  79 */     this.o = paramProgressBarStyle;
/*  80 */     invalidateHierarchy();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ProgressBarStyle getStyle() {
/*  86 */     return this.o;
/*     */   }
/*     */   
/*     */   public void act(float paramFloat) {
/*  90 */     super.act(paramFloat);
/*     */     
/*  92 */     this.t -= paramFloat;
/*     */     Stage stage;
/*  94 */     if (this.t > 0.0F && (stage = getStage()) != null && stage.getActionsRequestRendering()) Gdx.graphics.requestRendering();
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {
/*     */     ProgressBarStyle progressBarStyle;
/* 101 */     Drawable drawable1 = (progressBarStyle = this.o).knob, drawable2 = c();
/* 102 */     Drawable drawable3 = b();
/* 103 */     Drawable drawable4 = d();
/* 104 */     Drawable drawable5 = e();
/*     */     
/* 106 */     Color color = getColor();
/* 107 */     float f3 = getX(), f4 = getY();
/* 108 */     float f5 = getWidth(), f6 = getHeight();
/* 109 */     float f7 = (drawable1 == null) ? 0.0F : drawable1.getMinHeight();
/* 110 */     float f1 = (drawable1 == null) ? 0.0F : drawable1.getMinWidth();
/* 111 */     float f8 = getVisualPercent();
/*     */     
/* 113 */     paramBatch.setColor(color.r, color.g, color.b, color.a * paramFloat);
/*     */     
/* 115 */     if (this.m) {
/* 116 */       float f10 = 0.0F;
/* 117 */       if (drawable3 != null) {
/* 118 */         a(paramBatch, drawable3, f3 + (f5 - drawable3.getMinWidth()) * 0.5F, f4, drawable3.getMinWidth(), f6);
/* 119 */         paramFloat = drawable3.getTopHeight();
/* 120 */         f10 = drawable3.getBottomHeight();
/* 121 */         f6 -= paramFloat + f10;
/*     */       } 
/*     */ 
/*     */       
/* 125 */       f8 = MathUtils.clamp((f2 = f6 - f7) * f8, 0.0F, f2);
/* 126 */       this.l = f10 + f8;
/*     */       
/* 128 */       float f11 = f7 * 0.5F;
/* 129 */       if (drawable4 != null) {
/* 130 */         a(paramBatch, drawable4, f3 + (f5 - drawable4
/* 131 */             .getMinWidth()) * 0.5F, f4 + f10, drawable4
/*     */             
/* 133 */             .getMinWidth(), f8 + f11);
/*     */       }
/* 135 */       if (drawable5 != null) {
/* 136 */         a(paramBatch, drawable5, f3 + (f5 - drawable5
/* 137 */             .getMinWidth()) * 0.5F, f4 + this.l + f11, drawable5
/*     */             
/* 139 */             .getMinWidth(), f2 - (
/* 140 */             this.w ? (float)Math.ceil((f8 - f11)) : (f8 - f11)));
/*     */       }
/* 142 */       if (drawable2 != null) {
/* 143 */         paramFloat = drawable2.getMinWidth(); f2 = drawable2.getMinHeight();
/* 144 */         a(paramBatch, drawable2, f3 + (f5 - paramFloat) * 0.5F, f4 + this.l + (f7 - f2) * 0.5F, paramFloat, f2);
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 150 */     paramFloat = 0.0F;
/* 151 */     if (f2 != null) {
/* 152 */       a(paramBatch, f2, f3, Math.round(f4 + (f6 - f2.getMinHeight()) * 0.5F), f5, Math.round(f2.getMinHeight()));
/* 153 */       paramFloat = f2.getLeftWidth();
/* 154 */       float f = f2.getRightWidth();
/* 155 */       f5 -= paramFloat + f;
/*     */     } 
/*     */     
/*     */     float f2;
/* 159 */     f8 = MathUtils.clamp((f2 = f5 - f1) * f8, 0.0F, f2);
/* 160 */     this.l = paramFloat + f8;
/*     */     
/* 162 */     float f9 = f1 * 0.5F;
/* 163 */     if (drawable4 != null) {
/* 164 */       a(paramBatch, drawable4, f3 + paramFloat, f4 + (f6 - drawable4
/*     */           
/* 166 */           .getMinHeight()) * 0.5F, f8 + f9, drawable4
/* 167 */           .getMinHeight());
/*     */     }
/* 169 */     if (drawable5 != null) {
/* 170 */       a(paramBatch, drawable5, f3 + this.l + f9, f4 + (f6 - drawable5
/*     */           
/* 172 */           .getMinHeight()) * 0.5F, f2 - (
/* 173 */           this.w ? (float)Math.ceil((f8 - f9)) : (f8 - f9)), drawable5
/* 174 */           .getMinHeight());
/*     */     }
/* 176 */     if (drawable2 != null) {
/* 177 */       paramFloat = drawable2.getMinWidth(); f2 = drawable2.getMinHeight();
/* 178 */       a(paramBatch, drawable2, f3 + this.l + (f1 - paramFloat) * 0.5F, f4 + (f6 - f2) * 0.5F, paramFloat, f2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Batch paramBatch, Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 187 */     if (this.w) {
/* 188 */       paramFloat1 = (float)Math.floor(paramFloat1);
/* 189 */       paramFloat2 = (float)Math.floor(paramFloat2);
/* 190 */       paramFloat3 = (float)Math.ceil(paramFloat3);
/* 191 */       paramFloat4 = (float)Math.ceil(paramFloat4);
/*     */     } 
/* 193 */     paramDrawable.draw(paramBatch, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public float getValue() {
/* 197 */     return this.q;
/*     */   }
/*     */ 
/*     */   
/*     */   public float getVisualValue() {
/* 202 */     if (this.t > 0.0F) return this.u.apply(this.r, this.q, 1.0F - this.t / this.s); 
/* 203 */     return this.q;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateVisualValue() {
/* 208 */     this.t = 0.0F;
/*     */   }
/*     */   
/*     */   public float getPercent() {
/* 212 */     if (this.j == this.k) return 0.0F; 
/* 213 */     return (this.q - this.j) / (this.k - this.j);
/*     */   }
/*     */   
/*     */   public float getVisualPercent() {
/* 217 */     if (this.j == this.k) return 0.0F; 
/* 218 */     return this.v.apply((getVisualValue() - this.j) / (this.k - this.j));
/*     */   }
/*     */   @Null
/*     */   protected Drawable b() {
/* 222 */     if (this.n && this.o.disabledBackground != null) return this.o.disabledBackground; 
/* 223 */     return this.o.background;
/*     */   }
/*     */   @Null
/*     */   protected Drawable c() {
/* 227 */     if (this.n && this.o.disabledKnob != null) return this.o.disabledKnob; 
/* 228 */     return this.o.knob;
/*     */   }
/*     */   
/*     */   protected Drawable d() {
/* 232 */     if (this.n && this.o.disabledKnobBefore != null) return this.o.disabledKnobBefore; 
/* 233 */     return this.o.knobBefore;
/*     */   }
/*     */   
/*     */   protected Drawable e() {
/* 237 */     if (this.n && this.o.disabledKnobAfter != null) return this.o.disabledKnobAfter; 
/* 238 */     return this.o.knobAfter;
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
/*     */   public boolean setValue(float paramFloat) {
/* 251 */     paramFloat = b(a(paramFloat));
/* 252 */     float f1 = this.q;
/* 253 */     if (paramFloat == f1) return false; 
/* 254 */     float f2 = getVisualValue();
/* 255 */     this.q = paramFloat;
/*     */     
/* 257 */     if (this.x) {
/* 258 */       ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/* 259 */       boolean bool = fire((Event)changeEvent);
/* 260 */       Pools.free(changeEvent);
/* 261 */       if (bool) {
/* 262 */         this.q = f1;
/* 263 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 267 */     if (this.s > 0.0F) {
/* 268 */       this.r = f2;
/* 269 */       this.t = this.s;
/*     */     } 
/* 271 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private float a(float paramFloat) {
/* 276 */     return Math.round(paramFloat / this.p) * this.p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float b(float paramFloat) {
/* 282 */     return MathUtils.clamp(paramFloat, this.j, this.k);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRange(float paramFloat1, float paramFloat2) {
/* 287 */     if (paramFloat1 > paramFloat2) throw new IllegalArgumentException("min must be <= max: " + paramFloat1 + " <= " + paramFloat2); 
/* 288 */     this.j = paramFloat1;
/* 289 */     this.k = paramFloat2;
/* 290 */     if (this.q < paramFloat1) {
/* 291 */       setValue(paramFloat1); return;
/* 292 */     }  if (this.q > paramFloat2)
/* 293 */       setValue(paramFloat2); 
/*     */   }
/*     */   
/*     */   public void setStepSize(float paramFloat) {
/* 297 */     if (paramFloat <= 0.0F) throw new IllegalArgumentException("steps must be > 0: " + paramFloat); 
/* 298 */     this.p = paramFloat;
/*     */   }
/*     */   
/*     */   public float getPrefWidth() {
/* 302 */     if (this.m) {
/* 303 */       Drawable drawable1 = this.o.knob, drawable2 = b();
/* 304 */       return Math.max((drawable1 == null) ? 0.0F : drawable1.getMinWidth(), (drawable2 == null) ? 0.0F : drawable2.getMinWidth());
/*     */     } 
/* 306 */     return 140.0F;
/*     */   }
/*     */   
/*     */   public float getPrefHeight() {
/* 310 */     if (this.m) {
/* 311 */       return 140.0F;
/*     */     }
/* 313 */     Drawable drawable1 = this.o.knob, drawable2 = b();
/* 314 */     return Math.max((drawable1 == null) ? 0.0F : drawable1.getMinHeight(), (drawable2 == null) ? 0.0F : drawable2.getMinHeight());
/*     */   }
/*     */ 
/*     */   
/*     */   public float getMinValue() {
/* 319 */     return this.j;
/*     */   }
/*     */   
/*     */   public float getMaxValue() {
/* 323 */     return this.k;
/*     */   }
/*     */   
/*     */   public float getStepSize() {
/* 327 */     return this.p;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimateDuration(float paramFloat) {
/* 332 */     this.s = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setAnimateInterpolation(Interpolation paramInterpolation) {
/* 337 */     if (paramInterpolation == null) throw new IllegalArgumentException("animateInterpolation cannot be null."); 
/* 338 */     this.u = paramInterpolation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVisualInterpolation(Interpolation paramInterpolation) {
/* 343 */     this.v = paramInterpolation;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setRound(boolean paramBoolean) {
/* 348 */     this.w = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setDisabled(boolean paramBoolean) {
/* 352 */     this.n = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isAnimating() {
/* 356 */     return (this.t > 0.0F);
/*     */   }
/*     */   
/*     */   public boolean isDisabled() {
/* 360 */     return this.n;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isVertical() {
/* 365 */     return this.m;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProgrammaticChangeEvents(boolean paramBoolean) {
/* 371 */     this.x = paramBoolean;
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
/* 388 */       this.background = param1Drawable1;
/* 389 */       this.knob = param1Drawable2; } @Null
/*     */     public Drawable knobBefore; @Null
/*     */     public Drawable disabledKnobBefore; @Null
/*     */     public Drawable knobAfter; @Null
/* 393 */     public Drawable disabledKnobAfter; public ProgressBarStyle() {} public ProgressBarStyle(ProgressBarStyle param1ProgressBarStyle) { this.background = param1ProgressBarStyle.background;
/* 394 */       this.disabledBackground = param1ProgressBarStyle.disabledBackground;
/*     */       
/* 396 */       this.knob = param1ProgressBarStyle.knob;
/* 397 */       this.disabledKnob = param1ProgressBarStyle.disabledKnob;
/*     */       
/* 399 */       this.knobBefore = param1ProgressBarStyle.knobBefore;
/* 400 */       this.disabledKnobBefore = param1ProgressBarStyle.disabledKnobBefore;
/*     */       
/* 402 */       this.knobAfter = param1ProgressBarStyle.knobAfter;
/* 403 */       this.disabledKnobAfter = param1ProgressBarStyle.disabledKnobAfter; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\ProgressBar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */