package com.vladsch.flexmark.ext.jekyll.tag;

public interface JekyllTagVisitor {
  void visit(JekyllTag paramJekyllTag);
  
  void visit(JekyllTagBlock paramJekyllTagBlock);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\jekyll\tag\JekyllTagVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */