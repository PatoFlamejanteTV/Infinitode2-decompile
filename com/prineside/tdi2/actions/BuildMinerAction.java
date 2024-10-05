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
/*    */ public class BuildMinerAction extends Action {
/*    */   public MinerType minerType;
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   private BuildMinerAction() {}
/*    */   
/*    */   public BuildMinerAction(MinerType paramMinerType, int paramInt1, int paramInt2) {
/* 22 */     this.minerType = paramMinerType;
/* 23 */     this.x = paramInt1;
/* 24 */     this.y = paramInt2;
/*    */   }
/*    */   
/*    */   public BuildMinerAction(JsonValue paramJsonValue) {
/* 28 */     this(
/* 29 */         MinerType.valueOf(paramJsonValue.getString("mt")), paramJsonValue
/* 30 */         .getInt("x"), paramJsonValue
/* 31 */         .getInt("y"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 37 */     return ActionType.BM;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 42 */     paramJson.writeValue("mt", this.minerType.name());
/* 43 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 44 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 49 */     paramKryo.writeObject(paramOutput, this.minerType);
/* 50 */     paramOutput.writeByte(this.x);
/* 51 */     paramOutput.writeByte(this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 56 */     this.minerType = (MinerType)paramKryo.readObject(paramInput, MinerType.class);
/* 57 */     this.x = paramInput.readByte();
/* 58 */     this.y = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return "BuildMiner " + this.minerType.name() + " " + this.x + " " + this.y;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\BuildMinerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */