/*    */ package com.prineside.luaj.lib;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.KryoSerializable;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.luaj.Globals;
/*    */ import com.prineside.luaj.LuaTable;
/*    */ import com.prineside.luaj.LuaValue;
/*    */ import com.prineside.luaj.Varargs;
/*    */ import com.prineside.luaj.debug.CallFrame;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS
/*    */ public final class DebugLib
/*    */   extends TwoArgFunction implements KryoSerializable {
/*    */   Globals a;
/*    */   
/*    */   public final void write(Kryo paramKryo, Output paramOutput) {
/* 20 */     super.write(paramKryo, paramOutput);
/* 21 */     paramKryo.writeObjectOrNull(paramOutput, this.a, Globals.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public final void read(Kryo paramKryo, Input paramInput) {
/* 26 */     super.read(paramKryo, paramInput);
/* 27 */     this.a = (Globals)paramKryo.readObjectOrNull(paramInput, Globals.class);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 39 */     this.a = paramLuaValue2.checkglobals();
/* 40 */     this.a.setDebugLib(this);
/*    */     LuaTable luaTable;
/* 42 */     (luaTable = new LuaTable()).set("traceback", (LuaValue)new traceback(this, (byte)0));
/* 43 */     paramLuaValue2.set("debug", (LuaValue)luaTable);
/* 44 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("debug", (LuaValue)luaTable); 
/* 45 */     return (LuaValue)luaTable;
/*    */   }
/*    */   
/*    */   @REGS
/*    */   public static final class traceback
/*    */     extends VarArgFunction
/*    */     implements KryoSerializable {
/*    */     private DebugLib a;
/*    */     
/*    */     public final void write(Kryo param1Kryo, Output param1Output) {
/* 55 */       param1Kryo.writeObject(param1Output, this.a);
/*    */     }
/*    */ 
/*    */     
/*    */     public final void read(Kryo param1Kryo, Input param1Input) {
/* 60 */       this.a = (DebugLib)param1Kryo.readObject(param1Input, DebugLib.class);
/*    */     }
/*    */     
/*    */     private traceback() {}
/*    */     
/*    */     private traceback(DebugLib param1DebugLib) {
/* 66 */       this.a = param1DebugLib;
/*    */     }
/*    */ 
/*    */     
/*    */     public final Varargs invoke(Varargs param1Varargs) {
/* 71 */       String str2 = param1Varargs.optjstring(1, null);
/* 72 */       int i = param1Varargs.optint(2, 1);
/* 73 */       String str1 = this.a.a.getCallstack().traceback(i);
/* 74 */       return (Varargs)valueOf((str2 != null) ? (str2 + "\n" + str1) : str1);
/*    */     }
/*    */   }
/*    */   
/*    */   public final String traceback(int paramInt) {
/* 79 */     return this.a.getCallstack().traceback(paramInt);
/*    */   }
/*    */   
/*    */   public final CallFrame getCallFrame(int paramInt) {
/* 83 */     return this.a.getCallstack().getCallFrame(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\DebugLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */