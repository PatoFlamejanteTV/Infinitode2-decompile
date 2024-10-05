/*     */ package com.prineside.tdi2.units;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Animation;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.projectiles.ChainLightningProjectile;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class BallLightningUnit
/*     */   extends Unit
/*     */ {
/*     */   private float a;
/*     */   private Tower b;
/*     */   private float c;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  31 */     super.write(paramKryo, paramOutput);
/*  32 */     paramOutput.writeFloat(this.a);
/*  33 */     paramKryo.writeClassAndObject(paramOutput, this.b);
/*  34 */     paramOutput.writeFloat(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  39 */     super.read(paramKryo, paramInput);
/*  40 */     this.a = paramInput.readFloat();
/*  41 */     this.b = (Tower)paramKryo.readClassAndObject(paramInput);
/*  42 */     this.c = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private BallLightningUnit() {
/*  46 */     super(UnitType.BALL_LIGHTNING);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat) {
/*  50 */     this.drawOverEnemies = true;
/*     */     
/*  52 */     this.b = paramTower;
/*  53 */     this.c = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  58 */     TextureRegion textureRegion = (TextureRegion)Game.i.unitManager.F.BALL_LIGHTNING.a.getKeyFrame(this.a, true);
/*  59 */     paramBatch.draw(textureRegion, this.drawPosition.x - 32.0F, this.drawPosition.y - 32.0F, 32.0F, 32.0F, 64.0F, 64.0F, 1.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  64 */     this.a += paramFloat;
/*     */     
/*  66 */     this.S.map.getEnemiesInCircleV(this.position, 32.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */           Enemy enemy;
/*     */           if ((enemy = paramEnemyReference.enemy) == null || !enemy.isVulnerableTo(DamageType.ELECTRICITY)) {
/*     */             return true;
/*     */           }
/*     */           ChainLightningProjectile chainLightningProjectile = (ChainLightningProjectile)this.S.projectile.F.CHAIN_LIGHTNING.obtain();
/*     */           this.S.projectile.register((Projectile)chainLightningProjectile);
/*     */           chainLightningProjectile.setup(this.b, enemy, this.c, this.c * 0.1F, 0.9F, 16.0F, this.position);
/*     */           this.S.unit.killUnit(this, enemy);
/*     */           return false;
/*     */         });
/*     */   }
/*     */   
/*     */   public static class BallLightningUnitFactory
/*     */     extends Unit.Factory.BasicAbstractFactory<BallLightningUnit>
/*     */   {
/*     */     Animation<ResourcePack.AtlasTextureRegion> a;
/*     */     
/*     */     public void setupAssets() {
/*  85 */       this.a = new Animation(0.05F, Game.i.assetManager.getTextureRegions("unit-type-ball-lightning"));
/*     */     }
/*     */     
/*     */     public Animation<ResourcePack.AtlasTextureRegion> getBallAnimation() {
/*  89 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public BallLightningUnit create() {
/*  94 */       return new BallLightningUnit((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/*  99 */       return Color.WHITE;
/*     */     }
/*     */ 
/*     */     
/*     */     public UnitType getUnitType() {
/* 104 */       return UnitType.BALL_LIGHTNING;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\units\BallLightningUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */