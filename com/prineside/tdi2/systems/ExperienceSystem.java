/*     */ package com.prineside.tdi2.systems;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffect;
/*     */ import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.FloatArray;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.badlogic.gdx.utils.IntIntMap;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.events.Event;
/*     */ import com.prineside.tdi2.events.game.TowerAbilityChange;
/*     */ import com.prineside.tdi2.events.game.TowerExperienceChange;
/*     */ import com.prineside.tdi2.events.game.TowerLevelUp;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS
/*     */ public final class ExperienceSystem extends GameSystem {
/*     */   private float a;
/*     */   
/*     */   static {
/*  30 */     TLog.forClass(ExperienceSystem.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  35 */   private Array<Tower> b = new Array(true, 1, Tower.class);
/*  36 */   private FloatArray c = new FloatArray();
/*     */   @NAGS
/*  38 */   private final IntIntMap d = new IntIntMap(); @NAGS
/*  39 */   private final IntArray e = new IntArray();
/*     */ 
/*     */   
/*     */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  43 */     super.write(paramKryo, paramOutput);
/*  44 */     paramOutput.writeFloat(this.a);
/*  45 */     paramKryo.writeObject(paramOutput, this.b);
/*  46 */     paramKryo.writeObject(paramOutput, this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public final void read(Kryo paramKryo, Input paramInput) {
/*  51 */     super.read(paramKryo, paramInput);
/*  52 */     this.a = paramInput.readFloat();
/*  53 */     this.b = (Array<Tower>)paramKryo.readObject(paramInput, Array.class);
/*  54 */     this.c = (FloatArray)paramKryo.readObject(paramInput, FloatArray.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void addExperienceRaw(Tower paramTower, float paramFloat) {
/*  61 */     if (!paramTower.isRegistered())
/*     */       return; 
/*  63 */     paramTower.addExperience(paramFloat);
/*  64 */     this.b.add(paramTower);
/*  65 */     this.c.add(paramFloat);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float addExperienceBuffed(Tower paramTower, float paramFloat) {
/*  73 */     paramFloat *= paramTower.experienceMultiplier;
/*  74 */     addExperienceRaw(paramTower, paramFloat);
/*  75 */     return paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float removeExperienceRaw(Tower paramTower, float paramFloat) {
/*  82 */     if (paramFloat > paramTower.currentLevelExperience) {
/*  83 */       paramFloat = paramTower.currentLevelExperience;
/*     */     }
/*  85 */     paramTower.setExperience(paramTower.experience - paramFloat);
/*  86 */     this.b.add(paramTower);
/*  87 */     this.c.add(-paramFloat);
/*     */     
/*  89 */     return paramFloat;
/*     */   }
/*     */   
/*     */   public final void updateLevelExperience(Tower paramTower) {
/*  93 */     short s = paramTower.getLevel();
/*  94 */     paramTower.calculateXpLevel(false);
/*  95 */     if (paramTower.getLevel() != s) {
/*  96 */       this.S.map.markTilesDirtyNearTile((Tile)paramTower.getTile(), 1);
/*     */     }
/*     */     
/*  99 */     if (paramTower.getLevel() > s) {
/* 100 */       notifyTowerLeveledUp(paramTower);
/*     */     }
/*     */   }
/*     */   
/*     */   public final void notifyTowerLeveledUp(Tower paramTower) {
/* 105 */     this.S.gameState.checkGameplayUpdateAllowed();
/*     */     
/* 107 */     this.S.events.trigger((Event)new TowerLevelUp(paramTower));
/*     */     
/* 109 */     if (paramTower.getLevel() == 10) {
/*     */       
/* 111 */       this.S.events.trigger((Event)new TowerAbilityChange(paramTower, 3, true));
/* 112 */       paramTower.onAbilitySet(3, true);
/*     */     } 
/*     */ 
/*     */     
/* 116 */     if (this.S._particle != null && Game.i.settingsManager.isParticlesDrawing()) {
/*     */       ParticleEffectPool.PooledEffect pooledEffect;
/* 118 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.lvlUpParticles.obtain()).setPosition((paramTower.getTile()).center.x, (paramTower.getTile()).center.y);
/* 119 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */ 
/*     */       
/* 122 */       (pooledEffect = (ParticleEffectPool.PooledEffect)Game.i.towerManager.highlightParticles[paramTower.type.ordinal()].obtain()).setPosition((paramTower.getTile()).center.x, (paramTower.getTile()).center.y);
/* 123 */       this.S._particle.addParticle((ParticleEffect)pooledEffect, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(float paramFloat) {
/* 128 */     this.a += paramFloat;
/* 129 */     if (this.S.gameState.isGameRealTimePasses() && this.a > 1.0F) {
/* 130 */       this.a = 0.0F;
/*     */       
/*     */       DelayedRemovalArray<Tower> delayedRemovalArray;
/* 133 */       (delayedRemovalArray = this.S.tower.towers).begin(); byte b; int i;
/* 134 */       for (b = 0, i = delayedRemovalArray.size; b < i; b++) {
/*     */         Tower tower;
/* 136 */         if ((tower = ((Tower[])delayedRemovalArray.items)[b]).experienceGeneration != 0.0F) {
/* 137 */           float f = tower.experienceGeneration;
/* 138 */           if (this.S.gameState.isDoubleSpeedActive()) {
/* 139 */             f *= 2.0F;
/*     */           }
/* 141 */           addExperienceRaw(tower, f);
/* 142 */           this.S.statistics.addStatistic(StatisticsType.XPG_TG, f);
/*     */         } 
/*     */       } 
/* 145 */       delayedRemovalArray.end();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 152 */     a(paramFloat);
/*     */ 
/*     */     
/* 155 */     if (this.c.size != 0) {
/*     */       
/* 157 */       this.d.clear();
/* 158 */       this.e.clear();
/* 159 */       int i = this.c.size; byte b;
/* 160 */       for (b = 0; b < i; b++) {
/* 161 */         Tower tower = ((Tower[])this.b.items)[b];
/*     */         int k;
/* 163 */         if ((k = this.d.get(tower.id, -1)) == -1) {
/*     */           
/* 165 */           this.d.put(tower.id, b);
/* 166 */           this.e.add(b);
/*     */         } else {
/*     */           
/* 169 */           this.c.items[k] = this.c.items[k] + this.c.items[b];
/*     */         } 
/*     */       } 
/*     */       
/*     */       int j;
/* 174 */       for (b = 0, j = this.e.size; b < j; b++) {
/* 175 */         int k = this.e.items[b];
/* 176 */         Tower tower = ((Tower[])this.b.items)[k];
/* 177 */         float f = this.c.items[k];
/* 178 */         this.S.events.getListeners(TowerExperienceChange.class).trigger((Event)new TowerExperienceChange(tower, f));
/*     */       } 
/* 180 */       this.b.removeRange(0, i - 1);
/* 181 */       this.c.removeRange(0, i - 1);
/*     */     } 
/*     */ 
/*     */     
/* 185 */     updateLevelExperienceOfEveryTower();
/*     */   }
/*     */   
/*     */   public final void updateLevelExperienceOfEveryTower() {
/* 189 */     DelayedRemovalArray<Tower> delayedRemovalArray = this.S.tower.towers;
/* 190 */     for (byte b = 0; b < delayedRemovalArray.size; b++) {
/* 191 */       updateLevelExperience(((Tower[])delayedRemovalArray.items)[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 202 */     return "Experience";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\ExperienceSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */