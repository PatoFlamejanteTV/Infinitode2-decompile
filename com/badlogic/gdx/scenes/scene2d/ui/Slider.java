/*     */ package com.badlogic.gdx.scenes.scene2d.ui;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.scenes.scene2d.Actor;
/*     */ import com.badlogic.gdx.scenes.scene2d.Event;
/*     */ import com.badlogic.gdx.scenes.scene2d.EventListener;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputEvent;
/*     */ import com.badlogic.gdx.scenes.scene2d.InputListener;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Slider
/*     */   extends ProgressBar
/*     */ {
/*  42 */   int button = -1;
/*  43 */   int draggingPointer = -1;
/*     */   boolean mouseOver;
/*  45 */   private Interpolation visualInterpolationInverse = Interpolation.linear;
/*     */   private float[] snapValues;
/*     */   private float threshold;
/*     */   
/*     */   public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin) {
/*  50 */     this(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSkin.<SliderStyle>get("default-" + (paramBoolean ? "vertical" : "horizontal"), SliderStyle.class));
/*     */   }
/*     */   
/*     */   public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, Skin paramSkin, String paramString) {
/*  54 */     this(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSkin.<SliderStyle>get(paramString, SliderStyle.class));
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
/*     */   public Slider(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, SliderStyle paramSliderStyle) {
/*  67 */     super(paramFloat1, paramFloat2, paramFloat3, paramBoolean, paramSliderStyle);
/*     */     
/*  69 */     addListener((EventListener)new InputListener() {
/*     */           public boolean touchDown(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  71 */             if (Slider.this.disabled) return false; 
/*  72 */             if (Slider.this.button != -1 && Slider.this.button != param1Int2) return false; 
/*  73 */             if (Slider.this.draggingPointer != -1) return false; 
/*  74 */             Slider.this.draggingPointer = param1Int1;
/*  75 */             Slider.this.calculatePositionAndValue(param1Float1, param1Float2);
/*  76 */             return true;
/*     */           }
/*     */           
/*     */           public void touchUp(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int1, int param1Int2) {
/*  80 */             if (param1Int1 != Slider.this.draggingPointer)
/*  81 */               return;  Slider.this.draggingPointer = -1;
/*     */             
/*  83 */             if (param1InputEvent.isTouchFocusCancel() || !Slider.this.calculatePositionAndValue(param1Float1, param1Float2)) {
/*     */               
/*  85 */               ChangeListener.ChangeEvent changeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
/*  86 */               Slider.this.fire((Event)changeEvent);
/*  87 */               Pools.free(changeEvent);
/*     */             } 
/*     */           }
/*     */           
/*     */           public void touchDragged(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int) {
/*  92 */             Slider.this.calculatePositionAndValue(param1Float1, param1Float2);
/*     */           }
/*     */           
/*     */           public void enter(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/*  96 */             if (param1Int == -1) Slider.this.mouseOver = true; 
/*     */           }
/*     */           
/*     */           public void exit(InputEvent param1InputEvent, float param1Float1, float param1Float2, int param1Int, @Null Actor param1Actor) {
/* 100 */             if (param1Int == -1) Slider.this.mouseOver = false;
/*     */           
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public SliderStyle getStyle() {
/* 108 */     return (SliderStyle)super.getStyle();
/*     */   }
/*     */   
/*     */   public boolean isOver() {
/* 112 */     return this.mouseOver;
/*     */   }
/*     */   @Null
/*     */   protected Drawable getBackgroundDrawable() {
/* 116 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 117 */     if (this.disabled && sliderStyle.disabledBackground != null) return sliderStyle.disabledBackground; 
/* 118 */     if (isDragging() && sliderStyle.backgroundDown != null) return sliderStyle.backgroundDown; 
/* 119 */     if (this.mouseOver && sliderStyle.backgroundOver != null) return sliderStyle.backgroundOver; 
/* 120 */     return sliderStyle.background;
/*     */   }
/*     */   @Null
/*     */   protected Drawable getKnobDrawable() {
/* 124 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 125 */     if (this.disabled && sliderStyle.disabledKnob != null) return sliderStyle.disabledKnob; 
/* 126 */     if (isDragging() && sliderStyle.knobDown != null) return sliderStyle.knobDown; 
/* 127 */     if (this.mouseOver && sliderStyle.knobOver != null) return sliderStyle.knobOver; 
/* 128 */     return sliderStyle.knob;
/*     */   }
/*     */   
/*     */   protected Drawable getKnobBeforeDrawable() {
/* 132 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 133 */     if (this.disabled && sliderStyle.disabledKnobBefore != null) return sliderStyle.disabledKnobBefore; 
/* 134 */     if (isDragging() && sliderStyle.knobBeforeDown != null) return sliderStyle.knobBeforeDown; 
/* 135 */     if (this.mouseOver && sliderStyle.knobBeforeOver != null) return sliderStyle.knobBeforeOver; 
/* 136 */     return sliderStyle.knobBefore;
/*     */   }
/*     */   
/*     */   protected Drawable getKnobAfterDrawable() {
/* 140 */     SliderStyle sliderStyle = (SliderStyle)super.getStyle();
/* 141 */     if (this.disabled && sliderStyle.disabledKnobAfter != null) return sliderStyle.disabledKnobAfter; 
/* 142 */     if (isDragging() && sliderStyle.knobAfterDown != null) return sliderStyle.knobAfterDown; 
/* 143 */     if (this.mouseOver && sliderStyle.knobAfterOver != null) return sliderStyle.knobAfterOver; 
/* 144 */     return sliderStyle.knobAfter;
/*     */   }
/*     */   boolean calculatePositionAndValue(float paramFloat1, float paramFloat2) {
/*     */     float f1;
/*     */     SliderStyle sliderStyle;
/* 149 */     Drawable drawable1 = (sliderStyle = getStyle()).knob;
/* 150 */     Drawable drawable2 = getBackgroundDrawable();
/*     */ 
/*     */     
/* 153 */     float f2 = this.position;
/*     */     
/* 155 */     float f3 = getMinValue();
/* 156 */     float f4 = getMaxValue();
/*     */     
/* 158 */     if (this.vertical) {
/* 159 */       float f = getHeight() - drawable2.getTopHeight() - drawable2.getBottomHeight();
/* 160 */       f1 = (drawable1 == null) ? 0.0F : drawable1.getMinHeight();
/* 161 */       this.position = paramFloat2 - drawable2.getBottomHeight() - f1 * 0.5F;
/* 162 */       paramFloat1 = f3 + (f4 - f3) * this.visualInterpolationInverse.apply(this.position / (f - f1));
/* 163 */       this.position = Math.max(Math.min(0.0F, drawable2.getBottomHeight()), this.position);
/* 164 */       this.position = Math.min(f - f1, this.position);
/*     */     } else {
/* 166 */       float f = getWidth() - drawable2.getLeftWidth() - drawable2.getRightWidth();
/* 167 */       f1 = (f1 == null) ? 0.0F : f1.getMinWidth();
/* 168 */       this.position = paramFloat1 - drawable2.getLeftWidth() - f1 * 0.5F;
/* 169 */       paramFloat1 = f3 + (f4 - f3) * this.visualInterpolationInverse.apply(this.position / (f - f1));
/* 170 */       this.position = Math.max(Math.min(0.0F, drawable2.getLeftWidth()), this.position);
/* 171 */       this.position = Math.min(f - f1, this.position);
/*     */     } 
/*     */     
/* 174 */     float f5 = paramFloat1;
/* 175 */     if (!Gdx.input.isKeyPressed(59) && !Gdx.input.isKeyPressed(60)) paramFloat1 = snap(paramFloat1); 
/* 176 */     boolean bool = setValue(paramFloat1);
/* 177 */     if (paramFloat1 == f5) this.position = f2; 
/* 178 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected float snap(float paramFloat) {
/* 184 */     if (this.snapValues == null || this.snapValues.length == 0) return paramFloat; 
/* 185 */     float f1 = -1.0F, f2 = 0.0F;
/* 186 */     for (byte b = 0; b < this.snapValues.length; b++) {
/* 187 */       float f3 = this.snapValues[b];
/*     */       float f4;
/* 189 */       if ((f4 = Math.abs(paramFloat - f3)) <= this.threshold && (
/* 190 */         f1 == -1.0F || f4 < f1)) {
/* 191 */         f1 = f4;
/* 192 */         f2 = f3;
/*     */       } 
/*     */     } 
/*     */     
/* 196 */     return (f1 == -1.0F) ? paramFloat : f2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSnapToValues(float paramFloat, @Null float... paramVarArgs) {
/* 202 */     if (paramVarArgs != null && paramVarArgs.length == 0) throw new IllegalArgumentException("values cannot be empty."); 
/* 203 */     this.snapValues = paramVarArgs;
/* 204 */     this.threshold = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setSnapToValues(@Null float[] paramArrayOffloat, float paramFloat) {
/* 212 */     setSnapToValues(paramFloat, paramArrayOffloat);
/*     */   }
/*     */   @Null
/*     */   public float[] getSnapToValues() {
/* 216 */     return this.snapValues;
/*     */   }
/*     */   
/*     */   public float getSnapToValuesThreshold() {
/* 220 */     return this.threshold;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDragging() {
/* 225 */     return (this.draggingPointer != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setButton(int paramInt) {
/* 230 */     this.button = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisualInterpolationInverse(Interpolation paramInterpolation) {
/* 236 */     this.visualInterpolationInverse = paramInterpolation;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVisualPercent(float paramFloat) {
/* 242 */     setValue(this.min + (this.max - this.min) * this.visualInterpolationInverse.apply(paramFloat));
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
/* 258 */       super(param1Drawable1, param1Drawable2); } @Null
/*     */     public Drawable knobBeforeOver; @Null
/*     */     public Drawable knobBeforeDown; @Null
/*     */     public Drawable knobAfterOver; @Null
/* 262 */     public Drawable knobAfterDown; public SliderStyle() {} public SliderStyle(SliderStyle param1SliderStyle) { super(param1SliderStyle);
/* 263 */       this.backgroundOver = param1SliderStyle.backgroundOver;
/* 264 */       this.backgroundDown = param1SliderStyle.backgroundDown;
/*     */       
/* 266 */       this.knobOver = param1SliderStyle.knobOver;
/* 267 */       this.knobDown = param1SliderStyle.knobDown;
/*     */       
/* 269 */       this.knobBeforeOver = param1SliderStyle.knobBeforeOver;
/* 270 */       this.knobBeforeDown = param1SliderStyle.knobBeforeDown;
/*     */       
/* 272 */       this.knobAfterOver = param1SliderStyle.knobAfterOver;
/* 273 */       this.knobAfterDown = param1SliderStyle.knobAfterDown; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\ui\Slider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */