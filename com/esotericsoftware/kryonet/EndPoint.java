package com.esotericsoftware.kryonet;

import com.esotericsoftware.kryo.Kryo;

public interface EndPoint extends Runnable {
  void addListener(Listener paramListener);
  
  void removeListener(Listener paramListener);
  
  void run();
  
  void start();
  
  void stop();
  
  void close();
  
  void update(int paramInt);
  
  Thread getUpdateThread();
  
  Kryo getKryo();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\EndPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */