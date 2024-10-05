/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Base64Coder
/*     */ {
/*     */   private static final String systemLineSeparator = "\n";
/*     */   
/*     */   public static class CharMap
/*     */   {
/*  36 */     protected final char[] encodingMap = new char[64];
/*  37 */     protected final byte[] decodingMap = new byte[128];
/*     */     
/*     */     public CharMap(char param1Char1, char param1Char2) {
/*  40 */       byte b = 0; char c;
/*  41 */       for (c = 'A'; c <= 'Z'; c = (char)(c + 1)) {
/*  42 */         this.encodingMap[b++] = c;
/*     */       }
/*  44 */       for (c = 'a'; c <= 'z'; c = (char)(c + 1)) {
/*  45 */         this.encodingMap[b++] = c;
/*     */       }
/*  47 */       for (c = '0'; c <= '9'; c = (char)(c + 1)) {
/*  48 */         this.encodingMap[b++] = c;
/*     */       }
/*  50 */       this.encodingMap[b++] = param1Char1;
/*  51 */       this.encodingMap[b] = param1Char2;
/*  52 */       for (b = 0; b < this.decodingMap.length; b++) {
/*  53 */         this.decodingMap[b] = -1;
/*     */       }
/*  55 */       for (b = 0; b < 64; b++) {
/*  56 */         this.decodingMap[this.encodingMap[b]] = (byte)b;
/*     */       }
/*     */     }
/*     */     
/*     */     public byte[] getDecodingMap() {
/*  61 */       return this.decodingMap;
/*     */     }
/*     */     
/*     */     public char[] getEncodingMap() {
/*  65 */       return this.encodingMap;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final CharMap regularMap = new CharMap('+', '/'), urlsafeMap = new CharMap('-', '_');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String encodeString(String paramString) {
/*  78 */     return encodeString(paramString, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String encodeString(String paramString, boolean paramBoolean) {
/*     */     try {
/*  88 */       return new String(encode(paramString.getBytes("UTF-8"), paramBoolean ? urlsafeMap.encodingMap : regularMap.encodingMap));
/*  89 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */       
/*  91 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String encodeLines(byte[] paramArrayOfbyte) {
/* 100 */     return encodeLines(paramArrayOfbyte, 0, paramArrayOfbyte.length, 76, "\n", regularMap.encodingMap);
/*     */   }
/*     */   
/*     */   public static String encodeLines(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, String paramString, CharMap paramCharMap) {
/* 104 */     return encodeLines(paramArrayOfbyte, paramInt1, paramInt2, paramInt3, paramString, paramCharMap.encodingMap);
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
/*     */   public static String encodeLines(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, String paramString, char[] paramArrayOfchar) {
/* 117 */     if ((paramInt3 = paramInt3 * 3 / 4) <= 0) {
/* 118 */       throw new IllegalArgumentException();
/*     */     }
/* 120 */     int i = (paramInt2 + paramInt3 - 1) / paramInt3;
/* 121 */     i = ((paramInt2 + 2) / 3 << 2) + i * paramString.length();
/* 122 */     StringBuilder stringBuilder = new StringBuilder(i);
/* 123 */     int j = 0;
/* 124 */     while (j < paramInt2) {
/* 125 */       int k = Math.min(paramInt2 - j, paramInt3);
/* 126 */       stringBuilder.append(encode(paramArrayOfbyte, paramInt1 + j, k, paramArrayOfchar));
/* 127 */       stringBuilder.append(paramString);
/* 128 */       j += k;
/*     */     } 
/* 130 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] encode(byte[] paramArrayOfbyte) {
/* 137 */     return encode(paramArrayOfbyte, regularMap.encodingMap);
/*     */   }
/*     */   
/*     */   public static char[] encode(byte[] paramArrayOfbyte, CharMap paramCharMap) {
/* 141 */     return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramCharMap);
/*     */   }
/*     */   
/*     */   public static char[] encode(byte[] paramArrayOfbyte, char[] paramArrayOfchar) {
/* 145 */     return encode(paramArrayOfbyte, 0, paramArrayOfbyte.length, paramArrayOfchar);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] encode(byte[] paramArrayOfbyte, int paramInt) {
/* 153 */     return encode(paramArrayOfbyte, 0, paramInt, regularMap.encodingMap);
/*     */   }
/*     */   
/*     */   public static char[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, CharMap paramCharMap) {
/* 157 */     return encode(paramArrayOfbyte, paramInt1, paramInt2, paramCharMap.encodingMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static char[] encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar) {
/* 167 */     int i = ((paramInt2 << 2) + 2) / 3;
/*     */     int j;
/* 169 */     char[] arrayOfChar = new char[j = (paramInt2 + 2) / 3 << 2];
/* 170 */     int k = paramInt1;
/* 171 */     paramInt1 += paramInt2;
/* 172 */     paramInt2 = 0;
/* 173 */     while (k < paramInt1) {
/* 174 */       int m = paramArrayOfbyte[k++] & 0xFF;
/* 175 */       int n = (k < paramInt1) ? (paramArrayOfbyte[k++] & 0xFF) : 0;
/* 176 */       int i1 = (k < paramInt1) ? (paramArrayOfbyte[k++] & 0xFF) : 0;
/* 177 */       int i2 = m >>> 2;
/* 178 */       m = (m & 0x3) << 4 | n >>> 4;
/* 179 */       n = (n & 0xF) << 2 | i1 >>> 6;
/* 180 */       i1 &= 0x3F;
/* 181 */       arrayOfChar[paramInt2++] = paramArrayOfchar[i2];
/* 182 */       arrayOfChar[paramInt2++] = paramArrayOfchar[m];
/* 183 */       arrayOfChar[paramInt2] = (paramInt2 < i) ? paramArrayOfchar[n] : '=';
/* 184 */       paramInt2++;
/* 185 */       arrayOfChar[paramInt2] = (paramInt2 < i) ? paramArrayOfchar[i1] : '=';
/* 186 */       paramInt2++;
/*     */     } 
/* 188 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String decodeString(String paramString) {
/* 196 */     return decodeString(paramString, false);
/*     */   }
/*     */   
/*     */   public static String decodeString(String paramString, boolean paramBoolean) {
/* 200 */     return new String(decode(paramString.toCharArray(), paramBoolean ? urlsafeMap.decodingMap : regularMap.decodingMap));
/*     */   }
/*     */   
/*     */   public static byte[] decodeLines(String paramString) {
/* 204 */     return decodeLines(paramString, regularMap.decodingMap);
/*     */   }
/*     */   
/*     */   public static byte[] decodeLines(String paramString, CharMap paramCharMap) {
/* 208 */     return decodeLines(paramString, paramCharMap.decodingMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decodeLines(String paramString, byte[] paramArrayOfbyte) {
/* 218 */     char[] arrayOfChar = new char[paramString.length()];
/* 219 */     byte b1 = 0;
/* 220 */     for (byte b2 = 0; b2 < paramString.length(); b2++) {
/*     */       char c;
/* 222 */       if ((c = paramString.charAt(b2)) != ' ' && c != '\r' && c != '\n' && c != '\t') {
/* 223 */         arrayOfChar[b1++] = c;
/*     */       }
/*     */     } 
/* 226 */     return decode(arrayOfChar, 0, b1, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(String paramString) {
/* 234 */     return decode(paramString.toCharArray());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(String paramString, CharMap paramCharMap) {
/* 243 */     return decode(paramString.toCharArray(), paramCharMap);
/*     */   }
/*     */   
/*     */   public static byte[] decode(char[] paramArrayOfchar, byte[] paramArrayOfbyte) {
/* 247 */     return decode(paramArrayOfchar, 0, paramArrayOfchar.length, paramArrayOfbyte);
/*     */   }
/*     */   
/*     */   public static byte[] decode(char[] paramArrayOfchar, CharMap paramCharMap) {
/* 251 */     return decode(paramArrayOfchar, 0, paramArrayOfchar.length, paramCharMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(char[] paramArrayOfchar) {
/* 259 */     return decode(paramArrayOfchar, 0, paramArrayOfchar.length, regularMap.decodingMap);
/*     */   }
/*     */   
/*     */   public static byte[] decode(char[] paramArrayOfchar, int paramInt1, int paramInt2, CharMap paramCharMap) {
/* 263 */     return decode(paramArrayOfchar, paramInt1, paramInt2, paramCharMap.decodingMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte[] decode(char[] paramArrayOfchar, int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
/* 274 */     if (paramInt2 % 4 != 0) {
/* 275 */       throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
/*     */     }
/* 277 */     while (paramInt2 > 0 && paramArrayOfchar[paramInt1 + paramInt2 - 1] == '=') {
/* 278 */       paramInt2--;
/*     */     }
/*     */     int i;
/* 281 */     byte[] arrayOfByte = new byte[i = paramInt2 * 3 / 4];
/* 282 */     int j = paramInt1;
/* 283 */     paramInt1 += paramInt2;
/* 284 */     paramInt2 = 0;
/* 285 */     while (j < paramInt1) {
/* 286 */       char c1 = paramArrayOfchar[j++];
/* 287 */       char c2 = paramArrayOfchar[j++];
/* 288 */       int n = (j < paramInt1) ? paramArrayOfchar[j++] : 65;
/* 289 */       byte b = (j < paramInt1) ? paramArrayOfchar[j++] : 65;
/* 290 */       if (c1 > '' || c2 > '' || n > 127 || b > Byte.MAX_VALUE) {
/* 291 */         throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
/*     */       }
/* 293 */       byte b1 = paramArrayOfbyte[c1];
/* 294 */       byte b2 = paramArrayOfbyte[c2];
/* 295 */       n = paramArrayOfbyte[n];
/* 296 */       b = paramArrayOfbyte[b];
/* 297 */       if (b1 < 0 || b2 < 0 || n < 0 || b < 0) {
/* 298 */         throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
/*     */       }
/* 300 */       int k = b1 << 2 | b2 >>> 4;
/* 301 */       int m = (b2 & 0xF) << 4 | n >>> 2;
/* 302 */       n = (n & 0x3) << 6 | b;
/* 303 */       arrayOfByte[paramInt2++] = (byte)k;
/* 304 */       if (paramInt2 < i) {
/* 305 */         arrayOfByte[paramInt2++] = (byte)m;
/*     */       }
/* 307 */       if (paramInt2 < i) {
/* 308 */         arrayOfByte[paramInt2++] = (byte)n;
/*     */       }
/*     */     } 
/* 311 */     return arrayOfByte;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\Base64Coder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */