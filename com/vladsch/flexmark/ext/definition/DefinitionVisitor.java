package com.vladsch.flexmark.ext.definition;

public interface DefinitionVisitor {
  void visit(DefinitionList paramDefinitionList);
  
  void visit(DefinitionTerm paramDefinitionTerm);
  
  void visit(DefinitionItem paramDefinitionItem);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\DefinitionVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */