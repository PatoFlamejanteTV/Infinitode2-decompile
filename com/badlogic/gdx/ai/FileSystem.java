package com.badlogic.gdx.ai;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import java.io.File;

public interface FileSystem {
  FileHandleResolver newResolver(Files.FileType paramFileType);
  
  FileHandle newFileHandle(String paramString);
  
  FileHandle newFileHandle(File paramFile);
  
  FileHandle newFileHandle(String paramString, Files.FileType paramFileType);
  
  FileHandle newFileHandle(File paramFile, Files.FileType paramFileType);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\FileSystem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */