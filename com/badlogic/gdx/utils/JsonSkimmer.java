/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
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
/*     */ 
/*     */ 
/*     */ public class JsonSkimmer
/*     */ {
/*     */   public void parse(String paramString) {
/*  35 */     char[] arrayOfChar = paramString.toCharArray();
/*  36 */     parse(arrayOfChar, 0, arrayOfChar.length);
/*     */   }
/*     */   
/*     */   public void parse(Reader paramReader) {
/*  40 */     null = new char[1024];
/*  41 */     int i = 0;
/*     */     
/*     */     try {
/*     */       int j;
/*  45 */       while ((j = paramReader.read(null, i, null.length - i)) != -1) {
/*  46 */         char[] arrayOfChar; if (j == 0) {
/*  47 */           arrayOfChar = new char[null.length << 1];
/*  48 */           System.arraycopy(null, 0, arrayOfChar, 0, null.length);
/*  49 */           null = arrayOfChar; continue;
/*     */         } 
/*  51 */         i += arrayOfChar;
/*     */       } 
/*  53 */     } catch (IOException iOException) {
/*  54 */       throw new SerializationException("Error reading input.", iOException);
/*     */     } finally {
/*  56 */       StreamUtils.closeQuietly(paramReader);
/*     */     } 
/*  58 */     parse((char[])SYNTHETIC_LOCAL_VARIABLE_2, 0, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public void parse(InputStream paramInputStream) {
/*     */     try {
/*  64 */       InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, "UTF-8");
/*  65 */     } catch (Exception exception) {
/*  66 */       throw new SerializationException("Error reading stream.", exception);
/*     */     } 
/*  68 */     parse((Reader)exception);
/*     */   }
/*     */ 
/*     */   
/*     */   public void parse(FileHandle paramFileHandle) {
/*     */     try {
/*  74 */       Reader reader = paramFileHandle.reader("UTF-8");
/*  75 */     } catch (Exception exception) {
/*  76 */       throw new SerializationException("Error reading file: " + paramFileHandle, exception);
/*     */     } 
/*     */     try {
/*  79 */       parse((Reader)exception); return;
/*  80 */     } catch (Exception exception1) {
/*  81 */       throw new SerializationException("Error parsing file: " + paramFileHandle, exception1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void parse(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  86 */     this.stop = false;
/*  87 */     int i = paramInt1;
/*  88 */     int[] arrayOfInt = new int[4];
/*     */     
/*  90 */     int j = 0;
/*  91 */     String str = null;
/*  92 */     boolean bool1 = false, bool2 = false, bool3 = false;
/*  93 */     RuntimeException runtimeException = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 102 */       paramInt1 = 1;
/* 103 */       byte b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       byte b1 = 0;
/*     */       label183: while (true) {
/*     */         int k;
/*     */         int m;
/* 117 */         switch (b1) {
/*     */           case false:
/* 119 */             if (i == paramInt2) {
/* 120 */               b1 = 4;
/*     */               continue;
/*     */             } 
/* 123 */             if (paramInt1 == 0) {
/* 124 */               b1 = 5;
/*     */               continue;
/*     */             } 
/*     */ 
/*     */           
/*     */           case true:
/* 130 */             m = _json_key_offsets[paramInt1];
/* 131 */             k = _json_index_offsets[paramInt1];
/*     */             
/* 133 */             if ((b1 = _json_single_lengths[paramInt1]) > 0) {
/* 134 */               int n = m;
/*     */               
/* 136 */               int i1 = m + b1 - 1;
/*     */               while (true) {
/* 138 */                 if (i1 >= n)
/*     */                 
/* 140 */                 { int i2 = n + (i1 - n >> 1);
/* 141 */                   if (paramArrayOfchar[i] < _json_trans_keys[i2]) {
/* 142 */                     i1 = i2 - 1; continue;
/* 143 */                   }  if (paramArrayOfchar[i] > _json_trans_keys[i2]) {
/* 144 */                     n = i2 + 1; continue;
/*     */                   } 
/* 146 */                   k = k + i2 - m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 176 */                   k = _json_indicies[k];
/* 177 */                   paramInt1 = _json_trans_targs[k];
/*     */                   
/* 179 */                   if (_json_trans_actions[k] != 0)
/* 180 */                   { b1 = _json_trans_actions[k];
/* 181 */                     k = _json_actions[b1++]; label178: while (true)
/* 182 */                     { if (k-- > 0)
/* 183 */                       { String str1; switch (_json_actions[b1++])
/*     */                         
/*     */                         { 
/*     */                           case 0:
/* 187 */                             bool2 = true;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 1:
/* 193 */                             str1 = new String(paramArrayOfchar, j, i - j);
/* 194 */                             if (bool1) str1 = unescape(str1); 
/* 195 */                             if (bool2) {
/* 196 */                               bool2 = false;
/*     */                               
/* 198 */                               str = str1;
/*     */                             } else {
/*     */                               
/* 201 */                               value(str, str1, bool3);
/* 202 */                               str = null;
/*     */                             } 
/* 204 */                             if (this.stop)
/* 205 */                               return;  bool3 = false;
/* 206 */                             j = i;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 2:
/* 213 */                             push(str, true);
/* 214 */                             if (this.stop)
/* 215 */                               return;  str = null;
/*     */                             
/* 217 */                             if (b == arrayOfInt.length) arrayOfInt = Arrays.copyOf(arrayOfInt, arrayOfInt.length << 1);
/*     */                             
/* 219 */                             arrayOfInt[b++] = paramInt1;
/* 220 */                             paramInt1 = 5;
/* 221 */                             b1 = 2;
/*     */                             continue label183;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 3:
/* 231 */                             pop();
/* 232 */                             if (this.stop)
/*     */                               return; 
/* 234 */                             paramInt1 = arrayOfInt[--b];
/* 235 */                             b1 = 2;
/*     */                             continue label183;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 4:
/* 244 */                             push(str, false);
/* 245 */                             if (this.stop)
/* 246 */                               return;  str = null;
/*     */                             
/* 248 */                             if (b == arrayOfInt.length) arrayOfInt = Arrays.copyOf(arrayOfInt, arrayOfInt.length << 1);
/*     */                             
/* 250 */                             arrayOfInt[b++] = paramInt1;
/* 251 */                             paramInt1 = 23;
/* 252 */                             b1 = 2;
/*     */                             continue label183;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 5:
/* 262 */                             pop();
/* 263 */                             if (this.stop)
/*     */                               return; 
/* 265 */                             paramInt1 = arrayOfInt[--b];
/* 266 */                             b1 = 2;
/*     */                             continue label183;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 6:
/* 275 */                             if (paramArrayOfchar[i++] == '/') {
/* 276 */                               while (i != paramInt2 && paramArrayOfchar[i] != '\n')
/* 277 */                                 i++; 
/* 278 */                               i--; continue;
/*     */                             } 
/* 280 */                             while ((i + 1 < paramInt2 && paramArrayOfchar[i] != '*') || paramArrayOfchar[i + 1] != '/')
/* 281 */                               i++; 
/* 282 */                             i++;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 7:
/* 291 */                             j = i;
/* 292 */                             bool1 = false;
/* 293 */                             bool3 = true;
/* 294 */                             if (bool2) {
/*     */                               do {
/*     */                                 char c;
/* 297 */                                 switch (paramArrayOfchar[i]) {
/*     */                                   case '\\':
/* 299 */                                     bool1 = true;
/*     */                                     break;
/*     */                                   case '/':
/* 302 */                                     if (i + 1 != paramInt2 && ((
/*     */                                       
/* 304 */                                       c = paramArrayOfchar[i + 1]) == '/' || c == '*'))
/*     */                                       break; 
/*     */                                     break;
/*     */                                   case '\n':
/*     */                                   case '\r':
/*     */                                   case ':':
/*     */                                     break;
/*     */                                 } 
/* 312 */                                 ++i;
/* 313 */                               } while (i != paramInt2);
/*     */                             } else {
/*     */                               do {
/*     */                                 char c;
/*     */                                 
/* 318 */                                 switch (paramArrayOfchar[i]) {
/*     */                                   case '\\':
/* 320 */                                     bool1 = true;
/*     */                                     break;
/*     */                                   case '/':
/* 323 */                                     if (i + 1 != paramInt2 && ((
/*     */                                       
/* 325 */                                       c = paramArrayOfchar[i + 1]) == '/' || c == '*'))
/*     */                                       break; 
/*     */                                     break;
/*     */                                   case '\n':
/*     */                                   case '\r':
/*     */                                   case ',':
/*     */                                   case ']':
/*     */                                   case '}':
/*     */                                     break;
/*     */                                 } 
/* 335 */                                 ++i;
/* 336 */                               } while (i != paramInt2);
/*     */                             } 
/*     */                             while (true) {
/* 339 */                               i--;
/* 340 */                               if (Character.isSpace(paramArrayOfchar[i])) {
/*     */                                 continue;
/*     */                               }
/*     */                               continue label178;
/*     */                             } 
/*     */ 
/*     */                           
/*     */                           case 8:
/* 348 */                             j = ++i;
/* 349 */                             bool1 = false;
/*     */                             
/*     */                             do {
/* 352 */                               switch (paramArrayOfchar[i]) {
/*     */                                 case '\\':
/* 354 */                                   bool1 = true;
/* 355 */                                   i++;
/*     */                                   break;
/*     */                                 
/*     */                                 case '"':
/*     */                                   break;
/*     */                               } 
/* 361 */                               ++i;
/* 362 */                             } while (i != paramInt2);
/*     */                             
/* 364 */                             i--; continue; }  continue; }  continue label183; }  } else { continue; }  } else { break; } 
/*     */               }  m = m + b1; k += b1;
/*     */             }  if ((b1 = _json_range_lengths[paramInt1]) > 0) { int n = m; int i1 = m + (b1 << 1) - 2; while (true) { if (i1 >= n) { int i2 = n + (i1 - n >> 1 & 0xFFFFFFFE); if (paramArrayOfchar[i] < _json_trans_keys[i2]) { i1 = i2 - 2; continue; }
/*     */                    if (paramArrayOfchar[i] > _json_trans_keys[i2 + 1]) { n = i2 + 2; continue; }
/*     */                    k += i2 - m >> 1; break; }
/*     */                  k += b1; break; }
/*     */                continue; }
/*     */              continue;
/*     */           case true:
/* 373 */             if (paramInt1 == 0) {
/* 374 */               b1 = 5;
/*     */               continue;
/*     */             } 
/* 377 */             if (++i != paramInt2) {
/* 378 */               b1 = 1;
/*     */               continue;
/*     */             } 
/*     */           case true:
/* 382 */             if (i == paramInt2) {
/* 383 */               byte b2 = _json_eof_actions[paramInt1];
/* 384 */               byte b3 = _json_actions[b2++];
/* 385 */               while (b3-- > 0) {
/* 386 */                 String str1; switch (_json_actions[b2++]) {
/*     */ 
/*     */                   
/*     */                   case 1:
/* 390 */                     str1 = new String(paramArrayOfchar, j, i - j);
/* 391 */                     if (bool1) str1 = unescape(str1); 
/* 392 */                     if (bool2) {
/* 393 */                       bool2 = false;
/*     */                       
/* 395 */                       str = str1;
/*     */                     } else {
/*     */                       
/* 398 */                       value(str, str1, bool3);
/* 399 */                       str = null;
/*     */                     } 
/* 401 */                     if (this.stop)
/* 402 */                       return;  bool3 = false;
/* 403 */                     j = i;
/*     */                 } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*     */               } 
/*     */             } 
/*     */             break;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/* 419 */     } catch (RuntimeException runtimeException2) {
/* 420 */       RuntimeException runtimeException1 = null;
/*     */     } 
/*     */     
/* 423 */     if (i < paramInt2) {
/* 424 */       byte b = 1; int k;
/* 425 */       for (k = 0; k < i; k++) {
/* 426 */         if (paramArrayOfchar[k] == '\n') b++; 
/* 427 */       }  k = Math.max(0, i - 32);
/* 428 */       throw new SerializationException("Error parsing JSON on line " + b + " near: " + new String(paramArrayOfchar, k, i - k) + "*ERROR*" + new String(paramArrayOfchar, i, 
/* 429 */             Math.min(64, paramInt2 - i)), runtimeException);
/*     */     } 
/* 431 */     if (runtimeException != null) throw new SerializationException("Error parsing JSON: " + new String(paramArrayOfchar), runtimeException);
/*     */   
/*     */   }
/*     */   
/*     */   private static byte[] init__json_actions_0() {
/* 436 */     return new byte[] { 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5 };
/*     */   }
/*     */   
/* 439 */   private static final byte[] _json_actions = init__json_actions_0();
/*     */   
/*     */   private static short[] init__json_key_offsets_0() {
/* 442 */     return new short[] { 0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184 };
/*     */   }
/*     */ 
/*     */   
/* 446 */   private static final short[] _json_key_offsets = init__json_key_offsets_0();
/*     */   
/*     */   private static char[] init__json_trans_keys_0() {
/* 449 */     return new char[] { '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '"', '*', '/', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '*', '/', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', '}', '\t', '\n', '\r', ' ', ',', '/', '}', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '"', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '"', '*', '/', '*', '/', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', ']', '\t', '\n', '\r', ' ', ',', '/', ']', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '"', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '*', '/', '\r', ' ', '/', '\t', '\n', '\r', ' ', '/', '\t', '\n', Character.MIN_VALUE };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 458 */   private static final char[] _json_trans_keys = init__json_trans_keys_0();
/*     */   
/*     */   private static byte[] init__json_single_lengths_0() {
/* 461 */     return new byte[] { 0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 465 */   private static final byte[] _json_single_lengths = init__json_single_lengths_0();
/*     */   
/*     */   private static byte[] init__json_range_lengths_0() {
/* 468 */     return new byte[] { 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 472 */   private static final byte[] _json_range_lengths = init__json_range_lengths_0();
/*     */   
/*     */   private static short[] init__json_index_offsets_0() {
/* 475 */     return new short[] { 0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207 };
/*     */   }
/*     */ 
/*     */   
/* 479 */   private static final short[] _json_index_offsets = init__json_index_offsets_0();
/*     */   
/*     */   private static byte[] init__json_indicies_0() {
/* 482 */     return new byte[] { 1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, 12, 13, 14, 3, 15, 11, 10, 16, 16, 17, 18, 16, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, 33, 34, 34, 33, 13, 35, 15, 3, 34, 34, 12, 36, 37, 3, 15, 34, 10, 16, 3, 36, 36, 12, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, 12, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, 44, 44, 3, 45, 45, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 55, 54, 56, 57, 58, 3, 59, 60, 60, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 491 */   private static final byte[] _json_indicies = init__json_indicies_0();
/*     */   
/*     */   private static byte[] init__json_trans_targs_0() {
/* 494 */     return new byte[] { 35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, 11, 11, 11, 12, 17, 19, 37, 11, 12, 19, 14, 16, 15, 14, 12, 18, 17, 11, 9, 5, 24, 23, 27, 31, 34, 25, 38, 25, 25, 26, 31, 33, 38, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 499 */   private static final byte[] _json_trans_targs = init__json_trans_targs_0();
/*     */   
/*     */   private static byte[] init__json_trans_actions_0() {
/* 502 */     return new byte[] { 13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 507 */   private static final byte[] _json_trans_actions = init__json_trans_actions_0();
/*     */   
/*     */   private static byte[] init__json_eof_actions_0() {
/* 510 */     return new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 514 */   private static final byte[] _json_eof_actions = init__json_eof_actions_0();
/*     */   
/*     */   static final int json_start = 1;
/*     */   
/*     */   static final int json_first_final = 35;
/*     */   
/*     */   static final int json_error = 0;
/*     */   
/*     */   static final int json_en_object = 5;
/*     */   
/*     */   static final int json_en_array = 23;
/*     */   
/*     */   static final int json_en_main = 1;
/*     */   private boolean stop;
/*     */   
/*     */   public void stop() {
/* 530 */     this.stop = true;
/*     */   }
/*     */   
/*     */   public boolean isStopped() {
/* 534 */     return this.stop;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String unescape(String paramString) {
/* 539 */     int i = paramString.length();
/* 540 */     StringBuilder stringBuilder = new StringBuilder(i + 16);
/* 541 */     for (byte b = 0; b < i; ) {
/*     */       char c;
/* 543 */       if ((c = paramString.charAt(b++)) != '\\') {
/* 544 */         stringBuilder.append(c);
/*     */         continue;
/*     */       } 
/* 547 */       if (b != i) {
/*     */         
/* 549 */         if ((c = paramString.charAt(b++)) == 'u') {
/* 550 */           stringBuilder.append(Character.toChars(Integer.parseInt(paramString.substring(b, b + 4), 16)));
/* 551 */           b += 4;
/*     */           continue;
/*     */         } 
/* 554 */         switch (c) {
/*     */           case '"':
/*     */           case '/':
/*     */           case '\\':
/*     */             break;
/*     */           case 'b':
/* 560 */             c = '\b';
/*     */             break;
/*     */           case 'f':
/* 563 */             c = '\f';
/*     */             break;
/*     */           case 'n':
/* 566 */             c = '\n';
/*     */             break;
/*     */           case 'r':
/* 569 */             c = '\r';
/*     */             break;
/*     */           case 't':
/* 572 */             c = '\t';
/*     */             break;
/*     */           default:
/* 575 */             throw new SerializationException("Illegal escaped character: \\" + c);
/*     */         } 
/* 577 */         stringBuilder.append(c);
/*     */       } 
/* 579 */     }  return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected void push(@Null String paramString, boolean paramBoolean) {}
/*     */   
/*     */   protected void pop() {}
/*     */   
/*     */   protected void value(@Null String paramString1, String paramString2, boolean paramBoolean) {}
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\JsonSkimmer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */