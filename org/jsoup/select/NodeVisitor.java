package org.jsoup.select;

import org.jsoup.nodes.Node;

@FunctionalInterface
public interface NodeVisitor {
  void head(Node paramNode, int paramInt);
  
  default void tail(Node paramNode, int paramInt) {}
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\NodeVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */