/*     */ package com.prineside.tdi2.explosions;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.ExplosionType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.projectiles.SplinterProjectile;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class GenericExplosion
/*     */   extends Explosion {
/*     */   private int d;
/*     */   private float e;
/*     */   private float f;
/*     */   @NAGS
/*  28 */   private final Color g = new Color(MaterialColor.RED.P400); @NAGS
/*  29 */   private Color h = null;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  33 */     super.write(paramKryo, paramOutput);
/*  34 */     paramOutput.writeVarInt(this.d, true);
/*  35 */     paramOutput.writeFloat(this.e);
/*  36 */     paramOutput.writeFloat(this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  41 */     super.read(paramKryo, paramInput);
/*  42 */     this.d = paramInput.readVarInt(true);
/*  43 */     this.e = paramInput.readFloat();
/*  44 */     this.f = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final GenericExplosion cpy() {
/*     */     GenericExplosion genericExplosion;
/*  50 */     (genericExplosion = (GenericExplosion)this.S.explosion.F.GENERIC.obtain()).setup(getTower(), this.position.x, this.position.y, this.damage, this.a, this.d, this.e, this.f, this.g, this.h);
/*  51 */     return genericExplosion;
/*     */   }
/*     */   
/*     */   private GenericExplosion() {
/*  55 */     super(ExplosionType.GENERIC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt, float paramFloat5, float paramFloat6, Color paramColor1, Color paramColor2) {
/*  62 */     float f = 0.2F + paramFloat4 * 0.08F;
/*  63 */     a(paramTower, paramFloat1, paramFloat2, paramFloat3, paramFloat4, f, null);
/*     */     
/*  65 */     this.d = paramInt;
/*  66 */     this.h = paramColor2;
/*     */     
/*  68 */     this.e = paramFloat5;
/*  69 */     this.f = paramFloat6;
/*     */     
/*  71 */     if (paramColor1 == null) {
/*  72 */       this.g.set(MaterialColor.RED.P400); return;
/*     */     } 
/*  74 */     this.g.set(paramColor1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void explode() {
/*  80 */     super.explode();
/*     */     
/*  82 */     if (this.b > 0.0F) {
/*     */       
/*  84 */       addExplosionParticle(this.g, LimitedParticleType.EXPLOSION_CANNON);
/*     */       
/*  86 */       if (this.S._sound != null) {
/*  87 */         this.S._sound.playExplosionSound(this.position.x);
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
/*     */   public final void enemyAffected(Enemy paramEnemy, float paramFloat1, float paramFloat2) {
/* 101 */     this.S.damage.queueDamage(this.S.damage
/* 102 */         .obtainRecord().setup(paramEnemy, calculateDamage(this.damage, paramFloat1, paramFloat2), DamageType.EXPLOSION)
/* 103 */         .setTower(getTower())
/* 104 */         .setAbility(this.fromAbility)
/* 105 */         .setExplosion(this));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 111 */     return (super.isDone() && this.d == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 116 */     super.update(paramFloat);
/*     */     
/*     */     Tower tower;
/* 119 */     if (this.d != 0 && (
/*     */       
/* 121 */       tower = getTower()) != null && tower.isRegistered()) {
/* 122 */       SplinterProjectile splinterProjectile = (SplinterProjectile)this.S.projectile.F.SPLINTER.obtain();
/* 123 */       this.S.projectile.register((Projectile)splinterProjectile);
/*     */       
/* 125 */       float f = this.S.gameState.randomFloat() * 6.2831855F;
/* 126 */       Vector2 vector21 = new Vector2();
/* 127 */       Vector2 vector22 = new Vector2();
/*     */       Vector2 vector23;
/* 129 */       (vector23 = new Vector2()).set(PMath.cos(f), PMath.sin(f));
/*     */       
/* 131 */       vector23.scl(32.0F);
/* 132 */       vector21.set(vector23).add(this.position.x, this.position.y);
/*     */       
/* 134 */       vector23.scl((this.f * 128.0F + 32.0F) / 32.0F);
/* 135 */       vector22.set(vector23).add(this.position.x, this.position.y);
/*     */       
/* 137 */       splinterProjectile.setup(tower, this.e, vector21, vector22, 2.0F, this.h);
/*     */       
/* 139 */       this.d--;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static final class GenericExplosionFactory
/*     */     extends Explosion.Factory<GenericExplosion>
/*     */   {
/*     */     private static GenericExplosion b() {
/* 147 */       return new GenericExplosion((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\explosions\GenericExplosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */