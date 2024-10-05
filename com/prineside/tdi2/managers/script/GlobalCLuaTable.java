/*    */ package com.prineside.tdi2.managers.script;
/*    */ 
/*    */ import com.prineside.luaj.LuaString;
/*    */ import com.prineside.luaj.LuaTable;
/*    */ import com.prineside.luaj.LuaValue;
/*    */ import com.prineside.luaj.Varargs;
/*    */ import com.prineside.tdi2.Game;
/*    */ import com.prineside.tdi2.serializers.SingletonSerializer;
/*    */ import com.prineside.tdi2.utils.REGS;
/*    */ 
/*    */ @REGS(serializer = GlobalCLuaTable.Serializer.class)
/*    */ public final class GlobalCLuaTable
/*    */   extends LuaTable
/*    */ {
/*    */   public static class Serializer
/*    */     extends SingletonSerializer<GlobalCLuaTable> {
/*    */     public GlobalCLuaTable read() {
/* 18 */       return Game.i.scriptManager.getGlobalCTable();
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public GlobalCLuaTable(LuaValue paramLuaValue) {
/* 25 */     loadFrom(paramLuaValue);
/*    */   }
/*    */   
/*    */   public final void loadFrom(LuaValue paramLuaValue) {
/* 29 */     presize(paramLuaValue.length(), 0);
/* 30 */     for (Varargs varargs = paramLuaValue.next(LuaValue.NIL); !varargs.arg1().isnil(); 
/* 31 */       varargs = paramLuaValue.next(varargs.arg1())) {
/* 32 */       LuaValue luaValue1 = varargs.arg1();
/* 33 */       LuaValue luaValue2 = varargs.arg(2);
/* 34 */       super.rawset(luaValue1, luaValue2.istable() ? (LuaValue)new GlobalCLuaTable(luaValue2) : luaValue2);
/*    */     } 
/*    */   }
/*    */   
/*    */   public final LuaValue setmetatable(LuaValue paramLuaValue) {
/* 39 */     return error("table is read-only");
/*    */   }
/*    */   public final void set(int paramInt, LuaValue paramLuaValue) {
/* 42 */     error("table is read-only");
/*    */   }
/*    */   public final void rawset(int paramInt, LuaValue paramLuaValue) {
/* 45 */     error("table is read-only");
/*    */   }
/*    */   public final void rawset(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 48 */     error("table is read-only");
/*    */   }
/*    */   public final LuaValue remove(int paramInt) {
/* 51 */     return error("table is read-only");
/*    */   }
/*    */   
/*    */   public final LuaValue tostring() {
/* 55 */     return (LuaValue)LuaString.valueOf("table: globalClassAliases");
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\managers\script\GlobalCLuaTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */