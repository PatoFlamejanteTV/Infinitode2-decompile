package com.vladsch.flexmark.util.ast;

public interface NodeVisitHandler extends Visitor<Node> {
  void visitNodeOnly(Node paramNode);
  
  void visitChildren(Node paramNode);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\NodeVisitHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */