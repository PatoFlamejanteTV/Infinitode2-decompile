package com.google.common.base;

@ElementTypesAreNonnullByDefault
public interface Function<F, T> {
  @ParametricNullness
  T apply(@ParametricNullness F paramF);
  
  boolean equals(Object paramObject);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Function.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */