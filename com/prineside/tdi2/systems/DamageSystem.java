/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.EnemyDie;
/*     */ import com.prineside.tdi2.events.game.EnemyTakeDamage;
/*     */ import com.prineside.tdi2.events.game.GiveDamageToEnemy;
/*     */ import com.prineside.tdi2.events.game.MdpsUpdate;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class DamageSystem extends GameSystem {
/*     */   static {
/*  40 */     TLog.forClass(DamageSystem.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int DAMAGE_DRAIN_MAX_ITERATIONS = 20;
/*     */ 
/*     */   
/*  48 */   private DpsCounter[] a = new DpsCounter[20];
/*  49 */   private Array<DamageRecord> b = new Array(true, 1, DamageRecord.class);
/*  50 */   private Array<DamageRecord> c = new Array(true, 1, DamageRecord.class);
/*     */   private double d;
/*     */   @NAGS
/*  53 */   private final Array<DamageRecord> e = new Array(true, 1, DamageRecord.class); @NAGS
/*     */   private double[] f; @NAGS
/*  55 */   private int g = 0; @NAGS
/*  56 */   private EnemyTakeDamage h = new EnemyTakeDamage();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  60 */     super.write(paramKryo, paramOutput);
/*  61 */     paramKryo.writeObject(paramOutput, this.a);
/*  62 */     paramKryo.writeObject(paramOutput, this.b);
/*  63 */     paramKryo.writeObject(paramOutput, this.c);
/*  64 */     paramOutput.writeDouble(this.d);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  69 */     super.read(paramKryo, paramInput);
/*  70 */     this.a = (DpsCounter[])paramKryo.readObject(paramInput, DpsCounter[].class);
/*  71 */     this.b = (Array<DamageRecord>)paramKryo.readObject(paramInput, Array.class);
/*  72 */     this.c = (Array<DamageRecord>)paramKryo.readObject(paramInput, Array.class);
/*  73 */     this.d = paramInput.readDouble();
/*     */   }
/*     */   
/*     */   public final DamageRecord obtainRecord() {
/*  77 */     return (this.e.size == 0) ? new DamageRecord() : (DamageRecord)this.e.pop();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  82 */     if (!Config.isHeadless() && Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DPS_CHART_ENABLED) != 0.0D) {
/*  83 */       this.f = new double[300];
/*     */     }
/*     */ 
/*     */     
/*  87 */     for (byte b = 0; b < 20; b++) {
/*  88 */       this.a[b] = new DpsCounter((byte)0);
/*  89 */       (this.a[b]).timeAccumulator = b * 0.25F;
/*     */     } 
/*  91 */     if (!this.S.CFG.headless) a(); 
/*     */   }
/*     */   
/*     */   private void a() {
/*  95 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.DEBUG_DPS_CHART_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawDebugDpsChart(paramBatch)))
/*     */ 
/*     */         
/*  98 */         .setName("Damage-drawDebugDpsChart"));
/*     */   }
/*     */   
/*     */   public final void queueDamage(DamageRecord paramDamageRecord) {
/* 102 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 104 */     Enemy enemy = paramDamageRecord.getEnemy();
/* 105 */     Ability ability = paramDamageRecord.getAbility();
/* 106 */     if (!enemy.isRegistered() || enemy.id == 0) {
/* 107 */       throw new IllegalArgumentException("Enemy is not registered " + enemy);
/*     */     }
/*     */     
/* 110 */     if (ability != null && EnemyType.isBoss(enemy.type))
/*     */     {
/* 112 */       paramDamageRecord.setDamage(paramDamageRecord.getDamage() * 0.075F);
/*     */     }
/*     */     
/* 115 */     if (!paramDamageRecord.isIgnoreTowerEfficiency() && paramDamageRecord.getTower() != null && !paramDamageRecord.getTower().canAttackEnemy(enemy)) {
/*     */       return;
/*     */     }
/*     */     
/*     */     Tower tower;
/* 120 */     if ((tower = paramDamageRecord.getTower()) != null && paramDamageRecord.isCleanForDps()) {
/*     */       float f;
/*     */       
/* 123 */       if ((f = Math.min(paramDamageRecord.getDamage(), tower.loopAbilityDamageBuffer)) > 0.0F) {
/* 124 */         tower.loopAbilityDamageBuffer -= f;
/* 125 */         queueDamage(paramDamageRecord.copyFor(paramDamageRecord.getEnemy(), obtainRecord()).setDamage(f).setCleanForDps(false).setAbility((Ability)tower.affectedByLoopAbility).setEfficiency(paramDamageRecord.getEfficiency() | 0x8));
/* 126 */         if (tower.loopAbilityDamageBuffer <= 0.0F) {
/* 127 */           tower.affectedByLoopAbility = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 133 */     GiveDamageToEnemy giveDamageToEnemy = new GiveDamageToEnemy(paramDamageRecord);
/* 134 */     this.S.events.trigger((Event)giveDamageToEnemy);
/* 135 */     if (giveDamageToEnemy.isCancelled())
/*     */       return; 
/* 137 */     this.b.add(paramDamageRecord);
/*     */   } private void a(DamageRecord paramDamageRecord) {
/*     */     EnemyTakeDamage enemyTakeDamage;
/*     */     boolean bool1;
/*     */     Enemy enemy;
/* 142 */     if (!(enemy = paramDamageRecord.getEnemy()).isRegistered())
/*     */       return; 
/* 144 */     float f1 = (enemy.getPosition()).x;
/* 145 */     float f2 = (enemy.getPosition()).y;
/* 146 */     float f3 = paramDamageRecord.isLethal() ? Float.MAX_VALUE : paramDamageRecord.getDamage();
/* 147 */     DamageType damageType = paramDamageRecord.getDamageType();
/* 148 */     int i = paramDamageRecord.getEfficiency();
/* 149 */     Tower tower1 = paramDamageRecord.getTower();
/* 150 */     Ability ability = paramDamageRecord.getAbility();
/* 151 */     Projectile projectile = paramDamageRecord.getProjectile();
/* 152 */     boolean bool = paramDamageRecord.isCleanForDps();
/*     */     
/* 154 */     Tower tower2 = paramDamageRecord.isIgnoreTowerEfficiency() ? null : tower1;
/*     */     
/* 156 */     if ((f3 = enemy.giveDamage(tower2, f3, damageType)) <= 0.0F) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     if (DamageType.Efficiency.isNormal(i)) {
/*     */       float f;
/* 165 */       if ((f = enemy.getBuffedDamageMultiplier((tower2 == null) ? null : tower2.type, damageType)) < 0.7F) {
/* 166 */         i |= 0x10;
/* 167 */       } else if (f > 1.3F) {
/* 168 */         i |= 0x2;
/*     */       } 
/*     */     } 
/* 171 */     paramDamageRecord.setEfficiency(i);
/* 172 */     paramDamageRecord.setFactDamage(f3);
/*     */ 
/*     */ 
/*     */     
/* 176 */     if (this.h == null) {
/* 177 */       enemyTakeDamage = new EnemyTakeDamage();
/* 178 */       bool1 = false;
/*     */     } else {
/* 180 */       enemyTakeDamage = this.h;
/* 181 */       this.h = null;
/* 182 */       bool1 = true;
/*     */     } 
/* 184 */     this.S.events.trigger((Event)enemyTakeDamage.setup(paramDamageRecord));
/* 185 */     if (bool1) {
/* 186 */       this.h = enemyTakeDamage.reset();
/*     */     }
/*     */ 
/*     */     
/* 190 */     if (tower1 != null) tower1.damageGiven += f3; 
/* 191 */     if (tower1 != null && ability == null && bool)
/*     */     {
/* 193 */       for (bool = false; bool < 20; bool++) {
/* 194 */         (this.a[bool]).damage += f3;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 199 */     if (this.S._particle != null) {
/* 200 */       int j; bool = false;
/* 201 */       if (DamageType.Efficiency.isOverTime(i)) {
/*     */         
/* 203 */         j = 7043 + damageType.ordinal();
/*     */ 
/*     */         
/* 206 */         if (tower1 != null) {
/* 207 */           j = j * 7867 + tower1.id;
/*     */         }
/* 209 */         if (ability != null) {
/* 210 */           j = j * 6521 + ability.getType().ordinal();
/*     */         }
/*     */       } 
/* 213 */       this.S._particle.addDamageParticle(f1, f2, (long)f3, i, j);
/*     */     } 
/*     */     
/* 216 */     if (enemy.isRegistered()) {
/* 217 */       if (enemy.getHealth() <= 0.0F) {
/*     */         
/* 219 */         queueEnemyKill(paramDamageRecord);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 224 */       if (tower1 != null && tower1.getTile() != null && damageType == DamageType.BULLET && this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 225 */         this.S._particle.addEnemyHitParticle(tower1, enemy, f3, projectile);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double getTowersMaxDps() {
/* 235 */     return this.d;
/*     */   }
/*     */   
/*     */   public final void setTowersMaxDps(double paramDouble) {
/* 239 */     Preconditions.checkArgument((paramDouble >= 0.0D && PMath.isFinite(paramDouble)));
/* 240 */     double d = this.d;
/* 241 */     this.d = paramDouble;
/* 242 */     this.S.events.trigger((Event)new MdpsUpdate(d));
/*     */   }
/*     */   
/*     */   public final void queueEnemyKill(DamageRecord paramDamageRecord) {
/* 246 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/*     */     Enemy enemy;
/* 249 */     if (!(enemy = paramDamageRecord.getEnemy()).isRegistered()) {
/* 250 */       throw new IllegalArgumentException("Enemy is not registered");
/*     */     }
/*     */     
/* 253 */     EnemyDie enemyDie = new EnemyDie(paramDamageRecord);
/* 254 */     this.S.events.trigger((Event)enemyDie);
/* 255 */     if (enemyDie.isCancelled())
/*     */       return; 
/* 257 */     this.c.add(paramDamageRecord);
/*     */   }
/*     */   
/*     */   private void b(DamageRecord paramDamageRecord) {
/*     */     Enemy enemy;
/* 262 */     if (!(enemy = paramDamageRecord.getEnemy()).isRegistered())
/*     */       return; 
/* 264 */     enemy.onPreDie();
/*     */ 
/*     */     
/* 267 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */       TextureRegion textureRegion; float f; ParticleEffectPool.PooledEffect pooledEffect;
/* 269 */       (pooledEffect = enemy.getBreakParticle()).setPosition(enemy.drawPosition.x, enemy.drawPosition.y);
/* 270 */       this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.ENEMY_DEAD, enemy.drawPosition.x, enemy.drawPosition.y);
/*     */ 
/*     */ 
/*     */       
/* 274 */       if (this.S.enemy.isEmojiEnemies()) {
/* 275 */         textureRegion = enemy.getEmojiTexture();
/* 276 */         f = 0.0F;
/*     */       } else {
/* 278 */         textureRegion = enemy.getTexture();
/* 279 */         f = enemy.drawAngle;
/*     */       } 
/* 281 */       this.S._particle.addRegularShatterParticle(textureRegion, enemy.drawPosition.x, enemy.drawPosition.y, textureRegion.getRegionWidth(), f, enemy.drawScale);
/*     */     } 
/*     */     
/* 284 */     this.S.map.a(enemy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drainDamageAndKillQueue() {
/*     */     int i;
/* 292 */     if ((i = this.b.size) != 0) {
/* 293 */       for (byte b = 0; b < i; b++) {
/* 294 */         a(((DamageRecord[])this.b.items)[b]);
/*     */       }
/*     */     }
/*     */     int j;
/* 298 */     if ((j = this.c.size) != 0) {
/* 299 */       for (byte b = 0; b < j; b++) {
/* 300 */         b(((DamageRecord[])this.c.items)[b]);
/*     */       }
/* 302 */       this.c.removeRange(0, j - 1);
/*     */     } 
/*     */     
/* 305 */     if (i != 0) {
/* 306 */       for (byte b = 0; b < i; b++) {
/* 307 */         ((DamageRecord[])this.b.items)[b].reset();
/*     */       }
/* 309 */       this.e.addAll(this.b.items, 0, i);
/* 310 */       this.b.removeRange(0, i - 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void drainDamageAndKillQueueTillEmpty() {
/* 315 */     byte b = 0;
/* 316 */     while (b < 20) {
/* 317 */       drainDamageAndKillQueue();
/* 318 */       if (this.b.size == 0 && this.c.size == 0) {
/*     */         return;
/*     */       }
/* 321 */       b++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 332 */     drainDamageAndKillQueueTillEmpty();
/*     */ 
/*     */     
/* 335 */     double d1 = 0.0D;
/* 336 */     double d2 = 0.0D; DpsCounter[] arrayOfDpsCounter; int i; byte b;
/* 337 */     for (i = (arrayOfDpsCounter = this.a).length, b = 0; b < i; b++) {
/* 338 */       DpsCounter dpsCounter; (dpsCounter = arrayOfDpsCounter[b]).timeAccumulator += paramFloat;
/* 339 */       if (dpsCounter.timeAccumulator > 5.0F) {
/* 340 */         if (dpsCounter.damage > dpsCounter.maxDamage) {
/* 341 */           dpsCounter.maxDamage = dpsCounter.damage;
/*     */         }
/* 343 */         if (d2 < dpsCounter.damage) {
/* 344 */           d2 = dpsCounter.damage;
/*     */         }
/* 346 */         dpsCounter.timeAccumulator = 0.0F;
/* 347 */         dpsCounter.damage = 0.0D;
/*     */       } 
/*     */       
/* 350 */       if (d1 < dpsCounter.maxDamage) {
/* 351 */         d1 = dpsCounter.maxDamage;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 356 */     if ((d1 = d1 / 5.0D) > this.d) {
/* 357 */       setTowersMaxDps(d1);
/*     */     }
/*     */ 
/*     */     
/* 361 */     if (this.f != null && (
/*     */       
/* 363 */       d2 = d2 / 5.0D) > 0.0D) {
/* 364 */       this.f[this.g++] = d2;
/* 365 */       if (this.g == this.f.length) {
/* 366 */         this.g = 0;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawDebugDpsChart(Batch paramBatch) {
/* 373 */     if (this.f != null) {
/* 374 */       Game.i.renderingManager.stopAnyBatchDrawing();
/*     */       
/* 376 */       Game.i.renderingManager.shapeRenderer.setProjectionMatrix((Game.i.uiManager.viewport.getCamera()).projection);
/* 377 */       Game.i.renderingManager.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
/* 378 */       Game.i.renderingManager.shapeRenderer.setColor(MaterialColor.ORANGE.P500.cpy());
/* 379 */       (Game.i.renderingManager.shapeRenderer.getColor()).a = 0.5F;
/*     */       
/* 381 */       Gdx.gl.glEnable(3042);
/* 382 */       Gdx.gl.glBlendFunc(770, 771);
/*     */       
/* 384 */       byte b = 0;
/*     */       
/* 386 */       float f = -Game.i.uiManager.viewport.getWorldHeight() * 0.5F;
/* 387 */       double d = 300.0D / this.d; int i;
/* 388 */       for (i = this.g; i < this.f.length; i++) {
/* 389 */         double d1 = this.f[i] * d;
/* 390 */         Game.i.renderingManager.shapeRenderer.rect((b * 3) + -450.0F, f, 2.0F, (float)d1);
/* 391 */         b++;
/*     */       } 
/* 393 */       for (i = 0; i < this.g; i++) {
/* 394 */         double d1 = this.f[i] * d;
/* 395 */         Game.i.renderingManager.shapeRenderer.rect((b * 3) + -450.0F, f, 2.0F, (float)d1);
/* 396 */         b++;
/*     */       } 
/*     */       
/* 399 */       Game.i.renderingManager.shapeRenderer.end();
/* 400 */       paramBatch.begin();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 406 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 411 */     return "Damage";
/*     */   }
/*     */   
/*     */   @REGS(arrayLevels = 1)
/*     */   public static class DpsCounter
/*     */     implements KryoSerializable {
/*     */     public double damage;
/*     */     public float timeAccumulator;
/*     */     public double maxDamage;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 422 */       param1Output.writeDouble(this.damage);
/* 423 */       param1Output.writeFloat(this.timeAccumulator);
/* 424 */       param1Output.writeDouble(this.maxDamage);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 429 */       this.damage = param1Input.readDouble();
/* 430 */       this.timeAccumulator = param1Input.readFloat();
/* 431 */       this.maxDamage = param1Input.readDouble();
/*     */     }
/*     */     
/*     */     private DpsCounter() {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\DamageSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */