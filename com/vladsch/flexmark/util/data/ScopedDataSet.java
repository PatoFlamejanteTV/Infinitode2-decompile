/*    */ package com.vladsch.flexmark.util.data;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class ScopedDataSet
/*    */   extends DataSet {
/*    */   protected final DataHolder parent;
/*    */   
/*    */   public ScopedDataSet(DataHolder paramDataHolder) {
/* 13 */     this.parent = paramDataHolder;
/*    */   }
/*    */   
/*    */   public ScopedDataSet(DataHolder paramDataHolder1, DataHolder paramDataHolder2) {
/* 17 */     super(paramDataHolder2);
/* 18 */     this.parent = paramDataHolder1;
/*    */   }
/*    */   
/*    */   public DataHolder getParent() {
/* 22 */     return this.parent;
/*    */   }
/*    */ 
/*    */   
/*    */   public Map<? extends DataKeyBase<?>, Object> getAll() {
/* 27 */     if (this.parent != null) {
/*    */       HashMap<DataKeyBase<?>, Object> hashMap;
/* 29 */       (hashMap = new HashMap<>(this.parent.getAll())).putAll(super.getAll());
/* 30 */       return hashMap;
/*    */     } 
/* 32 */     return super.getAll();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<? extends DataKeyBase<?>> getKeys() {
/* 38 */     if (this.parent != null) {
/*    */       HashSet<DataKeyBase<?>> hashSet;
/* 40 */       (hashSet = new HashSet<>(this.parent.getKeys())).addAll(super.getKeys());
/* 41 */       return hashSet;
/*    */     } 
/* 43 */     return super.getKeys();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public MutableDataSet toMutable() {
/*    */     MutableDataSet mutableDataSet;
/* 50 */     (mutableDataSet = new MutableDataSet()).dataSet.putAll(super.getAll());
/* 51 */     return (this.parent != null) ? new MutableScopedDataSet(this.parent, mutableDataSet) : mutableDataSet;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean contains(DataKeyBase<?> paramDataKeyBase) {
/* 56 */     return (super.contains(paramDataKeyBase) || (this.parent != null && this.parent.contains(paramDataKeyBase)));
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory) {
/* 61 */     if (this.parent == null || super.contains(paramDataKeyBase) || !this.parent.contains(paramDataKeyBase)) {
/* 62 */       return super.getOrCompute(paramDataKeyBase, paramDataValueFactory);
/*    */     }
/* 64 */     return this.parent.getOrCompute(paramDataKeyBase, paramDataValueFactory);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\ScopedDataSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */