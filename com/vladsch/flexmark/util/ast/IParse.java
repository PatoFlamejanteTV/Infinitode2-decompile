package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.io.Reader;

public interface IParse {
  Node parse(BasedSequence paramBasedSequence);
  
  Node parse(String paramString);
  
  Node parseReader(Reader paramReader);
  
  DataHolder getOptions();
  
  boolean transferReferences(Document paramDocument1, Document paramDocument2, Boolean paramBoolean);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\IParse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */