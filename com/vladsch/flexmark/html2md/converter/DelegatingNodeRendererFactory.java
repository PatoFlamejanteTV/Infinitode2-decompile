package com.vladsch.flexmark.html2md.converter;

import java.util.Set;

public interface DelegatingNodeRendererFactory extends HtmlNodeRendererFactory {
  Set<Class<?>> getDelegates();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\DelegatingNodeRendererFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */