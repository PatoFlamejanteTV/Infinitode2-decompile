/*    */ package com.prineside.tdi2.actions;
/*    */ 
/*    */ import com.badlogic.gdx.utils.JsonValue;
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.Action;
/*    */ import com.prineside.tdi2.enums.ActionType;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public class CallWaveAction
/*    */   extends Action {
/*    */   public CallWaveAction() {}
/*    */   
/*    */   public CallWaveAction(JsonValue paramJsonValue) {}
/*    */   
/*    */   public ActionType getType() {
/* 19 */     return ActionType.CW;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(Kryo paramKryo, Output paramOutput) {}
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {}
/*    */ 
/*    */   
/*    */   public String toString() {
/* 30 */     return "CallWave";
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\actions\CallWaveAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */