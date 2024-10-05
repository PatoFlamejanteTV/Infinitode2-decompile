/*    */ package com.prineside.tdi2.managers.preferences.categories.settings;
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
/*    */ 
/*    */ public final class SP_Replay
/*    */   implements PrefSubcategory {
/* 15 */   private static final TLog a = TLog.forClass(SP_Replay.class);
/*    */   
/* 17 */   public final Array<String> sentReplayIds = new Array(false, 1, String.class);
/*    */ 
/*    */   
/*    */   public final void load(PrefMap paramPrefMap) {
/* 21 */     this.sentReplayIds.clear();
/*    */     
/*    */     String str;
/* 24 */     if ((str = paramPrefMap.get("sentGameReplaysToServer", null)) != null) {
/*    */       try {
/*    */         JsonValue jsonValue;
/* 27 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/* 28 */           this.sentReplayIds.add(jsonValue1.asString()); }
/*    */         
/* 30 */         a.i("loaded " + this.sentReplayIds.size + " replay IDs sent to the server", new Object[0]); return;
/* 31 */       } catch (Exception exception) {
/* 32 */         a.e("failed to parse json: " + str, new Object[] { exception });
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public final synchronized void save(PrefMap paramPrefMap) {
/* 39 */     Json json = new Json(JsonWriter.OutputType.minimal);
/* 40 */     StringWriter stringWriter = new StringWriter();
/* 41 */     json.setWriter(stringWriter);
/* 42 */     json.writeArrayStart();
/* 43 */     for (byte b = 0; b < this.sentReplayIds.size; b++) {
/* 44 */       json.writeValue(this.sentReplayIds.get(b));
/*    */     }
/* 46 */     json.writeArrayEnd();
/*    */     
/* 48 */     paramPrefMap.set("sentGameReplaysToServer", stringWriter.toString());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\settings\SP_Replay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */