/*     */ package com.prineside.tdi2.projectiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.CollidingProjectile;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.DamageRecord;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class SplinterProjectile extends CollidingProjectile {
/*  26 */   private static final Color d = Color.WHITE.cpy();
/*  27 */   private static final Color e = new Color(MaterialColor.RED.P500.r, MaterialColor.RED.P500.g, MaterialColor.RED.P500.b, 0.56F);
/*     */ 
/*     */   
/*     */   private Tower f;
/*     */   
/*     */   private boolean g = false;
/*     */   
/*     */   @NAGS
/*     */   private TrailMultiLine h;
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  39 */     super.write(paramKryo, paramOutput);
/*  40 */     paramKryo.writeClassAndObject(paramOutput, this.f);
/*  41 */     paramOutput.writeBoolean(this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  46 */     super.read(paramKryo, paramInput);
/*  47 */     this.f = (Tower)paramKryo.readClassAndObject(paramInput);
/*  48 */     this.g = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private SplinterProjectile() {
/*  52 */     super(ProjectileType.SPLINTER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, Vector2 paramVector21, Vector2 paramVector22, float paramFloat2, Color paramColor) {
/*  59 */     this.f = paramTower;
/*  60 */     this.c = paramFloat1;
/*     */     
/*  62 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  63 */       this.h = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  64 */       this.h.setup((paramColor == null) ? e : paramColor, 11.0F, 0.4F, 0.0F);
/*  65 */       this.h.setStartPoint(paramVector21.x, paramVector21.y);
/*  66 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.h);
/*     */     } 
/*     */     
/*  69 */     a(paramVector21, paramFloat2, paramVector22);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  74 */     super.setUnregistered();
/*  75 */     if (this.h != null) {
/*  76 */       this.h.allowCompletion();
/*  77 */       this.h = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  83 */     super.reset();
/*     */     
/*  85 */     this.f = null;
/*  86 */     this.h = null;
/*  87 */     this.g = false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(Enemy paramEnemy) {
/*  92 */     if (this.g || (this.f != null && !this.f.isRegistered()))
/*  93 */       return;  if (this.f != null && !this.f.canAttackEnemy(paramEnemy))
/*     */       return; 
/*  95 */     DamageRecord damageRecord = this.S.damage.obtainRecord().setup(paramEnemy, this.c, DamageType.BULLET).setTower(this.f).setProjectile((Projectile)this);
/*  96 */     if (this.f != null && this.f.type == TowerType.CANNON)
/*     */     {
/*  98 */       if (this.f.isAbilityInstalled(3) && paramEnemy.getHealth() / paramEnemy.maxHealth < 0.25F)
/*     */       {
/* 100 */         damageRecord.setDamage(this.c * 1.25F);
/*     */       }
/*     */     }
/* 103 */     this.S.damage.queueDamage(damageRecord);
/* 104 */     this.g = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 109 */     return (this.g || super.isDone());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 114 */     if (this.h != null) {
/*     */       Vector2 vector2;
/* 116 */       (vector2 = new Vector2()).set(-this.a.x, -this.a.y).scl(6.0F).add(this.drawPosition);
/* 117 */       this.h.setHeadPosition(vector2.x, vector2.y);
/*     */     } 
/*     */     
/* 120 */     if (a() < 0.1F) {
/* 121 */       d.a = a() / 0.1F;
/* 122 */       paramBatch.setColor(d);
/*     */     } 
/* 124 */     paramBatch.draw(this.S.projectile.F.SPLINTER.a, this.drawPosition.x - 4.5F, this.drawPosition.y - 9.0F, 4.5F, 9.0F, 9.0F, 18.0F, 1.0F, 1.0F, this.drawAngle);
/* 125 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */   
/*     */   public static class SplinterProjectileFactory
/*     */     extends Projectile.Factory<SplinterProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 134 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-cannon-splinter");
/* 135 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static SplinterProjectile b() {
/* 140 */       return new SplinterProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\SplinterProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */