/*    */ package com.prineside.luaj.lib.jse;
/*    */ 
/*    */ import com.prineside.luaj.LuaValue;
/*    */ import com.prineside.luaj.lib.BaseLib;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @REGS
/*    */ public final class JseBaseLib
/*    */   extends BaseLib
/*    */ {
/*    */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 77 */     super.call(paramLuaValue1, paramLuaValue2);
/* 78 */     (paramLuaValue2.checkglobals()).STDIN = System.in;
/* 79 */     return paramLuaValue2;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\jse\JseBaseLib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */