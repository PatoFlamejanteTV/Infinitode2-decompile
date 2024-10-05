/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*    */ import java.util.BitSet;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SubClassingBag<T>
/*    */ {
/*    */   private final ClassificationBag<Class<?>, T> items;
/*    */   private final HashMap<Class<?>, BitSet> subClassMap;
/*    */   
/*    */   public SubClassingBag(ClassificationBag<Class<?>, T> paramClassificationBag, HashMap<Class<?>, List<Class<?>>> paramHashMap) {
/* 17 */     this.items = paramClassificationBag;
/* 18 */     this.subClassMap = new HashMap<>();
/*    */     
/* 20 */     for (Class<?> clazz : paramHashMap.keySet()) {
/* 21 */       List<? extends Class<?>> list = paramHashMap.get(clazz);
/*    */       BitSet bitSet;
/* 23 */       if (!(bitSet = this.items.categoriesBitSet(list)).isEmpty()) {
/* 24 */         this.subClassMap.put(clazz, bitSet);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public OrderedSet<T> getItems() {
/* 30 */     return this.items.getItems();
/*    */   }
/*    */   
/*    */   public boolean contains(T paramT) {
/* 34 */     return this.items.contains(paramT);
/*    */   }
/*    */   
/*    */   public boolean containsType(Class<?> paramClass) {
/* 38 */     return this.items.containsCategory(paramClass);
/*    */   }
/*    */   
/*    */   public BitSet getTypeSet(Class<?> paramClass) {
/* 42 */     return this.subClassMap.get(paramClass);
/*    */   }
/*    */   
/*    */   public int getTypeCount(Class<?> paramClass) {
/*    */     BitSet bitSet;
/* 47 */     return ((bitSet = this.subClassMap.get(paramClass)) == null) ? 0 : bitSet.cardinality();
/*    */   }
/*    */   
/*    */   public final <X> ReversibleIterable<X> itemsOfType(Class<X> paramClass, Class<?>... paramVarArgs) {
/* 51 */     return this.items.getCategoryItems(paramClass, typeBitSet(paramClass, paramVarArgs));
/*    */   }
/*    */   
/*    */   public final <X> ReversibleIterable<X> itemsOfType(Class<X> paramClass, Collection<Class<?>> paramCollection) {
/* 55 */     return this.items.getCategoryItems(paramClass, typeBitSet(paramClass, paramCollection));
/*    */   }
/*    */   
/*    */   public final <X> ReversibleIterable<X> reversedItemsOfType(Class<X> paramClass, Class<?>... paramVarArgs) {
/* 59 */     return this.items.getCategoryItemsReversed(paramClass, typeBitSet(paramClass, paramVarArgs));
/*    */   }
/*    */   
/*    */   public final <X> ReversibleIterable<X> reversedItemsOfType(Class<X> paramClass, Collection<Class<?>> paramCollection) {
/* 63 */     return this.items.getCategoryItemsReversed(paramClass, typeBitSet(paramClass, paramCollection));
/*    */   }
/*    */ 
/*    */   
/*    */   public final BitSet typeBitSet(Class<?> paramClass, Class<?>... paramVarArgs) {
/* 68 */     BitSet bitSet = new BitSet(); int i; byte b;
/* 69 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { Class<?> clazz = paramVarArgs[b];
/* 70 */       if (paramClass.isAssignableFrom(clazz) && this.subClassMap.containsKey(clazz))
/* 71 */         bitSet.or(this.subClassMap.get(clazz)); 
/*    */       b++; }
/*    */     
/* 74 */     return bitSet;
/*    */   }
/*    */ 
/*    */   
/*    */   public final BitSet typeBitSet(Class<?> paramClass, Collection<Class<?>> paramCollection) {
/* 79 */     BitSet bitSet = new BitSet();
/* 80 */     for (Class<?> clazz : paramCollection) {
/* 81 */       if (paramClass.isAssignableFrom(clazz) && this.subClassMap.containsKey(clazz)) {
/* 82 */         bitSet.or(this.subClassMap.get(clazz));
/*    */       }
/*    */     } 
/* 85 */     return bitSet;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\SubClassingBag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */