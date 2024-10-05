/*     */ package com.prineside.tdi2.units;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.SnowballBuff;
/*     */ import com.prineside.tdi2.buffs.processors.SnowballBuffProcessor;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class SnowballUnit
/*     */   extends Unit
/*     */ {
/*     */   private float a;
/*     */   private Tower b;
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect c;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  33 */     super.write(paramKryo, paramOutput);
/*  34 */     paramOutput.writeFloat(this.a);
/*  35 */     paramKryo.writeClassAndObject(paramOutput, this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  40 */     super.read(paramKryo, paramInput);
/*  41 */     this.a = paramInput.readFloat();
/*  42 */     this.b = (Tower)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   private SnowballUnit() {
/*  46 */     super(UnitType.SNOWBALL);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat) {
/*  50 */     this.drawOverEnemies = true;
/*     */     
/*  52 */     this.b = paramTower;
/*  53 */     this.a = paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onSpawned() {
/*  58 */     super.onSpawned();
/*     */     
/*  60 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*  61 */       this.c = (ParticleEffectPool.PooledEffect)Game.i.unitManager.F.SNOWBALL.b.obtain();
/*  62 */       this.c.setPosition(this.position.x, this.position.y);
/*  63 */       this.S._particle.addParticle((ParticleEffect)this.c, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  69 */     if (this.c != null) {
/*  70 */       this.c.allowCompletion();
/*  71 */       this.c = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  77 */     if (this.c != null) {
/*  78 */       this.c.setPosition(this.drawPosition.x, this.drawPosition.y);
/*     */     }
/*     */     
/*  81 */     paramBatch.draw(Game.i.unitManager.F.SNOWBALL.a, this.drawPosition.x - 32.0F, this.drawPosition.y - 32.0F, 32.0F, 32.0F, 64.0F, 64.0F, 1.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  86 */     this.S.map.getEnemiesInRect(this.position.x - 16.0F, this.position.y - 16.0F, this.position.x + 16.0F, this.position.y + 16.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */           Enemy enemy;
/*     */           if ((enemy = paramEnemyReference.enemy) == null) {
/*     */             return true;
/*     */           }
/*     */           if (enemy.buffSnowballHits < SnowballBuffProcessor.MAX_HITS_ONE_ENEMY && PMath.circleIntersectsCircle((enemy.getPosition()).x, (enemy.getPosition()).y, enemy.getSize(), this.position.x, this.position.y, 32.0F)) {
/*     */             SnowballBuff snowballBuff = new SnowballBuff();
/*     */             paramFloat2 = this.a * SnowballBuffProcessor.STUN_DURATION_BY_STUN_COUNT[enemy.buffSnowballHits];
/*     */             snowballBuff.setup(paramFloat2, paramFloat2 * 10.0F);
/*     */             if (this.S.buff.P_SNOWBALL.addBuff(enemy, snowballBuff)) {
/*     */               this.S.unit.killUnit(this, enemy);
/*     */               return false;
/*     */             } 
/*     */           } 
/*     */           return true;
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public static class SnowballUnitFactory
/*     */     extends Unit.Factory.BasicAbstractFactory<SnowballUnit>
/*     */   {
/*     */     TextureRegion a;
/*     */     ParticleEffectPool b;
/*     */     
/*     */     public void setupAssets() {
/* 112 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("unit-type-snowball");
/*     */       
/* 114 */       this.b = Game.i.assetManager.getParticleEffectPool("snowflakes-trace.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public SnowballUnit create() {
/* 119 */       return new SnowballUnit((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 124 */       return MaterialColor.LIGHT_BLUE.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public UnitType getUnitType() {
/* 129 */       return UnitType.SNOWBALL;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\units\SnowballUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */