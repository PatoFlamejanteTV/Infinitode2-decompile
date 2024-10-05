/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectSet;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class ObjectSetComparator extends DeepClassComparator<ObjectSet> {
/*    */   public final Class<ObjectSet> forClass() {
/*  9 */     return ObjectSet.class;
/*    */   }
/*    */   
/*    */   public final void compare(ObjectSet paramObjectSet1, ObjectSet paramObjectSet2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramObjectSet1.size != paramObjectSet2.size) {
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramObjectSet1.size).append(" != ").append(paramObjectSet2.size).append("\n");
/*    */     }
/*    */     
/* 17 */     ObjectSet.ObjectSetIterator objectSetIterator = paramObjectSet1.iterator();
/* 18 */     while (objectSetIterator.hasNext) {
/*    */       Object object;
/* 20 */       if ((object = objectSetIterator.next()).getClass().isEnum())
/*    */       {
/* 22 */         if (!paramObjectSet2.contains(object))
/* 23 */           paramDeepClassComparisonConfig.appendPrefix().append("[").append(object).append("]: key not exists\n"); 
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\ObjectSetComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */