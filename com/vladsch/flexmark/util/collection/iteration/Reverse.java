/*    */ package com.vladsch.flexmark.util.collection.iteration;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Reverse<T>
/*    */   implements ReversibleIterable<T>
/*    */ {
/*    */   private final List<T> list;
/*    */   private final boolean isReversed;
/*    */   
/*    */   public Reverse(List<T> paramList) {
/* 13 */     this(paramList, true);
/*    */   }
/*    */   
/*    */   public Reverse(List<T> paramList, boolean paramBoolean) {
/* 17 */     this.list = paramList;
/* 18 */     this.isReversed = paramBoolean;
/*    */   }
/*    */   
/*    */   static class ReversedListIterator<T> implements ReversibleIterator<T> {
/*    */     private final List<T> list;
/*    */     private final boolean isReversed;
/*    */     private int index;
/*    */     
/*    */     ReversedListIterator(List<T> param1List, boolean param1Boolean) {
/* 27 */       this.list = param1List;
/* 28 */       this.isReversed = param1Boolean;
/* 29 */       if (param1Boolean) {
/* 30 */         this.index = (param1List.size() == 0) ? -1 : (param1List.size() - 1); return;
/*    */       } 
/* 32 */       this.index = (param1List.size() == 0) ? -1 : 0;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean isReversed() {
/* 38 */       return this.isReversed;
/*    */     }
/*    */ 
/*    */ 
/*    */     
/*    */     public void remove() {}
/*    */ 
/*    */ 
/*    */     
/*    */     public boolean hasNext() {
/* 48 */       return (this.index != -1);
/*    */     }
/*    */ 
/*    */     
/*    */     public T next() {
/* 53 */       T t = this.list.get(this.index);
/* 54 */       if (this.index != -1) {
/* 55 */         if (this.isReversed) {
/* 56 */           this.index--;
/*    */         }
/* 58 */         else if (this.index == this.list.size() - 1) {
/* 59 */           this.index = -1;
/*    */         } else {
/* 61 */           this.index++;
/*    */         } 
/*    */       }
/*    */ 
/*    */       
/* 66 */       return t;
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterator<T> iterator() {
/* 73 */     return new ReversedListIterator<>(this.list, this.isReversed);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterable<T> reversed() {
/* 79 */     return new Reverse(this.list, !this.isReversed);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isReversed() {
/* 84 */     return this.isReversed;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ReversibleIterator<T> reversedIterator() {
/* 90 */     return new ReversedListIterator<>(this.list, !this.isReversed);
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\collection\iteration\Reverse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */