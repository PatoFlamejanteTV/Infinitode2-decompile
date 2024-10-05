/*    */ package com.prineside.tdi2.managers.preferences.categories;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Threads;
/*    */ import com.prineside.tdi2.managers.preferences.PrefCategory;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Achievement;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Auth;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_BasicLevel;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Custom;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_DailyQuest;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Enemy;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Inventory;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Message;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Progress;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Purchase;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Research;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_SecretCode;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_Statistics;
/*    */ import com.prineside.tdi2.managers.preferences.categories.progress.PP_UserMaps;
/*    */ import com.prineside.tdi2.utils.ObjectConsumer;
/*    */ 
/*    */ 
/*    */ public final class ProgressPrefs
/*    */   extends PrefCategory
/*    */ {
/*    */   public static ProgressPrefs i() {
/* 29 */     return Game.i.preferencesManager.getProgressPrefs();
/*    */   }
/*    */ 
/*    */   
/* 33 */   public final PP_Achievement achievement = new PP_Achievement();
/* 34 */   public final PP_Auth auth = new PP_Auth();
/* 35 */   public final PP_BasicLevel basicLevel = new PP_BasicLevel();
/* 36 */   public final PP_DailyQuest dailyQuest = new PP_DailyQuest();
/* 37 */   public final PP_Enemy enemy = new PP_Enemy();
/* 38 */   public final PP_Message message = new PP_Message();
/* 39 */   public final PP_Progress progress = new PP_Progress();
/* 40 */   public final PP_Inventory inventory = new PP_Inventory();
/* 41 */   public final PP_Purchase purchase = new PP_Purchase();
/* 42 */   public final PP_Research research = new PP_Research();
/* 43 */   public final PP_SecretCode secretCode = new PP_SecretCode();
/* 44 */   public final PP_Statistics statistics = new PP_Statistics();
/* 45 */   public final PP_UserMaps userMaps = new PP_UserMaps();
/* 46 */   public final PP_Custom custom = new PP_Custom();
/*    */   
/* 48 */   public final PrefSubcategory[] all = new PrefSubcategory[] { (PrefSubcategory)this.achievement, (PrefSubcategory)this.auth, (PrefSubcategory)this.basicLevel, (PrefSubcategory)this.dailyQuest, (PrefSubcategory)this.enemy, (PrefSubcategory)this.message, (PrefSubcategory)this.progress, (PrefSubcategory)this.inventory, (PrefSubcategory)this.purchase, (PrefSubcategory)this.research, (PrefSubcategory)this.secretCode, (PrefSubcategory)this.statistics, (PrefSubcategory)this.userMaps, (PrefSubcategory)this.custom };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final void load(PrefMap paramPrefMap) {
/*    */     PrefSubcategory[] arrayOfPrefSubcategory;
/*    */     int i;
/*    */     byte b;
/* 67 */     for (i = (arrayOfPrefSubcategory = this.all).length, b = 0; b < i; b++) {
/* 68 */       PrefSubcategory prefSubcategory; (prefSubcategory = arrayOfPrefSubcategory[b]).load(paramPrefMap);
/*    */     } 
/*    */   } public final void save(PrefMap paramPrefMap) {
/*    */     PrefSubcategory[] arrayOfPrefSubcategory;
/*    */     int i;
/*    */     byte b;
/* 74 */     for (i = (arrayOfPrefSubcategory = this.all).length, b = 0; b < i; b++) {
/* 75 */       PrefSubcategory prefSubcategory; (prefSubcategory = arrayOfPrefSubcategory[b]).save(paramPrefMap);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final void saveAsync(PrefMap paramPrefMap, Runnable paramRunnable, ObjectConsumer<Exception> paramObjectConsumer) {
/* 81 */     Threads.i().asyncConcurrentLoop((Object[])this.all, 0, this.all.length, (paramInt, paramPrefSubcategory) -> paramPrefSubcategory.save(paramPrefMap), paramRunnable, paramObjectConsumer);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\ProgressPrefs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */