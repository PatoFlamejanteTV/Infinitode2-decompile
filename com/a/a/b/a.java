/*     */ package com.a.a.b;
/*     */ 
/*     */ import com.a.a.b.g.c;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */   implements Serializable
/*     */ {
/*     */   public enum a
/*     */   {
/*  32 */     a,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     b,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     c;
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
/*  82 */   private final transient int[] a = new int[128];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  88 */   private final transient char[] b = new char[64];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   private final transient byte[] c = new byte[64];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final char e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final a h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(String paramString1, String paramString2, boolean paramBoolean, char paramChar, int paramInt) {
/* 149 */     this.d = paramString1;
/* 150 */     this.g = paramBoolean;
/* 151 */     this.e = paramChar;
/* 152 */     this.f = paramInt;
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 158 */     if ((i = paramString2.length()) != 64) {
/* 159 */       throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + i + ")");
/*     */     }
/*     */ 
/*     */     
/* 163 */     paramString2.getChars(0, i, this.b, 0);
/* 164 */     Arrays.fill(this.a, -1);
/* 165 */     for (byte b = 0; b < i; b++) {
/* 166 */       paramInt = this.b[b];
/* 167 */       this.c[b] = (byte)paramInt;
/* 168 */       this.a[paramInt] = b;
/*     */     } 
/*     */ 
/*     */     
/* 172 */     if (paramBoolean) {
/* 173 */       this.a[paramChar] = -2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 178 */     this.h = paramBoolean ? a.b : a.a;
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
/*     */   public a(a parama, String paramString, int paramInt) {
/* 196 */     this(parama, paramString, parama.g, parama.e, 2147483647);
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
/*     */   public a(a parama, String paramString, boolean paramBoolean, char paramChar, int paramInt) {
/* 214 */     this(parama, paramString, paramBoolean, paramChar, parama.h, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private a(a parama, String paramString, boolean paramBoolean, char paramChar, a parama1, int paramInt) {
/* 220 */     this.d = paramString;
/*     */     byte[] arrayOfByte;
/* 222 */     System.arraycopy(arrayOfByte = parama.c, 0, this.c, 0, arrayOfByte.length);
/*     */     char[] arrayOfChar;
/* 224 */     System.arraycopy(arrayOfChar = parama.b, 0, this.b, 0, arrayOfChar.length);
/*     */     int[] arrayOfInt;
/* 226 */     System.arraycopy(arrayOfInt = parama.a, 0, this.a, 0, arrayOfInt.length);
/*     */     
/* 228 */     this.g = paramBoolean;
/* 229 */     this.e = paramChar;
/* 230 */     this.f = paramInt;
/* 231 */     this.h = parama1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String e() {
/* 318 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a() {
/* 324 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean f() {
/* 332 */     return (this.h == a.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g() {
/* 341 */     return (this.h != a.a);
/*     */   }
/*     */   
/* 344 */   public final boolean a(char paramChar) { return (paramChar == this.e); } public final boolean a(int paramInt) {
/* 345 */     return (paramInt == this.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final char b() {
/* 355 */     return this.e;
/*     */   }
/*     */   public final int c() {
/* 358 */     return this.f;
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
/*     */   public final int b(char paramChar) {
/* 374 */     return ((paramChar = paramChar) <= '') ? this.a[paramChar] : -1;
/*     */   }
/*     */ 
/*     */   
/*     */   public final int b(int paramInt) {
/* 379 */     return (paramInt <= 127) ? this.a[paramInt] : -1;
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
/*     */   public final int a(int paramInt1, char[] paramArrayOfchar, int paramInt2) {
/* 419 */     paramArrayOfchar[paramInt2++] = this.b[paramInt1 >> 18 & 0x3F];
/* 420 */     paramArrayOfchar[paramInt2++] = this.b[paramInt1 >> 12 & 0x3F];
/* 421 */     paramArrayOfchar[paramInt2++] = this.b[paramInt1 >> 6 & 0x3F];
/* 422 */     paramArrayOfchar[paramInt2++] = this.b[paramInt1 & 0x3F];
/* 423 */     return paramInt2;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(StringBuilder paramStringBuilder, int paramInt) {
/* 428 */     paramStringBuilder.append(this.b[paramInt >> 18 & 0x3F]);
/* 429 */     paramStringBuilder.append(this.b[paramInt >> 12 & 0x3F]);
/* 430 */     paramStringBuilder.append(this.b[paramInt >> 6 & 0x3F]);
/* 431 */     paramStringBuilder.append(this.b[paramInt & 0x3F]);
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
/*     */   public final int a(int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3) {
/* 449 */     paramArrayOfchar[paramInt3++] = this.b[paramInt1 >> 18 & 0x3F];
/* 450 */     paramArrayOfchar[paramInt3++] = this.b[paramInt1 >> 12 & 0x3F];
/* 451 */     if (a()) {
/* 452 */       paramArrayOfchar[paramInt3++] = (paramInt2 == 2) ? this.b[paramInt1 >> 6 & 0x3F] : this.e;
/*     */       
/* 454 */       paramArrayOfchar[paramInt3++] = this.e;
/*     */     }
/* 456 */     else if (paramInt2 == 2) {
/* 457 */       paramArrayOfchar[paramInt3++] = this.b[paramInt1 >> 6 & 0x3F];
/*     */     } 
/*     */     
/* 460 */     return paramInt3;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/* 465 */     paramStringBuilder.append(this.b[paramInt1 >> 18 & 0x3F]);
/* 466 */     paramStringBuilder.append(this.b[paramInt1 >> 12 & 0x3F]);
/* 467 */     if (a()) {
/* 468 */       paramStringBuilder.append((paramInt2 == 2) ? this.b[paramInt1 >> 6 & 0x3F] : this.e);
/*     */       
/* 470 */       paramStringBuilder.append(this.e); return;
/*     */     } 
/* 472 */     if (paramInt2 == 2) {
/* 473 */       paramStringBuilder.append(this.b[paramInt1 >> 6 & 0x3F]);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a(byte[] paramArrayOfbyte) {
/* 550 */     return a(paramArrayOfbyte, false);
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
/*     */   public final String a(byte[] paramArrayOfbyte, boolean paramBoolean) {
/* 567 */     int i = paramArrayOfbyte.length;
/* 568 */     StringBuilder stringBuilder = new StringBuilder(i + (i >> 2) + (i >> 3));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 573 */     int j = c() >> 2;
/*     */ 
/*     */     
/* 576 */     byte b = 0;
/* 577 */     int k = i - 3;
/*     */     
/* 579 */     while (b <= k) {
/*     */ 
/*     */ 
/*     */       
/* 583 */       int n = (n = (n = paramArrayOfbyte[b++] << 8) | paramArrayOfbyte[b++] & 0xFF) << 8 | paramArrayOfbyte[b++] & 0xFF;
/* 584 */       a(stringBuilder, n);
/* 585 */       if (--j <= 0) {
/*     */         
/* 587 */         stringBuilder.append('\\');
/* 588 */         stringBuilder.append('n');
/* 589 */         j = c() >> 2;
/*     */       } 
/*     */     } 
/*     */     
/*     */     int m;
/*     */     
/* 595 */     if ((m = i - b) > 0) {
/* 596 */       i = paramArrayOfbyte[b++] << 16;
/* 597 */       if (m == 2) {
/* 598 */         i |= (paramArrayOfbyte[b] & 0xFF) << 8;
/*     */       }
/* 600 */       a(stringBuilder, i, m);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 606 */     return stringBuilder.toString();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final byte[] a(String paramString) {
/* 675 */     c c = new c();
/* 676 */     a(paramString, c);
/* 677 */     return c.b();
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
/*     */   public final void a(String paramString, c paramc) {
/* 698 */     byte b = 0;
/* 699 */     int i = paramString.length();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 706 */     while (b < i) {
/*     */       char c1;
/*     */ 
/*     */       
/* 710 */       if ((c1 = paramString.charAt(b++)) > ' ') {
/*     */         int j;
/* 712 */         if ((j = b(c1)) < 0) {
/* 713 */           a(c1, 0, (String)null);
/*     */         }
/* 715 */         int k = j;
/*     */         
/* 717 */         if (b >= i) {
/* 718 */           h();
/*     */         }
/* 720 */         c1 = paramString.charAt(b++);
/*     */         
/* 722 */         if ((j = b(c1)) < 0) {
/* 723 */           a(c1, 1, (String)null);
/*     */         }
/* 725 */         k = k << 6 | j;
/*     */         
/* 727 */         if (b >= i) {
/*     */           
/* 729 */           if (!f()) {
/* 730 */             k >>= 4;
/* 731 */             paramc.a(k);
/*     */             return;
/*     */           } 
/* 734 */           h();
/*     */         } 
/* 736 */         c1 = paramString.charAt(b++);
/*     */ 
/*     */ 
/*     */         
/* 740 */         if ((j = b(c1)) < 0) {
/* 741 */           if (j != -2) {
/* 742 */             a(c1, 2, (String)null);
/*     */           }
/* 744 */           if (!g()) {
/* 745 */             i();
/*     */           }
/*     */           
/* 748 */           if (b >= i) {
/* 749 */             h();
/*     */           }
/* 751 */           c1 = paramString.charAt(b++);
/* 752 */           if (!a(c1)) {
/* 753 */             a(c1, 3, "expected padding character '" + b() + "'");
/*     */           }
/*     */           
/* 756 */           k >>= 4;
/* 757 */           paramc.a(k);
/*     */           
/*     */           continue;
/*     */         } 
/* 761 */         k = k << 6 | j;
/*     */         
/* 763 */         if (b >= i) {
/*     */           
/* 765 */           if (!f()) {
/* 766 */             k >>= 2;
/* 767 */             paramc.b(k);
/*     */             return;
/*     */           } 
/* 770 */           h();
/*     */         } 
/* 772 */         c1 = paramString.charAt(b++);
/*     */         
/* 774 */         if ((j = b(c1)) < 0) {
/* 775 */           if (j != -2) {
/* 776 */             a(c1, 3, (String)null);
/*     */           }
/* 778 */           if (!g()) {
/* 779 */             i();
/*     */           }
/* 781 */           k >>= 2;
/* 782 */           paramc.b(k);
/*     */           continue;
/*     */         } 
/* 785 */         k = k << 6 | j;
/* 786 */         paramc.c(k);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 798 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 804 */     if (paramObject == this) return true; 
/* 805 */     if (paramObject == null || paramObject.getClass() != getClass()) return false;
/*     */ 
/*     */     
/* 808 */     if (((a)(paramObject = paramObject)).e == this.e && ((a)paramObject).f == this.f && ((a)paramObject).g == this.g && ((a)paramObject).h == this.h && this.d
/*     */ 
/*     */ 
/*     */       
/* 812 */       .equals(((a)paramObject).d)) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final int hashCode() {
/* 818 */     return this.d.hashCode();
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
/*     */   private void a(char paramChar, int paramInt, String paramString) {
/*     */     String str;
/* 837 */     if (paramChar <= ' ') {
/* 838 */       str = "Illegal white space character (code 0x" + Integer.toHexString(paramChar) + ") as character #" + (paramInt + 1) + " of 4-char base64 unit: can only used between units";
/* 839 */     } else if (a(str)) {
/* 840 */       str = "Unexpected padding character ('" + b() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
/* 841 */     } else if (!Character.isDefined(str) || Character.isISOControl(str)) {
/*     */       
/* 843 */       str = "Illegal character (code 0x" + Integer.toHexString(str) + ") in base64 content";
/*     */     } else {
/* 845 */       str = "Illegal character '" + str + "' (code 0x" + Integer.toHexString(str) + ") in base64 content";
/*     */     } 
/* 847 */     if (paramString != null) {
/* 848 */       str = str + ": " + paramString;
/*     */     }
/* 850 */     throw new IllegalArgumentException(str);
/*     */   }
/*     */   
/*     */   private void h() {
/* 854 */     throw new IllegalArgumentException(d());
/*     */   }
/*     */   
/*     */   private void i() {
/* 858 */     throw new IllegalArgumentException(j());
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
/*     */   private String j() {
/* 870 */     return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", new Object[] {
/* 871 */           e()
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String d() {
/* 883 */     return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", new Object[] {
/* 884 */           e(), Character.valueOf(b())
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */