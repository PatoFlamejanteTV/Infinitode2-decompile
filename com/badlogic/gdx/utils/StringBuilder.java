/*      */ package com.badlogic.gdx.utils;
/*      */ 
/*      */ import java.util.Arrays;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringBuilder
/*      */   implements Appendable, CharSequence
/*      */ {
/*      */   static final int INITIAL_CAPACITY = 16;
/*      */   public char[] chars;
/*      */   public int length;
/*   33 */   private static final char[] digits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
/*      */ 
/*      */   
/*      */   public static int numChars(int paramInt1, int paramInt2) {
/*   37 */     byte b = (paramInt1 < 0) ? 2 : 1;
/*   38 */     while ((paramInt1 /= paramInt2) != 0)
/*   39 */       b++; 
/*   40 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int numChars(long paramLong, int paramInt) {
/*   45 */     byte b = (paramLong < 0L) ? 2 : 1;
/*   46 */     while ((paramLong /= paramInt) != 0L)
/*   47 */       b++; 
/*   48 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final char[] getValue() {
/*   55 */     return this.chars;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder() {
/*   62 */     this.chars = new char[16];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder(int paramInt) {
/*   71 */     if (paramInt < 0) {
/*   72 */       throw new NegativeArraySizeException();
/*      */     }
/*   74 */     this.chars = new char[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder(CharSequence paramCharSequence) {
/*   83 */     this(paramCharSequence.toString());
/*      */   }
/*      */   
/*      */   public StringBuilder(StringBuilder paramStringBuilder) {
/*   87 */     this.length = paramStringBuilder.length;
/*   88 */     this.chars = new char[this.length + 16];
/*   89 */     System.arraycopy(paramStringBuilder.chars, 0, this.chars, 0, this.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder(String paramString) {
/*   98 */     this.length = paramString.length();
/*   99 */     this.chars = new char[this.length + 16];
/*  100 */     paramString.getChars(0, this.length, this.chars, 0);
/*      */   }
/*      */   
/*      */   private void enlargeBuffer(int paramInt) {
/*  104 */     int i = (this.chars.length >> 1) + this.chars.length + 2;
/*  105 */     char[] arrayOfChar = new char[(paramInt > i) ? paramInt : i];
/*  106 */     System.arraycopy(this.chars, 0, arrayOfChar, 0, this.length);
/*  107 */     this.chars = arrayOfChar;
/*      */   }
/*      */   
/*      */   final void appendNull() {
/*      */     int i;
/*  112 */     if ((i = this.length + 4) > this.chars.length) {
/*  113 */       enlargeBuffer(i);
/*      */     }
/*  115 */     this.chars[this.length++] = 'n';
/*  116 */     this.chars[this.length++] = 'u';
/*  117 */     this.chars[this.length++] = 'l';
/*  118 */     this.chars[this.length++] = 'l';
/*      */   }
/*      */   
/*      */   final void append0(char[] paramArrayOfchar) {
/*      */     int i;
/*  123 */     if ((i = this.length + paramArrayOfchar.length) > this.chars.length) {
/*  124 */       enlargeBuffer(i);
/*      */     }
/*  126 */     System.arraycopy(paramArrayOfchar, 0, this.chars, this.length, paramArrayOfchar.length);
/*  127 */     this.length = i;
/*      */   }
/*      */ 
/*      */   
/*      */   final void append0(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  132 */     if (paramInt1 > paramArrayOfchar.length || paramInt1 < 0) {
/*  133 */       throw new ArrayIndexOutOfBoundsException("Offset out of bounds: " + paramInt1);
/*      */     }
/*  135 */     if (paramInt2 < 0 || paramArrayOfchar.length - paramInt1 < paramInt2) {
/*  136 */       throw new ArrayIndexOutOfBoundsException("Length out of bounds: " + paramInt2);
/*      */     }
/*      */     
/*      */     int i;
/*  140 */     if ((i = this.length + paramInt2) > this.chars.length) {
/*  141 */       enlargeBuffer(i);
/*      */     }
/*  143 */     System.arraycopy(paramArrayOfchar, paramInt1, this.chars, this.length, paramInt2);
/*  144 */     this.length = i;
/*      */   }
/*      */   
/*      */   final void append0(char paramChar) {
/*  148 */     if (this.length == this.chars.length) {
/*  149 */       enlargeBuffer(this.length + 1);
/*      */     }
/*  151 */     this.chars[this.length++] = paramChar;
/*      */   }
/*      */   
/*      */   final void append0(String paramString) {
/*  155 */     if (paramString == null) {
/*  156 */       appendNull();
/*      */       return;
/*      */     } 
/*  159 */     int i = paramString.length();
/*      */     int j;
/*  161 */     if ((j = this.length + i) > this.chars.length) {
/*  162 */       enlargeBuffer(j);
/*      */     }
/*  164 */     paramString.getChars(0, i, this.chars, this.length);
/*  165 */     this.length = j;
/*      */   }
/*      */   
/*      */   final void append0(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/*  169 */     if (paramCharSequence == null) {
/*  170 */       paramCharSequence = "null";
/*      */     }
/*  172 */     if (paramInt1 < 0 || paramInt2 < 0 || paramInt1 > paramInt2 || paramInt2 > paramCharSequence.length()) {
/*  173 */       throw new IndexOutOfBoundsException();
/*      */     }
/*      */     
/*  176 */     append0(paramCharSequence.subSequence(paramInt1, paramInt2).toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int capacity() {
/*  185 */     return this.chars.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public char charAt(int paramInt) {
/*  194 */     if (paramInt < 0 || paramInt >= this.length) {
/*  195 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  197 */     return this.chars[paramInt];
/*      */   }
/*      */   
/*      */   final void delete0(int paramInt1, int paramInt2) {
/*  201 */     if (paramInt1 >= 0) {
/*  202 */       if (paramInt2 > this.length) {
/*  203 */         paramInt2 = this.length;
/*      */       }
/*  205 */       if (paramInt2 == paramInt1) {
/*      */         return;
/*      */       }
/*  208 */       if (paramInt2 > paramInt1) {
/*      */         int i;
/*  210 */         if ((i = this.length - paramInt2) >= 0) System.arraycopy(this.chars, paramInt2, this.chars, paramInt1, i); 
/*  211 */         this.length -= paramInt2 - paramInt1;
/*      */         return;
/*      */       } 
/*      */     } 
/*  215 */     throw new StringIndexOutOfBoundsException();
/*      */   }
/*      */   
/*      */   final void deleteCharAt0(int paramInt) {
/*  219 */     if (paramInt < 0 || paramInt >= this.length) {
/*  220 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*      */     int i;
/*  223 */     if ((i = this.length - paramInt - 1) > 0) {
/*  224 */       System.arraycopy(this.chars, paramInt + 1, this.chars, paramInt, i);
/*      */     }
/*  226 */     this.length--;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ensureCapacity(int paramInt) {
/*  236 */     if (paramInt > this.chars.length) {
/*  237 */       int i = (this.chars.length << 1) + 2;
/*  238 */       enlargeBuffer((i > paramInt) ? i : paramInt);
/*      */     } 
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
/*      */   public void getChars(int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3) {
/*  252 */     if (paramInt1 > this.length || paramInt2 > this.length || paramInt1 > paramInt2) {
/*  253 */       throw new StringIndexOutOfBoundsException();
/*      */     }
/*  255 */     System.arraycopy(this.chars, paramInt1, paramArrayOfchar, paramInt3, paramInt2 - paramInt1);
/*      */   }
/*      */   
/*      */   final void insert0(int paramInt, char[] paramArrayOfchar) {
/*  259 */     if (paramInt < 0 || paramInt > this.length) {
/*  260 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  262 */     if (paramArrayOfchar.length != 0) {
/*  263 */       move(paramArrayOfchar.length, paramInt);
/*  264 */       System.arraycopy(paramArrayOfchar, 0, paramArrayOfchar, paramInt, paramArrayOfchar.length);
/*  265 */       this.length += paramArrayOfchar.length;
/*      */     } 
/*      */   }
/*      */   
/*      */   final void insert0(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
/*  270 */     if (paramInt1 >= 0 && paramInt1 <= paramInt3) {
/*      */       
/*  272 */       if (paramInt2 >= 0 && paramInt3 >= 0 && paramInt3 <= paramArrayOfchar.length - paramInt2) {
/*  273 */         if (paramInt3 != 0) {
/*  274 */           move(paramInt3, paramInt1);
/*  275 */           System.arraycopy(paramArrayOfchar, paramInt2, this.chars, paramInt1, paramInt3);
/*  276 */           this.length += paramInt3;
/*      */         } 
/*      */         return;
/*      */       } 
/*  280 */       throw new StringIndexOutOfBoundsException("offset " + paramInt2 + ", length " + paramInt3 + ", char[].length " + paramArrayOfchar.length);
/*      */     } 
/*  282 */     throw new StringIndexOutOfBoundsException(paramInt1);
/*      */   }
/*      */   
/*      */   final void insert0(int paramInt, char paramChar) {
/*  286 */     if (paramInt < 0 || paramInt > this.length)
/*      */     {
/*  288 */       throw new ArrayIndexOutOfBoundsException(paramInt);
/*      */     }
/*  290 */     move(1, paramInt);
/*  291 */     this.chars[paramInt] = paramChar;
/*  292 */     this.length++;
/*      */   }
/*      */   
/*      */   final void insert0(int paramInt, String paramString) {
/*  296 */     if (paramInt >= 0 && paramInt <= this.length) {
/*  297 */       if (paramString == null) {
/*  298 */         paramString = "null";
/*      */       }
/*      */       int i;
/*  301 */       if ((i = paramString.length()) != 0) {
/*  302 */         move(i, paramInt);
/*  303 */         paramString.getChars(0, i, this.chars, paramInt);
/*  304 */         this.length += i;
/*      */       }  return;
/*      */     } 
/*  307 */     throw new StringIndexOutOfBoundsException(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   final void insert0(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3) {
/*  312 */     if (paramCharSequence == null) {
/*  313 */       paramCharSequence = "null";
/*      */     }
/*  315 */     if (paramInt1 < 0 || paramInt1 > this.length || paramInt2 < 0 || paramInt3 < 0 || paramInt2 > paramInt3 || paramInt3 > paramCharSequence.length()) {
/*  316 */       throw new IndexOutOfBoundsException();
/*      */     }
/*  318 */     insert0(paramInt1, paramCharSequence.subSequence(paramInt2, paramInt3).toString());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int length() {
/*  325 */     return this.length;
/*      */   }
/*      */   
/*      */   private void move(int paramInt1, int paramInt2) {
/*  329 */     if (this.chars.length - this.length >= paramInt1) {
/*  330 */       System.arraycopy(this.chars, paramInt2, this.chars, paramInt2 + paramInt1, this.length - paramInt2);
/*      */       return;
/*      */     } 
/*  333 */     int i = this.length + paramInt1, j = (this.chars.length << 1) + 2;
/*      */     
/*  335 */     char[] arrayOfChar = new char[i = (i > j) ? i : j];
/*  336 */     System.arraycopy(this.chars, 0, arrayOfChar, 0, paramInt2);
/*      */     
/*  338 */     System.arraycopy(this.chars, paramInt2, arrayOfChar, paramInt2 + paramInt1, this.length - paramInt2);
/*  339 */     this.chars = arrayOfChar;
/*      */   }
/*      */   
/*      */   final void replace0(int paramInt1, int paramInt2, String paramString) {
/*  343 */     if (paramInt1 >= 0) {
/*  344 */       if (paramInt2 > this.length) {
/*  345 */         paramInt2 = this.length;
/*      */       }
/*  347 */       if (paramInt2 > paramInt1) {
/*  348 */         int i = paramString.length();
/*      */         int j;
/*  350 */         if ((j = paramInt2 - paramInt1 - i) > 0) {
/*      */           
/*  352 */           System.arraycopy(this.chars, paramInt2, this.chars, paramInt1 + i, this.length - paramInt2);
/*  353 */         } else if (j < 0) {
/*      */           
/*  355 */           move(-j, paramInt2);
/*      */         } 
/*  357 */         paramString.getChars(0, i, this.chars, paramInt1);
/*  358 */         this.length -= j;
/*      */         return;
/*      */       } 
/*  361 */       if (paramInt1 == paramInt2) {
/*  362 */         if (paramString == null) {
/*  363 */           throw new NullPointerException();
/*      */         }
/*  365 */         insert0(paramInt1, paramString);
/*      */         return;
/*      */       } 
/*      */     } 
/*  369 */     throw new StringIndexOutOfBoundsException();
/*      */   }
/*      */   
/*      */   final void reverse0() {
/*  373 */     if (this.length < 2) {
/*      */       return;
/*      */     }
/*  376 */     int i = this.length - 1;
/*  377 */     char c1 = this.chars[0];
/*  378 */     char c2 = this.chars[i];
/*  379 */     boolean bool1 = true, bool2 = true; byte b; int j;
/*  380 */     for (b = 0, j = this.length / 2; b < j; b++, i--) {
/*  381 */       char c3 = this.chars[b + 1];
/*  382 */       char c4 = this.chars[i - 1];
/*      */       
/*      */       boolean bool3;
/*  385 */       if ((bool3 = (bool1 && c3 >= '?' && c3 <= '?' && c1 >= '?' && c1 <= '?') ? true : false) && this.length < 3) {
/*      */         return;
/*      */       }
/*  388 */       boolean bool4 = (bool2 && c4 >= '?' && c4 <= '?' && c2 >= '?' && c2 <= '?') ? true : false;
/*  389 */       bool1 = bool2 = true;
/*  390 */       if (bool3 == bool4) {
/*  391 */         if (bool3) {
/*      */           
/*  393 */           this.chars[i] = c3;
/*  394 */           this.chars[i - 1] = c1;
/*  395 */           this.chars[b] = c4;
/*  396 */           this.chars[b + 1] = c2;
/*  397 */           c1 = this.chars[b + 2];
/*  398 */           c2 = this.chars[i - 2];
/*  399 */           b++;
/*  400 */           i--;
/*      */         } else {
/*      */           
/*  403 */           this.chars[i] = c1;
/*  404 */           this.chars[b] = c2;
/*  405 */           c1 = c3;
/*  406 */           c2 = c4;
/*      */         }
/*      */       
/*  409 */       } else if (bool3) {
/*      */         
/*  411 */         this.chars[i] = c3;
/*  412 */         this.chars[b] = c2;
/*  413 */         c2 = c4;
/*  414 */         bool1 = false;
/*      */       } else {
/*      */         
/*  417 */         this.chars[i] = c1;
/*  418 */         this.chars[b] = c4;
/*  419 */         c1 = c3;
/*  420 */         bool2 = false;
/*      */       } 
/*      */     } 
/*      */     
/*  424 */     if ((this.length & 0x1) == 1 && (!bool1 || !bool2)) {
/*  425 */       this.chars[i] = bool1 ? c2 : c1;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setCharAt(int paramInt, char paramChar) {
/*  435 */     if (paramInt < 0 || paramInt >= this.length) {
/*  436 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  438 */     this.chars[paramInt] = paramChar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setLength(int paramInt) {
/*  448 */     if (paramInt < 0) {
/*  449 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  451 */     if (paramInt > this.chars.length) {
/*  452 */       enlargeBuffer(paramInt);
/*      */     }
/*  454 */     else if (this.length < paramInt) {
/*  455 */       Arrays.fill(this.chars, this.length, paramInt, false);
/*      */     } 
/*      */     
/*  458 */     this.length = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int paramInt) {
/*  467 */     if (paramInt >= 0 && paramInt <= this.length) {
/*  468 */       if (paramInt == this.length) {
/*  469 */         return "";
/*      */       }
/*      */ 
/*      */       
/*  473 */       return new String(this.chars, paramInt, this.length - paramInt);
/*      */     } 
/*  475 */     throw new StringIndexOutOfBoundsException(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String substring(int paramInt1, int paramInt2) {
/*  486 */     if (paramInt1 >= 0 && paramInt1 <= paramInt2 && paramInt2 <= this.length) {
/*  487 */       if (paramInt1 == paramInt2) {
/*  488 */         return "";
/*      */       }
/*      */ 
/*      */       
/*  492 */       return new String(this.chars, paramInt1, paramInt2 - paramInt1);
/*      */     } 
/*  494 */     throw new StringIndexOutOfBoundsException();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/*  501 */     if (this.length == 0) return ""; 
/*  502 */     return new String(this.chars, 0, this.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toStringAndClear() {
/*  509 */     String str = toString();
/*  510 */     clear();
/*  511 */     return str;
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
/*      */   public CharSequence subSequence(int paramInt1, int paramInt2) {
/*  523 */     return substring(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int indexOf(String paramString) {
/*  534 */     return indexOf(paramString, 0);
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
/*      */   public int indexOf(String paramString, int paramInt) {
/*  546 */     if (paramInt < 0) {
/*  547 */       paramInt = 0;
/*      */     }
/*      */     int i;
/*  550 */     if ((i = paramString.length()) == 0) return (paramInt < this.length || paramInt == 0) ? paramInt : this.length; 
/*  551 */     int j = this.length - i;
/*  552 */     if (paramInt > j) return -1; 
/*  553 */     char c = paramString.charAt(0);
/*      */     while (true) {
/*  555 */       paramInt = paramInt;
/*  556 */       int k = 0;
/*  557 */       for (; paramInt <= j; paramInt++) {
/*  558 */         if (this.chars[paramInt] == c) {
/*  559 */           k = 1;
/*      */           break;
/*      */         } 
/*      */       } 
/*  563 */       if (!k) return -1; 
/*  564 */       k = paramInt; byte b = 0; do {  }
/*  565 */       while (++b < i && this.chars[++k] == paramString.charAt(b));
/*      */ 
/*      */       
/*  568 */       if (b == i) return paramInt; 
/*  569 */       paramInt++;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int indexOfIgnoreCase(String paramString, int paramInt) {
/*  574 */     if (paramInt < 0) {
/*  575 */       paramInt = 0;
/*      */     }
/*      */     int i;
/*  578 */     if ((i = paramString.length()) == 0) return (paramInt < this.length || paramInt == 0) ? paramInt : this.length; 
/*  579 */     int j = this.length - i;
/*  580 */     if (paramInt > j) return -1;
/*      */     
/*  582 */     char c1, c2 = Character.toLowerCase(c1 = Character.toUpperCase(paramString.charAt(0)));
/*      */     while (true) {
/*  584 */       paramInt = paramInt;
/*  585 */       byte b = 0;
/*  586 */       for (; paramInt <= j; paramInt++) {
/*      */         char c;
/*  588 */         if ((c = this.chars[paramInt]) == c1 || c == c2) {
/*  589 */           b = 1;
/*      */           break;
/*      */         } 
/*      */       } 
/*  593 */       if (!b) return -1; 
/*  594 */       int k = paramInt; b = 0;
/*  595 */       while (++b < i) {
/*  596 */         char c3 = this.chars[++k];
/*  597 */         char c4 = Character.toUpperCase(paramString.charAt(b));
/*  598 */         if (c3 == c4 || c3 == Character.toLowerCase(c4));
/*      */       } 
/*  600 */       if (b == i) return paramInt; 
/*  601 */       paramInt++;
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean contains(String paramString) {
/*  606 */     return (indexOf(paramString, 0) != -1);
/*      */   }
/*      */   
/*      */   public boolean containsIgnoreCase(String paramString) {
/*  610 */     return (indexOfIgnoreCase(paramString, 0) != -1);
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
/*      */   public int lastIndexOf(String paramString) {
/*  622 */     return lastIndexOf(paramString, this.length);
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
/*      */   public int lastIndexOf(String paramString, int paramInt) {
/*      */     int i;
/*  636 */     if ((i = paramString.length()) <= this.length && paramInt >= 0) {
/*  637 */       if (i > 0) {
/*  638 */         if (paramInt > this.length - i) {
/*  639 */           paramInt = this.length - i;
/*      */         }
/*      */         
/*  642 */         char c = paramString.charAt(0);
/*      */         while (true) {
/*  644 */           paramInt = paramInt;
/*  645 */           int j = 0;
/*  646 */           for (; paramInt >= 0; paramInt--) {
/*  647 */             if (this.chars[paramInt] == c) {
/*  648 */               j = 1;
/*      */               break;
/*      */             } 
/*      */           } 
/*  652 */           if (!j) {
/*  653 */             return -1;
/*      */           }
/*  655 */           j = paramInt; byte b = 0; do {  }
/*  656 */           while (++b < i && this.chars[++j] == paramString.charAt(b));
/*      */ 
/*      */           
/*  659 */           if (b == i) {
/*  660 */             return paramInt;
/*      */           }
/*  662 */           paramInt--;
/*      */         } 
/*      */       } 
/*  665 */       return (paramInt < this.length) ? paramInt : this.length;
/*      */     } 
/*  667 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void trimToSize() {
/*  675 */     if (this.length < this.chars.length) {
/*  676 */       char[] arrayOfChar = new char[this.length];
/*  677 */       System.arraycopy(this.chars, 0, arrayOfChar, 0, this.length);
/*  678 */       this.chars = arrayOfChar;
/*      */     } 
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
/*      */   public int codePointAt(int paramInt) {
/*  691 */     if (paramInt < 0 || paramInt >= this.length) {
/*  692 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  694 */     return Character.codePointAt(this.chars, paramInt, this.length);
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
/*      */   public int codePointBefore(int paramInt) {
/*  706 */     if (paramInt <= 0 || paramInt > this.length) {
/*  707 */       throw new StringIndexOutOfBoundsException(paramInt);
/*      */     }
/*  709 */     return Character.codePointBefore(this.chars, paramInt);
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
/*      */   public int codePointCount(int paramInt1, int paramInt2) {
/*  723 */     if (paramInt1 < 0 || paramInt2 > this.length || paramInt1 > paramInt2) {
/*  724 */       throw new StringIndexOutOfBoundsException();
/*      */     }
/*  726 */     return Character.codePointCount(this.chars, paramInt1, paramInt2 - paramInt1);
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
/*      */   public int offsetByCodePoints(int paramInt1, int paramInt2) {
/*  740 */     return Character.offsetByCodePoints(this.chars, 0, this.length, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(boolean paramBoolean) {
/*  750 */     append0(paramBoolean ? "true" : "false");
/*  751 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(char paramChar) {
/*  761 */     append0(paramChar);
/*  762 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(int paramInt) {
/*  772 */     return append(paramInt, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(int paramInt1, int paramInt2) {
/*  783 */     return append(paramInt1, paramInt2, '0');
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
/*      */   public StringBuilder append(int paramInt1, int paramInt2, char paramChar) {
/*  795 */     if (paramInt1 == Integer.MIN_VALUE) {
/*  796 */       append0("-2147483648");
/*  797 */       return this;
/*      */     } 
/*  799 */     if (paramInt1 < 0) {
/*  800 */       append0('-');
/*  801 */       paramInt1 = -paramInt1;
/*      */     } 
/*  803 */     if (paramInt2 > 1)
/*  804 */       for (paramInt2 -= numChars(paramInt1, 10); paramInt2 > 0; paramInt2--) {
/*  805 */         append(paramChar);
/*      */       } 
/*  807 */     if (paramInt1 >= 10000) {
/*  808 */       if (paramInt1 >= 1000000000) append0(digits[(int)(paramInt1 % 10000000000L / 1000000000L)]); 
/*  809 */       if (paramInt1 >= 100000000) append0(digits[paramInt1 % 1000000000 / 100000000]); 
/*  810 */       if (paramInt1 >= 10000000) append0(digits[paramInt1 % 100000000 / 10000000]); 
/*  811 */       if (paramInt1 >= 1000000) append0(digits[paramInt1 % 10000000 / 1000000]); 
/*  812 */       if (paramInt1 >= 100000) append0(digits[paramInt1 % 1000000 / 100000]); 
/*  813 */       append0(digits[paramInt1 % 100000 / 10000]);
/*      */     } 
/*  815 */     if (paramInt1 >= 1000) append0(digits[paramInt1 % 10000 / 1000]); 
/*  816 */     if (paramInt1 >= 100) append0(digits[paramInt1 % 1000 / 100]); 
/*  817 */     if (paramInt1 >= 10) append0(digits[paramInt1 % 100 / 10]); 
/*  818 */     append0(digits[paramInt1 % 10]);
/*  819 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(long paramLong) {
/*  828 */     return append(paramLong, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(long paramLong, int paramInt) {
/*  838 */     return append(paramLong, paramInt, '0');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(long paramLong, int paramInt, char paramChar) {
/*  849 */     if (paramLong == Long.MIN_VALUE) {
/*  850 */       append0("-9223372036854775808");
/*  851 */       return this;
/*      */     } 
/*  853 */     if (paramLong < 0L) {
/*  854 */       append0('-');
/*  855 */       paramLong = -paramLong;
/*      */     } 
/*  857 */     if (paramInt > 1)
/*  858 */       for (paramInt -= numChars(paramLong, 10); paramInt > 0; paramInt--) {
/*  859 */         append(paramChar);
/*      */       } 
/*  861 */     if (paramLong >= 10000L) {
/*  862 */       if (paramLong >= 1000000000000000000L) append0(digits[(int)(paramLong % 1.0E19D / 1.0E18D)]); 
/*  863 */       if (paramLong >= 100000000000000000L) append0(digits[(int)(paramLong % 1000000000000000000L / 100000000000000000L)]); 
/*  864 */       if (paramLong >= 10000000000000000L) append0(digits[(int)(paramLong % 100000000000000000L / 10000000000000000L)]); 
/*  865 */       if (paramLong >= 1000000000000000L) append0(digits[(int)(paramLong % 10000000000000000L / 1000000000000000L)]); 
/*  866 */       if (paramLong >= 100000000000000L) append0(digits[(int)(paramLong % 1000000000000000L / 100000000000000L)]); 
/*  867 */       if (paramLong >= 10000000000000L) append0(digits[(int)(paramLong % 100000000000000L / 10000000000000L)]); 
/*  868 */       if (paramLong >= 1000000000000L) append0(digits[(int)(paramLong % 10000000000000L / 1000000000000L)]); 
/*  869 */       if (paramLong >= 100000000000L) append0(digits[(int)(paramLong % 1000000000000L / 100000000000L)]); 
/*  870 */       if (paramLong >= 10000000000L) append0(digits[(int)(paramLong % 100000000000L / 10000000000L)]); 
/*  871 */       if (paramLong >= 1000000000L) append0(digits[(int)(paramLong % 10000000000L / 1000000000L)]); 
/*  872 */       if (paramLong >= 100000000L) append0(digits[(int)(paramLong % 1000000000L / 100000000L)]); 
/*  873 */       if (paramLong >= 10000000L) append0(digits[(int)(paramLong % 100000000L / 10000000L)]); 
/*  874 */       if (paramLong >= 1000000L) append0(digits[(int)(paramLong % 10000000L / 1000000L)]); 
/*  875 */       if (paramLong >= 100000L) append0(digits[(int)(paramLong % 1000000L / 100000L)]); 
/*  876 */       append0(digits[(int)(paramLong % 100000L / 10000L)]);
/*      */     } 
/*  878 */     if (paramLong >= 1000L) append0(digits[(int)(paramLong % 10000L / 1000L)]); 
/*  879 */     if (paramLong >= 100L) append0(digits[(int)(paramLong % 1000L / 100L)]); 
/*  880 */     if (paramLong >= 10L) append0(digits[(int)(paramLong % 100L / 10L)]); 
/*  881 */     append0(digits[(int)(paramLong % 10L)]);
/*  882 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(float paramFloat) {
/*  891 */     append0(Float.toString(paramFloat));
/*  892 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(double paramDouble) {
/*  902 */     append0(Double.toString(paramDouble));
/*  903 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(Object paramObject) {
/*  913 */     if (paramObject == null) {
/*  914 */       appendNull();
/*      */     } else {
/*  916 */       append0(paramObject.toString());
/*      */     } 
/*  918 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(String paramString) {
/*  926 */     append0(paramString);
/*  927 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public StringBuilder append(String paramString1, String paramString2) {
/*  932 */     if (this.length > 0) append0(paramString2); 
/*  933 */     append0(paramString1);
/*  934 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder appendLine(String paramString) {
/*  943 */     append0(paramString);
/*  944 */     append0('\n');
/*  945 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(char[] paramArrayOfchar) {
/*  955 */     append0(paramArrayOfchar);
/*  956 */     return this;
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
/*      */   public StringBuilder append(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  969 */     append0(paramArrayOfchar, paramInt1, paramInt2);
/*  970 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder append(CharSequence paramCharSequence) {
/*  979 */     if (paramCharSequence == null) {
/*  980 */       appendNull();
/*  981 */     } else if (paramCharSequence instanceof StringBuilder) {
/*  982 */       paramCharSequence = paramCharSequence;
/*  983 */       append0(((StringBuilder)paramCharSequence).chars, 0, ((StringBuilder)paramCharSequence).length);
/*      */     } else {
/*  985 */       append0(paramCharSequence.toString());
/*      */     } 
/*  987 */     return this;
/*      */   }
/*      */   
/*      */   public StringBuilder append(StringBuilder paramStringBuilder) {
/*  991 */     if (paramStringBuilder == null) {
/*  992 */       appendNull();
/*      */     } else {
/*  994 */       append0(paramStringBuilder.chars, 0, paramStringBuilder.length);
/*  995 */     }  return this;
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
/*      */   public StringBuilder append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
/* 1008 */     append0(paramCharSequence, paramInt1, paramInt2);
/* 1009 */     return this;
/*      */   }
/*      */   
/*      */   public StringBuilder append(StringBuilder paramStringBuilder, int paramInt1, int paramInt2) {
/* 1013 */     if (paramStringBuilder == null) {
/* 1014 */       appendNull();
/*      */     } else {
/* 1016 */       append0(paramStringBuilder.chars, paramInt1, paramInt2);
/* 1017 */     }  return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder appendCodePoint(int paramInt) {
/* 1027 */     append0(Character.toChars(paramInt));
/* 1028 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder delete(int paramInt1, int paramInt2) {
/* 1039 */     delete0(paramInt1, paramInt2);
/* 1040 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder deleteCharAt(int paramInt) {
/* 1050 */     deleteCharAt0(paramInt);
/* 1051 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public void clear() {
/* 1056 */     this.length = 0;
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
/*      */   public StringBuilder insert(int paramInt, boolean paramBoolean) {
/* 1068 */     insert0(paramInt, paramBoolean ? "true" : "false");
/* 1069 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, char paramChar) {
/* 1081 */     insert0(paramInt, paramChar);
/* 1082 */     return this;
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
/*      */   public StringBuilder insert(int paramInt1, int paramInt2) {
/* 1094 */     insert0(paramInt1, Integer.toString(paramInt2));
/* 1095 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, long paramLong) {
/* 1107 */     insert0(paramInt, Long.toString(paramLong));
/* 1108 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, float paramFloat) {
/* 1120 */     insert0(paramInt, Float.toString(paramFloat));
/* 1121 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, double paramDouble) {
/* 1133 */     insert0(paramInt, Double.toString(paramDouble));
/* 1134 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, Object paramObject) {
/* 1146 */     insert0(paramInt, (paramObject == null) ? "null" : paramObject.toString());
/* 1147 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder insert(int paramInt, String paramString) {
/* 1158 */     insert0(paramInt, paramString);
/* 1159 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, char[] paramArrayOfchar) {
/* 1171 */     insert0(paramInt, paramArrayOfchar);
/* 1172 */     return this;
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
/*      */   public StringBuilder insert(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
/* 1187 */     insert0(paramInt1, paramArrayOfchar, paramInt2, paramInt3);
/* 1188 */     return this;
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
/*      */   public StringBuilder insert(int paramInt, CharSequence paramCharSequence) {
/* 1201 */     insert0(paramInt, (paramCharSequence == null) ? "null" : paramCharSequence.toString());
/* 1202 */     return this;
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
/*      */   public StringBuilder insert(int paramInt1, CharSequence paramCharSequence, int paramInt2, int paramInt3) {
/* 1218 */     insert0(paramInt1, paramCharSequence, paramInt2, paramInt3);
/* 1219 */     return this;
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
/*      */   public StringBuilder replace(int paramInt1, int paramInt2, String paramString) {
/* 1232 */     replace0(paramInt1, paramInt2, paramString);
/* 1233 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public StringBuilder replace(String paramString1, String paramString2) {
/* 1238 */     int i = paramString1.length(), j = paramString2.length();
/* 1239 */     int k = 0;
/*      */ 
/*      */     
/* 1242 */     while ((k = indexOf(paramString1, k)) != -1) {
/* 1243 */       replace0(k, k + i, paramString2);
/* 1244 */       k += j;
/*      */     } 
/* 1246 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public StringBuilder replace(char paramChar, String paramString) {
/* 1251 */     int i = paramString.length();
/* 1252 */     int j = 0;
/*      */     
/*      */     while (true) {
/* 1255 */       if (j == this.length) return this; 
/* 1256 */       if (this.chars[j] != paramChar) {
/* 1257 */         j++; continue;
/*      */       } 
/* 1259 */       replace0(j, j + 1, paramString);
/* 1260 */       j += i;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuilder reverse() {
/* 1268 */     reverse0();
/* 1269 */     return this;
/*      */   }
/*      */   
/*      */   public boolean isEmpty() {
/* 1273 */     return (this.length == 0);
/*      */   }
/*      */   
/*      */   public boolean notEmpty() {
/* 1277 */     return (this.length != 0);
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1281 */     int i = 31 + this.length;
/* 1282 */     for (byte b = 0; b < this.length; b++)
/* 1283 */       i = i * 31 + this.chars[b]; 
/* 1284 */     return i;
/*      */   }
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1288 */     if (this == paramObject) return true; 
/* 1289 */     if (paramObject == null) return false; 
/* 1290 */     if (getClass() != paramObject.getClass()) return false; 
/* 1291 */     paramObject = paramObject;
/*      */     int i;
/* 1293 */     if ((i = this.length) != ((StringBuilder)paramObject).length) return false; 
/* 1294 */     char[] arrayOfChar = this.chars; paramObject = ((StringBuilder)paramObject).chars;
/* 1295 */     for (byte b = 0; b < i; b++) {
/* 1296 */       if (arrayOfChar[b] != paramObject[b]) return false; 
/* 1297 */     }  return true;
/*      */   }
/*      */   
/*      */   public boolean equalsIgnoreCase(@Null StringBuilder paramStringBuilder) {
/* 1301 */     if (this == paramStringBuilder) return true; 
/* 1302 */     if (paramStringBuilder == null) return false; 
/*      */     int i;
/* 1304 */     if ((i = this.length) != paramStringBuilder.length) return false; 
/* 1305 */     char[] arrayOfChar2 = this.chars, arrayOfChar1 = paramStringBuilder.chars;
/* 1306 */     for (byte b = 0; b < i; b++) {
/* 1307 */       char c1 = arrayOfChar2[b];
/* 1308 */       char c2 = Character.toUpperCase(arrayOfChar1[b]);
/* 1309 */       if (c1 != c2 && c1 != Character.toLowerCase(c2)) return false; 
/*      */     } 
/* 1311 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equalsIgnoreCase(@Null String paramString) {
/* 1315 */     if (paramString == null) return false; 
/*      */     int i;
/* 1317 */     if ((i = this.length) != paramString.length()) return false; 
/* 1318 */     char[] arrayOfChar = this.chars;
/* 1319 */     for (byte b = 0; b < i; b++) {
/* 1320 */       char c1 = arrayOfChar[b];
/* 1321 */       char c2 = Character.toUpperCase(paramString.charAt(b));
/* 1322 */       if (c1 != c2 && c1 != Character.toLowerCase(c2)) return false; 
/*      */     } 
/* 1324 */     return true;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\badlogic\gd\\utils\StringBuilder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */