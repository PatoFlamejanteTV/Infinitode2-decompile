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
/*     */ import com.prineside.tdi2.buffs.ArmorBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class ArmoredEnemy
/*     */   extends Enemy {
/*     */   public static final byte AURA_CHECK_FRAME_INTERVAL = 7;
/*  24 */   private static final Color a = MaterialColor.TEAL.P500;
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
/*     */   private ArmoredEnemy() {
/*  43 */     super(EnemyType.ARMORED);
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
/*  58 */       if (this.b == 7) {
/*  59 */         this.b = 0;
/*  60 */         paramFloat = this.S.gameValue.getTickRateDeltaTime() * 7.1F;
/*     */         
/*  62 */         this.S.map.getEnemiesInCircleV(getPosition(), 128.0F, (paramEnemyReference, paramFloat2, paramFloat3, paramFloat4) -> {
/*     */               Enemy enemy;
/*     */               if ((enemy = paramEnemyReference.enemy) == null || enemy.type == EnemyType.ARMORED) {
/*     */                 return true;
/*     */               }
/*     */               DelayedRemovalArray delayedRemovalArray = enemy.getBuffsByTypeOrNull(BuffType.ARMOR);
/*     */               boolean bool = false;
/*     */               if (delayedRemovalArray != null && delayedRemovalArray.size != 0) {
/*     */                 ArmorBuff armorBuff;
/*     */                 (armorBuff = (ArmorBuff)delayedRemovalArray.first()).duration = paramFloat1;
/*     */                 bool = true;
/*     */               } 
/*     */               if (!bool) {
/*     */                 ArmorBuff armorBuff;
/*     */                 (armorBuff = new ArmorBuff()).setup(paramFloat1, paramFloat1);
/*     */                 this.S.buff.P_ARMOR.addBuff(enemy, armorBuff);
/*     */               } 
/*     */               return true;
/*     */             });
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/*  87 */     super.drawBatchAdditive(paramBatch, paramFloat);
/*     */     
/*  89 */     if (this.S.gameState.difficultyMode != DifficultyMode.EASY) {
/*  90 */       paramBatch.setColor(a);
/*  91 */       paramBatch.draw(Game.i.enemyManager.F.ARMORED.a, this.drawPosition.x - 128.0F, this.drawPosition.y - 128.0F, 256.0F, 256.0F);
/*  92 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class ArmoredEnemyFactory extends Enemy.Factory<ArmoredEnemy> {
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/*     */     TextureRegion a;
/*     */     private TextureRegion d;
/*     */     
/*     */     public ArmoredEnemyFactory() {
/* 103 */       super(EnemyType.ARMORED);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 108 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-armored");
/* 109 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-armored-hl");
/* 110 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("aura-range");
/* 111 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-armored-emj");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 117 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 122 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 127 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArmoredEnemy create() {
/* 132 */       return new ArmoredEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 137 */       return MaterialColor.TEAL.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\ArmoredEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */