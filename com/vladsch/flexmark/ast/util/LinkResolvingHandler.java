/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.visitor.AstAction;
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ 
/*    */ public class LinkResolvingHandler<N extends Node> extends AstHandler<N, LinkResolvingHandler.LinkResolvingVisitor<N>> {
/*    */   public LinkResolvingHandler(Class<N> paramClass, LinkResolvingVisitor<N> paramLinkResolvingVisitor) {
/* 11 */     super(paramClass, paramLinkResolvingVisitor);
/*    */   }
/*    */ 
/*    */   
/*    */   public ResolvedLink resolveLink(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedLink paramResolvedLink) {
/* 16 */     return ((LinkResolvingVisitor<Node>)getAdapter()).resolveLink(paramNode, paramLinkResolverBasicContext, paramResolvedLink);
/*    */   }
/*    */   
/*    */   public static interface LinkResolvingVisitor<N extends Node> extends AstAction<N> {
/*    */     ResolvedLink resolveLink(N param1N, LinkResolverBasicContext param1LinkResolverBasicContext, ResolvedLink param1ResolvedLink);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\LinkResolvingHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */