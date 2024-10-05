/*    */ package com.badlogic.gdx.utils;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Sort
/*    */ {
/*    */   private static Sort instance;
/*    */   private TimSort timSort;
/*    */   private ComparableTimSort comparableTimSort;
/*    */   
/*    */   public <T extends Comparable> void sort(Array<T> paramArray) {
/* 31 */     if (this.comparableTimSort == null) this.comparableTimSort = new ComparableTimSort(); 
/* 32 */     this.comparableTimSort.doSort((Object[])paramArray.items, 0, paramArray.size);
/*    */   }
/*    */ 
/*    */   
/*    */   public void sort(Object[] paramArrayOfObject) {
/* 37 */     if (this.comparableTimSort == null) this.comparableTimSort = new ComparableTimSort(); 
/* 38 */     this.comparableTimSort.doSort(paramArrayOfObject, 0, paramArrayOfObject.length);
/*    */   }
/*    */ 
/*    */   
/*    */   public void sort(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 43 */     if (this.comparableTimSort == null) this.comparableTimSort = new ComparableTimSort(); 
/* 44 */     this.comparableTimSort.doSort(paramArrayOfObject, paramInt1, paramInt2);
/*    */   }
/*    */   
/*    */   public <T> void sort(Array<T> paramArray, Comparator<? super T> paramComparator) {
/* 48 */     if (this.timSort == null) this.timSort = new TimSort(); 
/* 49 */     this.timSort.doSort(paramArray.items, (Comparator)paramComparator, 0, paramArray.size);
/*    */   }
/*    */   
/*    */   public <T> void sort(T[] paramArrayOfT, Comparator<? super T> paramComparator) {
/* 53 */     if (this.timSort == null) this.timSort = new TimSort(); 
/* 54 */     this.timSort.doSort(paramArrayOfT, (Comparator)paramComparator, 0, paramArrayOfT.length);
/*    */   }
/*    */   
/*    */   public <T> void sort(T[] paramArrayOfT, Comparator<? super T> paramComparator, int paramInt1, int paramInt2) {
/* 58 */     if (this.timSort == null) this.timSort = new TimSort(); 
/* 59 */     this.timSort.doSort(paramArrayOfT, (Comparator)paramComparator, paramInt1, paramInt2);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Sort instance() {
/* 64 */     if (instance == null) instance = new Sort(); 
/* 65 */     return instance;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Sort.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */