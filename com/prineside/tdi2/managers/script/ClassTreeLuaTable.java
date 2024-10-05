/*    */ package com.prineside.tdi2.managers.script;
/*    */ 
/*    */ import com.esotericsoftware.kryo.Kryo;
/*    */ import com.esotericsoftware.kryo.io.Input;
/*    */ import com.esotericsoftware.kryo.io.Output;
/*    */ import com.prineside.luaj.LuaString;
/*    */ import com.prineside.luaj.LuaTable;
/*    */ import com.prineside.luaj.LuaValue;
/*    */ import com.prineside.luaj.Varargs;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS
/*    */ public class ClassTreeLuaTable
/*    */   extends LuaTable
/*    */ {
/*    */   public void write(Kryo paramKryo, Output paramOutput) {
/* 21 */     paramOutput.writeString(get((LuaValue)LuaString.valueOf("_classTreePath")).tojstring());
/*    */   }
/*    */ 
/*    */   
/*    */   public void read(Kryo paramKryo, Input paramInput) {
/* 26 */     String str = paramInput.readString();
/* 27 */     Game.i.scriptManager.restoreClassTreePath(str, this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected ClassTreeLuaTable() {}
/*    */ 
/*    */   
/*    */   public ClassTreeLuaTable(LuaValue paramLuaValue) {
/* 36 */     loadFrom(paramLuaValue);
/*    */   }
/*    */   
/*    */   public void loadFrom(LuaValue paramLuaValue) {
/* 40 */     presize(paramLuaValue.length(), 0);
/* 41 */     for (Varargs varargs = paramLuaValue.next(LuaValue.NIL); !varargs.arg1().isnil(); 
/* 42 */       varargs = paramLuaValue.next(varargs.arg1())) {
/* 43 */       LuaValue luaValue1 = varargs.arg1();
/* 44 */       LuaValue luaValue2 = varargs.arg(2);
/* 45 */       super.rawset(luaValue1, luaValue2.istable() ? (LuaValue)new ClassTreeLuaTable(luaValue2) : luaValue2);
/*    */     } 
/*    */   }
/*    */   
/*    */   public LuaValue setmetatable(LuaValue paramLuaValue) {
/* 50 */     return error("table is read-only");
/*    */   }
/*    */   public void set(int paramInt, LuaValue paramLuaValue) {
/* 53 */     error("table is read-only");
/*    */   }
/*    */   public void rawset(int paramInt, LuaValue paramLuaValue) {
/* 56 */     error("table is read-only");
/*    */   }
/*    */   public void rawset(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 59 */     error("table is read-only");
/*    */   }
/*    */   public LuaValue remove(int paramInt) {
/* 62 */     return error("table is read-only");
/*    */   }
/*    */   
/*    */   public LuaValue tostring() {
/* 66 */     return (LuaValue)LuaString.valueOf("table: classTree@" + get("_classTreePath").tojstring());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\ClassTreeLuaTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */