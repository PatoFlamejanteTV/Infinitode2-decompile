/*     */ package com.prineside.tdi2.projectiles;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.CollidingProjectile;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.ProjectileTrail;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.buffs.BonusCoinsBuff;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.shapes.TrailMultiLine;
/*     */ import com.prineside.tdi2.towers.MultishotTower;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MultishotProjectile extends CollidingProjectile {
/*  31 */   private static final Color d = Color.WHITE.cpy();
/*  32 */   private static final Color e = new Color(MaterialColor.YELLOW.P500.r, MaterialColor.YELLOW.P500.g, MaterialColor.YELLOW.P500.b, 0.4F);
/*     */   
/*     */   @NAGS
/*     */   private TrailMultiLine f;
/*     */   
/*     */   @NAGS
/*  38 */   public float drawScale = 1.0F;
/*     */   
/*     */   private Tower g;
/*     */   
/*     */   private boolean h;
/*     */   private boolean i;
/*     */   private boolean j;
/*     */   private boolean k;
/*     */   public boolean flyingBack;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  49 */     super.write(paramKryo, paramOutput);
/*  50 */     paramKryo.writeClassAndObject(paramOutput, this.g);
/*  51 */     paramOutput.writeBoolean(this.h);
/*  52 */     paramOutput.writeBoolean(this.i);
/*  53 */     paramOutput.writeBoolean(this.j);
/*  54 */     paramOutput.writeBoolean(this.k);
/*  55 */     paramOutput.writeBoolean(this.flyingBack);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  60 */     super.read(paramKryo, paramInput);
/*  61 */     this.g = (Tower)paramKryo.readClassAndObject(paramInput);
/*  62 */     this.h = paramInput.readBoolean();
/*  63 */     this.i = paramInput.readBoolean();
/*  64 */     this.j = paramInput.readBoolean();
/*  65 */     this.k = paramInput.readBoolean();
/*  66 */     this.flyingBack = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private MultishotProjectile() {
/*  70 */     super(ProjectileType.MULTISHOT);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, Vector2 paramVector21, Vector2 paramVector22, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, float paramFloat3) {
/*  74 */     a(paramVector21, paramFloat2, paramVector22);
/*     */     
/*  76 */     this.g = paramTower;
/*  77 */     this.c = paramFloat1;
/*  78 */     this.i = paramBoolean1;
/*  79 */     this.j = paramBoolean2;
/*     */     
/*  81 */     if (this.S._projectileTrail != null && this.S._projectileTrail.isEnabled()) {
/*  82 */       this.f = (TrailMultiLine)Game.i.shapeManager.F.TRAIL_MULTI_LINE.obtain();
/*  83 */       this.f.setup(e, 12.0F * paramFloat3, 0.4F, 0.0F);
/*  84 */       this.f.setStartPoint(paramVector21.x, paramVector21.y);
/*  85 */       this.S._projectileTrail.addTrail((ProjectileTrail)this.f);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setUnregistered() {
/*  91 */     super.setUnregistered();
/*  92 */     if (this.f != null) {
/*  93 */       this.f.allowCompletion();
/*  94 */       this.f = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/* 100 */     super.reset();
/*     */     
/* 102 */     this.drawScale = 1.0F;
/* 103 */     this.flyingBack = false;
/* 104 */     this.k = false;
/* 105 */     this.h = false;
/* 106 */     this.i = false;
/* 107 */     this.j = false;
/* 108 */     this.g = null;
/* 109 */     this.f = null;
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
/*     */   protected final void a(Enemy paramEnemy) {
/* 141 */     float f = this.c;
/*     */     
/* 143 */     if (this.j) {
/* 144 */       float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_COUNTER_DAMAGE);
/* 145 */       f *= 1.0F + f1 * paramEnemy.otherEnemiesNearby;
/*     */     } 
/*     */     
/* 148 */     if (!paramEnemy.isVulnerableToSpecial(SpecialDamageType.PIERCING)) {
/* 149 */       this.h = true;
/*     */     }
/*     */     
/* 152 */     if (this.g instanceof MultishotTower && this.g.isRegistered()) {
/*     */       boolean bool;
/* 154 */       if ((bool = (this.g.isAbilityInstalled(2) && paramEnemy.getTowerDamageMultiplier(TowerType.MULTISHOT) > 0.0F) ? true : false) && paramEnemy.multishotTowerHits != null) {
/* 155 */         int i = paramEnemy.multishotTowerHits.get(this.g.id, 0);
/* 156 */         float f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_COMPACT_DAMAGE_PER_HIT) * i;
/* 157 */         f *= f1 + 1.0F;
/*     */       } 
/* 159 */       if (this.g.isAbilityInstalled(1)) {
/*     */         
/* 161 */         float f1 = PMath.getDistanceBetweenPoints(this.position, (this.g.getTile()).center);
/* 162 */         f1 = 1.0F - f1 / this.g.rangeInPixels;
/* 163 */         f = (float)(f * (1.0D + (this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_BUCKSHOT_DAMAGE) - 1.0D) * f1));
/*     */ 
/*     */         
/* 166 */         BonusCoinsBuff bonusCoinsBuff = new BonusCoinsBuff();
/* 167 */         float f2 = this.S.gameValue.getFloatValue(GameValueType.TOWER_MULTISHOT_A_BUCKSHOT_COINS_DURATION);
/* 168 */         bonusCoinsBuff.setup(f2, f2 * 10.0F, ((MultishotTower)this.g).getBuckshotCoinBonusMult(), this.g);
/* 169 */         this.S.buff.P_BONUS_COINS.addBuff(paramEnemy, bonusCoinsBuff);
/*     */       } 
/* 171 */       this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(paramEnemy, f, DamageType.BULLET).setTower(this.g).setProjectile((Projectile)this));
/* 172 */       if (bool) {
/* 173 */         if (paramEnemy.multishotTowerHits == null) {
/* 174 */           paramEnemy.multishotTowerHits = new IntIntMap();
/*     */         }
/*     */         int i;
/* 177 */         if ((i = paramEnemy.multishotTowerHits.get(this.g.id, 0)) < this.S.gameValue.getIntValue(GameValueType.TOWER_MULTISHOT_A_COMPACT_MAX_HIT_COUNT)) {
/* 178 */           paramEnemy.multishotTowerHits.put(this.g.id, i + 1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 183 */     if (!this.i || this.k) {
/*     */       
/* 185 */       this.h = true;
/* 186 */       this.k = true;
/*     */     } else {
/* 188 */       this.c = (float)(this.c * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_MULTISHOT_A_PENETRATING_DAMAGE));
/* 189 */       this.k = true;
/*     */     } 
/* 191 */     if (this.flyingBack && this.g != null && this.g instanceof MultishotTower) {
/* 192 */       int i = ((MultishotTower)this.g).notHitBackProjectileCount + 1;
/* 193 */       ((MultishotTower)this.g).notHitBackProjectileCount = 0;
/* 194 */       this.c *= i;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 200 */     return (this.h || super.isDone());
/*     */   }
/*     */ 
/*     */   
/*     */   public final void onDone() {
/* 205 */     if (this.flyingBack && 
/* 206 */       !this.k && this.g != null && this.g instanceof MultishotTower && 
/* 207 */       ((MultishotTower)this.g).notHitBackProjectileCount < this.S.gameValue.getIntValue(GameValueType.TOWER_MULTISHOT_A_BACK_MAX_STACK)) {
/* 208 */       ((MultishotTower)this.g).notHitBackProjectileCount++;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {
/* 217 */     if (this.f != null) {
/*     */       Vector2 vector2;
/* 219 */       (vector2 = new Vector2()).set(-this.a.x, -this.a.y).scl(9.0F).add(this.drawPosition);
/* 220 */       this.f.setHeadPosition(vector2.x, vector2.y);
/*     */     } 
/*     */     
/* 223 */     if (a() < 0.2F) {
/* 224 */       d.a = a() / 0.2F;
/* 225 */       paramBatch.setColor(d);
/*     */     } 
/* 227 */     paramBatch.draw(this.S.projectile.F.MULTISHOT.a, this.drawPosition.x - 5.1749997F * this.drawScale, this.drawPosition.y - 13.799999F * this.drawScale, 5.1749997F * this.drawScale, 13.799999F * this.drawScale, 10.349999F * this.drawScale, 27.599998F * this.drawScale, 1.0F, 1.0F, this.drawAngle);
/* 228 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */   
/*     */   public static class MultishotProjectileFactory
/*     */     extends Projectile.Factory<MultishotProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 237 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("projectile-multishot");
/* 238 */       Game.i.assetManager.getTextureRegion("bullet-trace-thin");
/*     */     }
/*     */ 
/*     */     
/*     */     private static MultishotProjectile b() {
/* 243 */       return new MultishotProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\MultishotProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */