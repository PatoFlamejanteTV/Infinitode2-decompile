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
/*    */ public class CoreUpgradeAction extends Action {
/*    */   public int x;
/*    */   public int y;
/*    */   public int col;
/*    */   public int row;
/*    */   
/*    */   private CoreUpgradeAction() {}
/*    */   
/*    */   public CoreUpgradeAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 22 */     this.x = paramInt1;
/* 23 */     this.y = paramInt2;
/* 24 */     this.col = paramInt3;
/* 25 */     this.row = paramInt4;
/*    */   }
/*    */   
/*    */   public CoreUpgradeAction(JsonValue paramJsonValue) {
/* 29 */     this(paramJsonValue
/* 30 */         .getInt("x"), paramJsonValue
/* 31 */         .getInt("y"), paramJsonValue
/* 32 */         .getInt("col"), paramJsonValue
/* 33 */         .getInt("row"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 39 */     return ActionType.CU;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 44 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 45 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/* 46 */     paramJson.writeValue("col", Integer.valueOf(this.col));
/* 47 */     paramJson.writeValue("row", Integer.valueOf(this.row));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 52 */     paramOutput.writeInt(this.x);
/* 53 */     paramOutput.writeInt(this.y);
/* 54 */     paramOutput.writeInt(this.col);
/* 55 */     paramOutput.writeInt(this.row);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 60 */     this.x = paramInput.readInt();
/* 61 */     this.y = paramInput.readInt();
/* 62 */     this.col = paramInput.readInt();
/* 63 */     this.row = paramInput.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     return "CoreUpgrade " + this.x + " " + this.y + " " + this.col + " " + this.row;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\CoreUpgradeAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */