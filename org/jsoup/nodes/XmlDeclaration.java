/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Iterator;
/*    */ import org.jsoup.SerializationException;
/*    */ import org.jsoup.helper.Validate;
/*    */ import org.jsoup.internal.StringUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlDeclaration
/*    */   extends LeafNode
/*    */ {
/*    */   private final boolean isProcessingInstruction;
/*    */   
/*    */   public XmlDeclaration(String paramString, boolean paramBoolean) {
/* 22 */     Validate.notNull(paramString);
/* 23 */     this.value = paramString;
/* 24 */     this.isProcessingInstruction = paramBoolean;
/*    */   }
/*    */   
/*    */   public String nodeName() {
/* 28 */     return "#declaration";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String name() {
/* 36 */     return coreValue();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getWholeDeclaration() {
/* 44 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/*    */     try {
/* 46 */       getWholeDeclaration(stringBuilder, new Document.OutputSettings());
/* 47 */     } catch (IOException iOException) {
/* 48 */       throw new SerializationException(iOException);
/*    */     } 
/* 50 */     return StringUtil.releaseBuilder((StringBuilder)iOException).trim();
/*    */   }
/*    */   
/*    */   private void getWholeDeclaration(Appendable paramAppendable, Document.OutputSettings paramOutputSettings) {
/* 54 */     for (Iterator<Attribute> iterator = attributes().iterator(); iterator.hasNext(); ) {
/* 55 */       Attribute attribute; String str2 = (attribute = iterator.next()).getKey();
/* 56 */       String str1 = attribute.getValue();
/* 57 */       if (!str2.equals(nodeName())) {
/* 58 */         paramAppendable.append(' ');
/*    */         
/* 60 */         paramAppendable.append(str2);
/* 61 */         if (!str1.isEmpty()) {
/* 62 */           paramAppendable.append("=\"");
/* 63 */           Entities.escape(paramAppendable, str1, paramOutputSettings, true, false, false, false);
/* 64 */           paramAppendable.append('"');
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 72 */     paramAppendable
/* 73 */       .append("<")
/* 74 */       .append(this.isProcessingInstruction ? "!" : "?")
/* 75 */       .append(coreValue());
/* 76 */     getWholeDeclaration(paramAppendable, paramOutputSettings);
/* 77 */     paramAppendable
/* 78 */       .append(this.isProcessingInstruction ? "!" : "?")
/* 79 */       .append(">");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*    */ 
/*    */   
/*    */   public String toString() {
/* 88 */     return outerHtml();
/*    */   }
/*    */ 
/*    */   
/*    */   public XmlDeclaration clone() {
/* 93 */     return (XmlDeclaration)super.clone();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\XmlDeclaration.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */