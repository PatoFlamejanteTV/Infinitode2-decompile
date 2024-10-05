package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.util.ast.Node;
import java.util.function.Supplier;

public interface CharacterNodeFactory extends Supplier<Node> {
  boolean skipNext(char paramChar);
  
  boolean skipPrev(char paramChar);
  
  boolean wantSkippedWhitespace();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\CharacterNodeFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */