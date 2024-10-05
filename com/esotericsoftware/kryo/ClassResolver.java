package com.esotericsoftware.kryo;

import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public interface ClassResolver {
  void setKryo(Kryo paramKryo);
  
  Registration register(Registration paramRegistration);
  
  Registration unregister(int paramInt);
  
  Registration registerImplicit(Class paramClass);
  
  Registration getRegistration(Class paramClass);
  
  Registration getRegistration(int paramInt);
  
  Registration writeClass(Output paramOutput, Class paramClass);
  
  Registration readClass(Input paramInput);
  
  void reset();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryo\ClassResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */