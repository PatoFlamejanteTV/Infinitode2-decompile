/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
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
/*     */ public class OrderedSet<T>
/*     */   extends ObjectSet<T>
/*     */ {
/*     */   final Array<T> items;
/*     */   transient OrderedSetIterator iterator1;
/*     */   transient OrderedSetIterator iterator2;
/*     */   
/*     */   public OrderedSet() {
/*  48 */     this.items = new Array<>();
/*     */   }
/*     */   
/*     */   public OrderedSet(int paramInt, float paramFloat) {
/*  52 */     super(paramInt, paramFloat);
/*  53 */     this.items = new Array<>(paramInt);
/*     */   }
/*     */   
/*     */   public OrderedSet(int paramInt) {
/*  57 */     super(paramInt);
/*  58 */     this.items = new Array<>(paramInt);
/*     */   }
/*     */   
/*     */   public OrderedSet(OrderedSet<? extends T> paramOrderedSet) {
/*  62 */     super(paramOrderedSet);
/*  63 */     this.items = new Array<>(paramOrderedSet.items);
/*     */   }
/*     */   
/*     */   public boolean add(T paramT) {
/*  67 */     if (!super.add(paramT)) return false; 
/*  68 */     this.items.add(paramT);
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(T paramT, int paramInt) {
/*     */     int i;
/*  75 */     if (!super.add(paramT)) {
/*     */       
/*  77 */       if ((i = this.items.indexOf(paramT, true)) != paramInt) this.items.insert(paramInt, this.items.removeIndex(i)); 
/*  78 */       return false;
/*     */     } 
/*  80 */     this.items.insert(paramInt, i);
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   public void addAll(OrderedSet<T> paramOrderedSet) {
/*  85 */     ensureCapacity(paramOrderedSet.size);
/*  86 */     T[] arrayOfT = paramOrderedSet.items.items; int i; byte b;
/*  87 */     for (b = 0, i = paramOrderedSet.items.size; b < i; b++)
/*  88 */       add(arrayOfT[b]); 
/*     */   }
/*     */   
/*     */   public boolean remove(T paramT) {
/*  92 */     if (!super.remove(paramT)) return false; 
/*  93 */     this.items.removeValue(paramT, false);
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   public T removeIndex(int paramInt) {
/*  98 */     paramInt = this.items.removeIndex(paramInt);
/*  99 */     super.remove(paramInt);
/* 100 */     return paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean alter(T paramT1, T paramT2) {
/* 111 */     if (contains(paramT2)) return false; 
/* 112 */     if (!super.remove(paramT1)) return false; 
/* 113 */     super.add(paramT2);
/* 114 */     this.items.set(this.items.indexOf(paramT1, false), paramT2);
/* 115 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean alterIndex(int paramInt, T paramT) {
/* 125 */     if (paramInt < 0 || paramInt >= this.size || contains(paramT)) return false; 
/* 126 */     super.remove(this.items.get(paramInt));
/* 127 */     super.add(paramT);
/* 128 */     this.items.set(paramInt, paramT);
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 133 */     this.items.clear();
/* 134 */     super.clear(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 138 */     this.items.clear();
/* 139 */     super.clear();
/*     */   }
/*     */   
/*     */   public Array<T> orderedItems() {
/* 143 */     return this.items;
/*     */   }
/*     */   
/*     */   public OrderedSetIterator<T> iterator() {
/* 147 */     if (Collections.allocateIterators) return new OrderedSetIterator<>(this); 
/* 148 */     if (this.iterator1 == null) {
/* 149 */       this.iterator1 = new OrderedSetIterator(this);
/* 150 */       this.iterator2 = new OrderedSetIterator(this);
/*     */     } 
/* 152 */     if (!this.iterator1.valid) {
/* 153 */       this.iterator1.reset();
/* 154 */       this.iterator1.valid = true;
/* 155 */       this.iterator2.valid = false;
/* 156 */       return this.iterator1;
/*     */     } 
/* 158 */     this.iterator2.reset();
/* 159 */     this.iterator2.valid = true;
/* 160 */     this.iterator1.valid = false;
/* 161 */     return this.iterator2;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 165 */     if (this.size == 0) return "{}"; 
/* 166 */     T[] arrayOfT = this.items.items;
/*     */     java.lang.StringBuilder stringBuilder;
/* 168 */     (stringBuilder = new java.lang.StringBuilder(32)).append('{');
/* 169 */     stringBuilder.append(arrayOfT[0]);
/* 170 */     for (byte b = 1; b < this.size; b++) {
/* 171 */       stringBuilder.append(", ");
/* 172 */       stringBuilder.append(arrayOfT[b]);
/*     */     } 
/* 174 */     stringBuilder.append('}');
/* 175 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String toString(String paramString) {
/* 179 */     return this.items.toString(paramString);
/*     */   }
/*     */   
/*     */   public static class OrderedSetIterator<K> extends ObjectSet.ObjectSetIterator<K> {
/*     */     private Array<K> items;
/*     */     
/*     */     public OrderedSetIterator(OrderedSet<K> param1OrderedSet) {
/* 186 */       super(param1OrderedSet);
/* 187 */       this.items = param1OrderedSet.items;
/*     */     }
/*     */     
/*     */     public void reset() {
/* 191 */       this.nextIndex = 0;
/* 192 */       this.hasNext = (this.set.size > 0);
/*     */     }
/*     */     
/*     */     public K next() {
/* 196 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 197 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 198 */       K k = this.items.get(this.nextIndex);
/* 199 */       this.nextIndex++;
/* 200 */       this.hasNext = (this.nextIndex < this.set.size);
/* 201 */       return k;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 205 */       if (this.nextIndex < 0) throw new IllegalStateException("next must be called before remove."); 
/* 206 */       this.nextIndex--;
/* 207 */       ((OrderedSet)this.set).removeIndex(this.nextIndex);
/*     */     }
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 211 */       param1Array.addAll(this.items, this.nextIndex, this.items.size - this.nextIndex);
/* 212 */       this.nextIndex = this.items.size;
/* 213 */       this.hasNext = false;
/* 214 */       return param1Array;
/*     */     }
/*     */     
/*     */     public Array<K> toArray() {
/* 218 */       return toArray(new Array<>(true, this.set.size - this.nextIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   public static <T> OrderedSet<T> with(T... paramVarArgs) {
/*     */     OrderedSet<T> orderedSet;
/* 224 */     (orderedSet = new OrderedSet<>()).addAll(paramVarArgs);
/* 225 */     return orderedSet;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\OrderedSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */