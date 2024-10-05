/*     */ package com.badlogic.gdx.graphics.g3d.particles.influencers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParallelArray;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleChannels;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleController;
/*     */ import com.badlogic.gdx.graphics.g3d.particles.ParticleControllerComponent;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import java.util.Arrays;
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
/*     */ public class DynamicsInfluencer
/*     */   extends Influencer
/*     */ {
/*     */   public Array<DynamicsModifier> velocities;
/*     */   private ParallelArray.FloatChannel accellerationChannel;
/*     */   private ParallelArray.FloatChannel positionChannel;
/*     */   private ParallelArray.FloatChannel previousPositionChannel;
/*     */   private ParallelArray.FloatChannel rotationChannel;
/*     */   private ParallelArray.FloatChannel angularVelocityChannel;
/*     */   boolean hasAcceleration;
/*     */   boolean has2dAngularVelocity;
/*     */   boolean has3dAngularVelocity;
/*     */   
/*     */   public DynamicsInfluencer() {
/*  37 */     this.velocities = new Array(true, 3, DynamicsModifier.class);
/*     */   }
/*     */   
/*     */   public DynamicsInfluencer(DynamicsModifier... paramVarArgs) {
/*  41 */     this.velocities = new Array(true, paramVarArgs.length, DynamicsModifier.class); int i; byte b;
/*  42 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { DynamicsModifier dynamicsModifier = paramVarArgs[b];
/*  43 */       this.velocities.add(dynamicsModifier.copy());
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public DynamicsInfluencer(DynamicsInfluencer paramDynamicsInfluencer) {
/*  48 */     this((DynamicsModifier[])paramDynamicsInfluencer.velocities.toArray(DynamicsModifier.class));
/*     */   }
/*     */ 
/*     */   
/*     */   public void allocateChannels() {
/*  53 */     for (byte b = 0; b < this.velocities.size; b++) {
/*  54 */       ((DynamicsModifier[])this.velocities.items)[b].allocateChannels();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  59 */     this.accellerationChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.Acceleration);
/*  60 */     this.hasAcceleration = (this.accellerationChannel != null);
/*  61 */     if (this.hasAcceleration) {
/*  62 */       this.positionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Position);
/*  63 */       this.previousPositionChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.PreviousPosition);
/*     */     } 
/*     */ 
/*     */     
/*  67 */     this.angularVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.AngularVelocity2D);
/*  68 */     this.has2dAngularVelocity = (this.angularVelocityChannel != null);
/*  69 */     if (this.has2dAngularVelocity) {
/*  70 */       this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation2D);
/*  71 */       this.has3dAngularVelocity = false; return;
/*     */     } 
/*  73 */     this.angularVelocityChannel = (ParallelArray.FloatChannel)this.controller.particles.getChannel(ParticleChannels.AngularVelocity3D);
/*  74 */     this.has3dAngularVelocity = (this.angularVelocityChannel != null);
/*  75 */     if (this.has3dAngularVelocity) this.rotationChannel = (ParallelArray.FloatChannel)this.controller.particles.addChannel(ParticleChannels.Rotation3D);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(ParticleController paramParticleController) {
/*  81 */     super.set(paramParticleController);
/*  82 */     for (byte b = 0; b < this.velocities.size; b++) {
/*  83 */       ((DynamicsModifier[])this.velocities.items)[b].set(paramParticleController);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/*  89 */     for (byte b = 0; b < this.velocities.size; b++) {
/*  90 */       ((DynamicsModifier[])this.velocities.items)[b].init();
/*     */     }
/*     */   }
/*     */   
/*     */   public void activateParticles(int paramInt1, int paramInt2) {
/*  95 */     if (this.hasAcceleration) {
/*     */       int i;
/*     */ 
/*     */       
/*  99 */       for (int j = (i = paramInt1 * this.positionChannel.strideSize) + paramInt2 * this.positionChannel.strideSize; i < j; i += this.positionChannel.strideSize) {
/* 100 */         this.previousPositionChannel.data[i] = this.positionChannel.data[i];
/* 101 */         this.previousPositionChannel.data[i + 1] = this.positionChannel.data[i + 1];
/* 102 */         this.previousPositionChannel.data[i + 2] = this.positionChannel.data[i + 2];
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     if (this.has2dAngularVelocity) {
/*     */       int i;
/*     */       
/* 114 */       for (int j = (i = paramInt1 * this.rotationChannel.strideSize) + paramInt2 * this.rotationChannel.strideSize; i < j; i += this.rotationChannel.strideSize) {
/* 115 */         this.rotationChannel.data[i] = 1.0F;
/* 116 */         this.rotationChannel.data[i + 1] = 0.0F;
/*     */       } 
/* 118 */     } else if (this.has3dAngularVelocity) {
/*     */       int i;
/*     */       
/* 121 */       for (int j = (i = paramInt1 * this.rotationChannel.strideSize) + paramInt2 * this.rotationChannel.strideSize; i < j; i += this.rotationChannel.strideSize) {
/* 122 */         this.rotationChannel.data[i] = 0.0F;
/* 123 */         this.rotationChannel.data[i + 1] = 0.0F;
/* 124 */         this.rotationChannel.data[i + 2] = 0.0F;
/* 125 */         this.rotationChannel.data[i + 3] = 1.0F;
/*     */       } 
/*     */     } 
/*     */     
/* 129 */     for (byte b = 0; b < this.velocities.size; b++) {
/* 130 */       ((DynamicsModifier[])this.velocities.items)[b].activateParticles(paramInt1, paramInt2);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 136 */     if (this.hasAcceleration)
/* 137 */       Arrays.fill(this.accellerationChannel.data, 0, this.controller.particles.size * this.accellerationChannel.strideSize, 0.0F); 
/* 138 */     if (this.has2dAngularVelocity || this.has3dAngularVelocity) {
/* 139 */       Arrays.fill(this.angularVelocityChannel.data, 0, this.controller.particles.size * this.angularVelocityChannel.strideSize, 0.0F);
/*     */     }
/*     */     byte b;
/* 142 */     for (b = 0; b < this.velocities.size; b++) {
/* 143 */       ((DynamicsModifier[])this.velocities.items)[b].update();
/*     */     }
/*     */ 
/*     */     
/* 147 */     if (this.hasAcceleration) {
/*     */       int i;
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
/* 161 */       for (b = 0, i = 0; b < this.controller.particles.size; b++, i += this.positionChannel.strideSize) {
/* 162 */         float f1 = this.positionChannel.data[i];
/* 163 */         float f2 = this.positionChannel.data[i + 1];
/* 164 */         float f3 = this.positionChannel.data[i + 2];
/* 165 */         this.positionChannel.data[i] = f1 * 2.0F - this.previousPositionChannel.data[i] + this.accellerationChannel.data[i] * this.controller.deltaTimeSqr;
/*     */ 
/*     */         
/* 168 */         this.positionChannel.data[i + 1] = f2 * 2.0F - this.previousPositionChannel.data[i + 1] + this.accellerationChannel.data[i + 1] * this.controller.deltaTimeSqr;
/*     */ 
/*     */         
/* 171 */         this.positionChannel.data[i + 2] = f3 * 2.0F - this.previousPositionChannel.data[i + 2] + this.accellerationChannel.data[i + 2] * this.controller.deltaTimeSqr;
/*     */ 
/*     */         
/* 174 */         this.previousPositionChannel.data[i] = f1;
/* 175 */         this.previousPositionChannel.data[i + 1] = f2;
/* 176 */         this.previousPositionChannel.data[i + 2] = f3;
/*     */       } 
/*     */     } 
/*     */     
/* 180 */     if (this.has2dAngularVelocity) {
/* 181 */       int i; for (b = 0, i = 0; b < this.controller.particles.size; b++, i += this.rotationChannel.strideSize) {
/*     */         float f;
/* 183 */         if ((f = this.angularVelocityChannel.data[b] * this.controller.deltaTime) != 0.0F) {
/* 184 */           float f1 = MathUtils.cosDeg(f), f2 = MathUtils.sinDeg(f);
/* 185 */           float f3 = this.rotationChannel.data[i];
/* 186 */           float f4 = this.rotationChannel.data[i + 1];
/* 187 */           float f5 = f3 * f1 - f4 * f2;
/* 188 */           float f6 = f4 * f1 + f3 * f2;
/* 189 */           this.rotationChannel.data[i] = f5;
/* 190 */           this.rotationChannel.data[i + 1] = f6;
/*     */         } 
/*     */       }  return;
/* 193 */     }  if (this.has3dAngularVelocity) {
/* 194 */       b = 0; int i = 0;
/* 195 */       for (int j = 0; b < this.controller.particles.size; b++, i += this.rotationChannel.strideSize, j += this.angularVelocityChannel.strideSize) {
/*     */         
/* 197 */         float f1 = this.angularVelocityChannel.data[j];
/* 198 */         float f2 = this.angularVelocityChannel.data[j + 1];
/* 199 */         float f3 = this.angularVelocityChannel.data[j + 2];
/* 200 */         float f4 = this.rotationChannel.data[i];
/* 201 */         float f5 = this.rotationChannel.data[i + 1];
/* 202 */         float f6 = this.rotationChannel.data[i + 2];
/* 203 */         float f7 = this.rotationChannel.data[i + 3];
/* 204 */         TMP_Q.set(f1, f2, f3, 0.0F).mul(f4, f5, f6, f7).mul(0.5F * this.controller.deltaTime).add(f4, f5, f6, f7).nor();
/* 205 */         this.rotationChannel.data[i] = TMP_Q.x;
/* 206 */         this.rotationChannel.data[i + 1] = TMP_Q.y;
/* 207 */         this.rotationChannel.data[i + 2] = TMP_Q.z;
/* 208 */         this.rotationChannel.data[i + 3] = TMP_Q.w;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public DynamicsInfluencer copy() {
/* 215 */     return new DynamicsInfluencer(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(Json paramJson) {
/* 220 */     paramJson.writeValue("velocities", this.velocities, Array.class, DynamicsModifier.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json paramJson, JsonValue paramJsonValue) {
/* 225 */     this.velocities.addAll((Array)paramJson.readValue("velocities", Array.class, DynamicsModifier.class, paramJsonValue));
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\influencers\DynamicsInfluencer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */