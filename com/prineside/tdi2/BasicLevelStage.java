/*    */ package com.prineside.tdi2;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Color;
/*    */ import com.badlogic.gdx.utils.Array;
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ 
/*    */ 
/*    */ public class BasicLevelStage
/*    */ {
/*    */   public String name;
/*    */   public boolean regular = true;
/*    */   public Color color;
/*    */   public String titleAlias;
/* 15 */   public final Array<Requirement> showRequirements = new Array();
/* 16 */   public final Array<BasicLevel> levels = new Array(true, 1, BasicLevel.class);
/*    */   
/*    */   public BasicLevelStage(String paramString1, Color paramColor, String paramString2) {
/* 19 */     this.name = paramString1;
/* 20 */     this.color = paramColor;
/* 21 */     this.titleAlias = paramString2;
/*    */   }
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 25 */     paramJson.writeValue("name", this.name);
/* 26 */     paramJson.writeValue("title", this.titleAlias);
/* 27 */     paramJson.writeValue("regular", Boolean.valueOf(this.regular));
/* 28 */     paramJson.writeValue("color", "#" + this.color.toString().substring(0, 6));
/* 29 */     paramJson.writeArrayStart("showRequirements");
/* 30 */     for (byte b = 0; b < this.showRequirements.size; b++) {
/* 31 */       Requirement requirement = (Requirement)this.showRequirements.get(b);
/* 32 */       paramJson.writeObjectStart();
/* 33 */       requirement.toJson(paramJson);
/* 34 */       paramJson.writeObjectEnd();
/*    */     } 
/* 36 */     paramJson.writeArrayEnd();
/*    */   }
/*    */   
/*    */   public void sortLevels() {
/* 40 */     for (byte b = 0; b < this.levels.size; b++) {
/* 41 */       for (int i = b + 1; i < this.levels.size; i++) {
/* 42 */         if ((((BasicLevel[])this.levels.items)[b]).stagePosition > (((BasicLevel[])this.levels.items)[i]).stagePosition) {
/* 43 */           this.levels.swap(b, i);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 50 */     if (Game.i.localeManager.i18n.has(this.titleAlias)) {
/* 51 */       return Game.i.localeManager.i18n.get(this.titleAlias);
/*    */     }
/* 53 */     return this.titleAlias;
/*    */   }
/*    */ 
/*    */   
/*    */   public static BasicLevelStage fromJson(JsonValue paramJsonValue) {
/* 58 */     String str1 = paramJsonValue.getString("name");
/* 59 */     String str2 = paramJsonValue.getString("title");
/* 60 */     boolean bool = paramJsonValue.getBoolean("regular", false);
/*    */     Color color;
/* 62 */     Color.rgb888ToColor(color = new Color(), Integer.parseInt(paramJsonValue.getString("color").substring(1), 16));
/* 63 */     color.a = 1.0F;
/*    */     BasicLevelStage basicLevelStage;
/* 65 */     (basicLevelStage = new BasicLevelStage(str1, color, str2)).regular = bool;
/*    */ 
/*    */     
/* 68 */     for (JsonValue.JsonIterator<JsonValue> jsonIterator = paramJsonValue.get("showRequirements").iterator(); jsonIterator.hasNext(); ) { JsonValue jsonValue = jsonIterator.next();
/* 69 */       basicLevelStage.showRequirements.add(Requirement.fromJson(jsonValue)); }
/*    */ 
/*    */     
/* 72 */     return basicLevelStage;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\BasicLevelStage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */