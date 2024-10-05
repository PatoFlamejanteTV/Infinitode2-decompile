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
/*    */ 
/*    */ 
/*    */ @REGS(arrayLevels = 1)
/*    */ public final class LocVars
/*    */   implements KryoSerializable
/*    */ {
/*    */   public LuaString varname;
/*    */   public int startpc;
/*    */   public int endpc;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 46 */     paramKryo.writeObjectOrNull(paramOutput, this.varname, LuaString.class);
/* 47 */     paramOutput.writeInt(this.startpc);
/* 48 */     paramOutput.writeInt(this.endpc);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 53 */     this.varname = (LuaString)paramKryo.readObjectOrNull(paramInput, LuaString.class);
/* 54 */     this.startpc = paramInput.readInt();
/* 55 */     this.endpc = paramInput.readInt();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private LocVars() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LocVars(LuaString paramLuaString, int paramInt1, int paramInt2) {
/* 67 */     this.varname = paramLuaString;
/* 68 */     this.startpc = paramInt1;
/* 69 */     this.endpc = paramInt2;
/*    */   }
/*    */   
/*    */   public final String tojstring() {
/* 73 */     return this.varname + " " + this.startpc + "-" + this.endpc;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LocVars.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */