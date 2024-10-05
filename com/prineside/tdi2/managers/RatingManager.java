/*     */ package com.prineside.tdi2.managers;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.Manager;
/*     */ import com.prineside.tdi2.enums.StatisticsType;
/*     */ import com.prineside.tdi2.managers.preferences.categories.SettingsPrefs;
/*     */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*     */ import com.prineside.tdi2.ui.components.RatingForm;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ @REGS(serializer = RatingManager.Serializer.class)
/*     */ public class RatingManager
/*     */   extends Manager.ManagerAdapter
/*     */ {
/*     */   public static class Serializer
/*     */     extends SingletonSerializer<RatingManager>
/*     */   {
/*     */     public RatingManager read() {
/*  21 */       return Game.i.ratingManager;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setup() {
/*  26 */     Game.i.screenManager.addListener(() -> {
/*     */           if ((SettingsPrefs.i()).rating.lastResponse == 1 || (SettingsPrefs.i()).rating.lastResponse == 3) {
/*     */             return;
/*     */           }
/*     */           if (Game.i.screenManager.getCurrentScreen() instanceof com.prineside.tdi2.screens.MainMenuScreen || Game.i.screenManager.getCurrentScreen() instanceof com.prineside.tdi2.screens.LevelSelectScreen) {
/*     */             if (shouldWeAskForReview()) {
/*     */               RatingForm.i().showRatePrompt();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean isMadeReview() {
/*  39 */     return ((SettingsPrefs.i()).rating.lastResponse == 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldWeAskForReview() {
/*  45 */     if ((SettingsPrefs.i()).rating.lastResponse == 3 || (SettingsPrefs.i()).rating.lastResponse == 1) return false;
/*     */     
/*  47 */     if ((int)Game.i.statisticsManager.getAllTime(StatisticsType.PT) > 62208000)
/*     */     {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) return false;
/*     */     
/*  54 */     if ((SettingsPrefs.i()).rating.lastResponse == 0)
/*     */     {
/*  56 */       return Game.i.basicLevelManager.isOpened(Game.i.basicLevelManager.getLevel("2.6")); } 
/*  57 */     if ((SettingsPrefs.i()).rating.lastResponse == 2) {
/*     */       long l;
/*     */       
/*  60 */       return ((l = Game.getTimestampMillis() - (SettingsPrefs.i()).rating.responseTimestamp) > 172800000L);
/*     */     } 
/*     */     
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldRateButtonBeVisible() {
/*  70 */     if ((SettingsPrefs.i()).rating.lastResponse == 3 || (SettingsPrefs.i()).rating.lastResponse == 1) return false;
/*     */     
/*  72 */     if ((int)Game.i.statisticsManager.getAllTime(StatisticsType.PT) > 62208000)
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     if (Gdx.app.getType() == Application.ApplicationType.Desktop) return false;
/*     */     
/*  79 */     if ((SettingsPrefs.i()).rating.lastResponse == 0)
/*     */     {
/*  81 */       return Game.i.basicLevelManager.isOpened(Game.i.basicLevelManager.getLevel("2.6")); } 
/*  82 */     if ((SettingsPrefs.i()).rating.lastResponse == 2)
/*     */     {
/*  84 */       return true;
/*     */     }
/*     */     
/*  87 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void madeReview(int paramInt, String paramString) {
/*  92 */     (SettingsPrefs.i()).rating.lastResponse = 3;
/*  93 */     (SettingsPrefs.i()).rating.responseTimestamp = Game.getTimestampMillis();
/*  94 */     SettingsPrefs.i().requireSave();
/*     */     
/*  96 */     Game.i.analyticsManager.logCustomEvent("made_review", new String[] { "stars", String.valueOf(paramInt) }, (Object[])new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void promptAnsweredLater() {
/* 101 */     (SettingsPrefs.i()).rating.lastResponse = 2;
/* 102 */     (SettingsPrefs.i()).rating.responseTimestamp = Game.getTimestampMillis();
/* 103 */     SettingsPrefs.i().requireSave();
/*     */   }
/*     */   
/*     */   public void promptAnsweredNever() {
/* 107 */     (SettingsPrefs.i()).rating.lastResponse = 1;
/* 108 */     (SettingsPrefs.i()).rating.responseTimestamp = Game.getTimestampMillis();
/* 109 */     SettingsPrefs.i().requireSave();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\RatingManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */