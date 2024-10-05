/*     */ package com.d;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.DataNode;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
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
/*     */ @Deprecated
/*     */ public class a
/*     */ {
/*     */   @Deprecated
/*     */   public static Document a(Document paramDocument) {
/*     */     try {
/*     */       DocumentBuilderFactory documentBuilderFactory;
/*     */       DocumentBuilder documentBuilder;
/*  46 */       Document document = (documentBuilder = (documentBuilderFactory = DocumentBuilderFactory.newInstance()).newDocumentBuilder()).newDocument();
/*     */       
/*  48 */       HashMap<Object, Object> hashMap = new HashMap<>();
/*     */       
/*  50 */       a((Node)paramDocument, document, document, (Map)hashMap);
/*     */     }
/*  52 */     catch (ParserConfigurationException parserConfigurationException) {
/*  53 */       throw new RuntimeException(parserConfigurationException);
/*     */     } 
/*     */     
/*  56 */     return (Document)parserConfigurationException;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(Node paramNode, Node paramNode1, Document paramDocument, Map<String, String> paramMap) {
/*     */     Document document;
/*     */     Element element;
/*     */     TextNode textNode;
/*     */     DataNode dataNode;
/*     */     Iterator<Attribute> iterator;
/*  72 */     if (paramNode instanceof Document) {
/*     */ 
/*     */       
/*  75 */       for (Iterator<Node> iterator1 = (document = (Document)paramNode).childNodes().iterator(); iterator1.hasNext();)
/*  76 */         a(node = iterator1.next(), paramNode1, paramDocument, paramMap); 
/*     */       return;
/*     */     } 
/*  79 */     if (document instanceof Element) {
/*  80 */       element = (Element)document;
/*  81 */       Element element1 = paramDocument.createElement(element.tagName());
/*  82 */       paramNode1.appendChild(element1);
/*     */       
/*     */       Attributes attributes;
/*  85 */       for (iterator = (attributes = element.attributes()).iterator(); iterator.hasNext();) {
/*     */ 
/*     */         
/*  88 */         if (!(str = (attribute = iterator.next()).getKey()).equals("xmlns")) {
/*     */           String str1;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  94 */           if ((str1 = a(str)) != null) {
/*  95 */             if (str1.equals("xmlns")) {
/*  96 */               paramMap.put(b(str), attribute.getValue());
/*  97 */             } else if (!str1.equals("xml") && (
/*     */               
/*  99 */               str1 = paramMap.get(str1)) == null) {
/*     */               
/* 101 */               str = str.replace(':', '_');
/*     */             } 
/*     */           }
/*     */           
/* 105 */           element1.setAttribute(str, attribute.getValue());
/* 106 */           if ("id".equals(str)) {
/* 107 */             element1.setIdAttribute(str, true);
/*     */           }
/*     */         } 
/*     */       } 
/* 111 */       for (iterator = element.childNodes().iterator(); iterator.hasNext();)
/* 112 */         a(node = (Node)iterator.next(), element1, paramDocument, paramMap);  return;
/*     */     } 
/* 114 */     if (element instanceof TextNode) {
/* 115 */       textNode = (TextNode)element;
/*     */       
/* 117 */       if (!(iterator instanceof Document))
/* 118 */         iterator.appendChild(paramDocument.createTextNode(textNode.getWholeText()));  return;
/*     */     } 
/* 120 */     if (textNode instanceof DataNode) {
/* 121 */       dataNode = (DataNode)textNode;
/* 122 */       iterator.appendChild(paramDocument.createCDATASection(dataNode.getWholeData())); return;
/* 123 */     }  if (!(dataNode instanceof org.jsoup.nodes.DocumentType))
/*     */     {
/* 125 */       if (!(dataNode instanceof org.jsoup.nodes.Comment))
/*     */       {
/*     */         
/* 128 */         if (!a) throw new AssertionError();  } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static String a(String paramString) {
/*     */     int i;
/* 134 */     if (paramString != null && (
/*     */       
/* 136 */       i = paramString.indexOf(':')) > 0) {
/* 137 */       return paramString.substring(0, i);
/*     */     }
/*     */     
/* 140 */     return null;
/*     */   }
/*     */   private static String b(String paramString) {
/*     */     int i;
/* 144 */     if (paramString != null && (
/*     */       
/* 146 */       i = paramString.lastIndexOf(':')) > 0) {
/* 147 */       return paramString.substring(i + 1);
/*     */     }
/*     */     
/* 150 */     return paramString;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */