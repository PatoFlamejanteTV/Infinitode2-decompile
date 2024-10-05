/*     */ package io.github.classgraph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.ListIterator;
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
/*     */ class PotentiallyUnmodifiableList<T>
/*     */   extends ArrayList<T>
/*     */ {
/*     */   static final long serialVersionUID = 1L;
/*     */   boolean modifiable = true;
/*     */   
/*     */   PotentiallyUnmodifiableList() {}
/*     */   
/*     */   PotentiallyUnmodifiableList(int paramInt) {
/*  63 */     super(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PotentiallyUnmodifiableList(Collection<T> paramCollection) {
/*  73 */     super(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  79 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  85 */     return super.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   void makeUnmodifiable() {
/*  90 */     this.modifiable = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean add(T paramT) {
/*  95 */     if (!this.modifiable) {
/*  96 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/*  98 */     return super.add(paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int paramInt, T paramT) {
/* 104 */     if (!this.modifiable) {
/* 105 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 107 */     super.add(paramInt, paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(Object paramObject) {
/* 113 */     if (!this.modifiable) {
/* 114 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 116 */     return super.remove(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T remove(int paramInt) {
/* 122 */     if (!this.modifiable) {
/* 123 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 125 */     return super.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(Collection<? extends T> paramCollection) {
/* 131 */     if (!this.modifiable && !paramCollection.isEmpty()) {
/* 132 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 134 */     return super.addAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addAll(int paramInt, Collection<? extends T> paramCollection) {
/* 140 */     if (!this.modifiable && !paramCollection.isEmpty()) {
/* 141 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 143 */     return super.addAll(paramInt, paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeAll(Collection<?> paramCollection) {
/* 149 */     if (!this.modifiable && !paramCollection.isEmpty()) {
/* 150 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 152 */     return super.removeAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean retainAll(Collection<?> paramCollection) {
/* 158 */     if (!this.modifiable && !isEmpty()) {
/* 159 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 161 */     return super.retainAll(paramCollection);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 167 */     if (!this.modifiable && !isEmpty()) {
/* 168 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 170 */     super.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public T set(int paramInt, T paramT) {
/* 176 */     if (!this.modifiable) {
/* 177 */       throw new IllegalArgumentException("List is immutable");
/*     */     }
/* 179 */     return super.set(paramInt, paramT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<T> iterator() {
/* 189 */     final Iterator<T> iterator = super.iterator();
/* 190 */     return new Iterator<T>()
/*     */       {
/*     */         public boolean hasNext() {
/* 193 */           if (PotentiallyUnmodifiableList.this.isEmpty()) {
/* 194 */             return false;
/*     */           }
/* 196 */           return iterator.hasNext();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public T next() {
/* 202 */           return iterator.next();
/*     */         }
/*     */ 
/*     */         
/*     */         public void remove() {
/* 207 */           if (!PotentiallyUnmodifiableList.this.modifiable) {
/* 208 */             throw new IllegalArgumentException("List is immutable");
/*     */           }
/* 210 */           iterator.remove();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ListIterator<T> listIterator() {
/* 218 */     final ListIterator<T> iterator = super.listIterator();
/* 219 */     return new ListIterator<T>()
/*     */       {
/*     */         public boolean hasNext() {
/* 222 */           if (PotentiallyUnmodifiableList.this.isEmpty()) {
/* 223 */             return false;
/*     */           }
/* 225 */           return iterator.hasNext();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public T next() {
/* 231 */           return iterator.next();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hasPrevious() {
/* 236 */           if (PotentiallyUnmodifiableList.this.isEmpty()) {
/* 237 */             return false;
/*     */           }
/* 239 */           return iterator.hasPrevious();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public T previous() {
/* 245 */           return iterator.previous();
/*     */         }
/*     */ 
/*     */         
/*     */         public int nextIndex() {
/* 250 */           if (PotentiallyUnmodifiableList.this.isEmpty()) {
/* 251 */             return 0;
/*     */           }
/* 253 */           return iterator.nextIndex();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int previousIndex() {
/* 259 */           if (PotentiallyUnmodifiableList.this.isEmpty()) {
/* 260 */             return -1;
/*     */           }
/* 262 */           return iterator.previousIndex();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void remove() {
/* 268 */           if (!PotentiallyUnmodifiableList.this.modifiable) {
/* 269 */             throw new IllegalArgumentException("List is immutable");
/*     */           }
/* 271 */           iterator.remove();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(T param1T) {
/* 277 */           if (!PotentiallyUnmodifiableList.this.modifiable) {
/* 278 */             throw new IllegalArgumentException("List is immutable");
/*     */           }
/* 280 */           iterator.set(param1T);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void add(T param1T) {
/* 286 */           if (!PotentiallyUnmodifiableList.this.modifiable) {
/* 287 */             throw new IllegalArgumentException("List is immutable");
/*     */           }
/* 289 */           iterator.add(param1T);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\io\github\classgraph\PotentiallyUnmodifiableList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */