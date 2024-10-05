/*   */ package com.vladsch.flexmark.ext.toc;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class SimTocVisitorExt {
/*   */   public static <V extends SimTocVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(SimTocBlock.class, paramV::visit), new VisitHandler(SimTocOptionList.class, paramV::visit), new VisitHandler(SimTocOption.class, paramV::visit), new VisitHandler(SimTocContent.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\toc\SimTocVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */