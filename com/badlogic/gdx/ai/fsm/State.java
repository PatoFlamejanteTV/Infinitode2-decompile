package com.badlogic.gdx.ai.fsm;

import com.badlogic.gdx.ai.msg.Telegram;

public interface State<E> {
  void enter(E paramE);
  
  void update(E paramE);
  
  void exit(E paramE);
  
  boolean onMessage(E paramE, Telegram paramTelegram);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\fsm\State.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */