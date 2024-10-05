/*     */ package com.prineside.tdi2.projectiles;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.SpecialDamageType;
/*     */ import com.prineside.tdi2.shapes.ChainLightning;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class ChainLightningProjectile
/*     */   extends Projectile {
/*     */   private Tower a;
/*     */   private float b;
/*     */   private float d;
/*     */   private float e;
/*     */   private float f;
/*  32 */   private IntSet g = new IntSet();
/*  33 */   private Vector2 h = new Vector2();
/*     */   
/*     */   private float i;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  38 */     super.write(paramKryo, paramOutput);
/*  39 */     paramKryo.writeClassAndObject(paramOutput, this.a);
/*  40 */     paramOutput.writeFloat(this.b);
/*  41 */     paramOutput.writeFloat(this.d);
/*  42 */     paramOutput.writeFloat(this.e);
/*  43 */     paramOutput.writeFloat(this.f);
/*  44 */     paramKryo.writeObject(paramOutput, this.g);
/*  45 */     paramKryo.writeObject(paramOutput, this.h);
/*  46 */     paramOutput.writeFloat(this.i);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  51 */     super.read(paramKryo, paramInput);
/*  52 */     this.a = (Tower)paramKryo.readClassAndObject(paramInput);
/*  53 */     this.b = paramInput.readFloat();
/*  54 */     this.d = paramInput.readFloat();
/*  55 */     this.e = paramInput.readFloat();
/*  56 */     this.f = paramInput.readFloat();
/*  57 */     this.g = (IntSet)paramKryo.readObject(paramInput, IntSet.class);
/*  58 */     this.h = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  59 */     this.i = paramInput.readFloat();
/*     */   }
/*     */   
/*     */   private ChainLightningProjectile() {
/*  63 */     super(ProjectileType.CHAIN_LIGHTNING);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, Enemy paramEnemy, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Vector2 paramVector2) {
/*  67 */     if (paramFloat4 < 0.0F) throw new IllegalArgumentException("chainLength is " + paramFloat4);
/*     */     
/*  69 */     Preconditions.checkArgument((paramFloat1 > 0.0F && PMath.isFinite(paramFloat1)), "Invalid damage: %s", Float.valueOf(paramFloat1));
/*  70 */     Preconditions.checkArgument((paramFloat2 >= 0.0F && PMath.isFinite(paramFloat2)), "Invalid minDamage: %s", Float.valueOf(paramFloat2));
/*  71 */     this.h.set(paramVector2);
/*  72 */     this.a = paramTower;
/*  73 */     this.b = paramFloat1;
/*  74 */     this.d = paramFloat2;
/*  75 */     this.e = paramFloat3;
/*  76 */     this.f = paramFloat4;
/*  77 */     this.i = 0.0F;
/*     */     
/*  79 */     a(paramEnemy);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void reset() {
/*  84 */     super.reset();
/*     */     
/*  86 */     this.b = 0.0F;
/*  87 */     this.d = 0.0F;
/*  88 */     this.e = 0.0F;
/*  89 */     this.f = 0.0F;
/*  90 */     this.i = 0.0F;
/*  91 */     this.a = null;
/*  92 */     this.g.clear();
/*  93 */     this.h.setZero();
/*     */   }
/*     */   
/*     */   private void a(Enemy paramEnemy) {
/*  97 */     float f1 = (paramEnemy.getPosition()).x + (this.S.gameState.randomFloat() - 0.5F) * paramEnemy.getSize() * 0.8F;
/*  98 */     float f2 = (paramEnemy.getPosition()).y + (this.S.gameState.randomFloat() - 0.5F) * paramEnemy.getSize() * 0.8F;
/*     */     
/* 100 */     if (this.S._particle != null && !this.S.gameState.canSkipMediaUpdate() && Game.i.settingsManager.isProjectilesDrawing()) {
/*     */       ChainLightning chainLightning;
/* 102 */       (chainLightning = (ChainLightning)Game.i.shapeManager.F.CHAIN_LIGHTNING.obtain()).setTexture(this.S.projectile.F.CHAIN_LIGHTNING.a, true, true);
/* 103 */       chainLightning.setColor(MaterialColor.BLUE.P300);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 108 */       chainLightning.setup(this.h.x, this.h.y, f1, f2, 0.5F, 0.25F, true, 13.440001F, 67.2F, 16.0F);
/* 109 */       this.S._particle.addChainLightning(chainLightning);
/*     */     } 
/*     */     
/* 112 */     this.h.set(f1, f2);
/*     */     
/* 114 */     if (!paramEnemy.isVulnerableToSpecial(SpecialDamageType.CHAINING)) {
/* 115 */       this.f = 0.0F;
/*     */     }
/*     */     
/* 118 */     this.g.add(paramEnemy.id);
/* 119 */     this.S.damage.queueDamage(this.S.damage.obtainRecord().setup(paramEnemy, this.b, DamageType.ELECTRICITY).setTower(this.a).setProjectile(this));
/*     */     
/* 121 */     this.b *= this.e;
/* 122 */     if (this.b < this.d) {
/* 123 */       this.b = this.d;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isDone() {
/* 129 */     return hasReachedTarget();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean hasReachedTarget() {
/* 138 */     return (this.f <= 0.0F && this.i > 0.2F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void applyDrawInterpolation(float paramFloat) {}
/*     */ 
/*     */   
/*     */   private boolean a(float paramFloat) {
/*     */     Enemy enemy;
/* 147 */     if (this.f > 0.0F) {
/*     */       
/* 149 */       if (this.f < 1.0F)
/*     */       {
/* 151 */         if (this.S.gameState.randomFloat() > this.f) {
/*     */           
/* 153 */           this.f = 0.0F;
/* 154 */           return true;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 159 */       float[] arrayOfFloat = { Float.MAX_VALUE };
/* 160 */       Enemy[] arrayOfEnemy = { null };
/*     */       
/* 162 */       this.S.map.getEnemiesInCircle(this.h.x, this.h.y, 192.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             if ((paramFloat1 = this.h.dst2(paramFloat1, paramFloat2)) < paramArrayOffloat[0]) {
/*     */               Enemy enemy;
/*     */               if ((enemy = paramEnemyReference.enemy) == null) {
/*     */                 return true;
/*     */               }
/*     */               if (this.g.contains(enemy.id)) {
/*     */                 return true;
/*     */               }
/*     */               if (this.a != null && !this.a.canAttackEnemy(enemy)) {
/*     */                 return true;
/*     */               }
/*     */               if (!enemy.isVulnerableTo(DamageType.ELECTRICITY)) {
/*     */                 return true;
/*     */               }
/*     */               paramArrayOfEnemy[0] = enemy;
/*     */               paramArrayOffloat[0] = paramFloat1;
/*     */             } 
/*     */             return true;
/*     */           });
/* 182 */       if (arrayOfEnemy[0] == null) {
/*     */         
/* 184 */         this.f = 0.0F;
/* 185 */         return true;
/*     */       } 
/*     */       
/* 188 */       float f = (arrayOfEnemy[0]).buffFreezingLightningLengthBonus + 100.0F;
/* 189 */       f = 1.0F / f * 0.01F;
/* 190 */       this.f -= f;
/* 191 */       if (this.f < 0.0F) this.f = 0.0F;
/*     */       
/* 193 */       enemy = arrayOfEnemy[0];
/* 194 */       arrayOfEnemy[0] = null;
/*     */       
/* 196 */       a(enemy);
/*     */     } else {
/*     */       
/* 199 */       this.i += enemy;
/*     */     } 
/*     */     
/* 202 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 207 */     if (this.a == null || !this.a.isRegistered()) {
/* 208 */       this.f = 0.0F;
/* 209 */       this.i += paramFloat;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     int i;
/* 215 */     if ((i = MathUtils.ceil(paramFloat / 0.03448276F)) == 1) {
/* 216 */       a(paramFloat); return;
/*     */     } 
/* 218 */     paramFloat /= i;
/* 219 */     for (byte b = 0; b < i && 
/* 220 */       !a(paramFloat); b++);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */   
/*     */   public static class ChainLightningProjectileFactory
/*     */     extends Projectile.Factory<ChainLightningProjectile>
/*     */   {
/*     */     TextureRegion a;
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 235 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("chain-lightning");
/*     */     }
/*     */ 
/*     */     
/*     */     private static ChainLightningProjectile b() {
/* 240 */       return new ChainLightningProjectile((byte)0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\projectiles\ChainLightningProjectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */