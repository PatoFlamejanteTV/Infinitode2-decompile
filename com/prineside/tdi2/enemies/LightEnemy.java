/*     */ package com.prineside.tdi2.enemies;
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
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class LightEnemy
/*     */   extends Enemy
/*     */ {
/*  25 */   private float a = 10.0F;
/*     */   
/*     */   private DamageType b;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  30 */     super.write(paramKryo, paramOutput);
/*  31 */     paramOutput.writeFloat(this.a);
/*  32 */     paramKryo.writeObjectOrNull(paramOutput, this.b, DamageType.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  37 */     super.read(paramKryo, paramInput);
/*  38 */     this.a = paramInput.readFloat();
/*  39 */     this.b = (DamageType)paramKryo.readObjectOrNull(paramInput, DamageType.class);
/*     */   }
/*     */   
/*     */   private LightEnemy() {
/*  43 */     super(EnemyType.LIGHT);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float giveDamage(Tower paramTower, float paramFloat, DamageType paramDamageType) {
/*  53 */     float f = super.giveDamage(paramTower, paramFloat, paramDamageType);
/*     */     
/*  55 */     if (this.S.gameState.difficultyMode != DifficultyMode.EASY && 
/*  56 */       f != 0.0F && 
/*  57 */       this.a > 10.0F) {
/*  58 */       this.b = paramDamageType;
/*  59 */       this.a = 0.0F;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  64 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffedDamageMultiplier(TowerType paramTowerType, DamageType paramDamageType) {
/*  69 */     float f = super.getBuffedDamageMultiplier(paramTowerType, paramDamageType);
/*     */     
/*  71 */     if (this.b != null && this.b == paramDamageType) {
/*  72 */       f *= 0.25F;
/*     */     }
/*     */     
/*  75 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  80 */     super.update(paramFloat);
/*     */     
/*  82 */     this.a += paramFloat;
/*  83 */     if (this.b != null && this.a > 6.0F) {
/*  84 */       this.b = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  90 */     super.drawBatch(paramBatch, paramFloat);
/*     */     
/*  92 */     if (this.b != null) {
/*  93 */       TextureRegion textureRegion = Game.i.enemyManager.getDamageTypeIcon(this.b);
/*  94 */       paramBatch.setColor(0.0F, 0.0F, 0.0F, 0.28F);
/*  95 */       paramBatch.draw(textureRegion, this.drawPosition.x - 10.0F, this.drawPosition.y - 14.0F, 24.0F, 24.0F);
/*  96 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*  97 */       paramBatch.draw(textureRegion, this.drawPosition.x - 12.0F, this.drawPosition.y - 12.0F, 24.0F, 24.0F);
/*  98 */       if (this.a < 0.5F) {
/*  99 */         float f1 = this.a / 0.5F;
/* 100 */         float f2 = 24.0F + 42.0F * f1;
/*     */         
/* 102 */         paramBatch.setColor(1.0F, 1.0F, 1.0F, 1.0F - f1);
/* 103 */         paramBatch.draw(textureRegion, this.drawPosition.x - f2 * 0.5F, this.drawPosition.y - f2 * 0.5F, f2, f2);
/*     */       } 
/* 105 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class LightEnemyFactory extends Enemy.Factory<LightEnemy> {
/*     */     private TextureRegion a;
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/*     */     
/*     */     public LightEnemyFactory() {
/* 115 */       super(EnemyType.LIGHT);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 120 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-light");
/* 121 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-light-hl");
/* 122 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-light-emj");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 127 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 132 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 137 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public LightEnemy create() {
/* 142 */       return new LightEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 147 */       return MaterialColor.CYAN.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\LightEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */