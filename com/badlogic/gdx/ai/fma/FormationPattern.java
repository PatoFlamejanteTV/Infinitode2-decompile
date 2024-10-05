package com.badlogic.gdx.ai.fma;

import com.badlogic.gdx.ai.utils.Location;

public interface FormationPattern<T extends com.badlogic.gdx.math.Vector<T>> {
  void setNumberOfSlots(int paramInt);
  
  Location<T> calculateSlotLocation(Location<T> paramLocation, int paramInt);
  
  boolean supportsSlots(int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\FormationPattern.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */