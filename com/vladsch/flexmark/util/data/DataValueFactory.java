package com.vladsch.flexmark.util.data;

import java.util.function.Function;

public interface DataValueFactory<T> extends Function<DataHolder, T> {
  T apply(DataHolder paramDataHolder);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataValueFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */