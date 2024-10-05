/*      */ package com.prineside.tdi2.systems;
/*      */ 
/*      */ import com.badlogic.gdx.math.MathUtils;
/*      */ import com.badlogic.gdx.math.RandomXS128;
/*      */ import com.badlogic.gdx.math.Vector2;
/*      */ import com.badlogic.gdx.utils.Array;
/*      */ import com.badlogic.gdx.utils.IntMap;
/*      */ import com.badlogic.gdx.utils.Null;
/*      */ import com.esotericsoftware.kryo.Kryo;
/*      */ import com.esotericsoftware.kryo.io.Input;
/*      */ import com.esotericsoftware.kryo.io.Output;
/*      */ import com.prineside.tdi2.Action;
/*      */ import com.prineside.tdi2.Config;
/*      */ import com.prineside.tdi2.Enemy;
/*      */ import com.prineside.tdi2.Game;
/*      */ import com.prineside.tdi2.GameSystem;
/*      */ import com.prineside.tdi2.Item;
/*      */ import com.prineside.tdi2.ItemStack;
/*      */ import com.prineside.tdi2.Miner;
/*      */ import com.prineside.tdi2.SerializableListener;
/*      */ import com.prineside.tdi2.actions.RewardingAdAction;
/*      */ import com.prineside.tdi2.enums.ActionType;
/*      */ import com.prineside.tdi2.enums.CaseType;
/*      */ import com.prineside.tdi2.enums.DifficultyMode;
/*      */ import com.prineside.tdi2.enums.EnemyType;
/*      */ import com.prineside.tdi2.enums.GameValueType;
/*      */ import com.prineside.tdi2.enums.MinerType;
/*      */ import com.prineside.tdi2.enums.RarityType;
/*      */ import com.prineside.tdi2.enums.ResourceType;
/*      */ import com.prineside.tdi2.enums.StatisticsType;
/*      */ import com.prineside.tdi2.events.Event;
/*      */ import com.prineside.tdi2.events.Listener;
/*      */ import com.prineside.tdi2.events.game.EnemyDie;
/*      */ import com.prineside.tdi2.events.game.EnemyLootAdd;
/*      */ import com.prineside.tdi2.events.game.MinerMineItem;
/*      */ import com.prineside.tdi2.events.game.MinerResourceChange;
/*      */ import com.prineside.tdi2.events.game.RewardingAdBecameAvailable;
/*      */ import com.prineside.tdi2.events.game.RewardingAdRegistered;
/*      */ import com.prineside.tdi2.items.CaseItem;
/*      */ import com.prineside.tdi2.managers.ItemManager;
/*      */ import com.prineside.tdi2.managers.ProgressManager;
/*      */ import com.prineside.tdi2.managers.PurchaseManager;
/*      */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*      */ import com.prineside.tdi2.utils.NAGS;
/*      */ import com.prineside.tdi2.utils.REGS;
/*      */ import com.prineside.tdi2.utils.logging.TLog;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @REGS
/*      */ public final class LootSystem
/*      */   extends GameSystem
/*      */ {
/*   55 */   private static final TLog a = TLog.forClass(LootSystem.class);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   78 */   public static final int[] REWARDING_AD_VIEW_BONUSES = new int[] { 5, 10, 15, 20, 25 };
/*      */ 
/*      */ 
/*      */   
/*      */   public static final float ENCRYPTED_CASE_GLOBAL_INTERVAL = 2400.0F;
/*      */ 
/*      */   
/*      */   public RandomXS128 random;
/*      */ 
/*      */   
/*      */   public ProgressManager.InventoryStatistics inventoryStatistics;
/*      */ 
/*      */   
/*      */   private ProgressManager.InventoryStatistics b;
/*      */ 
/*      */   
/*      */   private float c;
/*      */ 
/*      */   
/*   97 */   private float d = 60.0F;
/*   98 */   private float e = 1.0F;
/*   99 */   private int f = 0;
/*      */   private boolean g = false;
/*  101 */   private float h = 0.0F;
/*  102 */   private float i = 0.0F;
/*  103 */   private float j = 0.0F;
/*      */   
/*      */   private int k;
/*      */   private float l;
/*      */   private int m;
/*      */   private int n;
/*  109 */   private int o = 0;
/*      */   
/*      */   private float p;
/*      */   private int q;
/*  113 */   private int r = 0;
/*  114 */   private int s = 0;
/*  115 */   private int t = 0;
/*      */ 
/*      */   
/*  118 */   private int[] u = new int[0];
/*      */   private int v;
/*  120 */   private int w = -1;
/*      */ 
/*      */   
/*      */   private float x;
/*      */   
/*      */   private float y;
/*      */   
/*  127 */   public int[] lootFillsByRarity = new int[RarityType.values.length];
/*      */   
/*  129 */   private IntMap<Array<ItemStack>> z = new IntMap();
/*      */   
/*      */   public boolean minersMineOnlyLegendaries = false;
/*      */   
/*      */   public final void write(Kryo paramKryo, Output paramOutput) {
/*  134 */     super.write(paramKryo, paramOutput);
/*  135 */     paramKryo.writeObjectOrNull(paramOutput, this.random, RandomXS128.class);
/*  136 */     paramKryo.writeObject(paramOutput, this.inventoryStatistics);
/*  137 */     paramKryo.writeObject(paramOutput, this.b);
/*  138 */     paramOutput.writeFloat(this.c);
/*  139 */     paramOutput.writeFloat(this.d);
/*  140 */     paramOutput.writeFloat(this.e);
/*  141 */     paramOutput.writeVarInt(this.f, true);
/*  142 */     paramOutput.writeBoolean(this.g);
/*  143 */     paramOutput.writeFloat(this.h);
/*  144 */     paramOutput.writeFloat(this.i);
/*  145 */     paramOutput.writeFloat(this.j);
/*  146 */     paramOutput.writeInt(this.k);
/*  147 */     paramOutput.writeFloat(this.l);
/*  148 */     paramOutput.writeInt(this.m);
/*  149 */     paramOutput.writeInt(this.n);
/*  150 */     paramOutput.writeInt(this.o);
/*  151 */     paramOutput.writeFloat(this.p);
/*  152 */     paramOutput.writeVarInt(this.q, true);
/*  153 */     paramOutput.writeInt(this.r);
/*  154 */     paramOutput.writeInt(this.s);
/*  155 */     paramOutput.writeVarInt(this.t, true);
/*  156 */     paramKryo.writeObject(paramOutput, this.u);
/*  157 */     paramOutput.writeVarInt(this.v, true);
/*  158 */     paramOutput.writeInt(this.w);
/*  159 */     paramOutput.writeFloat(this.x);
/*  160 */     paramOutput.writeFloat(this.y);
/*  161 */     paramKryo.writeObject(paramOutput, this.lootFillsByRarity);
/*  162 */     paramKryo.writeObject(paramOutput, this.z);
/*  163 */     paramOutput.writeBoolean(this.minersMineOnlyLegendaries);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void read(Kryo paramKryo, Input paramInput) {
/*  168 */     super.read(paramKryo, paramInput);
/*  169 */     this.random = (RandomXS128)paramKryo.readObjectOrNull(paramInput, RandomXS128.class);
/*  170 */     this.inventoryStatistics = (ProgressManager.InventoryStatistics)paramKryo.readObject(paramInput, ProgressManager.InventoryStatistics.class);
/*  171 */     this.b = (ProgressManager.InventoryStatistics)paramKryo.readObject(paramInput, ProgressManager.InventoryStatistics.class);
/*  172 */     this.c = paramInput.readFloat();
/*  173 */     this.d = paramInput.readFloat();
/*  174 */     this.e = paramInput.readFloat();
/*  175 */     this.f = paramInput.readVarInt(true);
/*  176 */     this.g = paramInput.readBoolean();
/*  177 */     this.h = paramInput.readFloat();
/*  178 */     this.i = paramInput.readFloat();
/*  179 */     this.j = paramInput.readFloat();
/*  180 */     this.k = paramInput.readInt();
/*  181 */     this.l = paramInput.readFloat();
/*  182 */     this.m = paramInput.readInt();
/*  183 */     this.n = paramInput.readInt();
/*  184 */     this.o = paramInput.readInt();
/*  185 */     this.p = paramInput.readFloat();
/*  186 */     this.q = paramInput.readVarInt(true);
/*  187 */     this.r = paramInput.readInt();
/*  188 */     this.s = paramInput.readInt();
/*  189 */     this.t = paramInput.readVarInt(true);
/*  190 */     this.u = (int[])paramKryo.readObject(paramInput, int[].class);
/*  191 */     this.v = paramInput.readVarInt(true);
/*  192 */     this.w = paramInput.readInt();
/*  193 */     this.x = paramInput.readFloat();
/*  194 */     this.y = paramInput.readFloat();
/*  195 */     this.lootFillsByRarity = (int[])paramKryo.readObject(paramInput, int[].class);
/*  196 */     this.z = (IntMap<Array<ItemStack>>)paramKryo.readObject(paramInput, IntMap.class);
/*  197 */     this.minersMineOnlyLegendaries = paramInput.readBoolean();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean affectsGameState() {
/*  202 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float a(float paramFloat) {
/*  209 */     if (paramFloat <= 100.0F) {
/*  210 */       return 1.0F + (100.0F - paramFloat) * 0.01F;
/*      */     }
/*  212 */     if (paramFloat > 880.0F) {
/*      */       
/*  214 */       paramFloat = 1.0F - 1.0F / ((paramFloat - 880.0F) * 0.00125F + 1.0F);
/*  215 */       paramFloat = 880.0F + 720.0F * paramFloat;
/*      */     } 
/*  217 */     paramFloat = 1.0F + MathUtils.sin((paramFloat - 100.0F) * 0.002F - 1.5707964F) * 40.0F + 40.0F;
/*  218 */     return 1.0F / paramFloat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void setup() {
/*  260 */     if (Config.isHeadless())
/*      */       return; 
/*  262 */     if (this.S.gameState.getSeed() == -1L) {
/*  263 */       throw new IllegalStateException("GameStateSystem seed not set");
/*      */     }
/*      */     
/*  266 */     if (this.S.gameState.gameStartTimestamp == -1L) {
/*  267 */       throw new IllegalStateException("GameStartTimestamp not set");
/*      */     }
/*      */     
/*  270 */     if (this.inventoryStatistics == null) {
/*  271 */       throw new IllegalStateException("inventoryStatistics not set");
/*      */     }
/*      */     
/*  274 */     this.b = this.inventoryStatistics.cpy();
/*      */     
/*  276 */     long l = this.S.gameState.getSeed() + this.S.gameState.gameStartTimestamp * 29L;
/*  277 */     this.random = new RandomXS128(l);
/*      */ 
/*      */ 
/*      */     
/*  281 */     this.c = a(this.S.gameState.averageDifficulty);
/*  282 */     this.c *= 210.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  287 */     if (this.S.gameState.averageDifficulty < 100) {
/*      */       
/*  289 */       this.l = this.S.gameState.averageDifficulty * 0.01F;
/*  290 */       this.k = (int)(this.l * 125.0F);
/*  291 */     } else if (this.S.gameState.averageDifficulty > 100) {
/*      */       
/*  293 */       this.l = 1.0F + (this.S.gameState.averageDifficulty - 100) / 400.0F * 1.5F;
/*  294 */       this.k = (int)(this.l * 125.0F);
/*      */     } else {
/*      */       
/*  297 */       this.l = 1.0F;
/*  298 */       this.k = 125;
/*      */     } 
/*  300 */     this.l *= 0.15F;
/*      */ 
/*      */ 
/*      */     
/*  304 */     this.c *= 1.0F / ProgressManager.getDifficultyModePrizeMultiplier(this.S.gameState.difficultyMode);
/*      */     
/*  306 */     if (this.S.gameState.lootBoostEnabled)
/*      */     {
/*  308 */       this.c /= 1.5F;
/*      */     }
/*  310 */     if (this.S.gameState.rarityBoostEnabled)
/*      */     {
/*  312 */       this.e *= 1.5F;
/*      */     }
/*      */     
/*  315 */     if (this.c <= 0.0F) {
/*  316 */       throw new IllegalStateException("itemsStep is " + this.c);
/*      */     }
/*      */     
/*  319 */     b();
/*  320 */     c();
/*      */     
/*  322 */     this.S.events.getListeners(EnemyDie.class).addStateAffecting(new OnEnemyDie(this));
/*  323 */     this.S.events.getListeners(MinerResourceChange.class).addStateAffecting(new OnMinerResourceChange(this)).setDescription("Notifies loot system about the mined resource");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a() {
/*  329 */     this.f++;
/*  330 */     this.j = 0.0F;
/*  331 */     a.i("rewarding ad view registered, current multiplier: " + getRewardingAdsLootMultiplier(), new Object[0]);
/*      */     
/*  333 */     this.S.events.trigger((Event)new RewardingAdRegistered());
/*      */   }
/*      */   
/*      */   public final float getActiveSecondsPlayed() {
/*  337 */     return this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final void update(float paramFloat) {
/*  343 */     if (Config.isHeadless())
/*      */       return; 
/*  345 */     if (isRewardingAdAvailableByState() && Game.i.progressManager.isPremiumStatusActive()) {
/*      */       
/*  347 */       if (this.f == 2 || this.f == 4) {
/*  348 */         (ProgressPrefs.i()).progress.registerVideoWatched();
/*  349 */         ProgressPrefs.i().requireSave();
/*      */       } 
/*      */       
/*  352 */       a();
/*      */     } 
/*      */     
/*      */     StateSystem.ActionsArray actionsArray;
/*      */     
/*  357 */     if ((actionsArray = this.S.gameState.getCurrentUpdateActions()) != null) {
/*  358 */       for (byte b = 0; b < actionsArray.size; b++) {
/*      */         Action action;
/*  360 */         if ((action = actionsArray.actions[b]).getType() == ActionType.RA)
/*      */         {
/*      */           
/*  363 */           if (isRewardingAdAvailableByState()) {
/*  364 */             a();
/*  365 */             this.S.gameState.registerPlayerActivity();
/*      */           } else {
/*  367 */             a.e("failed to handle rewarding ads action - not available (" + getTimeToRewardingAds(false) + ")", new Object[0]);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  373 */     if (this.S.gameState.isGameRealTimePasses()) {
/*  374 */       float f = paramFloat * getRewardingAdsLootMultiplier() * 1.25F;
/*  375 */       if (this.S.statistics.getStatistic(StatisticsType.PT) - this.y < 30.0D && 
/*  376 */         this.S.gameState.updateNumber - this.S.gameState.getPxpLastActionFrame() < 3600) {
/*  377 */         this.h += f;
/*  378 */         this.i += paramFloat;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  386 */       this.j += f;
/*      */       
/*  388 */       if (!this.g && 
/*  389 */         isRewardingAdAvailableByState()) {
/*      */         
/*  391 */         this.S.events.trigger((Event)new RewardingAdBecameAvailable());
/*  392 */         this.g = true;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  412 */     this.x += paramFloat;
/*  413 */     if (this.x > 1.0F) {
/*  414 */       this.x--;
/*      */       
/*      */       int i;
/*      */       
/*  418 */       if ((i = this.S.gameValue.getIntValue(GameValueType.TOWER_FLAMETHROWER_A_INSTAKILL_BANK_TIME)) < 0) {
/*  419 */         i = 0;
/*  420 */       } else if (i > 900) {
/*      */         
/*  422 */         i = 900;
/*      */       } 
/*  424 */       if (this.u.length != i) {
/*      */         
/*  426 */         this.u = new int[i];
/*  427 */         this.v = 0;
/*      */       } 
/*      */       
/*  430 */       if (this.u.length > 0) {
/*      */         
/*  432 */         int k = this.S.gameState.calculatePrizeGreenPapers();
/*      */         
/*      */         int j;
/*  435 */         if ((j = (int)((j = (this.w < 0) ? 0 : (k - this.w)) * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.TOWER_FLAMETHROWER_A_INSTAKILL_PAPER_BANK))) < 0) {
/*  436 */           j = 0;
/*      */         }
/*  438 */         if (this.v == this.u.length) {
/*      */           
/*  440 */           System.arraycopy(this.u, 1, this.u, 0, this.u.length - 1);
/*  441 */           this.v--;
/*      */         } 
/*  443 */         this.u[this.v++] = j;
/*  444 */         this.w = k;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int getPapersFromFlamethrowerUltBank(int paramInt) {
/*  463 */     if (paramInt <= 0) {
/*  464 */       return 0;
/*      */     }
/*      */     
/*  467 */     int i = 0;
/*  468 */     for (byte b = 0; b < this.v; b++) {
/*  469 */       int j = this.u[b];
/*      */       int k;
/*  471 */       if ((k = paramInt - i) <= j) {
/*      */         
/*  473 */         this.u[b] = this.u[b] - k;
/*  474 */         i += k;
/*      */         
/*      */         break;
/*      */       } 
/*  478 */       i += j;
/*  479 */       this.u[b] = 0;
/*      */     } 
/*      */ 
/*      */     
/*  483 */     return i;
/*      */   }
/*      */   
/*      */   public final int getRewardingAdViews() {
/*  487 */     return this.f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final float getTimeToRewardingAds(boolean paramBoolean) {
/*  494 */     if (this.f >= 5) return -1.0F;
/*      */     
/*  496 */     if (!Config.isHeadless() && 
/*  497 */       !Game.i.purchaseManager.rewardingAdsAvailable()) return -1.0F;
/*      */ 
/*      */     
/*      */     float f;
/*  501 */     if ((f = 300.0F - this.j) < 0.0F) f = 0.0F;
/*      */     
/*  503 */     if (paramBoolean) {
/*  504 */       return Math.max(Game.i.purchaseManager.getSecondsTillAdIsReady(PurchaseManager.RewardingAdsType.LOOT_MULTIPLIER), f);
/*      */     }
/*  506 */     return f;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isRewardingAdAvailableInReality() {
/*  511 */     return (getTimeToRewardingAds(true) == 0.0F);
/*      */   }
/*      */   
/*      */   public final boolean isRewardingAdAvailableByState() {
/*  515 */     return (getTimeToRewardingAds(false) == 0.0F);
/*      */   }
/*      */   
/*      */   public final void viewRewardingAdAction() {
/*  519 */     if (isRewardingAdAvailableByState()) {
/*  520 */       this.S.gameState.pushActionNextUpdate((Action)new RewardingAdAction()); return;
/*      */     } 
/*  522 */     a.e("failed to add rewarding ads action - not available " + getTimeToRewardingAds(false), new Object[0]);
/*  523 */     a.i(this.f + "/5" + " " + Game.i.purchaseManager.rewardingAdsAvailable() + " " + Game.i.actionResolver.rewardAdsAvailable(), new Object[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public final float getRewardingAdsLootMultiplier() {
/*  528 */     float f = 1.0F;
/*  529 */     if (this.f > 0 && this.f <= REWARDING_AD_VIEW_BONUSES.length) {
/*  530 */       f = 1.0F + REWARDING_AD_VIEW_BONUSES[this.f - 1] * 0.01F;
/*      */     }
/*      */     
/*  533 */     return f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static float a(float paramFloat1, float paramFloat2, int paramInt) {
/*  540 */     paramFloat1 = (float)MathUtils.clamp(paramFloat1, 0.001D, 1.0D);
/*  541 */     return paramFloat2 + paramFloat2 * 0.15F * paramFloat1 * paramInt + ((float)StrictMath.pow(paramInt, 1.0D + paramFloat1 * 0.2D) - paramInt * (1.0F - paramFloat1)) * 0.075F * paramFloat2;
/*      */   }
/*      */   
/*      */   public static float calculateBaseLootCountGraph(float paramFloat) {
/*  545 */     if (paramFloat < 600.0F) {
/*      */       
/*  547 */       paramFloat *= 0.0016666667F;
/*      */       
/*  549 */       return (paramFloat = (1.0F - MathUtils.cos(paramFloat * 1.6F * 1.5707964F)) * 0.55555F) * 5.0F;
/*  550 */     }  if (paramFloat < 1800.0F) {
/*      */       
/*  552 */       paramFloat = (paramFloat - 600.0F) * 8.3333335E-4F;
/*  553 */       return 5.0F + paramFloat * 10.0F;
/*      */     } 
/*      */ 
/*      */     
/*  557 */     paramFloat = (float)StrictMath.pow(((paramFloat = (paramFloat - 600.0F - 1200.0F) * 8.3333335E-4F) + 0.2F), 0.75D) - 0.3F;
/*  558 */     return 15.0F + paramFloat * 10.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void main(String[] paramArrayOfString) {
/*  563 */     for (boolean bool = false; bool < 5400.0D; bool += true) {
/*  564 */       float f = calculateBaseLootCountGraph(bool);
/*  565 */       System.out.println((bool / 60.0F) + "," + f);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b() {
/*      */     float f1;
/*  726 */     if ((f1 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.LOOT_FREQUENCY)) <= 0.0F) {
/*      */       
/*  728 */       f2 = 3.1536E7F;
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  734 */       f2 = (f2 = a(f2 = (1.0F - (float)StrictMath.pow((f1 - 1.0F), 1.5D) * 0.031625F) * 0.5F, this.c, this.r)) / f1;
/*      */     } 
/*      */     
/*  737 */     this.d += f2;
/*      */     
/*  739 */     float f2 = f2;
/*      */     
/*  741 */     if (this.r == 0)
/*      */     {
/*  743 */       f2 *= 0.35F;
/*      */     }
/*  745 */     this.d += (this.random.nextFloat() - this.random.nextFloat()) * f2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void c() {
/*  753 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */     
/*  755 */     float f1 = this.k - this.k * 0.4F;
/*  756 */     float f2 = this.k + this.k * 0.4F;
/*      */     
/*  758 */     this.n = (int)(f1 + (f2 - f1) * this.random.nextFloat());
/*  759 */     if (this.n == 0) this.n = 1; 
/*      */   }
/*      */   
/*      */   public final boolean canGiveChests() {
/*  763 */     return this.S.gameState.canLootCases;
/*      */   }
/*      */   
/*  766 */   private static float A = 0.0F;
/*  767 */   private static int B = -1;
/*      */ 
/*      */   
/*      */   private static float a(int paramInt) {
/*  771 */     if (B == paramInt) {
/*  772 */       return A;
/*      */     }
/*  774 */     B = paramInt;
/*      */     
/*  776 */     if (paramInt < 100)
/*      */     {
/*  778 */       return A = paramInt * 0.01F;
/*      */     }
/*      */     
/*      */     float f;
/*  782 */     if ((f = paramInt) > 2000.0F) {
/*  783 */       f = 1.0F - 1.0F / ((f - 2000.0F) * 0.00375F + 1.0F);
/*  784 */       f = 2000.0F + 270.91F * f;
/*      */     } 
/*      */ 
/*      */     
/*  788 */     return A = (float)(1.0D + (f - 100.0D) / 400.0D * 0.85D - StrictMath.pow(f * 2.5E-4D, 3.5D) * 10.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public final ItemStack forceFillWithLoot(Enemy paramEnemy) {
/*  793 */     if (Config.isHeadless()) return new ItemStack((Item)Item.D.GREEN_PAPER, 1);
/*      */ 
/*      */ 
/*      */     
/*  797 */     float f1 = a(this.S.gameState.averageDifficulty);
/*  798 */     float f2 = this.h * f1;
/*      */     
/*  800 */     if (this.S.gameState.averageDifficulty < 100) {
/*      */       
/*  802 */       f1 = this.S.gameState.averageDifficulty / 100.0F * 0.35F;
/*  803 */     } else if (this.S.gameState.averageDifficulty < 150) {
/*      */       
/*  805 */       f1 = 0.35F + (this.S.gameState.averageDifficulty - 100) / 50.0F * 0.2F;
/*  806 */     } else if (this.S.gameState.averageDifficulty < 325) {
/*      */       
/*  808 */       f1 = 0.55F + (this.S.gameState.averageDifficulty - 150) / 175.0F * 0.15F;
/*  809 */     } else if (this.S.gameState.averageDifficulty < 500) {
/*      */       
/*  811 */       f1 = 0.7F + (this.S.gameState.averageDifficulty - 325) / 175.0F * 0.05F;
/*      */     } else {
/*      */       
/*  814 */       f1 = 0.75F + (this.S.gameState.averageDifficulty - 500) / 250.0F * 0.025F;
/*      */     } 
/*      */     
/*  817 */     float f3 = 0.0F;
/*      */ 
/*      */     
/*  820 */     if (f2 < 60.0F) {
/*  821 */       f1 *= 0.1F;
/*  822 */     } else if (f2 < 150.0F) {
/*  823 */       f1 *= 0.2F;
/*  824 */     } else if (f2 < 300.0F) {
/*  825 */       f1 *= 0.35F;
/*  826 */     } else if (f2 < 600.0F) {
/*  827 */       f1 *= 0.5F;
/*  828 */     } else if (f2 < 1200.0F) {
/*  829 */       f1 *= 0.65F;
/*  830 */     } else if (f2 < 1800.0F) {
/*  831 */       f1 *= 0.8F;
/*  832 */     } else if (f2 < 2400.0F) {
/*  833 */       f1 = f1;
/*  834 */     } else if (f2 < 3000.0F) {
/*  835 */       f1 *= 1.15F;
/*  836 */     } else if (f2 < 3600.0F) {
/*  837 */       f1 *= 1.3F;
/*      */     } else {
/*  839 */       f1 *= 1.4F;
/*      */     } 
/*      */     
/*  842 */     if (this.S.gameState.averageDifficulty <= 75 && f1 > 0.4F) {
/*  843 */       f1 = 0.4F;
/*  844 */     } else if (this.S.gameState.averageDifficulty <= 87 && f1 > 0.5F) {
/*  845 */       f1 = 0.5F;
/*  846 */     } else if (this.S.gameState.averageDifficulty <= 100 && f1 > 0.6F) {
/*  847 */       f1 = 0.6F;
/*  848 */     } else if (this.S.gameState.averageDifficulty <= 110 && f1 > 0.65F) {
/*  849 */       f1 = 0.65F;
/*  850 */     } else if (this.S.gameState.averageDifficulty <= 120 && f1 > 0.7F) {
/*  851 */       f1 = 0.7F;
/*  852 */     } else if (this.S.gameState.averageDifficulty <= 130 && f1 > 0.75F) {
/*  853 */       f1 = 0.75F;
/*  854 */     } else if (this.S.gameState.averageDifficulty <= 140 && f1 > 0.82F) {
/*  855 */       f1 = 0.82F;
/*  856 */     } else if (this.S.gameState.averageDifficulty <= 155 && f1 > 0.9F) {
/*  857 */       f1 = 0.9F;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  863 */     if ((f1 = (float)((f1 = f1 * this.e) * this.S.gameValue.getPercentValueAsMultiplier(GameValueType.LOOT_RARITY))) > 1.0F)
/*      */     {
/*  865 */       f3 = (float)(0.0D + StrictMath.pow((f1 - 1.0F), 0.8D) * 0.10000000149011612D);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  870 */     if (f1 > 1.0F) f1 = 1.0F; 
/*  871 */     if (f3 > f1) f3 = f1;
/*      */ 
/*      */     
/*  874 */     if ((f1 = f1 - f3) < 0.0F) f1 = 0.0F;
/*      */ 
/*      */ 
/*      */     
/*  878 */     if ((f2 = (f2 = StrictMath.abs(this.random.nextFloat() - this.random.nextFloat())) * 1.06F) > 1.0F) f2 = 1.0F;
/*      */ 
/*      */     
/*  881 */     RarityType rarityType = ProgressManager.getRarityFromQuality(f1 = f3 + f2 * f1);
/*  882 */     f3 = ProgressManager.globalQualityToRarityQualuty(f1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  892 */     float f4 = (float)((f4 = DifficultyMode.isEndless(this.S.gameState.difficultyMode) ? 0.5F : 0.0F) * ((this.S.gameValue.getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE) - 1.0D) * 0.4000000059604645D + 1.0D));
/*      */ 
/*      */     
/*  895 */     int i = 0;
/*  896 */     Array array = (this.S.gameState.getGameLootIssuedItems()).items;
/*  897 */     for (byte b1 = 0; b1 < array.size; b1++) {
/*      */       ItemStack itemStack1;
/*  899 */       if ((itemStack1 = (ItemStack)array.get(b1)).getItem() == Item.D.BIT_DUST) {
/*  900 */         i += itemStack1.getCount();
/*      */       }
/*      */     } 
/*  903 */     float f5 = 1.0F;
/*  904 */     for (byte b2 = 1; b2 <= 12; b2++) {
/*  905 */       if (i > this.q * b2) {
/*  906 */         f5 -= 0.05F;
/*      */       }
/*      */     } 
/*  909 */     f4 *= f5;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  916 */     ItemStack itemStack = ItemManager.generateItemByRarity(this.random, rarityType, f3, 0.5F, 0.0F, 0.25F, f4, 
/*      */ 
/*      */ 
/*      */         
/*  920 */         canGiveChests() ? 1.0F : 0.0F, 1.0F, 
/*      */         
/*  922 */         (f1 > 0.5F + this.random.nextFloat() * 0.5F), this.b);
/*      */ 
/*      */     
/*  925 */     this.b.countItem(itemStack.getItem(), itemStack.getCount());
/*  926 */     this.lootFillsByRarity[rarityType.ordinal()] = this.lootFillsByRarity[rarityType.ordinal()] + 1;
/*  927 */     addLoot(paramEnemy, itemStack.getItem(), itemStack.getCount());
/*      */     
/*  929 */     return itemStack;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void fillWithLoot(Enemy paramEnemy) {
/*  936 */     if (Config.isHeadless())
/*      */       return; 
/*  938 */     this.S.gameState.checkGameplayUpdateAllowed();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  945 */     if (this.S.wave.mode == WaveSystem.Mode.PREDEFINED) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  950 */     this.o++;
/*      */     
/*  952 */     float f1 = a(this.S.gameState.averageDifficulty);
/*  953 */     f1 = this.h * f1;
/*      */     
/*  955 */     boolean bool = canGiveChests();
/*      */ 
/*      */ 
/*      */     
/*  959 */     int i = 5;
/*      */     float f2;
/*  961 */     if ((f2 = (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.LOOT_FREQUENCY)) >= 10.0F) {
/*      */       
/*  963 */       i = 1;
/*  964 */     } else if (f2 >= 5.0F) {
/*  965 */       i = 2;
/*  966 */     } else if (f2 >= 2.5F) {
/*  967 */       i = 3;
/*  968 */     } else if (f2 >= 1.25F) {
/*  969 */       i = 4;
/*      */     } 
/*      */ 
/*      */     
/*  973 */     if (this.o % i == 0 || EnemyType.isBoss(paramEnemy.type)) {
/*      */ 
/*      */ 
/*      */       
/*  977 */       for (i = 0; i < 3 && 
/*  978 */         f1 >= this.d; i++) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  986 */         ItemStack itemStack = forceFillWithLoot(paramEnemy);
/*      */         
/*  988 */         this.r++;
/*  989 */         b();
/*      */         
/*  991 */         if (f1 >= this.d) {
/*      */ 
/*      */           
/*  994 */           addLoot(paramEnemy, itemStack.getItem(), itemStack.getCount());
/*      */           
/*  996 */           this.r++;
/*  997 */           b();
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       int j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1011 */       if ((j = (i = (int)(this.S.gameState.calculatePrizeGreenPapers() * this.l)) - this.m) >= this.n) {
/*      */         
/* 1013 */         addLoot(paramEnemy, (Item)Item.D.GREEN_PAPER, j);
/* 1014 */         this.m = i;
/* 1015 */         c();
/*      */       } 
/*      */     } 
/*      */     
/* 1019 */     if (this.o % 7 == 0 || EnemyType.isBoss(paramEnemy.type)) {
/*      */       float f;
/*      */       
/* 1022 */       if (this.s == 0) {
/* 1023 */         f = 1200.0F;
/* 1024 */       } else if (this.s == 1) {
/* 1025 */         f = 3600.0F;
/*      */       } else {
/* 1027 */         f = 10800.0F * (this.s - 1);
/*      */       } 
/*      */       
/* 1030 */       if (f1 > f) {
/* 1031 */         f2 = (f1 - f) / 1000000.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1036 */         if (this.random.nextFloat() < f2) {
/* 1037 */           addLoot(paramEnemy, (Item)Item.D.ACCELERATOR, 1);
/* 1038 */           this.s++;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1043 */     if (bool && (
/* 1044 */       this.o % 11 == 0 || EnemyType.isBoss(paramEnemy.type))) {
/*      */       
/* 1046 */       float f = MathUtils.floor(this.S.gameState.gameStartProgressSnapshot.statsPlayTimeCasesLoot / 2400.0F + 1.0F + this.t) * 2400.0F;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1054 */       if ((f2 = (float)(this.S.gameState.gameStartProgressSnapshot.statsPlayTimeCasesLoot + this.S.statistics.getStatistic(StatisticsType.PTCL))) > f) {
/* 1055 */         this.S.statistics.addStatistic(StatisticsType.EQCG, 1.0D);
/*      */         
/* 1057 */         CaseType caseType = Game.i.itemManager.getQueuedEncryptedCaseType(
/* 1058 */             MathUtils.round(this.S.gameState.gameStartProgressSnapshot.statsQueuedCasesGiven) + this.t);
/*      */ 
/*      */         
/* 1061 */         CaseItem caseItem = Item.D.F_CASE.create(caseType, true);
/*      */         
/* 1063 */         addLoot(paramEnemy, (Item)caseItem, 1);
/*      */         
/* 1065 */         this.t++;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1071 */     if (DifficultyMode.isEndless(this.S.gameState.difficultyMode)) {
/* 1072 */       if (this.p == 0.0F) {
/* 1073 */         this.p = d();
/*      */       }
/*      */       
/*      */       float f;
/* 1077 */       if ((f = (float)this.S.statistics.getStatistic(StatisticsType.PTEMWD)) > this.p) {
/* 1078 */         this.p += d();
/*      */         
/* 1080 */         f2 = (float)(this.S.statistics.getStatistic(StatisticsType.PT) / 60.0D);
/*      */         
/* 1082 */         if ((f1 = (float)(1.5D + Math.pow(f2, 1.2D) * 0.015D)) > 4.5F) f1 = 4.5F;
/*      */ 
/*      */         
/*      */         int k;
/* 1086 */         if ((k = this.S.gameState.averageDifficulty) > 4500) {
/* 1087 */           k = 4500;
/*      */         }
/*      */         float f3;
/* 1090 */         if ((f3 = 1.0F + (k - 100) / 4500.0F * 2.0F) < 0.1F) {
/* 1091 */           f3 = 0.1F;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1097 */         int j = (int)(f1 = f1 * f3);
/* 1098 */         if (this.random.nextFloat() < f1 - j) {
/* 1099 */           j++;
/*      */         }
/* 1101 */         if (j > 0) {
/* 1102 */           this.S.statistics.addStatistic(StatisticsType.BDFTPG, j);
/* 1103 */           addLoot(paramEnemy, (Item)Item.D.BIT_DUST, j);
/* 1104 */           this.q += j;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Null
/*      */   public final ItemStack addLoot(Enemy paramEnemy, Item paramItem, int paramInt) {
/*      */     EnemyLootAdd enemyLootAdd;
/* 1117 */     if ((enemyLootAdd = (EnemyLootAdd)this.S.events.trigger((Event)new EnemyLootAdd(paramItem, paramInt))).getCount() > 0) {
/* 1118 */       return paramEnemy.addLoot(paramItem, paramInt);
/*      */     }
/* 1120 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private float d() {
/* 1125 */     return 1500.0F / (float)this.S.gameValue.getPercentValueAsMultiplier(GameValueType.BIT_DUST_DROP_RATE) * (0.8F + this.random.nextFloat() * 0.4F);
/*      */   }
/*      */   
/*      */   public final int getLootSlots(MinerType paramMinerType) {
/* 1129 */     int i = this.S.gameValue.getIntValue(GameValueType.MINERS_LOOT_SLOTS);
/* 1130 */     switch (null.a[paramMinerType.ordinal()]) { case 1:
/* 1131 */         i += this.S.gameValue.getIntValue(GameValueType.MINER_SCALAR_LOOT_SLOTS); break;
/* 1132 */       case 2: i += this.S.gameValue.getIntValue(GameValueType.MINER_VECTOR_LOOT_SLOTS); break;
/* 1133 */       case 3: i += this.S.gameValue.getIntValue(GameValueType.MINER_MATRIX_LOOT_SLOTS); break;
/* 1134 */       case 4: i += this.S.gameValue.getIntValue(GameValueType.MINER_TENSOR_LOOT_SLOTS); break;
/* 1135 */       case 5: i += this.S.gameValue.getIntValue(GameValueType.MINER_INFIAR_LOOT_SLOTS); break; }
/*      */     
/* 1137 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static double a(Miner paramMiner, int paramInt) {
/*      */     double d1;
/* 1146 */     if (paramInt <= 10) {
/* 1147 */       d1 = 1.0D - paramInt * 0.07D;
/*      */     
/*      */     }
/* 1150 */     else if ((d1 = 0.3D - (paramInt - 10) * 0.05D) < 0.01D) {
/* 1151 */       d1 = 0.01D;
/*      */     } 
/*      */     
/* 1154 */     double d2 = d1 * 0.0025D;
/*      */     
/* 1156 */     float f2 = 15.0F + paramInt * 7.0F;
/*      */     
/*      */     float f1;
/* 1159 */     if ((f1 = paramMiner.existsTime - paramMiner.lastMinedItemTime) < f2) {
/* 1160 */       return 0.0D;
/*      */     }
/*      */     
/*      */     double d3;
/*      */     
/* 1165 */     return (d3 = d2 * (f1 - f2)) * 0.1D;
/*      */   }
/*      */   @Null
/*      */   public final Array<ItemStack> getSourceMinedItems(int paramInt1, int paramInt2) {
/* 1169 */     paramInt1 = (paramInt2 << 13) + paramInt1;
/* 1170 */     return (Array<ItemStack>)this.z.get(paramInt1, null);
/*      */   }
/*      */   
/*      */   public final Array<ItemStack> getOrCreateSourceMinedItems(int paramInt1, int paramInt2) {
/* 1174 */     this.S.gameState.checkGameplayUpdateAllowed();
/* 1175 */     paramInt1 = (paramInt2 << 13) + paramInt1;
/*      */     Array<ItemStack> array;
/* 1177 */     if ((array = (Array)this.z.get(paramInt1, null)) == null) {
/* 1178 */       array = new Array(true, 1, ItemStack.class);
/* 1179 */       this.z.put(paramInt1, array);
/*      */     } 
/* 1181 */     return array;
/*      */   }
/*      */   
/*      */   private static float a(RandomXS128 paramRandomXS128, ResourceType paramResourceType, int paramInt) {
/* 1185 */     float f = (paramResourceType.ordinal() + 1) * 0.2F;
/* 1186 */     if (paramInt == 0) {
/* 1187 */       f *= 0.7F;
/* 1188 */     } else if (paramInt == 1) {
/* 1189 */       f *= 0.85F;
/*      */     } 
/* 1191 */     f = f * 0.75F + f * StrictMath.abs(paramRandomXS128.nextFloat() - paramRandomXS128.nextFloat()) * 0.25F;
/*      */     
/* 1193 */     return StrictMath.abs(paramRandomXS128.nextFloat() - paramRandomXS128.nextFloat()) * f;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(Miner paramMiner, ResourceType paramResourceType, int paramInt, boolean paramBoolean) {
/* 1219 */     if (paramBoolean && paramInt > 0) {
/*      */       double d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1227 */       paramInt = (paramMiner.getTile().getY() << 13) + paramMiner.getTile().getX();
/*      */       
/* 1229 */       Array array = (Array)this.z.get(paramInt, null);
/* 1230 */       int i = 0;
/* 1231 */       if (array != null) {
/* 1232 */         i = array.size;
/*      */       }
/*      */       
/* 1235 */       if (this.random.nextDouble() > 0.1D) {
/* 1236 */         d = 0.0D;
/*      */       } else {
/* 1238 */         d = a(paramMiner, i);
/* 1239 */         if (this.minersMineOnlyLegendaries) {
/* 1240 */           d *= 0.5D;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1245 */       if (d != 0.0D && this.random.nextDouble() < d) {
/*      */         float f1;
/*      */ 
/*      */         
/* 1249 */         RarityType rarityType = ProgressManager.getRarityFromQuality(f1 = a(this.random, paramResourceType, i));
/* 1250 */         float f2 = ProgressManager.globalQualityToRarityQualuty(f1);
/* 1251 */         if (this.minersMineOnlyLegendaries) {
/* 1252 */           rarityType = RarityType.LEGENDARY;
/* 1253 */           f2 = this.random.nextFloat();
/*      */         } 
/* 1255 */         ItemStack itemStack = ItemManager.generateItemByRarity(this.random, rarityType, f2, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, false, this.b);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1270 */         MinerMineItem minerMineItem = new MinerMineItem(paramMiner, paramResourceType, itemStack, f1, rarityType, f2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1278 */         if (i >= getLootSlots(paramMiner.type)) {
/* 1279 */           minerMineItem.setCancelled(true);
/*      */         }
/* 1281 */         this.S.events.getListeners(MinerMineItem.class).trigger((Event)minerMineItem);
/*      */         
/* 1283 */         if (!minerMineItem.isCancelled()) {
/* 1284 */           paramMiner = minerMineItem.getMiner();
/* 1285 */           itemStack = minerMineItem.getItemStack();
/* 1286 */           if (minerMineItem.isCountTowardsInventoryStatistics()) {
/* 1287 */             this.b.countItem(itemStack.getItem(), itemStack.getCount());
/*      */           }
/*      */           
/* 1290 */           if (minerMineItem.isAddAndShowActualLoot()) {
/* 1291 */             Vector2 vector2 = new Vector2((paramMiner.getTile()).center);
/* 1292 */             if (this.S._input != null) this.S._input.cameraController.mapToStage(vector2); 
/* 1293 */             this.S.gameState.addLootIssuedPrizes(itemStack, vector2.x, vector2.y, 2);
/*      */           } 
/*      */           
/* 1296 */           if (minerMineItem.isAddToEmptyItemSlot()) {
/* 1297 */             if (array == null) {
/* 1298 */               array = new Array(true, 1, ItemStack.class);
/* 1299 */               this.z.put(paramInt, array);
/*      */             } 
/* 1301 */             array.add(itemStack);
/*      */           } 
/*      */         } 
/* 1304 */         paramMiner.lastMinedItemTime = paramMiner.existsTime;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public final boolean profileUpdate() {
/* 1310 */     return false;
/*      */   }
/*      */   
/*      */   public final String getSystemName() {
/* 1314 */     return "Loot";
/*      */   }
/*      */   
/*      */   @REGS
/*      */   public static final class OnEnemyDie extends SerializableListener<LootSystem> implements Listener<EnemyDie> { @NAGS
/* 1319 */     private final Vector2 b = new Vector2();
/*      */ 
/*      */ 
/*      */     
/*      */     public OnEnemyDie(LootSystem param1LootSystem) {
/* 1324 */       this.a = param1LootSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(EnemyDie param1EnemyDie) {
/*      */       Enemy enemy;
/* 1330 */       if ((enemy = param1EnemyDie.getLastDamage().getEnemy()).loot != null) {
/*      */         
/* 1332 */         this.b.set(enemy.getPosition());
/* 1333 */         if (((LootSystem)this.a).S._input != null) ((LootSystem)this.a).S._input.cameraController.mapToStage(this.b);
/*      */ 
/*      */         
/* 1336 */         float f = -enemy.loot.size * 96.0F * 0.5F + 48.0F;
/* 1337 */         GameStateSystem gameStateSystem = ((LootSystem)this.a).S.gameState;
/* 1338 */         for (byte b = 0; b < enemy.loot.size; b++) {
/* 1339 */           if (((ItemStack[])enemy.loot.items)[b] != null) {
/* 1340 */             gameStateSystem.addLootIssuedPrizes(((ItemStack[])enemy.loot.items)[b], this.b.x + f + 96.0F * b, this.b.y, 2);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 1345 */       LootSystem.a((LootSystem)this.a, (float)((LootSystem)this.a).S.statistics.getStatistic(StatisticsType.PT));
/*      */     }
/*      */     
/*      */     private OnEnemyDie() {} }
/*      */   
/*      */   @REGS
/*      */   public static final class OnMinerResourceChange extends SerializableListener<LootSystem> implements Listener<MinerResourceChange> { private OnMinerResourceChange() {}
/*      */     
/*      */     public OnMinerResourceChange(LootSystem param1LootSystem) {
/* 1354 */       this.a = param1LootSystem;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void handleEvent(MinerResourceChange param1MinerResourceChange) {
/* 1359 */       LootSystem.a((LootSystem)this.a, param1MinerResourceChange.getMiner(), param1MinerResourceChange.getResourceType(), param1MinerResourceChange.getDelta(), param1MinerResourceChange.isMined());
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\systems\LootSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */