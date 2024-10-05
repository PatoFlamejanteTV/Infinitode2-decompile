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
/*    */ public class CustomAction
/*    */   extends Action {
/*    */   public int i1;
/*    */   public int i2;
/*    */   public int i3;
/*    */   public int i4;
/*    */   
/*    */   public CustomAction(JsonValue paramJsonValue) {
/* 21 */     this.i1 = paramJsonValue.getInt("i1", 0);
/* 22 */     this.i2 = paramJsonValue.getInt("i2", 0);
/* 23 */     this.i3 = paramJsonValue.getInt("i3", 0);
/* 24 */     this.i4 = paramJsonValue.getInt("i4", 0);
/* 25 */     this.d1 = paramJsonValue.getInt("d1", 0);
/* 26 */     this.d2 = paramJsonValue.getInt("d2", 0);
/* 27 */     this.s = paramJsonValue.getString("s", null);
/*    */   }
/*    */   public double d1; public double d2; public String s;
/*    */   private CustomAction() {}
/*    */   public ActionType getType() {
/* 32 */     return ActionType.C;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toJson(Json paramJson) {
/* 37 */     if (this.i1 != 0) paramJson.writeValue("i1", Integer.valueOf(this.i1)); 
/* 38 */     if (this.i2 != 0) paramJson.writeValue("i2", Integer.valueOf(this.i2)); 
/* 39 */     if (this.i3 != 0) paramJson.writeValue("i3", Integer.valueOf(this.i3)); 
/* 40 */     if (this.i4 != 0) paramJson.writeValue("i4", Integer.valueOf(this.i4)); 
/* 41 */     if (this.d1 != 0.0D) paramJson.writeValue("d1", Double.valueOf(this.d1)); 
/* 42 */     if (this.d2 != 0.0D) paramJson.writeValue("d2", Double.valueOf(this.d2)); 
/* 43 */     if (this.s != null) paramJson.writeValue("s", this.s);
/*    */   
/*    */   }
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 48 */     paramOutput.writeVarInt(this.i1, true);
/* 49 */     paramOutput.writeVarInt(this.i2, true);
/* 50 */     paramOutput.writeVarInt(this.i3, true);
/* 51 */     paramOutput.writeVarInt(this.i4, true);
/* 52 */     paramOutput.writeDouble(this.d1);
/* 53 */     paramOutput.writeDouble(this.d2);
/* 54 */     paramOutput.writeString(this.s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 59 */     this.i1 = paramInput.readVarInt(true);
/* 60 */     this.i2 = paramInput.readVarInt(true);
/* 61 */     this.i3 = paramInput.readVarInt(true);
/* 62 */     this.i4 = paramInput.readVarInt(true);
/* 63 */     this.d1 = paramInput.readDouble();
/* 64 */     this.d2 = paramInput.readDouble();
/* 65 */     this.s = paramInput.readString();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     return "Custom " + this.i1 + " " + this.i2 + " " + this.i3 + " " + this.i4 + " " + this.d1 + " " + this.d2 + " " + this.s;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\CustomAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */