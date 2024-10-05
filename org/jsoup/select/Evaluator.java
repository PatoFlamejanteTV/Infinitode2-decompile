/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.internal.Normalizer;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.PseudoTextElement;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.parser.ParseSettings;
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
/*     */ public abstract class Evaluator
/*     */ {
/*     */   public Predicate<Element> asPredicate(Element paramElement) {
/*  38 */     return paramElement2 -> matches(paramElement1, paramElement2);
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
/*     */   protected void reset() {}
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
/*     */   protected int cost() {
/*  62 */     return 5;
/*     */   }
/*     */   
/*     */   public abstract boolean matches(Element paramElement1, Element paramElement2);
/*     */   
/*     */   public static final class Tag
/*     */     extends Evaluator {
/*     */     private final String tagName;
/*     */     
/*     */     public Tag(String param1String) {
/*  72 */       this.tagName = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*  77 */       return param1Element2.nameIs(this.tagName);
/*     */     }
/*     */     
/*     */     protected final int cost() {
/*  81 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/*  86 */       return String.format("%s", new Object[] { this.tagName });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class TagEndsWith
/*     */     extends Evaluator
/*     */   {
/*     */     private final String tagName;
/*     */ 
/*     */     
/*     */     public TagEndsWith(String param1String) {
/*  98 */       this.tagName = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 103 */       return param1Element2.normalName().endsWith(this.tagName);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 108 */       return String.format("%s", new Object[] { this.tagName });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Id
/*     */     extends Evaluator
/*     */   {
/*     */     private final String id;
/*     */     
/*     */     public Id(String param1String) {
/* 119 */       this.id = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 124 */       return this.id.equals(param1Element2.id());
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 128 */       return 2;
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 132 */       return String.format("#%s", new Object[] { this.id });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Class
/*     */     extends Evaluator
/*     */   {
/*     */     private final String className;
/*     */     
/*     */     public Class(String param1String) {
/* 143 */       this.className = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 148 */       return param1Element2.hasClass(this.className);
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 152 */       return 6;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 157 */       return String.format(".%s", new Object[] { this.className });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Attribute
/*     */     extends Evaluator
/*     */   {
/*     */     private final String key;
/*     */ 
/*     */     
/*     */     public Attribute(String param1String) {
/* 169 */       this.key = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 174 */       return param1Element2.hasAttr(this.key);
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 178 */       return 2;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 183 */       return String.format("[%s]", new Object[] { this.key });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class AttributeStarting
/*     */     extends Evaluator
/*     */   {
/*     */     private final String keyPrefix;
/*     */     
/*     */     public AttributeStarting(String param1String) {
/* 194 */       Validate.notNull(param1String);
/* 195 */       this.keyPrefix = Normalizer.lowerCase(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*     */       List<?> list;
/* 201 */       for (Iterator<?> iterator = (list = param1Element2.attributes().asList()).iterator(); iterator.hasNext();) {
/* 202 */         if (Normalizer.lowerCase((attribute = (org.jsoup.nodes.Attribute)iterator.next()).getKey()).startsWith(this.keyPrefix))
/* 203 */           return true; 
/*     */       } 
/* 205 */       return false;
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 209 */       return 6;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 214 */       return String.format("[^%s]", new Object[] { this.keyPrefix });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValue
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValue(String param1String1, String param1String2) {
/* 224 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 229 */       return (param1Element2.hasAttr(this.key) && this.value.equalsIgnoreCase(param1Element2.attr(this.key).trim()));
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 233 */       return 3;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 238 */       return String.format("[%s=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueNot
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueNot(String param1String1, String param1String2) {
/* 248 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 253 */       return !this.value.equalsIgnoreCase(param1Element2.attr(this.key));
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 257 */       return 3;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 262 */       return String.format("[%s!=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueStarting
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueStarting(String param1String1, String param1String2) {
/* 272 */       super(param1String1, param1String2, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 277 */       return (param1Element2.hasAttr(this.key) && Normalizer.lowerCase(param1Element2.attr(this.key)).startsWith(this.value));
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 281 */       return 4;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 286 */       return String.format("[%s^=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueEnding
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueEnding(String param1String1, String param1String2) {
/* 295 */       super(param1String1, param1String2, false);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 300 */       return (param1Element2.hasAttr(this.key) && Normalizer.lowerCase(param1Element2.attr(this.key)).endsWith(this.value));
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 304 */       return 4;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 309 */       return String.format("[%s$=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueContaining
/*     */     extends AttributeKeyPair
/*     */   {
/*     */     public AttributeWithValueContaining(String param1String1, String param1String2) {
/* 318 */       super(param1String1, param1String2);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 323 */       return (param1Element2.hasAttr(this.key) && Normalizer.lowerCase(param1Element2.attr(this.key)).contains(this.value));
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 327 */       return 6;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 332 */       return String.format("[%s*=%s]", new Object[] { this.key, this.value });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class AttributeWithValueMatching
/*     */     extends Evaluator
/*     */   {
/*     */     final String key;
/*     */     
/*     */     final Pattern pattern;
/*     */     
/*     */     public AttributeWithValueMatching(String param1String, Pattern param1Pattern) {
/* 345 */       this.key = Normalizer.normalize(param1String);
/* 346 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 351 */       return (param1Element2.hasAttr(this.key) && this.pattern.matcher(param1Element2.attr(this.key)).find());
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 355 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 360 */       return String.format("[%s~=%s]", new Object[] { this.key, this.pattern.toString() });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class AttributeKeyPair
/*     */     extends Evaluator
/*     */   {
/*     */     final String key;
/*     */     
/*     */     final String value;
/*     */     
/*     */     public AttributeKeyPair(String param1String1, String param1String2) {
/* 373 */       this(param1String1, param1String2, true);
/*     */     }
/*     */     
/*     */     public AttributeKeyPair(String param1String1, String param1String2, boolean param1Boolean) {
/* 377 */       Validate.notEmpty(param1String1);
/* 378 */       Validate.notEmpty(param1String2);
/*     */       
/* 380 */       this.key = Normalizer.normalize(param1String1);
/*     */       
/*     */       boolean bool;
/* 383 */       if (bool = ((param1String2.startsWith("'") && param1String2.endsWith("'")) || (param1String2.startsWith("\"") && param1String2.endsWith("\""))) ? true : false) {
/* 384 */         param1String2 = param1String2.substring(1, param1String2.length() - 1);
/*     */       }
/*     */       
/* 387 */       this.value = param1Boolean ? Normalizer.normalize(param1String2) : Normalizer.normalize(param1String2, bool);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class AllElements
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 398 */       return true;
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 402 */       return 10;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 407 */       return "*";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class IndexLessThan
/*     */     extends IndexEvaluator
/*     */   {
/*     */     public IndexLessThan(int param1Int) {
/* 416 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 421 */       return (param1Element1 != param1Element2 && param1Element2.elementSiblingIndex() < this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 426 */       return String.format(":lt(%d)", new Object[] { Integer.valueOf(this.index) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IndexGreaterThan
/*     */     extends IndexEvaluator
/*     */   {
/*     */     public IndexGreaterThan(int param1Int) {
/* 436 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 441 */       return (param1Element2.elementSiblingIndex() > this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 446 */       return String.format(":gt(%d)", new Object[] { Integer.valueOf(this.index) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IndexEquals
/*     */     extends IndexEvaluator
/*     */   {
/*     */     public IndexEquals(int param1Int) {
/* 456 */       super(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 461 */       return (param1Element2.elementSiblingIndex() == this.index);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 466 */       return String.format(":eq(%d)", new Object[] { Integer.valueOf(this.index) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsLastChild
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 478 */       if ((param1Element1 = param1Element2.parent()) != null && !(param1Element1 instanceof org.jsoup.nodes.Document) && param1Element2 == param1Element1.lastElementChild()) return true;  return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 483 */       return ":last-child";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsFirstOfType extends IsNthOfType {
/*     */     public IsFirstOfType() {
/* 489 */       super(0, 1);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 493 */       return ":first-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsLastOfType extends IsNthLastOfType {
/*     */     public IsLastOfType() {
/* 499 */       super(0, 1);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 503 */       return ":last-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class CssNthEvaluator extends Evaluator {
/*     */     protected final int a;
/*     */     protected final int b;
/*     */     
/*     */     public CssNthEvaluator(int param1Int1, int param1Int2) {
/* 512 */       this.a = param1Int1;
/* 513 */       this.b = param1Int2;
/*     */     }
/*     */     public CssNthEvaluator(int param1Int) {
/* 516 */       this(0, param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*     */       Element element;
/* 522 */       if ((element = param1Element2.parent()) == null || element instanceof org.jsoup.nodes.Document) return false;
/*     */       
/* 524 */       int i = calculatePosition(param1Element1, param1Element2);
/* 525 */       if (this.a == 0) return (i == this.b);
/*     */       
/* 527 */       return ((i - this.b) * this.a >= 0 && (i - this.b) % this.a == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 532 */       if (this.a == 0)
/* 533 */         return String.format(":%s(%d)", new Object[] { getPseudoClass(), Integer.valueOf(this.b) }); 
/* 534 */       if (this.b == 0)
/* 535 */         return String.format(":%s(%dn)", new Object[] { getPseudoClass(), Integer.valueOf(this.a) }); 
/* 536 */       return String.format(":%s(%dn%+d)", new Object[] { getPseudoClass(), Integer.valueOf(this.a), Integer.valueOf(this.b) });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract String getPseudoClass();
/*     */ 
/*     */     
/*     */     protected abstract int calculatePosition(Element param1Element1, Element param1Element2);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class IsNthChild
/*     */     extends CssNthEvaluator
/*     */   {
/*     */     public IsNthChild(int param1Int1, int param1Int2) {
/* 552 */       super(param1Int1, param1Int2);
/*     */     }
/*     */     
/*     */     protected final int calculatePosition(Element param1Element1, Element param1Element2) {
/* 556 */       return param1Element2.elementSiblingIndex() + 1;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final String getPseudoClass() {
/* 561 */       return "nth-child";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsNthLastChild
/*     */     extends CssNthEvaluator
/*     */   {
/*     */     public IsNthLastChild(int param1Int1, int param1Int2) {
/* 572 */       super(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final int calculatePosition(Element param1Element1, Element param1Element2) {
/* 577 */       if (param1Element2.parent() == null)
/* 578 */         return 0; 
/* 579 */       return param1Element2.parent().childrenSize() - param1Element2.elementSiblingIndex();
/*     */     }
/*     */ 
/*     */     
/*     */     protected final String getPseudoClass() {
/* 584 */       return "nth-last-child";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IsNthOfType
/*     */     extends CssNthEvaluator
/*     */   {
/*     */     public IsNthOfType(int param1Int1, int param1Int2) {
/* 594 */       super(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected int calculatePosition(Element param1Element1, Element param1Element2) {
/* 599 */       if ((param1Element1 = param1Element2.parent()) == null) {
/* 600 */         return 0;
/*     */       }
/* 602 */       byte b1 = 0;
/* 603 */       int i = param1Element1.childNodeSize();
/* 604 */       for (byte b2 = 0; b2 < i; ) {
/*     */         Node node;
/* 606 */         if ((node = param1Element1.childNode(b2)).normalName().equals(param1Element2.normalName())) b1++; 
/* 607 */         if (node != param1Element2)
/*     */           b2++; 
/* 609 */       }  return b1;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getPseudoClass() {
/* 614 */       return "nth-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static class IsNthLastOfType
/*     */     extends CssNthEvaluator {
/*     */     public IsNthLastOfType(int param1Int1, int param1Int2) {
/* 621 */       super(param1Int1, param1Int2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected int calculatePosition(Element param1Element1, Element param1Element2) {
/* 627 */       if ((param1Element1 = param1Element2.parent()) == null) {
/* 628 */         return 0;
/*     */       }
/* 630 */       byte b = 0;
/* 631 */       Element element = param1Element2;
/* 632 */       while (element != null) {
/* 633 */         if (element.normalName().equals(param1Element2.normalName()))
/* 634 */           b++; 
/* 635 */         element = element.nextElementSibling();
/*     */       } 
/* 637 */       return b;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getPseudoClass() {
/* 642 */       return "nth-last-of-type";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsFirstChild
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 653 */       if ((param1Element1 = param1Element2.parent()) != null && !(param1Element1 instanceof org.jsoup.nodes.Document) && param1Element2 == param1Element1.firstElementChild()) return true;  return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 658 */       return ":first-child";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class IsRoot
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 670 */       param1Element1 = (param1Element1 instanceof org.jsoup.nodes.Document) ? param1Element1.firstElementChild() : param1Element1;
/* 671 */       return (param1Element2 == param1Element1);
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 675 */       return 1;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 680 */       return ":root";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsOnlyChild
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 688 */       if ((param1Element1 = param1Element2.parent()) != null && !(param1Element1 instanceof org.jsoup.nodes.Document) && param1Element2.siblingElements().isEmpty()) return true;  return false;
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 692 */       return ":only-child";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsOnlyOfType
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 700 */       if ((param1Element1 = param1Element2.parent()) == null || param1Element1 instanceof org.jsoup.nodes.Document) return false;
/*     */       
/* 702 */       byte b = 0;
/* 703 */       param1Element1 = param1Element1.firstElementChild();
/* 704 */       while (param1Element1 != null) {
/* 705 */         if (param1Element1.normalName().equals(param1Element2.normalName()))
/* 706 */           b++; 
/* 707 */         if (b <= 1)
/*     */         {
/* 709 */           param1Element1 = param1Element1.nextElementSibling(); } 
/*     */       } 
/* 711 */       return (b == 1);
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 715 */       return ":only-of-type";
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class IsEmpty
/*     */     extends Evaluator {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*     */       List<?> list;
/* 723 */       for (Iterator<?> iterator = (list = param1Element2.childNodes()).iterator(); iterator.hasNext(); ) {
/* 724 */         Node node; if (node = (Node)iterator.next() instanceof TextNode)
/* 725 */           return ((TextNode)node).isBlank(); 
/* 726 */         if (!(node instanceof org.jsoup.nodes.Comment) && !(node instanceof org.jsoup.nodes.XmlDeclaration) && !(node instanceof org.jsoup.nodes.DocumentType))
/* 727 */           return false; 
/*     */       } 
/* 729 */       return true;
/*     */     }
/*     */     
/*     */     public final String toString() {
/* 733 */       return ":empty";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class IndexEvaluator
/*     */     extends Evaluator
/*     */   {
/*     */     final int index;
/*     */ 
/*     */     
/*     */     public IndexEvaluator(int param1Int) {
/* 746 */       this.index = param1Int;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ContainsText
/*     */     extends Evaluator
/*     */   {
/*     */     private final String searchText;
/*     */     
/*     */     public ContainsText(String param1String) {
/* 757 */       this.searchText = Normalizer.lowerCase(StringUtil.normaliseWhitespace(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 762 */       return Normalizer.lowerCase(param1Element2.text()).contains(this.searchText);
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 766 */       return 10;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 771 */       return String.format(":contains(%s)", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class ContainsWholeText
/*     */     extends Evaluator
/*     */   {
/*     */     private final String searchText;
/*     */ 
/*     */     
/*     */     public ContainsWholeText(String param1String) {
/* 784 */       this.searchText = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 789 */       return param1Element2.wholeText().contains(this.searchText);
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 793 */       return 10;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 798 */       return String.format(":containsWholeText(%s)", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class ContainsWholeOwnText
/*     */     extends Evaluator
/*     */   {
/*     */     private final String searchText;
/*     */ 
/*     */     
/*     */     public ContainsWholeOwnText(String param1String) {
/* 811 */       this.searchText = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 816 */       return param1Element2.wholeOwnText().contains(this.searchText);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 821 */       return String.format(":containsWholeOwnText(%s)", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ContainsData
/*     */     extends Evaluator
/*     */   {
/*     */     private final String searchText;
/*     */     
/*     */     public ContainsData(String param1String) {
/* 832 */       this.searchText = Normalizer.lowerCase(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 837 */       return Normalizer.lowerCase(param1Element2.data()).contains(this.searchText);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 842 */       return String.format(":containsData(%s)", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class ContainsOwnText
/*     */     extends Evaluator
/*     */   {
/*     */     private final String searchText;
/*     */     
/*     */     public ContainsOwnText(String param1String) {
/* 853 */       this.searchText = Normalizer.lowerCase(StringUtil.normaliseWhitespace(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 858 */       return Normalizer.lowerCase(param1Element2.ownText()).contains(this.searchText);
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 863 */       return String.format(":containsOwn(%s)", new Object[] { this.searchText });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Matches
/*     */     extends Evaluator
/*     */   {
/*     */     private final Pattern pattern;
/*     */     
/*     */     public Matches(Pattern param1Pattern) {
/* 874 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*     */       Matcher matcher;
/* 880 */       return (matcher = this.pattern.matcher(param1Element2.text())).find();
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 884 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 889 */       return String.format(":matches(%s)", new Object[] { this.pattern });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class MatchesOwn
/*     */     extends Evaluator
/*     */   {
/*     */     private final Pattern pattern;
/*     */     
/*     */     public MatchesOwn(Pattern param1Pattern) {
/* 900 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*     */       Matcher matcher;
/* 906 */       return (matcher = this.pattern.matcher(param1Element2.ownText())).find();
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 910 */       return 7;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 915 */       return String.format(":matchesOwn(%s)", new Object[] { this.pattern });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class MatchesWholeText
/*     */     extends Evaluator
/*     */   {
/*     */     private final Pattern pattern;
/*     */ 
/*     */     
/*     */     public MatchesWholeText(Pattern param1Pattern) {
/* 927 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*     */       Matcher matcher;
/* 933 */       return (matcher = this.pattern.matcher(param1Element2.wholeText())).find();
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 937 */       return 8;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 942 */       return String.format(":matchesWholeText(%s)", new Object[] { this.pattern });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class MatchesWholeOwnText
/*     */     extends Evaluator
/*     */   {
/*     */     private final Pattern pattern;
/*     */ 
/*     */     
/*     */     public MatchesWholeOwnText(Pattern param1Pattern) {
/* 954 */       this.pattern = param1Pattern;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*     */       Matcher matcher;
/* 960 */       return (matcher = this.pattern.matcher(param1Element2.wholeOwnText())).find();
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 964 */       return 7;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 969 */       return String.format(":matchesWholeOwnText(%s)", new Object[] { this.pattern });
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class MatchText
/*     */     extends Evaluator
/*     */   {
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 977 */       if (param1Element2 instanceof PseudoTextElement) {
/* 978 */         return true;
/*     */       }
/*     */       List<?> list;
/* 981 */       for (TextNode textNode : list = param1Element2.textNodes()) {
/*     */         
/* 983 */         PseudoTextElement pseudoTextElement = new PseudoTextElement(org.jsoup.parser.Tag.valueOf(param1Element2.tagName(), param1Element2.tag().namespace(), ParseSettings.preserveCase), param1Element2.baseUri(), param1Element2.attributes());
/* 984 */         textNode.replaceWith((Node)pseudoTextElement);
/* 985 */         pseudoTextElement.appendChild((Node)textNode);
/*     */       } 
/* 987 */       return false;
/*     */     }
/*     */     
/*     */     protected final int cost() {
/* 991 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 996 */       return ":matchText";
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\Evaluator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */