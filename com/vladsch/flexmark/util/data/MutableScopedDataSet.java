/*    */ package com.vladsch.flexmark.util.data;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MutableScopedDataSet
/*    */   extends MutableDataSet
/*    */ {
/*    */   protected final DataHolder parent;
/*    */   
/*    */   public MutableScopedDataSet(DataHolder paramDataHolder) {
/* 16 */     this.parent = paramDataHolder;
/*    */   }
/*    */   
/*    */   public MutableScopedDataSet(DataHolder paramDataHolder, MutableDataHolder paramMutableDataHolder) {
/* 20 */     super(paramMutableDataHolder);
/* 21 */     this.parent = paramDataHolder;
/*    */   }
/*    */   
/*    */   public DataHolder getParent() {
/* 25 */     return this.parent;
/*    */   }
/*    */ 
/*    */   
/*    */   public Map<? extends DataKeyBase<?>, Object> getAll() {
/* 30 */     if (this.parent != null) {
/* 31 */       HashMap<DataKeyBase<?>, Object> hashMap = new HashMap<>(super.getAll());
/* 32 */       for (DataKeyBase<?> dataKeyBase : this.parent.getKeys()) {
/* 33 */         if (!contains(dataKeyBase)) {
/* 34 */           hashMap.put(dataKeyBase, dataKeyBase.get(this.parent));
/*    */         }
/*    */       } 
/*    */       
/* 38 */       return hashMap;
/*    */     } 
/* 40 */     return super.getAll();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Collection<? extends DataKeyBase<?>> getKeys() {
/* 46 */     if (this.parent != null) {
/* 47 */       ArrayList<DataKeyBase<?>> arrayList = new ArrayList<>(super.getKeys());
/* 48 */       for (DataKeyBase<?> dataKeyBase : this.parent.getKeys()) {
/* 49 */         if (!contains(dataKeyBase)) {
/* 50 */           arrayList.add(dataKeyBase);
/*    */         }
/*    */       } 
/*    */       
/* 54 */       return arrayList;
/*    */     } 
/* 56 */     return super.getKeys();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean contains(DataKeyBase<?> paramDataKeyBase) {
/* 62 */     return (super.contains(paramDataKeyBase) || (this.parent != null && this.parent.contains(paramDataKeyBase)));
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getOrCompute(DataKeyBase<?> paramDataKeyBase, DataValueFactory<?> paramDataValueFactory) {
/* 67 */     if (this.parent == null || super.contains(paramDataKeyBase) || !this.parent.contains(paramDataKeyBase)) {
/* 68 */       return super.getOrCompute(paramDataKeyBase, paramDataValueFactory);
/*    */     }
/* 70 */     return this.parent.getOrCompute(paramDataKeyBase, paramDataValueFactory);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\data\MutableScopedDataSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */