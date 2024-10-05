/*    */ package com.a.a.c.m;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.NoSuchElementException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class e<T>
/*    */   implements Iterable<T>, Iterator<T>
/*    */ {
/*    */   private final T[] a;
/*    */   private int b;
/*    */   
/*    */   public e(T[] paramArrayOfT) {
/* 18 */     this.a = paramArrayOfT;
/* 19 */     this.b = 0;
/*    */   }
/*    */   
/*    */   public final boolean hasNext() {
/* 23 */     return (this.b < this.a.length);
/*    */   }
/*    */   
/*    */   public final T next() {
/* 27 */     if (this.b >= this.a.length) {
/* 28 */       throw new NoSuchElementException();
/*    */     }
/* 30 */     return this.a[this.b++];
/*    */   }
/*    */   
/* 33 */   public final void remove() { throw new UnsupportedOperationException(); } public final Iterator<T> iterator() {
/* 34 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\m\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */