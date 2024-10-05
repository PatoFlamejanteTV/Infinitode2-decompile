/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.function.Supplier;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.NodeIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class StructuralEvaluator
/*     */   extends Evaluator
/*     */ {
/*     */   final Evaluator evaluator;
/*     */   final ThreadLocal<IdentityHashMap<Element, IdentityHashMap<Element, Boolean>>> threadMemo;
/*     */   
/*     */   public StructuralEvaluator(Evaluator paramEvaluator) {
/*  22 */     this
/*  23 */       .threadMemo = ThreadLocal.withInitial(IdentityHashMap::new);
/*     */     this.evaluator = paramEvaluator;
/*     */   }
/*     */   boolean memoMatches(Element paramElement1, Element paramElement2) {
/*     */     IdentityHashMap<?, IdentityHashMap> identityHashMap;
/*     */     IdentityHashMap<Object, Object> identityHashMap1;
/*  29 */     if ((identityHashMap1 = (identityHashMap = (IdentityHashMap)this.threadMemo.get()).get(paramElement1)) == null) {
/*  30 */       identityHashMap1 = new IdentityHashMap<>();
/*  31 */       identityHashMap.put(paramElement1, identityHashMap1);
/*     */     } 
/*     */     Boolean bool;
/*  34 */     if ((bool = (Boolean)identityHashMap1.get(paramElement2)) == null) {
/*  35 */       bool = Boolean.valueOf(this.evaluator.matches(paramElement1, paramElement2));
/*  36 */       identityHashMap1.put(paramElement2, bool);
/*     */     } 
/*  38 */     return bool.booleanValue();
/*     */   }
/*     */   
/*     */   protected void reset() {
/*  42 */     ((IdentityHashMap)this.threadMemo.get()).clear();
/*  43 */     super.reset();
/*     */   }
/*     */   
/*     */   static class Root
/*     */     extends Evaluator {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  49 */       return (param1Element1 == param1Element2);
/*     */     }
/*     */     
/*     */     protected int cost() {
/*  53 */       return 1;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  57 */       return "";
/*     */     }
/*     */   }
/*     */   
/*     */   static class Has
/*     */     extends StructuralEvaluator {
/*  63 */     static final ThreadLocal<NodeIterator<Element>> ThreadElementIter = ThreadLocal.withInitial(() -> new NodeIterator((Node)new Element("html"), Element.class));
/*     */ 
/*     */     
/*     */     public Has(Evaluator param1Evaluator) {
/*  67 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*     */       NodeIterator nodeIterator;
/*  74 */       (nodeIterator = ThreadElementIter.get()).restart((Node)param1Element2);
/*  75 */       while (nodeIterator.hasNext()) {
/*     */         Element element;
/*  77 */         if ((element = (Element)nodeIterator.next()) != param1Element2 && 
/*  78 */           this.evaluator.matches(param1Element2, element))
/*  79 */           return true; 
/*     */       } 
/*  81 */       return false;
/*     */     }
/*     */     
/*     */     protected int cost() {
/*  85 */       return 10 * this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  90 */       return String.format(":has(%s)", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class Is
/*     */     extends StructuralEvaluator {
/*     */     public Is(Evaluator param1Evaluator) {
/*  97 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 102 */       return this.evaluator.matches(param1Element1, param1Element2);
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 106 */       return 2 + this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 111 */       return String.format(":is(%s)", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class Not extends StructuralEvaluator {
/*     */     public Not(Evaluator param1Evaluator) {
/* 117 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 122 */       return !memoMatches(param1Element1, param1Element2);
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 126 */       return 2 + this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 131 */       return String.format(":not(%s)", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class Parent extends StructuralEvaluator {
/*     */     public Parent(Evaluator param1Evaluator) {
/* 137 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 142 */       if (param1Element1 == param1Element2) {
/* 143 */         return false;
/*     */       }
/* 145 */       param1Element2 = param1Element2.parent();
/* 146 */       while (param1Element2 != null) {
/* 147 */         if (memoMatches(param1Element1, param1Element2))
/* 148 */           return true; 
/* 149 */         if (param1Element2 != param1Element1)
/*     */         {
/* 151 */           param1Element2 = param1Element2.parent(); } 
/*     */       } 
/* 153 */       return false;
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 157 */       return 2 * this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 162 */       return String.format("%s ", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   static class ImmediateParent
/*     */     extends StructuralEvaluator
/*     */   {
/*     */     public ImmediateParent(Evaluator param1Evaluator) {
/* 172 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 177 */       if (param1Element1 == param1Element2) {
/* 178 */         return false;
/*     */       }
/*     */       
/* 181 */       if ((param1Element2 = param1Element2.parent()) != null && memoMatches(param1Element1, param1Element2)) return true;  return false;
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 185 */       return 1 + this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 190 */       return String.format("%s > ", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class ImmediateParentRun
/*     */     extends Evaluator
/*     */   {
/* 199 */     final ArrayList<Evaluator> evaluators = new ArrayList<>();
/* 200 */     int cost = 2;
/*     */     
/*     */     public ImmediateParentRun(Evaluator param1Evaluator) {
/* 203 */       this.evaluators.add(param1Evaluator);
/* 204 */       this.cost += param1Evaluator.cost();
/*     */     }
/*     */     
/*     */     void add(Evaluator param1Evaluator) {
/* 208 */       this.evaluators.add(param1Evaluator);
/* 209 */       this.cost += param1Evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 214 */       if (param1Element2 == param1Element1) {
/* 215 */         return false;
/*     */       }
/* 217 */       for (int i = this.evaluators.size() - 1; i >= 0; i--) {
/* 218 */         if (param1Element2 == null)
/* 219 */           return false; 
/*     */         Evaluator evaluator;
/* 221 */         if (!(evaluator = this.evaluators.get(i)).matches(param1Element1, param1Element2))
/* 222 */           return false; 
/* 223 */         param1Element2 = param1Element2.parent();
/*     */       } 
/* 225 */       return true;
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 229 */       return this.cost;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 234 */       return StringUtil.join(this.evaluators, " > ");
/*     */     }
/*     */   }
/*     */   
/*     */   static class PreviousSibling extends StructuralEvaluator {
/*     */     public PreviousSibling(Evaluator param1Evaluator) {
/* 240 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 245 */       if (param1Element1 == param1Element2) return false;
/*     */       
/* 247 */       Element element = param1Element2.firstElementSibling();
/* 248 */       while (element != null && 
/* 249 */         element != param1Element2) {
/* 250 */         if (memoMatches(param1Element1, element)) return true; 
/* 251 */         element = element.nextElementSibling();
/*     */       } 
/*     */       
/* 254 */       return false;
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 258 */       return 3 * this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 263 */       return String.format("%s ~ ", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class ImmediatePreviousSibling extends StructuralEvaluator {
/*     */     public ImmediatePreviousSibling(Evaluator param1Evaluator) {
/* 269 */       super(param1Evaluator);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 274 */       if (param1Element1 == param1Element2) {
/* 275 */         return false;
/*     */       }
/*     */       
/* 278 */       if ((param1Element2 = param1Element2.previousElementSibling()) != null && memoMatches(param1Element1, param1Element2)) return true;  return false;
/*     */     }
/*     */     
/*     */     protected int cost() {
/* 282 */       return 2 + this.evaluator.cost();
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 287 */       return String.format("%s + ", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\StructuralEvaluator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */