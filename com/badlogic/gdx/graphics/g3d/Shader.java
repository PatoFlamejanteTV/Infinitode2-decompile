package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.utils.Disposable;

public interface Shader extends Disposable {
  void init();
  
  int compareTo(Shader paramShader);
  
  boolean canRender(Renderable paramRenderable);
  
  void begin(Camera paramCamera, RenderContext paramRenderContext);
  
  void render(Renderable paramRenderable);
  
  void end();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3d\Shader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */