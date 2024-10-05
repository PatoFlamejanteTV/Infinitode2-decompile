package com.badlogic.gdx;

public interface InputProcessor {
  boolean keyDown(int paramInt);
  
  boolean keyUp(int paramInt);
  
  boolean keyTyped(char paramChar);
  
  boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  boolean touchCancelled(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  boolean touchDragged(int paramInt1, int paramInt2, int paramInt3);
  
  boolean mouseMoved(int paramInt1, int paramInt2);
  
  boolean scrolled(float paramFloat1, float paramFloat2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\InputProcessor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */