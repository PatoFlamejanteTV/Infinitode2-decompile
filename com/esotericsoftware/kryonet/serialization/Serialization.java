package com.esotericsoftware.kryonet.serialization;

import com.esotericsoftware.kryonet.Connection;
import java.nio.ByteBuffer;

public interface Serialization {
  void write(Connection paramConnection, ByteBuffer paramByteBuffer, Object paramObject);
  
  Object read(Connection paramConnection, ByteBuffer paramByteBuffer);
  
  int getLengthLength();
  
  void writeLength(ByteBuffer paramByteBuffer, int paramInt);
  
  int readLength(ByteBuffer paramByteBuffer);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\serialization\Serialization.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */