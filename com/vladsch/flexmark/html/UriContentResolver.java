/*    */ package com.vladsch.flexmark.html;
/*    */ 
/*    */ import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
/*    */ import com.vladsch.flexmark.html.renderer.ResolvedContent;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ 
/*    */ public interface UriContentResolver {
/*    */   public static final UriContentResolver NULL;
/*    */   
/*    */   static {
/* 11 */     NULL = ((paramNode, paramLinkResolverBasicContext, paramResolvedContent) -> paramResolvedContent);
/*    */   }
/*    */   
/*    */   ResolvedContent resolveContent(Node paramNode, LinkResolverBasicContext paramLinkResolverBasicContext, ResolvedContent paramResolvedContent);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\UriContentResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */