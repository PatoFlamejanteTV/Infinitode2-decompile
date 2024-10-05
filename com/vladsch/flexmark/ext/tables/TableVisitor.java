package com.vladsch.flexmark.ext.tables;

public interface TableVisitor {
  void visit(TableBlock paramTableBlock);
  
  void visit(TableHead paramTableHead);
  
  void visit(TableSeparator paramTableSeparator);
  
  void visit(TableBody paramTableBody);
  
  void visit(TableRow paramTableRow);
  
  void visit(TableCell paramTableCell);
  
  void visit(TableCaption paramTableCaption);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */