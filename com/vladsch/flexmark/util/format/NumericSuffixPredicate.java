/*   */ package com.vladsch.flexmark.util.format;
/*   */ 
/*   */ import java.util.function.Predicate;
/*   */ 
/*   */ public interface NumericSuffixPredicate
/*   */   extends Predicate<String>
/*   */ {
/*   */   default boolean sortSuffix(String paramString) {
/* 9 */     return true;
/*   */   }
/*   */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\format\NumericSuffixPredicate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */