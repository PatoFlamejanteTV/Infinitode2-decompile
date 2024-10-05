/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.ExplosionType;
/*     */ import com.prineside.tdi2.explosions.AirFallExplosion;
/*     */ import com.prineside.tdi2.explosions.CannonExplosion;
/*     */ import com.prineside.tdi2.explosions.FireballExplosion;
/*     */ import com.prineside.tdi2.explosions.GenericExplosion;
/*     */ import com.prineside.tdi2.explosions.MissileExplosion;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ 
/*     */ @REGS
/*     */ public final class ExplosionSystem extends GameSystem {
/*     */   private Array<Explosion> a;
/*     */   
/*     */   public ExplosionSystem() {
/*  21 */     this.a = new Array(false, 16, Explosion.class);
/*     */ 
/*     */     
/*  24 */     this.F = new Factories();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  32 */     this.b = (Explosion.Factory<?>[])new Explosion.Factory[ExplosionType.values.length];
/*     */     
/*  34 */     this.b[ExplosionType.CANNON.ordinal()] = (Explosion.Factory<?>)this.F.CANNON;
/*  35 */     this.b[ExplosionType.MISSILE.ordinal()] = (Explosion.Factory<?>)this.F.MISSILE;
/*  36 */     this.b[ExplosionType.FIREBALL.ordinal()] = (Explosion.Factory<?>)this.F.FIREBALL;
/*  37 */     this.b[ExplosionType.AIR_FALL.ordinal()] = (Explosion.Factory<?>)this.F.AIR_FALL;
/*  38 */     this.b[ExplosionType.GENERIC.ordinal()] = (Explosion.Factory<?>)this.F.GENERIC; ExplosionType[] arrayOfExplosionType; int i;
/*     */     byte b;
/*  40 */     for (i = (arrayOfExplosionType = ExplosionType.values).length, b = 0; b < i; ) { ExplosionType explosionType = arrayOfExplosionType[b];
/*  41 */       if (this.b[explosionType.ordinal()] == null)
/*  42 */         throw new RuntimeException("Not all explosion factories were created");  b++; }
/*     */     
/*     */     Explosion.Factory<?>[] arrayOfFactory;
/*  45 */     for (i = (arrayOfFactory = this.b).length, b = 0; b < i; b++) {
/*  46 */       Explosion.Factory<?> factory; (factory = arrayOfFactory[b]).setup(this);
/*     */     } 
/*     */   } @NAGS
/*     */   public final Factories F; @NAGS
/*     */   private final Explosion.Factory<?>[] b; public static final class Factories {
/*     */     public final CannonExplosion.CannonExplosionFactory CANNON = new CannonExplosion.CannonExplosionFactory(); public final MissileExplosion.MissileExplosionFactory MISSILE = new MissileExplosion.MissileExplosionFactory(); public final FireballExplosion.FireballExplosionFactory FIREBALL = new FireballExplosion.FireballExplosionFactory(); public final AirFallExplosion.AirFallExplosionFactory AIR_FALL = new AirFallExplosion.AirFallExplosionFactory(); public final GenericExplosion.GenericExplosionFactory GENERIC = new GenericExplosion.GenericExplosionFactory(); }
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  53 */     super.write(paramKryo, paramOutput);
/*  54 */     paramKryo.writeObject(paramOutput, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  59 */     super.read(paramKryo, paramInput);
/*  60 */     this.a = (Array<Explosion>)paramKryo.readObject(paramInput, Array.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  65 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setup() {}
/*     */ 
/*     */   
/*     */   public final Explosion.Factory<? extends Explosion> getFactory(ExplosionType paramExplosionType) {
/*  74 */     return (Explosion.Factory)this.b[paramExplosionType.ordinal()];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void register(Explosion paramExplosion) {
/*  82 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/*  84 */     paramExplosion.setRegistered(this.S);
/*  85 */     this.a.add(paramExplosion);
/*     */     
/*  87 */     if (Game.i.debugManager != null && Game.i.debugManager.isEnabled()) Game.i.debugManager.registerValue("Explosions count").append(this.a.size); 
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/*     */     Explosion explosion;
/*  92 */     (explosion = ((Explosion[])this.a.items)[paramInt]).setUnregistered();
/*  93 */     this.a.removeIndex(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*     */     int i;
/*  99 */     for (i = this.a.size - 1; i >= 0; i--) {
/* 100 */       ((Explosion[])this.a.items)[i].update(paramFloat);
/*     */     }
/*     */ 
/*     */     
/* 104 */     for (i = this.a.size - 1; i >= 0; i--) {
/*     */       Explosion explosion;
/* 106 */       if ((explosion = ((Explosion[])this.a.items)[i]).isDone()) {
/* 107 */         a(i);
/*     */ 
/*     */         
/* 110 */         if (Game.i.debugManager != null && Game.i.debugManager.isEnabled()) Game.i.debugManager.registerValue("Explosions count").append(this.a.size);
/*     */       
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final String getSystemName() {
/* 117 */     return "Explosion";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 123 */     for (byte b = 0; b < this.a.size; b++) {
/* 124 */       ((Explosion[])this.a.items)[b].setUnregistered();
/*     */     }
/* 126 */     this.a.clear();
/*     */     
/* 128 */     Game.i.debugManager.unregisterValue("Explosions count");
/*     */     
/* 130 */     super.dispose();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ExplosionSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */