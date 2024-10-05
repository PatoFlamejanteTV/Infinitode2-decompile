package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.GLTexture;

public interface TextureBinder {
  void begin();
  
  void end();
  
  int bind(TextureDescriptor paramTextureDescriptor);
  
  int bind(GLTexture paramGLTexture);
  
  int getBindCount();
  
  int getReuseCount();
  
  void resetCounts();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\TextureBinder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */