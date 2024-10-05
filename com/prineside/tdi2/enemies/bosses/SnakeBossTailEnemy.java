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
/*     */ public final class SnakeBossTailEnemy extends Enemy {
/*     */   private SnakeBossTailEnemy() {
/*  16 */     super(EnemyType.SNAKE_BOSS_TAIL);
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
/*  39 */     return 50.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  44 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  49 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  54 */     float f = this.angle;
/*     */     
/*  56 */     this.angle += SnakeBossHeadEnemy.calculateSwingRotation(this.passedTiles);
/*  57 */     this.drawAngle = this.angle;
/*  58 */     this.drawPosition.set(getPosition());
/*  59 */     super.drawBatch(paramBatch, paramFloat);
/*  60 */     this.angle = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onPositionSetToPath() {
/*  65 */     SnakeBossHeadEnemy.transformPositionToSwing(this.passedTiles, this.angle, getPosition());
/*  66 */     setPosition(getPosition());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public static class SnakeBossTailEnemyFactory extends Enemy.Factory<SnakeBossTailEnemy> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public SnakeBossTailEnemyFactory() {
/*  78 */       super(EnemyType.SNAKE_BOSS_TAIL);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/*  83 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-snake-tail");
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
/*     */     public SnakeBossTailEnemy create() {
/*  98 */       return new SnakeBossTailEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 103 */       return MaterialColor.LIGHT_GREEN.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\SnakeBossTailEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */