package com.vladsch.flexmark.html;

import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.misc.Extension;

public interface RendererExtension extends Extension {
  void rendererOptions(MutableDataHolder paramMutableDataHolder);
  
  void extend(RendererBuilder paramRendererBuilder, String paramString);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\RendererExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */