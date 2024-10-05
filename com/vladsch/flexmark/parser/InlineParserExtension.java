package com.vladsch.flexmark.parser;

public interface InlineParserExtension {
  void finalizeDocument(InlineParser paramInlineParser);
  
  void finalizeBlock(InlineParser paramInlineParser);
  
  boolean parse(LightInlineParser paramLightInlineParser);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\InlineParserExtension.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */