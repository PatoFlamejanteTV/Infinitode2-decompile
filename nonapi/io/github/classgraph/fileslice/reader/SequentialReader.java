package nonapi.io.github.classgraph.fileslice.reader;

public interface SequentialReader {
  byte readByte();
  
  int readUnsignedByte();
  
  short readShort();
  
  int readUnsignedShort();
  
  int readInt();
  
  long readUnsignedInt();
  
  long readLong();
  
  void skip(int paramInt);
  
  String readString(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  String readString(int paramInt);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\nonapi\io\github\classgraph\fileslice\reader\SequentialReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */