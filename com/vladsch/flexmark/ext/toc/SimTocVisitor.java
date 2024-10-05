package com.vladsch.flexmark.ext.toc;

public interface SimTocVisitor {
  void visit(SimTocBlock paramSimTocBlock);
  
  void visit(SimTocOptionList paramSimTocOptionList);
  
  void visit(SimTocOption paramSimTocOption);
  
  void visit(SimTocContent paramSimTocContent);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\SimTocVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */