/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MobchainBossBodyEnemy extends Enemy {
/*     */   private MobchainBossBodyEnemy() {
/*  17 */     super(EnemyType.MOBCHAIN_BOSS_BODY);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  22 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/*  27 */     float f = super.getAbilityVulnerability(paramAbilityType);
/*  28 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/*  29 */       return f * 0.1F;
/*     */     }
/*     */     
/*  32 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/*  37 */     float f1 = getHealth() / this.maxHealth;
/*  38 */     float f2 = 1.0F;
/*  39 */     if (f1 < 0.66F && f1 > 0.33F) {
/*     */       
/*  41 */       if (paramTowerType == TowerType.SPLASH || paramTowerType == TowerType.SNIPER || paramTowerType == TowerType.MULTISHOT || paramTowerType == TowerType.MINIGUN || paramTowerType == TowerType.MISSILE || paramTowerType == TowerType.CANNON || paramTowerType == TowerType.BASIC) {
/*  42 */         f2 = 0.1F;
/*     */       }
/*  44 */     } else if (f1 <= 0.33F) {
/*     */       
/*  46 */       if (paramTowerType == TowerType.VENOM || paramTowerType == TowerType.TESLA || paramTowerType == TowerType.LASER || paramTowerType == TowerType.FREEZING || paramTowerType == TowerType.FLAMETHROWER || paramTowerType == TowerType.BLAST) {
/*  47 */         f2 = 0.1F;
/*     */       }
/*     */     } 
/*     */     
/*  51 */     return f2 * super.getBuffedDamageMultiplier(paramTowerType, paramDamageType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  61 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  66 */     return 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public static class MobchainBossBodyEnemyFactory extends Enemy.Factory<MobchainBossBodyEnemy> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public MobchainBossBodyEnemyFactory() {
/*  78 */       super(EnemyType.SNAKE_BOSS_BODY);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/*  83 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/*  88 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/*  93 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-mobchain-body");
/*     */     }
/*     */ 
/*     */     
/*     */     public MobchainBossBodyEnemy create() {
/*  98 */       return new MobchainBossBodyEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 103 */       return MaterialColor.DEEP_PURPLE.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\MobchainBossBodyEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */