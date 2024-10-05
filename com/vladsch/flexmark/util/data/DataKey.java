/*     */ package com.vladsch.flexmark.util.data;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataKey<T>
/*     */   extends DataKeyBase<T>
/*     */ {
/*     */   public DataKey(String paramString, T paramT, DataNotNullValueFactory<T> paramDataNotNullValueFactory) {
/*  40 */     super(paramString, paramT, paramDataNotNullValueFactory);
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
/*     */   public DataKey(String paramString, NotNullValueSupplier<T> paramNotNullValueSupplier) {
/*  52 */     super(paramString, paramNotNullValueSupplier.get(), paramDataHolder -> paramNotNullValueSupplier.get());
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
/*     */   
/*     */   public DataKey(String paramString, DataKey<T> paramDataKey) {
/*  65 */     this(paramString, paramDataKey.getDefaultValue(), paramDataKey::get);
/*     */   }
/*     */   
/*     */   public DataKey(String paramString, T paramT) {
/*  69 */     this(paramString, paramT, paramDataHolder -> paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public DataNotNullValueFactory<T> getFactory() {
/*  74 */     return (DataNotNullValueFactory<T>)super.getFactory();
/*     */   }
/*     */ 
/*     */   
/*     */   public T getDefaultValue() {
/*  79 */     return super.getDefaultValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public T getDefaultValue(DataHolder paramDataHolder) {
/*  84 */     return super.getDefaultValue(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public T get(DataHolder paramDataHolder) {
/*  89 */     return super.get(paramDataHolder);
/*     */   }
/*     */ 
/*     */   
/*     */   public MutableDataHolder set(MutableDataHolder paramMutableDataHolder, T paramT) {
/*  94 */     return paramMutableDataHolder.set(this, paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     T t = getDefaultValue();
/* 101 */     return "DataKey<" + t.getClass().getSimpleName() + "> " + getName();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */