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
/*    */ public class SelectTowerAbilityAction extends Action {
/*    */   public int x;
/*    */   public int y;
/*    */   public int abilityIndex;
/*    */   
/*    */   private SelectTowerAbilityAction() {}
/*    */   
/*    */   public SelectTowerAbilityAction(int paramInt1, int paramInt2, int paramInt3) {
/* 21 */     this.abilityIndex = paramInt1;
/* 22 */     this.x = paramInt2;
/* 23 */     this.y = paramInt3;
/*    */   }
/*    */   
/*    */   public SelectTowerAbilityAction(JsonValue paramJsonValue) {
/* 27 */     this(paramJsonValue
/* 28 */         .getInt("ai"), paramJsonValue
/* 29 */         .getInt("x"), paramJsonValue
/* 30 */         .getInt("y"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 36 */     return ActionType.STA;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 41 */     paramJson.writeValue("ai", Integer.valueOf(this.abilityIndex));
/* 42 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 43 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 48 */     paramOutput.writeByte(this.abilityIndex);
/* 49 */     paramOutput.writeByte(this.x);
/* 50 */     paramOutput.writeByte(this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 55 */     this.abilityIndex = paramInput.readByte();
/* 56 */     this.x = paramInput.readByte();
/* 57 */     this.y = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 62 */     return "SelectTowerAbility " + this.x + " " + this.y + " " + this.abilityIndex;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\SelectTowerAbilityAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */