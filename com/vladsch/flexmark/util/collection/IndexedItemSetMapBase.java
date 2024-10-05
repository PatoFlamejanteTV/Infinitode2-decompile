/*     */ package com.vladsch.flexmark.util.collection;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IndexedItemSetMapBase<K, S, M>
/*     */   implements IndexedItemSetMap<K, S, M>
/*     */ {
/*     */   public IndexedItemSetMapBase() {
/*  15 */     this(0);
/*     */   }
/*     */ 
/*     */   
/*  19 */   protected final HashMap<K, S> bag = new HashMap<>();
/*     */ 
/*     */   
/*     */   public IndexedItemSetMapBase(int paramInt) {}
/*     */   
/*     */   public abstract K mapKey(M paramM);
/*     */   
/*     */   public abstract S newSet();
/*     */   
/*     */   public abstract boolean addSetItem(S paramS, int paramInt);
/*     */   
/*     */   public abstract boolean removeSetItem(S paramS, int paramInt);
/*     */   
/*     */   public abstract boolean containsSetItem(S paramS, int paramInt);
/*     */   
/*     */   public boolean addItem(M paramM, int paramInt) {
/*  35 */     paramM = (M)mapKey(paramM);
/*     */     S s;
/*  37 */     if ((s = this.bag.get(paramM)) == null) {
/*  38 */       s = newSet();
/*  39 */       this.bag.put((K)paramM, s);
/*     */     } 
/*  41 */     return addSetItem(s, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean removeItem(M paramM, int paramInt) {
/*  46 */     paramM = (M)mapKey(paramM);
/*     */     
/*  48 */     if ((paramM = (M)this.bag.get(paramM)) != null && removeSetItem((S)paramM, paramInt)) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsItem(M paramM, int paramInt) {
/*  53 */     paramM = (M)mapKey(paramM);
/*     */     
/*  55 */     if ((paramM = (M)this.bag.get(paramM)) != null && containsSetItem((S)paramM, paramInt)) return true;  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/*  60 */     return this.bag.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/*  65 */     return this.bag.isEmpty();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/*  70 */     return this.bag.containsKey(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsValue(Object paramObject) {
/*  75 */     return this.bag.containsValue(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public S get(Object paramObject) {
/*  80 */     return this.bag.get(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public S put(K paramK, S paramS) {
/*  85 */     return this.bag.put(paramK, paramS);
/*     */   }
/*     */ 
/*     */   
/*     */   public S remove(Object paramObject) {
/*  90 */     return this.bag.remove(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void putAll(Map<? extends K, ? extends S> paramMap) {
/*  95 */     this.bag.putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 100 */     this.bag.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<K> keySet() {
/* 105 */     return this.bag.keySet();
/*     */   }
/*     */ 
/*     */   
/*     */   public Collection<S> values() {
/* 110 */     return this.bag.values();
/*     */   }
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<K, S>> entrySet() {
/* 115 */     return this.bag.entrySet();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\IndexedItemSetMapBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */