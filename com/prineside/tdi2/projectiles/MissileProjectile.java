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
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.explosions.MissileExplosion;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.towers.MissileTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class MissileProjectile extends EnemyFollowingExplosiveProjectile {
/*  26 */   private static final TLog d = TLog.forClass(MissileProjectile.class);
/*     */   
/*  28 */   private static final Color e = new Color(MaterialColor.RED.P500.r, MaterialColor.RED.P500.g, MaterialColor.RED.P500.b, 0.56F);
/*     */   
/*     */   @NAGS
/*     */   private TrailMultiLine f;
/*     */   
/*     */   @NAGS
/*  34 */   private float g = 1.0F;
/*     */   
/*     */   private MissileTower h;
/*     */   private MissileExplosion i;
/*     */   private boolean j = false;
/*     */   private float k;
/*  40 */   private float l = Float.MAX_VALUE;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  44 */     super.write(paramKryo, paramOutput);
/*  45 */     paramKryo.writeObjectOrNull(paramOutput, this.h, MissileTower.class);
/*  46 */     paramKryo.writeObjectOrNull(paramOutput, this.i, MissileExplosion.class);
/*  47 */     paramOutput.writeBoolean(this.j);
/*  48 */     paramOutput.writeFloat(this.k);
/*  49 */     paramOutput.writeFloat(this.l);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  54 */     super.read(paramKryo, paramInput);
/*  55 */     this.h = (MissileTower)paramKryo.readObjectOrNull(paramInput, MissileTower.class);
/*  56 */     this.i = (MissileExplosion)paramKryo.readObjectOrNull(paramInput, MissileExplosion.class);
/*  57 */     this.j = paramInput.readBoolean();
/*  58 */     this.k = paramInput.readFloat();
/*  59 */     this.l = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   protected MissileProjectile() {
/*  63 */     super(ProjectileType.MISSILE);
/*     */   }
/*     */   
/*     */   public final void setup(MissileTower paramMissileTower, Enemy paramEnemy, float paramFloat1, float paramFloat2, Vector2 paramVector2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
/*  67 */     this.i = (MissileExplosion)this.S.explosion.F.MISSILE.obtain();
/*  68 */     this.i.setup((Tower)paramMissileTower, (paramEnemy.getPosition()).x, (paramEnemy.getPosition()).y, paramFloat1, paramFloat2);
/*     */     
/*  70 */     this.h = paramMissileTower;
/*  71 */     this.g = paramFloat6;
/*  72 */     this.l = Float.MAX_VALUE;
/*     */     
/*  74 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  75 */       this.f = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  76 */       this.f.setup(e, 15.0F * paramFloat6, 0.6F, 0.0F);
/*  77 */       this.f.setStartPoint(paramVector2.x, paramVector2.y);
/*  78 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.f);
/*     */     } 
/*     */     
/*  81 */     a(paramVector2, paramEnemy, paramFloat5, paramFloat3, (Explosion)this.i, paramFloat4, paramFloat4 * 0.05F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  86 */     super.setUnregistered();
/*  87 */     if (this.f != null) {
/*  88 */       this.f.allowCompletion();
/*  89 */       this.f = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  95 */     super.reset();
/*     */     
/*  97 */     this.j = false;
/*  98 */     this.i = null;
/*  99 */     this.k = 0.0F;
/* 100 */     this.h = null;
/* 101 */     this.f = null;
/* 102 */     this.l = Float.MAX_VALUE;
/*     */   }
/*     */   
/*     */   public final MissileTower getTower() {
/* 106 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setTarget(Enemy paramEnemy) {
/* 111 */     this.j = false;
/*     */     
/* 113 */     super.setTarget(paramEnemy);
/*     */   }
/*     */   
/*     */   public final void update(float paramFloat) {
/*     */     SpawnTile spawnTile;
/* 118 */     Enemy enemy = getTarget();
/*     */     
/* 120 */     if (this.h == null || !this.h.isRegistered()) {
/* 121 */       this.a = true;
/*     */       
/*     */       return;
/*     */     } 
/* 125 */     if (!this.j && enemy == null) {
/*     */       
/* 127 */       this.j = true;
/*     */       
/* 129 */       if (this.S.map.spawnedEnemies.size != 0) {
/*     */         
/* 131 */         if ((enemy = (((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[this.S.gameState.randomInt(this.S.map.spawnedEnemies.size)]).enemy) == null) {
/* 132 */           d.i("null enemy", new Object[0]);
/*     */         }
/* 134 */         if (enemy != null && this.h.canAttackEnemy(enemy)) {
/* 135 */           setTarget(enemy);
/*     */         }
/*     */       } else {
/*     */         Array array;
/*     */         
/* 140 */         spawnTile = (SpawnTile)(array = this.S.map.getMap().getTilesByType(SpawnTile.class)).get(this.S.gameState.randomInt(array.size));
/* 141 */         this.b.set(spawnTile.center);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 146 */     super.update(spawnTile);
/*     */     
/* 148 */     this.k += spawnTile;
/* 149 */     if (this.k > 20.0F)
/*     */     {
/* 151 */       this.a = true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 157 */     if (this.f != null) {
/*     */       
/* 159 */       Vector2 vector2 = (new Vector2(9.0F, 0.0F)).rotateDeg(this.drawAngle - 90.0F).add(this.drawPosition);
/* 160 */       this.f.setHeadPosition(vector2.x, vector2.y);
/*     */     } 
/*     */     
/* 163 */     paramBatch.draw(this.S.projectile.F.MISSILE.a, this.drawPosition.x - 10.5F * this.g, this.drawPosition.y - 21.0F * this.g, 10.5F * this.g, 21.0F * this.g, 21.0F * this.g, 42.0F * this.g, 1.0F, 1.0F, this.drawAngle);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class MissileProjectileFactory
/*     */     extends Projectile.Factory<MissileProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 182 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-missile");
/*     */       
/* 184 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static MissileProjectile b() {
/* 189 */       return new MissileProjectile();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\MissileProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */