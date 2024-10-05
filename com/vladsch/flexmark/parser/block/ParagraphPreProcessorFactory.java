package com.vladsch.flexmark.parser.block;

import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.function.Function;

public interface ParagraphPreProcessorFactory extends Dependent, Function<ParserState, ParagraphPreProcessor> {
  ParagraphPreProcessor apply(ParserState paramParserState);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\block\ParagraphPreProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */