package com.vladsch.flexmark.ext.macros;

public interface MacrosVisitor {
  void visit(MacroReference paramMacroReference);
  
  void visit(MacroDefinitionBlock paramMacroDefinitionBlock);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\macros\MacrosVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */