package com.vladsch.flexmark.html.renderer;

import java.util.Set;

public interface DelegatingNodeRendererFactory extends NodeRendererFactory {
  Set<Class<?>> getDelegates();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\DelegatingNodeRendererFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */