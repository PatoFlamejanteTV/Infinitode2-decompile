package com.esotericsoftware.kryonet.rmi;

import com.esotericsoftware.kryonet.Connection;

public interface RemoteObject {
  void setResponseTimeout(int paramInt);
  
  void setNonBlocking(boolean paramBoolean);
  
  void setTransmitReturnValue(boolean paramBoolean);
  
  void setTransmitExceptions(boolean paramBoolean);
  
  void setUDP(boolean paramBoolean);
  
  void setRemoteToString(boolean paramBoolean);
  
  Object waitForLastResponse();
  
  Object hasLastResponse();
  
  byte getLastResponseID();
  
  Object waitForResponse(byte paramByte);
  
  Object hasResponse(byte paramByte);
  
  void close();
  
  Connection getConnection();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kryonet\rmi\RemoteObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */