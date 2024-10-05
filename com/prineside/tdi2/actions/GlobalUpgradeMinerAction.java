/*    */ package com.prineside.tdi2.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Action;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.enums.MinerType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class GlobalUpgradeMinerAction extends Action {
/*    */   public MinerType minerType;
/*    */   
/*    */   private GlobalUpgradeMinerAction() {}
/*    */   
/*    */   public GlobalUpgradeMinerAction(MinerType paramMinerType) {
/* 20 */     this.minerType = paramMinerType;
/*    */   }
/*    */   
/*    */   public GlobalUpgradeMinerAction(JsonValue paramJsonValue) {
/* 24 */     this(
/* 25 */         MinerType.valueOf(paramJsonValue.getString("mt")));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 31 */     return ActionType.GUM;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 36 */     paramJson.writeValue("mt", this.minerType.name());
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 41 */     paramKryo.writeObject(paramOutput, this.minerType);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 46 */     this.minerType = (MinerType)paramKryo.readObject(paramInput, MinerType.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return "GlobalUpgradeMiner " + this.minerType.name();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\GlobalUpgradeMinerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */