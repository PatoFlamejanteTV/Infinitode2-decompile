/*    */ package com.prineside.tdi2.utils.simulation.providers;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.scene2d.Actor;
/*    */ import com.prineside.tdi2.scene2d.ui.Table;
/*    */ import com.prineside.tdi2.screens.SimulationScreen;
/*    */ import com.prineside.tdi2.ui.actors.Label;
/*    */ import com.prineside.tdi2.ui.actors.RectButton;
/*    */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*    */ import com.prineside.tdi2.utils.MaterialColor;
/*    */ import com.prineside.tdi2.utils.simulation.PerformanceBenchmarkSim;
/*    */ import com.prineside.tdi2.utils.simulation.SimTypeProvider;
/*    */ import com.prineside.tdi2.utils.simulation.Simulation;
/*    */ 
/*    */ public final class PerformanceBenchmarkSimProvider
/*    */   implements SimTypeProvider {
/*    */   public final String getName() {
/* 18 */     return "PerformanceBenchmark";
/*    */   }
/*    */ 
/*    */   
/*    */   public final void prepareSimForm(SimulationScreen paramSimulationScreen) {
/* 23 */     Table table = paramSimulationScreen.formTable;
/*    */     
/*    */     Label label;
/* 26 */     (label = new Label("Thread count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 27 */     table.add((Actor)label).growX().row();
/*    */     
/* 29 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("8", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/* 30 */     table.add((Actor)textFieldXPlatform2).growX().padBottom(10.0F).row();
/*    */ 
/*    */     
/* 33 */     (label = new Label("Repeat count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 34 */     table.add((Actor)label).growX().row();
/*    */     
/* 36 */     TextFieldXPlatform textFieldXPlatform3 = new TextFieldXPlatform("8", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), false));
/* 37 */     table.add((Actor)textFieldXPlatform3).growX().padBottom(10.0F).row();
/*    */ 
/*    */     
/* 40 */     (label = new Label("Total count of jobs is thread count X repeat count. Running 8 threads with 8 repeats is exactly equal to running to 16 threads with 4 repeats - adjust according to your CPU cores", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P800);
/* 41 */     label.setWrap(true);
/* 42 */     table.add((Actor)label).growX().row();
/*    */ 
/*    */     
/* 45 */     (label = new Label("Frame count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 46 */     table.add((Actor)label).growX().row();
/*    */     
/* 48 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("400000", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/* 49 */     table.add((Actor)textFieldXPlatform1).growX().padBottom(10.0F).row();
/*    */     
/* 51 */     RectButton rectButton = new RectButton("Add simulation", Game.i.assetManager.getLabelStyle(24), () -> {
/*    */           PerformanceBenchmarkSim performanceBenchmarkSim = new PerformanceBenchmarkSim(paramSimulationScreen.simConfig, Integer.parseInt(paramTextFieldXPlatform1.getText()), Integer.parseInt(paramTextFieldXPlatform2.getText()), Integer.parseInt(paramTextFieldXPlatform3.getText()));
/*    */ 
/*    */ 
/*    */           
/*    */           paramSimulationScreen.addSimulation((Simulation)performanceBenchmarkSim);
/*    */         });
/*    */ 
/*    */     
/* 60 */     table.add((Actor)rectButton).height(40.0F).growX().row();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\providers\PerformanceBenchmarkSimProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */