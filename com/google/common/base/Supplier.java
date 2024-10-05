package com.google.common.base;

@ElementTypesAreNonnullByDefault
public interface Supplier<T> {
  @ParametricNullness
  T get();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\google\common\base\Supplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */