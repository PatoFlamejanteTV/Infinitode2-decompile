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
/*    */ public class QuickSelect<T>
/*    */ {
/*    */   private T[] array;
/*    */   private Comparator<? super T> comp;
/*    */   
/*    */   public int select(T[] paramArrayOfT, Comparator<T> paramComparator, int paramInt1, int paramInt2) {
/* 30 */     this.array = paramArrayOfT;
/* 31 */     this.comp = paramComparator;
/* 32 */     return recursiveSelect(0, paramInt2 - 1, paramInt1);
/*    */   }
/*    */   
/*    */   private int partition(int paramInt1, int paramInt2, int paramInt3) {
/* 36 */     T t = this.array[paramInt3];
/* 37 */     swap(paramInt2, paramInt3);
/* 38 */     paramInt3 = paramInt1;
/* 39 */     for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/* 40 */       if (this.comp.compare(this.array[paramInt1], t) < 0) {
/* 41 */         swap(paramInt3, paramInt1);
/* 42 */         paramInt3++;
/*    */       } 
/*    */     } 
/* 45 */     swap(paramInt2, paramInt3);
/* 46 */     return paramInt3;
/*    */   }
/*    */   
/*    */   private int recursiveSelect(int paramInt1, int paramInt2, int paramInt3) {
/* 50 */     if (paramInt1 == paramInt2) return paramInt1; 
/* 51 */     int i = medianOfThreePivot(paramInt1, paramInt2);
/*    */     
/*    */     int j;
/*    */     
/* 55 */     if ((j = (i = partition(paramInt1, paramInt2, i)) - paramInt1 + 1) == paramInt3) {
/* 56 */       paramInt1 = i;
/* 57 */     } else if (paramInt3 < j) {
/* 58 */       paramInt1 = recursiveSelect(paramInt1, i - 1, paramInt3);
/*    */     } else {
/* 60 */       paramInt1 = recursiveSelect(i + 1, paramInt2, paramInt3 - j);
/*    */     } 
/* 62 */     return paramInt1;
/*    */   }
/*    */ 
/*    */   
/*    */   private int medianOfThreePivot(int paramInt1, int paramInt2) {
/* 67 */     T t1 = this.array[paramInt1];
/* 68 */     int i = (paramInt1 + paramInt2) / 2;
/* 69 */     T t2 = this.array[i];
/* 70 */     T t3 = this.array[paramInt2];
/*    */ 
/*    */ 
/*    */     
/* 74 */     if (this.comp.compare(t1, t2) > 0) {
/* 75 */       if (this.comp.compare(t2, t3) > 0)
/* 76 */         return i; 
/* 77 */       if (this.comp.compare(t1, t3) > 0) {
/* 78 */         return paramInt2;
/*    */       }
/* 80 */       return paramInt1;
/*    */     } 
/*    */     
/* 83 */     if (this.comp.compare(t1, t3) > 0)
/* 84 */       return paramInt1; 
/* 85 */     if (this.comp.compare(t2, t3) > 0) {
/* 86 */       return paramInt2;
/*    */     }
/* 88 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void swap(int paramInt1, int paramInt2) {
/* 94 */     T t = this.array[paramInt1];
/* 95 */     this.array[paramInt1] = this.array[paramInt2];
/* 96 */     this.array[paramInt2] = t;
/*    */   }
/*    */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\QuickSelect.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */