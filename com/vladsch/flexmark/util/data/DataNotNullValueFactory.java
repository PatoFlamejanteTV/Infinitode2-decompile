package com.vladsch.flexmark.util.data;

public interface DataNotNullValueFactory<T> extends DataValueFactory<T> {
  T apply(DataHolder paramDataHolder);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataNotNullValueFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */