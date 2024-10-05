/*     */ package com.prineside.tdi2.projectiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.CollidingProjectile;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.BonusXpBuff;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.towers.SplashTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class SplashProjectile
/*     */   extends CollidingProjectile
/*     */ {
/*  33 */   private static final Color d = Color.WHITE.cpy();
/*  34 */   private static final Color e = new Color(MaterialColor.DEEP_ORANGE.P500.r, MaterialColor.DEEP_ORANGE.P500.g, MaterialColor.DEEP_ORANGE.P500.b, 0.56F);
/*     */   
/*  36 */   public int chainKillGeneration = 0;
/*     */   
/*     */   private Tower f;
/*     */   public byte hitCount;
/*     */   private boolean g;
/*     */   @NAGS
/*     */   private TrailMultiLine h;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  45 */     super.write(paramKryo, paramOutput);
/*  46 */     paramOutput.writeVarInt(this.chainKillGeneration, true);
/*  47 */     paramKryo.writeClassAndObject(paramOutput, this.f);
/*  48 */     paramOutput.writeByte(this.hitCount);
/*  49 */     paramOutput.writeBoolean(this.g);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  54 */     super.read(paramKryo, paramInput);
/*  55 */     this.chainKillGeneration = paramInput.readVarInt(true);
/*  56 */     this.f = (Tower)paramKryo.readClassAndObject(paramInput);
/*  57 */     this.hitCount = paramInput.readByte();
/*  58 */     this.g = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private SplashProjectile() {
/*  62 */     super(ProjectileType.SPLASH);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, Vector2 paramVector21, Vector2 paramVector22, float paramFloat2) {
/*  66 */     a(paramVector21, paramFloat2, paramVector22);
/*     */     
/*  68 */     this.f = paramTower;
/*  69 */     this.c = paramFloat1;
/*  70 */     this.hitCount = 0;
/*  71 */     this.g = false;
/*     */     
/*  73 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  74 */       this.h = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  75 */       this.h.setup(e, 13.0F, 0.4F, 0.0F);
/*  76 */       this.h.setStartPoint(paramVector21.x, paramVector21.y);
/*  77 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.h);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  83 */     super.setUnregistered();
/*  84 */     if (this.h != null) {
/*  85 */       this.h.allowCompletion();
/*  86 */       this.h = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  92 */     super.reset();
/*     */     
/*  94 */     this.chainKillGeneration = 0;
/*  95 */     this.f = null;
/*  96 */     this.h = null;
/*  97 */     this.hitCount = 0;
/*  98 */     this.g = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 103 */     if (this.h != null) {
/*     */       Vector2 vector2;
/* 105 */       (vector2 = new Vector2()).set(-this.a.x, -this.a.y).scl(8.0F).add(this.drawPosition);
/* 106 */       this.h.setHeadPosition(vector2.x, vector2.y);
/*     */     } 
/*     */     
/* 109 */     if (a() < 0.2F) {
/* 110 */       d.a = a() / 0.2F;
/* 111 */       paramBatch.setColor(d);
/*     */     } 
/* 113 */     paramBatch.draw(this.S.projectile.F.SPLASH.a, this.drawPosition.x - 5.625F, this.drawPosition.y - 11.25F, 5.625F, 11.25F, 11.25F, 22.5F, 1.0F, 1.0F, this.drawAngle);
/* 114 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void a(Enemy paramEnemy) {
/* 119 */     if (this.f == null || !this.f.isRegistered() || !this.f.canAttackEnemy(paramEnemy))
/*     */       return; 
/* 121 */     float f = this.c;
/* 122 */     if (this.f.isAbilityInstalled(3) && paramEnemy.getBuffedSpeed() < this.S.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_RIFFLED_SPEED_MARK))
/*     */     {
/* 124 */       f = (float)(f * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_RIFFLED_DAMAGE));
/*     */     }
/*     */     
/* 127 */     if (!paramEnemy.isVulnerableToSpecial(SpecialDamageType.PIERCING)) {
/* 128 */       this.g = true;
/*     */     }
/*     */     
/* 131 */     this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(paramEnemy, f, DamageType.BULLET).setTower(this.f).setProjectile((Projectile)this));
/* 132 */     if (this.f instanceof SplashTower && this.S.gameState.randomFloat() < this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_SPLASH_A_ULTIMATE_ON_HIT_CHANCE)) {
/* 133 */       SplashTower.triggerChainReaction(this.S, (SplashTower)this.f, this);
/*     */     }
/*     */     
/* 136 */     if (this.f.isAbilityInstalled(2)) {
/*     */       
/* 138 */       f = this.S.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_BONUS_XP);
/* 139 */       float f1 = this.S.gameValue.getFloatValue(GameValueType.TOWER_SPLASH_A_FAST_BULLETS_BONUS_XP_DURATION);
/*     */       BonusXpBuff bonusXpBuff;
/* 141 */       (bonusXpBuff = new BonusXpBuff()).setup(f1, f1 * 10.0F, f * 0.01F, this.f);
/* 142 */       this.S.buff.P_BONUS_XP.addBuff(paramEnemy, bonusXpBuff);
/*     */     } 
/*     */     
/* 145 */     this.hitCount = (byte)(this.hitCount + 1);
/* 146 */     this.c *= this.f.getStat(TowerStatType.U_PIERCING) * 0.01F;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 151 */     return (super.isDone() || this.g || this.c < 0.01F || this.hitCount > 10);
/*     */   }
/*     */   
/*     */   public static class SplashProjectileFactory
/*     */     extends Projectile.Factory<SplashProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 160 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-splash");
/* 161 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static SplashProjectile b() {
/* 166 */       return new SplashProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\SplashProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */