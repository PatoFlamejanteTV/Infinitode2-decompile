/*     */ package com.vladsch.flexmark.util.data;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MutableDataSet
/*     */   extends DataSet
/*     */   implements MutableDataHolder
/*     */ {
/*     */   public MutableDataSet() {}
/*     */   
/*     */   public MutableDataSet(DataHolder paramDataHolder) {
/*  12 */     super(paramDataHolder);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> MutableDataSet set(DataKey<T> paramDataKey, T paramT) {
/*  18 */     return set(paramDataKey, paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> MutableDataSet set(NullableDataKey<T> paramNullableDataKey, T paramT) {
/*  24 */     return set(paramNullableDataKey, paramT);
/*     */   }
/*     */   
/*     */   private <T> MutableDataSet set(DataKeyBase<T> paramDataKeyBase, T paramT) {
/*  28 */     this.dataSet.put(paramDataKeyBase, paramT);
/*  29 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet setFrom(MutableDataSetter paramMutableDataSetter) {
/*  35 */     paramMutableDataSetter.setIn(this);
/*  36 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet setAll(DataHolder paramDataHolder) {
/*  42 */     this.dataSet.putAll(paramDataHolder.getAll());
/*  43 */     return this;
/*     */   }
/*     */   
/*     */   public static MutableDataSet merge(DataHolder... paramVarArgs) {
/*  47 */     MutableDataSet mutableDataSet = new MutableDataSet(); int i; byte b;
/*  48 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; b++) {
/*  49 */       DataHolder dataHolder; if ((dataHolder = paramVarArgs[b]) != null) {
/*  50 */         mutableDataSet.dataSet.putAll(dataHolder.getAll());
/*     */       }
/*     */     } 
/*  53 */     return mutableDataSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/*  59 */     paramMutableDataHolder.setAll(this);
/*  60 */     return paramMutableDataHolder;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet remove(DataKeyBase<?> paramDataKeyBase) {
/*  66 */     this.dataSet.remove(paramDataKeyBase);
/*  67 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory) {
/*  72 */     if (this.dataSet.containsKey(paramDataKeyBase)) {
/*  73 */       return this.dataSet.get(paramDataKeyBase);
/*     */     }
/*  75 */     paramDataValueFactory = (DataValueFactory<?>)paramDataValueFactory.apply(this);
/*  76 */     this.dataSet.put(paramDataKeyBase, paramDataValueFactory);
/*  77 */     return paramDataValueFactory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet toMutable() {
/*  84 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DataSet toImmutable() {
/*  90 */     return new DataSet(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableDataSet toDataSet() {
/*  95 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MutableDataSet clear() {
/* 101 */     this.dataSet.clear();
/* 102 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\MutableDataSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */