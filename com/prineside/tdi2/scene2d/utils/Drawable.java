package com.prineside.tdi2.scene2d.utils;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface Drawable {
  void draw(Batch paramBatch, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  float getLeftWidth();
  
  void setLeftWidth(float paramFloat);
  
  float getRightWidth();
  
  void setRightWidth(float paramFloat);
  
  float getTopHeight();
  
  void setTopHeight(float paramFloat);
  
  float getBottomHeight();
  
  void setBottomHeight(float paramFloat);
  
  float getMinWidth();
  
  void setMinWidth(float paramFloat);
  
  float getMinHeight();
  
  void setMinHeight(float paramFloat);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\scene2\\utils\Drawable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */