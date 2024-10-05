package com.vladsch.flexmark.ast;

public interface AnchorRefTarget {
  String getAnchorRefText();
  
  String getAnchorRefId();
  
  void setAnchorRefId(String paramString);
  
  boolean isExplicitAnchorRefId();
  
  void setExplicitAnchorRefId(boolean paramBoolean);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ast\AnchorRefTarget.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */