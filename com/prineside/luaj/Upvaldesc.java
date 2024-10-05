/*    */ package com.prineside.luaj;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public final class Upvaldesc
/*    */   implements KryoSerializable
/*    */ {
/*    */   public LuaString name;
/*    */   public boolean instack;
/*    */   public short idx;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 44 */     paramKryo.writeObjectOrNull(paramOutput, this.name, LuaString.class);
/* 45 */     paramOutput.writeBoolean(this.instack);
/* 46 */     paramOutput.writeShort(this.idx);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 51 */     this.name = (LuaString)paramKryo.readObjectOrNull(paramInput, LuaString.class);
/* 52 */     this.instack = paramInput.readBoolean();
/* 53 */     this.idx = paramInput.readShort();
/*    */   }
/*    */   
/*    */   private Upvaldesc() {}
/*    */   
/*    */   public Upvaldesc(LuaString paramLuaString, boolean paramBoolean, int paramInt) {
/* 59 */     this.name = paramLuaString;
/* 60 */     this.instack = paramBoolean;
/* 61 */     this.idx = (short)paramInt;
/*    */   }
/*    */   
/*    */   public final String toString() {
/* 65 */     return this.idx + (this.instack ? " instack " : " closed ") + String.valueOf(this.name);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Upvaldesc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */