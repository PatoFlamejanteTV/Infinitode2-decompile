/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.badlogic.gdx.utils.Disposable;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.pathfinding.Path;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(classOnly = true)
/*     */ public abstract class Unit extends Registrable {
/*     */   public int id;
/*  22 */   public Vector2 position = new Vector2();
/*  23 */   public float angle = 0.0F;
/*     */   
/*     */   @NAGS
/*  26 */   public Vector2 drawPosition = new Vector2(); @NAGS
/*     */   public float drawAngle;
/*     */   public UnitType type;
/*  29 */   public float speed = 1.0F;
/*     */   
/*     */   public Tile startingTile;
/*     */   
/*     */   public Tile targetTile;
/*     */   
/*     */   public boolean staticPosition;
/*     */   
/*     */   public boolean drawOverEnemies;
/*     */   
/*     */   public int sideShiftIndex;
/*     */   
/*     */   public float passedTiles;
/*     */   public Path graphPath;
/*     */   public boolean spawned;
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/*  46 */     super.write(paramKryo, paramOutput);
/*  47 */     paramOutput.writeVarInt(this.id, true);
/*  48 */     paramKryo.writeObject(paramOutput, this.position);
/*  49 */     paramOutput.writeFloat(this.angle);
/*  50 */     paramKryo.writeObject(paramOutput, this.type);
/*  51 */     paramOutput.writeFloat(this.speed);
/*  52 */     paramKryo.writeClassAndObject(paramOutput, this.startingTile);
/*  53 */     paramKryo.writeClassAndObject(paramOutput, this.targetTile);
/*  54 */     paramOutput.writeBoolean(this.staticPosition);
/*  55 */     paramOutput.writeBoolean(this.drawOverEnemies);
/*  56 */     paramOutput.writeInt(this.sideShiftIndex);
/*  57 */     paramOutput.writeFloat(this.passedTiles);
/*  58 */     paramKryo.writeObjectOrNull(paramOutput, this.graphPath, Path.class);
/*  59 */     paramOutput.writeBoolean(this.spawned);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/*  64 */     super.read(paramKryo, paramInput);
/*  65 */     this.id = paramInput.readVarInt(true);
/*  66 */     this.position = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  67 */     this.angle = paramInput.readFloat();
/*  68 */     this.type = (UnitType)paramKryo.readObject(paramInput, UnitType.class);
/*  69 */     this.speed = paramInput.readFloat();
/*  70 */     this.startingTile = (Tile)paramKryo.readClassAndObject(paramInput);
/*  71 */     this.targetTile = (Tile)paramKryo.readClassAndObject(paramInput);
/*  72 */     this.staticPosition = paramInput.readBoolean();
/*  73 */     this.drawOverEnemies = paramInput.readBoolean();
/*  74 */     this.sideShiftIndex = paramInput.readInt();
/*  75 */     this.passedTiles = paramInput.readFloat();
/*  76 */     this.graphPath = (Path)paramKryo.readObjectOrNull(paramInput, Path.class);
/*  77 */     this.spawned = paramInput.readBoolean();
/*     */   }
/*     */   
/*     */   private Unit() {}
/*     */   
/*     */   protected Unit(UnitType paramUnitType) {
/*  83 */     this.type = paramUnitType;
/*     */   }
/*     */   public float getSize() {
/*  86 */     return 25.6F;
/*     */   }
/*     */   public void update(float paramFloat) {}
/*     */   
/*     */   public void applyDrawInterpolation(float paramFloat) {
/*  91 */     if (paramFloat != 0.0F && !this.staticPosition) {
/*  92 */       paramFloat = this.passedTiles + getPassedTilesDelta(paramFloat);
/*  93 */       this.graphPath.getPosition(paramFloat, this.sideShiftIndex, this.drawPosition);
/*  94 */       this.drawAngle = this.graphPath.getRotation(paramFloat, this.sideShiftIndex); return;
/*     */     } 
/*  96 */     this.drawAngle = this.angle;
/*  97 */     this.drawPosition.set(this.position);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float getPassedTilesDelta(float paramFloat) {
/* 102 */     if (this.staticPosition) throw new IllegalStateException("Unit is static"); 
/* 103 */     return this.graphPath.getPassedTilesDelta(paramFloat, this.passedTiles, this.sideShiftIndex, this.speed);
/*     */   }
/*     */   
/*     */   public abstract void drawBatch(Batch paramBatch, float paramFloat);
/*     */   
/*     */   public void onSpawned() {}
/*     */   
/*     */   public void onDespawned() {}
/*     */   
/*     */   public static interface Factory<T extends Unit> extends Disposable, EntityFactory {
/*     */     void setup();
/*     */     
/*     */     T create();
/*     */     
/*     */     Color getColor();
/*     */     
/*     */     ParticleEffectPool.PooledEffect getBreakParticle();
/*     */     
/*     */     void dispose();
/*     */     
/*     */     UnitType getUnitType();
/*     */     
/*     */     public static abstract class BasicAbstractFactory<T extends Unit> implements Factory<T> {
/*     */       public BasicAbstractFactory() {
/* 127 */         if (Game.i.assetManager != null) {
/*     */           ParticleEffect particleEffect;
/*     */           
/* 130 */           (particleEffect = new ParticleEffect()).load(Gdx.files.internal("particles/break.prt"), Game.i.assetManager.getTextureRegion("particle-triangle").getAtlas());
/* 131 */           particleEffect.setEmittersCleanUpBlendFunction(false);
/* 132 */           ((ParticleEmitter)particleEffect.getEmitters().get(0)).getTint().setColors(new float[] { (getColor()).r, (getColor()).g, (getColor()).b });
/* 133 */           this.a = Game.i.assetManager.getParticleEffectPoolWithTemplate("break.prt@unitType:" + getUnitType().name(), particleEffect);
/*     */         } 
/*     */       }
/*     */       private ParticleEffectPool a;
/*     */       
/*     */       public void setup() {
/* 139 */         if (Game.i.assetManager != null) {
/* 140 */           setupAssets();
/*     */         }
/*     */       }
/*     */ 
/*     */       
/*     */       public void setupAssets() {}
/*     */ 
/*     */       
/*     */       public void dispose() {}
/*     */       
/*     */       public ParticleEffectPool.PooledEffect getBreakParticle() {
/* 151 */         return (ParticleEffectPool.PooledEffect)this.a.obtain();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\Unit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */