/*   */ package com.vladsch.flexmark.ast.util;
/*   */ import com.vladsch.flexmark.ast.BulletListItem;
/*   */ import com.vladsch.flexmark.ast.Reference;
/*   */ import com.vladsch.flexmark.util.ast.Document;
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class BlockVisitorExt {
/*   */   public static <V extends BlockVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 9 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(BlockQuote.class, paramV::visit), new VisitHandler(BulletList.class, paramV::visit), new VisitHandler(Document.class, paramV::visit), new VisitHandler(FencedCodeBlock.class, paramV::visit), new VisitHandler(Heading.class, paramV::visit), new VisitHandler(HtmlBlock.class, paramV::visit), new VisitHandler(HtmlCommentBlock.class, paramV::visit), new VisitHandler(IndentedCodeBlock.class, paramV::visit), new VisitHandler(BulletListItem.class, paramV::visit), new VisitHandler(OrderedListItem.class, paramV::visit), new VisitHandler(OrderedList.class, paramV::visit), new VisitHandler(Paragraph.class, paramV::visit), new VisitHandler(Reference.class, paramV::visit), new VisitHandler(ThematicBreak.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\BlockVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */