/*    */ package com.vladsch.flexmark.util.misc;
/*    */ 
/*    */ import java.util.Objects;
/*    */ 
/*    */ public final class Pair<K, V>
/*    */   implements Paired<K, V> {
/*    */   public static <K1, V1> Pair<K1, V1> of(K1 paramK1, V1 paramV1) {
/*  8 */     return new Pair<>(paramK1, paramV1);
/*    */   }
/*    */   
/*    */   private final K first;
/*    */   private final V second;
/*    */   
/*    */   public Pair(K paramK, V paramV) {
/* 15 */     this.first = paramK;
/* 16 */     this.second = paramV;
/*    */   }
/*    */ 
/*    */   
/*    */   public final K getFirst() {
/* 21 */     return this.first;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V getSecond() {
/* 26 */     return this.second;
/*    */   }
/*    */ 
/*    */   
/*    */   public final K getKey() {
/* 31 */     return this.first;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V getValue() {
/* 36 */     return this.second;
/*    */   }
/*    */ 
/*    */   
/*    */   public final V setValue(V paramV) {
/* 41 */     throw new IllegalStateException("setValue not supported");
/*    */   }
/*    */ 
/*    */   
/*    */   public final String toString() {
/*    */     StringBuilder stringBuilder;
/* 47 */     (stringBuilder = new StringBuilder()).append('(');
/*    */     
/* 49 */     if (this.first == null) { stringBuilder.append("null"); }
/* 50 */     else { stringBuilder.append(this.first); }
/*    */     
/* 52 */     stringBuilder.append(", ");
/*    */     
/* 54 */     if (this.second == null) { stringBuilder.append("null"); }
/* 55 */     else { stringBuilder.append(this.second); }
/*    */     
/* 57 */     stringBuilder.append(')');
/* 58 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public final boolean equals(Object paramObject) {
/* 63 */     if (this == paramObject) return true; 
/* 64 */     if (paramObject == null) return false; 
/* 65 */     if (!(paramObject instanceof java.util.Map.Entry)) return false;
/*    */     
/* 67 */     paramObject = paramObject;
/*    */     
/* 69 */     if (!Objects.equals(this.first, paramObject.getKey())) return false; 
/* 70 */     return Objects.equals(this.second, paramObject.getValue());
/*    */   }
/*    */ 
/*    */   
/*    */   public final int hashCode() {
/* 75 */     int i = (this.first != null) ? this.first.hashCode() : 0;
/*    */     
/* 77 */     return i = i * 31 + ((this.second != null) ? this.second.hashCode() : 0);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\Pair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */