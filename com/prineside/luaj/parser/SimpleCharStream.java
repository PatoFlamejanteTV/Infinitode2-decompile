/*     */ package com.prineside.luaj.parser;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleCharStream
/*     */ {
/*     */   public static final boolean staticFlag = false;
/*     */   private int a;
/*     */   private int b;
/*     */   private int c;
/*  18 */   public int bufpos = -1;
/*     */   
/*     */   private int[] d;
/*     */   private int[] e;
/*  22 */   private int f = 0;
/*  23 */   private int g = 1;
/*     */   
/*     */   private boolean h = false;
/*     */   
/*     */   private boolean i = false;
/*     */   
/*     */   private Reader j;
/*     */   private char[] k;
/*  31 */   private int l = 0;
/*  32 */   private int m = 0;
/*  33 */   private int n = 1;
/*     */   
/*  35 */   public void setTabSize(int paramInt) { this.n = paramInt; } public int getTabSize(int paramInt) {
/*  36 */     return this.n;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(boolean paramBoolean) {
/*  41 */     char[] arrayOfChar = new char[this.a + 2048];
/*  42 */     int[] arrayOfInt1 = new int[this.a + 2048];
/*  43 */     int[] arrayOfInt2 = new int[this.a + 2048];
/*     */ 
/*     */     
/*     */     try {
/*  47 */       if (paramBoolean)
/*     */       {
/*  49 */         System.arraycopy(this.k, this.c, arrayOfChar, 0, this.a - this.c);
/*  50 */         System.arraycopy(this.k, 0, arrayOfChar, this.a - this.c, this.bufpos);
/*  51 */         this.k = arrayOfChar;
/*     */         
/*  53 */         System.arraycopy(this.d, this.c, arrayOfInt1, 0, this.a - this.c);
/*  54 */         System.arraycopy(this.d, 0, arrayOfInt1, this.a - this.c, this.bufpos);
/*  55 */         this.d = arrayOfInt1;
/*     */         
/*  57 */         System.arraycopy(this.e, this.c, arrayOfInt2, 0, this.a - this.c);
/*  58 */         System.arraycopy(this.e, 0, arrayOfInt2, this.a - this.c, this.bufpos);
/*  59 */         this.e = arrayOfInt2;
/*     */         
/*  61 */         this.l = this.bufpos += this.a - this.c;
/*     */       }
/*     */       else
/*     */       {
/*  65 */         System.arraycopy(this.k, this.c, arrayOfChar, 0, this.a - this.c);
/*  66 */         this.k = arrayOfChar;
/*     */         
/*  68 */         System.arraycopy(this.d, this.c, arrayOfInt1, 0, this.a - this.c);
/*  69 */         this.d = arrayOfInt1;
/*     */         
/*  71 */         System.arraycopy(this.e, this.c, arrayOfInt2, 0, this.a - this.c);
/*  72 */         this.e = arrayOfInt2;
/*     */         
/*  74 */         this.l = this.bufpos -= this.c;
/*     */       }
/*     */     
/*  77 */     } catch (Throwable throwable) {
/*     */       
/*  79 */       throw new Error(throwable.getMessage());
/*     */     } 
/*     */ 
/*     */     
/*  83 */     this.a += 2048;
/*  84 */     this.b = this.a;
/*  85 */     this.c = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() {
/*  90 */     if (this.l == this.b)
/*     */     {
/*  92 */       if (this.b == this.a) {
/*     */         
/*  94 */         if (this.c > 2048) {
/*     */           
/*  96 */           this.bufpos = this.l = 0;
/*  97 */           this.b = this.c;
/*     */         }
/*  99 */         else if (this.c < 0) {
/* 100 */           this.bufpos = this.l = 0;
/*     */         } else {
/* 102 */           a(false);
/*     */         } 
/* 104 */       } else if (this.b > this.c) {
/* 105 */         this.b = this.a;
/* 106 */       } else if (this.c - this.b < 2048) {
/* 107 */         a(true);
/*     */       } else {
/* 109 */         this.b = this.c;
/*     */       } 
/*     */     }
/*     */     try {
/*     */       int i;
/* 114 */       if ((i = this.j.read(this.k, this.l, this.b - this.l)) == -1) {
/*     */         
/* 116 */         this.j.close();
/* 117 */         throw new IOException();
/*     */       } 
/*     */       
/* 120 */       this.l += i;
/*     */       
/*     */       return;
/* 123 */     } catch (IOException iOException) {
/* 124 */       this.bufpos--;
/* 125 */       backup(0);
/* 126 */       if (this.c == -1)
/* 127 */         this.c = this.bufpos; 
/* 128 */       throw iOException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public char BeginToken() {
/* 135 */     this.c = -1;
/* 136 */     char c = readChar();
/* 137 */     this.c = this.bufpos;
/*     */     
/* 139 */     return c;
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
/*     */   private void a(char paramChar) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: dup
/*     */     //   2: getfield f : I
/*     */     //   5: iconst_1
/*     */     //   6: iadd
/*     */     //   7: putfield f : I
/*     */     //   10: aload_0
/*     */     //   11: getfield i : Z
/*     */     //   14: ifeq -> 25
/*     */     //   17: aload_0
/*     */     //   18: iconst_0
/*     */     //   19: putfield i : Z
/*     */     //   22: goto -> 51
/*     */     //   25: aload_0
/*     */     //   26: getfield h : Z
/*     */     //   29: ifeq -> 66
/*     */     //   32: aload_0
/*     */     //   33: iconst_0
/*     */     //   34: putfield h : Z
/*     */     //   37: iload_1
/*     */     //   38: bipush #10
/*     */     //   40: if_icmpne -> 51
/*     */     //   43: aload_0
/*     */     //   44: iconst_1
/*     */     //   45: putfield i : Z
/*     */     //   48: goto -> 66
/*     */     //   51: aload_0
/*     */     //   52: dup
/*     */     //   53: getfield g : I
/*     */     //   56: aload_0
/*     */     //   57: iconst_1
/*     */     //   58: dup_x1
/*     */     //   59: putfield f : I
/*     */     //   62: iadd
/*     */     //   63: putfield g : I
/*     */     //   66: iload_1
/*     */     //   67: tableswitch default -> 149, 9 -> 116, 10 -> 108, 11 -> 149, 12 -> 149, 13 -> 100
/*     */     //   100: aload_0
/*     */     //   101: iconst_1
/*     */     //   102: putfield h : Z
/*     */     //   105: goto -> 149
/*     */     //   108: aload_0
/*     */     //   109: iconst_1
/*     */     //   110: putfield i : Z
/*     */     //   113: goto -> 149
/*     */     //   116: aload_0
/*     */     //   117: dup
/*     */     //   118: getfield f : I
/*     */     //   121: iconst_1
/*     */     //   122: isub
/*     */     //   123: putfield f : I
/*     */     //   126: aload_0
/*     */     //   127: dup
/*     */     //   128: getfield f : I
/*     */     //   131: aload_0
/*     */     //   132: getfield n : I
/*     */     //   135: aload_0
/*     */     //   136: getfield f : I
/*     */     //   139: aload_0
/*     */     //   140: getfield n : I
/*     */     //   143: irem
/*     */     //   144: isub
/*     */     //   145: iadd
/*     */     //   146: putfield f : I
/*     */     //   149: aload_0
/*     */     //   150: getfield d : [I
/*     */     //   153: aload_0
/*     */     //   154: getfield bufpos : I
/*     */     //   157: aload_0
/*     */     //   158: getfield g : I
/*     */     //   161: iastore
/*     */     //   162: aload_0
/*     */     //   163: getfield e : [I
/*     */     //   166: aload_0
/*     */     //   167: getfield bufpos : I
/*     */     //   170: aload_0
/*     */     //   171: getfield f : I
/*     */     //   174: iastore
/*     */     //   175: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #144	-> 0
/*     */     //   #146	-> 10
/*     */     //   #148	-> 17
/*     */     //   #149	-> 22
/*     */     //   #151	-> 25
/*     */     //   #153	-> 32
/*     */     //   #154	-> 37
/*     */     //   #156	-> 43
/*     */     //   #159	-> 51
/*     */     //   #162	-> 66
/*     */     //   #165	-> 100
/*     */     //   #166	-> 105
/*     */     //   #168	-> 108
/*     */     //   #169	-> 113
/*     */     //   #171	-> 116
/*     */     //   #172	-> 126
/*     */     //   #178	-> 149
/*     */     //   #179	-> 162
/*     */     //   #180	-> 175
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
/*     */   public char readChar() {
/* 185 */     if (this.m > 0) {
/*     */       
/* 187 */       this.m--;
/*     */       
/* 189 */       if (++this.bufpos == this.a) {
/* 190 */         this.bufpos = 0;
/*     */       }
/* 192 */       return this.k[this.bufpos];
/*     */     } 
/*     */     
/* 195 */     if (++this.bufpos >= this.l) {
/* 196 */       a();
/*     */     }
/* 198 */     char c = this.k[this.bufpos];
/*     */     
/* 200 */     a(c);
/* 201 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColumn() {
/* 210 */     return this.e[this.bufpos];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLine() {
/* 219 */     return this.d[this.bufpos];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEndColumn() {
/* 224 */     return this.e[this.bufpos];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getEndLine() {
/* 229 */     return this.d[this.bufpos];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBeginColumn() {
/* 234 */     return this.e[this.c];
/*     */   }
/*     */ 
/*     */   
/*     */   public int getBeginLine() {
/* 239 */     return this.d[this.c];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void backup(int paramInt) {
/* 245 */     this.m += paramInt;
/* 246 */     if ((this.bufpos -= paramInt) < 0) {
/* 247 */       this.bufpos += this.a;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(Reader paramReader, int paramInt1, int paramInt2, int paramInt3) {
/* 254 */     this.j = paramReader;
/* 255 */     this.g = paramInt1;
/* 256 */     this.f = paramInt2 - 1;
/*     */     
/* 258 */     this.b = this.a = paramInt3;
/* 259 */     this.k = new char[paramInt3];
/* 260 */     this.d = new int[paramInt3];
/* 261 */     this.e = new int[paramInt3];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(Reader paramReader, int paramInt1, int paramInt2) {
/* 268 */     this(paramReader, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(Reader paramReader) {
/* 274 */     this(paramReader, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(Reader paramReader, int paramInt1, int paramInt2, int paramInt3) {
/* 281 */     this.j = paramReader;
/* 282 */     this.g = paramInt1;
/* 283 */     this.f = paramInt2 - 1;
/*     */     
/* 285 */     if (this.k == null || paramInt3 != this.k.length) {
/*     */       
/* 287 */       this.b = this.a = paramInt3;
/* 288 */       this.k = new char[paramInt3];
/* 289 */       this.d = new int[paramInt3];
/* 290 */       this.e = new int[paramInt3];
/*     */     } 
/* 292 */     this.i = this.h = false;
/* 293 */     this.c = this.m = this.l = 0;
/* 294 */     this.bufpos = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(Reader paramReader, int paramInt1, int paramInt2) {
/* 301 */     ReInit(paramReader, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(Reader paramReader) {
/* 307 */     ReInit(paramReader, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 313 */     this((paramString == null) ? new InputStreamReader(paramInputStream) : new InputStreamReader(paramInputStream, paramString), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3) {
/* 320 */     this(new InputStreamReader(paramInputStream), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2) {
/* 327 */     this(paramInputStream, paramString, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, int paramInt1, int paramInt2) {
/* 334 */     this(paramInputStream, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream, String paramString) {
/* 340 */     this(paramInputStream, paramString, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SimpleCharStream(InputStream paramInputStream) {
/* 346 */     this(paramInputStream, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 353 */     ReInit((paramString == null) ? new InputStreamReader(paramInputStream) : new InputStreamReader(paramInputStream, paramString), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, int paramInt1, int paramInt2, int paramInt3) {
/* 360 */     ReInit(new InputStreamReader(paramInputStream), paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, String paramString) {
/* 366 */     ReInit(paramInputStream, paramString, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream) {
/* 372 */     ReInit(paramInputStream, 1, 1, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, String paramString, int paramInt1, int paramInt2) {
/* 378 */     ReInit(paramInputStream, paramString, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void ReInit(InputStream paramInputStream, int paramInt1, int paramInt2) {
/* 384 */     ReInit(paramInputStream, paramInt1, paramInt2, 4096);
/*     */   }
/*     */ 
/*     */   
/*     */   public String GetImage() {
/* 389 */     if (this.bufpos >= this.c) {
/* 390 */       return new String(this.k, this.c, this.bufpos - this.c + 1);
/*     */     }
/* 392 */     return new String(this.k, this.c, this.a - this.c) + new String(this.k, 0, this.bufpos + 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char[] GetSuffix(int paramInt) {
/* 399 */     char[] arrayOfChar = new char[paramInt];
/*     */     
/* 401 */     if (this.bufpos + 1 >= paramInt) {
/* 402 */       System.arraycopy(this.k, this.bufpos - paramInt + 1, arrayOfChar, 0, paramInt);
/*     */     } else {
/*     */       
/* 405 */       System.arraycopy(this.k, this.a - paramInt - this.bufpos - 1, arrayOfChar, 0, paramInt - this.bufpos - 1);
/*     */       
/* 407 */       System.arraycopy(this.k, 0, arrayOfChar, paramInt - this.bufpos - 1, this.bufpos + 1);
/*     */     } 
/*     */     
/* 410 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void Done() {
/* 416 */     this.k = null;
/* 417 */     this.d = null;
/* 418 */     this.e = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void adjustBeginLineColumn(int paramInt1, int paramInt2) {
/* 426 */     int j, i = this.c;
/*     */ 
/*     */     
/* 429 */     if (this.bufpos >= this.c) {
/*     */       
/* 431 */       j = this.bufpos - this.c + this.m + 1;
/*     */     }
/*     */     else {
/*     */       
/* 435 */       j = this.a - this.c + this.bufpos + 1 + this.m;
/*     */     } 
/*     */     
/* 438 */     byte b = 0; int k = 0;
/* 439 */     int n = 0;
/*     */     int m;
/* 441 */     while (b < j && this.d[k = i % this.a] == this.d[m = ++i % this.a]) {
/*     */       
/* 443 */       this.d[k] = paramInt1;
/* 444 */       m = n + this.e[m] - this.e[k];
/* 445 */       this.e[k] = paramInt2 + n;
/* 446 */       n = m;
/* 447 */       b++;
/*     */     } 
/*     */     
/* 450 */     if (b < j) {
/*     */       
/* 452 */       this.d[k] = paramInt1++;
/* 453 */       this.e[k] = paramInt2 + n;
/*     */       
/* 455 */       while (b++ < j) {
/*     */         
/* 457 */         if (this.d[k = i % this.a] != this.d[++i % this.a]) {
/* 458 */           this.d[k] = paramInt1++; continue;
/*     */         } 
/* 460 */         this.d[k] = paramInt1;
/*     */       } 
/*     */     } 
/*     */     
/* 464 */     this.g = this.d[k];
/* 465 */     this.f = this.e[k];
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\parser\SimpleCharStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */