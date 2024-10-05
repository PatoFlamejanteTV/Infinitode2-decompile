/*   */ package com.prineside.luaj.lib;
/*   */ 
/*   */ import com.prineside.luaj.LuaValue;
/*   */ 
/*   */ class TableLibFunction extends LibFunction {
/*   */   public LuaValue call() {
/* 7 */     return argerror(1, "table expected, got no value");
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\TableLibFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */