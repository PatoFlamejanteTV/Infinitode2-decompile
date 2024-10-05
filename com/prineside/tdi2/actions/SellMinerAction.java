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
/*    */ public class SellMinerAction extends Action {
/*    */   public int x;
/*    */   public int y;
/*    */   
/*    */   private SellMinerAction() {}
/*    */   
/*    */   public SellMinerAction(int paramInt1, int paramInt2) {
/* 20 */     this.x = paramInt1;
/* 21 */     this.y = paramInt2;
/*    */   }
/*    */   
/*    */   public SellMinerAction(JsonValue paramJsonValue) {
/* 25 */     this(paramJsonValue
/* 26 */         .getInt("x"), paramJsonValue
/* 27 */         .getInt("y"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 33 */     return ActionType.SM;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 38 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 39 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 44 */     paramOutput.writeByte(this.x);
/* 45 */     paramOutput.writeByte(this.y);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 50 */     this.x = paramInput.readByte();
/* 51 */     this.y = paramInput.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 56 */     return "SellMiner " + this.x + " " + this.y;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\SellMinerAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */