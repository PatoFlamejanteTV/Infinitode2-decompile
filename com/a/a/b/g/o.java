/*      */ package com.a.a.b.g;
/*      */ 
/*      */ import com.a.a.b.c.h;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
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
/*      */ public final class o
/*      */ {
/*   29 */   private static char[] a = new char[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final a b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] c;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int d;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ArrayList<char[]> f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int h;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] i;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int j;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String k;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private char[] l;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public o(a parama) {
/*  124 */     this.b = parama;
/*      */   }
/*      */ 
/*      */   
/*      */   private o(a parama, char[] paramArrayOfchar) {
/*  129 */     this.b = parama;
/*  130 */     this.i = paramArrayOfchar;
/*  131 */     this.j = paramArrayOfchar.length;
/*  132 */     this.d = -1;
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
/*      */   public static o a(char[] paramArrayOfchar) {
/*  147 */     return new o(null, paramArrayOfchar);
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
/*      */   public final void a() {
/*  165 */     this.d = -1;
/*  166 */     this.j = 0;
/*  167 */     this.e = 0;
/*      */     
/*  169 */     this.c = null;
/*      */ 
/*      */     
/*  172 */     this.l = null;
/*      */     
/*  174 */     if (this.g) {
/*  175 */       l();
/*      */     }
/*      */ 
/*      */     
/*  179 */     if (this.b != null && 
/*  180 */       this.i != null) {
/*      */       
/*  182 */       char[] arrayOfChar = this.i;
/*  183 */       this.i = null;
/*  184 */       this.b.a(2, arrayOfChar);
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
/*      */   public final void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  247 */     this.k = null;
/*  248 */     this.l = null;
/*      */ 
/*      */     
/*  251 */     this.c = paramArrayOfchar;
/*  252 */     this.d = paramInt1;
/*  253 */     this.e = paramInt2;
/*      */ 
/*      */     
/*  256 */     if (this.g) {
/*  257 */       l();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final void b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  263 */     this.c = null;
/*  264 */     this.d = -1;
/*  265 */     this.e = 0;
/*      */     
/*  267 */     this.k = null;
/*  268 */     this.l = null;
/*      */ 
/*      */     
/*  271 */     if (this.g) {
/*  272 */       l();
/*  273 */     } else if (this.i == null) {
/*  274 */       this.i = c(paramInt2);
/*      */     } 
/*  276 */     this.j = this.h = 0;
/*  277 */     c(paramArrayOfchar, paramInt1, paramInt2);
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
/*      */   public final void a(String paramString) {
/*  301 */     this.c = null;
/*  302 */     this.d = -1;
/*  303 */     this.e = 0;
/*      */     
/*  305 */     this.k = paramString;
/*  306 */     this.l = null;
/*      */     
/*  308 */     if (this.g) {
/*  309 */       l();
/*      */     }
/*  311 */     this.j = 0;
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
/*      */   private char[] c(int paramInt) {
/*  331 */     if (this.b != null) {
/*  332 */       return this.b.a(2, paramInt);
/*      */     }
/*  334 */     return new char[Math.max(paramInt, 500)];
/*      */   }
/*      */ 
/*      */   
/*      */   private void l() {
/*  339 */     this.g = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  347 */     this.f.clear();
/*  348 */     this.j = this.h = 0;
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
/*      */   public final int b() {
/*  361 */     if (this.d >= 0) {
/*  362 */       return this.e;
/*      */     }
/*  364 */     if (this.l != null) {
/*  365 */       return this.l.length;
/*      */     }
/*  367 */     if (this.k != null) {
/*  368 */       return this.k.length();
/*      */     }
/*      */     
/*  371 */     return this.h + this.j;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int c() {
/*  379 */     return (this.d >= 0) ? this.d : 0;
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
/*      */   public final char[] d() {
/*  408 */     if (this.d >= 0) return this.c; 
/*  409 */     if (this.l != null) return this.l; 
/*  410 */     if (this.k != null) {
/*  411 */       return this.l = this.k.toCharArray();
/*      */     }
/*      */     
/*  414 */     if (!this.g) {
/*  415 */       return (this.i == null) ? a : this.i;
/*      */     }
/*      */     
/*  418 */     return f();
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
/*      */   public final String e() {
/*  436 */     if (this.k == null)
/*      */     {
/*  438 */       if (this.l != null) {
/*  439 */         this.k = new String(this.l);
/*      */       
/*      */       }
/*  442 */       else if (this.d >= 0) {
/*  443 */         if (this.e <= 0) {
/*  444 */           return this.k = "";
/*      */         }
/*  446 */         this.k = new String(this.c, this.d, this.e);
/*      */       } else {
/*      */         
/*  449 */         int i = this.h;
/*  450 */         int j = this.j;
/*      */         
/*  452 */         if (i == 0) {
/*  453 */           this.k = (j == 0) ? "" : new String(this.i, 0, j);
/*      */         } else {
/*  455 */           StringBuilder stringBuilder = new StringBuilder(i + j);
/*      */           
/*  457 */           if (this.f != null) {
/*  458 */             int k; for (j = 0, k = this.f.size(); j < k; j++) {
/*  459 */               char[] arrayOfChar = this.f.get(j);
/*  460 */               stringBuilder.append(arrayOfChar, 0, arrayOfChar.length);
/*      */             } 
/*      */           } 
/*      */           
/*  464 */           stringBuilder.append(this.i, 0, this.j);
/*  465 */           this.k = stringBuilder.toString();
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  471 */     return this.k;
/*      */   }
/*      */   
/*      */   public final char[] f() {
/*      */     char[] arrayOfChar;
/*  476 */     if ((arrayOfChar = this.l) == null) {
/*  477 */       this.l = arrayOfChar = n();
/*      */     }
/*  479 */     return arrayOfChar;
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
/*      */   public final double a(boolean paramBoolean) {
/*  533 */     return h.b(e(), paramBoolean);
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
/*      */   public final float b(boolean paramBoolean) {
/*  562 */     return h.c(e(), paramBoolean);
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
/*      */   public final int c(boolean paramBoolean) {
/*  581 */     if (this.d >= 0 && this.c != null) {
/*  582 */       if (paramBoolean) {
/*  583 */         return -h.a(this.c, this.d + 1, this.e - 1);
/*      */       }
/*  585 */       return h.a(this.c, this.d, this.e);
/*      */     } 
/*  587 */     if (paramBoolean) {
/*  588 */       return -h.a(this.i, 1, this.j - 1);
/*      */     }
/*  590 */     return h.a(this.i, 0, this.j);
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
/*      */   public final long d(boolean paramBoolean) {
/*  609 */     if (this.d >= 0 && this.c != null) {
/*  610 */       if (paramBoolean) {
/*  611 */         return -h.b(this.c, this.d + 1, this.e - 1);
/*      */       }
/*  613 */       return h.b(this.c, this.d, this.e);
/*      */     } 
/*  615 */     if (paramBoolean) {
/*  616 */       return -h.b(this.i, 1, this.j - 1);
/*      */     }
/*  618 */     return h.b(this.i, 0, this.j);
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
/*      */   public final void a(char paramChar) {
/*  686 */     if (this.d >= 0) {
/*  687 */       d(16);
/*      */     }
/*  689 */     this.k = null;
/*  690 */     this.l = null;
/*      */     
/*  692 */     char[] arrayOfChar = this.i;
/*  693 */     if (this.j >= arrayOfChar.length) {
/*  694 */       m();
/*  695 */       arrayOfChar = this.i;
/*      */     } 
/*  697 */     arrayOfChar[this.j++] = paramChar;
/*      */   }
/*      */ 
/*      */   
/*      */   public final void c(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*      */     int i;
/*  703 */     if (this.d >= 0) {
/*  704 */       d(paramInt2);
/*      */     }
/*  706 */     this.k = null;
/*  707 */     this.l = null;
/*      */     
/*      */     char[] arrayOfChar;
/*      */     
/*      */     int j;
/*      */     
/*  713 */     if ((j = (arrayOfChar = this.i).length - this.j) >= paramInt2) {
/*  714 */       System.arraycopy(paramArrayOfchar, paramInt1, arrayOfChar, this.j, paramInt2);
/*  715 */       this.j += paramInt2;
/*      */       
/*      */       return;
/*      */     } 
/*  719 */     if (j > 0) {
/*  720 */       System.arraycopy(paramArrayOfchar, paramInt1, arrayOfChar, this.j, j);
/*  721 */       paramInt1 += j;
/*  722 */       paramInt2 -= j;
/*      */     } 
/*      */ 
/*      */     
/*      */     do {
/*  727 */       m();
/*  728 */       i = Math.min(this.i.length, paramInt2);
/*  729 */       System.arraycopy(paramArrayOfchar, paramInt1, this.i, 0, i);
/*  730 */       this.j += i;
/*  731 */       paramInt1 += i;
/*      */     }
/*  733 */     while ((paramInt2 = paramInt2 - i) > 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public final void a(String paramString, int paramInt1, int paramInt2) {
/*      */     int i;
/*  739 */     if (this.d >= 0) {
/*  740 */       d(paramInt2);
/*      */     }
/*  742 */     this.k = null;
/*  743 */     this.l = null;
/*      */     
/*      */     char[] arrayOfChar;
/*      */     
/*      */     int j;
/*  748 */     if ((j = (arrayOfChar = this.i).length - this.j) >= paramInt2) {
/*  749 */       paramString.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, this.j);
/*  750 */       this.j += paramInt2;
/*      */       
/*      */       return;
/*      */     } 
/*  754 */     if (j > 0) {
/*  755 */       paramString.getChars(paramInt1, paramInt1 + j, arrayOfChar, this.j);
/*  756 */       paramInt2 -= j;
/*  757 */       paramInt1 += j;
/*      */     } 
/*      */ 
/*      */     
/*      */     do {
/*  762 */       m();
/*  763 */       i = Math.min(this.i.length, paramInt2);
/*  764 */       paramString.getChars(paramInt1, paramInt1 + i, this.i, 0);
/*  765 */       this.j += i;
/*  766 */       paramInt1 += i;
/*      */     }
/*  768 */     while ((paramInt2 = paramInt2 - i) > 0);
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
/*      */   public final char[] g() {
/*  783 */     if (this.d >= 0) {
/*  784 */       d(1);
/*      */     } else {
/*      */       char[] arrayOfChar;
/*  787 */       if ((arrayOfChar = this.i) == null) {
/*  788 */         this.i = c(0);
/*  789 */       } else if (this.j >= arrayOfChar.length) {
/*      */         
/*  791 */         m();
/*      */       } 
/*      */     } 
/*  794 */     return this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final char[] h() {
/*  800 */     this.d = -1;
/*  801 */     this.j = 0;
/*  802 */     this.e = 0;
/*      */     
/*  804 */     this.c = null;
/*  805 */     this.k = null;
/*  806 */     this.l = null;
/*      */ 
/*      */     
/*  809 */     if (this.g) {
/*  810 */       l();
/*      */     }
/*      */     char[] arrayOfChar;
/*  813 */     if ((arrayOfChar = this.i) == null) {
/*  814 */       this.i = arrayOfChar = c(0);
/*      */     }
/*  816 */     return arrayOfChar;
/*      */   }
/*      */   
/*  819 */   public final int i() { return this.j; } public final void a(int paramInt) {
/*  820 */     this.j = paramInt;
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
/*      */   public final String b(int paramInt) {
/*  835 */     this.j = paramInt;
/*      */     
/*  837 */     if (this.h > 0) {
/*  838 */       return e();
/*      */     }
/*      */ 
/*      */     
/*  842 */     String str = ((paramInt = this.j) == 0) ? "" : new String(this.i, 0, paramInt);
/*  843 */     this.k = str;
/*  844 */     return str;
/*      */   }
/*      */   
/*      */   public final char[] j() {
/*  848 */     if (this.f == null) {
/*  849 */       this.f = (ArrayList)new ArrayList<>();
/*      */     }
/*  851 */     this.g = true;
/*  852 */     this.f.add(this.i);
/*  853 */     int i = this.i.length;
/*  854 */     this.h += i;
/*  855 */     this.j = 0;
/*      */ 
/*      */ 
/*      */     
/*  859 */     if ((i = i + (i >> 1)) < 500) {
/*  860 */       i = 500;
/*  861 */     } else if (i > 65536) {
/*  862 */       i = 65536;
/*      */     } 
/*  864 */     char[] arrayOfChar = e(i);
/*  865 */     this.i = arrayOfChar;
/*  866 */     return arrayOfChar;
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
/*      */   public final char[] k() {
/*      */     char[] arrayOfChar;
/*      */     int i;
/*      */     int j;
/*  884 */     if ((j = (i = (arrayOfChar = this.i).length) + (i >> 1)) > 65536) {
/*  885 */       j = i + (i >> 2);
/*      */     }
/*  887 */     return this.i = Arrays.copyOf(arrayOfChar, j);
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
/*      */   public final String toString() {
/*  919 */     return e();
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
/*      */   private void d(int paramInt) {
/*  933 */     int i = this.e;
/*  934 */     this.e = 0;
/*  935 */     char[] arrayOfChar = this.c;
/*  936 */     this.c = null;
/*  937 */     int j = this.d;
/*  938 */     this.d = -1;
/*      */ 
/*      */     
/*  941 */     paramInt = i + paramInt;
/*  942 */     if (this.i == null || paramInt > this.i.length) {
/*  943 */       this.i = c(paramInt);
/*      */     }
/*  945 */     if (i > 0) {
/*  946 */       System.arraycopy(arrayOfChar, j, this.i, 0, i);
/*      */     }
/*  948 */     this.h = 0;
/*  949 */     this.j = i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void m() {
/*  956 */     if (this.f == null) {
/*  957 */       this.f = (ArrayList)new ArrayList<>();
/*      */     }
/*  959 */     char[] arrayOfChar = this.i;
/*  960 */     this.g = true;
/*  961 */     this.f.add(arrayOfChar);
/*  962 */     this.h += arrayOfChar.length;
/*  963 */     this.j = 0;
/*      */ 
/*      */     
/*      */     int i;
/*      */     
/*  968 */     if ((i = (i = arrayOfChar.length) + (i >> 1)) < 500) {
/*  969 */       i = 500;
/*  970 */     } else if (i > 65536) {
/*  971 */       i = 65536;
/*      */     } 
/*  973 */     this.i = e(i);
/*      */   }
/*      */ 
/*      */   
/*      */   private char[] n() {
/*  978 */     if (this.k != null) {
/*  979 */       return this.k.toCharArray();
/*      */     }
/*      */     
/*  982 */     if (this.d >= 0) {
/*      */       int k;
/*  984 */       if ((k = this.e) <= 0) {
/*  985 */         return a;
/*      */       }
/*      */       int m;
/*  988 */       if ((m = this.d) == 0) {
/*  989 */         return Arrays.copyOf(this.c, k);
/*      */       }
/*  991 */       return Arrays.copyOfRange(this.c, m, m + k);
/*      */     } 
/*      */     
/*      */     int i;
/*  995 */     if ((i = b()) <= 0) {
/*  996 */       return a;
/*      */     }
/*  998 */     int j = 0;
/*  999 */     char[] arrayOfChar = e(i);
/* 1000 */     if (this.f != null) {
/* 1001 */       byte b; int k; for (b = 0, k = this.f.size(); b < k; b++) {
/*      */         char[] arrayOfChar1;
/* 1003 */         int m = (arrayOfChar1 = this.f.get(b)).length;
/* 1004 */         System.arraycopy(arrayOfChar1, 0, arrayOfChar, j, m);
/* 1005 */         j += m;
/*      */       } 
/*      */     } 
/* 1008 */     System.arraycopy(this.i, 0, arrayOfChar, j, this.j);
/* 1009 */     return arrayOfChar;
/*      */   }
/*      */   private static char[] e(int paramInt) {
/* 1012 */     return new char[paramInt];
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\g\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */