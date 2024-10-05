/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ public final class PP_DailyQuest implements PrefSubcategory {
/*   9 */   private static final TLog a = TLog.forClass(PP_DailyQuest.class);
/*     */   private int b;
/*     */   @Null
/*     */   private String c;
/*  13 */   private int d = -1;
/*  14 */   private int e = 0;
/*     */   
/*     */   private int f;
/*     */   @Null
/*     */   private String g;
/*     */   
/*     */   public final String getDailyLootCurrentDay() {
/*  21 */     return this.i;
/*     */   } @Null
/*     */   private String h; @Null
/*     */   private String i; public final synchronized void setDailyLootCurrentDay(String paramString) {
/*  25 */     this.i = paramString;
/*     */   }
/*     */   @Null
/*     */   public final String getDailyLootCurrentQuest() {
/*  29 */     return this.h;
/*     */   }
/*     */   
/*     */   public final synchronized void setDailyLootCurrentQuest(@Null String paramString) {
/*  33 */     this.h = paramString;
/*     */   }
/*     */   @Null
/*     */   public final String getDailyLootLastCompletedDay() {
/*  37 */     return this.g;
/*     */   }
/*     */   
/*     */   public final synchronized void setDailyLootLastCompletedDay(@Null String paramString) {
/*  41 */     this.g = paramString;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public final int getDailyLootDaysInRow() {
/*  46 */     return this.f;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public final synchronized void setDailyLootDaysInRow(int paramInt) {
/*  51 */     this.f = paramInt;
/*     */   }
/*     */   
/*     */   public final int getDailyLootCurrentDayIndex() {
/*  55 */     return this.e;
/*     */   }
/*     */   
/*     */   public final synchronized void setDailyLootCurrentDayIndex(int paramInt) {
/*  59 */     this.e = paramInt;
/*     */   }
/*     */   
/*     */   public final int getLastLoadedQuestId() {
/*  63 */     return this.d;
/*     */   }
/*     */   
/*     */   public final synchronized void setLastLoadedQuestId(int paramInt) {
/*  67 */     this.d = paramInt;
/*     */   }
/*     */   
/*     */   public final int getLastCompletedDailyQuestTimestamp() {
/*  71 */     return this.b;
/*     */   }
/*     */   
/*     */   public final synchronized void setLastCompletedDailyQuestTimestamp(int paramInt) {
/*  75 */     this.b = paramInt;
/*     */   }
/*     */   @Null
/*     */   public final String getLastLoadedQuestDate() {
/*  79 */     return this.c;
/*     */   }
/*     */   
/*     */   public final synchronized void setLastLoadedQuestDate(@Null String paramString) {
/*  83 */     this.c = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void load(PrefMap paramPrefMap) {
/*  88 */     this.b = 0;
/*  89 */     this.c = null;
/*  90 */     this.d = -1;
/*  91 */     this.e = 0;
/*  92 */     this.f = 0;
/*  93 */     this.g = null;
/*  94 */     this.h = null;
/*  95 */     this.i = null;
/*     */     
/*     */     try {
/*     */       String str;
/*     */       
/* 100 */       if ((str = paramPrefMap.get("lastCompletedDailyQuestTimestamp", null)) != null) {
/* 101 */         this.b = Integer.parseInt(str);
/* 102 */         a.i("last completed daily quest timestamp: " + this.b, new Object[0]);
/*     */       } else {
/* 104 */         a.i("no last completed daily quest timestamp", new Object[0]);
/*     */       } 
/* 106 */     } catch (Exception exception2) {
/* 107 */       Exception exception1; (exception1 = null).printStackTrace();
/*     */     } 
/*     */     
/*     */     try {
/* 111 */       this.c = paramPrefMap.get("dailyQuestLastQuestDate", null);
/* 112 */       this.d = Integer.parseInt(paramPrefMap.get("dailyQuestLastQuestId", "-1"));
/*     */       
/* 114 */       if (this.d <= 0 || this.c == null) {
/* 115 */         this.d = -1;
/* 116 */         this.c = null;
/* 117 */         a.i("no last loaded daily quest", new Object[0]);
/*     */       } else {
/* 119 */         a.i("last loaded daily quest id: " + this.d + " at " + this.c, new Object[0]);
/*     */       } 
/* 121 */     } catch (Exception exception2) {
/* 122 */       Exception exception1; (exception1 = null).printStackTrace();
/*     */     } 
/*     */     
/*     */     try {
/* 126 */       this.e = Integer.parseInt(paramPrefMap.get("dailyLootCurrentDayIndex", "0"));
/* 127 */       this.f = Integer.parseInt(paramPrefMap.get("dailyLootDaysInRow", "0"));
/* 128 */       a.i("dailyLootDaysInRow " + this.f, new Object[0]);
/* 129 */       this.g = paramPrefMap.get("dailyLootLastCompletedDay", null);
/* 130 */       this.h = paramPrefMap.get("dailyLootCurrentQuest", null);
/* 131 */       this.i = paramPrefMap.get("dailyLootCurrentDay", null); return;
/* 132 */     } catch (Exception exception) {
/* 133 */       a.e("failed to load daily loot config", new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 139 */     paramPrefMap.set("dailyLootCurrentDayIndex", this.e);
/* 140 */     paramPrefMap.set("dailyLootDaysInRow", this.f);
/* 141 */     paramPrefMap.set("dailyLootLastCompletedDay", this.g);
/* 142 */     paramPrefMap.set("dailyLootCurrentQuest", this.h);
/* 143 */     paramPrefMap.set("dailyLootCurrentDay", this.i);
/* 144 */     paramPrefMap.set("dailyQuestLastQuestDate", this.c);
/* 145 */     paramPrefMap.set("dailyQuestLastQuestId", String.valueOf(this.d));
/* 146 */     if (this.b != 0) paramPrefMap.set("lastCompletedDailyQuestTimestamp", String.valueOf(this.b)); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_DailyQuest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */