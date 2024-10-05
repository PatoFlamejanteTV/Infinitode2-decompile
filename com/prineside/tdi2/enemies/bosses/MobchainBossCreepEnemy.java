/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MobchainBossCreepEnemy extends Enemy {
/*     */   @NAGS
/*  24 */   public Color color = Color.WHITE;
/*     */   public TowerType vulnerableTo;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  28 */     super.write(paramKryo, paramOutput);
/*  29 */     paramKryo.writeObjectOrNull(paramOutput, this.vulnerableTo, TowerType.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  34 */     super.read(paramKryo, paramInput);
/*  35 */     this.vulnerableTo = (TowerType)paramKryo.readObjectOrNull(paramInput, TowerType.class);
/*     */   }
/*     */   
/*     */   private MobchainBossCreepEnemy() {
/*  39 */     super(EnemyType.MOBCHAIN_BOSS_CREEP);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/*  49 */     return super.getAbilityVulnerability(paramAbilityType) * 0.1F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/*  54 */     float f = 0.15F;
/*     */     
/*  56 */     if (this.vulnerableTo == paramTowerType) {
/*  57 */       f = 1.0F;
/*     */     }
/*     */     
/*  60 */     return f * super.getBuffedDamageMultiplier(paramTowerType, paramDamageType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  70 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  75 */     drawBatch(paramBatch, paramFloat, this.color);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawHealth(Batch paramBatch) {
/*  80 */     super.drawHealth(paramBatch);
/*     */     
/*  82 */     if (this.vulnerableTo != null) {
/*  83 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */       
/*  85 */       paramBatch.draw((TextureRegion)(AssetManager.TextureRegions.i()).enemyDialog, this.drawPosition.x - 44.0F, this.drawPosition.y + 56.0F, 88.0F, 80.0F);
/*  86 */       paramBatch.draw(Game.i.towerManager.getFactory(this.vulnerableTo).getIconTexture(), this.drawPosition.x - 32.0F, this.drawPosition.y + 66.0F, 64.0F, 64.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  92 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   public static class MobchainBossCreepEnemyFactory extends Enemy.Factory<MobchainBossCreepEnemy> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public MobchainBossCreepEnemyFactory() {
/* 104 */       super(EnemyType.MOBCHAIN_BOSS_CREEP);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 109 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 114 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 119 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-mobchain-creep");
/*     */     }
/*     */ 
/*     */     
/*     */     public MobchainBossCreepEnemy create() {
/* 124 */       return new MobchainBossCreepEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 129 */       return MaterialColor.DEEP_PURPLE.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\MobchainBossCreepEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */