package com.badlogic.gdx;

import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Null;

public interface Audio {
  AudioDevice newAudioDevice(int paramInt, boolean paramBoolean);
  
  AudioRecorder newAudioRecorder(int paramInt, boolean paramBoolean);
  
  Sound newSound(FileHandle paramFileHandle);
  
  Music newMusic(FileHandle paramFileHandle);
  
  boolean switchOutputDevice(@Null String paramString);
  
  String[] getAvailableOutputDevices();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\Audio.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */