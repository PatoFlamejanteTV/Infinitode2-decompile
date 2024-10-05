package com.badlogic.gdx.backends.lwjgl3;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.backends.lwjgl3.audio.Lwjgl3Audio;

public interface Lwjgl3ApplicationBase extends Application {
  Lwjgl3Audio createAudio(Lwjgl3ApplicationConfiguration paramLwjgl3ApplicationConfiguration);
  
  Lwjgl3Input createInput(Lwjgl3Window paramLwjgl3Window);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\backends\lwjgl3\Lwjgl3ApplicationBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */