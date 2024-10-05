/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ public final class MapEntry<K, V>
/*    */   implements Map.Entry<K, V>
/*    */ {
/*    */   private final K key;
/*    */   private final V value;
/*    */   
/*    */   public MapEntry(K paramK, V paramV) {
/* 14 */     this.key = paramK;
/* 15 */     this.value = paramV;
/*    */   }
/*    */ 
/*    */   
/*    */   public final K getKey() {
/* 20 */     return this.key;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V getValue() {
/* 25 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V setValue(V paramV) {
/* 30 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 35 */     if (this == paramObject) return true; 
/* 36 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*    */     
/* 38 */     paramObject = paramObject;
/*    */     
/* 40 */     if (!Objects.equals(this.key, ((MapEntry)paramObject).key)) return false; 
/* 41 */     return Objects.equals(this.value, ((MapEntry)paramObject).value);
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 46 */     int i = this.key.hashCode();
/*    */     
/* 48 */     return i = i * 31 + ((this.value != null) ? this.value.hashCode() : 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\MapEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */