package com.prineside.tdi2.utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public interface NoFieldKryoSerializable extends KryoSerializable {
  default void write(Kryo paramKryo, Output paramOutput) {}
  
  default void read(Kryo paramKryo, Input paramInput) {}
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\NoFieldKryoSerializable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */