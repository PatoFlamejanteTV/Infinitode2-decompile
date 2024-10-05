/*     */ package org.jsoup.helper;
/*     */ 
/*     */ import java.io.StringWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Stack;
/*     */ import javax.xml.parsers.DocumentBuilder;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import javax.xml.transform.Transformer;
/*     */ import javax.xml.transform.TransformerException;
/*     */ import javax.xml.transform.TransformerFactory;
/*     */ import javax.xml.transform.dom.DOMSource;
/*     */ import javax.xml.transform.stream.StreamResult;
/*     */ import javax.xml.xpath.XPathConstants;
/*     */ import javax.xml.xpath.XPathExpression;
/*     */ import javax.xml.xpath.XPathExpressionException;
/*     */ import javax.xml.xpath.XPathFactory;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.Comment;
/*     */ import org.jsoup.nodes.DataNode;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.DocumentType;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.select.NodeTraversor;
/*     */ import org.jsoup.select.NodeVisitor;
/*     */ import org.jsoup.select.Selector;
/*     */ import org.w3c.dom.Comment;
/*     */ import org.w3c.dom.DOMException;
/*     */ import org.w3c.dom.DOMImplementation;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.DocumentType;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.NodeList;
/*     */ import org.w3c.dom.Text;
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
/*     */ public class W3CDom
/*     */ {
/*     */   public static final String SourceProperty = "jsoupSource";
/*     */   private static final String ContextProperty = "jsoupContextSource";
/*     */   private static final String ContextNodeProperty = "jsoupContextNode";
/*     */   public static final String XPathFactoryProperty = "javax.xml.xpath.XPathFactory:jsoup";
/*     */   protected DocumentBuilderFactory factory;
/*     */   private boolean namespaceAware = true;
/*     */   
/*     */   public W3CDom() {
/*  67 */     this.factory = DocumentBuilderFactory.newInstance();
/*  68 */     this.factory.setNamespaceAware(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean namespaceAware() {
/*  77 */     return this.namespaceAware;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public W3CDom namespaceAware(boolean paramBoolean) {
/*  88 */     this.namespaceAware = paramBoolean;
/*  89 */     this.factory.setNamespaceAware(paramBoolean);
/*  90 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document convert(Document paramDocument) {
/* 100 */     return (new W3CDom()).fromJsoup(paramDocument);
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
/*     */   public static String asString(Document paramDocument, Map<String, String> paramMap) {
/*     */     try {
/* 125 */       DOMSource dOMSource = new DOMSource(paramDocument);
/* 126 */       StringWriter stringWriter = new StringWriter();
/* 127 */       StreamResult streamResult = new StreamResult(stringWriter);
/*     */       TransformerFactory transformerFactory;
/* 129 */       Transformer transformer = (transformerFactory = TransformerFactory.newInstance()).newTransformer();
/* 130 */       if (paramMap != null) {
/* 131 */         transformer.setOutputProperties(propertiesFromMap(paramMap));
/*     */       }
/* 133 */       if (paramDocument.getDoctype() != null) {
/*     */         DocumentType documentType;
/* 135 */         if (!StringUtil.isBlank((documentType = paramDocument.getDoctype()).getPublicId()))
/* 136 */           transformer.setOutputProperty("doctype-public", documentType.getPublicId()); 
/* 137 */         if (!StringUtil.isBlank(documentType.getSystemId())) {
/* 138 */           transformer.setOutputProperty("doctype-system", documentType.getSystemId());
/*     */         }
/* 140 */         else if (documentType.getName().equalsIgnoreCase("html") && 
/* 141 */           StringUtil.isBlank(documentType.getPublicId()) && 
/* 142 */           StringUtil.isBlank(documentType.getSystemId())) {
/* 143 */           transformer.setOutputProperty("doctype-system", "about:legacy-compat");
/*     */         } 
/*     */       } 
/* 146 */       transformer.transform(dOMSource, streamResult);
/* 147 */       return stringWriter.toString();
/*     */     }
/* 149 */     catch (TransformerException transformerException) {
/* 150 */       throw new IllegalStateException(transformerException);
/*     */     } 
/*     */   }
/*     */   
/*     */   static Properties propertiesFromMap(Map<String, String> paramMap) {
/*     */     Properties properties;
/* 156 */     (properties = new Properties()).putAll(paramMap);
/* 157 */     return properties;
/*     */   }
/*     */ 
/*     */   
/*     */   public static HashMap<String, String> OutputHtml() {
/* 162 */     return methodMap("html");
/*     */   }
/*     */ 
/*     */   
/*     */   public static HashMap<String, String> OutputXml() {
/* 167 */     return methodMap("xml");
/*     */   }
/*     */   
/*     */   private static HashMap<String, String> methodMap(String paramString) {
/*     */     HashMap<Object, Object> hashMap;
/* 172 */     (hashMap = new HashMap<>()).put("method", paramString);
/* 173 */     return (HashMap)hashMap;
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
/*     */   public Document fromJsoup(Document paramDocument) {
/* 186 */     return fromJsoup((Element)paramDocument);
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
/*     */   public Document fromJsoup(Element paramElement) {
/* 201 */     Validate.notNull(paramElement);
/*     */     
/*     */     try {
/*     */       DocumentBuilder documentBuilder;
/* 205 */       DOMImplementation dOMImplementation = (documentBuilder = this.factory.newDocumentBuilder()).getDOMImplementation();
/* 206 */       Document document = documentBuilder.newDocument();
/*     */       Document document1;
/*     */       DocumentType documentType;
/* 209 */       if ((documentType = (DocumentType)(((document1 = paramElement.ownerDocument()) != null) ? document1.documentType() : null)) != null) {
/*     */         try {
/* 211 */           DocumentType documentType1 = dOMImplementation.createDocumentType(documentType.name(), documentType.publicId(), documentType.systemId());
/* 212 */           document.appendChild(documentType1);
/* 213 */         } catch (DOMException dOMException) {}
/*     */       }
/*     */ 
/*     */       
/* 217 */       document.setXmlStandalone(true);
/*     */       
/* 219 */       Element element = (paramElement instanceof Document) ? paramElement.firstElementChild() : paramElement;
/* 220 */       document.setUserData("jsoupContextSource", element, null);
/* 221 */       convert((document1 != null) ? (Element)document1 : paramElement, document);
/* 222 */       return document;
/* 223 */     } catch (ParserConfigurationException parserConfigurationException) {
/* 224 */       throw new IllegalStateException(parserConfigurationException);
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
/*     */   public void convert(Document paramDocument, Document paramDocument1) {
/* 238 */     convert((Element)paramDocument, paramDocument1);
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
/*     */   public void convert(Element paramElement, Document paramDocument) {
/*     */     W3CBuilder w3CBuilder;
/* 251 */     (w3CBuilder = new W3CBuilder(paramDocument)).namespaceAware = this.namespaceAware;
/*     */     Document document;
/* 253 */     if ((document = paramElement.ownerDocument()) != null) {
/* 254 */       if (!StringUtil.isBlank(document.location())) {
/* 255 */         paramDocument.setDocumentURI(document.location());
/*     */       }
/* 257 */       w3CBuilder.syntax = document.outputSettings().syntax();
/*     */     } 
/* 259 */     paramElement = (paramElement instanceof Document) ? paramElement.firstElementChild() : paramElement;
/* 260 */     NodeTraversor.traverse(w3CBuilder, (Node)paramElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeList selectXpath(String paramString, Document paramDocument) {
/* 270 */     return selectXpath(paramString, paramDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NodeList selectXpath(String paramString, Node paramNode) {
/*     */     NodeList nodeList;
/* 280 */     Validate.notEmptyParam(paramString, "xpath");
/* 281 */     Validate.notNullParam(paramNode, "contextNode");
/*     */ 
/*     */     
/*     */     try {
/*     */       XPathExpression xPathExpression;
/*     */ 
/*     */       
/*     */       String str;
/*     */ 
/*     */       
/*     */       XPathFactory xPathFactory;
/*     */       
/* 293 */       Validate.notNull(nodeList = (NodeList)(xPathExpression = (xPathFactory = ((str = System.getProperty("javax.xml.xpath.XPathFactory:jsoup")) != null) ? XPathFactory.newInstance("jsoup") : XPathFactory.newInstance()).newXPath().compile(paramString)).evaluate(paramNode, XPathConstants.NODESET));
/* 294 */     } catch (XPathExpressionException|javax.xml.xpath.XPathFactoryConfigurationException xPathExpressionException) {
/* 295 */       throw new Selector.SelectorParseException(xPathExpressionException, "Could not evaluate XPath query [%s]: %s", new Object[] { paramString, xPathExpressionException
/* 296 */             .getMessage() });
/*     */     } 
/* 298 */     return nodeList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> List<T> sourceNodes(NodeList paramNodeList, Class<T> paramClass) {
/* 309 */     Validate.notNull(paramNodeList);
/* 310 */     Validate.notNull(paramClass);
/* 311 */     ArrayList<Node> arrayList = new ArrayList(paramNodeList.getLength());
/*     */     
/* 313 */     for (byte b = 0; b < paramNodeList.getLength(); b++) {
/*     */       Node node;
/* 315 */       Object object = (node = paramNodeList.item(b)).getUserData("jsoupSource");
/* 316 */       if (paramClass.isInstance(object)) {
/* 317 */         arrayList.add((Node)paramClass.cast(object));
/*     */       }
/*     */     } 
/* 320 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node contextNode(Document paramDocument) {
/* 329 */     return (Node)paramDocument.getUserData("jsoupContextNode");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String asString(Document paramDocument) {
/* 340 */     return asString(paramDocument, null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected static class W3CBuilder
/*     */     implements NodeVisitor
/*     */   {
/*     */     private static final String xmlnsKey = "xmlns";
/*     */     
/*     */     private static final String xmlnsPrefix = "xmlns:";
/*     */     
/*     */     private final Document doc;
/*     */     private boolean namespaceAware = true;
/* 353 */     private final Stack<HashMap<String, String>> namespacesStack = new Stack<>();
/*     */     private Node dest;
/* 355 */     private Document.OutputSettings.Syntax syntax = Document.OutputSettings.Syntax.xml;
/*     */     private final Element contextElement;
/*     */     
/*     */     public W3CBuilder(Document param1Document) {
/* 359 */       this.doc = param1Document;
/* 360 */       this.namespacesStack.push(new HashMap<>());
/* 361 */       this.dest = param1Document;
/* 362 */       this.contextElement = (Element)param1Document.getUserData("jsoupContextSource");
/* 363 */       Document document = this.contextElement.ownerDocument();
/* 364 */       if (this.namespaceAware && document != null && document.parser().getTreeBuilder() instanceof org.jsoup.parser.HtmlTreeBuilder)
/*     */       {
/* 366 */         ((HashMap<String, String>)this.namespacesStack.peek()).put("", "http://www.w3.org/1999/xhtml"); } 
/*     */     }
/*     */     
/*     */     public void head(Node param1Node, int param1Int) {
/*     */       Element element;
/* 371 */       this.namespacesStack.push(new HashMap<>(this.namespacesStack.peek()));
/* 372 */       if (param1Node instanceof Element)
/* 373 */       { element = (Element)param1Node;
/*     */         
/* 375 */         String str1 = updateNamespaces(element);
/* 376 */         str1 = this.namespaceAware ? (String)((HashMap)this.namespacesStack.peek()).get(str1) : null;
/* 377 */         String str2 = element.tagName();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/* 385 */           str1 = (str1 == null && str2.contains(":")) ? "" : str1;
/* 386 */           Element element1 = this.doc.createElementNS(str1, str2);
/* 387 */           copyAttributes((Node)element, element1);
/* 388 */           append(element1, (Node)element);
/* 389 */           if (element == this.contextElement)
/* 390 */             this.doc.setUserData("jsoupContextNode", element1, null); 
/* 391 */           this.dest = element1;
/* 392 */         } catch (DOMException dOMException) {
/* 393 */           append(this.doc.createTextNode("<" + str2 + ">"), (Node)element); return;
/*     */         }  }
/* 395 */       else { TextNode textNode; Comment comment; if (element instanceof TextNode) {
/* 396 */           textNode = (TextNode)element;
/* 397 */           Text text = this.doc.createTextNode(textNode.getWholeText());
/* 398 */           append(text, (Node)textNode); return;
/* 399 */         }  if (textNode instanceof Comment) {
/* 400 */           comment = (Comment)textNode;
/* 401 */           Comment comment1 = this.doc.createComment(comment.getData());
/* 402 */           append(comment1, (Node)comment); return;
/* 403 */         }  if (comment instanceof DataNode) {
/* 404 */           DataNode dataNode = (DataNode)comment;
/* 405 */           Text text = this.doc.createTextNode(dataNode.getWholeData());
/* 406 */           append(text, (Node)dataNode);
/*     */         }  }
/*     */     
/*     */     }
/*     */ 
/*     */     
/*     */     private void append(Node param1Node, Node param1Node1) {
/* 413 */       param1Node.setUserData("jsoupSource", param1Node1, null);
/* 414 */       this.dest.appendChild(param1Node);
/*     */     }
/*     */     
/*     */     public void tail(Node param1Node, int param1Int) {
/* 418 */       if (param1Node instanceof Element && this.dest.getParentNode() instanceof Element) {
/* 419 */         this.dest = this.dest.getParentNode();
/*     */       }
/* 421 */       this.namespacesStack.pop();
/*     */     }
/*     */     
/*     */     private void copyAttributes(Node param1Node, Element param1Element) {
/* 425 */       for (Iterator<Attribute> iterator = param1Node.attributes().iterator(); iterator.hasNext();) {
/*     */         
/* 427 */         if ((str = Attribute.getValidKey((attribute = iterator.next()).getKey(), this.syntax)) != null) {
/* 428 */           param1Element.setAttribute(str, attribute.getValue());
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private String updateNamespaces(Element param1Element) {
/*     */       Attributes attributes;
/* 440 */       for (Iterator<Attribute> iterator = (attributes = param1Element.attributes()).iterator(); iterator.hasNext(); ) {
/*     */         Attribute attribute;
/*     */         String str;
/* 443 */         if ((str = (attribute = iterator.next()).getKey()).equals("xmlns")) {
/* 444 */           str = "";
/* 445 */         } else if (str.startsWith("xmlns:")) {
/* 446 */           str = str.substring(6);
/*     */         } else {
/*     */           continue;
/*     */         } 
/* 450 */         ((HashMap<String, String>)this.namespacesStack.peek()).put(str, attribute.getValue());
/*     */       } 
/*     */       
/*     */       int i;
/*     */       
/* 455 */       return ((i = param1Element.tagName().indexOf(':')) > 0) ? param1Element.tagName().substring(0, i) : "";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\helper\W3CDom.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */