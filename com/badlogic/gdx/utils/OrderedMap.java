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
/*     */ 
/*     */ 
/*     */ public class OrderedMap<K, V>
/*     */   extends ObjectMap<K, V>
/*     */ {
/*     */   final Array<K> keys;
/*     */   
/*     */   public OrderedMap() {
/*  48 */     this.keys = new Array<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMap(int paramInt) {
/*  54 */     super(paramInt);
/*  55 */     this.keys = new Array<>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OrderedMap(int paramInt, float paramFloat) {
/*  62 */     super(paramInt, paramFloat);
/*  63 */     this.keys = new Array<>(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public OrderedMap(OrderedMap<? extends K, ? extends V> paramOrderedMap) {
/*  68 */     super(paramOrderedMap);
/*  69 */     this.keys = new Array<>(paramOrderedMap.keys);
/*     */   }
/*     */   public V put(K paramK, V paramV) {
/*     */     V v;
/*     */     int i;
/*  74 */     if ((i = locateKey(paramK)) >= 0) {
/*  75 */       v = this.valueTable[i];
/*  76 */       this.valueTable[i] = paramV;
/*  77 */       return v;
/*     */     } 
/*  79 */     i = -(i + 1);
/*  80 */     this.keyTable[i] = (K)v;
/*  81 */     this.valueTable[i] = paramV;
/*  82 */     this.keys.add((K)v);
/*  83 */     if (++this.size >= this.threshold) resize(this.keyTable.length << 1); 
/*  84 */     return null;
/*     */   }
/*     */   
/*     */   public <T extends K> void putAll(OrderedMap<T, ? extends V> paramOrderedMap) {
/*  88 */     ensureCapacity(paramOrderedMap.size);
/*  89 */     T[] arrayOfT = paramOrderedMap.keys.items; byte b; int i;
/*  90 */     for (b = 0, i = paramOrderedMap.keys.size; b < i; b++) {
/*  91 */       T t = arrayOfT[b];
/*  92 */       put((K)t, paramOrderedMap.get(t));
/*     */     } 
/*     */   }
/*     */   
/*     */   public V remove(K paramK) {
/*  97 */     this.keys.removeValue(paramK, false);
/*  98 */     return super.remove(paramK);
/*     */   }
/*     */   
/*     */   public V removeIndex(int paramInt) {
/* 102 */     return super.remove(this.keys.removeIndex(paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean alter(K paramK1, K paramK2) {
/* 113 */     if (containsKey(paramK2)) return false; 
/*     */     int i;
/* 115 */     if ((i = this.keys.indexOf(paramK1, false)) == -1) return false; 
/* 116 */     super.put(paramK2, super.remove(paramK1));
/* 117 */     this.keys.set(i, paramK2);
/* 118 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean alterIndex(int paramInt, K paramK) {
/* 128 */     if (paramInt < 0 || paramInt >= this.size || containsKey(paramK)) return false; 
/* 129 */     super.put(paramK, super.remove(this.keys.get(paramInt)));
/* 130 */     this.keys.set(paramInt, paramK);
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   public void clear(int paramInt) {
/* 135 */     this.keys.clear();
/* 136 */     super.clear(paramInt);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 140 */     this.keys.clear();
/* 141 */     super.clear();
/*     */   }
/*     */   
/*     */   public Array<K> orderedKeys() {
/* 145 */     return this.keys;
/*     */   }
/*     */   
/*     */   public ObjectMap.Entries<K, V> iterator() {
/* 149 */     return entries();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap.Entries<K, V> entries() {
/* 157 */     if (Collections.allocateIterators) return new OrderedMapEntries<>(this); 
/* 158 */     if (this.entries1 == null) {
/* 159 */       this.entries1 = new OrderedMapEntries<>(this);
/* 160 */       this.entries2 = new OrderedMapEntries<>(this);
/*     */     } 
/* 162 */     if (!this.entries1.valid) {
/* 163 */       this.entries1.reset();
/* 164 */       this.entries1.valid = true;
/* 165 */       this.entries2.valid = false;
/* 166 */       return this.entries1;
/*     */     } 
/* 168 */     this.entries2.reset();
/* 169 */     this.entries2.valid = true;
/* 170 */     this.entries1.valid = false;
/* 171 */     return this.entries2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap.Values<V> values() {
/* 179 */     if (Collections.allocateIterators) return new OrderedMapValues<>(this); 
/* 180 */     if (this.values1 == null) {
/* 181 */       this.values1 = new OrderedMapValues(this);
/* 182 */       this.values2 = new OrderedMapValues(this);
/*     */     } 
/* 184 */     if (!this.values1.valid) {
/* 185 */       this.values1.reset();
/* 186 */       this.values1.valid = true;
/* 187 */       this.values2.valid = false;
/* 188 */       return this.values1;
/*     */     } 
/* 190 */     this.values2.reset();
/* 191 */     this.values2.valid = true;
/* 192 */     this.values1.valid = false;
/* 193 */     return this.values2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ObjectMap.Keys<K> keys() {
/* 201 */     if (Collections.allocateIterators) return new OrderedMapKeys<>(this); 
/* 202 */     if (this.keys1 == null) {
/* 203 */       this.keys1 = new OrderedMapKeys(this);
/* 204 */       this.keys2 = new OrderedMapKeys(this);
/*     */     } 
/* 206 */     if (!this.keys1.valid) {
/* 207 */       this.keys1.reset();
/* 208 */       this.keys1.valid = true;
/* 209 */       this.keys2.valid = false;
/* 210 */       return this.keys1;
/*     */     } 
/* 212 */     this.keys2.reset();
/* 213 */     this.keys2.valid = true;
/* 214 */     this.keys1.valid = false;
/* 215 */     return this.keys2;
/*     */   }
/*     */   
/*     */   protected String toString(String paramString, boolean paramBoolean) {
/* 219 */     if (this.size == 0) return paramBoolean ? "{}" : ""; 
/* 220 */     java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder(32);
/* 221 */     if (paramBoolean) stringBuilder.append('{'); 
/* 222 */     Array<K> array = this.keys; byte b; int i;
/* 223 */     for (b = 0, i = array.size; b < i; b++) {
/* 224 */       V v = (V)array.get(b);
/* 225 */       if (b > 0) stringBuilder.append(paramString); 
/* 226 */       stringBuilder.append((v == this) ? "(this)" : v);
/* 227 */       stringBuilder.append('=');
/* 228 */       v = get(v);
/* 229 */       stringBuilder.append((v == this) ? "(this)" : v);
/*     */     } 
/* 231 */     if (paramBoolean) stringBuilder.append('}'); 
/* 232 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static class OrderedMapEntries<K, V> extends ObjectMap.Entries<K, V> {
/*     */     private Array<K> keys;
/*     */     
/*     */     public OrderedMapEntries(OrderedMap<K, V> param1OrderedMap) {
/* 239 */       super(param1OrderedMap);
/* 240 */       this.keys = param1OrderedMap.keys;
/*     */     }
/*     */     
/*     */     public void reset() {
/* 244 */       this.currentIndex = -1;
/* 245 */       this.nextIndex = 0;
/* 246 */       this.hasNext = (this.map.size > 0);
/*     */     }
/*     */     
/*     */     public ObjectMap.Entry next() {
/* 250 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 251 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 252 */       this.currentIndex = this.nextIndex;
/* 253 */       this.entry.key = this.keys.get(this.nextIndex);
/* 254 */       this.entry.value = this.map.get(this.entry.key);
/* 255 */       this.nextIndex++;
/* 256 */       this.hasNext = (this.nextIndex < this.map.size);
/* 257 */       return this.entry;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 261 */       if (this.currentIndex < 0) throw new IllegalStateException("next must be called before remove."); 
/* 262 */       this.map.remove(this.entry.key);
/* 263 */       this.nextIndex--;
/* 264 */       this.currentIndex = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class OrderedMapKeys<K> extends ObjectMap.Keys<K> {
/*     */     private Array<K> keys;
/*     */     
/*     */     public OrderedMapKeys(OrderedMap<K, ?> param1OrderedMap) {
/* 272 */       super(param1OrderedMap);
/* 273 */       this.keys = param1OrderedMap.keys;
/*     */     }
/*     */     
/*     */     public void reset() {
/* 277 */       this.currentIndex = -1;
/* 278 */       this.nextIndex = 0;
/* 279 */       this.hasNext = (this.map.size > 0);
/*     */     }
/*     */     
/*     */     public K next() {
/* 283 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 284 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 285 */       K k = this.keys.get(this.nextIndex);
/* 286 */       this.currentIndex = this.nextIndex;
/* 287 */       this.nextIndex++;
/* 288 */       this.hasNext = (this.nextIndex < this.map.size);
/* 289 */       return k;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 293 */       if (this.currentIndex < 0) throw new IllegalStateException("next must be called before remove."); 
/* 294 */       ((OrderedMap)this.map).removeIndex(this.currentIndex);
/* 295 */       this.nextIndex = this.currentIndex;
/* 296 */       this.currentIndex = -1;
/*     */     }
/*     */     
/*     */     public Array<K> toArray(Array<K> param1Array) {
/* 300 */       param1Array.addAll(this.keys, this.nextIndex, this.keys.size - this.nextIndex);
/* 301 */       this.nextIndex = this.keys.size;
/* 302 */       this.hasNext = false;
/* 303 */       return param1Array;
/*     */     }
/*     */     
/*     */     public Array<K> toArray() {
/* 307 */       return toArray(new Array<>(true, this.keys.size - this.nextIndex));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class OrderedMapValues<V> extends ObjectMap.Values<V> {
/*     */     private Array keys;
/*     */     
/*     */     public OrderedMapValues(OrderedMap<?, V> param1OrderedMap) {
/* 315 */       super(param1OrderedMap);
/* 316 */       this.keys = param1OrderedMap.keys;
/*     */     }
/*     */     
/*     */     public void reset() {
/* 320 */       this.currentIndex = -1;
/* 321 */       this.nextIndex = 0;
/* 322 */       this.hasNext = (this.map.size > 0);
/*     */     }
/*     */     
/*     */     public V next() {
/* 326 */       if (!this.hasNext) throw new NoSuchElementException(); 
/* 327 */       if (!this.valid) throw new GdxRuntimeException("#iterator() cannot be used nested."); 
/* 328 */       V v = this.map.get(this.keys.get(this.nextIndex));
/* 329 */       this.currentIndex = this.nextIndex;
/* 330 */       this.nextIndex++;
/* 331 */       this.hasNext = (this.nextIndex < this.map.size);
/* 332 */       return v;
/*     */     }
/*     */     
/*     */     public void remove() {
/* 336 */       if (this.currentIndex < 0) throw new IllegalStateException("next must be called before remove."); 
/* 337 */       ((OrderedMap)this.map).removeIndex(this.currentIndex);
/* 338 */       this.nextIndex = this.currentIndex;
/* 339 */       this.currentIndex = -1;
/*     */     }
/*     */     
/*     */     public Array<V> toArray(Array<V> param1Array) {
/* 343 */       int i = this.keys.size;
/* 344 */       param1Array.ensureCapacity(i - this.nextIndex);
/* 345 */       T[] arrayOfT = this.keys.items;
/* 346 */       for (int j = this.nextIndex; j < i; j++)
/* 347 */         param1Array.add(this.map.get(arrayOfT[j])); 
/* 348 */       this.currentIndex = i - 1;
/* 349 */       this.nextIndex = i;
/* 350 */       this.hasNext = false;
/* 351 */       return param1Array;
/*     */     }
/*     */     
/*     */     public Array<V> toArray() {
/* 355 */       return toArray(new Array<>(true, this.keys.size - this.nextIndex));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\OrderedMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */