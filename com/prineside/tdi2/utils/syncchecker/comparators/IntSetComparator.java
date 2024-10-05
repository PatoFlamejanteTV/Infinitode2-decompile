/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IntSet;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class IntSetComparator extends DeepClassComparator<IntSet> {
/*    */   public final Class<IntSet> forClass() {
/*  9 */     return IntSet.class;
/*    */   }
/*    */   
/*    */   public final void compare(IntSet paramIntSet1, IntSet paramIntSet2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramIntSet1.size != paramIntSet2.size) {
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramIntSet1.size).append(" != ").append(paramIntSet2.size).append("\n");
/*    */     }
/*    */     
/* 17 */     IntSet.IntSetIterator intSetIterator = paramIntSet1.iterator();
/* 18 */     while (intSetIterator.hasNext) {
/* 19 */       int i = intSetIterator.next();
/* 20 */       if (!paramIntSet2.contains(i))
/* 21 */         paramDeepClassComparisonConfig.appendPrefix().append("[").append(i).append("]: key not exists\n"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\IntSetComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */