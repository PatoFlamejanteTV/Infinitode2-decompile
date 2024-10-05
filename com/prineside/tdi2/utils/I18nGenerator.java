/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*     */ import com.prineside.tdi2.BasicLevelStage;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Map;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.Tower;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.BossTileType;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.ResearchCategoryType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.enums.TriggeredActionType;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.ResearchManager;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.tiles.ScriptTile;
/*     */ import com.prineside.tdi2.ui.components.GameOverOverlay;
/*     */ import com.prineside.tdi2.ui.shared.InventoryOverlay;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileWriter;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Properties;
/*     */ import java.util.Scanner;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class I18nGenerator
/*     */ {
/*  61 */   private static final TLog a = TLog.forClass(I18nGenerator.class);
/*     */   
/*  63 */   private static final String[] b = new String[] { ".java", ".lua" };
/*  64 */   private static final String[] c = new String[] { "../src", "scripts", "../../core/src", "../../desktop/src", "../../ios/src" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  75 */     Array<File> array = new Array(); String[] arrayOfString; int i; byte b1;
/*  76 */     for (i = (arrayOfString = c).length, b1 = 0; b1 < i; ) { String str = arrayOfString[b1];
/*  77 */       a(new File(str), b, array);
/*     */       
/*     */       b1++; }
/*     */     
/*  81 */     Array array1 = new Array();
/*  82 */     ObjectMap objectMap = new ObjectMap();
/*  83 */     Pattern pattern1 = Pattern.compile("i18n[()]*([.:])(get|format)\\(([^)]+)\\)((?!//).)*(//)*(.*)");
/*  84 */     Pattern pattern2 = Pattern.compile("i18n[()]*([.:])(get|format)");
/*  85 */     for (byte b2 = 0; b2 < array.size; b2++) {
/*     */       try {
/*  87 */         File file = (File)array.get(b2);
/*     */         
/*  89 */         Scanner scanner = new Scanner(file, "UTF-8");
/*  90 */         byte b = 1;
/*  91 */         while (scanner.hasNextLine()) {
/*  92 */           String str = scanner.nextLine();
/*  93 */           Matcher matcher = pattern1.matcher(str);
/*  94 */           label541: while (matcher.find()) {
/*     */             String[] arrayOfString1;
/*  96 */             Matcher matcher1 = pattern2.matcher(str);
/*  97 */             boolean bool = false;
/*  98 */             while (matcher1.find()) {
/*  99 */               if (bool) {
/* 100 */                 a.w(file.getPath() + ":" + b + " - multiple i18n calls", new Object[0]);
/*     */                 break label541;
/*     */               } 
/* 103 */               bool = true;
/*     */             } 
/*     */             
/* 106 */             String str1 = matcher.group(2).trim();
/* 107 */             String str2 = matcher.group(3).trim();
/* 108 */             String str3 = matcher.group(6).trim();
/*     */             
/* 110 */             if (str2.contains("(")) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 115 */               if ((arrayOfString1 = str2.split(","))[0].startsWith("\"") && arrayOfString1[0].endsWith("\"") && a(arrayOfString1[0], "\"") == 2) {
/*     */                 
/* 117 */                 array1.add(arrayOfString1[0].substring(1, arrayOfString1[0].length() - 1)); continue;
/*     */               } 
/* 119 */               a.w(file.getPath() + ":" + b + " - do not use '(' inside i18n.get() or i18n.format() to properly generate i18n lists", new Object[0]);
/*     */               
/*     */               continue;
/*     */             } 
/* 123 */             if (str2.startsWith("\"") && str2.endsWith("\"") && a(str2, "\"") == 2) {
/*     */               
/* 125 */               array1.add(str2.substring(1, str2.length() - 1));
/*     */               
/*     */               continue;
/*     */             } 
/* 129 */             if (str3.length() == 0) {
/* 130 */               if (arrayOfString1.equals("format")) {
/*     */                 
/* 132 */                 if ((arrayOfString1 = str2.split(","))[0].startsWith("\"") && arrayOfString1[0].endsWith("\"") && a(arrayOfString1[0], "\"") == 2) {
/*     */                   
/* 134 */                   array1.add(arrayOfString1[0].substring(1, arrayOfString1[0].length() - 1)); continue;
/*     */                 } 
/* 136 */                 a.i(file.getPath() + ":" + b + " - skipping format TODO", new Object[0]);
/*     */                 continue;
/*     */               } 
/* 139 */               a.w(file.getPath() + ":" + b + " - no comment found for runtime generated alias", new Object[0]);
/*     */               continue;
/*     */             } 
/* 142 */             if (!str3.equals("_ignored")) {
/* 143 */               if (objectMap.containsKey(str3)) {
/* 144 */                 a.i(file.getPath() + ":" + b + " - warning: comment already used in " + (String)objectMap.get(str3), new Object[0]); continue;
/*     */               } 
/* 146 */               objectMap.put(str3, file.getPath() + ":" + b);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 153 */           b++;
/*     */         } 
/* 155 */         scanner.close();
/* 156 */       } catch (FileNotFoundException fileNotFoundException2) {
/* 157 */         FileNotFoundException fileNotFoundException1; (fileNotFoundException1 = null).printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 162 */     Array array2 = new Array();
/*     */ 
/*     */     
/* 165 */     if (objectMap.remove("ability_name_ + AbilityType") != null) {
/*     */       AbilityType[] arrayOfAbilityType; int j; byte b;
/* 167 */       for (j = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < j; ) { AbilityType abilityType = arrayOfAbilityType[b];
/* 168 */         array2.add("ability_name_" + abilityType.name()); b++; }
/*     */     
/*     */     } 
/* 171 */     if (objectMap.remove("ability_name_fancy_ + AbilityType") != null) {
/*     */       AbilityType[] arrayOfAbilityType; int j; byte b;
/* 173 */       for (j = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < j; ) { AbilityType abilityType = arrayOfAbilityType[b];
/* 174 */         array2.add("ability_name_fancy_" + abilityType.name()); b++; }
/*     */     
/*     */     } 
/* 177 */     if (objectMap.remove("ability_description_ + AbilityType") != null) {
/* 178 */       AbilityType[] arrayOfAbilityType; int j; byte b; for (j = (arrayOfAbilityType = AbilityType.values).length, b = 0; b < j; ) { AbilityType abilityType = arrayOfAbilityType[b];
/* 179 */         array2.add("ability_description_" + abilityType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 184 */     if (objectMap.remove("achievement_name_ + AchievementType") != null) {
/* 185 */       AchievementType[] arrayOfAchievementType; int j; byte b; for (j = (arrayOfAchievementType = AchievementType.values).length, b = 0; b < j; ) { AchievementType achievementType = arrayOfAchievementType[b];
/* 186 */         array2.add("achievement_name_" + achievementType.name()); b++; }
/*     */     
/*     */     } 
/* 189 */     if (objectMap.remove("achievement_description_ + AchievementType") != null) {
/* 190 */       AchievementType[] arrayOfAchievementType; int j; byte b; for (j = (arrayOfAchievementType = AchievementType.values).length, b = 0; b < j; ) { AchievementType achievementType = arrayOfAchievementType[b];
/* 191 */         array2.add("achievement_description_" + achievementType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 196 */     if (objectMap.remove("aim_strategy_ + Tower.AimStrategy") != null) {
/*     */       Tower.AimStrategy[] arrayOfAimStrategy; int j; byte b;
/* 198 */       for (j = (arrayOfAimStrategy = Tower.AimStrategy.values).length, b = 0; b < j; ) { Tower.AimStrategy aimStrategy = arrayOfAimStrategy[b];
/* 199 */         array2.add("aim_strategy_" + aimStrategy.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 204 */     if (objectMap.remove("boss_tile_name_ + BossTileType") != null) {
/*     */       BossTileType[] arrayOfBossTileType; int j; byte b;
/* 206 */       for (j = (arrayOfBossTileType = BossTileType.values).length, b = 0; b < j; ) { BossTileType bossTileType = arrayOfBossTileType[b];
/* 207 */         array2.add("boss_tile_name_" + bossTileType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 212 */     if (objectMap.remove("case_key_title_ + CaseType") != null) {
/*     */       CaseType[] arrayOfCaseType; int j; byte b;
/* 214 */       for (j = (arrayOfCaseType = CaseType.values).length, b = 0; b < j; ) { CaseType caseType = arrayOfCaseType[b];
/* 215 */         array2.add("case_key_title_" + caseType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 220 */     if (objectMap.remove("continue_game_status_ + GameStateSystem.ContinueGameStatus") != null) {
/*     */       GameStateSystem.ContinueGameStatus[] arrayOfContinueGameStatus; int j; byte b;
/* 222 */       for (j = (arrayOfContinueGameStatus = GameStateSystem.ContinueGameStatus.values).length, b = 0; b < j; ) { GameStateSystem.ContinueGameStatus continueGameStatus = arrayOfContinueGameStatus[b];
/* 223 */         array2.add("continue_game_status_" + continueGameStatus.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 228 */     if (objectMap.remove("difficulty_mode_ + DifficultyMode") != null) {
/*     */       DifficultyMode[] arrayOfDifficultyMode; int j; byte b;
/* 230 */       for (j = (arrayOfDifficultyMode = DifficultyMode.values).length, b = 0; b < j; ) { DifficultyMode difficultyMode = arrayOfDifficultyMode[b];
/* 231 */         array2.add("difficulty_mode_" + difficultyMode.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 236 */     if (objectMap.remove("enemy_name_ + EnemyType") != null) {
/*     */       EnemyType[] arrayOfEnemyType; int j; byte b;
/* 238 */       for (j = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < j; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 239 */         array2.add("enemy_name_" + enemyType.name()); b++; }
/*     */     
/*     */     } 
/* 242 */     if (objectMap.remove("enemy_description_ + EnemyType") != null) {
/* 243 */       EnemyType[] arrayOfEnemyType; int j; byte b; for (j = (arrayOfEnemyType = EnemyType.values).length, b = 0; b < j; ) { EnemyType enemyType = arrayOfEnemyType[b];
/* 244 */         array2.add("enemy_description_" + enemyType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 249 */     if (objectMap.remove("gv_title_ + GameValueType") != null) {
/*     */       GameValueType[] arrayOfGameValueType; int j; byte b;
/* 251 */       for (j = (arrayOfGameValueType = GameValueType.values).length, b = 0; b < j; ) { GameValueType gameValueType = arrayOfGameValueType[b];
/* 252 */         array2.add("gv_title_" + gameValueType.name()); b++; }
/*     */     
/*     */     } 
/* 255 */     if (objectMap.remove("gv_title_disabled_ + GameValueType") != null) {
/*     */       GameValueType[] arrayOfGameValueType; int j; byte b;
/* 257 */       for (j = (arrayOfGameValueType = GameValueType.values).length, b = 0; b < j; ) { GameValueType gameValueType = arrayOfGameValueType[b];
/*     */         GameValueManager.GameValueStockConfig gameValueStockConfig;
/* 259 */         if ((gameValueStockConfig = Game.i.gameValueManager.getStockValueConfig(gameValueType)).units == GameValueManager.ValueUnits.BOOLEAN) {
/* 260 */           array2.add("gv_title_disabled_" + gameValueType.name());
/*     */         }
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 266 */     if (objectMap.remove("game_over_reason_ + GameOverReason") != null) {
/*     */       GameStateSystem.GameOverReason[] arrayOfGameOverReason; int j; byte b;
/* 268 */       for (j = (arrayOfGameOverReason = GameStateSystem.GameOverReason.values()).length, b = 0; b < j; ) { GameStateSystem.GameOverReason gameOverReason = arrayOfGameOverReason[b];
/* 269 */         array2.add("game_over_reason_" + gameOverReason.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 274 */     if (objectMap.remove("gate_name_ + GateType") != null) {
/*     */       GateType[] arrayOfGateType; int j; byte b;
/* 276 */       for (j = (arrayOfGateType = GateType.values).length, b = 0; b < j; ) { GateType gateType = arrayOfGateType[b];
/* 277 */         array2.add("gate_name_" + gateType.name()); b++; }
/*     */     
/*     */     } 
/* 280 */     if (objectMap.remove("gate_description_ + GateType") != null) {
/* 281 */       GateType[] arrayOfGateType; int j; byte b; for (j = (arrayOfGateType = GateType.values).length, b = 0; b < j; ) { GateType gateType = arrayOfGateType[b];
/* 282 */         array2.add("gate_description_" + gateType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 287 */     if (objectMap.remove("hotkey_ + HotkeyAction") != null) {
/*     */       SettingsManager.HotkeyAction[] arrayOfHotkeyAction; int j; byte b;
/* 289 */       for (j = (arrayOfHotkeyAction = SettingsManager.HotkeyAction.values).length, b = 0; b < j; ) { SettingsManager.HotkeyAction hotkeyAction = arrayOfHotkeyAction[b];
/* 290 */         array2.add("hotkey_" + hotkeyAction.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 295 */     if (objectMap.remove("invalid_map_format_hint_ + Reason") != null) {
/*     */       Map.InvalidMapException.Reason[] arrayOfReason; int j; byte b;
/* 297 */       for (j = (arrayOfReason = Map.InvalidMapException.Reason.values()).length, b = 0; b < j; ) { Map.InvalidMapException.Reason reason = arrayOfReason[b];
/* 298 */         array2.add("invalid_map_format_hint_" + reason.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 303 */     if (objectMap.remove("item_title_CASE_ + CaseType") != null) {
/*     */       CaseType[] arrayOfCaseType; int j; byte b;
/* 305 */       for (j = (arrayOfCaseType = CaseType.values).length, b = 0; b < j; ) { CaseType caseType = arrayOfCaseType[b];
/* 306 */         array2.add("item_title_CASE_" + caseType.name()); b++; }
/*     */     
/*     */     } 
/* 309 */     if (objectMap.remove("item_description_CASE_ + CaseType") != null) {
/* 310 */       CaseType[] arrayOfCaseType; int j; byte b; for (j = (arrayOfCaseType = CaseType.values).length, b = 0; b < j; ) { CaseType caseType = arrayOfCaseType[b];
/* 311 */         array2.add("item_description_CASE_" + caseType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 316 */     if (objectMap.remove("item_category_ + ItemCategoryType") != null) {
/*     */       ItemCategoryType[] arrayOfItemCategoryType; int j; byte b;
/* 318 */       for (j = (arrayOfItemCategoryType = ItemCategoryType.values()).length, b = 0; b < j; ) { ItemCategoryType itemCategoryType = arrayOfItemCategoryType[b];
/* 319 */         array2.add("item_category_" + itemCategoryType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 324 */     if (objectMap.remove("item_subcategory_ + ItemSubcategoryType") != null) {
/*     */       ItemSubcategoryType[] arrayOfItemSubcategoryType; int j; byte b;
/* 326 */       for (j = (arrayOfItemSubcategoryType = ItemSubcategoryType.values()).length, b = 0; b < j; ) { ItemSubcategoryType itemSubcategoryType = arrayOfItemSubcategoryType[b];
/* 327 */         array2.add("item_subcategory_" + itemSubcategoryType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 332 */     if (objectMap.remove("inventory_tab_name_ + TabType") != null) {
/*     */       InventoryOverlay.TabType[] arrayOfTabType; int j; byte b;
/* 334 */       for (j = (arrayOfTabType = InventoryOverlay.TabType.values()).length, b = 0; b < j; ) { InventoryOverlay.TabType tabType = arrayOfTabType[b];
/* 335 */         array2.add("inventory_tab_name_" + tabType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 340 */     if (objectMap.remove("levels.json stage titles") != null)
/*     */     {
/* 342 */       for (Array.ArrayIterator<BasicLevelStage> arrayIterator1 = Game.i.basicLevelManager.stagesOrdered.iterator(); arrayIterator1.hasNext(); ) { BasicLevelStage basicLevelStage = arrayIterator1.next();
/* 343 */         array2.add(basicLevelStage.titleAlias); }
/*     */     
/*     */     }
/*     */ 
/*     */     
/* 348 */     if (objectMap.remove("measure_units_ + units") != null) {
/*     */       StringFormatter.MeasureUnits[] arrayOfMeasureUnits; int j; byte b;
/* 350 */       for (j = (arrayOfMeasureUnits = StringFormatter.MeasureUnits.values).length, b = 0; b < j; ) { StringFormatter.MeasureUnits measureUnits = arrayOfMeasureUnits[b];
/* 351 */         array2.add("measure_units_" + measureUnits.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 356 */     if (objectMap.remove("miner_name_ + MinerType") != null) {
/*     */       MinerType[] arrayOfMinerType; int j; byte b;
/* 358 */       for (j = (arrayOfMinerType = MinerType.values).length, b = 0; b < j; ) { MinerType minerType = arrayOfMinerType[b];
/* 359 */         array2.add("miner_name_" + minerType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 364 */     if (objectMap.remove("modifier_name_ + ModifierType") != null) {
/*     */       ModifierType[] arrayOfModifierType; int j; byte b;
/* 366 */       for (j = (arrayOfModifierType = ModifierType.values).length, b = 0; b < j; ) { ModifierType modifierType = arrayOfModifierType[b];
/* 367 */         array2.add("modifier_name_" + modifierType.name()); b++; }
/*     */     
/*     */     } 
/* 370 */     if (objectMap.remove("modifier_name_fancy_ + ModifierType") != null) {
/*     */       ModifierType[] arrayOfModifierType; int j; byte b;
/* 372 */       for (j = (arrayOfModifierType = ModifierType.values).length, b = 0; b < j; ) { ModifierType modifierType = arrayOfModifierType[b];
/* 373 */         array2.add("modifier_name_fancy_" + modifierType.name());
/*     */         b++; }
/*     */     
/*     */     } 
/* 377 */     if (objectMap.remove("modifier_description_ + ModifierType") != null) {
/* 378 */       ModifierType[] arrayOfModifierType; int j; byte b; for (j = (arrayOfModifierType = ModifierType.values).length, b = 0; b < j; ) { ModifierType modifierType = arrayOfModifierType[b];
/* 379 */         array2.add("modifier_description_" + modifierType.name());
/*     */         b++; }
/*     */     
/*     */     } 
/* 383 */     if (objectMap.remove("modifier_simple_description_ + ModifierType") != null) {
/* 384 */       ModifierType[] arrayOfModifierType; int j; byte b; for (j = (arrayOfModifierType = ModifierType.values).length, b = 0; b < j; ) { ModifierType modifierType = arrayOfModifierType[b];
/* 385 */         array2.add("modifier_simple_description_" + modifierType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 390 */     if (objectMap.remove("rarity_ + RarityType") != null) {
/*     */       RarityType[] arrayOfRarityType; int j; byte b;
/* 392 */       for (j = (arrayOfRarityType = RarityType.values).length, b = 0; b < j; ) { RarityType rarityType = arrayOfRarityType[b];
/* 393 */         array2.add("rarity_" + rarityType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 398 */     if (objectMap.remove("research_title_ + ResearchCategoryType") != null) {
/*     */       ResearchCategoryType[] arrayOfResearchCategoryType; int j; byte b;
/* 400 */       for (j = (arrayOfResearchCategoryType = ResearchCategoryType.values).length, b = 0; b < j; ) { ResearchCategoryType researchCategoryType = arrayOfResearchCategoryType[b];
/* 401 */         array2.add("research_title_" + researchCategoryType.name()); b++; }
/*     */     
/*     */     } 
/* 404 */     if (objectMap.remove("research_description_ + ResearchCategoryType") != null) {
/* 405 */       ResearchCategoryType[] arrayOfResearchCategoryType; int j; byte b; for (j = (arrayOfResearchCategoryType = ResearchCategoryType.values).length, b = 0; b < j; ) { ResearchCategoryType researchCategoryType = arrayOfResearchCategoryType[b];
/* 406 */         array2.add("research_description_" + researchCategoryType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 411 */     if (objectMap.remove("resource_name_ + ResourceType") != null) {
/*     */       ResourceType[] arrayOfResourceType; int j; byte b;
/* 413 */       for (j = (arrayOfResourceType = ResourceType.values).length, b = 0; b < j; ) { ResourceType resourceType = arrayOfResourceType[b];
/* 414 */         array2.add("resource_name_" + resourceType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 419 */     if (objectMap.remove("levels.json SCRIPTED quests") != null)
/*     */     {
/* 421 */       for (Array.ArrayIterator<BasicLevel> arrayIterator1 = Game.i.basicLevelManager.levelsOrdered.iterator(); arrayIterator1.hasNext();) {
/* 422 */         for (Array.ArrayIterator<BasicLevelQuestConfig> arrayIterator2 = (basicLevel = arrayIterator1.next()).quests.iterator(); arrayIterator2.hasNext();) {
/* 423 */           if ((basicLevelQuestConfig = arrayIterator2.next()).isScripted()) {
/* 424 */             array2.add(basicLevelQuestConfig.scriptedTitle);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 431 */     if (objectMap.remove("space_tile_bonus_ + SpaceTileBonusType") != null) {
/*     */       SpaceTileBonusType[] arrayOfSpaceTileBonusType; int j; byte b;
/* 433 */       for (j = (arrayOfSpaceTileBonusType = SpaceTileBonusType.values).length, b = 0; b < j; ) { SpaceTileBonusType spaceTileBonusType = arrayOfSpaceTileBonusType[b];
/* 434 */         array2.add("space_tile_bonus_" + spaceTileBonusType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 439 */     if (objectMap.remove("statistics_ + StatisticsType") != null) {
/*     */       StatisticsType[] arrayOfStatisticsType; int j; byte b;
/* 441 */       for (j = (arrayOfStatisticsType = StatisticsType.values).length, b = 0; b < j; ) { StatisticsType statisticsType = arrayOfStatisticsType[b];
/* 442 */         array2.add("statistics_" + statisticsType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 447 */     if (objectMap.remove("start_research_fail_reason_ + StartResearchFailReason") != null) {
/*     */       ResearchManager.StartResearchFailReason[] arrayOfStartResearchFailReason; int j; byte b;
/* 449 */       for (j = (arrayOfStartResearchFailReason = ResearchManager.StartResearchFailReason.values).length, b = 0; b < j; ) { ResearchManager.StartResearchFailReason startResearchFailReason = arrayOfStartResearchFailReason[b];
/* 450 */         array2.add("start_research_fail_reason_" + startResearchFailReason.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/*     */     
/* 456 */     if (objectMap.remove("tower_name_ + TowerType") != null) {
/*     */       TowerType[] arrayOfTowerType; int j; byte b;
/* 458 */       for (j = (arrayOfTowerType = TowerType.values).length, b = 0; b < j; ) { TowerType towerType = arrayOfTowerType[b];
/* 459 */         array2.add("tower_name_" + towerType.name()); b++; }
/*     */     
/*     */     } 
/* 462 */     if (objectMap.remove("tower_description_ + TowerType") != null) {
/* 463 */       TowerType[] arrayOfTowerType; int j; byte b; for (j = (arrayOfTowerType = TowerType.values).length, b = 0; b < j; ) { TowerType towerType = arrayOfTowerType[b];
/* 464 */         array2.add("tower_description_" + towerType.name()); b++; }
/*     */     
/*     */     } 
/* 467 */     if (objectMap.remove("tower_ability_TOWER_ABILITY_name") != null) {
/* 468 */       objectMap.remove("tower_ability_TOWER_ABILITY_description"); TowerType[] arrayOfTowerType; int j;
/*     */       byte b;
/* 470 */       for (j = (arrayOfTowerType = TowerType.values).length, b = 0; b < j; ) { TowerType towerType = arrayOfTowerType[b]; String[] arrayOfString1, arrayOfString2; int k;
/*     */         byte b4;
/* 472 */         for (k = (arrayOfString2 = arrayOfString1 = Game.i.towerManager.getFactory(towerType).getAbilityAliases()).length, b4 = 0; b4 < k; ) { String str = arrayOfString2[b4];
/* 473 */           array2.add("tower_ability_" + towerType.name() + "_" + str + "_name");
/* 474 */           array2.add("tower_ability_" + towerType.name() + "_" + str + "_description"); b4++; }
/*     */          b++; }
/*     */     
/*     */     } 
/* 478 */     if (objectMap.remove("tower_unique_stat_description_ + TowerType") != null) {
/* 479 */       TowerType[] arrayOfTowerType; int j; byte b; for (j = (arrayOfTowerType = TowerType.values).length, b = 0; b < j; ) { TowerType towerType = arrayOfTowerType[b];
/* 480 */         array2.add("tower_unique_stat_description_" + towerType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 485 */     if (objectMap.remove("tower_stat_ + TowerStatType") != null) {
/*     */       TowerStatType[] arrayOfTowerStatType; int j; byte b;
/* 487 */       for (j = (arrayOfTowerStatType = TowerStatType.values).length, b = 0; b < j; ) { TowerStatType towerStatType = arrayOfTowerStatType[b];
/* 488 */         array2.add("tower_stat_" + towerStatType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 493 */     if (objectMap.remove("tr_title_ + TrophyType") != null) {
/*     */       TrophyType[] arrayOfTrophyType; int j; byte b;
/* 495 */       for (j = (arrayOfTrophyType = TrophyType.values).length, b = 0; b < j; ) { TrophyType trophyType = arrayOfTrophyType[b];
/* 496 */         array2.add("tr_title_" + trophyType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 501 */     if (objectMap.remove("triggered_action_ + TriggeredActionType") != null) {
/*     */       TriggeredActionType[] arrayOfTriggeredActionType; int j; byte b;
/* 503 */       for (j = (arrayOfTriggeredActionType = TriggeredActionType.values).length, b = 0; b < j; ) { TriggeredActionType triggeredActionType = arrayOfTriggeredActionType[b];
/* 504 */         array2.add("triggered_action_" + triggeredActionType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 509 */     if (objectMap.remove("tile_name_ + TileType") != null) {
/*     */       TileType[] arrayOfTileType; int j; byte b;
/* 511 */       for (j = (arrayOfTileType = TileType.values).length, b = 0; b < j; ) { TileType tileType = arrayOfTileType[b];
/* 512 */         array2.add("tile_name_" + tileType.name()); b++; }
/*     */     
/*     */     } 
/* 515 */     if (objectMap.remove("tile_description_ + TileType") != null) {
/* 516 */       TileType[] arrayOfTileType; int j; byte b; for (j = (arrayOfTileType = TileType.values).length, b = 0; b < j; ) { TileType tileType = arrayOfTileType[b];
/* 517 */         array2.add("tile_description_" + tileType.name());
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 522 */     if (objectMap.remove("game_over_hints") != null) {
/* 523 */       String[] arrayOfString1; int j; byte b; for (j = (arrayOfString1 = GameOverOverlay.HINT_ALIASES).length, b = 0; b < j; ) { String str = arrayOfString1[b];
/* 524 */         array2.add(str);
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/* 529 */     Pattern pattern3 = Pattern.compile("I18nGenerator[\\s]*\\{([^\\}]+)");
/* 530 */     for (Array.ArrayIterator<BasicLevel> arrayIterator = Game.i.basicLevelManager.levelsOrdered.iterator(); arrayIterator.hasNext();) {
/* 531 */       for (Array.ArrayIterator<Tile> arrayIterator1 = (basicLevel = arrayIterator.next()).getMap().getAllTiles().iterator(); arrayIterator1.hasNext();) {
/* 532 */         if ((tile = arrayIterator1.next()).type == TileType.SCRIPT && (
/*     */ 
/*     */           
/* 535 */           str = (scriptTile = (ScriptTile)tile).getScript()) != null) {
/*     */           Matcher matcher;
/*     */           
/* 538 */           if ((matcher = pattern3.matcher(str)).find()) {
/*     */             byte b; int j; String[] arrayOfString1; String[] arrayOfString2;
/* 540 */             for (j = (arrayOfString2 = arrayOfString1 = matcher.group(1).replaceAll("\"", "").split(",")).length, b = 0; b < j; b++) {
/*     */               String str1;
/* 542 */               if ((str1 = (str1 = arrayOfString2[b]).trim()).length() > 0)
/* 543 */                 array2.add(str1); 
/*     */             } 
/*     */             continue;
/*     */           } 
/* 547 */           a.i("nothing found in " + basicLevel.name, new Object[0]);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 555 */     for (ObjectMap.Keys<String> keys = objectMap.keys().iterator(); keys.hasNext(); ) { String str = keys.next();
/* 556 */       a.w("runtime generated alias not implemented in I18nGenerator: " + str + " (" + (String)objectMap.get(str) + ")", new Object[0]); }
/*     */ 
/*     */ 
/*     */     
/* 560 */     Array array3 = new Array();
/* 561 */     ObjectSet objectSet = new ObjectSet(); byte b3;
/* 562 */     for (b3 = 0; b3 < array2.size; b3++) {
/* 563 */       objectSet.add(array2.get(b3));
/*     */     }
/* 565 */     for (b3 = 0; b3 < array1.size; b3++) {
/* 566 */       String str = (String)array1.get(b3);
/* 567 */       if (!objectSet.contains(str)) {
/* 568 */         objectSet.add(str);
/* 569 */         array3.add(str);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 574 */     array3.sort();
/*     */     
/*     */     Array array4;
/*     */     
/* 578 */     (array4 = new Array()).addAll(array3);
/* 579 */     array4.addAll(array2);
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
/*     */     try {
/* 598 */       ObjectMap objectMap2 = new ObjectMap();
/* 599 */       for (byte b5 = 0; b5 < array4.size; b5++) {
/* 600 */         objectMap2.put(array4.get(b5), "");
/*     */       }
/*     */       
/* 603 */       DelayedRemovalArray delayedRemovalArray1 = new DelayedRemovalArray();
/* 604 */       DelayedRemovalArray delayedRemovalArray2 = new DelayedRemovalArray();
/* 605 */       File file = new File("i18n/MainBundle.properties");
/* 606 */       FileInputStream fileInputStream = new FileInputStream(file);
/*     */       Properties properties;
/* 608 */       (properties = new Properties()).load(fileInputStream);
/* 609 */       fileInputStream.close();
/*     */       
/* 611 */       Pattern pattern = Pattern.compile("\\[@([a-zA-Z0-9_-]+)]");
/*     */       
/* 613 */       ObjectMap objectMap1 = new ObjectMap();
/* 614 */       Enumeration<Object> enumeration = properties.keys();
/* 615 */       while (enumeration.hasMoreElements()) {
/*     */         
/* 617 */         String str1 = (String)enumeration.nextElement();
/*     */         
/*     */         String str2;
/* 620 */         if ((str2 = (str2 = properties.getProperty(str1)).replace("\n", "\\n")).length() != 0) {
/* 621 */           objectMap1.put(str1, str2);
/*     */ 
/*     */           
/* 624 */           Matcher matcher = pattern.matcher(str2);
/* 625 */           while (matcher.find()) {
/*     */             
/* 627 */             String str = matcher.group(1).trim();
/* 628 */             if (!delayedRemovalArray2.contains(str, false)) delayedRemovalArray2.add(str);
/*     */           
/*     */           } 
/* 631 */           if (!objectMap2.containsKey(str1)) {
/*     */             
/* 633 */             delayedRemovalArray1.add(str1);
/*     */             continue;
/*     */           } 
/* 636 */           objectMap2.put(str1, str2);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*     */       BufferedWriter bufferedWriter;
/*     */       
/* 643 */       (bufferedWriter = new BufferedWriter(new FileWriter("i18n/MainBundle.properties"))).write("#B207\n"); byte b4;
/* 644 */       for (b4 = 0; b4 < array4.size; b4++) {
/* 645 */         String str = (String)array4.get(b4);
/* 646 */         bufferedWriter.write(str);
/* 647 */         if (!str.startsWith("#")) {
/* 648 */           bufferedWriter.write("=");
/* 649 */           String str1 = (String)objectMap2.get(str);
/* 650 */           bufferedWriter.write(str1);
/*     */         } 
/* 652 */         bufferedWriter.write("\n");
/*     */       } 
/*     */ 
/*     */       
/* 656 */       delayedRemovalArray1.begin();
/* 657 */       for (b4 = 0; b4 < delayedRemovalArray1.size; b4++) {
/* 658 */         for (byte b = 0; b < delayedRemovalArray2.size; b++) {
/* 659 */           if (((String)delayedRemovalArray2.get(b)).equals(delayedRemovalArray1.get(b4))) {
/* 660 */             delayedRemovalArray1.removeIndex(b4);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 665 */       delayedRemovalArray1.end();
/*     */ 
/*     */       
/* 668 */       delayedRemovalArray2.begin();
/* 669 */       for (b4 = 0; b4 < delayedRemovalArray2.size; b4++) {
/* 670 */         if (objectMap2.containsKey(delayedRemovalArray2.get(b4))) {
/* 671 */           delayedRemovalArray2.removeIndex(b4);
/*     */         }
/*     */       } 
/* 674 */       delayedRemovalArray2.end();
/*     */ 
/*     */       
/* 677 */       if (delayedRemovalArray2.size != 0) {
/*     */         
/* 679 */         delayedRemovalArray2.sort();
/* 680 */         for (b4 = 0; b4 < delayedRemovalArray2.size; b4++) {
/* 681 */           bufferedWriter.write((String)delayedRemovalArray2.get(b4));
/* 682 */           bufferedWriter.write("=");
/* 683 */           if (objectMap1.containsKey(delayedRemovalArray2.get(b4))) bufferedWriter.write((String)objectMap1.get(delayedRemovalArray2.get(b4))); 
/* 684 */           bufferedWriter.write("\n");
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 689 */       if (delayedRemovalArray1.size != 0) {
/* 690 */         bufferedWriter.write("#\n");
/* 691 */         bufferedWriter.write("# Obsolete ----\n");
/* 692 */         bufferedWriter.write("#\n");
/* 693 */         delayedRemovalArray1.sort(String::compareTo);
/* 694 */         for (b4 = 0; b4 < delayedRemovalArray1.size; b4++) {
/* 695 */           bufferedWriter.write((String)delayedRemovalArray1.get(b4));
/* 696 */           bufferedWriter.write("=");
/* 697 */           if (objectMap1.containsKey(delayedRemovalArray1.get(b4))) bufferedWriter.write((String)objectMap1.get(delayedRemovalArray1.get(b4))); 
/* 698 */           bufferedWriter.write("\n");
/*     */         } 
/*     */       } 
/*     */       
/* 702 */       bufferedWriter.close();
/* 703 */     } catch (Exception exception) {
/* 704 */       a.e("Failed to handle MainBundle.properties", new Object[] { exception });
/*     */     } 
/*     */     
/* 707 */     a.i("Done", new Object[0]);
/*     */   }
/*     */   
/*     */   private static int a(String paramString1, String paramString2) {
/* 711 */     return paramString1.length() - paramString1.replace(paramString2, "").length();
/*     */   }
/*     */   
/*     */   private void a(File paramFile, String[] paramArrayOfString, Array<File> paramArray) {
/* 715 */     if (paramFile.isDirectory()) {
/*     */       File[] arrayOfFile;
/* 717 */       if ((arrayOfFile = paramFile.listFiles()) != null) {
/* 718 */         File[] arrayOfFile1; int i; byte b; for (i = (arrayOfFile1 = arrayOfFile).length, b = 0; b < i; ) { File file = arrayOfFile1[b];
/* 719 */           a(file, paramArrayOfString, paramArray); b++; }
/*     */       
/*     */       }  return;
/* 722 */     }  if (paramFile.isFile()) {
/* 723 */       boolean bool = false; String[] arrayOfString; int i; byte b;
/* 724 */       for (i = (arrayOfString = paramArrayOfString).length, b = 0; b < i; ) { String str = arrayOfString[b];
/* 725 */         if (paramFile.getName().endsWith(str)) {
/* 726 */           bool = true;
/*     */           break;
/*     */         } 
/*     */         b++; }
/*     */       
/* 731 */       if (bool) paramArray.add(paramFile);  return;
/*     */     } 
/* 733 */     a.e("unable to search in '" + paramFile.getName() + "', it's not a file or dir", new Object[0]);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\I18nGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */