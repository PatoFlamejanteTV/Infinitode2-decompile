package com.prineside.tdi2.utils.syncchecker;

public abstract class DeepClassComparator<T> {
  public abstract Class<T> forClass();
  
  public abstract void compare(T paramT1, T paramT2, DeepClassComparisonConfig paramDeepClassComparisonConfig);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\DeepClassComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */