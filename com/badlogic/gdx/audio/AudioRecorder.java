package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public interface AudioRecorder extends Disposable {
  void read(short[] paramArrayOfshort, int paramInt1, int paramInt2);
  
  void dispose();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\audio\AudioRecorder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */