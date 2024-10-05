package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.Document;

public interface MergeContext {
  Document getDocument(TranslationContext paramTranslationContext);
  
  void forEachPrecedingDocument(Document paramDocument, MergeContextConsumer paramMergeContextConsumer);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\MergeContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */