/*     */ package com.prineside.tdi2.units;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.math.Interpolation;
/*     */ import com.badlogic.gdx.math.Vector2;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Explosion;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.tiles.PlatformTile;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class MineUnit
/*     */   extends Unit
/*     */ {
/*     */   public Tower owner;
/*  29 */   public Vector2 startPos = new Vector2();
/*  30 */   public Vector2 targetPos = new Vector2(); @NAGS
/*  31 */   public float rotation = Float.MAX_VALUE; public float existsTime;
/*     */   public Explosion explosion;
/*     */   @NAGS
/*  34 */   private Color a = new Color();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  38 */     super.write(paramKryo, paramOutput);
/*  39 */     paramKryo.writeClassAndObject(paramOutput, this.owner);
/*  40 */     paramKryo.writeObject(paramOutput, this.startPos);
/*  41 */     paramKryo.writeObject(paramOutput, this.targetPos);
/*  42 */     paramOutput.writeFloat(this.rotation);
/*  43 */     paramOutput.writeFloat(this.existsTime);
/*  44 */     paramKryo.writeClassAndObject(paramOutput, this.explosion);
/*  45 */     paramKryo.writeObject(paramOutput, this.a);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  50 */     super.read(paramKryo, paramInput);
/*  51 */     this.owner = (Tower)paramKryo.readClassAndObject(paramInput);
/*  52 */     this.startPos = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  53 */     this.targetPos = (Vector2)paramKryo.readObject(paramInput, Vector2.class);
/*  54 */     this.rotation = paramInput.readFloat();
/*  55 */     this.existsTime = paramInput.readFloat();
/*  56 */     this.explosion = (Explosion)paramKryo.readClassAndObject(paramInput);
/*  57 */     this.a = (Color)paramKryo.readObject(paramInput, Color.class);
/*     */   }
/*     */   
/*     */   private MineUnit() {
/*  61 */     super(UnitType.MINE);
/*     */   }
/*     */   
/*     */   public final void setup(Tower paramTower, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, Explosion paramExplosion, Color paramColor) {
/*  65 */     this.staticPosition = true;
/*     */     
/*  67 */     this.owner = paramTower;
/*  68 */     this.position.set(paramFloat1, paramFloat2);
/*  69 */     this.startPos.set(paramFloat1, paramFloat2);
/*  70 */     this.targetPos.set(paramFloat3, paramFloat4);
/*  71 */     this.explosion = paramExplosion;
/*  72 */     this.a.set(paramColor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  78 */     if ((paramFloat = 0.5F + this.existsTime * 2.0F) > 1.0F) paramFloat = 1.0F;
/*     */     
/*  80 */     if (this.rotation == Float.MAX_VALUE) {
/*  81 */       this.rotation = -20.0F + FastRandom.getFloat() * 20.0F;
/*     */     }
/*  83 */     paramBatch.setColor(this.a);
/*  84 */     paramBatch.draw(MineUnitFactory.a(Game.i.unitManager.F.MINE), this.position.x - 24.0F, this.position.y - 24.0F, 24.0F, 24.0F, 48.0F, 48.0F, paramFloat, paramFloat, this.rotation);
/*  85 */     paramBatch.setColor(Color.WHITE);
/*     */   }
/*     */   
/*     */   private void a() {
/*  89 */     if (this.S == null) throw new IllegalStateException("Unit " + this + " is unregistered");
/*     */     
/*  91 */     this.explosion.position.set(this.position);
/*  92 */     this.S.explosion.register(this.explosion);
/*  93 */     this.explosion.explode();
/*     */     
/*  95 */     this.S.unit.killUnit(this, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 100 */     if (this.owner != null && !this.owner.isRegistered()) {
/*     */       
/* 102 */       a();
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     this.existsTime += paramFloat;
/*     */ 
/*     */     
/* 109 */     if (this.existsTime < 1.0F) {
/* 110 */       this.position.set(this.startPos);
/* 111 */       this.position.lerp(this.targetPos, Interpolation.pow5Out.apply(this.existsTime));
/*     */     } else {
/* 113 */       this.position.set(this.targetPos);
/*     */     } 
/*     */     
/* 116 */     Tile tile = this.S.map.getMap().getTileByMapPos(this.position.x, this.position.y);
/*     */ 
/*     */     
/* 119 */     if (this.existsTime > 1.0F) {
/* 120 */       if (tile == null || (tile.type == TileType.PLATFORM && ((PlatformTile)tile).building != null)) {
/* 121 */         a();
/*     */         return;
/*     */       } 
/* 124 */       if (tile.enemyCount != 0) {
/* 125 */         this.S.map.getEnemiesInCircleV(this.position, 32.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */               if (paramEnemyReference.enemy != null && !paramEnemyReference.enemy.isAir()) {
/*     */                 a();
/*     */                 return false;
/*     */               } 
/*     */               return true;
/*     */             });
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class MineUnitFactory
/*     */     extends Unit.Factory.BasicAbstractFactory<MineUnit>
/*     */   {
/*     */     private TextureRegion a;
/*     */     
/*     */     public void setupAssets() {
/* 142 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("mine");
/*     */     }
/*     */ 
/*     */     
/*     */     public MineUnit create() {
/* 147 */       return new MineUnit((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 152 */       return Color.WHITE;
/*     */     }
/*     */ 
/*     */     
/*     */     public UnitType getUnitType() {
/* 157 */       return UnitType.MINE;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\units\MineUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */