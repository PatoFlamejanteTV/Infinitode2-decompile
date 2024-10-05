/*   */ package com.vladsch.flexmark.ext.gitlab;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class GitLabVisitorExt {
/*   */   public static <V extends GitLabVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(GitLabIns.class, paramV::visit), new VisitHandler(GitLabDel.class, paramV::visit), new VisitHandler(GitLabInlineMath.class, paramV::visit), new VisitHandler(GitLabBlockQuote.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\gitlab\GitLabVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */