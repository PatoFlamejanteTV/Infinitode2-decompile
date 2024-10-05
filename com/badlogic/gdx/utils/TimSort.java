/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ class TimSort<T>
/*     */ {
/*     */   private static final int MIN_MERGE = 32;
/*     */   private T[] a;
/*     */   private Comparator<? super T> c;
/*     */   private static final int MIN_GALLOP = 7;
/*  64 */   private int minGallop = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private T[] tmp;
/*     */ 
/*     */ 
/*     */   
/*     */   private int tmpCount;
/*     */ 
/*     */ 
/*     */   
/*  82 */   private int stackSize = 0;
/*     */   
/*     */   private final int[] runBase;
/*     */   
/*     */   private final int[] runLen;
/*     */   
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */   TimSort() {
/*  91 */     this.tmp = (T[])new Object[256];
/*  92 */     this.runBase = new int[40];
/*  93 */     this.runLen = new int[40];
/*     */   }
/*     */   public void doSort(T[] paramArrayOfT, Comparator<T> paramComparator, int paramInt1, int paramInt2) {
/*     */     int m;
/*  97 */     this.stackSize = 0;
/*  98 */     rangeCheck(paramArrayOfT.length, paramInt1, paramInt2);
/*     */     int j;
/* 100 */     if ((j = paramInt2 - paramInt1) < 2) {
/*     */       return;
/*     */     }
/* 103 */     if (j < 32) {
/* 104 */       int n = countRunAndMakeAscending(paramArrayOfT, paramInt1, paramInt2, paramComparator);
/* 105 */       binarySort(paramArrayOfT, paramInt1, paramInt2, paramInt1 + n, paramComparator);
/*     */       
/*     */       return;
/*     */     } 
/* 109 */     this.a = paramArrayOfT;
/* 110 */     this.c = paramComparator;
/* 111 */     this.tmpCount = 0;
/*     */ 
/*     */ 
/*     */     
/* 115 */     int k = minRunLength(j);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 121 */       if ((m = countRunAndMakeAscending(paramArrayOfT, paramInt1, paramInt2, paramComparator)) >= k)
/* 122 */         continue;  int n = (j <= k) ? j : k;
/* 123 */       binarySort(paramArrayOfT, paramInt1, paramInt1 + n, paramInt1 + m, paramComparator);
/* 124 */       m = n;
/*     */ 
/*     */ 
/*     */       
/* 128 */       pushRun(paramInt1, m);
/* 129 */       mergeCollapse();
/*     */ 
/*     */       
/* 132 */       paramInt1 += m;
/*     */     }
/* 134 */     while ((j = j - m) != 0);
/*     */ 
/*     */ 
/*     */     
/* 138 */     mergeForceCollapse();
/*     */ 
/*     */     
/* 141 */     this.a = null;
/* 142 */     this.c = null;
/* 143 */     T[] arrayOfT = this.tmp; int i; byte b;
/* 144 */     for (b = 0, i = this.tmpCount; b < i; b++) {
/* 145 */       arrayOfT[b] = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TimSort(T[] paramArrayOfT, Comparator<? super T> paramComparator) {
/* 153 */     this.a = paramArrayOfT;
/* 154 */     this.c = paramComparator;
/*     */     
/*     */     int i;
/*     */     
/* 158 */     Object[] arrayOfObject = new Object[((i = paramArrayOfT.length) < 512) ? (i >>> 1) : 256];
/* 159 */     this.tmp = (T[])arrayOfObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     i = (i < 120) ? 5 : ((i < 1542) ? 10 : ((i < 119151) ? 19 : 40));
/* 169 */     this.runBase = new int[i];
/* 170 */     this.runLen = new int[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static <T> void sort(T[] paramArrayOfT, Comparator<? super T> paramComparator) {
/* 179 */     sort(paramArrayOfT, 0, paramArrayOfT.length, paramComparator);
/*     */   }
/*     */   static <T> void sort(T[] paramArrayOfT, int paramInt1, int paramInt2, Comparator<? super T> paramComparator) {
/*     */     int k;
/* 183 */     if (paramComparator == null) {
/* 184 */       Arrays.sort((Object[])paramArrayOfT, paramInt1, paramInt2);
/*     */       
/*     */       return;
/*     */     } 
/* 188 */     rangeCheck(paramArrayOfT.length, paramInt1, paramInt2);
/*     */     int i;
/* 190 */     if ((i = paramInt2 - paramInt1) < 2) {
/*     */       return;
/*     */     }
/* 193 */     if (i < 32) {
/* 194 */       int m = countRunAndMakeAscending(paramArrayOfT, paramInt1, paramInt2, paramComparator);
/* 195 */       binarySort(paramArrayOfT, paramInt1, paramInt2, paramInt1 + m, paramComparator);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 201 */     TimSort<T> timSort = new TimSort<>(paramArrayOfT, paramComparator);
/* 202 */     int j = minRunLength(i);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 208 */       if ((k = countRunAndMakeAscending(paramArrayOfT, paramInt1, paramInt2, paramComparator)) >= j)
/* 209 */         continue;  int m = (i <= j) ? i : j;
/* 210 */       binarySort(paramArrayOfT, paramInt1, paramInt1 + m, paramInt1 + k, paramComparator);
/* 211 */       k = m;
/*     */ 
/*     */ 
/*     */       
/* 215 */       timSort.pushRun(paramInt1, k);
/* 216 */       timSort.mergeCollapse();
/*     */ 
/*     */       
/* 219 */       paramInt1 += k;
/*     */     }
/* 221 */     while ((i = i - k) != 0);
/*     */ 
/*     */ 
/*     */     
/* 225 */     timSort.mergeForceCollapse();
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
/*     */   private static <T> void binarySort(T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3, Comparator<? super T> paramComparator) {
/* 243 */     if (paramInt3 == paramInt1) paramInt3++; 
/* 244 */     for (; paramInt3 < paramInt2; paramInt3++) {
/* 245 */       T t = paramArrayOfT[paramInt3];
/*     */ 
/*     */       
/* 248 */       int i = paramInt1;
/* 249 */       int j = paramInt3;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 254 */       while (i < j) {
/* 255 */         int m = i + j >>> 1;
/* 256 */         if (paramComparator.compare(t, paramArrayOfT[m]) < 0) {
/* 257 */           j = m; continue;
/*     */         } 
/* 259 */         i = m + 1;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       int k;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 270 */       switch (k = paramInt3 - i) {
/*     */         case 2:
/* 272 */           paramArrayOfT[i + 2] = paramArrayOfT[i + 1];
/*     */         case 1:
/* 274 */           paramArrayOfT[i + 1] = paramArrayOfT[i];
/*     */           break;
/*     */         default:
/* 277 */           System.arraycopy(paramArrayOfT, i, paramArrayOfT, i + 1, k); break;
/*     */       } 
/* 279 */       paramArrayOfT[i] = t;
/*     */     } 
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
/*     */   
/*     */   private static <T> int countRunAndMakeAscending(T[] paramArrayOfT, int paramInt1, int paramInt2, Comparator<? super T> paramComparator) {
/*     */     int i;
/* 305 */     if ((i = paramInt1 + 1) == paramInt2) return 1;
/*     */ 
/*     */     
/* 308 */     if (paramComparator.compare(paramArrayOfT[i++], paramArrayOfT[paramInt1]) < 0) {
/* 309 */       while (i < paramInt2 && paramComparator.compare(paramArrayOfT[i], paramArrayOfT[i - 1]) < 0)
/* 310 */         i++; 
/* 311 */       reverseRange((Object[])paramArrayOfT, paramInt1, i);
/*     */     } else {
/* 313 */       while (i < paramInt2 && paramComparator.compare(paramArrayOfT[i], paramArrayOfT[i - 1]) >= 0) {
/* 314 */         i++;
/*     */       }
/*     */     } 
/* 317 */     return i - paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void reverseRange(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 326 */     paramInt2--;
/* 327 */     while (paramInt1 < paramInt2) {
/* 328 */       Object object = paramArrayOfObject[paramInt1];
/* 329 */       paramArrayOfObject[paramInt1++] = paramArrayOfObject[paramInt2];
/* 330 */       paramArrayOfObject[paramInt2--] = object;
/*     */     } 
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
/*     */   private static int minRunLength(int paramInt) {
/* 349 */     int i = 0;
/* 350 */     while (paramInt >= 32) {
/* 351 */       i |= paramInt & 0x1;
/* 352 */       paramInt >>= 1;
/*     */     } 
/* 354 */     return paramInt + i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushRun(int paramInt1, int paramInt2) {
/* 362 */     this.runBase[this.stackSize] = paramInt1;
/* 363 */     this.runLen[this.stackSize] = paramInt2;
/* 364 */     this.stackSize++;
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
/*     */   private void mergeCollapse() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield stackSize : I
/*     */     //   4: iconst_1
/*     */     //   5: if_icmple -> 126
/*     */     //   8: aload_0
/*     */     //   9: getfield stackSize : I
/*     */     //   12: iconst_2
/*     */     //   13: isub
/*     */     //   14: dup
/*     */     //   15: istore_1
/*     */     //   16: ifle -> 45
/*     */     //   19: aload_0
/*     */     //   20: getfield runLen : [I
/*     */     //   23: iload_1
/*     */     //   24: iconst_1
/*     */     //   25: isub
/*     */     //   26: iaload
/*     */     //   27: aload_0
/*     */     //   28: getfield runLen : [I
/*     */     //   31: iload_1
/*     */     //   32: iaload
/*     */     //   33: aload_0
/*     */     //   34: getfield runLen : [I
/*     */     //   37: iload_1
/*     */     //   38: iconst_1
/*     */     //   39: iadd
/*     */     //   40: iaload
/*     */     //   41: iadd
/*     */     //   42: if_icmple -> 76
/*     */     //   45: iload_1
/*     */     //   46: iconst_2
/*     */     //   47: if_icmplt -> 101
/*     */     //   50: aload_0
/*     */     //   51: getfield runLen : [I
/*     */     //   54: iload_1
/*     */     //   55: iconst_2
/*     */     //   56: isub
/*     */     //   57: iaload
/*     */     //   58: aload_0
/*     */     //   59: getfield runLen : [I
/*     */     //   62: iload_1
/*     */     //   63: iaload
/*     */     //   64: aload_0
/*     */     //   65: getfield runLen : [I
/*     */     //   68: iload_1
/*     */     //   69: iconst_1
/*     */     //   70: isub
/*     */     //   71: iaload
/*     */     //   72: iadd
/*     */     //   73: if_icmpgt -> 101
/*     */     //   76: aload_0
/*     */     //   77: getfield runLen : [I
/*     */     //   80: iload_1
/*     */     //   81: iconst_1
/*     */     //   82: isub
/*     */     //   83: iaload
/*     */     //   84: aload_0
/*     */     //   85: getfield runLen : [I
/*     */     //   88: iload_1
/*     */     //   89: iconst_1
/*     */     //   90: iadd
/*     */     //   91: iaload
/*     */     //   92: if_icmpge -> 118
/*     */     //   95: iinc #1, -1
/*     */     //   98: goto -> 118
/*     */     //   101: aload_0
/*     */     //   102: getfield runLen : [I
/*     */     //   105: iload_1
/*     */     //   106: iaload
/*     */     //   107: aload_0
/*     */     //   108: getfield runLen : [I
/*     */     //   111: iload_1
/*     */     //   112: iconst_1
/*     */     //   113: iadd
/*     */     //   114: iaload
/*     */     //   115: if_icmpgt -> 126
/*     */     //   118: aload_0
/*     */     //   119: iload_1
/*     */     //   120: invokespecial mergeAt : (I)V
/*     */     //   123: goto -> 0
/*     */     //   126: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #380	-> 0
/*     */     //   #381	-> 8
/*     */     //   #382	-> 15
/*     */     //   #383	-> 76
/*     */     //   #384	-> 101
/*     */     //   #387	-> 118
/*     */     //   #388	-> 123
/*     */     //   #389	-> 126
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
/*     */   private void mergeForceCollapse() {
/* 393 */     while (this.stackSize > 1) {
/*     */       int i;
/* 395 */       if ((i = this.stackSize - 2) > 0 && this.runLen[i - 1] < this.runLen[i + 1]) i--; 
/* 396 */       mergeAt(i);
/*     */     } 
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
/*     */   private void mergeAt(int paramInt) {
/* 409 */     int i = this.runBase[paramInt];
/* 410 */     int j = this.runLen[paramInt];
/* 411 */     int k = this.runBase[paramInt + 1];
/* 412 */     int m = this.runLen[paramInt + 1];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 420 */     this.runLen[paramInt] = j + m;
/* 421 */     if (paramInt == this.stackSize - 3) {
/* 422 */       this.runBase[paramInt + 1] = this.runBase[paramInt + 2];
/* 423 */       this.runLen[paramInt + 1] = this.runLen[paramInt + 2];
/*     */     } 
/* 425 */     this.stackSize--;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 431 */     paramInt = gallopRight(this.a[k], this.a, i, j, 0, this.c);
/*     */     
/* 433 */     i += paramInt;
/*     */     
/* 435 */     if ((j = j - paramInt) == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 443 */     if ((m = gallopLeft(this.a[i + j - 1], this.a, k, m, m - 1, this.c)) == 0) {
/*     */       return;
/*     */     }
/* 446 */     if (j <= m) {
/* 447 */       mergeLo(i, j, k, m); return;
/*     */     } 
/* 449 */     mergeHi(i, j, k, m);
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
/*     */   private static <T> int gallopLeft(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3, Comparator<? super T> paramComparator) {
/* 467 */     int i = 0;
/* 468 */     int j = 1;
/* 469 */     if (paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt3]) > 0) {
/*     */       
/* 471 */       paramInt2 -= paramInt3;
/* 472 */       while (j < paramInt2 && paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt3 + j]) > 0) {
/* 473 */         i = j;
/*     */         
/* 475 */         if ((j = (j << 1) + 1) <= 0)
/* 476 */           j = paramInt2; 
/*     */       } 
/* 478 */       if (j > paramInt2) j = paramInt2;
/*     */ 
/*     */       
/* 481 */       i += paramInt3;
/* 482 */       j += paramInt3;
/*     */     } else {
/*     */       
/* 485 */       paramInt2 = paramInt3 + 1;
/* 486 */       while (j < paramInt2 && paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt3 - j]) <= 0) {
/* 487 */         i = j;
/*     */         
/* 489 */         if ((j = (j << 1) + 1) <= 0)
/* 490 */           j = paramInt2; 
/*     */       } 
/* 492 */       if (j > paramInt2) j = paramInt2;
/*     */ 
/*     */       
/* 495 */       paramInt2 = i;
/* 496 */       i = paramInt3 - j;
/* 497 */       j = paramInt3 - paramInt2;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 505 */     i++;
/* 506 */     while (i < j) {
/* 507 */       paramInt2 = i + (j - i >>> 1);
/*     */       
/* 509 */       if (paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt2]) > 0) {
/* 510 */         i = paramInt2 + 1; continue;
/*     */       } 
/* 512 */       j = paramInt2;
/*     */     } 
/*     */     
/* 515 */     return j;
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
/*     */   private static <T> int gallopRight(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3, Comparator<? super T> paramComparator) {
/* 532 */     int i = 1;
/* 533 */     int j = 0;
/* 534 */     if (paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt3]) < 0) {
/*     */       
/* 536 */       paramInt2 = paramInt3 + 1;
/* 537 */       while (i < paramInt2 && paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt3 - i]) < 0) {
/* 538 */         j = i;
/*     */         
/* 540 */         if ((i = (i << 1) + 1) <= 0)
/* 541 */           i = paramInt2; 
/*     */       } 
/* 543 */       if (i > paramInt2) i = paramInt2;
/*     */ 
/*     */       
/* 546 */       paramInt2 = j;
/* 547 */       j = paramInt3 - i;
/* 548 */       i = paramInt3 - paramInt2;
/*     */     } else {
/*     */       
/* 551 */       paramInt2 -= paramInt3;
/* 552 */       while (i < paramInt2 && paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt3 + i]) >= 0) {
/* 553 */         j = i;
/*     */         
/* 555 */         if ((i = (i << 1) + 1) <= 0)
/* 556 */           i = paramInt2; 
/*     */       } 
/* 558 */       if (i > paramInt2) i = paramInt2;
/*     */ 
/*     */       
/* 561 */       j += paramInt3;
/* 562 */       i += paramInt3;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 570 */     j++;
/* 571 */     while (j < i) {
/* 572 */       paramInt2 = j + (i - j >>> 1);
/*     */       
/* 574 */       if (paramComparator.compare(paramT, paramArrayOfT[paramInt1 + paramInt2]) < 0) {
/* 575 */         i = paramInt2; continue;
/*     */       } 
/* 577 */       j = paramInt2 + 1;
/*     */     } 
/*     */     
/* 580 */     return i;
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
/*     */   private void mergeLo(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 598 */     T[] arrayOfT1 = this.a;
/* 599 */     T[] arrayOfT2 = ensureCapacity(paramInt2);
/* 600 */     System.arraycopy(arrayOfT1, paramInt1, arrayOfT2, 0, paramInt2);
/*     */     
/* 602 */     int i = 0;
/* 603 */     int j = paramInt3;
/* 604 */     int k = paramInt1;
/*     */ 
/*     */     
/* 607 */     k++; j++; arrayOfT1[paramInt1] = arrayOfT1[paramInt3];
/* 608 */     if (--paramInt4 == 0) {
/* 609 */       System.arraycopy(arrayOfT2, 0, arrayOfT1, k, paramInt2);
/*     */       return;
/*     */     } 
/* 612 */     if (paramInt2 == 1) {
/* 613 */       System.arraycopy(arrayOfT1, j, arrayOfT1, k, paramInt4);
/* 614 */       arrayOfT1[k + paramInt4] = arrayOfT2[0];
/*     */       
/*     */       return;
/*     */     } 
/* 618 */     Comparator<? super T> comparator = this.c;
/* 619 */     paramInt3 = this.minGallop;
/*     */     
/*     */     while (true) {
/* 622 */       int m = 0;
/* 623 */       int n = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         while (true) {
/* 630 */           if (comparator.compare(arrayOfT1[j], arrayOfT2[i]) < 0) {
/* 631 */             arrayOfT1[k++] = arrayOfT1[j++];
/* 632 */             n++;
/* 633 */             m = 0;
/* 634 */             if (--paramInt4 == 0)
/*     */               // Byte code: goto -> 0  break;
/* 636 */           }  arrayOfT1[k++] = arrayOfT2[i++];
/* 637 */           m++;
/* 638 */           n = 0;
/* 639 */           if (--paramInt2 != 1)
/*     */             break;  // Byte code: goto -> 0
/* 641 */         }  if ((m | n) >= paramInt3)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 651 */           System.arraycopy(arrayOfT2, i, arrayOfT1, k, m);
/* 652 */           k += m;
/* 653 */           i += m;
/*     */           
/* 655 */           label52: while ((m = gallopRight(arrayOfT1[j], arrayOfT2, i, paramInt2, 0, comparator)) == 0 || (paramInt2 = paramInt2 - m) > 1)
/*     */           
/*     */           { 
/* 658 */             arrayOfT1[k++] = arrayOfT1[j++];
/* 659 */             if (--paramInt4 != 0)
/*     */             
/*     */             { 
/*     */               
/* 663 */               System.arraycopy(arrayOfT1, j, arrayOfT1, k, n);
/* 664 */               k += n;
/* 665 */               j += n;
/*     */               
/* 667 */               if ((n = gallopLeft(arrayOfT2[i], arrayOfT1, j, paramInt4, 0, comparator)) == 0 || (paramInt4 = paramInt4 - n) != 0)
/*     */               
/* 669 */               { arrayOfT1[k++] = arrayOfT2[i++];
/* 670 */                 if (--paramInt2 != 1)
/* 671 */                 { paramInt3--;
/* 672 */                   if ((((m >= 7) ? 1 : 0) | ((n >= 7) ? 1 : 0)) == 0)
/* 673 */                   { if (paramInt3 < 0) { paramInt3 = 0; break label52; }
/* 674 */                      paramInt3 += 2; }  }  }  }  }  break; } 
/*     */       }  break;
/* 676 */     }  this.minGallop = (paramInt3 <= 0) ? 1 : paramInt3;
/*     */     
/* 678 */     if (paramInt2 == 1) {
/*     */       
/* 680 */       System.arraycopy(arrayOfT1, j, arrayOfT1, k, paramInt4);
/* 681 */       arrayOfT1[k + paramInt4] = arrayOfT2[i]; return;
/* 682 */     }  if (paramInt2 == 0) {
/* 683 */       throw new IllegalArgumentException("Comparison method violates its general contract!");
/*     */     }
/*     */ 
/*     */     
/* 687 */     System.arraycopy(arrayOfT2, i, arrayOfT1, k, paramInt2);
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
/*     */   private void mergeHi(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield a : [Ljava/lang/Object;
/*     */     //   4: astore #5
/*     */     //   6: aload_0
/*     */     //   7: iload #4
/*     */     //   9: invokespecial ensureCapacity : (I)[Ljava/lang/Object;
/*     */     //   12: astore #6
/*     */     //   14: aload #5
/*     */     //   16: iload_3
/*     */     //   17: aload #6
/*     */     //   19: iconst_0
/*     */     //   20: iload #4
/*     */     //   22: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   25: iload_1
/*     */     //   26: iload_2
/*     */     //   27: iadd
/*     */     //   28: iconst_1
/*     */     //   29: isub
/*     */     //   30: istore #7
/*     */     //   32: iload #4
/*     */     //   34: iconst_1
/*     */     //   35: isub
/*     */     //   36: istore #8
/*     */     //   38: iload_3
/*     */     //   39: iload #4
/*     */     //   41: iadd
/*     */     //   42: iconst_1
/*     */     //   43: isub
/*     */     //   44: istore_3
/*     */     //   45: aload #5
/*     */     //   47: iload_3
/*     */     //   48: iinc #3, -1
/*     */     //   51: aload #5
/*     */     //   53: iload #7
/*     */     //   55: iinc #7, -1
/*     */     //   58: aaload
/*     */     //   59: aastore
/*     */     //   60: iinc #2, -1
/*     */     //   63: iload_2
/*     */     //   64: ifne -> 82
/*     */     //   67: aload #6
/*     */     //   69: iconst_0
/*     */     //   70: aload #5
/*     */     //   72: iload_3
/*     */     //   73: iload #8
/*     */     //   75: isub
/*     */     //   76: iload #4
/*     */     //   78: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   81: return
/*     */     //   82: iload #4
/*     */     //   84: iconst_1
/*     */     //   85: if_icmpne -> 123
/*     */     //   88: iload_3
/*     */     //   89: iload_2
/*     */     //   90: isub
/*     */     //   91: istore_3
/*     */     //   92: iload #7
/*     */     //   94: iload_2
/*     */     //   95: isub
/*     */     //   96: istore #7
/*     */     //   98: aload #5
/*     */     //   100: iload #7
/*     */     //   102: iconst_1
/*     */     //   103: iadd
/*     */     //   104: aload #5
/*     */     //   106: iload_3
/*     */     //   107: iconst_1
/*     */     //   108: iadd
/*     */     //   109: iload_2
/*     */     //   110: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   113: aload #5
/*     */     //   115: iload_3
/*     */     //   116: aload #6
/*     */     //   118: iload #8
/*     */     //   120: aaload
/*     */     //   121: aastore
/*     */     //   122: return
/*     */     //   123: aload_0
/*     */     //   124: getfield c : Ljava/util/Comparator;
/*     */     //   127: astore #9
/*     */     //   129: aload_0
/*     */     //   130: getfield minGallop : I
/*     */     //   133: istore #10
/*     */     //   135: iconst_0
/*     */     //   136: istore #11
/*     */     //   138: iconst_0
/*     */     //   139: istore #12
/*     */     //   141: aload #9
/*     */     //   143: aload #6
/*     */     //   145: iload #8
/*     */     //   147: aaload
/*     */     //   148: aload #5
/*     */     //   150: iload #7
/*     */     //   152: aaload
/*     */     //   153: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
/*     */     //   158: ifge -> 192
/*     */     //   161: aload #5
/*     */     //   163: iload_3
/*     */     //   164: iinc #3, -1
/*     */     //   167: aload #5
/*     */     //   169: iload #7
/*     */     //   171: iinc #7, -1
/*     */     //   174: aaload
/*     */     //   175: aastore
/*     */     //   176: iinc #11, 1
/*     */     //   179: iconst_0
/*     */     //   180: istore #12
/*     */     //   182: iinc #2, -1
/*     */     //   185: iload_2
/*     */     //   186: ifne -> 222
/*     */     //   189: goto -> 453
/*     */     //   192: aload #5
/*     */     //   194: iload_3
/*     */     //   195: iinc #3, -1
/*     */     //   198: aload #6
/*     */     //   200: iload #8
/*     */     //   202: iinc #8, -1
/*     */     //   205: aaload
/*     */     //   206: aastore
/*     */     //   207: iinc #12, 1
/*     */     //   210: iconst_0
/*     */     //   211: istore #11
/*     */     //   213: iinc #4, -1
/*     */     //   216: iload #4
/*     */     //   218: iconst_1
/*     */     //   219: if_icmpeq -> 453
/*     */     //   222: iload #11
/*     */     //   224: iload #12
/*     */     //   226: ior
/*     */     //   227: iload #10
/*     */     //   229: if_icmplt -> 141
/*     */     //   232: iload_2
/*     */     //   233: aload #6
/*     */     //   235: iload #8
/*     */     //   237: aaload
/*     */     //   238: aload #5
/*     */     //   240: iload_1
/*     */     //   241: iload_2
/*     */     //   242: dup
/*     */     //   243: iconst_1
/*     */     //   244: isub
/*     */     //   245: aload #9
/*     */     //   247: invokestatic gallopRight : (Ljava/lang/Object;[Ljava/lang/Object;IIILjava/util/Comparator;)I
/*     */     //   250: isub
/*     */     //   251: dup
/*     */     //   252: istore #11
/*     */     //   254: ifeq -> 294
/*     */     //   257: iload_3
/*     */     //   258: iload #11
/*     */     //   260: isub
/*     */     //   261: istore_3
/*     */     //   262: iload #7
/*     */     //   264: iload #11
/*     */     //   266: isub
/*     */     //   267: istore #7
/*     */     //   269: iload_2
/*     */     //   270: iload #11
/*     */     //   272: isub
/*     */     //   273: istore_2
/*     */     //   274: aload #5
/*     */     //   276: iload #7
/*     */     //   278: iconst_1
/*     */     //   279: iadd
/*     */     //   280: aload #5
/*     */     //   282: iload_3
/*     */     //   283: iconst_1
/*     */     //   284: iadd
/*     */     //   285: iload #11
/*     */     //   287: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   290: iload_2
/*     */     //   291: ifeq -> 453
/*     */     //   294: aload #5
/*     */     //   296: iload_3
/*     */     //   297: iinc #3, -1
/*     */     //   300: aload #6
/*     */     //   302: iload #8
/*     */     //   304: iinc #8, -1
/*     */     //   307: aaload
/*     */     //   308: aastore
/*     */     //   309: iinc #4, -1
/*     */     //   312: iload #4
/*     */     //   314: iconst_1
/*     */     //   315: if_icmpeq -> 453
/*     */     //   318: iload #4
/*     */     //   320: aload #5
/*     */     //   322: iload #7
/*     */     //   324: aaload
/*     */     //   325: aload #6
/*     */     //   327: iconst_0
/*     */     //   328: iload #4
/*     */     //   330: dup
/*     */     //   331: iconst_1
/*     */     //   332: isub
/*     */     //   333: aload #9
/*     */     //   335: invokestatic gallopLeft : (Ljava/lang/Object;[Ljava/lang/Object;IIILjava/util/Comparator;)I
/*     */     //   338: isub
/*     */     //   339: dup
/*     */     //   340: istore #12
/*     */     //   342: ifeq -> 386
/*     */     //   345: iload_3
/*     */     //   346: iload #12
/*     */     //   348: isub
/*     */     //   349: istore_3
/*     */     //   350: iload #8
/*     */     //   352: iload #12
/*     */     //   354: isub
/*     */     //   355: istore #8
/*     */     //   357: iload #4
/*     */     //   359: iload #12
/*     */     //   361: isub
/*     */     //   362: istore #4
/*     */     //   364: aload #6
/*     */     //   366: iload #8
/*     */     //   368: iconst_1
/*     */     //   369: iadd
/*     */     //   370: aload #5
/*     */     //   372: iload_3
/*     */     //   373: iconst_1
/*     */     //   374: iadd
/*     */     //   375: iload #12
/*     */     //   377: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   380: iload #4
/*     */     //   382: iconst_1
/*     */     //   383: if_icmple -> 453
/*     */     //   386: aload #5
/*     */     //   388: iload_3
/*     */     //   389: iinc #3, -1
/*     */     //   392: aload #5
/*     */     //   394: iload #7
/*     */     //   396: iinc #7, -1
/*     */     //   399: aaload
/*     */     //   400: aastore
/*     */     //   401: iinc #2, -1
/*     */     //   404: iload_2
/*     */     //   405: ifeq -> 453
/*     */     //   408: iinc #10, -1
/*     */     //   411: iload #11
/*     */     //   413: bipush #7
/*     */     //   415: if_icmplt -> 422
/*     */     //   418: iconst_1
/*     */     //   419: goto -> 423
/*     */     //   422: iconst_0
/*     */     //   423: iload #12
/*     */     //   425: bipush #7
/*     */     //   427: if_icmplt -> 434
/*     */     //   430: iconst_1
/*     */     //   431: goto -> 435
/*     */     //   434: iconst_0
/*     */     //   435: ior
/*     */     //   436: ifne -> 232
/*     */     //   439: iload #10
/*     */     //   441: ifge -> 447
/*     */     //   444: iconst_0
/*     */     //   445: istore #10
/*     */     //   447: iinc #10, 2
/*     */     //   450: goto -> 135
/*     */     //   453: aload_0
/*     */     //   454: iload #10
/*     */     //   456: ifgt -> 463
/*     */     //   459: iconst_1
/*     */     //   460: goto -> 465
/*     */     //   463: iload #10
/*     */     //   465: putfield minGallop : I
/*     */     //   468: iload #4
/*     */     //   470: iconst_1
/*     */     //   471: if_icmpne -> 509
/*     */     //   474: iload_3
/*     */     //   475: iload_2
/*     */     //   476: isub
/*     */     //   477: istore_3
/*     */     //   478: iload #7
/*     */     //   480: iload_2
/*     */     //   481: isub
/*     */     //   482: istore #7
/*     */     //   484: aload #5
/*     */     //   486: iload #7
/*     */     //   488: iconst_1
/*     */     //   489: iadd
/*     */     //   490: aload #5
/*     */     //   492: iload_3
/*     */     //   493: iconst_1
/*     */     //   494: iadd
/*     */     //   495: iload_2
/*     */     //   496: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   499: aload #5
/*     */     //   501: iload_3
/*     */     //   502: aload #6
/*     */     //   504: iload #8
/*     */     //   506: aaload
/*     */     //   507: aastore
/*     */     //   508: return
/*     */     //   509: iload #4
/*     */     //   511: ifne -> 524
/*     */     //   514: new java/lang/IllegalArgumentException
/*     */     //   517: dup
/*     */     //   518: ldc 'Comparison method violates its general contract!'
/*     */     //   520: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   523: athrow
/*     */     //   524: aload #6
/*     */     //   526: iconst_0
/*     */     //   527: aload #5
/*     */     //   529: iload_3
/*     */     //   530: iload #4
/*     */     //   532: iconst_1
/*     */     //   533: isub
/*     */     //   534: isub
/*     */     //   535: iload #4
/*     */     //   537: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   540: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #702	-> 0
/*     */     //   #703	-> 6
/*     */     //   #704	-> 14
/*     */     //   #706	-> 25
/*     */     //   #707	-> 32
/*     */     //   #708	-> 38
/*     */     //   #711	-> 45
/*     */     //   #712	-> 60
/*     */     //   #713	-> 67
/*     */     //   #714	-> 81
/*     */     //   #716	-> 82
/*     */     //   #717	-> 88
/*     */     //   #718	-> 92
/*     */     //   #719	-> 98
/*     */     //   #720	-> 113
/*     */     //   #721	-> 122
/*     */     //   #724	-> 123
/*     */     //   #725	-> 129
/*     */     //   #728	-> 135
/*     */     //   #729	-> 138
/*     */     //   #736	-> 141
/*     */     //   #737	-> 161
/*     */     //   #738	-> 176
/*     */     //   #739	-> 179
/*     */     //   #740	-> 182
/*     */     //   #742	-> 192
/*     */     //   #743	-> 207
/*     */     //   #744	-> 210
/*     */     //   #745	-> 213
/*     */     //   #747	-> 222
/*     */     //   #755	-> 232
/*     */     //   #756	-> 252
/*     */     //   #757	-> 257
/*     */     //   #758	-> 262
/*     */     //   #759	-> 269
/*     */     //   #760	-> 274
/*     */     //   #761	-> 290
/*     */     //   #763	-> 294
/*     */     //   #764	-> 309
/*     */     //   #766	-> 318
/*     */     //   #767	-> 340
/*     */     //   #768	-> 345
/*     */     //   #769	-> 350
/*     */     //   #770	-> 357
/*     */     //   #771	-> 364
/*     */     //   #772	-> 380
/*     */     //   #775	-> 386
/*     */     //   #776	-> 401
/*     */     //   #777	-> 408
/*     */     //   #778	-> 411
/*     */     //   #779	-> 439
/*     */     //   #780	-> 447
/*     */     //   #781	-> 450
/*     */     //   #782	-> 453
/*     */     //   #784	-> 468
/*     */     //   #786	-> 474
/*     */     //   #787	-> 478
/*     */     //   #788	-> 484
/*     */     //   #789	-> 499
/*     */     //   #790	-> 509
/*     */     //   #791	-> 514
/*     */     //   #795	-> 524
/*     */     //   #797	-> 540
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
/*     */   private T[] ensureCapacity(int paramInt) {
/* 805 */     this.tmpCount = Math.max(this.tmpCount, paramInt);
/* 806 */     if (this.tmp.length < paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 813 */       int i = (i = (i = (i = (i = paramInt | paramInt >> 1) | i >> 2) | i >> 4) | i >> 8) | i >> 16;
/* 814 */       i++;
/*     */       
/* 816 */       if (i < 0) {
/* 817 */         i = paramInt;
/*     */       } else {
/* 819 */         i = Math.min(i, this.a.length >>> 1);
/*     */       } 
/* 821 */       Object[] arrayOfObject = new Object[i];
/* 822 */       this.tmp = (T[])arrayOfObject;
/*     */     } 
/* 824 */     return this.tmp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void rangeCheck(int paramInt1, int paramInt2, int paramInt3) {
/* 835 */     if (paramInt2 > paramInt3) throw new IllegalArgumentException("fromIndex(" + paramInt2 + ") > toIndex(" + paramInt3 + ")"); 
/* 836 */     if (paramInt2 < 0) throw new ArrayIndexOutOfBoundsException(paramInt2); 
/* 837 */     if (paramInt3 > paramInt1) throw new ArrayIndexOutOfBoundsException(paramInt3); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\TimSort.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */