package com.badlogic.gdx.scenes.scene2d.utils;

public interface Layout {
  void layout();
  
  void invalidate();
  
  void invalidateHierarchy();
  
  void validate();
  
  void pack();
  
  void setFillParent(boolean paramBoolean);
  
  void setLayoutEnabled(boolean paramBoolean);
  
  float getMinWidth();
  
  float getMinHeight();
  
  float getPrefWidth();
  
  float getPrefHeight();
  
  float getMaxWidth();
  
  float getMaxHeight();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\scenes\scene2\\utils\Layout.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */