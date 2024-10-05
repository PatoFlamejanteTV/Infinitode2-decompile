package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapRenderer;

public interface TiledMapRenderer extends MapRenderer {
  void renderObjects(MapLayer paramMapLayer);
  
  void renderObject(MapObject paramMapObject);
  
  void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer);
  
  void renderImageLayer(TiledMapImageLayer paramTiledMapImageLayer);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\maps\tiled\TiledMapRenderer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */