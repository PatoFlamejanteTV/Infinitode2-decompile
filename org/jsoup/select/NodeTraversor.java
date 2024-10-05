/*     */ package org.jsoup.select;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
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
/*     */ public class NodeTraversor
/*     */ {
/*     */   public static void traverse(NodeVisitor paramNodeVisitor, Node paramNode) {
/*  24 */     Validate.notNull(paramNodeVisitor);
/*  25 */     Validate.notNull(paramNode);
/*  26 */     Node node = paramNode;
/*  27 */     byte b = 0;
/*     */     
/*  29 */     while (node != null) {
/*     */       Node node1;
/*  31 */       boolean bool = ((node1 = node.parentNode()) != null) ? node1.childNodeSize() : false;
/*  32 */       Node node2 = node.nextSibling();
/*     */       
/*  34 */       paramNodeVisitor.head(node, b);
/*  35 */       if (node1 != null && !node.hasParent()) {
/*  36 */         if (bool == node1.childNodeSize()) {
/*  37 */           node = node1.childNode(node.siblingIndex());
/*     */         } else {
/*     */           
/*  40 */           if ((node = node2) == null) {
/*  41 */             node = node1;
/*  42 */             b--;
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */       }
/*  48 */       if (node.childNodeSize() > 0) {
/*  49 */         node = node.childNode(0);
/*  50 */         b++; continue;
/*     */       } 
/*     */       while (true) {
/*  53 */         assert node != null;
/*  54 */         if (node.nextSibling() == null && b > 0) {
/*  55 */           paramNodeVisitor.tail(node, b);
/*  56 */           node = node.parentNode();
/*  57 */           b--; continue;
/*     */         }  break;
/*  59 */       }  paramNodeVisitor.tail(node, b);
/*  60 */       if (node != paramNode)
/*     */       {
/*  62 */         node = node.nextSibling();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void traverse(NodeVisitor paramNodeVisitor, Elements paramElements) {
/*  73 */     Validate.notNull(paramNodeVisitor);
/*  74 */     Validate.notNull(paramElements);
/*  75 */     for (Element element : paramElements) {
/*  76 */       traverse(paramNodeVisitor, (Node)element);
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
/*     */   public static NodeFilter.FilterResult filter(NodeFilter paramNodeFilter, Node paramNode) {
/*  88 */     Node node = paramNode;
/*  89 */     byte b = 0;
/*     */     
/*  91 */     while (node != null) {
/*     */       NodeFilter.FilterResult filterResult;
/*  93 */       if ((filterResult = paramNodeFilter.head(node, b)) == NodeFilter.FilterResult.STOP) {
/*  94 */         return filterResult;
/*     */       }
/*  96 */       if (filterResult == NodeFilter.FilterResult.CONTINUE && node.childNodeSize() > 0) {
/*  97 */         node = node.childNode(0);
/*  98 */         b++;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       while (true) {
/* 103 */         assert node != null;
/* 104 */         if (node.nextSibling() == null && b > 0) {
/*     */           
/* 106 */           if ((filterResult == NodeFilter.FilterResult.CONTINUE || filterResult == NodeFilter.FilterResult.SKIP_CHILDREN) && (
/*     */             
/* 108 */             filterResult = paramNodeFilter.tail(node, b)) == NodeFilter.FilterResult.STOP) {
/* 109 */             return filterResult;
/*     */           }
/* 111 */           Node node2 = node;
/* 112 */           node = node.parentNode();
/* 113 */           b--;
/* 114 */           if (filterResult == NodeFilter.FilterResult.REMOVE)
/* 115 */             node2.remove(); 
/* 116 */           filterResult = NodeFilter.FilterResult.CONTINUE; continue;
/*     */         }  break;
/*     */       } 
/* 119 */       if ((filterResult == NodeFilter.FilterResult.CONTINUE || filterResult == NodeFilter.FilterResult.SKIP_CHILDREN) && (
/*     */         
/* 121 */         filterResult = paramNodeFilter.tail(node, b)) == NodeFilter.FilterResult.STOP) {
/* 122 */         return filterResult;
/*     */       }
/* 124 */       if (node == paramNode)
/* 125 */         return filterResult; 
/* 126 */       Node node1 = node;
/* 127 */       node = node.nextSibling();
/* 128 */       if (filterResult == NodeFilter.FilterResult.REMOVE) {
/* 129 */         node1.remove();
/*     */       }
/*     */     } 
/* 132 */     return NodeFilter.FilterResult.CONTINUE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void filter(NodeFilter paramNodeFilter, Elements paramElements) {
/* 141 */     Validate.notNull(paramNodeFilter);
/* 142 */     Validate.notNull(paramElements);
/* 143 */     for (Element element : paramElements) {
/* 144 */       if (filter(paramNodeFilter, (Node)element) != NodeFilter.FilterResult.STOP);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\NodeTraversor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */