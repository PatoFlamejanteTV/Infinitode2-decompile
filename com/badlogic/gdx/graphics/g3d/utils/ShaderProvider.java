package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.utils.Disposable;

public interface ShaderProvider extends Disposable {
  Shader getShader(Renderable paramRenderable);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\graphics\g3\\utils\ShaderProvider.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */