/*   */ package com.vladsch.flexmark.ext.tables;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class TableVisitorExt {
/*   */   public static <V extends TableVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(TableBlock.class, paramV::visit), new VisitHandler(TableHead.class, paramV::visit), new VisitHandler(TableSeparator.class, paramV::visit), new VisitHandler(TableBody.class, paramV::visit), new VisitHandler(TableRow.class, paramV::visit), new VisitHandler(TableCell.class, paramV::visit), new VisitHandler(TableCaption.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\tables\TableVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */