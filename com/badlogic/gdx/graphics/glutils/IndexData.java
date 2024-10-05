package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.Disposable;
import java.nio.ShortBuffer;

public interface IndexData extends Disposable {
  int getNumIndices();
  
  int getNumMaxIndices();
  
  void setIndices(short[] paramArrayOfshort, int paramInt1, int paramInt2);
  
  void setIndices(ShortBuffer paramShortBuffer);
  
  void updateIndices(int paramInt1, short[] paramArrayOfshort, int paramInt2, int paramInt3);
  
  @Deprecated
  ShortBuffer getBuffer();
  
  ShortBuffer getBuffer(boolean paramBoolean);
  
  void bind();
  
  void unbind();
  
  void invalidate();
  
  void dispose();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\glutils\IndexData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */