package com.badlogic.gdx.ai.fma;

import com.badlogic.gdx.utils.Array;

public interface SlotAssignmentStrategy<T extends com.badlogic.gdx.math.Vector<T>> {
  void updateSlotAssignments(Array<SlotAssignment<T>> paramArray);
  
  int calculateNumberOfSlots(Array<SlotAssignment<T>> paramArray);
  
  void removeSlotAssignment(Array<SlotAssignment<T>> paramArray, int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fma\SlotAssignmentStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */