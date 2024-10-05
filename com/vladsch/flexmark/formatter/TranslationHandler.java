package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.util.ast.Document;
import java.util.List;

public interface TranslationHandler extends TranslationContext {
  void beginRendering(Document paramDocument, NodeFormatterContext paramNodeFormatterContext, MarkdownWriter paramMarkdownWriter);
  
  List<String> getTranslatingTexts();
  
  void setTranslatedTexts(List<? extends CharSequence> paramList);
  
  void setRenderPurpose(RenderPurpose paramRenderPurpose);
  
  void setMergeContext(MergeContext paramMergeContext);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\TranslationHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */