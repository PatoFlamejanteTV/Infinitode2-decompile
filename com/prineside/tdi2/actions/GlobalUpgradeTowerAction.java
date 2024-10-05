/*    */ package com.prineside.tdi2.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Action;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.enums.TowerType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class GlobalUpgradeTowerAction extends Action {
/*    */   public TowerType towerType;
/*    */   
/*    */   private GlobalUpgradeTowerAction() {}
/*    */   
/*    */   public GlobalUpgradeTowerAction(TowerType paramTowerType) {
/* 20 */     this.towerType = paramTowerType;
/*    */   }
/*    */   
/*    */   public GlobalUpgradeTowerAction(JsonValue paramJsonValue) {
/* 24 */     this(
/* 25 */         TowerType.valueOf(paramJsonValue.getString("tt")));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 31 */     return ActionType.GUT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 36 */     paramJson.writeValue("tt", this.towerType.name());
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 41 */     paramKryo.writeObject(paramOutput, this.towerType);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 46 */     this.towerType = (TowerType)paramKryo.readObject(paramInput, TowerType.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 51 */     return "GlobalUpgradeTower " + this.towerType.name();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\GlobalUpgradeTowerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */