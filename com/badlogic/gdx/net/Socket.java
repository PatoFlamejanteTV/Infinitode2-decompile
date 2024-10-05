package com.badlogic.gdx.net;

import com.badlogic.gdx.utils.Disposable;
import java.io.InputStream;
import java.io.OutputStream;

public interface Socket extends Disposable {
  boolean isConnected();
  
  InputStream getInputStream();
  
  OutputStream getOutputStream();
  
  String getRemoteAddress();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\Socket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */