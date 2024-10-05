/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.IdentityHashMap;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Element;
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
/*     */ public class Selector
/*     */ {
/*     */   public static Elements select(String paramString, Element paramElement) {
/* 100 */     Validate.notEmpty(paramString);
/* 101 */     return select(QueryParser.parse(paramString), paramElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Elements select(Evaluator paramEvaluator, Element paramElement) {
/* 112 */     Validate.notNull(paramEvaluator);
/* 113 */     Validate.notNull(paramElement);
/* 114 */     return Collector.collect(paramEvaluator, paramElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Elements select(String paramString, Iterable<Element> paramIterable) {
/* 125 */     Validate.notEmpty(paramString);
/* 126 */     Validate.notNull(paramIterable);
/* 127 */     Evaluator evaluator = QueryParser.parse(paramString);
/* 128 */     Elements elements = new Elements();
/* 129 */     IdentityHashMap<Object, Object> identityHashMap = new IdentityHashMap<>();
/*     */ 
/*     */     
/* 132 */     for (Element element : paramIterable) {
/*     */       Elements elements1;
/* 134 */       for (Element element1 : elements1 = select(evaluator, element)) {
/* 135 */         if (identityHashMap.put(element1, Boolean.TRUE) == null) {
/* 136 */           elements.add(element1);
/*     */         }
/*     */       } 
/*     */     } 
/* 140 */     return elements;
/*     */   }
/*     */ 
/*     */   
/*     */   static Elements filterOut(Collection<Element> paramCollection1, Collection<Element> paramCollection2) {
/* 145 */     Elements elements = new Elements();
/* 146 */     for (Element element : paramCollection1) {
/* 147 */       boolean bool = false;
/* 148 */       for (Element element1 : paramCollection2) {
/* 149 */         if (element.equals(element1)) {
/* 150 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 154 */       if (!bool)
/* 155 */         elements.add(element); 
/*     */     } 
/* 157 */     return elements;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Element selectFirst(String paramString, Element paramElement) {
/* 167 */     Validate.notEmpty(paramString);
/* 168 */     return Collector.findFirst(QueryParser.parse(paramString), paramElement);
/*     */   }
/*     */   
/*     */   public static class SelectorParseException extends IllegalStateException {
/*     */     public SelectorParseException(String param1String) {
/* 173 */       super(param1String);
/*     */     }
/*     */     
/*     */     public SelectorParseException(String param1String, Object... param1VarArgs) {
/* 177 */       super(String.format(param1String, param1VarArgs));
/*     */     }
/*     */     
/*     */     public SelectorParseException(Throwable param1Throwable, String param1String, Object... param1VarArgs) {
/* 181 */       super(String.format(param1String, param1VarArgs), param1Throwable);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\jsoup\select\Selector.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */