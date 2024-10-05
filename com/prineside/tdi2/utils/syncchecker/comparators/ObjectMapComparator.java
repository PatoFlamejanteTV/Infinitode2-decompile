/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.ObjectMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class ObjectMapComparator extends DeepClassComparator<ObjectMap> {
/*    */   public final Class<ObjectMap> forClass() {
/*  9 */     return ObjectMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(ObjectMap paramObjectMap1, ObjectMap paramObjectMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramObjectMap1.size != paramObjectMap2.size)
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramObjectMap1.size).append(" != ").append(paramObjectMap2.size).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\ObjectMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */