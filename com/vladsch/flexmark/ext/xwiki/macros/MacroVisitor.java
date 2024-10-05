package com.vladsch.flexmark.ext.xwiki.macros;

public interface MacroVisitor {
  void visit(Macro paramMacro);
  
  void visit(MacroClose paramMacroClose);
  
  void visit(MacroBlock paramMacroBlock);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\MacroVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */