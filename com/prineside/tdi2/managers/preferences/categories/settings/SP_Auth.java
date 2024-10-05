/*     */ package com.prineside.tdi2.managers.preferences.categories.settings;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.AuthManager;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ public final class SP_Auth
/*     */   implements PrefSubcategory {
/*  18 */   private static final TLog a = TLog.forClass(SP_Auth.class);
/*     */   
/*     */   private boolean b = false;
/*     */   
/*     */   @Null
/*     */   private String c;
/*  24 */   public int cloudSaveSlotId = -1;
/*     */   public int cloudSaveSlotTimestamp;
/*     */   public boolean autoSavesEnabled;
/*     */   @Null
/*  28 */   public SessionData sessionData = new SessionData();
/*     */   @Null
/*     */   public final String getOfflinePlayerId() {
/*  31 */     return this.c;
/*     */   }
/*     */   
/*     */   public final synchronized void setOfflinePlayerId(String paramString) {
/*  35 */     this.c = paramString;
/*     */   }
/*     */   
/*     */   public final boolean isHasUnsavedProgressForCloud() {
/*  39 */     return this.b;
/*     */   }
/*     */   
/*     */   public final synchronized void setHasUnsavedProgressForCloud(boolean paramBoolean) {
/*  43 */     this.b = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(PrefMap paramPrefMap) {
/*  48 */     this.b = false;
/*     */     try {
/*  50 */       this.b = Boolean.parseBoolean(paramPrefMap.get("hasUnsavedProgressForCloud", "false"));
/*  51 */     } catch (Exception exception) {
/*  52 */       a.e("failed to load hasUnsavedProgressForCloud", new Object[] { exception });
/*     */     } 
/*     */     
/*  55 */     this.c = paramPrefMap.get("playerid", null);
/*  56 */     if (this.c != null && this.c.length() > 32) {
/*     */       
/*  58 */       a.e("Invalid playerid, set to null: " + this.c, new Object[0]);
/*  59 */       this.c = null;
/*     */     } 
/*     */     
/*  62 */     this.cloudSaveSlotId = -1;
/*  63 */     this.cloudSaveSlotTimestamp = 0;
/*     */     try {
/*     */       String str;
/*  66 */       if ((str = paramPrefMap.get("cloudSaveSlot", null)) != null) {
/*  67 */         JsonValue jsonValue = (new JsonReader()).parse(str);
/*  68 */         this.cloudSaveSlotId = jsonValue.getInt("id");
/*  69 */         this.cloudSaveSlotTimestamp = jsonValue.getInt("timestamp");
/*     */       } 
/*  71 */       this.autoSavesEnabled = Boolean.parseBoolean(paramPrefMap.get("authAutoSaves", "false"));
/*  72 */     } catch (Exception exception) {
/*  73 */       a.e("failed to load cloudSaveSlot or authAutoSaves", new Object[] { exception });
/*     */     } 
/*     */     
/*     */     try {
/*     */       String str;
/*     */       
/*  79 */       if ((str = paramPrefMap.get("authSession", null)) != null) {
/*  80 */         JsonValue jsonValue = (new JsonReader()).parse(str);
/*  81 */         this.sessionData.fromJson(jsonValue);
/*     */       }  return;
/*  83 */     } catch (Exception exception) {
/*  84 */       a.e("failed to load authSession data", new Object[] { exception });
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/*  90 */     paramPrefMap.set("hasUnsavedProgressForCloud", this.b ? "true" : "false");
/*  91 */     paramPrefMap.set("playerid", this.c);
/*     */     
/*  93 */     Json json = new Json(JsonWriter.OutputType.json);
/*  94 */     StringWriter stringWriter = new StringWriter();
/*  95 */     json.setWriter(stringWriter);
/*  96 */     json.writeObjectStart();
/*  97 */     json.writeValue("id", Integer.valueOf(this.cloudSaveSlotId));
/*  98 */     json.writeValue("timestamp", Integer.valueOf(this.cloudSaveSlotTimestamp));
/*  99 */     json.writeObjectEnd();
/*     */     
/* 101 */     paramPrefMap.set("cloudSaveSlot", stringWriter.toString());
/* 102 */     paramPrefMap.set("authAutoSaves", String.valueOf(this.autoSavesEnabled));
/*     */     
/* 104 */     if (this.sessionData.sessionId != null) {
/* 105 */       json = new Json(JsonWriter.OutputType.json);
/* 106 */       stringWriter = new StringWriter();
/* 107 */       json.setWriter(stringWriter);
/* 108 */       json.writeObjectStart();
/* 109 */       this.sessionData.toJson(json);
/* 110 */       json.writeObjectEnd();
/* 111 */       paramPrefMap.set("authSession", stringWriter.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   public final void setNoCloudSaveSlot() {
/* 116 */     this.cloudSaveSlotId = -1;
/* 117 */     this.cloudSaveSlotTimestamp = 0;
/* 118 */     this.b = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class SessionData
/*     */   {
/*     */     @Null
/*     */     public String sessionId;
/*     */     @Null
/*     */     public String nickname;
/*     */     public long updateTimestamp;
/*     */     @Null
/*     */     public String playerId;
/*     */     @Null
/*     */     public String inviteCode;
/* 133 */     public AuthManager.XpStatus xpStatus = AuthManager.XpStatus.NORMAL; @Null
/*     */     public String invitedBy; @Null
/*     */     public String emailHint; public boolean passwordSet = true; @Null
/*     */     public String steamAccountId; public boolean hasAvatar; public long lastLoadFromCloudTimestamp; public int currentLevelXp; public int bonusXpRemaining; public int regularXpRemaining; public int tempXp;
/*     */     public int nextXpRefreshTimestamp;
/*     */     public int nextLevelXp;
/*     */     public int profileLevel;
/*     */     public int maxProfileLevel;
/*     */     public float playedLevelXpCoeff;
/*     */     public float bonusLevelXpCoeff;
/*     */     @Null
/*     */     public String bonusXpLevel;
/* 145 */     public Array<String> xpPlayedLevels = new Array(String.class);
/* 146 */     public Array<AuthManager.ProfileStatus> profileStatuses = new Array(true, 1, AuthManager.ProfileStatus.class);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void toJson(Json param1Json) {
/* 152 */       param1Json.writeValue("id", this.sessionId);
/* 153 */       param1Json.writeValue("nickname", this.nickname);
/* 154 */       param1Json.writeValue("playerId", this.playerId);
/* 155 */       param1Json.writeValue("emailHint", this.emailHint);
/* 156 */       param1Json.writeValue("steamAccountId", this.steamAccountId);
/* 157 */       param1Json.writeValue("lastLoadFromCloudTimestamp", Long.valueOf(this.lastLoadFromCloudTimestamp));
/* 158 */       if (this.inviteCode != null) {
/* 159 */         param1Json.writeValue("inviteCode", this.inviteCode);
/*     */       }
/* 161 */       if (this.invitedBy != null) {
/* 162 */         param1Json.writeValue("invitedBy", this.invitedBy);
/*     */       }
/* 164 */       param1Json.writeValue("updateTimestamp", Long.valueOf(this.updateTimestamp));
/*     */ 
/*     */       
/* 167 */       param1Json.writeValue("xpStatus", Integer.valueOf(this.xpStatus.ordinal()));
/* 168 */       param1Json.writeValue("currentLevelXp", Integer.valueOf(this.currentLevelXp));
/* 169 */       param1Json.writeValue("tempXp", Integer.valueOf(this.tempXp));
/* 170 */       param1Json.writeValue("nextLevelXp", Integer.valueOf(this.nextLevelXp));
/* 171 */       param1Json.writeValue("profileLevel", Integer.valueOf(this.profileLevel));
/* 172 */       param1Json.writeValue("maxProfileLevel", Integer.valueOf(this.maxProfileLevel));
/* 173 */       param1Json.writeValue("playedLevelXpCoeff", Float.valueOf(this.playedLevelXpCoeff));
/* 174 */       param1Json.writeValue("bonusLevelXpCoeff", Float.valueOf(this.bonusLevelXpCoeff));
/* 175 */       if (this.bonusXpLevel != null) param1Json.writeValue("bonusXpLevel", this.bonusXpLevel); 
/* 176 */       param1Json.writeValue("bonusXpRemaining", Integer.valueOf(this.bonusXpRemaining));
/* 177 */       param1Json.writeValue("regularXpRemaining", Integer.valueOf(this.regularXpRemaining));
/* 178 */       param1Json.writeValue("nextXpRefresh", Integer.valueOf(this.nextXpRefreshTimestamp));
/* 179 */       param1Json.writeArrayStart("xpPlayedLevels"); byte b;
/* 180 */       for (b = 0; b < this.xpPlayedLevels.size; b++) {
/* 181 */         param1Json.writeValue(((String[])this.xpPlayedLevels.items)[b]);
/*     */       }
/* 183 */       param1Json.writeArrayEnd();
/*     */       
/* 185 */       param1Json.writeArrayStart("profileStatuses");
/* 186 */       for (b = 0; b < this.profileStatuses.size; b++) {
/* 187 */         AuthManager.ProfileStatus profileStatus = (AuthManager.ProfileStatus)this.profileStatuses.get(b);
/* 188 */         param1Json.writeObjectStart();
/* 189 */         param1Json.writeValue("id", profileStatus.id);
/* 190 */         param1Json.writeValue("reason", profileStatus.reason);
/* 191 */         param1Json.writeValue("receivedAt", Integer.valueOf(profileStatus.receivedAt));
/* 192 */         param1Json.writeValue("expiresAt", Integer.valueOf(profileStatus.expiresAt));
/* 193 */         param1Json.writeObjectEnd();
/*     */       } 
/* 195 */       param1Json.writeArrayEnd();
/*     */     }
/*     */     
/*     */     public final void fromJson(JsonValue param1JsonValue) {
/* 199 */       this.sessionId = param1JsonValue.getString("id");
/* 200 */       this.nickname = param1JsonValue.getString("nickname");
/* 201 */       this.updateTimestamp = param1JsonValue.getLong("updateTimestamp");
/* 202 */       this.playerId = param1JsonValue.getString("playerId");
/* 203 */       this.inviteCode = param1JsonValue.getString("inviteCode", null);
/* 204 */       this.invitedBy = param1JsonValue.getString("invitedBy", null);
/* 205 */       this.passwordSet = true;
/* 206 */       this.emailHint = param1JsonValue.getString("emailHint", "");
/* 207 */       this.steamAccountId = param1JsonValue.getString("steamAccountId", null);
/* 208 */       this.lastLoadFromCloudTimestamp = param1JsonValue.getLong("lastLoadFromCloudTimestamp", 0L);
/*     */ 
/*     */       
/* 211 */       this.xpStatus = AuthManager.XpStatus.values[param1JsonValue.getInt("xpStatus", AuthManager.XpStatus.NORMAL.ordinal())];
/* 212 */       this.currentLevelXp = param1JsonValue.getInt("currentLevelXp", 0);
/* 213 */       this.bonusXpRemaining = param1JsonValue.getInt("bonusXpRemaining", 0);
/* 214 */       this.regularXpRemaining = param1JsonValue.getInt("regularXpRemaining", 0);
/* 215 */       this.nextXpRefreshTimestamp = param1JsonValue.getInt("nextXpRefresh", Game.getTimestampSeconds() + 432000);
/* 216 */       this.tempXp = param1JsonValue.getInt("tempXp", 0);
/* 217 */       this.nextLevelXp = param1JsonValue.getInt("nextLevelXp", 1000);
/* 218 */       this.profileLevel = param1JsonValue.getInt("profileLevel", 1);
/* 219 */       this.maxProfileLevel = param1JsonValue.getInt("maxProfileLevel", 30);
/* 220 */       this.playedLevelXpCoeff = param1JsonValue.getFloat("playedLevelXpCoeff", 0.5F);
/* 221 */       this.bonusLevelXpCoeff = param1JsonValue.getFloat("bonusLevelXpCoeff", 1.5F);
/* 222 */       this.bonusXpLevel = param1JsonValue.getString("bonusXpLevel", null);
/*     */       JsonValue jsonValue;
/* 224 */       if ((jsonValue = param1JsonValue.get("xpPlayedLevels")) != null) {
/* 225 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = param1JsonValue.get("xpPlayedLevels").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 226 */           this.xpPlayedLevels.add(jsonValue1.asString()); }
/*     */       
/*     */       }
/*     */ 
/*     */       
/* 231 */       this.profileStatuses.clear();
/*     */       
/* 233 */       if ((jsonValue = param1JsonValue.get("profileStatuses")) != null) {
/* 234 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue.iterator(); jsonIterator.hasNext(); ) { param1JsonValue = jsonIterator.next();
/*     */           try {
/*     */             AuthManager.ProfileStatus profileStatus;
/* 237 */             (profileStatus = new AuthManager.ProfileStatus()).id = param1JsonValue.getString("id");
/* 238 */             profileStatus.reason = param1JsonValue.getString("reason");
/* 239 */             profileStatus.receivedAt = param1JsonValue.getInt("receivedAt");
/* 240 */             profileStatus.expiresAt = param1JsonValue.getInt("expiresAt", -1);
/* 241 */             this.profileStatuses.add(profileStatus);
/* 242 */           } catch (Exception exception) {
/* 243 */             SP_Auth.a().e("failed to load profile status: " + param1JsonValue.toString(), new Object[] { exception });
/*     */           }  }
/*     */       
/*     */       }
/*     */     }
/*     */     
/*     */     public final void fromServerResponseJson(JsonValue param1JsonValue) {
/* 250 */       this.sessionId = param1JsonValue.getString("sessionId");
/*     */       String str;
/* 252 */       if ((str = param1JsonValue.getString("newSession", null)) != null)
/*     */       {
/* 254 */         this.sessionId = str;
/*     */       }
/*     */       
/* 257 */       this.hasAvatar = param1JsonValue.getBoolean("hasPfp", false);
/* 258 */       this.passwordSet = param1JsonValue.getBoolean("passwordSet", true);
/* 259 */       this.steamAccountId = param1JsonValue.getString("steamAccountId", null);
/* 260 */       this.nickname = param1JsonValue.getString("nickname");
/* 261 */       this.emailHint = param1JsonValue.getString("emailHint", "");
/* 262 */       this.updateTimestamp = Game.getTimestampMillis();
/* 263 */       this.playerId = param1JsonValue.getString("playerid");
/* 264 */       this.inviteCode = param1JsonValue.getString("inviteCode", null);
/* 265 */       this.invitedBy = param1JsonValue.getString("invitedBy", null);
/*     */       
/*     */       JsonValue jsonValue1;
/*     */       
/* 269 */       if ((jsonValue1 = param1JsonValue.get("xp")) != null) {
/* 270 */         this.currentLevelXp = jsonValue1.get("current").getInt("level-xp");
/* 271 */         this.bonusXpRemaining = jsonValue1.getInt("bonusXpRemaining", 0);
/* 272 */         this.regularXpRemaining = jsonValue1.getInt("regularXpRemaining", 0);
/* 273 */         this.nextXpRefreshTimestamp = jsonValue1.getInt("nextXpRefresh", Game.getTimestampSeconds() + 432000);
/* 274 */         this.tempXp = jsonValue1.getInt("temp");
/* 275 */         this.nextLevelXp = jsonValue1.get("current").getInt("next-level");
/* 276 */         this.profileLevel = jsonValue1.get("current").getInt("level");
/* 277 */         this.maxProfileLevel = jsonValue1.get("current").getInt("maxLevel");
/* 278 */         this.playedLevelXpCoeff = jsonValue1.get("dailyXp").getFloat("playedLevelXpCoeff");
/* 279 */         this.bonusLevelXpCoeff = jsonValue1.get("dailyXp").getFloat("bonusLevelXpCoeff");
/* 280 */         this.bonusXpLevel = jsonValue1.get("dailyXp").getString("bonusLevel");
/* 281 */         this.xpPlayedLevels.clear();
/* 282 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue1.get("dailyXp").get("playedToday").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 283 */           this.xpPlayedLevels.add(jsonValue.asString()); }
/*     */         
/* 285 */         this.xpStatus = AuthManager.XpStatus.NORMAL;
/* 286 */         if (jsonValue1.getString("status").equals("bonus")) {
/* 287 */           this.xpStatus = AuthManager.XpStatus.BONUS;
/* 288 */         } else if (jsonValue1.getString("status").equals("reduced")) {
/* 289 */           this.xpStatus = AuthManager.XpStatus.REDUCED;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 294 */       this.profileStatuses.clear();
/*     */       JsonValue jsonValue2;
/* 296 */       if ((jsonValue2 = param1JsonValue.get("profileStatuses")) != null)
/* 297 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { param1JsonValue = jsonIterator.next();
/*     */           try {
/*     */             AuthManager.ProfileStatus profileStatus;
/* 300 */             (profileStatus = new AuthManager.ProfileStatus()).id = param1JsonValue.getString("status");
/* 301 */             profileStatus.receivedAt = param1JsonValue.getInt("received_at", Game.getTimestampSeconds());
/* 302 */             profileStatus.expiresAt = param1JsonValue.getInt("expires_at", -1);
/* 303 */             profileStatus.reason = param1JsonValue.getString("reason");
/*     */             
/* 305 */             this.profileStatuses.add(profileStatus);
/* 306 */           } catch (Exception exception) {
/* 307 */             SP_Auth.a().e("failed to store profile status: " + param1JsonValue.toJson(JsonWriter.OutputType.json), new Object[] { exception });
/*     */           }  }
/*     */          
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Auth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */