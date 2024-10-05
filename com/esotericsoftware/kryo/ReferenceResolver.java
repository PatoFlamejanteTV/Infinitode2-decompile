package com.esotericsoftware.kryo;

public interface ReferenceResolver {
  void setKryo(Kryo paramKryo);
  
  int getWrittenId(Object paramObject);
  
  int addWrittenObject(Object paramObject);
  
  int nextReadId(Class paramClass);
  
  void setReadObject(int paramInt, Object paramObject);
  
  Object getReadObject(Class paramClass, int paramInt);
  
  void reset();
  
  boolean useReferences(Class paramClass);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\ReferenceResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */