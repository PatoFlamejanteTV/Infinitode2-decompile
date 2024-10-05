package com.badlogic.gdx.input;

public interface TextInputWrapper {
  String getText();
  
  int getSelectionStart();
  
  int getSelectionEnd();
  
  void setText(String paramString);
  
  void setPosition(int paramInt);
  
  boolean shouldClose();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\input\TextInputWrapper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */