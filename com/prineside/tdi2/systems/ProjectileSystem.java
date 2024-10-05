/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Projectile;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.projectiles.AirProjectile;
/*     */ import com.prineside.tdi2.projectiles.BasicProjectile;
/*     */ import com.prineside.tdi2.projectiles.ChainLightningProjectile;
/*     */ import com.prineside.tdi2.projectiles.LaserProjectile;
/*     */ import com.prineside.tdi2.projectiles.MissileProjectile;
/*     */ import com.prineside.tdi2.projectiles.MultishotProjectile;
/*     */ import com.prineside.tdi2.projectiles.SplashProjectile;
/*     */ import com.prineside.tdi2.projectiles.SplinterProjectile;
/*     */ import com.prineside.tdi2.projectiles.VenomProjectile;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ 
/*     */ @REGS
/*     */ public final class ProjectileSystem extends GameSystem {
/*     */   public DelayedRemovalArray<Projectile> projectiles;
/*     */   public int nextProjectileId;
/*     */   @NAGS
/*     */   private final Projectile.Factory<?>[] a;
/*     */   @NAGS
/*     */   public final Factories F;
/*     */   
/*     */   public ProjectileSystem() {
/*  33 */     this.projectiles = new DelayedRemovalArray(false, 16, Projectile.class);
/*  34 */     this.nextProjectileId = 1;
/*     */     
/*  36 */     this.a = (Projectile.Factory<?>[])new Projectile.Factory[ProjectileType.values.length];
/*     */ 
/*     */     
/*  39 */     this.F = new Factories();
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
/*  55 */     this.a[ProjectileType.AIR.ordinal()] = (Projectile.Factory<?>)this.F.AIR;
/*  56 */     this.a[ProjectileType.BASIC.ordinal()] = (Projectile.Factory<?>)this.F.BASIC;
/*  57 */     this.a[ProjectileType.CANNON.ordinal()] = (Projectile.Factory<?>)this.F.CANNON;
/*  58 */     this.a[ProjectileType.SPLINTER.ordinal()] = (Projectile.Factory<?>)this.F.SPLINTER;
/*  59 */     this.a[ProjectileType.CHAIN_LIGHTNING.ordinal()] = (Projectile.Factory<?>)this.F.CHAIN_LIGHTNING;
/*  60 */     this.a[ProjectileType.MISSILE.ordinal()] = (Projectile.Factory<?>)this.F.MISSILE;
/*  61 */     this.a[ProjectileType.MULTISHOT.ordinal()] = (Projectile.Factory<?>)this.F.MULTISHOT;
/*  62 */     this.a[ProjectileType.SPLASH.ordinal()] = (Projectile.Factory<?>)this.F.SPLASH;
/*  63 */     this.a[ProjectileType.VENOM.ordinal()] = (Projectile.Factory<?>)this.F.VENOM;
/*  64 */     this.a[ProjectileType.LASER.ordinal()] = (Projectile.Factory<?>)this.F.LASER;
/*  65 */     this.a[ProjectileType.BULLET_WALL.ordinal()] = (Projectile.Factory<?>)this.F.BULLET_WALL;
/*  66 */     this.a[ProjectileType.BUFF.ordinal()] = (Projectile.Factory<?>)this.F.BUFF; ProjectileType[] arrayOfProjectileType; int i;
/*     */     byte b;
/*  68 */     for (i = (arrayOfProjectileType = ProjectileType.values).length, b = 0; b < i; ) { ProjectileType projectileType = arrayOfProjectileType[b];
/*  69 */       if (this.a[projectileType.ordinal()] == null)
/*  70 */         throw new RuntimeException("Not all projectile factories were created"); 
/*     */       b++; }
/*     */     
/*     */     Projectile.Factory<?>[] arrayOfFactory;
/*  74 */     for (i = (arrayOfFactory = this.a).length, b = 0; b < i; b++) {
/*  75 */       Projectile.Factory<?> factory; (factory = arrayOfFactory[b]).setup(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  82 */     super.write(paramKryo, paramOutput);
/*  83 */     paramKryo.writeObject(paramOutput, this.projectiles);
/*  84 */     paramOutput.writeInt(this.nextProjectileId);
/*     */   }
/*     */   public static final class Factories {
/*     */     public final AirProjectile.AirProjectileFactory AIR = new AirProjectile.AirProjectileFactory(); public final BasicProjectile.BasicProjectileFactory BASIC = new BasicProjectile.BasicProjectileFactory(); public final CannonProjectile.CannonProjectileFactory CANNON = new CannonProjectile.CannonProjectileFactory(); public final SplinterProjectile.SplinterProjectileFactory SPLINTER = new SplinterProjectile.SplinterProjectileFactory(); public final ChainLightningProjectile.ChainLightningProjectileFactory CHAIN_LIGHTNING = new ChainLightningProjectile.ChainLightningProjectileFactory(); public final MissileProjectile.MissileProjectileFactory MISSILE = new MissileProjectile.MissileProjectileFactory(); public final MultishotProjectile.MultishotProjectileFactory MULTISHOT = new MultishotProjectile.MultishotProjectileFactory(); public final SplashProjectile.SplashProjectileFactory SPLASH = new SplashProjectile.SplashProjectileFactory(); public final VenomProjectile.VenomProjectileFactory VENOM = new VenomProjectile.VenomProjectileFactory(); public final LaserProjectile.LaserProjectileFactory LASER = new LaserProjectile.LaserProjectileFactory(); public final BulletWallProjectile.MultishotProjectileFactory BULLET_WALL = new BulletWallProjectile.MultishotProjectileFactory(); public final BuffProjectile.BuffProjectileFactory BUFF = new BuffProjectile.BuffProjectileFactory(); }
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  89 */     super.read(paramKryo, paramInput);
/*  90 */     this.projectiles = (DelayedRemovalArray<Projectile>)paramKryo.readObject(paramInput, DelayedRemovalArray.class);
/*  91 */     this.nextProjectileId = paramInput.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  96 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/* 101 */     if (!this.S.CFG.headless) a();
/*     */   
/*     */   }
/*     */   
/*     */   public final void postStateRestore() {
/* 106 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/* 110 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.PROJECTILE_DRAW, true, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramBatch, paramFloat2, paramFloat3)))
/*     */ 
/*     */         
/* 113 */         .setName("Projectile-draw"));
/*     */   }
/*     */   
/*     */   public final Projectile.Factory<? extends Projectile> getFactory(ProjectileType paramProjectileType) {
/* 117 */     return (Projectile.Factory)this.a[paramProjectileType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void register(Projectile paramProjectile) {
/* 125 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 127 */     if (paramProjectile.isRegistered()) throw new RuntimeException("Already registered");
/*     */ 
/*     */ 
/*     */     
/* 131 */     paramProjectile.id = this.nextProjectileId++;
/*     */     
/* 133 */     paramProjectile.setRegistered(this.S);
/* 134 */     this.projectiles.add(paramProjectile);
/*     */     
/* 136 */     this.S.events.getListeners(ProjectileSpawn.class).trigger((Event)new ProjectileSpawn(paramProjectile));
/*     */     
/* 138 */     if (Game.i.debugManager != null && Game.i.debugManager.isEnabled()) Game.i.debugManager.registerValue("Projectiles count").append(this.projectiles.size);
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 144 */     IntArray intArray = null;
/* 145 */     this.projectiles.begin(); byte b; int i;
/* 146 */     for (b = 0, i = this.projectiles.size; b < i; b++) {
/*     */       Projectile projectile;
/* 148 */       (projectile = ((Projectile[])this.projectiles.items)[b]).update(paramFloat);
/* 149 */       if (projectile.isDone()) {
/*     */         
/* 151 */         if (intArray == null) {
/* 152 */           intArray = new IntArray();
/*     */         }
/* 154 */         intArray.add(b);
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     this.projectiles.end();
/*     */ 
/*     */     
/* 161 */     if (intArray != null) {
/* 162 */       this.projectiles.begin();
/* 163 */       for (b = 0, i = intArray.size; b < i; b++) {
/* 164 */         int j = intArray.items[b];
/*     */         Projectile projectile;
/* 166 */         (projectile = ((Projectile[])this.projectiles.items)[j]).onDone();
/* 167 */         this.S.events.trigger((Event)new ProjectileDespawn(projectile));
/* 168 */         projectile.setUnregistered();
/* 169 */         getFactory(projectile.type).free(projectile);
/* 170 */         this.projectiles.removeIndex(j);
/*     */       } 
/* 172 */       this.projectiles.end();
/*     */     } 
/*     */     
/* 175 */     if (Game.i.debugManager != null && Game.i.debugManager.isEnabled()) Game.i.debugManager.registerValue("Projectiles count").append(this.projectiles.size);
/*     */   
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/* 180 */     return "Projectile";
/*     */   }
/*     */   
/*     */   public final void draw(Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 184 */     if (!Game.i.settingsManager.isProjectilesDrawing())
/*     */       return; 
/* 186 */     for (int i = this.projectiles.size - 1; i >= 0; i--) {
/* 187 */       ((Projectile[])this.projectiles.items)[i].applyDrawInterpolation(paramFloat2);
/* 188 */       ((Projectile[])this.projectiles.items)[i].draw(paramBatch, paramFloat1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 195 */     this.projectiles.clear();
/* 196 */     Game.i.debugManager.unregisterValue("Projectiles count");
/*     */     
/* 198 */     super.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ProjectileSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */