/*     */ package com.prineside.tdi2.enemies;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class IcyEnemy
/*     */   extends Enemy {
/*     */   public float shieldHealth;
/*     */   public float shieldMaxHealth;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  25 */     super.write(paramKryo, paramOutput);
/*  26 */     paramOutput.writeFloat(this.shieldHealth);
/*  27 */     paramOutput.writeFloat(this.shieldMaxHealth);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  32 */     super.read(paramKryo, paramInput);
/*  33 */     this.shieldHealth = paramInput.readFloat();
/*  34 */     this.shieldMaxHealth = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private IcyEnemy() {
/*  38 */     super(EnemyType.ICY);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBuffVulnerability(BuffType paramBuffType) {
/*  43 */     if (paramBuffType == BuffType.STUN || paramBuffType == BuffType.SNOWBALL || paramBuffType == BuffType.BLIZZARD || paramBuffType == BuffType.FREEZING) {
/*  44 */       if (this.shieldHealth <= 0.0F) {
/*  45 */         return super.getBuffVulnerability(paramBuffType);
/*     */       }
/*  47 */       return 0.0F;
/*     */     } 
/*     */ 
/*     */     
/*  51 */     return super.getBuffVulnerability(paramBuffType);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setMaxHealth(float paramFloat) {
/*  56 */     super.setMaxHealth(paramFloat);
/*     */     
/*  58 */     this.shieldHealth = paramFloat * 0.25F;
/*  59 */     this.shieldMaxHealth = this.shieldHealth;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/*  64 */     return 0.5F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float giveDamage(Tower paramTower, float paramFloat, DamageType paramDamageType) {
/*  69 */     float f2 = getHealth();
/*  70 */     float f1 = super.giveDamage(paramTower, paramFloat, paramDamageType);
/*  71 */     if (this.shieldHealth > 0.0F) {
/*     */       
/*  73 */       paramFloat = f1;
/*  74 */       if (paramDamageType != DamageType.BULLET && paramDamageType != DamageType.FIRE) {
/*  75 */         paramFloat = f1 * 0.25F;
/*     */       }
/*     */       
/*  78 */       this.shieldHealth -= paramFloat;
/*  79 */       if (this.shieldHealth < 0.0F) {
/*  80 */         this.shieldHealth = 0.0F;
/*     */       }
/*  82 */       setHealth(f2);
/*     */     } 
/*  84 */     return f1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawHealth(Batch paramBatch) {
/*  89 */     super.drawHealth(paramBatch);
/*     */     
/*  91 */     if (this.shieldHealth != 0.0F) {
/*  92 */       float f = this.shieldHealth / this.shieldMaxHealth;
/*     */       
/*  94 */       paramBatch.setColor(HEALTH_BAR_BACKGROUND_COLOR);
/*  95 */       paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 28.0F, this.drawPosition.y + 58.0F, 56.0F, 8.0F);
/*     */       
/*  97 */       paramBatch.setColor(MaterialColor.LIGHT_BLUE.P500);
/*  98 */       paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 26.0F, this.drawPosition.y + 60.0F, (int)(52.0F * f), 4.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public static class IcyEnemyFactory extends Enemy.Factory<IcyEnemy> {
/*     */     private TextureRegion a;
/*     */     private TextureRegion b;
/*     */     private TextureRegion c;
/*     */     
/*     */     public IcyEnemyFactory() {
/* 113 */       super(EnemyType.ICY);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 118 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-icy");
/* 119 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-icy-hl");
/* 120 */       this.c = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-icy-emj");
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 125 */       return this.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 130 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getEmojiTexture() {
/* 135 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public IcyEnemy create() {
/* 140 */       return new IcyEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 145 */       return MaterialColor.BLUE.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\IcyEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */