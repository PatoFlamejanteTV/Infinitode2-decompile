package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.math.Matrix4;

public interface ShadowMap {
  Matrix4 getProjViewTrans();
  
  TextureDescriptor getDepthMap();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\environment\ShadowMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */