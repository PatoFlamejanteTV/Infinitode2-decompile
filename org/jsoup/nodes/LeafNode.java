/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public abstract class LeafNode
/*     */   extends Node
/*     */ {
/*     */   Object value;
/*     */   
/*     */   protected final boolean hasAttributes() {
/*  12 */     return this.value instanceof Attributes;
/*     */   }
/*     */ 
/*     */   
/*     */   public final Attributes attributes() {
/*  17 */     ensureAttributes();
/*  18 */     return (Attributes)this.value;
/*     */   }
/*     */   
/*     */   private void ensureAttributes() {
/*  22 */     if (!hasAttributes()) {
/*  23 */       Object object = this.value;
/*  24 */       Attributes attributes = new Attributes();
/*  25 */       this.value = attributes;
/*  26 */       if (object != null)
/*  27 */         attributes.put(nodeName(), (String)object); 
/*     */     } 
/*     */   }
/*     */   
/*     */   String coreValue() {
/*  32 */     return attr(nodeName());
/*     */   }
/*     */   
/*     */   void coreValue(String paramString) {
/*  36 */     attr(nodeName(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String attr(String paramString) {
/*  41 */     if (!hasAttributes()) {
/*  42 */       return nodeName().equals(paramString) ? (String)this.value : "";
/*     */     }
/*  44 */     return super.attr(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Node attr(String paramString1, String paramString2) {
/*  49 */     if (!hasAttributes() && paramString1.equals(nodeName())) {
/*  50 */       this.value = paramString2;
/*     */     } else {
/*  52 */       ensureAttributes();
/*  53 */       super.attr(paramString1, paramString2);
/*     */     } 
/*  55 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAttr(String paramString) {
/*  60 */     ensureAttributes();
/*  61 */     return super.hasAttr(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Node removeAttr(String paramString) {
/*  66 */     ensureAttributes();
/*  67 */     return super.removeAttr(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String absUrl(String paramString) {
/*  72 */     ensureAttributes();
/*  73 */     return super.absUrl(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String baseUri() {
/*  78 */     return hasParent() ? parent().baseUri() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doSetBaseUri(String paramString) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int childNodeSize() {
/*  88 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public Node empty() {
/*  93 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<Node> ensureChildNodes() {
/*  98 */     return EmptyNodes;
/*     */   }
/*     */ 
/*     */   
/*     */   protected LeafNode doClone(Node paramNode) {
/* 103 */     paramNode = super.doClone(paramNode);
/*     */ 
/*     */     
/* 106 */     if (hasAttributes()) {
/* 107 */       ((LeafNode)paramNode).value = ((Attributes)this.value).clone();
/*     */     }
/* 109 */     return (LeafNode)paramNode;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\LeafNode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */