/*    */ package com.prineside.luaj.lib;
/*    */ 
/*    */ import com.prineside.luaj.LuaValue;
/*    */ import com.prineside.luaj.Varargs;
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
/*    */ public abstract class VarArgFunction
/*    */   extends LibFunction
/*    */ {
/*    */   public LuaValue call() {
/* 54 */     return invoke((Varargs)NONE).arg1();
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue) {
/* 58 */     return invoke((Varargs)paramLuaValue).arg1();
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 62 */     return invoke(varargsOf(paramLuaValue1, (Varargs)paramLuaValue2)).arg1();
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 66 */     return invoke(LuaValue.varargsOf(paramLuaValue1, paramLuaValue2, (Varargs)paramLuaValue3)).arg1();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Varargs invoke(Varargs paramVarargs) {
/* 77 */     return onInvoke(paramVarargs).eval();
/*    */   }
/*    */   
/*    */   public Varargs onInvoke(Varargs paramVarargs) {
/* 81 */     return invoke(paramVarargs);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\VarArgFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */