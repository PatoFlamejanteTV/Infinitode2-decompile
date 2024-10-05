/*    */ package com.prineside.tdi2.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.Json;
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Action;
/*    */ import com.prineside.tdi2.Tower;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.enums.TowerType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class BuildTowerAction extends Action {
/*    */   public TowerType towerType;
/*    */   public Tower.AimStrategy aimStrategy;
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   private BuildTowerAction() {}
/*    */   
/*    */   public BuildTowerAction(TowerType paramTowerType, Tower.AimStrategy paramAimStrategy, int paramInt1, int paramInt2) {
/* 24 */     this.towerType = paramTowerType;
/* 25 */     this.aimStrategy = paramAimStrategy;
/* 26 */     this.x = paramInt1;
/* 27 */     this.y = paramInt2;
/*    */   }
/*    */   
/*    */   public BuildTowerAction(JsonValue paramJsonValue) {
/* 31 */     this(
/* 32 */         TowerType.valueOf(paramJsonValue.getString("tt")), 
/* 33 */         Tower.AimStrategy.valueOf(paramJsonValue.getString("aim")), paramJsonValue
/* 34 */         .getInt("x"), paramJsonValue
/* 35 */         .getInt("y"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 41 */     return ActionType.BT;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 46 */     paramJson.writeValue("tt", this.towerType.name());
/* 47 */     paramJson.writeValue("aim", this.aimStrategy.name());
/* 48 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 49 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 54 */     paramKryo.writeObject(paramOutput, this.towerType);
/* 55 */     paramKryo.writeObject(paramOutput, this.aimStrategy);
/* 56 */     paramOutput.writeByte(this.x);
/* 57 */     paramOutput.writeByte(this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 62 */     this.towerType = (TowerType)paramKryo.readObject(paramInput, TowerType.class);
/* 63 */     this.aimStrategy = (Tower.AimStrategy)paramKryo.readObject(paramInput, Tower.AimStrategy.class);
/* 64 */     this.x = paramInput.readByte();
/* 65 */     this.y = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     return "BuildTower " + this.towerType.name() + " " + this.x + " " + this.y + " " + this.aimStrategy.name();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\BuildTowerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */