/*     */ package com.prineside.tdi2.managers.preferences.categories.settings;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.ObjectSet;
/*     */ import com.badlogic.gdx.utils.StringBuilder;
/*     */ import com.prineside.tdi2.enums.AbilityType;
/*     */ import com.prineside.tdi2.managers.SettingsManager;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SP_Settings
/*     */   implements PrefSubcategory
/*     */ {
/*     */   private static final TLog a = TLog.forClass(SP_Settings.class);
/*     */   public static final double CUSTOM_VALUE_NOT_SET = -9740019.0D;
/*     */   private static final double[] b;
/*     */   
/*     */   public SP_Settings() {
/*  93 */     this.lastSelectedAbilities = new Array(true, 1, AbilityType.class);
/*  94 */     this.shownTooltipTags = new ObjectSet();
/*     */     
/*  96 */     this.customValues = new double[(SettingsManager.CustomValueType.values()).length];
/*     */     
/*  98 */     Arrays.fill(this.customValues, -9740019.0D);
/*     */     
/* 100 */     this.hotKeys = new int[SettingsManager.HotkeyAction.values.length][];
/*     */   }
/*     */   public Array<AbilityType> lastSelectedAbilities;
/*     */   public void load(PrefMap paramPrefMap) {
/* 104 */     Arrays.fill(this.customValues, -9740019.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     ObjectPair[] arrayOfObjectPair;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     byte b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 123 */     for (arrayOfObjectPair = arrayOfObjectPair = new ObjectPair[] { new ObjectPair(SettingsManager.CustomValueType.BUG_REPORTS_ENABLED, "bugReportsEnabled"), new ObjectPair(SettingsManager.CustomValueType.EXPLOSIONS_DRAWING, "explosionsDrawing"), new ObjectPair(SettingsManager.CustomValueType.PROJECTILES_DRAWING, "projectilesDrawing"), new ObjectPair(SettingsManager.CustomValueType.PROJECTILE_TRAILS_DRAWING, "projectileTrailsDrawing"), new ObjectPair(SettingsManager.CustomValueType.PARTICLES_DRAWING, "particlesDrawing"), new ObjectPair(SettingsManager.CustomValueType.UI_ANIMATIONS_ENABLED, "uiAnimationsEnabled"), new ObjectPair(SettingsManager.CustomValueType.FLYING_COINS_ENABLED, "flyingCoinsEnabled"), new ObjectPair(SettingsManager.CustomValueType.INSTANT_AUTO_WAVE_CALL, "instantAutoWaveCall"), new ObjectPair(SettingsManager.CustomValueType.STAINS_ENABLED, "stainsEnabled"), new ObjectPair(SettingsManager.CustomValueType.LARGE_FONTS_ENABLED, "largeFonts"), new ObjectPair(SettingsManager.CustomValueType.DEBUG_MODE, "debugMode"), new ObjectPair(SettingsManager.CustomValueType.THREE_DEE_MODELS_ENABLED, "threeDeeModelsEnabled"), new ObjectPair(SettingsManager.CustomValueType.DEBUG_DETAILED_MODE, "debugDetailedMode") }b = 0; b < 13; ) { ObjectPair objectPair = arrayOfObjectPair[b];
/*     */       String str;
/* 125 */       if ((str = paramPrefMap.get((String)objectPair.second, null)) != null) {
/* 126 */         this.customValues[((SettingsManager.CustomValueType)objectPair.first).ordinal()] = str.equals("true") ? 1.0D : 0.0D;
/* 127 */         paramPrefMap.set((String)objectPair.second, null);
/*     */       } 
/*     */       b++; }
/*     */     
/*     */     String str1;
/* 132 */     if ((str1 = paramPrefMap.get("customValues", null)) != null) {
/*     */       JsonValue jsonValue;
/* 134 */       for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */         try {
/* 136 */           SettingsManager.CustomValueType customValueType = SettingsManager.CustomValueType.valueOf(jsonValue1.name);
/* 137 */           this.customValues[customValueType.ordinal()] = jsonValue1.asDouble();
/* 138 */         } catch (Exception exception) {
/* 139 */           a.i("failed to load custom value " + jsonValue1.name, new Object[0]);
/*     */         }  }
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 147 */     if ((str1 = paramPrefMap.get("hotkeys", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 150 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str1)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*     */           try {
/* 152 */             SettingsManager.HotkeyAction hotkeyAction = SettingsManager.HotkeyAction.valueOf(jsonValue1.name);
/* 153 */             this.hotKeys[hotkeyAction.ordinal()] = jsonValue1.asIntArray();
/* 154 */           } catch (Exception exception) {
/* 155 */             a.e("failed to load hotkey " + jsonValue1.name, new Object[] { exception });
/*     */           }  }
/*     */       
/* 158 */       } catch (Exception exception) {
/* 159 */         a.e("failed to load hotkeys", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/* 163 */     this.lastSelectedAbilities.clear();
/*     */     String str2;
/* 165 */     if ((str2 = paramPrefMap.get("lastAbilitiesConfiguration", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 168 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str2)).iterator(); jsonIterator.hasNext(); ) {
/* 169 */           JsonValue jsonValue1; if ((jsonValue1 = jsonIterator.next()).type() == JsonValue.ValueType.stringValue) {
/*     */             try {
/* 171 */               this.lastSelectedAbilities.add(AbilityType.valueOf(jsonValue1.asString()));
/* 172 */             } catch (Exception exception) {} continue;
/*     */           } 
/* 174 */           this.lastSelectedAbilities.add(null);
/*     */         }
/*     */       
/* 177 */       } catch (Exception exception) {
/* 178 */         a.e("failed to load previous abilities configuration", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */     
/* 182 */     this.shownTooltipTags.clear();
/*     */     String str3;
/* 184 */     if ((str3 = paramPrefMap.get("TooltipsOverlay.shownTags", null)) != null)
/*     */       try {
/*     */         int i; String[] arrayOfString1; byte b1; String[] arrayOfString2;
/* 187 */         for (i = (arrayOfString1 = arrayOfString2 = str3.split("\\|")).length, b1 = 0; b1 < i; b1++) {
/* 188 */           if ((str3 = arrayOfString1[b1]).length() != 0)
/* 189 */             this.shownTooltipTags.add(str3); 
/*     */         } 
/*     */         return;
/* 192 */       } catch (Exception exception) {
/* 193 */         a.e("failed to load shown tags", new Object[] { exception });
/*     */       }  
/*     */   }
/*     */   public final ObjectSet<String> shownTooltipTags;
/*     */   public final double[] customValues;
/*     */   
/*     */   public synchronized void save(PrefMap paramPrefMap) {
/* 200 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 201 */     StringWriter stringWriter = new StringWriter();
/* 202 */     json.setWriter(stringWriter);
/*     */     
/* 204 */     json.writeObjectStart(); SettingsManager.CustomValueType[] arrayOfCustomValueType; int i; byte b;
/* 205 */     for (i = (arrayOfCustomValueType = SettingsManager.CustomValueType.values).length, b = 0; b < i; ) { SettingsManager.CustomValueType customValueType = arrayOfCustomValueType[b];
/* 206 */       if (this.customValues[customValueType.ordinal()] != -9740019.0D && this.customValues[customValueType.ordinal()] != getDefaultCustomValue(customValueType))
/* 207 */         json.writeValue(customValueType.name(), Double.valueOf(this.customValues[customValueType.ordinal()])); 
/*     */       b++; }
/*     */     
/* 210 */     json.writeObjectEnd();
/* 211 */     paramPrefMap.set("customValues", stringWriter.toString());
/*     */ 
/*     */     
/* 214 */     json = new Json(JsonWriter.OutputType.minimal);
/* 215 */     stringWriter = new StringWriter();
/* 216 */     json.setWriter(stringWriter);
/* 217 */     json.writeObjectStart(); SettingsManager.HotkeyAction[] arrayOfHotkeyAction;
/* 218 */     for (i = (arrayOfHotkeyAction = SettingsManager.HotkeyAction.values).length, b = 0; b < i; ) { SettingsManager.HotkeyAction hotkeyAction = arrayOfHotkeyAction[b];
/* 219 */       if (this.hotKeys[hotkeyAction.ordinal()] != null) {
/* 220 */         json.writeArrayStart(hotkeyAction.name());
/* 221 */         for (byte b1 = 0; b1 < (this.hotKeys[hotkeyAction.ordinal()]).length; b1++) {
/* 222 */           json.writeValue(Integer.valueOf(this.hotKeys[hotkeyAction.ordinal()][b1]));
/*     */         }
/* 224 */         json.writeArrayEnd();
/*     */       }  b++; }
/*     */     
/* 227 */     json.writeObjectEnd();
/* 228 */     paramPrefMap.set("hotkeys", stringWriter.toString());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 243 */     paramPrefMap.set("lastAbilitiesConfiguration", null);
/*     */     
/* 245 */     StringBuilder stringBuilder = new StringBuilder();
/* 246 */     for (ObjectSet.ObjectSetIterator<String> objectSetIterator = this.shownTooltipTags.iterator(); objectSetIterator.hasNext(); ) { String str = objectSetIterator.next();
/* 247 */       if (stringBuilder.length != 0) {
/* 248 */         stringBuilder.append('|');
/*     */       }
/* 250 */       stringBuilder.append(str); }
/*     */     
/* 252 */     paramPrefMap.set("TooltipsOverlay.shownTags", (stringBuilder.length == 0) ? null : stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public final int[][] hotKeys;
/*     */   
/*     */   static {
/*     */     (b = new double[(SettingsManager.CustomValueType.values()).length])[SettingsManager.CustomValueType.UI_SCALE.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.DBG_CONSOLE_LINE_COUNT.ordinal()] = 200.0D;
/*     */     b[SettingsManager.CustomValueType.SEND_NOTIFICATIONS.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.MUSIC_CACHE_MAX_SIZE.ordinal()] = 100.0D;
/*     */     b[SettingsManager.CustomValueType.ENABLE_REWARDING_ADS.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.ENABLE_PAUSE_AD_ICON.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.SOUND_VOLUME.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.MUSIC_VOLUME.ordinal()] = 0.7D;
/*     */     b[SettingsManager.CustomValueType.SHOOTING_SOUNDS_VOLUME.ordinal()] = 0.5D;
/*     */     b[SettingsManager.CustomValueType.LIVE_LEADERBOARDS.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.GRAPHICS_INTERPOLATION_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.CAMERA_SHAKE_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.SMOOTH_MUSIC.ordinal()] = 0.0D;
/*     */     b[SettingsManager.CustomValueType.STATISTICS_CHART_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.SLOW_MOTION_PAUSE.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.BACKGROUND_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.LOOT_ICONS_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.STATE_AUTO_SAVE_INTERVAL.ordinal()] = 3.0D;
/*     */     b[SettingsManager.CustomValueType.UI_QUEST_LIST_VISIBLE.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.UI_LIVE_LEADERBOARDS_VISIBLE.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.PP_GRAPHICS_SCALE.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.PP_EFFECTS_SCALE.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.DAMAGE_PARTICLES_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.MUSIC_SPECTRUM_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.INSTANT_HOLD_BUTTON_ON_RMB.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.DAMAGE_PARTICLES_MORE.ordinal()] = 0.0D;
/*     */     b[SettingsManager.CustomValueType.PARTICLE_COUNT.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.SHOW_BONUS_SELECTION_IMMEDIATELY.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.THREE_DEE_MODELS_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.BUG_REPORTS_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.EXPLOSIONS_DRAWING.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.PROJECTILES_DRAWING.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.PROJECTILE_TRAILS_DRAWING.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.PARTICLES_DRAWING.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.UI_ANIMATIONS_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.FLYING_COINS_ENABLED.ordinal()] = 1.0D;
/*     */     b[SettingsManager.CustomValueType.STAINS_ENABLED.ordinal()] = 1.0D;
/*     */   }
/*     */   
/*     */   public static double getDefaultCustomValue(SettingsManager.CustomValueType paramCustomValueType) {
/*     */     switch (null.a[paramCustomValueType.ordinal()]) {
/*     */       case 1:
/*     */         try {
/*     */           if (Gdx.app.getType() == Application.ApplicationType.Desktop) {
/*     */             if (Gdx.graphics.getHeight() >= 1440)
/*     */               return 0.8D; 
/*     */             if (Gdx.graphics.getHeight() >= 1080)
/*     */               return 0.9D; 
/*     */             return 1.0D;
/*     */           } 
/*     */         } catch (Exception exception) {}
/*     */         return 1.0D;
/*     */     } 
/*     */     return b[paramCustomValueType.ordinal()];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Settings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */