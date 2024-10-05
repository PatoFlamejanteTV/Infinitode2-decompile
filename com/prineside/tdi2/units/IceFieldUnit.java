/*     */ package com.prineside.tdi2.units;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.TextureRegion;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.buffs.SlippingBuff;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.UnitType;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS
/*     */ public final class IceFieldUnit extends Unit {
/*     */   public float lifetimeLeft;
/*     */   public int touchesLeft;
/*  23 */   public ObjectSet<Enemy.EnemyReference> affectedEnemies = new ObjectSet();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  27 */     super.write(paramKryo, paramOutput);
/*  28 */     paramOutput.writeFloat(this.lifetimeLeft);
/*  29 */     paramOutput.writeVarInt(this.touchesLeft, true);
/*  30 */     paramKryo.writeObject(paramOutput, this.affectedEnemies);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  35 */     super.read(paramKryo, paramInput);
/*  36 */     this.lifetimeLeft = paramInput.readFloat();
/*  37 */     this.touchesLeft = paramInput.readVarInt(true);
/*  38 */     this.affectedEnemies = (ObjectSet<Enemy.EnemyReference>)paramKryo.readObject(paramInput, ObjectSet.class);
/*     */   }
/*     */   
/*     */   private IceFieldUnit() {
/*  42 */     super(UnitType.ICE_FIELD);
/*     */   }
/*     */   
/*     */   public final void setup(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt) {
/*  46 */     this.staticPosition = true;
/*  47 */     this.touchesLeft = paramInt;
/*  48 */     this.position.set(paramFloat1, paramFloat2);
/*  49 */     this.lifetimeLeft = paramFloat3;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void drawBatch(Batch paramBatch, float paramFloat) {
/*  54 */     paramBatch.setColor(Color.WHITE);
/*  55 */     paramBatch.draw(IceFieldUnitFactory.a(Game.i.unitManager.F.ICE_FIELD), this.position.x - 75.0F, this.position.y - 75.0F, 75.0F, 75.0F, 150.0F, 150.0F, 1.0F, 1.0F, 0.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/*  60 */     this.lifetimeLeft -= paramFloat;
/*  61 */     if (this.lifetimeLeft <= 0.0F) {
/*  62 */       this.S.unit.killUnit(this, null); return;
/*     */     } 
/*     */     Tile tile;
/*  65 */     if ((tile = this.S.map.getMap().getTileByMapPos(this.position.x, this.position.y)) != null && tile.enemyCount != 0) {
/*  66 */       this.S.map.getEnemiesInRect(this.position.x - 64.0F, this.position.y - 64.0F, this.position.x + 64.0F, this.position.y + 64.0F, (paramEnemyReference, paramFloat1, paramFloat2, paramFloat3) -> {
/*     */             if (paramEnemyReference.enemy == null) {
/*     */               return true;
/*     */             }
/*     */             Enemy enemy;
/*     */             if (!(enemy = paramEnemyReference.enemy).isAir()) {
/*     */               if (!enemy.hasBuffsByType(BuffType.SLIPPING)) {
/*     */                 SlippingBuff slippingBuff;
/*     */                 (slippingBuff = new SlippingBuff()).setup(0.21F, 1.0F);
/*     */                 this.S.buff.P_SLIPPING.addBuff(enemy, slippingBuff);
/*     */               } 
/*     */               if (this.touchesLeft > 0 && !this.affectedEnemies.contains(paramEnemyReference)) {
/*     */                 this.affectedEnemies.add(paramEnemyReference);
/*     */                 this.touchesLeft--;
/*     */                 if (this.touchesLeft == 0) {
/*     */                   this.lifetimeLeft = Math.min(this.lifetimeLeft, 5.0F);
/*     */                   return false;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             return true;
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class IceFieldUnitFactory
/*     */     extends Unit.Factory.BasicAbstractFactory<IceFieldUnit>
/*     */   {
/*     */     private TextureRegion a;
/*     */ 
/*     */     
/*     */     public void setupAssets() {
/*  99 */       this.a = (TextureRegion)Game.i.assetManager.getTextureRegion("tile-ice-overlay");
/*     */     }
/*     */ 
/*     */     
/*     */     public IceFieldUnit create() {
/* 104 */       return new IceFieldUnit((byte)0);
/*     */     }
/*     */ 
/*     */     
/*     */     public Color getColor() {
/* 109 */       return Color.WHITE;
/*     */     }
/*     */ 
/*     */     
/*     */     public UnitType getUnitType() {
/* 114 */       return UnitType.ICE_FIELD;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\units\IceFieldUnit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */