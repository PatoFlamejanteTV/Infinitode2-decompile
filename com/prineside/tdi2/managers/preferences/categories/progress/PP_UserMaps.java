/*    */ package com.prineside.tdi2.managers.preferences.categories.progress;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonReader;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.badlogic.gdx.utils.JsonWriter;
/*    */ import com.prineside.tdi2.UserMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefMap;
/*    */ import com.prineside.tdi2.managers.preferences.PrefSubcategory;
/*    */ import com.prineside.tdi2.utils.logging.TLog;
/*    */ import java.io.StringWriter;
/*    */ 
/*    */ public class PP_UserMaps
/*    */   implements PrefSubcategory {
/* 16 */   private static final TLog a = TLog.forClass(PP_UserMaps.class);
/*    */   
/* 18 */   private final Array<UserMap> b = new Array(UserMap.class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Array<UserMap> getUserMapsOrdered() {
/* 24 */     return this.b;
/*    */   }
/*    */   
/*    */   public synchronized void addUserMap(UserMap paramUserMap) {
/* 28 */     this.b.add(paramUserMap);
/*    */   }
/*    */   
/*    */   public synchronized boolean removeUserMap(String paramString) {
/* 32 */     for (byte b = 0; b < this.b.size; b++) {
/* 33 */       if ((((UserMap[])this.b.items)[b]).id.equals(paramString)) {
/* 34 */         this.b.removeIndex(b);
/* 35 */         return true;
/*    */       } 
/*    */     } 
/* 38 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(PrefMap paramPrefMap) {
/* 43 */     this.b.clear();
/*    */     String str;
/* 45 */     if ((str = paramPrefMap.get("userMaps", null)) != null) {
/*    */       try {
/*    */         JsonValue jsonValue;
/* 48 */         for (JsonValue.JsonIterator<JsonValue> jsonIterator = (jsonValue = (new JsonReader()).parse(str)).iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue1 = jsonIterator.next();
/*    */           try {
/* 50 */             UserMap userMap = UserMap.fromJson(jsonValue1);
/* 51 */             this.b.add(userMap);
/* 52 */           } catch (Exception exception) {
/*    */             
/* 54 */             a.e("failed to parse user map", new Object[] { exception });
/*    */           }  }
/*    */       
/* 57 */       } catch (Exception exception) {
/* 58 */         a.e("failed to parse json: " + str, new Object[] { exception });
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/* 63 */     this.b.sort((paramUserMap1, paramUserMap2) -> (paramUserMap1.creationTimestamp == paramUserMap2.creationTimestamp) ? 0 : ((paramUserMap1.creationTimestamp > paramUserMap2.creationTimestamp) ? 1 : -1));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void save(PrefMap paramPrefMap) {
/* 74 */     if (this.b.size != 0) {
/* 75 */       Json json = new Json(JsonWriter.OutputType.minimal);
/* 76 */       StringWriter stringWriter = new StringWriter();
/* 77 */       json.setWriter(stringWriter);
/* 78 */       json.writeArrayStart();
/* 79 */       for (byte b = 0; b < this.b.size; b++) {
/* 80 */         json.writeObjectStart();
/* 81 */         ((UserMap[])this.b.items)[b].toJson(json);
/* 82 */         json.writeObjectEnd();
/*    */       } 
/* 84 */       json.writeArrayEnd();
/*    */       
/* 86 */       paramPrefMap.set("userMaps", stringWriter.toString());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\preferences\categories\progress\PP_UserMaps.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */