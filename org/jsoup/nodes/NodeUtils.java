/*    */ package org.jsoup.nodes;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Spliterator;
/*    */ import java.util.Spliterators;
/*    */ import java.util.stream.Stream;
/*    */ import java.util.stream.StreamSupport;
/*    */ import org.jsoup.helper.Validate;
/*    */ import org.jsoup.helper.W3CDom;
/*    */ import org.jsoup.parser.HtmlTreeBuilder;
/*    */ import org.jsoup.parser.Parser;
/*    */ import org.jsoup.parser.TreeBuilder;
/*    */ import org.w3c.dom.Document;
/*    */ import org.w3c.dom.Node;
/*    */ import org.w3c.dom.NodeList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class NodeUtils
/*    */ {
/*    */   static Document.OutputSettings outputSettings(Node paramNode) {
/* 27 */     return ((paramNode = paramNode.ownerDocument()) != null) ? paramNode.outputSettings() : (new Document("")).outputSettings();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static Parser parser(Node paramNode) {
/* 35 */     if ((paramNode = paramNode.ownerDocument()) != null && paramNode.parser() != null) return paramNode.parser();  return new Parser((TreeBuilder)new HtmlTreeBuilder());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static <T extends Node> List<T> selectXpath(String paramString, Element paramElement, Class<T> paramClass) {
/* 45 */     Validate.notEmpty(paramString);
/* 46 */     Validate.notNull(paramElement);
/* 47 */     Validate.notNull(paramClass);
/*    */     
/*    */     W3CDom w3CDom;
/* 50 */     Document document = (w3CDom = (new W3CDom()).namespaceAware(false)).fromJsoup(paramElement);
/* 51 */     Node node = w3CDom.contextNode(document);
/* 52 */     NodeList nodeList = w3CDom.selectXpath(paramString, node);
/* 53 */     return w3CDom.sourceNodes(nodeList, paramClass);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   static <T extends Node> Stream<T> stream(Node paramNode, Class<T> paramClass) {
/*    */     Spliterator<T> spliterator;
/*    */     NodeIterator<T> nodeIterator;
/* 61 */     return StreamSupport.stream(spliterator = spliterator(nodeIterator = new NodeIterator<>(paramNode, paramClass)), false);
/*    */   }
/*    */   
/*    */   static <T extends Node> Spliterator<T> spliterator(Iterator<T> paramIterator) {
/* 65 */     return Spliterators.spliteratorUnknownSize(paramIterator, 273);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\NodeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */