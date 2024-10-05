package com.prineside.tdi2.pathfinding;

import com.badlogic.gdx.utils.Null;
import com.prineside.tdi2.utils.REGS;

@REGS(classOnly = true, arrayLevels = 1)
public interface PathNode {
  short getX();
  
  short getY();
  
  @Null
  int[] getTeleports();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\pathfinding\PathNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */