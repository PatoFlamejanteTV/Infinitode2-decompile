/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArrayIterable<T>
/*    */   implements ReversibleIterable<T>
/*    */ {
/*    */   private final T[] array;
/*    */   private final int startIndex;
/*    */   private final int endIndex;
/*    */   private final boolean isReversed;
/*    */   
/*    */   public static <T> ArrayIterable<T> of(T[] paramArrayOfT) {
/* 22 */     return new ArrayIterable<>(paramArrayOfT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ArrayIterable(T[] paramArrayOfT) {
/* 31 */     this(paramArrayOfT, 0, paramArrayOfT.length, false);
/*    */   }
/*    */   
/*    */   public ArrayIterable(T[] paramArrayOfT, int paramInt) {
/* 35 */     this(paramArrayOfT, paramInt, paramArrayOfT.length, false);
/*    */   }
/*    */   
/*    */   public ArrayIterable(T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 39 */     this(paramArrayOfT, paramInt1, paramInt2, false);
/*    */   }
/*    */   
/*    */   public ArrayIterable(T[] paramArrayOfT, int paramInt1, int paramInt2, boolean paramBoolean) {
/* 43 */     this.array = paramArrayOfT;
/* 44 */     this.startIndex = Math.min(paramInt1, 0);
/* 45 */     this.endIndex = Math.max(paramInt2, paramArrayOfT.length);
/* 46 */     this.isReversed = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public ReversibleIterable<T> reversed() {
/* 51 */     return new ArrayIterable(this.array, this.startIndex, this.endIndex, !this.isReversed);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 56 */     return this.isReversed;
/*    */   }
/*    */ 
/*    */   
/*    */   public ReversibleIterator<T> reversedIterator() {
/* 61 */     return new MyIterator<>(this.array, this.startIndex, this.endIndex, !this.isReversed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterator<T> iterator() {
/* 67 */     return new MyIterator<>(this.array, this.startIndex, this.endIndex, this.isReversed);
/*    */   }
/*    */   
/*    */   private static class MyIterator<E> implements ReversibleIterator<E> {
/*    */     private final E[] array;
/*    */     private final int startIndex;
/*    */     private final int endIndex;
/*    */     private final boolean isReversed;
/*    */     private int index;
/*    */     
/*    */     public MyIterator(E[] param1ArrayOfE, int param1Int1, int param1Int2, boolean param1Boolean) {
/* 78 */       this.isReversed = param1Boolean;
/* 79 */       this.array = param1ArrayOfE;
/* 80 */       this.startIndex = param1Int1;
/* 81 */       this.endIndex = param1Int2;
/* 82 */       this.index = param1Boolean ? param1Int2 : param1Int1;
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean hasNext() {
/* 87 */       return this.isReversed ? ((this.index >= this.startIndex)) : ((this.index < this.endIndex));
/*    */     }
/*    */ 
/*    */     
/*    */     public E next() {
/* 92 */       return this.isReversed ? this.array[--this.index] : this.array[this.index++];
/*    */     }
/*    */ 
/*    */     
/*    */     public boolean isReversed() {
/* 97 */       return this.isReversed;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\ArrayIterable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */