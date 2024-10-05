/*     */ package com.prineside.tdi2.projectiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyFollowingProjectile;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.towers.AirTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class AirProjectile extends EnemyFollowingProjectile {
/*  23 */   private static final Color d = new Color(MaterialColor.CYAN.P500.r, MaterialColor.CYAN.P500.g, MaterialColor.CYAN.P500.b, 0.56F);
/*     */   
/*     */   private AirTower e;
/*     */   
/*     */   private float f;
/*     */   
/*     */   private float g;
/*     */   private float h;
/*     */   @NAGS
/*     */   private TrailMultiLine i;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  35 */     super.write(paramKryo, paramOutput);
/*  36 */     paramKryo.writeClassAndObject(paramOutput, this.e);
/*  37 */     paramOutput.writeFloat(this.f);
/*  38 */     paramOutput.writeFloat(this.g);
/*  39 */     paramOutput.writeFloat(this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  44 */     super.read(paramKryo, paramInput);
/*  45 */     this.e = (AirTower)paramKryo.readClassAndObject(paramInput);
/*  46 */     this.f = paramInput.readFloat();
/*  47 */     this.g = paramInput.readFloat();
/*  48 */     this.h = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private AirProjectile() {
/*  52 */     super(ProjectileType.AIR);
/*     */   }
/*     */   
/*     */   public final void setup(AirTower paramAirTower, Enemy paramEnemy, float paramFloat1, Vector2 paramVector2, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {
/*  56 */     this.e = paramAirTower;
/*  57 */     this.c = paramFloat1;
/*  58 */     this.f = paramFloat3;
/*  59 */     this.g = paramFloat4;
/*  60 */     this.h = paramFloat5;
/*     */     
/*  62 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  63 */       this.i = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  64 */       this.i.setup(d, 15.0F, 0.4F, 0.0F);
/*  65 */       this.i.setStartPoint(paramVector2.x, paramVector2.y);
/*  66 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.i);
/*     */     } 
/*     */     
/*  69 */     setup(paramVector2, paramEnemy, paramFloat2);
/*     */   }
/*     */   
/*     */   public final float getBurnChance() {
/*  73 */     return this.f;
/*     */   }
/*     */   
/*     */   public final float getBurningTime() {
/*  77 */     return this.h;
/*     */   }
/*     */   
/*     */   public final float getBurnDamage() {
/*  81 */     return this.g;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  86 */     super.setUnregistered();
/*  87 */     if (this.i != null) {
/*  88 */       this.i.allowCompletion();
/*  89 */       this.i = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  95 */     super.reset();
/*     */     
/*  97 */     this.e = null;
/*  98 */     this.i = null;
/*  99 */     this.f = 0.0F;
/* 100 */     this.g = 0.0F;
/* 101 */     this.h = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hit() {
/* 106 */     super.hit();
/*     */     
/*     */     Enemy enemy;
/* 109 */     if ((enemy = getTarget()) != null) {
/* 110 */       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.c, DamageType.BULLET).setTower((Tower)this.e).setProjectile((Projectile)this));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 116 */     if (this.i != null) {
/* 117 */       this.i.setHeadPosition(this.drawPosition.x, this.drawPosition.y);
/*     */     }
/*     */     
/* 120 */     paramBatch.draw(this.S.projectile.F.AIR.a, this.drawPosition.x - 9.0F, this.drawPosition.y - 9.0F, 18.0F, 18.0F);
/*     */     
/* 122 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class AirProjectileFactory
/*     */     extends Projectile.Factory<AirProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 131 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-air");
/* 132 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static AirProjectile b() {
/* 137 */       return new AirProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\AirProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */