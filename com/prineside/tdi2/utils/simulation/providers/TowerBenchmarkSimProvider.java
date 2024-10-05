/*     */ package com.prineside.tdi2.utils.simulation.providers;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.Color;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.IntArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.scene2d.Actor;
/*     */ import com.prineside.tdi2.scene2d.EventListener;
/*     */ import com.prineside.tdi2.scene2d.ui.Cell;
/*     */ import com.prineside.tdi2.scene2d.ui.SelectBox;
/*     */ import com.prineside.tdi2.scene2d.ui.Table;
/*     */ import com.prineside.tdi2.scene2d.utils.ChangeListener;
/*     */ import com.prineside.tdi2.screens.SimulationScreen;
/*     */ import com.prineside.tdi2.ui.actors.Label;
/*     */ import com.prineside.tdi2.ui.actors.LabelToggleButton;
/*     */ import com.prineside.tdi2.ui.actors.RectButton;
/*     */ import com.prineside.tdi2.ui.actors.TextFieldXPlatform;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.simulation.SimTypeProvider;
/*     */ import com.prineside.tdi2.utils.simulation.Simulation;
/*     */ import com.prineside.tdi2.utils.simulation.TowerBenchmarkSim;
/*     */ import com.prineside.tdi2.utils.simulation.TowersBenchmarkScenario;
/*     */ 
/*     */ public final class TowerBenchmarkSimProvider
/*     */   implements SimTypeProvider {
/*     */   public final String getName() {
/*  28 */     return "TowerBenchmark";
/*     */   }
/*     */ 
/*     */   
/*     */   public final void prepareSimForm(SimulationScreen paramSimulationScreen) {
/*  33 */     Table table1 = paramSimulationScreen.formTable;
/*     */     
/*  35 */     Array array = new Array((Object[])new TowerBenchmarkSim.TowerBenchmarkXpConfig[] { new TowerBenchmarkSim.TowerBenchmarkXpConfig("1|NONE", 1, new int[0]), new TowerBenchmarkSim.TowerBenchmarkXpConfig("4|NONE", 4, new int[0]), new TowerBenchmarkSim.TowerBenchmarkXpConfig("4|1", 4, new int[] { 0 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("4|2", 4, new int[] { 1 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("4|3", 4, new int[] { 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("7|NONE", 7, new int[0]), new TowerBenchmarkSim.TowerBenchmarkXpConfig("7|1/2", 7, new int[] { 0, 1 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("7|1/3", 7, new int[] { 0, 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("7|2/3", 7, new int[] { 1, 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|NONE", 10, new int[0]), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|1", 10, new int[] { 0 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|2", 10, new int[] { 1 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|3", 10, new int[] { 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|1/2", 10, new int[] { 0, 1 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|1/3", 10, new int[] { 0, 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("10|2/3", 10, new int[] { 1, 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|NONE", 20, new int[0]), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1", 20, new int[] { 0 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|2", 20, new int[] { 1 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|3", 20, new int[] { 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/2", 20, new int[] { 0, 1 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/3", 20, new int[] { 0, 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|2/3", 20, new int[] { 1, 2 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|ULT", 20, new int[] { 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/ULT", 20, new int[] { 0, 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|2/ULT", 20, new int[] { 1, 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|3/ULT", 20, new int[] { 2, 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/2/ULT", 20, new int[] { 0, 1, 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/3/ULT", 20, new int[] { 0, 2, 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|2/3/ULT", 20, new int[] { 1, 2, 4 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|PWR", 20, new int[] { 5 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/PWR", 20, new int[] { 0, 5 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|2/PWR", 20, new int[] { 1, 5 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|3/PWR", 20, new int[] { 2, 5 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/2/PWR", 20, new int[] { 0, 1, 5 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|1/3/PWR", 20, new int[] { 0, 2, 5 }), new TowerBenchmarkSim.TowerBenchmarkXpConfig("20|2/3/PWR", 20, new int[] { 1, 2, 5 }) });
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
/*     */ 
/*     */     
/*  77 */     TextFieldXPlatform textFieldXPlatform1 = new TextFieldXPlatform("no-research-starting", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), false));
/*     */     
/*     */     Label label2;
/*  80 */     (label2 = new Label("Research tree mode", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  81 */     table1.add((Actor)label2).growX().row();
/*     */     
/*     */     SelectBox selectBox;
/*  84 */     (selectBox = new SelectBox(Game.i.assetManager.getSelectBoxStyle(Game.i.assetManager.getDebugFont(false), true))).setItems((Object[])TowerBenchmarkSim.ResearchTreeMode.values());
/*  85 */     selectBox.addListener((EventListener)new ChangeListener(this, selectBox, textFieldXPlatform1)
/*     */         {
/*     */           public void changed(ChangeListener.ChangeEvent param1ChangeEvent, Actor param1Actor) {
/*  88 */             switch (TowerBenchmarkSimProvider.null.a[((TowerBenchmarkSim.ResearchTreeMode)this.a.getSelected()).ordinal()]) { case 1:
/*  89 */                 this.b.setText("no-research-"); return;
/*  90 */               case 2: this.b.setText("normal-"); return;
/*  91 */               case 3: this.b.setText("endless-");
/*     */                 break; }
/*     */              }
/*     */         });
/*  95 */     table1.add((Actor)selectBox).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/*  98 */     (label2 = new Label("Benchmark name", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/*  99 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 101 */     table1.add((Actor)textFieldXPlatform1).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/* 104 */     (label2 = new Label("Thread count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 105 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 107 */     TextFieldXPlatform textFieldXPlatform2 = new TextFieldXPlatform("8", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/* 108 */     table1.add((Actor)textFieldXPlatform2).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/* 111 */     (label2 = new Label("Runs per combo", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 112 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 114 */     TextFieldXPlatform textFieldXPlatform3 = new TextFieldXPlatform("2", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), false));
/* 115 */     table1.add((Actor)textFieldXPlatform3).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/* 118 */     (label2 = new Label("If set to 2+ runs, different start timestamp will be used and results will be averaged", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P800);
/* 119 */     label2.setWrap(true);
/* 120 */     table1.add((Actor)label2).growX().row();
/*     */ 
/*     */     
/* 123 */     (label2 = new Label("Tower types", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 124 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 126 */     LabelToggleButton[] arrayOfLabelToggleButton2 = new LabelToggleButton[TowerType.values.length];
/* 127 */     for (byte b2 = 0; b2 < TowerType.values.length; b2++) {
/* 128 */       TowerType towerType = TowerType.values[b2];
/* 129 */       LabelToggleButton labelToggleButton = new LabelToggleButton(towerType.name(), (towerType != TowerType.FREEZING), 21, 24.0F, false, null);
/* 130 */       arrayOfLabelToggleButton2[b2] = labelToggleButton;
/*     */       
/* 132 */       table1.add((Actor)labelToggleButton).growX().padBottom(3.0F).row();
/*     */     } 
/*     */ 
/*     */     
/* 136 */     (label2 = new Label("Wave count", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 137 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 139 */     TextFieldXPlatform textFieldXPlatform4 = new TextFieldXPlatform("300", Game.i.assetManager.getTextFieldStyleWithFontAndVariant(Game.i.assetManager.getDebugFont(false), true));
/* 140 */     table1.add((Actor)textFieldXPlatform4).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/* 143 */     (label2 = new Label("Upgrade levels", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 144 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 146 */     Table table2 = new Table();
/* 147 */     table1.add((Actor)table2).growX().padBottom(10.0F).row();
/*     */ 
/*     */     
/* 150 */     (label2 = new Label("Extra towers", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 151 */     table1.add((Actor)label2).growX().row();
/*     */     
/* 153 */     LabelToggleButton[] arrayOfLabelToggleButton3 = new LabelToggleButton[(TowersBenchmarkScenario.ExtraTowers.values()).length];
/* 154 */     for (byte b1 = 0; b1 < (TowersBenchmarkScenario.ExtraTowers.values()).length; b1++) {
/* 155 */       TowersBenchmarkScenario.ExtraTowers extraTowers = TowersBenchmarkScenario.ExtraTowers.values()[b1];
/* 156 */       LabelToggleButton labelToggleButton = new LabelToggleButton(extraTowers.name(), true, 21, 24.0F, false, null);
/* 157 */       arrayOfLabelToggleButton3[b1] = labelToggleButton;
/*     */       
/* 159 */       table1.add((Actor)labelToggleButton).growX().padBottom(3.0F).row();
/*     */     } 
/*     */     
/*     */     Label label1;
/* 163 */     (label1 = new Label("XP level / ability configs", Game.i.assetManager.getLabelStyle(18))).setColor(MaterialColor.GREY.P500);
/* 164 */     table1.add((Actor)label1).growX().row();
/*     */     
/* 166 */     LabelToggleButton[] arrayOfLabelToggleButton1 = new LabelToggleButton[array.size];
/* 167 */     for (byte b3 = 0; b3 < array.size; b3++) {
/* 168 */       TowerBenchmarkSim.TowerBenchmarkXpConfig towerBenchmarkXpConfig = (TowerBenchmarkSim.TowerBenchmarkXpConfig)array.get(b3);
/* 169 */       LabelToggleButton labelToggleButton = new LabelToggleButton(towerBenchmarkXpConfig.name, true, 21, 24.0F, false, null);
/* 170 */       arrayOfLabelToggleButton1[b3] = labelToggleButton;
/*     */       
/* 172 */       table1.add((Actor)labelToggleButton).growX().padBottom(3.0F).row();
/*     */     } 
/*     */     
/* 175 */     int[] arrayOfInt = { 0, 1, 3, 5, 7, 10 };
/* 176 */     LabelToggleButton[] arrayOfLabelToggleButton4 = new LabelToggleButton[6];
/* 177 */     for (byte b4 = 0; b4 < 6; b4++) {
/* 178 */       int i = arrayOfInt[b4];
/* 179 */       LabelToggleButton labelToggleButton = new LabelToggleButton(i, (i == 0 || i == 5 || i == 10), 21, 24.0F, false, null);
/* 180 */       arrayOfLabelToggleButton4[b4] = labelToggleButton;
/*     */       
/* 182 */       Cell cell = table2.add((Actor)labelToggleButton).growX().padBottom(3.0F);
/* 183 */       if (b4 % 2 == 1) {
/* 184 */         cell.padLeft(20.0F);
/* 185 */         cell.row();
/*     */       } else {
/* 187 */         cell.padRight(20.0F);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     RectButton rectButton1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     (rectButton1 = new RectButton("Set defaults", Game.i.assetManager.getLabelStyle(24), () -> { paramSelectBox.setSelected(TowerBenchmarkSim.ResearchTreeMode.FULL_NORMAL); paramTextFieldXPlatform1.setText("32"); paramTextFieldXPlatform2.setText("2"); paramTextFieldXPlatform3.setText("300"); paramArrayOfLabelToggleButton1[0].setEnabled(true); paramArrayOfLabelToggleButton1[1].setEnabled(false); paramArrayOfLabelToggleButton1[2].setEnabled(false); paramArrayOfLabelToggleButton1[3].setEnabled(true); paramArrayOfLabelToggleButton1[4].setEnabled(false); paramArrayOfLabelToggleButton1[5].setEnabled(true); paramArrayOfLabelToggleButton2[TowersBenchmarkScenario.ExtraTowers.FREEZING.ordinal()].setEnabled(true); paramArrayOfLabelToggleButton2[TowersBenchmarkScenario.ExtraTowers.NONE.ordinal()].setEnabled(true); paramArrayOfLabelToggleButton2[TowersBenchmarkScenario.ExtraTowers.BLAST.ordinal()].setEnabled(false); paramArrayOfLabelToggleButton2[TowersBenchmarkScenario.ExtraTowers.FREEZING_BLAST.ordinal()].setEnabled(true); })).setBackgroundColors(MaterialColor.GREEN.P800, MaterialColor.GREEN.P900, MaterialColor.GREEN.P700, Color.GRAY);
/* 208 */     table1.add((Actor)rectButton1).height(40.0F).growX().row();
/*     */     
/* 210 */     RectButton rectButton2 = new RectButton("Add simulation", Game.i.assetManager.getLabelStyle(24), () -> {
/*     */           Array array2 = new Array(true, 1, TowerType.class);
/*     */ 
/*     */           
/*     */           for (byte b3 = 0; b3 < TowerType.values.length; b3++) {
/*     */             if (paramArrayOfLabelToggleButton1[b3].isEnabled()) {
/*     */               array2.add(TowerType.values[b3]);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/*     */           IntArray intArray2;
/*     */ 
/*     */           
/*     */           (intArray2 = new IntArray()).add(Integer.parseInt(paramTextFieldXPlatform1.getText()));
/*     */           
/*     */           IntArray intArray1 = new IntArray();
/*     */           
/*     */           for (byte b1 = 0; b1 < paramArrayOfint.length; b1++) {
/*     */             int i = paramArrayOfint[b1];
/*     */             
/*     */             if (paramArrayOfLabelToggleButton2[b1].isEnabled()) {
/*     */               intArray1.add(i);
/*     */             }
/*     */           } 
/*     */           
/*     */           Array array1 = new Array(true, 1, TowersBenchmarkScenario.ExtraTowers.class);
/*     */           
/*     */           for (byte b4 = 0; b4 < (TowersBenchmarkScenario.ExtraTowers.values()).length; b4++) {
/*     */             if (paramArrayOfLabelToggleButton3[b4].isEnabled()) {
/*     */               array1.add(TowersBenchmarkScenario.ExtraTowers.values()[b4]);
/*     */             }
/*     */           } 
/*     */           
/*     */           Array array3 = new Array(true, 1, TowerBenchmarkSim.TowerBenchmarkXpConfig.class);
/*     */           
/*     */           for (byte b2 = 0; b2 < paramArray.size; b2++) {
/*     */             if (paramArrayOfLabelToggleButton4[b2].isEnabled()) {
/*     */               array3.add(paramArray.get(b2));
/*     */             }
/*     */           } 
/*     */           
/*     */           TowerBenchmarkSim towerBenchmarkSim = new TowerBenchmarkSim(paramSimulationScreen.simConfig, paramTextFieldXPlatform2.getText(), Integer.parseInt(paramTextFieldXPlatform3.getText()), Integer.parseInt(paramTextFieldXPlatform4.getText()), (TowerBenchmarkSim.ResearchTreeMode)paramSelectBox.getSelected(), array3, intArray2, intArray1, array1, array2);
/*     */           
/*     */           paramSimulationScreen.addSimulation((Simulation)towerBenchmarkSim);
/*     */         });
/*     */     
/* 257 */     table1.add((Actor)rectButton2).height(40.0F).growX().row();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\simulation\providers\TowerBenchmarkSimProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */