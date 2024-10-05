/*    */ package com.vladsch.flexmark.util.dependency;
/*    */ 
/*    */ import com.vladsch.flexmark.util.collection.CollectionHost;
/*    */ import com.vladsch.flexmark.util.collection.OrderedMap;
/*    */ 
/*    */ public class DependentItemMap<D>
/*    */   extends OrderedMap<Class<?>, DependentItem<D>> {
/*    */   public DependentItemMap() {}
/*    */   
/*    */   public DependentItemMap(int paramInt) {
/* 11 */     super(paramInt);
/*    */   }
/*    */   
/*    */   public DependentItemMap(CollectionHost<Class<?>> paramCollectionHost) {
/* 15 */     super(paramCollectionHost);
/*    */   }
/*    */   
/*    */   public DependentItemMap(int paramInt, CollectionHost<Class<?>> paramCollectionHost) {
/* 19 */     super(paramInt, paramCollectionHost);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\DependentItemMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */