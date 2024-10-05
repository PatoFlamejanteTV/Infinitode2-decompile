/*     */ package com.prineside.tdi2.managers;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.prineside.tdi2.BasicLevel;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.IssuedItems;
/*     */ import com.prineside.tdi2.ItemStack;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.enums.AchievementType;
/*     */ import com.prineside.tdi2.enums.ItemType;
/*     */ import com.prineside.tdi2.enums.StaticSoundType;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*     */ import com.prineside.tdi2.scene2d.utils.Drawable;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.shared.Notifications;
/*     */ import com.prineside.tdi2.utils.MaterialColor;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ @REGS(serializer = AchievementManager.Serializer.class)
/*     */ public class AchievementManager extends Manager.ManagerAdapter {
/*  26 */   private static final TLog a = TLog.forClass(AchievementManager.class);
/*     */   
/*     */   public static class Serializer extends SingletonSerializer<AchievementManager> {
/*     */     public AchievementManager read() {
/*  30 */       return Game.i.achievementManager;
/*     */     } }
/*     */   
/*  33 */   public AchievementConfig[] configs = new AchievementConfig[AchievementType.values.length];
/*     */   
/*  35 */   private static final String[] b = new String[] { "0.1", "0.2", "0.3", "0.4" };
/*  36 */   private static final String[] c = new String[] { "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7", "1.8" };
/*  37 */   private static final String[] d = new String[] { "2.1", "2.2", "2.3", "2.4", "2.5", "2.6", "2.7", "2.8" };
/*  38 */   private static final String[] e = new String[] { "3.1", "3.2", "3.3", "3.4", "3.5", "3.6", "3.7", "3.8" };
/*  39 */   private static final String[] f = new String[] { "4.1", "4.2", "4.3", "4.4", "4.5", "4.6", "4.7", "4.8" };
/*  40 */   private static final String[] g = new String[] { "5.1", "5.2", "5.3", "5.4", "5.5", "5.6", "5.7", "5.8" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setup() {
/*     */     JsonValue jsonValue;
/*  48 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(Gdx.files.internal("res/achievements.json"))).iterator(); jsonIterator.hasNext(); ) {
/*  49 */       JsonValue jsonValue1; AchievementType achievementType = AchievementType.valueOf((jsonValue1 = jsonIterator.next()).name);
/*     */       AchievementConfig achievementConfig;
/*  51 */       (achievementConfig = new AchievementConfig()).required = jsonValue1.getInt("required", 1);
/*  52 */       achievementConfig.hidden = jsonValue1.getBoolean("hidden", false);
/*  53 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator1 = jsonValue1.get("rewards").iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue2 = jsonIterator1.next();
/*  54 */         achievementConfig.rewards.add(ItemStack.fromJson(jsonValue2)); }
/*     */       
/*  56 */       this.configs[achievementType.ordinal()] = achievementConfig;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isRedeemed(AchievementType paramAchievementType) {
/*  61 */     return (ProgressPrefs.i()).achievement.isRedeemed(paramAchievementType);
/*     */   }
/*     */   
/*     */   public CharSequence getName(AchievementType paramAchievementType) {
/*  65 */     String str = "achievement_name_" + paramAchievementType.name();
/*  66 */     return Game.i.localeManager.i18n.get(str);
/*     */   }
/*     */   
/*     */   public CharSequence getDescription(AchievementType paramAchievementType) {
/*  70 */     String str = "achievement_description_" + paramAchievementType.name();
/*  71 */     int i = (this.configs[paramAchievementType.ordinal()]).required;
/*  72 */     return Game.i.localeManager.i18n.format(str, new Object[] { Integer.valueOf(i) });
/*     */   }
/*     */   
/*     */   public void setProgress(AchievementType paramAchievementType, int paramInt) {
/*  76 */     if (Config.isHeadless())
/*  77 */       return;  if (Config.isModdingMode())
/*  78 */       return;  if (Game.i.isInMainThread()) {
/*     */       ProgressPrefs progressPrefs;
/*     */       
/*  81 */       if ((progressPrefs = ProgressPrefs.i()).achievement.getProgress(paramAchievementType) < paramInt) {
/*     */         
/*  83 */         int i = (this.configs[paramAchievementType.ordinal()]).required;
/*  84 */         if (progressPrefs.achievement.getProgress(paramAchievementType) < i && paramInt >= i && Game.isLoaded()) {
/*     */           
/*  86 */           CharSequence charSequence = getName(paramAchievementType);
/*  87 */           charSequence = Game.i.localeManager.i18n.format("achievement_complete", new Object[] { charSequence });
/*  88 */           Notifications.i().add(charSequence, (Drawable)Game.i.assetManager.getDrawable("icon-trophy"), MaterialColor.LIGHT_GREEN.P800, StaticSoundType.SUCCESS);
/*     */           
/*  90 */           Game.i.actionResolver.unlockAchievement(paramAchievementType);
/*     */         } 
/*  92 */         progressPrefs.achievement.setProgress(paramAchievementType, paramInt);
/*  93 */         progressPrefs.requireSave();
/*     */       }  return;
/*     */     } 
/*  96 */     a.e("skipped setProgress for " + paramAchievementType + " - not on main thread", new Object[0]);
/*     */   } public void syncAchievementsWithPlatform() {
/*     */     AchievementType[] arrayOfAchievementType;
/*     */     int i;
/*     */     byte b;
/* 101 */     for (i = (arrayOfAchievementType = AchievementType.values).length, b = 0; b < i; ) { AchievementType achievementType = arrayOfAchievementType[b];
/* 102 */       if (isRequirementMet(achievementType))
/* 103 */         Game.i.actionResolver.unlockAchievement(achievementType); 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void redeem(AchievementType paramAchievementType) {
/* 109 */     ProgressPrefs progressPrefs = ProgressPrefs.i();
/* 110 */     if (!isRequirementMet(paramAchievementType) || progressPrefs.achievement.isRedeemed(paramAchievementType)) {
/*     */       return;
/*     */     }
/*     */     
/* 114 */     IssuedItems issuedItems = new IssuedItems(IssuedItems.IssueReason.ACHIEVEMENT, Game.getTimestampSeconds());
/*     */     
/*     */     Array array;
/* 117 */     (array = new Array(ItemStack.class)).addAll((this.configs[paramAchievementType.ordinal()]).rewards);
/* 118 */     issuedItems.items.addAll(array);
/* 119 */     issuedItems.achievementType = paramAchievementType;
/* 120 */     Game.i.progressManager.addIssuedPrizes(issuedItems, true);
/* 121 */     Game.i.progressManager.addItemArray(issuedItems.items, "achievement_redeem");
/* 122 */     Game.i.progressManager.showNewlyIssuedPrizesPopup();
/*     */     
/* 124 */     progressPrefs.achievement.setRedeemed(paramAchievementType, true);
/* 125 */     progressPrefs.requireSave();
/*     */   }
/*     */   
/*     */   public int countAchievementsToRedeem() {
/* 129 */     byte b1 = 0;
/* 130 */     ProgressPrefs progressPrefs = ProgressPrefs.i(); AchievementType[] arrayOfAchievementType; int i; byte b2;
/* 131 */     for (i = (arrayOfAchievementType = AchievementType.values).length, b2 = 0; b2 < i; ) { AchievementType achievementType = arrayOfAchievementType[b2];
/* 132 */       if (Game.i.achievementManager.isRequirementMet(achievementType) && !progressPrefs.achievement.isRedeemed(achievementType)) {
/* 133 */         b1++;
/*     */       }
/*     */       b2++; }
/*     */     
/* 137 */     return b1;
/*     */   }
/*     */   
/*     */   public boolean isRequirementMet(AchievementType paramAchievementType) {
/* 141 */     return ((ProgressPrefs.i()).achievement.getProgress(paramAchievementType) >= (this.configs[paramAchievementType.ordinal()]).required);
/*     */   }
/*     */   
/*     */   public int getCurrentProgress(AchievementType paramAchievementType) {
/* 145 */     return (ProgressPrefs.i()).achievement.getProgress(paramAchievementType);
/*     */   }
/*     */   
/*     */   private void a(AchievementType paramAchievementType, String[] paramArrayOfString) {
/* 149 */     byte b1 = 0; int i; byte b2;
/* 150 */     for (i = (paramArrayOfString = paramArrayOfString).length, b2 = 0; b2 < i; ) { String str = paramArrayOfString[b2];
/*     */       BasicLevel basicLevel;
/* 152 */       if ((basicLevel = Game.i.basicLevelManager.getLevel(str)) == null) {
/* 153 */         throw new IllegalStateException("handleCompletedLevels - level " + str + " not found");
/*     */       }
/* 155 */       if (Game.i.basicLevelManager.getGainedStarsOnLevel(basicLevel) >= 3)
/* 156 */         b1++; 
/*     */       b2++; }
/*     */     
/* 159 */     setProgress(paramAchievementType, b1);
/*     */   }
/*     */   
/*     */   public void updateGlobal() {
/* 163 */     if (Config.isModdingMode()) {
/*     */       return;
/*     */     }
/* 166 */     a(AchievementType.TUTORIALS_COMPLETE, b);
/*     */ 
/*     */     
/* 169 */     a(AchievementType.STAGE_1_COMPLETE, c);
/* 170 */     a(AchievementType.STAGE_2_COMPLETE, d);
/* 171 */     a(AchievementType.STAGE_3_COMPLETE, e);
/* 172 */     a(AchievementType.STAGE_4_COMPLETE, f);
/* 173 */     a(AchievementType.STAGE_5_COMPLETE, g);
/*     */ 
/*     */     
/* 176 */     setProgress(AchievementType.UNLOCK_ALL_TROPHIES, (Game.i.progressManager.getItemsByType(ItemType.TROPHY)).size);
/*     */ 
/*     */     
/* 179 */     setProgress(AchievementType.MILLION_PAPERS, (int)Game.i.statisticsManager.getAllTime(StatisticsType.GPG));
/*     */ 
/*     */     
/* 182 */     setProgress(AchievementType.KILL_MILLION_ENEMIES, (int)Game.i.statisticsManager.getAllTime(StatisticsType.EK));
/* 183 */     setProgress(AchievementType.KILL_TEN_MILLION_ENEMIES, (int)Game.i.statisticsManager.getAllTime(StatisticsType.EK));
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose() {}
/*     */ 
/*     */   
/*     */   public static class AchievementConfig
/*     */   {
/* 192 */     public Array<ItemStack> rewards = new Array(ItemStack.class);
/*     */     public int required;
/*     */     public boolean hidden;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\AchievementManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */