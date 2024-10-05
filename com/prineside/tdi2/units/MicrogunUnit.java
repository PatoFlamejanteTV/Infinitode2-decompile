/*     */ package com.prineside.tdi2.units;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.graphics.g2d.Sprite;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.managers.AssetManager;
/*     */ import com.prineside.tdi2.shapes.BulletSmokeMultiLine;
/*     */ import com.prineside.tdi2.shapes.RangeCircle;
/*     */ import com.prineside.tdi2.systems.MapSystem;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.towers.MinigunTower;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MicrogunUnit
/*     */   extends Unit {
/*     */   public MinigunTower parent;
/*     */   private float a;
/*     */   private float b;
/*  46 */   private Enemy.EnemyReference c = Enemy.EnemyReference.NULL;
/*     */   @NAGS
/*  48 */   private final Vector2 d = new Vector2(); @NAGS
/*  49 */   private final Vector2 e = new Vector2(); @NAGS
/*     */   private float f;
/*     */   @NAGS
/*     */   private float g;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  55 */     super.write(paramKryo, paramOutput);
/*  56 */     paramKryo.writeClassAndObject(paramOutput, this.parent);
/*  57 */     paramKryo.writeObject(paramOutput, this.c);
/*  58 */     paramOutput.writeFloat(this.a);
/*  59 */     paramOutput.writeFloat(this.b);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  64 */     super.read(paramKryo, paramInput);
/*  65 */     this.parent = (MinigunTower)paramKryo.readClassAndObject(paramInput);
/*  66 */     this.c = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  67 */     this.a = paramInput.readFloat();
/*  68 */     this.b = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private MicrogunUnit() {
/*  72 */     super(UnitType.MICROGUN);
/*     */   }
/*     */   
/*     */   public final void setup(MinigunTower paramMinigunTower, float paramFloat1, float paramFloat2) {
/*  76 */     this.parent = paramMinigunTower;
/*  77 */     this.angle = 0.0F;
/*     */     
/*  79 */     this.staticPosition = true;
/*  80 */     this.position.set(paramFloat1, paramFloat2);
/*     */   }
/*     */   
/*     */   public final float getSize() {
/*  84 */     return 32.0F;
/*     */   }
/*     */   public final void drawRange(Batch paramBatch, RangeCircle paramRangeCircle) {
/*  87 */     float f1 = this.position.x;
/*  88 */     float f2 = this.position.y;
/*  89 */     float f3 = b();
/*     */     
/*  91 */     if (paramRangeCircle.getX() != f1 || paramRangeCircle.getY() != f2 || paramRangeCircle.getMinRadius() != 0.0F || paramRangeCircle.getMaxRadius() != f3) {
/*  92 */       paramRangeCircle.setup(f1, f2, 0.0F, f3, MapSystem.TOWER_RANGE_HOVER_COLOR);
/*     */     }
/*     */     
/*  95 */     paramRangeCircle.draw(paramBatch);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/* 101 */     paramBatch.draw(Game.i.unitManager.F.MICROGUN.a, this.drawPosition.x - 30.0F, this.drawPosition.y - 30.0F, 60.0F, 60.0F);
/*     */ 
/*     */     
/* 104 */     paramBatch.draw(Game.i.unitManager.F.MICROGUN.b, this.drawPosition.x - 12.0F, this.drawPosition.y - 12.0F, 12.0F, 12.0F, 24.0F, 48.0F, 1.0F, 1.0F, this.angle);
/*     */   }
/*     */ 
/*     */   
/*     */   private Enemy a() {
/* 109 */     float f1 = (f1 = b()) * f1;
/*     */     
/* 111 */     Enemy enemy = null;
/* 112 */     float f2 = Float.MAX_VALUE;
/*     */     
/* 114 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy enemy1;
/* 116 */       if ((enemy1 = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy) != null) {
/*     */         float f;
/*     */         
/* 119 */         if ((f = this.position.dst2(enemy1.getPosition())) < f1 && 
/* 120 */           this.parent.canAttackEnemy(enemy1) && 
/* 121 */           f2 > f) {
/* 122 */           enemy = enemy1;
/* 123 */           f2 = f;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     return enemy;
/*     */   }
/*     */   
/*     */   private float b() {
/* 133 */     return this.parent.rangeInPixels * (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_MICROGUN_RANGE);
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/*     */     Enemy enemy;
/* 138 */     if ((enemy = this.c.enemy) == null) {
/*     */       return;
/*     */     }
/*     */     
/* 142 */     if (this.S._gameUi != null) {
/* 143 */       this.d.set(this.position);
/* 144 */       PMath.shiftPointByAngle(this.d, this.angle, 38.0F);
/* 145 */       PMath.shiftPointByAngle(this.d, this.angle + 90.0F, 4.0F);
/*     */       
/* 147 */       (enemy.getPosition()).x += FastRandom.getFloat() * 4.0F;
/* 148 */       (enemy.getPosition()).y += FastRandom.getFloat() * 4.0F;
/*     */     } 
/*     */     
/* 151 */     this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(enemy, this.parent.getStat(TowerStatType.DAMAGE) * paramInt, DamageType.BULLET).setTower((Tower)this.parent));
/*     */ 
/*     */     
/* 154 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled() && (
/* 155 */       PMath.getDistanceBetweenAngles(this.f, this.angle) > 4.0F || this.g > 0.2F)) {
/*     */       
/* 157 */       this.f = this.angle;
/* 158 */       this.g = 0.0F;
/*     */       
/* 160 */       Vector2 vector2 = new Vector2();
/* 161 */       BulletSmokeMultiLine bulletSmokeMultiLine = (BulletSmokeMultiLine)Game.i.shapeManager.F.BULLET_SMOKE_MULTI_LINE.obtain();
/* 162 */       PMath.getPointByAngleFromPoint(this.position.x, this.position.y, this.angle, 36.0F, vector2);
/* 163 */       bulletSmokeMultiLine.setTexture(Game.i.towerManager.F.MINIGUN.bulletTraceTexture, false, (FastRandom.getFloat() < 0.5F));
/* 164 */       bulletSmokeMultiLine.setColor(MaterialColor.PURPLE.P200);
/* 165 */       bulletSmokeMultiLine.maxSegmentWidth = 32.0F;
/* 166 */       bulletSmokeMultiLine.nodesDisperseTime = 0.7F;
/* 167 */       bulletSmokeMultiLine.maxAlpha = 0.56F;
/* 168 */       bulletSmokeMultiLine.setup(vector2.x, vector2.y, this.e.x, this.e.y);
/* 169 */       this.S._projectileTrail.addTrail((ProjectileTrail)bulletSmokeMultiLine);
/*     */     } 
/*     */ 
/*     */     
/* 173 */     if (this.S._particle != null) {
/*     */       Vector2 vector2;
/* 175 */       (vector2 = new Vector2()).set(this.position.x, this.position.y);
/* 176 */       PMath.shiftPointByAngle(vector2, this.angle, 35.0F);
/* 177 */       this.S._particle.addFlashParticle((TextureRegion)(AssetManager.TextureRegions.i()).muzzleFlashSmall, vector2.x, vector2.y, 10.4F, 3.8999999F, 20.8F, 31.199999F, this.angle);
/*     */     } 
/*     */     
/* 180 */     if (this.S._sound != null) {
/* 181 */       this.S._sound.playShotSound(StaticSoundType.SHOT_MINIGUN, (Tower)this.parent);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void destroy(Enemy paramEnemy) {
/* 186 */     if (this.S._particle != null) {
/* 187 */       this.S._particle.addRegularShatterParticle(Game.i.unitManager.F.MICROGUN.a, this.position.x, this.position.y, 60.0F, 0.0F, 1.0F);
/*     */     }
/* 189 */     this.S.unit.killUnit(this, paramEnemy);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 194 */     if (!this.parent.isRegistered()) {
/* 195 */       destroy((Enemy)null);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     Tile tile;
/* 201 */     if ((tile = this.S.map.getMap().getTileByMapPos(this.position.x, this.position.y)).enemyCount != 0)
/* 202 */       this.S.map.getEnemiesInCircle(this.position.x, this.position.y, 16.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             if (paramEnemyReference.enemy == null) {
/*     */               return true;
/*     */             }
/*     */             destroy(paramEnemyReference.enemy);
/*     */             return false;
/*     */           }); 
/* 209 */     if (this.S == null)
/*     */       return; 
/* 211 */     if (tile.type == TileType.PLATFORM && 
/* 212 */       ((PlatformTile)tile).building != null) {
/* 213 */       destroy((Enemy)null);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 218 */     this.g += paramFloat;
/*     */     
/* 220 */     if (this.c.enemy == null) {
/* 221 */       this.a += paramFloat;
/* 222 */       if (this.a > 0.15F) {
/* 223 */         this.a = 0.0F;
/* 224 */         this.c = this.S.enemy.getReference(a());
/*     */       } 
/*     */     } 
/*     */     
/*     */     Enemy enemy;
/* 229 */     if ((enemy = this.c.enemy) != null) {
/* 230 */       float f1 = PMath.getSquareDistanceBetweenPoints(this.position.x, this.position.y, (enemy.getPosition()).x, (enemy.getPosition()).y);
/* 231 */       float f2 = b();
/*     */       
/* 233 */       boolean bool = false;
/* 234 */       float f3 = 1.0F / (float)(this.parent.getStat(TowerStatType.ATTACK_SPEED) * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MINIGUN_A_MICROGUN_ATTACK_SPEED));
/*     */       
/* 236 */       if (f1 < f2 * f2) {
/*     */         
/* 238 */         if (!this.parent.isOutOfOrder()) {
/*     */           
/* 240 */           rotateAt((enemy.getPosition()).x, (enemy.getPosition()).y, paramFloat, this.parent.getStat(TowerStatType.ROTATION_SPEED));
/*     */ 
/*     */           
/* 243 */           float f = PMath.getAngleBetweenPoints(this.position, enemy.getPosition());
/*     */ 
/*     */           
/* 246 */           if ((f = StrictMath.abs(PMath.getDistanceBetweenAngles(this.angle, f))) < 3.0F) {
/*     */             
/* 248 */             bool = true;
/*     */             
/*     */             int i;
/* 251 */             if ((i = (int)(this.b / f3)) > 0) {
/*     */               
/* 253 */               a(i);
/* 254 */               this.b -= f3 * i;
/* 255 */               if (this.b < 0.0F) this.b = 0.0F;
/*     */             
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 261 */         this.c = Enemy.EnemyReference.NULL;
/*     */       } 
/*     */       
/* 264 */       this.b += paramFloat;
/* 265 */       if (!bool && this.b > f3) {
/* 266 */         this.b = f3;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void rotateAt(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
/* 272 */     rotateToAngle(PMath.getAngleBetweenPoints(this.position.x, this.position.y, paramFloat1, paramFloat2), paramFloat3, paramFloat4);
/*     */   }
/*     */   
/*     */   public final void rotateToAngle(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 276 */     if (paramFloat1 == this.angle)
/*     */       return; 
/* 278 */     float f = PMath.getDistanceBetweenAngles(this.angle, paramFloat1);
/*     */ 
/*     */     
/* 281 */     if ((paramFloat2 = paramFloat2 * paramFloat3) < StrictMath.abs(f)) {
/*     */       
/* 283 */       if (f < 0.0F) {
/* 284 */         this.angle -= paramFloat2; return;
/*     */       } 
/* 286 */       this.angle += paramFloat2;
/*     */       
/*     */       return;
/*     */     } 
/* 290 */     this.angle = paramFloat1;
/*     */   }
/*     */   
/*     */   public static class MicrogunUnitFactory
/*     */     extends Unit.Factory.BasicAbstractFactory<MicrogunUnit>
/*     */   {
/*     */     TextureRegion a;
/*     */     TextureRegion b;
/*     */     public ParticleEffectPool highlightParticles;
/*     */     
/*     */     public void setupAssets() {
/* 301 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tower-minigun-microgun-base");
/* 302 */       this.b = (TextureRegion)Game.i.assetManager.getTextureRegion("tower-minigun-microgun-weapon");
/*     */       
/*     */       ParticleEffect particleEffect;
/* 305 */       (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/building-highlight.prt"), Game.i.assetManager.getTextureRegion("tower-basic-base").getAtlas());
/* 306 */       particleEffect.setEmittersCleanUpBlendFunction(false);
/* 307 */       ((ParticleEmitter)particleEffect.getEmitters().first()).setSprites(new Array((Object[])new Sprite[] { new Sprite(this.a) }));
/*     */ 
/*     */       
/* 310 */       this.highlightParticles = Game.i.assetManager.getParticleEffectPoolWithTemplate("building-highlight.prt@unitType:" + UnitType.MICROGUN.name(), particleEffect);
/*     */     }
/*     */ 
/*     */     
/*     */     public MicrogunUnit create() {
/* 315 */       return new MicrogunUnit((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 320 */       return MaterialColor.PURPLE.P300;
/*     */     }
/*     */ 
/*     */     
/*     */     public UnitType getUnitType() {
/* 325 */       return UnitType.MICROGUN;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\units\MicrogunUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */