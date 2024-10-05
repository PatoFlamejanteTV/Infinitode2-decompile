/*    */ package com.vladsch.flexmark.html2md.converter;
/*    */ 
/*    */ import org.jsoup.nodes.Node;
/*    */ 
/*    */ public class HtmlNodeRendererHandler<N extends Node> implements CustomHtmlNodeRenderer<N> {
/*    */   protected final String myTagName;
/*    */   protected final Class<? extends N> myClass;
/*    */   protected final CustomHtmlNodeRenderer<N> myAdapter;
/*    */   
/*    */   public HtmlNodeRendererHandler(String paramString, Class<? extends N> paramClass, CustomHtmlNodeRenderer<N> paramCustomHtmlNodeRenderer) {
/* 11 */     this.myTagName = paramString;
/* 12 */     this.myClass = paramClass;
/* 13 */     this.myAdapter = paramCustomHtmlNodeRenderer;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Node paramNode, HtmlNodeConverterContext paramHtmlNodeConverterContext, HtmlMarkdownWriter paramHtmlMarkdownWriter) {
/* 19 */     this.myAdapter.render((N)paramNode, paramHtmlNodeConverterContext, paramHtmlMarkdownWriter);
/*    */   }
/*    */   
/*    */   public Class<? extends N> getNodeType() {
/* 23 */     return this.myClass;
/*    */   }
/*    */   
/*    */   public String getTagName() {
/* 27 */     return this.myTagName;
/*    */   }
/*    */   
/*    */   public CustomHtmlNodeRenderer<N> getNodeAdapter() {
/* 31 */     return this.myAdapter;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 36 */     if (this == paramObject) return true; 
/* 37 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*    */     
/* 39 */     paramObject = paramObject;
/*    */     
/* 41 */     if (this.myClass != ((HtmlNodeRendererHandler)paramObject).myClass) return false; 
/* 42 */     return (this.myAdapter == ((HtmlNodeRendererHandler)paramObject).myAdapter);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 47 */     int i = this.myClass.hashCode();
/*    */     
/* 49 */     return i = i * 31 + this.myAdapter.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmark\html2md\converter\HtmlNodeRendererHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */