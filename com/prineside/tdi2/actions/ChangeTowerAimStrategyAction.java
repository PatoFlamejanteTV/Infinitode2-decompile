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
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class ChangeTowerAimStrategyAction extends Action {
/*    */   public int x;
/*    */   public int y;
/*    */   public Tower.AimStrategy aimStrategy;
/*    */   
/*    */   private ChangeTowerAimStrategyAction() {}
/*    */   
/*    */   public ChangeTowerAimStrategyAction(int paramInt1, int paramInt2, Tower.AimStrategy paramAimStrategy) {
/* 22 */     this.x = paramInt1;
/* 23 */     this.y = paramInt2;
/* 24 */     this.aimStrategy = paramAimStrategy;
/*    */   }
/*    */   
/*    */   public ChangeTowerAimStrategyAction(JsonValue paramJsonValue) {
/* 28 */     this(paramJsonValue
/* 29 */         .getInt("x"), paramJsonValue
/* 30 */         .getInt("y"), 
/* 31 */         Tower.AimStrategy.valueOf(paramJsonValue.getString("aim")));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 37 */     return ActionType.CTAS;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 42 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 43 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/* 44 */     paramJson.writeValue("aim", this.aimStrategy.name());
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 49 */     paramKryo.writeObject(paramOutput, this.aimStrategy);
/* 50 */     paramOutput.writeByte(this.x);
/* 51 */     paramOutput.writeByte(this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 56 */     this.aimStrategy = (Tower.AimStrategy)paramKryo.readObject(paramInput, Tower.AimStrategy.class);
/* 57 */     this.x = paramInput.readByte();
/* 58 */     this.y = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 63 */     return "ChangeTowerAimStrategy " + this.aimStrategy.name() + " " + this.x + " " + this.y;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\ChangeTowerAimStrategyAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */