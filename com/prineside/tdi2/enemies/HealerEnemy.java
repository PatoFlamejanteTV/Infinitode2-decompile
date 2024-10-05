/*     */ package com.prineside.tdi2.enemies;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.buffs.RegenerationBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class HealerEnemy
/*     */   extends Enemy {
/*     */   public static final byte AURA_CHECK_FRAME_INTERVAL = 7;
/*  24 */   private static final Color a = MaterialColor.RED.P500;
/*     */ 
/*     */   
/*     */   private byte b;
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  32 */     super.write(paramKryo, paramOutput);
/*  33 */     paramOutput.writeByte(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  38 */     super.read(paramKryo, paramInput);
/*  39 */     this.b = paramInput.readByte();
/*     */   }
/*     */   
/*     */   private HealerEnemy() {
/*  43 */     super(EnemyType.HEALER);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  48 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  53 */     super.update(paramFloat);
/*     */     
/*  55 */     if (this.S.gameState.difficultyMode != DifficultyMode.EASY) {
/*     */       
/*  57 */       this.b = (byte)(this.b + 1);
/*  58 */       Enemy.EnemyReference enemyReference = this.S.enemy.getReference(this);
/*  59 */       if (this.b == 7) {
/*  60 */         this.b = 0;
/*  61 */         float f = this.S.gameValue.getTickRateDeltaTime() * 7.1F;
/*     */         
/*  63 */         this.S.map.getEnemiesInCircleV(getPosition(), 128.0F, (paramEnemyReference2, paramFloat2, paramFloat3, paramFloat4) -> {
/*     */               Enemy enemy;
/*     */               if ((enemy = paramEnemyReference2.enemy) == null || enemy.type == EnemyType.HEALER) {
/*     */                 return true;
/*     */               }
/*     */               paramFloat2 = StrictMath.min(enemy.maxHealth, this.maxHealth) * 0.05F;
/*     */               DelayedRemovalArray delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.REGENERATION);
/*     */               boolean bool = false;
/*     */               if (delayedRemovalArray != null && delayedRemovalArray.size != 0) {
/*     */                 for (byte b = 0; b < delayedRemovalArray.size; b++) {
/*     */                   RegenerationBuff regenerationBuff;
/*     */                   if ((regenerationBuff = (RegenerationBuff)delayedRemovalArray.get(b)).issuer == paramEnemyReference1) {
/*     */                     regenerationBuff.duration = paramFloat1;
/*     */                     regenerationBuff.hpPerSecond = paramFloat2;
/*     */                     bool = true;
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */               if (!bool) {
/*     */                 RegenerationBuff regenerationBuff;
/*     */                 (regenerationBuff = new RegenerationBuff()).setup(paramFloat1, paramFloat1, StrictMath.min(enemy.maxHealth, this.maxHealth) * 0.05F, paramEnemyReference1);
/*     */                 this.S.buff.P_REGENERATION.addBuff(enemy, regenerationBuff);
/*     */               } 
/*     */               return true;
/*     */             });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  96 */     return 1.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 101 */     super.drawBatchAdditive(paramBatch, paramFloat);
/*     */     
/* 103 */     if (this.S.gameState.difficultyMode != DifficultyMode.EASY) {
/* 104 */       paramBatch.setColor(a);
/* 105 */       paramBatch.draw(Game.i.enemyManager.F.HEALER.a, this.drawPosition.x - 128.0F, this.drawPosition.y - 128.0F, 256.0F, 256.0F);
/* 106 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class HealerEnemyFactory extends Enemy.Factory<HealerEnemy> {
/*     */     private TextureRegion b;
/*     */     TextureRegion a;
/*     */     private TextureRegion c;
/*     */     private TextureRegion d;
/*     */     
/*     */     public HealerEnemyFactory() {
/* 117 */       super(EnemyType.HEALER);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 122 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-healer");
/* 123 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("aura-range");
/* 124 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-healer-hl");
/* 125 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-healer-emj");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 130 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 135 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 140 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public HealerEnemy create() {
/* 145 */       return new HealerEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 150 */       return MaterialColor.RED.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\HealerEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */