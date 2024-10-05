/*      */ package com.prineside.luaj.parser;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ 
/*      */ public class LuaParserTokenManager
/*      */   implements LuaParserConstants
/*      */ {
/*    9 */   public PrintStream debugStream = System.out;
/*      */   public void setDebugStream(PrintStream paramPrintStream) {
/*   11 */     this.debugStream = paramPrintStream;
/*      */   }
/*      */   private int a(int paramInt1, int paramInt2) {
/*   14 */     this.s = paramInt2;
/*   15 */     this.r = paramInt1;
/*   16 */     return paramInt1 + 1;
/*      */   }
/*      */   
/*      */   private int a() {
/*   20 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*   23 */         return a(262144L);
/*      */     } 
/*   25 */     return 1;
/*      */   }
/*      */   
/*      */   private int a(long paramLong) {
/*      */     try {
/*   30 */       this.m = this.g.readChar();
/*   31 */     } catch (IOException iOException) {
/*   32 */       return 1;
/*      */     } 
/*   34 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*   37 */         if (262144L != 0L) {
/*   38 */           return a(1, 18);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*   43 */         return 2;
/*      */     } 
/*      */     return 2;
/*      */   } private int b() {
/*   47 */     return b(6, 0);
/*      */   }
/*      */   
/*      */   private int b(int paramInt1, int paramInt2) {
/*   51 */     paramInt1 = 0;
/*   52 */     this.p = 7;
/*   53 */     int i = 1;
/*   54 */     this.i[0] = 6;
/*   55 */     int j = Integer.MAX_VALUE;
/*      */     
/*      */     while (true) {
/*   58 */       if (++this.q == Integer.MAX_VALUE)
/*   59 */         m(); 
/*   60 */       if (this.m < '@') {
/*      */ 
/*      */         
/*      */         do {
/*      */           
/*   65 */           switch (this.i[--i]) {
/*      */             
/*      */             case 0:
/*      */             case 1:
/*   69 */               if (this.m == '=')
/*   70 */                 g(1, 2); 
/*      */               break;
/*      */             case 3:
/*   73 */               if (this.m == '=')
/*   74 */                 this.i[this.p++] = 0; 
/*      */               break;
/*      */             case 4:
/*   77 */               if (this.m == '=')
/*   78 */                 this.i[this.p++] = 3; 
/*      */               break;
/*      */             case 5:
/*   81 */               if (this.m == '=') {
/*   82 */                 this.i[this.p++] = 4;
/*      */               }
/*      */               break;
/*      */           } 
/*   86 */         } while (i != paramInt1);
/*      */       }
/*   88 */       else if (this.m < '') {
/*      */ 
/*      */         
/*      */         do {
/*      */           
/*   93 */           switch (this.i[--i]) {
/*      */             
/*      */             case 2:
/*   96 */               if (this.m == ']' && j > 27)
/*   97 */                 j = 27; 
/*      */               break;
/*      */             case 6:
/*  100 */               if (this.m == ']') {
/*  101 */                 this.i[this.p++] = 5;
/*      */               }
/*      */               break;
/*      */           } 
/*  105 */         } while (i != paramInt1);
/*      */       } 
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
/*  122 */       if (j != Integer.MAX_VALUE) {
/*      */         
/*  124 */         this.s = j;
/*  125 */         this.r = paramInt2;
/*  126 */         j = Integer.MAX_VALUE;
/*      */       } 
/*  128 */       paramInt2++;
/*  129 */       if ((i = this.p) == (paramInt1 = 7 - (this.p = paramInt1)))
/*  130 */         return paramInt2;  
/*  131 */       try { this.m = this.g.readChar(); }
/*  132 */       catch (IOException iOException) { return paramInt2; }
/*      */     
/*      */     } 
/*      */   }
/*      */   private int c() {
/*  137 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  140 */         return b(67108864L);
/*      */     } 
/*  142 */     return 1;
/*      */   }
/*      */   
/*      */   private int b(long paramLong) {
/*      */     try {
/*  147 */       this.m = this.g.readChar();
/*  148 */     } catch (IOException iOException) {
/*  149 */       return 1;
/*      */     } 
/*  151 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  154 */         return a(67108864L, 67108864L);
/*      */     } 
/*  156 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int a(long paramLong1, long paramLong2) {
/*  161 */     if ((paramLong2 = 0x4000000L & paramLong1) == 0L)
/*  162 */       return 2;  try {
/*  163 */       this.m = this.g.readChar();
/*  164 */     } catch (IOException iOException) {
/*  165 */       return 2;
/*      */     } 
/*  167 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  170 */         return b(paramLong2, 67108864L);
/*      */     } 
/*  172 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   private int b(long paramLong1, long paramLong2) {
/*  177 */     if ((paramLong2 = 0x4000000L & paramLong1) == 0L)
/*  178 */       return 3;  try {
/*  179 */       this.m = this.g.readChar();
/*  180 */     } catch (IOException iOException) {
/*  181 */       return 3;
/*      */     } 
/*  183 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  186 */         return c(paramLong2, 67108864L);
/*      */     } 
/*  188 */     return 4;
/*      */   }
/*      */ 
/*      */   
/*      */   private int c(long paramLong1, long paramLong2) {
/*  193 */     if ((paramLong2 = 0x4000000L & paramLong1) == 0L)
/*  194 */       return 4;  try {
/*  195 */       this.m = this.g.readChar();
/*  196 */     } catch (IOException iOException) {
/*  197 */       return 4;
/*      */     } 
/*  199 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  202 */         if ((paramLong2 & 0x4000000L) != 0L) {
/*  203 */           return a(4, 26);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  208 */         return 5;
/*      */     } 
/*      */     return 5;
/*      */   } private int d() {
/*  212 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  215 */         return c(33554432L);
/*      */     } 
/*  217 */     return 1;
/*      */   }
/*      */   
/*      */   private int c(long paramLong) {
/*      */     try {
/*  222 */       this.m = this.g.readChar();
/*  223 */     } catch (IOException iOException) {
/*  224 */       return 1;
/*      */     } 
/*  226 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  229 */         return d(33554432L, 33554432L);
/*      */     } 
/*  231 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int d(long paramLong1, long paramLong2) {
/*  236 */     if ((paramLong2 = 0x2000000L & paramLong1) == 0L)
/*  237 */       return 2;  try {
/*  238 */       this.m = this.g.readChar();
/*  239 */     } catch (IOException iOException) {
/*  240 */       return 2;
/*      */     } 
/*  242 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  245 */         return e(paramLong2, 33554432L);
/*      */     } 
/*  247 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   private int e(long paramLong1, long paramLong2) {
/*  252 */     if ((paramLong2 = 0x2000000L & paramLong1) == 0L)
/*  253 */       return 3;  try {
/*  254 */       this.m = this.g.readChar();
/*  255 */     } catch (IOException iOException) {
/*  256 */       return 3;
/*      */     } 
/*  258 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  261 */         if ((paramLong2 & 0x2000000L) != 0L) {
/*  262 */           return a(3, 25);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  267 */         return 4;
/*      */     } 
/*      */     return 4;
/*      */   } private int e() {
/*  271 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  274 */         return d(16777216L);
/*      */     } 
/*  276 */     return 1;
/*      */   }
/*      */   
/*      */   private int d(long paramLong) {
/*      */     try {
/*  281 */       this.m = this.g.readChar();
/*  282 */     } catch (IOException iOException) {
/*  283 */       return 1;
/*      */     } 
/*  285 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  288 */         return f(16777216L, 16777216L);
/*      */     } 
/*  290 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int f(long paramLong1, long paramLong2) {
/*  295 */     if ((paramLong2 = 0x1000000L & paramLong1) == 0L)
/*  296 */       return 2;  try {
/*  297 */       this.m = this.g.readChar();
/*  298 */     } catch (IOException iOException) {
/*  299 */       return 2;
/*      */     } 
/*  301 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  304 */         if ((paramLong2 & 0x1000000L) != 0L) {
/*  305 */           return a(2, 24);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  310 */         return 3;
/*      */     } 
/*      */     return 3;
/*      */   } private int f() {
/*  314 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  317 */         return e(8388608L);
/*      */     } 
/*  319 */     return 1;
/*      */   }
/*      */   
/*      */   private int e(long paramLong) {
/*      */     try {
/*  324 */       this.m = this.g.readChar();
/*  325 */     } catch (IOException iOException) {
/*  326 */       return 1;
/*      */     } 
/*  328 */     switch (this.m) {
/*      */       
/*      */       case ']':
/*  331 */         if (8388608L != 0L) {
/*  332 */           return a(1, 23);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  337 */         return 2;
/*      */     } 
/*      */     return 2;
/*      */   } private final int a(int paramInt, long paramLong1, long paramLong2) {
/*  341 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/*  344 */         if ((paramLong1 & 0x7800L) != 0L || (paramLong2 & 0x2000L) != 0L)
/*  345 */           return 14; 
/*  346 */         if ((paramLong2 & 0x1008200L) != 0L)
/*  347 */           return 31; 
/*  348 */         if ((paramLong1 & 0x7FFFFE0000000L) != 0L) {
/*      */           
/*  350 */           this.s = 51;
/*  351 */           return 17;
/*      */         } 
/*  353 */         if ((paramLong1 & 0x103C0L) != 0L || (paramLong2 & 0x80000L) != 0L)
/*  354 */           return 7; 
/*  355 */         return -1;
/*      */       case 1:
/*  357 */         if ((paramLong1 & 0x103C0L) != 0L)
/*  358 */           return 6; 
/*  359 */         if ((paramLong1 & 0x7000L) != 0L)
/*  360 */           return 13; 
/*  361 */         if ((paramLong1 & 0x118080000000L) != 0L)
/*  362 */           return 17; 
/*  363 */         if ((paramLong1 & 0x7EE7F60000000L) != 0L) {
/*      */           
/*  365 */           if (this.r != 1) {
/*      */             
/*  367 */             this.s = 51;
/*  368 */             this.r = 1;
/*      */           } 
/*  370 */           return 17;
/*      */         } 
/*  372 */         return -1;
/*      */       case 2:
/*  374 */         if ((paramLong1 & 0x7E26B40000000L) != 0L) {
/*      */           
/*  376 */           this.s = 51;
/*  377 */           this.r = 2;
/*  378 */           return 17;
/*      */         } 
/*  380 */         if ((paramLong1 & 0x6000L) != 0L)
/*  381 */           return 12; 
/*  382 */         if ((paramLong1 & 0x3C0L) != 0L)
/*  383 */           return 5; 
/*  384 */         if ((paramLong1 & 0xC1420000000L) != 0L)
/*  385 */           return 17; 
/*  386 */         return -1;
/*      */       case 3:
/*  388 */         if ((paramLong1 & 0x380L) != 0L)
/*  389 */           return 4; 
/*  390 */         if ((paramLong1 & 0x6622840000000L) != 0L) {
/*      */           
/*  392 */           if (this.r != 3) {
/*      */             
/*  394 */             this.s = 51;
/*  395 */             this.r = 3;
/*      */           } 
/*  397 */           return 17;
/*      */         } 
/*  399 */         if ((paramLong1 & 0x1804300000000L) != 0L)
/*  400 */           return 17; 
/*  401 */         if ((paramLong1 & 0x4000L) != 0L)
/*  402 */           return 9; 
/*  403 */         return -1;
/*      */       case 4:
/*  405 */         if ((paramLong1 & 0x602200000000L) != 0L) {
/*      */           
/*  407 */           this.s = 51;
/*  408 */           this.r = 4;
/*  409 */           return 17;
/*      */         } 
/*  411 */         if ((paramLong1 & 0x300L) != 0L)
/*  412 */           return 3; 
/*  413 */         if ((paramLong1 & 0x6020840000000L) != 0L)
/*  414 */           return 17; 
/*  415 */         return -1;
/*      */       case 5:
/*  417 */         if ((paramLong1 & 0x200L) != 0L)
/*  418 */           return 0; 
/*  419 */         if ((paramLong1 & 0x600200000000L) != 0L)
/*  420 */           return 17; 
/*  421 */         if ((paramLong1 & 0x2000000000L) != 0L) {
/*      */           
/*  423 */           this.s = 51;
/*  424 */           this.r = 5;
/*  425 */           return 17;
/*      */         } 
/*  427 */         return -1;
/*      */       case 6:
/*  429 */         if ((paramLong1 & 0x2000000000L) != 0L) {
/*      */           
/*  431 */           this.s = 51;
/*  432 */           this.r = 6;
/*  433 */           return 17;
/*      */         } 
/*  435 */         return -1;
/*      */     } 
/*  437 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   private final int b(int paramInt, long paramLong1, long paramLong2) {
/*  442 */     return c(a(paramInt, paramLong1, paramLong2), paramInt + 1);
/*      */   }
/*      */   
/*      */   private int g() {
/*  446 */     switch (this.m) {
/*      */       
/*      */       case '#':
/*  449 */         return a(0, 69);
/*      */       case '%':
/*  451 */         return a(0, 87);
/*      */       case '(':
/*  453 */         return a(0, 75);
/*      */       case ')':
/*  455 */         return a(0, 76);
/*      */       case '*':
/*  457 */         return a(0, 84);
/*      */       case '+':
/*  459 */         return a(0, 82);
/*      */       case ',':
/*  461 */         return a(0, 72);
/*      */       case '-':
/*  463 */         this.s = 83;
/*  464 */         return g(66496L, 0L);
/*      */       case '.':
/*  466 */         this.s = 73;
/*  467 */         return g(0L, 16809984L);
/*      */       case '/':
/*  469 */         return a(0, 85);
/*      */       case ':':
/*  471 */         this.s = 74;
/*  472 */         return g(0L, 2L);
/*      */       case ';':
/*  474 */         return a(0, 70);
/*      */       case '<':
/*  476 */         this.s = 89;
/*  477 */         return g(0L, 67108864L);
/*      */       case '=':
/*  479 */         this.s = 71;
/*  480 */         return g(0L, 536870912L);
/*      */       case '>':
/*  482 */         this.s = 91;
/*  483 */         return g(0L, 268435456L);
/*      */       case '[':
/*  485 */         this.s = 77;
/*  486 */         return g(30720L, 0L);
/*      */       case ']':
/*  488 */         return a(0, 78);
/*      */       case '^':
/*  490 */         return a(0, 86);
/*      */       case 'a':
/*  492 */         return g(536870912L, 0L);
/*      */       case 'b':
/*  494 */         return g(1073741824L, 0L);
/*      */       case 'd':
/*  496 */         return g(2147483648L, 0L);
/*      */       case 'e':
/*  498 */         return g(30064771072L, 0L);
/*      */       case 'f':
/*  500 */         return g(240518168576L, 0L);
/*      */       case 'g':
/*  502 */         return g(274877906944L, 0L);
/*      */       case 'i':
/*  504 */         return g(1649267441664L, 0L);
/*      */       case 'l':
/*  506 */         return g(2199023255552L, 0L);
/*      */       case 'n':
/*  508 */         return g(13194139533312L, 0L);
/*      */       case 'o':
/*  510 */         return g(17592186044416L, 0L);
/*      */       case 'r':
/*  512 */         return g(105553116266496L, 0L);
/*      */       case 't':
/*  514 */         return g(422212465065984L, 0L);
/*      */       case 'u':
/*  516 */         return g(562949953421312L, 0L);
/*      */       case 'w':
/*  518 */         return g(1125899906842624L, 0L);
/*      */       case '{':
/*  520 */         return a(0, 80);
/*      */       case '}':
/*  522 */         return a(0, 81);
/*      */       case '~':
/*  524 */         return g(0L, 1073741824L);
/*      */     } 
/*  526 */     return c(8, 0);
/*      */   }
/*      */   
/*      */   private int g(long paramLong1, long paramLong2) {
/*      */     try {
/*  531 */       this.m = this.g.readChar();
/*  532 */     } catch (IOException iOException) {
/*  533 */       a(0, paramLong1, paramLong2);
/*  534 */       return 1;
/*      */     } 
/*  536 */     switch (this.m) {
/*      */       
/*      */       case '-':
/*  539 */         if ((paramLong1 & 0x10000L) != 0L) {
/*      */           
/*  541 */           this.s = 16;
/*  542 */           this.r = 1;
/*      */         } 
/*  544 */         return a(paramLong1, 960L, paramLong2, 0L);
/*      */       case '.':
/*  546 */         if ((paramLong2 & 0x1000000L) != 0L) {
/*      */           
/*  548 */           this.s = 88;
/*  549 */           this.r = 1;
/*      */         } 
/*  551 */         return a(paramLong1, 0L, paramLong2, 32768L);
/*      */       case ':':
/*  553 */         if ((paramLong2 & 0x2L) != 0L)
/*  554 */           return a(1, 65); 
/*      */         break;
/*      */       case '=':
/*  557 */         if ((paramLong2 & 0x4000000L) != 0L)
/*  558 */           return a(1, 90); 
/*  559 */         if ((paramLong2 & 0x10000000L) != 0L)
/*  560 */           return a(1, 92); 
/*  561 */         if ((paramLong2 & 0x20000000L) != 0L)
/*  562 */           return a(1, 93); 
/*  563 */         if ((paramLong2 & 0x40000000L) != 0L)
/*  564 */           return a(1, 94); 
/*  565 */         return a(paramLong1, 28672L, paramLong2, 0L);
/*      */       case '[':
/*  567 */         if ((paramLong1 & 0x800L) != 0L)
/*  568 */           return a(1, 11); 
/*      */         break;
/*      */       case 'a':
/*  571 */         return a(paramLong1, 34359738368L, paramLong2, 0L);
/*      */       case 'e':
/*  573 */         return a(paramLong1, 105553116266496L, paramLong2, 0L);
/*      */       case 'f':
/*  575 */         if ((paramLong1 & 0x8000000000L) != 0L)
/*  576 */           return a(1, 39, 17); 
/*      */         break;
/*      */       case 'h':
/*  579 */         return a(paramLong1, 1266637395197952L, paramLong2, 0L);
/*      */       case 'i':
/*  581 */         return a(paramLong1, 4398046511104L, paramLong2, 0L);
/*      */       case 'l':
/*  583 */         return a(paramLong1, 12884901888L, paramLong2, 0L);
/*      */       case 'n':
/*  585 */         if ((paramLong1 & 0x10000000000L) != 0L)
/*  586 */           return a(1, 40, 17); 
/*  587 */         return a(paramLong1, 562967670161408L, paramLong2, 0L);
/*      */       case 'o':
/*  589 */         if ((paramLong1 & 0x80000000L) != 0L)
/*  590 */           return a(1, 31, 17); 
/*  591 */         return a(paramLong1, 11338713661440L, paramLong2, 0L);
/*      */       case 'r':
/*  593 */         if ((paramLong1 & 0x100000000000L) != 0L)
/*  594 */           return a(1, 44, 17); 
/*  595 */         return a(paramLong1, 281476050452480L, paramLong2, 0L);
/*      */       case 'u':
/*  597 */         return a(paramLong1, 137438953472L, paramLong2, 0L);
/*      */     } 
/*      */ 
/*      */     
/*  601 */     return b(0, paramLong1, paramLong2);
/*      */   }
/*      */   
/*      */   private int a(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  605 */     if (((paramLong2 &= paramLong1) | (paramLong4 &= paramLong3)) == 0L)
/*  606 */       return b(0, paramLong1, paramLong3);  try {
/*  607 */       this.m = this.g.readChar();
/*  608 */     } catch (IOException iOException) {
/*  609 */       a(1, paramLong2, paramLong4);
/*  610 */       return 2;
/*      */     } 
/*  612 */     switch (this.m) {
/*      */       
/*      */       case '.':
/*  615 */         if ((paramLong4 & 0x8000L) != 0L)
/*  616 */           return a(2, 79); 
/*      */         break;
/*      */       case '=':
/*  619 */         return b(paramLong2, 24576L, paramLong4, 0L);
/*      */       case '[':
/*  621 */         if ((paramLong2 & 0x1000L) != 0L)
/*  622 */           return a(2, 12); 
/*  623 */         return b(paramLong2, 960L, paramLong4, 0L);
/*      */       case 'c':
/*  625 */         return b(paramLong2, 2199023255552L, paramLong4, 0L);
/*      */       case 'd':
/*  627 */         if ((paramLong2 & 0x20000000L) != 0L)
/*  628 */           return a(2, 29, 17); 
/*  629 */         if ((paramLong2 & 0x400000000L) != 0L)
/*  630 */           return a(2, 34, 17); 
/*      */         break;
/*      */       case 'e':
/*  633 */         return b(paramLong2, 140738562097152L, paramLong4, 0L);
/*      */       case 'i':
/*  635 */         return b(paramLong2, 1125899906842624L, paramLong4, 0L);
/*      */       case 'l':
/*  637 */         if ((paramLong2 & 0x40000000000L) != 0L)
/*  638 */           return a(2, 42, 17); 
/*  639 */         return b(paramLong2, 34359738368L, paramLong4, 0L);
/*      */       case 'n':
/*  641 */         return b(paramLong2, 137438953472L, paramLong4, 0L);
/*      */       case 'p':
/*  643 */         return b(paramLong2, 70368744177664L, paramLong4, 0L);
/*      */       case 'r':
/*  645 */         if ((paramLong2 & 0x1000000000L) != 0L)
/*  646 */           return a(2, 36, 17); 
/*      */         break;
/*      */       case 's':
/*  649 */         return b(paramLong2, 12884901888L, paramLong4, 0L);
/*      */       case 't':
/*  651 */         if ((paramLong2 & 0x80000000000L) != 0L)
/*  652 */           return a(2, 43, 17); 
/*  653 */         return b(paramLong2, 598409203417088L, paramLong4, 0L);
/*      */       case 'u':
/*  655 */         return b(paramLong2, 281474976710656L, paramLong4, 0L);
/*      */     } 
/*      */ 
/*      */     
/*  659 */     return b(1, paramLong2, paramLong4);
/*      */   }
/*      */   
/*      */   private int b(long paramLong1, long paramLong2, long paramLong3, long paramLong4) {
/*  663 */     if (((paramLong2 &= paramLong1) | 0x0L & paramLong3) == 0L)
/*  664 */       return b(1, paramLong1, paramLong3);  try {
/*  665 */       this.m = this.g.readChar();
/*  666 */     } catch (IOException iOException) {
/*  667 */       a(2, paramLong2, 0L);
/*  668 */       return 3;
/*      */     } 
/*  670 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  673 */         return h(paramLong2, 17280L);
/*      */       case '[':
/*  675 */         if ((paramLong2 & 0x40L) != 0L)
/*  676 */           return a(3, 6); 
/*  677 */         if ((paramLong2 & 0x2000L) != 0L)
/*  678 */           return a(3, 13); 
/*      */         break;
/*      */       case 'a':
/*  681 */         return h(paramLong2, 2200096997376L);
/*      */       case 'c':
/*  683 */         return h(paramLong2, 137438953472L);
/*      */       case 'e':
/*  685 */         if ((paramLong2 & 0x100000000L) != 0L) {
/*      */           
/*  687 */           this.s = 32;
/*  688 */           this.r = 3;
/*      */         }
/*  690 */         else if ((paramLong2 & 0x1000000000000L) != 0L) {
/*  691 */           return a(3, 48, 17);
/*  692 */         }  return h(paramLong2, 70377334112256L);
/*      */       case 'i':
/*  694 */         return h(paramLong2, 562949953421312L);
/*      */       case 'l':
/*  696 */         return h(paramLong2, 1125899906842624L);
/*      */       case 'n':
/*  698 */         if ((paramLong2 & 0x800000000000L) != 0L)
/*  699 */           return a(3, 47, 17); 
/*      */         break;
/*      */       case 'o':
/*  702 */         if ((paramLong2 & 0x4000000000L) != 0L)
/*  703 */           return a(3, 38, 17); 
/*      */         break;
/*      */       case 's':
/*  706 */         return h(paramLong2, 34359738368L);
/*      */       case 'u':
/*  708 */         return h(paramLong2, 35184372088832L);
/*      */     } 
/*      */ 
/*      */     
/*  712 */     return b(2, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int h(long paramLong1, long paramLong2) {
/*  716 */     if ((paramLong2 &= paramLong1) == 0L)
/*  717 */       return b(2, paramLong1, 0L);  try {
/*  718 */       this.m = this.g.readChar();
/*  719 */     } catch (IOException iOException) {
/*  720 */       a(3, paramLong2, 0L);
/*  721 */       return 4;
/*      */     } 
/*  723 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  726 */         return i(paramLong2, 768L);
/*      */       case '[':
/*  728 */         if ((paramLong2 & 0x80L) != 0L)
/*  729 */           return a(4, 7); 
/*  730 */         if ((paramLong2 & 0x4000L) != 0L)
/*  731 */           return a(4, 14); 
/*      */         break;
/*      */       case 'a':
/*  734 */         return i(paramLong2, 70368744177664L);
/*      */       case 'e':
/*  736 */         if ((paramLong2 & 0x800000000L) != 0L)
/*  737 */           return a(4, 35, 17); 
/*  738 */         if ((paramLong2 & 0x4000000000000L) != 0L)
/*  739 */           return a(4, 50, 17); 
/*      */         break;
/*      */       case 'i':
/*  742 */         return i(paramLong2, 8589934592L);
/*      */       case 'k':
/*  744 */         if ((paramLong2 & 0x40000000L) != 0L)
/*  745 */           return a(4, 30, 17); 
/*      */         break;
/*      */       case 'l':
/*  748 */         if ((paramLong2 & 0x20000000000L) != 0L)
/*  749 */           return a(4, 41, 17); 
/*  750 */         if ((paramLong2 & 0x2000000000000L) != 0L)
/*  751 */           return a(4, 49, 17); 
/*      */         break;
/*      */       case 'r':
/*  754 */         return i(paramLong2, 35184372088832L);
/*      */       case 't':
/*  756 */         return i(paramLong2, 137438953472L);
/*      */     } 
/*      */ 
/*      */     
/*  760 */     return b(3, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int i(long paramLong1, long paramLong2) {
/*  764 */     if ((paramLong2 &= paramLong1) == 0L)
/*  765 */       return b(3, paramLong1, 0L);  try {
/*  766 */       this.m = this.g.readChar();
/*  767 */     } catch (IOException iOException) {
/*  768 */       a(4, paramLong2, 0L);
/*  769 */       return 5;
/*      */     } 
/*  771 */     switch (this.m) {
/*      */       
/*      */       case '=':
/*  774 */         return j(paramLong2, 512L);
/*      */       case '[':
/*  776 */         if ((paramLong2 & 0x100L) != 0L)
/*  777 */           return a(5, 8); 
/*      */         break;
/*      */       case 'f':
/*  780 */         if ((paramLong2 & 0x200000000L) != 0L)
/*  781 */           return a(5, 33, 17); 
/*      */         break;
/*      */       case 'i':
/*  784 */         return j(paramLong2, 137438953472L);
/*      */       case 'n':
/*  786 */         if ((paramLong2 & 0x200000000000L) != 0L)
/*  787 */           return a(5, 45, 17); 
/*      */         break;
/*      */       case 't':
/*  790 */         if ((paramLong2 & 0x400000000000L) != 0L) {
/*  791 */           return a(5, 46, 17);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  796 */     return b(4, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int j(long paramLong1, long paramLong2) {
/*  800 */     if ((paramLong2 &= paramLong1) == 0L)
/*  801 */       return b(4, paramLong1, 0L);  try {
/*  802 */       this.m = this.g.readChar();
/*  803 */     } catch (IOException iOException) {
/*  804 */       a(5, paramLong2, 0L);
/*  805 */       return 6;
/*      */     } 
/*  807 */     switch (this.m) {
/*      */       
/*      */       case '[':
/*  810 */         if ((paramLong2 & 0x200L) != 0L)
/*  811 */           return a(6, 9); 
/*      */         break;
/*      */       case 'o':
/*  814 */         return k(paramLong2, 137438953472L);
/*      */     } 
/*      */ 
/*      */     
/*  818 */     return b(5, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int k(long paramLong1, long paramLong2) {
/*  822 */     if ((paramLong2 = 0x2000000000L & paramLong1) == 0L)
/*  823 */       return b(5, paramLong1, 0L);  try {
/*  824 */       this.m = this.g.readChar();
/*  825 */     } catch (IOException iOException) {
/*  826 */       a(6, paramLong2, 0L);
/*  827 */       return 7;
/*      */     } 
/*  829 */     switch (this.m) {
/*      */       
/*      */       case 'n':
/*  832 */         if ((paramLong2 & 0x2000000000L) != 0L) {
/*  833 */           return a(7, 37, 17);
/*      */         }
/*      */         break;
/*      */     } 
/*      */     
/*  838 */     return b(6, paramLong2, 0L);
/*      */   }
/*      */   
/*      */   private int a(int paramInt1, int paramInt2, int paramInt3) {
/*  842 */     this.s = paramInt2;
/*  843 */     this.r = paramInt1; 
/*  844 */     try { this.m = this.g.readChar(); }
/*  845 */     catch (IOException iOException) { return paramInt1 + 1; }
/*  846 */      return c(17, paramInt1 + 1);
/*      */   }
/*  848 */   private static long[] a = new long[] { -2L, -1L, -1L, -1L };
/*      */ 
/*      */   
/*  851 */   private static long[] b = new long[] { 0L, 0L, -1L, -1L };
/*      */ 
/*      */ 
/*      */   
/*      */   private int c(int paramInt1, int paramInt2) {
/*  856 */     int i = 0;
/*  857 */     this.p = 66;
/*  858 */     int j = 1;
/*  859 */     this.i[0] = paramInt1;
/*  860 */     paramInt1 = Integer.MAX_VALUE;
/*      */     
/*      */     while (true) {
/*  863 */       if (++this.q == Integer.MAX_VALUE)
/*  864 */         m(); 
/*  865 */       if (this.m < '@') {
/*      */         
/*  867 */         long l = 1L << this.m;
/*      */         
/*      */         do {
/*  870 */           switch (this.i[--j]) {
/*      */             
/*      */             case 8:
/*  873 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  875 */                 if (paramInt1 > 52)
/*  876 */                   paramInt1 = 52; 
/*  877 */                 h(0, 3);
/*      */               }
/*  879 */               else if (this.m == '\'') {
/*  880 */                 h(4, 6);
/*  881 */               } else if (this.m == '"') {
/*  882 */                 h(7, 9);
/*  883 */               } else if (this.m == '.') {
/*  884 */                 a(31);
/*  885 */               } else if (this.m == '-') {
/*  886 */                 this.i[this.p++] = 7;
/*  887 */               }  if (this.m == '0')
/*  888 */                 this.i[this.p++] = 19; 
/*      */               break;
/*      */             case 0:
/*      */             case 1:
/*  892 */               if (this.m == '=')
/*  893 */                 g(1, 2); 
/*      */               break;
/*      */             case 3:
/*  896 */               if (this.m == '=')
/*  897 */                 this.i[this.p++] = 0; 
/*      */               break;
/*      */             case 4:
/*  900 */               if (this.m == '=')
/*  901 */                 this.i[this.p++] = 3; 
/*      */               break;
/*      */             case 5:
/*  904 */               if (this.m == '=')
/*  905 */                 this.i[this.p++] = 4; 
/*      */               break;
/*      */             case 7:
/*  908 */               if (this.m == '-')
/*  909 */                 this.i[this.p++] = 6; 
/*      */               break;
/*      */             case 9:
/*      */             case 10:
/*  913 */               if (this.m == '=')
/*  914 */                 g(10, 11); 
/*      */               break;
/*      */             case 12:
/*  917 */               if (this.m == '=')
/*  918 */                 this.i[this.p++] = 9; 
/*      */               break;
/*      */             case 13:
/*  921 */               if (this.m == '=')
/*  922 */                 this.i[this.p++] = 12; 
/*      */               break;
/*      */             case 14:
/*  925 */               if (this.m == '=')
/*  926 */                 this.i[this.p++] = 13; 
/*      */               break;
/*      */             case 17:
/*  929 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  931 */                 if (paramInt1 > 51)
/*  932 */                   paramInt1 = 51; 
/*  933 */                 this.i[this.p++] = 17;
/*      */               }  break;
/*      */             case 18:
/*  936 */               if (this.m == '0')
/*  937 */                 this.i[this.p++] = 19; 
/*      */               break;
/*      */             case 20:
/*  940 */               if (this.m == '.')
/*  941 */                 a(21); 
/*      */               break;
/*      */             case 21:
/*  944 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  946 */                 if (paramInt1 > 52)
/*  947 */                   paramInt1 = 52; 
/*  948 */                 g(21, 22);
/*      */               }  break;
/*      */             case 23:
/*  951 */               if ((0x280000000000L & l) != 0L)
/*  952 */                 a(24); 
/*      */               break;
/*      */             case 24:
/*  955 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  957 */                 if (paramInt1 > 52)
/*  958 */                   paramInt1 = 52; 
/*  959 */                 a(24);
/*      */               }  break;
/*      */             case 25:
/*  962 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  964 */                 if (paramInt1 > 52)
/*  965 */                   paramInt1 = 52; 
/*  966 */                 h(10, 13);
/*      */               }  break;
/*      */             case 26:
/*  969 */               if ((0x3FF000000000000L & l) != 0L)
/*  970 */                 g(26, 27); 
/*      */               break;
/*      */             case 27:
/*  973 */               if (this.m == '.') {
/*      */                 
/*  975 */                 if (paramInt1 > 52)
/*  976 */                   paramInt1 = 52; 
/*  977 */                 g(28, 22);
/*      */               }  break;
/*      */             case 28:
/*  980 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  982 */                 if (paramInt1 > 52)
/*  983 */                   paramInt1 = 52; 
/*  984 */                 g(28, 22);
/*      */               }  break;
/*      */             case 29:
/*  987 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/*  989 */                 if (paramInt1 > 52)
/*  990 */                   paramInt1 = 52; 
/*  991 */                 g(29, 22);
/*      */               }  break;
/*      */             case 30:
/*  994 */               if (this.m == '.')
/*  995 */                 a(31); 
/*      */               break;
/*      */             case 31:
/*  998 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1000 */                 if (paramInt1 > 52)
/* 1001 */                   paramInt1 = 52; 
/* 1002 */                 g(31, 32);
/*      */               }  break;
/*      */             case 33:
/* 1005 */               if ((0x280000000000L & l) != 0L)
/* 1006 */                 a(34); 
/*      */               break;
/*      */             case 34:
/* 1009 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1011 */                 if (paramInt1 > 52)
/* 1012 */                   paramInt1 = 52; 
/* 1013 */                 a(34);
/*      */               }  break;
/*      */             case 35:
/* 1016 */               if (this.m == '"')
/* 1017 */                 h(7, 9); 
/*      */               break;
/*      */             case 36:
/* 1020 */               if ((0xFFFFFFFBFFFFFFFFL & l) != 0L)
/* 1021 */                 h(7, 9); 
/*      */               break;
/*      */             case 37:
/* 1024 */               if (this.m == '"' && paramInt1 > 61)
/* 1025 */                 paramInt1 = 61; 
/*      */               break;
/*      */             case 39:
/* 1028 */               h(7, 9);
/*      */               break;
/*      */             case 41:
/* 1031 */               if ((0x3FF000000000000L & l) != 0L)
/* 1032 */                 this.i[this.p++] = 42; 
/*      */               break;
/*      */             case 42:
/* 1035 */               if ((0x3FF000000000000L & l) != 0L)
/* 1036 */                 this.i[this.p++] = 43; 
/*      */               break;
/*      */             case 43:
/* 1039 */               if ((0x3FF000000000000L & l) != 0L)
/* 1040 */                 this.i[this.p++] = 44; 
/*      */               break;
/*      */             case 44:
/*      */             case 47:
/* 1044 */               if ((0x3FF000000000000L & l) != 0L)
/* 1045 */                 h(7, 9); 
/*      */               break;
/*      */             case 45:
/* 1048 */               if ((0x3FF000000000000L & l) != 0L)
/* 1049 */                 h(14, 17); 
/*      */               break;
/*      */             case 46:
/* 1052 */               if ((0x3FF000000000000L & l) != 0L)
/* 1053 */                 h(18, 21); 
/*      */               break;
/*      */             case 48:
/* 1056 */               if (this.m == '\'')
/* 1057 */                 h(4, 6); 
/*      */               break;
/*      */             case 49:
/* 1060 */               if ((0xFFFFFF7FFFFFFFFFL & l) != 0L)
/* 1061 */                 h(4, 6); 
/*      */               break;
/*      */             case 50:
/* 1064 */               if (this.m == '\'' && paramInt1 > 62)
/* 1065 */                 paramInt1 = 62; 
/*      */               break;
/*      */             case 52:
/* 1068 */               h(4, 6);
/*      */               break;
/*      */             case 54:
/* 1071 */               if ((0x3FF000000000000L & l) != 0L)
/* 1072 */                 this.i[this.p++] = 55; 
/*      */               break;
/*      */             case 55:
/* 1075 */               if ((0x3FF000000000000L & l) != 0L)
/* 1076 */                 this.i[this.p++] = 56; 
/*      */               break;
/*      */             case 56:
/* 1079 */               if ((0x3FF000000000000L & l) != 0L)
/* 1080 */                 this.i[this.p++] = 57; 
/*      */               break;
/*      */             case 57:
/*      */             case 60:
/* 1084 */               if ((0x3FF000000000000L & l) != 0L)
/* 1085 */                 h(4, 6); 
/*      */               break;
/*      */             case 58:
/* 1088 */               if ((0x3FF000000000000L & l) != 0L)
/* 1089 */                 h(22, 25); 
/*      */               break;
/*      */             case 59:
/* 1092 */               if ((0x3FF000000000000L & l) != 0L)
/* 1093 */                 h(26, 29); 
/*      */               break;
/*      */             case 61:
/* 1096 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1098 */                 if (paramInt1 > 52)
/* 1099 */                   paramInt1 = 52; 
/* 1100 */                 h(0, 3);
/*      */               }  break;
/*      */             case 62:
/* 1103 */               if ((0x3FF000000000000L & l) != 0L)
/* 1104 */                 g(62, 63); 
/*      */               break;
/*      */             case 63:
/* 1107 */               if (this.m == '.') {
/*      */                 
/* 1109 */                 if (paramInt1 > 52)
/* 1110 */                   paramInt1 = 52; 
/* 1111 */                 g(64, 32);
/*      */               }  break;
/*      */             case 64:
/* 1114 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1116 */                 if (paramInt1 > 52)
/* 1117 */                   paramInt1 = 52; 
/* 1118 */                 g(64, 32);
/*      */               }  break;
/*      */             case 65:
/* 1121 */               if ((0x3FF000000000000L & l) != 0L) {
/*      */                 
/* 1123 */                 if (paramInt1 > 52)
/* 1124 */                   paramInt1 = 52; 
/* 1125 */                 g(65, 32);
/*      */               } 
/*      */               break;
/*      */           } 
/* 1129 */         } while (j != i);
/*      */       }
/* 1131 */       else if (this.m < '') {
/*      */         
/* 1133 */         long l = 1L << (this.m & 0x3F);
/*      */         
/*      */         do {
/* 1136 */           switch (this.i[--j]) {
/*      */             
/*      */             case 8:
/* 1139 */               if ((0x7FFFFFE87FFFFFEL & l) != 0L) {
/*      */                 
/* 1141 */                 if (paramInt1 > 51)
/* 1142 */                   paramInt1 = 51; 
/* 1143 */                 a(17); break;
/*      */               } 
/* 1145 */               if (this.m == '[')
/* 1146 */                 this.i[this.p++] = 14; 
/*      */               break;
/*      */             case 2:
/* 1149 */               if (this.m == '[' && paramInt1 > 10)
/* 1150 */                 paramInt1 = 10; 
/*      */               break;
/*      */             case 6:
/* 1153 */               if (this.m == '[')
/* 1154 */                 this.i[this.p++] = 5; 
/*      */               break;
/*      */             case 11:
/* 1157 */               if (this.m == '[' && paramInt1 > 15)
/* 1158 */                 paramInt1 = 15; 
/*      */               break;
/*      */             case 15:
/* 1161 */               if (this.m == '[')
/* 1162 */                 this.i[this.p++] = 14; 
/*      */               break;
/*      */             case 16:
/*      */             case 17:
/* 1166 */               if ((0x7FFFFFE87FFFFFEL & l) != 0L) {
/*      */                 
/* 1168 */                 if (paramInt1 > 51)
/* 1169 */                   paramInt1 = 51; 
/* 1170 */                 a(17);
/*      */               }  break;
/*      */             case 19:
/* 1173 */               if ((0x100000001000000L & l) != 0L)
/* 1174 */                 f(30, 31); 
/*      */               break;
/*      */             case 21:
/* 1177 */               if ((0x7E0000007EL & l) != 0L) {
/*      */                 
/* 1179 */                 if (paramInt1 > 52)
/* 1180 */                   paramInt1 = 52; 
/* 1181 */                 g(21, 22);
/*      */               }  break;
/*      */             case 22:
/* 1184 */               if ((0x1002000010020L & l) != 0L)
/* 1185 */                 f(32, 33); 
/*      */               break;
/*      */             case 25:
/* 1188 */               if ((0x7E0000007EL & l) != 0L) {
/*      */                 
/* 1190 */                 if (paramInt1 > 52)
/* 1191 */                   paramInt1 = 52; 
/* 1192 */                 h(10, 13);
/*      */               }  break;
/*      */             case 26:
/* 1195 */               if ((0x7E0000007EL & l) != 0L)
/* 1196 */                 g(26, 27); 
/*      */               break;
/*      */             case 28:
/* 1199 */               if ((0x7E0000007EL & l) != 0L) {
/*      */                 
/* 1201 */                 if (paramInt1 > 52)
/* 1202 */                   paramInt1 = 52; 
/* 1203 */                 g(28, 22);
/*      */               }  break;
/*      */             case 29:
/* 1206 */               if ((0x7E0000007EL & l) != 0L) {
/*      */                 
/* 1208 */                 if (paramInt1 > 52)
/* 1209 */                   paramInt1 = 52; 
/* 1210 */                 g(29, 22);
/*      */               }  break;
/*      */             case 32:
/* 1213 */               if ((0x2000000020L & l) != 0L)
/* 1214 */                 f(34, 35); 
/*      */               break;
/*      */             case 36:
/* 1217 */               if ((0xFFFFFFFFEFFFFFFFL & l) != 0L)
/* 1218 */                 h(7, 9); 
/*      */               break;
/*      */             case 38:
/* 1221 */               if (this.m == '\\')
/* 1222 */                 f(36, 38); 
/*      */               break;
/*      */             case 39:
/* 1225 */               h(7, 9);
/*      */               break;
/*      */             case 40:
/* 1228 */               if (this.m == 'u')
/* 1229 */                 this.i[this.p++] = 41; 
/*      */               break;
/*      */             case 41:
/* 1232 */               if ((0x7E0000007EL & l) != 0L)
/* 1233 */                 this.i[this.p++] = 42; 
/*      */               break;
/*      */             case 42:
/* 1236 */               if ((0x7E0000007EL & l) != 0L)
/* 1237 */                 this.i[this.p++] = 43; 
/*      */               break;
/*      */             case 43:
/* 1240 */               if ((0x7E0000007EL & l) != 0L)
/* 1241 */                 this.i[this.p++] = 44; 
/*      */               break;
/*      */             case 44:
/* 1244 */               if ((0x7E0000007EL & l) != 0L)
/* 1245 */                 h(7, 9); 
/*      */               break;
/*      */             case 49:
/* 1248 */               if ((0xFFFFFFFFEFFFFFFFL & l) != 0L)
/* 1249 */                 h(4, 6); 
/*      */               break;
/*      */             case 51:
/* 1252 */               if (this.m == '\\')
/* 1253 */                 f(39, 41); 
/*      */               break;
/*      */             case 52:
/* 1256 */               h(4, 6);
/*      */               break;
/*      */             case 53:
/* 1259 */               if (this.m == 'u')
/* 1260 */                 this.i[this.p++] = 54; 
/*      */               break;
/*      */             case 54:
/* 1263 */               if ((0x7E0000007EL & l) != 0L)
/* 1264 */                 this.i[this.p++] = 55; 
/*      */               break;
/*      */             case 55:
/* 1267 */               if ((0x7E0000007EL & l) != 0L)
/* 1268 */                 this.i[this.p++] = 56; 
/*      */               break;
/*      */             case 56:
/* 1271 */               if ((0x7E0000007EL & l) != 0L)
/* 1272 */                 this.i[this.p++] = 57; 
/*      */               break;
/*      */             case 57:
/* 1275 */               if ((0x7E0000007EL & l) != 0L) {
/* 1276 */                 h(4, 6);
/*      */               }
/*      */               break;
/*      */           } 
/* 1280 */         } while (j != i);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1285 */         int m, n = (m = this.m >> 8) >> 6;
/* 1286 */         long l1 = 1L << (m & 0x3F);
/* 1287 */         int k = (this.m & 0xFF) >> 6;
/* 1288 */         long l2 = 1L << (this.m & 0x3F);
/*      */         
/*      */         do {
/* 1291 */           switch (this.i[--j]) {
/*      */             
/*      */             case 36:
/*      */             case 39:
/* 1295 */               if (a(m, n, k, l1, l2))
/* 1296 */                 h(7, 9); 
/*      */               break;
/*      */             case 49:
/*      */             case 52:
/* 1300 */               if (a(m, n, k, l1, l2)) {
/* 1301 */                 h(4, 6);
/*      */               }
/*      */               break;
/*      */           } 
/* 1305 */         } while (j != i);
/*      */       } 
/* 1307 */       if (paramInt1 != Integer.MAX_VALUE) {
/*      */         
/* 1309 */         this.s = paramInt1;
/* 1310 */         this.r = paramInt2;
/* 1311 */         paramInt1 = Integer.MAX_VALUE;
/*      */       } 
/* 1313 */       paramInt2++;
/* 1314 */       if ((j = this.p) == (i = 66 - (this.p = i)))
/* 1315 */         return paramInt2;  
/* 1316 */       try { this.m = this.g.readChar(); }
/* 1317 */       catch (IOException iOException) { return paramInt2; }
/*      */     
/*      */     } 
/*      */   }
/*      */   private int h() {
/* 1322 */     return d(4, 0);
/*      */   }
/*      */   
/*      */   private int d(int paramInt1, int paramInt2) {
/* 1326 */     paramInt1 = 0;
/* 1327 */     this.p = 4;
/* 1328 */     int i = 1;
/* 1329 */     this.i[0] = 4;
/* 1330 */     int j = Integer.MAX_VALUE;
/*      */     
/*      */     while (true) {
/* 1333 */       if (++this.q == Integer.MAX_VALUE)
/* 1334 */         m(); 
/* 1335 */       if (this.m < '@') {
/*      */         
/* 1337 */         long l = 1L << this.m;
/*      */         
/*      */         do {
/* 1340 */           switch (this.i[--i]) {
/*      */             
/*      */             case 4:
/* 1343 */               if ((0xFFFFFFFFFFFFDBFFL & l) != 0L) {
/*      */                 
/* 1345 */                 if (j > 17)
/* 1346 */                   j = 17; 
/* 1347 */                 h(42, 44);
/*      */               }
/* 1349 */               else if ((0x2400L & l) != 0L) {
/*      */                 
/* 1351 */                 if (j > 17)
/* 1352 */                   j = 17; 
/*      */               } 
/* 1354 */               if (this.m == '\r')
/* 1355 */                 this.i[this.p++] = 2; 
/*      */               break;
/*      */             case 0:
/* 1358 */               if ((0xFFFFFFFFFFFFDBFFL & l) != 0L) {
/*      */                 
/* 1360 */                 j = 17;
/* 1361 */                 h(42, 44);
/*      */               }  break;
/*      */             case 1:
/* 1364 */               if ((0x2400L & l) != 0L && j > 17)
/* 1365 */                 j = 17; 
/*      */               break;
/*      */             case 2:
/* 1368 */               if (this.m == '\n' && j > 17)
/* 1369 */                 j = 17; 
/*      */               break;
/*      */             case 3:
/* 1372 */               if (this.m == '\r') {
/* 1373 */                 this.i[this.p++] = 2;
/*      */               }
/*      */               break;
/*      */           } 
/* 1377 */         } while (i != paramInt1);
/*      */       }
/* 1379 */       else if (this.m < '') {
/*      */ 
/*      */         
/*      */         do {
/*      */           
/* 1384 */           switch (this.i[--i]) {
/*      */             
/*      */             case 0:
/*      */             case 4:
/* 1388 */               j = 17;
/* 1389 */               h(42, 44);
/*      */               break;
/*      */           } 
/*      */         
/* 1393 */         } while (i != paramInt1);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1398 */         int m, n = (m = this.m >> 8) >> 6;
/* 1399 */         long l1 = 1L << (m & 0x3F);
/* 1400 */         int k = (this.m & 0xFF) >> 6;
/* 1401 */         long l2 = 1L << (this.m & 0x3F);
/*      */         
/*      */         do {
/* 1404 */           switch (this.i[--i]) {
/*      */             
/*      */             case 0:
/*      */             case 4:
/* 1408 */               if (a(m, n, k, l1, l2)) {
/*      */                 
/* 1410 */                 if (j > 17)
/* 1411 */                   j = 17; 
/* 1412 */                 h(42, 44);
/*      */               } 
/*      */               break;
/*      */           } 
/* 1416 */         } while (i != paramInt1);
/*      */       } 
/* 1418 */       if (j != Integer.MAX_VALUE) {
/*      */         
/* 1420 */         this.s = j;
/* 1421 */         this.r = paramInt2;
/* 1422 */         j = Integer.MAX_VALUE;
/*      */       } 
/* 1424 */       paramInt2++;
/* 1425 */       if ((i = this.p) == (paramInt1 = 4 - (this.p = paramInt1)))
/* 1426 */         return paramInt2;  
/* 1427 */       try { this.m = this.g.readChar(); }
/* 1428 */       catch (IOException iOException) { return paramInt2; }
/*      */     
/*      */     } 
/*      */   }
/*      */   private int i() {
/* 1433 */     return e(6, 0);
/*      */   }
/*      */   
/*      */   private int e(int paramInt1, int paramInt2) {
/* 1437 */     paramInt1 = 0;
/* 1438 */     this.p = 7;
/* 1439 */     int i = 1;
/* 1440 */     this.i[0] = 6;
/* 1441 */     int j = Integer.MAX_VALUE;
/*      */     
/*      */     while (true) {
/* 1444 */       if (++this.q == Integer.MAX_VALUE)
/* 1445 */         m(); 
/* 1446 */       if (this.m < '@') {
/*      */ 
/*      */         
/*      */         do {
/*      */           
/* 1451 */           switch (this.i[--i]) {
/*      */             
/*      */             case 0:
/*      */             case 1:
/* 1455 */               if (this.m == '=')
/* 1456 */                 g(1, 2); 
/*      */               break;
/*      */             case 3:
/* 1459 */               if (this.m == '=')
/* 1460 */                 this.i[this.p++] = 0; 
/*      */               break;
/*      */             case 4:
/* 1463 */               if (this.m == '=')
/* 1464 */                 this.i[this.p++] = 3; 
/*      */               break;
/*      */             case 5:
/* 1467 */               if (this.m == '=') {
/* 1468 */                 this.i[this.p++] = 4;
/*      */               }
/*      */               break;
/*      */           } 
/* 1472 */         } while (i != paramInt1);
/*      */       }
/* 1474 */       else if (this.m < '') {
/*      */ 
/*      */         
/*      */         do {
/*      */           
/* 1479 */           switch (this.i[--i]) {
/*      */             
/*      */             case 2:
/* 1482 */               if (this.m == ']' && j > 22)
/* 1483 */                 j = 22; 
/*      */               break;
/*      */             case 6:
/* 1486 */               if (this.m == ']') {
/* 1487 */                 this.i[this.p++] = 5;
/*      */               }
/*      */               break;
/*      */           } 
/* 1491 */         } while (i != paramInt1);
/*      */       } 
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
/* 1508 */       if (j != Integer.MAX_VALUE) {
/*      */         
/* 1510 */         this.s = j;
/* 1511 */         this.r = paramInt2;
/* 1512 */         j = Integer.MAX_VALUE;
/*      */       } 
/* 1514 */       paramInt2++;
/* 1515 */       if ((i = this.p) == (paramInt1 = 7 - (this.p = paramInt1)))
/* 1516 */         return paramInt2;  
/* 1517 */       try { this.m = this.g.readChar(); }
/* 1518 */       catch (IOException iOException) { return paramInt2; }
/*      */     
/*      */     } 
/*      */   }
/*      */   private int j() {
/* 1523 */     switch (this.m) {
/*      */       
/*      */       case ']':
/* 1526 */         return f(2097152L);
/*      */     } 
/* 1528 */     return 1;
/*      */   }
/*      */   
/*      */   private int f(long paramLong) {
/*      */     try {
/* 1533 */       this.m = this.g.readChar();
/* 1534 */     } catch (IOException iOException) {
/* 1535 */       return 1;
/*      */     } 
/* 1537 */     switch (this.m) {
/*      */       
/*      */       case '=':
/* 1540 */         return l(2097152L, 2097152L);
/*      */     } 
/* 1542 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int l(long paramLong1, long paramLong2) {
/* 1547 */     if ((paramLong2 = 0x200000L & paramLong1) == 0L)
/* 1548 */       return 2;  try {
/* 1549 */       this.m = this.g.readChar();
/* 1550 */     } catch (IOException iOException) {
/* 1551 */       return 2;
/*      */     } 
/* 1553 */     switch (this.m) {
/*      */       
/*      */       case '=':
/* 1556 */         return m(paramLong2, 2097152L);
/*      */     } 
/* 1558 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   private int m(long paramLong1, long paramLong2) {
/* 1563 */     if ((paramLong2 = 0x200000L & paramLong1) == 0L)
/* 1564 */       return 3;  try {
/* 1565 */       this.m = this.g.readChar();
/* 1566 */     } catch (IOException iOException) {
/* 1567 */       return 3;
/*      */     } 
/* 1569 */     switch (this.m) {
/*      */       
/*      */       case '=':
/* 1572 */         return n(paramLong2, 2097152L);
/*      */     } 
/* 1574 */     return 4;
/*      */   }
/*      */ 
/*      */   
/*      */   private int n(long paramLong1, long paramLong2) {
/* 1579 */     if ((paramLong2 = 0x200000L & paramLong1) == 0L)
/* 1580 */       return 4;  try {
/* 1581 */       this.m = this.g.readChar();
/* 1582 */     } catch (IOException iOException) {
/* 1583 */       return 4;
/*      */     } 
/* 1585 */     switch (this.m) {
/*      */       
/*      */       case ']':
/* 1588 */         if ((paramLong2 & 0x200000L) != 0L) {
/* 1589 */           return a(4, 21);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1594 */         return 5;
/*      */     } 
/*      */     return 5;
/*      */   } private int k() {
/* 1598 */     switch (this.m) {
/*      */       
/*      */       case ']':
/* 1601 */         return g(1048576L);
/*      */     } 
/* 1603 */     return 1;
/*      */   }
/*      */   
/*      */   private int g(long paramLong) {
/*      */     try {
/* 1608 */       this.m = this.g.readChar();
/* 1609 */     } catch (IOException iOException) {
/* 1610 */       return 1;
/*      */     } 
/* 1612 */     switch (this.m) {
/*      */       
/*      */       case '=':
/* 1615 */         return o(1048576L, 1048576L);
/*      */     } 
/* 1617 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int o(long paramLong1, long paramLong2) {
/* 1622 */     if ((paramLong2 = 0x100000L & paramLong1) == 0L)
/* 1623 */       return 2;  try {
/* 1624 */       this.m = this.g.readChar();
/* 1625 */     } catch (IOException iOException) {
/* 1626 */       return 2;
/*      */     } 
/* 1628 */     switch (this.m) {
/*      */       
/*      */       case '=':
/* 1631 */         return p(paramLong2, 1048576L);
/*      */     } 
/* 1633 */     return 3;
/*      */   }
/*      */ 
/*      */   
/*      */   private int p(long paramLong1, long paramLong2) {
/* 1638 */     if ((paramLong2 = 0x100000L & paramLong1) == 0L)
/* 1639 */       return 3;  try {
/* 1640 */       this.m = this.g.readChar();
/* 1641 */     } catch (IOException iOException) {
/* 1642 */       return 3;
/*      */     } 
/* 1644 */     switch (this.m) {
/*      */       
/*      */       case ']':
/* 1647 */         if ((paramLong2 & 0x100000L) != 0L) {
/* 1648 */           return a(3, 20);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1653 */         return 4;
/*      */     } 
/*      */     return 4;
/*      */   } private int l() {
/* 1657 */     switch (this.m) {
/*      */       
/*      */       case ']':
/* 1660 */         return h(524288L);
/*      */     } 
/* 1662 */     return 1;
/*      */   }
/*      */   
/*      */   private int h(long paramLong) {
/*      */     try {
/* 1667 */       this.m = this.g.readChar();
/* 1668 */     } catch (IOException iOException) {
/* 1669 */       return 1;
/*      */     } 
/* 1671 */     switch (this.m) {
/*      */       
/*      */       case '=':
/* 1674 */         return q(524288L, 524288L);
/*      */     } 
/* 1676 */     return 2;
/*      */   }
/*      */ 
/*      */   
/*      */   private int q(long paramLong1, long paramLong2) {
/* 1681 */     if ((paramLong2 = 0x80000L & paramLong1) == 0L)
/* 1682 */       return 2;  try {
/* 1683 */       this.m = this.g.readChar();
/* 1684 */     } catch (IOException iOException) {
/* 1685 */       return 2;
/*      */     } 
/* 1687 */     switch (this.m) {
/*      */       
/*      */       case ']':
/* 1690 */         if ((paramLong2 & 0x80000L) != 0L) {
/* 1691 */           return a(2, 19);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1696 */         return 3;
/*      */     } 
/* 1698 */     return 3; } private static int[] c = new int[] { 62, 63, 65, 32, 49, 50, 51, 36, 37, 38, 26, 27, 29, 22, 36, 37, 38, 46, 36, 47, 37, 38, 49, 50, 51, 59, 49, 60, 50, 51, 20, 25, 23, 24, 33, 34, 39, 40, 45, 52, 53, 58, 0, 1, 3 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final boolean a(int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
/* 1705 */     switch (paramInt1) {
/*      */       
/*      */       case 0:
/* 1708 */         return ((b[paramInt3] & paramLong2) != 0L);
/*      */     } 
/* 1710 */     if ((a[paramInt2] & paramLong1) != 0L)
/* 1711 */       return true; 
/* 1712 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/* 1717 */   public static final String[] jjstrLiteralImages = new String[] { "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "return", "repeat", "then", "true", "until", "while", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "::", null, null, null, "#", ";", "=", ",", ".", ":", "(", ")", "[", "]", "...", "{", "}", "+", "-", "*", "/", "^", "%", "..", "<", "<=", ">", ">=", "==", "~=" };
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
/* 1731 */   public static final String[] lexStateNames = new String[] { "DEFAULT", "IN_COMMENT", "IN_LC0", "IN_LC1", "IN_LC2", "IN_LC3", "IN_LCN", "IN_LS0", "IN_LS1", "IN_LS2", "IN_LS3", "IN_LSN" };
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
/* 1747 */   public static final int[] jjnewLexState = new int[] { -1, -1, -1, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 1753 */   private static long[] d = new long[] { 6926536226618998785L, 2147483618L };
/*      */ 
/*      */   
/* 1756 */   private static long[] e = new long[] { 8257598L, 0L };
/*      */ 
/*      */   
/* 1759 */   private static long[] f = new long[] { 8257536L, 0L };
/*      */ 
/*      */ 
/*      */   
/*      */   private SimpleCharStream g;
/*      */ 
/*      */   
/* 1766 */   private final int[] h = new int[66];
/* 1767 */   private final int[] i = new int[132];
/* 1768 */   private final StringBuffer j = new StringBuffer();
/* 1769 */   private StringBuffer k = this.j;
/*      */   
/*      */   private int l;
/*      */   
/*      */   private char m;
/*      */   private int n;
/*      */   private int o;
/*      */   private int p;
/*      */   private int q;
/*      */   private int r;
/*      */   private int s;
/*      */   
/*      */   public LuaParserTokenManager(SimpleCharStream paramSimpleCharStream, int paramInt) {
/* 1782 */     this(paramSimpleCharStream);
/* 1783 */     SwitchTo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void ReInit(SimpleCharStream paramSimpleCharStream) {
/* 1789 */     this.r = this.p = 0;
/* 1790 */     this.n = 0;
/* 1791 */     this.g = paramSimpleCharStream;
/* 1792 */     m();
/*      */   }
/*      */ 
/*      */   
/*      */   private void m() {
/* 1797 */     this.q = -2147483647;
/* 1798 */     for (byte b = 66; b-- > 0;) {
/* 1799 */       this.h[b] = Integer.MIN_VALUE;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void ReInit(SimpleCharStream paramSimpleCharStream, int paramInt) {
/* 1805 */     ReInit(paramSimpleCharStream);
/* 1806 */     SwitchTo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void SwitchTo(int paramInt) {
/* 1812 */     if (paramInt >= 12 || paramInt < 0) {
/* 1813 */       throw new TokenMgrError("Error: Ignoring invalid lexical state : " + paramInt + ". State unchanged.", 2);
/*      */     }
/* 1815 */     this.n = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Token n() {
/*      */     String str;
/*      */     int i, j, k, m;
/* 1826 */     if (this.r < 0) {
/*      */       
/* 1828 */       if (this.k == null) {
/* 1829 */         str = "";
/*      */       } else {
/* 1831 */         str = this.k.toString();
/* 1832 */       }  i = j = this.g.getBeginLine();
/* 1833 */       k = m = this.g.getBeginColumn();
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1838 */       str = ((str = jjstrLiteralImages[this.s]) == null) ? this.g.GetImage() : str;
/* 1839 */       i = this.g.getBeginLine();
/* 1840 */       k = this.g.getBeginColumn();
/* 1841 */       j = this.g.getEndLine();
/* 1842 */       m = this.g.getEndColumn();
/*      */     } 
/*      */     
/*      */     Token token;
/* 1846 */     (token = Token.newToken(this.s, str)).beginLine = i;
/* 1847 */     token.endLine = j;
/* 1848 */     token.beginColumn = k;
/* 1849 */     token.endColumn = m;
/*      */     
/* 1851 */     return token;
/*      */   }
/*      */   public LuaParserTokenManager(SimpleCharStream paramSimpleCharStream) {
/* 1854 */     this.n = 0;
/* 1855 */     this.o = 0;
/*      */     this.g = paramSimpleCharStream;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Token getNextToken() {
/* 1864 */     Token token = null;
/*      */     
/* 1866 */     int k = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     label122: while (true) {
/*      */       try {
/* 1873 */         this.m = this.g.BeginToken();
/*      */       }
/* 1875 */       catch (IOException iOException) {
/*      */         
/* 1877 */         this.s = 0;
/*      */         Token token1;
/* 1879 */         (token1 = n()).specialToken = token;
/* 1880 */         return token1;
/*      */       } 
/* 1882 */       this.k = this.j;
/* 1883 */       this.k.setLength(0);
/* 1884 */       this.l = 0;
/*      */ 
/*      */       
/*      */       while (true) {
/* 1888 */         switch (this.n) {
/*      */           case 0:
/*      */             
/* 1891 */             try { this.g.backup(0);
/* 1892 */               while (this.m <= ' ' && (0x100003600L & 1L << this.m) != 0L) {
/* 1893 */                 this.m = this.g.BeginToken();
/*      */               } }
/* 1895 */             catch (IOException iOException) { continue label122; }
/* 1896 */              this.s = Integer.MAX_VALUE;
/* 1897 */             this.r = 0;
/* 1898 */             k = g();
/*      */             break;
/*      */           case 1:
/* 1901 */             this.s = 17;
/* 1902 */             this.r = -1;
/*      */             
/* 1904 */             k = h();
/*      */             break;
/*      */           case 2:
/* 1907 */             this.s = Integer.MAX_VALUE;
/* 1908 */             this.r = 0;
/* 1909 */             k = a();
/* 1910 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1912 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 3:
/* 1916 */             this.s = Integer.MAX_VALUE;
/* 1917 */             this.r = 0;
/* 1918 */             k = l();
/* 1919 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1921 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 4:
/* 1925 */             this.s = Integer.MAX_VALUE;
/* 1926 */             this.r = 0;
/* 1927 */             k = k();
/* 1928 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1930 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 5:
/* 1934 */             this.s = Integer.MAX_VALUE;
/* 1935 */             this.r = 0;
/* 1936 */             k = j();
/* 1937 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1939 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 6:
/* 1943 */             this.s = Integer.MAX_VALUE;
/* 1944 */             this.r = 0;
/* 1945 */             k = i();
/* 1946 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1948 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 7:
/* 1952 */             this.s = Integer.MAX_VALUE;
/* 1953 */             this.r = 0;
/* 1954 */             k = f();
/* 1955 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1957 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 8:
/* 1961 */             this.s = Integer.MAX_VALUE;
/* 1962 */             this.r = 0;
/* 1963 */             k = e();
/* 1964 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1966 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 9:
/* 1970 */             this.s = Integer.MAX_VALUE;
/* 1971 */             this.r = 0;
/* 1972 */             k = d();
/* 1973 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1975 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 10:
/* 1979 */             this.s = Integer.MAX_VALUE;
/* 1980 */             this.r = 0;
/* 1981 */             k = c();
/* 1982 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1984 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */           case 11:
/* 1988 */             this.s = Integer.MAX_VALUE;
/* 1989 */             this.r = 0;
/* 1990 */             k = b();
/* 1991 */             if (this.r == 0 && this.s > 28)
/*      */             {
/* 1993 */               this.s = 28;
/*      */             }
/*      */             break;
/*      */         } 
/* 1997 */         if (this.s != Integer.MAX_VALUE)
/*      */         
/* 1999 */         { if (this.r + 1 < k)
/* 2000 */             this.g.backup(k - this.r - 1); 
/* 2001 */           if ((d[this.s >> 6] & 1L << (this.s & 0x3F)) != 0L) {
/*      */             Token token1;
/*      */             
/* 2004 */             (token1 = n()).specialToken = token;
/* 2005 */             if (jjnewLexState[this.s] != -1)
/* 2006 */               this.n = jjnewLexState[this.s]; 
/* 2007 */             return token1;
/*      */           } 
/* 2009 */           if ((e[this.s >> 6] & 1L << (this.s & 0x3F)) != 0L) {
/*      */             
/* 2011 */             if ((f[this.s >> 6] & 1L << (this.s & 0x3F)) != 0L) {
/*      */               
/* 2013 */               Token token1 = n();
/* 2014 */               if (token == null) {
/* 2015 */                 token = token1;
/*      */               } else {
/*      */                 
/* 2018 */                 token1.specialToken = token;
/* 2019 */                 token = token.next = token1;
/*      */               } 
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/* 2025 */             if (jjnewLexState[this.s] != -1) {
/* 2026 */               this.n = jjnewLexState[this.s]; continue label122;
/*      */             }  continue label122;
/*      */           } 
/* 2029 */           this.l += this.r + 1;
/* 2030 */           if (jjnewLexState[this.s] != -1)
/* 2031 */             this.n = jjnewLexState[this.s]; 
/* 2032 */           k = 0;
/* 2033 */           this.s = Integer.MAX_VALUE;
/*      */           
/* 2035 */           try { this.m = this.g.readChar();
/*      */             
/*      */             continue; }
/* 2038 */           catch (IOException iOException) { break; }  }  break;
/*      */       }  break;
/* 2040 */     }  int i = this.g.getEndLine();
/* 2041 */     int j = this.g.getEndColumn();
/* 2042 */     String str = null;
/* 2043 */     boolean bool = false; try {
/* 2044 */       this.g.readChar(); this.g.backup(1);
/* 2045 */     } catch (IOException iOException) {
/* 2046 */       bool = true;
/* 2047 */       str = (k <= 1) ? "" : this.g.GetImage();
/* 2048 */       if (this.m == '\n' || this.m == '\r') {
/* 2049 */         i++;
/* 2050 */         j = 0;
/*      */       } else {
/*      */         
/* 2053 */         j++;
/*      */       } 
/* 2055 */     }  if (!bool) {
/* 2056 */       this.g.backup(1);
/* 2057 */       str = (k <= 1) ? "" : this.g.GetImage();
/*      */     } 
/* 2059 */     throw new TokenMgrError(bool, this.n, i, j, str, this.m, 0);
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
/*      */   private void a(int paramInt) {
/* 2074 */     if (this.h[paramInt] != this.q) {
/*      */       
/* 2076 */       this.i[this.p++] = paramInt;
/* 2077 */       this.h[paramInt] = this.q;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void f(int paramInt1, int paramInt2) {
/*      */     do {
/* 2083 */       this.i[this.p++] = c[paramInt1];
/* 2084 */     } while (paramInt1++ != paramInt2);
/*      */   }
/*      */   
/*      */   private void g(int paramInt1, int paramInt2) {
/* 2088 */     a(paramInt1);
/* 2089 */     a(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   private void h(int paramInt1, int paramInt2) {
/*      */     do {
/* 2095 */       a(c[paramInt1]);
/* 2096 */     } while (paramInt1++ != paramInt2);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\parser\LuaParserTokenManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */