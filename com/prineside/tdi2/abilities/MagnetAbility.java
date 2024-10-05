/*     */ package com.prineside.tdi2.abilities;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.math.MathUtils;
/*     */ import com.badlogic.gdx.utils.IntSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Ability;
/*     */ import com.prineside.tdi2.CollidingProjectile;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameValueProvider;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.SerializableListener;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.Listener;
/*     */ import com.prineside.tdi2.events.game.ProjectileDespawn;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.scene2d.utils.TextureRegionDrawable;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public class MagnetAbility
/*     */   extends Ability
/*     */ {
/*  40 */   private static final int[] b = new int[] { 100, 125, 150, 175, 250, 300, 400, 550, 750, 875, 1000 };
/*     */ 
/*     */   
/*  43 */   private static final int[][] c = new int[][] { { 5, 10, 25, 0, 0, 0, 0, 0, 0, 0, 300 }, { 0, 0, 5, 10, 30, 0, 0, 0, 0, 0, 250 }, { 0, 0, 0, 0, 10, 20, 50, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 10, 25, 45, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 10, 25, 75, 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private float d;
/*     */ 
/*     */ 
/*     */   
/*  52 */   private Enemy.EnemyReference e = Enemy.EnemyReference.NULL;
/*  53 */   private IntSet f = new IntSet();
/*     */   
/*     */   private float g;
/*  56 */   private OnProjectileDespawn h = new OnProjectileDespawn(this, (byte)0); @NAGS
/*     */   private ParticleEffectPool.PooledEffect i;
/*     */   @NAGS
/*     */   private boolean j;
/*     */   @NAGS
/*     */   private boolean k;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  64 */     super.write(paramKryo, paramOutput);
/*  65 */     paramOutput.writeFloat(this.d);
/*  66 */     paramKryo.writeObject(paramOutput, this.e);
/*  67 */     paramKryo.writeObject(paramOutput, this.f);
/*  68 */     paramOutput.writeFloat(this.g);
/*  69 */     paramKryo.writeObject(paramOutput, this.h);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  74 */     super.read(paramKryo, paramInput);
/*  75 */     this.d = paramInput.readFloat();
/*  76 */     this.e = (Enemy.EnemyReference)paramKryo.readObject(paramInput, Enemy.EnemyReference.class);
/*  77 */     this.f = (IntSet)paramKryo.readObject(paramInput, IntSet.class);
/*  78 */     this.g = paramInput.readFloat();
/*  79 */     this.h = (OnProjectileDespawn)paramKryo.readObject(paramInput, OnProjectileDespawn.class);
/*     */   }
/*     */   
/*     */   private MagnetAbility() {
/*  83 */     super(AbilityType.MAGNET);
/*     */   }
/*     */ 
/*     */   
/*     */   public void configure(int paramInt1, int paramInt2, double paramDouble) {
/*  88 */     this.a = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_MAGNET_COINS);
/*  89 */     this.g = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.ABILITY_MAGNET_DAMAGE_MULTIPLIER);
/*  90 */     this.d = 0.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean start() {
/*  96 */     for (byte b = 0; b < this.S.ability.activeAbilities.size; b++) {
/*     */       Ability ability;
/*  98 */       if ((ability = (Ability)this.S.ability.activeAbilities.get(b)).getType() == AbilityType.MAGNET) {
/*  99 */         if (this.S._gameUi != null) {
/* 100 */           Notifications.i().add(Game.i.localeManager.i18n.get("multiple_abilities_can_not_be_active"), (Drawable)Game.i.assetManager.getDrawable("icon-ability"), MaterialColor.ORANGE.P800, StaticSoundType.FAIL);
/*     */         }
/* 102 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     this.S.events.getListeners(ProjectileDespawn.class).addStateAffecting(this.h);
/*     */     
/* 108 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/* 109 */       this.i = (ParticleEffectPool.PooledEffect)MagnetAbilityFactory.a(Game.i.abilityManager.F.MAGNET).obtain();
/*     */     }
/*     */     
/* 112 */     if (this.e.enemy == null) {
/* 113 */       c();
/*     */     }
/*     */     
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   private void c() {
/* 120 */     this.e = Enemy.EnemyReference.NULL;
/* 121 */     for (byte b = 0; b < this.S.map.spawnedEnemies.size; b++) {
/*     */       Enemy.EnemyReference enemyReference;
/* 123 */       if ((enemyReference = ((Enemy.EnemyReference[])this.S.map.spawnedEnemies.items)[b]).enemy != null)
/*     */       {
/* 125 */         if (this.e.enemy == null || enemyReference.enemy.passedTiles > this.e.enemy.passedTiles) {
/* 126 */           this.e = enemyReference;
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void update(float paramFloat) {
/* 133 */     this.d += paramFloat;
/*     */     
/* 135 */     if (this.d <= 8.0F) {
/*     */       
/* 137 */       if (this.e.enemy == null)
/*     */       {
/* 139 */         c();
/*     */       }
/*     */       
/* 142 */       if (this.e.enemy != null)
/*     */       {
/*     */         
/* 145 */         for (byte b = 0; b < this.S.projectile.projectiles.size; b++) {
/* 146 */           Projectile projectile = ((Projectile[])this.S.projectile.projectiles.items)[b];
/* 147 */           if (!this.f.contains(projectile.id)) {
/*     */             
/* 149 */             this.f.add(projectile.id);
/* 150 */             projectile.multiplyDamage(this.g);
/* 151 */             if (projectile instanceof CollidingProjectile) {
/* 152 */               ((CollidingProjectile)projectile).totalFlyTime *= 2.0F;
/*     */             }
/*     */           } 
/*     */           
/* 156 */           projectile.flyOnEnemy(this.e.enemy);
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 161 */     else if (this.i != null && !this.k) {
/* 162 */       this.i.allowCompletion();
/* 163 */       this.k = true;
/*     */     } 
/*     */ 
/*     */     
/* 167 */     if (this.e.enemy != null)
/*     */     {
/* 169 */       if (this.i != null) {
/* 170 */         this.i.setPosition((this.e.enemy.getPosition()).x, (this.e.enemy.getPosition()).y);
/*     */         
/* 172 */         if (!this.j) {
/* 173 */           this.j = true;
/* 174 */           this.S._particle.addParticle((ParticleEffect)this.i, false);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDone() {
/* 182 */     return (this.d > 9.7F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void draw(Batch paramBatch, float paramFloat) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnregistered() {
/* 192 */     this.e = Enemy.EnemyReference.NULL;
/*     */     
/* 194 */     this.S.events.getListeners(ProjectileDespawn.class).remove(this.h);
/*     */     
/* 196 */     this.f.clear();
/* 197 */     if (this.i != null) {
/* 198 */       this.i.allowCompletion();
/* 199 */       this.i = null;
/*     */     } 
/*     */     
/* 202 */     super.setUnregistered();
/*     */   }
/*     */   
/*     */   public static class MagnetAbilityFactory extends Ability.Factory<MagnetAbility> {
/*     */     private ParticleEffectPool a;
/*     */     
/*     */     public MagnetAbilityFactory(AbilityType param1AbilityType) {
/* 209 */       super(param1AbilityType);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/* 214 */       this.a = Game.i.assetManager.getParticleEffectPool("ability-magnet.prt");
/*     */     }
/*     */ 
/*     */     
/*     */     public MagnetAbility create() {
/* 219 */       return new MagnetAbility((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean requiresMapPointing() {
/* 224 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 229 */       return MaterialColor.PINK.P500;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence getDescription(GameValueProvider param1GameValueProvider) {
/* 234 */       float f = MathUtils.round((float)param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_MAGNET_DAMAGE_MULTIPLIER) * 1000.0F) / 10.0F;
/* 235 */       int i = (int)StrictMath.round(param1GameValueProvider.getPercentValueAsMultiplier(GameValueType.ABILITY_MAGNET_COINS) * 100.0D);
/*     */       
/* 237 */       String str2 = Game.i.localeManager.i18n.format("ability_description_MAGNET", new Object[] { Float.valueOf(f) });
/* 238 */       String str1 = Game.i.localeManager.i18n.format("ability_coins_for_killed_enemies", new Object[] { Integer.valueOf(i) });
/* 239 */       return str2 + "\n" + str1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getDarkerColor() {
/* 244 */       return MaterialColor.PINK.P800;
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInGreenPapers(int param1Int) {
/* 249 */       return MagnetAbility.a()[StrictMath.min(param1Int, (MagnetAbility.a()).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public int getPriceInResources(ResourceType param1ResourceType, int param1Int) {
/* 254 */       return MagnetAbility.b()[param1ResourceType.ordinal()][StrictMath.min(param1Int, (MagnetAbility.b()[0]).length - 1)];
/*     */     }
/*     */ 
/*     */     
/*     */     public TextureRegionDrawable getIconDrawable() {
/* 259 */       return Game.i.assetManager.getDrawable("icon-magnet");
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static final class OnProjectileDespawn extends SerializableListener<MagnetAbility> implements Listener<ProjectileDespawn> {
/*     */     private OnProjectileDespawn() {}
/*     */     
/*     */     private OnProjectileDespawn(MagnetAbility param1MagnetAbility) {
/* 268 */       this.a = param1MagnetAbility;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void handleEvent(ProjectileDespawn param1ProjectileDespawn) {
/* 273 */       MagnetAbility.a((MagnetAbility)this.a).remove((param1ProjectileDespawn.getProjectile()).id);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\abilities\MagnetAbility.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */