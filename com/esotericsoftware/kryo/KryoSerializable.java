package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public interface KryoSerializable {
  void write(Kryo paramKryo, Output paramOutput);
  
  void read(Kryo paramKryo, Input paramInput);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\KryoSerializable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */