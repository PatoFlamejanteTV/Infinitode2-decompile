/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.UnaryOperator;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Comment;
/*     */ import org.jsoup.nodes.DataNode;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.FormElement;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
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
/*     */ public class Elements
/*     */   extends ArrayList<Element>
/*     */ {
/*     */   public Elements() {}
/*     */   
/*     */   public Elements(int paramInt) {
/*  35 */     super(paramInt);
/*     */   }
/*     */   
/*     */   public Elements(Collection<Element> paramCollection) {
/*  39 */     super(paramCollection);
/*     */   }
/*     */   
/*     */   public Elements(List<Element> paramList) {
/*  43 */     super(paramList);
/*     */   }
/*     */   
/*     */   public Elements(Element... paramVarArgs) {
/*  47 */     super(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements clone() {
/*  56 */     Elements elements = new Elements(size());
/*     */     
/*  58 */     for (Element element : this) {
/*  59 */       elements.add(element.clone());
/*     */     }
/*  61 */     return elements;
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
/*     */   public String attr(String paramString) {
/*  73 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/*  74 */       if ((element = iterator.next()).hasAttr(paramString))
/*  75 */         return element.attr(paramString); 
/*     */     } 
/*  77 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasAttr(String paramString) {
/*  86 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/*  87 */       if ((element = iterator.next()).hasAttr(paramString))
/*  88 */         return true; 
/*     */     } 
/*  90 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> eachAttr(String paramString) {
/* 101 */     ArrayList<String> arrayList = new ArrayList(size());
/* 102 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 103 */       if ((element = iterator.next()).hasAttr(paramString))
/* 104 */         arrayList.add(element.attr(paramString)); 
/*     */     } 
/* 106 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements attr(String paramString1, String paramString2) {
/* 116 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 117 */       (element = iterator.next()).attr(paramString1, paramString2);
/*     */     }
/* 119 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements removeAttr(String paramString) {
/* 128 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 129 */       (element = iterator.next()).removeAttr(paramString);
/*     */     }
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements addClass(String paramString) {
/* 140 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 141 */       (element = iterator.next()).addClass(paramString);
/*     */     }
/* 143 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements removeClass(String paramString) {
/* 152 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 153 */       (element = iterator.next()).removeClass(paramString);
/*     */     }
/* 155 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements toggleClass(String paramString) {
/* 164 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 165 */       (element = iterator.next()).toggleClass(paramString);
/*     */     }
/* 167 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasClass(String paramString) {
/* 176 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 177 */       if ((element = iterator.next()).hasClass(paramString))
/* 178 */         return true; 
/*     */     } 
/* 180 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String val() {
/* 189 */     if (size() > 0)
/*     */     {
/* 191 */       return first().val();
/*     */     }
/* 193 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements val(String paramString) {
/* 202 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();)
/* 203 */       (element = iterator.next()).val(paramString); 
/* 204 */     return this;
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
/*     */   public String text() {
/* 217 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 218 */     for (Element element : this) {
/* 219 */       if (stringBuilder.length() != 0)
/* 220 */         stringBuilder.append(" "); 
/* 221 */       stringBuilder.append(element.text());
/*     */     } 
/* 223 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasText() {
/* 232 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 233 */       if ((element = iterator.next()).hasText())
/* 234 */         return true; 
/*     */     } 
/* 236 */     return false;
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
/*     */   public List<String> eachText() {
/* 248 */     ArrayList<String> arrayList = new ArrayList(size());
/* 249 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 250 */       if ((element = iterator.next()).hasText())
/* 251 */         arrayList.add(element.text()); 
/*     */     } 
/* 253 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String html() {
/* 263 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 264 */     for (Element element : this) {
/* 265 */       if (stringBuilder.length() != 0)
/* 266 */         stringBuilder.append("\n"); 
/* 267 */       stringBuilder.append(element.html());
/*     */     } 
/* 269 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String outerHtml() {
/* 279 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 280 */     for (Element element : this) {
/* 281 */       if (stringBuilder.length() != 0)
/* 282 */         stringBuilder.append("\n"); 
/* 283 */       stringBuilder.append(element.outerHtml());
/*     */     } 
/* 285 */     return StringUtil.releaseBuilder(stringBuilder);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 296 */     return outerHtml();
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
/*     */   public Elements tagName(String paramString) {
/* 308 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 309 */       (element = iterator.next()).tagName(paramString);
/*     */     }
/* 311 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements html(String paramString) {
/* 321 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 322 */       (element = iterator.next()).html(paramString);
/*     */     }
/* 324 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements prepend(String paramString) {
/* 334 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 335 */       (element = iterator.next()).prepend(paramString);
/*     */     }
/* 337 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements append(String paramString) {
/* 347 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 348 */       (element = iterator.next()).append(paramString);
/*     */     }
/* 350 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements before(String paramString) {
/* 360 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 361 */       (element = iterator.next()).before(paramString);
/*     */     }
/* 363 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements after(String paramString) {
/* 373 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 374 */       (element = iterator.next()).after(paramString);
/*     */     }
/* 376 */     return this;
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
/*     */   public Elements wrap(String paramString) {
/* 389 */     Validate.notEmpty(paramString);
/* 390 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 391 */       (element = iterator.next()).wrap(paramString);
/*     */     }
/* 393 */     return this;
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
/*     */   public Elements unwrap() {
/* 411 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 412 */       (element = iterator.next()).unwrap();
/*     */     }
/* 414 */     return this;
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
/*     */   public Elements empty() {
/* 429 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 430 */       (element = iterator.next()).empty();
/*     */     }
/* 432 */     return this;
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
/*     */   public Elements remove() {
/* 450 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 451 */       (element = iterator.next()).remove();
/*     */     }
/* 453 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements select(String paramString) {
/* 464 */     return Selector.select(paramString, this);
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
/*     */   public Elements not(String paramString) {
/* 478 */     Elements elements = Selector.select(paramString, this);
/* 479 */     return Selector.filterOut(this, elements);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements eq(int paramInt) {
/* 490 */     return (size() > paramInt) ? new Elements(new Element[] { get(paramInt) }) : new Elements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(String paramString) {
/* 499 */     Evaluator evaluator = QueryParser.parse(paramString);
/* 500 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 501 */       if ((element = iterator.next()).is(evaluator))
/* 502 */         return true; 
/*     */     } 
/* 504 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements next() {
/* 512 */     return siblings((String)null, true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements next(String paramString) {
/* 521 */     return siblings(paramString, true, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements nextAll() {
/* 529 */     return siblings((String)null, true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements nextAll(String paramString) {
/* 538 */     return siblings(paramString, true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements prev() {
/* 546 */     return siblings((String)null, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements prev(String paramString) {
/* 555 */     return siblings(paramString, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements prevAll() {
/* 563 */     return siblings((String)null, false, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements prevAll(String paramString) {
/* 572 */     return siblings(paramString, false, true);
/*     */   }
/*     */   
/*     */   private Elements siblings(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 576 */     Elements elements = new Elements();
/* 577 */     Evaluator evaluator = (paramString != null) ? QueryParser.parse(paramString) : null;
/* 578 */     label25: for (Element element : this) {
/*     */       
/*     */       while (true)
/* 581 */       { if ((element = (Element)(paramBoolean1 ? element.nextElementSibling() : element.previousElementSibling())) != null)
/* 582 */         { if (evaluator == null) {
/* 583 */             elements.add(element);
/* 584 */           } else if (element.is(evaluator)) {
/* 585 */             elements.add(element);
/* 586 */           }  element = element;
/* 587 */           if (!paramBoolean2)
/*     */             continue label25;  continue; }  continue label25; } 
/* 589 */     }  return elements;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements parents() {
/* 597 */     LinkedHashSet<Element> linkedHashSet = new LinkedHashSet();
/* 598 */     for (Element element : this) {
/* 599 */       linkedHashSet.addAll(element.parents());
/*     */     }
/* 601 */     return new Elements(linkedHashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element first() {
/* 610 */     return isEmpty() ? null : get(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element last() {
/* 618 */     return isEmpty() ? null : get(size() - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements traverse(NodeVisitor paramNodeVisitor) {
/* 627 */     NodeTraversor.traverse(paramNodeVisitor, this);
/* 628 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Elements filter(NodeFilter paramNodeFilter) {
/* 637 */     NodeTraversor.filter(paramNodeFilter, this);
/* 638 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<FormElement> forms() {
/* 647 */     ArrayList<FormElement> arrayList = new ArrayList();
/* 648 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext();) {
/* 649 */       if (element = iterator.next() instanceof FormElement)
/* 650 */         arrayList.add((FormElement)element); 
/* 651 */     }  return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Comment> comments() {
/* 659 */     return childNodesOfType(Comment.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<TextNode> textNodes() {
/* 667 */     return childNodesOfType(TextNode.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<DataNode> dataNodes() {
/* 676 */     return childNodesOfType(DataNode.class);
/*     */   }
/*     */   
/*     */   private <T extends Node> List<T> childNodesOfType(Class<T> paramClass) {
/* 680 */     ArrayList<Node> arrayList = new ArrayList();
/* 681 */     for (Element element : this) {
/* 682 */       for (byte b = 0; b < element.childNodeSize(); b++) {
/* 683 */         Node node = element.childNode(b);
/* 684 */         if (paramClass.isInstance(node))
/* 685 */           arrayList.add((Node)paramClass.cast(node)); 
/*     */       } 
/*     */     } 
/* 688 */     return (List)arrayList;
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
/*     */   public Element set(int paramInt, Element paramElement) {
/* 701 */     Validate.notNull(paramElement);
/*     */     Element element;
/* 703 */     (element = super.set(paramInt, paramElement)).replaceWith((Node)paramElement);
/* 704 */     return element;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element remove(int paramInt) {
/*     */     Element element;
/* 715 */     (element = super.remove(paramInt)).remove();
/* 716 */     return element;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/*     */     int i;
/* 727 */     if ((i = indexOf(paramObject)) == -1) {
/* 728 */       return false;
/*     */     }
/* 730 */     remove(i);
/* 731 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 741 */     remove();
/* 742 */     super.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 753 */     boolean bool = false;
/* 754 */     for (Object object : paramCollection) {
/* 755 */       bool |= remove(object);
/*     */     }
/* 757 */     return bool;
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
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 769 */     boolean bool = false;
/* 770 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext(); ) {
/* 771 */       Element element = iterator.next();
/* 772 */       if (!paramCollection.contains(element)) {
/* 773 */         iterator.remove();
/* 774 */         bool = true;
/*     */       } 
/*     */     } 
/* 777 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeIf(Predicate<? super Element> paramPredicate) {
/* 787 */     boolean bool = false;
/* 788 */     for (Iterator<Element> iterator = iterator(); iterator.hasNext(); ) {
/* 789 */       Element element = iterator.next();
/* 790 */       if (paramPredicate.test(element)) {
/* 791 */         iterator.remove();
/* 792 */         bool = true;
/*     */       } 
/*     */     } 
/* 795 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceAll(UnaryOperator<Element> paramUnaryOperator) {
/* 804 */     for (byte b = 0; b < size(); b++)
/* 805 */       set(b, paramUnaryOperator.apply(get(b))); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\Elements.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */