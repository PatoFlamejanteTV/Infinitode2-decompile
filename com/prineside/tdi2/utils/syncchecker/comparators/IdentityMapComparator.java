/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.badlogic.gdx.utils.IdentityMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class IdentityMapComparator extends DeepClassComparator<IdentityMap> {
/*    */   public final Class<IdentityMap> forClass() {
/*  9 */     return IdentityMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(IdentityMap paramIdentityMap1, IdentityMap paramIdentityMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramIdentityMap1.size != paramIdentityMap2.size)
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramIdentityMap1.size).append(" != ").append(paramIdentityMap2.size).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\IdentityMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */