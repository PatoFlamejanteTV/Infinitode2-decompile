/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Enemy;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Unit;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.UnitDie;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.tiles.SpawnTile;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ 
/*     */ @REGS
/*     */ public final class UnitSystem
/*     */   extends GameSystem
/*     */ {
/*  33 */   private static final TLog a = TLog.forClass(UnitSystem.class);
/*     */ 
/*     */ 
/*     */   
/*  37 */   private int b = 1;
/*     */   
/*     */   public int spawnedSnowballs;
/*     */   
/*     */   public int spawnedBallLightnings;
/*     */   private float c;
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  45 */     super.write(paramKryo, paramOutput);
/*  46 */     paramOutput.writeVarInt(this.b, true);
/*  47 */     paramOutput.writeInt(this.spawnedSnowballs);
/*  48 */     paramOutput.writeInt(this.spawnedBallLightnings);
/*  49 */     paramOutput.writeFloat(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  54 */     super.read(paramKryo, paramInput);
/*  55 */     this.b = paramInput.readVarInt(true);
/*  56 */     this.spawnedSnowballs = paramInput.readInt();
/*  57 */     this.spawnedBallLightnings = paramInput.readInt();
/*  58 */     this.c = paramInput.readFloat();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  63 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  68 */     if (!this.S.CFG.headless) a(); 
/*     */   }
/*     */   
/*     */   public final float getBallLightningAccumulationTime() {
/*  72 */     return this.c;
/*     */   }
/*     */   
/*     */   private void a() {
/*  76 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.UNIT_DRAW_GROUNDED, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawGrounded(paramBatch, paramFloat2, paramFloat3)))
/*     */ 
/*     */         
/*  79 */         .setName("Unit-drawGrounded"));
/*     */     
/*  81 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.UNIT_DRAW_FLYING, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> drawFlying(paramBatch, paramFloat2, paramFloat3)))
/*     */ 
/*     */         
/*  84 */         .setName("Unit-drawFlying"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postStateRestore() {
/*  94 */     a();
/*     */   }
/*     */   
/*     */   public final boolean preparePathToRandomSpawn(Unit paramUnit, Tile paramTile) {
/*  98 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */ 
/*     */     
/*     */     Array array;
/*     */     
/* 103 */     (array = this.S.TSH.getTileArray()).addAll(this.S.map.getMap().getTilesByType(SpawnTile.class)); int i;
/* 104 */     for (i = array.size - 1; i >= 0; i--) {
/* 105 */       int j = this.S.gameState.randomInt(i + 1);
/* 106 */       SpawnTile spawnTile = (SpawnTile)array.get(i);
/* 107 */       array.set(i, array.get(j));
/* 108 */       array.set(j, spawnTile);
/*     */     } 
/*     */ 
/*     */     
/* 112 */     for (i = 0; i < array.size; i++) {
/* 113 */       Tile tile = (Tile)array.get(i);
/* 114 */       paramUnit.graphPath = this.S.pathfinding.findPathBetweenTiles(paramTile, tile);
/* 115 */       if (paramUnit.graphPath != null) {
/*     */         
/* 117 */         paramUnit.startingTile = paramTile;
/* 118 */         paramUnit.targetTile = tile;
/* 119 */         paramUnit.sideShiftIndex = 5;
/* 120 */         this.S.TSH.freeTileArray(array);
/*     */         
/* 122 */         paramUnit.angle = paramUnit.graphPath.getRotation(paramUnit.passedTiles, paramUnit.sideShiftIndex);
/* 123 */         paramUnit.graphPath.getPosition(paramUnit.passedTiles, paramUnit.sideShiftIndex, paramUnit.position);
/* 124 */         paramUnit.applyDrawInterpolation(0.0F);
/*     */         
/* 126 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 131 */     this.S.TSH.freeTileArray(array);
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public final void register(Unit paramUnit) {
/* 136 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 138 */     paramUnit.id = this.b;
/* 139 */     this.b++;
/*     */     
/* 141 */     paramUnit.setRegistered(this.S);
/*     */     
/* 143 */     if (paramUnit instanceof com.prineside.tdi2.units.SnowballUnit) {
/* 144 */       this.spawnedSnowballs++; return;
/* 145 */     }  if (paramUnit instanceof com.prineside.tdi2.units.BallLightningUnit) {
/* 146 */       this.spawnedBallLightnings++;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Unit paramUnit) {
/* 152 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 154 */     paramUnit.setUnregistered();
/*     */     
/* 156 */     if (paramUnit instanceof com.prineside.tdi2.units.SnowballUnit) {
/* 157 */       this.spawnedSnowballs--; return;
/* 158 */     }  if (paramUnit instanceof com.prineside.tdi2.units.BallLightningUnit) {
/* 159 */       this.spawnedBallLightnings--;
/*     */     }
/*     */   }
/*     */   
/*     */   public final void killUnit(Unit paramUnit, Enemy paramEnemy) {
/* 164 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 166 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/*     */       
/* 169 */       (pooledEffect = Game.i.unitManager.getFactory(paramUnit.type).getBreakParticle()).setPosition(paramUnit.position.x, paramUnit.position.y);
/* 170 */       this.S._particle.addLimitedParticle((ParticleEffect)pooledEffect, LimitedParticleType.UNIT_DEAD, paramUnit.position.x, paramUnit.position.y);
/*     */     } 
/*     */     
/* 173 */     this.S.events.trigger((Event)new UnitDie(paramUnit, paramEnemy));
/* 174 */     this.S.map.a(paramUnit);
/*     */     
/* 176 */     a(paramUnit);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 181 */     this.S.map.spawnedUnits.begin(); byte b; int i;
/* 182 */     for (b = 0, i = this.S.map.spawnedUnits.size; b < i; b++) {
/*     */       Unit unit;
/*     */       
/* 185 */       if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b]).staticPosition) {
/* 186 */         unit.update(paramFloat);
/* 187 */       } else if (unit.graphPath != null) {
/* 188 */         unit.passedTiles += unit.getPassedTilesDelta(paramFloat);
/* 189 */         if (unit.passedTiles >= unit.graphPath.getLengthInTiles()) {
/*     */           
/* 191 */           killUnit(unit, null);
/* 192 */         } else if (unit.passedTiles >= -0.5F) {
/*     */           
/* 194 */           unit.angle = unit.graphPath.getRotation(unit.passedTiles, unit.sideShiftIndex);
/* 195 */           unit.graphPath.getPosition(unit.passedTiles, unit.sideShiftIndex, unit.position);
/*     */ 
/*     */           
/* 198 */           unit.update(paramFloat);
/*     */         } else {
/*     */           
/* 201 */           a.e(unit.passedTiles + " passed tiles", new Object[0]);
/* 202 */           this.S.map.a(unit);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     this.S.map.spawnedUnits.end();
/*     */ 
/*     */ 
/*     */     
/* 211 */     float f = (float)Math.pow((f = 1.0F + (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_TESLA_A_PER_BALL_PENALTY)), this.spawnedBallLightnings);
/* 212 */     this.c = 10.0F * f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 217 */     return "Unit";
/*     */   }
/*     */   
/*     */   public final void drawGrounded(Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 221 */     this.S.map.spawnedUnits.begin(); byte b; int i;
/* 222 */     for (b = 0, i = this.S.map.spawnedUnits.size; b < i; b++) {
/*     */       Unit unit;
/*     */       
/* 225 */       if (!(unit = ((Unit[])this.S.map.spawnedUnits.items)[b]).drawOverEnemies) {
/* 226 */         unit.applyDrawInterpolation(paramFloat2);
/* 227 */         unit.drawBatch(paramBatch, paramFloat1);
/*     */       } 
/*     */     } 
/* 230 */     this.S.map.spawnedUnits.end();
/*     */   }
/*     */   
/*     */   public final void drawFlying(Batch paramBatch, float paramFloat1, float paramFloat2) {
/* 234 */     this.S.map.spawnedUnits.begin(); byte b; int i;
/* 235 */     for (b = 0, i = this.S.map.spawnedUnits.size; b < i; b++) {
/*     */       Unit unit;
/*     */       
/* 238 */       if ((unit = ((Unit[])this.S.map.spawnedUnits.items)[b]).drawOverEnemies) {
/* 239 */         unit.applyDrawInterpolation(paramFloat2);
/* 240 */         unit.drawBatch(paramBatch, paramFloat1);
/*     */       } 
/*     */     } 
/* 243 */     this.S.map.spawnedUnits.end();
/*     */     
/* 245 */     if (Game.i.settingsManager.getCustomValue(SettingsManager.CustomValueType.DBG_DRAW_UNITS_BBOX) != 0.0D) {
/* 246 */       paramBatch.end();
/* 247 */       Game.i.renderingManager.shapeRenderer.setProjectionMatrix(paramBatch.getProjectionMatrix());
/* 248 */       Game.i.renderingManager.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
/* 249 */       Game.i.renderingManager.shapeRenderer.setColor(MaterialColor.CYAN.P500.cpy());
/* 250 */       (Game.i.renderingManager.shapeRenderer.getColor()).a = 0.5F;
/* 251 */       for (b = 0, i = this.S.map.spawnedUnits.size; b < i; b++) {
/* 252 */         Unit unit = ((Unit[])this.S.map.spawnedUnits.items)[b];
/* 253 */         Game.i.renderingManager.shapeRenderer.circle(unit.position.x, unit.position.y, unit.getSize());
/*     */       } 
/* 255 */       Game.i.renderingManager.shapeRenderer.end();
/* 256 */       paramBatch.begin();
/*     */     } 
/*     */     
/* 259 */     paramBatch.setColor(Config.WHITE_COLOR_CACHED_FLOAT_BITS);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\UnitSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */