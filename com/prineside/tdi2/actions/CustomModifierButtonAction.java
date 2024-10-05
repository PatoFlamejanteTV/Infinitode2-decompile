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
/*    */ public class CustomModifierButtonAction extends Action {
/*    */   public int x;
/*    */   public int y;
/*    */   public int mapX;
/*    */   public int mapY;
/*    */   
/*    */   private CustomModifierButtonAction() {}
/*    */   
/*    */   public CustomModifierButtonAction(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 22 */     this.x = paramInt1;
/* 23 */     this.y = paramInt2;
/* 24 */     this.mapX = paramInt3;
/* 25 */     this.mapY = paramInt4;
/*    */   }
/*    */   
/*    */   public CustomModifierButtonAction(JsonValue paramJsonValue) {
/* 29 */     this(paramJsonValue
/* 30 */         .getInt("x"), paramJsonValue
/* 31 */         .getInt("y"), paramJsonValue
/* 32 */         .getInt("mx"), paramJsonValue
/* 33 */         .getInt("my"));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ActionType getType() {
/* 39 */     return ActionType.CMB;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 44 */     paramJson.writeValue("x", Integer.valueOf(this.x));
/* 45 */     paramJson.writeValue("y", Integer.valueOf(this.y));
/* 46 */     paramJson.writeValue("mx", Integer.valueOf(this.mapX));
/* 47 */     paramJson.writeValue("my", Integer.valueOf(this.mapY));
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 52 */     paramOutput.writeByte(this.x);
/* 53 */     paramOutput.writeByte(this.y);
/* 54 */     paramOutput.writeInt(this.mapX);
/* 55 */     paramOutput.writeInt(this.mapY);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 60 */     this.x = paramInput.readByte();
/* 61 */     this.y = paramInput.readByte();
/* 62 */     this.mapX = paramInput.readInt();
/* 63 */     this.mapY = paramInput.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 68 */     return "CustomModifierButton " + this.x + " " + this.y + " " + this.mapX + " " + this.mapY;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\CustomModifierButtonAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */