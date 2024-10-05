/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Comparator;
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
/*     */ public class DelayedRemovalArray<T>
/*     */   extends Array<T>
/*     */ {
/*     */   private int iterating;
/*  34 */   private IntArray remove = new IntArray(0);
/*     */   
/*     */   private int clear;
/*     */ 
/*     */   
/*     */   public DelayedRemovalArray() {}
/*     */   
/*     */   public DelayedRemovalArray(Array<? extends T> paramArray) {
/*  42 */     super(paramArray);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray(boolean paramBoolean, int paramInt, Class paramClass) {
/*  46 */     super(paramBoolean, paramInt, paramClass);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray(boolean paramBoolean, int paramInt) {
/*  50 */     super(paramBoolean, paramInt);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray(boolean paramBoolean, T[] paramArrayOfT, int paramInt1, int paramInt2) {
/*  54 */     super(paramBoolean, paramArrayOfT, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray(Class paramClass) {
/*  58 */     super(paramClass);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray(int paramInt) {
/*  62 */     super(paramInt);
/*     */   }
/*     */   
/*     */   public DelayedRemovalArray(T[] paramArrayOfT) {
/*  66 */     super(paramArrayOfT);
/*     */   }
/*     */   
/*     */   public void begin() {
/*  70 */     this.iterating++;
/*     */   }
/*     */   
/*     */   public void end() {
/*  74 */     if (this.iterating == 0) throw new IllegalStateException("begin must be called before end."); 
/*  75 */     this.iterating--;
/*  76 */     if (this.iterating == 0) {
/*  77 */       if (this.clear > 0 && this.clear == this.size) {
/*  78 */         this.remove.clear();
/*  79 */         clear();
/*     */       } else {
/*  81 */         int i; int j; for (i = 0, j = this.remove.size; i < j; i++) {
/*     */           int k;
/*  83 */           if ((k = this.remove.pop()) >= this.clear) removeIndex(k); 
/*     */         } 
/*  85 */         for (i = this.clear - 1; i >= 0; i--)
/*  86 */           removeIndex(i); 
/*     */       } 
/*  88 */       this.clear = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void remove(int paramInt) {
/*  93 */     if (paramInt < this.clear)
/*  94 */       return;  byte b; int i; for (b = 0, i = this.remove.size; b < i; b++) {
/*  95 */       int j = this.remove.get(b);
/*  96 */       if (paramInt == j)
/*  97 */         return;  if (paramInt < j) {
/*  98 */         this.remove.insert(b, paramInt);
/*     */         return;
/*     */       } 
/*     */     } 
/* 102 */     this.remove.add(paramInt);
/*     */   }
/*     */   public boolean removeValue(T paramT, boolean paramBoolean) {
/*     */     int i;
/* 106 */     if (this.iterating > 0) {
/*     */       
/* 108 */       if ((i = indexOf(paramT, paramBoolean)) == -1) return false; 
/* 109 */       remove(i);
/* 110 */       return true;
/*     */     } 
/* 112 */     return super.removeValue(i, paramBoolean);
/*     */   }
/*     */   
/*     */   public T removeIndex(int paramInt) {
/* 116 */     if (this.iterating > 0) {
/* 117 */       remove(paramInt);
/* 118 */       return get(paramInt);
/*     */     } 
/* 120 */     return super.removeIndex(paramInt);
/*     */   }
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 124 */     if (this.iterating > 0) {
/* 125 */       for (paramInt2 = paramInt2; paramInt2 >= paramInt1; paramInt2--)
/* 126 */         remove(paramInt2);  return;
/*     */     } 
/* 128 */     super.removeRange(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void clear() {
/* 132 */     if (this.iterating > 0) {
/* 133 */       this.clear = this.size;
/*     */       return;
/*     */     } 
/* 136 */     super.clear();
/*     */   }
/*     */   
/*     */   public void set(int paramInt, T paramT) {
/* 140 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 141 */     super.set(paramInt, paramT);
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, T paramT) {
/* 145 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 146 */     super.insert(paramInt, paramT);
/*     */   }
/*     */   
/*     */   public void insertRange(int paramInt1, int paramInt2) {
/* 150 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 151 */     super.insertRange(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 155 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 156 */     super.swap(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public T pop() {
/* 160 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 161 */     return super.pop();
/*     */   }
/*     */   
/*     */   public void sort() {
/* 165 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 166 */     super.sort();
/*     */   }
/*     */   
/*     */   public void sort(Comparator<? super T> paramComparator) {
/* 170 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 171 */     super.sort(paramComparator);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 175 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 176 */     super.reverse();
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 180 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 181 */     super.shuffle();
/*     */   }
/*     */   
/*     */   public void truncate(int paramInt) {
/* 185 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 186 */     super.truncate(paramInt);
/*     */   }
/*     */   
/*     */   public T[] setSize(int paramInt) {
/* 190 */     if (this.iterating > 0) throw new IllegalStateException("Invalid between begin/end."); 
/* 191 */     return super.setSize(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> DelayedRemovalArray<T> with(T... paramVarArgs) {
/* 196 */     return new DelayedRemovalArray<>(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\DelayedRemovalArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */