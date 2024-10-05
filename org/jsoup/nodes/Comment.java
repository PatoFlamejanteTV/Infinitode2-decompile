/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ import org.jsoup.parser.ParseSettings;
/*    */ import org.jsoup.parser.Parser;
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
/*    */ public class Comment
/*    */   extends LeafNode
/*    */ {
/*    */   public Comment(String paramString) {
/* 19 */     this.value = paramString;
/*    */   }
/*    */   
/*    */   public String nodeName() {
/* 23 */     return "#comment";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getData() {
/* 31 */     return coreValue();
/*    */   }
/*    */   
/*    */   public Comment setData(String paramString) {
/* 35 */     coreValue(paramString);
/* 36 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 41 */     if (paramOutputSettings.prettyPrint() && ((isEffectivelyFirst() && this.parentNode instanceof Element && ((Element)this.parentNode).tag().formatAsBlock()) || paramOutputSettings.outline()))
/* 42 */       indent(paramAppendable, paramInt, paramOutputSettings); 
/* 43 */     paramAppendable
/* 44 */       .append("<!--")
/* 45 */       .append(getData())
/* 46 */       .append("-->");
/*    */   }
/*    */ 
/*    */   
/*    */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */ 
/*    */   
/*    */   public String toString() {
/* 54 */     return outerHtml();
/*    */   }
/*    */ 
/*    */   
/*    */   public Comment clone() {
/* 59 */     return (Comment)super.clone();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isXmlDeclaration() {
/*    */     String str;
/* 68 */     return isXmlDeclarationData(str = getData());
/*    */   }
/*    */   
/*    */   private static boolean isXmlDeclarationData(String paramString) {
/* 72 */     return (paramString.length() > 1 && (paramString.startsWith("!") || paramString.startsWith("?")));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XmlDeclaration asXmlDeclaration() {
/* 80 */     String str1 = getData();
/*    */     
/* 82 */     XmlDeclaration xmlDeclaration = null;
/*    */     
/*    */     String str2;
/* 85 */     if (isXmlDeclarationData(str2 = str1.substring(1, str1.length() - 1))) {
/* 86 */       return null;
/*    */     }
/* 88 */     str2 = "<" + str2 + ">";
/*    */     
/*    */     Document document;
/* 91 */     if ((document = Parser.htmlParser().settings(ParseSettings.preserveCase).parseInput(str2, baseUri())).body().childrenSize() > 0) {
/* 92 */       Element element = document.body().child(0);
/*    */       
/* 94 */       (xmlDeclaration = new XmlDeclaration(NodeUtils.parser(document).settings().normalizeTag(element.tagName()), str1.startsWith("!"))).attributes().addAll(element.attributes());
/*    */     } 
/* 96 */     return xmlDeclaration;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Comment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */