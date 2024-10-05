/*    */ package com.prineside.tdi2.utils.simulation;
/*    */ 
/*    */ import com.badlogic.gdx.math.RandomXS128;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.prineside.tdi2.GameSystemProvider;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.enums.TowerType;
/*    */ import com.prineside.tdi2.gameplayMods.GameplayMod;
/*    */ import com.prineside.tdi2.systems.BonusSystem;
/*    */ import com.prineside.tdi2.tiles.PlatformTile;
/*    */ import com.prineside.tdi2.towers.GaussTower;
/*    */ import com.prineside.tdi2.utils.ObjectSupplier;
/*    */ 
/*    */ public final class BuildTowerScenario implements Scenario {
/*    */   private GameSystemProvider a;
/*    */   private final int b;
/*    */   private final TowerType c;
/*    */   private final Tower.AimStrategy d;
/*    */   private final int[] e;
/*    */   private final float f;
/*    */   private final int g;
/*    */   private final int h;
/*    */   private final RandomXS128 i;
/*    */   
/*    */   public BuildTowerScenario(int paramInt1, TowerType paramTowerType, int[] paramArrayOfint, Tower.AimStrategy paramAimStrategy, float paramFloat, int paramInt2, int paramInt3) {
/* 26 */     this.b = paramInt1;
/* 27 */     this.c = paramTowerType;
/* 28 */     this.d = paramAimStrategy;
/* 29 */     this.e = paramArrayOfint;
/* 30 */     this.f = paramFloat;
/* 31 */     this.g = paramInt2;
/* 32 */     this.h = paramInt3;
/* 33 */     this.i = new RandomXS128(paramInt3);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void start(GameSystemProvider paramGameSystemProvider) {
/* 38 */     this.a = paramGameSystemProvider;
/* 39 */     paramGameSystemProvider.wave.startNextWave();
/*    */     
/* 41 */     paramGameSystemProvider.gameState.addMoney(1000000.0F, false);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 46 */     PlatformTile platformTile = (PlatformTile)array.first(); Array array;
/*    */     Tower tower;
/* 48 */     if ((array = paramGameSystemProvider.map.getMap().getTilesByType(PlatformTile.class)).size != 0 && (tower = paramGameSystemProvider.tower.buildTower(this.c, this.d, platformTile.getX(), platformTile.getY())) != null) {
/* 49 */       if (this.c == TowerType.GAUSS) {
/* 50 */         ((GaussTower)tower).setTargetAngle(this.f);
/*    */       }
/* 52 */       tower.angle = this.f; int arrayOfInt[], i; byte b2;
/* 53 */       for (i = (arrayOfInt = this.e).length, b2 = 0; b2 < i; ) { int j = arrayOfInt[b2];
/* 54 */         paramGameSystemProvider.tower.setAbilityInstalled(tower, j, true); b2++; }
/*    */       
/* 56 */       for (byte b1 = 0; b1 < this.g; b1++) {
/* 57 */         paramGameSystemProvider.tower.upgradeTower(tower);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final void setGSP(GameSystemProvider paramGameSystemProvider) {
/* 65 */     this.a = paramGameSystemProvider;
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean isFinished() {
/* 70 */     return (this.a.gameState.updateNumber >= this.b || this.a.gameState.isGameOver());
/*    */   }
/*    */ 
/*    */   
/*    */   public final float getProgress() {
/* 75 */     return this.a.gameState.updateNumber / this.b;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void onUpdate() {
/* 84 */     int i = this.i.nextInt((bonusStage.getBonusesToChooseFrom()).size); GameplayMod gameplayMod;
/*    */     ObjectSupplier objectSupplier;
/*    */     BonusSystem.BonusStage bonusStage;
/* 87 */     if (this.a.bonus.isEnabled() && this.a.bonus.bonusSelectionAvailable() && (bonusStage = this.a.bonus.getStageToChooseBonusFor()) != null && (objectSupplier = (gameplayMod = (GameplayMod)bonusStage.getBonusesToChooseFrom().get(i)).getNotSatisfiedPreconditions(this.a)) == null) {
/* 88 */       this.a.bonus.selectBonusAction(i);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Scenario cpy() {
/* 97 */     return new BuildTowerScenario(this.b, this.c, this.e, this.d, this.f, this.g, this.h);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\BuildTowerScenario.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */