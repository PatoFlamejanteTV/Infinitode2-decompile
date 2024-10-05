/*     */ package org.jsoup.safety;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.DataNode;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.parser.ParseErrorList;
/*     */ import org.jsoup.parser.Parser;
/*     */ import org.jsoup.select.NodeTraversor;
/*     */ import org.jsoup.select.NodeVisitor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Cleaner
/*     */ {
/*     */   private final Safelist safelist;
/*     */   
/*     */   public Cleaner(Safelist paramSafelist) {
/*  41 */     Validate.notNull(paramSafelist);
/*  42 */     this.safelist = paramSafelist;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document clean(Document paramDocument) {
/*  53 */     Validate.notNull(paramDocument);
/*     */     
/*  55 */     Document document = Document.createShell(paramDocument.baseUri());
/*  56 */     copySafeNodes(paramDocument.body(), document.body());
/*  57 */     document.outputSettings(paramDocument.outputSettings().clone());
/*     */     
/*  59 */     return document;
/*     */   }
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
/*     */   
/*     */   public boolean isValid(Document paramDocument) {
/*  85 */     Validate.notNull(paramDocument);
/*     */     
/*  87 */     Document document = Document.createShell(paramDocument.baseUri());
/*     */     int i;
/*  89 */     if ((i = copySafeNodes(paramDocument.body(), document.body())) == 0 && paramDocument
/*  90 */       .head().childNodes().isEmpty()) return true;
/*     */     
/*     */     return false;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidBodyHtml(String paramString) {
/* 115 */     Document document1 = Document.createShell("");
/* 116 */     Document document2 = Document.createShell("");
/* 117 */     ParseErrorList parseErrorList = ParseErrorList.tracking(1);
/* 118 */     List list = Parser.parseFragment(paramString, document2.body(), "", parseErrorList);
/* 119 */     document2.body().insertChildren(0, list);
/*     */     int i;
/* 121 */     if ((i = copySafeNodes(document2.body(), document1.body())) == 0 && parseErrorList.isEmpty()) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private final class CleaningVisitor
/*     */     implements NodeVisitor
/*     */   {
/* 128 */     private int numDiscarded = 0;
/*     */     private final Element root;
/*     */     private Element destination;
/*     */     
/*     */     private CleaningVisitor(Element param1Element1, Element param1Element2) {
/* 133 */       this.root = param1Element1;
/* 134 */       this.destination = param1Element2;
/*     */     }
/*     */     public final void head(Node param1Node, int param1Int) {
/*     */       Cleaner.ElementMeta elementMeta;
/* 138 */       if (param1Node instanceof Element)
/* 139 */       { Element element = (Element)param1Node;
/*     */         
/* 141 */         if (Cleaner.this.safelist.isSafeTag(element.normalName()))
/*     */         
/* 143 */         { element = (elementMeta = Cleaner.this.createSafeElement(element)).el;
/* 144 */           this.destination.appendChild((Node)element);
/*     */           
/* 146 */           this.numDiscarded += elementMeta.numAttribsDiscarded;
/* 147 */           this.destination = element; }
/* 148 */         else { if (elementMeta != this.root)
/* 149 */             this.numDiscarded++;  return; }
/*     */          }
/* 151 */       else { TextNode textNode; if (elementMeta instanceof TextNode) {
/* 152 */           TextNode textNode1 = (TextNode)elementMeta;
/* 153 */           textNode = new TextNode(textNode1.getWholeText());
/* 154 */           this.destination.appendChild((Node)textNode); return;
/* 155 */         }  if (textNode instanceof DataNode && Cleaner.this.safelist.isSafeTag(textNode.parent().normalName())) {
/* 156 */           DataNode dataNode2 = (DataNode)textNode;
/* 157 */           DataNode dataNode1 = new DataNode(dataNode2.getWholeData());
/* 158 */           this.destination.appendChild((Node)dataNode1); return;
/*     */         } 
/* 160 */         this.numDiscarded++; }
/*     */     
/*     */     }
/*     */     
/*     */     public final void tail(Node param1Node, int param1Int) {
/* 165 */       if (param1Node instanceof Element && Cleaner.this.safelist.isSafeTag(param1Node.normalName())) {
/* 166 */         this.destination = this.destination.parent();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int copySafeNodes(Element paramElement1, Element paramElement2) {
/*     */     CleaningVisitor cleaningVisitor;
/* 173 */     NodeTraversor.traverse(cleaningVisitor = new CleaningVisitor(paramElement1, paramElement2), (Node)paramElement1);
/* 174 */     return cleaningVisitor.numDiscarded;
/*     */   }
/*     */   
/*     */   private ElementMeta createSafeElement(Element paramElement) {
/* 178 */     Element element = paramElement.shallowClone();
/* 179 */     String str = paramElement.tagName();
/* 180 */     Attributes attributes1 = element.attributes();
/* 181 */     element.clearAttributes();
/*     */     
/* 183 */     byte b = 0;
/*     */     Attributes attributes2;
/* 185 */     for (Attribute attribute : attributes2 = paramElement.attributes()) {
/* 186 */       if (this.safelist.isSafeAttribute(str, paramElement, attribute)) {
/* 187 */         attributes1.put(attribute); continue;
/*     */       } 
/* 189 */       b++;
/*     */     } 
/* 191 */     attributes2 = this.safelist.getEnforcedAttributes(str);
/* 192 */     attributes1.addAll(attributes2);
/* 193 */     element.attributes().addAll(attributes1);
/* 194 */     return new ElementMeta(element, b);
/*     */   }
/*     */   
/*     */   private static class ElementMeta {
/*     */     Element el;
/*     */     int numAttribsDiscarded;
/*     */     
/*     */     ElementMeta(Element param1Element, int param1Int) {
/* 202 */       this.el = param1Element;
/* 203 */       this.numAttribsDiscarded = param1Int;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\safety\Cleaner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */