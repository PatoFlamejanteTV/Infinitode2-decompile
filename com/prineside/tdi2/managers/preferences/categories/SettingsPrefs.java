/*    */ package com.prineside.tdi2.managers.preferences.categories;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Threads;
/*    */ import com.prineside.tdi2.managers.preferences.PrefCategory;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Auth;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Enemy;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Locale;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Music;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Rating;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Replay;
/*    */ import com.prineside.tdi2.managers.preferences.categories.settings.SP_Settings;
/*    */ import com.prineside.tdi2.utils.ObjectConsumer;
/*    */ 
/*    */ 
/*    */ public final class SettingsPrefs
/*    */   extends PrefCategory
/*    */ {
/*    */   public static SettingsPrefs i() {
/* 22 */     return Game.i.preferencesManager.getSettingsPrefs();
/*    */   }
/*    */ 
/*    */   
/* 26 */   public final SP_Auth auth = new SP_Auth();
/* 27 */   public final SP_Enemy enemy = new SP_Enemy();
/* 28 */   public final SP_Locale locale = new SP_Locale();
/* 29 */   public final SP_Music music = new SP_Music();
/* 30 */   public final SP_Rating rating = new SP_Rating();
/* 31 */   public final SP_Replay replay = new SP_Replay();
/* 32 */   public final SP_Settings settings = new SP_Settings();
/*    */   
/* 34 */   public final PrefSubcategory[] all = new PrefSubcategory[] { (PrefSubcategory)this.auth, (PrefSubcategory)this.enemy, (PrefSubcategory)this.locale, (PrefSubcategory)this.music, (PrefSubcategory)this.rating, (PrefSubcategory)this.replay, (PrefSubcategory)this.settings };
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
/* 46 */     for (i = (arrayOfPrefSubcategory = this.all).length, b = 0; b < i; b++) {
/* 47 */       PrefSubcategory prefSubcategory; (prefSubcategory = arrayOfPrefSubcategory[b]).load(paramPrefMap);
/*    */     } 
/*    */   } public final void save(PrefMap paramPrefMap) {
/*    */     PrefSubcategory[] arrayOfPrefSubcategory;
/*    */     int i;
/*    */     byte b;
/* 53 */     for (i = (arrayOfPrefSubcategory = this.all).length, b = 0; b < i; b++) {
/* 54 */       PrefSubcategory prefSubcategory; (prefSubcategory = arrayOfPrefSubcategory[b]).save(paramPrefMap);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public final void saveAsync(PrefMap paramPrefMap, Runnable paramRunnable, ObjectConsumer<Exception> paramObjectConsumer) {
/* 60 */     Threads.i().asyncConcurrentLoop((Object[])this.all, 0, this.all.length, (paramInt, paramPrefSubcategory) -> paramPrefSubcategory.save(paramPrefMap), paramRunnable, paramObjectConsumer);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\SettingsPrefs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */