/*     */ package com.prineside.tdi2.units;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class DisorientedUnit
/*     */   extends Unit
/*     */ {
/*     */   @Null
/*     */   private Tower a;
/*     */   private float b;
/*     */   private float c;
/*     */   public float coinsPerTilePassed;
/*     */   public int maxSumCoins;
/*  33 */   private int d = -1;
/*     */   
/*     */   private float e;
/*     */   private float f;
/*     */   private float g;
/*     */   private EnemyType h;
/*     */   @NAGS
/*     */   private TextureRegion i;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/*  45 */     paramOutput.writeFloat(this.b);
/*  46 */     paramOutput.writeFloat(this.c);
/*  47 */     paramOutput.writeFloat(this.coinsPerTilePassed);
/*  48 */     paramOutput.writeVarInt(this.maxSumCoins, true);
/*  49 */     paramOutput.writeVarInt(this.d, false);
/*  50 */     paramOutput.writeFloat(this.e);
/*  51 */     paramOutput.writeFloat(this.f);
/*  52 */     paramOutput.writeFloat(this.g);
/*  53 */     paramKryo.writeObject(paramOutput, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  58 */     super.read(paramKryo, paramInput);
/*  59 */     this.a = (Tower)paramKryo.readClassAndObject(paramInput);
/*  60 */     this.b = paramInput.readFloat();
/*  61 */     this.c = paramInput.readFloat();
/*  62 */     this.coinsPerTilePassed = paramInput.readFloat();
/*  63 */     this.maxSumCoins = paramInput.readVarInt(true);
/*  64 */     this.d = paramInput.readVarInt(false);
/*  65 */     this.e = paramInput.readFloat();
/*  66 */     this.f = paramInput.readFloat();
/*  67 */     this.g = paramInput.readFloat();
/*  68 */     this.h = (EnemyType)paramKryo.readObject(paramInput, EnemyType.class);
/*     */   }
/*     */   
/*     */   private DisorientedUnit() {
/*  72 */     super(UnitType.DISORIENTED);
/*     */   }
/*     */   @Null
/*     */   public final Tower getSpawnedByTower() {
/*  76 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, EnemyType paramEnemyType, float paramFloat1, float paramFloat2) {
/*  80 */     if (paramFloat1 <= 0.0F) {
/*  81 */       throw new IllegalArgumentException("health is " + paramFloat1);
/*     */     }
/*  83 */     if (paramFloat2 <= 0.0F) {
/*  84 */       throw new IllegalArgumentException("maxHealth is " + paramFloat2);
/*     */     }
/*  86 */     this.a = paramTower;
/*  87 */     this.h = paramEnemyType;
/*  88 */     this.b = paramFloat1;
/*  89 */     this.c = paramFloat2;
/*     */   }
/*     */   
/*     */   private void a(Batch paramBatch) {
/*  93 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */ 
/*     */     
/*  96 */     float f = this.b / this.c;
/*     */     
/*  98 */     paramBatch.setColor(MaterialColor.PURPLE.P900);
/*  99 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 28.0F, this.drawPosition.y + 52.0F, 56.0F, 8.0F);
/* 100 */     paramBatch.setColor(MaterialColor.PURPLE.P300);
/* 101 */     paramBatch.draw((TextureRegion)Game.i.assetManager.getBlankWhiteTextureRegion(), this.drawPosition.x - 26.0F, this.drawPosition.y + 54.0F, (int)(52.0F * f), 4.0F);
/*     */     
/* 103 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 108 */     if (this.i == null) {
/* 109 */       this.i = this.S.enemy.getTexture(this.h);
/*     */     }
/* 111 */     paramFloat = this.i.getRegionWidth();
/*     */     
/* 113 */     paramBatch.setColor(MaterialColor.PURPLE.P100);
/* 114 */     paramBatch.draw(this.i, this.drawPosition.x - paramFloat * 0.5F, this.drawPosition.y - paramFloat * 0.5F, paramFloat * 0.5F, paramFloat * 0.5F, paramFloat, paramFloat, 1.0F, 1.0F, this.drawAngle);
/*     */     
/* 116 */     a(paramBatch);
/*     */   }
/*     */   
/*     */   public final void setCoinsPerTilePassed(float paramFloat, int paramInt) {
/* 120 */     this.coinsPerTilePassed = paramFloat;
/* 121 */     this.maxSumCoins = paramInt;
/*     */ 
/*     */ 
/*     */     
/* 125 */     int i = this.graphPath.getLengthInTiles();
/*     */ 
/*     */     
/* 128 */     float f = 0.5F;
/* 129 */     this.e = 0.5F;
/* 130 */     while (f < 0.98F) {
/* 131 */       int j = 0;
/* 132 */       for (byte b = 0; b < i; b++) {
/* 133 */         float f1 = (float)Math.pow(this.e, b);
/*     */         int k;
/* 135 */         if ((k = (int)(paramFloat * f1)) <= 0) k = 1; 
/* 136 */         j += k;
/*     */       } 
/* 138 */       if (j <= paramInt) {
/*     */ 
/*     */ 
/*     */         
/* 142 */         this.e = f;
/* 143 */         f += 0.01F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 150 */     if (this.coinsPerTilePassed != 0.0F) {
/*     */       
/* 152 */       int i = (int)this.passedTiles;
/* 153 */       if (this.d != i) {
/*     */         
/* 155 */         float f = 1.0F; int j;
/* 156 */         for (j = 0; j < i; j++) {
/* 157 */           f *= this.e;
/*     */         }
/*     */         
/* 160 */         if ((j = (int)(this.coinsPerTilePassed * f)) <= 0) j = 1;
/*     */         
/* 162 */         this.f = 1.0F / j;
/* 163 */         this.g = i;
/* 164 */         this.d = i;
/*     */       } 
/*     */       
/* 167 */       byte b = 0;
/* 168 */       while (this.passedTiles >= this.g) {
/* 169 */         this.S.gameState.addMoney(1.0F, true);
/* 170 */         this.S.statistics.addStatistic(StatisticsType.CG_U, 1.0D);
/* 171 */         if (this.a != null) {
/* 172 */           this.a.bonusCoinsBrought++;
/*     */         }
/* 174 */         b++;
/* 175 */         this.g += this.f;
/*     */       } 
/*     */       
/* 178 */       if (b > 0 && this.S._particle != null) {
/* 179 */         this.S._particle.addCoinParticle(this.drawPosition.x, this.drawPosition.y, b);
/*     */       }
/*     */     } 
/*     */     
/* 183 */     this.S.map.getEnemiesInCircleV(this.position, 32.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */           Enemy enemy;
/*     */           if ((enemy = paramEnemyReference.enemy) == null || enemy.disabled.isTrue() || (this.a != null && !enemy.canBeAttackedBy(this.a))) {
/*     */             return true;
/*     */           }
/*     */           if ((paramFloat1 = enemy.getBuffedDamageMultiplier((this.a == null) ? null : this.a.type, DamageType.BULLET)) <= 0.0F) {
/*     */             return true;
/*     */           }
/*     */           paramFloat2 = enemy.getHealth();
/*     */           if ((paramFloat3 = this.b * paramFloat1) <= paramFloat2) {
/*     */             if (this.b < 0.0F) {
/*     */               throw new IllegalArgumentException("health is " + this.b);
/*     */             }
/*     */             this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.b, DamageType.BULLET).setTower(this.a).setCleanForDps(false));
/*     */             this.S.unit.killUnit(this, enemy);
/*     */           } else {
/*     */             this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, paramFloat2 + 0.001F, DamageType.BULLET).setTower(this.a).setCleanForDps(false).setLethal(true).setIgnoreTowerEfficiency(true).setUnit(this));
/*     */             this.b -= paramFloat2 / paramFloat1 + 2.0F;
/*     */             if (this.b <= 0.0F) {
/*     */               this.S.unit.killUnit(this, enemy);
/*     */             }
/*     */           } 
/*     */           return false;
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DisorientedUnitFactory
/*     */     extends Unit.Factory.BasicAbstractFactory<DisorientedUnit>
/*     */   {
/*     */     public void setupAssets() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DisorientedUnit create() {
/* 227 */       return new DisorientedUnit((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 232 */       return Color.WHITE;
/*     */     }
/*     */ 
/*     */     
/*     */     public UnitType getUnitType() {
/* 237 */       return UnitType.DISORIENTED;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\units\DisorientedUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */