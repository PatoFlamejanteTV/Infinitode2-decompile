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
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.utils.EntityUtils;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class BulletWallProjectile extends CollidingProjectile {
/*  24 */   private static final Color d = Color.WHITE.cpy();
/*  25 */   private static final Color e = new Color(MaterialColor.TEAL.P500.r, MaterialColor.TEAL.P500.g, MaterialColor.TEAL.P500.b, 0.56F);
/*     */   
/*     */   private float f;
/*     */   
/*     */   private float g;
/*     */   
/*     */   private boolean h;
/*     */   
/*     */   @NAGS
/*     */   private TrailMultiLine i;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  38 */     super.write(paramKryo, paramOutput);
/*  39 */     paramOutput.writeFloat(this.f);
/*  40 */     paramOutput.writeFloat(this.g);
/*  41 */     paramOutput.writeBoolean(this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  46 */     super.read(paramKryo, paramInput);
/*  47 */     this.f = paramInput.readFloat();
/*  48 */     this.g = paramInput.readFloat();
/*  49 */     this.h = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private BulletWallProjectile() {
/*  53 */     super(ProjectileType.BULLET_WALL);
/*     */   }
/*     */   
/*     */   public final void setup(float paramFloat1, Vector2 paramVector21, Vector2 paramVector22, float paramFloat2) {
/*  57 */     a(paramVector21, paramFloat2, paramVector22);
/*     */     
/*  59 */     this.c = paramFloat1;
/*  60 */     this.f = this.totalFlyTime;
/*  61 */     this.g = 0.0F;
/*  62 */     this.totalFlyTime *= 3.0F;
/*     */     
/*  64 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  65 */       this.i = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  66 */       this.i.setup(e, 15.0F, 0.5F, 0.0F);
/*  67 */       this.i.setStartPoint(paramVector21.x, paramVector21.y);
/*  68 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  74 */     super.setUnregistered();
/*  75 */     if (this.i != null) {
/*  76 */       this.i.allowCompletion();
/*  77 */       this.i = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  83 */     super.update(paramFloat);
/*  84 */     this.g += paramFloat;
/*  85 */     if (this.g >= this.f) {
/*     */       
/*  87 */       EntityUtils.removeNullRefs((Array)this.S.map.spawnedEnemies);
/*  88 */       if (this.S.map.spawnedEnemies.size == 0) {
/*  89 */         this.a.scl(-1.0F);
/*  90 */         if (this.b != -741.84F) {
/*  91 */           this.b += 180.0F;
/*     */         }
/*     */       } else {
/*  94 */         int i = this.S.gameState.randomInt(this.S.map.spawnedEnemies.size);
/*  95 */         Enemy enemy = ((Enemy.EnemyReference)this.S.map.spawnedEnemies.get(i)).enemy;
/*  96 */         flyOnEnemy(enemy);
/*     */       } 
/*  98 */       this.g = 0.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/* 104 */     super.reset();
/*     */     
/* 106 */     this.f = 0.0F;
/* 107 */     this.g = 0.0F;
/* 108 */     this.h = false;
/* 109 */     this.i = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(Enemy paramEnemy) {
/* 114 */     float f = this.c;
/* 115 */     if (EnemyType.isBoss(paramEnemy.type)) {
/* 116 */       f *= 0.1F;
/*     */     }
/*     */     
/* 119 */     this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(paramEnemy, f, DamageType.BULLET).setProjectile((Projectile)this).setCleanForDps(false));
/* 120 */     this.h = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 125 */     return (this.h || super.isDone());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 130 */     if (this.i != null) {
/* 131 */       Vector2 vector2 = (new Vector2(-this.a.x, -this.a.y)).scl(6.0F).add(this.drawPosition);
/* 132 */       this.i.setHeadPosition(vector2.x, vector2.y);
/*     */     } 
/*     */ 
/*     */     
/* 136 */     if (a() < 0.2F) {
/* 137 */       d.a = a() / 0.2F;
/* 138 */       paramBatch.setColor(d);
/*     */     } 
/* 140 */     paramBatch.draw(this.S.projectile.F.BULLET_WALL.a, this.drawPosition.x - 7.5F, this.drawPosition.y - 15.0F, 7.5F, 15.0F, 15.0F, 30.0F, 1.0F, 1.0F, this.drawAngle);
/* 141 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */   
/*     */   public static class MultishotProjectileFactory
/*     */     extends Projectile.Factory<BulletWallProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 150 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-bullet-wall");
/* 151 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static BulletWallProjectile b() {
/* 156 */       return new BulletWallProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\BulletWallProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */