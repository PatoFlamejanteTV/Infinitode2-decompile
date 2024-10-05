/*    */ package com.vladsch.flexmark.ast.util;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.visitor.AstActionHandler;
/*    */ import com.vladsch.flexmark.util.visitor.AstHandler;
/*    */ import java.util.Collection;
/*    */ 
/*    */ public class LinkResolverAdapter
/*    */   extends AstActionHandler<LinkResolverAdapter, Node, LinkResolvingHandler.LinkResolvingVisitor<Node>, LinkResolvingHandler<Node>> implements LinkResolvingHandler.LinkResolvingVisitor<Node> {
/* 12 */   protected static final LinkResolvingHandler[] EMPTY_HANDLERS = new LinkResolvingHandler[0];
/*    */   
/*    */   public LinkResolverAdapter(LinkResolvingHandler... paramVarArgs) {
/* 15 */     super(Node.AST_ADAPTER);
/* 16 */     addActionHandlers((AstHandler[][])new LinkResolvingHandler[][] { paramVarArgs });
/*    */   }
/*    */   
/*    */   public LinkResolverAdapter(LinkResolvingHandler[]... paramVarArgs) {
/* 20 */     super(Node.AST_ADAPTER);
/*    */     
/* 22 */     addActionHandlers((AstHandler[][])paramVarArgs);
/*    */   }
/*    */   
/*    */   public LinkResolverAdapter(Collection<LinkResolvingHandler> paramCollection) {
/* 26 */     super(Node.AST_ADAPTER);
/* 27 */     addHandlers(paramCollection);
/*    */   }
/*    */ 
/*    */   
/*    */   public LinkResolverAdapter addHandlers(Collection<LinkResolvingHandler> paramCollection) {
/* 32 */     return (LinkResolverAdapter)addActionHandlers((AstHandler[][])new LinkResolvingHandler[][] { paramCollection.<LinkResolvingHandler>toArray(EMPTY_HANDLERS) });
/*    */   }
/*    */   
/*    */   public LinkResolverAdapter addHandlers(LinkResolvingHandler[] paramArrayOfLinkResolvingHandler) {
/* 36 */     return (LinkResolverAdapter)addActionHandlers((AstHandler[][])new LinkResolvingHandler[][] { paramArrayOfLinkResolvingHandler });
/*    */   }
/*    */ 
/*    */   
/*    */   public LinkResolverAdapter addHandlers(LinkResolvingHandler[]... paramVarArgs) {
/* 41 */     return (LinkResolverAdapter)addActionHandlers((AstHandler[][])paramVarArgs);
/*    */   }
/*    */ 
/*    */   
/*    */   public LinkResolverAdapter addHandler(LinkResolvingHandler paramLinkResolvingHandler) {
/* 46 */     return (LinkResolverAdapter)addActionHandler(paramLinkResolvingHandler);
/*    */   }
/*    */ 
/*    */   
/*    */   public ResolvedLink resolveLink(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedLink paramResolvedLink) {
/* 51 */     return (ResolvedLink)processNodeOnly(paramNode, paramResolvedLink, (paramNode, paramLinkResolvingVisitor) -> paramLinkResolvingVisitor.resolveLink(paramNode, paramLinkResolverBasicContext, paramResolvedLink));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\as\\util\LinkResolverAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */