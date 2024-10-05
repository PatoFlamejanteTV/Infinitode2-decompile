/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.a.a.b.d.e;
/*     */ import com.a.a.c.h.a;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ 
/*     */ public final class JsonHandler {
/*  10 */   private static final JsonHandler a = new JsonHandler();
/*     */   public static JsonHandler i() {
/*  12 */     return a;
/*     */   }
/*     */   
/*  15 */   public static final JsonValue EMPTY_JSON_OBJECT = new JsonValue(JsonValue.ValueType.object);
/*     */ 
/*     */   
/*     */   private a b;
/*     */ 
/*     */   
/*     */   public final a getMapper() {
/*  22 */     if (this.b == null) {
/*  23 */       this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  33 */         .b = (a)a.b().a(new e[] { e.a }).a(new e[] { e.b }).a(new e[] { e.c }).a(new e[] { e.i }).a(new e[] { e.d }).a(new e[] { e.e }).a(new e[] { e.f }).a(new e[] { e.g }).a(new e[] { e.h }).a();
/*     */     }
/*  35 */     return this.b;
/*     */   }
/*     */   
/*     */   public static JsonValue orEmptyObject(@Null JsonValue paramJsonValue) {
/*  39 */     if (paramJsonValue == null) {
/*  40 */       return EMPTY_JSON_OBJECT;
/*     */     }
/*  42 */     return paramJsonValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isJsonFile(FileHandle paramFileHandle) {
/*  52 */     if (!paramFileHandle.exists() || paramFileHandle.isDirectory()) return false; 
/*  53 */     String str = paramFileHandle.extension();
/*     */     
/*  55 */     return ("json".equals(str) || "json5".equals(str));
/*     */   }
/*     */   
/*     */   public static JsonValue cloneJsonValue(JsonValue paramJsonValue) {
/*     */     JsonValue.JsonIterator<JsonValue> jsonIterator;
/*     */     JsonValue jsonValue;
/*  61 */     (jsonValue = new JsonValue(paramJsonValue.type())).name = paramJsonValue.name;
/*  62 */     switch (null.a[paramJsonValue.type().ordinal()]) {
/*     */       case 1:
/*     */       case 2:
/*  65 */         for (jsonIterator = paramJsonValue.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*  66 */           jsonValue.addChild(cloneJsonValue(jsonValue1)); }
/*     */         
/*     */         break;
/*     */       
/*     */       case 3:
/*  71 */         jsonValue.set(jsonIterator.asString());
/*     */         break;
/*     */       
/*     */       case 4:
/*  75 */         jsonValue.set(jsonIterator.asLong(), null);
/*     */         break;
/*     */       
/*     */       case 5:
/*  79 */         jsonValue.set(jsonIterator.asDouble(), null);
/*     */         break;
/*     */       
/*     */       case 6:
/*  83 */         jsonValue.set(jsonIterator.asBoolean());
/*     */         break;
/*     */     } 
/*     */     
/*  87 */     return jsonValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setJsonValue(JsonValue paramJsonValue1, JsonValue paramJsonValue2) {
/*     */     JsonValue.JsonIterator<JsonValue> jsonIterator;
/*  95 */     paramJsonValue1.size = 0;
/*  96 */     paramJsonValue1.child = null;
/*     */     
/*  98 */     switch (null.a[paramJsonValue2.type().ordinal()]) {
/*     */       
/*     */       case 1:
/* 101 */         paramJsonValue1.setType(JsonValue.ValueType.object);
/* 102 */         for (jsonIterator = paramJsonValue2.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 103 */           paramJsonValue1.addChild(cloneJsonValue(jsonValue)); }
/*     */         
/*     */         return;
/*     */ 
/*     */       
/*     */       case 2:
/* 109 */         paramJsonValue1.setType(JsonValue.ValueType.array);
/* 110 */         for (jsonIterator = jsonIterator.iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 111 */           paramJsonValue1.addChild(cloneJsonValue(jsonValue)); }
/*     */         
/*     */         return;
/*     */       
/*     */       case 3:
/* 116 */         paramJsonValue1.set(jsonIterator.asString());
/*     */         return;
/*     */       
/*     */       case 4:
/* 120 */         paramJsonValue1.set(jsonIterator.asLong(), null);
/*     */         return;
/*     */       
/*     */       case 7:
/* 124 */         paramJsonValue1.setType(JsonValue.ValueType.nullValue);
/*     */         return;
/*     */       
/*     */       case 5:
/* 128 */         paramJsonValue1.set(jsonIterator.asDouble(), null);
/*     */         return;
/*     */       
/*     */       case 6:
/* 132 */         paramJsonValue1.set(jsonIterator.asBoolean());
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\JsonHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */