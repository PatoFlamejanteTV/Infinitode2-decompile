/*     */ package com.prineside.tdi2.projectiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyFollowingExplosiveProjectile;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.explosions.CannonExplosion;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.towers.CannonTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class CannonProjectile extends EnemyFollowingExplosiveProjectile {
/*  26 */   private static final Color d = new Color(MaterialColor.RED.P500.r, MaterialColor.RED.P500.g, MaterialColor.RED.P500.b, 0.56F);
/*     */   
/*     */   @NAGS
/*     */   private TrailMultiLine e;
/*     */   
/*     */   private CannonExplosion f;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  35 */     super.write(paramKryo, paramOutput);
/*  36 */     paramKryo.writeClassAndObject(paramOutput, this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  41 */     super.read(paramKryo, paramInput);
/*  42 */     this.f = (CannonExplosion)paramKryo.readClassAndObject(paramInput);
/*     */   }
/*     */   
/*     */   private CannonProjectile() {
/*  46 */     super(ProjectileType.CANNON);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, Enemy paramEnemy, float paramFloat1, float paramFloat2, Vector2 paramVector2, float paramFloat3, int paramInt, float paramFloat4, float paramFloat5) {
/*  50 */     this.f = (CannonExplosion)this.S.explosion.F.CANNON.obtain();
/*  51 */     this.f.setup(paramTower, (paramEnemy.getPosition()).x, (paramEnemy.getPosition()).y, paramFloat1, paramFloat2, paramInt, paramFloat4, paramFloat5);
/*     */     CannonTower cannonTower;
/*  53 */     if (paramTower.isRegistered() && paramTower.type == TowerType.CANNON && (
/*     */       
/*  55 */       cannonTower = (CannonTower)paramTower).isAbilityInstalled(2))
/*     */     {
/*  57 */       this.f.piercingMultiplier = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_CANNON_A_FOUNDATION_PIERCING);
/*     */     }
/*     */ 
/*     */     
/*  61 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  62 */       this.e = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  63 */       this.e.setup(d, 15.0F, 0.4F, 0.0F);
/*  64 */       this.e.setStartPoint(paramVector2.x, paramVector2.y);
/*  65 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.e);
/*     */     } 
/*     */     
/*  68 */     a(paramVector2, paramEnemy, paramTower.angle, paramFloat3, (Explosion)this.f, 0.0F, 120.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  73 */     super.setUnregistered();
/*  74 */     if (this.e != null) {
/*  75 */       this.e.allowCompletion();
/*  76 */       this.e = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  82 */     super.reset();
/*     */     
/*  84 */     this.e = null;
/*  85 */     this.f = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/*  90 */     if (this.e != null) {
/*  91 */       this.e.setHeadPosition(this.drawPosition.x, this.drawPosition.y);
/*     */     }
/*  93 */     paramBatch.draw(this.S.projectile.F.CANNON.a, this.drawPosition.x - 8.0F, this.drawPosition.y - 8.0F, 16.0F, 16.0F);
/*     */     
/*  95 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class CannonProjectileFactory
/*     */     extends Projectile.Factory<CannonProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 104 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-cannon");
/* 105 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static CannonProjectile b() {
/* 110 */       return new CannonProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\CannonProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */