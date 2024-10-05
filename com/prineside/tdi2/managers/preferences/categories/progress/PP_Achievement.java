/*    */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonReader;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.badlogic.gdx.utils.JsonWriter;
/*    */ import com.prineside.tdi2.enums.AchievementType;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.io.StringWriter;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ public final class PP_Achievement
/*    */   implements PrefSubcategory {
/* 16 */   private static final TLog a = TLog.forClass(PP_Achievement.class);
/*    */ 
/*    */   
/* 19 */   private final int[] b = new int[AchievementType.values.length];
/* 20 */   private final boolean[] c = new boolean[AchievementType.values.length];
/*    */   
/*    */   public final int getProgress(AchievementType paramAchievementType) {
/* 23 */     return this.b[paramAchievementType.ordinal()];
/*    */   }
/*    */   
/*    */   public final boolean isRedeemed(AchievementType paramAchievementType) {
/* 27 */     return this.c[paramAchievementType.ordinal()];
/*    */   }
/*    */   
/*    */   public final synchronized void setRedeemed(AchievementType paramAchievementType, boolean paramBoolean) {
/* 31 */     this.c[paramAchievementType.ordinal()] = paramBoolean;
/*    */   }
/*    */   
/*    */   public final synchronized void setProgress(AchievementType paramAchievementType, int paramInt) {
/* 35 */     this.b[paramAchievementType.ordinal()] = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void load(PrefMap paramPrefMap) {
/* 40 */     Arrays.fill(this.b, 0);
/* 41 */     Arrays.fill(this.c, false);
/*    */     String str;
/* 43 */     if ((str = paramPrefMap.get("achievements", null)) != null) {
/*    */       try {
/*    */         JsonValue jsonValue;
/*    */         
/* 47 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*    */           try {
/* 49 */             AchievementType achievementType = AchievementType.valueOf(jsonValue1.getString(0));
/* 50 */             this.b[achievementType.ordinal()] = jsonValue1.getInt(1);
/* 51 */             this.c[achievementType.ordinal()] = (jsonValue1.getInt(2) == 1);
/* 52 */           } catch (Exception exception) {
/* 53 */             a.e("failed to load achievement progress", new Object[] { exception });
/*    */           }  }
/*    */          return;
/* 56 */       } catch (Exception exception) {
/* 57 */         a.e("failed to parse json: " + str, new Object[] { exception });
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 65 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 66 */     StringWriter stringWriter = new StringWriter();
/* 67 */     json.setWriter(stringWriter);
/* 68 */     json.writeArrayStart(); AchievementType[] arrayOfAchievementType; int i; byte b;
/* 69 */     for (i = (arrayOfAchievementType = AchievementType.values).length, b = 0; b < i; ) { AchievementType achievementType = arrayOfAchievementType[b];
/* 70 */       if (this.b[achievementType.ordinal()] != 0) {
/* 71 */         json.writeArrayStart();
/* 72 */         json.writeValue(achievementType.name());
/* 73 */         json.writeValue(Integer.valueOf(this.b[achievementType.ordinal()]));
/* 74 */         json.writeValue(Integer.valueOf(this.c[achievementType.ordinal()] ? 1 : 0));
/* 75 */         json.writeArrayEnd();
/*    */       }  b++; }
/*    */     
/* 78 */     json.writeArrayEnd();
/* 79 */     paramPrefMap.set("achievements", stringWriter.toString());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Achievement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */