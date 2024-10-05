package com.prineside.luaj;

interface Metatable {
  boolean useWeakKeys();
  
  boolean useWeakValues();
  
  LuaValue toLuaValue();
  
  LuaTable.Slot entry(LuaValue paramLuaValue1, LuaValue paramLuaValue2);
  
  LuaValue wrap(LuaValue paramLuaValue);
  
  LuaValue arrayget(LuaValue[] paramArrayOfLuaValue, int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Metatable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */