/*     */ package com.prineside.tdi2.enemies;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.RegenerationBuff;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class ToxicEnemy
/*     */   extends Enemy
/*     */ {
/*     */   private float a;
/*     */   private float b;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  28 */     super.write(paramKryo, paramOutput);
/*  29 */     paramOutput.writeFloat(this.a);
/*  30 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  35 */     super.read(paramKryo, paramInput);
/*  36 */     this.a = paramInput.readFloat();
/*  37 */     this.b = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private ToxicEnemy() {
/*  41 */     super(EnemyType.TOXIC);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  46 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float giveDamage(Tower paramTower, float paramFloat, DamageType paramDamageType) {
/*  51 */     this.a = 0.0F;
/*  52 */     this.b = 9001.0F;
/*     */     
/*  54 */     return super.giveDamage(paramTower, paramFloat, paramDamageType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  59 */     super.update(paramFloat);
/*     */     
/*  61 */     if (this.S.gameState.difficultyMode != DifficultyMode.EASY) {
/*  62 */       this.a += paramFloat;
/*  63 */       this.b += paramFloat;
/*     */       
/*  65 */       if (this.a > 3.5F && getHealth() != this.maxHealth && 
/*  66 */         this.b > 0.25F) {
/*     */         RegenerationBuff regenerationBuff;
/*  68 */         (regenerationBuff = new RegenerationBuff()).setup(0.5F, 5.0F, this.maxHealth * 0.05F, this.S.enemy.getReference(this));
/*  69 */         this.S.buff.P_REGENERATION.addBuff(this, regenerationBuff);
/*  70 */         this.b = 0.0F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class ToxicEnemyFactory
/*     */     extends Enemy.Factory<ToxicEnemy> {
/*     */     private TextureRegion a;
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/*     */     
/*     */     public ToxicEnemyFactory() {
/*  82 */       super(EnemyType.TOXIC);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/*  87 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/*  92 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/*  97 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-toxic");
/*  98 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-toxic-hl");
/*  99 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-toxic-emj");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 104 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public ToxicEnemy create() {
/* 109 */       return new ToxicEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 114 */       return MaterialColor.LIGHT_GREEN.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\ToxicEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */