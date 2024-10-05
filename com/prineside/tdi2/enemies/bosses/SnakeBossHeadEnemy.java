/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class SnakeBossHeadEnemy
/*     */   extends Enemy
/*     */ {
/*     */   public static final float DEFAULT_MIN_SPEED = 0.3F;
/*     */   public static final float DEFAULT_MAX_SPEED = 0.85F;
/*  26 */   public float defaultMinSpeed = 0.3F;
/*  27 */   public float defaultMaxSpeed = 0.85F;
/*  28 */   public float damageResistance = 1.0F;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  32 */     super.write(paramKryo, paramOutput);
/*  33 */     paramOutput.writeFloat(this.defaultMinSpeed);
/*  34 */     paramOutput.writeFloat(this.defaultMaxSpeed);
/*  35 */     paramOutput.writeFloat(this.damageResistance);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  40 */     super.read(paramKryo, paramInput);
/*  41 */     this.defaultMinSpeed = paramInput.readFloat();
/*  42 */     this.defaultMaxSpeed = paramInput.readFloat();
/*  43 */     this.damageResistance = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private SnakeBossHeadEnemy() {
/*  47 */     super(EnemyType.SNAKE_BOSS_HEAD);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  52 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  57 */     return 50.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  62 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  67 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/*  72 */     float f = super.getAbilityVulnerability(paramAbilityType);
/*  73 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/*  74 */       return f * 0.1F;
/*     */     }
/*  76 */     if (paramAbilityType == AbilityType.LOIC) {
/*  77 */       return f * 4.0F;
/*     */     }
/*     */     
/*  80 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/*  85 */     return super.getBuffedDamageMultiplier(paramTowerType, paramDamageType) * (1.0F - this.damageResistance);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawHealth(Batch paramBatch) {
/*  90 */     super.drawHealth(paramBatch);
/*     */     
/*  92 */     if (this.damageResistance != 0.0F) {
/*  93 */       paramBatch.setColor(HEALTH_BAR_BACKGROUND_COLOR);
/*  94 */       paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 28.0F, this.drawPosition.y + 58.0F, 56.0F, 8.0F);
/*     */       
/*  96 */       paramBatch.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  97 */       paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 26.0F, this.drawPosition.y + 60.0F, (int)(52.0F * this.damageResistance), 4.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 103 */     float f = this.angle;
/*     */     
/* 105 */     this.angle += calculateSwingRotation(this.passedTiles);
/* 106 */     this.drawAngle = this.angle;
/* 107 */     this.drawPosition.set(getPosition());
/* 108 */     super.drawBatch(paramBatch, paramFloat);
/* 109 */     this.angle = f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onPositionSetToPath() {
/* 114 */     transformPositionToSwing(this.passedTiles, this.angle, getPosition());
/* 115 */     setPosition(getPosition());
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public static float calculateSwingRotation(float paramFloat) {
/* 124 */     return PMath.sin(paramFloat * 3.0F) * 15.0F;
/*     */   }
/*     */   
/*     */   public static void transformPositionToSwing(float paramFloat1, float paramFloat2, Vector2 paramVector2) {
/* 128 */     paramFloat1 = PMath.sin(paramFloat1 * 3.0F - 45.0F);
/* 129 */     paramVector2.add((new Vector2(12.8F, 0.0F)).rotate(paramFloat2).scl(-paramFloat1));
/*     */   }
/*     */   
/*     */   public static class SnakeBossHeadEnemyFactory extends Enemy.Factory<SnakeBossHeadEnemy> {
/*     */     private TextureRegion a;
/*     */     
/*     */     public SnakeBossHeadEnemyFactory() {
/* 136 */       super(EnemyType.SNAKE_BOSS_HEAD);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 141 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 146 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 151 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-snake-head");
/*     */     }
/*     */ 
/*     */     
/*     */     public SnakeBossHeadEnemy create() {
/* 156 */       return new SnakeBossHeadEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 161 */       return MaterialColor.LIGHT_GREEN.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\SnakeBossHeadEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */