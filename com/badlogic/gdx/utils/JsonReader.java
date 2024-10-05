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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonReader
/*     */   implements BaseJsonReader
/*     */ {
/*     */   public JsonValue parse(String paramString) {
/*  39 */     char[] arrayOfChar = paramString.toCharArray();
/*  40 */     return parse(arrayOfChar, 0, arrayOfChar.length);
/*     */   }
/*     */   
/*     */   public JsonValue parse(Reader paramReader) {
/*  44 */     null = new char[1024];
/*  45 */     int i = 0;
/*     */     
/*     */     try {
/*     */       int j;
/*  49 */       while ((j = paramReader.read(null, i, null.length - i)) != -1) {
/*  50 */         char[] arrayOfChar; if (j == 0) {
/*  51 */           arrayOfChar = new char[null.length << 1];
/*  52 */           System.arraycopy(null, 0, arrayOfChar, 0, null.length);
/*  53 */           null = arrayOfChar; continue;
/*     */         } 
/*  55 */         i += arrayOfChar;
/*     */       } 
/*  57 */     } catch (IOException iOException) {
/*  58 */       throw new SerializationException("Error reading input.", iOException);
/*     */     } finally {
/*  60 */       StreamUtils.closeQuietly(paramReader);
/*     */     } 
/*  62 */     return parse((char[])SYNTHETIC_LOCAL_VARIABLE_2, 0, i);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonValue parse(InputStream paramInputStream) {
/*     */     try {
/*  68 */       InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream, "UTF-8");
/*  69 */     } catch (Exception exception) {
/*  70 */       throw new SerializationException("Error reading stream.", exception);
/*     */     } 
/*  72 */     return parse((Reader)exception);
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonValue parse(FileHandle paramFileHandle) {
/*     */     try {
/*  78 */       Reader reader = paramFileHandle.reader("UTF-8");
/*  79 */     } catch (Exception exception) {
/*  80 */       throw new SerializationException("Error reading file: " + paramFileHandle, exception);
/*     */     } 
/*     */     try {
/*  83 */       return parse((Reader)exception);
/*  84 */     } catch (Exception exception1) {
/*  85 */       throw new SerializationException("Error parsing file: " + paramFileHandle, exception1);
/*     */     } 
/*     */   }
/*     */   public JsonValue parse(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*     */     int k;
/*  90 */     this.stop = false;
/*  91 */     int i = paramInt1;
/*  92 */     int[] arrayOfInt = new int[4];
/*     */     
/*  94 */     int j = 0;
/*  95 */     String str = null;
/*  96 */     boolean bool1 = false, bool2 = false, bool3 = false;
/*  97 */     RuntimeException runtimeException = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 106 */       paramInt1 = 1;
/* 107 */       byte b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       k = 0;
/*     */       label256: while (true) {
/*     */         int m;
/*     */         int n;
/* 121 */         switch (k) {
/*     */           case false:
/* 123 */             if (i == paramInt2) {
/* 124 */               k = 4;
/*     */               continue;
/*     */             } 
/* 127 */             if (paramInt1 == 0) {
/* 128 */               k = 5;
/*     */               continue;
/*     */             } 
/*     */ 
/*     */           
/*     */           case true:
/* 134 */             n = _json_key_offsets[paramInt1];
/* 135 */             m = _json_index_offsets[paramInt1];
/*     */             
/* 137 */             if ((k = _json_single_lengths[paramInt1]) > 0) {
/* 138 */               int i1 = n;
/*     */               
/* 140 */               int i2 = n + k - 1;
/*     */               while (true) {
/* 142 */                 if (i2 >= i1)
/*     */                 
/* 144 */                 { int i3 = i1 + (i2 - i1 >> 1);
/* 145 */                   if (paramArrayOfchar[i] < _json_trans_keys[i3]) {
/* 146 */                     i2 = i3 - 1; continue;
/* 147 */                   }  if (paramArrayOfchar[i] > _json_trans_keys[i3]) {
/* 148 */                     i1 = i3 + 1; continue;
/*     */                   } 
/* 150 */                   m = m + i3 - n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 180 */                   m = _json_indicies[m];
/* 181 */                   paramInt1 = _json_trans_targs[m];
/*     */                   
/* 183 */                   if (_json_trans_actions[m] != 0)
/* 184 */                   { k = _json_trans_actions[m];
/* 185 */                     m = _json_actions[k++]; label246: while (true)
/* 186 */                     { if (m-- > 0)
/* 187 */                       { String str1; switch (_json_actions[k++])
/*     */                         
/*     */                         { 
/*     */                           case 0:
/* 191 */                             bool2 = true;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 1:
/* 197 */                             str1 = new String(paramArrayOfchar, j, i - j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 2:
/* 277 */                             startObject(str);
/* 278 */                             if (!this.stop) {
/* 279 */                               str = null;
/*     */                               
/* 281 */                               if (b == arrayOfInt.length) arrayOfInt = Arrays.copyOf(arrayOfInt, arrayOfInt.length << 1);
/*     */                               
/* 283 */                               arrayOfInt[b++] = paramInt1;
/* 284 */                               paramInt1 = 5;
/* 285 */                               k = 2;
/*     */                               continue label256;
/*     */                             } 
/*     */                             // Byte code: goto -> 2088
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 3:
/* 295 */                             pop();
/* 296 */                             if (!this.stop) {
/*     */                               
/* 298 */                               paramInt1 = arrayOfInt[--b];
/* 299 */                               k = 2;
/*     */                               continue label256;
/*     */                             } 
/*     */                             // Byte code: goto -> 2088
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 4:
/* 308 */                             startArray(str);
/* 309 */                             if (!this.stop) {
/* 310 */                               str = null;
/*     */                               
/* 312 */                               if (b == arrayOfInt.length) arrayOfInt = Arrays.copyOf(arrayOfInt, arrayOfInt.length << 1);
/*     */                               
/* 314 */                               arrayOfInt[b++] = paramInt1;
/* 315 */                               paramInt1 = 23;
/* 316 */                               k = 2;
/*     */                               continue label256;
/*     */                             } 
/*     */                             // Byte code: goto -> 2088
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 5:
/* 326 */                             pop();
/* 327 */                             if (!this.stop) {
/*     */                               
/* 329 */                               paramInt1 = arrayOfInt[--b];
/* 330 */                               k = 2;
/*     */                               continue label256;
/*     */                             } 
/*     */                             // Byte code: goto -> 2088
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 6:
/* 339 */                             if (paramArrayOfchar[i++] == '/') {
/* 340 */                               while (i != paramInt2 && paramArrayOfchar[i] != '\n')
/* 341 */                                 i++; 
/* 342 */                               i--; continue;
/*     */                             } 
/* 344 */                             while (i + 1 < paramInt2 && (paramArrayOfchar[i] != '*' || paramArrayOfchar[i + 1] != '/'))
/* 345 */                               i++; 
/* 346 */                             i++;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 7:
/* 355 */                             j = i;
/* 356 */                             bool1 = false;
/* 357 */                             bool3 = true;
/* 358 */                             if (bool2) {
/*     */                               do {
/*     */                                 char c;
/* 361 */                                 switch (paramArrayOfchar[i]) {
/*     */                                   case '\\':
/* 363 */                                     bool1 = true;
/*     */                                     break;
/*     */                                   case '/':
/* 366 */                                     if (i + 1 != paramInt2 && ((
/*     */                                       
/* 368 */                                       c = paramArrayOfchar[i + 1]) == '/' || c == '*'))
/*     */                                       break; 
/*     */                                     break;
/*     */                                   case '\n':
/*     */                                   case '\r':
/*     */                                   case ':':
/*     */                                     break;
/*     */                                 } 
/* 376 */                                 ++i;
/* 377 */                               } while (i != paramInt2);
/*     */                             } else {
/*     */                               do {
/*     */                                 char c;
/*     */                                 
/* 382 */                                 switch (paramArrayOfchar[i]) {
/*     */                                   case '\\':
/* 384 */                                     bool1 = true;
/*     */                                     break;
/*     */                                   case '/':
/* 387 */                                     if (i + 1 != paramInt2 && ((
/*     */                                       
/* 389 */                                       c = paramArrayOfchar[i + 1]) == '/' || c == '*'))
/*     */                                       break; 
/*     */                                     break;
/*     */                                   case '\n':
/*     */                                   case '\r':
/*     */                                   case ',':
/*     */                                   case ']':
/*     */                                   case '}':
/*     */                                     break;
/*     */                                 } 
/* 399 */                                 ++i;
/* 400 */                               } while (i != paramInt2);
/*     */                             } 
/*     */                             while (true) {
/* 403 */                               i--;
/* 404 */                               if (Character.isSpace(paramArrayOfchar[i])) {
/*     */                                 continue;
/*     */                               }
/*     */                               continue label246;
/*     */                             } 
/*     */ 
/*     */                           
/*     */                           case 8:
/* 412 */                             j = ++i;
/* 413 */                             bool1 = false;
/*     */                             
/*     */                             do {
/* 416 */                               switch (paramArrayOfchar[i]) {
/*     */                                 case '\\':
/* 418 */                                   bool1 = true;
/* 419 */                                   i++;
/*     */                                   break;
/*     */                                 
/*     */                                 case '"':
/*     */                                   break;
/*     */                               } 
/* 425 */                               ++i;
/* 426 */                             } while (i != paramInt2);
/*     */                             
/* 428 */                             i--; continue; }  continue; }  continue label256; }  } else { continue; }  } else { break; } 
/*     */               }  n = n + k; m += k;
/*     */             }  if ((k = _json_range_lengths[paramInt1]) > 0) { int i1 = n; int i2 = n + (k << 1) - 2; while (true) { if (i2 >= i1) { int i3 = i1 + (i2 - i1 >> 1 & 0xFFFFFFFE); if (paramArrayOfchar[i] < _json_trans_keys[i3]) { i2 = i3 - 2; continue; }
/*     */                    if (paramArrayOfchar[i] > _json_trans_keys[i3 + 1]) { i1 = i3 + 2; continue; }
/*     */                    m += i3 - n >> 1; break; }
/*     */                  m += k; break; }
/*     */                continue; }
/*     */              continue;
/*     */           case true:
/* 437 */             if (paramInt1 == 0) {
/* 438 */               k = 5;
/*     */               continue;
/*     */             } 
/* 441 */             if (++i != paramInt2) {
/* 442 */               k = 1;
/*     */               continue;
/*     */             } 
/*     */           case true:
/* 446 */             if (i == paramInt2) {
/* 447 */               byte b1 = _json_eof_actions[paramInt1];
/* 448 */               byte b2 = _json_actions[b1++];
/* 449 */               while (b2-- > 0) {
/* 450 */                 String str1; switch (_json_actions[b1++]) {
/*     */ 
/*     */                   
/*     */                   case 1:
/* 454 */                     str1 = new String(paramArrayOfchar, j, i - j);
/*     */                 } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         break;
/*     */       } 
/* 543 */     } catch (RuntimeException runtimeException2) {
/* 544 */       RuntimeException runtimeException1 = null;
/*     */     } 
/*     */     
/* 547 */     JsonValue jsonValue = this.root;
/* 548 */     this.root = null;
/* 549 */     this.current = null;
/* 550 */     this.lastChild.clear();
/*     */     
/* 552 */     if (!this.stop) {
/* 553 */       if (i < paramInt2) {
/* 554 */         byte b = 1;
/* 555 */         for (k = 0; k < i; k++) {
/* 556 */           if (paramArrayOfchar[k] == '\n') b++; 
/* 557 */         }  k = Math.max(0, i - 32);
/* 558 */         throw new SerializationException("Error parsing JSON on line " + b + " near: " + new String(paramArrayOfchar, k, i - k) + "*ERROR*" + new String(paramArrayOfchar, i, 
/* 559 */               Math.min(64, paramInt2 - i)), runtimeException);
/*     */       } 
/* 561 */       if (this.elements.size != 0) {
/* 562 */         JsonValue jsonValue1 = this.elements.peek();
/* 563 */         this.elements.clear();
/* 564 */         if (jsonValue1 != null && jsonValue1.isObject()) {
/* 565 */           throw new SerializationException("Error parsing JSON, unmatched brace.");
/*     */         }
/* 567 */         throw new SerializationException("Error parsing JSON, unmatched bracket.");
/*     */       } 
/* 569 */       if (runtimeException != null) throw new SerializationException("Error parsing JSON: " + new String(paramArrayOfchar), runtimeException); 
/*     */     } 
/* 571 */     return k;
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] init__json_actions_0() {
/* 576 */     return new byte[] { 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5 };
/*     */   }
/*     */   
/* 579 */   private static final byte[] _json_actions = init__json_actions_0();
/*     */   
/*     */   private static short[] init__json_key_offsets_0() {
/* 582 */     return new short[] { 0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184 };
/*     */   }
/*     */ 
/*     */   
/* 586 */   private static final short[] _json_key_offsets = init__json_key_offsets_0();
/*     */   
/*     */   private static char[] init__json_trans_keys_0() {
/* 589 */     return new char[] { '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '"', '*', '/', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '\r', ' ', '/', ':', '\t', '\n', '*', '/', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', '}', '\t', '\n', '\r', ' ', ',', '/', '}', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '"', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '"', ',', '/', ':', '}', '\t', '\n', '*', '/', '*', '/', '"', '*', '/', '*', '/', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', ' ', ',', '/', ']', '\t', '\n', '\r', ' ', ',', '/', ']', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '"', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '\r', ' ', '"', ',', '/', ':', '[', ']', '{', '\t', '\n', '*', '/', '*', '/', '*', '/', '\r', ' ', '/', '\t', '\n', '\r', ' ', '/', '\t', '\n', Character.MIN_VALUE };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 598 */   private static final char[] _json_trans_keys = init__json_trans_keys_0();
/*     */   
/*     */   private static byte[] init__json_single_lengths_0() {
/* 601 */     return new byte[] { 0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 605 */   private static final byte[] _json_single_lengths = init__json_single_lengths_0();
/*     */   
/*     */   private static byte[] init__json_range_lengths_0() {
/* 608 */     return new byte[] { 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 612 */   private static final byte[] _json_range_lengths = init__json_range_lengths_0();
/*     */   
/*     */   private static short[] init__json_index_offsets_0() {
/* 615 */     return new short[] { 0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207 };
/*     */   }
/*     */ 
/*     */   
/* 619 */   private static final short[] _json_index_offsets = init__json_index_offsets_0();
/*     */   
/*     */   private static byte[] init__json_indicies_0() {
/* 622 */     return new byte[] { 1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, 11, 11, 12, 13, 14, 3, 15, 11, 10, 16, 16, 17, 18, 16, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, 33, 34, 34, 33, 13, 35, 15, 3, 34, 34, 12, 36, 37, 3, 15, 34, 10, 16, 3, 36, 36, 12, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, 12, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, 44, 44, 3, 45, 45, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 55, 54, 56, 57, 58, 3, 59, 60, 60, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 631 */   private static final byte[] _json_indicies = init__json_indicies_0();
/*     */   
/*     */   private static byte[] init__json_trans_targs_0() {
/* 634 */     return new byte[] { 35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, 11, 11, 11, 12, 17, 19, 37, 11, 12, 19, 14, 16, 15, 14, 12, 18, 17, 11, 9, 5, 24, 23, 27, 31, 34, 25, 38, 25, 25, 26, 31, 33, 38, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 639 */   private static final byte[] _json_trans_targs = init__json_trans_targs_0();
/*     */   
/*     */   private static byte[] init__json_trans_actions_0() {
/* 642 */     return new byte[] { 13, 0, 15, 0, 0, 7, 3, 11, 1, 11, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, 11, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 11, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, 11, 11, 0, 11, 11, 11, 1, 0, 0 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 647 */   private static final byte[] _json_trans_actions = init__json_trans_actions_0();
/*     */   
/*     */   private static byte[] init__json_eof_actions_0() {
/* 650 */     return new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 654 */   private static final byte[] _json_eof_actions = init__json_eof_actions_0();
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
/*     */   static final int json_en_main = 1;
/* 666 */   private final Array<JsonValue> elements = new Array<>(8);
/* 667 */   private final Array<JsonValue> lastChild = new Array<>(8);
/*     */   private JsonValue root;
/*     */   private JsonValue current;
/*     */   private boolean stop;
/*     */   
/*     */   public void stop() {
/* 673 */     this.stop = true;
/*     */   }
/*     */   
/*     */   public boolean isStopped() {
/* 677 */     return this.stop;
/*     */   }
/*     */   
/*     */   private void addChild(@Null String paramString, JsonValue paramJsonValue) {
/* 681 */     paramJsonValue.setName(paramString);
/* 682 */     if (this.current == null) {
/* 683 */       this.current = paramJsonValue;
/* 684 */       this.root = paramJsonValue; return;
/* 685 */     }  if (this.current.isArray() || this.current.isObject()) {
/* 686 */       paramJsonValue.parent = this.current;
/* 687 */       if (this.current.size == 0) {
/* 688 */         this.current.child = paramJsonValue;
/*     */       } else {
/*     */         JsonValue jsonValue;
/* 691 */         (jsonValue = this.lastChild.pop()).next = paramJsonValue;
/* 692 */         paramJsonValue.prev = jsonValue;
/*     */       } 
/* 694 */       this.lastChild.add(paramJsonValue);
/* 695 */       this.current.size++; return;
/*     */     } 
/* 697 */     this.root = this.current;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void startObject(@Null String paramString) {
/* 702 */     JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
/* 703 */     if (this.current != null) addChild(paramString, jsonValue); 
/* 704 */     this.elements.add(jsonValue);
/* 705 */     this.current = jsonValue;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void startArray(@Null String paramString) {
/* 710 */     JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
/* 711 */     if (this.current != null) addChild(paramString, jsonValue); 
/* 712 */     this.elements.add(jsonValue);
/* 713 */     this.current = jsonValue;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void pop() {
/* 718 */     this.root = this.elements.pop();
/* 719 */     if (this.current.size > 0) this.lastChild.pop(); 
/* 720 */     this.current = (this.elements.size > 0) ? this.elements.peek() : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void string(@Null String paramString1, String paramString2) {
/* 725 */     addChild(paramString1, new JsonValue(paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void number(@Null String paramString1, double paramDouble, String paramString2) {
/* 730 */     addChild(paramString1, new JsonValue(paramDouble, paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void number(@Null String paramString1, long paramLong, String paramString2) {
/* 735 */     addChild(paramString1, new JsonValue(paramLong, paramString2));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void bool(@Null String paramString, boolean paramBoolean) {
/* 740 */     addChild(paramString, new JsonValue(paramBoolean));
/*     */   }
/*     */ 
/*     */   
/*     */   protected String unescape(String paramString) {
/* 745 */     int i = paramString.length();
/* 746 */     StringBuilder stringBuilder = new StringBuilder(i + 16);
/* 747 */     for (byte b = 0; b < i; ) {
/*     */       char c;
/* 749 */       if ((c = paramString.charAt(b++)) != '\\') {
/* 750 */         stringBuilder.append(c);
/*     */         continue;
/*     */       } 
/* 753 */       if (b != i) {
/*     */         
/* 755 */         if ((c = paramString.charAt(b++)) == 'u') {
/* 756 */           stringBuilder.append(Character.toChars(Integer.parseInt(paramString.substring(b, b + 4), 16)));
/* 757 */           b += 4;
/*     */           continue;
/*     */         } 
/* 760 */         switch (c) {
/*     */           case '"':
/*     */           case '/':
/*     */           case '\\':
/*     */             break;
/*     */           case 'b':
/* 766 */             c = '\b';
/*     */             break;
/*     */           case 'f':
/* 769 */             c = '\f';
/*     */             break;
/*     */           case 'n':
/* 772 */             c = '\n';
/*     */             break;
/*     */           case 'r':
/* 775 */             c = '\r';
/*     */             break;
/*     */           case 't':
/* 778 */             c = '\t';
/*     */             break;
/*     */           default:
/* 781 */             throw new SerializationException("Illegal escaped character: \\" + c);
/*     */         } 
/* 783 */         stringBuilder.append(c);
/*     */       } 
/* 785 */     }  return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\JsonReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */