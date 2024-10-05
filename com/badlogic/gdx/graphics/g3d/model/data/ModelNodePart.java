package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.ArrayMap;

public class ModelNodePart {
  public String materialId;
  
  public String meshPartId;
  
  public ArrayMap<String, Matrix4> bones;
  
  public int[][] uvMapping;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\data\ModelNodePart.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */