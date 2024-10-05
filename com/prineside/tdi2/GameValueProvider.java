package com.prineside.tdi2;

import com.prineside.tdi2.enums.GameValueType;

public interface GameValueProvider {
  double getValue(GameValueType paramGameValueType);
  
  float getFloatValue(GameValueType paramGameValueType);
  
  boolean getBooleanValue(GameValueType paramGameValueType);
  
  int getIntValue(GameValueType paramGameValueType);
  
  int getIntValueSum(GameValueType paramGameValueType1, GameValueType paramGameValueType2);
  
  float getFloatValueSum(GameValueType paramGameValueType1, GameValueType paramGameValueType2);
  
  double getPercentValueAsMultiplier(GameValueType paramGameValueType);
  
  double getPercentValueAsMultiplierSum(GameValueType paramGameValueType1, GameValueType paramGameValueType2);
  
  double getPercentValueAsMultiplierSumAll(GameValueType[] paramArrayOfGameValueType);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\GameValueProvider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */