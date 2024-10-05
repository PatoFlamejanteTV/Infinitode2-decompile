/*     */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*     */ 
/*     */ import com.badlogic.gdx.utils.Json;
/*     */ import com.badlogic.gdx.utils.JsonReader;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import com.badlogic.gdx.utils.ObjectMap;
/*     */ import com.prineside.tdi2.Game;
/*     */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*     */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ import java.io.StringWriter;
/*     */ 
/*     */ public final class PP_Message
/*     */   implements PrefSubcategory {
/*  17 */   private static final TLog a = TLog.forClass(PP_Message.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  22 */   private final ObjectMap<String, Long> b = new ObjectMap();
/*  23 */   private final ObjectMap<String, Long> c = new ObjectMap();
/*  24 */   private final ObjectMap<String, Long> d = new ObjectMap();
/*     */   
/*     */   public final boolean isMessageRead(String paramString) {
/*  27 */     return this.b.containsKey(paramString);
/*     */   }
/*     */   
/*     */   public final synchronized void setMessageRead(String paramString) {
/*  31 */     this.b.put(paramString, Long.valueOf(Game.getTimestampMillis()));
/*     */   }
/*     */   
/*     */   public final synchronized void removeMessageReadRecord(String paramString) {
/*  35 */     this.b.remove(paramString);
/*     */   }
/*     */   @Null
/*     */   public final Long getMessageReadTimestamp(String paramString) {
/*  39 */     return (Long)this.b.get(paramString, null);
/*     */   }
/*     */   
/*     */   public final boolean isMessageDeleted(String paramString) {
/*  43 */     return this.c.containsKey(paramString);
/*     */   }
/*     */   
/*     */   public final synchronized void setMessageDeleted(String paramString) {
/*  47 */     this.c.put(paramString, Long.valueOf(Game.getTimestampMillis()));
/*     */   }
/*     */   
/*     */   public final synchronized void removeMessageDeletedRecord(String paramString) {
/*  51 */     this.c.remove(paramString);
/*     */   }
/*     */   @Null
/*     */   public final Long getMessageDeletedTimestamp(String paramString) {
/*  55 */     return (Long)this.c.get(paramString, null);
/*     */   }
/*     */   
/*     */   public final boolean isMessageItemsReceived(String paramString) {
/*  59 */     return this.d.containsKey(paramString);
/*     */   }
/*     */   
/*     */   public final synchronized void setMessageItemsReceived(String paramString) {
/*  63 */     this.d.put(paramString, Long.valueOf(Game.getTimestampMillis()));
/*     */   }
/*     */   
/*     */   public final synchronized void removeMessageItemsReceivedRecord(String paramString) {
/*  67 */     this.d.remove(paramString);
/*     */   }
/*     */   @Null
/*     */   public final Long getMessageItemsReceivedTimestamp(String paramString) {
/*  71 */     return (Long)this.d.get(paramString, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void load(PrefMap paramPrefMap) {
/*  76 */     this.b.clear();
/*  77 */     this.c.clear();
/*  78 */     this.d.clear();
/*     */     
/*     */     String str;
/*  81 */     if ((str = paramPrefMap.get("messageManager", null)) != null) {
/*     */       try {
/*     */         JsonValue jsonValue1;
/*     */         JsonValue jsonValue2;
/*  85 */         if ((jsonValue2 = (jsonValue1 = (new JsonReader()).parse(str)).get("readMessages")) != null) {
/*  86 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  87 */             this.b.put(jsonValue.getString("id"), Long.valueOf(jsonValue.getLong("ts"))); }
/*     */         
/*     */         }
/*     */         
/*  91 */         if ((jsonValue2 = jsonValue1.get("deletedMessages")) != null) {
/*  92 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  93 */             this.c.put(jsonValue.getString("id"), Long.valueOf(jsonValue.getLong("ts"))); }
/*     */         
/*     */         }
/*     */         
/*  97 */         if ((jsonValue2 = jsonValue1.get("itemsReceivedMessages")) != null)
/*  98 */           for (JsonValue.JsonIterator<JsonValue> jsonIterator = jsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/*  99 */             this.d.put(jsonValue.getString("id"), Long.valueOf(jsonValue.getLong("ts"))); }
/*     */            
/*     */         return;
/* 102 */       } catch (Exception exception) {
/* 103 */         a.e("failed to read save data", new Object[] { exception });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final synchronized void save(PrefMap paramPrefMap) {
/* 110 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 111 */     StringWriter stringWriter = new StringWriter();
/* 112 */     json.setWriter(stringWriter);
/* 113 */     json.writeObjectStart();
/*     */     
/* 115 */     json.writeArrayStart("readMessages"); ObjectMap.Entries<ObjectMap.Entry> entries;
/* 116 */     for (entries = this.b.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 117 */       if (Game.getTimestampMillis() - ((Long)entry.value).longValue() < 3888000000L) {
/* 118 */         json.writeObjectStart();
/* 119 */         json.writeValue("id", entry.key);
/* 120 */         json.writeValue("ts", entry.value);
/* 121 */         json.writeObjectEnd();
/*     */       }  }
/*     */     
/* 124 */     json.writeArrayEnd();
/*     */     
/* 126 */     json.writeArrayStart("deletedMessages");
/* 127 */     for (entries = this.c.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 128 */       if (Game.getTimestampMillis() - ((Long)entry.value).longValue() < 3888000000L) {
/* 129 */         json.writeObjectStart();
/* 130 */         json.writeValue("id", entry.key);
/* 131 */         json.writeValue("ts", entry.value);
/* 132 */         json.writeObjectEnd();
/*     */       }  }
/*     */     
/* 135 */     json.writeArrayEnd();
/*     */     
/* 137 */     json.writeArrayStart("itemsReceivedMessages");
/* 138 */     for (entries = this.d.iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 139 */       if (Game.getTimestampMillis() - ((Long)entry.value).longValue() < 3888000000L) {
/* 140 */         json.writeObjectStart();
/* 141 */         json.writeValue("id", entry.key);
/* 142 */         json.writeValue("ts", entry.value);
/* 143 */         json.writeObjectEnd();
/*     */       }  }
/*     */     
/* 146 */     json.writeArrayEnd();
/*     */     
/* 148 */     json.writeObjectEnd();
/* 149 */     paramPrefMap.set("messageManager", stringWriter.toString());
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_Message.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */