/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TextNode
/*     */   extends LeafNode
/*     */ {
/*     */   public TextNode(String paramString) {
/*  20 */     this.value = paramString;
/*     */   }
/*     */   
/*     */   public String nodeName() {
/*  24 */     return "#text";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String text() {
/*  33 */     return StringUtil.normaliseWhitespace(getWholeText());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextNode text(String paramString) {
/*  42 */     coreValue(paramString);
/*  43 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWholeText() {
/*  51 */     return coreValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlank() {
/*  59 */     return StringUtil.isBlank(coreValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextNode splitText(int paramInt) {
/*  69 */     String str2 = coreValue();
/*  70 */     Validate.isTrue((paramInt >= 0), "Split offset must be not be negative");
/*  71 */     Validate.isTrue((paramInt < str2.length()), "Split offset must not be greater than current text length");
/*     */     
/*  73 */     String str3 = str2.substring(0, paramInt);
/*  74 */     String str1 = str2.substring(paramInt);
/*  75 */     text(str3);
/*  76 */     TextNode textNode = new TextNode(str1);
/*  77 */     if (this.parentNode != null) {
/*  78 */       this.parentNode.addChildren(siblingIndex() + 1, new Node[] { textNode });
/*     */     }
/*  80 */     return textNode;
/*     */   }
/*     */ 
/*     */   
/*     */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/*  85 */     boolean bool = paramOutputSettings.prettyPrint();
/*  86 */     Element element = (this.parentNode instanceof Element) ? (Element)this.parentNode : null;
/*  87 */     bool = (bool && !Element.preserveWhitespace(this.parentNode));
/*  88 */     boolean bool1 = (element != null && (element.tag().isBlock() || element.tag().formatAsBlock())) ? true : false;
/*  89 */     boolean bool2 = false, bool3 = false;
/*     */     
/*  91 */     if (bool) {
/*  92 */       bool2 = ((bool1 && this.siblingIndex == 0) || this.parentNode instanceof Document) ? true : false;
/*  93 */       bool3 = (bool1 && nextSibling() == null) ? true : false;
/*     */ 
/*     */       
/*  96 */       Node node1 = nextSibling();
/*  97 */       Node node2 = previousSibling();
/*  98 */       boolean bool5 = isBlank();
/*     */ 
/*     */       
/*     */       boolean bool4;
/*     */       
/* 103 */       if ((bool4 = ((node1 instanceof Element && ((Element)node1).shouldIndent(paramOutputSettings)) || (node1 instanceof TextNode && ((TextNode)node1).isBlank()) || (node2 instanceof Element && (((Element)node2).isBlock() || node2.nameIs("br")))) ? true : false) && bool5)
/*     */         return; 
/* 105 */       if ((node2 == null && element != null && element
/* 106 */         .tag().formatAsBlock() && !bool5) || (paramOutputSettings
/* 107 */         .outline() && siblingNodes().size() > 0 && !bool5) || (node2 != null && node2
/* 108 */         .nameIs("br")))
/*     */       {
/* 110 */         indent(paramAppendable, paramInt, paramOutputSettings);
/*     */       }
/*     */     } 
/* 113 */     Entities.escape(paramAppendable, coreValue(), paramOutputSettings, false, bool, bool2, bool3);
/*     */   }
/*     */ 
/*     */   
/*     */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*     */ 
/*     */   
/*     */   public String toString() {
/* 121 */     return outerHtml();
/*     */   }
/*     */ 
/*     */   
/*     */   public TextNode clone() {
/* 126 */     return (TextNode)super.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TextNode createFromEncoded(String paramString) {
/* 135 */     paramString = Entities.unescape(paramString);
/* 136 */     return new TextNode(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   static String normaliseWhitespace(String paramString) {
/* 141 */     return paramString = StringUtil.normaliseWhitespace(paramString);
/*     */   }
/*     */   
/*     */   static String stripLeadingWhitespace(String paramString) {
/* 145 */     return paramString.replaceFirst("^\\s+", "");
/*     */   }
/*     */   
/*     */   static boolean lastCharIsWhitespace(StringBuilder paramStringBuilder) {
/* 149 */     return (paramStringBuilder.length() != 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) == ' ');
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\TextNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */