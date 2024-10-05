package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.Array;

public interface GroupStrategy {
  ShaderProgram getGroupShader(int paramInt);
  
  int decideGroup(Decal paramDecal);
  
  void beforeGroup(int paramInt, Array<Decal> paramArray);
  
  void afterGroup(int paramInt);
  
  void beforeGroups();
  
  void afterGroups();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\decals\GroupStrategy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */