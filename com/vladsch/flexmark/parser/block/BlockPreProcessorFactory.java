package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.Set;
import java.util.function.Function;

public interface BlockPreProcessorFactory extends Dependent, Function<ParserState, BlockPreProcessor> {
  Set<Class<? extends Block>> getBlockTypes();
  
  BlockPreProcessor apply(ParserState paramParserState);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\BlockPreProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */