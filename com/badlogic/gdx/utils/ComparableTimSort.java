/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ComparableTimSort
/*     */ {
/*     */   private static final int MIN_MERGE = 32;
/*     */   private Object[] a;
/*     */   private static final int MIN_GALLOP = 7;
/*  44 */   private int minGallop = 7;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object[] tmp;
/*     */ 
/*     */ 
/*     */   
/*     */   private int tmpCount;
/*     */ 
/*     */ 
/*     */   
/*  62 */   private int stackSize = 0;
/*     */   
/*     */   private final int[] runBase;
/*     */   
/*     */   private final int[] runLen;
/*     */   
/*     */   private static final boolean DEBUG = false;
/*     */   
/*     */   ComparableTimSort() {
/*  71 */     this.tmp = new Object[256];
/*  72 */     this.runBase = new int[40];
/*  73 */     this.runLen = new int[40];
/*     */   }
/*     */   public void doSort(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/*     */     int m;
/*  77 */     this.stackSize = 0;
/*  78 */     rangeCheck(paramArrayOfObject.length, paramInt1, paramInt2);
/*     */     int j;
/*  80 */     if ((j = paramInt2 - paramInt1) < 2) {
/*     */       return;
/*     */     }
/*  83 */     if (j < 32) {
/*  84 */       int n = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2);
/*  85 */       binarySort(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + n);
/*     */       
/*     */       return;
/*     */     } 
/*  89 */     this.a = paramArrayOfObject;
/*  90 */     this.tmpCount = 0;
/*     */ 
/*     */ 
/*     */     
/*  94 */     int k = minRunLength(j);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 100 */       if ((m = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2)) >= k)
/* 101 */         continue;  int n = (j <= k) ? j : k;
/* 102 */       binarySort(paramArrayOfObject, paramInt1, paramInt1 + n, paramInt1 + m);
/* 103 */       m = n;
/*     */ 
/*     */ 
/*     */       
/* 107 */       pushRun(paramInt1, m);
/* 108 */       mergeCollapse();
/*     */ 
/*     */       
/* 111 */       paramInt1 += m;
/*     */     }
/* 113 */     while ((j = j - m) != 0);
/*     */ 
/*     */ 
/*     */     
/* 117 */     mergeForceCollapse();
/*     */ 
/*     */     
/* 120 */     this.a = null;
/* 121 */     Object[] arrayOfObject = this.tmp; int i; byte b;
/* 122 */     for (b = 0, i = this.tmpCount; b < i; b++) {
/* 123 */       arrayOfObject[b] = null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private ComparableTimSort(Object[] paramArrayOfObject) {
/* 130 */     this.a = paramArrayOfObject;
/*     */     
/*     */     int i;
/*     */     
/* 134 */     Object[] arrayOfObject = new Object[((i = paramArrayOfObject.length) < 512) ? (i >>> 1) : 256];
/* 135 */     this.tmp = arrayOfObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 144 */     i = (i < 120) ? 5 : ((i < 1542) ? 10 : ((i < 119151) ? 19 : 40));
/* 145 */     this.runBase = new int[i];
/* 146 */     this.runLen = new int[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void sort(Object[] paramArrayOfObject) {
/* 155 */     sort(paramArrayOfObject, 0, paramArrayOfObject.length);
/*     */   }
/*     */   static void sort(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/*     */     int k;
/* 159 */     rangeCheck(paramArrayOfObject.length, paramInt1, paramInt2);
/*     */     int i;
/* 161 */     if ((i = paramInt2 - paramInt1) < 2) {
/*     */       return;
/*     */     }
/* 164 */     if (i < 32) {
/* 165 */       int m = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2);
/* 166 */       binarySort(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + m);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 172 */     ComparableTimSort comparableTimSort = new ComparableTimSort(paramArrayOfObject);
/* 173 */     int j = minRunLength(i);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/* 179 */       if ((k = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2)) >= j)
/* 180 */         continue;  int m = (i <= j) ? i : j;
/* 181 */       binarySort(paramArrayOfObject, paramInt1, paramInt1 + m, paramInt1 + k);
/* 182 */       k = m;
/*     */ 
/*     */ 
/*     */       
/* 186 */       comparableTimSort.pushRun(paramInt1, k);
/* 187 */       comparableTimSort.mergeCollapse();
/*     */ 
/*     */       
/* 190 */       paramInt1 += k;
/*     */     }
/* 192 */     while ((i = i - k) != 0);
/*     */ 
/*     */ 
/*     */     
/* 196 */     comparableTimSort.mergeForceCollapse();
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
/*     */   private static void binarySort(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
/* 213 */     if (paramInt3 == paramInt1) paramInt3++; 
/* 214 */     for (; paramInt3 < paramInt2; paramInt3++) {
/*     */       
/* 216 */       Comparable<Object> comparable = (Comparable)paramArrayOfObject[paramInt3];
/*     */ 
/*     */       
/* 219 */       int i = paramInt1;
/* 220 */       int j = paramInt3;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 225 */       while (i < j) {
/* 226 */         int m = i + j >>> 1;
/* 227 */         if (comparable.compareTo(paramArrayOfObject[m]) < 0) {
/* 228 */           j = m; continue;
/*     */         } 
/* 230 */         i = m + 1;
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
/* 241 */       switch (k = paramInt3 - i) {
/*     */         case 2:
/* 243 */           paramArrayOfObject[i + 2] = paramArrayOfObject[i + 1];
/*     */         case 1:
/* 245 */           paramArrayOfObject[i + 1] = paramArrayOfObject[i];
/*     */           break;
/*     */         default:
/* 248 */           System.arraycopy(paramArrayOfObject, i, paramArrayOfObject, i + 1, k); break;
/*     */       } 
/* 250 */       paramArrayOfObject[i] = comparable;
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
/*     */   private static int countRunAndMakeAscending(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/*     */     int i;
/* 276 */     if ((i = paramInt1 + 1) == paramInt2) return 1;
/*     */ 
/*     */     
/* 279 */     if (((Comparable<Object>)paramArrayOfObject[i++]).compareTo(paramArrayOfObject[paramInt1]) < 0) {
/* 280 */       while (i < paramInt2 && ((Comparable<Object>)paramArrayOfObject[i]).compareTo(paramArrayOfObject[i - 1]) < 0)
/* 281 */         i++; 
/* 282 */       reverseRange(paramArrayOfObject, paramInt1, i);
/*     */     } else {
/* 284 */       while (i < paramInt2 && ((Comparable<Object>)paramArrayOfObject[i]).compareTo(paramArrayOfObject[i - 1]) >= 0) {
/* 285 */         i++;
/*     */       }
/*     */     } 
/* 288 */     return i - paramInt1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void reverseRange(Object[] paramArrayOfObject, int paramInt1, int paramInt2) {
/* 297 */     paramInt2--;
/* 298 */     while (paramInt1 < paramInt2) {
/* 299 */       Object object = paramArrayOfObject[paramInt1];
/* 300 */       paramArrayOfObject[paramInt1++] = paramArrayOfObject[paramInt2];
/* 301 */       paramArrayOfObject[paramInt2--] = object;
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
/* 320 */     int i = 0;
/* 321 */     while (paramInt >= 32) {
/* 322 */       i |= paramInt & 0x1;
/* 323 */       paramInt >>= 1;
/*     */     } 
/* 325 */     return paramInt + i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushRun(int paramInt1, int paramInt2) {
/* 333 */     this.runBase[this.stackSize] = paramInt1;
/* 334 */     this.runLen[this.stackSize] = paramInt2;
/* 335 */     this.stackSize++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void mergeCollapse() {
/* 345 */     while (this.stackSize > 1) {
/*     */       int i;
/* 347 */       if ((i = this.stackSize - 2) > 0 && this.runLen[i - 1] <= this.runLen[i] + this.runLen[i + 1]) {
/* 348 */         if (this.runLen[i - 1] < this.runLen[i + 1]) i--; 
/* 349 */         mergeAt(i); continue;
/* 350 */       }  if (this.runLen[i] <= this.runLen[i + 1]) {
/* 351 */         mergeAt(i);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void mergeForceCollapse() {
/* 360 */     while (this.stackSize > 1) {
/*     */       int i;
/* 362 */       if ((i = this.stackSize - 2) > 0 && this.runLen[i - 1] < this.runLen[i + 1]) i--; 
/* 363 */       mergeAt(i);
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
/*     */   private void mergeAt(int paramInt) {
/* 377 */     int i = this.runBase[paramInt];
/* 378 */     int j = this.runLen[paramInt];
/* 379 */     int k = this.runBase[paramInt + 1];
/* 380 */     int m = this.runLen[paramInt + 1];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 388 */     this.runLen[paramInt] = j + m;
/* 389 */     if (paramInt == this.stackSize - 3) {
/* 390 */       this.runBase[paramInt + 1] = this.runBase[paramInt + 2];
/* 391 */       this.runLen[paramInt + 1] = this.runLen[paramInt + 2];
/*     */     } 
/* 393 */     this.stackSize--;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 399 */     paramInt = gallopRight((Comparable<Object>)this.a[k], this.a, i, j, 0);
/*     */     
/* 401 */     i += paramInt;
/*     */     
/* 403 */     if ((j = j - paramInt) == 0) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 411 */     if ((m = gallopLeft((Comparable<Object>)this.a[i + j - 1], this.a, k, m, m - 1)) == 0) {
/*     */       return;
/*     */     }
/* 414 */     if (j <= m) {
/* 415 */       mergeLo(i, j, k, m); return;
/*     */     } 
/* 417 */     mergeHi(i, j, k, m);
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
/*     */   private static int gallopLeft(Comparable<Object> paramComparable, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
/* 435 */     int i = 0;
/* 436 */     int j = 1;
/* 437 */     if (paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt3]) > 0) {
/*     */       
/* 439 */       paramInt2 -= paramInt3;
/* 440 */       while (j < paramInt2 && paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt3 + j]) > 0) {
/* 441 */         i = j;
/*     */         
/* 443 */         if ((j = (j << 1) + 1) <= 0)
/* 444 */           j = paramInt2; 
/*     */       } 
/* 446 */       if (j > paramInt2) j = paramInt2;
/*     */ 
/*     */       
/* 449 */       i += paramInt3;
/* 450 */       j += paramInt3;
/*     */     } else {
/*     */       
/* 453 */       paramInt2 = paramInt3 + 1;
/* 454 */       while (j < paramInt2 && paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt3 - j]) <= 0) {
/* 455 */         i = j;
/*     */         
/* 457 */         if ((j = (j << 1) + 1) <= 0)
/* 458 */           j = paramInt2; 
/*     */       } 
/* 460 */       if (j > paramInt2) j = paramInt2;
/*     */ 
/*     */       
/* 463 */       paramInt2 = i;
/* 464 */       i = paramInt3 - j;
/* 465 */       j = paramInt3 - paramInt2;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 473 */     i++;
/* 474 */     while (i < j) {
/* 475 */       paramInt2 = i + (j - i >>> 1);
/*     */       
/* 477 */       if (paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt2]) > 0) {
/* 478 */         i = paramInt2 + 1; continue;
/*     */       } 
/* 480 */       j = paramInt2;
/*     */     } 
/*     */     
/* 483 */     return j;
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
/*     */   private static int gallopRight(Comparable<Object> paramComparable, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3) {
/* 499 */     int i = 1;
/* 500 */     int j = 0;
/* 501 */     if (paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt3]) < 0) {
/*     */       
/* 503 */       paramInt2 = paramInt3 + 1;
/* 504 */       while (i < paramInt2 && paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt3 - i]) < 0) {
/* 505 */         j = i;
/*     */         
/* 507 */         if ((i = (i << 1) + 1) <= 0)
/* 508 */           i = paramInt2; 
/*     */       } 
/* 510 */       if (i > paramInt2) i = paramInt2;
/*     */ 
/*     */       
/* 513 */       paramInt2 = j;
/* 514 */       j = paramInt3 - i;
/* 515 */       i = paramInt3 - paramInt2;
/*     */     } else {
/*     */       
/* 518 */       paramInt2 -= paramInt3;
/* 519 */       while (i < paramInt2 && paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt3 + i]) >= 0) {
/* 520 */         j = i;
/*     */         
/* 522 */         if ((i = (i << 1) + 1) <= 0)
/* 523 */           i = paramInt2; 
/*     */       } 
/* 525 */       if (i > paramInt2) i = paramInt2;
/*     */ 
/*     */       
/* 528 */       j += paramInt3;
/* 529 */       i += paramInt3;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 537 */     j++;
/* 538 */     while (j < i) {
/* 539 */       paramInt2 = j + (i - j >>> 1);
/*     */       
/* 541 */       if (paramComparable.compareTo(paramArrayOfObject[paramInt1 + paramInt2]) < 0) {
/* 542 */         i = paramInt2; continue;
/*     */       } 
/* 544 */       j = paramInt2 + 1;
/*     */     } 
/*     */     
/* 547 */     return i;
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
/*     */   private void mergeLo(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 566 */     Object[] arrayOfObject1 = this.a;
/* 567 */     Object[] arrayOfObject2 = ensureCapacity(paramInt2);
/* 568 */     System.arraycopy(arrayOfObject1, paramInt1, arrayOfObject2, 0, paramInt2);
/*     */     
/* 570 */     int i = 0;
/* 571 */     int j = paramInt3;
/* 572 */     int k = paramInt1;
/*     */ 
/*     */     
/* 575 */     k++; j++; arrayOfObject1[paramInt1] = arrayOfObject1[paramInt3];
/* 576 */     if (--paramInt4 == 0) {
/* 577 */       System.arraycopy(arrayOfObject2, 0, arrayOfObject1, k, paramInt2);
/*     */       return;
/*     */     } 
/* 580 */     if (paramInt2 == 1) {
/* 581 */       System.arraycopy(arrayOfObject1, j, arrayOfObject1, k, paramInt4);
/* 582 */       arrayOfObject1[k + paramInt4] = arrayOfObject2[0];
/*     */       
/*     */       return;
/*     */     } 
/* 586 */     paramInt1 = this.minGallop;
/*     */     
/*     */     while (true) {
/* 589 */       paramInt3 = 0;
/* 590 */       int m = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         while (true) {
/* 597 */           if (((Comparable<Object>)arrayOfObject1[j]).compareTo(arrayOfObject2[i]) < 0) {
/* 598 */             arrayOfObject1[k++] = arrayOfObject1[j++];
/* 599 */             m++;
/* 600 */             paramInt3 = 0;
/* 601 */             if (--paramInt4 == 0)
/*     */               // Byte code: goto -> 0  break;
/* 603 */           }  arrayOfObject1[k++] = arrayOfObject2[i++];
/* 604 */           paramInt3++;
/* 605 */           m = 0;
/* 606 */           if (--paramInt2 != 1)
/*     */             break;  // Byte code: goto -> 0
/* 608 */         }  if ((paramInt3 | m) >= paramInt1)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 618 */           System.arraycopy(arrayOfObject2, i, arrayOfObject1, k, paramInt3);
/* 619 */           k += paramInt3;
/* 620 */           i += paramInt3;
/*     */           
/* 622 */           label52: while ((paramInt3 = gallopRight((Comparable<Object>)arrayOfObject1[j], arrayOfObject2, i, paramInt2, 0)) == 0 || (paramInt2 = paramInt2 - paramInt3) > 1)
/*     */           
/*     */           { 
/* 625 */             arrayOfObject1[k++] = arrayOfObject1[j++];
/* 626 */             if (--paramInt4 != 0)
/*     */             
/*     */             { 
/*     */               
/* 630 */               System.arraycopy(arrayOfObject1, j, arrayOfObject1, k, m);
/* 631 */               k += m;
/* 632 */               j += m;
/*     */               
/* 634 */               if ((m = gallopLeft((Comparable<Object>)arrayOfObject2[i], arrayOfObject1, j, paramInt4, 0)) == 0 || (paramInt4 = paramInt4 - m) != 0)
/*     */               
/* 636 */               { arrayOfObject1[k++] = arrayOfObject2[i++];
/* 637 */                 if (--paramInt2 != 1)
/* 638 */                 { paramInt1--;
/* 639 */                   if ((((paramInt3 >= 7) ? 1 : 0) | ((m >= 7) ? 1 : 0)) == 0)
/* 640 */                   { if (paramInt1 < 0) { paramInt1 = 0; break label52; }
/* 641 */                      paramInt1 += 2; }  }  }  }  }  break; } 
/*     */       }  break;
/* 643 */     }  this.minGallop = (paramInt1 <= 0) ? 1 : paramInt1;
/*     */     
/* 645 */     if (paramInt2 == 1) {
/*     */       
/* 647 */       System.arraycopy(arrayOfObject1, j, arrayOfObject1, k, paramInt4);
/* 648 */       arrayOfObject1[k + paramInt4] = arrayOfObject2[i]; return;
/* 649 */     }  if (paramInt2 == 0) {
/* 650 */       throw new IllegalArgumentException("Comparison method violates its general contract!");
/*     */     }
/*     */ 
/*     */     
/* 654 */     System.arraycopy(arrayOfObject2, i, arrayOfObject1, k, paramInt2);
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
/*     */     //   124: getfield minGallop : I
/*     */     //   127: istore #9
/*     */     //   129: iconst_0
/*     */     //   130: istore #10
/*     */     //   132: iconst_0
/*     */     //   133: istore #11
/*     */     //   135: aload #6
/*     */     //   137: iload #8
/*     */     //   139: aaload
/*     */     //   140: checkcast java/lang/Comparable
/*     */     //   143: aload #5
/*     */     //   145: iload #7
/*     */     //   147: aaload
/*     */     //   148: invokeinterface compareTo : (Ljava/lang/Object;)I
/*     */     //   153: ifge -> 187
/*     */     //   156: aload #5
/*     */     //   158: iload_3
/*     */     //   159: iinc #3, -1
/*     */     //   162: aload #5
/*     */     //   164: iload #7
/*     */     //   166: iinc #7, -1
/*     */     //   169: aaload
/*     */     //   170: aastore
/*     */     //   171: iinc #10, 1
/*     */     //   174: iconst_0
/*     */     //   175: istore #11
/*     */     //   177: iinc #2, -1
/*     */     //   180: iload_2
/*     */     //   181: ifne -> 217
/*     */     //   184: goto -> 450
/*     */     //   187: aload #5
/*     */     //   189: iload_3
/*     */     //   190: iinc #3, -1
/*     */     //   193: aload #6
/*     */     //   195: iload #8
/*     */     //   197: iinc #8, -1
/*     */     //   200: aaload
/*     */     //   201: aastore
/*     */     //   202: iinc #11, 1
/*     */     //   205: iconst_0
/*     */     //   206: istore #10
/*     */     //   208: iinc #4, -1
/*     */     //   211: iload #4
/*     */     //   213: iconst_1
/*     */     //   214: if_icmpeq -> 450
/*     */     //   217: iload #10
/*     */     //   219: iload #11
/*     */     //   221: ior
/*     */     //   222: iload #9
/*     */     //   224: if_icmplt -> 135
/*     */     //   227: iload_2
/*     */     //   228: aload #6
/*     */     //   230: iload #8
/*     */     //   232: aaload
/*     */     //   233: checkcast java/lang/Comparable
/*     */     //   236: aload #5
/*     */     //   238: iload_1
/*     */     //   239: iload_2
/*     */     //   240: dup
/*     */     //   241: iconst_1
/*     */     //   242: isub
/*     */     //   243: invokestatic gallopRight : (Ljava/lang/Comparable;[Ljava/lang/Object;III)I
/*     */     //   246: isub
/*     */     //   247: dup
/*     */     //   248: istore #10
/*     */     //   250: ifeq -> 290
/*     */     //   253: iload_3
/*     */     //   254: iload #10
/*     */     //   256: isub
/*     */     //   257: istore_3
/*     */     //   258: iload #7
/*     */     //   260: iload #10
/*     */     //   262: isub
/*     */     //   263: istore #7
/*     */     //   265: iload_2
/*     */     //   266: iload #10
/*     */     //   268: isub
/*     */     //   269: istore_2
/*     */     //   270: aload #5
/*     */     //   272: iload #7
/*     */     //   274: iconst_1
/*     */     //   275: iadd
/*     */     //   276: aload #5
/*     */     //   278: iload_3
/*     */     //   279: iconst_1
/*     */     //   280: iadd
/*     */     //   281: iload #10
/*     */     //   283: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   286: iload_2
/*     */     //   287: ifeq -> 450
/*     */     //   290: aload #5
/*     */     //   292: iload_3
/*     */     //   293: iinc #3, -1
/*     */     //   296: aload #6
/*     */     //   298: iload #8
/*     */     //   300: iinc #8, -1
/*     */     //   303: aaload
/*     */     //   304: aastore
/*     */     //   305: iinc #4, -1
/*     */     //   308: iload #4
/*     */     //   310: iconst_1
/*     */     //   311: if_icmpeq -> 450
/*     */     //   314: iload #4
/*     */     //   316: aload #5
/*     */     //   318: iload #7
/*     */     //   320: aaload
/*     */     //   321: checkcast java/lang/Comparable
/*     */     //   324: aload #6
/*     */     //   326: iconst_0
/*     */     //   327: iload #4
/*     */     //   329: dup
/*     */     //   330: iconst_1
/*     */     //   331: isub
/*     */     //   332: invokestatic gallopLeft : (Ljava/lang/Comparable;[Ljava/lang/Object;III)I
/*     */     //   335: isub
/*     */     //   336: dup
/*     */     //   337: istore #11
/*     */     //   339: ifeq -> 383
/*     */     //   342: iload_3
/*     */     //   343: iload #11
/*     */     //   345: isub
/*     */     //   346: istore_3
/*     */     //   347: iload #8
/*     */     //   349: iload #11
/*     */     //   351: isub
/*     */     //   352: istore #8
/*     */     //   354: iload #4
/*     */     //   356: iload #11
/*     */     //   358: isub
/*     */     //   359: istore #4
/*     */     //   361: aload #6
/*     */     //   363: iload #8
/*     */     //   365: iconst_1
/*     */     //   366: iadd
/*     */     //   367: aload #5
/*     */     //   369: iload_3
/*     */     //   370: iconst_1
/*     */     //   371: iadd
/*     */     //   372: iload #11
/*     */     //   374: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   377: iload #4
/*     */     //   379: iconst_1
/*     */     //   380: if_icmple -> 450
/*     */     //   383: aload #5
/*     */     //   385: iload_3
/*     */     //   386: iinc #3, -1
/*     */     //   389: aload #5
/*     */     //   391: iload #7
/*     */     //   393: iinc #7, -1
/*     */     //   396: aaload
/*     */     //   397: aastore
/*     */     //   398: iinc #2, -1
/*     */     //   401: iload_2
/*     */     //   402: ifeq -> 450
/*     */     //   405: iinc #9, -1
/*     */     //   408: iload #10
/*     */     //   410: bipush #7
/*     */     //   412: if_icmplt -> 419
/*     */     //   415: iconst_1
/*     */     //   416: goto -> 420
/*     */     //   419: iconst_0
/*     */     //   420: iload #11
/*     */     //   422: bipush #7
/*     */     //   424: if_icmplt -> 431
/*     */     //   427: iconst_1
/*     */     //   428: goto -> 432
/*     */     //   431: iconst_0
/*     */     //   432: ior
/*     */     //   433: ifne -> 227
/*     */     //   436: iload #9
/*     */     //   438: ifge -> 444
/*     */     //   441: iconst_0
/*     */     //   442: istore #9
/*     */     //   444: iinc #9, 2
/*     */     //   447: goto -> 129
/*     */     //   450: aload_0
/*     */     //   451: iload #9
/*     */     //   453: ifgt -> 460
/*     */     //   456: iconst_1
/*     */     //   457: goto -> 462
/*     */     //   460: iload #9
/*     */     //   462: putfield minGallop : I
/*     */     //   465: iload #4
/*     */     //   467: iconst_1
/*     */     //   468: if_icmpne -> 506
/*     */     //   471: iload_3
/*     */     //   472: iload_2
/*     */     //   473: isub
/*     */     //   474: istore_3
/*     */     //   475: iload #7
/*     */     //   477: iload_2
/*     */     //   478: isub
/*     */     //   479: istore #7
/*     */     //   481: aload #5
/*     */     //   483: iload #7
/*     */     //   485: iconst_1
/*     */     //   486: iadd
/*     */     //   487: aload #5
/*     */     //   489: iload_3
/*     */     //   490: iconst_1
/*     */     //   491: iadd
/*     */     //   492: iload_2
/*     */     //   493: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   496: aload #5
/*     */     //   498: iload_3
/*     */     //   499: aload #6
/*     */     //   501: iload #8
/*     */     //   503: aaload
/*     */     //   504: aastore
/*     */     //   505: return
/*     */     //   506: iload #4
/*     */     //   508: ifne -> 521
/*     */     //   511: new java/lang/IllegalArgumentException
/*     */     //   514: dup
/*     */     //   515: ldc 'Comparison method violates its general contract!'
/*     */     //   517: invokespecial <init> : (Ljava/lang/String;)V
/*     */     //   520: athrow
/*     */     //   521: aload #6
/*     */     //   523: iconst_0
/*     */     //   524: aload #5
/*     */     //   526: iload_3
/*     */     //   527: iload #4
/*     */     //   529: iconst_1
/*     */     //   530: isub
/*     */     //   531: isub
/*     */     //   532: iload #4
/*     */     //   534: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
/*     */     //   537: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #670	-> 0
/*     */     //   #671	-> 6
/*     */     //   #672	-> 14
/*     */     //   #674	-> 25
/*     */     //   #675	-> 32
/*     */     //   #676	-> 38
/*     */     //   #679	-> 45
/*     */     //   #680	-> 60
/*     */     //   #681	-> 67
/*     */     //   #682	-> 81
/*     */     //   #684	-> 82
/*     */     //   #685	-> 88
/*     */     //   #686	-> 92
/*     */     //   #687	-> 98
/*     */     //   #688	-> 113
/*     */     //   #689	-> 122
/*     */     //   #692	-> 123
/*     */     //   #695	-> 129
/*     */     //   #696	-> 132
/*     */     //   #703	-> 135
/*     */     //   #704	-> 156
/*     */     //   #705	-> 171
/*     */     //   #706	-> 174
/*     */     //   #707	-> 177
/*     */     //   #709	-> 187
/*     */     //   #710	-> 202
/*     */     //   #711	-> 205
/*     */     //   #712	-> 208
/*     */     //   #714	-> 217
/*     */     //   #722	-> 227
/*     */     //   #723	-> 248
/*     */     //   #724	-> 253
/*     */     //   #725	-> 258
/*     */     //   #726	-> 265
/*     */     //   #727	-> 270
/*     */     //   #728	-> 286
/*     */     //   #730	-> 290
/*     */     //   #731	-> 305
/*     */     //   #733	-> 314
/*     */     //   #734	-> 337
/*     */     //   #735	-> 342
/*     */     //   #736	-> 347
/*     */     //   #737	-> 354
/*     */     //   #738	-> 361
/*     */     //   #739	-> 377
/*     */     //   #741	-> 383
/*     */     //   #742	-> 398
/*     */     //   #743	-> 405
/*     */     //   #744	-> 408
/*     */     //   #745	-> 436
/*     */     //   #746	-> 444
/*     */     //   #747	-> 447
/*     */     //   #748	-> 450
/*     */     //   #750	-> 465
/*     */     //   #752	-> 471
/*     */     //   #753	-> 475
/*     */     //   #754	-> 481
/*     */     //   #755	-> 496
/*     */     //   #756	-> 506
/*     */     //   #757	-> 511
/*     */     //   #761	-> 521
/*     */     //   #763	-> 537
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
/*     */   private Object[] ensureCapacity(int paramInt) {
/* 771 */     this.tmpCount = Math.max(this.tmpCount, paramInt);
/* 772 */     if (this.tmp.length < paramInt) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 779 */       int i = (i = (i = (i = (i = paramInt | paramInt >> 1) | i >> 2) | i >> 4) | i >> 8) | i >> 16;
/* 780 */       i++;
/*     */       
/* 782 */       if (i < 0) {
/* 783 */         i = paramInt;
/*     */       } else {
/* 785 */         i = Math.min(i, this.a.length >>> 1);
/*     */       } 
/* 787 */       Object[] arrayOfObject = new Object[i];
/* 788 */       this.tmp = arrayOfObject;
/*     */     } 
/* 790 */     return this.tmp;
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
/* 801 */     if (paramInt2 > paramInt3) throw new IllegalArgumentException("fromIndex(" + paramInt2 + ") > toIndex(" + paramInt3 + ")"); 
/* 802 */     if (paramInt2 < 0) throw new ArrayIndexOutOfBoundsException(paramInt2); 
/* 803 */     if (paramInt3 > paramInt1) throw new ArrayIndexOutOfBoundsException(paramInt3); 
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\ComparableTimSort.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */