package com.badlogic.gdx.graphics.g3d.particles.batches;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.particles.ResourceData;

public interface ParticleBatch<T extends com.badlogic.gdx.graphics.g3d.particles.renderers.ParticleControllerRenderData> extends RenderableProvider, ResourceData.Configurable {
  void begin();
  
  void draw(T paramT);
  
  void end();
  
  void save(AssetManager paramAssetManager, ResourceData paramResourceData);
  
  void load(AssetManager paramAssetManager, ResourceData paramResourceData);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\particles\batches\ParticleBatch.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */