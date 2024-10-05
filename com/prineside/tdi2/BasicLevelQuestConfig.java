/*     */ package com.prineside.tdi2;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.managers.GameValueManager;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.systems.QuestSystem;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicLevelQuestConfig
/*     */ {
/*     */   public String id;
/*     */   public boolean scripted;
/*     */   @Null
/*     */   public StatisticsType statisticsType;
/*     */   public long requiredValue;
/*     */   public BasicLevel level;
/*  28 */   public Array<ItemStack> prizes = new Array(ItemStack.class);
/*     */   
/*     */   public String scriptedTitle;
/*     */   
/*     */   public boolean duringGame;
/*     */   
/*  34 */   private static final StringBuilder a = new StringBuilder();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BasicLevelQuestConfig(String paramString, boolean paramBoolean1, @Null StatisticsType paramStatisticsType, long paramLong, boolean paramBoolean2, BasicLevel paramBasicLevel) {
/*  40 */     this.id = paramString;
/*  41 */     this.scripted = paramBoolean1;
/*  42 */     this.statisticsType = paramStatisticsType;
/*  43 */     this.requiredValue = paramLong;
/*  44 */     this.duringGame = paramBoolean2;
/*  45 */     this.level = paramBasicLevel;
/*     */   }
/*     */   
/*     */   public long getSavedValue() {
/*  49 */     return (ProgressPrefs.i()).basicLevel.getQuestSavedValue(this.id);
/*     */   }
/*     */   
/*     */   public void setSavedValue(long paramLong) {
/*     */     ProgressPrefs progressPrefs;
/*  54 */     (progressPrefs = ProgressPrefs.i()).basicLevel.setQuestSavedValue(this.id, paramLong);
/*  55 */     progressPrefs.requireSave();
/*     */   }
/*     */   
/*     */   public int getExtraDustInEndless(GameValueProvider paramGameValueProvider) {
/*  59 */     byte b1 = 0;
/*  60 */     for (byte b2 = 0; b2 < this.level.quests.size; ) {
/*  61 */       b1 = b2;
/*  62 */       if (((BasicLevelQuestConfig[])this.level.quests.items)[b2] != this) {
/*     */         b2++;
/*     */       }
/*     */     } 
/*     */     
/*  67 */     double d1 = 1.0D + b1 / (this.level.quests.size - 1);
/*  68 */     double d2 = paramGameValueProvider.getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE);
/*     */     
/*  70 */     if (this.duringGame) {
/*  71 */       return (int)(d1 * 2.0D * d2);
/*     */     }
/*  73 */     return (int)(d2 * 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void toJson(Json paramJson) {
/*  81 */     paramJson.writeValue("id", this.id);
/*  82 */     if (this.scripted) {
/*  83 */       paramJson.writeValue("scripted", Boolean.TRUE);
/*  84 */       paramJson.writeValue("title", this.scriptedTitle);
/*     */     } else {
/*  86 */       paramJson.writeValue("statisticsType", this.statisticsType.name());
/*     */     } 
/*  88 */     if (this.requiredValue != 0L) {
/*  89 */       paramJson.writeValue("value", Long.valueOf(this.requiredValue));
/*     */     }
/*  91 */     if (this.duringGame) paramJson.writeValue("oneGame", Boolean.TRUE);
/*     */     
/*  93 */     paramJson.writeArrayStart("prizes");
/*  94 */     for (byte b = 0; b < this.prizes.size; b++) {
/*  95 */       paramJson.writeObjectStart();
/*  96 */       ((ItemStack[])this.prizes.items)[b].toJson(paramJson);
/*  97 */       paramJson.writeObjectEnd();
/*     */     } 
/*  99 */     paramJson.writeArrayEnd();
/*     */   }
/*     */   
/*     */   public static BasicLevelQuestConfig fromJson(JsonValue paramJsonValue, BasicLevel paramBasicLevel) {
/* 103 */     String str = paramJsonValue.getString("id");
/* 104 */     boolean bool1 = paramJsonValue.getBoolean("scripted", false);
/* 105 */     StatisticsType statisticsType = null;
/* 106 */     if (!bool1) {
/* 107 */       statisticsType = StatisticsType.valueOf(paramJsonValue.getString("statisticsType"));
/*     */     }
/* 109 */     long l = paramJsonValue.getLong("value", 0L);
/* 110 */     boolean bool2 = paramJsonValue.getBoolean("oneGame", false);
/*     */     
/* 112 */     BasicLevelQuestConfig basicLevelQuestConfig = new BasicLevelQuestConfig(str, bool1, statisticsType, l, bool2, paramBasicLevel);
/*     */     
/* 114 */     if (bool1) {
/* 115 */       basicLevelQuestConfig.scriptedTitle = paramJsonValue.getString("title");
/*     */     }
/*     */ 
/*     */     
/* 119 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (paramJsonValue = paramJsonValue.get("prizes")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 120 */       basicLevelQuestConfig.prizes.add(ItemStack.fromJson(jsonValue)); }
/*     */ 
/*     */     
/* 123 */     return basicLevelQuestConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public QuestSystem.Quest createIngameQuest(GameSystemProvider paramGameSystemProvider) {
/* 131 */     if (this.scripted) return null;
/*     */     
/* 133 */     return (QuestSystem.Quest)new QuestSystem.BasicLevelQuest(this.level, this, paramGameSystemProvider);
/*     */   }
/*     */   
/*     */   public String getId() {
/* 137 */     return this.id;
/*     */   }
/*     */   
/*     */   public boolean isScripted() {
/* 141 */     return this.scripted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getCurrentValue(GameValueManager.GameValuesSnapshot paramGameValuesSnapshot) {
/* 148 */     if (isCompleted()) {
/* 149 */       return getRequiredValue(paramGameValuesSnapshot);
/*     */     }
/*     */     
/* 152 */     if (!this.scripted) {
/* 153 */       return getSavedValue();
/*     */     }
/* 155 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getRequiredValue(GameValueManager.GameValuesSnapshot paramGameValuesSnapshot) {
/* 160 */     if (this.level.fixedQuests) return this.requiredValue; 
/* 161 */     if (!(Game.i.basicLevelManager.getStage(this.level.stageName)).regular) return this.requiredValue;
/*     */     
/*     */     double d;
/* 164 */     if ((d = paramGameValuesSnapshot.getPercentValueAsMultiplier(GameValueType.REGULAR_QUESTS_DIFFICULTY)) <= 1.0D) return this.requiredValue;
/*     */ 
/*     */     
/*     */     long l;
/* 168 */     if ((l = (long)(d * this.requiredValue)) < 100L)
/* 169 */       return l; 
/* 170 */     if (l < 500L)
/* 171 */       return l - l % 5L; 
/* 172 */     if (l < 1000L)
/* 173 */       return l - l % 10L; 
/* 174 */     if (l < 5000L) {
/* 175 */       return l - l % 50L;
/*     */     }
/* 177 */     return l - l % 100L;
/*     */   }
/*     */ 
/*     */   
/*     */   public Array<ItemStack> getPrizes(GameValueManager.GameValuesSnapshot paramGameValuesSnapshot) {
/* 182 */     if (this.level.fixedQuests || !(Game.i.basicLevelManager.getStage(this.level.stageName)).regular) {
/* 183 */       return this.prizes;
/*     */     }
/*     */     
/*     */     double d;
/* 187 */     if ((d = paramGameValuesSnapshot.getPercentValueAsMultiplier(GameValueType.REGULAR_QUESTS_PRIZE_MULTIPLIER)) <= 1.0D) return this.prizes;
/*     */     
/* 189 */     Array<ItemStack> array = new Array(ItemStack.class);
/*     */     
/* 191 */     for (byte b = 0; b < this.prizes.size; b++) {
/*     */       ItemStack itemStack;
/* 193 */       if ((itemStack = ((ItemStack[])this.prizes.items)[b]).getItem() instanceof com.prineside.tdi2.items.StarItem || itemStack.getItem().getType() == ItemType.GAME_VALUE_LEVEL || itemStack.getItem().getType() == ItemType.GAME_VALUE_GLOBAL) {
/* 194 */         array.add(itemStack);
/*     */       } else {
/* 196 */         int i = (int)(itemStack.getCount() * d + 1.0E-4D);
/*     */         
/* 198 */         array.add(new ItemStack(itemStack.getItem(), i));
/*     */       } 
/*     */     } 
/*     */     
/* 202 */     return array;
/*     */   }
/*     */   
/*     */   public CharSequence formatValueForUi(double paramDouble) {
/* 206 */     if (this.scripted) {
/* 207 */       a.setLength(0);
/* 208 */       return (CharSequence)a;
/*     */     } 
/*     */     
/* 211 */     return Game.i.statisticsManager.formatStatisticsValue(this.statisticsType, paramDouble);
/*     */   }
/*     */   public CharSequence formatValueForUiWithRequiredValue(double paramDouble1, double paramDouble2, boolean paramBoolean) {
/* 214 */     a.setLength(0);
/*     */     
/* 216 */     if (paramDouble2 <= 0.0D) {
/* 217 */       return (CharSequence)a;
/*     */     }
/*     */     
/* 220 */     paramDouble1 = StrictMath.min(paramDouble2, paramDouble1);
/*     */     
/* 222 */     if (paramBoolean) a.append("[#90A4AE]"); 
/* 223 */     a.append(formatValueForUi(paramDouble1));
/* 224 */     a.append(" / ");
/* 225 */     if (paramBoolean) a.append("[][#ffffff]"); 
/* 226 */     a.append(formatValueForUi(paramDouble2));
/* 227 */     if (paramBoolean) a.append("[]");
/*     */     
/* 229 */     return (CharSequence)a;
/*     */   }
/*     */   
/*     */   public boolean isDuringGame() {
/* 233 */     return this.duringGame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompleted() {
/* 241 */     return Game.i.basicLevelManager.isQuestCompleted(this.id);
/*     */   }
/*     */   
/*     */   public boolean wasEverCompleted() {
/* 245 */     return Game.i.basicLevelManager.isQuestEverCompleted(this.id);
/*     */   }
/*     */   
/*     */   public void setCompleted(boolean paramBoolean) {
/* 249 */     if (!paramBoolean) {
/*     */       ProgressPrefs progressPrefs;
/* 251 */       (progressPrefs = ProgressPrefs.i()).basicLevel.removeQuestSavedValue(this.id);
/* 252 */       progressPrefs.requireSave();
/*     */     } 
/* 254 */     Game.i.basicLevelManager.setQuestCompleted(this.id, paramBoolean);
/*     */   }
/*     */   
/*     */   public CharSequence getTitle(boolean paramBoolean1, boolean paramBoolean2) {
/* 258 */     a.setLength(0);
/*     */     
/* 260 */     if (this.scripted) {
/* 261 */       a.append(Game.i.localeManager.i18n.get(this.scriptedTitle));
/*     */     } else {
/* 263 */       a.append(Game.i.statisticsManager.getStatisticsTitle(this.statisticsType));
/*     */     } 
/*     */     
/* 266 */     if (paramBoolean2 && this.duringGame) {
/* 267 */       if (paramBoolean1) {
/* 268 */         a.append("[#90A4AE]");
/*     */       }
/*     */       
/* 271 */       a.append(" ").append(Game.i.localeManager.i18n.get("during_one_game").toLowerCase(Locale.ENGLISH));
/*     */       
/* 273 */       if (paramBoolean1) {
/* 274 */         a.append("[]");
/*     */       }
/*     */     } 
/*     */     
/* 278 */     return (CharSequence)a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\BasicLevelQuestConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */