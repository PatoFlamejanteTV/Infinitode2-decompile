package com.vladsch.flexmark.html2md.converter;

import com.vladsch.flexmark.util.data.DataHolder;
import java.util.function.Function;

public interface HtmlNodeRendererFactory extends Function<DataHolder, HtmlNodeRenderer> {
  HtmlNodeRenderer apply(DataHolder paramDataHolder);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlNodeRendererFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */