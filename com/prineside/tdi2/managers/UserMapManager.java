/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.DelayedRemovalArray;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Gate;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.Item;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.MapPrestigeConfig;
/*     */ import com.prineside.tdi2.Tile;
/*     */ import com.prineside.tdi2.UserMap;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.BossType;
/*     */ import com.prineside.tdi2.enums.EnemyType;
/*     */ import com.prineside.tdi2.enums.GameValueType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.Dialog;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = UserMapManager.Serializer.class)
/*     */ public class UserMapManager extends Manager.ManagerAdapter {
/*  27 */   private static final TLog a = TLog.forClass(UserMapManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<UserMapManager> {
/*     */     public UserMapManager read() {
/*  31 */       return Game.i.userMapManager;
/*     */     } }
/*     */   
/*     */   public void prestigeSellMap(MapPrestigeConfig paramMapPrestigeConfig) {
/*     */     UserMap userMap;
/*  36 */     if ((userMap = Game.i.userMapManager.getUserMap(paramMapPrestigeConfig.userMapId)) == null) {
/*  37 */       Dialog.i().showAlert("Map not found");
/*     */       return;
/*     */     } 
/*  40 */     if (paramMapPrestigeConfig.getFinalPrestigeTokens() <= 0) {
/*  41 */       Dialog.i().showAlert("You will get no tokens");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  46 */     byte b1 = 0;
/*  47 */     byte b2 = 0;
/*     */     
/*  49 */     DelayedRemovalArray delayedRemovalArray1 = userMap.map.getAllTiles();
/*  50 */     for (byte b3 = 0; b3 < ((Array)delayedRemovalArray1).size; b3++) {
/*     */       Tile tile;
/*  52 */       if ((tile = ((Tile[])((Array)delayedRemovalArray1).items)[b3]).getPrestigeScore() > 0.0D) {
/*     */         
/*  54 */         b1++;
/*  55 */         if (Game.i.progressManager.removeItems((Item)Item.D.F_TILE.create(tile), 1))
/*  56 */           b2++; 
/*     */       } 
/*     */     } 
/*  59 */     DelayedRemovalArray delayedRemovalArray2 = userMap.map.getAllGates(); int i;
/*  60 */     for (i = 0; i < ((Array)delayedRemovalArray2).size; i++) {
/*     */       Gate gate;
/*  62 */       if ((gate = ((Gate[])((Array)delayedRemovalArray2).items)[i]).getPrestigeScore() > 0.0D) {
/*     */         
/*  64 */         b1++;
/*  65 */         if (Game.i.progressManager.removeItems((Item)Item.D.F_GATE.create(gate), 1)) {
/*  66 */           b2++;
/*     */         }
/*     */       } 
/*     */     } 
/*  70 */     a.i("map prestige: removed " + b2 + "/" + b1 + " map pieces", new Object[0]);
/*     */     
/*  72 */     i = paramMapPrestigeConfig.getFinalPrestigeTokens();
/*     */ 
/*     */     
/*  75 */     Game.i.progressManager.addItems((Item)Item.D.PRESTIGE_TOKEN, i, "map_prestige");
/*     */     
/*     */     IssuedItems issuedItems;
/*     */     
/*  79 */     (issuedItems = new IssuedItems(IssuedItems.IssueReason.MAP_PRESTIGE, Game.getTimestampSeconds())).mapPrestigeConfig = paramMapPrestigeConfig;
/*  80 */     issuedItems.items.add(new ItemStack((Item)Item.D.PRESTIGE_TOKEN, i));
/*  81 */     Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/*     */     
/*  83 */     removeUserMap(paramMapPrestigeConfig.userMapId);
/*     */     
/*  85 */     if (i >= 50)
/*     */     {
/*  87 */       Game.i.statisticsManager.registerDelta(StatisticsType.PMS, 1.0D);
/*     */     }
/*  89 */     Game.i.statisticsManager.registerDelta(StatisticsType.PPG, i);
/*     */     
/*  91 */     Game.i.achievementManager.setProgress(AchievementType.PRESTIGE, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public BossType[] getDefaultBosses() {
/*  96 */     Array array = new Array(BossType.class);
/*     */     
/*  98 */     if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.BROOT_BOSS, false)) {
/*  99 */       array.add(BossType.BROOT);
/*     */     }
/* 101 */     if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.SNAKE_BOSS_HEAD, false)) {
/* 102 */       array.add(BossType.SNAKE);
/*     */     }
/* 104 */     if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.CONSTRUCTOR_BOSS, false)) {
/* 105 */       array.add(BossType.CONSTRUCTOR);
/*     */     }
/* 107 */     if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.MOBCHAIN_BOSS_HEAD, false)) {
/* 108 */       array.add(BossType.MOBCHAIN);
/*     */     }
/* 110 */     if (!Game.i.enemyManager.isEnemyTypeNewForPlayer(EnemyType.METAPHOR_BOSS, false)) {
/* 111 */       array.add(BossType.METAPHOR);
/*     */     }
/*     */     
/* 114 */     if (array.size != 0) {
/* 115 */       return (BossType[])array.toArray();
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMapEditorAvailable() {
/* 122 */     return Game.i.gameValueManager.getSnapshot().getBooleanValue(GameValueType.MAP_EDITOR);
/*     */   }
/*     */   
/*     */   public int getMaxMapSize() {
/* 126 */     return Game.i.gameValueManager.getSnapshot().getIntValue(GameValueType.USER_MAP_MAX_SIZE);
/*     */   }
/*     */   
/*     */   public void rename(UserMap paramUserMap, String paramString) {
/* 130 */     if (paramUserMap.name.equals(paramString))
/*     */       return; 
/* 132 */     paramUserMap.name = paramString;
/* 133 */     ProgressPrefs.i().requireSave();
/*     */   }
/*     */   
/*     */   public Array<UserMap> getUserMaps() {
/* 137 */     return (ProgressPrefs.i()).userMaps.getUserMapsOrdered();
/*     */   }
/*     */   
/*     */   public UserMap getUserMap(String paramString) {
/* 141 */     Array array = (ProgressPrefs.i()).userMaps.getUserMapsOrdered();
/* 142 */     for (byte b = 0; b < array.size; b++) {
/* 143 */       if ((((UserMap[])array.items)[b]).id.equals(paramString)) {
/* 144 */         return (UserMap)array.get(b);
/*     */       }
/*     */     } 
/*     */     
/* 148 */     return null;
/*     */   }
/*     */   
/*     */   public UserMap addUserMap(String paramString) {
/* 152 */     UserMap userMap = new UserMap(paramString);
/* 153 */     (ProgressPrefs.i()).userMaps.addUserMap(userMap);
/* 154 */     ProgressPrefs.i().requireSave();
/*     */     
/* 156 */     return userMap;
/*     */   }
/*     */   
/*     */   public void removeUserMap(String paramString) {
/* 160 */     (ProgressPrefs.i()).userMaps.removeUserMap(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\UserMapManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */