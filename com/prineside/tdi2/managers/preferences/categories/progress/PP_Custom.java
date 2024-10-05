/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.google.common.base.Preconditions;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
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
/*     */ public final class PP_Custom
/*     */   implements PrefSubcategory
/*     */ {
/*  35 */   private static final TLog a = TLog.forClass(PP_Custom.class);
/*     */   
/*     */   public static final int MAX_ENTRIES = 256;
/*     */   
/*     */   public static final int MAX_ENTRY_LENGTH = 131072;
/*  40 */   private final ConcurrentHashMap<String, String> b = new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized void setValue(String paramString1, @Null String paramString2) {
/*  48 */     Preconditions.checkNotNull(paramString1, "key can not be null");
/*     */     
/*  50 */     if (paramString2 == null) {
/*  51 */       this.b.remove(paramString1); return;
/*     */     } 
/*  53 */     if (this.b.size() >= 256 && 
/*  54 */       !this.b.contains(paramString1)) {
/*  55 */       throw new IllegalStateException("Can't add a new entry - too many custom entries are stored, remove some other value first");
/*     */     }
/*     */     
/*  58 */     if (paramString2.length() > 131072) {
/*  59 */       throw new IllegalArgumentException("Value is too long - max string length is defined as MAX_ENTRY_LENGTH. Split your data or reduce its size somehow");
/*     */     }
/*  61 */     this.b.put(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Null
/*     */   public final String getValue(String paramString1, @Null String paramString2) {
/*  72 */     Preconditions.checkNotNull(paramString1, "key can not be null");
/*     */     
/*  74 */     if ((paramString1 = this.b.get(paramString1)) != null) {
/*  75 */       return paramString1;
/*     */     }
/*  77 */     return paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final synchronized String[] getKeys() {
/*  84 */     String[] arrayOfString = new String[this.b.size()];
/*  85 */     byte b = 0;
/*  86 */     for (Map.Entry<String, String> entry : this.b.entrySet()) {
/*  87 */       arrayOfString[b++] = (String)entry.getKey();
/*     */     }
/*     */     
/*  90 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void load(PrefMap paramPrefMap) {
/*  95 */     this.b.clear();
/*     */     String str;
/*  97 */     if ((str = paramPrefMap.get("customData", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue;
/* 100 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 101 */           this.b.put(jsonValue1.name, jsonValue1.asString()); }
/*     */          return;
/* 103 */       } catch (Exception exception) {
/* 104 */         a.e("failed to parse customData", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 111 */     if (this.b.size() != 0) {
/* 112 */       Json json = new Json(JsonWriter.OutputType.minimal);
/* 113 */       StringWriter stringWriter = new StringWriter();
/* 114 */       json.setWriter(stringWriter);
/* 115 */       json.writeObjectStart();
/* 116 */       for (Map.Entry<String, String> entry : this.b.entrySet()) {
/* 117 */         json.writeValue((String)entry.getKey(), entry.getValue());
/*     */       }
/* 119 */       json.writeObjectEnd();
/*     */       
/* 121 */       paramPrefMap.set("customData", stringWriter.toString());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Custom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */