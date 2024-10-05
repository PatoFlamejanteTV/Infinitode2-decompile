/*    */ package com.prineside.tdi2.utils.luaTests;
/*    */ 
/*    */ public interface TestInterfaceWithDefaults {
/*    */   default String getAsStringDefaultMethod(int paramInt) {
/*  5 */     return Defaults.getAsStringDefaultMethod(this, paramInt);
/*    */   }
/*    */   
/*    */   int getIntMultipliedByTwo(int paramInt);
/*    */   
/*    */   public static final class Defaults {
/*    */     public static String getAsStringDefaultMethod(TestInterfaceWithDefaults param1TestInterfaceWithDefaults, int param1Int) {
/* 12 */       return "value as string: " + param1TestInterfaceWithDefaults.getIntMultipliedByTwo(param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\luaTests\TestInterfaceWithDefaults.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */