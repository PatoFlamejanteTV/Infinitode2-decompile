/*   */ package com.vladsch.flexmark.ext.escaped.character;
/*   */ 
/*   */ import com.vladsch.flexmark.util.ast.VisitHandler;
/*   */ 
/*   */ public class EscapedCharacterVisitorExt {
/*   */   public static <V extends EscapedCharacterVisitor> VisitHandler<?>[] VISIT_HANDLERS(V paramV) {
/* 7 */     return (VisitHandler<?>[])new VisitHandler[] { new VisitHandler(EscapedCharacter.class, paramV::visit) };
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\ext\escaped\character\EscapedCharacterVisitorExt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */