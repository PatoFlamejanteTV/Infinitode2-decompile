/*    */ package com.vladsch.flexmark.util.data;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class DataKeyBase<T>
/*    */   implements MutableDataValueSetter<T>
/*    */ {
/*    */   private final String name;
/*    */   private final DataValueFactory<T> factory;
/*    */   private final T defaultValue;
/*    */   
/*    */   public DataKeyBase(String paramString, T paramT, DataValueFactory<T> paramDataValueFactory) {
/* 21 */     this.name = paramString;
/* 22 */     this.defaultValue = paramT;
/* 23 */     this.factory = paramDataValueFactory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public DataKeyBase(String paramString, DataKeyBase<T> paramDataKeyBase) {
/* 36 */     this(paramString, paramDataKeyBase.defaultValue, paramDataKeyBase::get);
/*    */   }
/*    */   
/*    */   public DataKeyBase(String paramString, T paramT) {
/* 40 */     this(paramString, paramT, paramDataHolder -> paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 45 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public DataValueFactory<T> getFactory() {
/* 50 */     return this.factory;
/*    */   }
/*    */   
/*    */   public T getDefaultValue() {
/* 54 */     return this.defaultValue;
/*    */   }
/*    */   
/*    */   public T getDefaultValue(DataHolder paramDataHolder) {
/* 58 */     return this.factory.apply(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public T get(DataHolder paramDataHolder) {
/* 63 */     return (T)((paramDataHolder == null) ? (Object)this.defaultValue : paramDataHolder.getOrCompute(this, this::getDefaultValue));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public final T getFrom(DataHolder paramDataHolder) {
/* 73 */     return get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 78 */     if (this.defaultValue != null) {
/* 79 */       return "NullableDataKey<" + this.defaultValue.getClass().getSimpleName() + "> " + this.name;
/*    */     }
/* 81 */     return "NullableDataKey<unknown> " + this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 93 */     return (this == paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 98 */     return super.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataKeyBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */