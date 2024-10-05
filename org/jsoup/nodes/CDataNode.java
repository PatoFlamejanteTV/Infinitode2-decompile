/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CDataNode
/*    */   extends TextNode
/*    */ {
/*    */   public CDataNode(String paramString) {
/* 10 */     super(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String nodeName() {
/* 15 */     return "#cdata";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String text() {
/* 24 */     return getWholeText();
/*    */   }
/*    */ 
/*    */   
/*    */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 29 */     paramAppendable
/* 30 */       .append("<![CDATA[")
/* 31 */       .append(getWholeText());
/*    */   }
/*    */ 
/*    */   
/*    */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 36 */     paramAppendable.append("]]>");
/*    */   }
/*    */ 
/*    */   
/*    */   public CDataNode clone() {
/* 41 */     return (CDataNode)super.clone();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\CDataNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */