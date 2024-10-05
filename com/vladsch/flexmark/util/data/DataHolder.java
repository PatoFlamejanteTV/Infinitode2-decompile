/*    */ package com.vladsch.flexmark.util.data;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ public interface DataHolder
/*    */   extends MutableDataSetter
/*    */ {
/* 10 */   public static final DataHolder NULL = new DataSet();
/*    */ 
/*    */ 
/*    */   
/*    */   Map<? extends DataKeyBase<?>, Object> getAll();
/*    */ 
/*    */   
/*    */   Collection<? extends DataKeyBase<?>> getKeys();
/*    */ 
/*    */   
/*    */   boolean contains(DataKeyBase<?> paramDataKeyBase);
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   default <T> T get(DataKey<T> paramDataKey) {
/* 25 */     return paramDataKey.get(this);
/*    */   }
/*    */ 
/*    */   
/*    */   default MutableDataHolder setIn(MutableDataHolder paramMutableDataHolder) {
/* 30 */     return paramMutableDataHolder.setAll(this);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   MutableDataHolder toMutable();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   DataHolder toImmutable();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   default DataSet toDataSet() {
/* 53 */     return (this instanceof DataSet) ? (DataSet)this : ((this instanceof MutableDataHolder) ? new MutableDataSet(this) : new DataSet(this));
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\DataHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */