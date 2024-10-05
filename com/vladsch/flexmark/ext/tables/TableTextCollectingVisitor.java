/*    */ package com.vladsch.flexmark.ext.tables;
/*    */ 
/*    */ import com.vladsch.flexmark.ast.util.TextCollectingVisitor;
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class TableTextCollectingVisitor
/*    */   extends TextCollectingVisitor
/*    */ {
/* 10 */   public static final Class<?>[] TABLE_LINE_BREAK_CLASSES = new Class[] { TableBlock.class, TableRow.class, TableCaption.class };
/*    */   
/*    */   public TableTextCollectingVisitor(Class<?>... paramVarArgs) {
/* 13 */     super((paramVarArgs.length == 0) ? TABLE_LINE_BREAK_CLASSES : concatArrays(new Class[][] { TABLE_LINE_BREAK_CLASSES, paramVarArgs }));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableTextCollectingVisitor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */