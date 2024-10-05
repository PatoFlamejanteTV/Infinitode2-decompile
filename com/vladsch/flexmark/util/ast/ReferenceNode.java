package com.vladsch.flexmark.util.ast;

public interface ReferenceNode<R extends NodeRepository<B>, B extends Node, N extends Node> extends Comparable<B> {
  N getReferencingNode(Node paramNode);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\ReferenceNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */