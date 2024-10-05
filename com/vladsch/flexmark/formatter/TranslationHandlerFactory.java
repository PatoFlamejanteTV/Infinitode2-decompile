package com.vladsch.flexmark.formatter;

import com.vladsch.flexmark.html.renderer.HtmlIdGeneratorFactory;
import com.vladsch.flexmark.util.data.DataHolder;

public interface TranslationHandlerFactory extends TranslationContext {
  TranslationHandler create(DataHolder paramDataHolder, HtmlIdGeneratorFactory paramHtmlIdGeneratorFactory);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\formatter\TranslationHandlerFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */