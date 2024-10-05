/*     */ package com.prineside.luaj.lib;
/*     */ 
/*     */ import com.prineside.luaj.LuaTable;
/*     */ import com.prineside.luaj.LuaValue;
/*     */ import com.prineside.luaj.Varargs;
/*     */ import com.prineside.tdi2.utils.REGS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableLib
/*     */   extends TwoArgFunction
/*     */ {
/*     */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/*     */     LuaTable luaTable;
/*  66 */     (luaTable = new LuaTable()).set("concat", (LuaValue)new concat());
/*  67 */     luaTable.set("insert", (LuaValue)new insert());
/*  68 */     luaTable.set("pack", (LuaValue)new pack());
/*  69 */     luaTable.set("remove", (LuaValue)new remove());
/*  70 */     luaTable.set("sort", (LuaValue)new sort());
/*  71 */     luaTable.set("unpack", (LuaValue)new unpack());
/*  72 */     paramLuaValue2.set("table", (LuaValue)luaTable);
/*  73 */     if (!paramLuaValue2.get("package").isnil()) paramLuaValue2.get("package").get("loaded").set("table", (LuaValue)luaTable); 
/*  74 */     return NIL;
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class concat
/*     */     extends TableLibFunction {
/*     */     public LuaValue call(LuaValue param1LuaValue) {
/*  81 */       return param1LuaValue.checktable().concat(EMPTYSTRING, 1, param1LuaValue.length());
/*     */     }
/*     */     public LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2) {
/*  84 */       return param1LuaValue1.checktable().concat(param1LuaValue2.checkstring(), 1, param1LuaValue1.length());
/*     */     }
/*     */     public LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaValue param1LuaValue3) {
/*  87 */       return param1LuaValue1.checktable().concat(param1LuaValue2.checkstring(), param1LuaValue3.checkint(), param1LuaValue1.length());
/*     */     }
/*     */     public LuaValue call(LuaValue param1LuaValue1, LuaValue param1LuaValue2, LuaValue param1LuaValue3, LuaValue param1LuaValue4) {
/*  90 */       return param1LuaValue1.checktable().concat(param1LuaValue2.checkstring(), param1LuaValue3.checkint(), param1LuaValue4.checkint());
/*     */     } }
/*     */   
/*     */   @REGS
/*     */   public static class insert extends VarArgFunction { public Varargs invoke(Varargs param1Varargs) {
/*     */       LuaTable luaTable;
/*     */       int i;
/*     */       int j;
/*  98 */       switch (param1Varargs.narg()) {
/*     */         
/*     */         case 2:
/* 101 */           (luaTable = param1Varargs.checktable(1)).insert(luaTable.length() + 1, param1Varargs.arg(2));
/* 102 */           return (Varargs)NONE;
/*     */         
/*     */         case 3:
/* 105 */           luaTable = param1Varargs.checktable(1);
/* 106 */           i = param1Varargs.checkint(2);
/* 107 */           j = luaTable.length() + 1;
/* 108 */           if (i <= 0 || i > j) argerror(2, "position out of bounds: " + i + " not between 1 and " + j); 
/* 109 */           luaTable.insert(i, param1Varargs.arg(3));
/* 110 */           return (Varargs)NONE;
/*     */       } 
/*     */       
/* 113 */       return (Varargs)error("wrong number of arguments to 'table.insert': " + param1Varargs.narg() + " (must be 2 or 3)");
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   @REGS
/*     */   public static class pack
/*     */     extends VarArgFunction
/*     */   {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/*     */       LuaTable luaTable;
/* 124 */       (luaTable = tableOf(param1Varargs, 1)).set("n", param1Varargs.narg());
/* 125 */       return (Varargs)luaTable;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class remove
/*     */     extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/*     */       LuaTable luaTable;
/* 134 */       int j = (luaTable = param1Varargs.checktable(1)).length();
/*     */       int i;
/* 136 */       if ((i = param1Varargs.optint(2, j)) != j && (i <= 0 || i > j + 1)) {
/* 137 */         argerror(2, "position out of bounds: " + i + " not between 1 and " + (j + 1));
/*     */       }
/* 139 */       return (Varargs)luaTable.remove(i);
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class sort
/*     */     extends VarArgFunction {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 147 */       param1Varargs.checktable(1).sort(
/* 148 */           param1Varargs.isnil(2) ? NIL : (LuaValue)param1Varargs.checkfunction(2));
/* 149 */       return (Varargs)NONE;
/*     */     }
/*     */   }
/*     */   
/*     */   @REGS
/*     */   public static class unpack
/*     */     extends VarArgFunction
/*     */   {
/*     */     public Varargs invoke(Varargs param1Varargs) {
/* 158 */       LuaTable luaTable = param1Varargs.checktable(1);
/*     */       
/* 160 */       boolean bool = param1Varargs.arg(3).isnil() ? luaTable.length() : false;
/* 161 */       return luaTable.unpack(param1Varargs.optint(2, 1), param1Varargs.optint(3, bool));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\TableLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */