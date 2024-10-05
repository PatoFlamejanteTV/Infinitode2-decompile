/*     */ package com.badlogic.gdx.utils;
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
/*     */ public class JsonString
/*     */ {
/*     */   final StringBuilder buffer;
/*  28 */   private final Array<JsonObject> stack = new Array<>();
/*     */   private JsonObject current;
/*     */   private boolean named;
/*  31 */   private JsonWriter.OutputType outputType = JsonWriter.OutputType.json;
/*     */   private boolean quoteLongValues = false;
/*     */   
/*     */   public JsonString() {
/*  35 */     this.buffer = new StringBuilder();
/*     */   }
/*     */   
/*     */   public StringBuilder getBuffer() {
/*  39 */     return this.buffer;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOutputType(JsonWriter.OutputType paramOutputType) {
/*  44 */     this.outputType = paramOutputType;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQuoteLongValues(boolean paramBoolean) {
/*  50 */     this.quoteLongValues = paramBoolean;
/*     */   }
/*     */   
/*     */   public JsonString name(String paramString) {
/*  54 */     if (this.current == null || this.current.array) throw new IllegalStateException("Current item must be an object."); 
/*  55 */     if (!this.current.needsComma) {
/*  56 */       this.current.needsComma = true;
/*     */     } else {
/*  58 */       this.buffer.append(',');
/*  59 */     }  this.buffer.append(this.outputType.quoteName(paramString));
/*  60 */     this.buffer.append(':');
/*  61 */     this.named = true;
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public JsonString object() {
/*  66 */     requireCommaOrName();
/*  67 */     this.stack.add(this.current = new JsonObject(false));
/*  68 */     return this;
/*     */   }
/*     */   
/*     */   public JsonString array() {
/*  72 */     requireCommaOrName();
/*  73 */     this.stack.add(this.current = new JsonObject(true));
/*  74 */     return this;
/*     */   }
/*     */   
/*     */   public JsonString value(@Null Object paramObject) {
/*  78 */     if (this.quoteLongValues && (paramObject instanceof Long || paramObject instanceof Double || paramObject instanceof java.math.BigDecimal || paramObject instanceof java.math.BigInteger)) {
/*     */       
/*  80 */       paramObject = paramObject.toString();
/*  81 */     } else if (paramObject instanceof Number) {
/*     */       Number number;
/*  83 */       long l = (number = (Number)paramObject).longValue();
/*  84 */       if (number.doubleValue() == l) paramObject = Long.valueOf(l); 
/*     */     } 
/*  86 */     requireCommaOrName();
/*  87 */     this.buffer.append(this.outputType.quoteValue(paramObject));
/*  88 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonString json(String paramString) {
/*  93 */     requireCommaOrName();
/*  94 */     this.buffer.append(paramString);
/*  95 */     return this;
/*     */   }
/*     */   
/*     */   private void requireCommaOrName() {
/*  99 */     if (this.current == null)
/* 100 */       return;  if (this.current.array) {
/* 101 */       if (!this.current.needsComma) {
/* 102 */         this.current.needsComma = true; return;
/*     */       } 
/* 104 */       this.buffer.append(','); return;
/*     */     } 
/* 106 */     if (!this.named) throw new IllegalStateException("Name must be set."); 
/* 107 */     this.named = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonString object(String paramString) {
/* 112 */     return name(paramString).object();
/*     */   }
/*     */   
/*     */   public JsonString array(String paramString) {
/* 116 */     return name(paramString).array();
/*     */   }
/*     */   
/*     */   public JsonString set(String paramString, Object paramObject) {
/* 120 */     return name(paramString).value(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonString json(String paramString1, String paramString2) {
/* 125 */     return name(paramString1).json(paramString2);
/*     */   }
/*     */   
/*     */   public JsonString pop() {
/* 129 */     if (this.named) throw new IllegalStateException("Expected an object, array, or value since a name was set."); 
/* 130 */     ((JsonObject)this.stack.pop()).close();
/* 131 */     this.current = (this.stack.size == 0) ? null : this.stack.peek();
/* 132 */     return this;
/*     */   }
/*     */   
/*     */   public JsonString close() {
/* 136 */     while (this.stack.size > 0)
/* 137 */       pop(); 
/* 138 */     return this;
/*     */   }
/*     */   
/*     */   public void reset() {
/* 142 */     this.buffer.clear();
/* 143 */     this.stack.clear();
/* 144 */     this.current = null;
/* 145 */     this.named = false;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 149 */     return this.buffer.toString();
/*     */   }
/*     */   
/*     */   private class JsonObject {
/*     */     final boolean array;
/*     */     boolean needsComma;
/*     */     
/*     */     JsonObject(boolean param1Boolean) {
/* 157 */       this.array = param1Boolean;
/* 158 */       JsonString.this.buffer.append(param1Boolean ? 91 : 123);
/*     */     }
/*     */     
/*     */     void close() {
/* 162 */       JsonString.this.buffer.append(this.array ? 93 : 125);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\JsonString.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */