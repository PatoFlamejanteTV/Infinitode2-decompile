package com.vladsch.flexmark.util.visitor;

public interface AstNode<N> {
  N getFirstChild(N paramN);
  
  N getNext(N paramN);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\visitor\AstNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */