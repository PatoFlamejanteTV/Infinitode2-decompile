/*     */ package com.prineside.tdi2.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.Pools;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.Event;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.InputEvent;
/*     */ import com.prineside.tdi2.scene2d.InputListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Slider
/*     */   extends ProgressBar
/*     */ {
/*  42 */   int o = -1;
/*  43 */   int p = -1;
/*     */   boolean q;
/*  45 */   private Interpolation r = Interpolation.linear;
/*     */ 
/*     */ 
/*     */   
/*     */   private float[] s;
/*     */ 
/*     */ 
/*     */   
/*     */   private float t;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, SliderStyle paramSliderStyle) {
/*  59 */     super(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSliderStyle);
/*     */     
/*  61 */     addListener((EventListener)new InputListener(this) {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  63 */             if (this.a.n) return false; 
/*  64 */             if (this.a.o != -1 && this.a.o != param1Int2) return false; 
/*  65 */             if (this.a.p != -1) return false; 
/*  66 */             this.a.p = param1Int1;
/*  67 */             this.a.a(param1Float1, param1Float2);
/*  68 */             return true;
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  72 */             if (param1Int1 != this.a.p)
/*  73 */               return;  this.a.p = -1;
/*     */             
/*  75 */             if (param1InputEvent.isTouchFocusCancel() || !this.a.a(param1Float1, param1Float2)) {
/*     */               
/*  77 */               ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/*  78 */               this.a.fire((Event)changeEvent);
/*  79 */               Pools.free(changeEvent);
/*     */             } 
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  84 */             this.a.a(param1Float1, param1Float2);
/*     */           }
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  88 */             if (param1Int == -1) this.a.q = true; 
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  92 */             if (param1Int == -1) this.a.q = false;
/*     */           
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public SliderStyle getStyle() {
/* 100 */     return (SliderStyle)super.getStyle();
/*     */   }
/*     */   
/*     */   public boolean isOver() {
/* 104 */     return this.q;
/*     */   }
/*     */   @Null
/*     */   protected final Drawable b() {
/* 108 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 109 */     if (this.n && sliderStyle.disabledBackground != null) return sliderStyle.disabledBackground; 
/* 110 */     if (isDragging() && sliderStyle.backgroundDown != null) return sliderStyle.backgroundDown; 
/* 111 */     if (this.q && sliderStyle.backgroundOver != null) return sliderStyle.backgroundOver; 
/* 112 */     return sliderStyle.background;
/*     */   }
/*     */   @Null
/*     */   protected final Drawable c() {
/* 116 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 117 */     if (this.n && sliderStyle.disabledKnob != null) return sliderStyle.disabledKnob; 
/* 118 */     if (isDragging() && sliderStyle.knobDown != null) return sliderStyle.knobDown; 
/* 119 */     if (this.q && sliderStyle.knobOver != null) return sliderStyle.knobOver; 
/* 120 */     return sliderStyle.knob;
/*     */   }
/*     */   
/*     */   protected final Drawable d() {
/* 124 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 125 */     if (this.n && sliderStyle.disabledKnobBefore != null) return sliderStyle.disabledKnobBefore; 
/* 126 */     if (isDragging() && sliderStyle.knobBeforeDown != null) return sliderStyle.knobBeforeDown; 
/* 127 */     if (this.q && sliderStyle.knobBeforeOver != null) return sliderStyle.knobBeforeOver; 
/* 128 */     return sliderStyle.knobBefore;
/*     */   }
/*     */   
/*     */   protected final Drawable e() {
/* 132 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 133 */     if (this.n && sliderStyle.disabledKnobAfter != null) return sliderStyle.disabledKnobAfter; 
/* 134 */     if (isDragging() && sliderStyle.knobAfterDown != null) return sliderStyle.knobAfterDown; 
/* 135 */     if (this.q && sliderStyle.knobAfterOver != null) return sliderStyle.knobAfterOver; 
/* 136 */     return sliderStyle.knobAfter;
/*     */   }
/*     */   final boolean a(float paramFloat1, float paramFloat2) {
/*     */     float f1;
/*     */     SliderStyle sliderStyle;
/* 141 */     Drawable drawable1 = (sliderStyle = getStyle()).knob;
/* 142 */     Drawable drawable2 = b();
/*     */ 
/*     */     
/* 145 */     float f2 = this.l;
/*     */     
/* 147 */     float f3 = getMinValue();
/* 148 */     float f4 = getMaxValue();
/*     */     
/* 150 */     if (this.m) {
/* 151 */       float f = getHeight() - drawable2.getTopHeight() - drawable2.getBottomHeight();
/* 152 */       f1 = (drawable1 == null) ? 0.0F : drawable1.getMinHeight();
/* 153 */       this.l = paramFloat2 - drawable2.getBottomHeight() - f1 * 0.5F;
/* 154 */       paramFloat1 = f3 + (f4 - f3) * this.r.apply(this.l / (f - f1));
/* 155 */       this.l = Math.max(Math.min(0.0F, drawable2.getBottomHeight()), this.l);
/* 156 */       this.l = Math.min(f - f1, this.l);
/*     */     } else {
/* 158 */       float f = getWidth() - drawable2.getLeftWidth() - drawable2.getRightWidth();
/* 159 */       f1 = (f1 == null) ? 0.0F : f1.getMinWidth();
/* 160 */       this.l = paramFloat1 - drawable2.getLeftWidth() - f1 * 0.5F;
/* 161 */       paramFloat1 = f3 + (f4 - f3) * this.r.apply(this.l / (f - f1));
/* 162 */       this.l = Math.max(Math.min(0.0F, drawable2.getLeftWidth()), this.l);
/* 163 */       this.l = Math.min(f - f1, this.l);
/*     */     } 
/*     */     
/* 166 */     float f5 = paramFloat1;
/* 167 */     if (!Gdx.input.isKeyPressed(59) && !Gdx.input.isKeyPressed(60)) paramFloat1 = a(paramFloat1); 
/* 168 */     boolean bool = setValue(paramFloat1);
/* 169 */     if (paramFloat1 == f5) this.l = f2; 
/* 170 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private float a(float paramFloat) {
/* 176 */     if (this.s == null || this.s.length == 0) return paramFloat; 
/* 177 */     float f1 = -1.0F, f2 = 0.0F;
/* 178 */     for (byte b = 0; b < this.s.length; b++) {
/* 179 */       float f3 = this.s[b];
/*     */       float f4;
/* 181 */       if ((f4 = Math.abs(paramFloat - f3)) <= this.t && (
/* 182 */         f1 == -1.0F || f4 < f1)) {
/* 183 */         f1 = f4;
/* 184 */         f2 = f3;
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     return (f1 == -1.0F) ? paramFloat : f2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSnapToValues(float paramFloat, @Null float... paramVarArgs) {
/* 194 */     if (paramVarArgs != null && paramVarArgs.length == 0) throw new IllegalArgumentException("values cannot be empty."); 
/* 195 */     this.s = paramVarArgs;
/* 196 */     this.t = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setSnapToValues(@Null float[] paramArrayOffloat, float paramFloat) {
/* 204 */     setSnapToValues(paramFloat, paramArrayOffloat);
/*     */   }
/*     */   @Null
/*     */   public float[] getSnapToValues() {
/* 208 */     return this.s;
/*     */   }
/*     */   
/*     */   public float getSnapToValuesThreshold() {
/* 212 */     return this.t;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDragging() {
/* 217 */     return (this.p != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 222 */     this.o = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisualInterpolationInverse(Interpolation paramInterpolation) {
/* 228 */     this.r = paramInterpolation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisualPercent(float paramFloat) {
/* 234 */     setValue(this.j + (this.k - this.j) * this.r.apply(paramFloat));
/*     */   }
/*     */   
/*     */   public static class SliderStyle
/*     */     extends ProgressBar.ProgressBarStyle
/*     */   {
/*     */     @Null
/*     */     public Drawable backgroundOver;
/*     */     @Null
/*     */     public Drawable backgroundDown;
/*     */     @Null
/*     */     public Drawable knobOver;
/*     */     @Null
/*     */     public Drawable knobDown;
/*     */     
/*     */     public SliderStyle(@Null Drawable param1Drawable1, @Null Drawable param1Drawable2) {
/* 250 */       super(param1Drawable1, param1Drawable2); } @Null
/*     */     public Drawable knobBeforeOver; @Null
/*     */     public Drawable knobBeforeDown; @Null
/*     */     public Drawable knobAfterOver; @Null
/* 254 */     public Drawable knobAfterDown; public SliderStyle() {} public SliderStyle(SliderStyle param1SliderStyle) { super(param1SliderStyle);
/* 255 */       this.backgroundOver = param1SliderStyle.backgroundOver;
/* 256 */       this.backgroundDown = param1SliderStyle.backgroundDown;
/*     */       
/* 258 */       this.knobOver = param1SliderStyle.knobOver;
/* 259 */       this.knobDown = param1SliderStyle.knobDown;
/*     */       
/* 261 */       this.knobBeforeOver = param1SliderStyle.knobBeforeOver;
/* 262 */       this.knobBeforeDown = param1SliderStyle.knobBeforeDown;
/*     */       
/* 264 */       this.knobAfterOver = param1SliderStyle.knobAfterOver;
/* 265 */       this.knobAfterDown = param1SliderStyle.knobAfterDown; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\ui\Slider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */