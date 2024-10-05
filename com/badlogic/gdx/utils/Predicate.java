/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Iterator;
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
/*     */ public interface Predicate<T>
/*     */ {
/*     */   boolean evaluate(T paramT);
/*     */   
/*     */   public static class PredicateIterator<T>
/*     */     implements Iterator<T>
/*     */   {
/*     */     public Iterator<T> iterator;
/*     */     public Predicate<T> predicate;
/*     */     public boolean end = false;
/*     */     public boolean peeked = false;
/*  33 */     public T next = null;
/*     */     
/*     */     public PredicateIterator(Iterable<T> param1Iterable, Predicate<T> param1Predicate) {
/*  36 */       this(param1Iterable.iterator(), param1Predicate);
/*     */     }
/*     */     
/*     */     public PredicateIterator(Iterator<T> param1Iterator, Predicate<T> param1Predicate) {
/*  40 */       set(param1Iterator, param1Predicate);
/*     */     }
/*     */     
/*     */     public void set(Iterable<T> param1Iterable, Predicate<T> param1Predicate) {
/*  44 */       set(param1Iterable.iterator(), param1Predicate);
/*     */     }
/*     */     
/*     */     public void set(Iterator<T> param1Iterator, Predicate<T> param1Predicate) {
/*  48 */       this.iterator = param1Iterator;
/*  49 */       this.predicate = param1Predicate;
/*  50 */       this.end = this.peeked = false;
/*  51 */       this.next = null;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/*  56 */       if (this.end) return false; 
/*  57 */       if (this.next != null) return true; 
/*  58 */       this.peeked = true;
/*  59 */       while (this.iterator.hasNext()) {
/*  60 */         T t = this.iterator.next();
/*  61 */         if (this.predicate.evaluate(t)) {
/*  62 */           this.next = t;
/*  63 */           return true;
/*     */         } 
/*     */       } 
/*  66 */       this.end = true;
/*  67 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public T next() {
/*  72 */       if (this.next == null && !hasNext()) return null; 
/*  73 */       T t = this.next;
/*  74 */       this.next = null;
/*  75 */       this.peeked = false;
/*  76 */       return t;
/*     */     }
/*     */ 
/*     */     
/*     */     public void remove() {
/*  81 */       if (this.peeked) throw new GdxRuntimeException("Cannot remove between a call to hasNext() and next()."); 
/*  82 */       this.iterator.remove();
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PredicateIterable<T> implements Iterable<T> {
/*     */     public Iterable<T> iterable;
/*     */     public Predicate<T> predicate;
/*  89 */     public Predicate.PredicateIterator<T> iterator = null;
/*     */     
/*     */     public PredicateIterable(Iterable<T> param1Iterable, Predicate<T> param1Predicate) {
/*  92 */       set(param1Iterable, param1Predicate);
/*     */     }
/*     */     
/*     */     public void set(Iterable<T> param1Iterable, Predicate<T> param1Predicate) {
/*  96 */       this.iterable = param1Iterable;
/*  97 */       this.predicate = param1Predicate;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Iterator<T> iterator() {
/* 106 */       if (Collections.allocateIterators) return new Predicate.PredicateIterator<>(this.iterable.iterator(), this.predicate); 
/* 107 */       if (this.iterator == null) {
/* 108 */         this.iterator = new Predicate.PredicateIterator<>(this.iterable.iterator(), this.predicate);
/*     */       } else {
/* 110 */         this.iterator.set(this.iterable.iterator(), this.predicate);
/* 111 */       }  return this.iterator;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Predicate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */