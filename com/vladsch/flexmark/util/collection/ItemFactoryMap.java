/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import java.util.function.Function;
/*    */ 
/*    */ 
/*    */ public class ItemFactoryMap<I, P>
/*    */   implements Map<Function<P, I>, I>
/*    */ {
/*    */   protected final HashMap<Function<P, I>, I> itemMap;
/*    */   protected final P param;
/*    */   
/*    */   public ItemFactoryMap(P paramP) {
/* 17 */     this(paramP, 0);
/*    */   }
/*    */   
/*    */   public ItemFactoryMap(P paramP, int paramInt) {
/* 21 */     this.itemMap = new HashMap<>(paramInt);
/* 22 */     this.param = paramP;
/*    */   }
/*    */   
/*    */   public I getItem(Function<P, I> paramFunction) {
/*    */     I i;
/* 27 */     if ((i = this.itemMap.get(paramFunction)) == null) {
/* 28 */       i = paramFunction.apply(this.param);
/* 29 */       this.itemMap.put(paramFunction, i);
/*    */     } 
/* 31 */     return i;
/*    */   }
/*    */ 
/*    */   
/*    */   public I get(Object paramObject) {
/* 36 */     if (paramObject instanceof Function)
/*    */     {
/* 38 */       return getItem((Function<P, I>)paramObject);
/*    */     }
/* 40 */     return null;
/*    */   }
/*    */   
/*    */   public int size() {
/* 44 */     return this.itemMap.size();
/*    */   }
/*    */   public boolean isEmpty() {
/* 47 */     return this.itemMap.isEmpty();
/*    */   }
/*    */   public boolean containsKey(Object paramObject) {
/* 50 */     return this.itemMap.containsKey(paramObject);
/*    */   }
/*    */   public I put(Function<P, I> paramFunction, I paramI) {
/* 53 */     return this.itemMap.put(paramFunction, paramI);
/*    */   }
/*    */   public void putAll(Map<? extends Function<P, I>, ? extends I> paramMap) {
/* 56 */     this.itemMap.putAll(paramMap);
/*    */   }
/*    */   public I remove(Object paramObject) {
/* 59 */     return this.itemMap.remove(paramObject);
/*    */   }
/*    */   public void clear() {
/* 62 */     this.itemMap.clear();
/*    */   }
/*    */   public boolean containsValue(Object paramObject) {
/* 65 */     return this.itemMap.containsValue(paramObject);
/*    */   }
/*    */   public Set<Function<P, I>> keySet() {
/* 68 */     return this.itemMap.keySet();
/*    */   }
/*    */   public Collection<I> values() {
/* 71 */     return this.itemMap.values();
/*    */   }
/*    */   public Set<Map.Entry<Function<P, I>, I>> entrySet() {
/* 74 */     return this.itemMap.entrySet();
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\ItemFactoryMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */