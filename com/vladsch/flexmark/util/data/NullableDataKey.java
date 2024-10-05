/*    */ package com.vladsch.flexmark.util.data;
/*    */ 
/*    */ import java.util.function.Supplier;
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
/*    */ public class NullableDataKey<T>
/*    */   extends DataKeyBase<T>
/*    */ {
/*    */   public NullableDataKey(String paramString, T paramT, DataValueFactory<T> paramDataValueFactory) {
/* 19 */     super(paramString, paramT, paramDataValueFactory);
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
/*    */   public NullableDataKey(String paramString, DataValueNullableFactory<T> paramDataValueNullableFactory) {
/* 31 */     super(paramString, paramDataValueNullableFactory.apply((DataHolder)null), paramDataValueNullableFactory);
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
/*    */   public NullableDataKey(String paramString, Supplier<T> paramSupplier) {
/* 43 */     super(paramString, paramSupplier.get(), paramDataHolder -> paramSupplier.get());
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
/*    */   public NullableDataKey(String paramString, DataKeyBase<T> paramDataKeyBase) {
/* 56 */     this(paramString, paramDataKeyBase.getDefaultValue(), paramDataKeyBase::get);
/*    */   }
/*    */   
/*    */   public NullableDataKey(String paramString, T paramT) {
/* 60 */     this(paramString, paramT, paramDataHolder -> paramObject);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NullableDataKey(String paramString) {
/* 69 */     this(paramString, null, paramDataHolder -> null);
/*    */   }
/*    */ 
/*    */   
/*    */   public T getDefaultValue() {
/* 74 */     return super.getDefaultValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public T getDefaultValue(DataHolder paramDataHolder) {
/* 79 */     return super.getDefaultValue(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public T get(DataHolder paramDataHolder) {
/* 84 */     return super.get(paramDataHolder);
/*    */   }
/*    */ 
/*    */   
/*    */   public MutableDataHolder set(MutableDataHolder paramMutableDataHolder, T paramT) {
/* 89 */     return paramMutableDataHolder.set(this, paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/*    */     T t;
/* 96 */     if ((t = getDefaultValue()) != null) {
/* 97 */       return "DataKey<" + t.getClass().getSimpleName() + "> " + getName();
/*    */     }
/* 99 */     return "DataKey<null> " + getName();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\NullableDataKey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */