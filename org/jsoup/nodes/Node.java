/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.stream.Stream;
/*     */ import org.jsoup.SerializationException;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.select.NodeFilter;
/*     */ import org.jsoup.select.NodeTraversor;
/*     */ import org.jsoup.select.NodeVisitor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Node
/*     */   implements Cloneable
/*     */ {
/*  27 */   static final List<Node> EmptyNodes = Collections.emptyList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final String EmptyString = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Node parentNode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int siblingIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String normalName() {
/*  51 */     return nodeName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean nameIs(String paramString) {
/*  61 */     return normalName().equals(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean parentNameIs(String paramString) {
/*  71 */     return (this.parentNode != null && this.parentNode.normalName().equals(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean parentElementIs(String paramString1, String paramString2) {
/*  82 */     if (this.parentNode != null && this.parentNode instanceof Element && ((Element)this.parentNode)
/*  83 */       .elementIs(paramString1, paramString2)) return true;
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
/*     */   public boolean hasParent() {
/*  97 */     return (this.parentNode != null);
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
/*     */   public String attr(String paramString) {
/* 116 */     Validate.notNull(paramString);
/* 117 */     if (!hasAttributes()) {
/* 118 */       return "";
/*     */     }
/*     */     String str;
/* 121 */     if ((str = attributes().getIgnoreCase(paramString)).length() > 0)
/* 122 */       return str; 
/* 123 */     if (paramString.startsWith("abs:"))
/* 124 */       return absUrl(paramString.substring(4)); 
/* 125 */     return "";
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
/*     */   public int attributesSize() {
/* 141 */     return hasAttributes() ? attributes().size() : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node attr(String paramString1, String paramString2) {
/* 152 */     paramString1 = NodeUtils.parser(this).settings().normalizeAttribute(paramString1);
/* 153 */     attributes().putIgnoreCase(paramString1, paramString2);
/* 154 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAttr(String paramString) {
/* 163 */     Validate.notNull(paramString);
/* 164 */     if (!hasAttributes()) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (paramString.startsWith("abs:")) {
/* 168 */       String str = paramString.substring(4);
/* 169 */       if (attributes().hasKeyIgnoreCase(str) && !absUrl(str).isEmpty())
/* 170 */         return true; 
/*     */     } 
/* 172 */     return attributes().hasKeyIgnoreCase(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node removeAttr(String paramString) {
/* 181 */     Validate.notNull(paramString);
/* 182 */     if (hasAttributes())
/* 183 */       attributes().removeIgnoreCase(paramString); 
/* 184 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node clearAttributes() {
/* 192 */     if (hasAttributes()) {
/* 193 */       Iterator<Attribute> iterator = attributes().iterator();
/* 194 */       while (iterator.hasNext()) {
/* 195 */         iterator.next();
/* 196 */         iterator.remove();
/*     */       } 
/*     */     } 
/* 199 */     return this;
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
/*     */   public void setBaseUri(String paramString) {
/* 222 */     Validate.notNull(paramString);
/* 223 */     doSetBaseUri(paramString);
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
/*     */   
/*     */   public String absUrl(String paramString) {
/* 250 */     Validate.notEmpty(paramString);
/* 251 */     if (!hasAttributes() || !attributes().hasKeyIgnoreCase(paramString)) {
/* 252 */       return "";
/*     */     }
/* 254 */     return StringUtil.resolve(baseUri(), attributes().getIgnoreCase(paramString));
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
/*     */   public Node childNode(int paramInt) {
/* 266 */     return ensureChildNodes().get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Node> childNodes() {
/* 275 */     if (childNodeSize() == 0) {
/* 276 */       return EmptyNodes;
/*     */     }
/* 278 */     List<Node> list = ensureChildNodes();
/*     */     ArrayList<Node> arrayList;
/* 280 */     (arrayList = new ArrayList<>(list.size())).addAll(list);
/* 281 */     return Collections.unmodifiableList(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Node> childNodesCopy() {
/* 290 */     List<Node> list = ensureChildNodes();
/* 291 */     ArrayList<Node> arrayList = new ArrayList(list.size());
/* 292 */     for (Node node : list) {
/* 293 */       arrayList.add(node.clone());
/*     */     }
/* 295 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Node[] childNodesAsArray() {
/* 305 */     return ensureChildNodes().<Node>toArray(new Node[0]);
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
/*     */   public Node parent() {
/* 321 */     return this.parentNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Node parentNode() {
/* 329 */     return this.parentNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node root() {
/* 337 */     Node node = this;
/* 338 */     while (node.parentNode != null)
/* 339 */       node = node.parentNode; 
/* 340 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document ownerDocument() {
/*     */     Node node;
/* 349 */     return (node = root() instanceof Document) ? (Document)node : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove() {
/* 357 */     if (this.parentNode != null) {
/* 358 */       this.parentNode.removeChild(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node before(String paramString) {
/* 368 */     addSiblingHtml(this.siblingIndex, paramString);
/* 369 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node before(Node paramNode) {
/* 379 */     Validate.notNull(paramNode);
/* 380 */     Validate.notNull(this.parentNode);
/*     */ 
/*     */     
/* 383 */     if (paramNode.parentNode == this.parentNode) paramNode.remove();
/*     */     
/* 385 */     this.parentNode.addChildren(this.siblingIndex, new Node[] { paramNode });
/* 386 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node after(String paramString) {
/* 396 */     addSiblingHtml(this.siblingIndex + 1, paramString);
/* 397 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node after(Node paramNode) {
/* 407 */     Validate.notNull(paramNode);
/* 408 */     Validate.notNull(this.parentNode);
/*     */ 
/*     */     
/* 411 */     if (paramNode.parentNode == this.parentNode) paramNode.remove();
/*     */     
/* 413 */     this.parentNode.addChildren(this.siblingIndex + 1, new Node[] { paramNode });
/* 414 */     return this;
/*     */   }
/*     */   
/*     */   private void addSiblingHtml(int paramInt, String paramString) {
/* 418 */     Validate.notNull(paramString);
/* 419 */     Validate.notNull(this.parentNode);
/*     */     
/* 421 */     Element element = (parent() instanceof Element) ? (Element)parent() : null;
/* 422 */     List list = NodeUtils.parser(this).parseFragmentInput(paramString, element, baseUri());
/* 423 */     this.parentNode.addChildren(paramInt, (Node[])list.toArray((Object[])new Node[0]));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node wrap(String paramString) {
/* 434 */     Validate.notEmpty(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 440 */     Element element1 = (this.parentNode != null && this.parentNode instanceof Element) ? (Element)this.parentNode : ((this instanceof Element) ? (Element)this : null);
/*     */     List<Node> list;
/*     */     Node node;
/* 443 */     if (!(node = (list = NodeUtils.parser(this).parseFragmentInput(paramString, element1, baseUri())).get(0) instanceof Element)) {
/* 444 */       return this;
/*     */     }
/* 446 */     node = node;
/* 447 */     Element element2 = getDeepChild((Element)node);
/* 448 */     if (this.parentNode != null)
/* 449 */       this.parentNode.replaceChild(this, node); 
/* 450 */     element2.addChildren(new Node[] { this });
/*     */ 
/*     */     
/* 453 */     if (list.size() > 0)
/*     */     {
/* 455 */       for (byte b = 0; b < list.size(); b++) {
/* 456 */         Node node1 = list.get(b);
/*     */         
/* 458 */         if (node != node1) {
/*     */ 
/*     */           
/* 461 */           if (node1.parentNode != null)
/* 462 */             node1.parentNode.removeChild(node1); 
/* 463 */           node.after(node1);
/*     */         } 
/*     */       }  } 
/* 466 */     return this;
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
/*     */   public Node unwrap() {
/* 485 */     Validate.notNull(this.parentNode);
/* 486 */     Node node = firstChild();
/* 487 */     this.parentNode.addChildren(this.siblingIndex, childNodesAsArray());
/* 488 */     remove();
/*     */     
/* 490 */     return node;
/*     */   }
/*     */   
/*     */   private Element getDeepChild(Element paramElement) {
/* 494 */     Element element = paramElement.firstElementChild();
/* 495 */     while (element != null) {
/* 496 */       paramElement = element;
/* 497 */       element = element.firstElementChild();
/*     */     } 
/* 499 */     return paramElement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void nodelistChanged() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceWith(Node paramNode) {
/* 511 */     Validate.notNull(paramNode);
/* 512 */     Validate.notNull(this.parentNode);
/* 513 */     this.parentNode.replaceChild(this, paramNode);
/*     */   }
/*     */   
/*     */   protected void setParentNode(Node paramNode) {
/* 517 */     Validate.notNull(paramNode);
/* 518 */     if (this.parentNode != null)
/* 519 */       this.parentNode.removeChild(this); 
/* 520 */     this.parentNode = paramNode;
/*     */   }
/*     */   
/*     */   protected void replaceChild(Node paramNode1, Node paramNode2) {
/* 524 */     Validate.isTrue((paramNode1.parentNode == this));
/* 525 */     Validate.notNull(paramNode2);
/* 526 */     if (paramNode1 == paramNode2)
/*     */       return; 
/* 528 */     if (paramNode2.parentNode != null) {
/* 529 */       paramNode2.parentNode.removeChild(paramNode2);
/*     */     }
/* 531 */     int i = paramNode1.siblingIndex;
/* 532 */     ensureChildNodes().set(i, paramNode2);
/* 533 */     paramNode2.parentNode = this;
/* 534 */     paramNode2.setSiblingIndex(i);
/* 535 */     paramNode1.parentNode = null;
/*     */   }
/*     */   
/*     */   protected void removeChild(Node paramNode) {
/* 539 */     Validate.isTrue((paramNode.parentNode == this));
/* 540 */     int i = paramNode.siblingIndex;
/* 541 */     ensureChildNodes().remove(i);
/* 542 */     reindexChildren(i);
/* 543 */     paramNode.parentNode = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void addChildren(Node... paramVarArgs) {
/* 548 */     List<Node> list = ensureChildNodes(); int i;
/*     */     byte b;
/* 550 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Node node = paramVarArgs[b];
/* 551 */       reparentChild(node);
/* 552 */       list.add(node);
/* 553 */       node.setSiblingIndex(list.size() - 1);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   protected void addChildren(int paramInt, Node... paramVarArgs) {
/* 558 */     Validate.notNull(paramVarArgs);
/* 559 */     if (paramVarArgs.length == 0) {
/*     */       return;
/*     */     }
/* 562 */     List<Node> list = ensureChildNodes();
/*     */     
/*     */     Node node;
/*     */     
/* 566 */     if ((node = paramVarArgs[0].parent()) != null && node.childNodeSize() == paramVarArgs.length) {
/* 567 */       boolean bool = true;
/* 568 */       List<Node> list1 = node.ensureChildNodes();
/*     */       
/* 570 */       int j = paramVarArgs.length;
/* 571 */       while (j-- > 0) {
/* 572 */         if (paramVarArgs[j] != list1.get(j)) {
/* 573 */           bool = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 577 */       if (bool) {
/* 578 */         boolean bool1 = (childNodeSize() == 0) ? true : false;
/* 579 */         node.empty();
/* 580 */         list.addAll(paramInt, Arrays.asList(paramVarArgs));
/* 581 */         j = paramVarArgs.length;
/* 582 */         while (j-- > 0) {
/* 583 */           (paramVarArgs[j]).parentNode = this;
/*     */         }
/* 585 */         if (!bool1 || (paramVarArgs[0]).siblingIndex != 0) {
/* 586 */           reindexChildren(paramInt);
/*     */         }
/*     */         return;
/*     */       } 
/*     */     } 
/* 591 */     Validate.noNullElements((Object[])paramVarArgs); Node[] arrayOfNode; int i; byte b;
/* 592 */     for (i = (arrayOfNode = paramVarArgs).length, b = 0; b < i; ) { Node node1 = arrayOfNode[b];
/* 593 */       reparentChild(node1); b++; }
/*     */     
/* 595 */     list.addAll(paramInt, Arrays.asList(paramVarArgs));
/* 596 */     reindexChildren(paramInt);
/*     */   }
/*     */   
/*     */   protected void reparentChild(Node paramNode) {
/* 600 */     paramNode.setParentNode(this);
/*     */   }
/*     */   
/*     */   private void reindexChildren(int paramInt) {
/*     */     int i;
/* 605 */     if ((i = childNodeSize()) == 0)
/* 606 */       return;  List<Node> list = ensureChildNodes();
/* 607 */     for (paramInt = paramInt; paramInt < i; paramInt++) {
/* 608 */       ((Node)list.get(paramInt)).setSiblingIndex(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Node> siblingNodes() {
/* 618 */     if (this.parentNode == null) {
/* 619 */       return Collections.emptyList();
/*     */     }
/* 621 */     List<Node> list = this.parentNode.ensureChildNodes();
/* 622 */     ArrayList<Node> arrayList = new ArrayList(list.size() - 1);
/* 623 */     for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
/* 624 */       if ((node = iterator.next()) != this)
/* 625 */         arrayList.add(node); 
/* 626 */     }  return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node nextSibling() {
/* 634 */     if (this.parentNode == null) {
/* 635 */       return null;
/*     */     }
/* 637 */     List<Node> list = this.parentNode.ensureChildNodes();
/* 638 */     int i = this.siblingIndex + 1;
/* 639 */     if (list.size() > i) {
/* 640 */       return list.get(i);
/*     */     }
/* 642 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node previousSibling() {
/* 650 */     if (this.parentNode == null) {
/* 651 */       return null;
/*     */     }
/* 653 */     if (this.siblingIndex > 0) {
/* 654 */       return this.parentNode.ensureChildNodes().get(this.siblingIndex - 1);
/*     */     }
/* 656 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int siblingIndex() {
/* 666 */     return this.siblingIndex;
/*     */   }
/*     */   
/*     */   protected void setSiblingIndex(int paramInt) {
/* 670 */     this.siblingIndex = paramInt;
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
/*     */   public Node firstChild() {
/* 682 */     if (childNodeSize() == 0) return null; 
/* 683 */     return ensureChildNodes().get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node lastChild() {
/*     */     int i;
/* 695 */     if ((i = childNodeSize()) == 0) return null; 
/*     */     List<Node> list;
/* 697 */     return (list = ensureChildNodes()).get(i - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node traverse(NodeVisitor paramNodeVisitor) {
/* 706 */     Validate.notNull(paramNodeVisitor);
/* 707 */     NodeTraversor.traverse(paramNodeVisitor, this);
/* 708 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node forEachNode(Consumer<? super Node> paramConsumer) {
/* 719 */     Validate.notNull(paramConsumer);
/* 720 */     nodeStream().forEach(paramConsumer);
/* 721 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node filter(NodeFilter paramNodeFilter) {
/* 730 */     Validate.notNull(paramNodeFilter);
/* 731 */     NodeTraversor.filter(paramNodeFilter, this);
/* 732 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Stream<Node> nodeStream() {
/* 742 */     return NodeUtils.stream(this, Node.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T extends Node> Stream<T> nodeStream(Class<T> paramClass) {
/* 753 */     return NodeUtils.stream(this, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String outerHtml() {
/* 763 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 764 */     outerHtml(stringBuilder);
/* 765 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */   
/*     */   protected void outerHtml(Appendable paramAppendable) {
/* 769 */     NodeTraversor.traverse(new OuterHtmlVisitor(paramAppendable, NodeUtils.outputSettings(this)), this);
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
/*     */   public <T extends Appendable> T html(T paramT) {
/* 788 */     outerHtml((Appendable)paramT);
/* 789 */     return paramT;
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
/*     */   public Range sourceRange() {
/* 804 */     return Range.of(this, true);
/*     */   }
/*     */ 
/*     */   
/*     */   final boolean isEffectivelyFirst() {
/* 809 */     if (this.siblingIndex == 0) return true; 
/* 810 */     if (this.siblingIndex == 1) {
/*     */       Node node;
/* 812 */       if (node = previousSibling() instanceof TextNode && ((TextNode)node).isBlank()) return true;  return false;
/*     */     } 
/* 814 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 823 */     return outerHtml();
/*     */   }
/*     */   
/*     */   protected void indent(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 827 */     paramAppendable.append('\n').append(StringUtil.padding(paramInt * paramOutputSettings.indentAmount(), paramOutputSettings.maxPaddingWidth()));
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
/*     */   public boolean equals(Object paramObject) {
/* 840 */     return (this == paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 851 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasSameValue(Object paramObject) {
/* 861 */     if (this == paramObject) return true; 
/* 862 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*     */     
/* 864 */     return outerHtml().equals(((Node)paramObject).outerHtml());
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
/*     */   public Node clone() {
/* 879 */     Node node = doClone(null);
/*     */     
/*     */     LinkedList<Node> linkedList;
/*     */     
/* 883 */     (linkedList = new LinkedList<>()).add(node);
/*     */     
/* 885 */     while (!linkedList.isEmpty()) {
/*     */       Node node1;
/*     */       
/* 888 */       int i = (node1 = linkedList.remove()).childNodeSize();
/* 889 */       for (byte b = 0; b < i; b++) {
/*     */         List<Node> list;
/* 891 */         Node node2 = ((Node)(list = node1.ensureChildNodes()).get(b)).doClone(node1);
/* 892 */         list.set(b, node2);
/* 893 */         linkedList.add(node2);
/*     */       } 
/*     */     } 
/*     */     
/* 897 */     return node;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Node shallowClone() {
/* 907 */     return doClone(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Node doClone(Node paramNode) {
/*     */     Node node;
/*     */     try {
/* 918 */       node = (Node)super.clone();
/* 919 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 920 */       throw new RuntimeException(cloneNotSupportedException);
/*     */     } 
/*     */     
/* 923 */     node.parentNode = (Node)cloneNotSupportedException;
/* 924 */     node.siblingIndex = (cloneNotSupportedException == null) ? 0 : this.siblingIndex;
/*     */     Document document;
/* 926 */     if (cloneNotSupportedException == null && !(this instanceof Document) && (
/*     */       
/* 928 */       document = ownerDocument()) != null) {
/* 929 */       document = document.shallowClone();
/* 930 */       node.parentNode = document;
/* 931 */       document.ensureChildNodes().add(node);
/*     */     } 
/*     */ 
/*     */     
/* 935 */     return node;
/*     */   } public abstract String nodeName(); protected abstract boolean hasAttributes(); public abstract Attributes attributes(); public abstract String baseUri(); protected abstract void doSetBaseUri(String paramString); protected abstract List<Node> ensureChildNodes();
/*     */   public abstract int childNodeSize();
/*     */   public abstract Node empty();
/*     */   abstract void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings);
/*     */   abstract void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings);
/*     */   private static class OuterHtmlVisitor implements NodeVisitor { private final Appendable accum;
/*     */     OuterHtmlVisitor(Appendable param1Appendable, Document.OutputSettings param1OutputSettings) {
/* 943 */       this.accum = param1Appendable;
/* 944 */       this.out = param1OutputSettings;
/* 945 */       param1OutputSettings.prepareEncoder();
/*     */     }
/*     */     private final Document.OutputSettings out;
/*     */     public void head(Node param1Node, int param1Int) {
/*     */       try {
/* 950 */         param1Node.outerHtmlHead(this.accum, param1Int, this.out); return;
/* 951 */       } catch (IOException iOException) {
/* 952 */         throw new SerializationException(iOException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void tail(Node param1Node, int param1Int) {
/* 957 */       if (!param1Node.nodeName().equals("#text"))
/*     */         try {
/* 959 */           param1Node.outerHtmlTail(this.accum, param1Int, this.out); return;
/* 960 */         } catch (IOException iOException) {
/* 961 */           throw new SerializationException(iOException);
/*     */         }  
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Node.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */