package com.codedisaster.steamworks;

public interface SteamHTTPCallback {
  void onHTTPRequestCompleted(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, long paramLong, boolean paramBoolean, SteamHTTP.HTTPStatusCode paramHTTPStatusCode, int paramInt);
  
  void onHTTPRequestHeadersReceived(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, long paramLong);
  
  void onHTTPRequestDataReceived(SteamHTTPRequestHandle paramSteamHTTPRequestHandle, long paramLong, int paramInt1, int paramInt2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\codedisaster\steamworks\SteamHTTPCallback.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */