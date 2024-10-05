/*     */ package com.prineside.tdi2.utils;
/*     */ 
/*     */ import com.a.a.c.j.m;
/*     */ import com.a.a.c.m;
/*     */ import com.badlogic.gdx.utils.JsonValue;
/*     */ import com.badlogic.gdx.utils.JsonWriter;
/*     */ import com.badlogic.gdx.utils.Null;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ public final class JsonAssertUtils
/*     */ {
/*     */   public static void checkJsonType(JsonValue paramJsonValue, JsonValue.ValueType paramValueType, CharSequence paramCharSequence) {
/*  14 */     if (paramJsonValue == null) {
/*  15 */       throw new IllegalArgumentException(paramCharSequence + " - type must be " + paramValueType + ", null given");
/*     */     }
/*  17 */     if (paramJsonValue.type() != paramValueType) {
/*  18 */       throw new IllegalArgumentException(paramCharSequence + " - type must be " + paramValueType + ", " + paramJsonValue.type() + " given: " + paramJsonValue);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void checkJsonType(m paramm, m paramm1, CharSequence paramCharSequence) {
/*  23 */     if (paramm == null) {
/*  24 */       throw new IllegalArgumentException(paramCharSequence + " - type must be " + paramm1 + ", null given");
/*     */     }
/*  26 */     if (paramm.d() != paramm1)
/*  27 */       throw new IllegalArgumentException(paramCharSequence + " - type must be " + paramm1 + ", " + paramm.d() + " given: " + paramm);  } public static void assertJsonValuesEqual(JsonValue paramJsonValue1, JsonValue paramJsonValue2, @Null StringBuilder paramStringBuilder) { JsonValue.JsonIterator<JsonValue> jsonIterator1; int i; byte b2; JsonValue.JsonIterator jsonIterator3; byte b1; JsonValue.JsonIterator<JsonValue> jsonIterator2;
/*     */     JsonValue.JsonIterator jsonIterator5;
/*     */     byte b4;
/*     */     JsonValue.JsonIterator jsonIterator4;
/*     */     byte b3;
/*  32 */     if (paramJsonValue1 == paramJsonValue2)
/*     */       return; 
/*  34 */     if (paramStringBuilder == null)
/*     */     {
/*  36 */       (paramStringBuilder = new StringBuilder()).append("root");
/*     */     }
/*     */     
/*  39 */     if (paramJsonValue1 == null || paramJsonValue2 == null) {
/*  40 */       throw new IllegalArgumentException("One value is null: " + paramJsonValue1 + ", " + paramJsonValue2 + " at " + paramStringBuilder);
/*     */     }
/*     */     
/*  43 */     if (paramJsonValue1.type() != paramJsonValue2.type()) {
/*  44 */       throw new IllegalArgumentException("Type mismatch (" + paramJsonValue1.type() + ", " + paramJsonValue2.type() + "): " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */     }
/*     */     
/*  47 */     switch (null.a[paramJsonValue1.type().ordinal()]) {
/*     */       case 1:
/*  49 */         if (paramJsonValue1.asBoolean() != paramJsonValue2.asBoolean()) {
/*  50 */           throw new IllegalArgumentException("Boolean values mismatch: " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*     */         break;
/*     */       
/*     */       case 2:
/*  55 */         if (paramJsonValue1.asDouble() != paramJsonValue2.asDouble()) {
/*  56 */           throw new IllegalArgumentException("Double values mismatch: " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/*  61 */         if (paramJsonValue1.asLong() != paramJsonValue2.asLong()) {
/*  62 */           throw new IllegalArgumentException("Long values mismatch: " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case 4:
/*  68 */         if (paramJsonValue1.asString() == paramJsonValue2.asString()) {
/*     */           return;
/*     */         }
/*  71 */         if (paramJsonValue1.asString() == null) {
/*  72 */           throw new IllegalArgumentException("String values mismatch (first is null): " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*  74 */         if (paramJsonValue2.asString() == null) {
/*  75 */           throw new IllegalArgumentException("String values mismatch (second is null): " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*  77 */         if (!paramJsonValue1.asString().equals(paramJsonValue2.asString())) {
/*  78 */           throw new IllegalArgumentException("String values mismatch: " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*     */         break;
/*     */       
/*     */       case 5:
/*  83 */         if (paramJsonValue1.size != paramJsonValue2.size) {
/*  84 */           throw new IllegalArgumentException("Array length mismatch: " + paramJsonValue1.toJson(JsonWriter.OutputType.json) + ", " + paramJsonValue2.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*  86 */         b2 = 0;
/*  87 */         for (jsonIterator5 = paramJsonValue1.iterator(); jsonIterator5.hasNext(); ) { jsonIterator5.next();
/*  88 */           b2++; }
/*     */         
/*  90 */         if (b2 != paramJsonValue1.size) {
/*  91 */           throw new IllegalArgumentException("Broken json (first, size does not match iteration count: real = " + b2 + ", size = " + paramJsonValue1.size + "): " + paramJsonValue1 + ", " + paramJsonValue2 + " at " + paramStringBuilder);
/*     */         }
/*     */         
/*  94 */         b4 = 0;
/*  95 */         for (jsonIterator3 = paramJsonValue2.iterator(); jsonIterator3.hasNext(); ) { jsonIterator3.next();
/*  96 */           b4++; }
/*     */         
/*  98 */         if (b4 != paramJsonValue2.size) {
/*  99 */           throw new IllegalArgumentException("Broken json (second, size does not match iteration count: real = " + b4 + ", size = " + paramJsonValue2.size + "): " + paramJsonValue1 + ", " + paramJsonValue2 + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 102 */         jsonIterator3 = paramJsonValue2.iterator();
/* 103 */         b4 = 0;
/* 104 */         for (jsonIterator1 = paramJsonValue1.iterator(); jsonIterator1.hasNext(); ) { JsonValue jsonValue1 = jsonIterator1.next();
/* 105 */           i = paramStringBuilder.length();
/* 106 */           paramStringBuilder.append('[').append(b4).append(']');
/* 107 */           JsonValue jsonValue2 = jsonIterator3.next();
/* 108 */           assertJsonValuesEqual(jsonValue1, jsonValue2, paramStringBuilder);
/* 109 */           paramStringBuilder.setLength(i);
/*     */           
/* 111 */           b4++; }
/*     */         
/*     */         return;
/*     */       
/*     */       case 6:
/* 116 */         if (((JsonValue)jsonIterator1).size != i.size) {
/* 117 */           throw new IllegalArgumentException("Objects field count mismatch: " + jsonIterator1.toJson(JsonWriter.OutputType.json) + ", " + i.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/* 119 */         b1 = 0;
/* 120 */         for (jsonIterator4 = jsonIterator1.iterator(); jsonIterator4.hasNext(); ) { jsonIterator4.next();
/* 121 */           b1++; }
/*     */         
/* 123 */         if (b1 != ((JsonValue)jsonIterator1).size) {
/* 124 */           throw new IllegalArgumentException("Broken json (first, size does not match iteration count): " + jsonIterator1.toJson(JsonWriter.OutputType.json) + ", " + i.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 127 */         b3 = 0;
/* 128 */         for (jsonIterator2 = i.iterator(); jsonIterator2.hasNext(); ) { jsonIterator2.next();
/* 129 */           b3++; }
/*     */         
/* 131 */         if (b3 != i.size) {
/* 132 */           throw new IllegalArgumentException("Broken json (second, size does not match iteration count): " + jsonIterator1.toJson(JsonWriter.OutputType.json) + ", " + i.toJson(JsonWriter.OutputType.json) + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 135 */         for (jsonIterator2 = jsonIterator1.iterator(); jsonIterator2.hasNext(); ) { JsonValue jsonValue1 = jsonIterator2.next();
/* 136 */           int j = paramStringBuilder.length();
/* 137 */           paramStringBuilder.append('.').append(jsonValue1.name);
/* 138 */           JsonValue jsonValue2 = i.get(jsonValue1.name);
/* 139 */           assertJsonValuesEqual(jsonValue1, jsonValue2, paramStringBuilder);
/* 140 */           paramStringBuilder.setLength(j); }
/*     */          return;
/*     */       case 7:
/*     */         return;
/*     */     }  } public static void assertJsonValuesEqual(m paramm1, m paramm2, @Null StringBuilder paramStringBuilder) { int i; byte b2; Iterator<m> iterator1;
/*     */     byte b1;
/*     */     Iterator<Map.Entry> iterator;
/*     */     Iterator iterator3;
/*     */     byte b4;
/*     */     Iterator iterator2;
/*     */     byte b3;
/* 151 */     if (paramm1 == paramm2)
/*     */       return; 
/* 153 */     if (paramStringBuilder == null)
/*     */     {
/* 155 */       (paramStringBuilder = new StringBuilder()).append("root");
/*     */     }
/*     */     
/* 158 */     if (paramm1 == null || paramm2 == null) {
/* 159 */       throw new IllegalArgumentException("One value is null: " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */     }
/*     */     
/* 162 */     if (paramm1.d() != paramm2.d()) {
/* 163 */       throw new IllegalArgumentException("Type mismatch (" + paramm1.d() + ", " + paramm2.d() + "): " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */     }
/*     */     
/* 166 */     switch (null.b[paramm1.d().ordinal()]) {
/*     */       case 1:
/* 168 */         if (paramm1.l() != paramm2.l()) {
/* 169 */           throw new IllegalArgumentException("Boolean values mismatch: " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */         }
/*     */         break;
/*     */       
/*     */       case 2:
/* 174 */         if (paramm1.k() != paramm2.k()) {
/* 175 */           throw new IllegalArgumentException("Double values mismatch: " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 180 */         if (paramm1.i().equals(paramm2.i())) {
/*     */           return;
/*     */         }
/* 183 */         throw new IllegalArgumentException("String values mismatch: " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */       
/*     */       case 4:
/* 186 */         if (paramm1.a() != paramm2.a()) {
/* 187 */           throw new IllegalArgumentException("Array length mismatch: " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */         }
/* 189 */         b2 = 0;
/* 190 */         for (iterator3 = paramm1.iterator(); iterator3.hasNext(); ) { iterator3.next();
/* 191 */           b2++; }
/*     */         
/* 193 */         if (b2 != paramm1.a()) {
/* 194 */           throw new IllegalArgumentException("Broken json (first, size does not match iteration count: real = " + b2 + ", size = " + paramm1.a() + "): " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 197 */         b4 = 0;
/* 198 */         for (iterator1 = paramm2.iterator(); iterator1.hasNext(); ) { iterator1.next();
/* 199 */           b4++; }
/*     */         
/* 201 */         if (b4 != paramm2.a()) {
/* 202 */           throw new IllegalArgumentException("Broken json (second, size does not match iteration count: real = " + b4 + ", size = " + paramm2.a() + "): " + paramm1 + ", " + paramm2 + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 205 */         iterator1 = paramm2.iterator();
/* 206 */         b4 = 0;
/* 207 */         for (m m1 : paramm1) {
/* 208 */           i = paramStringBuilder.length();
/* 209 */           paramStringBuilder.append('[').append(b4).append(']');
/* 210 */           m m2 = iterator1.next();
/* 211 */           assertJsonValuesEqual(m1, m2, paramStringBuilder);
/* 212 */           paramStringBuilder.setLength(i);
/*     */           
/* 214 */           b4++;
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 5:
/* 219 */         if (paramm1.a() != i.a()) {
/* 220 */           throw new IllegalArgumentException("Objects field count mismatch: " + paramm1 + ", " + i + " at " + paramStringBuilder);
/*     */         }
/* 222 */         b1 = 0;
/* 223 */         for (iterator2 = paramm1.iterator(); iterator2.hasNext(); ) { iterator2.next();
/* 224 */           b1++; }
/*     */         
/* 226 */         if (b1 != paramm1.a()) {
/* 227 */           throw new IllegalArgumentException("Broken json (first, size does not match iteration count): " + paramm1 + ", " + i + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 230 */         b3 = 0;
/* 231 */         for (iterator = i.iterator(); iterator.hasNext(); ) { iterator.next();
/* 232 */           b3++; }
/*     */         
/* 234 */         if (b3 != i.a()) {
/* 235 */           throw new IllegalArgumentException("Broken json (second, size does not match iteration count): " + paramm1 + ", " + i + " at " + paramStringBuilder);
/*     */         }
/*     */         
/* 238 */         for (iterator = paramm1.n(); iterator.hasNext(); ) {
/* 239 */           Map.Entry entry = iterator.next();
/* 240 */           int j = paramStringBuilder.length();
/* 241 */           paramStringBuilder.append('.').append((String)entry.getKey());
/* 242 */           m m1 = i.a((String)entry.getKey());
/* 243 */           assertJsonValuesEqual((m)entry.getValue(), m1, paramStringBuilder);
/* 244 */           paramStringBuilder.setLength(j);
/*     */         } 
/*     */         break;
/*     */     }  }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\JsonAssertUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */