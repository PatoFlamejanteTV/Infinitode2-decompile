/*     */ package com.prineside.tdi2.projectiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyFollowingProjectile;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.towers.BasicTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class BasicProjectile extends EnemyFollowingProjectile {
/*  29 */   private static final Color d = new Color(MaterialColor.TEAL.P500.r, MaterialColor.TEAL.P500.g, MaterialColor.TEAL.P500.b, 0.56F);
/*     */   
/*     */   private Tower e;
/*     */   
/*     */   @NAGS
/*     */   private TrailMultiLine f;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  38 */     super.write(paramKryo, paramOutput);
/*  39 */     paramKryo.writeClassAndObject(paramOutput, this.e);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  44 */     super.read(paramKryo, paramInput);
/*  45 */     this.e = (Tower)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   private BasicProjectile() {
/*  49 */     super(ProjectileType.BASIC);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, Enemy paramEnemy, float paramFloat1, Vector2 paramVector2, float paramFloat2) {
/*  53 */     this.e = paramTower;
/*  54 */     this.c = paramFloat1;
/*     */     
/*  56 */     if (this.f == null && this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  57 */       this.f = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  58 */       this.f.setup(d, 15.0F, 0.4F, 0.0F);
/*  59 */       this.f.setStartPoint(paramVector2.x, paramVector2.y);
/*  60 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.f);
/*     */     } 
/*     */     
/*  63 */     setup(paramVector2, paramEnemy, paramFloat2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  68 */     super.setUnregistered();
/*  69 */     if (this.f != null) {
/*  70 */       this.f.allowCompletion();
/*  71 */       this.f = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  77 */     super.reset();
/*     */     
/*  79 */     this.e = null;
/*  80 */     this.f = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hit() {
/*  85 */     super.hit();
/*     */     
/*  87 */     if (this.e == null || !this.e.isRegistered())
/*     */       return; 
/*  89 */     Enemy enemy = getTarget();
/*     */     
/*  91 */     boolean bool = false;
/*  92 */     if (enemy != null) {
/*  93 */       bool = !enemy.isVulnerableToSpecial(SpecialDamageType.CHAINING) ? true : false;
/*  94 */       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(getTarget(), this.c, DamageType.BULLET).setTower(this.e).setProjectile((Projectile)this));
/*     */     } 
/*     */     
/*  97 */     if (this.e.type == TowerType.BASIC) {
/*  98 */       BasicTower basicTower = (BasicTower)this.e;
/*  99 */       if (!bool && basicTower.isAbilityInstalled(2)) {
/*     */         float f;
/* 101 */         if ((f = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_FOUNDATION_RICOCHET_CHANCE)) > 0.99D) {
/* 102 */           f = 0.99F;
/*     */         }
/* 104 */         if (this.S.gameState.randomFloat() < f) {
/*     */           
/* 106 */           this.speed = (float)(this.speed * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_BASIC_A_FOUNDATION_RICOCHET_SPEED));
/* 107 */           if (this.speed > 192.0F) {
/*     */             
/* 109 */             Array array = this.S.TSH.getEnemyArray();
/* 110 */             this.S.map.getEnemiesInCircle(
/* 111 */                 (getPosition()).x, 
/* 112 */                 (getPosition()).y, 256.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */                   Enemy enemy;
/*     */                   
/*     */                   if ((enemy = paramEnemyReference.enemy) == null || enemy == paramEnemy || !this.e.canAttackEnemy(enemy)) {
/*     */                     return true;
/*     */                   }
/*     */                   
/*     */                   paramArray.add(enemy);
/*     */                   
/*     */                   return true;
/*     */                 });
/*     */             
/* 124 */             if (array.size != 0) {
/* 125 */               enemy = ((Enemy[])array.items)[this.S.gameState.randomInt(array.size)];
/*     */               
/* 127 */               setup(this.e, enemy, this.c, getPosition(), this.speed / 128.0F);
/* 128 */               this.maxRotationSpeed = 0.0F;
/* 129 */               this.maxRotationSpeedDynamic = 0.0F;
/*     */             } 
/* 131 */             this.S.TSH.freeEnemyArray(array);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 140 */     if (this.f != null) {
/* 141 */       this.f.setHeadPosition(this.drawPosition.x, this.drawPosition.y);
/*     */     }
/* 143 */     paramBatch.draw(this.S.projectile.F.BASIC.a, this.drawPosition.x - 9.0F, this.drawPosition.y - 9.0F, 18.0F, 18.0F);
/*     */     
/* 145 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 150 */     return super.toString() + " (tower: " + this.e + ")";
/*     */   }
/*     */   
/*     */   public static class BasicProjectileFactory
/*     */     extends Projectile.Factory<BasicProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 159 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-basic");
/* 160 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static BasicProjectile b() {
/* 165 */       return new BasicProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\BasicProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */