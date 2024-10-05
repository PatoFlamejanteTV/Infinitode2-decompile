/*     */ package com.prineside.tdi2.systems;
/*     */ 
/*     */ import com.badlogic.gdx.graphics.g2d.Batch;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.BasicLevelQuestConfig;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.GameSystem;
/*     */ import com.prineside.tdi2.GameSystemProvider;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.configs.GameRenderingOrder;
/*     */ import com.prineside.tdi2.enums.DifficultyMode;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.ui.components.QuestList;
/*     */ import com.prineside.tdi2.utils.NAGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @NAGS
/*     */ public final class QuestSystem
/*     */   extends GameSystem {
/*  28 */   private static final TLog a = TLog.forClass(QuestSystem.class);
/*     */   
/*  30 */   private final DelayedRemovalArray<QuestEntry> b = new DelayedRemovalArray(true, 1, QuestEntry.class);
/*  31 */   private final DelayedRemovalArray<DelayedQuestRemoveEntry> c = new DelayedRemovalArray(false, 1, DelayedQuestRemoveEntry.class);
/*     */   
/*     */   private boolean d;
/*  34 */   private int e = 0;
/*     */   private BasicLevelWaveQuest f;
/*     */   private int g;
/*     */   private int h;
/*  38 */   private ObjectSet<String> i = new ObjectSet();
/*     */ 
/*     */   
/*     */   public final boolean affectsGameState() {
/*  42 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setup() {
/*  47 */     if (this.S.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/*  48 */       this.g = Game.i.basicLevelManager.getGainedStarsOnLevel(Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName));
/*     */     }
/*  50 */     a();
/*     */     
/*  52 */     this.S._render.addLayer((new RenderSystem.Layer(GameRenderingOrder.QUEST_DRAW, false, (paramBatch, paramFloat1, paramFloat2, paramFloat3) -> draw(paramFloat2, paramFloat1)))
/*     */ 
/*     */         
/*  55 */         .setName("Quest-draw"));
/*     */   }
/*     */ 
/*     */   
/*     */   public final void postSetup() {
/*  60 */     if (GameStateSystem.GameMode.isBasicLevel(this.S.gameState.gameMode)) {
/*  61 */       byte b1 = 0;
/*  62 */       int i = this.S.gameValue.getIntValue(GameValueType.REGULAR_QUESTS_SLOTS);
/*  63 */       BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName);
/*     */       
/*  65 */       boolean bool = true; byte b2;
/*  66 */       for (b2 = 0; b2 < basicLevel.waveQuests.size; b2++) {
/*  67 */         if (!((BasicLevel.WaveQuest[])basicLevel.waveQuests.items)[b2].isCompleted()) {
/*  68 */           bool = false;
/*     */           break;
/*     */         } 
/*     */       } 
/*  72 */       if (bool) {
/*  73 */         a.i("all WQ are completed, +1 quest slot", new Object[0]);
/*  74 */         i++;
/*     */       } 
/*     */       
/*  77 */       for (b2 = 0; b2 < basicLevel.quests.size; b2++) {
/*     */         Quest quest; BasicLevelQuestConfig basicLevelQuestConfig;
/*  79 */         if (!(basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(b2)).isCompleted() && (
/*     */           
/*  81 */           quest = basicLevelQuestConfig.createIngameQuest(this.S)) != null) {
/*  82 */           this.S._quest.addQuest(quest);
/*  83 */           b1++;
/*  84 */           if (b1 < i)
/*     */             continue;  break;
/*     */         } 
/*     */         continue;
/*     */       } 
/*     */     } 
/*  90 */     update(0.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void postStateRestore() {}
/*     */ 
/*     */   
/*     */   private void a() {
/*  99 */     if (this.S._gameUi == null)
/*     */       return; 
/* 101 */     if (this.S.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 102 */       this.S._gameUi.mainUi.setLevelStarsIcon(this.g); return;
/*     */     } 
/* 104 */     this.S._gameUi.mainUi.setLevelStarsIcon(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final QuestEntry addQuest(Quest paramQuest) {
/* 109 */     if (paramQuest == null) throw new IllegalArgumentException("Quest is null");
/*     */     
/* 111 */     if (paramQuest instanceof RegularQuest) {
/* 112 */       RegularQuest regularQuest = (RegularQuest)paramQuest;
/* 113 */       if (!this.i.contains(regularQuest.b)) {
/* 114 */         this.i.add(regularQuest.b);
/*     */       } else {
/* 116 */         a.e("warning: quest " + regularQuest.b + " has been added to this game already", new Object[0]);
/*     */       } 
/*     */     } 
/*     */     QuestEntry questEntry;
/* 120 */     QuestEntry.a(questEntry = new QuestEntry(), paramQuest);
/*     */     
/* 122 */     if (this.S._gameUi != null) {
/* 123 */       QuestList.QuestListItem questListItem = this.S._gameUi.questList.addQuestListItem();
/*     */       
/* 125 */       if (paramQuest instanceof BasicLevelQuest) {
/* 126 */         BasicLevelQuest basicLevelQuest = (BasicLevelQuest)paramQuest;
/* 127 */         if (Game.i.dailyQuestManager.getDailyLootCurrentQuest().equals(basicLevelQuest.a.id)) {
/* 128 */           questListItem.setTitlePrefix(Game.i.assetManager.replaceRegionAliasesWithChars("[#03A9F4]<@icon-calendar>[] "));
/*     */         } else {
/* 130 */           for (byte b = 0; b < basicLevelQuest.a.prizes.size; b++) {
/* 131 */             if (((ItemStack[])basicLevelQuest.a.prizes.items)[b].getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 132 */               questListItem.setTitlePrefix(Game.i.assetManager.replaceRegionAliasesWithChars("[#FFC107]<@icon-star>[] "));
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/* 137 */       } else if (paramQuest instanceof BasicLevelWaveQuest) {
/* 138 */         BasicLevelWaveQuest basicLevelWaveQuest = (BasicLevelWaveQuest)paramQuest;
/* 139 */         for (byte b = 0; b < (BasicLevelWaveQuest.a(basicLevelWaveQuest)).prizes.size; b++) {
/* 140 */           if (((ItemStack[])(BasicLevelWaveQuest.a(basicLevelWaveQuest)).prizes.items)[b].getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 141 */             questListItem.setTitlePrefix(Game.i.assetManager.replaceRegionAliasesWithChars("[#FFC107]<@icon-star>[] "));
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 147 */       questListItem.setText(paramQuest.getTitle());
/* 148 */       QuestEntry.a(questEntry, questListItem);
/*     */     } 
/*     */     
/* 151 */     this.b.add(questEntry);
/*     */     
/* 153 */     return questEntry;
/*     */   }
/*     */   
/*     */   public final void removeQuest(Quest paramQuest) {
/* 157 */     this.b.begin();
/* 158 */     for (byte b = 0; b < this.b.size; b++) {
/* 159 */       if (QuestEntry.a(((QuestEntry[])this.b.items)[b]) == paramQuest) {
/* 160 */         if (this.S._gameUi != null) this.S._gameUi.questList.removeQuestListItem(QuestEntry.b(((QuestEntry[])this.b.items)[b])); 
/* 161 */         this.b.removeIndex(b);
/*     */       } 
/*     */     } 
/* 164 */     this.b.end();
/*     */   }
/*     */   
/*     */   public final void removeQuestWithDelay(Quest paramQuest, float paramFloat) {
/*     */     DelayedQuestRemoveEntry delayedQuestRemoveEntry;
/* 169 */     DelayedQuestRemoveEntry.a(delayedQuestRemoveEntry = new DelayedQuestRemoveEntry((byte)0), paramQuest);
/* 170 */     DelayedQuestRemoveEntry.a(delayedQuestRemoveEntry, paramFloat);
/* 171 */     this.c.add(delayedQuestRemoveEntry);
/*     */   }
/*     */   @Null
/*     */   public final QuestList.QuestListItem getListItem(Quest paramQuest) {
/* 175 */     if (paramQuest == null) throw new IllegalArgumentException("Quest is null");
/*     */     
/* 177 */     for (byte b = 0; b < this.b.size; b++) {
/* 178 */       if (QuestEntry.a(((QuestEntry[])this.b.items)[b]) == paramQuest) {
/* 179 */         return QuestEntry.b(((QuestEntry[])this.b.items)[b]);
/*     */       }
/*     */     } 
/*     */     
/* 183 */     return null;
/*     */   }
/*     */   
/*     */   public final int getBasicLevelStars() {
/* 187 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void draw(float paramFloat1, float paramFloat2) {
/* 191 */     if (this.S != null && this.S.gameState != null && this.S.gameState.isGameOver())
/*     */       return; 
/* 193 */     paramFloat2 *= 1.25F;
/*     */ 
/*     */     
/* 196 */     this.c.begin();
/* 197 */     for (byte b = 0; b < this.c.size; b++) {
/*     */       DelayedQuestRemoveEntry delayedQuestRemoveEntry;
/* 199 */       DelayedQuestRemoveEntry.b(delayedQuestRemoveEntry = (DelayedQuestRemoveEntry)this.c.get(b), paramFloat2);
/* 200 */       if (DelayedQuestRemoveEntry.a(delayedQuestRemoveEntry) <= 0.0F) {
/* 201 */         removeQuest(DelayedQuestRemoveEntry.b(delayedQuestRemoveEntry));
/* 202 */         this.c.removeIndex(b);
/*     */       } 
/*     */     } 
/* 205 */     this.c.end();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void update(float paramFloat) {
/* 211 */     this.b.begin(); int i;
/* 212 */     for (i = 0; i < this.b.size; i++) {
/*     */       QuestEntry questEntry;
/*     */       
/* 215 */       QuestEntry.a(questEntry = ((QuestEntry[])this.b.items)[i]).update();
/*     */       
/* 217 */       if (!QuestEntry.c(questEntry) && QuestEntry.a(questEntry).isCompleted()) {
/*     */         QuestList.QuestListItem questListItem;
/*     */         
/* 220 */         if ((questListItem = getListItem(QuestEntry.a(questEntry))) != null) questListItem.setCompleted(true); 
/* 221 */         QuestEntry.a(questEntry).onCompletion();
/*     */         
/* 223 */         QuestEntry.a(questEntry, true);
/*     */       } 
/*     */     } 
/* 226 */     this.b.end();
/*     */ 
/*     */     
/* 229 */     if (this.S.gameState.gameMode == GameStateSystem.GameMode.BASIC_LEVELS) {
/* 230 */       if (this.f == null || this.f.isCompleted()) {
/*     */         
/* 232 */         BasicLevel.WaveQuest waveQuest = null;
/* 233 */         BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName);
/* 234 */         for (byte b = 0; b < basicLevel.waveQuests.size; b++) {
/*     */           BasicLevel.WaveQuest waveQuest1;
/* 236 */           if ((waveQuest1 = (BasicLevel.WaveQuest)basicLevel.waveQuests.get(b)).waves > this.e && !waveQuest1.isCompleted()) {
/*     */             
/* 238 */             waveQuest = waveQuest1;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 243 */         if (waveQuest != null) {
/*     */           
/* 245 */           if (this.f != null)
/*     */           {
/* 247 */             removeQuestWithDelay(this.f, 2.0F);
/*     */           }
/*     */           
/* 250 */           BasicLevelWaveQuest basicLevelWaveQuest = waveQuest.createIngameQuest(this.S);
/* 251 */           addQuest(basicLevelWaveQuest);
/* 252 */           this.f = basicLevelWaveQuest;
/* 253 */           this.e = waveQuest.waves;
/* 254 */           basicLevelWaveQuest.update();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 259 */       i = this.S.gameValue.getIntValue(GameValueType.REGULAR_QUESTS_REPLACES);
/*     */       
/* 261 */       if (this.h < i) {
/* 262 */         boolean bool1 = false;
/* 263 */         boolean bool2 = false;
/*     */         
/* 265 */         this.b.begin(); byte b;
/* 266 */         label58: for (b = 0; b < this.b.size; b++) {
/*     */           QuestEntry questEntry;
/*     */           
/* 269 */           if (QuestEntry.a(questEntry = ((QuestEntry[])this.b.items)[b]) instanceof BasicLevelQuest && QuestEntry.a(questEntry).isCompleted()) {
/* 270 */             bool1 = true;
/*     */ 
/*     */ 
/*     */             
/* 274 */             BasicLevel basicLevel = Game.i.basicLevelManager.getLevel(this.S.gameState.basicLevelName);
/* 275 */             for (byte b1 = 0; b1 < basicLevel.quests.size; b1++) {
/*     */               BasicLevelQuestConfig basicLevelQuestConfig;
/* 277 */               if (!(basicLevelQuestConfig = (BasicLevelQuestConfig)basicLevel.quests.get(b1)).isCompleted())
/*     */               {
/*     */                 
/* 280 */                 if (!this.i.contains(basicLevelQuestConfig.id)) {
/*     */                   Quest quest;
/*     */                   
/* 283 */                   if ((quest = basicLevelQuestConfig.createIngameQuest(this.S)) != null) {
/*     */                     
/* 285 */                     addQuest(quest);
/* 286 */                     removeQuestWithDelay(QuestEntry.a(questEntry), 2.0F);
/* 287 */                     quest.update();
/* 288 */                     this.h++;
/* 289 */                     bool2 = true;
/*     */                     
/*     */                     break label58;
/*     */                   } 
/*     */                 } 
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 299 */         this.b.end();
/*     */         
/* 301 */         if (bool1 && !bool2)
/*     */         {
/*     */           
/* 304 */           this.h = Math.max(this.h, i);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final String getSystemName() {
/* 312 */     return "Quest";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void saveBasicLevelQuestValues() {
/* 320 */     if (this.d) {
/* 321 */       a.e("failed to save quests progress", new Object[] { new RuntimeException("saveBasicLevelQuestValues() already called") });
/*     */       return;
/*     */     } 
/* 324 */     this.d = true;
/*     */     
/* 326 */     ProgressPrefs.i();
/* 327 */     for (byte b = 0; b < this.b.size; b++) {
/*     */       QuestEntry questEntry;
/* 329 */       if (QuestEntry.a(questEntry = ((QuestEntry[])this.b.items)[b]) instanceof BasicLevelQuest) {
/*     */         BasicLevelQuest basicLevelQuest;
/* 331 */         if (!(basicLevelQuest = (BasicLevelQuest)QuestEntry.a(questEntry)).a.isDuringGame()) {
/*     */           
/* 333 */           basicLevelQuest.a.setSavedValue((long)basicLevelQuest.getValue());
/*     */         } else {
/*     */           
/* 336 */           basicLevelQuest.a.setSavedValue((long)StrictMath.max(basicLevelQuest.getValue(), basicLevelQuest.a.getSavedValue()));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final void dispose() {
/* 344 */     this.b.clear();
/* 345 */     this.c.clear();
/* 346 */     this.f = null;
/*     */     
/* 348 */     super.dispose();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class DelayedQuestRemoveEntry
/*     */   {
/*     */     private QuestSystem.Quest a;
/*     */ 
/*     */     
/*     */     private float b;
/*     */ 
/*     */ 
/*     */     
/*     */     private DelayedQuestRemoveEntry() {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class QuestEntry
/*     */   {
/*     */     private QuestSystem.Quest a;
/*     */ 
/*     */     
/*     */     private QuestList.QuestListItem b;
/*     */ 
/*     */     
/*     */     private boolean c;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class RegularQuest
/*     */     implements Quest
/*     */   {
/*     */     protected final String b;
/*     */ 
/*     */     
/*     */     protected final String c;
/*     */ 
/*     */     
/*     */     protected final double d;
/*     */ 
/*     */     
/*     */     protected final Array<ItemStack> e;
/*     */ 
/*     */     
/* 396 */     private double a = -1.0D;
/*     */     
/*     */     private GameSystemProvider g;
/* 399 */     protected static final StringBuilder f = new StringBuilder();
/*     */ 
/*     */     
/*     */     public RegularQuest(String param1String, CharSequence param1CharSequence, double param1Double, Array<ItemStack> param1Array, GameSystemProvider param1GameSystemProvider) {
/* 403 */       this.b = param1String;
/* 404 */       this.c = param1CharSequence.toString();
/* 405 */       this.e = param1Array;
/* 406 */       this.d = param1Double;
/*     */       
/* 408 */       this.g = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract double getValue();
/*     */     
/*     */     public String getTitle() {
/* 415 */       return this.c;
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 420 */       double d = getValue();
/* 421 */       if (this.a != d) {
/*     */         QuestList.QuestListItem questListItem;
/* 423 */         if ((questListItem = this.g._quest.getListItem(this)) != null) {
/* 424 */           f.setLength(0);
/* 425 */           f.append(this.c);
/* 426 */           if (this.d > 1.0D) {
/* 427 */             f.append(' ').append((long)StrictMath.min(d, this.d)).append('/').append((long)this.d);
/*     */           }
/* 429 */           questListItem.setText((CharSequence)f);
/*     */         } 
/*     */         
/* 432 */         this.a = d;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isCompleted() {
/* 438 */       return (getValue() >= this.d);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BasicLevelQuest
/*     */     extends RegularQuest {
/*     */     private BasicLevel g;
/*     */     protected final BasicLevelQuestConfig a;
/*     */     private GameSystemProvider h;
/* 447 */     private double i = -1.0D;
/*     */     
/*     */     public BasicLevelQuest(BasicLevel param1BasicLevel, BasicLevelQuestConfig param1BasicLevelQuestConfig, GameSystemProvider param1GameSystemProvider) {
/* 450 */       super(param1BasicLevelQuestConfig.getId(), param1BasicLevelQuestConfig.getTitle(false, true), param1BasicLevelQuestConfig.getRequiredValue(param1GameSystemProvider.gameValue.getSnapshot()), param1BasicLevelQuestConfig.getPrizes(param1GameSystemProvider.gameValue.getSnapshot()), param1GameSystemProvider);
/*     */       
/* 452 */       this.g = param1BasicLevel;
/* 453 */       this.a = param1BasicLevelQuestConfig;
/*     */       
/* 455 */       this.h = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue() {
/* 460 */       if (this.a.isDuringGame()) {
/* 461 */         return this.h.statistics.getCurrentGameStatistic(this.a.statisticsType);
/*     */       }
/* 463 */       return this.a.getSavedValue() + this.h.statistics.getCurrentGameStatistic(this.a.statisticsType);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update() {
/* 469 */       double d = getValue();
/* 470 */       if (this.i != d) {
/*     */         QuestList.QuestListItem questListItem;
/* 472 */         if ((questListItem = this.h._quest.getListItem(this)) != null) {
/* 473 */           f.setLength(0);
/* 474 */           f.append(this.c);
/* 475 */           if (this.d > 1.0D) {
/* 476 */             f.append(' ').append(this.a.formatValueForUiWithRequiredValue((long)StrictMath.min(d, this.d), this.d, true));
/*     */           }
/* 478 */           questListItem.setText((CharSequence)f);
/*     */         } 
/*     */         
/* 481 */         this.i = d;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void onCompletion() {
/* 487 */       this.h._quest.getListItem(this);
/*     */       
/* 489 */       this.h.gameState.addCompletedQuest(this.b);
/*     */       IssuedItems issuedItems;
/* 491 */       (issuedItems = new IssuedItems(IssuedItems.IssueReason.QUEST, Game.getTimestampSeconds())).items.addAll(this.e);
/*     */       int i;
/* 493 */       if ((i = this.a.getExtraDustInEndless(this.h.gameValue)) > 0 && DifficultyMode.isEndless(this.h.gameState.difficultyMode)) {
/* 494 */         issuedItems.items.add(new ItemStack((Item)Item.D.BIT_DUST, i));
/*     */       }
/* 496 */       issuedItems.questBasicLevel = this.g.name;
/* 497 */       issuedItems.questId = this.b;
/*     */       
/* 499 */       this.h.gameState.addCompletedQuestIssuedPrizes(issuedItems, 512.0F, Game.i.settingsManager.getScaledViewportHeight() - 240.0F, 16);
/*     */ 
/*     */       
/* 502 */       for (byte b = 0; b < this.e.size; b++) {
/* 503 */         if (((ItemStack)this.e.get(b)).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 504 */           QuestSystem.a(this.h._quest, ((ItemStack)this.e.get(b)).getCount());
/* 505 */           QuestSystem.a(this.h._quest);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BasicLevelWaveQuest
/*     */     extends RegularQuest
/*     */   {
/*     */     private final BasicLevel.WaveQuest a;
/*     */     private final BasicLevel g;
/*     */     private final GameSystemProvider h;
/* 517 */     private double i = -1.0D;
/*     */     
/*     */     public BasicLevelWaveQuest(BasicLevel param1BasicLevel, BasicLevel.WaveQuest param1WaveQuest, GameSystemProvider param1GameSystemProvider) {
/* 520 */       super(param1WaveQuest.id, Game.i.localeManager.i18n.get("defeat_waves"), param1WaveQuest.waves, param1WaveQuest.prizes, param1GameSystemProvider);
/*     */       
/* 522 */       this.g = param1BasicLevel;
/* 523 */       this.a = param1WaveQuest;
/*     */       
/* 525 */       this.h = param1GameSystemProvider;
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue() {
/* 530 */       return this.h.wave.getCompletedWavesCount();
/*     */     }
/*     */ 
/*     */     
/*     */     public void update() {
/* 535 */       double d = getValue();
/* 536 */       if (this.i != d) {
/*     */         QuestList.QuestListItem questListItem;
/* 538 */         if ((questListItem = this.h._quest.getListItem(this)) != null) {
/* 539 */           f.setLength(0);
/* 540 */           f.append(this.c);
/* 541 */           f.append(" [#90A4AE]").append((int)StrictMath.min(d, this.d)).append("[] / [#FFFFFF]").append((int)this.d).append("[]");
/* 542 */           questListItem.setText((CharSequence)f);
/*     */         } 
/*     */         
/* 545 */         this.i = d;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void onCompletion() {
/* 551 */       this.h._quest.getListItem(this);
/*     */       
/* 553 */       this.h.gameState.addCompletedQuest(this.a.id);
/*     */       
/*     */       IssuedItems issuedItems;
/* 556 */       (issuedItems = new IssuedItems(IssuedItems.IssueReason.WAVE_QUEST, Game.getTimestampSeconds())).items.addAll(this.a.prizes);
/* 557 */       issuedItems.waveQuestBasicLevel = this.g.name;
/* 558 */       issuedItems.waveQuestId = this.a.id;
/*     */       
/* 560 */       this.h.gameState.addCompletedQuestIssuedPrizes(issuedItems, 512.0F, Game.i.settingsManager.getScaledViewportHeight() - 240.0F, 16);
/*     */ 
/*     */       
/* 563 */       for (byte b = 0; b < this.a.prizes.size; b++) {
/* 564 */         if (((ItemStack)this.a.prizes.get(b)).getItem() instanceof com.prineside.tdi2.items.StarItem) {
/* 565 */           QuestSystem.a(this.h._quest, ((ItemStack)this.a.prizes.get(b)).getCount());
/* 566 */           QuestSystem.a(this.h._quest);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public static interface Quest {
/*     */     String getTitle();
/*     */     
/*     */     void update();
/*     */     
/*     */     boolean isCompleted();
/*     */     
/*     */     void onCompletion();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\QuestSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */