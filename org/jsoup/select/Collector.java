/*    */ package org.jsoup.select;
/*    */ 
/*    */ import java.util.Optional;
/*    */ import java.util.function.Supplier;
/*    */ import java.util.stream.Collectors;
/*    */ import org.jsoup.nodes.Element;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Collector
/*    */ {
/*    */   public static Elements collect(Evaluator paramEvaluator, Element paramElement) {
/* 25 */     paramEvaluator.reset();
/*    */     
/* 27 */     return (Elements)paramElement.stream()
/* 28 */       .filter(paramEvaluator.asPredicate(paramElement))
/* 29 */       .collect(Collectors.toCollection(Elements::new));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Element findFirst(Evaluator paramEvaluator, Element paramElement) {
/* 40 */     paramEvaluator.reset();
/*    */     
/*    */     Optional<Element> optional;
/* 43 */     return (optional = paramElement.stream().filter(paramEvaluator.asPredicate(paramElement)).findFirst()).orElse(null);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\Collector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */