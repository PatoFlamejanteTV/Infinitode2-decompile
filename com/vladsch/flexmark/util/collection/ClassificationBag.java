/*     */ package com.vladsch.flexmark.util.collection;
/*     */ 
/*     */ import com.vladsch.flexmark.util.collection.iteration.BitSetIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
/*     */ import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
/*     */ import java.util.BitSet;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ import java.util.function.Function;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassificationBag<K, V>
/*     */ {
/*     */   private final OrderedSet<V> items;
/*     */   final IndexedItemBitSetMap<K, V> bag;
/*     */   final CollectionHost<V> host;
/*     */   
/*     */   public ClassificationBag(Function<V, K> paramFunction) {
/*  20 */     this(0, paramFunction);
/*     */   }
/*     */   
/*     */   public ClassificationBag(Function<V, K> paramFunction, CollectionHost<V> paramCollectionHost) {
/*  24 */     this(0, paramFunction, paramCollectionHost);
/*     */   }
/*     */   
/*     */   public ClassificationBag(int paramInt, Function<V, K> paramFunction) {
/*  28 */     this(paramInt, paramFunction, null);
/*     */   }
/*     */   
/*     */   public ClassificationBag(int paramInt, Function<V, K> paramFunction, CollectionHost<V> paramCollectionHost) {
/*  32 */     this.host = paramCollectionHost;
/*  33 */     this.items = new OrderedSet<>(paramInt, new CollectionHost<V>()
/*     */         {
/*     */           public void adding(int param1Int, V param1V, Object param1Object) {
/*  36 */             if (ClassificationBag.this.host != null && !ClassificationBag.this.host.skipHostUpdate()) ClassificationBag.this.host.adding(param1Int, param1V, param1Object); 
/*  37 */             if (param1V != null) ClassificationBag.this.bag.addItem(param1V, param1Int);
/*     */           
/*     */           }
/*     */           
/*     */           public Object removing(int param1Int, V param1V) {
/*  42 */             if (ClassificationBag.this.host != null && !ClassificationBag.this.host.skipHostUpdate()) ClassificationBag.this.host.removing(param1Int, param1V); 
/*  43 */             if (param1V != null) ClassificationBag.this.bag.removeItem(param1V, param1Int); 
/*  44 */             return null;
/*     */           }
/*     */ 
/*     */           
/*     */           public void clearing() {
/*  49 */             if (ClassificationBag.this.host != null && !ClassificationBag.this.host.skipHostUpdate()) ClassificationBag.this.host.clearing(); 
/*  50 */             ClassificationBag.this.bag.clear();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void addingNulls(int param1Int) {
/*  56 */             if (ClassificationBag.this.host != null && !ClassificationBag.this.host.skipHostUpdate()) ClassificationBag.this.host.addingNulls(param1Int);
/*     */           
/*     */           }
/*     */           
/*     */           public boolean skipHostUpdate() {
/*  61 */             return false;
/*     */           }
/*     */ 
/*     */           
/*     */           public int getIteratorModificationCount() {
/*  66 */             return ClassificationBag.this.getModificationCount();
/*     */           }
/*     */         });
/*     */     
/*  70 */     this.bag = new IndexedItemBitSetMap<>(paramFunction);
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedSet<V> getItems() {
/*  75 */     return this.items;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getModificationCount() {
/*  80 */     return this.items.getModificationCount();
/*     */   }
/*     */   
/*     */   public boolean add(V paramV) {
/*  84 */     return this.items.add(paramV);
/*     */   }
/*     */   
/*     */   public boolean remove(V paramV) {
/*  88 */     return this.items.remove(paramV);
/*     */   }
/*     */   
/*     */   public boolean remove(int paramInt) {
/*  92 */     return this.items.removeIndex(paramInt);
/*     */   }
/*     */   
/*     */   public boolean contains(V paramV) {
/*  96 */     return this.items.contains(paramV);
/*     */   }
/*     */   
/*     */   public boolean containsCategory(K paramK) {
/*     */     BitSet bitSet;
/* 101 */     if ((bitSet = this.bag.get(paramK)) != null && !bitSet.isEmpty()) return true;  return false;
/*     */   }
/*     */   
/*     */   public BitSet getCategorySet(K paramK) {
/* 105 */     return this.bag.get(paramK);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCategoryCount(K paramK) {
/*     */     BitSet bitSet;
/* 111 */     return ((bitSet = this.bag.get(paramK)) == null) ? 0 : bitSet.cardinality();
/*     */   }
/*     */   
/*     */   public Map<K, BitSet> getCategoryMap() {
/* 115 */     return this.bag;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 119 */     this.items.clear();
/*     */   }
/*     */   
/*     */   @SafeVarargs
/*     */   public final <X> ReversibleIterable<X> getCategoryItems(Class<? extends X> paramClass, K... paramVarArgs) {
/* 124 */     return (ReversibleIterable<X>)new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), (ReversibleIterable)new BitSetIterable(categoriesBitSet(paramVarArgs), false));
/*     */   }
/*     */   
/*     */   public final <X> ReversibleIterable<X> getCategoryItems(Class<? extends X> paramClass, Collection<? extends K> paramCollection) {
/* 128 */     return (ReversibleIterable<X>)new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), (ReversibleIterable)new BitSetIterable(categoriesBitSet(paramCollection), false));
/*     */   }
/*     */   
/*     */   public final <X> ReversibleIterable<X> getCategoryItems(Class<? extends X> paramClass, BitSet paramBitSet) {
/* 132 */     return (ReversibleIterable<X>)new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), (ReversibleIterable)new BitSetIterable(paramBitSet, false));
/*     */   }
/*     */   
/*     */   @SafeVarargs
/*     */   public final <X> ReversibleIterable<X> getCategoryItemsReversed(Class<? extends X> paramClass, K... paramVarArgs) {
/* 137 */     return (ReversibleIterable<X>)new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), (ReversibleIterable)new BitSetIterable(categoriesBitSet(paramVarArgs), true));
/*     */   }
/*     */   
/*     */   public final <X> ReversibleIterable<X> getCategoryItemsReversed(Class<? extends X> paramClass, Collection<? extends K> paramCollection) {
/* 141 */     return (ReversibleIterable<X>)new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), (ReversibleIterable)new BitSetIterable(categoriesBitSet(paramCollection), true));
/*     */   }
/*     */   
/*     */   public final <X> ReversibleIterable<X> getCategoryItemsReversed(Class<? extends X> paramClass, BitSet paramBitSet) {
/* 145 */     return (ReversibleIterable<X>)new IndexedIterable(this.items.getConcurrentModsIndexedProxy(), (ReversibleIterable)new BitSetIterable(paramBitSet, true));
/*     */   }
/*     */ 
/*     */   
/*     */   @SafeVarargs
/*     */   public final BitSet categoriesBitSet(K... paramVarArgs) {
/* 151 */     BitSet bitSet = new BitSet(); int i; byte b;
/* 152 */     for (i = (paramVarArgs = paramVarArgs).length, b = 0; b < i; ) { K k = paramVarArgs[b];
/*     */       BitSet bitSet1;
/* 154 */       if ((bitSet1 = this.bag.get(k)) != null)
/* 155 */         bitSet.or(bitSet1); 
/*     */       b++; }
/*     */     
/* 158 */     return bitSet;
/*     */   }
/*     */   
/*     */   public final BitSet categoriesBitSet(Collection<? extends K> paramCollection) {
/*     */     // Byte code:
/*     */     //   0: new java/util/BitSet
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: aload_1
/*     */     //   9: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   14: astore_1
/*     */     //   15: aload_1
/*     */     //   16: invokeinterface hasNext : ()Z
/*     */     //   21: ifeq -> 55
/*     */     //   24: aload_1
/*     */     //   25: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   30: astore_3
/*     */     //   31: aload_0
/*     */     //   32: getfield bag : Lcom/vladsch/flexmark/util/collection/IndexedItemBitSetMap;
/*     */     //   35: aload_3
/*     */     //   36: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   39: checkcast java/util/BitSet
/*     */     //   42: dup
/*     */     //   43: astore_3
/*     */     //   44: ifnull -> 52
/*     */     //   47: aload_2
/*     */     //   48: aload_3
/*     */     //   49: invokevirtual or : (Ljava/util/BitSet;)V
/*     */     //   52: goto -> 15
/*     */     //   55: aload_2
/*     */     //   56: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #162	-> 0
/*     */     //   #163	-> 8
/*     */     //   #164	-> 31
/*     */     //   #165	-> 43
/*     */     //   #166	-> 47
/*     */     //   #168	-> 52
/*     */     //   #169	-> 55
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\ClassificationBag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */