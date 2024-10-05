/*     */ package com.prineside.tdi2.managers.preferences;
/*     */ 
/*     */ import com.badlogic.gdx.Application;
/*     */ import com.badlogic.gdx.Gdx;
/*     */ import com.badlogic.gdx.Preferences;
/*     */ import com.badlogic.gdx.utils.Array;
/*     */ import com.badlogic.gdx.utils.Base64Coder;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.prineside.kryo.FixedInput;
/*     */ import com.prineside.tdi2.Config;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.utils.ObjectPair;
/*     */ import com.prineside.tdi2.utils.StringFormatter;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class LegacyPreferences {
/*  21 */   private static final TLog a = TLog.forClass(LegacyPreferences.class);
/*     */   
/*     */   private final byte[] b;
/*  24 */   private final FixedInput c = new FixedInput();
/*     */ 
/*     */ 
/*     */   
/*     */   public LegacyPreferences() {
/*     */     String str;
/*  30 */     if ((str = (String)Game.i.actionResolver.getDeviceInfo().get("id")) != null && str.length() >= 4) {
/*  31 */       if (str.length() > 64) str = str.substring(0, 64); 
/*     */       char[] arrayOfChar;
/*  33 */       byte[] arrayOfByte = new byte[(arrayOfChar = str.toCharArray()).length];
/*  34 */       for (byte b = 0; b < arrayOfChar.length; b++) {
/*  35 */         arrayOfByte[b] = (byte)(arrayOfChar[b] - 110);
/*     */       }
/*  37 */       this.b = arrayOfByte; return;
/*     */     } 
/*  39 */     this.b = new byte[] { 14, 1, 93, -7, -71, -29, 98, 39 };
/*     */   }
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
/*     */   @Null
/*     */   public Array<ObjectPair<String, HashMap<String, String>>> getLocallyStoredPrefs() {
/*  54 */     a.i("searching for a legacy properties (" + Config.LEGACY_PREFERENCES_NAME_PREFIX + "*)", new Object[0]);
/*  55 */     Array<ObjectPair<String, HashMap<String, String>>> array = null; String[] arrayOfString; int i; byte b;
/*  56 */     for (i = (arrayOfString = Config.LEGACY_PREFERENCES_NAMES).length, b = 0; b < i; ) { String str = arrayOfString[b];
/*     */       SafePreferences safePreferences;
/*  58 */       if ((safePreferences = getPropertiesInstance(str)).count() != 0) {
/*  59 */         if (array == null) {
/*  60 */           array = new Array(true, 1, ObjectPair.class);
/*     */         }
/*  62 */         ObjectPair objectPair = new ObjectPair();
/*  63 */         if (Config.LEGACY_PREFERENCES_NAME_PROGRESS.equals(str)) {
/*  64 */           objectPair.first = "Progress";
/*  65 */         } else if (Config.LEGACY_PREFERENCES_NAME_SETTINGS.equals(str)) {
/*  66 */           objectPair.first = "Settings";
/*  67 */         } else if (Config.LEGACY_PREFERENCES_NAME_STATISTICS.equals(str)) {
/*  68 */           objectPair.first = "Statistics";
/*  69 */         } else if (Config.LEGACY_PREFERENCES_NAME_USER_MAPS.equals(str)) {
/*  70 */           objectPair.first = "UserMaps";
/*     */         } else {
/*     */           
/*  73 */           throw new IllegalArgumentException("Invalid preferences name: " + str);
/*     */         } 
/*  75 */         objectPair.second = safePreferences.getAll();
/*  76 */         array.add(objectPair);
/*     */       }  b++; }
/*     */     
/*  79 */     return array;
/*     */   }
/*     */   
/*     */   public boolean has1dot8prefs() {
/*     */     Array<ObjectPair<String, HashMap<String, String>>> array;
/*  84 */     if ((array = getLocallyStoredPrefs()) != null && array.size != 0) return true;  return false;
/*     */   }
/*     */   
/*     */   public boolean has1dot9migrationFlag() {
/*     */     Array<ObjectPair<String, HashMap<String, String>>> array;
/*  89 */     if ((array = getLocallyStoredPrefs()) == null || array.size == 0) return false;
/*     */     
/*  91 */     for (byte b = 0; b < array.size; b++) {
/*     */       ObjectPair objectPair;
/*  93 */       if (((String)(objectPair = (ObjectPair)array.get(b)).first).equals("Progress")) {
/*  94 */         String str = (String)((HashMap)objectPair.second).get("_migrated_1_9_0");
/*  95 */         if ("true".equals(str)) {
/*  96 */           return true;
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 102 */     return false;
/*     */   }
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
/*     */   public Array<ObjectPair<String, HashMap<String, String>>> fromBytes(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 120 */     Array<ObjectPair<String, HashMap<String, String>>> array = new Array(true, 1, ObjectPair.class);
/* 121 */     ByteArrayOutputStream byteArrayOutputStream = StringFormatter.fromCompactBytes(paramArrayOfbyte, paramInt1, paramInt2);
/* 122 */     this.c.setBuffer(byteArrayOutputStream.toByteArray());
/*     */     
/* 124 */     int i = this.c.readInt();
/* 125 */     paramInt1 = 0; while (true) { if (paramInt1 < i)
/* 126 */       { String str = this.c.readString();
/* 127 */         ObjectPair objectPair = new ObjectPair();
/* 128 */         if (Config.LEGACY_PREFERENCES_NAME_PROGRESS.equals(str)) {
/* 129 */           objectPair.first = "Progress";
/* 130 */         } else if (Config.LEGACY_PREFERENCES_NAME_SETTINGS.equals(str)) {
/* 131 */           objectPair.first = "Settings";
/* 132 */         } else if (Config.LEGACY_PREFERENCES_NAME_STATISTICS.equals(str)) {
/* 133 */           objectPair.first = "Statistics";
/* 134 */         } else if (Config.LEGACY_PREFERENCES_NAME_USER_MAPS.equals(str)) {
/* 135 */           objectPair.first = "UserMaps";
/*     */         } else {
/*     */           
/* 138 */           a.e("unrecognized legacy properties type, skipped: " + str, new Object[0]);
/*     */           
/*     */           paramInt1++;
/*     */         } 
/* 142 */         HashMap<Object, Object> hashMap = new HashMap<>();
/* 143 */         int j = this.c.readInt();
/* 144 */         for (byte b = 0; b < j; b++) {
/* 145 */           String str1 = this.c.readString();
/*     */           String str2;
/* 147 */           if ((str2 = this.c.readString()) != null) {
/* 148 */             hashMap.put(str1, str2);
/*     */           }
/*     */         } 
/* 151 */         objectPair.second = hashMap;
/* 152 */         array.add(objectPair); }
/*     */       else { break; }
/*     */        paramInt1++; }
/* 155 */      return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Array<ObjectPair<String, HashMap<String, String>>> fromCompactBase64(String paramString) {
/* 163 */     byte[] arrayOfByte = StringFormatter.fromBase64(paramString);
/* 164 */     return fromBytes(arrayOfByte, 0, arrayOfByte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SafePreferences getPropertiesInstance(String paramString) {
/* 173 */     if (Config.isModdingMode()) {
/* 174 */       paramString = paramString + ".mod-" + Config.getModId();
/*     */     }
/*     */     
/* 177 */     return new SafePreferences(paramString, this.b);
/*     */   }
/*     */   
/*     */   public static class SafePreferences {
/*     */     private final Preferences a;
/*     */     private final byte[] b;
/*     */     
/*     */     protected SafePreferences(String param1String, byte[] param1ArrayOfbyte) {
/* 185 */       this.a = Gdx.app.getPreferences(param1String);
/* 186 */       this.b = param1ArrayOfbyte;
/*     */     }
/*     */     
/*     */     public int count() {
/* 190 */       return this.a.get().size();
/*     */     }
/*     */     
/*     */     public HashMap<String, String> getAll() {
/* 194 */       null = new HashMap<>();
/* 195 */       synchronized (this.a) {
/*     */         Map<?, ?> map;
/* 197 */         for (Iterator<Map.Entry> iterator = (map = this.a.get()).entrySet().iterator(); iterator.hasNext(); ) {
/* 198 */           Map.Entry entry; if ((entry = iterator.next()).getValue() instanceof String) {
/* 199 */             null.put(entry.getKey(), get((String)entry.getKey(), "")); continue;
/*     */           } 
/* 201 */           LegacyPreferences.a().i("getAll - invalid data type for key '" + (String)entry.getKey() + "' : " + entry.getValue().getClass().getName(), new Object[0]);
/*     */         } 
/*     */       } 
/*     */       
/* 205 */       return (HashMap<String, String>)SYNTHETIC_LOCAL_VARIABLE_1;
/*     */     }
/*     */     
/*     */     public void set(String param1String1, String param1String2) {
/* 209 */       synchronized (this.a) {
/* 210 */         if (Config.preferencesEncryptionEnabled()) {
/* 211 */           this.a.putString(param1String1, StringFormatter.stringToCompactBase64(param1String2));
/*     */         } else {
/*     */           
/* 214 */           this.a.putString(param1String1, param1String2);
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     }
/*     */     public String get(String param1String1, String param1String2) {
/* 220 */       synchronized (this.a) {
/* 221 */         if (this.a.contains(param1String1)) {
/* 222 */           if (Config.preferencesEncryptionEnabled()) {
/* 223 */             String str = this.a.getString(param1String1);
/*     */ 
/*     */             
/*     */             try {
/* 227 */               return StringFormatter.stringFromCompactBase64(str);
/* 228 */             } catch (Exception exception) {
/*     */               
/* 230 */               String str1 = a(str, this.b);
/* 231 */               param1String2 = param1String2;
/*     */               try {
/* 233 */                 param1String2 = new String(Base64Coder.decode(str1));
/* 234 */               } catch (Exception exception1) {
/* 235 */                 LegacyPreferences.a().e("Unable to decode Base64 for key '" + param1String1 + "': " + exception1.getMessage() + " (" + str + ")", new Object[] { exception1 });
/* 236 */                 this.a.remove(param1String1);
/*     */               } 
/*     */ 
/*     */               
/* 240 */               return param1String2;
/*     */             } 
/*     */           } 
/* 243 */           return this.a.getString(param1String1);
/*     */         } 
/*     */         
/* 246 */         return param1String2;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 252 */       this.a.clear();
/* 253 */       this.a.flush();
/*     */     }
/*     */     
/*     */     public void flush() {
/* 257 */       this.a.flush();
/*     */     }
/*     */ 
/*     */     
/*     */     private static char a(char param1Char, int param1Int) {
/* 262 */       return (char)(((param1Char - 32 + param1Int) % 94 + 94) % 94 + 32);
/*     */     }
/*     */     
/*     */     private static String a(String param1String, byte[] param1ArrayOfbyte) {
/* 266 */       if (Gdx.app.getType() == Application.ApplicationType.iOS)
/*     */       {
/* 268 */         return param1String;
/*     */       }
/* 270 */       char[] arrayOfChar = param1String.toCharArray();
/* 271 */       byte b1 = 0;
/* 272 */       for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
/* 273 */         arrayOfChar[b2] = a(arrayOfChar[b2], -(b2 + b2 + arrayOfChar.length - param1ArrayOfbyte[b1]));
/*     */         
/* 275 */         b1++;
/* 276 */         if (b1 == param1ArrayOfbyte.length) {
/* 277 */           b1 = 0;
/*     */         }
/*     */       } 
/*     */       
/* 281 */       return new String(arrayOfChar);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\LegacyPreferences.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */