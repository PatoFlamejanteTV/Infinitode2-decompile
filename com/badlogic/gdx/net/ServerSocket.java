package com.badlogic.gdx.net;

import com.badlogic.gdx.Net;
import com.badlogic.gdx.utils.Disposable;

public interface ServerSocket extends Disposable {
  Net.Protocol getProtocol();
  
  Socket accept(SocketHints paramSocketHints);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\net\ServerSocket.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */