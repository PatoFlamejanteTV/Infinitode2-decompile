package com.badlogic.gdx;

import java.util.Map;

public interface Preferences {
  Preferences putBoolean(String paramString, boolean paramBoolean);
  
  Preferences putInteger(String paramString, int paramInt);
  
  Preferences putLong(String paramString, long paramLong);
  
  Preferences putFloat(String paramString, float paramFloat);
  
  Preferences putString(String paramString1, String paramString2);
  
  Preferences put(Map<String, ?> paramMap);
  
  boolean getBoolean(String paramString);
  
  int getInteger(String paramString);
  
  long getLong(String paramString);
  
  float getFloat(String paramString);
  
  String getString(String paramString);
  
  boolean getBoolean(String paramString, boolean paramBoolean);
  
  int getInteger(String paramString, int paramInt);
  
  long getLong(String paramString, long paramLong);
  
  float getFloat(String paramString, float paramFloat);
  
  String getString(String paramString1, String paramString2);
  
  Map<String, ?> get();
  
  boolean contains(String paramString);
  
  void clear();
  
  void remove(String paramString);
  
  void flush();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Preferences.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */