/*      */ package com.b.a.a;
/*      */ 
/*      */ import com.b.a.d.c;
/*      */ import java.io.IOException;
/*      */ import java.nio.ByteBuffer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class aa
/*      */ {
/*      */   private aa() {
/*   42 */     ByteBuffer byteBuffer = f.b("ucase.icu");
/*   43 */     a(byteBuffer);
/*      */   }
/*      */ 
/*      */   
/*      */   private final void a(ByteBuffer paramByteBuffer) {
/*   48 */     f.b(paramByteBuffer, 1665225541, new b((byte)0));
/*      */     
/*      */     int i;
/*      */     
/*   52 */     if ((i = paramByteBuffer.getInt()) < 16) {
/*   53 */       throw new IOException("indexes[0] too small in ucase.icu");
/*      */     }
/*   55 */     this.d = new int[i];
/*      */     
/*   57 */     this.d[0] = i; int j;
/*   58 */     for (j = 1; j < i; j++) {
/*   59 */       this.d[j] = paramByteBuffer.getInt();
/*      */     }
/*      */ 
/*      */     
/*   63 */     this.f = x.b(paramByteBuffer);
/*   64 */     j = this.d[2];
/*      */     
/*   66 */     if ((i = this.f.b()) > j) {
/*   67 */       throw new IOException("ucase.icu: not enough bytes for the trie");
/*      */     }
/*      */     
/*   70 */     f.a(paramByteBuffer, j - i);
/*      */ 
/*      */ 
/*      */     
/*   74 */     if ((i = this.d[3]) > 0) {
/*   75 */       this.e = f.a(paramByteBuffer, i, 0);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*   80 */     if ((i = this.d[4]) > 0)
/*   81 */       f.b(paramByteBuffer, i, 0); 
/*      */   }
/*      */   
/*      */   public static interface a {
/*      */     int a(); }
/*      */   
/*      */   static final class b implements f.a {
/*      */     public final boolean a(byte[] param1ArrayOfbyte) {
/*   89 */       return (param1ArrayOfbyte[0] == 3);
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
/*      */ 
/*      */     
/*      */     private b() {}
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
/*      */   private static final int a(int paramInt) {
/*  115 */     return paramInt >> 5;
/*      */   }
/*      */   
/*      */   private static final boolean b(int paramInt) {
/*  119 */     return ((paramInt & 0x10) != 0);
/*      */   }
/*      */ 
/*      */   
/*  123 */   private static final byte[] c = new byte[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7, 4, 5, 5, 6, 5, 6, 6, 7, 5, 6, 6, 7, 6, 7, 7, 8 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean b(int paramInt1, int paramInt2) {
/*  143 */     return ((paramInt1 & 1 << paramInt2) != 0);
/*      */   }
/*      */   private static final byte c(int paramInt1, int paramInt2) {
/*  146 */     return c[paramInt1 & (1 << paramInt2) - 1];
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
/*      */   private final long a(int paramInt1, int paramInt2, int paramInt3) {
/*      */     long l;
/*  160 */     if ((paramInt1 & 0x100) == 0) {
/*  161 */       paramInt3 += c(paramInt1, 7);
/*  162 */       l = this.e.charAt(paramInt3);
/*      */     } else {
/*  164 */       paramInt3 += 2 * c(paramInt1, 7);
/*      */       
/*  166 */       l = (l = this.e.charAt(paramInt3++)) << 16L | this.e.charAt(paramInt3);
/*      */     } 
/*  168 */     return l | paramInt3 << 32L;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private final int b(int paramInt1, int paramInt2, int paramInt3) {
/*  174 */     if ((paramInt1 & 0x100) == 0) {
/*  175 */       paramInt3 += c(paramInt1, paramInt2);
/*  176 */       paramInt1 = this.e.charAt(paramInt3);
/*      */     } else {
/*  178 */       paramInt3 += 2 * c(paramInt1, paramInt2);
/*      */       
/*  180 */       paramInt1 = (paramInt1 = this.e.charAt(paramInt3++)) << 16 | this.e.charAt(paramInt3);
/*      */     } 
/*  182 */     return paramInt1;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int c(int paramInt) {
/*  459 */     return h(this.f.a(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   private int d(int paramInt) {
/*  464 */     return i(this.f.a(paramInt));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int e(int paramInt) {
/*  470 */     if (!b(paramInt = this.f.a(paramInt))) {
/*  471 */       return paramInt & 0x60;
/*      */     }
/*  473 */     return this.e.charAt(a(paramInt)) >> 7 & 0x60;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean f(int paramInt) {
/*  478 */     return (e(paramInt) == 32);
/*      */   }
/*      */   
/*      */   private boolean g(int paramInt) {
/*  482 */     return ((this.f.a(paramInt) & 0x8) != 0);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean a(a parama, int paramInt) {
/*  659 */     if (parama == null) {
/*  660 */       return false;
/*      */     }
/*      */     
/*  663 */     while ((paramInt = parama.a()) >= 0) {
/*      */       
/*  665 */       if (((paramInt = d(paramInt)) & 0x4) == 0) {
/*      */         
/*  667 */         if (paramInt != 0) {
/*  668 */           return true;
/*      */         }
/*  670 */         return false;
/*      */       } 
/*      */     } 
/*      */     
/*  674 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean a(a parama) {
/*  682 */     if (parama == null) {
/*  683 */       return false;
/*      */     }
/*      */     int i;
/*  686 */     while ((i = parama.a()) >= 0) {
/*      */       
/*  688 */       if ((i = e(i)) == 32)
/*  689 */         return true; 
/*  690 */       if (i != 96) {
/*  691 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  695 */     return false;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int a(int paramInt1, a parama, Appendable paramAppendable, int paramInt2) {
/*  823 */     paramInt2 = paramInt1;
/*      */     int i;
/*  825 */     if (!b(i = this.f.a(paramInt1))) {
/*  826 */       if (h(i) >= 2) {
/*  827 */         paramInt2 = paramInt1 + j(i);
/*      */       }
/*      */     } else {
/*  830 */       i = a(i);
/*  831 */       char c = this.e.charAt(i++);
/*      */ 
/*      */       
/*  834 */       int j = i;
/*      */       
/*  836 */       if ((c & 0x4000) != 0) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  920 */         if (paramInt1 == 304)
/*      */           
/*      */           try {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  927 */             paramAppendable.append("i̇");
/*  928 */             return 2;
/*  929 */           } catch (IOException iOException1) {
/*  930 */             throw new c(iOException1);
/*      */           }  
/*  932 */         if (paramInt1 == 931 && 
/*  933 */           !a(parama, 1) && 
/*  934 */           a(parama, -1))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  942 */           return 962; } 
/*      */       } else {
/*      */         int k;
/*      */         long l;
/*  946 */         if (b(c, 7) && (
/*      */ 
/*      */           
/*  949 */           k = (int)(l = a(c, 7, i)) & 0xF) != 0) {
/*      */           
/*  951 */           i = (int)(l >> 32L) + 1;
/*      */ 
/*      */           
/*      */           try {
/*  955 */             paramAppendable.append(this.e, i, i + k);
/*      */ 
/*      */             
/*  958 */             return k;
/*  959 */           } catch (IOException iOException) {
/*  960 */             throw new c(iOException);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  965 */       if (b(c, 0)) {
/*  966 */         paramInt2 = b(c, 0, j);
/*      */       }
/*      */     } 
/*      */     
/*  970 */     return (paramInt2 == iOException) ? (paramInt2 ^ 0xFFFFFFFF) : paramInt2;
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
/*      */   private final int a(int paramInt1, a parama, Appendable paramAppendable, int paramInt2, boolean paramBoolean) {
/*      */     // Byte code:
/*      */     //   0: iload_1
/*      */     //   1: istore #6
/*      */     //   3: aload_0
/*      */     //   4: getfield f : Lcom/b/a/a/x;
/*      */     //   7: iload_1
/*      */     //   8: invokevirtual a : (I)I
/*      */     //   11: dup
/*      */     //   12: istore #7
/*      */     //   14: invokestatic b : (I)Z
/*      */     //   17: ifne -> 41
/*      */     //   20: iload #7
/*      */     //   22: invokestatic h : (I)I
/*      */     //   25: iconst_1
/*      */     //   26: if_icmpne -> 286
/*      */     //   29: iload_1
/*      */     //   30: iload #7
/*      */     //   32: invokestatic j : (I)I
/*      */     //   35: iadd
/*      */     //   36: istore #6
/*      */     //   38: goto -> 286
/*      */     //   41: iload #7
/*      */     //   43: invokestatic a : (I)I
/*      */     //   46: istore #6
/*      */     //   48: aload_0
/*      */     //   49: getfield e : Ljava/lang/String;
/*      */     //   52: iload #6
/*      */     //   54: iinc #6, 1
/*      */     //   57: invokevirtual charAt : (I)C
/*      */     //   60: istore #8
/*      */     //   62: iload #6
/*      */     //   64: istore #7
/*      */     //   66: iload #8
/*      */     //   68: sipush #16384
/*      */     //   71: iand
/*      */     //   72: ifeq -> 114
/*      */     //   75: iload #4
/*      */     //   77: iconst_2
/*      */     //   78: if_icmpne -> 91
/*      */     //   81: iload_1
/*      */     //   82: bipush #105
/*      */     //   84: if_icmpne -> 91
/*      */     //   87: sipush #304
/*      */     //   90: ireturn
/*      */     //   91: iload #4
/*      */     //   93: iconst_3
/*      */     //   94: if_icmpne -> 238
/*      */     //   97: iload_1
/*      */     //   98: sipush #775
/*      */     //   101: if_icmpne -> 238
/*      */     //   104: aload_0
/*      */     //   105: aload_2
/*      */     //   106: invokespecial a : (Lcom/b/a/a/aa$a;)Z
/*      */     //   109: ifeq -> 238
/*      */     //   112: iconst_0
/*      */     //   113: ireturn
/*      */     //   114: iload #8
/*      */     //   116: bipush #7
/*      */     //   118: invokestatic b : (II)Z
/*      */     //   121: ifeq -> 238
/*      */     //   124: aload_0
/*      */     //   125: iload #8
/*      */     //   127: bipush #7
/*      */     //   129: iload #6
/*      */     //   131: invokespecial a : (III)J
/*      */     //   134: dup2
/*      */     //   135: lstore #13
/*      */     //   137: l2i
/*      */     //   138: ldc 65535
/*      */     //   140: iand
/*      */     //   141: istore_2
/*      */     //   142: lload #13
/*      */     //   144: bipush #32
/*      */     //   146: lshr
/*      */     //   147: l2i
/*      */     //   148: iconst_1
/*      */     //   149: iadd
/*      */     //   150: dup
/*      */     //   151: istore #6
/*      */     //   153: iload_2
/*      */     //   154: bipush #15
/*      */     //   156: iand
/*      */     //   157: iadd
/*      */     //   158: istore #6
/*      */     //   160: iload_2
/*      */     //   161: iconst_4
/*      */     //   162: ishr
/*      */     //   163: istore_2
/*      */     //   164: iload #6
/*      */     //   166: iload_2
/*      */     //   167: bipush #15
/*      */     //   169: iand
/*      */     //   170: iadd
/*      */     //   171: istore #6
/*      */     //   173: iload_2
/*      */     //   174: iconst_4
/*      */     //   175: ishr
/*      */     //   176: istore_2
/*      */     //   177: iload #5
/*      */     //   179: ifeq -> 190
/*      */     //   182: iload_2
/*      */     //   183: bipush #15
/*      */     //   185: iand
/*      */     //   186: istore_2
/*      */     //   187: goto -> 206
/*      */     //   190: iload #6
/*      */     //   192: iload_2
/*      */     //   193: bipush #15
/*      */     //   195: iand
/*      */     //   196: iadd
/*      */     //   197: istore #6
/*      */     //   199: iload_2
/*      */     //   200: iconst_4
/*      */     //   201: ishr
/*      */     //   202: bipush #15
/*      */     //   204: iand
/*      */     //   205: istore_2
/*      */     //   206: iload_2
/*      */     //   207: ifeq -> 238
/*      */     //   210: aload_3
/*      */     //   211: aload_0
/*      */     //   212: getfield e : Ljava/lang/String;
/*      */     //   215: iload #6
/*      */     //   217: dup
/*      */     //   218: iload_2
/*      */     //   219: iadd
/*      */     //   220: invokeinterface append : (Ljava/lang/CharSequence;II)Ljava/lang/Appendable;
/*      */     //   225: pop
/*      */     //   226: iload_2
/*      */     //   227: ireturn
/*      */     //   228: astore_1
/*      */     //   229: new com/b/a/d/c
/*      */     //   232: dup
/*      */     //   233: aload_1
/*      */     //   234: invokespecial <init> : (Ljava/lang/Throwable;)V
/*      */     //   237: athrow
/*      */     //   238: iload #5
/*      */     //   240: ifne -> 257
/*      */     //   243: iload #8
/*      */     //   245: iconst_3
/*      */     //   246: invokestatic b : (II)Z
/*      */     //   249: ifeq -> 257
/*      */     //   252: iconst_3
/*      */     //   253: istore_2
/*      */     //   254: goto -> 275
/*      */     //   257: iload #8
/*      */     //   259: iconst_2
/*      */     //   260: invokestatic b : (II)Z
/*      */     //   263: ifeq -> 271
/*      */     //   266: iconst_2
/*      */     //   267: istore_2
/*      */     //   268: goto -> 275
/*      */     //   271: iload_1
/*      */     //   272: iconst_m1
/*      */     //   273: ixor
/*      */     //   274: ireturn
/*      */     //   275: aload_0
/*      */     //   276: iload #8
/*      */     //   278: iload_2
/*      */     //   279: iload #7
/*      */     //   281: invokespecial b : (III)I
/*      */     //   284: istore #6
/*      */     //   286: iload #6
/*      */     //   288: iload_1
/*      */     //   289: if_icmpne -> 297
/*      */     //   292: iload #6
/*      */     //   294: iconst_m1
/*      */     //   295: ixor
/*      */     //   296: ireturn
/*      */     //   297: iload #6
/*      */     //   299: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #981	-> 0
/*      */     //   #982	-> 3
/*      */     //   #983	-> 12
/*      */     //   #984	-> 20
/*      */     //   #985	-> 29
/*      */     //   #988	-> 41
/*      */     //   #989	-> 48
/*      */     //   #992	-> 62
/*      */     //   #994	-> 66
/*      */     //   #996	-> 75
/*      */     //   #1008	-> 87
/*      */     //   #1009	-> 91
/*      */     //   #1019	-> 112
/*      */     //   #1023	-> 114
/*      */     //   #1024	-> 124
/*      */     //   #1025	-> 135
/*      */     //   #1028	-> 142
/*      */     //   #1031	-> 151
/*      */     //   #1032	-> 160
/*      */     //   #1033	-> 164
/*      */     //   #1034	-> 173
/*      */     //   #1036	-> 177
/*      */     //   #1037	-> 182
/*      */     //   #1040	-> 190
/*      */     //   #1041	-> 199
/*      */     //   #1044	-> 206
/*      */     //   #1047	-> 210
/*      */     //   #1050	-> 226
/*      */     //   #1051	-> 228
/*      */     //   #1052	-> 229
/*      */     //   #1057	-> 238
/*      */     //   #1058	-> 252
/*      */     //   #1059	-> 257
/*      */     //   #1061	-> 266
/*      */     //   #1063	-> 271
/*      */     //   #1065	-> 275
/*      */     //   #1068	-> 286
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   210	227	228	java/io/IOException
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
/*      */   private int b(int paramInt1, a parama, Appendable paramAppendable, int paramInt2) {
/* 1074 */     return a(paramInt1, parama, paramAppendable, 1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int c(int paramInt1, a parama, Appendable paramAppendable, int paramInt2) {
/* 1080 */     return a(paramInt1, parama, paramAppendable, 1, false);
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
/*      */   public final int a(int paramInt1, Appendable paramAppendable, int paramInt2) {
/*      */     // Byte code:
/*      */     //   0: iload_1
/*      */     //   1: istore #4
/*      */     //   3: aload_0
/*      */     //   4: getfield f : Lcom/b/a/a/x;
/*      */     //   7: iload_1
/*      */     //   8: invokevirtual a : (I)I
/*      */     //   11: dup
/*      */     //   12: istore #5
/*      */     //   14: invokestatic b : (I)Z
/*      */     //   17: ifne -> 41
/*      */     //   20: iload #5
/*      */     //   22: invokestatic h : (I)I
/*      */     //   25: iconst_2
/*      */     //   26: if_icmplt -> 269
/*      */     //   29: iload_1
/*      */     //   30: iload #5
/*      */     //   32: invokestatic j : (I)I
/*      */     //   35: iadd
/*      */     //   36: istore #4
/*      */     //   38: goto -> 269
/*      */     //   41: iload #5
/*      */     //   43: invokestatic a : (I)I
/*      */     //   46: istore #4
/*      */     //   48: aload_0
/*      */     //   49: getfield e : Ljava/lang/String;
/*      */     //   52: iload #4
/*      */     //   54: iinc #4, 1
/*      */     //   57: invokevirtual charAt : (I)C
/*      */     //   60: istore #6
/*      */     //   62: iload #4
/*      */     //   64: istore #5
/*      */     //   66: iload #6
/*      */     //   68: ldc 32768
/*      */     //   70: iand
/*      */     //   71: ifeq -> 141
/*      */     //   74: iload_3
/*      */     //   75: sipush #255
/*      */     //   78: iand
/*      */     //   79: ifne -> 121
/*      */     //   82: iload_1
/*      */     //   83: bipush #73
/*      */     //   85: if_icmpne -> 91
/*      */     //   88: bipush #105
/*      */     //   90: ireturn
/*      */     //   91: iload_1
/*      */     //   92: sipush #304
/*      */     //   95: if_icmpne -> 226
/*      */     //   98: aload_2
/*      */     //   99: ldc 'i̇'
/*      */     //   101: invokeinterface append : (Ljava/lang/CharSequence;)Ljava/lang/Appendable;
/*      */     //   106: pop
/*      */     //   107: iconst_2
/*      */     //   108: ireturn
/*      */     //   109: astore #11
/*      */     //   111: new com/b/a/d/c
/*      */     //   114: dup
/*      */     //   115: aload #11
/*      */     //   117: invokespecial <init> : (Ljava/lang/Throwable;)V
/*      */     //   120: athrow
/*      */     //   121: iload_1
/*      */     //   122: bipush #73
/*      */     //   124: if_icmpne -> 131
/*      */     //   127: sipush #305
/*      */     //   130: ireturn
/*      */     //   131: iload_1
/*      */     //   132: sipush #304
/*      */     //   135: if_icmpne -> 226
/*      */     //   138: bipush #105
/*      */     //   140: ireturn
/*      */     //   141: iload #6
/*      */     //   143: bipush #7
/*      */     //   145: invokestatic b : (II)Z
/*      */     //   148: ifeq -> 226
/*      */     //   151: aload_0
/*      */     //   152: iload #6
/*      */     //   154: bipush #7
/*      */     //   156: iload #4
/*      */     //   158: invokespecial a : (III)J
/*      */     //   161: dup2
/*      */     //   162: lstore #11
/*      */     //   164: l2i
/*      */     //   165: ldc 65535
/*      */     //   167: iand
/*      */     //   168: istore_3
/*      */     //   169: lload #11
/*      */     //   171: bipush #32
/*      */     //   173: lshr
/*      */     //   174: l2i
/*      */     //   175: iconst_1
/*      */     //   176: iadd
/*      */     //   177: dup
/*      */     //   178: istore #4
/*      */     //   180: iload_3
/*      */     //   181: bipush #15
/*      */     //   183: iand
/*      */     //   184: iadd
/*      */     //   185: istore #4
/*      */     //   187: iload_3
/*      */     //   188: iconst_4
/*      */     //   189: ishr
/*      */     //   190: bipush #15
/*      */     //   192: iand
/*      */     //   193: dup
/*      */     //   194: istore_3
/*      */     //   195: ifeq -> 226
/*      */     //   198: aload_2
/*      */     //   199: aload_0
/*      */     //   200: getfield e : Ljava/lang/String;
/*      */     //   203: iload #4
/*      */     //   205: dup
/*      */     //   206: iload_3
/*      */     //   207: iadd
/*      */     //   208: invokeinterface append : (Ljava/lang/CharSequence;II)Ljava/lang/Appendable;
/*      */     //   213: pop
/*      */     //   214: iload_3
/*      */     //   215: ireturn
/*      */     //   216: astore_1
/*      */     //   217: new com/b/a/d/c
/*      */     //   220: dup
/*      */     //   221: aload_1
/*      */     //   222: invokespecial <init> : (Ljava/lang/Throwable;)V
/*      */     //   225: athrow
/*      */     //   226: iload #6
/*      */     //   228: iconst_1
/*      */     //   229: invokestatic b : (II)Z
/*      */     //   232: ifeq -> 240
/*      */     //   235: iconst_1
/*      */     //   236: istore_2
/*      */     //   237: goto -> 258
/*      */     //   240: iload #6
/*      */     //   242: iconst_0
/*      */     //   243: invokestatic b : (II)Z
/*      */     //   246: ifeq -> 254
/*      */     //   249: iconst_0
/*      */     //   250: istore_2
/*      */     //   251: goto -> 258
/*      */     //   254: iload_1
/*      */     //   255: iconst_m1
/*      */     //   256: ixor
/*      */     //   257: ireturn
/*      */     //   258: aload_0
/*      */     //   259: iload #6
/*      */     //   261: iload_2
/*      */     //   262: iload #5
/*      */     //   264: invokespecial b : (III)I
/*      */     //   267: istore #4
/*      */     //   269: iload #4
/*      */     //   271: iload_1
/*      */     //   272: if_icmpne -> 280
/*      */     //   275: iload #4
/*      */     //   277: iconst_m1
/*      */     //   278: ixor
/*      */     //   279: ireturn
/*      */     //   280: iload #4
/*      */     //   282: ireturn
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #1195	-> 0
/*      */     //   #1196	-> 3
/*      */     //   #1197	-> 12
/*      */     //   #1198	-> 20
/*      */     //   #1199	-> 29
/*      */     //   #1202	-> 41
/*      */     //   #1203	-> 48
/*      */     //   #1206	-> 62
/*      */     //   #1208	-> 66
/*      */     //   #1210	-> 74
/*      */     //   #1212	-> 82
/*      */     //   #1214	-> 88
/*      */     //   #1215	-> 91
/*      */     //   #1218	-> 98
/*      */     //   #1219	-> 107
/*      */     //   #1220	-> 109
/*      */     //   #1221	-> 111
/*      */     //   #1226	-> 121
/*      */     //   #1228	-> 127
/*      */     //   #1229	-> 131
/*      */     //   #1231	-> 138
/*      */     //   #1234	-> 141
/*      */     //   #1235	-> 151
/*      */     //   #1236	-> 162
/*      */     //   #1239	-> 169
/*      */     //   #1242	-> 178
/*      */     //   #1243	-> 187
/*      */     //   #1245	-> 194
/*      */     //   #1248	-> 198
/*      */     //   #1251	-> 214
/*      */     //   #1252	-> 216
/*      */     //   #1253	-> 217
/*      */     //   #1258	-> 226
/*      */     //   #1259	-> 235
/*      */     //   #1260	-> 240
/*      */     //   #1261	-> 249
/*      */     //   #1263	-> 254
/*      */     //   #1265	-> 258
/*      */     //   #1268	-> 269
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   98	108	109	java/io/IOException
/*      */     //   198	215	216	java/io/IOException
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
/* 1282 */   public static final StringBuilder a = new StringBuilder(); private int[] d;
/*      */   
/*      */   public final boolean a(int paramInt1, int paramInt2) {
/* 1285 */     switch (paramInt2) {
/*      */       case 22:
/* 1287 */         return (1 == c(paramInt1));
/*      */       case 30:
/* 1289 */         return (2 == c(paramInt1));
/*      */       case 27:
/* 1291 */         return f(paramInt1);
/*      */       case 34:
/* 1293 */         return g(paramInt1);
/*      */       case 49:
/* 1295 */         return (0 != c(paramInt1));
/*      */       case 50:
/* 1297 */         return (d(paramInt1) >> 2 != 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 51:
/* 1311 */         a.setLength(0);
/* 1312 */         return (a(paramInt1, null, a, 1) >= 0);
/*      */       case 52:
/* 1314 */         a.setLength(0);
/* 1315 */         return (b(paramInt1, null, a, 1) >= 0);
/*      */       case 53:
/* 1317 */         a.setLength(0);
/* 1318 */         return (c(paramInt1, null, a, 1) >= 0);
/*      */       
/*      */       case 55:
/* 1321 */         a.setLength(0);
/*      */         
/* 1323 */         if (a(paramInt1, null, a, 1) >= 0 || 
/* 1324 */           b(paramInt1, null, a, 1) >= 0 || 
/* 1325 */           c(paramInt1, null, a, 1) >= 0) return true;  return false;
/*      */     } 
/* 1327 */     return false;
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
/*      */   private String e;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private x f;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final aa b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final int h(int paramInt) {
/* 1367 */     return paramInt & 0x3;
/*      */   }
/*      */ 
/*      */   
/*      */   private static final int i(int paramInt) {
/* 1372 */     return paramInt & 0x7;
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
/*      */   private static final int j(int paramInt) {
/* 1392 */     return (short)paramInt >> 7;
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
/*      */   static {
/*      */     try {
/* 1456 */       b = new aa(); return;
/* 1457 */     } catch (IOException iOException) {
/* 1458 */       throw new c(iOException);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\b\a\a\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */