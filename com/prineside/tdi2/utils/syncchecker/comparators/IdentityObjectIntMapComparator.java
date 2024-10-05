/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.esotericsoftware.kryo.util.IdentityObjectIntMap;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ 
/*    */ public final class IdentityObjectIntMapComparator extends DeepClassComparator<IdentityObjectIntMap> {
/*    */   public final Class<IdentityObjectIntMap> forClass() {
/*  9 */     return IdentityObjectIntMap.class;
/*    */   }
/*    */   
/*    */   public final void compare(IdentityObjectIntMap paramIdentityObjectIntMap1, IdentityObjectIntMap paramIdentityObjectIntMap2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 13 */     if (paramIdentityObjectIntMap1.size != paramIdentityObjectIntMap2.size)
/* 14 */       paramDeepClassComparisonConfig.appendPrefix().append(": sizes do not match").append(paramIdentityObjectIntMap1.size).append(" != ").append(paramIdentityObjectIntMap2.size).append("\n"); 
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\IdentityObjectIntMapComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */