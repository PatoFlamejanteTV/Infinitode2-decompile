/*     */ package com.esotericsoftware.kryo.util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IdentityMap<K, V>
/*     */   extends ObjectMap<K, V>
/*     */ {
/*     */   public IdentityMap() {}
/*     */   
/*     */   public IdentityMap(int paramInt) {
/*  44 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IdentityMap(int paramInt, float paramFloat) {
/*  51 */     super(paramInt, paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public IdentityMap(IdentityMap<K, V> paramIdentityMap) {
/*  56 */     super(paramIdentityMap);
/*     */   }
/*     */   
/*     */   protected int place(K paramK) {
/*  60 */     return System.identityHashCode(paramK) & this.mask;
/*     */   }
/*     */   
/*     */   public <T extends K> V get(T paramT) {
/*  64 */     for (int i = place((K)paramT);; i = i + 1 & this.mask) {
/*     */       K k;
/*  66 */       if ((k = this.keyTable[i]) == null) return null; 
/*  67 */       if (k == paramT) return this.valueTable[i]; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public V get(K paramK, V paramV) {
/*  72 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/*  74 */       if ((k = this.keyTable[i]) == null) return paramV; 
/*  75 */       if (k == paramK) return this.valueTable[i]; 
/*     */     } 
/*     */   }
/*     */   
/*     */   int locateKey(K paramK) {
/*  80 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/*  81 */     K[] arrayOfK = this.keyTable;
/*  82 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*     */       K k;
/*  84 */       if ((k = arrayOfK[i]) == null) return -(i + 1); 
/*  85 */       if (k == paramK) return i; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  90 */     int i = this.size;
/*  91 */     K[] arrayOfK = this.keyTable;
/*  92 */     V[] arrayOfV = this.valueTable; byte b; int j;
/*  93 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*     */ 
/*     */       
/*  96 */       i += System.identityHashCode(k); V v;
/*     */       K k;
/*  98 */       if ((k = arrayOfK[b]) != null && (v = arrayOfV[b]) != null) i += v.hashCode();
/*     */     
/*     */     } 
/* 101 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\IdentityMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */