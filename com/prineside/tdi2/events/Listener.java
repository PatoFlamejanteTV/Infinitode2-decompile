package com.prineside.tdi2.events;

import com.prineside.tdi2.utils.REGS;

@REGS(classOnly = true)
public interface Listener<T extends Event> {
  void handleEvent(T paramT);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi2\events\Listener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */