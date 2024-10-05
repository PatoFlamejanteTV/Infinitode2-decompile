/*    */ package com.prineside.tdi2.managers.preferences.categories.settings;
/*    */ 
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ 
/*    */ public final class SP_Rating implements PrefSubcategory {
/*  9 */   private static final TLog a = TLog.forClass(SP_Rating.class);
/*    */   
/*    */   public static final int NO_RESPONSE = 0;
/*    */   
/*    */   public static final int NEVER = 1;
/*    */   public static final int LATER = 2;
/*    */   public static final int REVIEWED = 3;
/* 16 */   public int lastResponse = 0;
/*    */   
/*    */   public long responseTimestamp;
/*    */ 
/*    */   
/*    */   public final void load(PrefMap paramPrefMap) {
/*    */     int i;
/* 23 */     if (paramPrefMap.get("ratingMadeReview", null) != null || paramPrefMap.get("ratingPromptAfter", null) != null) {
/*    */       boolean bool;
/* 25 */       a.i("migrating review preferences from the old save format", new Object[0]);
/*    */ 
/*    */       
/*    */       try {
/* 29 */         bool = Boolean.parseBoolean(paramPrefMap.get("ratingMadeReview", "false"));
/* 30 */       } catch (Exception exception) {
/* 31 */         bool = true;
/*    */       } 
/*    */       
/* 34 */       if (!bool) {
/*    */         
/* 36 */         a.i("- no review yet", new Object[0]);
/*    */         
/*    */         try {
/* 39 */           if ((i = Integer.parseInt(paramPrefMap.get("ratingPromptAfter", "3600"))) > 7776000) {
/* 40 */             a.i("- ratingPromptAfter is large, assuming never", new Object[0]);
/* 41 */             this.lastResponse = 1;
/* 42 */             this.responseTimestamp = Game.getTimestampMillis();
/*    */           } else {
/* 44 */             a.i("- ratingPromptAfter is not large, assuming later", new Object[0]);
/* 45 */             this.lastResponse = 2;
/* 46 */             this.responseTimestamp = Game.getTimestampMillis();
/*    */           } 
/* 48 */         } catch (Exception exception) {
/* 49 */           a.i("- error parsing ratingPromptAfter - assuming no response yet", new Object[0]);
/* 50 */           this.lastResponse = 0;
/*    */         } 
/*    */       } else {
/*    */         
/* 54 */         a.i("- made review", new Object[0]);
/* 55 */         this.lastResponse = 3;
/* 56 */         this.responseTimestamp = Game.getTimestampMillis();
/*    */       } 
/*    */       
/*    */       try {
/* 60 */         Game.i.preferencesManager.getSettingsPrefs().requireSave();
/* 61 */       } catch (Exception exception) {}
/*    */     } else {
/*    */       
/* 64 */       if (i.get("ratingLastResponse", null) != null) {
/*    */         try {
/* 66 */           this.lastResponse = Integer.parseInt(i.get("ratingLastResponse", null));
/* 67 */         } catch (Exception exception) {}
/*    */       }
/* 69 */       if (i.get("ratingResponseTimestamp", null) != null) {
/*    */         try {
/* 71 */           this.responseTimestamp = Long.parseLong(i.get("ratingResponseTimestamp", null));
/* 72 */         } catch (Exception exception) {}
/*    */       }
/*    */     } 
/*    */     
/* 76 */     a.i("lastResponse " + this.lastResponse, new Object[0]);
/* 77 */     a.i("responseTimestamp " + this.responseTimestamp + " / " + Game.getTimestampMillis(), new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 82 */     paramPrefMap.set("ratingLastResponse", String.valueOf(this.lastResponse));
/* 83 */     paramPrefMap.set("ratingResponseTimestamp", String.valueOf(this.responseTimestamp));
/*    */     
/* 85 */     a.i("save lastResponse " + this.lastResponse, new Object[0]);
/* 86 */     a.i("save responseTimestamp " + this.responseTimestamp + " / " + Game.getTimestampMillis(), new Object[0]);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Rating.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */