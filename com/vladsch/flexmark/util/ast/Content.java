package com.vladsch.flexmark.util.ast;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.List;

public interface Content {
  BasedSequence getSpanningChars();
  
  int getLineCount();
  
  BasedSequence getLineChars(int paramInt);
  
  BasedSequence getContentChars();
  
  BasedSequence getContentChars(int paramInt1, int paramInt2);
  
  List<BasedSequence> getContentLines();
  
  List<BasedSequence> getContentLines(int paramInt1, int paramInt2);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\ast\Content.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */