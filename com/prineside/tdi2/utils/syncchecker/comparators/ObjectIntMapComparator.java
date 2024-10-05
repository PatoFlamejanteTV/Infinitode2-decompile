/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectIntMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class ObjectIntMapComparator extends DeepClassComparator<ObjectIntMap> {
/*    */   public final Class<ObjectIntMap> forClass() {
/*  9 */     return ObjectIntMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(ObjectIntMap paramObjectIntMap1, ObjectIntMap paramObjectIntMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramObjectIntMap1.size != paramObjectIntMap2.size)
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramObjectIntMap1.size).append(" != ").append(paramObjectIntMap2.size).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\ObjectIntMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */