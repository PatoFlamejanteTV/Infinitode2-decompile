/*     */ package com.vladsch.flexmark.util.dependency;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
/*     */ import com.vladsch.flexmark.util.misc.Ref;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public abstract class DependencyHandler<D extends Dependent, S, R extends ResolvedDependencies<S>>
/*     */ {
/*     */   protected abstract S createStage(List<D> paramList);
/*     */   
/*     */   public R resolveDependencies(List<D> paramList) {
/*  20 */     if (paramList.size() == 0)
/*     */     {
/*  22 */       return createResolvedDependencies(Collections.EMPTY_LIST); } 
/*  23 */     if (paramList.size() == 1) {
/*     */       Dependent dependent;
/*  25 */       List<Dependent> list = Collections.singletonList(dependent = (Dependent)paramList.get(0));
/*  26 */       return createResolvedDependencies(Collections.singletonList(createStage((List)list)));
/*     */     } 
/*     */     
/*  29 */     int i = paramList.size();
/*  30 */     DependentItemMap<D> dependentItemMap = new DependentItemMap(i);
/*     */     
/*  32 */     for (Dependent dependent : paramList) {
/*  33 */       Class clazz = getDependentClass((D)dependent);
/*  34 */       if (dependentItemMap.containsKey(clazz)) {
/*  35 */         throw new IllegalStateException("Dependent class " + clazz + " is duplicated. Only one instance can be present in the list");
/*     */       }
/*  37 */       DependentItem<Dependent> dependentItem = new DependentItem<>(dependentItemMap.size(), dependent, getDependentClass((D)dependent), dependent.affectsGlobalScope());
/*  38 */       dependentItemMap.put(clazz, dependentItem);
/*     */     } 
/*     */     
/*  41 */     for (ReversibleIndexedIterator<Map.Entry> reversibleIndexedIterator = dependentItemMap.iterator(); reversibleIndexedIterator.hasNext(); ) {
/*     */       Map.Entry<?, DependentItem> entry;
/*     */       DependentItem dependentItem;
/*     */       Set<Class<?>> set2;
/*  45 */       if ((set2 = ((Dependent)(dependentItem = (entry = reversibleIndexedIterator.next()).getValue()).dependent).getAfterDependents()) != null && set2.size() > 0) {
/*  46 */         for (Class<?> clazz : set2) {
/*     */           DependentItem dependentItem1;
/*  48 */           if ((dependentItem1 = (DependentItem)dependentItemMap.get(clazz)) != null) {
/*  49 */             dependentItem.addDependency(dependentItem1);
/*  50 */             dependentItem1.addDependent(dependentItem);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*     */       Set<Class<?>> set1;
/*  56 */       if ((set1 = ((Dependent)dependentItem.dependent).getBeforeDependents()) != null && set1.size() > 0) {
/*  57 */         for (Class<?> clazz : set1) {
/*     */           DependentItem dependentItem1;
/*  59 */           if ((dependentItem1 = (DependentItem)dependentItemMap.get(clazz)) != null) {
/*  60 */             dependentItem1.addDependency(dependentItem);
/*  61 */             dependentItem.addDependent(dependentItem1);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  68 */     i = (dependentItemMap = prioritize(dependentItemMap)).size();
/*     */     
/*  70 */     BitSet bitSet1 = new BitSet(i);
/*  71 */     Ref ref = new Ref(bitSet1);
/*  72 */     ReversibleIndexedIterator reversibleIndexedIterator1 = dependentItemMap.valueIterator();
/*  73 */     while (reversibleIndexedIterator1.hasNext()) {
/*     */       DependentItem<?> dependentItem;
/*  75 */       if (!(dependentItem = (DependentItem)reversibleIndexedIterator1.next()).hasDependencies()) {
/*  76 */         ((BitSet)ref.value).set(dependentItem.index);
/*     */       }
/*     */     } 
/*     */     
/*     */     BitSet bitSet2;
/*  81 */     (bitSet2 = new BitSet(i)).set(0, dependentItemMap.size());
/*     */     
/*  83 */     ArrayList<S> arrayList = new ArrayList();
/*     */     
/*  85 */     while (bitSet1.nextSetBit(0) != -1) {
/*     */       
/*  87 */       ArrayList<D> arrayList1 = new ArrayList();
/*  88 */       BitSet bitSet = new BitSet();
/*     */ 
/*     */       
/*     */       int j;
/*     */       
/*  93 */       while ((j = bitSet1.nextSetBit(0)) >= 0) {
/*     */         
/*  95 */         bitSet1.clear(j);
/*  96 */         DependentItem dependentItem = (DependentItem)dependentItemMap.getValue(j);
/*  97 */         assert dependentItem != null;
/*     */         
/*  99 */         arrayList1.add(dependentItem.dependent);
/* 100 */         bitSet2.clear(j);
/*     */ 
/*     */         
/* 103 */         if (dependentItem.hasDependents()) {
/*     */ 
/*     */           
/* 106 */           while ((j = dependentItem.dependents.nextSetBit(0)) >= 0) {
/*     */             
/* 108 */             dependentItem.dependents.clear(j);
/* 109 */             DependentItem dependentItem1 = (DependentItem)dependentItemMap.getValue(j);
/* 110 */             assert dependentItem1 != null;
/*     */             
/* 112 */             if (!dependentItem1.removeDependency(dependentItem)) {
/* 113 */               if (dependentItem.isGlobalScope) {
/* 114 */                 bitSet.set(j); continue;
/*     */               } 
/* 116 */               bitSet1.set(j);
/*     */             } 
/*     */           }  continue;
/*     */         } 
/* 120 */         if (dependentItem.isGlobalScope) {
/*     */           
/* 122 */           bitSet.or(bitSet1);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 128 */       bitSet1 = bitSet;
/* 129 */       arrayList.add(createStage(arrayList1));
/*     */     } 
/*     */     
/* 132 */     if (bitSet2.nextSetBit(0) != -1) {
/* 133 */       throw new IllegalStateException("have dependents with dependency cycles" + bitSet2);
/*     */     }
/*     */     
/* 136 */     return createResolvedDependencies(arrayList);
/*     */   }
/*     */   protected abstract Class getDependentClass(D paramD);
/*     */   protected abstract R createResolvedDependencies(List<S> paramList);
/*     */   protected DependentItemMap<D> prioritize(DependentItemMap<D> paramDependentItemMap) {
/* 141 */     return paramDependentItemMap;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\DependencyHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */