/*    */ package com.esotericsoftware.kryo.util;
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
/*    */ public class IdentityObjectIntMap<K>
/*    */   extends ObjectIntMap<K>
/*    */ {
/*    */   public IdentityObjectIntMap() {}
/*    */   
/*    */   public IdentityObjectIntMap(int paramInt) {
/* 44 */     super(paramInt);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public IdentityObjectIntMap(int paramInt, float paramFloat) {
/* 51 */     super(paramInt, paramFloat);
/*    */   }
/*    */ 
/*    */   
/*    */   public IdentityObjectIntMap(IdentityObjectIntMap<K> paramIdentityObjectIntMap) {
/* 56 */     super(paramIdentityObjectIntMap);
/*    */   }
/*    */   
/*    */   protected int place(K paramK) {
/* 60 */     return System.identityHashCode(paramK) & this.mask;
/*    */   }
/*    */   
/*    */   public int get(K paramK, int paramInt) {
/* 64 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*    */       K k;
/* 66 */       if ((k = this.keyTable[i]) == null) return paramInt; 
/* 67 */       if (k == paramK) return this.valueTable[i]; 
/*    */     } 
/*    */   }
/*    */   
/*    */   int locateKey(K paramK) {
/* 72 */     if (paramK == null) throw new IllegalArgumentException("key cannot be null."); 
/* 73 */     K[] arrayOfK = this.keyTable;
/* 74 */     for (int i = place(paramK);; i = i + 1 & this.mask) {
/*    */       K k;
/* 76 */       if ((k = arrayOfK[i]) == null) return -(i + 1); 
/* 77 */       if (k == paramK) return i; 
/*    */     } 
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int i = this.size;
/* 83 */     K[] arrayOfK = this.keyTable;
/* 84 */     int[] arrayOfInt = this.valueTable; byte b; int j;
/* 85 */     for (b = 0, j = arrayOfK.length; b < j; b++) {
/*    */       K k;
/* 87 */       if ((k = arrayOfK[b]) != null) i += System.identityHashCode(k) + arrayOfInt[b]; 
/*    */     } 
/* 89 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\esotericsoftware\kry\\util\IdentityObjectIntMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */