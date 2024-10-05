/*     */ package com.vladsch.flexmark.util.data;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class DataSet implements DataHolder {
/*     */   public DataSet() {
/*  12 */     this(null);
/*     */   }
/*     */   protected final HashMap<DataKeyBase<?>, Object> dataSet;
/*     */   public DataSet(DataHolder paramDataHolder) {
/*  16 */     if (paramDataHolder == null) { this.dataSet = new HashMap<>(); return; }
/*  17 */      this.dataSet = new HashMap<>(paramDataHolder.getAll());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataHolder aggregateActions(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
/*     */     DataSet dataSet;
/*  30 */     (dataSet = new DataSet(paramDataHolder1)).dataSet.putAll(paramDataHolder2.getAll());
/*     */     
/*  32 */     for (Iterator<DataKeyAggregator> iterator = ourDataKeyAggregators.iterator(); iterator.hasNext();) {
/*  33 */       dataSet = (dataKeyAggregator = iterator.next()).aggregateActions(dataSet, paramDataHolder1, paramDataHolder2).toDataSet();
/*     */     }
/*  35 */     return dataSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataHolder aggregate() {
/*  45 */     DataHolder dataHolder = this;
/*  46 */     for (Iterator<DataKeyAggregator> iterator = ourDataKeyAggregators.iterator(); iterator.hasNext();) {
/*  47 */       dataHolder = (dataKeyAggregator = iterator.next()).aggregate(dataHolder);
/*     */     }
/*  49 */     return dataHolder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataHolder aggregate(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
/*  61 */     if (paramDataHolder1 == null && paramDataHolder2 == null)
/*  62 */       return new DataSet(); 
/*  63 */     if (paramDataHolder2 == null)
/*  64 */       return paramDataHolder1; 
/*  65 */     if (paramDataHolder1 == null) {
/*  66 */       return paramDataHolder2.toDataSet().aggregate().toImmutable();
/*     */     }
/*  68 */     return aggregateActions(paramDataHolder1, paramDataHolder2).toDataSet().aggregate().toImmutable();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<? extends DataKeyBase<?>, Object> getAll() {
/*  74 */     return this.dataSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<? extends DataKeyBase<?>> getKeys() {
/*  79 */     return this.dataSet.keySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(DataKeyBase<?> paramDataKeyBase) {
/*  84 */     return this.dataSet.containsKey(paramDataKeyBase);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory) {
/*  89 */     if (this.dataSet.containsKey(paramDataKeyBase)) {
/*  90 */       return this.dataSet.get(paramDataKeyBase);
/*     */     }
/*  92 */     return paramDataValueFactory.apply(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DataSet merge(DataHolder... paramVarArgs) {
/*  98 */     DataSet dataSet = new DataSet(); int i; byte b;
/*  99 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { DataHolder dataHolder = paramVarArgs[b];
/* 100 */       dataSet.dataSet.putAll(dataHolder.getAll()); b++; }
/*     */     
/* 102 */     return dataSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet toMutable() {
/* 108 */     return new MutableDataSet(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataSet toImmutable() {
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public DataSet toDataSet() {
/* 119 */     return this;
/*     */   }
/*     */   
/* 122 */   private static final ArrayList<DataKeyAggregator> ourDataKeyAggregators = new ArrayList<>();
/*     */   
/*     */   public static void registerDataKeyAggregator(DataKeyAggregator paramDataKeyAggregator) {
/* 125 */     if (isAggregatorRegistered(paramDataKeyAggregator)) {
/* 126 */       throw new IllegalStateException("Aggregator " + paramDataKeyAggregator + " is already registered");
/*     */     }
/*     */ 
/*     */     
/* 130 */     for (byte b = 0; b < ourDataKeyAggregators.size(); b++) {
/*     */       DataKeyAggregator dataKeyAggregator;
/*     */       
/* 133 */       if (invokeSetContains((dataKeyAggregator = ourDataKeyAggregators.get(b)).invokeAfterSet(), paramDataKeyAggregator)) {
/*     */         
/* 135 */         if (invokeSetContains(paramDataKeyAggregator.invokeAfterSet(), dataKeyAggregator)) {
/* 136 */           throw new IllegalStateException("Circular invokeAfter dependencies for " + paramDataKeyAggregator + " and " + dataKeyAggregator);
/*     */         }
/*     */ 
/*     */         
/* 140 */         ourDataKeyAggregators.add(b, paramDataKeyAggregator);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 146 */     ourDataKeyAggregators.add(paramDataKeyAggregator);
/*     */   }
/*     */   
/*     */   static boolean isAggregatorRegistered(DataKeyAggregator paramDataKeyAggregator) {
/* 150 */     for (Iterator<DataKeyAggregator> iterator = ourDataKeyAggregators.iterator(); iterator.hasNext();) {
/* 151 */       if ((dataKeyAggregator = iterator.next()).getClass() == paramDataKeyAggregator.getClass()) return true; 
/*     */     } 
/* 153 */     return false;
/*     */   }
/*     */   
/*     */   static boolean invokeSetContains(Set<Class<?>> paramSet, DataKeyAggregator paramDataKeyAggregator) {
/* 157 */     if (paramSet == null) return false; 
/* 158 */     return paramSet.contains(paramDataKeyAggregator.getClass());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     return "DataSet{dataSet=" + this.dataSet + '}';
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 170 */     if (this == paramObject) return true; 
/* 171 */     if (!(paramObject instanceof DataSet)) return false;
/*     */     
/* 173 */     paramObject = paramObject;
/*     */     
/* 175 */     return this.dataSet.equals(((DataSet)paramObject).dataSet);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 180 */     return this.dataSet.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */