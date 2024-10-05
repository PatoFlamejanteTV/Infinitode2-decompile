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
/*    */ public class SelectGameplayBonusAction extends Action {
/*    */   public int stage;
/*    */   public int bonusIdx;
/*    */   
/*    */   private SelectGameplayBonusAction() {}
/*    */   
/*    */   public SelectGameplayBonusAction(int paramInt1, int paramInt2) {
/* 20 */     this.stage = paramInt1;
/* 21 */     this.bonusIdx = paramInt2;
/*    */   }
/*    */   
/*    */   public SelectGameplayBonusAction(JsonValue paramJsonValue) {
/* 25 */     this(paramJsonValue
/* 26 */         .getInt("s"), paramJsonValue
/* 27 */         .getInt("bi"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 33 */     return ActionType.SGB;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 38 */     paramJson.writeValue("s", Integer.valueOf(this.stage));
/* 39 */     paramJson.writeValue("bi", Integer.valueOf(this.bonusIdx));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 44 */     paramOutput.writeVarInt(this.stage, true);
/* 45 */     paramOutput.writeVarInt(this.bonusIdx, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 50 */     this.stage = paramInput.readVarInt(true);
/* 51 */     this.bonusIdx = paramInput.readVarInt(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     return "SelectGameplayBonus " + this.stage + " " + this.bonusIdx;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\SelectGameplayBonusAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */