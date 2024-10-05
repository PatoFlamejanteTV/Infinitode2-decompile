/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.ActionType;
/*     */ import com.prineside.tdi2.enums.BlueprintType;
/*     */ import com.prineside.tdi2.enums.BossTileType;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.BuffType;
/*     */ import com.prineside.tdi2.enums.BuildingType;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.enums.DamageType;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.ExplosionType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.GateType;
/*     */ import com.prineside.tdi2.enums.GeneralizedTowerStatType;
/*     */ import com.prineside.tdi2.enums.InterpolationType;
/*     */ import com.prineside.tdi2.enums.ItemCategoryType;
/*     */ import com.prineside.tdi2.enums.ItemDataType;
/*     */ import com.prineside.tdi2.enums.ItemSortingType;
/*     */ import com.prineside.tdi2.enums.ItemSubcategoryType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.LimitedParticleType;
/*     */ import com.prineside.tdi2.enums.MinerType;
/*     */ import com.prineside.tdi2.enums.ModifierType;
/*     */ import com.prineside.tdi2.enums.PredefinedCoreTileType;
/*     */ import com.prineside.tdi2.enums.ProjectileType;
/*     */ import com.prineside.tdi2.enums.RarityType;
/*     */ import com.prineside.tdi2.enums.RequirementType;
/*     */ import com.prineside.tdi2.enums.ResearchCategoryType;
/*     */ import com.prineside.tdi2.enums.ResearchType;
/*     */ import com.prineside.tdi2.enums.ResourceType;
/*     */ import com.prineside.tdi2.enums.ShapeType;
/*     */ import com.prineside.tdi2.enums.SoundType;
/*     */ import com.prineside.tdi2.enums.SpaceTileBonusType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.enums.TileType;
/*     */ import com.prineside.tdi2.enums.TowerStatType;
/*     */ import com.prineside.tdi2.enums.TowerType;
/*     */ import com.prineside.tdi2.enums.TrophyType;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.FileWriter;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ 
/*     */ public class GameResourcesJsonGenerator
/*     */ {
/*  55 */   private static final TLog a = TLog.forClass(GameResourcesJsonGenerator.class);
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  60 */     Json json = new Json(JsonWriter.OutputType.json);
/*  61 */     StringWriter stringWriter = new StringWriter();
/*  62 */     json.setWriter(stringWriter);
/*  63 */     json.writeObjectStart();
/*     */     
/*  65 */     json.writeValue("generatedInBuild", Integer.valueOf(207));
/*     */     
/*  67 */     json.writeObjectStart("enums");
/*  68 */     a(json, (Class)AbilityType.class);
/*  69 */     a(json, (Class)AchievementType.class);
/*  70 */     a(json, (Class)ActionType.class);
/*  71 */     a(json, (Class)BlueprintType.class);
/*  72 */     a(json, (Class)BossTileType.class);
/*  73 */     a(json, (Class)BossType.class);
/*  74 */     a(json, (Class)BuffType.class);
/*  75 */     a(json, (Class)BuildingType.class);
/*  76 */     a(json, (Class)CaseType.class);
/*  77 */     a(json, (Class)DamageType.class);
/*  78 */     a(json, (Class)DifficultyMode.class);
/*  79 */     a(json, (Class)EnemyType.class);
/*  80 */     a(json, (Class)ExplosionType.class);
/*  81 */     a(json, (Class)GameValueType.class);
/*  82 */     a(json, (Class)GateType.class);
/*  83 */     a(json, (Class)GeneralizedTowerStatType.class);
/*  84 */     a(json, (Class)InterpolationType.class);
/*  85 */     a(json, (Class)ItemCategoryType.class);
/*  86 */     a(json, (Class)ItemDataType.class);
/*  87 */     a(json, (Class)ItemSortingType.class);
/*  88 */     a(json, (Class)ItemSubcategoryType.class);
/*  89 */     a(json, (Class)ItemType.class);
/*  90 */     a(json, (Class)LimitedParticleType.class);
/*  91 */     a(json, (Class)MinerType.class);
/*  92 */     a(json, (Class)ModifierType.class);
/*  93 */     a(json, (Class)PredefinedCoreTileType.class);
/*  94 */     a(json, (Class)ProjectileType.class);
/*  95 */     a(json, (Class)RarityType.class);
/*  96 */     a(json, (Class)RequirementType.class);
/*  97 */     a(json, (Class)ResearchCategoryType.class);
/*  98 */     a(json, (Class)ResearchType.class);
/*  99 */     a(json, (Class)ResourceType.class);
/* 100 */     a(json, (Class)ShapeType.class);
/* 101 */     a(json, (Class)SoundType.class);
/* 102 */     a(json, (Class)SpaceTileBonusType.class);
/* 103 */     a(json, (Class)StaticSoundType.class);
/* 104 */     a(json, (Class)StatisticsType.class);
/* 105 */     a(json, (Class)TileType.class);
/* 106 */     a(json, (Class)TowerStatType.class);
/* 107 */     a(json, (Class)TowerType.class);
/* 108 */     a(json, (Class)TrophyType.class);
/* 109 */     json.writeObjectEnd();
/*     */ 
/*     */     
/* 112 */     json.writeObjectStart("enumTitles");
/* 113 */     json.writeArrayStart(StatisticsType.class.getSimpleName()); StatisticsType[] arrayOfStatisticsType; int i; byte b;
/* 114 */     for (i = (arrayOfStatisticsType = StatisticsType.class.getEnumConstants()).length, b = 0; b < i; ) { StatisticsType statisticsType = arrayOfStatisticsType[b];
/* 115 */       json.writeValue(Game.i.statisticsManager.getStatisticsTitle(statisticsType)); b++; }
/*     */     
/* 117 */     json.writeObjectEnd();
/* 118 */     json.writeObjectEnd();
/*     */     
/* 120 */     json.writeObjectEnd();
/*     */     
/*     */     try {
/*     */       BufferedWriter bufferedWriter;
/*     */       
/* 125 */       (bufferedWriter = new BufferedWriter(new FileWriter("res/game-resources.json"))).write(json.prettyPrint(stringWriter.toString()));
/* 126 */       bufferedWriter.close();
/* 127 */     } catch (Exception exception) {
/* 128 */       a.e("failed to write resources file", new Object[] { exception });
/*     */     } 
/*     */     
/* 131 */     a.i("Done", new Object[0]);
/*     */   }
/*     */   
/*     */   private static void a(Json paramJson, Class<? extends Enum> paramClass) {
/* 135 */     paramJson.writeArrayStart(paramClass.getSimpleName()); Enum[] arrayOfEnum; int i; byte b;
/* 136 */     for (i = (arrayOfEnum = paramClass.getEnumConstants()).length, b = 0; b < i; ) { Enum enum_ = arrayOfEnum[b];
/* 137 */       paramJson.writeValue(enum_.name()); b++; }
/*     */     
/* 139 */     paramJson.writeArrayEnd();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\GameResourcesJsonGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */