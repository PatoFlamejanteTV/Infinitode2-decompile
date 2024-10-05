/*     */ package com.badlogic.gdx.ai.btree.utils;
/*     */ 
/*     */ import com.badlogic.gdx.ai.GdxAI;
/*     */ import com.badlogic.gdx.files.FileHandle;
/*     */ import com.badlogic.gdx.utils.GdxRuntimeException;
/*     */ import com.badlogic.gdx.utils.SerializationException;
/*     */ import com.badlogic.gdx.utils.StreamUtils;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BehaviorTreeReader
/*     */ {
/*     */   private static final String LOG_TAG = "BehaviorTreeReader";
/*     */   protected boolean debug = false;
/*     */   protected int lineNumber;
/*     */   protected boolean reportsComments;
/*     */   
/*     */   protected abstract void startLine(int paramInt);
/*     */   
/*     */   protected abstract void startStatement(String paramString, boolean paramBoolean1, boolean paramBoolean2);
/*     */   
/*     */   protected abstract void attribute(String paramString, Object paramObject);
/*     */   
/*     */   protected abstract void endStatement();
/*     */   
/*     */   protected abstract void endLine();
/*     */   
/*     */   protected void comment(String paramString) {}
/*     */   
/*     */   public BehaviorTreeReader() {
/*  60 */     this(false);
/*     */   }
/*     */   
/*     */   public BehaviorTreeReader(boolean paramBoolean) {
/*  64 */     this.reportsComments = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(String paramString) {
/*  71 */     char[] arrayOfChar = paramString.toCharArray();
/*  72 */     parse(arrayOfChar, 0, arrayOfChar.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(Reader paramReader) {
/*     */     try {
/*  80 */       char[] arrayOfChar = new char[1024];
/*  81 */       int i = 0;
/*     */       
/*     */       int j;
/*  84 */       while ((j = paramReader.read(arrayOfChar, i, arrayOfChar.length - i)) != -1) {
/*  85 */         char[] arrayOfChar1; if (j == 0) {
/*  86 */           arrayOfChar1 = new char[arrayOfChar.length << 1];
/*  87 */           System.arraycopy(arrayOfChar, 0, arrayOfChar1, 0, arrayOfChar.length);
/*  88 */           arrayOfChar = arrayOfChar1; continue;
/*     */         } 
/*  90 */         i += arrayOfChar1;
/*     */       } 
/*  92 */       parse(arrayOfChar, 0, i); return;
/*  93 */     } catch (IOException iOException) {
/*  94 */       throw new SerializationException(iOException);
/*     */     } finally {
/*  96 */       StreamUtils.closeQuietly(paramReader);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(InputStream paramInputStream) {
/*     */     try {
/* 105 */       parse(new InputStreamReader(paramInputStream, "UTF-8")); return;
/* 106 */     } catch (IOException iOException) {
/* 107 */       throw new SerializationException(iOException);
/*     */     } finally {
/* 109 */       StreamUtils.closeQuietly(paramInputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(FileHandle paramFileHandle) {
/*     */     try {
/* 118 */       parse(paramFileHandle.reader("UTF-8")); return;
/* 119 */     } catch (Exception exception) {
/* 120 */       throw new SerializationException("Error parsing file: " + paramFileHandle, exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 130 */     int i = paramInt1;
/*     */     
/* 132 */     int j = 0;
/* 133 */     byte b = 0;
/* 134 */     byte b1 = -1;
/* 135 */     boolean bool1 = false;
/* 136 */     boolean bool2 = false;
/* 137 */     String str1 = null;
/* 138 */     boolean bool3 = false;
/* 139 */     boolean bool4 = false;
/* 140 */     boolean bool5 = false;
/* 141 */     RuntimeException runtimeException = null;
/* 142 */     String str2 = null;
/*     */     
/* 144 */     this.lineNumber = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 150 */       paramInt1 = 29;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 160 */       byte b2 = 0; label233: while (true) {
/*     */         int k;
/*     */         int m;
/* 163 */         switch (b2) {
/*     */           case false:
/* 165 */             if (i == paramInt2) {
/* 166 */               b2 = 4;
/*     */               continue;
/*     */             } 
/* 169 */             if (paramInt1 == 0) {
/* 170 */               b2 = 5;
/*     */               continue;
/*     */             } 
/*     */           
/*     */           case true:
/* 175 */             m = _btree_key_offsets[paramInt1];
/* 176 */             k = _btree_index_offsets[paramInt1];
/*     */             
/* 178 */             if ((b2 = _btree_single_lengths[paramInt1]) > 0) {
/* 179 */               int n = m;
/*     */               
/* 181 */               int i1 = m + b2 - 1;
/*     */               while (true)
/* 183 */               { if (i1 >= n)
/*     */                 
/*     */                 { 
/* 186 */                   int i2 = n + (i1 - n >> 1);
/* 187 */                   if (paramArrayOfchar[i] < _btree_trans_keys[i2]) {
/* 188 */                     i1 = i2 - 1; continue;
/* 189 */                   }  if (paramArrayOfchar[i] > _btree_trans_keys[i2]) {
/* 190 */                     n = i2 + 1; continue;
/*     */                   } 
/* 192 */                   k = k + i2 - m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/* 223 */                   k = _btree_indicies[k];
/* 224 */                   paramInt1 = _btree_trans_targs[k];
/*     */                   
/* 226 */                   if (_btree_trans_actions[k] != 0)
/* 227 */                   { b2 = _btree_trans_actions[k];
/* 228 */                     k = _btree_actions[b2++]; while (true)
/* 229 */                     { if (k-- > 0)
/*     */                       { String str;
/* 231 */                         switch (_btree_actions[b2++])
/*     */                         
/*     */                         { 
/*     */                           
/*     */                           case 0:
/* 236 */                             str = new String(paramArrayOfchar, j, i - j);
/* 237 */                             j = i;
/* 238 */                             if (bool4) str = unescape(str);
/*     */                             
/* 240 */                             if (bool5) {
/* 241 */                               if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "string: " + str2 + "=" + str); 
/* 242 */                               if (str.equals("true")) {
/* 243 */                                 if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "boolean: " + str2 + "=true"); 
/* 244 */                                 attribute(str2, Boolean.TRUE);
/*     */                               }
/* 246 */                               else if (str.equals("false")) {
/* 247 */                                 if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "boolean: " + str2 + "=false"); 
/* 248 */                                 attribute(str2, Boolean.FALSE);
/*     */                               }
/* 250 */                               else if (str.equals("null")) {
/* 251 */                                 attribute(str2, null);
/*     */                               } else {
/*     */                                 
/*     */                                 try {
/* 255 */                                   if (containsFloatingPointCharacters(str)) {
/* 256 */                                     if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "double: " + str2 + "=" + Double.parseDouble(str)); 
/* 257 */                                     attribute(str2, new Double(str));
/*     */                                   } else {
/*     */                                     
/* 260 */                                     if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "double: " + str2 + "=" + Double.parseDouble(str)); 
/* 261 */                                     attribute(str2, new Long(str));
/*     */                                   }
/*     */                                 
/* 264 */                                 } catch (NumberFormatException numberFormatException) {
/* 265 */                                   throw new GdxRuntimeException("Attribute value must be a number, a boolean, a string or null");
/*     */                                 } 
/*     */                               } 
/*     */                             } else {
/*     */                               
/* 270 */                               if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "string: " + str2 + "=\"" + str + "\""); 
/* 271 */                               attribute(str2, str);
/*     */                             } 
/* 273 */                             bool5 = false;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 1:
/* 279 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "unquotedChars"); 
/* 280 */                             j = i;
/* 281 */                             bool4 = false;
/* 282 */                             bool5 = true;
/*     */                             
/*     */                             do {
/* 285 */                               switch (paramArrayOfchar[i]) {
/*     */                                 case '\\':
/* 287 */                                   bool4 = true;
/*     */                                   break;
/*     */                                 
/*     */                                 case '\t':
/*     */                                 case '\n':
/*     */                                 case '\r':
/*     */                                 case ' ':
/*     */                                 case '(':
/*     */                                 case ')':
/*     */                                   break;
/*     */                               } 
/* 298 */                               ++i;
/* 299 */                             } while (i != paramInt2);
/*     */                             
/* 301 */                             i--;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 2:
/* 307 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "quotedChars"); 
/* 308 */                             j = ++i;
/* 309 */                             bool4 = false;
/*     */                             
/*     */                             do {
/* 312 */                               switch (paramArrayOfchar[i]) {
/*     */                                 case '\\':
/* 314 */                                   bool4 = true;
/* 315 */                                   i++;
/*     */                                   break;
/*     */                                 
/*     */                                 case '"':
/*     */                                   break;
/*     */                               } 
/* 321 */                               ++i;
/* 322 */                             } while (i != paramInt2);
/*     */                             
/* 324 */                             i--;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 3:
/* 330 */                             b = 0;
/* 331 */                             b1 = -1;
/* 332 */                             bool1 = false;
/* 333 */                             bool2 = false;
/* 334 */                             str1 = null;
/* 335 */                             bool3 = false;
/* 336 */                             this.lineNumber++;
/* 337 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "****NEWLINE**** " + this.lineNumber);
/*     */                             
/*     */                             continue;
/*     */ 
/*     */                           
/*     */                           case 4:
/* 343 */                             b++;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 5:
/* 349 */                             if (b1 >= 0) {
/* 350 */                               endStatement();
/*     */                             }
/* 352 */                             bool3 = true;
/* 353 */                             if (str1 != null)
/* 354 */                               endLine(); 
/* 355 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "endLine: indent: " + b + " taskName: " + str1 + " data[" + i + "] = " + ((i >= paramInt2) ? "EOF" : ("\"" + paramArrayOfchar[i] + "\"")));
/*     */                             
/*     */                             continue;
/*     */ 
/*     */                           
/*     */                           case 6:
/* 361 */                             j = i;
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 7:
/* 367 */                             if (this.reportsComments) {
/* 368 */                               comment(new String(paramArrayOfchar, j, i - j)); continue;
/*     */                             } 
/* 370 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "# Comment");
/*     */                             
/*     */                             continue;
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 8:
/* 377 */                             if (b1++ < 0) {
/* 378 */                               startLine(b);
/*     */                             } else {
/*     */                               
/* 381 */                               endStatement();
/*     */                             } 
/* 383 */                             str1 = new String(paramArrayOfchar, j, i - j);
/* 384 */                             startStatement(str1, bool2, bool1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                           
/*     */                           case 9:
/* 391 */                             str2 = new String(paramArrayOfchar, j, i - j);
/*     */                             continue;
/*     */ 
/*     */                           
/*     */                           case 10:
/* 396 */                             bool2 = false;
/*     */                             continue;
/*     */                           
/*     */                           case 11:
/* 400 */                             bool2 = true;
/*     */                             continue;
/*     */                           
/*     */                           case 12:
/* 404 */                             bool1 = true;
/*     */                             continue;
/*     */                           
/*     */                           case 13:
/* 408 */                             bool1 = false; continue; }  continue; }  continue label233; }  } else { continue; }  } else { break; }  }  m = m + b2; k += b2;
/*     */             }  if ((b2 = _btree_range_lengths[paramInt1]) > 0) { int n = m; int i1 = m + (b2 << 1) - 2; while (true) { if (i1 >= n) { int i2 = n + (i1 - n >> 1 & 0xFFFFFFFE); if (paramArrayOfchar[i] < _btree_trans_keys[i2]) { i1 = i2 - 2; continue; }
/*     */                    if (paramArrayOfchar[i] > _btree_trans_keys[i2 + 1]) { n = i2 + 2; continue; }
/*     */                    k += i2 - m >> 1; break; }
/*     */                  k += b2; break; }
/*     */                continue; }
/*     */              continue;
/*     */           case true:
/* 416 */             if (paramInt1 == 0) {
/* 417 */               b2 = 5;
/*     */               continue;
/*     */             } 
/* 420 */             if (++i != paramInt2) {
/* 421 */               b2 = 1;
/*     */               continue;
/*     */             } 
/*     */           case true:
/* 425 */             if (i == paramInt2) {
/*     */               
/* 427 */               byte b3 = _btree_eof_actions[paramInt1];
/* 428 */               byte b4 = _btree_actions[b3++];
/* 429 */               while (b4-- > 0) {
/* 430 */                 String str; switch (_btree_actions[b3++]) {
/*     */ 
/*     */                   
/*     */                   case 0:
/* 434 */                     str = new String(paramArrayOfchar, j, i - j);
/* 435 */                     j = i;
/* 436 */                     if (bool4) str = unescape(str);
/*     */                     
/* 438 */                     if (bool5) {
/* 439 */                       if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "string: " + str2 + "=" + str); 
/* 440 */                       if (str.equals("true")) {
/* 441 */                         if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "boolean: " + str2 + "=true"); 
/* 442 */                         attribute(str2, Boolean.TRUE);
/*     */                       }
/* 444 */                       else if (str.equals("false")) {
/* 445 */                         if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "boolean: " + str2 + "=false"); 
/* 446 */                         attribute(str2, Boolean.FALSE);
/*     */                       }
/* 448 */                       else if (str.equals("null")) {
/* 449 */                         attribute(str2, null);
/*     */                       } else {
/*     */                         
/*     */                         try {
/* 453 */                           if (containsFloatingPointCharacters(str)) {
/* 454 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "double: " + str2 + "=" + Double.parseDouble(str)); 
/* 455 */                             attribute(str2, new Double(str));
/*     */                           } else {
/*     */                             
/* 458 */                             if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "double: " + str2 + "=" + Double.parseDouble(str)); 
/* 459 */                             attribute(str2, new Long(str));
/*     */                           }
/*     */                         
/* 462 */                         } catch (NumberFormatException numberFormatException) {
/* 463 */                           throw new GdxRuntimeException("Attribute value must be a number, a boolean, a string or null");
/*     */                         } 
/*     */                       } 
/*     */                     } else {
/*     */                       
/* 468 */                       if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "string: " + str2 + "=\"" + str + "\""); 
/* 469 */                       attribute(str2, str);
/*     */                     } 
/* 471 */                     bool5 = false;
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   case 5:
/* 477 */                     if (b1 >= 0) {
/* 478 */                       endStatement();
/*     */                     }
/* 480 */                     bool3 = true;
/* 481 */                     if (str1 != null)
/* 482 */                       endLine(); 
/* 483 */                     if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "endLine: indent: " + b + " taskName: " + str1 + " data[" + i + "] = " + ((i >= paramInt2) ? "EOF" : ("\"" + paramArrayOfchar[i] + "\"")));
/*     */                   
/*     */ 
/*     */ 
/*     */                   
/*     */                   case 6:
/* 489 */                     j = i;
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   case 7:
/* 495 */                     if (this.reportsComments) {
/* 496 */                       comment(new String(paramArrayOfchar, j, i - j)); continue;
/*     */                     } 
/* 498 */                     if (this.debug) GdxAI.getLogger().info("BehaviorTreeReader", "# Comment");
/*     */                   
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   case 8:
/* 505 */                     if (b1++ < 0) {
/* 506 */                       startLine(b);
/*     */                     } else {
/*     */                       
/* 509 */                       endStatement();
/*     */                     } 
/* 511 */                     str1 = new String(paramArrayOfchar, j, i - j);
/* 512 */                     startStatement(str1, bool2, bool1);
/* 513 */                     bool1 = false;
/*     */ 
/*     */ 
/*     */                   
/*     */                   case 10:
/* 518 */                     bool2 = false;
/*     */ 
/*     */                   
/*     */                   case 11:
/* 522 */                     bool2 = true;
/*     */                 } 
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
/*     */         break;
/*     */       } 
/* 536 */     } catch (RuntimeException runtimeException2) {
/* 537 */       RuntimeException runtimeException1 = null;
/*     */     } 
/*     */     
/* 540 */     if (i < paramInt2 || (str1 != null && !bool3)) {
/* 541 */       throw new SerializationException("Error parsing behavior tree on line " + this.lineNumber + " near: " + new String(paramArrayOfchar, i, paramInt2 - i), runtimeException);
/*     */     }
/* 543 */     if (runtimeException != null) {
/* 544 */       throw new SerializationException("Error parsing behavior tree: " + new String(paramArrayOfchar), runtimeException);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_actions_0() {
/* 552 */     return new byte[] { 0, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 9, 1, 12, 1, 13, 2, 0, 5, 2, 0, 13, 2, 5, 3, 2, 7, 5, 2, 10, 8, 2, 11, 8, 3, 0, 5, 3, 3, 6, 7, 5, 3, 7, 5, 3, 3, 10, 8, 5, 3, 10, 8, 13, 3, 11, 8, 5, 3, 11, 8, 13, 4, 6, 7, 5, 3, 4, 10, 8, 5, 3, 4, 11, 8, 5, 3 };
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
/* 563 */   private static final byte[] _btree_actions = init__btree_actions_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static short[] init__btree_key_offsets_0() {
/* 568 */     return new short[] { 0, 0, 1, 6, 16, 21, 33, 37, 47, 59, 63, 72, 73, 77, 82, 87, 91, 105, 114, 126, 130, 139, 143, 144, 148, 152, 157, 170, 174, 179, 191, 196, 198, 200, 213, 218, 233, 243, 248, 253, 267 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 576 */   private static final short[] _btree_key_offsets = init__btree_key_offsets_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static char[] init__btree_trans_keys_0() {
/* 581 */     return new char[] { '\n', '_', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', '$', ')', '_', 'A', 'Z', 'a', 'z', '_', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ')', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ')', '\t', '\r', ' ', '$', '(', '_', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ':', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ':', '\t', '\n', '\r', ' ', '"', '#', ':', '(', ')', '"', '\t', '\r', ' ', ':', '_', 'A', 'Z', 'a', 'z', '_', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ')', '\t', '\r', ' ', '$', ')', '.', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ')', '_', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ':', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ':', '\t', '\n', '\r', ' ', '"', '#', ':', '(', ')', '\t', '\r', ' ', ')', '"', '\t', '\r', ' ', ')', '\t', '\r', ' ', ':', '_', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', '$', ')', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\r', ' ', ')', '_', 'A', 'Z', 'a', 'z', '\t', '\n', '\r', ' ', '#', '$', '(', '_', 'A', 'Z', 'a', 'z', '\t', '\n', '\r', ' ', '#', '\n', '\r', '\n', '\r', '\t', '\n', '\r', ' ', '#', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\n', '\r', ' ', '#', '\t', '\n', '\r', ' ', '#', '$', '.', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\n', '\r', ' ', '#', '_', 'A', 'Z', 'a', 'z', '\t', '\n', '\r', ' ', '#', '\t', '\n', '\r', ' ', '#', '\t', '\n', '\r', ' ', '#', '$', '?', '_', '0', '9', 'A', 'Z', 'a', 'z', '\t', '\n', '\r', ' ', '#', Character.MIN_VALUE };
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
/* 608 */   private static final char[] _btree_trans_keys = init__btree_trans_keys_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_single_lengths_0() {
/* 613 */     return new byte[] { 0, 1, 1, 6, 1, 6, 4, 6, 6, 4, 7, 1, 4, 1, 1, 4, 8, 5, 6, 4, 7, 4, 1, 4, 4, 1, 7, 4, 1, 8, 5, 2, 2, 7, 5, 9, 6, 5, 5, 8, 5 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 621 */   private static final byte[] _btree_single_lengths = init__btree_single_lengths_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_range_lengths_0() {
/* 626 */     return new byte[] { 0, 0, 2, 2, 2, 3, 0, 2, 3, 0, 1, 0, 0, 2, 2, 0, 3, 2, 3, 0, 1, 0, 0, 0, 0, 2, 3, 0, 2, 2, 0, 0, 0, 3, 0, 3, 2, 0, 0, 3, 0 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 634 */   private static final byte[] _btree_range_lengths = init__btree_range_lengths_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static short[] init__btree_index_offsets_0() {
/* 639 */     return new short[] { 0, 0, 2, 6, 15, 19, 29, 34, 43, 53, 58, 67, 69, 74, 78, 82, 87, 99, 107, 117, 122, 131, 136, 138, 143, 148, 152, 163, 168, 172, 183, 189, 192, 195, 206, 212, 225, 234, 240, 246, 258 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 647 */   private static final short[] _btree_index_offsets = init__btree_index_offsets_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_indicies_0() {
/* 652 */     return new byte[] { 0, 1, 2, 2, 2, 1, 3, 3, 3, 4, 5, 6, 6, 6, 1, 7, 7, 7, 1, 8, 8, 8, 9, 11, 10, 10, 10, 10, 1, 12, 12, 12, 5, 1, 13, 13, 13, 14, 15, 16, 16, 16, 1, 17, 17, 17, 19, 20, 18, 18, 18, 18, 1, 21, 21, 21, 22, 1, 22, 1, 22, 22, 24, 1, 1, 1, 23, 25, 1, 17, 17, 17, 19, 1, 26, 26, 26, 1, 27, 27, 27, 1, 8, 8, 8, 9, 1, 28, 28, 28, 29, 30, 31, 33, 32, 32, 32, 32, 1, 34, 34, 34, 5, 35, 35, 35, 1, 36, 36, 36, 38, 39, 37, 37, 37, 37, 1, 40, 40, 40, 41, 1, 41, 1, 41, 41, 43, 1, 1, 1, 42, 44, 44, 44, 45, 1, 46, 1, 34, 34, 34, 5, 1, 36, 36, 36, 38, 1, 47, 47, 47, 1, 28, 28, 28, 29, 30, 33, 47, 47, 47, 47, 1, 28, 28, 28, 30, 1, 32, 32, 32, 1, 48, 49, 50, 48, 51, 14, 15, 16, 16, 16, 1, 50, 49, 50, 50, 51, 1, 53, 54, 52, 56, 57, 55, 58, 59, 58, 58, 60, 62, 61, 61, 61, 61, 1, 58, 59, 58, 58, 60, 1, 63, 64, 63, 63, 65, 66, 67, 68, 27, 27, 27, 27, 1, 69, 49, 69, 69, 51, 70, 70, 70, 1, 71, 72, 71, 71, 73, 1, 69, 49, 69, 69, 51, 1, 63, 64, 63, 63, 65, 66, 68, 26, 26, 26, 26, 1, 63, 64, 63, 63, 65, 1, 0 };
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
/* 679 */   private static final byte[] _btree_indicies = init__btree_indicies_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_trans_targs_0() {
/* 684 */     return new byte[] { 29, 0, 33, 3, 4, 7, 16, 5, 6, 7, 5, 15, 6, 7, 2, 3, 35, 9, 8, 10, 12, 9, 10, 37, 11, 38, 39, 35, 17, 25, 7, 28, 16, 27, 17, 18, 19, 18, 20, 24, 19, 20, 21, 22, 17, 7, 23, 26, 29, 29, 30, 31, 32, 29, 1, 32, 29, 1, 30, 29, 31, 33, 34, 36, 29, 31, 13, 14, 40, 36, 8, 36, 29, 31 };
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
/* 695 */   private static final byte[] _btree_trans_targs = init__btree_trans_targs_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_trans_actions_0() {
/* 700 */     return new byte[] { 7, 0, 13, 0, 0, 19, 13, 13, 36, 63, 0, 0, 0, 0, 0, 17, 13, 15, 0, 15, 0, 0, 0, 3, 5, 1, 0, 0, 33, 0, 55, 0, 0, 0, 0, 13, 15, 0, 15, 0, 0, 0, 3, 5, 1, 24, 1, 0, 9, 27, 0, 0, 13, 67, 43, 0, 47, 30, 36, 77, 36, 0, 0, 33, 72, 33, 0, 0, 0, 0, 13, 1, 39, 1 };
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
/* 711 */   private static final byte[] _btree_trans_actions = init__btree_trans_actions_0();
/*     */ 
/*     */ 
/*     */   
/*     */   private static byte[] init__btree_eof_actions_0() {
/* 716 */     return new byte[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 11, 11, 43, 30, 59, 59, 51, 11, 21, 11, 51, 51 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 724 */   private static final byte[] _btree_eof_actions = init__btree_eof_actions_0();
/*     */   
/*     */   static final int btree_start = 29;
/*     */   
/*     */   static final int btree_first_final = 29;
/*     */   
/*     */   static final int btree_error = 0;
/*     */   
/*     */   static final int btree_en_main = 29;
/*     */   
/*     */   private static boolean containsFloatingPointCharacters(String paramString) {
/*     */     byte b;
/*     */     int i;
/* 737 */     for (b = 0, i = paramString.length(); b < i; b++) {
/* 738 */       switch (paramString.charAt(b)) {
/*     */         case '.':
/*     */         case 'E':
/*     */         case 'e':
/* 742 */           return true;
/*     */       } 
/*     */     } 
/* 745 */     return false;
/*     */   }
/*     */   
/*     */   private static String unescape(String paramString) {
/* 749 */     int i = paramString.length();
/* 750 */     StringBuilder stringBuilder = new StringBuilder(i + 16);
/* 751 */     for (byte b = 0; b < i; ) {
/*     */       char c;
/* 753 */       if ((c = paramString.charAt(b++)) != '\\') {
/* 754 */         stringBuilder.append(c);
/*     */         continue;
/*     */       } 
/* 757 */       if (b != i) {
/*     */         
/* 759 */         if ((c = paramString.charAt(b++)) == 'u') {
/* 760 */           stringBuilder.append(Character.toChars(Integer.parseInt(paramString.substring(b, b + 4), 16)));
/* 761 */           b += 4;
/*     */           continue;
/*     */         } 
/* 764 */         switch (c) {
/*     */           case '"':
/*     */           case '/':
/*     */           case '\\':
/*     */             break;
/*     */           case 'b':
/* 770 */             c = '\b';
/*     */             break;
/*     */           case 'f':
/* 773 */             c = '\f';
/*     */             break;
/*     */           case 'n':
/* 776 */             c = '\n';
/*     */             break;
/*     */           case 'r':
/* 779 */             c = '\r';
/*     */             break;
/*     */           case 't':
/* 782 */             c = '\t';
/*     */             break;
/*     */           default:
/* 785 */             throw new SerializationException("Illegal escaped character: \\" + c);
/*     */         } 
/* 787 */         stringBuilder.append(c);
/*     */       } 
/* 789 */     }  return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gdx\ai\btre\\utils\BehaviorTreeReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */