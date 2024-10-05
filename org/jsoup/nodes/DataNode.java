/*    */ package org.jsoup.nodes;
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
/*    */ public class DataNode
/*    */   extends LeafNode
/*    */ {
/*    */   public DataNode(String paramString) {
/* 16 */     this.value = paramString;
/*    */   }
/*    */   
/*    */   public String nodeName() {
/* 20 */     return "#data";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getWholeData() {
/* 28 */     return coreValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataNode setWholeData(String paramString) {
/* 37 */     coreValue(paramString);
/* 38 */     return this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 45 */     String str = getWholeData();
/* 46 */     if (paramOutputSettings.syntax() == Document.OutputSettings.Syntax.xml && !str.contains("<![CDATA[")) {
/* 47 */       if (parentNameIs("script")) {
/* 48 */         paramAppendable.append("//<![CDATA[\n").append(str).append("\n//]]>"); return;
/* 49 */       }  if (parentNameIs("style")) {
/* 50 */         paramAppendable.append("/*<![CDATA[*/\n").append(str).append("\n/*]]>*/"); return;
/*    */       } 
/* 52 */       paramAppendable.append("<![CDATA[").append(str).append("]]>");
/*    */       return;
/*    */     } 
/* 55 */     paramAppendable.append(getWholeData());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */ 
/*    */   
/*    */   public String toString() {
/* 64 */     return outerHtml();
/*    */   }
/*    */ 
/*    */   
/*    */   public DataNode clone() {
/* 69 */     return (DataNode)super.clone();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\DataNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */