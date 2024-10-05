/*    */ package com.badlogic.gdx.utils;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IdentityMap<K, V>
/*    */   extends ObjectMap<K, V>
/*    */ {
/*    */   public IdentityMap() {}
/*    */   
/*    */   public IdentityMap(int paramInt) {
/* 44 */     super(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IdentityMap(int paramInt, float paramFloat) {
/* 51 */     super(paramInt, paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public IdentityMap(IdentityMap<K, V> paramIdentityMap) {
/* 56 */     super(paramIdentityMap);
/*    */   }
/*    */   
/*    */   protected int place(K paramK) {
/* 60 */     return (int)(System.identityHashCode(paramK) * -7046029254386353131L >>> this.shift);
/*    */   }
/*    */   
/*    */   int locateKey(K paramK) {
/* 64 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/* 65 */     K[] arrayOfK = this.keyTable;
/* 66 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*    */       K k;
/* 68 */       if ((k = arrayOfK[i]) == null) return -(i + 1); 
/* 69 */       if (k == paramK) return i; 
/*    */     } 
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int i = this.size;
/* 75 */     K[] arrayOfK = this.keyTable;
/* 76 */     V[] arrayOfV = this.valueTable; byte b; int j;
/* 77 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*    */ 
/*    */       
/* 80 */       i += System.identityHashCode(k); V v;
/*    */       K k;
/* 82 */       if ((k = arrayOfK[b]) != null && (v = arrayOfV[b]) != null) i += v.hashCode();
/*    */     
/*    */     } 
/* 85 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\IdentityMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */