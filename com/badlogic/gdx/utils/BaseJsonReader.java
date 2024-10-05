package com.badlogic.gdx.utils;

import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;

public interface BaseJsonReader {
  JsonValue parse(InputStream paramInputStream);
  
  JsonValue parse(FileHandle paramFileHandle);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\BaseJsonReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */