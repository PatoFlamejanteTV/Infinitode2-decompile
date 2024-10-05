/*     */ package com.prineside.tdi2.towers;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.BitmapFont;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.KryoSerializable;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.BonusXpBuff;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.units.DisorientedUnit;
/*     */ import com.prineside.tdi2.utils.DrawUtils;
/*     */ import com.prineside.tdi2.utils.FrameAccumulatorForPerformance;
/*     */ import com.prineside.tdi2.utils.Intersector;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.Quad;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class CrusherTower extends Tower {
/*     */   static {
/*  47 */     TLog.forClass(CrusherTower.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public static final String[] ABILITY_ALIASES = new String[] { "HEAVY_VICE", "INCREASED_CAPACITY", "CAREFUL_PROCESSING" };
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
/*  66 */   private static final float e = (new Color(1.0F, 1.0F, 1.0F, 0.0F)).toFloatBits();
/*  67 */   private static final float f = (new Color(1.0F, 1.0F, 1.0F, 1.0F)).toFloatBits();
/*     */   
/*     */   @NAGS
/*     */   private float g;
/*     */   
/*     */   @NAGS
/*     */   private float h;
/*     */   
/*     */   private int i;
/*     */   
/*  77 */   private Array<Hook> j = new Array(Hook.class);
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  81 */     super.write(paramKryo, paramOutput);
/*  82 */     paramOutput.writeVarInt(this.i, true);
/*  83 */     paramKryo.writeObject(paramOutput, this.j);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  88 */     super.read(paramKryo, paramInput);
/*  89 */     this.i = paramInput.readVarInt(true);
/*  90 */     this.j = (Array<Hook>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private CrusherTower() {
/*  94 */     super(TowerType.CRUSHER);
/*     */   }
/*     */ 
/*     */   
/*     */   public final Quad getWeaponTextures() {
/*  99 */     if (isAbilityInstalled(0)) {
/* 100 */       return Game.i.towerManager.F.CRUSHER.getAbilityTextures(0);
/*     */     }
/* 102 */     return Game.i.towerManager.F.CRUSHER.getWeaponTexture();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void applyDrawInterpolation(float paramFloat) {
/* 108 */     super.applyDrawInterpolation(paramFloat);
/*     */     
/* 110 */     if (paramFloat != 0.0F) {
/* 111 */       float f = getStat(TowerStatType.PROJECTILE_SPEED) * 128.0F;
/* 112 */       for (byte b1 = 0; b1 < this.j.size; b1++) {
/*     */         Vector2 vector2; Hook hook;
/* 114 */         Enemy enemy = (hook = ((Hook[])this.j.items)[b1]).getTarget();
/* 115 */         if (hook.status == 1) {
/*     */           
/* 117 */           if (enemy != null) {
/*     */             
/* 119 */             (vector2 = new Vector2(enemy.getPosition())).sub(hook.pos);
/* 120 */             vector2.nor();
/* 121 */             vector2.scl(f * paramFloat);
/*     */             
/* 123 */             hook.drawPos.set(hook.pos).add(vector2);
/*     */           } 
/* 125 */         } else if (hook.status == 2) {
/*     */           float f1;
/*     */           
/* 128 */           if (vector2 == null) {
/* 129 */             f1 = 256.0F * paramFloat;
/*     */           } else {
/* 131 */             f1 = 192.0F * paramFloat;
/*     */           } 
/*     */           
/*     */           Vector2 vector21;
/* 135 */           (vector21 = new Vector2(hook.pos)).sub(hook.basePos);
/* 136 */           vector21.nor();
/* 137 */           vector21.scl(f1);
/* 138 */           hook.drawPos.set(hook.pos).sub(vector21);
/*     */         } 
/*     */       }  return;
/*     */     } 
/* 142 */     for (byte b = 0; b < this.j.size; b++) {
/*     */       Hook hook;
/* 144 */       (hook = ((Hook[])this.j.items)[b]).drawPos.set(hook.pos);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawWeapon(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/*     */     byte b1, b2;
/* 152 */     paramFloat2 = StrictMath.abs(paramFloat1 = this.h - this.g);
/*     */ 
/*     */     
/* 155 */     if ((paramFloat3 = (paramFloat1 < 0.0F) ? (paramFloat4 * 2.0F) : (paramFloat4 * 0.5F)) >= paramFloat2) {
/*     */       
/* 157 */       this.g = this.h;
/* 158 */       if (this.g == 0.0F) {
/*     */         
/* 160 */         b1 = 0;
/* 161 */         for (b2 = 0; b2 < this.j.size; b2++) {
/* 162 */           if ((((Hook[])this.j.items)[b2]).status == 3) {
/* 163 */             b1 = 1;
/*     */             break;
/*     */           } 
/*     */         } 
/* 167 */         if (b1)
/*     */         {
/* 169 */           this.h = 1.0F;
/*     */         }
/*     */       } else {
/*     */         
/* 173 */         this.h = 0.0F;
/*     */       } 
/*     */     } else {
/*     */       
/* 177 */       this.g += b1 * paramFloat3 / b2;
/*     */       
/* 179 */       b1 = 0;
/* 180 */       for (b2 = 0; b2 < this.j.size; b2++) {
/* 181 */         if ((((Hook[])this.j.items)[b2]).status == 2 && (
/*     */           
/* 183 */           paramFloat3 = PMath.getSquareDistanceBetweenPoints((((Hook[])this.j.items)[b2]).drawPos.x, (((Hook[])this.j.items)[b2]).drawPos.y, (((Hook[])this.j.items)[b2]).basePos.x, (((Hook[])this.j.items)[b2]).basePos.y)) < 4096.0F) {
/* 184 */           b1 = 1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 189 */       if (b1)
/*     */       {
/* 191 */         this.h = 0.0F;
/*     */       }
/*     */     } 
/*     */     
/* 195 */     if ((getTile()).visibleOnScreen && !isOutOfOrder()) {
/*     */       Quad quad1, quad2;
/* 197 */       for (b1 = 0; b1 < this.j.size; b1++) {
/*     */         Hook hook;
/*     */ 
/*     */         
/* 201 */         if ((paramFloat3 = PMath.getDistanceBetweenPoints((hook = ((Hook[])this.j.items)[b1]).basePos.x, hook.basePos.y, hook.pos.x, hook.pos.y) / 64.0F) > 1.0F) paramFloat3 = 1.0F;
/*     */         
/* 203 */         if (hook.status == 2) {
/*     */ 
/*     */           
/* 206 */           paramFloat4 = 1.0F;
/*     */           
/* 208 */           if (hook.enemyStartDistance != 0.0F) {
/*     */             float f1;
/* 210 */             paramFloat4 = (f1 = PMath.getDistanceBetweenPoints(hook.drawPos, hook.basePos) / hook.enemyStartDistance) * 0.4F + 0.6F;
/*     */           } 
/* 212 */           paramFloat4 *= paramFloat3;
/*     */ 
/*     */           
/* 215 */           DrawUtils.texturedLineC(paramBatch, Game.i.towerManager.F.CRUSHER.f, hook.basePos.x, hook.basePos.y, hook.drawPos.x, hook.drawPos.y, 8.0F * paramFloat3, e, f);
/*     */ 
/*     */           
/* 218 */           paramFloat3 = PMath.getAngleBetweenPoints(hook.basePos, hook.drawPos);
/* 219 */           paramBatch.draw(Game.i.towerManager.F.CRUSHER.e, hook.drawPos.x - 23.0F * paramFloat4, hook.drawPos.y - 22.0F * paramFloat4, 23.0F * paramFloat4, 22.0F * paramFloat4, 46.0F * paramFloat4, 44.0F * paramFloat4, 1.0F, 1.0F, paramFloat3);
/* 220 */         } else if (hook.status == 1) {
/*     */ 
/*     */ 
/*     */           
/* 224 */           DrawUtils.texturedLineC(paramBatch, Game.i.towerManager.F.CRUSHER.f, hook.basePos.x, hook.basePos.y, hook.drawPos.x, hook.drawPos.y, 8.0F * paramFloat3, e, f);
/*     */ 
/*     */           
/* 227 */           paramFloat4 = PMath.getAngleBetweenPoints(hook.basePos, hook.drawPos);
/* 228 */           paramBatch.draw(Game.i.towerManager.F.CRUSHER.e, hook.drawPos.x - 23.0F * paramFloat3, hook.drawPos.y - 22.0F * paramFloat3, 23.0F * paramFloat3, 22.0F * paramFloat3, 46.0F * paramFloat3, 44.0F * paramFloat3, 1.0F, 1.0F, paramFloat4);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 233 */       for (b1 = 0; b1 < this.j.size; b1++) {
/*     */         Hook hook;
/* 235 */         if ((hook = ((Hook[])this.j.items)[b1]).status == 3) {
/*     */           Enemy enemy;
/*     */           
/* 238 */           if ((enemy = hook.getTarget()) != null) {
/* 239 */             TextureRegion textureRegion = enemy.getTexture();
/* 240 */             float f2 = 24.0F / enemy.getSize() * 2.0F;
/* 241 */             float f1 = textureRegion.getRegionWidth() * f2;
/* 242 */             paramBatch.draw(textureRegion, hook.basePos.x - f1 * 0.5F, hook.basePos.y - f1 * 0.5F, f1 * 0.5F, f1 * 0.5F, f1, f1, 1.0F + this.g * 0.3F, 1.0F - this.g * 0.6F, 0.0F);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 248 */       float f = this.g * 8.0F;
/*     */ 
/*     */       
/* 251 */       if (isAbilityInstalled(0)) {
/* 252 */         quad1 = Game.i.towerManager.F.CRUSHER.d[0];
/* 253 */         quad2 = Game.i.towerManager.F.CRUSHER.d[1];
/*     */       } else {
/* 255 */         quad1 = Game.i.towerManager.F.CRUSHER.c[0];
/* 256 */         quad2 = Game.i.towerManager.F.CRUSHER.c[1];
/*     */       } 
/*     */       
/* 259 */       quad1.draw(paramBatch, (getTile()).boundingBox.minX, (getTile()).boundingBox.minY - f, 128.0F, 128.0F);
/* 260 */       quad2.draw(paramBatch, (getTile()).boundingBox.minX, (getTile()).boundingBox.minY + f, 128.0F, 128.0F);
/*     */ 
/*     */       
/* 263 */       for (byte b = 0; b < this.j.size; b++) {
/*     */         Hook hook;
/* 265 */         Enemy enemy = (hook = ((Hook[])this.j.items)[b]).getTarget();
/* 266 */         if (hook.status == 2 && enemy != null) {
/*     */           
/* 268 */           f = 1.0F;
/* 269 */           if (hook.enemyStartDistance != 0.0F) {
/* 270 */             f = PMath.getDistanceBetweenPoints(hook.drawPos, hook.basePos) / hook.enemyStartDistance;
/*     */           }
/*     */           
/* 273 */           TextureRegion textureRegion = enemy.getTexture();
/* 274 */           float f1 = 24.0F / enemy.getSize() * 2.0F;
/* 275 */           f1 = (1.0F - f1) * f + f1;
/* 276 */           f1 = textureRegion.getRegionWidth() * f1;
/* 277 */           f = enemy.drawAngle * f;
/* 278 */           paramBatch.draw(textureRegion, hook.drawPos.x - f1 * 0.5F, hook.drawPos.y - f1 * 0.5F, f1 * 0.5F, f1 * 0.5F, f1, f1, 1.0F, 1.0F, f);
/*     */           
/* 280 */           f = paramBatch.getPackedColor();
/* 281 */           enemy.healthBarInvisible = true;
/* 282 */           enemy.drawPosition.set(hook.drawPos.x, hook.drawPos.y);
/* 283 */           enemy.drawHealth(paramBatch);
/* 284 */           paramBatch.setPackedColor(f);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
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
/*     */ 
/*     */   
/*     */   public final void drawBatchAdditive(Batch paramBatch, float paramFloat) {
/* 302 */     super.drawBatchAdditive(paramBatch, paramFloat);
/* 303 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_BUILDING_INFO) != 0.0D) {
/*     */       
/* 305 */       BitmapFont bitmapFont = Game.i.assetManager.getSmallDebugFont();
/* 306 */       for (byte b = 0; b < this.j.size; b++) {
/* 307 */         Hook hook = ((Hook[])this.j.items)[b];
/*     */         
/* 309 */         bitmapFont.draw(paramBatch, hook.status, hook.drawPos.x, hook.drawPos.y);
/* 310 */         if (Hook.a(hook) != null && (Hook.a(hook)).enemy != null) {
/* 311 */           DrawUtils.texturedLineB(paramBatch, (TextureRegion)(AssetManager.TextureRegions.i()).blank, hook.drawPos.x, hook.drawPos.y, ((Hook.a(hook)).enemy.getPosition()).x, ((Hook.a(hook)).enemy.getPosition()).y, 1.0F);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean canAim() {
/* 321 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean shouldSearchForTarget() {
/* 326 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean canAttack() {
/* 331 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float calculateStat(TowerStatType paramTowerStatType) {
/* 338 */     float f = super.calculateStat(paramTowerStatType);
/*     */     
/* 340 */     if (paramTowerStatType == TowerStatType.U_BONUS_EXPERIENCE && isAbilityInstalled(2)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_CAREFUL_PROCESSING)); 
/* 341 */     if (paramTowerStatType == TowerStatType.U_SHARED_DAMAGE && isAbilityInstalled(0)) f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_HEAVY_VICE));
/*     */     
/* 343 */     return f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void updateCache() {
/* 348 */     super.updateCache();
/*     */     
/* 350 */     this.i = isAbilityInstalled(1) ? this.S.gameValue.getIntValue(GameValueType.TOWER_CRUSHER_A_INCREASED_CAPACITY) : 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 358 */     for (byte b = 0; b < this.j.size; b++) {
/*     */       Hook hook;
/* 360 */       if ((hook = ((Hook[])this.j.items)[b]).status == 3) {
/*     */         Enemy enemy;
/*     */         
/* 363 */         if ((enemy = hook.getTarget()) != null) {
/* 364 */           enemy.drawPosition.set(hook.basePos.x, hook.basePos.y);
/* 365 */           enemy.healthBarInvisible = true;
/* 366 */           enemy.drawHealth(paramBatch);
/*     */         } 
/*     */       } 
/*     */     } 
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
/* 380 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */     
/* 382 */     super.drawBatch(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   private void a() {
/* 386 */     for (byte b = 0; b < this.j.size; b++) {
/*     */       Hook hook;
/* 388 */       if (((hook = ((Hook[])this.j.items)[b]).status == 2 || hook.status == 3) && hook.getTarget() != null) {
/*     */         Enemy enemy;
/* 390 */         (enemy = hook.getTarget()).disabled.removeReason("CrusherTower");
/* 391 */         enemy.invisible.removeReason("CrusherTower");
/* 392 */         enemy.healthBarInvisible = false;
/* 393 */         enemy.setPositionToPath();
/* 394 */         enemy.chasedByCrusher = false;
/*     */ 
/*     */ 
/*     */         
/* 398 */         hook.status = 0;
/* 399 */         Hook.a(hook, Enemy.EnemyReference.NULL);
/* 400 */         hook.recruiting = false;
/*     */       } 
/* 402 */       if (hook.status == 1 && hook.getTarget() != null) {
/*     */         Enemy enemy;
/* 404 */         (enemy = hook.getTarget()).chasedByCrusher = false;
/*     */ 
/*     */ 
/*     */         
/* 408 */         hook.status = 0;
/* 409 */         Hook.a(hook, Enemy.EnemyReference.NULL);
/* 410 */         hook.recruiting = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onPreSell() {
/* 417 */     a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 423 */     if (this.j.size != this.i) {
/* 424 */       if (this.j.size > this.i) {
/*     */         
/* 426 */         a();
/* 427 */         this.j.clear();
/*     */       } 
/*     */       
/* 430 */       if (this.j.size < this.i) {
/*     */         
/* 432 */         while (this.j.size < this.i) {
/*     */           Hook hook;
/* 434 */           (hook = new Hook()).basePos.set((getTile()).center);
/* 435 */           hook.pos.set((getTile()).center);
/* 436 */           this.j.add(hook);
/*     */         } 
/*     */         
/* 439 */         for (byte b = 0; b < this.j.size; b++) {
/*     */           float f1;
/* 441 */           if (this.j.size == 1) {
/* 442 */             f1 = 0.5F;
/*     */           } else {
/* 444 */             f1 = b / (this.j.size - 1.0F);
/*     */           } 
/*     */           
/* 447 */           float f2 = 56.0F + 16.0F * f1;
/* 448 */           float f3 = -0.5F + f1;
/* 449 */           (((Hook[])this.j.items)[b]).basePos.set((getTile()).center.x - 64.0F + f2, (getTile()).center.y + f3);
/* 450 */           if ((((Hook[])this.j.items)[b]).status == 0) {
/* 451 */             (((Hook[])this.j.items)[b]).pos.set((((Hook[])this.j.items)[b]).basePos);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 459 */     if (!isOutOfOrder()) {
/* 460 */       float f = getStat(TowerStatType.PROJECTILE_SPEED) * 128.0F;
/*     */ 
/*     */       
/* 463 */       byte b1 = 0; byte b2;
/* 464 */       for (b2 = 0; b2 < this.j.size; b2++) {
/*     */         Hook hook;
/*     */         
/* 467 */         if ((hook = ((Hook[])this.j.items)[b2]).status == 3) {
/* 468 */           b1++;
/*     */         }
/*     */       } 
/*     */       
/* 472 */       for (b2 = 0; b2 < this.j.size; b2++) {
/*     */         Hook hook;
/*     */ 
/*     */         
/* 476 */         if ((hook = ((Hook[])this.j.items)[b2]).status == 0 || (hook.status == 2 && hook.getTarget() == null))
/*     */         {
/*     */           
/* 479 */           if (!hook.missedTarget) {
/*     */             
/* 481 */             hook.framesSinceEnemySearch = (byte)(hook.framesSinceEnemySearch + 1);
/* 482 */             if (hook.framesSinceEnemySearch == 3) {
/* 483 */               hook.framesSinceEnemySearch = 0;
/*     */               
/* 485 */               Enemy enemy = null;
/* 486 */               if (!this.attackDisabled) {
/*     */                 
/* 488 */                 Vector2 vector2 = hook.basePos;
/* 489 */                 enemy = findTargetFiltered(paramEnemy -> !paramEnemy.chasedByCrusher ? (
/*     */                     
/* 491 */                     (paramEnemy.caughtByCrushersSet == null || !paramEnemy.caughtByCrushersSet.contains(this.id)) ? ((paramVector2.dst2(paramEnemy.getPosition()) < this.rangeInPixels * this.rangeInPixels)) : false) : false);
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 502 */               if (enemy != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 508 */                 hook.status = 1;
/* 509 */                 Hook.a(hook, this.S.enemy.getReference(enemy));
/* 510 */                 hook.chewingTime = 0.0F;
/* 511 */                 hook.startingHealth = 0.0F;
/* 512 */                 enemy.chasedByCrusher = true;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 519 */         if (hook.status == 1 && 
/* 520 */           hook.getTarget() == null)
/*     */         {
/* 522 */           hook.status = 2;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 533 */         if (hook.status == 1) {
/*     */ 
/*     */           
/* 536 */           Enemy enemy = hook.getTarget();
/*     */           Vector2 vector2;
/* 538 */           (vector2 = new Vector2(enemy.getPosition())).sub(hook.pos);
/* 539 */           vector2.nor();
/* 540 */           vector2.scl(f * paramFloat);
/*     */ 
/*     */           
/* 543 */           float f2 = hook.pos.x;
/* 544 */           float f3 = hook.pos.y;
/* 545 */           hook.pos.add(vector2);
/*     */ 
/*     */           
/*     */           float f1;
/*     */           
/* 550 */           if ((f1 = hook.basePos.dst2(enemy.getPosition())) > this.rangeInPixels * this.rangeInPixels) {
/*     */ 
/*     */ 
/*     */             
/* 554 */             enemy.chasedByCrusher = false;
/* 555 */             hook.status = 2;
/* 556 */             Hook.a(hook, Enemy.EnemyReference.NULL);
/*     */           } else {
/* 558 */             Vector2 vector21 = enemy.getPosition();
/* 559 */             if (Intersector.intersectSegmentCircle(hook.pos.x, hook.pos.y, f2, f3, vector21.x, vector21.y, 40.960003F))
/*     */             {
/*     */               
/* 562 */               if (enemy.caughtByCrushersSet == null || !enemy.caughtByCrushersSet.contains(this.id)) {
/*     */                 
/* 564 */                 f1 = this.S.gameState.randomFloat();
/*     */                 
/* 566 */                 double d = StrictMath.pow(0.699999988079071D, enemy.totalCatchesByCrushers);
/* 567 */                 if (f1 <= d) {
/*     */ 
/*     */                   
/* 570 */                   hook.status = 2;
/* 571 */                   hook.enemyStartPos.set(enemy.drawPosition);
/* 572 */                   hook.enemyStartDistance = PMath.getDistanceBetweenPoints(hook.basePos, enemy.drawPosition);
/*     */                   
/* 574 */                   enemy.invisible.addReason("CrusherTower");
/* 575 */                   enemy.disabled.addReason("CrusherTower");
/*     */                   
/* 577 */                   if (enemy.caughtByCrushersSet == null) {
/* 578 */                     enemy.caughtByCrushersSet = new IntSet();
/*     */                   }
/* 580 */                   enemy.caughtByCrushersSet.add(this.id);
/* 581 */                   enemy.totalCatchesByCrushers++;
/*     */                 }
/*     */                 else {
/*     */                   
/* 585 */                   enemy.chasedByCrusher = false;
/* 586 */                   hook.status = 2;
/* 587 */                   hook.missedTarget = true;
/* 588 */                   Hook.a(hook, Enemy.EnemyReference.NULL);
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           } 
/* 593 */         } else if (hook.status == 2) {
/*     */           float f1;
/*     */           
/* 596 */           if (hook.getTarget() == null) {
/* 597 */             f1 = 256.0F * paramFloat;
/*     */           } else {
/* 599 */             f1 = 192.0F * paramFloat;
/*     */           } 
/*     */           float f2;
/* 602 */           if ((f2 = PMath.getSquareDistanceBetweenPoints(hook.pos.x, hook.pos.y, hook.basePos.x, hook.basePos.y)) < f1 * f1) {
/*     */ 
/*     */             
/* 605 */             hook.pos.set(hook.basePos);
/* 606 */             hook.missedTarget = false;
/*     */             Enemy enemy1;
/* 608 */             if ((enemy1 = hook.getTarget()) == null) {
/*     */               
/* 610 */               hook.status = 0;
/* 611 */               hook.recruiting = false;
/*     */             } else {
/* 613 */               boolean bool = false;
/*     */               
/* 615 */               if (isAbilityInstalled(3)) {
/*     */                 
/* 617 */                 f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_DISORIENTATION_CHANCE_MAX);
/*     */                 float f3;
/* 619 */                 f2 = (f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_DISORIENTATION_CHANCE_MAX)) + (f2 - f3) * getUpgradeLevel() / 10.0F;
/*     */                 float f4;
/* 621 */                 if ((f4 = this.S.gameState.randomFloat()) < f2) {
/* 622 */                   bool = true;
/*     */                 }
/*     */               } 
/* 625 */               enemy1.setPosition(hook.basePos);
/* 626 */               enemy1.drawPosition.set(hook.basePos);
/*     */               
/* 628 */               hook.status = 3;
/* 629 */               hook.chewingTime = 0.0F;
/* 630 */               hook.startingHealth = enemy1.getHealth();
/* 631 */               hook.recruiting = bool;
/*     */               
/*     */               BonusXpBuff bonusXpBuff;
/* 634 */               (bonusXpBuff = new BonusXpBuff()).setup(getStat(TowerStatType.DURATION), getStat(TowerStatType.DURATION) * 10.0F, getStat(TowerStatType.U_BONUS_EXPERIENCE) * 0.01F, this);
/* 635 */               this.S.buff.P_BONUS_XP.addBuff(enemy1, bonusXpBuff);
/*     */             } 
/*     */           } else {
/*     */             Vector2 vector2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 664 */             (vector2 = new Vector2(hook.pos)).sub(hook.basePos);
/* 665 */             vector2.nor();
/* 666 */             vector2.scl(f1);
/* 667 */             hook.pos.sub(vector2);
/*     */           } 
/*     */           
/*     */           Enemy enemy;
/*     */           
/* 672 */           if ((enemy = hook.getTarget()) == null) {
/*     */ 
/*     */             
/* 675 */             hook.recruiting = false;
/*     */           } else {
/*     */             Tile tile;
/* 678 */             if ((tile = this.S.map.getMap().getTileByMapPos(hook.pos.x, hook.pos.y)) != null) {
/*     */               
/* 680 */               enemy.setPosition(hook.pos);
/* 681 */               enemy.drawPosition.set(hook.pos);
/*     */             } 
/*     */           } 
/* 684 */         } else if (hook.status == 3) {
/*     */           Enemy enemy;
/*     */           
/* 687 */           if ((enemy = hook.getTarget()) == null) {
/*     */ 
/*     */             
/* 690 */             hook.status = 0;
/*     */             
/* 692 */             hook.recruiting = false;
/*     */           } else {
/*     */             
/* 695 */             float f1 = getStat(TowerStatType.DAMAGE) * paramFloat;
/*     */             
/* 697 */             int i = Math.max(1, b1);
/* 698 */             float f2 = f1 * getStat(TowerStatType.U_SHARED_DAMAGE) * 0.01F / i;
/*     */ 
/*     */             
/* 701 */             if ((f1 = f1 + f2) > 0.0F) {
/* 702 */               this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, f1, DamageType.BULLET).setTower(this));
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 711 */             hook.chewingTime += paramFloat;
/*     */             
/* 713 */             boolean bool = false;
/* 714 */             if (hook.chewingTime >= getStat(TowerStatType.DURATION)) {
/*     */               
/* 716 */               if (hook.recruiting) {
/*     */                 
/* 718 */                 float f3 = (hook.startingHealth - enemy.getHealth()) / enemy.maxHealth * 0.33F;
/* 719 */                 if (this.S.gameState.randomFloat() < f3)
/*     */                 {
/* 721 */                   bool = true;
/*     */                 }
/*     */               } 
/*     */               
/* 725 */               if (!bool) {
/*     */                 
/* 727 */                 enemy.disabled.removeReason("CrusherTower");
/* 728 */                 enemy.invisible.removeReason("CrusherTower");
/* 729 */                 enemy.healthBarInvisible = false;
/* 730 */                 enemy.chasedByCrusher = false;
/* 731 */                 enemy.setPositionToPath();
/*     */ 
/*     */                 
/* 734 */                 hook.status = 0;
/* 735 */                 Hook.a(hook, Enemy.EnemyReference.NULL);
/* 736 */                 hook.recruiting = false;
/*     */               } 
/* 738 */             } else if (hook.recruiting && hook.startingHealth - enemy.getHealth() > enemy.maxHealth * 0.33F) {
/*     */               
/* 740 */               bool = true;
/*     */             } 
/*     */             
/* 743 */             if (bool) {
/*     */               
/* 745 */               DisorientedUnit disorientedUnit = Game.i.unitManager.F.DISORIENTED.create();
/* 746 */               float f3 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_ULTIMATE_UNIT_HP);
/* 747 */               disorientedUnit.setup(this, enemy.type, enemy.getHealth() * f3, enemy.maxHealth * f3);
/* 748 */               if (this.S.unit.preparePathToRandomSpawn((Unit)disorientedUnit, this.S.map.getMap().getTileByMapPos((enemy.getPosition()).x, (enemy.getPosition()).y))) {
/* 749 */                 this.S.unit.register((Unit)disorientedUnit);
/* 750 */                 this.S.map.spawnUnit((Unit)disorientedUnit);
/*     */                 
/* 752 */                 if (isAbilityInstalled(4)) {
/* 753 */                   if (this.bountyModifiersNearby != 0) {
/*     */                     
/* 755 */                     disorientedUnit.coinsPerTilePassed = 0.0F;
/* 756 */                     disorientedUnit.maxSumCoins = 0;
/*     */                   } else {
/* 758 */                     disorientedUnit.setCoinsPerTilePassed(getDisorientedUnitCoinPerTile(), (int)(enemy.bounty * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_ULTIMATE_COINS_LIMIT)));
/*     */                   } 
/*     */                 }
/*     */                 
/* 762 */                 if (enemy.type == EnemyType.METAPHOR_BOSS_CREEP) {
/* 763 */                   this.S.achievement.registerDelta(AchievementType.RECRUIT_SPIDER, 1);
/*     */                 }
/*     */               } 
/*     */               
/* 767 */               this.S.damage.queueEnemyKill(this.S.damage.obtainRecord().setup(enemy, 1.0F, DamageType.BULLET).setTower(this));
/*     */               
/* 769 */               hook.status = 0;
/* 770 */               Hook.a(hook, Enemy.EnemyReference.NULL);
/* 771 */               hook.recruiting = false;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 778 */       a();
/*     */     } 
/*     */     
/* 781 */     super.update(paramFloat);
/*     */   }
/*     */   
/*     */   public final float getDisorientedUnitCoinPerTile() {
/* 785 */     return this.S.gameValue.getFloatValue(GameValueType.TOWER_CRUSHER_A_ULTIMATE_COINS);
/*     */   }
/*     */   
/*     */   public final float getDisorientationChance() {
/* 789 */     float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_CRUSHER_A_DISORIENTATION_CHANCE_MIN);
/* 790 */     float f2 = this.S.gameValue.getFloatValue(GameValueType.TOWER_CRUSHER_A_DISORIENTATION_CHANCE_MAX);
/* 791 */     float f3 = getUpgradeLevel() / 10.0F;
/* 792 */     return f1 + (f2 - f1) * f3;
/*     */   }
/*     */   
/*     */   public static class CrusherTowerFactory
/*     */     extends Tower.Factory<CrusherTower> {
/*     */     Quad[] c;
/*     */     Quad[] d;
/*     */     TextureRegion e;
/*     */     TextureRegion f;
/*     */     
/*     */     public CrusherTowerFactory() {
/* 803 */       super("tower-crusher", TowerType.CRUSHER);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setup() {
/* 808 */       super.setup();
/*     */       
/* 810 */       (this.b[0]).descriptionArgs = (Object[])new String[] { "" };
/* 811 */       (this.b[1]).descriptionArgs = (Object[])new String[] { "" };
/* 812 */       (this.b[2]).descriptionArgs = (Object[])new String[] { "" };
/* 813 */       (this.b[3]).descriptionArgs = (Object[])new String[] { "" };
/* 814 */       (this.b[4]).descriptionArgs = (Object[])new String[] { "", "" };
/*     */     }
/*     */     
/*     */     @Null
/*     */     public CharSequence getStatMoreInfo(TowerStatType param1TowerStatType, GameValueProvider param1GameValueProvider, Tower param1Tower) {
/* 819 */       if (param1TowerStatType == TowerStatType.U_BONUS_EXPERIENCE)
/* 820 */         return Game.i.localeManager.i18n.get("tower_stat_more_info_CRUSHER_U_BONUS_EXPERIENCE"); 
/* 821 */       if (param1TowerStatType == TowerStatType.U_SHARED_DAMAGE) {
/* 822 */         return Game.i.localeManager.i18n.get("tower_stat_more_info_CRUSHER_U_SHARED_DAMAGE");
/*     */       }
/* 824 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Tower.AbilityConfig[] getAbilityConfigs(GameSystemProvider param1GameSystemProvider, Tower param1Tower) {
/* 830 */       Tower.AbilityConfig[] arrayOfAbilityConfig = super.getAbilityConfigs(param1GameSystemProvider, param1Tower);
/*     */       
/* 832 */       double d1 = param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_HEAVY_VICE);
/* 833 */       (arrayOfAbilityConfig[0]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(d1, 2, true).toString();
/*     */       
/* 835 */       double d2 = param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_CRUSHER_A_INCREASED_CAPACITY);
/* 836 */       (arrayOfAbilityConfig[1]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(d2, 0, true).toString();
/*     */       
/* 838 */       double d3 = param1GameSystemProvider.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CRUSHER_A_CAREFUL_PROCESSING);
/* 839 */       (arrayOfAbilityConfig[2]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(d3, 2, true).toString();
/*     */       
/* 841 */       (arrayOfAbilityConfig[3]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(((CrusherTower)param1Tower).getDisorientationChance(), 1, true).toString();
/*     */       
/* 843 */       int i = param1GameSystemProvider.gameValue.getIntValue(GameValueType.TOWER_CRUSHER_A_ULTIMATE_COINS_LIMIT);
/* 844 */       (arrayOfAbilityConfig[4]).descriptionArgs[0] = StringFormatter.compactNumberWithPrecisionTrimZeros(((CrusherTower)param1Tower).getDisorientedUnitCoinPerTile(), 1, true).toString();
/* 845 */       (arrayOfAbilityConfig[4]).descriptionArgs[1] = StringFormatter.compactNumberWithPrecisionTrimZeros(i, 1, true).toString();
/*     */       
/* 847 */       return arrayOfAbilityConfig;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean shouldDrawAbilityToCache(int param1Int) {
/* 853 */       if (param1Int == 0) {
/* 854 */         return false;
/*     */       }
/* 856 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 861 */       this.e = (TextureRegion)Game.i.assetManager.getTextureRegion("tower-crusher-hook");
/* 862 */       this.f = (TextureRegion)Game.i.assetManager.getTextureRegion("crusher-chain");
/*     */       
/* 864 */       this
/*     */         
/* 866 */         .c = new Quad[] { Game.i.assetManager.getQuad("towers." + TowerType.CRUSHER.name() + ".vices.regular.top"), Game.i.assetManager.getQuad("towers." + TowerType.CRUSHER.name() + ".vices.regular.bottom") };
/*     */       
/* 868 */       this
/*     */         
/* 870 */         .d = new Quad[] { Game.i.assetManager.getQuad("towers." + TowerType.CRUSHER.name() + ".vices.heavy.top"), Game.i.assetManager.getQuad("towers." + TowerType.CRUSHER.name() + ".vices.heavy.bottom") };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBuildPrice(GameSystemProvider param1GameSystemProvider) {
/* 876 */       int i = super.getBuildPrice(param1GameSystemProvider);
/*     */ 
/*     */       
/* 879 */       byte b1 = 0;
/* 880 */       for (byte b2 = 0; b2 < param1GameSystemProvider.tower.towers.size; b2++) {
/*     */         Tower tower;
/* 882 */         if ((tower = ((Tower[])param1GameSystemProvider.tower.towers.items)[b2]).type == TowerType.CRUSHER) {
/* 883 */           b1++;
/*     */         }
/*     */       } 
/*     */       
/* 887 */       float f = 1.0F + (float)StrictMath.pow(b1, 1.600000023841858D);
/*     */       
/* 889 */       return (int)(i * f);
/*     */     }
/*     */     
/*     */     public Color getColor() {
/* 893 */       return MaterialColor.BROWN.P500;
/*     */     }
/*     */     
/*     */     public int getGeneralizedStat(GeneralizedTowerStatType param1GeneralizedTowerStatType) {
/* 897 */       switch (CrusherTower.null.a[param1GeneralizedTowerStatType.ordinal()]) { case 1:
/* 898 */           return 1;
/* 899 */         case 2: return 1;
/* 900 */         case 3: return 5;
/* 901 */         case 4: return 1;
/* 902 */         case 5: return 1; }
/* 903 */        return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getAbilityAliases() {
/* 909 */       return CrusherTower.ABILITY_ALIASES;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getBuildHotKey() {
/* 914 */       return 49;
/*     */     }
/*     */ 
/*     */     
/*     */     public CrusherTower create() {
/* 919 */       return new CrusherTower((byte)0);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class Hook implements KryoSerializable {
/* 925 */     private Enemy.EnemyReference a = Enemy.EnemyReference.NULL;
/* 926 */     public Vector2 basePos = new Vector2();
/* 927 */     public Vector2 pos = new Vector2();
/* 928 */     public int status = 0;
/*     */     
/*     */     public boolean missedTarget;
/*     */     public float startingHealth;
/*     */     public float chewingTime;
/*     */     @FrameAccumulatorForPerformance
/*     */     public byte framesSinceEnemySearch;
/*     */     public boolean recruiting;
/*     */     @NAGS
/* 937 */     public Vector2 drawPos = new Vector2(); @NAGS
/* 938 */     public Vector2 enemyStartPos = new Vector2();
/*     */     
/*     */     @NAGS
/*     */     public float enemyStartDistance;
/*     */     
/*     */     public void write(Kryo param1Kryo, Output param1Output) {
/* 944 */       param1Kryo.writeObject(param1Output, this.a);
/* 945 */       param1Kryo.writeObject(param1Output, this.basePos);
/* 946 */       param1Kryo.writeObject(param1Output, this.pos);
/* 947 */       param1Output.writeByte(this.status);
/* 948 */       param1Output.writeBoolean(this.missedTarget);
/* 949 */       param1Output.writeFloat(this.startingHealth);
/* 950 */       param1Output.writeFloat(this.chewingTime);
/* 951 */       param1Output.writeByte(this.framesSinceEnemySearch);
/* 952 */       param1Output.writeBoolean(this.recruiting);
/*     */     }
/*     */ 
/*     */     
/*     */     public void read(Kryo param1Kryo, Input param1Input) {
/* 957 */       this.a = (Enemy.EnemyReference)param1Kryo.readObject(param1Input, Enemy.EnemyReference.class);
/* 958 */       this.basePos = (Vector2)param1Kryo.readObject(param1Input, Vector2.class);
/* 959 */       this.pos = (Vector2)param1Kryo.readObject(param1Input, Vector2.class);
/* 960 */       this.status = param1Input.readByte();
/* 961 */       this.missedTarget = param1Input.readBoolean();
/* 962 */       this.startingHealth = param1Input.readFloat();
/* 963 */       this.chewingTime = param1Input.readFloat();
/* 964 */       this.framesSinceEnemySearch = param1Input.readByte();
/* 965 */       this.recruiting = param1Input.readBoolean();
/*     */     }
/*     */     
/*     */     public Enemy getTarget() {
/* 969 */       return this.a.enemy;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\towers\CrusherTower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */