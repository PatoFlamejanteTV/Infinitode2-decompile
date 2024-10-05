package com.vladsch.flexmark.html.renderer;

import com.vladsch.flexmark.util.data.DataHolder;
import java.util.function.Function;

public interface NodeRendererFactory extends Function<DataHolder, NodeRenderer> {
  NodeRenderer apply(DataHolder paramDataHolder);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\NodeRendererFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */