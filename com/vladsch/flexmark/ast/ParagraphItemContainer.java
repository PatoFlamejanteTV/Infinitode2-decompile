package com.vladsch.flexmark.ast;

import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.data.DataHolder;

public interface ParagraphItemContainer {
  boolean isParagraphInTightListItem(Paragraph paramParagraph);
  
  boolean isItemParagraph(Paragraph paramParagraph);
  
  boolean isParagraphWrappingDisabled(Paragraph paramParagraph, ListOptions paramListOptions, DataHolder paramDataHolder);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\ParagraphItemContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */