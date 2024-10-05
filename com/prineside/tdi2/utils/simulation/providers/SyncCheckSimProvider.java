/*     */ package com.prineside.tdi2.utils.simulation.providers;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.screens.SimulationScreen;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.utils.FastRandom;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.simulation.BuildTowerScenario;
/*     */ import com.prineside.tdi2.utils.simulation.JustUpdateScenario;
/*     */ import com.prineside.tdi2.utils.simulation.Scenario;
/*     */ import com.prineside.tdi2.utils.simulation.SimTypeProvider;
/*     */ import com.prineside.tdi2.utils.simulation.Simulation;
/*     */ import com.prineside.tdi2.utils.simulation.SyncCheckSim;
/*     */ 
/*     */ public final class SyncCheckSimProvider
/*     */   implements SimTypeProvider {
/*     */   public final String getName() {
/*  27 */     return "SyncCheck";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void prepareSimForm(SimulationScreen paramSimulationScreen) {
/*  32 */     Table table = paramSimulationScreen.formTable;
/*     */     
/*     */     Label label;
/*  35 */     (label = new Label("Syn check scenario", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  36 */     table.add((Actor)label).growX().row();
/*     */     
/*     */     SelectBox selectBox;
/*  39 */     (selectBox = new SelectBox(Game.i.assetManager.getSelectBoxStyle(Game.i.assetManager.getDebugFont(true), true))).setItems((Object[])new String[] { "TowersAndAbilities", "JustUpdate" });
/*  40 */     table.add((Actor)selectBox).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/*  43 */     (label = new Label("Sync thread count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  44 */     table.add((Actor)label).growX().row();
/*     */     
/*  46 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("2", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), false));
/*  47 */     table.add((Actor)textFieldXPlatform2).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/*  50 */     (label = new Label("Extra load thread count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  51 */     table.add((Actor)label).growX().row();
/*     */     
/*  53 */     TextFieldXPlatform textFieldXPlatform3 = new TextFieldXPlatform("2", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/*  54 */     table.add((Actor)textFieldXPlatform3).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/*  57 */     (label = new Label("Frame count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  58 */     table.add((Actor)label).growX().row();
/*     */     
/*  60 */     TextFieldXPlatform textFieldXPlatform4 = new TextFieldXPlatform("500000", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), false));
/*  61 */     table.add((Actor)textFieldXPlatform4).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/*  64 */     (label = new Label("Sync check frame interval", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  65 */     table.add((Actor)label).growX().row();
/*     */     
/*  67 */     (label = new Label("Set to 1 for precise sync check", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P800);
/*  68 */     table.add((Actor)label).growX().row();
/*     */     
/*  70 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("500", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/*  71 */     table.add((Actor)textFieldXPlatform1).growX().padBottom(10.0F).row();
/*     */     
/*  73 */     RectButton rectButton = new RectButton("Add simulation", Game.i.assetManager.getLabelStyle(24), () -> {
/*     */           int i = Integer.parseInt(paramTextFieldXPlatform1.getText()); int j = Integer.parseInt(paramTextFieldXPlatform2.getText()); int k = Integer.parseInt(paramTextFieldXPlatform3.getText()); int m = Integer.parseInt(paramTextFieldXPlatform4.getText()); int n = FastRandom.random.nextInt();
/*     */           Array array = new Array();
/*     */           if (((String)paramSelectBox.getSelected()).equals("TowersAndAbilities")) {
/*     */             TowerType[] arrayOfTowerType;
/*     */             int i1 = (arrayOfTowerType = TowerType.values).length;
/*     */             byte b;
/*     */             for (b = 0; b < i1; b++) {
/*     */               TowerType towerType = arrayOfTowerType[b];
/*     */               array.add(new ObjectPair(towerType.name(), new BuildTowerScenario(m, towerType, new int[0], Tower.AimStrategy.RANDOM, FastRandom.getFairFloat() * 360.0F, 5, n)));
/*     */             } 
/*     */             i1 = (arrayOfTowerType = TowerType.values).length;
/*     */             for (b = 0; b < i1; b++) {
/*     */               TowerType towerType = arrayOfTowerType[b];
/*     */               array.add(new ObjectPair(towerType.name() + "(1st ability)", new BuildTowerScenario(m, towerType, new int[] { 0 }, Tower.AimStrategy.RANDOM, FastRandom.getFairFloat() * 360.0F, 5, n)));
/*     */             } 
/*     */             i1 = (arrayOfTowerType = TowerType.values).length;
/*     */             for (b = 0; b < i1; b++) {
/*     */               TowerType towerType = arrayOfTowerType[b];
/*     */               array.add(new ObjectPair(towerType.name() + "(2nd ability)", new BuildTowerScenario(m, towerType, new int[] { 1 }, Tower.AimStrategy.RANDOM, FastRandom.getFairFloat() * 360.0F, 5, n)));
/*     */             } 
/*     */             i1 = (arrayOfTowerType = TowerType.values).length;
/*     */             for (b = 0; b < i1; b++) {
/*     */               TowerType towerType = arrayOfTowerType[b];
/*     */               array.add(new ObjectPair(towerType.name() + "(3rd ability)", new BuildTowerScenario(m, towerType, new int[] { 2 }, Tower.AimStrategy.RANDOM, FastRandom.getFairFloat() * 360.0F, 5, n)));
/*     */             } 
/*     */             array.shuffle();
/*     */           } else {
/*     */             array.add(new ObjectPair("JustUpdate", new JustUpdateScenario(m)));
/*     */           } 
/*     */           SyncCheckSim syncCheckSim = new SyncCheckSim(paramSimulationScreen.simConfig, array, (Scenario)new JustUpdateScenario(500000000), i, j, k);
/*     */           paramSimulationScreen.addSimulation((Simulation)syncCheckSim);
/*     */         });
/* 106 */     table.add((Actor)rectButton).height(40.0F).growX().row();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\providers\SyncCheckSimProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */