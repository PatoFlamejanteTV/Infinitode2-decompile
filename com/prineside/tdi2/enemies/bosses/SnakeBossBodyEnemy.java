/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class SnakeBossBodyEnemy extends Enemy {
/*     */   private SnakeBossBodyEnemy() {
/*  16 */     super(EnemyType.SNAKE_BOSS_BODY);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  21 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/*  26 */     float f = super.getAbilityVulnerability(paramAbilityType);
/*  27 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/*  28 */       return f * 0.1F;
/*     */     }
/*  30 */     if (paramAbilityType == AbilityType.LOIC) {
/*  31 */       return f * 4.0F;
/*     */     }
/*     */     
/*  34 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  39 */     return 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  44 */     float f = this.angle;
/*     */     
/*  46 */     this.angle += SnakeBossHeadEnemy.calculateSwingRotation(this.passedTiles);
/*  47 */     this.drawAngle = this.angle;
/*  48 */     this.drawPosition.set(getPosition());
/*  49 */     super.drawBatch(paramBatch, paramFloat);
/*  50 */     this.angle = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onPositionSetToPath() {
/*  55 */     SnakeBossHeadEnemy.transformPositionToSwing(this.passedTiles, this.angle, getPosition());
/*  56 */     setPosition(getPosition());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  61 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public static class SnakeBossBodyEnemyFactory extends Enemy.Factory<SnakeBossBodyEnemy> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public SnakeBossBodyEnemyFactory() {
/*  78 */       super(EnemyType.SNAKE_BOSS_BODY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/*  83 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-snake-body");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/*  88 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/*  93 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public SnakeBossBodyEnemy create() {
/*  98 */       return new SnakeBossBodyEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 103 */       return MaterialColor.LIGHT_GREEN.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\SnakeBossBodyEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */