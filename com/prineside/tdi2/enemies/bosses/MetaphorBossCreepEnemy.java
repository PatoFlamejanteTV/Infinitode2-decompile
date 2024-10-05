/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Animation;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ResourcePack;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MetaphorBossCreepEnemy extends Enemy {
/*     */   @REGS
/*     */   public enum Kind {
/*  24 */     LOW_HP,
/*  25 */     HIGH_HP,
/*  26 */     RANDOM_SPEED,
/*  27 */     FRONT,
/*  28 */     REAR,
/*  29 */     BIG,
/*  30 */     SMALL; static {
/*     */     
/*  32 */     } public static final Kind[] values = values();
/*     */   }
/*     */   
/*  35 */   private Kind a = Kind.RANDOM_SPEED;
/*  36 */   private float b = 1.0F;
/*     */   
/*  38 */   private static final Color c = new Color();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  42 */     super.write(paramKryo, paramOutput);
/*  43 */     paramKryo.writeObject(paramOutput, this.a);
/*  44 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  49 */     super.read(paramKryo, paramInput);
/*  50 */     this.a = (Kind)paramKryo.readObject(paramInput, Kind.class);
/*  51 */     this.b = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private MetaphorBossCreepEnemy() {
/*  55 */     super(EnemyType.METAPHOR_BOSS_CREEP);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  60 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  65 */     return false;
/*     */   }
/*     */   
/*     */   public final void setKind(Kind paramKind) {
/*  69 */     this.a = paramKind;
/*     */     
/*  71 */     if (paramKind == Kind.BIG) {
/*  72 */       this.b = 1.25F; return;
/*  73 */     }  if (paramKind == Kind.SMALL) {
/*  74 */       this.b = 0.8F; return;
/*     */     } 
/*  76 */     this.b = 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Kind getKind() {
/*  81 */     return this.a;
/*     */   }
/*     */   
/*     */   public final float getSize() {
/*  85 */     return super.getSize() * this.b;
/*     */   }
/*     */   
/*     */   public final float getSquaredSize() {
/*  89 */     return super.getSize() * this.b * super.getSize() * this.b;
/*     */   }
/*     */   
/*     */   public final float getTowerDamageMultiplier(TowerType paramTowerType) {
/*  93 */     float f = super.getTowerDamageMultiplier(paramTowerType);
/*     */     
/*  95 */     if (this.a == Kind.HIGH_HP) {
/*  96 */       f *= 5.0F;
/*  97 */     } else if (this.a == Kind.LOW_HP) {
/*  98 */       f *= 0.2F;
/*     */     } 
/*     */     
/* 101 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat, Color paramColor) {
/* 111 */     paramFloat = 1.0F;
/*     */     
/* 113 */     c.set(paramColor);
/*     */     
/* 115 */     if (this.existsTime < 1.0F)
/*     */     {
/* 117 */       paramFloat = Interpolation.pow2Out.apply(this.existsTime);
/*     */     }
/* 119 */     paramFloat *= 0.75F * this.b;
/*     */     
/* 121 */     paramBatch.setColor(c);
/*     */     
/*     */     TextureRegion textureRegion;
/* 124 */     paramFloat = (textureRegion = (TextureRegion)Game.i.enemyManager.F.METAPHOR_BOSS_CREEP.a.getKeyFrame(this.passedTiles, true)).getRegionWidth() * paramFloat;
/* 125 */     paramBatch.draw(textureRegion, this.drawPosition.x - paramFloat * 0.5F, this.drawPosition.y - paramFloat * 0.5F, paramFloat * 0.5F, paramFloat * 0.5F, paramFloat, paramFloat, 1.0F, 1.0F, this.drawAngle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     if (hasBuffsByType(BuffType.BLIZZARD) || hasBuffsByType(BuffType.SNOWBALL)) {
/* 134 */       paramBatch.draw(Game.i.enemyManager.getIceOverlayTexture(this.id % 2), this.drawPosition.x - paramFloat * 0.5F, this.drawPosition.y - paramFloat * 0.5F, paramFloat, paramFloat);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/* 144 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   public static class MetaphorBossCreepEnemyFactory extends Enemy.Factory<MetaphorBossCreepEnemy> {
/*     */     private TextureRegion b;
/*     */     Animation<ResourcePack.AtlasTextureRegion> a;
/*     */     
/*     */     public MetaphorBossCreepEnemyFactory() {
/* 157 */       super(EnemyType.MOBCHAIN_BOSS_CREEP);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 162 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 167 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 172 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegions("enemy-type-boss-metaphor-creep").first();
/* 173 */       this.a = new Animation(0.07F, Game.i.assetManager.getTextureRegions("enemy-type-boss-metaphor-creep"));
/*     */     }
/*     */ 
/*     */     
/*     */     public MetaphorBossCreepEnemy create() {
/* 178 */       return new MetaphorBossCreepEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 183 */       return MaterialColor.RED.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\MetaphorBossCreepEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */