/*      */ package org.jsoup.nodes;
/*      */ 
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.atomic.AtomicBoolean;
/*      */ import java.util.function.Consumer;
/*      */ import java.util.regex.Pattern;
/*      */ import java.util.regex.PatternSyntaxException;
/*      */ import java.util.stream.Collectors;
/*      */ import java.util.stream.Stream;
/*      */ import org.jsoup.helper.ChangeNotifyingArrayList;
/*      */ import org.jsoup.helper.Validate;
/*      */ import org.jsoup.internal.Normalizer;
/*      */ import org.jsoup.internal.StringUtil;
/*      */ import org.jsoup.parser.ParseSettings;
/*      */ import org.jsoup.parser.Tag;
/*      */ import org.jsoup.parser.TokenQueue;
/*      */ import org.jsoup.select.Collector;
/*      */ import org.jsoup.select.Elements;
/*      */ import org.jsoup.select.Evaluator;
/*      */ import org.jsoup.select.NodeFilter;
/*      */ import org.jsoup.select.NodeTraversor;
/*      */ import org.jsoup.select.NodeVisitor;
/*      */ import org.jsoup.select.QueryParser;
/*      */ import org.jsoup.select.Selector;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Element
/*      */   extends Node
/*      */ {
/*   47 */   private static final List<Element> EmptyChildren = Collections.emptyList();
/*   48 */   private static final Pattern ClassSplit = Pattern.compile("\\s+");
/*   49 */   private static final String BaseUriKey = Attributes.internalKey("baseUri");
/*      */   
/*      */   private Tag tag;
/*      */   
/*      */   private WeakReference<List<Element>> shadowChildrenRef;
/*      */   
/*      */   List<Node> childNodes;
/*      */   
/*      */   Attributes attributes;
/*      */ 
/*      */   
/*      */   public Element(String paramString1, String paramString2) {
/*   61 */     this(Tag.valueOf(paramString1, paramString2, ParseSettings.preserveCase), (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element(String paramString) {
/*   70 */     this(Tag.valueOf(paramString, "http://www.w3.org/1999/xhtml", ParseSettings.preserveCase), "", (Attributes)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element(Tag paramTag, String paramString, Attributes paramAttributes) {
/*   83 */     Validate.notNull(paramTag);
/*   84 */     this.childNodes = EmptyNodes;
/*   85 */     this.attributes = paramAttributes;
/*   86 */     this.tag = paramTag;
/*   87 */     if (paramString != null) {
/*   88 */       setBaseUri(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element(Tag paramTag, String paramString) {
/*   99 */     this(paramTag, paramString, (Attributes)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean hasChildNodes() {
/*  106 */     return (this.childNodes != EmptyNodes);
/*      */   }
/*      */   
/*      */   protected List<Node> ensureChildNodes() {
/*  110 */     if (this.childNodes == EmptyNodes) {
/*  111 */       this.childNodes = (List<Node>)new NodeList(this, 4);
/*      */     }
/*  113 */     return this.childNodes;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean hasAttributes() {
/*  118 */     return (this.attributes != null);
/*      */   }
/*      */ 
/*      */   
/*      */   public Attributes attributes() {
/*  123 */     if (this.attributes == null)
/*  124 */       this.attributes = new Attributes(); 
/*  125 */     return this.attributes;
/*      */   }
/*      */ 
/*      */   
/*      */   public String baseUri() {
/*  130 */     return searchUpForAttribute(this, BaseUriKey);
/*      */   }
/*      */   
/*      */   private static String searchUpForAttribute(Element paramElement, String paramString) {
/*  134 */     paramElement = paramElement;
/*  135 */     while (paramElement != null) {
/*  136 */       if (paramElement.attributes != null && paramElement.attributes.hasKey(paramString))
/*  137 */         return paramElement.attributes.get(paramString); 
/*  138 */       paramElement = paramElement.parent();
/*      */     } 
/*  140 */     return "";
/*      */   }
/*      */ 
/*      */   
/*      */   protected void doSetBaseUri(String paramString) {
/*  145 */     attributes().put(BaseUriKey, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public int childNodeSize() {
/*  150 */     return this.childNodes.size();
/*      */   }
/*      */ 
/*      */   
/*      */   public String nodeName() {
/*  155 */     return this.tag.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String tagName() {
/*  165 */     return this.tag.getName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String normalName() {
/*  176 */     return this.tag.normalName();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean elementIs(String paramString1, String paramString2) {
/*  187 */     return (this.tag.normalName().equals(paramString1) && this.tag.namespace().equals(paramString2));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element tagName(String paramString) {
/*  199 */     return tagName(paramString, this.tag.namespace());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element tagName(String paramString1, String paramString2) {
/*  212 */     Validate.notEmptyParam(paramString1, "tagName");
/*  213 */     Validate.notEmptyParam(paramString2, "namespace");
/*  214 */     this.tag = Tag.valueOf(paramString1, paramString2, NodeUtils.parser(this).settings());
/*  215 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Tag tag() {
/*  224 */     return this.tag;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBlock() {
/*  234 */     return this.tag.isBlock();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String id() {
/*  243 */     return (this.attributes != null) ? this.attributes.getIgnoreCase("id") : "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element id(String paramString) {
/*  252 */     Validate.notNull(paramString);
/*  253 */     attr("id", paramString);
/*  254 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element attr(String paramString1, String paramString2) {
/*  264 */     super.attr(paramString1, paramString2);
/*  265 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element attr(String paramString, boolean paramBoolean) {
/*  279 */     attributes().put(paramString, paramBoolean);
/*  280 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Attribute attribute(String paramString) {
/*  291 */     return hasAttributes() ? attributes().attribute(paramString) : null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map<String, String> dataset() {
/*  308 */     return attributes().dataset();
/*      */   }
/*      */ 
/*      */   
/*      */   public final Element parent() {
/*  313 */     return (Element)this.parentNode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements parents() {
/*  321 */     Elements elements = new Elements();
/*  322 */     Element element = parent();
/*  323 */     while (element != null && !element.nameIs("#root")) {
/*  324 */       elements.add(element);
/*  325 */       element = element.parent();
/*      */     } 
/*  327 */     return elements;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element child(int paramInt) {
/*  342 */     return childElementsList().get(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int childrenSize() {
/*  357 */     return childElementsList().size();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements children() {
/*  369 */     return new Elements(childElementsList());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   List<Element> childElementsList() {
/*  378 */     if (childNodeSize() == 0) {
/*  379 */       return EmptyChildren;
/*      */     }
/*      */     List<Element> list;
/*  382 */     if (this.shadowChildrenRef == null || (list = this.shadowChildrenRef.get()) == null) {
/*  383 */       int i = this.childNodes.size();
/*  384 */       list = new ArrayList(i);
/*      */       
/*  386 */       for (byte b = 0; b < i; b++) {
/*      */         Node node;
/*  388 */         if (node = this.childNodes.get(b) instanceof Element)
/*  389 */           list.add((Element)node); 
/*      */       } 
/*  391 */       this.shadowChildrenRef = new WeakReference<>(list);
/*      */     } 
/*  393 */     return list;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void nodelistChanged() {
/*  401 */     super.nodelistChanged();
/*  402 */     this.shadowChildrenRef = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Stream<Element> stream() {
/*  412 */     return NodeUtils.stream(this, Element.class);
/*      */   }
/*      */ 
/*      */   
/*      */   private <T> List<T> filterNodes(Class<T> paramClass) {
/*  417 */     Objects.requireNonNull(paramClass);
/*  418 */     Objects.requireNonNull(paramClass); return (List<T>)this.childNodes.stream().filter(paramClass::isInstance).map(paramClass::cast)
/*  419 */       .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<TextNode> textNodes() {
/*  439 */     return filterNodes(TextNode.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<DataNode> dataNodes() {
/*  452 */     return filterNodes(DataNode.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements select(String paramString) {
/*  474 */     return Selector.select(paramString, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements select(Evaluator paramEvaluator) {
/*  485 */     return Selector.select(paramEvaluator, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element selectFirst(String paramString) {
/*  498 */     return Selector.selectFirst(paramString, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element selectFirst(Evaluator paramEvaluator) {
/*  510 */     return Collector.findFirst(paramEvaluator, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element expectFirst(String paramString) {
/*  522 */     return (Element)Validate.ensureNotNull(
/*  523 */         Selector.selectFirst(paramString, this), 
/*  524 */         (parent() != null) ? 
/*  525 */         "No elements matched the query '%s' on element '%s'." : 
/*  526 */         "No elements matched the query '%s' in the document.", new Object[] { paramString, 
/*  527 */           tagName() });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean is(String paramString) {
/*  539 */     return is(QueryParser.parse(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean is(Evaluator paramEvaluator) {
/*  548 */     return paramEvaluator.matches(root(), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element closest(String paramString) {
/*  559 */     return closest(QueryParser.parse(paramString));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element closest(Evaluator paramEvaluator) {
/*  570 */     Validate.notNull(paramEvaluator);
/*  571 */     Element element1 = this;
/*  572 */     Element element2 = root();
/*      */     while (true) {
/*  574 */       if (paramEvaluator.matches(element2, element1)) {
/*  575 */         return element1;
/*      */       }
/*  577 */       if ((element1 = element1.parent()) == null) {
/*  578 */         return null;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements selectXpath(String paramString) {
/*  600 */     return new Elements(NodeUtils.selectXpath(paramString, this, Element.class));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T extends Node> List<T> selectXpath(String paramString, Class<T> paramClass) {
/*  617 */     return NodeUtils.selectXpath(paramString, this, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendChild(Node paramNode) {
/*  629 */     Validate.notNull(paramNode);
/*      */ 
/*      */     
/*  632 */     reparentChild(paramNode);
/*  633 */     ensureChildNodes();
/*  634 */     this.childNodes.add(paramNode);
/*  635 */     paramNode.setSiblingIndex(this.childNodes.size() - 1);
/*  636 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendChildren(Collection<? extends Node> paramCollection) {
/*  647 */     insertChildren(-1, paramCollection);
/*  648 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendTo(Element paramElement) {
/*  658 */     Validate.notNull(paramElement);
/*  659 */     paramElement.appendChild(this);
/*  660 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependChild(Node paramNode) {
/*  670 */     Validate.notNull(paramNode);
/*      */     
/*  672 */     addChildren(0, new Node[] { paramNode });
/*  673 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependChildren(Collection<? extends Node> paramCollection) {
/*  684 */     insertChildren(0, paramCollection);
/*  685 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element insertChildren(int paramInt, Collection<? extends Node> paramCollection) {
/*  699 */     Validate.notNull(paramCollection, "Children collection to be inserted must not be null.");
/*  700 */     int i = childNodeSize();
/*  701 */     if (paramInt < 0) paramInt += i + 1; 
/*  702 */     Validate.isTrue((paramInt >= 0 && paramInt <= i), "Insert position out of bounds.");
/*      */ 
/*      */     
/*  705 */     Node[] arrayOfNode = (paramCollection = new ArrayList<>(paramCollection)).<Node>toArray(new Node[0]);
/*  706 */     addChildren(paramInt, arrayOfNode);
/*  707 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element insertChildren(int paramInt, Node... paramVarArgs) {
/*  720 */     Validate.notNull(paramVarArgs, "Children collection to be inserted must not be null.");
/*  721 */     int i = childNodeSize();
/*  722 */     if (paramInt < 0) paramInt += i + 1; 
/*  723 */     Validate.isTrue((paramInt >= 0 && paramInt <= i), "Insert position out of bounds.");
/*      */     
/*  725 */     addChildren(paramInt, paramVarArgs);
/*  726 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendElement(String paramString) {
/*  737 */     return appendElement(paramString, this.tag.namespace());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendElement(String paramString1, String paramString2) {
/*  748 */     Element element = new Element(Tag.valueOf(paramString1, paramString2, NodeUtils.parser(this).settings()), baseUri());
/*  749 */     appendChild(element);
/*  750 */     return element;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependElement(String paramString) {
/*  761 */     return prependElement(paramString, this.tag.namespace());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependElement(String paramString1, String paramString2) {
/*  772 */     Element element = new Element(Tag.valueOf(paramString1, paramString2, NodeUtils.parser(this).settings()), baseUri());
/*  773 */     prependChild(element);
/*  774 */     return element;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element appendText(String paramString) {
/*  784 */     Validate.notNull(paramString);
/*  785 */     TextNode textNode = new TextNode(paramString);
/*  786 */     appendChild(textNode);
/*  787 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prependText(String paramString) {
/*  797 */     Validate.notNull(paramString);
/*  798 */     TextNode textNode = new TextNode(paramString);
/*  799 */     prependChild(textNode);
/*  800 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element append(String paramString) {
/*  810 */     Validate.notNull(paramString);
/*  811 */     List list = NodeUtils.parser(this).parseFragmentInput(paramString, this, baseUri());
/*  812 */     addChildren((Node[])list.toArray((Object[])new Node[0]));
/*  813 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element prepend(String paramString) {
/*  823 */     Validate.notNull(paramString);
/*  824 */     List list = NodeUtils.parser(this).parseFragmentInput(paramString, this, baseUri());
/*  825 */     addChildren(0, (Node[])list.toArray((Object[])new Node[0]));
/*  826 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element before(String paramString) {
/*  838 */     return (Element)super.before(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element before(Node paramNode) {
/*  849 */     return (Element)super.before(paramNode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element after(String paramString) {
/*  861 */     return (Element)super.after(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element after(Node paramNode) {
/*  872 */     return (Element)super.after(paramNode);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element empty() {
/*  883 */     for (Iterator<Node> iterator = this.childNodes.iterator(); iterator.hasNext();) {
/*  884 */       (node = iterator.next()).parentNode = null;
/*      */     }
/*  886 */     this.childNodes.clear();
/*  887 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element wrap(String paramString) {
/*  898 */     return (Element)super.wrap(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String cssSelector() {
/*  912 */     if (id().length() > 0) {
/*      */       
/*  914 */       String str = "#" + TokenQueue.escapeCssIdentifier(id());
/*      */       Document document;
/*  916 */       if ((document = ownerDocument()) != null) {
/*      */         Elements elements;
/*  918 */         if ((elements = document.select(str)).size() == 1 && elements.get(0) == this)
/*  919 */           return str; 
/*      */       } else {
/*  921 */         return str;
/*      */       } 
/*      */     } 
/*      */     
/*  925 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/*  926 */     Element element = this;
/*  927 */     while (element != null && !(element instanceof Document)) {
/*  928 */       stringBuilder.insert(0, element.cssSelectorComponent());
/*  929 */       element = element.parent();
/*      */     } 
/*  931 */     return StringUtil.releaseBuilder(stringBuilder);
/*      */   }
/*      */ 
/*      */   
/*      */   private String cssSelectorComponent() {
/*  936 */     String str1 = TokenQueue.escapeCssIdentifier(tagName()).replace("\\:", "|");
/*  937 */     StringBuilder stringBuilder = StringUtil.borrowBuilder().append(str1);
/*      */ 
/*      */     
/*  940 */     StringUtil.StringJoiner stringJoiner = new StringUtil.StringJoiner(".");
/*  941 */     for (String str : classNames()) stringJoiner.add(TokenQueue.escapeCssIdentifier(str)); 
/*      */     String str2;
/*  943 */     if ((str2 = stringJoiner.complete()).length() > 0) {
/*  944 */       stringBuilder.append('.').append(str2);
/*      */     }
/*  946 */     if (parent() == null || parent() instanceof Document) {
/*  947 */       return StringUtil.releaseBuilder(stringBuilder);
/*      */     }
/*  949 */     stringBuilder.insert(0, " > ");
/*  950 */     if (parent().select(stringBuilder.toString()).size() > 1)
/*  951 */       stringBuilder.append(String.format(":nth-child(%d)", new Object[] {
/*  952 */               Integer.valueOf(elementSiblingIndex() + 1)
/*      */             })); 
/*  954 */     return StringUtil.releaseBuilder(stringBuilder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements siblingElements() {
/*  963 */     if (this.parentNode == null) {
/*  964 */       return new Elements(0);
/*      */     }
/*  966 */     List<Element> list = parent().childElementsList();
/*  967 */     Elements elements = new Elements(list.size() - 1);
/*  968 */     for (Iterator<Element> iterator = list.iterator(); iterator.hasNext();) {
/*  969 */       if ((element = iterator.next()) != this)
/*  970 */         elements.add(element); 
/*  971 */     }  return elements;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element nextElementSibling() {
/*  984 */     Element element = this; Node node;
/*  985 */     while ((node = element.nextSibling()) != null) {
/*  986 */       if (node instanceof Element) return (Element)node; 
/*      */     } 
/*  988 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements nextElementSiblings() {
/*  997 */     return nextElementSiblings(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element previousElementSibling() {
/* 1006 */     Element element = this; Node node;
/* 1007 */     while ((node = element.previousSibling()) != null) {
/* 1008 */       if (node instanceof Element) return (Element)node; 
/*      */     } 
/* 1010 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements previousElementSiblings() {
/* 1019 */     return nextElementSiblings(false);
/*      */   }
/*      */   
/*      */   private Elements nextElementSiblings(boolean paramBoolean) {
/* 1023 */     Elements elements = new Elements();
/* 1024 */     if (this.parentNode == null)
/* 1025 */       return elements; 
/* 1026 */     elements.add(this);
/* 1027 */     return paramBoolean ? elements.nextAll() : elements.prevAll();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element firstElementSibling() {
/* 1035 */     if (parent() != null)
/*      */     {
/* 1037 */       return parent().firstElementChild();
/*      */     }
/* 1039 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int elementSiblingIndex() {
/* 1048 */     if (parent() == null) return 0; 
/* 1049 */     return indexInList(this, parent().childElementsList());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element lastElementSibling() {
/* 1057 */     if (parent() != null)
/*      */     {
/* 1059 */       return parent().lastElementChild();
/*      */     }
/* 1061 */     return this;
/*      */   }
/*      */   
/*      */   private static <E extends Element> int indexInList(Element paramElement, List<E> paramList) {
/* 1065 */     int i = paramList.size();
/* 1066 */     for (byte b = 0; b < i; b++) {
/* 1067 */       if (paramList.get(b) == paramElement)
/* 1068 */         return b; 
/*      */     } 
/* 1070 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element firstElementChild() {
/* 1081 */     Node node = firstChild();
/* 1082 */     while (node != null) {
/* 1083 */       if (node instanceof Element) return (Element)node; 
/* 1084 */       node = node.nextSibling();
/*      */     } 
/* 1086 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element lastElementChild() {
/* 1097 */     Node node = lastChild();
/* 1098 */     while (node != null) {
/* 1099 */       if (node instanceof Element) return (Element)node; 
/* 1100 */       node = node.previousSibling();
/*      */     } 
/* 1102 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByTag(String paramString) {
/* 1113 */     Validate.notEmpty(paramString);
/* 1114 */     paramString = Normalizer.normalize(paramString);
/*      */     
/* 1116 */     return Collector.collect((Evaluator)new Evaluator.Tag(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element getElementById(String paramString) {
/* 1129 */     Validate.notEmpty(paramString);
/*      */     
/*      */     Elements elements;
/* 1132 */     if ((elements = Collector.collect((Evaluator)new Evaluator.Id(paramString), this)).size() > 0) {
/* 1133 */       return (Element)elements.get(0);
/*      */     }
/* 1135 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByClass(String paramString) {
/* 1150 */     Validate.notEmpty(paramString);
/*      */     
/* 1152 */     return Collector.collect((Evaluator)new Evaluator.Class(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttribute(String paramString) {
/* 1162 */     Validate.notEmpty(paramString);
/* 1163 */     paramString = paramString.trim();
/*      */     
/* 1165 */     return Collector.collect((Evaluator)new Evaluator.Attribute(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeStarting(String paramString) {
/* 1175 */     Validate.notEmpty(paramString);
/* 1176 */     paramString = paramString.trim();
/*      */     
/* 1178 */     return Collector.collect((Evaluator)new Evaluator.AttributeStarting(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValue(String paramString1, String paramString2) {
/* 1189 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValue(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueNot(String paramString1, String paramString2) {
/* 1200 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueNot(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueStarting(String paramString1, String paramString2) {
/* 1211 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueStarting(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueEnding(String paramString1, String paramString2) {
/* 1222 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueEnding(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueContaining(String paramString1, String paramString2) {
/* 1233 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueContaining(paramString1, paramString2), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueMatching(String paramString, Pattern paramPattern) {
/* 1243 */     return Collector.collect((Evaluator)new Evaluator.AttributeWithValueMatching(paramString, paramPattern), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByAttributeValueMatching(String paramString1, String paramString2) {
/*      */     Pattern pattern;
/*      */     try {
/* 1256 */       pattern = Pattern.compile(paramString2);
/* 1257 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 1258 */       throw new IllegalArgumentException("Pattern syntax error: " + paramString2, patternSyntaxException);
/*      */     } 
/* 1260 */     return getElementsByAttributeValueMatching((String)patternSyntaxException, pattern);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByIndexLessThan(int paramInt) {
/* 1269 */     return Collector.collect((Evaluator)new Evaluator.IndexLessThan(paramInt), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByIndexGreaterThan(int paramInt) {
/* 1278 */     return Collector.collect((Evaluator)new Evaluator.IndexGreaterThan(paramInt), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsByIndexEquals(int paramInt) {
/* 1287 */     return Collector.collect((Evaluator)new Evaluator.IndexEquals(paramInt), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsContainingText(String paramString) {
/* 1298 */     return Collector.collect((Evaluator)new Evaluator.ContainsText(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsContainingOwnText(String paramString) {
/* 1309 */     return Collector.collect((Evaluator)new Evaluator.ContainsOwnText(paramString), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingText(Pattern paramPattern) {
/* 1319 */     return Collector.collect((Evaluator)new Evaluator.Matches(paramPattern), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingText(String paramString) {
/*      */     try {
/* 1331 */       Pattern pattern = Pattern.compile(paramString);
/* 1332 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 1333 */       throw new IllegalArgumentException("Pattern syntax error: " + paramString, patternSyntaxException);
/*      */     } 
/* 1335 */     return getElementsMatchingText((Pattern)patternSyntaxException);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingOwnText(Pattern paramPattern) {
/* 1345 */     return Collector.collect((Evaluator)new Evaluator.MatchesOwn(paramPattern), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getElementsMatchingOwnText(String paramString) {
/*      */     try {
/* 1357 */       Pattern pattern = Pattern.compile(paramString);
/* 1358 */     } catch (PatternSyntaxException patternSyntaxException) {
/* 1359 */       throw new IllegalArgumentException("Pattern syntax error: " + paramString, patternSyntaxException);
/*      */     } 
/* 1361 */     return getElementsMatchingOwnText((Pattern)patternSyntaxException);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Elements getAllElements() {
/* 1370 */     return Collector.collect((Evaluator)new Evaluator.AllElements(), this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String text() {
/* 1390 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 1391 */     NodeTraversor.traverse(new TextAccumulator(stringBuilder), this);
/* 1392 */     return StringUtil.releaseBuilder(stringBuilder).trim();
/*      */   }
/*      */   
/*      */   private static class TextAccumulator implements NodeVisitor {
/*      */     private final StringBuilder accum;
/*      */     
/*      */     public TextAccumulator(StringBuilder param1StringBuilder) {
/* 1399 */       this.accum = param1StringBuilder;
/*      */     }
/*      */     
/*      */     public void head(Node param1Node, int param1Int) {
/* 1403 */       if (param1Node instanceof TextNode) {
/* 1404 */         param1Node = param1Node;
/* 1405 */         Element.appendNormalisedText(this.accum, (TextNode)param1Node); return;
/* 1406 */       }  if (param1Node instanceof Element) {
/* 1407 */         param1Node = param1Node;
/* 1408 */         if (this.accum.length() > 0 && (param1Node
/* 1409 */           .isBlock() || param1Node.nameIs("br")) && 
/* 1410 */           !TextNode.lastCharIsWhitespace(this.accum)) {
/* 1411 */           this.accum.append(' ');
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     public void tail(Node param1Node, int param1Int) {
/* 1417 */       if (param1Node instanceof Element) {
/* 1418 */         Element element = (Element)param1Node;
/* 1419 */         param1Node = param1Node.nextSibling();
/* 1420 */         if (element.isBlock() && (param1Node instanceof TextNode || (param1Node instanceof Element && !((Element)param1Node).tag.formatAsBlock())) && !TextNode.lastCharIsWhitespace(this.accum)) {
/* 1421 */           this.accum.append(' ');
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String wholeText() {
/* 1435 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 1436 */     nodeStream().forEach(paramNode -> appendWholeText(paramNode, paramStringBuilder));
/* 1437 */     return StringUtil.releaseBuilder(stringBuilder);
/*      */   }
/*      */   
/*      */   private static void appendWholeText(Node paramNode, StringBuilder paramStringBuilder) {
/* 1441 */     if (paramNode instanceof TextNode) {
/* 1442 */       paramStringBuilder.append(((TextNode)paramNode).getWholeText()); return;
/* 1443 */     }  if (paramNode.nameIs("br")) {
/* 1444 */       paramStringBuilder.append("\n");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String wholeOwnText() {
/* 1458 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 1459 */     int i = childNodeSize();
/* 1460 */     for (byte b = 0; b < i; b++) {
/*      */       Node node;
/* 1462 */       appendWholeText(node = this.childNodes.get(b), stringBuilder);
/*      */     } 
/*      */     
/* 1465 */     return StringUtil.releaseBuilder(stringBuilder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String ownText() {
/* 1480 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 1481 */     ownText(stringBuilder);
/* 1482 */     return StringUtil.releaseBuilder(stringBuilder).trim();
/*      */   }
/*      */   
/*      */   private void ownText(StringBuilder paramStringBuilder) {
/* 1486 */     for (byte b = 0; b < childNodeSize(); b++) {
/*      */       Node node;
/* 1488 */       if (node = this.childNodes.get(b) instanceof TextNode) {
/* 1489 */         node = node;
/* 1490 */         appendNormalisedText(paramStringBuilder, (TextNode)node);
/* 1491 */       } else if (node.nameIs("br") && !TextNode.lastCharIsWhitespace(paramStringBuilder)) {
/* 1492 */         paramStringBuilder.append(" ");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void appendNormalisedText(StringBuilder paramStringBuilder, TextNode paramTextNode) {
/* 1498 */     String str = paramTextNode.getWholeText();
/* 1499 */     if (preserveWhitespace(paramTextNode.parentNode) || paramTextNode instanceof CDataNode) {
/* 1500 */       paramStringBuilder.append(str); return;
/*      */     } 
/* 1502 */     StringUtil.appendNormalisedWhitespace(paramStringBuilder, str, TextNode.lastCharIsWhitespace(paramStringBuilder));
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean preserveWhitespace(Node paramNode) {
/* 1507 */     if (paramNode instanceof Element) {
/* 1508 */       paramNode = paramNode;
/* 1509 */       byte b = 0;
/*      */       do {
/* 1511 */         if (((Element)paramNode).tag.preserveWhitespace())
/* 1512 */           return true; 
/* 1513 */         paramNode = paramNode.parent();
/* 1514 */         ++b;
/* 1515 */       } while (b < 6 && paramNode != null);
/*      */     } 
/* 1517 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element text(String paramString) {
/* 1528 */     Validate.notNull(paramString);
/* 1529 */     empty();
/*      */     
/*      */     Document document;
/*      */     
/* 1533 */     if ((document = ownerDocument()) != null && document.parser().isContentForTagData(normalName())) {
/* 1534 */       appendChild(new DataNode(paramString));
/*      */     } else {
/* 1536 */       appendChild(new TextNode(paramString));
/*      */     } 
/* 1538 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasText() {
/* 1546 */     AtomicBoolean atomicBoolean = new AtomicBoolean(false);
/* 1547 */     filter((paramNode, paramInt) -> {
/*      */           if (paramNode instanceof TextNode && !(paramNode = paramNode).isBlank()) {
/*      */             paramAtomicBoolean.set(true);
/*      */             
/*      */             return NodeFilter.FilterResult.STOP;
/*      */           } 
/*      */           
/*      */           return NodeFilter.FilterResult.CONTINUE;
/*      */         });
/*      */     
/* 1557 */     return atomicBoolean.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String data() {
/* 1570 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 1571 */     traverse((paramNode, paramInt) -> {
/*      */           if (paramNode instanceof DataNode) {
/*      */             paramNode = paramNode; paramStringBuilder.append(paramNode.getWholeData()); return;
/*      */           } 
/*      */           if (paramNode instanceof Comment) {
/*      */             paramNode = paramNode;
/*      */             paramStringBuilder.append(paramNode.getData());
/*      */             return;
/*      */           } 
/*      */           if (paramNode instanceof CDataNode) {
/*      */             paramNode = paramNode;
/*      */             paramStringBuilder.append(paramNode.getWholeText());
/*      */           } 
/*      */         });
/* 1585 */     return StringUtil.releaseBuilder(stringBuilder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String className() {
/* 1594 */     return attr("class").trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<String> classNames() {
/* 1604 */     String[] arrayOfString = ClassSplit.split(className());
/*      */     LinkedHashSet<?> linkedHashSet;
/* 1606 */     (linkedHashSet = new LinkedHashSet(Arrays.asList((Object[])arrayOfString))).remove("");
/*      */     
/* 1608 */     return (Set)linkedHashSet;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element classNames(Set<String> paramSet) {
/* 1617 */     Validate.notNull(paramSet);
/* 1618 */     if (paramSet.isEmpty()) {
/* 1619 */       attributes().remove("class");
/*      */     } else {
/* 1621 */       attributes().put("class", StringUtil.join(paramSet, " "));
/*      */     } 
/* 1623 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasClass(String paramString) {
/* 1633 */     if (this.attributes == null) {
/* 1634 */       return false;
/*      */     }
/*      */     String str;
/* 1637 */     int i = (str = this.attributes.getIgnoreCase("class")).length();
/* 1638 */     int j = paramString.length();
/*      */     
/* 1640 */     if (i == 0 || i < j) {
/* 1641 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1645 */     if (i == j) {
/* 1646 */       return paramString.equalsIgnoreCase(str);
/*      */     }
/*      */ 
/*      */     
/* 1650 */     boolean bool = false;
/* 1651 */     byte b1 = 0;
/* 1652 */     for (byte b2 = 0; b2 < i; b2++) {
/* 1653 */       if (Character.isWhitespace(str.charAt(b2))) {
/* 1654 */         if (bool)
/*      */         {
/* 1656 */           if (b2 - b1 == j && str.regionMatches(true, b1, paramString, 0, j)) {
/* 1657 */             return true;
/*      */           }
/* 1659 */           bool = false;
/*      */         }
/*      */       
/* 1662 */       } else if (!bool) {
/*      */         
/* 1664 */         bool = true;
/* 1665 */         b1 = b2;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1671 */     if (bool && i - b1 == j) {
/* 1672 */       return str.regionMatches(true, b1, paramString, 0, j);
/*      */     }
/*      */     
/* 1675 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element addClass(String paramString) {
/* 1684 */     Validate.notNull(paramString);
/*      */     
/*      */     Set<String> set;
/* 1687 */     (set = classNames()).add(paramString);
/* 1688 */     classNames(set);
/*      */     
/* 1690 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element removeClass(String paramString) {
/* 1699 */     Validate.notNull(paramString);
/*      */     
/*      */     Set<String> set;
/* 1702 */     (set = classNames()).remove(paramString);
/* 1703 */     classNames(set);
/*      */     
/* 1705 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element toggleClass(String paramString) {
/* 1714 */     Validate.notNull(paramString);
/*      */     
/*      */     Set<String> set;
/* 1717 */     if ((set = classNames()).contains(paramString)) {
/* 1718 */       set.remove(paramString);
/*      */     } else {
/* 1720 */       set.add(paramString);
/* 1721 */     }  classNames(set);
/*      */     
/* 1723 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String val() {
/* 1731 */     if (elementIs("textarea", "http://www.w3.org/1999/xhtml")) {
/* 1732 */       return text();
/*      */     }
/* 1734 */     return attr("value");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element val(String paramString) {
/* 1743 */     if (elementIs("textarea", "http://www.w3.org/1999/xhtml")) {
/* 1744 */       text(paramString);
/*      */     } else {
/* 1746 */       attr("value", paramString);
/* 1747 */     }  return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Range endSourceRange() {
/* 1760 */     return Range.of(this, false);
/*      */   }
/*      */   
/*      */   boolean shouldIndent(Document.OutputSettings paramOutputSettings) {
/* 1764 */     return (paramOutputSettings.prettyPrint() && isFormatAsBlock(paramOutputSettings) && !isInlineable(paramOutputSettings) && !preserveWhitespace(this.parentNode));
/*      */   }
/*      */ 
/*      */   
/*      */   void outerHtmlHead(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 1769 */     if (shouldIndent(paramOutputSettings) && (
/* 1770 */       !(paramAppendable instanceof StringBuilder) || (
/* 1771 */       (StringBuilder)paramAppendable).length() > 0))
/*      */     {
/*      */       
/* 1774 */       indent(paramAppendable, paramInt, paramOutputSettings);
/*      */     }
/*      */     
/* 1777 */     paramAppendable.append('<').append(tagName());
/* 1778 */     if (this.attributes != null) this.attributes.html(paramAppendable, paramOutputSettings);
/*      */ 
/*      */     
/* 1781 */     if (this.childNodes.isEmpty() && this.tag.isSelfClosing()) {
/* 1782 */       if (paramOutputSettings.syntax() == Document.OutputSettings.Syntax.html && this.tag.isEmpty()) {
/* 1783 */         paramAppendable.append('>'); return;
/*      */       } 
/* 1785 */       paramAppendable.append(" />");
/*      */       return;
/*      */     } 
/* 1788 */     paramAppendable.append('>');
/*      */   }
/*      */ 
/*      */   
/*      */   void outerHtmlTail(Appendable paramAppendable, int paramInt, Document.OutputSettings paramOutputSettings) {
/* 1793 */     if (!this.childNodes.isEmpty() || !this.tag.isSelfClosing()) {
/* 1794 */       if (paramOutputSettings.prettyPrint() && !this.childNodes.isEmpty() && ((this.tag
/* 1795 */         .formatAsBlock() && !preserveWhitespace(this.parentNode)) || (paramOutputSettings
/* 1796 */         .outline() && (this.childNodes.size() > 1 || (this.childNodes.size() == 1 && this.childNodes.get(0) instanceof Element)))))
/*      */       {
/* 1798 */         indent(paramAppendable, paramInt, paramOutputSettings); } 
/* 1799 */       paramAppendable.append("</").append(tagName()).append('>');
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String html() {
/* 1811 */     StringBuilder stringBuilder = StringUtil.borrowBuilder();
/* 1812 */     html(stringBuilder);
/* 1813 */     String str = StringUtil.releaseBuilder(stringBuilder);
/* 1814 */     return NodeUtils.outputSettings(this).prettyPrint() ? str.trim() : str;
/*      */   }
/*      */ 
/*      */   
/*      */   public <T extends Appendable> T html(T paramT) {
/* 1819 */     int i = this.childNodes.size();
/* 1820 */     for (byte b = 0; b < i; b++) {
/* 1821 */       ((Node)this.childNodes.get(b)).outerHtml((Appendable)paramT);
/*      */     }
/* 1823 */     return paramT;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Element html(String paramString) {
/* 1833 */     empty();
/* 1834 */     append(paramString);
/* 1835 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Element clone() {
/* 1840 */     return (Element)super.clone();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Element shallowClone() {
/*      */     String str;
/* 1847 */     if ((str = baseUri()).isEmpty()) str = null; 
/* 1848 */     return new Element(this.tag, str, (this.attributes == null) ? null : this.attributes.clone());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected Element doClone(Node paramNode) {
/* 1854 */     ((Element)(paramNode = super.doClone(paramNode))).attributes = (this.attributes != null) ? this.attributes.clone() : null;
/* 1855 */     ((Element)paramNode).childNodes = (List<Node>)new NodeList((Element)paramNode, this.childNodes.size());
/* 1856 */     ((Element)paramNode).childNodes.addAll(this.childNodes);
/*      */     
/* 1858 */     return (Element)paramNode;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Element clearAttributes() {
/* 1864 */     if (this.attributes != null) {
/* 1865 */       super.clearAttributes();
/* 1866 */       if (this.attributes.size() == 0) {
/* 1867 */         this.attributes = null;
/*      */       }
/*      */     } 
/* 1870 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Element removeAttr(String paramString) {
/* 1875 */     return (Element)super.removeAttr(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public Element root() {
/* 1880 */     return (Element)super.root();
/*      */   }
/*      */ 
/*      */   
/*      */   public Element traverse(NodeVisitor paramNodeVisitor) {
/* 1885 */     return (Element)super.traverse(paramNodeVisitor);
/*      */   }
/*      */ 
/*      */   
/*      */   public Element forEachNode(Consumer<? super Node> paramConsumer) {
/* 1890 */     return (Element)super.forEachNode(paramConsumer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public Element forEach(Consumer<? super Element> paramConsumer) {
/* 1904 */     stream().forEach(paramConsumer);
/* 1905 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public Element filter(NodeFilter paramNodeFilter) {
/* 1910 */     return (Element)super.filter(paramNodeFilter);
/*      */   }
/*      */   
/*      */   private static final class NodeList extends ChangeNotifyingArrayList<Node> {
/*      */     private final Element owner;
/*      */     
/*      */     NodeList(Element param1Element, int param1Int) {
/* 1917 */       super(param1Int);
/* 1918 */       this.owner = param1Element;
/*      */     }
/*      */     
/*      */     public final void onContentsChanged() {
/* 1922 */       this.owner.nodelistChanged();
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isFormatAsBlock(Document.OutputSettings paramOutputSettings) {
/* 1927 */     return (this.tag.isBlock() || (parent() != null && parent().tag().formatAsBlock()) || paramOutputSettings.outline());
/*      */   }
/*      */   
/*      */   private boolean isInlineable(Document.OutputSettings paramOutputSettings) {
/* 1931 */     if (!this.tag.isInline())
/* 1932 */       return false; 
/* 1933 */     if ((parent() == null || parent().isBlock()) && 
/* 1934 */       !isEffectivelyFirst() && 
/* 1935 */       !paramOutputSettings.outline() && 
/* 1936 */       !nameIs("br")) return true; 
/*      */     return false;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\nodes\Element.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */