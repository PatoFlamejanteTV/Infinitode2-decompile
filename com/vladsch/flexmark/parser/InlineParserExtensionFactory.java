package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.dependency.Dependent;
import java.util.function.Function;

public interface InlineParserExtensionFactory extends Dependent, Function<LightInlineParser, InlineParserExtension> {
  CharSequence getCharacters();
  
  InlineParserExtension apply(LightInlineParser paramLightInlineParser);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\InlineParserExtensionFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */