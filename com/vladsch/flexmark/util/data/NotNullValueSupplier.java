package com.vladsch.flexmark.util.data;

import java.util.function.Supplier;

public interface NotNullValueSupplier<T> extends Supplier<T> {
  T get();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\NotNullValueSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */