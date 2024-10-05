/*    */ package com.prineside.tdi2.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Action;
/*    */ import com.prineside.tdi2.enums.AbilityType;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class UseAbilityAction extends Action {
/*    */   public AbilityType abilityType;
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   private UseAbilityAction() {}
/*    */   
/*    */   public UseAbilityAction(AbilityType paramAbilityType, int paramInt1, int paramInt2) {
/* 22 */     this.abilityType = paramAbilityType;
/* 23 */     this.x = paramInt1;
/* 24 */     this.y = paramInt2;
/*    */   }
/*    */   
/*    */   public UseAbilityAction(JsonValue paramJsonValue) {
/* 28 */     this(
/* 29 */         AbilityType.valueOf(paramJsonValue.getString("at")), paramJsonValue
/* 30 */         .getInt("x"), paramJsonValue
/* 31 */         .getInt("y"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 37 */     return ActionType.UA;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 42 */     paramJson.writeValue("at", this.abilityType.name());
/* 43 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 44 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 49 */     paramKryo.writeObject(paramOutput, this.abilityType);
/* 50 */     paramOutput.writeInt(this.x);
/* 51 */     paramOutput.writeInt(this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 56 */     this.abilityType = (AbilityType)paramKryo.readObject(paramInput, AbilityType.class);
/* 57 */     this.x = paramInput.readInt();
/* 58 */     this.y = paramInput.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return "UseAbility " + this.abilityType.name() + " " + this.x + " " + this.y;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\UseAbilityAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */