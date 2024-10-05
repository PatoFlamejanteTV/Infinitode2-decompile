package com.badlogic.gdx.assets;

public class AssetLoaderParameters<T> {
  public LoadedCallback loadedCallback;
  
  public static interface LoadedCallback {
    void finishedLoading(AssetManager param1AssetManager, String param1String, Class param1Class);
  }
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\assets\AssetLoaderParameters.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */