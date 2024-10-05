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
/*    */ public interface MutableDataHolder
/*    */   extends DataHolder, MutableDataSetter
/*    */ {
/*    */   @Deprecated
/*    */   default <T> T get(DataKey<T> paramDataKey) {
/* 17 */     return paramDataKey.get(this);
/*    */   }
/*    */   
/*    */   Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory);
/*    */   
/*    */   <T> MutableDataHolder set(DataKey<T> paramDataKey, T paramT);
/*    */   
/*    */   <T> MutableDataHolder set(NullableDataKey<T> paramNullableDataKey, T paramT);
/*    */   
/*    */   MutableDataHolder remove(DataKeyBase<?> paramDataKeyBase);
/*    */   
/*    */   MutableDataHolder setFrom(MutableDataSetter paramMutableDataSetter);
/*    */   
/*    */   MutableDataHolder setAll(DataHolder paramDataHolder);
/*    */   
/*    */   MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder);
/*    */   
/*    */   MutableDataHolder clear();
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\MutableDataHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */