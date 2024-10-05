/*    */ package com.vladsch.flexmark.html.renderer;
/*    */ 
/*    */ import com.vladsch.flexmark.util.ast.Document;
/*    */ import com.vladsch.flexmark.util.ast.Node;
/*    */ import com.vladsch.flexmark.util.data.DataHolder;
/*    */ import com.vladsch.flexmark.util.html.Attributes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface LinkResolverContext
/*    */   extends LinkResolverBasicContext
/*    */ {
/*    */   DataHolder getOptions();
/*    */   
/*    */   Document getDocument();
/*    */   
/*    */   String encodeUrl(CharSequence paramCharSequence);
/*    */   
/*    */   void render(Node paramNode);
/*    */   
/*    */   void renderChildren(Node paramNode);
/*    */   
/*    */   Node getCurrentNode();
/*    */   
/*    */   default ResolvedLink resolveLink(LinkType paramLinkType, CharSequence paramCharSequence, Boolean paramBoolean) {
/* 66 */     return resolveLink(paramLinkType, paramCharSequence, null, paramBoolean);
/*    */   }
/*    */   
/*    */   ResolvedLink resolveLink(LinkType paramLinkType, CharSequence paramCharSequence, Attributes paramAttributes, Boolean paramBoolean);
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html\renderer\LinkResolverContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */