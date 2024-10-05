package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class ModelNodeAnimation {
  public String nodeId;
  
  public Array<ModelNodeKeyframe<Vector3>> translation;
  
  public Array<ModelNodeKeyframe<Quaternion>> rotation;
  
  public Array<ModelNodeKeyframe<Vector3>> scaling;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\data\ModelNodeAnimation.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */