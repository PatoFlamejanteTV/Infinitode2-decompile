/*      */ package com.b.a.a;
/*      */ 
/*      */ import com.a.a.a.am;
/*      */ import com.b.a.c.i;
/*      */ import java.util.ArrayList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class az
/*      */ {
/*      */   private i a;
/*      */   private i b;
/*      */   private ArrayList<String> c;
/*      */   private short[] d;
/*      */   private final int e;
/*      */   private boolean f;
/*      */   private boolean g;
/*      */   private a h;
/*      */   
/*      */   public az(i parami, ArrayList<String> paramArrayList, int paramInt) {
/*      */     byte b2;
/*      */     int m;
/*   85 */     this.a = new i(0, 1114111);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   91 */     this.c = paramArrayList;
/*   92 */     this.g = (paramInt == 127);
/*   93 */     this.a.a(parami);
/*   94 */     if (0 != (paramInt & 0x1))
/*      */     {
/*      */       
/*   97 */       this.b = this.a;
/*      */     }
/*   99 */     this.h = new a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  108 */     int j = this.c.size();
/*      */ 
/*      */     
/*  111 */     int k = 0;
/*  112 */     this.f = false; byte b1;
/*  113 */     for (b1 = 0; b1 < j; b1++) {
/*      */       String str;
/*  115 */       m = (str = this.c.get(b1)).length();
/*      */       int n;
/*  117 */       if ((n = this.a.a(str, i.b.b)) < m) {
/*  118 */         this.f = true;
/*      */       }
/*  120 */       if (m > k) {
/*  121 */         k = m;
/*      */       }
/*      */     } 
/*  124 */     this.e = k;
/*  125 */     if (!this.f && (paramInt & 0x40) == 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  131 */     if (this.g) {
/*  132 */       this.a.a();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  139 */     if (this.g) {
/*      */       
/*  141 */       m = j << 1;
/*      */     } else {
/*  143 */       m = j;
/*      */     } 
/*  145 */     this.d = new short[m];
/*      */     
/*  147 */     if (this.g) {
/*      */       
/*  149 */       b2 = j;
/*      */     } else {
/*      */       
/*  152 */       b2 = 0;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  157 */     for (b1 = 0; b1 < j; b1++) {
/*      */       String str;
/*  159 */       m = (str = this.c.get(b1)).length();
/*      */       int n;
/*  161 */       if ((n = this.a.a(str, i.b.b)) < m) {
/*      */         
/*  163 */         if (0 != (paramInt & 0x2)) {
/*  164 */           if (0 != (paramInt & 0x20)) {
/*  165 */             this.d[b1] = c(n);
/*      */           }
/*  167 */           if (0 != (paramInt & 0x10)) {
/*      */             
/*  169 */             n = m - this.a.b(str, m, i.b.b);
/*  170 */             this.d[b2 + b1] = c(n);
/*      */           } 
/*      */         } else {
/*  173 */           this.d[b2 + b1] = 0; this.d[b1] = 0;
/*      */         } 
/*      */ 
/*      */         
/*  177 */         if (0 != (paramInt & 0x1)) {
/*      */ 
/*      */ 
/*      */           
/*  181 */           if (0 != (paramInt & 0x20)) {
/*  182 */             n = str.codePointAt(0);
/*  183 */             b(n);
/*      */           } 
/*  185 */           if (0 != (paramInt & 0x10)) {
/*  186 */             n = str.codePointBefore(m);
/*  187 */             b(n);
/*      */           }
/*      */         
/*      */         } 
/*  191 */       } else if (this.g) {
/*  192 */         this.d[b2 + b1] = 255; this.d[b1] = 255;
/*      */       } else {
/*      */         
/*  195 */         this.d[b1] = 255;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  201 */     if (this.g) {
/*  202 */       this.b.a();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a() {
/*  234 */     return this.f;
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean a(int paramInt) {
/*  239 */     return this.a.b(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(int paramInt) {
/*  247 */     if (ba.a(this.b, (Object)null) || ba.a(this.b, this.a)) {
/*  248 */       if (this.a.b(paramInt)) {
/*      */         return;
/*      */       }
/*  251 */       this.b = this.a.b();
/*      */     } 
/*  253 */     this.b.a(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(CharSequence paramCharSequence, int paramInt, i.b paramb) {
/*  368 */     if (paramb == i.b.a) {
/*  369 */       return b(paramCharSequence, paramInt, (am)null);
/*      */     }
/*      */     int j;
/*  372 */     if ((j = this.a.a(paramCharSequence, paramInt, i.b.b)) == paramCharSequence.length()) {
/*  373 */       return j;
/*      */     }
/*  375 */     return a(paramCharSequence, paramInt, j, paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private synchronized int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, i.b paramb) {
/*  387 */     int j = 0;
/*  388 */     if (paramb == i.b.b)
/*      */     {
/*  390 */       j = this.e;
/*      */     }
/*  392 */     this.h.a(j);
/*  393 */     j = paramCharSequence.length();
/*  394 */     int k = paramInt2, m = j - paramInt2;
/*  395 */     paramInt1 = paramInt2 - paramInt1;
/*  396 */     int n = this.c.size();
/*      */     while (true) {
/*  398 */       if (paramb == i.b.b)
/*  399 */       { for (paramInt2 = 0; paramInt2 < n; paramInt2++) {
/*      */           short s;
/*  401 */           if ((s = this.d[paramInt2]) != 255) {
/*      */             int i2;
/*      */             
/*      */             String str;
/*      */             
/*  406 */             int i3 = (str = this.c.get(paramInt2)).length();
/*      */ 
/*      */             
/*  409 */             if (s >= 254) {
/*  410 */               i2 = i3;
/*      */               
/*  412 */               i2 = str.offsetByCodePoints(i2, -1);
/*      */             } 
/*      */             
/*  415 */             if (i2 > paramInt1) {
/*  416 */               i2 = paramInt1;
/*      */             }
/*  418 */             int i4 = i3 - i2;
/*      */             
/*  420 */             while (i4 <= m) {
/*      */ 
/*      */ 
/*      */               
/*  424 */               if (!this.h.d(i4) && a(paramCharSequence, k - i2, j, str, i3)) {
/*  425 */                 if (i4 == m) {
/*  426 */                   return j;
/*      */                 }
/*  428 */                 this.h.c(i4);
/*      */               } 
/*  430 */               if (i2 != 0)
/*      */               
/*      */               { 
/*  433 */                 i2--;
/*  434 */                 i4++; } 
/*      */             } 
/*      */           } 
/*      */         }  }
/*  438 */       else { int i2 = 0, i3 = 0;
/*  439 */         for (paramInt2 = 0; paramInt2 < n; paramInt2++) {
/*  440 */           int i4 = this.d[paramInt2];
/*      */ 
/*      */           
/*      */           String str;
/*      */ 
/*      */           
/*  446 */           int i5 = (str = this.c.get(paramInt2)).length();
/*      */ 
/*      */           
/*  449 */           if (i4 >= 254) {
/*  450 */             i4 = i5;
/*      */           }
/*      */ 
/*      */           
/*  454 */           if (i4 > paramInt1) {
/*  455 */             i4 = paramInt1;
/*      */           }
/*  457 */           int i6 = i5 - i4;
/*      */           
/*  459 */           while (i6 <= m && i4 >= i3) {
/*      */ 
/*      */ 
/*      */             
/*  463 */             if ((i4 > i3 || i6 > i2) && 
/*  464 */               a(paramCharSequence, k - i4, j, str, i5)) {
/*  465 */               i2 = i6;
/*  466 */               i3 = i4;
/*      */               break;
/*      */             } 
/*  469 */             i4--;
/*  470 */             i6++;
/*      */           } 
/*      */         } 
/*      */         
/*  474 */         if (i2 != 0 || i3 != 0) {
/*      */ 
/*      */           
/*  477 */           k += i2;
/*      */           
/*  479 */           if ((m = m - i2) == 0) {
/*  480 */             return j;
/*      */           }
/*  482 */           paramInt1 = 0;
/*      */           
/*      */           continue;
/*      */         }  }
/*      */ 
/*      */       
/*  488 */       if (paramInt1 != 0 || k == 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  494 */         if (this.h.a()) {
/*  495 */           return k;
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/*  500 */         if (this.h.a()) {
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  505 */           if ((paramInt1 = (paramInt2 = this.a.a(paramCharSequence, k, i.b.b)) - k) == m || paramInt1 == 0)
/*      */           {
/*      */             
/*  508 */             return paramInt2;
/*      */           }
/*  510 */           k += paramInt1;
/*  511 */           m -= paramInt1;
/*      */ 
/*      */           
/*      */           continue;
/*      */         } 
/*      */ 
/*      */         
/*  518 */         if ((paramInt1 = a(this.a, paramCharSequence, k, m)) > 0) {
/*  519 */           if (paramInt1 == m) {
/*  520 */             return j;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  525 */           k += paramInt1;
/*  526 */           m -= paramInt1;
/*  527 */           this.h.b(paramInt1);
/*  528 */           paramInt1 = 0;
/*      */           
/*      */           continue;
/*      */         } 
/*      */       } 
/*      */       
/*  534 */       int i1 = this.h.a((am)null);
/*  535 */       k += i1;
/*  536 */       m -= i1;
/*  537 */       paramInt1 = 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int a(CharSequence paramCharSequence, int paramInt, i.b paramb, am paramam) {
/*  557 */     if (paramb == i.b.a) {
/*  558 */       return b(paramCharSequence, paramInt, paramam);
/*      */     }
/*      */ 
/*      */     
/*  562 */     if (paramb == i.b.b) {
/*  563 */       return a(paramCharSequence, paramInt, paramam);
/*      */     }
/*      */     
/*  566 */     int j = this.c.size();
/*  567 */     int k = paramCharSequence.length();
/*  568 */     int m = paramInt;
/*  569 */     paramInt = k - paramInt;
/*  570 */     byte b1 = 0;
/*  571 */     while (paramInt != 0) {
/*      */ 
/*      */       
/*  574 */       int n = ((n = a(this.a, paramCharSequence, m, paramInt)) > 0) ? n : 0;
/*      */       
/*  576 */       for (byte b2 = 0; b2 < j; b2++) {
/*      */         String str;
/*  578 */         int i1 = (str = this.c.get(b2)).length();
/*  579 */         if (n < i1 && i1 <= paramInt && 
/*  580 */           a(paramCharSequence, m, k, str, i1)) {
/*  581 */           n = i1;
/*      */         }
/*      */       } 
/*      */       
/*  585 */       if (n == 0) {
/*  586 */         paramam.a = b1;
/*  587 */         return m;
/*      */       } 
/*      */       
/*  590 */       b1++;
/*  591 */       m += n;
/*  592 */       paramInt -= n;
/*      */     } 
/*  594 */     paramam.a = b1;
/*  595 */     return m;
/*      */   }
/*      */ 
/*      */   
/*      */   private synchronized int a(CharSequence paramCharSequence, int paramInt, am paramam) {
/*  600 */     this.h.a(this.e);
/*  601 */     int j = this.c.size();
/*  602 */     int k = paramCharSequence.length();
/*  603 */     int m = paramInt;
/*  604 */     paramInt = k - paramInt;
/*  605 */     int n = 0;
/*  606 */     while (paramInt != 0) {
/*      */       int i1;
/*      */       
/*  609 */       if ((i1 = a(this.a, paramCharSequence, m, paramInt)) > 0) {
/*  610 */         this.h.a(i1, n + 1);
/*      */       }
/*      */       
/*  613 */       for (i1 = 0; i1 < j; i1++) {
/*      */         String str;
/*      */         
/*      */         int i2;
/*      */         
/*  618 */         if ((i2 = (str = this.c.get(i1)).length()) <= paramInt && !this.h.b(i2, n + 1) && 
/*  619 */           a(paramCharSequence, m, k, str, i2)) {
/*  620 */           this.h.a(i2, n + 1);
/*      */         }
/*      */       } 
/*      */       
/*  624 */       if (this.h.a()) {
/*  625 */         paramam.a = n;
/*  626 */         return m;
/*      */       } 
/*      */       
/*  629 */       i1 = this.h.a(paramam);
/*  630 */       n = paramam.a;
/*  631 */       m += i1;
/*  632 */       paramInt -= i1;
/*      */     } 
/*  634 */     paramam.a = n;
/*  635 */     return m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final synchronized int b(CharSequence paramCharSequence, int paramInt, i.b paramb) {
/*  646 */     if (paramb == i.b.a) {
/*  647 */       return a(paramCharSequence, paramInt);
/*      */     }
/*      */     int j;
/*  650 */     if ((j = this.a.b(paramCharSequence, paramInt, i.b.b)) == 0) {
/*  651 */       return 0;
/*      */     }
/*  653 */     int k = paramInt - j;
/*      */ 
/*      */     
/*  656 */     int m = 0;
/*  657 */     if (paramb == i.b.b)
/*      */     {
/*  659 */       m = this.e;
/*      */     }
/*  661 */     this.h.a(m);
/*  662 */     int n = this.c.size();
/*  663 */     int i1 = 0;
/*  664 */     if (this.g) {
/*  665 */       i1 = n;
/*      */     }
/*      */     while (true) {
/*  668 */       if (paramb == i.b.b)
/*  669 */       { for (m = 0; m < n; m++) {
/*      */           short s;
/*  671 */           if ((s = this.d[i1 + m]) != 255) {
/*      */             int i2;
/*      */             
/*      */             String str;
/*      */             
/*  676 */             int i3 = (str = this.c.get(m)).length();
/*      */ 
/*      */             
/*  679 */             if (s >= 254) {
/*  680 */               i2 = i3;
/*      */ 
/*      */               
/*  683 */               int i5 = str.offsetByCodePoints(0, 1);
/*  684 */               i2 -= i5;
/*      */             } 
/*  686 */             if (i2 > k) {
/*  687 */               i2 = k;
/*      */             }
/*  689 */             int i4 = i3 - i2;
/*      */             
/*  691 */             while (i4 <= j) {
/*      */ 
/*      */ 
/*      */               
/*  695 */               if (!this.h.d(i4) && a(paramCharSequence, j - i4, paramInt, str, i3)) {
/*  696 */                 if (i4 == j) {
/*  697 */                   return 0;
/*      */                 }
/*  699 */                 this.h.c(i4);
/*      */               } 
/*  701 */               if (i2 != 0)
/*      */               
/*      */               { 
/*  704 */                 i2--;
/*  705 */                 i4++; } 
/*      */             } 
/*      */           } 
/*      */         }  }
/*  709 */       else { int i2 = 0, i3 = 0;
/*  710 */         for (m = 0; m < n; m++) {
/*  711 */           int i4 = this.d[i1 + m];
/*      */ 
/*      */           
/*      */           String str;
/*      */ 
/*      */           
/*  717 */           int i5 = (str = this.c.get(m)).length();
/*      */ 
/*      */           
/*  720 */           if (i4 >= 254) {
/*  721 */             i4 = i5;
/*      */           }
/*      */ 
/*      */           
/*  725 */           if (i4 > k) {
/*  726 */             i4 = k;
/*      */           }
/*  728 */           int i6 = i5 - i4;
/*      */           
/*  730 */           while (i6 <= j && i4 >= i3) {
/*      */ 
/*      */ 
/*      */             
/*  734 */             if ((i4 > i3 || i6 > i2) && 
/*  735 */               a(paramCharSequence, j - i6, paramInt, str, i5)) {
/*  736 */               i2 = i6;
/*  737 */               i3 = i4;
/*      */               break;
/*      */             } 
/*  740 */             i4--;
/*  741 */             i6++;
/*      */           } 
/*      */         } 
/*      */         
/*  745 */         if (i2 != 0 || i3 != 0) {
/*      */ 
/*      */ 
/*      */           
/*  749 */           if ((j = j - i2) == 0) {
/*  750 */             return 0;
/*      */           }
/*  752 */           k = 0;
/*      */           
/*      */           continue;
/*      */         }  }
/*      */ 
/*      */       
/*  758 */       if (k != 0 || j == paramInt) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  764 */         if (this.h.a()) {
/*  765 */           return j;
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/*  770 */         if (this.h.a()) {
/*      */ 
/*      */           
/*  773 */           int i2 = j;
/*  774 */           j = this.a.b(paramCharSequence, i2, i.b.b);
/*  775 */           k = i2 - j;
/*  776 */           if (j == 0 || k == 0)
/*      */           {
/*      */             
/*  779 */             return j;
/*      */           }
/*      */ 
/*      */           
/*      */           continue;
/*      */         } 
/*      */ 
/*      */         
/*  787 */         if ((k = a(this.a, paramCharSequence, j)) > 0) {
/*  788 */           if (k == j) {
/*  789 */             return 0;
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*  794 */           j -= k;
/*  795 */           this.h.b(k);
/*  796 */           k = 0;
/*      */           
/*      */           continue;
/*      */         } 
/*      */       } 
/*      */       
/*  802 */       j -= this.h.a((am)null);
/*  803 */       k = 0;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int b(CharSequence paramCharSequence, int paramInt, am paramam) {
/*  839 */     int j = paramCharSequence.length();
/*  840 */     paramInt = paramInt;
/*  841 */     int k = this.c.size();
/*  842 */     int m = 0;
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*  847 */       if (paramam == null) {
/*  848 */         n = this.b.a(paramCharSequence, paramInt, i.b.a);
/*      */       } else {
/*  850 */         n = this.b.a(paramCharSequence, paramInt, i.b.a, paramam);
/*  851 */         paramam.a = m += paramam.a;
/*      */       } 
/*  853 */       if (n == j) {
/*  854 */         return j;
/*      */       }
/*  856 */       paramInt = n;
/*  857 */       int n = j - n;
/*      */ 
/*      */       
/*      */       int i1;
/*      */       
/*  862 */       if ((i1 = a(this.a, paramCharSequence, paramInt, n)) > 0) {
/*  863 */         return paramInt;
/*      */       }
/*      */ 
/*      */       
/*  867 */       for (byte b = 0; b < k; b++) {
/*  868 */         if (this.d[b] != 255) {
/*      */           String str;
/*      */ 
/*      */           
/*      */           int i2;
/*      */           
/*  874 */           if ((i2 = (str = this.c.get(b)).length()) <= n && a(paramCharSequence, paramInt, j, str, i2)) {
/*  875 */             return paramInt;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  882 */       paramInt -= i1;
/*  883 */       n += i1;
/*  884 */       m++;
/*  885 */       if (n == 0) {
/*  886 */         if (paramam != null) {
/*  887 */           paramam.a = m;
/*      */         }
/*  889 */         return j;
/*      */       } 
/*      */     } 
/*      */   } private int a(CharSequence paramCharSequence, int paramInt) {
/*  893 */     int j = paramInt;
/*  894 */     int k = this.c.size();
/*      */ 
/*      */ 
/*      */     
/*      */     while (true) {
/*  899 */       if ((j = this.b.b(paramCharSequence, j, i.b.a)) == 0) {
/*  900 */         return 0;
/*      */       }
/*      */ 
/*      */       
/*      */       int m;
/*      */       
/*  906 */       if ((m = a(this.a, paramCharSequence, j)) > 0) {
/*  907 */         return j;
/*      */       }
/*      */ 
/*      */       
/*  911 */       for (byte b = 0; b < k; b++) {
/*      */ 
/*      */ 
/*      */         
/*  915 */         if (this.d[b] != 255) {
/*      */           String str;
/*      */ 
/*      */           
/*      */           int n;
/*      */           
/*  921 */           if ((n = (str = this.c.get(b)).length()) <= j && a(paramCharSequence, j - n, paramInt, str, n)) {
/*  922 */             return j;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  930 */       if ((j = j + m) == 0)
/*  931 */         return 0; 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static short c(int paramInt) {
/*  936 */     return (paramInt < 254) ? (short)paramInt : 254;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(CharSequence paramCharSequence, int paramInt1, String paramString, int paramInt2) {
/*  941 */     paramInt1 += paramInt2;
/*  942 */     while (paramInt2-- > 0) {
/*  943 */       if (paramCharSequence.charAt(--paramInt1) != paramString.charAt(paramInt2)) {
/*  944 */         return false;
/*      */       }
/*      */     } 
/*  947 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString, int paramInt3) {
/*  961 */     if (a(paramCharSequence, paramInt1, paramString, paramInt3) && (paramInt1 <= 0 || 
/*  962 */       !Character.isHighSurrogate(paramCharSequence.charAt(paramInt1 - 1)) || 
/*  963 */       !Character.isLowSurrogate(paramCharSequence.charAt(paramInt1))) && (paramInt1 + paramInt3 >= paramInt2 || 
/*  964 */       !Character.isHighSurrogate(paramCharSequence.charAt(paramInt1 + paramInt3 - 1)) || 
/*  965 */       !Character.isLowSurrogate(paramCharSequence.charAt(paramInt1 + paramInt3)))) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int a(i parami, CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*      */     char c1;
/*      */     char c2;
/*  974 */     if ((c2 = paramCharSequence.charAt(paramInt1)) >= '?' && c2 <= '?' && paramInt2 >= 2 && 
/*      */       
/*  976 */       am.b(c1 = paramCharSequence.charAt(paramInt1 + 1))) {
/*  977 */       int j = Character.toCodePoint(c2, c1);
/*  978 */       return parami.b(j) ? 2 : -2;
/*      */     } 
/*      */     
/*  981 */     return parami.b(c2) ? 1 : -1;
/*      */   }
/*      */   private static int a(i parami, CharSequence paramCharSequence, int paramInt) {
/*      */     char c1;
/*      */     char c2;
/*  986 */     if ((c2 = paramCharSequence.charAt(paramInt - 1)) >= '?' && c2 <= '?' && paramInt >= 2 && 
/*      */       
/*  988 */       am.c(c1 = paramCharSequence.charAt(paramInt - 2))) {
/*  989 */       int j = Character.toCodePoint(c1, c2);
/*  990 */       return parami.b(j) ? 2 : -2;
/*      */     } 
/*      */     
/*  993 */     return parami.b(c2) ? 1 : -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class a
/*      */   {
/*      */     private int c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1034 */     private int[] a = new int[16];
/*      */ 
/*      */     
/*      */     public final void a(int param1Int) {
/* 1038 */       if (param1Int > this.a.length) {
/* 1039 */         this.a = new int[param1Int];
/*      */       }
/* 1041 */       b();
/*      */     }
/*      */     
/*      */     private void b() {
/* 1045 */       for (int i = this.a.length; i-- > 0;) {
/* 1046 */         this.a[i] = 0;
/*      */       }
/* 1048 */       this.c = this.b = 0;
/*      */     }
/*      */     
/*      */     public final boolean a() {
/* 1052 */       return (this.b == 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void b(int param1Int) {
/* 1064 */       if ((param1Int = this.c + param1Int) >= this.a.length) {
/* 1065 */         param1Int -= this.a.length;
/*      */       }
/* 1067 */       if (this.a[param1Int] != 0) {
/* 1068 */         this.a[param1Int] = 0;
/* 1069 */         this.b--;
/*      */       } 
/* 1071 */       this.c = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void c(int param1Int) {
/* 1080 */       if ((param1Int = this.c + param1Int) >= this.a.length) {
/* 1081 */         param1Int -= this.a.length;
/*      */       }
/* 1083 */       if (!d && this.a[param1Int] != 0) throw new AssertionError(); 
/* 1084 */       this.a[param1Int] = 1;
/* 1085 */       this.b++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void a(int param1Int1, int param1Int2) {
/* 1094 */       if (!d && param1Int2 <= 0) throw new AssertionError();
/*      */       
/* 1096 */       if ((param1Int1 = this.c + param1Int1) >= this.a.length) {
/* 1097 */         param1Int1 -= this.a.length;
/*      */       }
/* 1099 */       if (this.a[param1Int1] == 0) {
/* 1100 */         this.a[param1Int1] = param1Int2;
/* 1101 */         this.b++; return;
/* 1102 */       }  if (param1Int2 < this.a[param1Int1]) {
/* 1103 */         this.a[param1Int1] = param1Int2;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean d(int param1Int) {
/* 1112 */       if ((param1Int = this.c + param1Int) >= this.a.length) {
/* 1113 */         param1Int -= this.a.length;
/*      */       }
/* 1115 */       return (this.a[param1Int] != 0);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final boolean b(int param1Int1, int param1Int2) {
/* 1123 */       if ((param1Int1 = this.c + param1Int1) >= this.a.length) {
/* 1124 */         param1Int1 -= this.a.length;
/*      */       }
/*      */       
/* 1127 */       if ((param1Int1 = this.a[param1Int1]) != 0 && param1Int1 <= param1Int2) return true;  return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final int a(am param1am) {
/* 1137 */       int i = this.c;
/* 1138 */       while (++i < this.a.length) {
/*      */         int m;
/* 1140 */         if ((m = this.a[i]) != 0) {
/* 1141 */           this.a[i] = 0;
/* 1142 */           this.b--;
/* 1143 */           int n = i - this.c;
/* 1144 */           this.c = i;
/* 1145 */           if (param1am != null) param1am.a = m; 
/* 1146 */           return n;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1153 */       int j = this.a.length - this.c;
/* 1154 */       i = 0;
/*      */       int k;
/* 1156 */       while ((k = this.a[i]) == 0) {
/* 1157 */         i++;
/*      */       }
/* 1159 */       this.a[i] = 0;
/* 1160 */       this.b--;
/* 1161 */       this.c = i;
/* 1162 */       if (param1am != null) param1am.a = k; 
/* 1163 */       return j + i;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */