/*    */ package com.prineside.tdi2.managers.script;
/*    */ 
/*    */ import com.prineside.luaj.LuaTable;
/*    */ import com.prineside.luaj.LuaValue;
/*    */ import com.prineside.luaj.Varargs;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ 
/*    */ @REGS
/*    */ public class ReadOnlyLuaTable
/*    */   extends LuaTable
/*    */ {
/*    */   protected ReadOnlyLuaTable() {}
/*    */   
/*    */   public ReadOnlyLuaTable(LuaValue paramLuaValue) {
/* 16 */     presize(paramLuaValue.length(), 0);
/* 17 */     for (Varargs varargs = paramLuaValue.next(LuaValue.NIL); !varargs.arg1().isnil(); 
/* 18 */       varargs = paramLuaValue.next(varargs.arg1())) {
/* 19 */       LuaValue luaValue1 = varargs.arg1();
/* 20 */       LuaValue luaValue2 = varargs.arg(2);
/* 21 */       super.rawset(luaValue1, luaValue2.istable() ? (LuaValue)new ReadOnlyLuaTable(luaValue2) : luaValue2);
/*    */     } 
/*    */   }
/* 24 */   public LuaValue setmetatable(LuaValue paramLuaValue) { return error("table is read-only"); }
/* 25 */   public void set(int paramInt, LuaValue paramLuaValue) { error("table is read-only"); }
/* 26 */   public void rawset(int paramInt, LuaValue paramLuaValue) { error("table is read-only"); }
/* 27 */   public void rawset(LuaValue paramLuaValue1, LuaValue paramLuaValue2) { error("table is read-only"); } public LuaValue remove(int paramInt) {
/* 28 */     return error("table is read-only");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\ReadOnlyLuaTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */