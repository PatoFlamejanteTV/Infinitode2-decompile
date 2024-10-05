/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Pool;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.systems.ProjectileSystem;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class Projectile extends Registrable implements Pool.Poolable {
/*     */   public ProjectileType type;
/*  16 */   public int id = 0;
/*     */   protected float c;
/*  18 */   public Vector2 position = new Vector2();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  22 */     super.write(paramKryo, paramOutput);
/*  23 */     paramKryo.writeObjectOrNull(paramOutput, this.type, ProjectileType.class);
/*  24 */     paramOutput.writeInt(this.id);
/*  25 */     paramOutput.writeFloat(this.c);
/*  26 */     paramKryo.writeObject(paramOutput, this.position);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  31 */     super.read(paramKryo, paramInput);
/*  32 */     this.type = (ProjectileType)paramKryo.readObjectOrNull(paramInput, ProjectileType.class);
/*  33 */     this.id = paramInput.readInt();
/*  34 */     this.c = paramInput.readFloat();
/*  35 */     this.position = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*     */   }
/*     */   
/*     */   protected Projectile(ProjectileType paramProjectileType) {
/*  39 */     this.type = paramProjectileType;
/*     */   }
/*     */   
/*     */   public void setup() {
/*  43 */     if (!isRegistered()) {
/*  44 */       throw new IllegalStateException("Projectile must be registered by ProjectileSystem before it can be set up");
/*     */     }
/*     */   }
/*     */   
/*     */   public Vector2 getPosition() {
/*  49 */     return this.position;
/*     */   }
/*     */   
/*     */   public float getDamage() {
/*  53 */     return this.c;
/*     */   }
/*     */   
/*     */   public void setDamage(float paramFloat) {
/*  57 */     this.c = paramFloat;
/*     */   }
/*     */   
/*     */   public void multiplyDamage(float paramFloat) {
/*  61 */     this.c *= paramFloat;
/*     */   }
/*     */ 
/*     */   
/*     */   public void reset() {
/*  66 */     this.c = 0.0F;
/*  67 */     this.id = 0;
/*  68 */     this.position.setZero();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hit() {}
/*     */ 
/*     */   
/*     */   public abstract boolean isDone();
/*     */ 
/*     */   
/*     */   public abstract boolean hasReachedTarget();
/*     */ 
/*     */   
/*     */   public void onDone() {}
/*     */ 
/*     */   
/*     */   public void flyOnEnemy(Enemy paramEnemy) {}
/*     */ 
/*     */   
/*     */   public abstract void applyDrawInterpolation(float paramFloat);
/*     */   
/*     */   public abstract void update(float paramFloat);
/*     */   
/*     */   public abstract void draw(Batch paramBatch, float paramFloat);
/*     */   
/*     */   public String toString() {
/*  94 */     return super.toString() + " (id: " + this.id + ", damage: " + this.c + ", position: " + this.position + ", S: " + ((this.S != null) ? 1 : 0) + ")";
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
/*     */   public static abstract class Factory<T extends Projectile>
/*     */     implements EntityFactory
/*     */   {
/*     */     public void setup(ProjectileSystem param1ProjectileSystem) {
/* 113 */       if (Game.i.assetManager != null) {
/* 114 */         setupAssets();
/*     */       }
/*     */     }
/*     */     
/*     */     public void setupAssets() {}
/*     */     
/*     */     protected abstract T a();
/*     */     
/*     */     public final T obtain() {
/* 123 */       return a();
/*     */     }
/*     */     
/*     */     public final void free(Projectile param1Projectile) {}
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Projectile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */