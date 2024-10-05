package com.badlogic.gdx.graphics.g3d.model.data;

import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class ModelNode {
  public String id;
  
  public Vector3 translation;
  
  public Quaternion rotation;
  
  public Vector3 scale;
  
  public String meshId;
  
  public ModelNodePart[] parts;
  
  public ModelNode[] children;
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\model\data\ModelNode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */