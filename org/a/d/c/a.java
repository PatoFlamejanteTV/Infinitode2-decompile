/*     */ package org.a.d.c;
/*     */ 
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import org.a.d.a.l;
/*     */ import org.a.d.b;
/*     */ import org.a.d.b.b;
/*     */ import org.a.d.b.c;
/*     */ import org.a.d.b.d;
/*     */ import org.a.d.b.f;
/*     */ import org.a.d.b.g;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.ProcessingInstruction;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*  57 */   private DocumentBuilder a = null;
/*     */ 
/*     */   
/*     */   private boolean b = true;
/*     */ 
/*     */   
/*     */   public a() {
/*  64 */     DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/*     */     
/*     */     try {
/*  67 */       this.a = documentBuilderFactory.newDocumentBuilder();
/*     */       return;
/*  69 */     } catch (ParserConfigurationException parserConfigurationException) {
/*     */ 
/*     */       
/*  72 */       throw new RuntimeException(parserConfigurationException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(b paramb, OutputStream paramOutputStream, boolean paramBoolean) {
/*     */     Document document;
/*  80 */     Element element = a(document = this.a.newDocument(), paramb, true);
/*  81 */     for (l l : paramb.e())
/*     */     {
/*  83 */       element.appendChild(a(document, l));
/*     */     }
/*     */     
/*  86 */     a(document, paramOutputStream, "UTF-8");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Element a(Document paramDocument, l paraml) {
/*     */     Element element;
/*  93 */     (element = paramDocument.createElementNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf:Description")).setAttributeNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf:about", paraml.a());
/*  94 */     element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + paraml.i(), paraml.h());
/*     */     
/*  96 */     a(element, (org.a.d.b.a)paraml);
/*     */     
/*  98 */     List<b> list = paraml.d();
/*  99 */     a(paramDocument, element, list, paraml.i(), null, true);
/*     */     
/* 101 */     return element;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Document paramDocument, Element paramElement, List<b> paramList, String paramString1, String paramString2, boolean paramBoolean) {
/* 106 */     for (Iterator<b> iterator = paramList.iterator(); iterator.hasNext(); ) {
/*     */       List<b> list; Element element;
/*     */       b b;
/* 109 */       if (b = iterator.next() instanceof c) {
/*     */         String str;
/* 111 */         c c = (c)b;
/*     */ 
/*     */ 
/*     */         
/* 115 */         if (paramString2 != null && !paramString2.isEmpty()) {
/*     */           
/* 117 */           str = paramString2;
/*     */         }
/*     */         else {
/*     */           
/* 121 */           str = c.b();
/*     */         } 
/*     */         
/*     */         Element element1;
/* 125 */         (element1 = paramDocument.createElement(str + ":" + c.e())).setTextContent(c.a());
/*     */         
/* 127 */         for (g g : list = c.f())
/*     */         {
/* 129 */           element1.setAttributeNS(g.b(), g.a(), g.c());
/*     */         }
/* 131 */         paramElement.appendChild(element1); continue;
/*     */       } 
/* 133 */       if (g instanceof f) {
/*     */         
/* 135 */         f f = (f)g;
/*     */         
/* 137 */         Element element1 = paramDocument.createElement(f.h() + ":" + f.e());
/* 138 */         paramElement.appendChild(element1);
/*     */         
/* 140 */         a(element1, (org.a.d.b.a)f);
/*     */         
/* 142 */         Element element2 = paramDocument.createElement("rdf:" + f.a());
/* 143 */         element1.appendChild(element2);
/*     */         
/* 145 */         list = f.d();
/* 146 */         a(paramDocument, element2, list, paramString1, "rdf", false); continue;
/*     */       } 
/* 148 */       if (list instanceof d) {
/*     */         d d;
/*     */         
/* 151 */         List<b> list1 = (d = (d)list).d();
/*     */         
/* 153 */         Element element1 = paramElement;
/* 154 */         if (paramBoolean) {
/*     */ 
/*     */           
/* 157 */           Element element3 = paramDocument.createElement(paramString1 + ":" + d.e());
/* 158 */           paramElement.appendChild(element3);
/* 159 */           element1 = element3;
/*     */         } 
/*     */ 
/*     */         
/* 163 */         element = paramDocument.createElement("rdf:li");
/* 164 */         element1.appendChild(element);
/* 165 */         if (this.b) {
/*     */           
/* 167 */           element.setAttribute("rdf:parseType", "Resource");
/*     */           
/* 169 */           a(paramDocument, element, list1, paramString1, null, true);
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 174 */         Element element2 = paramDocument.createElement("rdf:Description");
/* 175 */         element.appendChild(element2);
/*     */         
/* 177 */         a(paramDocument, element2, list1, paramString1, null, true);
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 183 */       System.err.println(">> TODO >> " + element.getClass());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Element paramElement, org.a.d.b.a parama) {
/*     */     List<g> list;
/* 194 */     for (g g : list = a(parama)) {
/*     */       
/* 196 */       if ("http://www.w3.org/1999/02/22-rdf-syntax-ns#".equals(g.b())) {
/*     */         
/* 198 */         paramElement.setAttribute("rdf:" + g.a(), g.c());
/*     */         
/*     */         continue;
/*     */       } 
/* 202 */       paramElement.setAttribute(g.a(), g.c());
/*     */     } 
/*     */ 
/*     */     
/* 206 */     for (Map.Entry entry : parama.b().entrySet())
/*     */     {
/* 208 */       paramElement.setAttribute("xmlns:" + (String)entry.getValue(), (String)entry.getKey());
/*     */     }
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
/*     */   private static List<g> a(org.a.d.b.a parama) {
/* 222 */     List list2 = parama.f();
/*     */ 
/*     */     
/* 225 */     ArrayList<g> arrayList = new ArrayList();
/* 226 */     List list1 = parama.d();
/*     */     
/* 228 */     for (g g : list2) {
/*     */       
/* 230 */       boolean bool = false;
/* 231 */       for (b b : list1) {
/*     */         
/* 233 */         if (g.a().compareTo(b.e()) == 0) {
/*     */           
/* 235 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 239 */       if (!bool)
/*     */       {
/* 241 */         arrayList.add(g);
/*     */       }
/*     */     } 
/* 244 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Element a(Document paramDocument, b paramb, boolean paramBoolean) {
/* 251 */     if (paramBoolean) {
/*     */       
/* 253 */       ProcessingInstruction processingInstruction = paramDocument.createProcessingInstruction("xpacket", "begin=\"" + paramb
/* 254 */           .c() + "\" id=\"" + paramb.d() + "\"");
/* 255 */       paramDocument.appendChild(processingInstruction);
/*     */     } 
/*     */     
/*     */     Element element2;
/* 259 */     (element2 = paramDocument.createElementNS("adobe:ns:meta/", "x:xmpmeta")).setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:x", "adobe:ns:meta/");
/* 260 */     paramDocument.appendChild(element2);
/*     */     
/* 262 */     if (paramBoolean) {
/*     */       
/* 264 */       ProcessingInstruction processingInstruction = paramDocument.createProcessingInstruction("xpacket", "end=\"" + paramb
/* 265 */           .f() + "\"");
/* 266 */       paramDocument.appendChild(processingInstruction);
/*     */     } 
/*     */     
/* 269 */     Element element1 = paramDocument.createElementNS("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf:RDF");
/*     */     
/* 271 */     element2.appendChild(element1);
/*     */     
/* 273 */     return element1;
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
/*     */   private static void a(Node paramNode, OutputStream paramOutputStream, String paramString) {
/*     */     Transformer transformer;
/* 293 */     (transformer = TransformerFactory.newInstance().newTransformer()).setOutputProperty("indent", "yes");
/*     */     
/* 295 */     transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
/*     */     
/* 297 */     transformer.setOutputProperty("encoding", paramString);
/* 298 */     transformer.setOutputProperty("omit-xml-declaration", "yes");
/*     */     
/* 300 */     StreamResult streamResult = new StreamResult(paramOutputStream);
/* 301 */     DOMSource dOMSource = new DOMSource(paramNode);
/*     */     
/* 303 */     transformer.transform(dOMSource, streamResult);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */