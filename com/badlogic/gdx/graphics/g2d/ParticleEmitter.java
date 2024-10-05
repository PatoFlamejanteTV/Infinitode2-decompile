/*      */ package com.badlogic.gdx.graphics.g2d;
/*      */ 
/*      */ import com.badlogic.gdx.Gdx;
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.Rectangle;
/*      */ import com.badlogic.gdx.math.collision.BoundingBox;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.IOException;
/*      */ import java.io.Writer;
/*      */ import java.util.Arrays;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ParticleEmitter
/*      */ {
/*      */   private static final int UPDATE_SCALE = 1;
/*      */   private static final int UPDATE_ANGLE = 2;
/*      */   private static final int UPDATE_ROTATION = 4;
/*      */   private static final int UPDATE_VELOCITY = 8;
/*      */   private static final int UPDATE_WIND = 16;
/*      */   private static final int UPDATE_GRAVITY = 32;
/*      */   private static final int UPDATE_TINT = 64;
/*      */   private static final int UPDATE_SPRITE = 128;
/*   41 */   private RangedNumericValue delayValue = new RangedNumericValue();
/*   42 */   private IndependentScaledNumericValue lifeOffsetValue = new IndependentScaledNumericValue();
/*   43 */   private RangedNumericValue durationValue = new RangedNumericValue();
/*   44 */   private IndependentScaledNumericValue lifeValue = new IndependentScaledNumericValue();
/*   45 */   private ScaledNumericValue emissionValue = new ScaledNumericValue();
/*   46 */   private ScaledNumericValue xScaleValue = new ScaledNumericValue();
/*   47 */   private ScaledNumericValue yScaleValue = new ScaledNumericValue();
/*   48 */   private ScaledNumericValue rotationValue = new ScaledNumericValue();
/*   49 */   private ScaledNumericValue velocityValue = new ScaledNumericValue();
/*   50 */   private ScaledNumericValue angleValue = new ScaledNumericValue();
/*   51 */   private ScaledNumericValue windValue = new ScaledNumericValue();
/*   52 */   private ScaledNumericValue gravityValue = new ScaledNumericValue();
/*   53 */   private ScaledNumericValue transparencyValue = new ScaledNumericValue();
/*   54 */   private GradientColorValue tintValue = new GradientColorValue();
/*   55 */   private RangedNumericValue xOffsetValue = new ScaledNumericValue();
/*   56 */   private RangedNumericValue yOffsetValue = new ScaledNumericValue();
/*   57 */   private ScaledNumericValue spawnWidthValue = new ScaledNumericValue();
/*   58 */   private ScaledNumericValue spawnHeightValue = new ScaledNumericValue();
/*   59 */   private SpawnShapeValue spawnShapeValue = new SpawnShapeValue();
/*      */   
/*      */   private RangedNumericValue[] xSizeValues;
/*      */   
/*      */   private RangedNumericValue[] ySizeValues;
/*      */   private RangedNumericValue[] motionValues;
/*      */   private float accumulator;
/*      */   private Array<Sprite> sprites;
/*   67 */   private SpriteMode spriteMode = SpriteMode.single; private Particle[] particles;
/*      */   private int minParticleCount;
/*   69 */   private int maxParticleCount = 4; private float x; private float y; private String name; private Array<String> imagePaths; private int activeCount; private boolean[] active; private boolean firstUpdate;
/*      */   private boolean flipX;
/*      */   private boolean flipY;
/*      */   private int updateFlags;
/*      */   private boolean allowCompletion;
/*      */   private BoundingBox bounds;
/*      */   private int emission;
/*      */   private int emissionDiff;
/*      */   private int emissionDelta;
/*      */   private int lifeOffset;
/*      */   private int lifeOffsetDiff;
/*      */   private int life;
/*      */   private int lifeDiff;
/*      */   private float spawnWidth;
/*      */   private float spawnWidthDiff;
/*      */   private float spawnHeight;
/*      */   private float spawnHeightDiff;
/*   86 */   public float duration = 1.0F; public float durationTimer;
/*      */   private float delay;
/*      */   private float delayTimer;
/*      */   private boolean attached;
/*      */   private boolean continuous;
/*      */   private boolean aligned;
/*      */   private boolean behind;
/*      */   private boolean additive = true;
/*      */   private boolean premultipliedAlpha = false;
/*      */   boolean cleansUpBlendFunction = true;
/*      */   
/*      */   public ParticleEmitter() {
/*   98 */     initialize();
/*      */   }
/*      */   
/*      */   public ParticleEmitter(BufferedReader paramBufferedReader) {
/*  102 */     initialize();
/*  103 */     load(paramBufferedReader);
/*      */   }
/*      */   
/*      */   public ParticleEmitter(ParticleEmitter paramParticleEmitter) {
/*  107 */     this.sprites = new Array(paramParticleEmitter.sprites);
/*  108 */     this.name = paramParticleEmitter.name;
/*  109 */     this.imagePaths = new Array(paramParticleEmitter.imagePaths);
/*  110 */     setMaxParticleCount(paramParticleEmitter.maxParticleCount);
/*  111 */     this.minParticleCount = paramParticleEmitter.minParticleCount;
/*  112 */     this.delayValue.load(paramParticleEmitter.delayValue);
/*  113 */     this.durationValue.load(paramParticleEmitter.durationValue);
/*  114 */     this.emissionValue.load(paramParticleEmitter.emissionValue);
/*  115 */     this.lifeValue.load(paramParticleEmitter.lifeValue);
/*  116 */     this.lifeOffsetValue.load(paramParticleEmitter.lifeOffsetValue);
/*  117 */     this.xScaleValue.load(paramParticleEmitter.xScaleValue);
/*  118 */     this.yScaleValue.load(paramParticleEmitter.yScaleValue);
/*  119 */     this.rotationValue.load(paramParticleEmitter.rotationValue);
/*  120 */     this.velocityValue.load(paramParticleEmitter.velocityValue);
/*  121 */     this.angleValue.load(paramParticleEmitter.angleValue);
/*  122 */     this.windValue.load(paramParticleEmitter.windValue);
/*  123 */     this.gravityValue.load(paramParticleEmitter.gravityValue);
/*  124 */     this.transparencyValue.load(paramParticleEmitter.transparencyValue);
/*  125 */     this.tintValue.load(paramParticleEmitter.tintValue);
/*  126 */     this.xOffsetValue.load(paramParticleEmitter.xOffsetValue);
/*  127 */     this.yOffsetValue.load(paramParticleEmitter.yOffsetValue);
/*  128 */     this.spawnWidthValue.load(paramParticleEmitter.spawnWidthValue);
/*  129 */     this.spawnHeightValue.load(paramParticleEmitter.spawnHeightValue);
/*  130 */     this.spawnShapeValue.load(paramParticleEmitter.spawnShapeValue);
/*  131 */     this.attached = paramParticleEmitter.attached;
/*  132 */     this.continuous = paramParticleEmitter.continuous;
/*  133 */     this.aligned = paramParticleEmitter.aligned;
/*  134 */     this.behind = paramParticleEmitter.behind;
/*  135 */     this.additive = paramParticleEmitter.additive;
/*  136 */     this.premultipliedAlpha = paramParticleEmitter.premultipliedAlpha;
/*  137 */     this.cleansUpBlendFunction = paramParticleEmitter.cleansUpBlendFunction;
/*  138 */     this.spriteMode = paramParticleEmitter.spriteMode;
/*  139 */     setPosition(paramParticleEmitter.getX(), paramParticleEmitter.getY());
/*      */   }
/*      */   
/*      */   private void initialize() {
/*  143 */     this.sprites = new Array();
/*  144 */     this.imagePaths = new Array();
/*  145 */     this.durationValue.setAlwaysActive(true);
/*  146 */     this.emissionValue.setAlwaysActive(true);
/*  147 */     this.lifeValue.setAlwaysActive(true);
/*  148 */     this.xScaleValue.setAlwaysActive(true);
/*  149 */     this.transparencyValue.setAlwaysActive(true);
/*  150 */     this.spawnShapeValue.setAlwaysActive(true);
/*  151 */     this.spawnWidthValue.setAlwaysActive(true);
/*  152 */     this.spawnHeightValue.setAlwaysActive(true);
/*      */   }
/*      */   
/*      */   public void setMaxParticleCount(int paramInt) {
/*  156 */     this.maxParticleCount = paramInt;
/*  157 */     this.active = new boolean[paramInt];
/*  158 */     this.activeCount = 0;
/*  159 */     this.particles = new Particle[paramInt];
/*      */   }
/*      */   
/*      */   public void addParticle() {
/*      */     int i;
/*  164 */     if ((i = this.activeCount) == this.maxParticleCount)
/*  165 */       return;  boolean[] arrayOfBoolean = this.active; byte b; int j;
/*  166 */     for (b = 0, j = arrayOfBoolean.length; b < j; b++) {
/*  167 */       if (!arrayOfBoolean[b]) {
/*  168 */         activateParticle(b);
/*  169 */         arrayOfBoolean[b] = true;
/*  170 */         this.activeCount = i + 1;
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void addParticles(int paramInt) {
/*  178 */     if ((paramInt = Math.min(paramInt, this.maxParticleCount - this.activeCount)) == 0)
/*  179 */       return;  boolean[] arrayOfBoolean = this.active;
/*  180 */     byte b1 = 0; int i = arrayOfBoolean.length;
/*      */     
/*  182 */     for (byte b2 = 0; b2 < paramInt;) {
/*  183 */       for (; b1 < i; b2++) {
/*  184 */         if (!arrayOfBoolean[b1]) {
/*  185 */           activateParticle(b1);
/*  186 */           arrayOfBoolean[b1++] = true;
/*      */         } else {
/*      */           b1++; continue;
/*      */         } 
/*      */       } 
/*      */     } 
/*  192 */     this.activeCount += paramInt;
/*      */   }
/*      */   
/*      */   public void update(float paramFloat) {
/*  196 */     this.accumulator += paramFloat * 1000.0F;
/*  197 */     if (this.accumulator < 1.0F)
/*  198 */       return;  int i = (int)this.accumulator;
/*  199 */     this.accumulator -= i;
/*      */     
/*  201 */     if (this.delayTimer < this.delay) {
/*  202 */       this.delayTimer += i;
/*      */     } else {
/*  204 */       boolean bool = false;
/*  205 */       if (this.firstUpdate) {
/*  206 */         this.firstUpdate = false;
/*  207 */         addParticle();
/*      */       } 
/*      */       
/*  210 */       if (this.durationTimer < this.duration) {
/*  211 */         this.durationTimer += i;
/*      */       }
/*  213 */       else if (!this.continuous || this.allowCompletion) {
/*  214 */         bool = true;
/*      */       } else {
/*  216 */         restart();
/*      */       } 
/*      */       
/*  219 */       if (!bool) {
/*  220 */         this.emissionDelta += i;
/*      */         float f;
/*  222 */         if ((f = this.emission + this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration)) > 0.0F) {
/*  223 */           f = 1000.0F / f;
/*  224 */           if (this.emissionDelta >= f) {
/*      */             
/*  226 */             int m = Math.min(m = (int)(this.emissionDelta / f), this.maxParticleCount - this.activeCount);
/*  227 */             this.emissionDelta = (int)(this.emissionDelta - m * f);
/*  228 */             this.emissionDelta = (int)(this.emissionDelta % f);
/*  229 */             addParticles(m);
/*      */           } 
/*      */         } 
/*  232 */         if (this.activeCount < this.minParticleCount) addParticles(this.minParticleCount - this.activeCount);
/*      */       
/*      */       } 
/*      */     } 
/*  236 */     boolean[] arrayOfBoolean = this.active;
/*  237 */     int j = this.activeCount;
/*  238 */     Particle[] arrayOfParticle = this.particles; byte b; int k;
/*  239 */     for (b = 0, k = arrayOfBoolean.length; b < k; b++) {
/*  240 */       if (arrayOfBoolean[b] && !updateParticle(arrayOfParticle[b], paramFloat, i)) {
/*  241 */         arrayOfBoolean[b] = false;
/*  242 */         j--;
/*      */       } 
/*      */     } 
/*  245 */     this.activeCount = j;
/*      */   }
/*      */   
/*      */   public void draw(Batch paramBatch) {
/*  249 */     if (this.premultipliedAlpha) {
/*  250 */       paramBatch.setBlendFunction(1, 771);
/*  251 */     } else if (this.additive) {
/*  252 */       paramBatch.setBlendFunction(770, 1);
/*      */     } else {
/*  254 */       paramBatch.setBlendFunction(770, 771);
/*      */     } 
/*  256 */     Particle[] arrayOfParticle = this.particles;
/*  257 */     boolean[] arrayOfBoolean = this.active; byte b;
/*      */     int i;
/*  259 */     for (b = 0, i = arrayOfBoolean.length; b < i; b++) {
/*  260 */       if (arrayOfBoolean[b]) arrayOfParticle[b].draw(paramBatch);
/*      */     
/*      */     } 
/*  263 */     if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
/*  264 */       paramBatch.setBlendFunction(770, 771);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void draw(Batch paramBatch, float paramFloat) {
/*  270 */     this.accumulator += paramFloat * 1000.0F;
/*  271 */     if (this.accumulator < 1.0F) {
/*  272 */       draw(paramBatch);
/*      */       return;
/*      */     } 
/*  275 */     int i = (int)this.accumulator;
/*  276 */     this.accumulator -= i;
/*      */     
/*  278 */     if (this.premultipliedAlpha) {
/*  279 */       paramBatch.setBlendFunction(1, 771);
/*  280 */     } else if (this.additive) {
/*  281 */       paramBatch.setBlendFunction(770, 1);
/*      */     } else {
/*  283 */       paramBatch.setBlendFunction(770, 771);
/*      */     } 
/*      */     
/*  286 */     Particle[] arrayOfParticle = this.particles;
/*  287 */     boolean[] arrayOfBoolean = this.active;
/*  288 */     int j = this.activeCount; int k;
/*  289 */     for (byte b = 0; b < k; b++) {
/*  290 */       if (arrayOfBoolean[b]) {
/*  291 */         Particle particle = arrayOfParticle[b];
/*  292 */         if (updateParticle(particle, paramFloat, i)) {
/*  293 */           particle.draw(paramBatch);
/*      */         } else {
/*  295 */           arrayOfBoolean[b] = false;
/*  296 */           j--;
/*      */         } 
/*      */       } 
/*      */     } 
/*  300 */     this.activeCount = j;
/*      */     
/*  302 */     if (this.cleansUpBlendFunction && (this.additive || this.premultipliedAlpha)) {
/*  303 */       paramBatch.setBlendFunction(770, 771);
/*      */     }
/*  305 */     if (this.delayTimer < this.delay) {
/*  306 */       this.delayTimer += i;
/*      */       
/*      */       return;
/*      */     } 
/*  310 */     if (this.firstUpdate) {
/*  311 */       this.firstUpdate = false;
/*  312 */       addParticle();
/*      */     } 
/*      */     
/*  315 */     if (this.durationTimer < this.duration) {
/*  316 */       this.durationTimer += i;
/*      */     } else {
/*  318 */       if (!this.continuous || this.allowCompletion)
/*  319 */         return;  restart();
/*      */     } 
/*      */     
/*  322 */     this.emissionDelta += i;
/*      */     float f;
/*  324 */     if ((f = this.emission + this.emissionDiff * this.emissionValue.getScale(this.durationTimer / this.duration)) > 0.0F) {
/*  325 */       f = 1000.0F / f;
/*  326 */       if (this.emissionDelta >= f) {
/*      */         
/*  328 */         k = Math.min(k = (int)(this.emissionDelta / f), this.maxParticleCount - j);
/*  329 */         this.emissionDelta = (int)(this.emissionDelta - k * f);
/*  330 */         this.emissionDelta = (int)(this.emissionDelta % f);
/*  331 */         addParticles(k);
/*      */       } 
/*      */     } 
/*  334 */     if (j < this.minParticleCount) addParticles(this.minParticleCount - j); 
/*      */   }
/*      */   
/*      */   public void start() {
/*  338 */     this.firstUpdate = true;
/*  339 */     this.allowCompletion = false;
/*  340 */     restart();
/*      */   }
/*      */   
/*      */   public void reset() {
/*  344 */     reset(true);
/*      */   }
/*      */   
/*      */   public void reset(boolean paramBoolean) {
/*  348 */     this.emissionDelta = 0;
/*  349 */     this.durationTimer = this.duration;
/*  350 */     boolean[] arrayOfBoolean = this.active; byte b; int i;
/*  351 */     for (b = 0, i = arrayOfBoolean.length; b < i; b++)
/*  352 */       arrayOfBoolean[b] = false; 
/*  353 */     this.activeCount = 0;
/*  354 */     if (paramBoolean) start(); 
/*      */   }
/*      */   
/*      */   private void restart() {
/*  358 */     this.delay = this.delayValue.active ? this.delayValue.newLowValue() : 0.0F;
/*  359 */     this.delayTimer = 0.0F;
/*      */     
/*  361 */     this.durationTimer -= this.duration;
/*  362 */     this.duration = this.durationValue.newLowValue();
/*      */     
/*  364 */     this.emission = (int)this.emissionValue.newLowValue();
/*  365 */     this.emissionDiff = (int)this.emissionValue.newHighValue();
/*  366 */     if (!this.emissionValue.relative) this.emissionDiff -= this.emission;
/*      */     
/*  368 */     if (!this.lifeValue.independent) generateLifeValues();
/*      */     
/*  370 */     if (!this.lifeOffsetValue.independent) generateLifeOffsetValues();
/*      */     
/*  372 */     this.spawnWidth = this.spawnWidthValue.newLowValue();
/*  373 */     this.spawnWidthDiff = this.spawnWidthValue.newHighValue();
/*  374 */     if (!this.spawnWidthValue.relative) this.spawnWidthDiff -= this.spawnWidth;
/*      */     
/*  376 */     this.spawnHeight = this.spawnHeightValue.newLowValue();
/*  377 */     this.spawnHeightDiff = this.spawnHeightValue.newHighValue();
/*  378 */     if (!this.spawnHeightValue.relative) this.spawnHeightDiff -= this.spawnHeight;
/*      */     
/*  380 */     this.updateFlags = 0;
/*  381 */     if (this.angleValue.active && this.angleValue.timeline.length > 1) this.updateFlags |= 0x2; 
/*  382 */     if (this.velocityValue.active) this.updateFlags |= 0x8; 
/*  383 */     if (this.xScaleValue.timeline.length > 1) this.updateFlags |= 0x1; 
/*  384 */     if (this.yScaleValue.active && this.yScaleValue.timeline.length > 1) this.updateFlags |= 0x1; 
/*  385 */     if (this.rotationValue.active && this.rotationValue.timeline.length > 1) this.updateFlags |= 0x4; 
/*  386 */     if (this.windValue.active) this.updateFlags |= 0x10; 
/*  387 */     if (this.gravityValue.active) this.updateFlags |= 0x20; 
/*  388 */     if (this.tintValue.timeline.length > 1) this.updateFlags |= 0x40; 
/*  389 */     if (this.spriteMode == SpriteMode.animated) this.updateFlags |= 0x80; 
/*      */   }
/*      */   
/*      */   protected Particle newParticle(Sprite paramSprite) {
/*  393 */     return new Particle(paramSprite);
/*      */   }
/*      */   
/*      */   protected Particle[] getParticles() {
/*  397 */     return this.particles;
/*      */   }
/*      */   private void activateParticle(int paramInt) {
/*      */     float f7, f8, f9;
/*  401 */     Sprite sprite = null;
/*  402 */     switch (this.spriteMode) {
/*      */       case square:
/*      */       case ellipse:
/*  405 */         sprite = (Sprite)this.sprites.first();
/*      */         break;
/*      */       case line:
/*  408 */         sprite = (Sprite)this.sprites.random();
/*      */         break;
/*      */     } 
/*      */     
/*      */     Particle particle;
/*  413 */     if ((particle = this.particles[paramInt]) == null) {
/*  414 */       this.particles[paramInt] = particle = newParticle(sprite);
/*  415 */       particle.flip(this.flipX, this.flipY);
/*      */     } else {
/*  417 */       particle.set(sprite);
/*      */     } 
/*      */     
/*  420 */     float f1 = this.durationTimer / this.duration;
/*  421 */     int i = this.updateFlags;
/*      */     
/*  423 */     if (this.lifeValue.independent) generateLifeValues();
/*      */     
/*  425 */     if (this.lifeOffsetValue.independent) generateLifeOffsetValues();
/*      */     
/*  427 */     particle.currentLife = particle.life = this.life + (int)(this.lifeDiff * this.lifeValue.getScale(f1));
/*      */     
/*  429 */     if (this.velocityValue.active) {
/*  430 */       particle.velocity = this.velocityValue.newLowValue();
/*  431 */       particle.velocityDiff = this.velocityValue.newHighValue();
/*  432 */       if (!this.velocityValue.relative) particle.velocityDiff -= particle.velocity;
/*      */     
/*      */     } 
/*  435 */     particle.angle = this.angleValue.newLowValue();
/*  436 */     particle.angleDiff = this.angleValue.newHighValue();
/*  437 */     if (!this.angleValue.relative) particle.angleDiff -= particle.angle; 
/*  438 */     float f4 = 0.0F;
/*  439 */     if ((i & 0x2) == 0) {
/*  440 */       f4 = particle.angle + particle.angleDiff * this.angleValue.getScale(0.0F);
/*  441 */       particle.angle = f4;
/*  442 */       particle.angleCos = MathUtils.cosDeg(f4);
/*  443 */       particle.angleSin = MathUtils.sinDeg(f4);
/*      */     } 
/*      */     
/*  446 */     float f5 = sprite.getWidth();
/*  447 */     float f2 = sprite.getHeight();
/*      */     
/*  449 */     particle.xScale = this.xScaleValue.newLowValue() / f5;
/*  450 */     particle.xScaleDiff = this.xScaleValue.newHighValue() / f5;
/*  451 */     if (!this.xScaleValue.relative) particle.xScaleDiff -= particle.xScale;
/*      */     
/*  453 */     if (this.yScaleValue.active) {
/*  454 */       particle.yScale = this.yScaleValue.newLowValue() / f2;
/*  455 */       particle.yScaleDiff = this.yScaleValue.newHighValue() / f2;
/*  456 */       if (!this.yScaleValue.relative) particle.yScaleDiff -= particle.yScale; 
/*  457 */       particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(0.0F), particle.yScale + particle.yScaleDiff * this.yScaleValue
/*  458 */           .getScale(0.0F));
/*      */     } else {
/*  460 */       particle.setScale(particle.xScale + particle.xScaleDiff * this.xScaleValue.getScale(0.0F));
/*      */     } 
/*      */     
/*  463 */     if (this.rotationValue.active) {
/*  464 */       particle.rotation = this.rotationValue.newLowValue();
/*  465 */       particle.rotationDiff = this.rotationValue.newHighValue();
/*  466 */       if (!this.rotationValue.relative) particle.rotationDiff -= particle.rotation; 
/*  467 */       float f = particle.rotation + particle.rotationDiff * this.rotationValue.getScale(0.0F);
/*  468 */       if (this.aligned) f += f4; 
/*  469 */       particle.setRotation(f);
/*      */     } 
/*      */     
/*  472 */     if (this.windValue.active) {
/*  473 */       particle.wind = this.windValue.newLowValue();
/*  474 */       particle.windDiff = this.windValue.newHighValue();
/*  475 */       if (!this.windValue.relative) particle.windDiff -= particle.wind;
/*      */     
/*      */     } 
/*  478 */     if (this.gravityValue.active) {
/*  479 */       particle.gravity = this.gravityValue.newLowValue();
/*  480 */       particle.gravityDiff = this.gravityValue.newHighValue();
/*  481 */       if (!this.gravityValue.relative) particle.gravityDiff -= particle.gravity;
/*      */     
/*      */     } 
/*      */     float[] arrayOfFloat2;
/*  485 */     if ((arrayOfFloat2 = particle.tint) == null) particle.tint = arrayOfFloat2 = new float[3]; 
/*  486 */     float[] arrayOfFloat1 = this.tintValue.getColor(0.0F);
/*  487 */     arrayOfFloat2[0] = arrayOfFloat1[0];
/*  488 */     arrayOfFloat2[1] = arrayOfFloat1[1];
/*  489 */     arrayOfFloat2[2] = arrayOfFloat1[2];
/*      */     
/*  491 */     particle.transparency = this.transparencyValue.newLowValue();
/*  492 */     particle.transparencyDiff = this.transparencyValue.newHighValue() - particle.transparency;
/*      */ 
/*      */     
/*  495 */     float f3 = this.x;
/*  496 */     if (this.xOffsetValue.active) f3 += this.xOffsetValue.newLowValue(); 
/*  497 */     float f6 = this.y;
/*  498 */     if (this.yOffsetValue.active) f6 += this.yOffsetValue.newLowValue(); 
/*  499 */     switch (this.spawnShapeValue.shape) {
/*      */       case square:
/*  501 */         f7 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f1);
/*  502 */         f8 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f1);
/*  503 */         f3 += MathUtils.random(f7) - f7 * 0.5F;
/*  504 */         f6 += MathUtils.random(f8) - f8 * 0.5F;
/*      */         break;
/*      */       
/*      */       case ellipse:
/*  508 */         f7 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f1);
/*  509 */         f8 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f1);
/*  510 */         f9 = f7 * 0.5F;
/*  511 */         f8 *= 0.5F;
/*  512 */         if (f9 != 0.0F && f8 != 0.0F) {
/*  513 */           f8 = f9 / f8;
/*  514 */           if (this.spawnShapeValue.edges) {
/*      */             float f10;
/*  516 */             switch (this.spawnShapeValue.side) {
/*      */               case square:
/*  518 */                 f10 = -MathUtils.random(179.0F);
/*      */                 break;
/*      */               case ellipse:
/*  521 */                 f10 = MathUtils.random(179.0F);
/*      */                 break;
/*      */               default:
/*  524 */                 f10 = MathUtils.random(360.0F);
/*      */                 break;
/*      */             } 
/*  527 */             float f11 = MathUtils.cosDeg(f10);
/*  528 */             float f12 = MathUtils.sinDeg(f10);
/*  529 */             f3 += f11 * f9;
/*  530 */             f6 += f12 * f9 / f8;
/*  531 */             if ((i & 0x2) == 0) {
/*  532 */               particle.angle = f10;
/*  533 */               particle.angleCos = f11;
/*  534 */               particle.angleSin = f12;
/*      */             }  break;
/*      */           } 
/*  537 */           float f = f9 * f9;
/*      */           while (true) {
/*  539 */             float f10 = MathUtils.random(f7) - f9;
/*  540 */             float f11 = MathUtils.random(f7) - f9;
/*  541 */             if (f10 * f10 + f11 * f11 <= f) {
/*  542 */               f3 += f10;
/*  543 */               f6 += f11 / f8;
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         break;
/*      */       
/*      */       case line:
/*  551 */         f7 = this.spawnWidth + this.spawnWidthDiff * this.spawnWidthValue.getScale(f1);
/*  552 */         f8 = this.spawnHeight + this.spawnHeightDiff * this.spawnHeightValue.getScale(f1);
/*  553 */         if (f7 != 0.0F) {
/*  554 */           f9 = f7 * MathUtils.random();
/*  555 */           f3 += f9;
/*  556 */           f6 += f9 * f8 / f7; break;
/*      */         } 
/*  558 */         f6 += f8 * MathUtils.random();
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  563 */     particle.setBounds(f3 - f5 * 0.5F, f6 - f2 * 0.5F, f5, f2);
/*      */     
/*      */     int j;
/*  566 */     if ((j = (int)(this.lifeOffset + this.lifeOffsetDiff * this.lifeOffsetValue.getScale(f1))) > 0) {
/*  567 */       if (j >= particle.currentLife) j = particle.currentLife - 1; 
/*  568 */       updateParticle(particle, j / 1000.0F, j);
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean updateParticle(Particle paramParticle, float paramFloat, int paramInt) {
/*      */     float[] arrayOfFloat;
/*  574 */     if ((paramInt = paramParticle.currentLife - paramInt) <= 0) return false; 
/*  575 */     paramParticle.currentLife = paramInt;
/*      */     
/*  577 */     float f = 1.0F - paramParticle.currentLife / paramParticle.life;
/*      */     
/*      */     int i;
/*  580 */     if (((i = this.updateFlags) & 0x1) != 0) {
/*  581 */       if (this.yScaleValue.active) {
/*  582 */         paramParticle.setScale(paramParticle.xScale + paramParticle.xScaleDiff * this.xScaleValue.getScale(f), paramParticle.yScale + paramParticle.yScaleDiff * this.yScaleValue
/*  583 */             .getScale(f));
/*      */       } else {
/*  585 */         paramParticle.setScale(paramParticle.xScale + paramParticle.xScaleDiff * this.xScaleValue.getScale(f));
/*      */       } 
/*      */     }
/*      */     
/*  589 */     if ((i & 0x8) != 0) {
/*  590 */       float f2, f3, f1 = (paramParticle.velocity + paramParticle.velocityDiff * this.velocityValue.getScale(f)) * paramFloat;
/*      */ 
/*      */       
/*  593 */       if ((i & 0x2) != 0) {
/*  594 */         float f4 = paramParticle.angle + paramParticle.angleDiff * this.angleValue.getScale(f);
/*  595 */         f2 = f1 * MathUtils.cosDeg(f4);
/*  596 */         f3 = f1 * MathUtils.sinDeg(f4);
/*  597 */         if ((i & 0x4) != 0) {
/*  598 */           f1 = paramParticle.rotation + paramParticle.rotationDiff * this.rotationValue.getScale(f);
/*  599 */           if (this.aligned) f1 += f4; 
/*  600 */           paramParticle.setRotation(f1);
/*      */         } 
/*      */       } else {
/*  603 */         f2 = f1 * paramParticle.angleCos;
/*  604 */         f3 = f1 * paramParticle.angleSin;
/*  605 */         if (this.aligned || (i & 0x4) != 0) {
/*  606 */           float f4 = paramParticle.rotation + paramParticle.rotationDiff * this.rotationValue.getScale(f);
/*  607 */           if (this.aligned) f4 += paramParticle.angle; 
/*  608 */           paramParticle.setRotation(f4);
/*      */         } 
/*      */       } 
/*      */       
/*  612 */       if ((i & 0x10) != 0) {
/*  613 */         f2 += (paramParticle.wind + paramParticle.windDiff * this.windValue.getScale(f)) * paramFloat;
/*      */       }
/*  615 */       if ((i & 0x20) != 0) {
/*  616 */         f3 += (paramParticle.gravity + paramParticle.gravityDiff * this.gravityValue.getScale(f)) * paramFloat;
/*      */       }
/*  618 */       paramParticle.translate(f2, f3);
/*      */     }
/*  620 */     else if ((i & 0x4) != 0) {
/*  621 */       paramParticle.setRotation(paramParticle.rotation + paramParticle.rotationDiff * this.rotationValue.getScale(f));
/*      */     } 
/*      */ 
/*      */     
/*  625 */     if ((i & 0x40) != 0) {
/*  626 */       arrayOfFloat = this.tintValue.getColor(f);
/*      */     } else {
/*  628 */       arrayOfFloat = paramParticle.tint;
/*      */     } 
/*  630 */     if (this.premultipliedAlpha) {
/*  631 */       float f1 = this.additive ? 0.0F : 1.0F;
/*  632 */       float f2 = paramParticle.transparency + paramParticle.transparencyDiff * this.transparencyValue.getScale(f);
/*  633 */       paramParticle.setColor(arrayOfFloat[0] * f2, arrayOfFloat[1] * f2, arrayOfFloat[2] * f2, f2 * f1);
/*      */     } else {
/*  635 */       paramParticle.setColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2], paramParticle.transparency + paramParticle.transparencyDiff * this.transparencyValue
/*  636 */           .getScale(f));
/*      */     } 
/*      */     
/*  639 */     if ((i & 0x80) != 0) {
/*  640 */       int j = Math.min((int)(f * this.sprites.size), this.sprites.size - 1);
/*  641 */       if (paramParticle.frame != j) {
/*  642 */         Sprite sprite = (Sprite)this.sprites.get(j);
/*  643 */         float f2 = paramParticle.getWidth();
/*  644 */         float f1 = paramParticle.getHeight();
/*  645 */         paramParticle.setRegion(sprite);
/*  646 */         paramParticle.setSize(sprite.getWidth(), sprite.getHeight());
/*  647 */         paramParticle.setOrigin(sprite.getOriginX(), sprite.getOriginY());
/*  648 */         paramParticle.translate((f2 - sprite.getWidth()) * 0.5F, (f1 - sprite.getHeight()) * 0.5F);
/*  649 */         paramParticle.frame = j;
/*      */       } 
/*      */     } 
/*      */     
/*  653 */     return true;
/*      */   }
/*      */   
/*      */   private void generateLifeValues() {
/*  657 */     this.life = (int)this.lifeValue.newLowValue();
/*  658 */     this.lifeDiff = (int)this.lifeValue.newHighValue();
/*  659 */     if (!this.lifeValue.relative) this.lifeDiff -= this.life; 
/*      */   }
/*      */   
/*      */   private void generateLifeOffsetValues() {
/*  663 */     this.lifeOffset = this.lifeOffsetValue.active ? (int)this.lifeOffsetValue.newLowValue() : 0;
/*  664 */     this.lifeOffsetDiff = (int)this.lifeOffsetValue.newHighValue();
/*  665 */     if (!this.lifeOffsetValue.relative) this.lifeOffsetDiff -= this.lifeOffset; 
/*      */   }
/*      */   
/*      */   public void setPosition(float paramFloat1, float paramFloat2) {
/*  669 */     if (this.attached) {
/*  670 */       float f1 = paramFloat1 - this.x;
/*  671 */       float f2 = paramFloat2 - this.y;
/*  672 */       boolean[] arrayOfBoolean = this.active; byte b; int i;
/*  673 */       for (b = 0, i = arrayOfBoolean.length; b < i; b++) {
/*  674 */         if (arrayOfBoolean[b]) this.particles[b].translate(f1, f2); 
/*      */       } 
/*  676 */     }  this.x = paramFloat1;
/*  677 */     this.y = paramFloat2;
/*      */   }
/*      */   
/*      */   public void setSprites(Array<Sprite> paramArray) {
/*  681 */     this.sprites = paramArray;
/*  682 */     if (paramArray.size == 0)
/*  683 */       return;  byte b; int i; Particle particle; for (b = 0, i = this.particles.length; b < i && (
/*      */       
/*  685 */       particle = this.particles[b]) != null; b++) {
/*  686 */       float f; Sprite sprite1, sprite2 = null;
/*  687 */       switch (this.spriteMode) {
/*      */         case square:
/*  689 */           sprite2 = (Sprite)paramArray.first();
/*      */           break;
/*      */         case line:
/*  692 */           sprite2 = (Sprite)paramArray.random();
/*      */           break;
/*      */         case ellipse:
/*  695 */           f = 1.0F - particle.currentLife / particle.life;
/*  696 */           particle.frame = Math.min((int)(f * paramArray.size), paramArray.size - 1);
/*  697 */           sprite1 = (Sprite)paramArray.get(particle.frame);
/*      */           break;
/*      */       } 
/*  700 */       particle.setRegion(sprite1);
/*  701 */       particle.setOrigin(sprite1.getOriginX(), sprite1.getOriginY());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setSpriteMode(SpriteMode paramSpriteMode) {
/*  706 */     this.spriteMode = paramSpriteMode;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void preAllocateParticles() {
/*  712 */     if (this.sprites.isEmpty())
/*  713 */       throw new IllegalStateException("ParticleEmitter.setSprites() must have been called before preAllocateParticles()"); 
/*  714 */     for (byte b = 0; b < this.particles.length; b++) {
/*      */       Particle particle;
/*  716 */       if ((particle = this.particles[b]) == null) {
/*  717 */         this.particles[b] = particle = newParticle((Sprite)this.sprites.first());
/*  718 */         particle.flip(this.flipX, this.flipY);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void allowCompletion() {
/*  726 */     this.allowCompletion = true;
/*  727 */     this.durationTimer = this.duration;
/*      */   }
/*      */   
/*      */   public boolean getAllowCompletion() {
/*  731 */     return this.allowCompletion;
/*      */   }
/*      */   
/*      */   public Array<Sprite> getSprites() {
/*  735 */     return this.sprites;
/*      */   }
/*      */   
/*      */   public SpriteMode getSpriteMode() {
/*  739 */     return this.spriteMode;
/*      */   }
/*      */   
/*      */   public String getName() {
/*  743 */     return this.name;
/*      */   }
/*      */   
/*      */   public void setName(String paramString) {
/*  747 */     this.name = paramString;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getLife() {
/*  751 */     return this.lifeValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getXScale() {
/*  755 */     return this.xScaleValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getYScale() {
/*  759 */     return this.yScaleValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getRotation() {
/*  763 */     return this.rotationValue;
/*      */   }
/*      */   
/*      */   public GradientColorValue getTint() {
/*  767 */     return this.tintValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getVelocity() {
/*  771 */     return this.velocityValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getWind() {
/*  775 */     return this.windValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getGravity() {
/*  779 */     return this.gravityValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getAngle() {
/*  783 */     return this.angleValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getEmission() {
/*  787 */     return this.emissionValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getTransparency() {
/*  791 */     return this.transparencyValue;
/*      */   }
/*      */   
/*      */   public RangedNumericValue getDuration() {
/*  795 */     return this.durationValue;
/*      */   }
/*      */   
/*      */   public RangedNumericValue getDelay() {
/*  799 */     return this.delayValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getLifeOffset() {
/*  803 */     return this.lifeOffsetValue;
/*      */   }
/*      */   
/*      */   public RangedNumericValue getXOffsetValue() {
/*  807 */     return this.xOffsetValue;
/*      */   }
/*      */   
/*      */   public RangedNumericValue getYOffsetValue() {
/*  811 */     return this.yOffsetValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getSpawnWidth() {
/*  815 */     return this.spawnWidthValue;
/*      */   }
/*      */   
/*      */   public ScaledNumericValue getSpawnHeight() {
/*  819 */     return this.spawnHeightValue;
/*      */   }
/*      */   
/*      */   public SpawnShapeValue getSpawnShape() {
/*  823 */     return this.spawnShapeValue;
/*      */   }
/*      */   
/*      */   public boolean isAttached() {
/*  827 */     return this.attached;
/*      */   }
/*      */   
/*      */   public void setAttached(boolean paramBoolean) {
/*  831 */     this.attached = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isContinuous() {
/*  835 */     return this.continuous;
/*      */   }
/*      */   
/*      */   public void setContinuous(boolean paramBoolean) {
/*  839 */     this.continuous = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isAligned() {
/*  843 */     return this.aligned;
/*      */   }
/*      */   
/*      */   public void setAligned(boolean paramBoolean) {
/*  847 */     this.aligned = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isAdditive() {
/*  851 */     return this.additive;
/*      */   }
/*      */   
/*      */   public void setAdditive(boolean paramBoolean) {
/*  855 */     this.additive = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean cleansUpBlendFunction() {
/*  861 */     return this.cleansUpBlendFunction;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCleansUpBlendFunction(boolean paramBoolean) {
/*  873 */     this.cleansUpBlendFunction = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isBehind() {
/*  877 */     return this.behind;
/*      */   }
/*      */   
/*      */   public void setBehind(boolean paramBoolean) {
/*  881 */     this.behind = paramBoolean;
/*      */   }
/*      */   
/*      */   public boolean isPremultipliedAlpha() {
/*  885 */     return this.premultipliedAlpha;
/*      */   }
/*      */   
/*      */   public void setPremultipliedAlpha(boolean paramBoolean) {
/*  889 */     this.premultipliedAlpha = paramBoolean;
/*      */   }
/*      */   
/*      */   public int getMinParticleCount() {
/*  893 */     return this.minParticleCount;
/*      */   }
/*      */   
/*      */   public void setMinParticleCount(int paramInt) {
/*  897 */     this.minParticleCount = paramInt;
/*      */   }
/*      */   
/*      */   public int getMaxParticleCount() {
/*  901 */     return this.maxParticleCount;
/*      */   }
/*      */   
/*      */   public boolean isComplete() {
/*  905 */     if (this.continuous && !this.allowCompletion) return false; 
/*  906 */     if (this.delayTimer < this.delay) return false; 
/*  907 */     return (this.durationTimer >= this.duration && this.activeCount == 0);
/*      */   }
/*      */   
/*      */   public float getPercentComplete() {
/*  911 */     if (this.delayTimer < this.delay) return 0.0F; 
/*  912 */     return Math.min(1.0F, this.durationTimer / this.duration);
/*      */   }
/*      */   
/*      */   public float getX() {
/*  916 */     return this.x;
/*      */   }
/*      */   
/*      */   public float getY() {
/*  920 */     return this.y;
/*      */   }
/*      */   
/*      */   public int getActiveCount() {
/*  924 */     return this.activeCount;
/*      */   }
/*      */   
/*      */   public Array<String> getImagePaths() {
/*  928 */     return this.imagePaths;
/*      */   }
/*      */   
/*      */   public void setImagePaths(Array<String> paramArray) {
/*  932 */     this.imagePaths = paramArray;
/*      */   }
/*      */   
/*      */   public void setFlip(boolean paramBoolean1, boolean paramBoolean2) {
/*  936 */     this.flipX = paramBoolean1;
/*  937 */     this.flipY = paramBoolean2;
/*  938 */     if (this.particles == null)
/*  939 */       return;  byte b; int i; for (b = 0, i = this.particles.length; b < i; b++) {
/*      */       Particle particle;
/*  941 */       if ((particle = this.particles[b]) != null) particle.flip(paramBoolean1, paramBoolean2); 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void flipY() {
/*  946 */     this.angleValue.setHigh(-this.angleValue.getHighMin(), -this.angleValue.getHighMax());
/*  947 */     this.angleValue.setLow(-this.angleValue.getLowMin(), -this.angleValue.getLowMax());
/*      */     
/*  949 */     this.gravityValue.setHigh(-this.gravityValue.getHighMin(), -this.gravityValue.getHighMax());
/*  950 */     this.gravityValue.setLow(-this.gravityValue.getLowMin(), -this.gravityValue.getLowMax());
/*      */     
/*  952 */     this.windValue.setHigh(-this.windValue.getHighMin(), -this.windValue.getHighMax());
/*  953 */     this.windValue.setLow(-this.windValue.getLowMin(), -this.windValue.getLowMax());
/*      */     
/*  955 */     this.rotationValue.setHigh(-this.rotationValue.getHighMin(), -this.rotationValue.getHighMax());
/*  956 */     this.rotationValue.setLow(-this.rotationValue.getLowMin(), -this.rotationValue.getLowMax());
/*      */     
/*  958 */     this.yOffsetValue.setLow(-this.yOffsetValue.getLowMin(), -this.yOffsetValue.getLowMax());
/*      */   }
/*      */ 
/*      */   
/*      */   public BoundingBox getBoundingBox() {
/*  963 */     if (this.bounds == null) this.bounds = new BoundingBox();
/*      */     
/*  965 */     Particle[] arrayOfParticle = this.particles;
/*  966 */     boolean[] arrayOfBoolean = this.active;
/*      */     
/*      */     BoundingBox boundingBox;
/*  969 */     (boundingBox = this.bounds).inf(); byte b; int i;
/*  970 */     for (b = 0, i = arrayOfBoolean.length; b < i; b++) {
/*  971 */       if (arrayOfBoolean[b]) {
/*  972 */         Rectangle rectangle = arrayOfParticle[b].getBoundingRectangle();
/*  973 */         boundingBox.ext(rectangle.x, rectangle.y, 0.0F);
/*  974 */         boundingBox.ext(rectangle.x + rectangle.width, rectangle.y + rectangle.height, 0.0F);
/*      */       } 
/*      */     } 
/*  977 */     return boundingBox;
/*      */   }
/*      */   
/*      */   protected RangedNumericValue[] getXSizeValues() {
/*  981 */     if (this.xSizeValues == null) {
/*  982 */       this.xSizeValues = new RangedNumericValue[3];
/*  983 */       this.xSizeValues[0] = this.xScaleValue;
/*  984 */       this.xSizeValues[1] = this.spawnWidthValue;
/*  985 */       this.xSizeValues[2] = this.xOffsetValue;
/*      */     } 
/*  987 */     return this.xSizeValues;
/*      */   }
/*      */   
/*      */   protected RangedNumericValue[] getYSizeValues() {
/*  991 */     if (this.ySizeValues == null) {
/*  992 */       this.ySizeValues = new RangedNumericValue[3];
/*  993 */       this.ySizeValues[0] = this.yScaleValue;
/*  994 */       this.ySizeValues[1] = this.spawnHeightValue;
/*  995 */       this.ySizeValues[2] = this.yOffsetValue;
/*      */     } 
/*  997 */     return this.ySizeValues;
/*      */   }
/*      */   
/*      */   protected RangedNumericValue[] getMotionValues() {
/* 1001 */     if (this.motionValues == null) {
/* 1002 */       this.motionValues = new RangedNumericValue[3];
/* 1003 */       this.motionValues[0] = this.velocityValue;
/* 1004 */       this.motionValues[1] = this.windValue;
/* 1005 */       this.motionValues[2] = this.gravityValue;
/*      */     } 
/* 1007 */     return this.motionValues;
/*      */   }
/*      */ 
/*      */   
/*      */   public void scaleSize(float paramFloat) {
/* 1012 */     if (paramFloat == 1.0F)
/* 1013 */       return;  scaleSize(paramFloat, paramFloat);
/*      */   }
/*      */ 
/*      */   
/*      */   public void scaleSize(float paramFloat1, float paramFloat2) {
/* 1018 */     if (paramFloat1 == 1.0F && paramFloat2 == 1.0F)
/* 1019 */       return;  RangedNumericValue[] arrayOfRangedNumericValue; int i; byte b; for (i = (arrayOfRangedNumericValue = getXSizeValues()).length, b = 0; b < i; b++) {
/* 1020 */       RangedNumericValue rangedNumericValue; (rangedNumericValue = arrayOfRangedNumericValue[b]).scale(paramFloat1);
/* 1021 */     }  for (i = (arrayOfRangedNumericValue = getYSizeValues()).length, b = 0; b < i; b++) {
/* 1022 */       RangedNumericValue rangedNumericValue; (rangedNumericValue = arrayOfRangedNumericValue[b]).scale(paramFloat2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void scaleMotion(float paramFloat) {
/* 1027 */     if (paramFloat == 1.0F)
/* 1028 */       return;  RangedNumericValue[] arrayOfRangedNumericValue; int i; byte b; for (i = (arrayOfRangedNumericValue = getMotionValues()).length, b = 0; b < i; b++) {
/* 1029 */       RangedNumericValue rangedNumericValue; (rangedNumericValue = arrayOfRangedNumericValue[b]).scale(paramFloat);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void matchSize(ParticleEmitter paramParticleEmitter) {
/* 1034 */     matchXSize(paramParticleEmitter);
/* 1035 */     matchYSize(paramParticleEmitter);
/*      */   }
/*      */ 
/*      */   
/*      */   public void matchXSize(ParticleEmitter paramParticleEmitter) {
/* 1040 */     RangedNumericValue[] arrayOfRangedNumericValue2 = getXSizeValues();
/* 1041 */     RangedNumericValue[] arrayOfRangedNumericValue1 = paramParticleEmitter.getXSizeValues();
/* 1042 */     for (byte b = 0; b < arrayOfRangedNumericValue2.length; b++) {
/* 1043 */       arrayOfRangedNumericValue2[b].set(arrayOfRangedNumericValue1[b]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void matchYSize(ParticleEmitter paramParticleEmitter) {
/* 1049 */     RangedNumericValue[] arrayOfRangedNumericValue2 = getYSizeValues();
/* 1050 */     RangedNumericValue[] arrayOfRangedNumericValue1 = paramParticleEmitter.getYSizeValues();
/* 1051 */     for (byte b = 0; b < arrayOfRangedNumericValue2.length; b++) {
/* 1052 */       arrayOfRangedNumericValue2[b].set(arrayOfRangedNumericValue1[b]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void matchMotion(ParticleEmitter paramParticleEmitter) {
/* 1058 */     RangedNumericValue[] arrayOfRangedNumericValue2 = getMotionValues();
/* 1059 */     RangedNumericValue[] arrayOfRangedNumericValue1 = paramParticleEmitter.getMotionValues();
/* 1060 */     for (byte b = 0; b < arrayOfRangedNumericValue2.length; b++) {
/* 1061 */       arrayOfRangedNumericValue2[b].set(arrayOfRangedNumericValue1[b]);
/*      */     }
/*      */   }
/*      */   
/*      */   public void save(Writer paramWriter) {
/* 1066 */     paramWriter.write(this.name + "\n");
/* 1067 */     paramWriter.write("- Delay -\n");
/* 1068 */     this.delayValue.save(paramWriter);
/* 1069 */     paramWriter.write("- Duration - \n");
/* 1070 */     this.durationValue.save(paramWriter);
/* 1071 */     paramWriter.write("- Count - \n");
/* 1072 */     paramWriter.write("min: " + this.minParticleCount + "\n");
/* 1073 */     paramWriter.write("max: " + this.maxParticleCount + "\n");
/* 1074 */     paramWriter.write("- Emission - \n");
/* 1075 */     this.emissionValue.save(paramWriter);
/* 1076 */     paramWriter.write("- Life - \n");
/* 1077 */     this.lifeValue.save(paramWriter);
/* 1078 */     paramWriter.write("- Life Offset - \n");
/* 1079 */     this.lifeOffsetValue.save(paramWriter);
/* 1080 */     paramWriter.write("- X Offset - \n");
/* 1081 */     this.xOffsetValue.save(paramWriter);
/* 1082 */     paramWriter.write("- Y Offset - \n");
/* 1083 */     this.yOffsetValue.save(paramWriter);
/* 1084 */     paramWriter.write("- Spawn Shape - \n");
/* 1085 */     this.spawnShapeValue.save(paramWriter);
/* 1086 */     paramWriter.write("- Spawn Width - \n");
/* 1087 */     this.spawnWidthValue.save(paramWriter);
/* 1088 */     paramWriter.write("- Spawn Height - \n");
/* 1089 */     this.spawnHeightValue.save(paramWriter);
/* 1090 */     paramWriter.write("- X Scale - \n");
/* 1091 */     this.xScaleValue.save(paramWriter);
/* 1092 */     paramWriter.write("- Y Scale - \n");
/* 1093 */     this.yScaleValue.save(paramWriter);
/* 1094 */     paramWriter.write("- Velocity - \n");
/* 1095 */     this.velocityValue.save(paramWriter);
/* 1096 */     paramWriter.write("- Angle - \n");
/* 1097 */     this.angleValue.save(paramWriter);
/* 1098 */     paramWriter.write("- Rotation - \n");
/* 1099 */     this.rotationValue.save(paramWriter);
/* 1100 */     paramWriter.write("- Wind - \n");
/* 1101 */     this.windValue.save(paramWriter);
/* 1102 */     paramWriter.write("- Gravity - \n");
/* 1103 */     this.gravityValue.save(paramWriter);
/* 1104 */     paramWriter.write("- Tint - \n");
/* 1105 */     this.tintValue.save(paramWriter);
/* 1106 */     paramWriter.write("- Transparency - \n");
/* 1107 */     this.transparencyValue.save(paramWriter);
/* 1108 */     paramWriter.write("- Options - \n");
/* 1109 */     paramWriter.write("attached: " + this.attached + "\n");
/* 1110 */     paramWriter.write("continuous: " + this.continuous + "\n");
/* 1111 */     paramWriter.write("aligned: " + this.aligned + "\n");
/* 1112 */     paramWriter.write("additive: " + this.additive + "\n");
/* 1113 */     paramWriter.write("behind: " + this.behind + "\n");
/* 1114 */     paramWriter.write("premultipliedAlpha: " + this.premultipliedAlpha + "\n");
/* 1115 */     paramWriter.write("spriteMode: " + this.spriteMode.toString() + "\n");
/* 1116 */     paramWriter.write("- Image Paths -\n");
/* 1117 */     for (Array.ArrayIterator<String> arrayIterator = this.imagePaths.iterator(); arrayIterator.hasNext(); ) { String str = arrayIterator.next();
/* 1118 */       paramWriter.write(str + "\n"); }
/*      */     
/* 1120 */     paramWriter.write("\n");
/*      */   }
/*      */   
/*      */   public void load(BufferedReader paramBufferedReader) {
/*      */     try {
/* 1125 */       this.name = readString(paramBufferedReader, "name");
/* 1126 */       paramBufferedReader.readLine();
/* 1127 */       this.delayValue.load(paramBufferedReader);
/* 1128 */       paramBufferedReader.readLine();
/* 1129 */       this.durationValue.load(paramBufferedReader);
/* 1130 */       paramBufferedReader.readLine();
/* 1131 */       setMinParticleCount(readInt(paramBufferedReader, "minParticleCount"));
/* 1132 */       setMaxParticleCount(readInt(paramBufferedReader, "maxParticleCount"));
/* 1133 */       paramBufferedReader.readLine();
/* 1134 */       this.emissionValue.load(paramBufferedReader);
/* 1135 */       paramBufferedReader.readLine();
/* 1136 */       this.lifeValue.load(paramBufferedReader);
/* 1137 */       paramBufferedReader.readLine();
/* 1138 */       this.lifeOffsetValue.load(paramBufferedReader);
/* 1139 */       paramBufferedReader.readLine();
/* 1140 */       this.xOffsetValue.load(paramBufferedReader);
/* 1141 */       paramBufferedReader.readLine();
/* 1142 */       this.yOffsetValue.load(paramBufferedReader);
/* 1143 */       paramBufferedReader.readLine();
/* 1144 */       this.spawnShapeValue.load(paramBufferedReader);
/* 1145 */       paramBufferedReader.readLine();
/* 1146 */       this.spawnWidthValue.load(paramBufferedReader);
/* 1147 */       paramBufferedReader.readLine();
/* 1148 */       this.spawnHeightValue.load(paramBufferedReader);
/*      */       String str;
/* 1150 */       if ((str = paramBufferedReader.readLine()).trim().equals("- Scale -")) {
/* 1151 */         this.xScaleValue.load(paramBufferedReader);
/* 1152 */         this.yScaleValue.setActive(false);
/*      */       } else {
/* 1154 */         this.xScaleValue.load(paramBufferedReader);
/* 1155 */         paramBufferedReader.readLine();
/* 1156 */         this.yScaleValue.load(paramBufferedReader);
/*      */       } 
/* 1158 */       paramBufferedReader.readLine();
/* 1159 */       this.velocityValue.load(paramBufferedReader);
/* 1160 */       paramBufferedReader.readLine();
/* 1161 */       this.angleValue.load(paramBufferedReader);
/* 1162 */       paramBufferedReader.readLine();
/* 1163 */       this.rotationValue.load(paramBufferedReader);
/* 1164 */       paramBufferedReader.readLine();
/* 1165 */       this.windValue.load(paramBufferedReader);
/* 1166 */       paramBufferedReader.readLine();
/* 1167 */       this.gravityValue.load(paramBufferedReader);
/* 1168 */       paramBufferedReader.readLine();
/* 1169 */       this.tintValue.load(paramBufferedReader);
/* 1170 */       paramBufferedReader.readLine();
/* 1171 */       this.transparencyValue.load(paramBufferedReader);
/* 1172 */       paramBufferedReader.readLine();
/* 1173 */       this.attached = readBoolean(paramBufferedReader, "attached");
/* 1174 */       this.continuous = readBoolean(paramBufferedReader, "continuous");
/* 1175 */       this.aligned = readBoolean(paramBufferedReader, "aligned");
/* 1176 */       this.additive = readBoolean(paramBufferedReader, "additive");
/* 1177 */       this.behind = readBoolean(paramBufferedReader, "behind");
/*      */ 
/*      */ 
/*      */       
/* 1181 */       if ((str = paramBufferedReader.readLine()).startsWith("premultipliedAlpha")) {
/* 1182 */         this.premultipliedAlpha = readBoolean(str);
/* 1183 */         str = paramBufferedReader.readLine();
/*      */       } 
/* 1185 */       if (str.startsWith("spriteMode")) {
/* 1186 */         this.spriteMode = SpriteMode.valueOf(readString(str));
/* 1187 */         paramBufferedReader.readLine();
/*      */       } 
/*      */       
/* 1190 */       Array<String> array = new Array();
/* 1191 */       while ((str = paramBufferedReader.readLine()) != null && !str.isEmpty()) {
/* 1192 */         array.add(str);
/*      */       }
/* 1194 */       setImagePaths(array); return;
/* 1195 */     } catch (RuntimeException runtimeException) {
/* 1196 */       if (this.name == null) throw runtimeException; 
/* 1197 */       throw new RuntimeException("Error parsing emitter: " + this.name, runtimeException);
/*      */     } 
/*      */   }
/*      */   
/*      */   static String readString(String paramString) {
/* 1202 */     return paramString.substring(paramString.indexOf(":") + 1).trim();
/*      */   }
/*      */   
/*      */   static String readString(BufferedReader paramBufferedReader, String paramString) {
/*      */     String str;
/* 1207 */     if ((str = paramBufferedReader.readLine()) == null) throw new IOException("Missing value: " + paramString); 
/* 1208 */     return readString(str);
/*      */   }
/*      */   
/*      */   static boolean readBoolean(String paramString) {
/* 1212 */     return Boolean.parseBoolean(readString(paramString));
/*      */   }
/*      */   
/*      */   static boolean readBoolean(BufferedReader paramBufferedReader, String paramString) {
/* 1216 */     return Boolean.parseBoolean(readString(paramBufferedReader, paramString));
/*      */   }
/*      */   
/*      */   static int readInt(BufferedReader paramBufferedReader, String paramString) {
/* 1220 */     return Integer.parseInt(readString(paramBufferedReader, paramString));
/*      */   }
/*      */   
/*      */   static float readFloat(BufferedReader paramBufferedReader, String paramString) {
/* 1224 */     return Float.parseFloat(readString(paramBufferedReader, paramString));
/*      */   }
/*      */   
/*      */   public static class Particle
/*      */     extends Sprite {
/*      */     protected int life;
/*      */     protected int currentLife;
/*      */     protected float xScale;
/*      */     protected float xScaleDiff;
/*      */     protected float yScale;
/*      */     protected float yScaleDiff;
/*      */     protected float rotation;
/*      */     protected float rotationDiff;
/*      */     protected float velocity;
/*      */     protected float velocityDiff;
/*      */     protected float angle;
/*      */     
/*      */     public Particle(Sprite param1Sprite) {
/* 1242 */       super(param1Sprite);
/*      */     }
/*      */     protected float angleDiff; protected float angleCos; protected float angleSin; protected float transparency; protected float transparencyDiff; protected float wind; protected float windDiff; protected float gravity; protected float gravityDiff; protected float[] tint;
/*      */     protected int frame; }
/*      */   
/*      */   public static class ParticleValue { boolean active;
/*      */     boolean alwaysActive;
/*      */     
/*      */     public void setAlwaysActive(boolean param1Boolean) {
/* 1251 */       this.alwaysActive = param1Boolean;
/*      */     }
/*      */     
/*      */     public boolean isAlwaysActive() {
/* 1255 */       return this.alwaysActive;
/*      */     }
/*      */     
/*      */     public boolean isActive() {
/* 1259 */       return (this.alwaysActive || this.active);
/*      */     }
/*      */     
/*      */     public void setActive(boolean param1Boolean) {
/* 1263 */       this.active = param1Boolean;
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1267 */       if (!this.alwaysActive) {
/* 1268 */         param1Writer.write("active: " + this.active + "\n"); return;
/*      */       } 
/* 1270 */       this.active = true;
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1274 */       if (!this.alwaysActive) {
/* 1275 */         this.active = ParticleEmitter.readBoolean(param1BufferedReader, "active"); return;
/*      */       } 
/* 1277 */       this.active = true;
/*      */     }
/*      */     
/*      */     public void load(ParticleValue param1ParticleValue) {
/* 1281 */       this.active = param1ParticleValue.active;
/* 1282 */       this.alwaysActive = param1ParticleValue.alwaysActive;
/*      */     } }
/*      */ 
/*      */   
/*      */   public static class NumericValue extends ParticleValue {
/*      */     private float value;
/*      */     
/*      */     public float getValue() {
/* 1290 */       return this.value;
/*      */     }
/*      */     
/*      */     public void setValue(float param1Float) {
/* 1294 */       this.value = param1Float;
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1298 */       super.save(param1Writer);
/* 1299 */       if (!this.active)
/* 1300 */         return;  param1Writer.write("value: " + this.value + "\n");
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1304 */       super.load(param1BufferedReader);
/* 1305 */       if (!this.active)
/* 1306 */         return;  this.value = ParticleEmitter.readFloat(param1BufferedReader, "value");
/*      */     }
/*      */     
/*      */     public void load(NumericValue param1NumericValue) {
/* 1310 */       load(param1NumericValue);
/* 1311 */       this.value = param1NumericValue.value;
/*      */     } }
/*      */   
/*      */   public static class RangedNumericValue extends ParticleValue {
/*      */     private float lowMin;
/*      */     private float lowMax;
/*      */     
/*      */     public float newLowValue() {
/* 1319 */       return this.lowMin + (this.lowMax - this.lowMin) * MathUtils.random();
/*      */     }
/*      */     
/*      */     public void setLow(float param1Float) {
/* 1323 */       this.lowMin = param1Float;
/* 1324 */       this.lowMax = param1Float;
/*      */     }
/*      */     
/*      */     public void setLow(float param1Float1, float param1Float2) {
/* 1328 */       this.lowMin = param1Float1;
/* 1329 */       this.lowMax = param1Float2;
/*      */     }
/*      */     
/*      */     public float getLowMin() {
/* 1333 */       return this.lowMin;
/*      */     }
/*      */     
/*      */     public void setLowMin(float param1Float) {
/* 1337 */       this.lowMin = param1Float;
/*      */     }
/*      */     
/*      */     public float getLowMax() {
/* 1341 */       return this.lowMax;
/*      */     }
/*      */     
/*      */     public void setLowMax(float param1Float) {
/* 1345 */       this.lowMax = param1Float;
/*      */     }
/*      */ 
/*      */     
/*      */     public void scale(float param1Float) {
/* 1350 */       this.lowMin *= param1Float;
/* 1351 */       this.lowMax *= param1Float;
/*      */     }
/*      */     
/*      */     public void set(RangedNumericValue param1RangedNumericValue) {
/* 1355 */       this.lowMin = param1RangedNumericValue.lowMin;
/* 1356 */       this.lowMax = param1RangedNumericValue.lowMax;
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1360 */       super.save(param1Writer);
/* 1361 */       if (!this.active)
/* 1362 */         return;  param1Writer.write("lowMin: " + this.lowMin + "\n");
/* 1363 */       param1Writer.write("lowMax: " + this.lowMax + "\n");
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1367 */       super.load(param1BufferedReader);
/* 1368 */       if (!this.active)
/* 1369 */         return;  this.lowMin = ParticleEmitter.readFloat(param1BufferedReader, "lowMin");
/* 1370 */       this.lowMax = ParticleEmitter.readFloat(param1BufferedReader, "lowMax");
/*      */     }
/*      */     
/*      */     public void load(RangedNumericValue param1RangedNumericValue) {
/* 1374 */       load(param1RangedNumericValue);
/* 1375 */       this.lowMax = param1RangedNumericValue.lowMax;
/* 1376 */       this.lowMin = param1RangedNumericValue.lowMin;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ScaledNumericValue extends RangedNumericValue {
/* 1381 */     private float[] scaling = new float[] { 1.0F };
/* 1382 */     float[] timeline = new float[] { 0.0F }; private float highMin;
/*      */     private float highMax;
/*      */     boolean relative;
/*      */     
/*      */     public float newHighValue() {
/* 1387 */       return this.highMin + (this.highMax - this.highMin) * MathUtils.random();
/*      */     }
/*      */     
/*      */     public void setHigh(float param1Float) {
/* 1391 */       this.highMin = param1Float;
/* 1392 */       this.highMax = param1Float;
/*      */     }
/*      */     
/*      */     public void setHigh(float param1Float1, float param1Float2) {
/* 1396 */       this.highMin = param1Float1;
/* 1397 */       this.highMax = param1Float2;
/*      */     }
/*      */     
/*      */     public float getHighMin() {
/* 1401 */       return this.highMin;
/*      */     }
/*      */     
/*      */     public void setHighMin(float param1Float) {
/* 1405 */       this.highMin = param1Float;
/*      */     }
/*      */     
/*      */     public float getHighMax() {
/* 1409 */       return this.highMax;
/*      */     }
/*      */     
/*      */     public void setHighMax(float param1Float) {
/* 1413 */       this.highMax = param1Float;
/*      */     }
/*      */     
/*      */     public void scale(float param1Float) {
/* 1417 */       super.scale(param1Float);
/* 1418 */       this.highMin *= param1Float;
/* 1419 */       this.highMax *= param1Float;
/*      */     }
/*      */     
/*      */     public void set(ParticleEmitter.RangedNumericValue param1RangedNumericValue) {
/* 1423 */       if (param1RangedNumericValue instanceof ScaledNumericValue) {
/* 1424 */         set((ScaledNumericValue)param1RangedNumericValue); return;
/*      */       } 
/* 1426 */       super.set(param1RangedNumericValue);
/*      */     }
/*      */     
/*      */     public void set(ScaledNumericValue param1ScaledNumericValue) {
/* 1430 */       super.set(param1ScaledNumericValue);
/* 1431 */       this.highMin = param1ScaledNumericValue.highMin;
/* 1432 */       this.highMax = param1ScaledNumericValue.highMax;
/* 1433 */       if (this.scaling.length != param1ScaledNumericValue.scaling.length) {
/* 1434 */         this.scaling = Arrays.copyOf(param1ScaledNumericValue.scaling, param1ScaledNumericValue.scaling.length);
/*      */       } else {
/* 1436 */         System.arraycopy(param1ScaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
/* 1437 */       }  if (this.timeline.length != param1ScaledNumericValue.timeline.length) {
/* 1438 */         this.timeline = Arrays.copyOf(param1ScaledNumericValue.timeline, param1ScaledNumericValue.timeline.length);
/*      */       } else {
/* 1440 */         System.arraycopy(param1ScaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
/* 1441 */       }  this.relative = param1ScaledNumericValue.relative;
/*      */     }
/*      */     
/*      */     public float[] getScaling() {
/* 1445 */       return this.scaling;
/*      */     }
/*      */     
/*      */     public void setScaling(float[] param1ArrayOffloat) {
/* 1449 */       this.scaling = param1ArrayOffloat;
/*      */     }
/*      */     
/*      */     public float[] getTimeline() {
/* 1453 */       return this.timeline;
/*      */     }
/*      */     
/*      */     public void setTimeline(float[] param1ArrayOffloat) {
/* 1457 */       this.timeline = param1ArrayOffloat;
/*      */     }
/*      */     
/*      */     public boolean isRelative() {
/* 1461 */       return this.relative;
/*      */     }
/*      */     
/*      */     public void setRelative(boolean param1Boolean) {
/* 1465 */       this.relative = param1Boolean;
/*      */     }
/*      */     
/*      */     public float getScale(float param1Float) {
/* 1469 */       byte b = -1;
/*      */       float[] arrayOfFloat1;
/* 1471 */       int i = (arrayOfFloat1 = this.timeline).length;
/* 1472 */       for (byte b1 = 1; b1 < i; b1++) {
/*      */         float f;
/* 1474 */         if ((f = arrayOfFloat1[b1]) > param1Float) {
/* 1475 */           b = b1;
/*      */           break;
/*      */         } 
/*      */       } 
/* 1479 */       if (b == -1) return this.scaling[i - 1]; 
/* 1480 */       float[] arrayOfFloat2 = this.scaling;
/* 1481 */       int j = b - 1;
/* 1482 */       float f1 = arrayOfFloat2[j];
/* 1483 */       float f2 = arrayOfFloat1[j];
/* 1484 */       return f1 + (arrayOfFloat2[b] - f1) * (param1Float - f2) / (arrayOfFloat1[b] - f2);
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1488 */       super.save(param1Writer);
/* 1489 */       if (!this.active)
/* 1490 */         return;  param1Writer.write("highMin: " + this.highMin + "\n");
/* 1491 */       param1Writer.write("highMax: " + this.highMax + "\n");
/* 1492 */       param1Writer.write("relative: " + this.relative + "\n");
/* 1493 */       param1Writer.write("scalingCount: " + this.scaling.length + "\n"); byte b;
/* 1494 */       for (b = 0; b < this.scaling.length; b++)
/* 1495 */         param1Writer.write("scaling" + b + ": " + this.scaling[b] + "\n"); 
/* 1496 */       param1Writer.write("timelineCount: " + this.timeline.length + "\n");
/* 1497 */       for (b = 0; b < this.timeline.length; b++)
/* 1498 */         param1Writer.write("timeline" + b + ": " + this.timeline[b] + "\n"); 
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1502 */       super.load(param1BufferedReader);
/* 1503 */       if (!this.active)
/* 1504 */         return;  this.highMin = ParticleEmitter.readFloat(param1BufferedReader, "highMin");
/* 1505 */       this.highMax = ParticleEmitter.readFloat(param1BufferedReader, "highMax");
/* 1506 */       this.relative = ParticleEmitter.readBoolean(param1BufferedReader, "relative");
/* 1507 */       this.scaling = new float[ParticleEmitter.readInt(param1BufferedReader, "scalingCount")]; byte b;
/* 1508 */       for (b = 0; b < this.scaling.length; b++)
/* 1509 */         this.scaling[b] = ParticleEmitter.readFloat(param1BufferedReader, "scaling" + b); 
/* 1510 */       this.timeline = new float[ParticleEmitter.readInt(param1BufferedReader, "timelineCount")];
/* 1511 */       for (b = 0; b < this.timeline.length; b++)
/* 1512 */         this.timeline[b] = ParticleEmitter.readFloat(param1BufferedReader, "timeline" + b); 
/*      */     }
/*      */     
/*      */     public void load(ScaledNumericValue param1ScaledNumericValue) {
/* 1516 */       load(param1ScaledNumericValue);
/* 1517 */       this.highMax = param1ScaledNumericValue.highMax;
/* 1518 */       this.highMin = param1ScaledNumericValue.highMin;
/* 1519 */       this.scaling = new float[param1ScaledNumericValue.scaling.length];
/* 1520 */       System.arraycopy(param1ScaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
/* 1521 */       this.timeline = new float[param1ScaledNumericValue.timeline.length];
/* 1522 */       System.arraycopy(param1ScaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
/* 1523 */       this.relative = param1ScaledNumericValue.relative;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class IndependentScaledNumericValue extends ScaledNumericValue {
/*      */     boolean independent;
/*      */     
/*      */     public boolean isIndependent() {
/* 1531 */       return this.independent;
/*      */     }
/*      */     
/*      */     public void setIndependent(boolean param1Boolean) {
/* 1535 */       this.independent = param1Boolean;
/*      */     }
/*      */     
/*      */     public void set(ParticleEmitter.RangedNumericValue param1RangedNumericValue) {
/* 1539 */       if (param1RangedNumericValue instanceof IndependentScaledNumericValue) {
/* 1540 */         set((IndependentScaledNumericValue)param1RangedNumericValue); return;
/*      */       } 
/* 1542 */       super.set(param1RangedNumericValue);
/*      */     }
/*      */     
/*      */     public void set(ParticleEmitter.ScaledNumericValue param1ScaledNumericValue) {
/* 1546 */       if (param1ScaledNumericValue instanceof IndependentScaledNumericValue) {
/* 1547 */         set((IndependentScaledNumericValue)param1ScaledNumericValue); return;
/*      */       } 
/* 1549 */       super.set(param1ScaledNumericValue);
/*      */     }
/*      */     
/*      */     public void set(IndependentScaledNumericValue param1IndependentScaledNumericValue) {
/* 1553 */       super.set(param1IndependentScaledNumericValue);
/* 1554 */       this.independent = param1IndependentScaledNumericValue.independent;
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1558 */       super.save(param1Writer);
/* 1559 */       param1Writer.write("independent: " + this.independent + "\n");
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1563 */       super.load(param1BufferedReader);
/*      */       
/* 1565 */       if (param1BufferedReader.markSupported()) param1BufferedReader.mark(100); 
/*      */       String str2;
/* 1567 */       if ((str2 = param1BufferedReader.readLine()) == null) throw new IOException("Missing value: independent"); 
/* 1568 */       if (str2.contains("independent")) {
/* 1569 */         this.independent = Boolean.parseBoolean(ParticleEmitter.readString(str2)); return;
/* 1570 */       }  if (param1BufferedReader.markSupported()) {
/* 1571 */         param1BufferedReader.reset();
/*      */         
/*      */         return;
/*      */       } 
/* 1575 */       String str1 = "The loaded particle effect descriptor file uses an old invalid format. Please download the latest version of the Particle Editor tool and recreate the file by loading and saving it again.";
/*      */ 
/*      */       
/* 1578 */       Gdx.app.error("ParticleEmitter", str1);
/* 1579 */       throw new IOException(str1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void load(IndependentScaledNumericValue param1IndependentScaledNumericValue) {
/* 1584 */       load(param1IndependentScaledNumericValue);
/* 1585 */       this.independent = param1IndependentScaledNumericValue.independent;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class GradientColorValue extends ParticleValue {
/* 1590 */     private static float[] temp = new float[4];
/*      */     
/* 1592 */     private float[] colors = new float[] { 1.0F, 1.0F, 1.0F };
/* 1593 */     float[] timeline = new float[] { 0.0F };
/*      */     
/*      */     public GradientColorValue() {
/* 1596 */       this.alwaysActive = true;
/*      */     }
/*      */     
/*      */     public float[] getTimeline() {
/* 1600 */       return this.timeline;
/*      */     }
/*      */     
/*      */     public void setTimeline(float[] param1ArrayOffloat) {
/* 1604 */       this.timeline = param1ArrayOffloat;
/*      */     }
/*      */ 
/*      */     
/*      */     public float[] getColors() {
/* 1609 */       return this.colors;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setColors(float[] param1ArrayOffloat) {
/* 1614 */       this.colors = param1ArrayOffloat;
/*      */     }
/*      */     
/*      */     public float[] getColor(float param1Float) {
/* 1618 */       int i = 0, j = -1;
/*      */       float[] arrayOfFloat;
/* 1620 */       int k = (arrayOfFloat = this.timeline).length;
/* 1621 */       for (byte b = 1; b < k; b++) {
/*      */         float f;
/* 1623 */         if ((f = arrayOfFloat[b]) > param1Float) {
/* 1624 */           j = b;
/*      */           break;
/*      */         } 
/* 1627 */         i = b;
/*      */       } 
/* 1629 */       float f3 = arrayOfFloat[i];
/* 1630 */       i *= 3;
/* 1631 */       float f4 = this.colors[i];
/* 1632 */       float f2 = this.colors[i + 1];
/* 1633 */       float f1 = this.colors[i + 2];
/* 1634 */       if (j == -1) {
/* 1635 */         temp[0] = f4;
/* 1636 */         temp[1] = f2;
/* 1637 */         temp[2] = f1;
/* 1638 */         return temp;
/*      */       } 
/* 1640 */       param1Float = (param1Float - f3) / (arrayOfFloat[j] - f3);
/* 1641 */       j *= 3;
/* 1642 */       temp[0] = f4 + (this.colors[j] - f4) * param1Float;
/* 1643 */       temp[1] = f2 + (this.colors[j + 1] - f2) * param1Float;
/* 1644 */       temp[2] = f1 + (this.colors[j + 2] - f1) * param1Float;
/* 1645 */       return temp;
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1649 */       super.save(param1Writer);
/* 1650 */       if (!this.active)
/* 1651 */         return;  param1Writer.write("colorsCount: " + this.colors.length + "\n"); byte b;
/* 1652 */       for (b = 0; b < this.colors.length; b++)
/* 1653 */         param1Writer.write("colors" + b + ": " + this.colors[b] + "\n"); 
/* 1654 */       param1Writer.write("timelineCount: " + this.timeline.length + "\n");
/* 1655 */       for (b = 0; b < this.timeline.length; b++)
/* 1656 */         param1Writer.write("timeline" + b + ": " + this.timeline[b] + "\n"); 
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1660 */       super.load(param1BufferedReader);
/* 1661 */       if (!this.active)
/* 1662 */         return;  this.colors = new float[ParticleEmitter.readInt(param1BufferedReader, "colorsCount")]; byte b;
/* 1663 */       for (b = 0; b < this.colors.length; b++)
/* 1664 */         this.colors[b] = ParticleEmitter.readFloat(param1BufferedReader, "colors" + b); 
/* 1665 */       this.timeline = new float[ParticleEmitter.readInt(param1BufferedReader, "timelineCount")];
/* 1666 */       for (b = 0; b < this.timeline.length; b++)
/* 1667 */         this.timeline[b] = ParticleEmitter.readFloat(param1BufferedReader, "timeline" + b); 
/*      */     }
/*      */     
/*      */     public void load(GradientColorValue param1GradientColorValue) {
/* 1671 */       load(param1GradientColorValue);
/* 1672 */       this.colors = new float[param1GradientColorValue.colors.length];
/* 1673 */       System.arraycopy(param1GradientColorValue.colors, 0, this.colors, 0, this.colors.length);
/* 1674 */       this.timeline = new float[param1GradientColorValue.timeline.length];
/* 1675 */       System.arraycopy(param1GradientColorValue.timeline, 0, this.timeline, 0, this.timeline.length);
/*      */     } }
/*      */   public static class SpawnShapeValue extends ParticleValue { ParticleEmitter.SpawnShape shape; boolean edges; ParticleEmitter.SpawnEllipseSide side;
/*      */     
/*      */     public SpawnShapeValue() {
/* 1680 */       this.shape = ParticleEmitter.SpawnShape.point;
/*      */       
/* 1682 */       this.side = ParticleEmitter.SpawnEllipseSide.both;
/*      */     }
/*      */     public ParticleEmitter.SpawnShape getShape() {
/* 1685 */       return this.shape;
/*      */     }
/*      */     
/*      */     public void setShape(ParticleEmitter.SpawnShape param1SpawnShape) {
/* 1689 */       this.shape = param1SpawnShape;
/*      */     }
/*      */     
/*      */     public boolean isEdges() {
/* 1693 */       return this.edges;
/*      */     }
/*      */     
/*      */     public void setEdges(boolean param1Boolean) {
/* 1697 */       this.edges = param1Boolean;
/*      */     }
/*      */     
/*      */     public ParticleEmitter.SpawnEllipseSide getSide() {
/* 1701 */       return this.side;
/*      */     }
/*      */     
/*      */     public void setSide(ParticleEmitter.SpawnEllipseSide param1SpawnEllipseSide) {
/* 1705 */       this.side = param1SpawnEllipseSide;
/*      */     }
/*      */     
/*      */     public void save(Writer param1Writer) {
/* 1709 */       super.save(param1Writer);
/* 1710 */       if (!this.active)
/* 1711 */         return;  param1Writer.write("shape: " + this.shape + "\n");
/* 1712 */       if (this.shape == ParticleEmitter.SpawnShape.ellipse) {
/* 1713 */         param1Writer.write("edges: " + this.edges + "\n");
/* 1714 */         param1Writer.write("side: " + this.side + "\n");
/*      */       } 
/*      */     }
/*      */     
/*      */     public void load(BufferedReader param1BufferedReader) {
/* 1719 */       super.load(param1BufferedReader);
/* 1720 */       if (!this.active)
/* 1721 */         return;  this.shape = ParticleEmitter.SpawnShape.valueOf(ParticleEmitter.readString(param1BufferedReader, "shape"));
/* 1722 */       if (this.shape == ParticleEmitter.SpawnShape.ellipse) {
/* 1723 */         this.edges = ParticleEmitter.readBoolean(param1BufferedReader, "edges");
/* 1724 */         this.side = ParticleEmitter.SpawnEllipseSide.valueOf(ParticleEmitter.readString(param1BufferedReader, "side"));
/*      */       } 
/*      */     }
/*      */     
/*      */     public void load(SpawnShapeValue param1SpawnShapeValue) {
/* 1729 */       load(param1SpawnShapeValue);
/* 1730 */       this.shape = param1SpawnShapeValue.shape;
/* 1731 */       this.edges = param1SpawnShapeValue.edges;
/* 1732 */       this.side = param1SpawnShapeValue.side;
/*      */     } }
/*      */ 
/*      */   
/*      */   public enum SpawnShape {
/* 1737 */     point, line, square, ellipse;
/*      */   }
/*      */   
/*      */   public enum SpawnEllipseSide {
/* 1741 */     both, top, bottom;
/*      */   }
/*      */   
/*      */   public enum SpriteMode {
/* 1745 */     single, random, animated;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g2d\ParticleEmitter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */