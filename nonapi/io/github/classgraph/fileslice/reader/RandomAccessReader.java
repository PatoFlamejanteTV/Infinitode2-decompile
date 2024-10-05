package nonapi.io.github.classgraph.fileslice.reader;

import java.nio.ByteBuffer;

public interface RandomAccessReader {
  int read(long paramLong, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  int read(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  byte readByte(long paramLong);
  
  int readUnsignedByte(long paramLong);
  
  short readShort(long paramLong);
  
  int readUnsignedShort(long paramLong);
  
  int readInt(long paramLong);
  
  long readUnsignedInt(long paramLong);
  
  long readLong(long paramLong);
  
  String readString(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  String readString(long paramLong, int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\reader\RandomAccessReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */