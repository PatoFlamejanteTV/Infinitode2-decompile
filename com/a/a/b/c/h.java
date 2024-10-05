/*     */ package com.a.a.b.c;
/*     */ 
/*     */ import com.a.a.b.c.a.e;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class h
/*     */ {
/*  29 */   private static String a = "-9223372036854775808".substring(1);
/*  30 */   private static String b = "9223372036854775807";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  48 */     if (paramInt2 > 0 && paramArrayOfchar[paramInt1] == '+') {
/*  49 */       paramInt1++;
/*  50 */       paramInt2--;
/*     */     } 
/*     */     
/*  53 */     int i = paramArrayOfchar[paramInt1 + paramInt2 - 1] - 48;
/*     */     
/*  55 */     switch (paramInt2) {
/*     */       case 9:
/*  57 */         i += (paramArrayOfchar[paramInt1++] - 48) * 100000000;
/*     */       case 8:
/*  59 */         i += (paramArrayOfchar[paramInt1++] - 48) * 10000000;
/*     */       case 7:
/*  61 */         i += (paramArrayOfchar[paramInt1++] - 48) * 1000000;
/*     */       case 6:
/*  63 */         i += (paramArrayOfchar[paramInt1++] - 48) * 100000;
/*     */       case 5:
/*  65 */         i += (paramArrayOfchar[paramInt1++] - 48) * 10000;
/*     */       case 4:
/*  67 */         i += (paramArrayOfchar[paramInt1++] - 48) * 1000;
/*     */       case 3:
/*  69 */         i += (paramArrayOfchar[paramInt1++] - 48) * 100;
/*     */       case 2:
/*  71 */         i += (paramArrayOfchar[paramInt1] - 48) * 10; break;
/*     */     } 
/*  73 */     return i;
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
/*     */   public static int a(String paramString) {
/*  95 */     char c = paramString.charAt(0);
/*  96 */     int i = paramString.length();
/*  97 */     boolean bool = (c == '-') ? true : false;
/*  98 */     byte b = 1;
/*     */ 
/*     */     
/* 101 */     if (bool) {
/* 102 */       if (i == 1 || i > 10) {
/* 103 */         return Integer.parseInt(paramString);
/*     */       }
/* 105 */       b++; c = paramString.charAt(1);
/*     */     }
/* 107 */     else if (i > 9) {
/* 108 */       return Integer.parseInt(paramString);
/*     */     } 
/*     */     
/* 111 */     if (c > '9' || c < '0') {
/* 112 */       return Integer.parseInt(paramString);
/*     */     }
/* 114 */     int j = c - 48;
/* 115 */     if (b < i) {
/*     */       
/* 117 */       if ((c = paramString.charAt(b++)) > '9' || c < '0') {
/* 118 */         return Integer.parseInt(paramString);
/*     */       }
/* 120 */       j = j * 10 + c - 48;
/* 121 */       if (b < i) {
/*     */         
/* 123 */         if ((c = paramString.charAt(b++)) > '9' || c < '0') {
/* 124 */           return Integer.parseInt(paramString);
/*     */         }
/* 126 */         j = j * 10 + c - 48;
/*     */         
/* 128 */         if (b < i) {
/*     */           
/*     */           do {
/* 131 */             if ((c = paramString.charAt(b++)) > '9' || c < '0') {
/* 132 */               return Integer.parseInt(paramString);
/*     */             }
/* 134 */             j = j * 10 + c - 48;
/* 135 */           } while (b < i);
/*     */         }
/*     */       } 
/*     */     } 
/* 139 */     return bool ? -j : j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static long b(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 145 */     paramInt2 -= 9;
/*     */     long l;
/* 147 */     return (l = a(paramArrayOfchar, paramInt1, paramInt2) * 1000000000L) + a(paramArrayOfchar, paramInt1 + paramInt2, 9);
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
/*     */   public static long b(String paramString) {
/*     */     int i;
/* 162 */     if ((i = paramString.length()) <= 9) {
/* 163 */       return a(paramString);
/*     */     }
/*     */     
/* 166 */     return Long.parseLong(paramString);
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
/*     */   public static boolean a(char[] paramArrayOfchar, int paramInt1, int paramInt2, boolean paramBoolean) {
/*     */     String str;
/* 188 */     int i = (str = paramBoolean ? a : b).length();
/* 189 */     if (paramInt2 < i) return true; 
/* 190 */     if (paramInt2 > i) return false;
/*     */     
/* 192 */     for (paramInt2 = 0; paramInt2 < i; paramInt2++) {
/*     */       int j;
/* 194 */       if ((j = paramArrayOfchar[paramInt1 + paramInt2] - str.charAt(paramInt2)) != 0) {
/* 195 */         return (j < 0);
/*     */       }
/*     */     } 
/* 198 */     return true;
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
/*     */   public static boolean a(String paramString, boolean paramBoolean) {
/*     */     String str;
/* 215 */     int i = (str = b).length();
/*     */     int j;
/* 217 */     if ((j = paramString.length()) < i) return true; 
/* 218 */     if (j > i) return false;
/*     */ 
/*     */     
/* 221 */     for (j = 0; j < i; j++) {
/*     */       int k;
/* 223 */       if ((k = paramString.charAt(j) - str.charAt(j)) != 0) {
/* 224 */         return (k < 0);
/*     */       }
/*     */     } 
/* 227 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int a(String paramString, int paramInt) {
/* 232 */     if (paramString == null) {
/* 233 */       return paramInt;
/*     */     }
/*     */     
/*     */     int i;
/* 237 */     if ((i = (paramString = paramString.trim()).length()) == 0) {
/* 238 */       return paramInt;
/*     */     }
/*     */     
/* 241 */     byte b = 0;
/*     */     
/*     */     char c;
/* 244 */     if ((c = paramString.charAt(0)) == '+') {
/*     */       
/* 246 */       i = (paramString = paramString.substring(1)).length();
/* 247 */     } else if (c == '-') {
/* 248 */       b = 1;
/*     */     } 
/* 250 */     for (; b < i; b++) {
/*     */ 
/*     */       
/* 253 */       if ((c = paramString.charAt(b)) > '9' || c < '0') {
/*     */         
/*     */         try {
/*     */           
/* 257 */           return (int)b(paramString, true);
/* 258 */         } catch (NumberFormatException numberFormatException) {
/* 259 */           return paramInt;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     try {
/* 264 */       return Integer.parseInt(paramString);
/* 265 */     } catch (NumberFormatException numberFormatException) {
/* 266 */       return paramInt;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static long a(String paramString, long paramLong) {
/* 271 */     if (paramString == null) {
/* 272 */       return paramLong;
/*     */     }
/*     */     
/*     */     int i;
/* 276 */     if ((i = (paramString = paramString.trim()).length()) == 0) {
/* 277 */       return paramLong;
/*     */     }
/*     */     
/* 280 */     byte b = 0;
/*     */     
/*     */     char c;
/* 283 */     if ((c = paramString.charAt(0)) == '+') {
/*     */       
/* 285 */       i = (paramString = paramString.substring(1)).length();
/* 286 */     } else if (c == '-') {
/* 287 */       b = 1;
/*     */     } 
/* 289 */     for (; b < i; b++) {
/*     */ 
/*     */       
/* 292 */       if ((c = paramString.charAt(b)) > '9' || c < '0') {
/*     */         
/*     */         try {
/*     */           
/* 296 */           return (long)b(paramString, true);
/* 297 */         } catch (NumberFormatException numberFormatException) {
/* 298 */           return paramLong;
/*     */         } 
/*     */       }
/*     */     } 
/*     */     try {
/* 303 */       return Long.parseLong(paramString);
/* 304 */     } catch (NumberFormatException numberFormatException) {
/* 305 */       return paramLong;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double a(String paramString, double paramDouble) {
/* 316 */     return a(paramString, paramDouble, false);
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
/*     */   private static double a(String paramString, double paramDouble, boolean paramBoolean) {
/* 328 */     if (paramString == null) return paramDouble;
/*     */     
/*     */     int i;
/* 331 */     if ((i = (paramString = paramString.trim()).length()) == 0) {
/* 332 */       return paramDouble;
/*     */     }
/*     */     try {
/* 335 */       return b(paramString, false);
/* 336 */     } catch (NumberFormatException numberFormatException) {
/* 337 */       return paramDouble;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double c(String paramString) {
/* 347 */     return b(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double b(String paramString, boolean paramBoolean) {
/* 358 */     return paramBoolean ? e.a(paramString) : Double.parseDouble(paramString);
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
/*     */   public static float c(String paramString, boolean paramBoolean) {
/* 380 */     return paramBoolean ? e.b(paramString) : Float.parseFloat(paramString);
/*     */   }
/*     */   
/*     */   public static BigDecimal d(String paramString) {
/* 384 */     return a.a(paramString);
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
/*     */   public static BigInteger e(String paramString) {
/* 402 */     if (paramString.length() > 1250) {
/* 403 */       return a.a(paramString).toBigInteger();
/*     */     }
/* 405 */     return new BigInteger(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\c\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */