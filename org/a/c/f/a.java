/*      */ package org.a.c.f;
/*      */ 
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.charset.CharacterCodingException;
/*      */ import java.nio.charset.CharsetDecoder;
/*      */ import org.a.a.a.c;
/*      */ import org.a.c.b.b;
/*      */ import org.a.c.b.c;
/*      */ import org.a.c.b.d;
/*      */ import org.a.c.b.e;
/*      */ import org.a.c.b.i;
/*      */ import org.a.c.b.j;
/*      */ import org.a.c.b.k;
/*      */ import org.a.c.b.l;
/*      */ import org.a.c.b.m;
/*      */ import org.a.c.b.n;
/*      */ import org.a.c.b.s;
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
/*      */ public abstract class a
/*      */ {
/*   55 */   private static int c = Long.toString(Long.MAX_VALUE).length();
/*      */   
/*   57 */   private final CharsetDecoder d = org.a.c.i.a.f.newDecoder();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   62 */   private static final org.a.a.a.a e = c.a(a.class);
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
/*      */   protected final k a;
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
/*      */   protected e b;
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
/*      */   public a(k paramk) {
/*  134 */     this.a = paramk;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean a(char paramChar) {
/*  139 */     return (d(paramChar) || (paramChar >= 'a' && paramChar <= 'f') || (paramChar >= 'A' && paramChar <= 'F'));
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
/*      */   private b p() {
/*  153 */     long l1 = this.a.b();
/*  154 */     b b1 = f();
/*  155 */     l();
/*      */     
/*  157 */     if (!(b1 instanceof l) || !k())
/*      */     {
/*  159 */       return b1;
/*      */     }
/*      */     
/*  162 */     long l2 = this.a.b();
/*  163 */     b b2 = f();
/*  164 */     l();
/*  165 */     b('R');
/*  166 */     if (!(b1 instanceof i)) {
/*      */       
/*  168 */       (new StringBuilder("expected number, actual=")).append(b1).append(" at offset ").append(l1);
/*  169 */       return (b)k.a;
/*      */     } 
/*  171 */     if (!(b2 instanceof i)) {
/*      */       
/*  173 */       (new StringBuilder("expected number, actual=")).append(b1).append(" at offset ").append(l2);
/*  174 */       return (b)k.a;
/*      */     } 
/*      */     
/*  177 */     n n = new n(((i)b1).b(), ((i)b2).c());
/*      */     
/*  179 */     return a(n);
/*      */   }
/*      */ 
/*      */   
/*      */   private b a(n paramn) {
/*  184 */     if (this.b == null)
/*      */     {
/*  186 */       throw new IOException("object reference " + paramn + " at offset " + this.a.b() + " in content stream");
/*      */     }
/*      */     
/*  189 */     return (b)this.b.a(paramn);
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
/*      */   protected final d a() {
/*  201 */     b('<');
/*  202 */     b('<');
/*  203 */     l();
/*  204 */     d d = new d();
/*  205 */     boolean bool = false;
/*  206 */     while (!bool) {
/*      */       
/*  208 */       l();
/*      */       char c;
/*  210 */       if ((c = (char)this.a.c()) == '>') {
/*      */         
/*  212 */         bool = true; continue;
/*      */       } 
/*  214 */       if (c == '/') {
/*      */         
/*  216 */         a(d);
/*      */         
/*      */         continue;
/*      */       } 
/*      */       
/*  221 */       (new StringBuilder("Invalid dictionary, found: '")).append(c).append("' but expected: '/' at offset ").append(this.a.b());
/*  222 */       if (q())
/*      */       {
/*      */         
/*  225 */         return d;
/*      */       }
/*      */     } 
/*      */     
/*  229 */     b('>');
/*  230 */     b('>');
/*  231 */     return d;
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
/*      */   private boolean q() {
/*  245 */     int i = this.a.a();
/*  246 */     while (i != -1 && i != 47 && i != 62) {
/*      */ 
/*      */ 
/*      */       
/*  250 */       if (i == 101)
/*      */       {
/*      */         
/*  253 */         if ((i = this.a.a()) == 110)
/*      */         {
/*      */           
/*  256 */           if ((i = this.a.a()) == 100) {
/*      */             boolean bool;
/*      */ 
/*      */ 
/*      */             
/*  261 */             i = (!(bool = ((i = this.a.a()) == 115 && this.a.a() == 116 && this.a.a() == 114 && this.a.a() == 101 && this.a.a() == 97 && this.a.a() == 109) ? true : false) && i == 111 && this.a.a() == 98 && this.a.a() == 106) ? 1 : 0;
/*  262 */             if (bool || i != 0)
/*      */             {
/*      */               
/*  265 */               return true;
/*      */             }
/*      */           } 
/*      */         }
/*      */       }
/*  270 */       i = this.a.a();
/*      */     } 
/*  272 */     if (i == -1)
/*      */     {
/*  274 */       return true;
/*      */     }
/*  276 */     this.a.a(i);
/*  277 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(d paramd) {
/*  282 */     j j = e();
/*  283 */     b b = p();
/*  284 */     l();
/*  285 */     if ((char)this.a.c() == 'd') {
/*      */       String str;
/*      */ 
/*      */ 
/*      */       
/*  290 */       if (!(str = g()).equals("def")) {
/*      */         
/*  292 */         this.a.b(str.getBytes(org.a.c.i.a.d));
/*      */       }
/*      */       else {
/*      */         
/*  296 */         l();
/*      */       } 
/*      */     } 
/*      */     
/*  300 */     if (b == null) {
/*      */       
/*  302 */       (new StringBuilder("Bad dictionary declaration at offset ")).append(this.a.b());
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  307 */     b.a(true);
/*  308 */     paramd.a(j, b);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void b() {
/*  317 */     int i = this.a.a();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  322 */     while (32 == i)
/*      */     {
/*  324 */       i = this.a.a();
/*      */     }
/*      */     
/*  327 */     if (13 == i) {
/*      */       
/*  329 */       i = this.a.a();
/*  330 */       if (10 != i) {
/*      */         
/*  332 */         this.a.a(i);
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*  337 */     } else if (10 != i) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  342 */       this.a.a(i);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int e(int paramInt) {
/*  363 */     paramInt = paramInt;
/*  364 */     byte[] arrayOfByte = new byte[3];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */ 
/*      */     
/*  373 */     if ((i = this.a.a(arrayOfByte)) == 3 && arrayOfByte[0] == 13)
/*      */     {
/*  375 */       if ((arrayOfByte[1] == 10 && arrayOfByte[2] == 47) || arrayOfByte[2] == 62 || arrayOfByte[1] == 47 || arrayOfByte[1] == 62)
/*      */       {
/*      */         
/*  378 */         paramInt = 0;
/*      */       }
/*      */     }
/*  381 */     if (i > 0)
/*      */     {
/*  383 */       this.a.b(arrayOfByte, 0, i);
/*      */     }
/*  385 */     return paramInt;
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
/*      */   protected final s c() {
/*      */     char c;
/*  398 */     if ((c = (char)this.a.a()) == '<')
/*      */     {
/*  400 */       return r();
/*      */     }
/*  402 */     if (c != '(')
/*      */     {
/*  404 */       throw new IOException("parseCOSString string should start with '(' or '<' and not '" + c + "' at offset " + this.a
/*  405 */           .b());
/*      */     }
/*      */     
/*  408 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */ 
/*      */     
/*  411 */     int i = 1;
/*  412 */     int j = this.a.a();
/*  413 */     while (i && j != -1) {
/*      */       
/*  415 */       j = (char)j;
/*  416 */       int m = -2;
/*      */       
/*  418 */       if (j == 41) {
/*      */ 
/*      */         
/*  421 */         i--;
/*      */         
/*  423 */         if ((i = e(i)) != 0)
/*      */         {
/*  425 */           byteArrayOutputStream.write(j);
/*      */         }
/*      */       }
/*  428 */       else if (j == 40) {
/*      */         
/*  430 */         i++;
/*  431 */         byteArrayOutputStream.write(j);
/*      */       }
/*  433 */       else if (j == 92) {
/*      */         StringBuilder stringBuilder;
/*      */         
/*      */         char c1;
/*  437 */         switch (j = (char)this.a.a()) {
/*      */           
/*      */           case 110:
/*  440 */             byteArrayOutputStream.write(10);
/*      */             break;
/*      */           case 114:
/*  443 */             byteArrayOutputStream.write(13);
/*      */             break;
/*      */           case 116:
/*  446 */             byteArrayOutputStream.write(9);
/*      */             break;
/*      */           case 98:
/*  449 */             byteArrayOutputStream.write(8);
/*      */             break;
/*      */           case 102:
/*  452 */             byteArrayOutputStream.write(12);
/*      */             break;
/*      */ 
/*      */           
/*      */           case 41:
/*  457 */             if ((i = e(i)) != 0) {
/*      */               
/*  459 */               byteArrayOutputStream.write(j);
/*      */               
/*      */               break;
/*      */             } 
/*  463 */             byteArrayOutputStream.write(92);
/*      */             break;
/*      */           
/*      */           case 40:
/*      */           case 92:
/*  468 */             byteArrayOutputStream.write(j);
/*      */             break;
/*      */           case 10:
/*      */           case 13:
/*      */             do {
/*  473 */               j = this.a.a();
/*  474 */             } while (f(j) && j != -1);
/*      */ 
/*      */ 
/*      */             
/*  478 */             m = j;
/*      */             break;
/*      */ 
/*      */           
/*      */           case 48:
/*      */           case 49:
/*      */           case 50:
/*      */           case 51:
/*      */           case 52:
/*      */           case 53:
/*      */           case 54:
/*      */           case 55:
/*  490 */             (stringBuilder = new StringBuilder()).append(j);
/*      */ 
/*      */             
/*  493 */             if ((c1 = (char)(j = this.a.a())) >= '0' && c1 <= '7') {
/*      */               
/*  495 */               stringBuilder.append(c1);
/*      */ 
/*      */               
/*  498 */               if ((c1 = (char)(j = this.a.a())) >= '0' && c1 <= '7')
/*      */               {
/*  500 */                 stringBuilder.append(c1);
/*      */               }
/*      */               else
/*      */               {
/*  504 */                 m = j;
/*      */               }
/*      */             
/*      */             } else {
/*      */               
/*  509 */               m = j;
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*      */             try {
/*  515 */               j = Integer.parseInt(stringBuilder.toString(), 8);
/*      */             }
/*  517 */             catch (NumberFormatException numberFormatException) {
/*      */               
/*  519 */               throw new IOException("Error: Expected octal character, actual='" + stringBuilder + "'", numberFormatException);
/*      */             } 
/*  521 */             numberFormatException.write(j);
/*      */             break;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           default:
/*  528 */             numberFormatException.write(j);
/*      */             break;
/*      */         } 
/*      */ 
/*      */       
/*      */       } else {
/*  534 */         numberFormatException.write(j);
/*      */       } 
/*  536 */       if (m != -2) {
/*      */         
/*  538 */         j = m;
/*      */         
/*      */         continue;
/*      */       } 
/*  542 */       j = this.a.a();
/*      */     } 
/*      */     
/*  545 */     if (j != -1)
/*      */     {
/*  547 */       this.a.a(j);
/*      */     }
/*  549 */     return new s(numberFormatException.toByteArray());
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
/*      */   
/*      */   private s r() {
/*  566 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/*      */     while (true) {
/*      */       int i;
/*  570 */       while (a((char)(i = this.a.a())))
/*      */       {
/*  572 */         stringBuilder.append((char)i);
/*      */       }
/*  574 */       if (i != 62) {
/*      */ 
/*      */ 
/*      */         
/*  578 */         if (i < 0)
/*      */         {
/*  580 */           throw new IOException("Missing closing bracket for hex string. Reached EOS.");
/*      */         }
/*  582 */         if (i != 32 && i != 10 && i != 9 && i != 13 && i != 8 && i != 12) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  592 */           if (stringBuilder.length() % 2 != 0)
/*      */           {
/*  594 */             stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           do {
/*      */           
/*  602 */           } while ((i = this.a.a()) != 62 && i >= 0);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  607 */           if (i < 0)
/*      */           {
/*  609 */             throw new IOException("Missing closing bracket for hex string. Reached EOS."); } 
/*      */           break;
/*      */         } 
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  616 */     return s.a(stringBuilder.toString());
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
/*      */   protected final org.a.c.b.a d() {
/*  628 */     long l = this.a.b();
/*  629 */     b('[');
/*  630 */     org.a.c.b.a a1 = new org.a.c.b.a();
/*      */     
/*  632 */     l();
/*      */     int i;
/*  634 */     while ((i = this.a.c()) > 0 && (char)i != ']') {
/*      */       b b;
/*      */       
/*  637 */       if (b = f() instanceof m)
/*      */       {
/*      */         
/*  640 */         if (a1.b() > 0 && a1.b(a1.b() - 1) instanceof i) {
/*      */           
/*  642 */           i i1 = (i)a1.d(a1.b() - 1);
/*  643 */           if (a1.b() > 0 && a1.b(a1.b() - 1) instanceof i)
/*      */           {
/*  645 */             i i2 = (i)a1.d(a1.b() - 1);
/*  646 */             n n = new n(i2.b(), i1.c());
/*  647 */             b b1 = a(n);
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  652 */             i1 = null;
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/*  657 */           b = null;
/*      */         } 
/*      */       }
/*  660 */       if (b != null) {
/*      */         
/*  662 */         a1.a(b);
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  667 */         (new StringBuilder("Corrupt object reference at offset "))
/*  668 */           .append(this.a.b()).append(", start offset: ").append(l);
/*      */ 
/*      */ 
/*      */         
/*  672 */         String str = g();
/*  673 */         this.a.b(str.getBytes(org.a.c.i.a.d));
/*  674 */         if ("endobj".equals(str) || "endstream".equals(str))
/*      */         {
/*  676 */           return a1;
/*      */         }
/*      */       } 
/*  679 */       l();
/*      */     } 
/*      */     
/*  682 */     this.a.a();
/*  683 */     l();
/*  684 */     return a1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean a(int paramInt) {
/*  695 */     return (paramInt == 32 || paramInt == 13 || paramInt == 10 || paramInt == 9 || paramInt == 62 || paramInt == 60 || paramInt == 91 || paramInt == 47 || paramInt == 93 || paramInt == 41 || paramInt == 40 || paramInt == 0 || paramInt == 12);
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
/*      */   protected final j e() {
/*      */     String str;
/*  708 */     b('/');
/*  709 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  710 */     int i = this.a.a();
/*  711 */     while (i != -1) {
/*      */       int j;
/*      */       
/*  714 */       if ((j = i) == 35) {
/*      */         
/*  716 */         i = this.a.a();
/*  717 */         int n = this.a.a();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  724 */         if (a((char)i) && a((char)n)) {
/*      */           
/*  726 */           str = (char)i + (char)n;
/*      */           
/*      */           try {
/*  729 */             byteArrayOutputStream.write(Integer.parseInt(str, 16));
/*      */           }
/*  731 */           catch (NumberFormatException numberFormatException) {
/*      */             
/*  733 */             throw new IOException("Error: expected hex digit, actual='" + str + "'", numberFormatException);
/*      */           } 
/*  735 */           m = this.a.a();
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*  740 */         if (n == -1 || m == -1) {
/*      */ 
/*      */           
/*  743 */           m = -1;
/*      */           break;
/*      */         } 
/*  746 */         this.a.a(n);
/*  747 */         int m = m;
/*  748 */         numberFormatException.write(j);
/*      */         continue;
/*      */       } 
/*  751 */       if (!a(j)) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  757 */         numberFormatException.write(j);
/*  758 */         i = this.a.a();
/*      */       } 
/*      */     } 
/*  761 */     if (i != -1)
/*      */     {
/*  763 */       this.a.a(i);
/*      */     }
/*      */     
/*  766 */     byte[] arrayOfByte = numberFormatException.toByteArray();
/*      */     
/*  768 */     if (a(arrayOfByte)) {
/*      */       
/*  770 */       str = new String(numberFormatException.toByteArray(), org.a.c.i.a.f);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  775 */       str = new String(numberFormatException.toByteArray(), org.a.c.i.a.e);
/*      */     } 
/*  777 */     return j.a(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean a(byte[] paramArrayOfbyte) {
/*      */     try {
/*  787 */       this.d.decode(ByteBuffer.wrap(paramArrayOfbyte));
/*  788 */       return true;
/*      */     }
/*  790 */     catch (CharacterCodingException characterCodingException) {
/*      */       
/*  792 */       return false;
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
/*      */   protected final b f() {
/*      */     s s2;
/*      */     org.a.c.b.a a1;
/*      */     s s1;
/*      */     j j;
/*      */     k k1;
/*      */     c c;
/*      */     m m;
/*      */     int i, i1;
/*      */     String str;
/*  850 */     d d = null;
/*      */     
/*  852 */     l();
/*      */     
/*      */     int n;
/*  855 */     switch (n = (char)(n = this.a.c()))
/*      */     
/*      */     { 
/*      */       
/*      */       case 60:
/*  860 */         i1 = this.a.a();
/*      */         
/*  862 */         n = (char)this.a.c();
/*  863 */         this.a.a(i1);
/*  864 */         if (n == 60) {
/*      */ 
/*      */           
/*  867 */           d = a();
/*  868 */           l();
/*      */         }
/*      */         else {
/*      */           
/*  872 */           s2 = c();
/*      */         } 
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
/*  977 */         return (b)s2;case 91: return (b)d();case 40: return (b)c();case 47: return (b)e();case 110: a("null"); return (b)k.a;case 116: if ((str = new String(this.a.b(4), org.a.c.i.a.d)).equals("true")) { c = c.a; } else { throw new IOException("expected true actual='" + str + "' " + this.a + "' at offset " + this.a.b()); }  return (b)c;case 102: if ((str = new String(this.a.b(5), org.a.c.i.a.d)).equals("false")) { c = c.b; } else { throw new IOException("expected false actual='" + str + "' " + this.a + "' at offset " + this.a.b()); }  return (b)c;case 82: this.a.a(); return (b)new m(null);case 65535: return null; }  if (Character.isDigit(n) || n == 45 || n == 43 || n == 46) { StringBuilder stringBuilder = new StringBuilder(); int i2; n = (char)(i2 = this.a.a()); while (Character.isDigit(n) || n == 45 || n == 43 || n == 46 || n == 69 || n == 101) { stringBuilder.append(n); n = (char)(i2 = this.a.a()); }  if (i2 != -1) this.a.a(i2);  l l = l.a(stringBuilder.toString()); } else { if ((str = g()).isEmpty()) { i = this.a.c(); throw new IOException("Unknown dir object c='" + n + "' cInt=" + n + " peek='" + (char)i + "' peekInt=" + i + " at offset " + this.a.b()); }  if ("endobj".equals(str) || "endstream".equals(str)) this.a.b(str.getBytes(org.a.c.i.a.d));  }  return i;
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
/*      */   protected final String g() {
/*  989 */     l();
/*  990 */     StringBuilder stringBuilder = new StringBuilder();
/*  991 */     int i = this.a.a();
/*  992 */     while (!a((char)i) && i != -1) {
/*      */       
/*  994 */       stringBuilder.append((char)i);
/*  995 */       i = this.a.a();
/*      */     } 
/*  997 */     if (i != -1)
/*      */     {
/*  999 */       this.a.a(i);
/*      */     }
/* 1001 */     return stringBuilder.toString();
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
/*      */   private void a(String paramString) {
/* 1013 */     a(paramString.toCharArray());
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
/*      */   protected final void a(char[] paramArrayOfchar) {
/* 1025 */     l(); char[] arrayOfChar; int i; byte b;
/* 1026 */     for (i = (arrayOfChar = paramArrayOfchar).length, b = 0; b < i; ) { char c = arrayOfChar[b];
/*      */       
/* 1028 */       if (this.a.a() != c)
/*      */       {
/* 1030 */         throw new IOException("Expected string '" + new String(paramArrayOfchar) + "' but missed at character '" + c + "' at offset " + this.a
/*      */             
/* 1032 */             .b()); } 
/*      */       b++; }
/*      */     
/* 1035 */     l();
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
/*      */   private void b(char paramChar) {
/*      */     char c;
/* 1048 */     if ((c = (char)this.a.a()) != paramChar)
/*      */     {
/* 1050 */       throw new IOException("expected='" + paramChar + "' actual='" + c + "' at offset " + this.a.b());
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
/*      */   protected static boolean b(int paramInt) {
/* 1108 */     return (paramInt == 93);
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
/*      */   protected final String h() {
/* 1122 */     if (this.a.d())
/*      */     {
/* 1124 */       throw new IOException("Error: End-of-File, expected line");
/*      */     }
/*      */     
/* 1127 */     StringBuilder stringBuilder = new StringBuilder(11);
/*      */     
/*      */     int i;
/* 1130 */     while ((i = this.a.a()) != -1) {
/*      */ 
/*      */       
/* 1133 */       if (!f(i))
/*      */       {
/*      */ 
/*      */         
/* 1137 */         stringBuilder.append((char)i);
/*      */       }
/*      */     } 
/* 1140 */     if (h(i) && g(this.a.c()))
/*      */     {
/* 1142 */       this.a.a();
/*      */     }
/* 1144 */     return stringBuilder.toString();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean f(int paramInt) {
/* 1167 */     return (g(paramInt) || h(paramInt));
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean g(int paramInt) {
/* 1172 */     return (10 == paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean h(int paramInt) {
/* 1177 */     return (13 == paramInt);
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
/*      */   protected final boolean i() {
/* 1189 */     return c(this.a.c());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean c(int paramInt) {
/* 1200 */     return (paramInt == 0 || paramInt == 9 || paramInt == 12 || paramInt == 10 || paramInt == 13 || paramInt == 32);
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
/*      */   protected final boolean j() {
/* 1213 */     return i(this.a.c());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean i(int paramInt) {
/* 1224 */     return (32 == paramInt);
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
/*      */   protected final boolean k() {
/* 1236 */     return d(this.a.c());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected static boolean d(int paramInt) {
/* 1247 */     return (paramInt >= 48 && paramInt <= 57);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void l() {
/* 1257 */     int i = this.a.a();
/*      */     
/* 1259 */     while (c(i) || i == 37) {
/*      */       
/* 1261 */       if (i == 37) {
/*      */ 
/*      */         
/* 1264 */         i = this.a.a();
/* 1265 */         while (!f(i) && i != -1)
/*      */         {
/* 1267 */           i = this.a.a();
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/* 1272 */       i = this.a.a();
/*      */     } 
/*      */     
/* 1275 */     if (i != -1)
/*      */     {
/* 1277 */       this.a.a(i);
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
/*      */   protected final long m() {
/*      */     long l;
/* 1292 */     if ((l = o()) < 0L || l >= 10000000000L)
/*      */     {
/* 1294 */       throw new IOException("Object Number '" + l + "' has more than 10 digits or is negative");
/*      */     }
/* 1296 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final int n() {
/*      */     int i;
/* 1308 */     if ((i = s()) < 0 || i > 65535L)
/*      */     {
/* 1310 */       throw new IOException("Generation Number '" + i + "' has more than 5 digits");
/*      */     }
/* 1312 */     return i;
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
/*      */   private int s() {
/* 1324 */     l();
/*      */ 
/*      */     
/* 1327 */     StringBuilder stringBuilder = t();
/*      */ 
/*      */     
/*      */     try {
/* 1331 */       int i = Integer.parseInt(stringBuilder.toString());
/*      */     }
/* 1333 */     catch (NumberFormatException numberFormatException) {
/*      */       
/* 1335 */       this.a.b(stringBuilder.toString().getBytes(org.a.c.i.a.d));
/* 1336 */       throw new IOException("Error: Expected an integer type at offset " + this.a
/* 1337 */           .b() + ", instead got '" + stringBuilder + "'", numberFormatException);
/*      */     } 
/*      */     
/* 1340 */     return numberFormatException;
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
/*      */   protected final long o() {
/* 1353 */     l();
/*      */ 
/*      */     
/* 1356 */     StringBuilder stringBuilder = t();
/*      */ 
/*      */     
/*      */     try {
/* 1360 */       long l = Long.parseLong(stringBuilder.toString());
/*      */     }
/* 1362 */     catch (NumberFormatException numberFormatException) {
/*      */       
/* 1364 */       this.a.b(stringBuilder.toString().getBytes(org.a.c.i.a.d));
/* 1365 */       throw new IOException("Error: Expected a long type at offset " + this.a
/* 1366 */           .b() + ", instead got '" + stringBuilder + "'", numberFormatException);
/*      */     } 
/* 1368 */     return numberFormatException;
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
/*      */   private StringBuilder t() {
/* 1381 */     StringBuilder stringBuilder = new StringBuilder(); int i;
/* 1382 */     while ((i = this.a.a()) != 32 && i != 10 && i != 13 && i != 60 && i != 91 && i != 40 && i != 0 && i != -1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1391 */       stringBuilder.append((char)i);
/* 1392 */       if (stringBuilder.length() > c)
/*      */       {
/* 1394 */         throw new IOException("Number '" + stringBuilder + "' is getting too long, stop reading at offset " + this.a
/* 1395 */             .b());
/*      */       }
/*      */     } 
/* 1398 */     if (i != -1)
/*      */     {
/* 1400 */       this.a.a(i);
/*      */     }
/* 1402 */     return stringBuilder;
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */