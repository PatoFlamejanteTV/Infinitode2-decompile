package com.vladsch.flexmark.parser.delimiter;

import com.vladsch.flexmark.ast.Text;

public interface DelimiterRun {
  DelimiterRun getPrevious();
  
  DelimiterRun getNext();
  
  char getDelimiterChar();
  
  Text getNode();
  
  boolean canOpen();
  
  boolean canClose();
  
  int length();
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\parser\delimiter\DelimiterRun.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */