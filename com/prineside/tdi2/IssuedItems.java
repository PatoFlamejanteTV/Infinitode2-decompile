/*     */ package com.prineside.tdi2;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.esotericsoftware.kryo.Kryo;
/*     */ import com.esotericsoftware.kryo.io.Input;
/*     */ import com.esotericsoftware.kryo.io.Output;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.CaseType;
/*     */ import com.prineside.tdi2.systems.GameStateSystem;
/*     */ import com.prineside.tdi2.utils.PMath;
/*     */ 
/*     */ @REGS
/*     */ public class IssuedItems implements KryoSerializable {
/*     */   @NAGS
/*     */   public int issueTimestamp;
/*     */   @NAGS
/*     */   public boolean shown;
/*     */   public IssueReason reason;
/*     */   
/*     */   @REGS
/*     */   public enum IssueReason {
/*  23 */     REGULAR_REWARD,
/*     */     
/*  25 */     BASIC_LEVEL_BONUS_ITEMS,
/*  26 */     GAME_OVER_BASIC_LEVEL,
/*  27 */     GAME_OVER_USER_MAP,
/*  28 */     GAME_OVER_DAILY_QUEST,
/*  29 */     QUEST,
/*  30 */     WAVE_QUEST,
/*  31 */     DAILY_QUEST,
/*  32 */     REWARD_VIDEO,
/*  33 */     PREMIUM_REWARD_VIDEO,
/*  34 */     SECRET_CODE,
/*  35 */     PURCHASE,
/*  36 */     RANDOM_TILE_PACK,
/*  37 */     RANDOM_BARRIER_PACK,
/*  38 */     RANDOM_TELEPORT_PACK,
/*  39 */     CASE,
/*  40 */     DAILY_QUEST_LEADER_BOARD,
/*  41 */     MAP_PRESTIGE,
/*  42 */     QUESTS_PRESTIGE,
/*  43 */     DAILY_LOOT,
/*     */     
/*  45 */     SIGNED_UP_BY_INVITE,
/*  46 */     FOR_INVITED_PLAYER,
/*  47 */     FAILURE_COMPENSATION,
/*  48 */     LUCKY_SHOT,
/*  49 */     ACHIEVEMENT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   public Array<ItemStack> items = new Array(ItemStack.class);
/*     */ 
/*     */   
/*     */   public GameStateSystem.GameMode basicLevelGameMode;
/*     */ 
/*     */   
/*     */   public String gameOverBasicLevel;
/*     */ 
/*     */   
/*     */   public String userMapId;
/*     */ 
/*     */   
/*     */   public int userMapHash;
/*     */ 
/*     */   
/*     */   public String dailyQuestDate;
/*     */ 
/*     */   
/*     */   public String questBasicLevel;
/*     */ 
/*     */   
/*     */   public String questId;
/*     */ 
/*     */   
/*     */   public String waveQuestBasicLevel;
/*     */ 
/*     */   
/*     */   public String waveQuestId;
/*     */   
/*     */   public String secretCode;
/*     */   
/*     */   public String secretCodeDescription;
/*     */   
/*     */   public float randomTilePackQuality;
/*     */   
/*     */   public float randomBarrierPackQuality;
/*     */   
/*     */   public CaseType caseType;
/*     */   
/*     */   public int dqBoardPlace;
/*     */   
/*     */   public int dqBoardTotalPlaces;
/*     */   
/*     */   public int dqBoardRankPercentage;
/*     */   
/*     */   public String dqDate;
/*     */   
/*     */   public String invitedPlayerId;
/*     */   
/*     */   public String invitedPlayerNickname;
/*     */   
/*     */   public MapPrestigeConfig mapPrestigeConfig;
/*     */   
/*     */   public String dailyLootDate;
/*     */   
/*     */   public AchievementType achievementType;
/*     */   
/*     */   public String failureCompensationDescription;
/*     */   
/*     */   public boolean addedToIssuedItemsArray;
/*     */   
/*     */   public int massUnpackCount;
/*     */   
/* 118 */   private static final StringBuilder a = new StringBuilder();
/*     */ 
/*     */   
/*     */   public void write(Kryo paramKryo, Output paramOutput) {
/* 122 */     paramOutput.writeInt(this.issueTimestamp);
/* 123 */     paramOutput.writeBoolean(this.shown);
/* 124 */     paramKryo.writeObject(paramOutput, this.reason);
/* 125 */     paramKryo.writeObject(paramOutput, this.items);
/* 126 */     paramKryo.writeObjectOrNull(paramOutput, this.basicLevelGameMode, GameStateSystem.GameMode.class);
/* 127 */     paramKryo.writeObjectOrNull(paramOutput, this.gameOverBasicLevel, String.class);
/* 128 */     paramKryo.writeObjectOrNull(paramOutput, this.userMapId, String.class);
/* 129 */     paramOutput.writeInt(this.userMapHash);
/* 130 */     paramKryo.writeObjectOrNull(paramOutput, this.dailyQuestDate, String.class);
/* 131 */     paramKryo.writeObjectOrNull(paramOutput, this.questBasicLevel, String.class);
/* 132 */     paramKryo.writeObjectOrNull(paramOutput, this.questId, String.class);
/* 133 */     paramKryo.writeObjectOrNull(paramOutput, this.waveQuestBasicLevel, String.class);
/* 134 */     paramKryo.writeObjectOrNull(paramOutput, this.waveQuestId, String.class);
/* 135 */     paramKryo.writeObjectOrNull(paramOutput, this.secretCode, String.class);
/* 136 */     paramKryo.writeObjectOrNull(paramOutput, this.secretCodeDescription, String.class);
/* 137 */     paramOutput.writeFloat(this.randomTilePackQuality);
/* 138 */     paramOutput.writeFloat(this.randomBarrierPackQuality);
/* 139 */     paramKryo.writeObjectOrNull(paramOutput, this.caseType, CaseType.class);
/* 140 */     paramOutput.writeVarInt(this.dqBoardPlace, false);
/* 141 */     paramOutput.writeVarInt(this.dqBoardTotalPlaces, true);
/* 142 */     paramOutput.writeVarInt(this.dqBoardRankPercentage, false);
/* 143 */     paramKryo.writeObjectOrNull(paramOutput, this.dqDate, String.class);
/* 144 */     paramKryo.writeObjectOrNull(paramOutput, this.invitedPlayerId, String.class);
/* 145 */     paramKryo.writeObjectOrNull(paramOutput, this.invitedPlayerNickname, String.class);
/* 146 */     paramKryo.writeObjectOrNull(paramOutput, this.mapPrestigeConfig, MapPrestigeConfig.class);
/* 147 */     paramKryo.writeObjectOrNull(paramOutput, this.dailyLootDate, String.class);
/* 148 */     paramKryo.writeObjectOrNull(paramOutput, this.achievementType, AchievementType.class);
/* 149 */     paramKryo.writeObjectOrNull(paramOutput, this.failureCompensationDescription, String.class);
/* 150 */     paramOutput.writeBoolean(this.addedToIssuedItemsArray);
/* 151 */     paramOutput.writeVarInt(this.massUnpackCount, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Kryo paramKryo, Input paramInput) {
/* 156 */     this.issueTimestamp = paramInput.readInt();
/* 157 */     this.shown = paramInput.readBoolean();
/* 158 */     this.reason = (IssueReason)paramKryo.readObject(paramInput, IssueReason.class);
/* 159 */     this.items = (Array<ItemStack>)paramKryo.readObject(paramInput, Array.class);
/* 160 */     this.basicLevelGameMode = (GameStateSystem.GameMode)paramKryo.readObjectOrNull(paramInput, GameStateSystem.GameMode.class);
/* 161 */     this.gameOverBasicLevel = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 162 */     this.userMapId = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 163 */     this.userMapHash = paramInput.readInt();
/* 164 */     this.dailyQuestDate = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 165 */     this.questBasicLevel = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 166 */     this.questId = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 167 */     this.waveQuestBasicLevel = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 168 */     this.waveQuestId = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 169 */     this.secretCode = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 170 */     this.secretCodeDescription = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 171 */     this.randomTilePackQuality = paramInput.readFloat();
/* 172 */     this.randomBarrierPackQuality = paramInput.readFloat();
/* 173 */     this.caseType = (CaseType)paramKryo.readObjectOrNull(paramInput, CaseType.class);
/* 174 */     this.dqBoardPlace = paramInput.readVarInt(false);
/* 175 */     this.dqBoardTotalPlaces = paramInput.readVarInt(true);
/* 176 */     this.dqBoardRankPercentage = paramInput.readVarInt(false);
/* 177 */     this.dqDate = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 178 */     this.invitedPlayerId = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 179 */     this.invitedPlayerNickname = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 180 */     this.mapPrestigeConfig = (MapPrestigeConfig)paramKryo.readObjectOrNull(paramInput, MapPrestigeConfig.class);
/* 181 */     this.dailyLootDate = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 182 */     this.achievementType = (AchievementType)paramKryo.readObjectOrNull(paramInput, AchievementType.class);
/* 183 */     this.failureCompensationDescription = (String)paramKryo.readObjectOrNull(paramInput, String.class);
/* 184 */     this.addedToIssuedItemsArray = paramInput.readBoolean();
/* 185 */     this.massUnpackCount = paramInput.readVarInt(true);
/*     */   }
/*     */   
/*     */   private IssuedItems() {}
/*     */   
/*     */   public IssuedItems(IssueReason paramIssueReason, int paramInt) {
/* 191 */     this.issueTimestamp = paramInt;
/* 192 */     this.reason = paramIssueReason;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void compactItems() {
/* 199 */     for (int i = this.items.size - 1; i >= 0; i--) {
/* 200 */       ItemStack itemStack = ((ItemStack[])this.items.items)[i];
/* 201 */       for (int j = i - 1; j >= 0; j--) {
/* 202 */         ItemStack itemStack1 = ((ItemStack[])this.items.items)[j];
/* 203 */         if (itemStack.getItem().sameAs(itemStack1.getItem())) {
/* 204 */           itemStack1.setCount(PMath.addWithoutOverflow(itemStack1.getCount(), itemStack.getCount()));
/* 205 */           this.items.removeIndex(i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   } public CharSequence getReasonDescription() {
/*     */     BasicLevel basicLevel;
/*     */     CharSequence charSequence;
/* 212 */     a.setLength(0);
/* 213 */     switch (null.a[this.reason.ordinal()]) {
/*     */       
/*     */       case 1:
/* 216 */         if ((basicLevel = Game.i.basicLevelManager.getLevel(this.questBasicLevel)) != null) {
/* 217 */           BasicLevelQuestConfig basicLevelQuestConfig = basicLevel.getQuest(this.questId);
/* 218 */           a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_QUEST", new Object[] { basicLevelQuestConfig.getTitle(false, true), basicLevelQuestConfig.formatValueForUi(basicLevelQuestConfig.getRequiredValue(Game.i.gameValueManager.getSnapshot())), this.questBasicLevel }));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 230 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_QUEST_lite", new Object[] { this.questBasicLevel }));
/*     */         break;
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 236 */         if ((basicLevel = Game.i.basicLevelManager.getLevel(this.waveQuestBasicLevel)) != null) {
/* 237 */           BasicLevel.WaveQuest waveQuest = basicLevel.getWaveQuest(this.waveQuestId);
/* 238 */           a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_WAVE_QUEST", new Object[] { Integer.valueOf(waveQuest.waves), basicLevel.name })); break;
/*     */         } 
/* 240 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_WAVE_QUEST_lite"));
/*     */         break;
/*     */ 
/*     */       
/*     */       case 3:
/* 245 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_GAME_OVER_BASIC_LEVEL", new Object[] { this.gameOverBasicLevel }));
/*     */         break;
/*     */       
/*     */       case 4:
/* 249 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_BASIC_LEVEL_BONUS_ITEMS"));
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 6:
/* 256 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_DAILY_QUEST")).append(" ").append(this.dailyQuestDate);
/*     */         break;
/*     */       
/*     */       case 7:
/* 260 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_DAILY_QUEST"));
/*     */         break;
/*     */       
/*     */       case 8:
/* 264 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_REWARD_VIDEO"));
/*     */         break;
/*     */       
/*     */       case 9:
/* 268 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_PREMIUM_REWARD_VIDEO"));
/*     */         break;
/*     */       
/*     */       case 10:
/* 272 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_SECRET_CODE")).append(" \"").append(this.secretCode).append("\" (").append(this.secretCodeDescription).append(")");
/*     */         break;
/*     */       
/*     */       case 11:
/* 276 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_GAME_OVER_USER_MAP"));
/*     */         break;
/*     */       
/*     */       case 12:
/* 280 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_PURCHASE"));
/*     */         break;
/*     */       
/*     */       case 13:
/* 284 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_RANDOM_TILE_PACK", new Object[] { PMath.toString(StrictMath.round(this.randomTilePackQuality * 100.0F)) }));
/*     */         break;
/*     */       
/*     */       case 14:
/* 288 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_RANDOM_BARRIER_PACK", new Object[] { PMath.toString(StrictMath.round(this.randomBarrierPackQuality * 100.0F)) }));
/*     */         break;
/*     */       
/*     */       case 15:
/* 292 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_MAP_PRESTIGE"));
/*     */         break;
/*     */       
/*     */       case 16:
/* 296 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_DAILY_LOOT", new Object[] { this.dailyLootDate }));
/*     */         break;
/*     */       
/*     */       case 17:
/* 300 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_LUCKY_SHOT", new Object[] { this.dailyLootDate }));
/*     */         break;
/*     */       
/*     */       case 18:
/* 304 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_QUESTS_PRESTIGE"));
/*     */         break;
/*     */       
/*     */       case 19:
/* 308 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_RANDOM_TELEPORT_PACK"));
/*     */         break;
/*     */       
/*     */       case 20:
/* 312 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_CASE", new Object[] { String.valueOf(Item.D.F_CASE.create(this.caseType, true).getTitle()) }));
/*     */         break;
/*     */       
/*     */       case 21:
/* 316 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_DAILY_QUEST_LEADER_BOARD", new Object[] { this.dqDate, Integer.valueOf(this.dqBoardPlace), Integer.valueOf(this.dqBoardTotalPlaces), Integer.valueOf(this.dqBoardRankPercentage) }));
/*     */         break;
/*     */       
/*     */       case 22:
/* 320 */         a.append(Game.i.localeManager.i18n.get("issued_items_reason_description_SIGNED_UP_BY_INVITE"));
/*     */         break;
/*     */       
/*     */       case 23:
/* 324 */         a.append(Game.i.localeManager.i18n.format("issued_items_reason_description_FOR_INVITED_PLAYER", new Object[] { this.invitedPlayerNickname }));
/*     */         break;
/*     */       
/*     */       case 24:
/* 328 */         charSequence = Game.i.achievementManager.getName(this.achievementType);
/* 329 */         a.append(Game.i.localeManager.i18n.format("achievement_complete", new Object[] { charSequence }));
/*     */         break;
/*     */       
/*     */       case 25:
/* 333 */         if (this.failureCompensationDescription != null) a.append(this.failureCompensationDescription);
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 338 */     if (this.massUnpackCount > 1) {
/* 339 */       a.append(" x").append(StringFormatter.commaSeparatedNumber(this.massUnpackCount));
/*     */     }
/*     */     
/* 342 */     return (CharSequence)a;
/*     */   }
/*     */   
/*     */   public void toJson(Json paramJson) {
/* 346 */     paramJson.writeValue("r", this.reason.name());
/* 347 */     paramJson.writeValue("it", Integer.valueOf(this.issueTimestamp));
/* 348 */     paramJson.writeValue("s", Boolean.valueOf(this.shown));
/* 349 */     if (this.massUnpackCount != 0) paramJson.writeValue("muc", Integer.valueOf(this.massUnpackCount));
/*     */     
/* 351 */     switch (null.a[this.reason.ordinal()]) {
/*     */       case 3:
/* 353 */         paramJson.writeValue("bl", this.gameOverBasicLevel);
/* 354 */         paramJson.writeValue("blgm", this.basicLevelGameMode);
/*     */         break;
/*     */       
/*     */       case 11:
/* 358 */         paramJson.writeValue("umi", this.userMapId);
/* 359 */         paramJson.writeValue("umh", Integer.valueOf(this.userMapHash));
/*     */         break;
/*     */       
/*     */       case 6:
/* 363 */         paramJson.writeValue("dqd", this.dailyQuestDate);
/*     */         break;
/*     */       
/*     */       case 1:
/* 367 */         paramJson.writeValue("bl", this.questBasicLevel);
/* 368 */         paramJson.writeValue("q", this.questId);
/*     */         break;
/*     */       
/*     */       case 2:
/* 372 */         paramJson.writeValue("bl", this.waveQuestBasicLevel);
/* 373 */         paramJson.writeValue("q", this.waveQuestId);
/*     */         break;
/*     */       
/*     */       case 10:
/* 377 */         paramJson.writeValue("c", this.secretCode);
/* 378 */         paramJson.writeValue("m", this.secretCodeDescription);
/*     */         break;
/*     */       
/*     */       case 20:
/* 382 */         paramJson.writeValue("ct", this.caseType.name());
/*     */         break;
/*     */       
/*     */       case 21:
/* 386 */         paramJson.writeValue("dqlbp", Integer.valueOf(this.dqBoardPlace));
/* 387 */         paramJson.writeValue("dqlbrp", Integer.valueOf(this.dqBoardRankPercentage));
/* 388 */         paramJson.writeValue("dqlbtp", Integer.valueOf(this.dqBoardTotalPlaces));
/* 389 */         paramJson.writeValue("dqlbd", this.dqDate);
/*     */         break;
/*     */       
/*     */       case 13:
/* 393 */         paramJson.writeValue("rtpq", Float.valueOf(this.randomTilePackQuality));
/*     */         break;
/*     */       
/*     */       case 14:
/* 397 */         paramJson.writeValue("rbpq", Float.valueOf(this.randomBarrierPackQuality));
/*     */         break;
/*     */       
/*     */       case 15:
/* 401 */         paramJson.writeObjectStart("mpc");
/* 402 */         this.mapPrestigeConfig.toJson(paramJson);
/* 403 */         paramJson.writeObjectEnd();
/*     */         break;
/*     */       
/*     */       case 16:
/* 407 */         paramJson.writeValue("dld", this.dailyLootDate);
/*     */         break;
/*     */       
/*     */       case 24:
/* 411 */         paramJson.writeValue("at", this.achievementType.name());
/*     */         break;
/*     */       
/*     */       case 23:
/* 415 */         paramJson.writeValue("ipipi", this.invitedPlayerId);
/* 416 */         paramJson.writeValue("ipipn", this.invitedPlayerNickname);
/*     */         break;
/*     */       
/*     */       case 25:
/* 420 */         if (this.failureCompensationDescription != null) paramJson.writeValue("fcd", this.failureCompensationDescription);
/*     */         
/*     */         break;
/*     */     } 
/*     */     
/* 425 */     paramJson.writeArrayStart("i");
/* 426 */     for (byte b = 0; b < this.items.size; b++) {
/* 427 */       paramJson.writeObjectStart();
/* 428 */       ((ItemStack[])this.items.items)[b].toJson(paramJson);
/* 429 */       paramJson.writeObjectEnd();
/*     */     } 
/* 431 */     paramJson.writeArrayEnd();
/*     */   }
/*     */   
/*     */   public static IssuedItems fromJson(JsonValue paramJsonValue) {
/*     */     IssuedItems issuedItems;
/* 436 */     (issuedItems = new IssuedItems(IssueReason.valueOf(paramJsonValue.getString("r")), paramJsonValue.getInt("it"))).shown = paramJsonValue.getBoolean("s", false);
/* 437 */     issuedItems.massUnpackCount = paramJsonValue.getInt("muc", 0);
/*     */     
/*     */     JsonValue jsonValue;
/* 440 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = paramJsonValue.get("i")).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 441 */       issuedItems.items.add(ItemStack.fromJson(jsonValue1)); }
/*     */ 
/*     */     
/* 444 */     switch (null.a[issuedItems.reason.ordinal()]) {
/*     */       case 3:
/* 446 */         issuedItems.gameOverBasicLevel = paramJsonValue.getString("bl");
/* 447 */         issuedItems.basicLevelGameMode = GameStateSystem.GameMode.valueOf(paramJsonValue.getString("blgm", GameStateSystem.GameMode.BASIC_LEVELS.name()));
/*     */         break;
/*     */       
/*     */       case 11:
/* 451 */         issuedItems.userMapHash = paramJsonValue.getInt("umh");
/* 452 */         issuedItems.userMapId = paramJsonValue.getString("umi");
/*     */         break;
/*     */       
/*     */       case 6:
/* 456 */         issuedItems.dailyQuestDate = paramJsonValue.getString("dqd");
/*     */         break;
/*     */       
/*     */       case 1:
/* 460 */         issuedItems.questBasicLevel = paramJsonValue.getString("bl");
/* 461 */         issuedItems.questId = paramJsonValue.getString("q");
/*     */         break;
/*     */       
/*     */       case 2:
/* 465 */         issuedItems.waveQuestBasicLevel = paramJsonValue.getString("bl");
/* 466 */         issuedItems.waveQuestId = paramJsonValue.getString("q");
/*     */         break;
/*     */       
/*     */       case 10:
/* 470 */         issuedItems.secretCode = paramJsonValue.getString("c");
/* 471 */         issuedItems.secretCodeDescription = paramJsonValue.getString("m");
/*     */         break;
/*     */       
/*     */       case 20:
/* 475 */         issuedItems.caseType = CaseType.valueOf(paramJsonValue.getString("ct"));
/*     */         break;
/*     */       
/*     */       case 21:
/* 479 */         issuedItems.dqBoardPlace = paramJsonValue.getInt("dqlbp");
/* 480 */         issuedItems.dqBoardRankPercentage = paramJsonValue.getInt("dqlbrp");
/* 481 */         issuedItems.dqBoardTotalPlaces = paramJsonValue.getInt("dqlbtp");
/* 482 */         issuedItems.dqDate = paramJsonValue.getString("dqlbd");
/*     */         break;
/*     */       
/*     */       case 13:
/* 486 */         issuedItems.randomTilePackQuality = paramJsonValue.getFloat("rtpq");
/*     */         break;
/*     */       
/*     */       case 14:
/* 490 */         issuedItems.randomBarrierPackQuality = paramJsonValue.getFloat("rbpq");
/*     */         break;
/*     */       
/*     */       case 15:
/* 494 */         issuedItems.mapPrestigeConfig = MapPrestigeConfig.fromJson(paramJsonValue.get("mpc"));
/*     */         break;
/*     */       
/*     */       case 16:
/* 498 */         issuedItems.dailyLootDate = paramJsonValue.getString("dld");
/*     */         break;
/*     */       
/*     */       case 24:
/* 502 */         issuedItems.achievementType = AchievementType.valueOf(paramJsonValue.getString("at"));
/*     */         break;
/*     */       
/*     */       case 23:
/* 506 */         issuedItems.invitedPlayerId = paramJsonValue.getString("ipipi");
/* 507 */         issuedItems.invitedPlayerNickname = paramJsonValue.getString("ipipn");
/*     */         break;
/*     */       
/*     */       case 25:
/* 511 */         issuedItems.failureCompensationDescription = paramJsonValue.getString("fcd", null);
/*     */         break;
/*     */     } 
/*     */ 
/*     */     
/* 516 */     return issuedItems;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 521 */     return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (reason: " + this.reason + ", item types: " + this.items.size + ")";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\IssuedItems.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */