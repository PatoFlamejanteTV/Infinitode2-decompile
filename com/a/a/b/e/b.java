/*     */ package com.a.a.b.e;
/*     */ 
/*     */ import com.a.a.b.f;
/*     */ import com.a.a.b.g.g;
/*     */ import java.util.Arrays;
/*     */ import java.util.BitSet;
/*     */ import java.util.concurrent.atomic.AtomicReference;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/*     */   private b e;
/*     */   private AtomicReference<b> f;
/*     */   private int g;
/*     */   private int h;
/*     */   private boolean i;
/*     */   protected String[] a;
/*     */   protected a[] b;
/*     */   protected int c;
/*     */   private int j;
/*     */   private int k;
/*     */   protected int d;
/*     */   private boolean l;
/*     */   private BitSet m;
/*     */   
/*     */   private b(int paramInt) {
/* 232 */     this.e = null;
/* 233 */     this.g = paramInt;
/*     */ 
/*     */     
/* 236 */     this.i = true;
/* 237 */     this.h = -1;
/*     */     
/* 239 */     this.l = false;
/* 240 */     this.d = 0;
/*     */     
/* 242 */     this.f = new AtomicReference<>(b.a(64));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b(b paramb, int paramInt1, int paramInt2, b paramb1) {
/* 253 */     this.e = paramb;
/* 254 */     this.g = paramInt2;
/* 255 */     this.f = null;
/* 256 */     this.h = paramInt1;
/* 257 */     this.i = f.a.b.a(paramInt1);
/*     */ 
/*     */     
/* 260 */     this.a = paramb1.c;
/* 261 */     this.b = paramb1.d;
/*     */     
/* 263 */     this.c = paramb1.a;
/* 264 */     this.d = paramb1.b;
/*     */ 
/*     */     
/* 267 */     int i = this.a.length;
/* 268 */     this.j = b(i);
/* 269 */     this.k = i - 1;
/*     */ 
/*     */     
/* 272 */     this.l = true;
/*     */   }
/*     */   private static int b(int paramInt) {
/* 275 */     return paramInt - (paramInt >> 2);
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
/*     */   public static b a() {
/*     */     int i;
/*     */     long l;
/* 297 */     return c(i = (int)(l = System.currentTimeMillis()) + (int)(l >>> 32L) | 0x1);
/*     */   }
/*     */   
/*     */   private static b c(int paramInt) {
/* 301 */     return new b(paramInt);
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
/*     */   public final b a(int paramInt) {
/* 320 */     return new b(this, paramInt, this.g, this.f.get());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b() {
/* 331 */     if (!d()) {
/*     */       return;
/*     */     }
/* 334 */     if (this.e != null && this.i) {
/* 335 */       this.e.a(new b(this));
/*     */ 
/*     */       
/* 338 */       this.l = true;
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
/*     */   private void a(b paramb) {
/* 351 */     int i = paramb.a;
/* 352 */     b b1 = this.f.get();
/*     */ 
/*     */ 
/*     */     
/* 356 */     if (i == b1.a) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 363 */     if (i > 12000)
/*     */     {
/* 365 */       paramb = b.a(64);
/*     */     }
/* 367 */     this.f.compareAndSet(b1, paramb);
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
/*     */   private boolean d() {
/* 394 */     return !this.l; } public final int c() {
/* 395 */     return this.g;
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
/*     */   public final String a(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 436 */     if (paramInt2 <= 0) {
/* 437 */       return "";
/*     */     }
/* 439 */     if (!this.i) {
/* 440 */       return new String(paramArrayOfchar, paramInt1, paramInt2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 448 */     paramInt3 = d(paramInt3);
/*     */     
/*     */     String str;
/*     */     
/* 452 */     if ((str = this.a[paramInt3]) != null) {
/*     */       
/* 454 */       if (str.length() == paramInt2) {
/* 455 */         byte b1 = 0;
/* 456 */         while (str.charAt(b1) == paramArrayOfchar[paramInt1 + b1]) {
/*     */           
/* 458 */           if (++b1 == paramInt2) {
/* 459 */             return str;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       a a1;
/* 464 */       if ((a1 = this.b[paramInt3 >> 1]) != null) {
/*     */         
/* 466 */         if ((str = a1.a(paramArrayOfchar, paramInt1, paramInt2)) != null) {
/* 467 */           return str;
/*     */         }
/*     */         
/* 470 */         if ((str = a(paramArrayOfchar, paramInt1, paramInt2, a1.b)) != null) {
/* 471 */           return str;
/*     */         }
/*     */       } 
/*     */     } 
/* 475 */     return b(paramArrayOfchar, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */   
/*     */   private static String a(char[] paramArrayOfchar, int paramInt1, int paramInt2, a parama) {
/* 479 */     while (parama != null) {
/*     */       String str;
/* 481 */       if ((str = parama.a(paramArrayOfchar, paramInt1, paramInt2)) != null) {
/* 482 */         return str;
/*     */       }
/* 484 */       parama = parama.b;
/*     */     } 
/* 486 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String b(char[] paramArrayOfchar, int paramInt1, int paramInt2, int paramInt3) {
/* 491 */     if (this.l) {
/* 492 */       e();
/* 493 */       this.l = false;
/* 494 */     } else if (this.c >= this.j) {
/* 495 */       f();
/*     */ 
/*     */       
/* 498 */       paramInt3 = d(a(paramArrayOfchar, paramInt1, paramInt2));
/*     */     } 
/*     */     
/* 501 */     String str = new String(paramArrayOfchar, paramInt1, paramInt2);
/* 502 */     if (f.a.a.a(this.h)) {
/* 503 */       str = g.a.a(str);
/*     */     }
/* 505 */     this.c++;
/*     */     
/* 507 */     if (this.a[paramInt3] == null) {
/* 508 */       this.a[paramInt3] = str;
/*     */     } else {
/* 510 */       paramInt1 = paramInt3 >> 1;
/*     */       a a1;
/*     */       int i;
/* 513 */       if ((i = (a1 = new a(str, this.b[paramInt1])).c) > 150) {
/*     */ 
/*     */         
/* 516 */         a(paramInt1, a1, paramInt3);
/*     */       } else {
/* 518 */         this.b[paramInt1] = a1;
/* 519 */         this.d = Math.max(i, this.d);
/*     */       } 
/*     */     } 
/* 522 */     return str;
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
/*     */   private void a(int paramInt1, a parama, int paramInt2) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield m : Ljava/util/BitSet;
/*     */     //   4: ifnonnull -> 21
/*     */     //   7: aload_0
/*     */     //   8: new java/util/BitSet
/*     */     //   11: dup
/*     */     //   12: invokespecial <init> : ()V
/*     */     //   15: putfield m : Ljava/util/BitSet;
/*     */     //   18: goto -> 60
/*     */     //   21: aload_0
/*     */     //   22: getfield m : Ljava/util/BitSet;
/*     */     //   25: iload_1
/*     */     //   26: invokevirtual get : (I)Z
/*     */     //   29: ifeq -> 60
/*     */     //   32: getstatic com/a/a/b/f$a.c : Lcom/a/a/b/f$a;
/*     */     //   35: aload_0
/*     */     //   36: getfield h : I
/*     */     //   39: invokevirtual a : (I)Z
/*     */     //   42: ifeq -> 52
/*     */     //   45: aload_0
/*     */     //   46: sipush #150
/*     */     //   49: invokevirtual e : (I)V
/*     */     //   52: aload_0
/*     */     //   53: iconst_0
/*     */     //   54: putfield i : Z
/*     */     //   57: goto -> 68
/*     */     //   60: aload_0
/*     */     //   61: getfield m : Ljava/util/BitSet;
/*     */     //   64: iload_1
/*     */     //   65: invokevirtual set : (I)V
/*     */     //   68: aload_0
/*     */     //   69: getfield a : [Ljava/lang/String;
/*     */     //   72: iload_3
/*     */     //   73: aload_2
/*     */     //   74: getfield a : Ljava/lang/String;
/*     */     //   77: aastore
/*     */     //   78: aload_0
/*     */     //   79: getfield b : [Lcom/a/a/b/e/b$a;
/*     */     //   82: iload_1
/*     */     //   83: aconst_null
/*     */     //   84: aastore
/*     */     //   85: aload_0
/*     */     //   86: dup
/*     */     //   87: getfield c : I
/*     */     //   90: aload_2
/*     */     //   91: getfield c : I
/*     */     //   94: isub
/*     */     //   95: putfield c : I
/*     */     //   98: aload_0
/*     */     //   99: iconst_m1
/*     */     //   100: putfield d : I
/*     */     //   103: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #534	-> 0
/*     */     //   #535	-> 7
/*     */     //   #536	-> 18
/*     */     //   #538	-> 21
/*     */     //   #540	-> 32
/*     */     //   #541	-> 45
/*     */     //   #545	-> 52
/*     */     //   #547	-> 60
/*     */     //   #552	-> 68
/*     */     //   #553	-> 78
/*     */     //   #555	-> 85
/*     */     //   #557	-> 98
/*     */     //   #558	-> 103
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
/*     */   private int d(int paramInt) {
/* 573 */     return (paramInt = (paramInt = (paramInt = paramInt + (paramInt >>> 15)) ^ paramInt << 7) + (paramInt >>> 3)) & this.k;
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
/*     */   private int a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 589 */     int i = this.g;
/* 590 */     for (int j = paramInt1; j < paramInt1; j++) {
/* 591 */       i = i * 33 + paramArrayOfchar[j];
/*     */     }
/*     */     
/* 594 */     return (i == 0) ? 1 : i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int a(String paramString) {
/* 599 */     int i = paramString.length();
/*     */     
/* 601 */     int j = this.g;
/* 602 */     for (byte b1 = 0; b1 < i; b1++) {
/* 603 */       j = j * 33 + paramString.charAt(b1);
/*     */     }
/*     */     
/* 606 */     return (j == 0) ? 1 : j;
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
/*     */   private void e() {
/* 620 */     String[] arrayOfString = this.a;
/* 621 */     this.a = Arrays.<String>copyOf(arrayOfString, arrayOfString.length);
/* 622 */     a[] arrayOfA = this.b;
/* 623 */     this.b = Arrays.<a>copyOf(arrayOfA, arrayOfA.length);
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
/*     */   private void f() {
/*     */     int i, j;
/* 641 */     if ((j = (i = this.a.length) + i) > 65536) {
/*     */ 
/*     */       
/* 644 */       this.c = 0;
/* 645 */       this.i = false;
/*     */       
/* 647 */       this.a = new String[64];
/* 648 */       this.b = new a[32];
/* 649 */       this.k = 63;
/* 650 */       this.l = false;
/*     */       
/*     */       return;
/*     */     } 
/* 654 */     String[] arrayOfString = this.a;
/* 655 */     a[] arrayOfA = this.b;
/* 656 */     this.a = new String[j];
/* 657 */     this.b = new a[j >> 1];
/*     */     
/* 659 */     this.k = j - 1;
/* 660 */     this.j = b(j);
/*     */     
/* 662 */     j = 0;
/*     */ 
/*     */ 
/*     */     
/* 666 */     int k = 0; int m;
/* 667 */     for (m = 0; m < i; m++) {
/*     */       String str;
/* 669 */       if ((str = arrayOfString[m]) != null) {
/* 670 */         j++;
/* 671 */         int n = d(a(str));
/* 672 */         if (this.a[n] == null) {
/* 673 */           this.a[n] = str;
/*     */         } else {
/* 675 */           int i1 = n >> 1;
/* 676 */           a a1 = new a(str, this.b[i1]);
/* 677 */           this.b[i1] = a1;
/* 678 */           k = Math.max(k, a1.c);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 683 */     m = i >> 1;
/* 684 */     for (byte b1 = 0; b1 < m; b1++) {
/* 685 */       a a1 = arrayOfA[b1];
/* 686 */       while (a1 != null) {
/* 687 */         j++;
/* 688 */         String str = a1.a;
/* 689 */         int n = d(a(str));
/* 690 */         if (this.a[n] == null) {
/* 691 */           this.a[n] = str;
/*     */         } else {
/* 693 */           i = n >> 1;
/* 694 */           a a2 = new a(str, this.b[i]);
/* 695 */           this.b[i] = a2;
/* 696 */           k = Math.max(k, a2.c);
/*     */         } 
/* 698 */         a1 = a1.b;
/*     */       } 
/*     */     } 
/* 701 */     this.d = k;
/* 702 */     this.m = null;
/*     */     
/* 704 */     if (j != this.c) {
/* 705 */       throw new IllegalStateException(String.format("Internal error on SymbolTable.rehash(): had %d entries; now have %d", new Object[] {
/*     */               
/* 707 */               Integer.valueOf(this.c), Integer.valueOf(j)
/*     */             }));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void e(int paramInt) {
/* 717 */     throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.c + ") now exceeds maximum, 150" + " -- suspect a DoS attack based on hash collisions");
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
/*     */   static final class a
/*     */   {
/*     */     public final String a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public a(String param1String, a param1a) {
/* 817 */       this.a = param1String;
/* 818 */       this.b = param1a;
/* 819 */       this.c = (param1a == null) ? 1 : (param1a.c + 1);
/*     */     }
/*     */     
/*     */     public final String a(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 823 */       if (this.a.length() != param1Int2) {
/* 824 */         return null;
/*     */       }
/* 826 */       byte b = 0;
/*     */       while (true) {
/* 828 */         if (this.a.charAt(b) != param1ArrayOfchar[param1Int1 + b]) {
/* 829 */           return null;
/*     */         }
/* 831 */         if (++b >= param1Int2) {
/* 832 */           return this.a;
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class b
/*     */   {
/*     */     final int a;
/*     */ 
/*     */     
/*     */     final int b;
/*     */     
/*     */     final String[] c;
/*     */     
/*     */     final b.a[] d;
/*     */ 
/*     */     
/*     */     private b(int param1Int1, int param1Int2, String[] param1ArrayOfString, b.a[] param1ArrayOfa) {
/* 853 */       this.a = 0;
/* 854 */       this.b = 0;
/* 855 */       this.c = param1ArrayOfString;
/* 856 */       this.d = param1ArrayOfa;
/*     */     }
/*     */ 
/*     */     
/*     */     public b(b param1b) {
/* 861 */       this.a = param1b.c;
/* 862 */       this.b = param1b.d;
/* 863 */       this.c = param1b.a;
/* 864 */       this.d = param1b.b;
/*     */     }
/*     */     
/*     */     public static b a(int param1Int) {
/* 868 */       return new b(0, 0, new String[64], new b.a[32]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\e\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */