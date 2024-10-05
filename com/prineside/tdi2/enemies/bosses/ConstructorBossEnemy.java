/*     */ package com.prineside.tdi2.enemies.bosses;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.waves.processors.ConstructorBossWaveProcessor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class ConstructorBossEnemy
/*     */   extends Enemy
/*     */ {
/*  31 */   private static final Color a = MaterialColor.BLUE_GREY.P500;
/*     */ 
/*     */   
/*  34 */   public Array<Enemy> enemiesToSpawn = new Array(Enemy.class);
/*     */   
/*     */   public int enemiesToSpawnStartCount;
/*     */   
/*     */   public float spawningTime;
/*     */   public float timeSinceCreepSpawn;
/*     */   public float spawnDelayBeforeTime;
/*     */   public float spawnDelayAfterTime;
/*     */   public boolean groupSpawned75hp;
/*     */   public boolean groupSpawned50hp;
/*     */   public boolean groupSpawned25hp;
/*     */   public boolean invulnerable;
/*     */   public ConstructorBossWaveProcessor processor;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramKryo.writeObject(paramOutput, this.enemiesToSpawn);
/*  51 */     paramOutput.writeVarInt(this.enemiesToSpawnStartCount, true);
/*  52 */     paramOutput.writeFloat(this.spawningTime);
/*  53 */     paramOutput.writeFloat(this.timeSinceCreepSpawn);
/*  54 */     paramOutput.writeFloat(this.spawnDelayBeforeTime);
/*  55 */     paramOutput.writeFloat(this.spawnDelayAfterTime);
/*  56 */     paramOutput.writeBoolean(this.groupSpawned75hp);
/*  57 */     paramOutput.writeBoolean(this.groupSpawned50hp);
/*  58 */     paramOutput.writeBoolean(this.groupSpawned25hp);
/*  59 */     paramOutput.writeBoolean(this.invulnerable);
/*  60 */     paramKryo.writeObjectOrNull(paramOutput, this.processor, ConstructorBossWaveProcessor.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  65 */     super.read(paramKryo, paramInput);
/*  66 */     this.enemiesToSpawn = (Array<Enemy>)paramKryo.readObject(paramInput, Array.class);
/*  67 */     this.enemiesToSpawnStartCount = paramInput.readVarInt(true);
/*  68 */     this.spawningTime = paramInput.readFloat();
/*  69 */     this.timeSinceCreepSpawn = paramInput.readFloat();
/*  70 */     this.spawnDelayBeforeTime = paramInput.readFloat();
/*  71 */     this.spawnDelayAfterTime = paramInput.readFloat();
/*  72 */     this.groupSpawned75hp = paramInput.readBoolean();
/*  73 */     this.groupSpawned50hp = paramInput.readBoolean();
/*  74 */     this.groupSpawned25hp = paramInput.readBoolean();
/*  75 */     this.invulnerable = paramInput.readBoolean();
/*  76 */     this.processor = (ConstructorBossWaveProcessor)paramKryo.readObjectOrNull(paramInput, ConstructorBossWaveProcessor.class);
/*     */   }
/*     */   
/*     */   private ConstructorBossEnemy() {
/*  80 */     super(EnemyType.CONSTRUCTOR_BOSS);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean hasDrawPriority() {
/*  85 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossRelated() {
/*  90 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isBossMainBodyPart() {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getAbilityVulnerability(AbilityType paramAbilityType) {
/* 100 */     float f = super.getAbilityVulnerability(paramAbilityType);
/* 101 */     if (paramAbilityType == AbilityType.BALL_LIGHTNING) {
/* 102 */       return f * 0.1F;
/*     */     }
/*     */     
/* 105 */     return f;
/*     */   }
/*     */   
/*     */   public final void changeSpeedTo(float paramFloat1, float paramFloat2) {
/*     */     float f;
/* 110 */     if ((f = paramFloat1 - getSpeed()) != 0.0F) {
/* 111 */       paramFloat2 *= 2.0F;
/* 112 */       float f1 = StrictMath.abs(f);
/* 113 */       if (paramFloat2 < f1) {
/*     */         
/* 115 */         setSpeed(getSpeed() + f * paramFloat2 / f1);
/*     */         return;
/*     */       } 
/* 118 */       setSpeed(paramFloat1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getSize() {
/* 125 */     if (isInvulnerable()) return 96.0F;
/*     */     
/* 127 */     return 64.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getSquaredSize() {
/* 132 */     if (isInvulnerable()) return 4096.0F;
/*     */     
/* 134 */     return 4096.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final float giveDamage(Tower paramTower, float paramFloat, DamageType paramDamageType) {
/* 139 */     if (isInvulnerable()) {
/* 140 */       return 0.0F;
/*     */     }
/*     */     
/* 143 */     if (!this.groupSpawned25hp && this.processor != null) {
/*     */ 
/*     */       
/* 146 */       float f1 = getBuffedDamageMultiplier((paramTower == null) ? null : paramTower.type, paramDamageType);
/* 147 */       paramFloat *= f1;
/*     */       
/* 149 */       float f2 = getHealth() + 0.01F;
/* 150 */       if (!this.groupSpawned75hp) {
/* 151 */         f2 = getHealth() - this.maxHealth * 0.74F;
/* 152 */       } else if (!this.groupSpawned50hp) {
/* 153 */         f2 = getHealth() - this.maxHealth * 0.49F;
/* 154 */       } else if (!this.groupSpawned25hp) {
/* 155 */         f2 = getHealth() - this.maxHealth * 0.24F;
/*     */       } 
/* 157 */       if (paramFloat > f2) paramFloat = f2;
/*     */       
/* 159 */       return super.giveDamage(paramTower, paramFloat / f1, paramDamageType);
/*     */     } 
/* 161 */     return super.giveDamage(paramTower, paramFloat, paramDamageType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final float getBaseDamage() {
/* 167 */     return 100.0F;
/*     */   }
/*     */   
/*     */   public final boolean isInvulnerable() {
/* 171 */     return this.invulnerable;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 176 */     if (isInvulnerable()) {
/*     */       
/* 178 */       paramBatch.setColor(a);
/* 179 */       paramBatch.draw(Game.i.enemyManager.F.CONSTRUCTOR_BOSS.a, this.drawPosition.x - 96.0F, this.drawPosition.y - 96.0F, 192.0F, 192.0F);
/* 180 */       paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     } 
/*     */     
/* 183 */     super.drawBatch(paramBatch, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean dynamicPathfindingAllowed() {
/* 188 */     return false;
/*     */   }
/*     */   
/*     */   public static class ConstructorBossBodyEnemyFactory extends Enemy.Factory<ConstructorBossEnemy> {
/*     */     private TextureRegion b;
/*     */     TextureRegion a;
/*     */     
/*     */     public ConstructorBossBodyEnemyFactory() {
/* 196 */       super(EnemyType.CONSTRUCTOR_BOSS);
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getTexture() {
/* 201 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegion getHighlightTexture() {
/* 206 */       return this.b;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 211 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("enemy-type-boss-constructor");
/* 212 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("aura-range");
/*     */     }
/*     */ 
/*     */     
/*     */     public ConstructorBossEnemy create() {
/* 217 */       return new ConstructorBossEnemy((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 222 */       return MaterialColor.BLUE_GREY.P500;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\enemies\bosses\ConstructorBossEnemy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */