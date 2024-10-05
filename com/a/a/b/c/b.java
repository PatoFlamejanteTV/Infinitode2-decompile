/*     */ package com.a.a.b.c;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ 
/*     */ public final class b
/*     */ {
/*   7 */   private static char[] b = "0123456789ABCDEF".toCharArray(); private static byte[] d; private static byte[] e; private static int[] f; private static int[] g; private static int[] h;
/*   8 */   private static char[] c = "0123456789abcdef".toCharArray(); private static int[] i; private static int[] j; protected static final int[] a;
/*     */   private static int[] k;
/*     */   
/*     */   static {
/*     */     int i;
/*  13 */     d = new byte[i = b.length];
/*  14 */     e = new byte[i]; char c;
/*  15 */     for (c = Character.MIN_VALUE; c < i; c++) {
/*  16 */       d[c] = (byte)b[c];
/*  17 */       e[c] = (byte)c[c];
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  31 */     int[] arrayOfInt = new int[256];
/*     */     
/*  33 */     for (c = Character.MIN_VALUE; c < ' '; c++) {
/*  34 */       arrayOfInt[c] = -1;
/*     */     }
/*     */     
/*  37 */     arrayOfInt[34] = 1;
/*  38 */     arrayOfInt[92] = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     arrayOfInt = new int[(f = arrayOfInt).length];
/*  49 */     System.arraycopy(f, 0, arrayOfInt, 0, arrayOfInt.length);
/*  50 */     for (c = ''; c < 'Ā'; c++) {
/*     */       byte b2;
/*     */ 
/*     */       
/*  54 */       if ((c & 0xE0) == 192) {
/*  55 */         b2 = 2;
/*  56 */       } else if ((c & 0xF0) == 224) {
/*  57 */         b2 = 3;
/*  58 */       } else if ((c & 0xF8) == 240) {
/*     */         
/*  60 */         b2 = 4;
/*     */       } else {
/*     */         
/*  63 */         b2 = -1;
/*     */       } 
/*  65 */       arrayOfInt[c] = b2;
/*     */     } 
/*  67 */     g = arrayOfInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  80 */     Arrays.fill(arrayOfInt = new int[256], -1);
/*     */     
/*  82 */     for (c = '!'; c < 'Ā'; c++) {
/*  83 */       if (Character.isJavaIdentifierPart((char)c)) {
/*  84 */         arrayOfInt[c] = 0;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  90 */     arrayOfInt[64] = 0;
/*  91 */     arrayOfInt[35] = 0;
/*  92 */     arrayOfInt[42] = 0;
/*  93 */     arrayOfInt[45] = 0;
/*  94 */     arrayOfInt[43] = 0;
/*  95 */     h = arrayOfInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     arrayOfInt = new int[256];
/*     */     
/* 107 */     System.arraycopy(h, 0, arrayOfInt, 0, 256);
/* 108 */     Arrays.fill(arrayOfInt, 128, 128, 0);
/* 109 */     i = arrayOfInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     arrayOfInt = new int[256];
/*     */     
/* 120 */     System.arraycopy(g, 128, arrayOfInt, 128, 128);
/*     */ 
/*     */     
/* 123 */     Arrays.fill(arrayOfInt, 0, 32, -1);
/* 124 */     arrayOfInt[9] = 0;
/* 125 */     arrayOfInt[10] = 10;
/* 126 */     arrayOfInt[13] = 13;
/* 127 */     arrayOfInt[42] = 42;
/* 128 */     j = arrayOfInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 139 */     arrayOfInt = new int[256];
/* 140 */     System.arraycopy(g, 128, arrayOfInt, 128, 128);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     Arrays.fill(arrayOfInt, 0, 32, -1);
/* 146 */     arrayOfInt[32] = 1;
/* 147 */     arrayOfInt[9] = 1;
/* 148 */     arrayOfInt[10] = 10;
/* 149 */     arrayOfInt[13] = 13;
/* 150 */     arrayOfInt[47] = 47;
/* 151 */     arrayOfInt[35] = 35;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 161 */     arrayOfInt = new int[128];
/*     */     
/* 163 */     for (c = Character.MIN_VALUE; c < ' '; c++)
/*     */     {
/* 165 */       arrayOfInt[c] = -1;
/*     */     }
/*     */     
/* 168 */     arrayOfInt[34] = 34;
/* 169 */     arrayOfInt[92] = 92;
/*     */     
/* 171 */     arrayOfInt[8] = 98;
/* 172 */     arrayOfInt[9] = 116;
/* 173 */     arrayOfInt[12] = 102;
/* 174 */     arrayOfInt[10] = 110;
/* 175 */     arrayOfInt[13] = 114;
/* 176 */     a = arrayOfInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     Arrays.fill(k = new int[256], -1); byte b1;
/* 189 */     for (b1 = 0; b1 < 10; b1++) {
/* 190 */       k[b1 + 48] = b1;
/*     */     }
/* 192 */     for (b1 = 0; b1 < 6; b1++) {
/* 193 */       k[b1 + 97] = b1 + 10;
/* 194 */       k[b1 + 65] = b1 + 10;
/*     */     } 
/*     */   }
/*     */   
/* 198 */   public static int[] a() { return f; } public static int[] b() {
/* 199 */     return g;
/*     */   }
/* 201 */   public static int[] c() { return h; } public static int[] d() {
/* 202 */     return i;
/*     */   } public static int[] e() {
/* 204 */     return j;
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
/*     */   public static int[] f() {
/* 216 */     return a;
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
/*     */   public static int[] a(int paramInt) {
/* 230 */     if (paramInt == 34) {
/* 231 */       return a;
/*     */     }
/* 233 */     return a.a.a(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int b(int paramInt) {
/* 240 */     return k[paramInt & 0xFF];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static char c(int paramInt) {
/* 246 */     return b[paramInt];
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
/*     */   public static void a(StringBuilder paramStringBuilder, String paramString) {
/* 261 */     int arrayOfInt[], i = (arrayOfInt = a).length; byte b1; int j;
/* 262 */     for (b1 = 0, j = paramString.length(); b1 < j; b1++) {
/*     */       char c;
/* 264 */       if ((c = paramString.charAt(b1)) >= i || arrayOfInt[c] == 0) {
/* 265 */         paramStringBuilder.append(c);
/*     */       } else {
/*     */         
/* 268 */         paramStringBuilder.append('\\');
/*     */         int k;
/* 270 */         if ((k = arrayOfInt[c]) < 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 279 */           paramStringBuilder.append('u');
/* 280 */           paramStringBuilder.append('0');
/* 281 */           paramStringBuilder.append('0');
/* 282 */           c = c;
/* 283 */           paramStringBuilder.append(b[c >> 4]);
/* 284 */           paramStringBuilder.append(b[c & 0xF]);
/*     */         } else {
/* 286 */           paramStringBuilder.append((char)k);
/*     */         } 
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
/*     */   
/*     */   public static char[] a(boolean paramBoolean) {
/* 300 */     return paramBoolean ? (char[])b.clone() : (char[])c.clone();
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
/*     */   public static byte[] b(boolean paramBoolean) {
/* 312 */     return (byte[])d.clone();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */   {
/* 323 */     public static final a a = new a();
/*     */     
/* 325 */     private int[][] b = new int[128][];
/*     */     
/*     */     public final int[] a(int param1Int) {
/*     */       int[] arrayOfInt;
/* 329 */       if ((arrayOfInt = this.b[param1Int]) == null) {
/*     */ 
/*     */         
/* 332 */         if ((arrayOfInt = Arrays.copyOf(b.a, 128))[param1Int] == 0) {
/* 333 */           arrayOfInt[param1Int] = -1;
/*     */         }
/* 335 */         this.b[param1Int] = arrayOfInt;
/*     */       } 
/* 337 */       return arrayOfInt;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */