/*    */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonReader;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.badlogic.gdx.utils.JsonWriter;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.io.StringWriter;
/*    */ import java.util.Locale;
/*    */ 
/*    */ public final class PP_SecretCode
/*    */   implements PrefSubcategory {
/* 16 */   private static final TLog a = TLog.forClass(PP_SecretCode.class);
/*    */   
/* 18 */   private final Array<String> b = new Array();
/*    */   
/*    */   public final boolean isCodeApplied(String paramString) {
/* 21 */     return this.b.contains(paramString, false);
/*    */   }
/*    */   
/*    */   public final synchronized void setCodeApplied(String paramString) {
/* 25 */     paramString = paramString.toLowerCase(Locale.US);
/* 26 */     if (!this.b.contains(paramString, false)) {
/* 27 */       this.b.add(paramString);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final void load(PrefMap paramPrefMap) {
/* 33 */     this.b.clear();
/*    */     String str;
/* 35 */     if ((str = paramPrefMap.get("appliedSecretCodes", null)) != null) {
/*    */       try {
/*    */         JsonValue jsonValue;
/* 38 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 39 */           this.b.add(jsonValue1.asString()); }
/*    */          return;
/* 41 */       } catch (Exception exception) {
/* 42 */         a.e("failed to parse applied codes", new Object[] { exception });
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 49 */     if (this.b.size != 0) {
/* 50 */       Json json = new Json(JsonWriter.OutputType.minimal);
/* 51 */       StringWriter stringWriter = new StringWriter();
/* 52 */       json.setWriter(stringWriter);
/* 53 */       json.writeArrayStart();
/* 54 */       for (byte b = 0; b < this.b.size; b++) {
/* 55 */         json.writeValue(this.b.get(b));
/*    */       }
/* 57 */       json.writeArrayEnd();
/*    */       
/* 59 */       paramPrefMap.set("appliedSecretCodes", stringWriter.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_SecretCode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */