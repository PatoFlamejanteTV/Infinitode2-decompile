/*   */ package com.vladsch.flexmark.ast.util;
/*   */ 
/*   */ import com.vladsch.flexmark.ast.HtmlInnerBlock;
/*   */ import com.vladsch.flexmark.ast.HtmlInnerBlockComment;
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class HtmlInnerVisitorExt {
/*   */   public static <V extends HtmlInnerVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 9 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(HtmlInnerBlock.class, paramV::visit), new VisitHandler(HtmlInnerBlockComment.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\HtmlInnerVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */