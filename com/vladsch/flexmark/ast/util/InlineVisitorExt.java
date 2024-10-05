/*   */ package com.vladsch.flexmark.ast.util;
/*   */ import com.vladsch.flexmark.ast.HtmlEntity;
/*   */ import com.vladsch.flexmark.ast.MailLink;
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class InlineVisitorExt {
/*   */   public static <V extends InlineVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 8 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(AutoLink.class, paramV::visit), new VisitHandler(Code.class, paramV::visit), new VisitHandler(Emphasis.class, paramV::visit), new VisitHandler(HardLineBreak.class, paramV::visit), new VisitHandler(HtmlEntity.class, paramV::visit), new VisitHandler(HtmlInline.class, paramV::visit), new VisitHandler(HtmlInlineComment.class, paramV::visit), new VisitHandler(Image.class, paramV::visit), new VisitHandler(ImageRef.class, paramV::visit), new VisitHandler(Link.class, paramV::visit), new VisitHandler(LinkRef.class, paramV::visit), new VisitHandler(MailLink.class, paramV::visit), new VisitHandler(SoftLineBreak.class, paramV::visit), new VisitHandler(StrongEmphasis.class, paramV::visit), new VisitHandler(Text.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\InlineVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */