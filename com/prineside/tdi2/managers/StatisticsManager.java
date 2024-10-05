/*    */ package com.prineside.tdi2.managers;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.Manager;
/*    */ import com.prineside.tdi2.enums.StatisticsType;
/*    */ import com.prineside.tdi2.managers.preferences.categories.ProgressPrefs;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ import com.prineside.tdi2.utils.StringFormatter;
/*    */ 
/*    */ @REGS(serializer = StatisticsManager.Serializer.class)
/*    */ public class StatisticsManager extends Manager.ManagerAdapter {
/*    */   public static class Serializer extends SingletonSerializer<StatisticsManager> {
/*    */     public StatisticsManager read() {
/* 15 */       return Game.i.statisticsManager;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTimeSpentInGameSinceStart() {
/* 22 */     return (int)getAllTime(StatisticsType.PRT);
/*    */   }
/*    */   
/*    */   public CharSequence getStatisticsTitle(StatisticsType paramStatisticsType) {
/* 26 */     String str = paramStatisticsType.name();
/* 27 */     return Game.i.localeManager.i18n.get("statistics_" + str);
/*    */   }
/*    */   
/*    */   public CharSequence formatStatisticsValue(StatisticsType paramStatisticsType, double paramDouble) {
/* 31 */     if (paramStatisticsType == StatisticsType.PT || paramStatisticsType == StatisticsType.PRT || paramStatisticsType == StatisticsType.PTEMWD || paramStatisticsType == StatisticsType.WCST)
/*    */     {
/* 33 */       return (CharSequence)StringFormatter.digestTime((int)paramDouble);
/*    */     }
/* 35 */     return (CharSequence)StringFormatter.compactNumber(paramDouble, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public double getAllTime(StatisticsType paramStatisticsType) {
/* 40 */     return (ProgressPrefs.i()).statistics.getAllTime(paramStatisticsType);
/*    */   }
/*    */   
/*    */   public double getMaxOneGame(StatisticsType paramStatisticsType) {
/* 44 */     return (ProgressPrefs.i()).statistics.getMaxOneGame(paramStatisticsType);
/*    */   }
/*    */   
/*    */   public void registerDelta(StatisticsType paramStatisticsType, double paramDouble) {
/* 48 */     (ProgressPrefs.i()).statistics.addAllTime(paramStatisticsType, paramDouble);
/* 49 */     ProgressPrefs.i().requireSave();
/*    */ 
/*    */     
/* 52 */     if (paramStatisticsType == StatisticsType.PT && (ProgressPrefs.i()).progress.getLootBoostTimeLeft() > 0.0F) {
/*    */       float f;
/* 54 */       if ((f = (ProgressPrefs.i()).progress.getLootBoostTimeLeft() - (float)paramDouble) < 0.0F) {
/* 55 */         f = 0.0F;
/*    */       }
/* 57 */       (ProgressPrefs.i()).progress.setLootBoostTimeLeft(f);
/* 58 */       ProgressPrefs.i().requireSave();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void registerValue(StatisticsType paramStatisticsType, double paramDouble) {
/* 63 */     (ProgressPrefs.i()).statistics.setAllTime(paramStatisticsType, paramDouble);
/* 64 */     ProgressPrefs.i().requireSave();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void registerMaxOneGame(StatisticsType paramStatisticsType, double paramDouble) {
/* 71 */     if ((ProgressPrefs.i()).statistics.getMaxOneGame(paramStatisticsType) < paramDouble) {
/* 72 */       (ProgressPrefs.i()).statistics.setMaxOneGame(paramStatisticsType, paramDouble);
/* 73 */       ProgressPrefs.i().requireSave();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\StatisticsManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */