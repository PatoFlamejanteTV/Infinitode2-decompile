/*    */ package com.prineside.luaj;
/*    */ 
/*    */ 
/*    */ class NonTableMetatable
/*    */   implements Metatable
/*    */ {
/*    */   private final LuaValue a;
/*    */   
/*    */   public NonTableMetatable(LuaValue paramLuaValue) {
/* 10 */     this.a = paramLuaValue;
/*    */   }
/*    */   
/*    */   public boolean useWeakKeys() {
/* 14 */     return false;
/*    */   }
/*    */   
/*    */   public boolean useWeakValues() {
/* 18 */     return false;
/*    */   }
/*    */   
/*    */   public LuaValue toLuaValue() {
/* 22 */     return this.a;
/*    */   }
/*    */   
/*    */   public LuaTable.Slot entry(LuaValue paramLuaValue1, LuaValue paramLuaValue2) {
/* 26 */     return LuaTable.a(paramLuaValue1, paramLuaValue2);
/*    */   }
/*    */   
/*    */   public LuaValue wrap(LuaValue paramLuaValue) {
/* 30 */     return paramLuaValue;
/*    */   }
/*    */   
/*    */   public LuaValue arrayget(LuaValue[] paramArrayOfLuaValue, int paramInt) {
/* 34 */     return paramArrayOfLuaValue[paramInt];
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\NonTableMetatable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */