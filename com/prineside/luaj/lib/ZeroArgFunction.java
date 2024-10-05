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
/*    */ public abstract class ZeroArgFunction
/*    */   extends LibFunction
/*    */ {
/*    */   public abstract LuaValue call();
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue) {
/* 56 */     return call();
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 60 */     return call();
/*    */   }
/*    */   
/*    */   public LuaValue call(LuaValue paramLuaValue1, LuaValue paramLuaValue2, LuaValue paramLuaValue3) {
/* 64 */     return call();
/*    */   }
/*    */   
/*    */   public Varargs invoke(Varargs paramVarargs) {
/* 68 */     return (Varargs)call();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\lib\ZeroArgFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */