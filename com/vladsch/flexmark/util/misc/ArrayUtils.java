/*     */ package com.vladsch.flexmark.util.misc;
/*     */ 
/*     */ import java.lang.reflect.Array;
/*     */ import java.util.BitSet;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Predicate;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrayUtils
/*     */ {
/*     */   public static <T> boolean contained(T paramT, T[] paramArrayOfT) {
/*  13 */     return (indexOf(paramT, paramArrayOfT) != -1);
/*     */   }
/*     */   
/*     */   @SafeVarargs
/*     */   public static <T> T[] append(Class<T> paramClass, T[] paramArrayOfT1, T... paramVarArgs1) {
/*  18 */     if (paramVarArgs1.length > 0) {
/*     */       
/*  20 */       Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, paramArrayOfT1.length + paramVarArgs1.length);
/*  21 */       System.arraycopy(paramArrayOfT1, 0, arrayOfObject, 0, paramArrayOfT1.length);
/*  22 */       System.arraycopy(paramVarArgs1, 0, arrayOfObject, paramArrayOfT1.length, paramVarArgs1.length);
/*  23 */       return (T[])arrayOfObject;
/*     */     } 
/*  25 */     return paramArrayOfT1;
/*     */   } public static boolean contained(int paramInt, int[] paramArrayOfint) {
/*     */     int i;
/*     */     byte b;
/*  29 */     for (i = (paramArrayOfint = paramArrayOfint).length, b = 0; b < i; b++) {
/*  30 */       int j; if ((j = paramArrayOfint[b]) == paramInt) return true; 
/*     */     } 
/*  32 */     return false;
/*     */   }
/*     */   public static <T> T firstOf(T[] paramArrayOfT, Predicate<? super T> paramPredicate) {
/*  35 */     return firstOf(paramArrayOfT, 0, paramArrayOfT.length, paramPredicate);
/*     */   } public static <T> T firstOf(T[] paramArrayOfT, int paramInt, Predicate<? super T> paramPredicate) {
/*  37 */     return firstOf(paramArrayOfT, paramInt, paramArrayOfT.length, paramPredicate);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T> T firstOf(T[] paramArrayOfT, int paramInt1, int paramInt2, Predicate<? super T> paramPredicate) {
/*  42 */     return ((paramInt1 = indexOf(paramArrayOfT, paramInt1, paramInt2, paramPredicate)) == -1) ? null : paramArrayOfT[paramInt1];
/*     */   }
/*     */   public static <T> int indexOf(T paramT, T[] paramArrayOfT) {
/*  45 */     return indexOf(paramT, paramArrayOfT, 0, paramArrayOfT.length);
/*     */   } public static <T> int indexOf(T paramT, T[] paramArrayOfT, int paramInt) {
/*  47 */     return indexOf(paramT, paramArrayOfT, paramInt, paramArrayOfT.length);
/*     */   }
/*     */   public static <T> int indexOf(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2) {
/*  50 */     return indexOf(paramArrayOfT, paramInt1, paramInt2, paramObject2 -> Objects.equals(paramObject1, paramObject2));
/*     */   }
/*     */   public static <T> int indexOf(T[] paramArrayOfT, Predicate<? super T> paramPredicate) {
/*  53 */     return indexOf(paramArrayOfT, 0, paramArrayOfT.length, paramPredicate);
/*     */   } public static <T> int indexOf(T[] paramArrayOfT, int paramInt, Predicate<? super T> paramPredicate) {
/*  55 */     return indexOf(paramArrayOfT, paramInt, paramArrayOfT.length, paramPredicate);
/*     */   }
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
/*     */   public static <T> int indexOf(T[] paramArrayOfT, int paramInt1, int paramInt2, Predicate<? super T> paramPredicate) {
/*  76 */     int i = paramArrayOfT.length;
/*  77 */     if (paramInt2 > 0) {
/*  78 */       if (paramInt1 < 0) paramInt1 = 0; 
/*  79 */       if (paramInt2 > i) paramInt2 = i;
/*     */       
/*  81 */       if (paramInt1 < paramInt2)
/*  82 */         for (paramInt1 = paramInt1; paramInt1 < paramInt2; paramInt1++) {
/*  83 */           if (paramPredicate.test(paramArrayOfT[paramInt1])) return paramInt1;
/*     */         
/*     */         }  
/*     */     } 
/*  87 */     return -1;
/*     */   }
/*     */   public static <T> T lastOf(T[] paramArrayOfT, Predicate<? super T> paramPredicate) {
/*  90 */     return lastOf(paramArrayOfT, 0, paramArrayOfT.length, paramPredicate);
/*     */   } public static <T> T lastOf(T[] paramArrayOfT, int paramInt, Predicate<? super T> paramPredicate) {
/*  92 */     return lastOf(paramArrayOfT, 0, paramInt, paramPredicate);
/*     */   }
/*     */   
/*     */   public static <T> T lastOf(T[] paramArrayOfT, int paramInt1, int paramInt2, Predicate<? super T> paramPredicate) {
/*  96 */     return ((paramInt1 = lastIndexOf(paramArrayOfT, paramInt1, paramInt2, paramPredicate)) == -1) ? null : paramArrayOfT[paramInt1];
/*     */   }
/*     */   public static <T> int lastIndexOf(T paramT, T[] paramArrayOfT) {
/*  99 */     return lastIndexOf(paramT, paramArrayOfT, 0, paramArrayOfT.length);
/*     */   } public static <T> int lastIndexOf(T paramT, T[] paramArrayOfT, int paramInt) {
/* 101 */     return lastIndexOf(paramT, paramArrayOfT, 0, paramInt);
/*     */   }
/*     */   public static <T> int lastIndexOf(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2) {
/* 104 */     return lastIndexOf(paramArrayOfT, paramInt1, paramInt2, paramObject2 -> Objects.equals(paramObject1, paramObject2));
/*     */   }
/*     */   public static <T> int lastIndexOf(T[] paramArrayOfT, Predicate<? super T> paramPredicate) {
/* 107 */     return lastIndexOf(paramArrayOfT, 0, paramArrayOfT.length, paramPredicate);
/*     */   } public static <T> int lastIndexOf(T[] paramArrayOfT, int paramInt, Predicate<? super T> paramPredicate) {
/* 109 */     return lastIndexOf(paramArrayOfT, 0, paramInt, paramPredicate);
/*     */   }
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
/*     */   public static <T> int lastIndexOf(T[] paramArrayOfT, int paramInt1, int paramInt2, Predicate<? super T> paramPredicate) {
/* 132 */     int i = paramArrayOfT.length;
/* 133 */     if (paramInt2 >= 0) {
/* 134 */       if (paramInt1 < 0) paramInt1 = 0; 
/* 135 */       if (paramInt2 >= i) paramInt2 = i - 1;
/*     */       
/* 137 */       if (paramInt1 < paramInt2)
/* 138 */         for (paramInt2 = paramInt2; paramInt2 >= paramInt1; paramInt2--) {
/* 139 */           if (paramPredicate.test(paramArrayOfT[paramInt2])) return paramInt2;
/*     */         
/*     */         }  
/*     */     } 
/* 143 */     return -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int[] toArray(BitSet paramBitSet) {
/* 148 */     int i, arrayOfInt[] = new int[i = paramBitSet.cardinality()];
/*     */     
/* 150 */     int j = paramBitSet.length();
/* 151 */     while (j >= 0 && (
/*     */       
/* 153 */       j = paramBitSet.previousSetBit(j - 1)) >= 0)
/*     */     {
/* 155 */       arrayOfInt[--i] = j;
/*     */     }
/* 157 */     assert i == 0;
/* 158 */     return arrayOfInt;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\vladsch\flexmar\\util\misc\ArrayUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */