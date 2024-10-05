package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.visitor.AstAction;

public interface Visitor<N extends Node> extends AstAction<N> {
  void visit(N paramN);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\Visitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */