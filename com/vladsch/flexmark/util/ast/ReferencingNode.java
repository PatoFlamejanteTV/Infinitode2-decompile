package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;

public interface ReferencingNode<R extends NodeRepository<B>, B extends ReferenceNode> {
  boolean isDefined();
  
  BasedSequence getReference();
  
  B getReferenceNode(Document paramDocument);
  
  B getReferenceNode(R paramR);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\ReferencingNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */