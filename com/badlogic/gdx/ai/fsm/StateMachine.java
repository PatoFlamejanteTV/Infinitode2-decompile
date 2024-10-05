package com.badlogic.gdx.ai.fsm;

import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;

public interface StateMachine<E, S extends State<E>> extends Telegraph {
  void update();
  
  void changeState(S paramS);
  
  boolean revertToPreviousState();
  
  void setInitialState(S paramS);
  
  void setGlobalState(S paramS);
  
  S getCurrentState();
  
  S getGlobalState();
  
  S getPreviousState();
  
  boolean isInState(S paramS);
  
  boolean handleMessage(Telegram paramTelegram);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fsm\StateMachine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */