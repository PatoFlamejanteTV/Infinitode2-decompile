/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import org.jsoup.internal.StringUtil;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CombiningEvaluator
/*     */   extends Evaluator
/*     */ {
/*     */   final ArrayList<Evaluator> evaluators;
/*     */   final ArrayList<Evaluator> sortedEvaluators;
/*  19 */   int num = 0;
/*  20 */   int cost = 0;
/*     */   private static final Comparator<Evaluator> costComparator;
/*     */   
/*     */   CombiningEvaluator() {
/*  24 */     this.evaluators = new ArrayList<>();
/*  25 */     this.sortedEvaluators = new ArrayList<>();
/*     */   }
/*     */   
/*     */   CombiningEvaluator(Collection<Evaluator> paramCollection) {
/*  29 */     this();
/*  30 */     this.evaluators.addAll(paramCollection);
/*  31 */     updateEvaluators();
/*     */   }
/*     */   
/*     */   protected void reset() {
/*  35 */     for (Iterator<Evaluator> iterator = this.evaluators.iterator(); iterator.hasNext();) {
/*  36 */       (evaluator = iterator.next()).reset();
/*     */     }
/*  38 */     super.reset();
/*     */   }
/*     */   
/*     */   protected int cost() {
/*  42 */     return this.cost;
/*     */   }
/*     */   
/*     */   Evaluator rightMostEvaluator() {
/*  46 */     return (this.num > 0) ? this.evaluators.get(this.num - 1) : null;
/*     */   }
/*     */   
/*     */   void replaceRightMostEvaluator(Evaluator paramEvaluator) {
/*  50 */     this.evaluators.set(this.num - 1, paramEvaluator);
/*  51 */     updateEvaluators();
/*     */   }
/*     */ 
/*     */   
/*     */   void updateEvaluators() {
/*  56 */     this.num = this.evaluators.size();
/*     */ 
/*     */     
/*  59 */     this.cost = 0;
/*  60 */     for (Evaluator evaluator : this.evaluators) {
/*  61 */       this.cost += evaluator.cost();
/*     */     }
/*  63 */     this.sortedEvaluators.clear();
/*  64 */     this.sortedEvaluators.addAll(this.evaluators);
/*  65 */     Collections.sort(this.sortedEvaluators, costComparator);
/*     */   }
/*     */   static {
/*  68 */     costComparator = ((paramEvaluator1, paramEvaluator2) -> paramEvaluator1.cost() - paramEvaluator2.cost());
/*     */   }
/*     */   
/*     */   public static final class And extends CombiningEvaluator {
/*     */     And(Collection<Evaluator> param1Collection) {
/*  73 */       super(param1Collection);
/*     */     }
/*     */     
/*     */     And(Evaluator... param1VarArgs) {
/*  77 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/*  82 */       for (byte b = 0; b < this.num; b++) {
/*     */         Evaluator evaluator;
/*  84 */         if (!(evaluator = this.sortedEvaluators.get(b)).matches(param1Element1, param1Element2))
/*  85 */           return false; 
/*     */       } 
/*  87 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/*  92 */       return StringUtil.join(this.evaluators, "");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Or
/*     */     extends CombiningEvaluator
/*     */   {
/*     */     Or(Collection<Evaluator> param1Collection) {
/* 103 */       if (this.num > 1) {
/* 104 */         this.evaluators.add(new CombiningEvaluator.And(param1Collection));
/*     */       } else {
/* 106 */         this.evaluators.addAll(param1Collection);
/* 107 */       }  updateEvaluators();
/*     */     }
/*     */     Or(Evaluator... param1VarArgs) {
/* 110 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */     
/*     */     Or() {}
/*     */     
/*     */     public final void add(Evaluator param1Evaluator) {
/* 117 */       this.evaluators.add(param1Evaluator);
/* 118 */       updateEvaluators();
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean matches(Element param1Element1, Element param1Element2) {
/* 123 */       for (byte b = 0; b < this.num; b++) {
/*     */         Evaluator evaluator;
/* 125 */         if ((evaluator = this.sortedEvaluators.get(b)).matches(param1Element1, param1Element2))
/* 126 */           return true; 
/*     */       } 
/* 128 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 133 */       return StringUtil.join(this.evaluators, ", ");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\CombiningEvaluator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */