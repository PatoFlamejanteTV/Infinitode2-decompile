/*   */ package com.vladsch.flexmark.util.format;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.Node;
/*   */ 
/*   */ public interface TableManipulator {
/*   */   public static final TableManipulator NULL = (paramMarkdownTable, paramNode) -> {
/*   */     
/*   */     };
/*   */   
/*   */   void apply(MarkdownTable paramMarkdownTable, Node paramNode);
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\TableManipulator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */