/*   */ package com.vladsch.flexmark.ext.xwiki.macros;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class MacroVisitorExt {
/*   */   public static <V extends MacroVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(Macro.class, paramV::visit), new VisitHandler(MacroClose.class, paramV::visit), new VisitHandler(MacroBlock.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\xwiki\macros\MacroVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */