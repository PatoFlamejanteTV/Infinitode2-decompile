/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Quaternion;
/*     */ import com.badlogic.gdx.math.Vector3;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
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
/*     */ public abstract class DynamicsModifier
/*     */   extends Influencer
/*     */ {
/*  35 */   protected static final Vector3 TMP_V1 = new Vector3(); protected static final Vector3 TMP_V2 = new Vector3(); protected static final Vector3 TMP_V3 = new Vector3();
/*  36 */   protected static final Quaternion TMP_Q = new Quaternion();
/*     */   
/*     */   public static class FaceDirection extends DynamicsModifier {
/*     */     ParallelArray.FloatChannel rotationChannel;
/*     */     ParallelArray.FloatChannel accellerationChannel;
/*     */     
/*     */     public FaceDirection() {}
/*     */     
/*     */     public FaceDirection(FaceDirection param1FaceDirection) {
/*  45 */       super(param1FaceDirection);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/*  50 */       this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
/*  51 */       this.accellerationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/*  56 */       int i = 0, j = 0, k = 0 + this.controller.particles.size * this.rotationChannel.strideSize;
/*  57 */       for (; i < k; i += this.rotationChannel.strideSize, j += this.accellerationChannel.strideSize) {
/*     */ 
/*     */ 
/*     */         
/*  61 */         Vector3 vector31 = TMP_V1.set(this.accellerationChannel.data[j], this.accellerationChannel.data[j + 1], this.accellerationChannel.data[j + 2]).nor();
/*  62 */         Vector3 vector32 = TMP_V2.set(TMP_V1).crs(Vector3.Y).nor().crs(TMP_V1).nor(), vector33 = TMP_V3.set(vector32).crs(vector31).nor();
/*  63 */         TMP_Q.setFromAxes(false, vector33.x, vector32.x, vector31.x, vector33.y, vector32.y, vector31.y, vector33.z, vector32.z, vector31.z);
/*  64 */         this.rotationChannel.data[i] = TMP_Q.x;
/*  65 */         this.rotationChannel.data[i + 1] = TMP_Q.y;
/*  66 */         this.rotationChannel.data[i + 2] = TMP_Q.z;
/*  67 */         this.rotationChannel.data[i + 3] = TMP_Q.w;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ParticleControllerComponent copy() {
/*  73 */       return new FaceDirection(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class Strength extends DynamicsModifier {
/*     */     protected ParallelArray.FloatChannel strengthChannel;
/*     */     public ScaledNumericValue strengthValue;
/*     */     
/*     */     public Strength() {
/*  82 */       this.strengthValue = new ScaledNumericValue();
/*     */     }
/*     */     
/*     */     public Strength(Strength param1Strength) {
/*  86 */       super(param1Strength);
/*  87 */       this.strengthValue = new ScaledNumericValue();
/*  88 */       this.strengthValue.load(param1Strength.strengthValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/*  93 */       super.allocateChannels();
/*  94 */       ParticleChannels.Interpolation.id = this.controller.particleChannels.newId();
/*  95 */       this.strengthChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/*     */       int i;
/* 102 */       for (int j = (i = param1Int1 * this.strengthChannel.strideSize) + param1Int2 * this.strengthChannel.strideSize; i < j; i += this.strengthChannel.strideSize) {
/* 103 */         float f1 = this.strengthValue.newLowValue();
/* 104 */         float f2 = this.strengthValue.newHighValue();
/* 105 */         if (!this.strengthValue.isRelative()) f2 -= f1; 
/* 106 */         this.strengthChannel.data[i] = f1;
/* 107 */         this.strengthChannel.data[i + 1] = f2;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Json param1Json) {
/* 113 */       super.write(param1Json);
/* 114 */       param1Json.writeValue("strengthValue", this.strengthValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Json param1Json, JsonValue param1JsonValue) {
/* 119 */       super.read(param1Json, param1JsonValue);
/* 120 */       this.strengthValue = (ScaledNumericValue)param1Json.readValue("strengthValue", ScaledNumericValue.class, param1JsonValue);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class Angular
/*     */     extends Strength
/*     */   {
/*     */     protected ParallelArray.FloatChannel angularChannel;
/*     */     public ScaledNumericValue thetaValue;
/*     */     public ScaledNumericValue phiValue;
/*     */     
/*     */     public Angular() {
/* 132 */       this.thetaValue = new ScaledNumericValue();
/* 133 */       this.phiValue = new ScaledNumericValue();
/*     */     }
/*     */     
/*     */     public Angular(Angular param1Angular) {
/* 137 */       super(param1Angular);
/* 138 */       this.thetaValue = new ScaledNumericValue();
/* 139 */       this.phiValue = new ScaledNumericValue();
/* 140 */       this.thetaValue.load(param1Angular.thetaValue);
/* 141 */       this.phiValue.load(param1Angular.phiValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 146 */       super.allocateChannels();
/* 147 */       ParticleChannels.Interpolation4.id = this.controller.particleChannels.newId();
/* 148 */       this.angularChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Interpolation4);
/*     */     }
/*     */ 
/*     */     
/*     */     public void activateParticles(int param1Int1, int param1Int2) {
/* 153 */       super.activateParticles(param1Int1, param1Int2);
/*     */       
/*     */       int i;
/* 156 */       for (int j = (i = param1Int1 * this.angularChannel.strideSize) + param1Int2 * this.angularChannel.strideSize; i < j; i += this.angularChannel.strideSize) {
/*     */ 
/*     */         
/* 159 */         float f1 = this.thetaValue.newLowValue();
/* 160 */         float f2 = this.thetaValue.newHighValue();
/* 161 */         if (!this.thetaValue.isRelative()) f2 -= f1; 
/* 162 */         this.angularChannel.data[i] = f1;
/* 163 */         this.angularChannel.data[i + 1] = f2;
/*     */ 
/*     */         
/* 166 */         f1 = this.phiValue.newLowValue();
/* 167 */         f2 = this.phiValue.newHighValue();
/* 168 */         if (!this.phiValue.isRelative()) f2 -= f1; 
/* 169 */         this.angularChannel.data[i + 2] = f1;
/* 170 */         this.angularChannel.data[i + 3] = f2;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(Json param1Json) {
/* 176 */       super.write(param1Json);
/* 177 */       param1Json.writeValue("thetaValue", this.thetaValue);
/* 178 */       param1Json.writeValue("phiValue", this.phiValue);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Json param1Json, JsonValue param1JsonValue) {
/* 183 */       super.read(param1Json, param1JsonValue);
/* 184 */       this.thetaValue = (ScaledNumericValue)param1Json.readValue("thetaValue", ScaledNumericValue.class, param1JsonValue);
/* 185 */       this.phiValue = (ScaledNumericValue)param1Json.readValue("phiValue", ScaledNumericValue.class, param1JsonValue);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Rotational2D
/*     */     extends Strength {
/*     */     ParallelArray.FloatChannel rotationalVelocity2dChannel;
/*     */     
/*     */     public Rotational2D() {}
/*     */     
/*     */     public Rotational2D(Rotational2D param1Rotational2D) {
/* 196 */       super(param1Rotational2D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 201 */       super.allocateChannels();
/* 202 */       this.rotationalVelocity2dChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.AngularVelocity2D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 207 */       int i = 0, j = 2, k = 0, m = 0 + this.controller.particles.size * this.rotationalVelocity2dChannel.strideSize;
/* 208 */       for (; i < m; k += this.strengthChannel.strideSize, i += this.rotationalVelocity2dChannel.strideSize, j += this.lifeChannel.strideSize) {
/* 209 */         this.rotationalVelocity2dChannel.data[i] = this.rotationalVelocity2dChannel.data[i] + this.strengthChannel.data[k] + this.strengthChannel.data[k + 1] * this.strengthValue
/*     */           
/* 211 */           .getScale(this.lifeChannel.data[j]);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public Rotational2D copy() {
/* 217 */       return new Rotational2D(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Rotational3D extends Angular {
/*     */     ParallelArray.FloatChannel rotationChannel;
/*     */     ParallelArray.FloatChannel rotationalForceChannel;
/*     */     
/*     */     public Rotational3D() {}
/*     */     
/*     */     public Rotational3D(Rotational3D param1Rotational3D) {
/* 228 */       super(param1Rotational3D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 233 */       super.allocateChannels();
/* 234 */       this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
/* 235 */       this.rotationalForceChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.AngularVelocity3D);
/*     */     }
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
/*     */ 
/*     */     
/*     */     public void update() {
/* 266 */       int i = 0, j = 2, k = 0, m = 0, n = this.controller.particles.size * this.rotationalForceChannel.strideSize;
/* 267 */       for (; i < n; k += this.strengthChannel.strideSize, i += this.rotationalForceChannel.strideSize, m += this.angularChannel.strideSize, j += this.lifeChannel.strideSize) {
/*     */         
/* 269 */         float f1 = this.lifeChannel.data[j];
/*     */         
/* 271 */         float f2 = this.strengthChannel.data[k] + this.strengthChannel.data[k + 1] * this.strengthValue.getScale(f1);
/*     */         
/* 273 */         float f3 = this.angularChannel.data[m + 2] + this.angularChannel.data[m + 3] * this.phiValue.getScale(f1);
/*     */ 
/*     */ 
/*     */         
/* 277 */         float f4 = MathUtils.cosDeg(f1 = this.angularChannel.data[m] + this.angularChannel.data[m + 1] * this.thetaValue.getScale(f1)); f1 = MathUtils.sinDeg(f1); float f5 = MathUtils.cosDeg(f3);
/* 278 */         f3 = MathUtils.sinDeg(f3);
/*     */         
/* 280 */         TMP_V3.set(f4 * f3, f5, f1 * f3);
/* 281 */         TMP_V3.scl(f2 * 0.017453292F);
/*     */         
/* 283 */         this.rotationalForceChannel.data[i] = this.rotationalForceChannel.data[i] + TMP_V3.x;
/* 284 */         this.rotationalForceChannel.data[i + 1] = this.rotationalForceChannel.data[i + 1] + TMP_V3.y;
/* 285 */         this.rotationalForceChannel.data[i + 2] = this.rotationalForceChannel.data[i + 2] + TMP_V3.z;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public Rotational3D copy() {
/* 291 */       return new Rotational3D(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class CentripetalAcceleration
/*     */     extends Strength {
/*     */     ParallelArray.FloatChannel accelerationChannel;
/*     */     ParallelArray.FloatChannel positionChannel;
/*     */     
/*     */     public CentripetalAcceleration() {}
/*     */     
/*     */     public CentripetalAcceleration(CentripetalAcceleration param1CentripetalAcceleration) {
/* 303 */       super(param1CentripetalAcceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 308 */       super.allocateChannels();
/* 309 */       this.accelerationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
/* 310 */       this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 315 */       float f1 = 0.0F, f2 = 0.0F, f3 = 0.0F;
/* 316 */       if (!this.isGlobal) {
/*     */         float[] arrayOfFloat;
/* 318 */         f1 = (arrayOfFloat = this.controller.transform.val)[12];
/* 319 */         f2 = arrayOfFloat[13];
/* 320 */         f3 = arrayOfFloat[14];
/*     */       } 
/*     */       
/* 323 */       int i = 2, j = 0, k = 0, m = 0;
/* 324 */       byte b = 0;
/* 325 */       for (int n = this.controller.particles.size; b < n; b++, k += this.positionChannel.strideSize, j += this.strengthChannel.strideSize, m += this.accelerationChannel.strideSize, i += this.lifeChannel.strideSize) {
/*     */ 
/*     */ 
/*     */         
/* 329 */         float f = this.strengthChannel.data[j] + this.strengthChannel.data[j + 1] * this.strengthValue.getScale(this.lifeChannel.data[i]);
/* 330 */         TMP_V3.set(this.positionChannel.data[k] - f1, this.positionChannel.data[k + 1] - f2, this.positionChannel.data[k + 2] - f3)
/*     */           
/* 332 */           .nor().scl(f);
/* 333 */         this.accelerationChannel.data[m] = this.accelerationChannel.data[m] + TMP_V3.x;
/* 334 */         this.accelerationChannel.data[m + 1] = this.accelerationChannel.data[m + 1] + TMP_V3.y;
/* 335 */         this.accelerationChannel.data[m + 2] = this.accelerationChannel.data[m + 2] + TMP_V3.z;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public CentripetalAcceleration copy() {
/* 341 */       return new CentripetalAcceleration(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PolarAcceleration
/*     */     extends Angular {
/*     */     ParallelArray.FloatChannel directionalVelocityChannel;
/*     */     
/*     */     public PolarAcceleration() {}
/*     */     
/*     */     public PolarAcceleration(PolarAcceleration param1PolarAcceleration) {
/* 352 */       super(param1PolarAcceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 357 */       super.allocateChannels();
/* 358 */       this.directionalVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 363 */       int i = 0, j = 2, k = 0, m = 0, n = 0 + this.controller.particles.size * this.directionalVelocityChannel.strideSize;
/* 364 */       for (; i < n; k += this.strengthChannel.strideSize, i += this.directionalVelocityChannel.strideSize, m += this.angularChannel.strideSize, j += this.lifeChannel.strideSize) {
/*     */         
/* 366 */         float f1 = this.lifeChannel.data[j];
/*     */         
/* 368 */         float f2 = this.strengthChannel.data[k] + this.strengthChannel.data[k + 1] * this.strengthValue.getScale(f1);
/*     */         
/* 370 */         float f3 = this.angularChannel.data[m + 2] + this.angularChannel.data[m + 3] * this.phiValue.getScale(f1);
/*     */ 
/*     */ 
/*     */         
/* 374 */         float f4 = MathUtils.cosDeg(f1 = this.angularChannel.data[m] + this.angularChannel.data[m + 1] * this.thetaValue.getScale(f1)); f1 = MathUtils.sinDeg(f1); float f5 = MathUtils.cosDeg(f3);
/* 375 */         f3 = MathUtils.sinDeg(f3);
/* 376 */         TMP_V3.set(f4 * f3, f5, f1 * f3).nor().scl(f2);
/*     */         
/* 378 */         if (!this.isGlobal) {
/* 379 */           this.controller.transform.getRotation(TMP_Q, true);
/* 380 */           TMP_V3.mul(TMP_Q);
/*     */         } 
/*     */         
/* 383 */         this.directionalVelocityChannel.data[i] = this.directionalVelocityChannel.data[i] + TMP_V3.x;
/* 384 */         this.directionalVelocityChannel.data[i + 1] = this.directionalVelocityChannel.data[i + 1] + TMP_V3.y;
/* 385 */         this.directionalVelocityChannel.data[i + 2] = this.directionalVelocityChannel.data[i + 2] + TMP_V3.z;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public PolarAcceleration copy() {
/* 391 */       return new PolarAcceleration(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TangentialAcceleration extends Angular {
/*     */     ParallelArray.FloatChannel directionalVelocityChannel;
/*     */     ParallelArray.FloatChannel positionChannel;
/*     */     
/*     */     public TangentialAcceleration() {}
/*     */     
/*     */     public TangentialAcceleration(TangentialAcceleration param1TangentialAcceleration) {
/* 402 */       super(param1TangentialAcceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 407 */       super.allocateChannels();
/* 408 */       this.directionalVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
/* 409 */       this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 414 */       int i = 0, j = 2, k = 0, m = 0, n = 0;
/* 415 */       int i1 = 0 + this.controller.particles.size * this.directionalVelocityChannel.strideSize;
/* 416 */       for (; i < i1; k += this.strengthChannel.strideSize, i += this.directionalVelocityChannel.strideSize, m += this.angularChannel.strideSize, j += this.lifeChannel.strideSize, n += this.positionChannel.strideSize) {
/*     */         
/* 418 */         float f1 = this.lifeChannel.data[j];
/*     */         
/* 420 */         float f2 = this.strengthChannel.data[k] + this.strengthChannel.data[k + 1] * this.strengthValue.getScale(f1);
/*     */         
/* 422 */         float f3 = this.angularChannel.data[m + 2] + this.angularChannel.data[m + 3] * this.phiValue.getScale(f1);
/*     */ 
/*     */ 
/*     */         
/* 426 */         float f4 = MathUtils.cosDeg(f1 = this.angularChannel.data[m] + this.angularChannel.data[m + 1] * this.thetaValue.getScale(f1)); f1 = MathUtils.sinDeg(f1); float f5 = MathUtils.cosDeg(f3);
/* 427 */         f3 = MathUtils.sinDeg(f3);
/* 428 */         TMP_V3.set(f4 * f3, f5, f1 * f3);
/* 429 */         TMP_V1.set(this.positionChannel.data[n], this.positionChannel.data[n + 1], this.positionChannel.data[n + 2]);
/*     */ 
/*     */         
/* 432 */         if (!this.isGlobal) {
/* 433 */           this.controller.transform.getTranslation(TMP_V2);
/* 434 */           TMP_V1.sub(TMP_V2);
/* 435 */           this.controller.transform.getRotation(TMP_Q, true);
/* 436 */           TMP_V3.mul(TMP_Q);
/*     */         } 
/* 438 */         TMP_V3.crs(TMP_V1).nor().scl(f2);
/* 439 */         this.directionalVelocityChannel.data[i] = this.directionalVelocityChannel.data[i] + TMP_V3.x;
/* 440 */         this.directionalVelocityChannel.data[i + 1] = this.directionalVelocityChannel.data[i + 1] + TMP_V3.y;
/* 441 */         this.directionalVelocityChannel.data[i + 2] = this.directionalVelocityChannel.data[i + 2] + TMP_V3.z;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public TangentialAcceleration copy() {
/* 447 */       return new TangentialAcceleration(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BrownianAcceleration
/*     */     extends Strength {
/*     */     ParallelArray.FloatChannel accelerationChannel;
/*     */     
/*     */     public BrownianAcceleration() {}
/*     */     
/*     */     public BrownianAcceleration(BrownianAcceleration param1BrownianAcceleration) {
/* 458 */       super(param1BrownianAcceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void allocateChannels() {
/* 463 */       super.allocateChannels();
/* 464 */       this.accelerationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Acceleration);
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 469 */       int i = 2, j = 0, k = 0;
/* 470 */       byte b = 0;
/* 471 */       for (int m = this.controller.particles.size; b < m; b++, j += this.strengthChannel.strideSize, k += this.accelerationChannel.strideSize, i += this.lifeChannel.strideSize) {
/*     */ 
/*     */ 
/*     */         
/* 475 */         float f = this.strengthChannel.data[j] + this.strengthChannel.data[j + 1] * this.strengthValue.getScale(this.lifeChannel.data[i]);
/* 476 */         TMP_V3.set(MathUtils.random(-1.0F, 1.0F), MathUtils.random(-1.0F, 1.0F), MathUtils.random(-1.0F, 1.0F)).nor().scl(f);
/* 477 */         this.accelerationChannel.data[k] = this.accelerationChannel.data[k] + TMP_V3.x;
/* 478 */         this.accelerationChannel.data[k + 1] = this.accelerationChannel.data[k + 1] + TMP_V3.y;
/* 479 */         this.accelerationChannel.data[k + 2] = this.accelerationChannel.data[k + 2] + TMP_V3.z;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public BrownianAcceleration copy() {
/* 485 */       return new BrownianAcceleration(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isGlobal = false;
/*     */   
/*     */   protected ParallelArray.FloatChannel lifeChannel;
/*     */   
/*     */   public DynamicsModifier() {}
/*     */   
/*     */   public DynamicsModifier(DynamicsModifier paramDynamicsModifier) {
/* 496 */     this.isGlobal = paramDynamicsModifier.isGlobal;
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/* 501 */     this.lifeChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Life);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 506 */     super.write(paramJson);
/* 507 */     paramJson.writeValue("isGlobal", Boolean.valueOf(this.isGlobal));
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 512 */     super.read(paramJson, paramJsonValue);
/* 513 */     this.isGlobal = ((Boolean)paramJson.readValue("isGlobal", boolean.class, paramJsonValue)).booleanValue();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\DynamicsModifier.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */