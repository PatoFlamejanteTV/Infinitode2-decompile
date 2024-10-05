/*     */ package com.prineside.tdi2.enemies;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class FighterEnemy
/*     */   extends Enemy
/*     */ {
/*     */   private boolean a;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  30 */     super.write(paramKryo, paramOutput);
/*  31 */     paramOutput.writeBoolean(this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  36 */     super.read(paramKryo, paramInput);
/*  37 */     this.a = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private FighterEnemy() {
/*  41 */     super(EnemyType.FIGHTER);
/*     */   }
/*     */   
/*     */   public final float getSize() {
/*  45 */     if (this.a) {
/*  46 */       return 17.92F;
/*     */     }
/*  48 */     return 30.72F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getSquaredSize() {
/*  53 */     if (this.a) {
/*  54 */       return 943.7184F;
/*     */     }
/*  56 */     return 943.7184F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final TextureRegion getTexture() {
/*  62 */     if (this.a) {
/*  63 */       return Game.i.enemyManager.F.FIGHTER.b;
/*     */     }
/*  65 */     return Game.i.enemyManager.F.FIGHTER.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final TextureRegion getEmojiTexture() {
/*  71 */     if (this.a) {
/*  72 */       return Game.i.enemyManager.F.FIGHTER.b;
/*     */     }
/*  74 */     return Game.i.enemyManager.F.FIGHTER.getEmojiTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final TextureRegion getHighlightTexture() {
/*  80 */     if (this.a) {
/*  81 */       return Game.i.enemyManager.F.FIGHTER.b;
/*     */     }
/*  83 */     return Game.i.enemyManager.F.FIGHTER.c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  94 */     return this.a ? 0.5F : 2.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onPreDie() {
/*  99 */     super.onPreDie();
/*     */     
/* 101 */     if (!this.a && this.graphPath != null) {
/* 102 */       for (byte b = 0; b < 3; b++) {
/*     */         FighterEnemy fighterEnemy;
/* 104 */         (fighterEnemy = (FighterEnemy)Game.i.enemyManager.getFactory(EnemyType.FIGHTER).obtain()).a = true;
/* 105 */         fighterEnemy.setMaxHealth(this.maxHealth * 0.5F);
/* 106 */         this.bounty *= 0.33F;
/* 107 */         fighterEnemy.setKillExp(getKillExp() * 0.33F);
/* 108 */         fighterEnemy.killScore = (int)(this.killScore * 0.33F);
/* 109 */         fighterEnemy.setSpeed(getSpeed());
/* 110 */         fighterEnemy.setHealth(this.maxHealth * 0.33F);
/* 111 */         fighterEnemy.notAffectsWaveKillCounter.addReason("FighterChild");
/*     */         
/* 113 */         this.S.enemy.addEnemyWithPath(fighterEnemy, this.spawnTile, this.graphPath, -1, this.wave, this.passedTiles);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FighterEnemyFactory
/*     */     extends Enemy.Factory<FighterEnemy>
/*     */   {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     TextureRegion c;
/*     */     private TextureRegion d;
/*     */     
/*     */     public FighterEnemyFactory() {
/* 127 */       super(EnemyType.FIGHTER);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 132 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 137 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 142 */       return this.d;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 147 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fighter");
/* 148 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fighter-small");
/* 149 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fighter-hl");
/* 150 */       this.d = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-fighter-emj");
/*     */     }
/*     */ 
/*     */     
/*     */     public FighterEnemy create() {
/* 155 */       return new FighterEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 160 */       return MaterialColor.PURPLE.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\FighterEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */