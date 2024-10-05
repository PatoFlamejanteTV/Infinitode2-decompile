/*    */ package com.prineside.luaj;
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
/*    */ public abstract class LuaFunction
/*    */   extends LuaValue
/*    */ {
/*    */   public final int type() {
/* 39 */     return 6;
/*    */   }
/*    */   
/*    */   public final String typename() {
/* 43 */     return "function";
/*    */   }
/*    */   
/*    */   public final boolean isfunction() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public final LuaFunction checkfunction() {
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public final LuaFunction optfunction(LuaFunction paramLuaFunction) {
/* 55 */     return this;
/*    */   }
/*    */   
/*    */   public final LuaValue getmetatable() {
/* 59 */     return null;
/*    */   }
/*    */   
/*    */   public String tojstring() {
/* 63 */     return "function: " + classnamestub();
/*    */   }
/*    */   
/*    */   public final LuaString strvalue() {
/* 67 */     return valueOf(tojstring());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final String classnamestub() {
/*    */     String str;
/* 76 */     int i = Math.max((str = getClass().getName()).lastIndexOf('.'), str.lastIndexOf('$')) + 1;
/* 77 */     if (str.charAt(i) == '_') i++; 
/* 78 */     return str.substring(i);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String name() {
/* 85 */     return classnamestub();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\LuaFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */