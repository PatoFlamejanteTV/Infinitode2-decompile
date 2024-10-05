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
/*    */ public abstract class ThreeArgFunction
/*    */   extends LibFunction
/*    */ {
/*    */   public abstract LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3);
/*    */   
/*    */   public final LuaValue call() {
/* 58 */     return call(NIL, NIL, NIL);
/*    */   }
/*    */   
/*    */   public final LuaValue call(LuaValue paramLuaValue) {
/* 62 */     return call(paramLuaValue, NIL, NIL);
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 66 */     return call(paramLuaValue1, paramLuaValue2, NIL);
/*    */   }
/*    */   
/*    */   public Varargs invoke(Varargs paramVarargs) {
/* 70 */     return (Varargs)call(paramVarargs.arg1(), paramVarargs.arg(2), paramVarargs.arg(3));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\ThreeArgFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */