/*    */ package com.vladsch.flexmark.util.collection;
/*    */ 
/*    */ import java.util.BitSet;
/*    */ import java.util.function.Function;
/*    */ 
/*    */ public class IndexedItemBitSetMap<K, M>
/*    */   extends IndexedItemSetMapBase<K, BitSet, M>
/*    */ {
/*    */   private final Function<M, K> computable;
/*    */   
/*    */   public IndexedItemBitSetMap(Function<M, K> paramFunction) {
/* 12 */     this(paramFunction, 0);
/*    */   }
/*    */   
/*    */   public IndexedItemBitSetMap(Function<M, K> paramFunction, int paramInt) {
/* 16 */     super(paramInt);
/* 17 */     this.computable = paramFunction;
/*    */   }
/*    */   
/*    */   public Function<M, K> getComputable() {
/* 21 */     return this.computable;
/*    */   }
/*    */ 
/*    */   
/*    */   public K mapKey(M paramM) {
/* 26 */     return this.computable.apply(paramM);
/*    */   }
/*    */ 
/*    */   
/*    */   public BitSet newSet() {
/* 31 */     return new BitSet();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean addSetItem(BitSet paramBitSet, int paramInt) {
/* 36 */     boolean bool = paramBitSet.get(paramInt);
/* 37 */     paramBitSet.set(paramInt);
/* 38 */     return bool;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean removeSetItem(BitSet paramBitSet, int paramInt) {
/* 43 */     boolean bool = paramBitSet.get(paramInt);
/* 44 */     paramBitSet.clear(paramInt);
/* 45 */     return bool;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean containsSetItem(BitSet paramBitSet, int paramInt) {
/* 50 */     return paramBitSet.get(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\IndexedItemBitSetMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */