/*    */ package com.prineside.tdi2.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Action;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class ScriptAction extends Action {
/*    */   public String script;
/*    */   
/*    */   private ScriptAction() {}
/*    */   
/*    */   public ScriptAction(String paramString) {
/* 19 */     this.script = paramString;
/*    */   }
/*    */   
/*    */   public ScriptAction(JsonValue paramJsonValue) {
/* 23 */     this(paramJsonValue
/* 24 */         .getString("s"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 30 */     return ActionType.S;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 35 */     paramJson.writeValue("s", this.script);
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 40 */     paramOutput.writeString(this.script);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 45 */     this.script = paramInput.readString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 50 */     return "Script " + this.script;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\ScriptAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */