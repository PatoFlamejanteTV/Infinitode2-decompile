/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedLink;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ 
/*    */ public interface LinkResolver {
/*    */   public static final LinkResolver NULL;
/*    */   
/*    */   static {
/* 11 */     NULL = ((paramNode, paramLinkResolverBasicContext, paramResolvedLink) -> paramResolvedLink);
/*    */   }
/*    */   
/*    */   ResolvedLink resolveLink(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedLink paramResolvedLink);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\LinkResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */