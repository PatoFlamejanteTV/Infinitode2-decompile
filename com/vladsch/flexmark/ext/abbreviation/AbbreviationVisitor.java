package com.vladsch.flexmark.ext.abbreviation;

public interface AbbreviationVisitor {
  void visit(AbbreviationBlock paramAbbreviationBlock);
  
  void visit(Abbreviation paramAbbreviation);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\abbreviation\AbbreviationVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */