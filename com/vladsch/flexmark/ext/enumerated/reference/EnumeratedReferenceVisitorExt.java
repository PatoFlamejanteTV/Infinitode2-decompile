/*   */ package com.vladsch.flexmark.ext.enumerated.reference;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class EnumeratedReferenceVisitorExt {
/*   */   public static <V extends EnumeratedReferenceVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(EnumeratedReferenceText.class, paramV::visit), new VisitHandler(EnumeratedReferenceLink.class, paramV::visit), new VisitHandler(EnumeratedReferenceBlock.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\enumerated\reference\EnumeratedReferenceVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */