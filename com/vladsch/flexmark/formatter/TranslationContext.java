package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.html.renderer.HtmlIdGenerator;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import java.util.function.Function;
import java.util.function.Supplier;

public interface TranslationContext {
  HtmlIdGenerator getIdGenerator();
  
  RenderPurpose getRenderPurpose();
  
  MutableDataHolder getTranslationStore();
  
  boolean isTransformingText();
  
  CharSequence transformNonTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4);
  
  void postProcessNonTranslating(Function<String, CharSequence> paramFunction, Runnable paramRunnable);
  
  <T> T postProcessNonTranslating(Function<String, CharSequence> paramFunction, Supplier<T> paramSupplier);
  
  boolean isPostProcessingNonTranslating();
  
  CharSequence transformTranslating(CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, CharSequence paramCharSequence4);
  
  CharSequence transformAnchorRef(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
  
  void translatingSpan(TranslatingSpanRender paramTranslatingSpanRender);
  
  void nonTranslatingSpan(TranslatingSpanRender paramTranslatingSpanRender);
  
  void translatingRefTargetSpan(Node paramNode, TranslatingSpanRender paramTranslatingSpanRender);
  
  void customPlaceholderFormat(TranslationPlaceholderGenerator paramTranslationPlaceholderGenerator, TranslatingSpanRender paramTranslatingSpanRender);
  
  MergeContext getMergeContext();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\TranslationContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */