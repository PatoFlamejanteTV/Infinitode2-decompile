/*      */ package com.prineside.luaj.compiler;
/*      */ 
/*      */ import com.prineside.luaj.LocVars;
/*      */ import com.prineside.luaj.Lua;
/*      */ import com.prineside.luaj.LuaError;
/*      */ import com.prineside.luaj.LuaNumber;
/*      */ import com.prineside.luaj.LuaString;
/*      */ import com.prineside.luaj.LuaValue;
/*      */ import com.prineside.luaj.Prototype;
/*      */ import com.prineside.luaj.lib.MathLib;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.util.Hashtable;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class LexState
/*      */   extends Constants
/*      */ {
/*   49 */   private static String[] e = new String[] { "(for control)", "(for generator)", "(for index)", "(for limit)", "(for state)", "(for step)" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   57 */   private static final Hashtable f = new Hashtable<>(); private int g; private int h; int a; static {
/*      */     byte b;
/*   59 */     for (b = 0; b < e.length; b++) {
/*   60 */       f.put(e[b], Boolean.TRUE);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String c(String paramString)
/*      */   {
/*   68 */     return "'" + paramString + "'"; } private static final String a(Object paramObject) {
/*   69 */     return c(String.valueOf(paramObject));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isReservedKeyword(String paramString) {
/*   75 */     return f.containsKey(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class SemInfo
/*      */   {
/*      */     LuaValue a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     LuaString b;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private SemInfo() {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Token
/*      */   {
/*      */     int a;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  123 */     final LexState.SemInfo b = new LexState.SemInfo((byte)0);
/*      */     public void set(Token param1Token) {
/*  125 */       this.a = param1Token.a;
/*  126 */       this.b.a = param1Token.b.a;
/*  127 */       this.b.b = param1Token.b.b;
/*      */     }
/*      */ 
/*      */     
/*      */     private Token() {}
/*      */   }
/*      */   
/*  134 */   private Token i = new Token((byte)0);
/*  135 */   private Token j = new Token((byte)0);
/*      */   FuncState b;
/*      */   LuaC.CompileState c;
/*      */   private InputStream k;
/*      */   private char[] l;
/*      */   private int m;
/*  141 */   Dyndata d = new Dyndata();
/*      */   
/*      */   private LuaString n;
/*      */   
/*      */   private LuaString o;
/*      */   
/*  147 */   private static String[] p = new String[] { "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while", "..", "...", "==", ">=", "<=", "~=", "::", "<eos>", "<number>", "<name>", "<string>", "<eof>" };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  169 */   private static Hashtable q = new Hashtable<>();
/*      */   static {
/*  171 */     for (b = 0; b < 22; b++) {
/*  172 */       LuaString luaString = LuaValue.valueOf(p[b]);
/*  173 */       q.put(luaString, Integer.valueOf(b + 257));
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean b(int paramInt) {
/*  178 */     return ((paramInt >= 48 && paramInt <= 57) || (paramInt >= 97 && paramInt <= 122) || (paramInt >= 65 && paramInt <= 90) || paramInt == 95);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean c(int paramInt) {
/*  186 */     return ((paramInt >= 97 && paramInt <= 122) || (paramInt >= 65 && paramInt <= 90));
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean d(int paramInt) {
/*  191 */     return (paramInt >= 48 && paramInt <= 57);
/*      */   }
/*      */   
/*      */   private static boolean e(int paramInt) {
/*  195 */     return ((paramInt >= 48 && paramInt <= 57) || (paramInt >= 97 && paramInt <= 102) || (paramInt >= 65 && paramInt <= 70));
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean f(int paramInt) {
/*  201 */     return (paramInt >= 0 && paramInt <= 32);
/*      */   }
/*      */ 
/*      */   
/*      */   public LexState(LuaC.CompileState paramCompileState, InputStream paramInputStream) {
/*  206 */     this.k = paramInputStream;
/*  207 */     this.l = new char[32];
/*  208 */     this.c = paramCompileState;
/*      */   }
/*      */   
/*      */   private void b() {
/*      */     try {
/*  213 */       this.g = this.k.read(); return;
/*  214 */     } catch (IOException iOException2) {
/*  215 */       IOException iOException1; (iOException1 = null).printStackTrace();
/*  216 */       this.g = -1;
/*      */       return;
/*      */     } 
/*      */   }
/*      */   private boolean c() {
/*  221 */     return (this.g == 10 || this.g == 13);
/*      */   }
/*      */   
/*      */   private void d() {
/*  225 */     g(this.g);
/*  226 */     b();
/*      */   }
/*      */   
/*      */   private void g(int paramInt) {
/*  230 */     if (this.l == null || this.m + 1 > this.l.length)
/*  231 */       this.l = a(this.l, (this.m << 1) + 1); 
/*  232 */     this.l[this.m++] = (char)paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private String h(int paramInt) {
/*  237 */     if (paramInt < 257) {
/*  238 */       if (i(paramInt))
/*  239 */         return this.c.pushfstring("char(" + paramInt + ")"); 
/*  240 */       return this.c.pushfstring(String.valueOf((char)paramInt));
/*      */     } 
/*  242 */     return p[paramInt - 257];
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean i(int paramInt) {
/*  247 */     return (paramInt < 32);
/*      */   }
/*      */   
/*      */   private String j(int paramInt) {
/*  251 */     switch (paramInt) {
/*      */       case 287:
/*      */       case 288:
/*      */       case 289:
/*  255 */         return new String(this.l, 0, this.m);
/*      */     } 
/*  257 */     return h(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   final void a(String paramString, int paramInt) {
/*  262 */     String str = Lua.chunkid(this.n.tojstring());
/*  263 */     this.c.pushfstring(str + ":" + this.h + ": " + paramString);
/*  264 */     if (paramInt != 0)
/*  265 */       this.c.pushfstring("syntax error: " + paramString + " near " + j(paramInt)); 
/*  266 */     throw new LuaError(str + ":" + this.h + ": " + paramString);
/*      */   }
/*      */   
/*      */   final void a(String paramString) {
/*  270 */     a(paramString, this.i.a);
/*      */   }
/*      */ 
/*      */   
/*      */   private LuaString d(String paramString) {
/*  275 */     return this.c.newTString(paramString);
/*      */   }
/*      */   
/*      */   private LuaString a(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  279 */     return this.c.newTString(new String(paramArrayOfchar, 0, paramInt2));
/*      */   }
/*      */   
/*      */   private void e() {
/*  283 */     int i = this.g;
/*  284 */     a(c());
/*  285 */     b();
/*  286 */     if (c() && this.g != i)
/*  287 */       b(); 
/*  288 */     if (++this.h >= 2147483645) {
/*  289 */       a("chunk has too many lines");
/*      */     }
/*      */   }
/*      */   
/*      */   final void a(LuaC.CompileState paramCompileState, int paramInt, InputStream paramInputStream, LuaString paramLuaString) {
/*  294 */     this.c = paramCompileState;
/*  295 */     this.j.a = 286;
/*  296 */     this.k = paramInputStream;
/*  297 */     this.b = null;
/*  298 */     this.h = 1;
/*  299 */     this.a = 1;
/*  300 */     this.n = paramLuaString;
/*  301 */     this.o = LuaValue.ENV;
/*  302 */     this.m = 0;
/*  303 */     this.g = paramInt;
/*  304 */     f();
/*      */   }
/*      */   
/*      */   private void f() {
/*  308 */     if (this.g == 35) {
/*  309 */       while (!c() && this.g != -1) {
/*  310 */         b();
/*      */       }
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
/*      */   private boolean e(String paramString) {
/*  323 */     if (paramString.indexOf(this.g) < 0)
/*  324 */       return false; 
/*  325 */     d();
/*  326 */     return true;
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
/*      */   private LuaValue f(String paramString) {
/*  338 */     char[] arrayOfChar = paramString.toCharArray();
/*  339 */     byte b = 0;
/*  340 */     while (b < arrayOfChar.length && f(arrayOfChar[b])) {
/*  341 */       b++;
/*      */     }
/*  343 */     double d1 = 1.0D;
/*  344 */     if (b < arrayOfChar.length && arrayOfChar[b] == '-') {
/*  345 */       d1 = -1.0D;
/*  346 */       b++;
/*      */     } 
/*      */     
/*  349 */     if (b + 2 >= arrayOfChar.length)
/*  350 */       return (LuaValue)LuaValue.ZERO; 
/*  351 */     if (arrayOfChar[b++] != '0')
/*  352 */       return (LuaValue)LuaValue.ZERO; 
/*  353 */     if (arrayOfChar[b] != 'x' && arrayOfChar[b] != 'X')
/*  354 */       return (LuaValue)LuaValue.ZERO; 
/*  355 */     b++;
/*      */ 
/*      */     
/*  358 */     double d2 = 0.0D;
/*  359 */     int i = 0;
/*  360 */     while (b < arrayOfChar.length && e(arrayOfChar[b]))
/*  361 */       d2 = d2 * 16.0D + k(arrayOfChar[b++]); 
/*  362 */     if (b < arrayOfChar.length && arrayOfChar[b] == '.') {
/*  363 */       b++;
/*  364 */       while (b < arrayOfChar.length && e(arrayOfChar[b])) {
/*  365 */         d2 = d2 * 16.0D + k(arrayOfChar[b++]);
/*  366 */         i -= true;
/*      */       } 
/*      */     } 
/*  369 */     if (b < arrayOfChar.length && (arrayOfChar[b] == 'p' || arrayOfChar[b] == 'P')) {
/*  370 */       b++;
/*  371 */       int j = 0;
/*  372 */       boolean bool = false;
/*  373 */       if (b < arrayOfChar.length && arrayOfChar[b] == '-') {
/*  374 */         bool = true;
/*  375 */         b++;
/*      */       } 
/*  377 */       while (b < arrayOfChar.length && d(arrayOfChar[b]))
/*  378 */         j = j * 10 + arrayOfChar[b++] - 48; 
/*  379 */       if (bool)
/*  380 */         j = -j; 
/*  381 */       i += j;
/*      */     } 
/*  383 */     return (LuaValue)LuaValue.valueOf(d1 * d2 * MathLib.dpow_d(2.0D, i));
/*      */   }
/*      */   
/*      */   private boolean a(String paramString, SemInfo paramSemInfo) {
/*  387 */     if (paramString.indexOf('n') >= 0 || paramString.indexOf('N') >= 0) {
/*  388 */       paramSemInfo.a = (LuaValue)LuaValue.ZERO;
/*  389 */     } else if (paramString.indexOf('x') >= 0 || paramString.indexOf('X') >= 0) {
/*  390 */       paramSemInfo.a = f(paramString);
/*      */     } else {
/*      */       try {
/*  393 */         paramSemInfo.a = (LuaValue)LuaValue.valueOf(Double.parseDouble(paramString.trim()));
/*  394 */       } catch (NumberFormatException numberFormatException) {
/*  395 */         a("malformed number (" + numberFormatException.getMessage() + ")", 287);
/*      */       } 
/*      */     } 
/*  398 */     return true;
/*      */   }
/*      */   
/*      */   private void a(SemInfo paramSemInfo) {
/*  402 */     String str = "Ee";
/*  403 */     int i = this.g;
/*  404 */     a(d(this.g));
/*  405 */     d();
/*  406 */     if (i == 48 && e("Xx"))
/*  407 */       str = "Pp"; 
/*      */     while (true) {
/*  409 */       if (e(str))
/*  410 */         e("+-"); 
/*  411 */       if (e(this.g) || this.g == 46) {
/*  412 */         d(); continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  416 */     str = new String(this.l, 0, this.m);
/*  417 */     a(str, paramSemInfo);
/*      */   }
/*      */   
/*      */   private int g() {
/*  421 */     byte b = 0;
/*      */     int i;
/*  423 */     a(((i = this.g) == 91 || i == 93));
/*  424 */     d();
/*  425 */     while (this.g == 61) {
/*  426 */       d();
/*  427 */       b++;
/*      */     } 
/*  429 */     return (this.g == i) ? b : (-b - 1);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(SemInfo paramSemInfo, int paramInt) {
/*  434 */     d();
/*  435 */     if (c())
/*  436 */       e(); 
/*  437 */     for (boolean bool = false; !bool; ) {
/*  438 */       switch (this.g) {
/*      */         case -1:
/*  440 */           a((paramSemInfo != null) ? "unfinished long string" : 
/*  441 */               "unfinished long comment", 286);
/*      */           continue;
/*      */         case 91:
/*  444 */           if (g() == paramInt) {
/*  445 */             d();
/*      */ 
/*      */             
/*  448 */             if (paramInt == 0) {
/*  449 */               a("nesting of [[...]] is deprecated", 91);
/*      */             }
/*      */           } 
/*      */           continue;
/*      */         
/*      */         case 93:
/*  455 */           if (g() == paramInt) {
/*  456 */             d();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  462 */             bool = true;
/*      */           } 
/*      */           continue;
/*      */         
/*      */         case 10:
/*      */         case 13:
/*  468 */           g(10);
/*  469 */           e();
/*  470 */           if (paramSemInfo == null) {
/*  471 */             this.m = 0;
/*      */           }
/*      */           continue;
/*      */       } 
/*  475 */       if (paramSemInfo != null) {
/*  476 */         d(); continue;
/*      */       } 
/*  478 */       b();
/*      */     } 
/*      */ 
/*      */     
/*  482 */     if (paramSemInfo != null)
/*  483 */       paramSemInfo.b = this.c.newTString(LuaString.valueOf(this.l, paramInt + 2, this.m - 2 * (paramInt + 2))); 
/*      */   }
/*      */   
/*      */   private static int k(int paramInt) {
/*  487 */     return (paramInt <= 57) ? (paramInt - 48) : ((paramInt <= 70) ? (paramInt + 10 - 65) : (paramInt + 10 - 97));
/*      */   }
/*      */   
/*      */   private int h() {
/*  491 */     b();
/*  492 */     int i = this.g;
/*  493 */     b();
/*  494 */     int j = this.g;
/*  495 */     if (!e(i) || !e(j))
/*  496 */       a("hexadecimal digit expected 'x" + (char)i + (char)j, 289); 
/*  497 */     return (k(i) << 4) + k(j);
/*      */   }
/*      */   
/*      */   private void a(int paramInt, SemInfo paramSemInfo) {
/*  501 */     d();
/*  502 */     while (this.g != paramInt) {
/*  503 */       int i; byte b; switch (this.g) {
/*      */         case -1:
/*  505 */           a("unfinished string", 286);
/*      */           continue;
/*      */         case 10:
/*      */         case 13:
/*  509 */           a("unfinished string", 289);
/*      */           continue;
/*      */         
/*      */         case 92:
/*  513 */           b();
/*  514 */           switch (this.g) {
/*      */             case 97:
/*  516 */               i = 7;
/*      */               break;
/*      */             case 98:
/*  519 */               i = 8;
/*      */               break;
/*      */             case 102:
/*  522 */               i = 12;
/*      */               break;
/*      */             case 110:
/*  525 */               i = 10;
/*      */               break;
/*      */             case 114:
/*  528 */               i = 13;
/*      */               break;
/*      */             case 116:
/*  531 */               i = 9;
/*      */               break;
/*      */             case 118:
/*  534 */               i = 11;
/*      */               break;
/*      */             case 120:
/*  537 */               i = h();
/*      */               break;
/*      */             case 10:
/*      */             case 13:
/*  541 */               g(10);
/*  542 */               e();
/*      */               continue;
/*      */             case -1:
/*      */               continue;
/*      */             case 122:
/*  547 */               b();
/*  548 */               while (f(this.g)) {
/*  549 */                 if (c()) { e(); continue; }
/*  550 */                  b();
/*      */               } 
/*      */               continue;
/*      */             
/*      */             default:
/*  555 */               if (!d(this.g)) {
/*  556 */                 d(); continue;
/*      */               } 
/*  558 */               b = 0;
/*  559 */               i = 0;
/*      */               do {
/*  561 */                 i = i * 10 + this.g - 48;
/*  562 */                 b();
/*  563 */               } while (++b < 3 && d(this.g));
/*  564 */               if (i > 255)
/*  565 */                 a("escape sequence too large", 289); 
/*  566 */               g(i);
/*      */               continue;
/*      */           } 
/*      */ 
/*      */           
/*  571 */           g(i);
/*  572 */           b();
/*      */           continue;
/*      */       } 
/*      */       
/*  576 */       d();
/*      */     } 
/*      */     
/*  579 */     d();
/*  580 */     paramSemInfo.b = this.c.newTString(LuaString.valueOf(this.l, 1, this.m - 2));
/*      */   }
/*      */   
/*      */   private int b(SemInfo paramSemInfo) {
/*  584 */     this.m = 0; while (true) {
/*      */       int j;
/*  586 */       switch (this.g) {
/*      */         case 10:
/*      */         case 13:
/*  589 */           e();
/*      */           continue;
/*      */         
/*      */         case 9:
/*      */         case 11:
/*      */         case 12:
/*      */         case 32:
/*  596 */           b();
/*      */           continue;
/*      */         
/*      */         case 45:
/*  600 */           b();
/*  601 */           if (this.g != 45) {
/*  602 */             return 45;
/*      */           }
/*  604 */           b();
/*  605 */           if (this.g == 91) {
/*  606 */             int k = g();
/*  607 */             this.m = 0;
/*  608 */             if (k >= 0) {
/*  609 */               a((SemInfo)null, k);
/*  610 */               this.m = 0;
/*      */               
/*      */               continue;
/*      */             } 
/*      */           } 
/*  615 */           while (!c() && this.g != -1) {
/*  616 */             b();
/*      */           }
/*      */           continue;
/*      */         
/*      */         case 91:
/*  621 */           if ((j = g()) >= 0) {
/*  622 */             a(paramSemInfo, j);
/*  623 */             return 289;
/*  624 */           }  if (j == -1) {
/*  625 */             return 91;
/*      */           }
/*  627 */           a("invalid long string delimiter", 289);
/*      */ 
/*      */           
/*  630 */           b();
/*  631 */           if (this.g != 61) {
/*  632 */             return 61;
/*      */           }
/*  634 */           b();
/*  635 */           return 281;
/*      */         case 61:
/*      */           continue;
/*      */         case 60:
/*  639 */           b();
/*  640 */           if (this.g != 61) {
/*  641 */             return 60;
/*      */           }
/*  643 */           b();
/*  644 */           return 283;
/*      */ 
/*      */         
/*      */         case 62:
/*  648 */           b();
/*  649 */           if (this.g != 61) {
/*  650 */             return 62;
/*      */           }
/*  652 */           b();
/*  653 */           return 282;
/*      */ 
/*      */         
/*      */         case 126:
/*  657 */           b();
/*  658 */           if (this.g != 61) {
/*  659 */             return 126;
/*      */           }
/*  661 */           b();
/*  662 */           return 284;
/*      */ 
/*      */         
/*      */         case 58:
/*  666 */           b();
/*  667 */           if (this.g != 58) {
/*  668 */             return 58;
/*      */           }
/*  670 */           b();
/*  671 */           return 285;
/*      */ 
/*      */         
/*      */         case 34:
/*      */         case 39:
/*  676 */           a(this.g, paramSemInfo);
/*  677 */           return 289;
/*      */         
/*      */         case 46:
/*  680 */           d();
/*  681 */           if (e(".")) {
/*  682 */             if (e(".")) {
/*  683 */               return 280;
/*      */             }
/*  685 */             return 279;
/*  686 */           }  if (!d(this.g)) {
/*  687 */             return 46;
/*      */           }
/*  689 */           a(paramSemInfo);
/*  690 */           return 287;
/*      */         case 48: case 49: case 50: case 51: case 52: case 53: case 54:
/*      */         case 55:
/*      */         case 56:
/*      */         case 57:
/*  695 */           a(paramSemInfo);
/*  696 */           return 287;
/*      */         
/*      */         case -1:
/*  699 */           return 286;
/*      */       }  break;
/*      */     } 
/*  702 */     if (c(this.g) || this.g == 95)
/*      */     {
/*      */       while (true) {
/*      */         
/*  706 */         d();
/*  707 */         if (!b(this.g)) {
/*  708 */           LuaString luaString = a(this.l, 0, this.m);
/*  709 */           if (q.containsKey(luaString)) {
/*  710 */             return ((Integer)q.get(luaString)).intValue();
/*      */           }
/*  712 */           paramSemInfo.b = luaString;
/*  713 */           return 288;
/*      */         } 
/*      */       }  } 
/*  716 */     int i = this.g;
/*  717 */     b();
/*  718 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void i() {
/*  726 */     this.a = this.h;
/*  727 */     if (this.j.a != 286) {
/*  728 */       this.i.set(this.j);
/*  729 */       this.j.a = 286; return;
/*      */     } 
/*  731 */     this.i.a = b(this.i.b);
/*      */   }
/*      */   
/*      */   private void j() {
/*  735 */     a((this.j.a == 286));
/*  736 */     this.j.a = b(this.j.b);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static class expdesc
/*      */   {
/*      */     int a;
/*      */ 
/*      */ 
/*      */     
/*      */     static class U
/*      */     {
/*      */       short a;
/*      */ 
/*      */       
/*      */       short b;
/*      */ 
/*      */       
/*      */       short c;
/*      */ 
/*      */       
/*      */       private LuaValue e;
/*      */ 
/*      */       
/*      */       int d;
/*      */ 
/*      */       
/*      */       public void setNval(LuaValue param2LuaValue) {
/*  765 */         this.e = param2LuaValue;
/*      */       }
/*      */       public LuaValue nval() {
/*  768 */         return (LuaValue)((this.e == null) ? LuaNumber.valueOf(this.d) : this.e);
/*      */       }
/*      */     }
/*  771 */     final U b = new U();
/*  772 */     final IntPtr c = new IntPtr();
/*  773 */     final IntPtr d = new IntPtr();
/*      */     final void a(int param1Int1, int param1Int2) {
/*  775 */       this.d.a = -1;
/*  776 */       this.c.a = -1;
/*  777 */       this.a = param1Int1;
/*  778 */       this.b.d = param1Int2;
/*      */     }
/*      */     
/*      */     final boolean a() {
/*  782 */       return (this.c.a != this.d.a);
/*      */     }
/*      */     
/*      */     final boolean b() {
/*  786 */       return (this.a == 5 && this.c.a == -1 && this.d.a == -1);
/*      */     }
/*      */     
/*      */     public void setvalue(expdesc param1expdesc) {
/*  790 */       this.d.a = param1expdesc.d.a;
/*  791 */       this.a = param1expdesc.a;
/*  792 */       this.c.a = param1expdesc.c.a;
/*  793 */       U.a(this.b, U.a(param1expdesc.b));
/*  794 */       this.b.a = param1expdesc.b.a;
/*  795 */       this.b.b = param1expdesc.b.b;
/*  796 */       this.b.c = param1expdesc.b.c;
/*  797 */       this.b.d = param1expdesc.b.d;
/*      */     }
/*      */   } static class U { short a; short b; short c; private LuaValue e; int d; public void setNval(LuaValue param1LuaValue) {
/*      */       this.e = param1LuaValue;
/*      */     }
/*      */     public LuaValue nval() {
/*      */       return (LuaValue)((this.e == null) ? LuaNumber.valueOf(this.d) : this.e);
/*      */     } }
/*      */   static class Vardesc { Vardesc(int param1Int) {
/*  806 */       this.a = (short)param1Int;
/*      */     }
/*      */     
/*      */     final short a; }
/*      */   
/*      */   static class Labeldesc {
/*      */     LuaString a;
/*      */     int b;
/*      */     int c;
/*      */     short d;
/*      */     
/*      */     public Labeldesc(LuaString param1LuaString, int param1Int1, int param1Int2, short param1Short) {
/*  818 */       this.a = param1LuaString;
/*  819 */       this.b = param1Int1;
/*  820 */       this.c = param1Int2;
/*  821 */       this.d = param1Short;
/*      */     } }
/*      */   static class Dyndata { LexState.Vardesc[] a; int b; LexState.Labeldesc[] c;
/*      */     int d;
/*      */     LexState.Labeldesc[] e;
/*      */     int f;
/*      */     
/*      */     Dyndata() {
/*  829 */       this.b = 0;
/*      */       
/*  831 */       this.d = 0;
/*      */       
/*  833 */       this.f = 0;
/*      */     } }
/*      */ 
/*      */   
/*      */   private static boolean l(int paramInt) {
/*  838 */     return (paramInt == 12 || paramInt == 13);
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
/*      */   final void b(String paramString) {
/*  857 */     this.i.a = 0;
/*  858 */     a(paramString);
/*      */   }
/*      */   
/*      */   private void m(int paramInt) {
/*  862 */     a(this.c.pushfstring(c(h(paramInt)) + " expected"));
/*      */   }
/*      */   
/*      */   private boolean n(int paramInt) {
/*  866 */     if (this.i.a == paramInt) {
/*  867 */       i();
/*  868 */       return true;
/*      */     } 
/*  870 */     return false;
/*      */   }
/*      */   
/*      */   private void o(int paramInt) {
/*  874 */     if (this.i.a != paramInt)
/*  875 */       m(paramInt); 
/*      */   }
/*      */   
/*      */   private void p(int paramInt) {
/*  879 */     o(paramInt);
/*  880 */     i();
/*      */   }
/*      */   
/*      */   private void a(boolean paramBoolean, String paramString) {
/*  884 */     if (!paramBoolean) {
/*  885 */       a(paramString);
/*      */     }
/*      */   }
/*      */   
/*      */   private void b(int paramInt1, int paramInt2, int paramInt3) {
/*  890 */     if (!n(paramInt1)) {
/*  891 */       if (paramInt3 == this.h) {
/*  892 */         m(paramInt1); return;
/*      */       } 
/*  894 */       a(this.c.pushfstring(c(h(paramInt1)) + " expected (to close " + 
/*  895 */             c(h(paramInt2)) + " at line " + paramInt3 + ")"));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private LuaString k() {
/*  903 */     o(288);
/*  904 */     LuaString luaString = this.i.b.b;
/*  905 */     i();
/*  906 */     return luaString;
/*      */   }
/*      */   
/*      */   private void a(expdesc paramexpdesc, LuaString paramLuaString) {
/*  910 */     paramexpdesc.a(4, this.b.a(paramLuaString));
/*      */   }
/*      */   
/*      */   private void a(expdesc paramexpdesc) {
/*  914 */     a(paramexpdesc, k());
/*      */   }
/*      */ 
/*      */   
/*      */   private int a(LuaString paramLuaString) {
/*      */     FuncState funcState;
/*      */     Prototype prototype;
/*  921 */     if ((prototype = (funcState = this.b).a).locvars == null || funcState.k + 1 > prototype.locvars.length)
/*  922 */       prototype.locvars = a(prototype.locvars, (funcState.k << 1) + 1); 
/*  923 */     prototype.locvars[funcState.k] = new LocVars(paramLuaString, 0, 0);
/*  924 */     funcState.k = (short)(funcState.k + 1); return funcState.k;
/*      */   }
/*      */   
/*      */   private void b(LuaString paramLuaString) {
/*  928 */     int i = a(paramLuaString);
/*  929 */     this.b.a(this.d.b + 1, 200, "local variables");
/*  930 */     if (this.d.a == null || this.d.b + 1 > this.d.a.length)
/*  931 */       this.d.a = a(this.d.a, Math.max(1, this.d.b << 1)); 
/*  932 */     this.d.a[this.d.b++] = new Vardesc(i);
/*      */   }
/*      */   
/*      */   private void g(String paramString) {
/*  936 */     LuaString luaString = d(paramString);
/*  937 */     b(luaString);
/*      */   }
/*      */   
/*      */   private void q(int paramInt) {
/*      */     FuncState funcState;
/*  942 */     (funcState = this.b).l = (short)(funcState.l + paramInt);
/*  943 */     for (; paramInt > 0; paramInt--) {
/*  944 */       (funcState.a(funcState.l - paramInt)).startpc = funcState.e;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(expdesc paramexpdesc) {
/*  955 */     LuaString luaString = k();
/*      */     FuncState funcState;
/*  957 */     if (FuncState.a(funcState = this.b, luaString, paramexpdesc, 1) == 0) {
/*  958 */       expdesc expdesc1 = new expdesc();
/*  959 */       FuncState.a(funcState, this.o, paramexpdesc, 1);
/*  960 */       a((paramexpdesc.a == 7 || paramexpdesc.a == 8));
/*  961 */       a(expdesc1, luaString);
/*  962 */       funcState.c(paramexpdesc, expdesc1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(int paramInt1, int paramInt2, expdesc paramexpdesc) {
/*  967 */     FuncState funcState = this.b;
/*  968 */     paramInt1 -= paramInt2;
/*  969 */     if (l(paramexpdesc.a)) {
/*      */       
/*  971 */       paramInt1++;
/*  972 */       if (paramInt1 < 0) {
/*  973 */         paramInt1 = 0;
/*      */       }
/*  975 */       funcState.a(paramexpdesc, paramInt1);
/*  976 */       if (paramInt1 > 1) {
/*  977 */         funcState.d(paramInt1 - 1); return;
/*      */       } 
/*      */     } else {
/*  980 */       if (paramexpdesc.a != 0)
/*  981 */         funcState.f(paramexpdesc); 
/*  982 */       if (paramInt1 > 0) {
/*  983 */         paramInt2 = funcState.n;
/*  984 */         funcState.d(paramInt1);
/*  985 */         funcState.b(paramInt2, paramInt1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void l() {
/*  991 */     if (++this.c.a > 200)
/*  992 */       a("chunk has too many syntax levels", 0); 
/*      */   }
/*      */   
/*      */   private void m() {
/*  996 */     this.c.a--;
/*      */   }
/*      */   
/*      */   private void a(int paramInt, Labeldesc paramLabeldesc) {
/* 1000 */     FuncState funcState = this.b;
/*      */     
/*      */     Labeldesc arrayOfLabeldesc[], labeldesc;
/* 1003 */     a((labeldesc = (arrayOfLabeldesc = this.d.c)[paramInt]).a.eq_b((LuaValue)paramLabeldesc.a));
/* 1004 */     if (labeldesc.d < paramLabeldesc.d) {
/* 1005 */       LuaString luaString = (funcState.a(labeldesc.d)).varname;
/* 1006 */       String str = this.c.pushfstring("<goto " + labeldesc.a + "> at line " + labeldesc.c + " jumps into the scope of local '" + luaString
/*      */           
/* 1008 */           .tojstring() + "'");
/* 1009 */       b(str);
/*      */     } 
/* 1011 */     funcState.d(labeldesc.b, paramLabeldesc.b);
/*      */     
/* 1013 */     System.arraycopy(arrayOfLabeldesc, paramInt + 1, arrayOfLabeldesc, paramInt, this.d.d - paramInt - 1);
/* 1014 */     arrayOfLabeldesc[--this.d.d] = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean a(int paramInt) {
/* 1022 */     FuncState.BlockCnt blockCnt = this.b.d;
/*      */     Dyndata dyndata;
/* 1024 */     Labeldesc labeldesc = (dyndata = this.d).c[paramInt];
/*      */     
/* 1026 */     for (short s = blockCnt.b; s < dyndata.f; s++) {
/*      */       Labeldesc labeldesc1;
/* 1028 */       if ((labeldesc1 = dyndata.e[s]).a.eq_b((LuaValue)labeldesc.a)) {
/* 1029 */         if (labeldesc.d > labeldesc1.d && (blockCnt.e || dyndata.f > blockCnt.b))
/*      */         {
/* 1031 */           this.b.e(labeldesc.b, labeldesc1.d); } 
/* 1032 */         a(paramInt, labeldesc1);
/* 1033 */         return true;
/*      */       } 
/*      */     } 
/* 1036 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private int a(Labeldesc[] paramArrayOfLabeldesc, int paramInt1, LuaString paramLuaString, int paramInt2, int paramInt3) {
/* 1041 */     paramArrayOfLabeldesc[paramInt1] = new Labeldesc(paramLuaString, paramInt3, paramInt2, this.b.l);
/* 1042 */     return paramInt1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(Labeldesc paramLabeldesc) {
/* 1050 */     Labeldesc[] arrayOfLabeldesc = this.d.c;
/* 1051 */     short s = this.b.d.c;
/* 1052 */     while (s < this.d.d) {
/* 1053 */       if ((arrayOfLabeldesc[s]).a.eq_b((LuaValue)paramLabeldesc.a)) {
/* 1054 */         a(s, paramLabeldesc); continue;
/*      */       } 
/* 1056 */       s++;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a() {
/* 1065 */     LuaString luaString = LuaString.valueOf("break");
/* 1066 */     int i = a(this.d.e = a(this.d.e, this.d.f + 1), this.d.f++, luaString, 0, this.b.e);
/* 1067 */     b(this.d.e[i]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(Labeldesc paramLabeldesc) {
/* 1075 */     String str = this.c.pushfstring(isReservedKeyword(paramLabeldesc.a.tojstring()) ? (
/* 1076 */         "<" + paramLabeldesc.a + "> at line " + paramLabeldesc.c + " not inside a loop") : (
/* 1077 */         "no visible label '" + paramLabeldesc.a + "' for <goto> at line " + paramLabeldesc.c));
/* 1078 */     b(str);
/*      */   }
/*      */ 
/*      */   
/*      */   private Prototype n() {
/*      */     Prototype prototype;
/* 1084 */     if ((prototype = this.b.a).p == null || this.b.i >= prototype.p.length) {
/* 1085 */       prototype.p = a(prototype.p, Math.max(1, this.b.i << 1));
/*      */     }
/* 1087 */     prototype.p[this.b.i++] = prototype = new Prototype();
/* 1088 */     return prototype;
/*      */   }
/*      */   
/*      */   private void c(expdesc paramexpdesc) {
/* 1092 */     FuncState funcState = this.b.b;
/* 1093 */     paramexpdesc.a(11, funcState.c(37, 0, funcState.i - 1));
/* 1094 */     funcState.f(paramexpdesc);
/*      */   }
/*      */   
/*      */   private void a(FuncState paramFuncState, FuncState.BlockCnt paramBlockCnt) {
/* 1098 */     paramFuncState.b = this.b;
/* 1099 */     paramFuncState.c = this;
/* 1100 */     this.b = paramFuncState;
/* 1101 */     paramFuncState.e = 0;
/* 1102 */     paramFuncState.f = -1;
/* 1103 */     paramFuncState.g = new IntPtr(-1);
/* 1104 */     paramFuncState.n = 0;
/* 1105 */     paramFuncState.h = 0;
/* 1106 */     paramFuncState.i = 0;
/* 1107 */     paramFuncState.m = 0;
/* 1108 */     paramFuncState.k = 0;
/* 1109 */     paramFuncState.l = 0;
/* 1110 */     paramFuncState.j = this.d.b;
/* 1111 */     paramFuncState.d = null;
/* 1112 */     paramFuncState.a.source = this.n;
/* 1113 */     paramFuncState.a.maxstacksize = 2;
/* 1114 */     paramFuncState.a(paramBlockCnt, false);
/*      */   }
/*      */   
/*      */   private void o() {
/*      */     FuncState funcState;
/* 1119 */     Prototype prototype = (funcState = this.b).a;
/* 1120 */     funcState.c(0, 0);
/* 1121 */     funcState.a();
/* 1122 */     prototype.code = a(prototype.code, funcState.e);
/* 1123 */     prototype.lineinfo = a(prototype.lineinfo, funcState.e);
/* 1124 */     prototype.k = a(prototype.k, funcState.h);
/* 1125 */     prototype.p = a(prototype.p, funcState.i);
/* 1126 */     prototype.locvars = a(prototype.locvars, funcState.k);
/* 1127 */     prototype.upvalues = a(prototype.upvalues, funcState.m);
/* 1128 */     a((funcState.d == null));
/* 1129 */     this.b = funcState.b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void d(expdesc paramexpdesc) {
/* 1140 */     FuncState funcState = this.b;
/* 1141 */     expdesc expdesc1 = new expdesc();
/* 1142 */     funcState.h(paramexpdesc);
/* 1143 */     i();
/* 1144 */     a(expdesc1);
/* 1145 */     funcState.c(paramexpdesc, expdesc1);
/*      */   }
/*      */ 
/*      */   
/*      */   private void e(expdesc paramexpdesc) {
/* 1150 */     i();
/* 1151 */     k(paramexpdesc);
/* 1152 */     this.b.i(paramexpdesc);
/* 1153 */     p(93);
/*      */   }
/*      */   
/*      */   static class ConsControl
/*      */   {
/*      */     LexState.expdesc a;
/*      */     LexState.expdesc b;
/*      */     int c;
/*      */     int d;
/*      */     int e;
/*      */     
/*      */     ConsControl() {
/* 1165 */       this.a = new LexState.expdesc();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(ConsControl paramConsControl) {
/* 1175 */     FuncState funcState = this.b;
/* 1176 */     short s = this.b.n;
/* 1177 */     expdesc expdesc1 = new expdesc();
/* 1178 */     expdesc expdesc2 = new expdesc();
/*      */     
/* 1180 */     if (this.i.a == 288) {
/* 1181 */       funcState.a(paramConsControl.c, 2147483645, "items in a constructor");
/* 1182 */       a(expdesc1);
/*      */     } else {
/*      */       
/* 1185 */       e(expdesc1);
/* 1186 */     }  paramConsControl.c++;
/* 1187 */     p(61);
/* 1188 */     int i = funcState.j(expdesc1);
/* 1189 */     k(expdesc2);
/* 1190 */     funcState.b(10, paramConsControl.b.b.d, i, funcState.j(expdesc2));
/* 1191 */     funcState.n = (short)s;
/*      */   }
/*      */   
/*      */   private void b(ConsControl paramConsControl) {
/* 1195 */     k(paramConsControl.a);
/* 1196 */     this.b.a(paramConsControl.d, 2147483645, "items in a constructor");
/* 1197 */     paramConsControl.d++;
/* 1198 */     paramConsControl.e++;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void f(expdesc paramexpdesc) {
/* 1204 */     FuncState funcState = this.b;
/* 1205 */     int i = this.h;
/* 1206 */     int j = funcState.b(11, 0, 0, 0);
/*      */     ConsControl consControl;
/* 1208 */     (consControl = new ConsControl()).d = consControl.c = consControl.e = 0;
/* 1209 */     consControl.b = paramexpdesc;
/* 1210 */     paramexpdesc.a(11, j);
/* 1211 */     consControl.a.a(0, 0);
/* 1212 */     funcState.f(paramexpdesc);
/* 1213 */     p(123);
/*      */     while (true)
/* 1215 */     { a((consControl.a.a == 0 || consControl.e > 0));
/* 1216 */       if (this.i.a != 125)
/*      */       
/* 1218 */       { funcState.a(consControl);
/* 1219 */         switch (this.i.a) {
/*      */           case 288:
/* 1221 */             j();
/* 1222 */             if (this.j.a == 61) {
/*      */ 
/*      */               
/* 1225 */               a(consControl);
/*      */               break;
/*      */             } 
/*      */           case 91:
/* 1229 */             a(consControl);
/*      */             break;
/*      */           
/*      */           default:
/* 1233 */             b(consControl);
/*      */             break;
/*      */         } 
/*      */         
/* 1237 */         if (!n(44) && !n(59))
/* 1238 */           break;  continue; }  break; }  b(125, 123, i);
/* 1239 */     funcState.b(consControl);
/*      */     InstructionPtr instructionPtr;
/* 1241 */     c(instructionPtr = new InstructionPtr(funcState.a.code, j), r(consControl.d));
/* 1242 */     d(instructionPtr, r(consControl.c));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static int r(int paramInt) {
/* 1251 */     byte b = 0;
/* 1252 */     while (paramInt >= 16) {
/* 1253 */       paramInt = paramInt + 1 >> 1;
/* 1254 */       b++;
/*      */     } 
/* 1256 */     if (paramInt < 8) return paramInt; 
/* 1257 */     return b + 1 << 3 | paramInt - 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void p() {
/*      */     FuncState funcState;
/* 1266 */     Prototype prototype = (funcState = this.b).a;
/* 1267 */     byte b = 0;
/* 1268 */     prototype.is_vararg = 0;
/* 1269 */     if (this.i.a != 41) {
/*      */       do {
/* 1271 */         switch (this.i.a) {
/*      */           case 288:
/* 1273 */             b(k());
/* 1274 */             b++;
/*      */             break;
/*      */           
/*      */           case 280:
/* 1278 */             i();
/* 1279 */             prototype.is_vararg = 1;
/*      */             break;
/*      */           default:
/* 1282 */             a("<name> or " + a("...") + " expected"); break;
/*      */         } 
/* 1284 */       } while (prototype.is_vararg == 0 && n(44));
/*      */     }
/* 1286 */     q(b);
/* 1287 */     prototype.numparams = funcState.l;
/* 1288 */     funcState.d(funcState.l);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(expdesc paramexpdesc, boolean paramBoolean, int paramInt) {
/* 1294 */     FuncState funcState = new FuncState();
/* 1295 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/* 1296 */     funcState.a = n();
/* 1297 */     funcState.a.linedefined = paramInt;
/* 1298 */     a(funcState, blockCnt);
/* 1299 */     p(40);
/* 1300 */     if (paramBoolean) {
/* 1301 */       g("self");
/* 1302 */       q(1);
/*      */     } 
/* 1304 */     p();
/* 1305 */     p(41);
/* 1306 */     z();
/* 1307 */     funcState.a.lastlinedefined = this.h;
/* 1308 */     b(262, 265, paramInt);
/* 1309 */     c(paramexpdesc);
/* 1310 */     o();
/*      */   }
/*      */ 
/*      */   
/*      */   private int g(expdesc paramexpdesc) {
/* 1315 */     byte b = 1;
/* 1316 */     k(paramexpdesc);
/* 1317 */     while (n(44)) {
/* 1318 */       this.b.f(paramexpdesc);
/* 1319 */       k(paramexpdesc);
/* 1320 */       b++;
/*      */     } 
/* 1322 */     return b;
/*      */   }
/*      */   
/*      */   private void a(expdesc paramexpdesc, int paramInt) {
/*      */     int i;
/* 1327 */     FuncState funcState = this.b;
/* 1328 */     expdesc expdesc1 = new expdesc();
/*      */     
/* 1330 */     switch (this.i.a) {
/*      */       case 40:
/* 1332 */         i();
/* 1333 */         if (this.i.a == 41) {
/* 1334 */           expdesc1.a = 0;
/*      */         } else {
/* 1336 */           g(expdesc1);
/* 1337 */           funcState.c(expdesc1);
/*      */         } 
/* 1339 */         b(41, 40, paramInt);
/*      */         break;
/*      */       
/*      */       case 123:
/* 1343 */         f(expdesc1);
/*      */         break;
/*      */       
/*      */       case 289:
/* 1347 */         a(expdesc1, this.i.b.b);
/* 1348 */         i();
/*      */         break;
/*      */       
/*      */       default:
/* 1352 */         a("function arguments expected");
/*      */         return;
/*      */     } 
/*      */     
/* 1356 */     a((paramexpdesc.a == 6));
/* 1357 */     int j = paramexpdesc.b.d;
/* 1358 */     if (l(expdesc1.a)) {
/* 1359 */       i = -1;
/*      */     } else {
/* 1361 */       if (i.a != 0)
/* 1362 */         funcState.f(i); 
/* 1363 */       i = funcState.n - j + 1;
/*      */     } 
/* 1365 */     paramexpdesc.a(12, funcState.b(29, j, i + 1, 2));
/* 1366 */     funcState.e(paramInt);
/* 1367 */     funcState.n = (short)(j + 1);
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
/*      */   private void h(expdesc paramexpdesc) {
/*      */     int i;
/* 1380 */     switch (this.i.a) {
/*      */       case 40:
/* 1382 */         i = this.h;
/* 1383 */         i();
/* 1384 */         k(paramexpdesc);
/* 1385 */         b(41, 40, i);
/* 1386 */         this.b.e(paramexpdesc);
/*      */         return;
/*      */       
/*      */       case 288:
/* 1390 */         b(paramexpdesc);
/*      */         return;
/*      */     } 
/*      */     
/* 1394 */     a("unexpected symbol " + this.i.a + " (" + (char)this.i.a + ")");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void i(expdesc paramexpdesc) {
/* 1404 */     int i = this.h;
/* 1405 */     h(paramexpdesc); while (true) {
/*      */       expdesc expdesc1;
/* 1407 */       switch (this.i.a) {
/*      */         case 46:
/* 1409 */           d(paramexpdesc);
/*      */           continue;
/*      */         
/*      */         case 91:
/* 1413 */           expdesc1 = new expdesc();
/* 1414 */           this.b.h(paramexpdesc);
/* 1415 */           e(expdesc1);
/* 1416 */           this.b.c(paramexpdesc, expdesc1);
/*      */           continue;
/*      */         
/*      */         case 58:
/* 1420 */           expdesc1 = new expdesc();
/* 1421 */           i();
/* 1422 */           a(expdesc1);
/* 1423 */           this.b.b(paramexpdesc, expdesc1);
/* 1424 */           a(paramexpdesc, i);
/*      */           continue;
/*      */         
/*      */         case 40:
/*      */         case 123:
/*      */         case 289:
/* 1430 */           this.b.f(paramexpdesc);
/* 1431 */           a(paramexpdesc, i);
/*      */           continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void j(expdesc paramexpdesc) {
/*      */     FuncState funcState;
/* 1446 */     switch (this.i.a) {
/*      */       case 287:
/* 1448 */         paramexpdesc.a(5, 0);
/* 1449 */         paramexpdesc.b.setNval(this.i.b.a);
/*      */         break;
/*      */       
/*      */       case 289:
/* 1453 */         a(paramexpdesc, this.i.b.b);
/*      */         break;
/*      */       
/*      */       case 270:
/* 1457 */         paramexpdesc.a(1, 0);
/*      */         break;
/*      */       
/*      */       case 276:
/* 1461 */         paramexpdesc.a(2, 0);
/*      */         break;
/*      */       
/*      */       case 263:
/* 1465 */         paramexpdesc.a(3, 0);
/*      */         break;
/*      */       
/*      */       case 280:
/* 1469 */         funcState = this.b;
/* 1470 */         a((funcState.a.is_vararg != 0), "cannot use " + a("...") + " outside a vararg function");
/*      */         
/* 1472 */         paramexpdesc.a(13, funcState.b(38, 0, 1, 0));
/*      */         break;
/*      */       
/*      */       case 123:
/* 1476 */         f(paramexpdesc);
/*      */         return;
/*      */       
/*      */       case 265:
/* 1480 */         i();
/* 1481 */         a(paramexpdesc, false, this.h);
/*      */         return;
/*      */       
/*      */       default:
/* 1485 */         i(paramexpdesc);
/*      */         return;
/*      */     } 
/*      */     
/* 1489 */     i();
/*      */   }
/*      */ 
/*      */   
/*      */   private static int s(int paramInt) {
/* 1494 */     switch (paramInt) {
/*      */       case 271:
/* 1496 */         return 1;
/*      */       case 45:
/* 1498 */         return 0;
/*      */       case 35:
/* 1500 */         return 2;
/*      */     } 
/* 1502 */     return 3;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static int t(int paramInt) {
/* 1508 */     switch (paramInt) {
/*      */       case 43:
/* 1510 */         return 0;
/*      */       case 45:
/* 1512 */         return 1;
/*      */       case 42:
/* 1514 */         return 2;
/*      */       case 47:
/* 1516 */         return 3;
/*      */       case 37:
/* 1518 */         return 4;
/*      */       case 94:
/* 1520 */         return 5;
/*      */       case 279:
/* 1522 */         return 6;
/*      */       case 284:
/* 1524 */         return 7;
/*      */       case 281:
/* 1526 */         return 8;
/*      */       case 60:
/* 1528 */         return 9;
/*      */       case 283:
/* 1530 */         return 10;
/*      */       case 62:
/* 1532 */         return 11;
/*      */       case 282:
/* 1534 */         return 12;
/*      */       case 257:
/* 1536 */         return 13;
/*      */       case 272:
/* 1538 */         return 14;
/*      */     } 
/* 1540 */     return 15;
/*      */   }
/*      */ 
/*      */   
/*      */   static class Priority
/*      */   {
/*      */     final byte a;
/*      */     final byte b;
/*      */     
/*      */     public Priority(int param1Int1, int param1Int2) {
/* 1550 */       this.a = (byte)param1Int1;
/* 1551 */       this.b = (byte)param1Int2;
/*      */     }
/*      */   }
/*      */   
/* 1555 */   private static Priority[] r = new Priority[] { new Priority(6, 6), new Priority(6, 6), new Priority(7, 7), new Priority(7, 7), new Priority(7, 7), new Priority(10, 9), new Priority(5, 4), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(2, 2), new Priority(1, 1) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int b(expdesc paramexpdesc, int paramInt) {
/* 1573 */     l();
/*      */     int i;
/* 1575 */     if ((i = s(this.i.a)) != 3) {
/* 1576 */       int j = this.h;
/* 1577 */       i();
/* 1578 */       b(paramexpdesc, 8);
/* 1579 */       this.b.a(i, paramexpdesc, j);
/*      */     } else {
/* 1581 */       j(paramexpdesc);
/*      */     } 
/* 1583 */     i = t(this.i.a);
/* 1584 */     while (i != 15 && (r[i]).a > paramInt) {
/* 1585 */       expdesc expdesc1 = new expdesc();
/* 1586 */       int j = this.h;
/* 1587 */       i();
/* 1588 */       this.b.a(i, paramexpdesc);
/*      */       
/* 1590 */       int k = b(expdesc1, (r[i]).b);
/* 1591 */       this.b.a(i, paramexpdesc, expdesc1, j);
/* 1592 */       i = k;
/*      */     } 
/* 1594 */     m();
/* 1595 */     return i;
/*      */   }
/*      */   
/*      */   private void k(expdesc paramexpdesc) {
/* 1599 */     b(paramexpdesc, 0);
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
/*      */   private boolean b(boolean paramBoolean) {
/* 1614 */     switch (this.i.a) { case 260: case 261: case 262:
/*      */       case 286:
/* 1616 */         return true;
/*      */       case 277:
/* 1618 */         return paramBoolean; }
/* 1619 */      return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void q() {
/* 1626 */     FuncState funcState = this.b;
/* 1627 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/* 1628 */     funcState.a(blockCnt, false);
/* 1629 */     z();
/* 1630 */     funcState.a();
/*      */   }
/*      */ 
/*      */   
/*      */   static class LHS_assign
/*      */   {
/*      */     LHS_assign a;
/*      */     
/*      */     LexState.expdesc b;
/*      */     
/*      */     LHS_assign() {
/* 1641 */       this.b = new LexState.expdesc();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(LHS_assign paramLHS_assign, expdesc paramexpdesc) {
/*      */     FuncState funcState;
/* 1653 */     short s = (funcState = this.b).n;
/* 1654 */     boolean bool = false;
/* 1655 */     for (; paramLHS_assign != null; paramLHS_assign = paramLHS_assign.a) {
/* 1656 */       if (paramLHS_assign.b.a == 9) {
/*      */         
/* 1658 */         if (paramLHS_assign.b.b.c == paramexpdesc.a && paramLHS_assign.b.b.b == paramexpdesc.b.d) {
/* 1659 */           bool = true;
/* 1660 */           paramLHS_assign.b.b.c = 7;
/* 1661 */           paramLHS_assign.b.b.b = s;
/*      */         } 
/*      */         
/* 1664 */         if (paramexpdesc.a == 7 && paramLHS_assign.b.b.a == paramexpdesc.b.d) {
/* 1665 */           bool = true;
/* 1666 */           paramLHS_assign.b.b.a = s;
/*      */         } 
/*      */       } 
/*      */     } 
/* 1670 */     if (bool) {
/*      */       
/* 1672 */       boolean bool1 = (paramexpdesc.a == 7) ? false : true;
/* 1673 */       funcState.b(bool1, s, paramexpdesc.b.d, 0);
/* 1674 */       funcState.d(1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(LHS_assign paramLHS_assign, int paramInt) {
/* 1680 */     expdesc expdesc = new expdesc();
/* 1681 */     a((7 <= paramLHS_assign.b.a && paramLHS_assign.b.a <= 9), "syntax error");
/*      */     
/* 1683 */     if (n(44)) {
/*      */       LHS_assign lHS_assign;
/* 1685 */       (lHS_assign = new LHS_assign()).a = paramLHS_assign;
/* 1686 */       i(lHS_assign.b);
/* 1687 */       if (lHS_assign.b.a != 9)
/* 1688 */         a(paramLHS_assign, lHS_assign.b); 
/* 1689 */       a(lHS_assign, paramInt + 1);
/*      */     }
/*      */     else {
/*      */       
/* 1693 */       p(61);
/*      */       int i;
/* 1695 */       if ((i = g(expdesc)) != paramInt) {
/* 1696 */         a(paramInt, i, expdesc);
/* 1697 */         if (i > paramInt) {
/* 1698 */           this.b.n = (short)(this.b.n - i - paramInt);
/*      */         }
/*      */       } else {
/* 1701 */         this.b.d(expdesc);
/* 1702 */         this.b.a(paramLHS_assign.b, expdesc);
/*      */         return;
/*      */       } 
/*      */     } 
/* 1706 */     expdesc.a(6, this.b.n - 1);
/* 1707 */     this.b.a(paramLHS_assign.b, expdesc);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int r() {
/* 1713 */     expdesc expdesc = new expdesc();
/*      */     
/* 1715 */     k(expdesc);
/*      */     
/* 1717 */     if (expdesc.a == 1)
/* 1718 */       expdesc.a = 3; 
/* 1719 */     this.b.k(expdesc);
/* 1720 */     return expdesc.d.a;
/*      */   }
/*      */   private void u(int paramInt) {
/*      */     LuaString luaString;
/* 1724 */     int i = this.h;
/*      */ 
/*      */     
/* 1727 */     if (n(266)) {
/* 1728 */       luaString = k();
/*      */     } else {
/* 1730 */       i();
/* 1731 */       luaString = LuaString.valueOf("break");
/*      */     } 
/* 1733 */     paramInt = a(this.d.c = a(this.d.c, this.d.d + 1), this.d.d++, luaString, i, paramInt);
/* 1734 */     a(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void s() {
/* 1740 */     while (this.i.a == 59 || this.i.a == 285) {
/* 1741 */       y();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(LuaString paramLuaString, int paramInt) {
/* 1748 */     this.b.a(this.d.e, this.d.f, paramLuaString);
/* 1749 */     p(285);
/*      */     
/* 1751 */     int i = a(this.d.e = a(this.d.e, this.d.f + 1), this.d.f++, paramLuaString, paramInt, this.b.c());
/* 1752 */     s();
/* 1753 */     if (b(false))
/*      */     {
/* 1755 */       (this.d.e[i]).d = this.b.d.d;
/*      */     }
/* 1757 */     b(this.d.e[i]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void v(int paramInt) {
/* 1763 */     FuncState funcState = this.b;
/*      */ 
/*      */     
/* 1766 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/* 1767 */     i();
/* 1768 */     int i = funcState.c();
/* 1769 */     int j = r();
/* 1770 */     funcState.a(blockCnt, true);
/* 1771 */     p(259);
/* 1772 */     q();
/* 1773 */     funcState.d(funcState.b(), i);
/* 1774 */     b(262, 278, paramInt);
/* 1775 */     funcState.a();
/* 1776 */     funcState.b(j);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void w(int paramInt) {
/*      */     FuncState funcState;
/* 1783 */     int i = (funcState = this.b).c();
/* 1784 */     FuncState.BlockCnt blockCnt1 = new FuncState.BlockCnt();
/* 1785 */     FuncState.BlockCnt blockCnt2 = new FuncState.BlockCnt();
/* 1786 */     funcState.a(blockCnt1, true);
/* 1787 */     funcState.a(blockCnt2, false);
/* 1788 */     i();
/* 1789 */     z();
/* 1790 */     b(277, 273, paramInt);
/* 1791 */     paramInt = r();
/* 1792 */     if (blockCnt2.e) {
/* 1793 */       funcState.e(paramInt, blockCnt2.d);
/*      */     }
/* 1795 */     funcState.a();
/* 1796 */     funcState.d(paramInt, i);
/* 1797 */     funcState.a();
/*      */   }
/*      */ 
/*      */   
/*      */   private int t() {
/* 1802 */     expdesc expdesc = new expdesc();
/*      */     
/* 1804 */     k(expdesc);
/* 1805 */     int i = expdesc.a;
/* 1806 */     this.b.f(expdesc);
/* 1807 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 1813 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/* 1814 */     FuncState funcState = this.b;
/*      */     
/* 1816 */     q(3);
/* 1817 */     p(259);
/* 1818 */     int i = paramBoolean ? funcState.b(33, paramInt1, -1) : funcState.b();
/* 1819 */     funcState.a(blockCnt, false);
/* 1820 */     q(paramInt3);
/* 1821 */     funcState.d(paramInt3);
/* 1822 */     q();
/* 1823 */     funcState.a();
/* 1824 */     funcState.b(i);
/* 1825 */     if (paramBoolean) {
/* 1826 */       paramInt1 = funcState.b(32, paramInt1, -1);
/*      */     } else {
/* 1828 */       funcState.b(34, paramInt1, 0, paramInt3);
/* 1829 */       funcState.e(paramInt2);
/* 1830 */       paramInt1 = funcState.b(35, paramInt1 + 2, -1);
/*      */     } 
/* 1832 */     funcState.d(paramInt1, i + 1);
/* 1833 */     funcState.e(paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void b(LuaString paramLuaString, int paramInt) {
/*      */     FuncState funcState;
/* 1840 */     short s = (funcState = this.b).n;
/* 1841 */     g("(for index)");
/* 1842 */     g("(for limit)");
/* 1843 */     g("(for step)");
/* 1844 */     b(paramLuaString);
/* 1845 */     p(61);
/* 1846 */     t();
/* 1847 */     p(44);
/* 1848 */     t();
/* 1849 */     if (n(44)) {
/* 1850 */       t();
/*      */     } else {
/* 1852 */       funcState.f(funcState.n, funcState.a((LuaValue)LuaNumber.valueOf(1)));
/* 1853 */       funcState.d(1);
/*      */     } 
/* 1855 */     a(s, paramInt, 1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void c(LuaString paramLuaString) {
/* 1861 */     FuncState funcState = this.b;
/* 1862 */     expdesc expdesc = new expdesc();
/* 1863 */     byte b = 4;
/*      */     
/* 1865 */     short s = funcState.n;
/*      */     
/* 1867 */     g("(for generator)");
/* 1868 */     g("(for state)");
/* 1869 */     g("(for control)");
/*      */     
/* 1871 */     b(paramLuaString);
/* 1872 */     while (n(44)) {
/* 1873 */       b(k());
/* 1874 */       b++;
/*      */     } 
/* 1876 */     p(268);
/* 1877 */     int i = this.h;
/* 1878 */     a(3, g(expdesc), expdesc);
/* 1879 */     funcState.c(3);
/* 1880 */     a(s, i, b - 3, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void x(int paramInt) {
/* 1886 */     FuncState funcState = this.b;
/*      */     
/* 1888 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/* 1889 */     funcState.a(blockCnt, true);
/* 1890 */     i();
/* 1891 */     LuaString luaString = k();
/* 1892 */     switch (this.i.a) {
/*      */       case 61:
/* 1894 */         b(luaString, paramInt);
/*      */         break;
/*      */       case 44:
/*      */       case 268:
/* 1898 */         c(luaString);
/*      */         break;
/*      */       default:
/* 1901 */         a(a("=") + " or " + a("in") + " expected"); break;
/*      */     } 
/* 1903 */     b(262, 264, paramInt);
/* 1904 */     funcState.a();
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(IntPtr paramIntPtr) {
/*      */     int i;
/* 1910 */     expdesc expdesc = new expdesc();
/* 1911 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/*      */     
/* 1913 */     i();
/* 1914 */     k(expdesc);
/* 1915 */     p(275);
/* 1916 */     if (this.i.a == 266 || this.i.a == 258) {
/* 1917 */       this.b.l(expdesc);
/* 1918 */       this.b.a(blockCnt, false);
/* 1919 */       u(expdesc.c.a);
/* 1920 */       s();
/* 1921 */       if (b(false)) {
/* 1922 */         this.b.a();
/*      */         
/*      */         return;
/*      */       } 
/* 1926 */       i = this.b.b();
/*      */     } else {
/* 1928 */       this.b.k(i);
/* 1929 */       this.b.a(blockCnt, false);
/* 1930 */       i = i.d.a;
/*      */     } 
/* 1932 */     z();
/* 1933 */     this.b.a();
/* 1934 */     if (this.i.a == 260 || this.i.a == 261)
/* 1935 */       this.b.a(paramIntPtr, this.b.b()); 
/* 1936 */     this.b.b(i);
/*      */   }
/*      */ 
/*      */   
/*      */   private void y(int paramInt) {
/* 1941 */     IntPtr intPtr = new IntPtr(-1);
/* 1942 */     a(intPtr);
/* 1943 */     while (this.i.a == 261)
/* 1944 */       a(intPtr); 
/* 1945 */     if (n(260))
/* 1946 */       q(); 
/* 1947 */     b(262, 267, paramInt);
/* 1948 */     this.b.b(intPtr.a);
/*      */   }
/*      */   
/*      */   private void u() {
/* 1952 */     expdesc expdesc = new expdesc();
/* 1953 */     FuncState funcState = this.b;
/* 1954 */     b(k());
/* 1955 */     q(1);
/* 1956 */     a(expdesc, false, this.h);
/*      */     
/* 1958 */     (funcState.a(funcState.l - 1)).startpc = funcState.e;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void v() {
/* 1964 */     byte b = 0;
/*      */     
/* 1966 */     expdesc expdesc = new expdesc();
/*      */     while (true) {
/* 1968 */       b(k());
/* 1969 */       b++;
/* 1970 */       if (!n(44)) {
/* 1971 */         boolean bool; if (n(61)) {
/* 1972 */           bool = g(expdesc);
/*      */         } else {
/* 1974 */           expdesc.a = 0;
/* 1975 */           bool = false;
/*      */         } 
/* 1977 */         a(b, bool, expdesc);
/* 1978 */         q(b);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   private boolean l(expdesc paramexpdesc) {
/* 1984 */     boolean bool = false;
/* 1985 */     b(paramexpdesc);
/* 1986 */     while (this.i.a == 46)
/* 1987 */       d(paramexpdesc); 
/* 1988 */     if (this.i.a == 58) {
/* 1989 */       bool = true;
/* 1990 */       d(paramexpdesc);
/*      */     } 
/* 1992 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void z(int paramInt) {
/* 1999 */     expdesc expdesc1 = new expdesc();
/* 2000 */     expdesc expdesc2 = new expdesc();
/* 2001 */     i();
/* 2002 */     boolean bool = l(expdesc1);
/* 2003 */     a(expdesc2, bool, paramInt);
/* 2004 */     this.b.a(expdesc1, expdesc2);
/* 2005 */     this.b.e(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void w() {
/* 2011 */     FuncState funcState = this.b;
/* 2012 */     LHS_assign lHS_assign = new LHS_assign();
/* 2013 */     i(lHS_assign.b);
/* 2014 */     if (this.i.a == 61 || this.i.a == 44) {
/* 2015 */       lHS_assign.a = null;
/* 2016 */       a(lHS_assign, 1);
/*      */       return;
/*      */     } 
/* 2019 */     a((lHS_assign.b.a == 12), "syntax error");
/* 2020 */     d(funcState.a(lHS_assign.b), 1);
/*      */   }
/*      */ 
/*      */   
/*      */   private void x() {
/*      */     int i, j;
/* 2026 */     FuncState funcState = this.b;
/* 2027 */     expdesc expdesc = new expdesc();
/*      */     
/* 2029 */     if (b(true) || this.i.a == 59) {
/* 2030 */       i = j = 0;
/*      */     } else {
/* 2032 */       j = g(i);
/* 2033 */       if (l(i.a)) {
/* 2034 */         funcState.c(i);
/* 2035 */         if (i.a == 12 && j == 1) {
/* 2036 */           a(funcState.a(i), 30);
/* 2037 */           a((Lua.GETARG_A(funcState.b(i)) == funcState.l));
/*      */         } 
/* 2039 */         i = funcState.l;
/* 2040 */         j = -1;
/*      */       }
/* 2042 */       else if (j == 1) {
/* 2043 */         i = funcState.g(i);
/*      */       } else {
/* 2045 */         funcState.f(i);
/* 2046 */         i = funcState.l;
/* 2047 */         a((j == funcState.n - i));
/*      */       } 
/*      */     } 
/*      */     
/* 2051 */     funcState.c(i, j);
/* 2052 */     n(59);
/*      */   }
/*      */   
/*      */   private void y() {
/* 2056 */     int i = this.h;
/* 2057 */     l();
/* 2058 */     switch (this.i.a) {
/*      */       case 59:
/* 2060 */         i();
/*      */         break;
/*      */       
/*      */       case 267:
/* 2064 */         y(i);
/*      */         break;
/*      */       
/*      */       case 278:
/* 2068 */         v(i);
/*      */         break;
/*      */       
/*      */       case 259:
/* 2072 */         i();
/* 2073 */         q();
/* 2074 */         b(262, 259, i);
/*      */         break;
/*      */       
/*      */       case 264:
/* 2078 */         x(i);
/*      */         break;
/*      */       
/*      */       case 273:
/* 2082 */         w(i);
/*      */         break;
/*      */       
/*      */       case 265:
/* 2086 */         z(i);
/*      */         break;
/*      */       
/*      */       case 269:
/* 2090 */         i();
/* 2091 */         if (n(265)) {
/* 2092 */           u(); break;
/*      */         } 
/* 2094 */         v();
/*      */         break;
/*      */       
/*      */       case 285:
/* 2098 */         i();
/* 2099 */         a(k(), i);
/*      */         break;
/*      */       
/*      */       case 274:
/* 2103 */         i();
/* 2104 */         x();
/*      */         break;
/*      */       
/*      */       case 258:
/*      */       case 266:
/* 2109 */         u(this.b.b());
/*      */         break;
/*      */       
/*      */       default:
/* 2113 */         w();
/*      */         break;
/*      */     } 
/*      */     
/* 2117 */     a((this.b.a.maxstacksize >= this.b.n && this.b.n >= this.b.l));
/*      */     
/* 2119 */     this.b.n = this.b.l;
/* 2120 */     m();
/*      */   }
/*      */ 
/*      */   
/*      */   private void z() {
/* 2125 */     while (!b(true)) {
/* 2126 */       if (this.i.a == 274) {
/* 2127 */         y();
/*      */         return;
/*      */       } 
/* 2130 */       y();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void mainfunc(FuncState paramFuncState) {
/* 2139 */     FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
/* 2140 */     a(paramFuncState, blockCnt);
/* 2141 */     this.b.a.is_vararg = 1;
/*      */     expdesc expdesc;
/* 2143 */     (expdesc = new expdesc()).a(7, 0);
/* 2144 */     this.b.a(this.o, expdesc);
/* 2145 */     i();
/* 2146 */     z();
/* 2147 */     o(286);
/* 2148 */     o();
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\compiler\LexState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */