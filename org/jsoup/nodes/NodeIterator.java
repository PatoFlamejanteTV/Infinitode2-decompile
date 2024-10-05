/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import org.jsoup.helper.Validate;
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
/*     */ public class NodeIterator<T extends Node>
/*     */   implements Iterator<T>
/*     */ {
/*     */   private Node root;
/*     */   private T next;
/*     */   private Node current;
/*     */   private Node previous;
/*     */   private Node currentParent;
/*     */   private final Class<T> type;
/*     */   
/*     */   public NodeIterator(Node paramNode, Class<T> paramClass) {
/*  32 */     Validate.notNull(paramNode);
/*  33 */     Validate.notNull(paramClass);
/*  34 */     this.type = paramClass;
/*     */     
/*  36 */     restart(paramNode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static NodeIterator<Node> from(Node paramNode) {
/*  45 */     return new NodeIterator<>(paramNode, Node.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void restart(Node paramNode) {
/*  54 */     if (this.type.isInstance(paramNode))
/*     */     {
/*  56 */       this.next = (T)paramNode;
/*     */     }
/*  58 */     this.root = this.previous = this.current = paramNode;
/*  59 */     this.currentParent = this.current.parent();
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*  63 */     maybeFindNext();
/*  64 */     return (this.next != null);
/*     */   }
/*     */   
/*     */   public T next() {
/*  68 */     maybeFindNext();
/*  69 */     if (this.next == null) throw new NoSuchElementException();
/*     */     
/*  71 */     T t = this.next;
/*  72 */     this.previous = this.current;
/*  73 */     this.current = (Node)this.next;
/*  74 */     this.currentParent = this.current.parent();
/*  75 */     this.next = null;
/*  76 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void maybeFindNext() {
/*  83 */     if (this.next != null) {
/*     */       return;
/*     */     }
/*  86 */     if (this.currentParent != null && !this.current.hasParent()) {
/*  87 */       this.current = this.previous;
/*     */     }
/*  89 */     this.next = findNextNode();
/*     */   }
/*     */   
/*     */   private T findNextNode() {
/*  93 */     Node node = this.current;
/*     */     do {
/*  95 */       if (node.childNodeSize() > 0) {
/*  96 */         node = node.childNode(0); continue;
/*  97 */       }  if (this.root.equals(node)) {
/*  98 */         node = null; continue;
/*  99 */       }  if (node.nextSibling() != null) {
/* 100 */         node = node.nextSibling();
/*     */         continue;
/*     */       } 
/*     */       while (true) {
/* 104 */         if ((node = node.parent()) == null || this.root.equals(node))
/* 105 */           return null; 
/* 106 */         if (node.nextSibling() != null)
/* 107 */         { node = node.nextSibling();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 112 */           if (node == null)
/* 113 */             return null;  break; } 
/*     */       } 
/* 115 */     } while (!this.type.isInstance(node));
/*     */     
/* 117 */     return (T)node;
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove() {
/* 122 */     this.current.remove();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\NodeIterator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */