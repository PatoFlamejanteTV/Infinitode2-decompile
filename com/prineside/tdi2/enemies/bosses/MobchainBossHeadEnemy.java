/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MobchainBossHeadEnemy
/*     */   extends Enemy {
/*     */   public boolean vulnerable = false;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  25 */     super.write(paramKryo, paramOutput);
/*  26 */     paramOutput.writeBoolean(this.vulnerable);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  31 */     super.read(paramKryo, paramInput);
/*  32 */     this.vulnerable = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private MobchainBossHeadEnemy() {
/*  36 */     super(EnemyType.MOBCHAIN_BOSS_HEAD);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  41 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  46 */     return 100.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/*  51 */     float f = super.getAbilityVulnerability(paramAbilityType);
/*  52 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/*  53 */       return f * 0.1F;
/*     */     }
/*     */     
/*  56 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canBeAttackedBy(Tower paramTower) {
/*  71 */     if (!this.vulnerable) return false;
/*     */     
/*  73 */     return super.canBeAttackedBy(paramTower);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/*  78 */     if (!this.vulnerable) return 0.0F;
/*     */     
/*  80 */     return super.getBuffedDamageMultiplier(paramTowerType, paramDamageType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawHealth(Batch paramBatch) {
/*  85 */     if (this.vulnerable) {
/*  86 */       super.drawHealth(paramBatch);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public static class MobchainBossHeadEnemyFactory extends Enemy.Factory<MobchainBossHeadEnemy> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public MobchainBossHeadEnemyFactory() {
/*  99 */       super(EnemyType.MOBCHAIN_BOSS_HEAD);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 104 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 109 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 114 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-mobchain-head");
/*     */     }
/*     */ 
/*     */     
/*     */     public MobchainBossHeadEnemy create() {
/* 119 */       return new MobchainBossHeadEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 124 */       return MaterialColor.DEEP_PURPLE.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\MobchainBossHeadEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */