package com.vladsch.flexmark.parser;

import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.data.DataHolder;
import java.util.function.Function;

public interface LinkRefProcessorFactory extends Function<Document, LinkRefProcessor> {
  boolean getWantExclamationPrefix(DataHolder paramDataHolder);
  
  int getBracketNestingLevel(DataHolder paramDataHolder);
  
  LinkRefProcessor apply(Document paramDocument);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\LinkRefProcessorFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */