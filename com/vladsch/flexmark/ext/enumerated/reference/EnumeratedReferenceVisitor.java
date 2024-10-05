package com.vladsch.flexmark.ext.enumerated.reference;

public interface EnumeratedReferenceVisitor {
  void visit(EnumeratedReferenceText paramEnumeratedReferenceText);
  
  void visit(EnumeratedReferenceLink paramEnumeratedReferenceLink);
  
  void visit(EnumeratedReferenceBlock paramEnumeratedReferenceBlock);
}


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferenceVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */