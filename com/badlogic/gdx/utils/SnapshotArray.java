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
/*     */ public class SnapshotArray<T>
/*     */   extends Array<T>
/*     */ {
/*     */   private T[] snapshot;
/*     */   private T[] recycled;
/*     */   private int snapshots;
/*     */   
/*     */   public SnapshotArray() {}
/*     */   
/*     */   public SnapshotArray(Array<? extends T> paramArray) {
/*  52 */     super(paramArray);
/*     */   }
/*     */   
/*     */   public SnapshotArray(boolean paramBoolean, int paramInt, Class paramClass) {
/*  56 */     super(paramBoolean, paramInt, paramClass);
/*     */   }
/*     */   
/*     */   public SnapshotArray(boolean paramBoolean, int paramInt) {
/*  60 */     super(paramBoolean, paramInt);
/*     */   }
/*     */   
/*     */   public SnapshotArray(boolean paramBoolean, T[] paramArrayOfT, int paramInt1, int paramInt2) {
/*  64 */     super(paramBoolean, paramArrayOfT, paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public SnapshotArray(Class paramClass) {
/*  68 */     super(paramClass);
/*     */   }
/*     */   
/*     */   public SnapshotArray(int paramInt) {
/*  72 */     super(paramInt);
/*     */   }
/*     */   
/*     */   public SnapshotArray(T[] paramArrayOfT) {
/*  76 */     super(paramArrayOfT);
/*     */   }
/*     */ 
/*     */   
/*     */   public T[] begin() {
/*  81 */     modified();
/*  82 */     this.snapshot = this.items;
/*  83 */     this.snapshots++;
/*  84 */     return this.items;
/*     */   }
/*     */ 
/*     */   
/*     */   public void end() {
/*  89 */     this.snapshots = Math.max(0, this.snapshots - 1);
/*  90 */     if (this.snapshot == null)
/*  91 */       return;  if (this.snapshot != this.items && this.snapshots == 0) {
/*     */       
/*  93 */       this.recycled = this.snapshot; byte b; int i;
/*  94 */       for (b = 0, i = this.recycled.length; b < i; b++)
/*  95 */         this.recycled[b] = null; 
/*     */     } 
/*  97 */     this.snapshot = null;
/*     */   }
/*     */   
/*     */   private void modified() {
/* 101 */     if (this.snapshot == null || this.snapshot != this.items)
/*     */       return; 
/* 103 */     if (this.recycled != null && this.recycled.length >= this.size) {
/* 104 */       System.arraycopy(this.items, 0, this.recycled, 0, this.size);
/* 105 */       this.items = this.recycled;
/* 106 */       this.recycled = null; return;
/*     */     } 
/* 108 */     resize(this.items.length);
/*     */   }
/*     */   
/*     */   public void set(int paramInt, T paramT) {
/* 112 */     modified();
/* 113 */     super.set(paramInt, paramT);
/*     */   }
/*     */   
/*     */   public void insert(int paramInt, T paramT) {
/* 117 */     modified();
/* 118 */     super.insert(paramInt, paramT);
/*     */   }
/*     */   
/*     */   public void insertRange(int paramInt1, int paramInt2) {
/* 122 */     modified();
/* 123 */     super.insertRange(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public void swap(int paramInt1, int paramInt2) {
/* 127 */     modified();
/* 128 */     super.swap(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean removeValue(T paramT, boolean paramBoolean) {
/* 132 */     modified();
/* 133 */     return super.removeValue(paramT, paramBoolean);
/*     */   }
/*     */   
/*     */   public T removeIndex(int paramInt) {
/* 137 */     modified();
/* 138 */     return super.removeIndex(paramInt);
/*     */   }
/*     */   
/*     */   public void removeRange(int paramInt1, int paramInt2) {
/* 142 */     modified();
/* 143 */     super.removeRange(paramInt1, paramInt2);
/*     */   }
/*     */   
/*     */   public boolean removeAll(Array<? extends T> paramArray, boolean paramBoolean) {
/* 147 */     modified();
/* 148 */     return super.removeAll(paramArray, paramBoolean);
/*     */   }
/*     */   
/*     */   public T pop() {
/* 152 */     modified();
/* 153 */     return super.pop();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 157 */     modified();
/* 158 */     super.clear();
/*     */   }
/*     */   
/*     */   public void sort() {
/* 162 */     modified();
/* 163 */     super.sort();
/*     */   }
/*     */   
/*     */   public void sort(Comparator<? super T> paramComparator) {
/* 167 */     modified();
/* 168 */     super.sort(paramComparator);
/*     */   }
/*     */   
/*     */   public void reverse() {
/* 172 */     modified();
/* 173 */     super.reverse();
/*     */   }
/*     */   
/*     */   public void shuffle() {
/* 177 */     modified();
/* 178 */     super.shuffle();
/*     */   }
/*     */   
/*     */   public void truncate(int paramInt) {
/* 182 */     modified();
/* 183 */     super.truncate(paramInt);
/*     */   }
/*     */   
/*     */   public T[] setSize(int paramInt) {
/* 187 */     modified();
/* 188 */     return super.setSize(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> SnapshotArray<T> with(T... paramVarArgs) {
/* 193 */     return new SnapshotArray<>(paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\SnapshotArray.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */