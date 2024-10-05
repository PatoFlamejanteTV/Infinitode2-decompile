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
/*    */ 
/*    */ 
/*    */ public abstract class OneArgFunction
/*    */   extends LibFunction
/*    */ {
/*    */   public abstract LuaValue call(LuaValue paramLuaValue);
/*    */   
/*    */   public final LuaValue call() {
/* 58 */     return call(NIL);
/*    */   }
/*    */   
/*    */   public final LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 62 */     return call(paramLuaValue1);
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 66 */     return call(paramLuaValue1);
/*    */   }
/*    */   
/*    */   public Varargs invoke(Varargs paramVarargs) {
/* 70 */     return (Varargs)call(paramVarargs.arg1());
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\OneArgFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */