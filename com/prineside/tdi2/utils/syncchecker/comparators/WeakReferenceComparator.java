/*    */ package com.prineside.tdi2.utils.syncchecker.comparators;
/*    */ 
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparator;
/*    */ import com.prineside.tdi2.utils.syncchecker.DeepClassComparisonConfig;
/*    */ import com.prineside.tdi2.utils.syncchecker.SyncChecker;
/*    */ import java.lang.ref.WeakReference;
/*    */ 
/*    */ 
/*    */ public final class WeakReferenceComparator
/*    */   extends DeepClassComparator<WeakReference>
/*    */ {
/*    */   public final Class<WeakReference> forClass() {
/* 13 */     return WeakReference.class;
/*    */   }
/*    */ 
/*    */   
/*    */   public final void compare(WeakReference paramWeakReference1, WeakReference paramWeakReference2, DeepClassComparisonConfig paramDeepClassComparisonConfig) {
/* 18 */     paramDeepClassComparisonConfig.addPrefix(new String[] { ".get()" });
/* 19 */     SyncChecker.compareObjects(paramWeakReference1.get(), paramWeakReference2.get(), paramDeepClassComparisonConfig);
/* 20 */     paramDeepClassComparisonConfig.popPrefix(1);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\tdi\\utils\syncchecker\comparators\WeakReferenceComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */