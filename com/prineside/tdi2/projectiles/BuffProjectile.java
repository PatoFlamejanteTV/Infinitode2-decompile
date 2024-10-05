/*     */ package com.prineside.tdi2.projectiles;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Buff;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.EnemyFollowingProjectile;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class BuffProjectile extends EnemyFollowingProjectile {
/*  21 */   public Array<Buff> buffs = new Array(Buff.class);
/*     */ 
/*     */   
/*     */   @NAGS
/*     */   private ParticleEffectPool.PooledEffect d;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  29 */     super.write(paramKryo, paramOutput);
/*  30 */     paramKryo.writeObject(paramOutput, this.buffs);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  35 */     super.read(paramKryo, paramInput);
/*  36 */     this.buffs = (Array<Buff>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */   
/*     */   private BuffProjectile() {
/*  40 */     super(ProjectileType.BUFF);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup(Enemy paramEnemy, Array<Buff> paramArray, Vector2 paramVector2, float paramFloat) {
/*  47 */     this.c = 0.0F;
/*  48 */     if (paramArray != this.buffs) {
/*  49 */       this.buffs.addAll(paramArray);
/*     */     }
/*     */     
/*  52 */     if (this.S._particle != null && this.S._projectileTrail.isEnabled()) {
/*  53 */       this.d = (ParticleEffectPool.PooledEffect)this.S.projectile.F.BUFF.b.obtain();
/*  54 */       this.d.setPosition(paramVector2.x, paramVector2.y);
/*  55 */       this.S._particle.addParticle((ParticleEffect)this.d, true);
/*     */     } 
/*     */     
/*  58 */     setup(paramVector2, paramEnemy, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  63 */     super.reset();
/*  64 */     this.buffs.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  69 */     super.setUnregistered();
/*  70 */     if (this.d != null) {
/*  71 */       this.d.allowCompletion();
/*  72 */       this.d = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void hit() {
/*  78 */     super.hit();
/*     */     
/*     */     Enemy enemy;
/*     */     
/*  82 */     if ((enemy = getTarget()) != null) {
/*  83 */       for (byte b = 0; b < this.buffs.size; b++) {
/*  84 */         Buff buff = ((Buff[])this.buffs.items)[b];
/*  85 */         this.S.buff.getProcessor(buff.getType()).addBuff(enemy, buff);
/*     */       } 
/*     */     }
/*  88 */     this.buffs.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/*  93 */     paramBatch.draw(this.S.projectile.F.BUFF.a, this.drawPosition.x - 9.0F, this.drawPosition.y - 9.0F, 18.0F, 18.0F);
/*     */     
/*  95 */     if (this.d != null) this.d.setPosition(this.drawPosition.x, this.drawPosition.y);
/*     */     
/*  97 */     super.draw(paramBatch, paramFloat);
/*     */   }
/*     */   
/*     */   public static class BuffProjectileFactory
/*     */     extends Projectile.Factory<BuffProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     ParticleEffectPool b;
/*     */     
/*     */     public void setupAssets() {
/* 107 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-buff");
/* 108 */       this.b = Game.i.assetManager.getParticleEffectPool("buff-projectile.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     private static BuffProjectile b() {
/* 113 */       return new BuffProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\BuffProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */