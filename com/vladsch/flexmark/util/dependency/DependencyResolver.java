/*     */ package com.vladsch.flexmark.util.dependency;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ public class DependencyResolver {
/*     */   public static <D extends Dependent> List<D> resolveFlatDependencies(List<D> paramList, Function<DependentItemMap<D>, DependentItemMap<D>> paramFunction, Function<? super D, Class<?>> paramFunction1) {
/*  14 */     if ((paramList = resolveDependencies(paramList, paramFunction, paramFunction1)).isEmpty())
/*  15 */       return Collections.emptyList(); 
/*  16 */     if (paramList.size() == 1) {
/*  17 */       return (List<D>)paramList.get(0);
/*     */     }
/*  19 */     int i = 0;
/*  20 */     for (List list : paramList) {
/*  21 */       i += list.size();
/*     */     }
/*     */     
/*  24 */     ArrayList<D> arrayList = new ArrayList(i);
/*  25 */     for (List<D> paramList : paramList) {
/*  26 */       arrayList.addAll(paramList);
/*     */     }
/*  28 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public static <D extends Dependent> List<List<D>> resolveDependencies(List<D> paramList, Function<DependentItemMap<D>, DependentItemMap<D>> paramFunction, Function<? super D, Class<?>> paramFunction1) {
/*  33 */     if (paramList.size() == 0)
/*  34 */       return Collections.emptyList(); 
/*  35 */     if (paramList.size() == 1) {
/*  36 */       return Collections.singletonList(paramList);
/*     */     }
/*     */     
/*  39 */     int i = paramList.size();
/*  40 */     DependentItemMap<D> dependentItemMap = new DependentItemMap(i);
/*  41 */     if (paramFunction1 == null) paramFunction1 = Object::getClass;
/*     */     
/*  43 */     for (Dependent dependent : paramList) {
/*  44 */       Class clazz = paramFunction1.apply((D)dependent);
/*  45 */       if (dependentItemMap.containsKey(clazz)) {
/*  46 */         throw new IllegalStateException("Dependent class " + clazz + " is duplicated. Only one instance can be present in the list");
/*     */       }
/*  48 */       DependentItem<Dependent> dependentItem = new DependentItem<>(dependentItemMap.size(), dependent, paramFunction1.apply((D)dependent), dependent.affectsGlobalScope());
/*  49 */       dependentItemMap.put(clazz, dependentItem);
/*     */     } 
/*     */     
/*  52 */     for (ReversibleIndexedIterator<Map.Entry> reversibleIndexedIterator = dependentItemMap.iterator(); reversibleIndexedIterator.hasNext(); ) {
/*     */       Map.Entry<?, DependentItem> entry;
/*     */       DependentItem dependentItem;
/*     */       Set<Class<?>> set2;
/*  56 */       if ((set2 = ((Dependent)(dependentItem = (entry = reversibleIndexedIterator.next()).getValue()).dependent).getAfterDependents()) != null && set2.size() > 0) {
/*  57 */         for (Iterator<Class<?>> iterator = set2.iterator(); iterator.hasNext(); ) {
/*  58 */           Class<LastDependent> clazz; if ((clazz = (Class)iterator.next()) == LastDependent.class) {
/*     */             
/*  60 */             for (ReversibleIterator<DependentItem> reversibleIterator = dependentItemMap.valueIterable().iterator(); reversibleIterator.hasNext();) {
/*  61 */               if ((dependentItem2 = reversibleIterator.next()) != null && dependentItem2 != dependentItem) {
/*  62 */                 dependentItem.addDependency(dependentItem2);
/*  63 */                 dependentItem2.addDependent(dependentItem);
/*     */               } 
/*     */             }  continue;
/*     */           } 
/*     */           DependentItem dependentItem1;
/*  68 */           if ((dependentItem1 = (DependentItem)dependentItemMap.get(clazz)) != null) {
/*  69 */             dependentItem.addDependency(dependentItem1);
/*  70 */             dependentItem1.addDependent(dependentItem);
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*     */       Set<Class<?>> set1;
/*     */       
/*  77 */       if ((set1 = ((Dependent)dependentItem.dependent).getBeforeDependents()) != null && set1.size() > 0) {
/*  78 */         for (Iterator<Class<?>> iterator = set1.iterator(); iterator.hasNext(); ) {
/*  79 */           Class<FirstDependent> clazz; if ((clazz = (Class)iterator.next()) == FirstDependent.class) {
/*     */             
/*  81 */             for (ReversibleIterator<DependentItem> reversibleIterator = dependentItemMap.valueIterable().iterator(); reversibleIterator.hasNext();) {
/*  82 */               if ((dependentItem2 = reversibleIterator.next()) != null && dependentItem2 != dependentItem) {
/*  83 */                 dependentItem2.addDependency(dependentItem);
/*  84 */                 dependentItem.addDependent(dependentItem2);
/*     */               } 
/*     */             }  continue;
/*     */           } 
/*     */           DependentItem dependentItem1;
/*  89 */           if ((dependentItem1 = (DependentItem)dependentItemMap.get(clazz)) != null) {
/*  90 */             dependentItem1.addDependency(dependentItem);
/*  91 */             dependentItem.addDependent(dependentItem1);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  98 */     if (paramFunction != null) {
/*  99 */       dependentItemMap = paramFunction.apply(dependentItemMap);
/*     */     }
/* 101 */     i = dependentItemMap.size();
/*     */     
/* 103 */     BitSet bitSet1 = new BitSet(i);
/* 104 */     Ref ref = new Ref(bitSet1);
/* 105 */     ReversibleIndexedIterator reversibleIndexedIterator1 = dependentItemMap.valueIterator();
/* 106 */     while (reversibleIndexedIterator1.hasNext()) {
/*     */       DependentItem<?> dependentItem;
/* 108 */       if (!(dependentItem = (DependentItem)reversibleIndexedIterator1.next()).hasDependencies()) {
/* 109 */         ((BitSet)ref.value).set(dependentItem.index);
/*     */       }
/*     */     } 
/*     */     
/*     */     BitSet bitSet2;
/* 114 */     (bitSet2 = new BitSet(i)).set(0, dependentItemMap.size());
/*     */     
/* 116 */     ArrayList<ArrayList<D>> arrayList = new ArrayList();
/*     */     
/* 118 */     while (bitSet1.nextSetBit(0) != -1) {
/*     */       
/* 120 */       ArrayList<D> arrayList1 = new ArrayList();
/* 121 */       BitSet bitSet = new BitSet();
/*     */ 
/*     */       
/*     */       int j;
/*     */       
/* 126 */       while ((j = bitSet1.nextSetBit(0)) >= 0) {
/*     */         
/* 128 */         bitSet1.clear(j);
/* 129 */         DependentItem dependentItem = (DependentItem)dependentItemMap.getValue(j);
/* 130 */         assert dependentItem != null;
/*     */         
/* 132 */         arrayList1.add(dependentItem.dependent);
/* 133 */         bitSet2.clear(j);
/*     */ 
/*     */         
/* 136 */         if (dependentItem.hasDependents()) {
/*     */           int k;
/*     */           
/* 139 */           while ((k = dependentItem.dependents.nextSetBit(0)) >= 0) {
/*     */             
/* 141 */             dependentItem.dependents.clear(k);
/* 142 */             DependentItem dependentItem1 = (DependentItem)dependentItemMap.getValue(k);
/* 143 */             assert dependentItem1 != null;
/*     */             
/* 145 */             if (!dependentItem1.removeDependency(dependentItem)) {
/* 146 */               if (dependentItem.isGlobalScope) {
/* 147 */                 bitSet.set(k); continue;
/*     */               } 
/* 149 */               bitSet1.set(k);
/*     */             } 
/*     */           }  continue;
/*     */         } 
/* 153 */         if (dependentItem.isGlobalScope) {
/*     */           
/* 155 */           bitSet.or(bitSet1);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 161 */       bitSet1 = bitSet;
/* 162 */       arrayList.add(arrayList1);
/*     */     } 
/*     */     
/* 165 */     if (bitSet2.nextSetBit(0) != -1) {
/* 166 */       throw new IllegalStateException("have dependents with dependency cycles" + bitSet2);
/*     */     }
/*     */     
/* 169 */     return (List)arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\dependency\DependencyResolver.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */