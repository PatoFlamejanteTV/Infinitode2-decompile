/*   */ package com.vladsch.flexmark.ext.definition;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class DefinitionVisitorExt {
/*   */   public static <V extends DefinitionVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(DefinitionItem.class, paramV::visit), new VisitHandler(DefinitionList.class, paramV::visit), new VisitHandler(DefinitionTerm.class, paramV::visit), new VisitHandler(DefinitionItem.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\definition\DefinitionVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */