/*     */ package com.badlogic.gdx.utils;
/*     */ 
/*     */ import com.badlogic.gdx.files.FileHandle;
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
/*     */ public class XmlReader
/*     */ {
/*  38 */   private final Array<Element> elements = new Array<>(8); private Element root;
/*     */   private Element current;
/*  40 */   private final StringBuilder textBuffer = new StringBuilder(64);
/*     */   private String entitiesText;
/*     */   
/*     */   public Element parse(String paramString) {
/*  44 */     char[] arrayOfChar = paramString.toCharArray();
/*  45 */     return parse(arrayOfChar, 0, arrayOfChar.length);
/*     */   }
/*     */   
/*     */   public Element parse(Reader paramReader) {
/*     */     try {
/*  50 */       char[] arrayOfChar = new char[1024];
/*  51 */       int i = 0;
/*     */       
/*     */       int j;
/*  54 */       while ((j = paramReader.read(arrayOfChar, i, arrayOfChar.length - i)) != -1) {
/*  55 */         char[] arrayOfChar1; if (j == 0) {
/*  56 */           arrayOfChar1 = new char[arrayOfChar.length << 1];
/*  57 */           System.arraycopy(arrayOfChar, 0, arrayOfChar1, 0, arrayOfChar.length);
/*  58 */           arrayOfChar = arrayOfChar1; continue;
/*     */         } 
/*  60 */         i += arrayOfChar1;
/*     */       } 
/*  62 */       return parse(arrayOfChar, 0, i);
/*  63 */     } catch (IOException iOException) {
/*  64 */       throw new SerializationException(iOException);
/*     */     } finally {
/*  66 */       StreamUtils.closeQuietly(paramReader);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Element parse(InputStream paramInputStream) {
/*     */     try {
/*  72 */       return parse(new InputStreamReader(paramInputStream, "UTF-8"));
/*  73 */     } catch (IOException iOException) {
/*  74 */       throw new SerializationException(iOException);
/*     */     } finally {
/*  76 */       StreamUtils.closeQuietly(paramInputStream);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Element parse(FileHandle paramFileHandle) {
/*     */     try {
/*  82 */       return parse(paramFileHandle.reader("UTF-8"));
/*  83 */     } catch (Exception exception) {
/*  84 */       throw new SerializationException("Error parsing file: " + paramFileHandle, exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Element parse(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  89 */     int i = paramInt1;
/*     */     
/*  91 */     int j = 0;
/*  92 */     String str = null;
/*  93 */     boolean bool = false;
/*     */ 
/*     */ 
/*     */     
/*  97 */     paramInt1 = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     byte b = 0;
/*     */     label152: while (true) {
/*     */       int k;
/*     */       int m;
/* 111 */       switch (b) {
/*     */         case false:
/* 113 */           if (i == paramInt2) {
/* 114 */             b = 4;
/*     */             continue;
/*     */           } 
/* 117 */           if (paramInt1 == 0) {
/* 118 */             b = 5;
/*     */             continue;
/*     */           } 
/*     */ 
/*     */         
/*     */         case true:
/* 124 */           m = _xml_key_offsets[paramInt1];
/* 125 */           k = _xml_index_offsets[paramInt1];
/*     */           
/* 127 */           if ((b = _xml_single_lengths[paramInt1]) > 0) {
/* 128 */             String str1; int n = m;
/*     */             
/* 130 */             int i1 = m + b - 1;
/*     */             while (true) {
/* 132 */               if (i1 >= n)
/*     */               
/* 134 */               { int i2 = n + (i1 - n >> 1);
/* 135 */                 if (paramArrayOfchar[i] < _xml_trans_keys[i2]) {
/* 136 */                   i1 = i2 - 1; continue;
/* 137 */                 }  if (paramArrayOfchar[i] > _xml_trans_keys[i2]) {
/* 138 */                   n = i2 + 1; continue;
/*     */                 } 
/* 140 */                 k = k + i2 - m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 170 */                 k = _xml_indicies[k];
/* 171 */                 paramInt1 = _xml_trans_targs[k];
/*     */                 
/* 173 */                 if (_xml_trans_actions[k] != 0)
/* 174 */                 { b = _xml_trans_actions[k];
/* 175 */                   k = _xml_actions[b++]; while (true)
/* 176 */                   { if (k-- > 0)
/* 177 */                     { int i3; switch (_xml_actions[b++])
/*     */                       
/*     */                       { 
/*     */                         case 0:
/* 181 */                           j = i;
/*     */                           continue;
/*     */ 
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 1:
/* 188 */                           if ((n = paramArrayOfchar[j]) == 63 || n == 33) {
/* 189 */                             if (paramArrayOfchar[j + 1] == '[' && paramArrayOfchar[j + 2] == 'C' && paramArrayOfchar[j + 3] == 'D' && paramArrayOfchar[j + 4] == 'A' && paramArrayOfchar[j + 5] == 'T' && paramArrayOfchar[j + 6] == 'A' && paramArrayOfchar[j + 7] == '[') {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                               
/* 196 */                               j += 8;
/* 197 */                               i = j + 2;
/* 198 */                               while (paramArrayOfchar[i - 2] != ']' || paramArrayOfchar[i - 1] != ']' || paramArrayOfchar[i] != '>')
/* 199 */                                 i++; 
/* 200 */                               text(new String(paramArrayOfchar, j, i - j - 2));
/* 201 */                             } else if (n == 33 && paramArrayOfchar[j + 1] == '-' && paramArrayOfchar[j + 2] == '-') {
/* 202 */                               i = j + 3;
/* 203 */                               while (paramArrayOfchar[i] != '-' || paramArrayOfchar[i + 1] != '-' || paramArrayOfchar[i + 2] != '>')
/* 204 */                                 i++; 
/* 205 */                               i += 2;
/*     */                             } else {
/* 207 */                               while (paramArrayOfchar[i] != '>')
/* 208 */                                 i++; 
/*     */                             } 
/* 210 */                             paramInt1 = 15;
/* 211 */                             b = 2;
/*     */                             
/*     */                             continue label152;
/*     */                           } 
/* 215 */                           bool = true;
/* 216 */                           open(new String(paramArrayOfchar, j, i - j));
/*     */                           continue;
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 2:
/* 222 */                           bool = false;
/* 223 */                           close();
/*     */                           
/* 225 */                           paramInt1 = 15;
/* 226 */                           b = 2;
/*     */                           continue label152;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 3:
/* 234 */                           close();
/*     */                           
/* 236 */                           paramInt1 = 15;
/* 237 */                           b = 2;
/*     */                           continue label152;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 4:
/* 245 */                           if (bool) {
/* 246 */                             paramInt1 = 15;
/* 247 */                             b = 2;
/*     */                             continue label152;
/*     */                           } 
/*     */                           continue;
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 5:
/* 255 */                           str = new String(paramArrayOfchar, j, i - j);
/*     */                           continue;
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 6:
/* 261 */                           n = i;
/* 262 */                           while (n != j) {
/* 263 */                             switch (paramArrayOfchar[n - 1]) {
/*     */                               case '\t':
/*     */                               case '\n':
/*     */                               case '\r':
/*     */                               case ' ':
/* 268 */                                 n--;
/*     */                             } 
/*     */ 
/*     */                           
/*     */                           } 
/* 273 */                           i2 = j;
/* 274 */                           i1 = 0;
/* 275 */                           while (i2 != n) {
/* 276 */                             if (paramArrayOfchar[i2++] == '&') {
/* 277 */                               int i4 = i2;
/* 278 */                               while (i2 != n) {
/* 279 */                                 if (paramArrayOfchar[i2++] == ';') {
/* 280 */                                   this.textBuffer.append(paramArrayOfchar, j, i4 - j - 1);
/* 281 */                                   String str2 = new String(paramArrayOfchar, i4, i2 - i4 - 1);
/* 282 */                                   str1 = entity(str2);
/* 283 */                                   if (str1 != null); this.textBuffer.append(str2);
/* 284 */                                   i3 = i2;
/* 285 */                                   i1 = 1;
/*     */                                 } 
/*     */                               } 
/*     */                             } 
/* 289 */                           }  if (i1 != 0) {
/* 290 */                             if (i3 < n) this.textBuffer.append(paramArrayOfchar, i3, n - i3); 
/* 291 */                             this.entitiesText = this.textBuffer.toString();
/* 292 */                             this.textBuffer.setLength(0); continue;
/*     */                           } 
/* 294 */                           this.entitiesText = new String(paramArrayOfchar, i3, n - i3);
/*     */                           continue;
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 7:
/* 300 */                           attribute(str, this.entitiesText);
/*     */                           continue;
/*     */ 
/*     */ 
/*     */                         
/*     */                         case 8:
/* 306 */                           text(this.entitiesText); continue; }  continue; }  continue label152; }  } else { continue; }  } else { break; } 
/*     */             }  m = str1 + b; k += b;
/*     */           }  if ((b = _xml_range_lengths[paramInt1]) > 0) { int n = m; int i1 = m + (b << 1) - 2; while (true) { if (i1 >= n) { int i2 = n + (i1 - n >> 1 & 0xFFFFFFFE); if (paramArrayOfchar[i] < _xml_trans_keys[i2]) { i1 = i2 - 2; continue; }
/*     */                  if (paramArrayOfchar[i] > _xml_trans_keys[i2 + 1]) { n = i2 + 2; continue; }
/*     */                  k += i2 - m >> 1; break; }
/*     */                k += b; break; }
/*     */              continue; }
/*     */            continue;
/*     */         case true:
/* 315 */           if (paramInt1 == 0) {
/* 316 */             b = 5;
/*     */             continue;
/*     */           } 
/* 319 */           if (++i != paramInt2) {
/* 320 */             b = 1;
/*     */             continue;
/*     */           } 
/*     */           break;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       break;
/*     */     } 
/* 332 */     this.entitiesText = null;
/*     */     
/* 334 */     if (i < paramInt2) {
/* 335 */       b = 1;
/* 336 */       for (byte b1 = 0; b1 < i; b1++) {
/* 337 */         if (paramArrayOfchar[b1] == '\n') b++; 
/* 338 */       }  throw new SerializationException("Error parsing XML on line " + b + " near: " + new String(paramArrayOfchar, i, 
/* 339 */             Math.min(32, paramInt2 - i)));
/* 340 */     }  if (this.elements.size != 0) {
/* 341 */       Element element1 = this.elements.peek();
/* 342 */       this.elements.clear();
/* 343 */       throw new SerializationException("Error parsing XML, unclosed element: " + element1.getName());
/*     */     } 
/* 345 */     Element element = this.root;
/* 346 */     this.root = null;
/* 347 */     return element;
/*     */   }
/*     */ 
/*     */   
/*     */   private static byte[] init__xml_actions_0() {
/* 352 */     return new byte[] { 0, 1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 2, 1, 4, 2, 2, 4, 2, 6, 7, 2, 6, 8, 3, 0, 6, 7 };
/*     */   }
/*     */   
/* 355 */   private static final byte[] _xml_actions = init__xml_actions_0();
/*     */   
/*     */   private static byte[] init__xml_key_offsets_0() {
/* 358 */     return new byte[] { 0, 0, 4, 9, 14, 20, 26, 30, 35, 36, 37, 42, 46, 50, 51, 52, 56, 57, 62, 67, 73, 79, 83, 88, 89, 90, 95, 99, 103, 104, 108, 109, 110, 111, 112, 115 };
/*     */   }
/*     */ 
/*     */   
/* 362 */   private static final byte[] _xml_key_offsets = init__xml_key_offsets_0();
/*     */   
/*     */   private static char[] init__xml_trans_keys_0() {
/* 365 */     return new char[] { ' ', '<', '\t', '\r', ' ', '/', '>', '\t', '\r', ' ', '/', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '=', '\t', '\r', ' ', '"', '\'', '\t', '\r', '"', '"', ' ', '/', '>', '\t', '\r', ' ', '>', '\t', '\r', ' ', '>', '\t', '\r', '\'', '\'', ' ', '<', '\t', '\r', '<', ' ', '/', '>', '\t', '\r', ' ', '/', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '/', '=', '>', '\t', '\r', ' ', '=', '\t', '\r', ' ', '"', '\'', '\t', '\r', '"', '"', ' ', '/', '>', '\t', '\r', ' ', '>', '\t', '\r', ' ', '>', '\t', '\r', '<', ' ', '/', '\t', '\r', '>', '>', '\'', '\'', ' ', '\t', '\r', Character.MIN_VALUE };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 371 */   private static final char[] _xml_trans_keys = init__xml_trans_keys_0();
/*     */   
/*     */   private static byte[] init__xml_single_lengths_0() {
/* 374 */     return new byte[] { 0, 2, 3, 3, 4, 4, 2, 3, 1, 1, 3, 2, 2, 1, 1, 2, 1, 3, 3, 4, 4, 2, 3, 1, 1, 3, 2, 2, 1, 2, 1, 1, 1, 1, 1, 0 };
/*     */   }
/*     */ 
/*     */   
/* 378 */   private static final byte[] _xml_single_lengths = init__xml_single_lengths_0();
/*     */   
/*     */   private static byte[] init__xml_range_lengths_0() {
/* 381 */     return new byte[] { 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0 };
/*     */   }
/*     */ 
/*     */   
/* 385 */   private static final byte[] _xml_range_lengths = init__xml_range_lengths_0();
/*     */   
/*     */   private static short[] init__xml_index_offsets_0() {
/* 388 */     return new short[] { 0, 0, 4, 9, 14, 20, 26, 30, 35, 37, 39, 44, 48, 52, 54, 56, 60, 62, 67, 72, 78, 84, 88, 93, 95, 97, 102, 106, 110, 112, 116, 118, 120, 122, 124, 127 };
/*     */   }
/*     */ 
/*     */   
/* 392 */   private static final short[] _xml_index_offsets = init__xml_index_offsets_0();
/*     */   
/*     */   private static byte[] init__xml_indicies_0() {
/* 395 */     return new byte[] { 0, 2, 0, 1, 2, 1, 1, 2, 3, 5, 6, 7, 5, 4, 9, 10, 1, 11, 9, 8, 13, 1, 14, 1, 13, 12, 15, 16, 15, 1, 16, 17, 18, 16, 1, 20, 19, 22, 21, 9, 10, 11, 9, 1, 23, 24, 23, 1, 25, 11, 25, 1, 20, 26, 22, 27, 29, 30, 29, 28, 32, 31, 30, 34, 1, 30, 33, 36, 37, 38, 36, 35, 40, 41, 1, 42, 40, 39, 44, 1, 45, 1, 44, 43, 46, 47, 46, 1, 47, 48, 49, 47, 1, 51, 50, 53, 52, 40, 41, 42, 40, 1, 54, 55, 54, 1, 56, 42, 56, 1, 57, 1, 57, 34, 57, 1, 1, 58, 59, 58, 51, 60, 53, 61, 62, 62, 1, 1, 0 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 402 */   private static final byte[] _xml_indicies = init__xml_indicies_0();
/*     */   
/*     */   private static byte[] init__xml_trans_targs_0() {
/* 405 */     return new byte[] { 1, 0, 2, 3, 3, 4, 11, 34, 5, 4, 11, 34, 5, 6, 7, 6, 7, 8, 13, 9, 10, 9, 10, 12, 34, 12, 14, 14, 16, 15, 17, 16, 17, 18, 30, 18, 19, 26, 28, 20, 19, 26, 28, 20, 21, 22, 21, 22, 23, 32, 24, 25, 24, 25, 27, 28, 27, 29, 31, 35, 33, 33, 34 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 410 */   private static final byte[] _xml_trans_targs = init__xml_trans_targs_0();
/*     */   
/*     */   private static byte[] init__xml_trans_actions_0() {
/* 413 */     return new byte[] { 0, 0, 0, 1, 0, 3, 3, 13, 1, 0, 0, 9, 0, 11, 11, 0, 0, 0, 0, 1, 25, 0, 19, 5, 16, 0, 1, 0, 1, 0, 0, 0, 22, 1, 0, 0, 3, 3, 13, 1, 0, 0, 9, 0, 11, 11, 0, 0, 0, 0, 1, 25, 0, 19, 5, 16, 0, 0, 0, 7, 1, 0, 0 };
/*     */   }
/*     */ 
/*     */   
/* 417 */   private static final byte[] _xml_trans_actions = init__xml_trans_actions_0();
/*     */   
/*     */   static final int xml_start = 1;
/*     */   
/*     */   static final int xml_first_final = 34;
/*     */   
/*     */   static final int xml_error = 0;
/*     */   
/*     */   static final int xml_en_elementBody = 15;
/*     */   static final int xml_en_main = 1;
/*     */   
/*     */   protected void open(String paramString) {
/* 429 */     Element element1 = new Element(paramString, this.current);
/*     */     Element element2;
/* 431 */     if ((element2 = this.current) != null) element2.addChild(element1); 
/* 432 */     this.elements.add(element1);
/* 433 */     this.current = element1;
/*     */   }
/*     */   
/*     */   protected void attribute(String paramString1, String paramString2) {
/* 437 */     this.current.setAttribute(paramString1, paramString2);
/*     */   }
/*     */   @Null
/*     */   protected String entity(String paramString) {
/* 441 */     if (paramString.equals("lt")) return "<"; 
/* 442 */     if (paramString.equals("gt")) return ">"; 
/* 443 */     if (paramString.equals("amp")) return "&"; 
/* 444 */     if (paramString.equals("apos")) return "'"; 
/* 445 */     if (paramString.equals("quot")) return "\""; 
/* 446 */     if (paramString.startsWith("#x")) return Character.toString((char)Integer.parseInt(paramString.substring(2), 16)); 
/* 447 */     return null;
/*     */   }
/*     */   
/*     */   protected void text(String paramString) {
/* 451 */     String str = this.current.getText();
/* 452 */     this.current.setText((str != null) ? (str + paramString) : paramString);
/*     */   }
/*     */   
/*     */   protected void close() {
/* 456 */     this.root = this.elements.pop();
/* 457 */     this.current = (this.elements.size > 0) ? this.elements.peek() : null;
/*     */   }
/*     */   
/*     */   public static class Element {
/*     */     private final String name;
/*     */     private ObjectMap<String, String> attributes;
/*     */     private Array<Element> children;
/*     */     private String text;
/*     */     private Element parent;
/*     */     
/*     */     public Element(String param1String, Element param1Element) {
/* 468 */       this.name = param1String;
/* 469 */       this.parent = param1Element;
/*     */     }
/*     */     
/*     */     public String getName() {
/* 473 */       return this.name;
/*     */     }
/*     */     
/*     */     public ObjectMap<String, String> getAttributes() {
/* 477 */       return this.attributes;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getAttribute(String param1String) {
/* 482 */       if (this.attributes == null) throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute: " + param1String); 
/*     */       String str;
/* 484 */       if ((str = this.attributes.<String>get(param1String)) == null) throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute: " + param1String); 
/* 485 */       return str;
/*     */     }
/*     */     
/*     */     public String getAttribute(String param1String1, String param1String2) {
/* 489 */       if (this.attributes == null) return param1String2;
/*     */       
/* 491 */       if ((param1String1 = this.attributes.<String>get(param1String1)) == null) return param1String2; 
/* 492 */       return param1String1;
/*     */     }
/*     */     
/*     */     public boolean hasAttribute(String param1String) {
/* 496 */       if (this.attributes == null) return false; 
/* 497 */       return this.attributes.containsKey(param1String);
/*     */     }
/*     */     
/*     */     public void setAttribute(String param1String1, String param1String2) {
/* 501 */       if (this.attributes == null) this.attributes = new ObjectMap<>(8); 
/* 502 */       this.attributes.put(param1String1, param1String2);
/*     */     }
/*     */     
/*     */     public int getChildCount() {
/* 506 */       if (this.children == null) return 0; 
/* 507 */       return this.children.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public Element getChild(int param1Int) {
/* 512 */       if (this.children == null) throw new GdxRuntimeException("Element has no children: " + this.name); 
/* 513 */       return this.children.get(param1Int);
/*     */     }
/*     */     
/*     */     public void addChild(Element param1Element) {
/* 517 */       if (this.children == null) this.children = new Array<>(8); 
/* 518 */       this.children.add(param1Element);
/*     */     }
/*     */     
/*     */     public String getText() {
/* 522 */       return this.text;
/*     */     }
/*     */     
/*     */     public void setText(String param1String) {
/* 526 */       this.text = param1String;
/*     */     }
/*     */     
/*     */     public void removeChild(int param1Int) {
/* 530 */       if (this.children != null) this.children.removeIndex(param1Int); 
/*     */     }
/*     */     
/*     */     public void removeChild(Element param1Element) {
/* 534 */       if (this.children != null) this.children.removeValue(param1Element, true); 
/*     */     }
/*     */     
/*     */     public void remove() {
/* 538 */       this.parent.removeChild(this);
/*     */     }
/*     */     
/*     */     public Element getParent() {
/* 542 */       return this.parent;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 546 */       return toString("");
/*     */     }
/*     */     
/*     */     public String toString(String param1String) {
/*     */       StringBuilder stringBuilder;
/* 551 */       (stringBuilder = new StringBuilder(128)).append(param1String);
/* 552 */       stringBuilder.append('<');
/* 553 */       stringBuilder.append(this.name);
/* 554 */       if (this.attributes != null) {
/* 555 */         for (ObjectMap.Entries<ObjectMap.Entry> entries = this.attributes.entries().iterator(); entries.hasNext(); ) { ObjectMap.Entry entry = entries.next();
/* 556 */           stringBuilder.append(' ');
/* 557 */           stringBuilder.append((String)entry.key);
/* 558 */           stringBuilder.append("=\"");
/* 559 */           stringBuilder.append((String)entry.value);
/* 560 */           stringBuilder.append('"'); }
/*     */       
/*     */       }
/* 563 */       if (this.children == null && (this.text == null || this.text.length() == 0)) {
/* 564 */         stringBuilder.append("/>");
/*     */       } else {
/* 566 */         stringBuilder.append(">\n");
/* 567 */         String str = param1String + '\t';
/* 568 */         if (this.text != null && this.text.length() > 0) {
/* 569 */           stringBuilder.append(str);
/* 570 */           stringBuilder.append(this.text);
/* 571 */           stringBuilder.append('\n');
/*     */         } 
/* 573 */         if (this.children != null) {
/* 574 */           for (Array.ArrayIterator<Element> arrayIterator = this.children.iterator(); arrayIterator.hasNext(); ) { Element element = arrayIterator.next();
/* 575 */             stringBuilder.append(element.toString(str));
/* 576 */             stringBuilder.append('\n'); }
/*     */         
/*     */         }
/* 579 */         stringBuilder.append(param1String);
/* 580 */         stringBuilder.append("</");
/* 581 */         stringBuilder.append(this.name);
/* 582 */         stringBuilder.append('>');
/*     */       } 
/* 584 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     @Null
/*     */     public Element getChildByName(String param1String) {
/* 590 */       if (this.children == null) return null; 
/* 591 */       for (byte b = 0; b < this.children.size; b++) {
/*     */         Element element;
/* 593 */         if ((element = this.children.get(b)).name.equals(param1String)) return element; 
/*     */       } 
/* 595 */       return null;
/*     */     }
/*     */     
/*     */     public boolean hasChild(String param1String) {
/* 599 */       if (this.children == null) return false; 
/* 600 */       return (getChildByName(param1String) != null);
/*     */     }
/*     */ 
/*     */     
/*     */     @Null
/*     */     public Element getChildByNameRecursive(String param1String) {
/* 606 */       if (this.children == null) return null; 
/* 607 */       for (byte b = 0; b < this.children.size; b++) {
/*     */         Element element;
/* 609 */         if ((element = this.children.get(b)).name.equals(param1String)) return element;
/*     */         
/* 611 */         if ((element = element.getChildByNameRecursive(param1String)) != null) return element; 
/*     */       } 
/* 613 */       return null;
/*     */     }
/*     */     
/*     */     public boolean hasChildRecursive(String param1String) {
/* 617 */       if (this.children == null) return false; 
/* 618 */       return (getChildByNameRecursive(param1String) != null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Array<Element> getChildrenByName(String param1String) {
/* 624 */       Array<Element> array = new Array();
/* 625 */       if (this.children == null) return array; 
/* 626 */       for (byte b = 0; b < this.children.size; b++) {
/*     */         Element element;
/* 628 */         if ((element = this.children.get(b)).name.equals(param1String)) array.add(element); 
/*     */       } 
/* 630 */       return array;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Array<Element> getChildrenByNameRecursively(String param1String) {
/* 636 */       Array<Element> array = new Array();
/* 637 */       getChildrenByNameRecursively(param1String, array);
/* 638 */       return array;
/*     */     }
/*     */     
/*     */     private void getChildrenByNameRecursively(String param1String, Array<Element> param1Array) {
/* 642 */       if (this.children == null)
/* 643 */         return;  for (byte b = 0; b < this.children.size; b++) {
/*     */         Element element;
/* 645 */         if ((element = this.children.get(b)).name.equals(param1String)) param1Array.add(element); 
/* 646 */         element.getChildrenByNameRecursively(param1String, param1Array);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public float getFloatAttribute(String param1String) {
/* 652 */       return Float.parseFloat(getAttribute(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public float getFloatAttribute(String param1String, float param1Float) {
/* 657 */       if ((param1String = getAttribute(param1String, null)) == null) return param1Float; 
/* 658 */       return Float.parseFloat(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getIntAttribute(String param1String) {
/* 663 */       return Integer.parseInt(getAttribute(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public int getIntAttribute(String param1String, int param1Int) {
/* 668 */       if ((param1String = getAttribute(param1String, null)) == null) return param1Int; 
/* 669 */       return Integer.parseInt(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getBooleanAttribute(String param1String) {
/* 674 */       return Boolean.parseBoolean(getAttribute(param1String));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean getBooleanAttribute(String param1String, boolean param1Boolean) {
/* 679 */       if ((param1String = getAttribute(param1String, null)) == null) return param1Boolean; 
/* 680 */       return Boolean.parseBoolean(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String get(String param1String) {
/*     */       String str;
/* 687 */       if ((str = get(param1String, null)) == null) throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + param1String); 
/* 688 */       return str;
/*     */     }
/*     */ 
/*     */     
/*     */     public String get(String param1String1, String param1String2) {
/*     */       String str;
/* 694 */       if (this.attributes != null && (
/*     */         
/* 696 */         str = this.attributes.<String>get(param1String1)) != null) return str;
/*     */       
/*     */       Element element;
/* 699 */       if ((element = getChildByName(param1String1)) == null) return param1String2;
/*     */       
/* 701 */       if ((param1String1 = element.getText()) == null) return param1String2; 
/* 702 */       return param1String1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInt(String param1String) {
/*     */       String str;
/* 709 */       if ((str = get(param1String, null)) == null) throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + param1String); 
/* 710 */       return Integer.parseInt(str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getInt(String param1String, int param1Int) {
/* 717 */       if ((param1String = get(param1String, null)) == null) return param1Int; 
/* 718 */       return Integer.parseInt(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public float getFloat(String param1String) {
/*     */       String str;
/* 725 */       if ((str = get(param1String, null)) == null) throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + param1String); 
/* 726 */       return Float.parseFloat(str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public float getFloat(String param1String, float param1Float) {
/* 733 */       if ((param1String = get(param1String, null)) == null) return param1Float; 
/* 734 */       return Float.parseFloat(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean getBoolean(String param1String) {
/*     */       String str;
/* 741 */       if ((str = get(param1String, null)) == null) throw new GdxRuntimeException("Element " + this.name + " doesn't have attribute or child: " + param1String); 
/* 742 */       return Boolean.parseBoolean(str);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean getBoolean(String param1String, boolean param1Boolean) {
/* 749 */       if ((param1String = get(param1String, null)) == null) return param1Boolean; 
/* 750 */       return Boolean.parseBoolean(param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\XmlReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */