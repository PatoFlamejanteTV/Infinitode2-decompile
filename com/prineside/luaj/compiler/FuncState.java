/*      */ package com.prineside.luaj.compiler;
/*      */ 
/*      */ import com.prineside.luaj.LocVars;
/*      */ import com.prineside.luaj.Lua;
/*      */ import com.prineside.luaj.LuaNumber;
/*      */ import com.prineside.luaj.LuaString;
/*      */ import com.prineside.luaj.LuaValue;
/*      */ import com.prineside.luaj.Prototype;
/*      */ import com.prineside.luaj.Upvaldesc;
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
/*      */ public class FuncState
/*      */   extends Constants
/*      */ {
/*      */   Prototype a;
/*      */   private Hashtable o;
/*      */   FuncState b;
/*      */   LexState c;
/*      */   BlockCnt d;
/*      */   int e;
/*      */   int f;
/*      */   IntPtr g;
/*      */   int h;
/*      */   int i;
/*      */   int j;
/*      */   short k;
/*      */   short l;
/*      */   short m;
/*      */   short n;
/*      */   
/*      */   static class BlockCnt
/*      */   {
/*      */     BlockCnt a;
/*      */     short b;
/*      */     short c;
/*      */     short d;
/*      */     boolean e;
/*      */     boolean f;
/*      */   }
/*      */   
/*      */   final InstructionPtr a(LexState.expdesc paramexpdesc) {
/*   73 */     return new InstructionPtr(this.a.code, paramexpdesc.b.d);
/*      */   }
/*      */   
/*      */   final int b(LexState.expdesc paramexpdesc) {
/*   77 */     return this.a.code[paramexpdesc.b.d];
/*      */   }
/*      */   
/*      */   final int b(int paramInt1, int paramInt2, int paramInt3) {
/*   81 */     return c(paramInt1, paramInt2, 131070);
/*      */   }
/*      */   
/*      */   final void c(LexState.expdesc paramexpdesc) {
/*   85 */     a(paramexpdesc, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(LexState.Labeldesc[] paramArrayOfLabeldesc, int paramInt, LuaString paramLuaString) {
/*   96 */     for (short s = this.d.b; s < paramInt; s++) {
/*   97 */       if (paramLuaString.eq_b((LuaValue)(paramArrayOfLabeldesc[s]).a)) {
/*   98 */         String str = this.c.c.pushfstring("label '" + paramLuaString + " already defined on line " + (paramArrayOfLabeldesc[s]).c);
/*      */         
/*  100 */         this.c.b(str);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   final void a(int paramInt1, int paramInt2, String paramString) {
/*  107 */     if (paramInt1 > paramInt2) {
/*  108 */       a(paramInt2, paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(int paramInt, String paramString) {
/*  115 */     String str = (this.a.linedefined == 0) ? this.c.c.pushfstring("main function has more than " + paramInt + " " + paramString) : this.c.c.pushfstring("function at line " + this.a.linedefined + " has more than " + paramInt + " " + paramString);
/*  116 */     this.c.a(str, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   final LocVars a(int paramInt) {
/*  121 */     a(((paramInt = (this.c.d.a[this.j + paramInt]).a) < this.k));
/*  122 */     return this.a.locvars[paramInt];
/*      */   }
/*      */   
/*      */   private void f(int paramInt) {
/*  126 */     this.c.d.b -= this.l - paramInt;
/*  127 */     while (this.l > paramInt) {
/*  128 */       (a(this.l = (short)(this.l - 1))).endpc = this.e;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private int b(LuaString paramLuaString) {
/*  134 */     Upvaldesc[] arrayOfUpvaldesc = this.a.upvalues;
/*  135 */     for (byte b = 0; b < this.m; b++) {
/*  136 */       if ((arrayOfUpvaldesc[b]).name.eq_b((LuaValue)paramLuaString))
/*  137 */         return b; 
/*  138 */     }  return -1;
/*      */   }
/*      */   
/*      */   final int a(LuaString paramLuaString, LexState.expdesc paramexpdesc) {
/*  142 */     a(this.m + 1, 255, "upvalues");
/*  143 */     if (this.a.upvalues == null || this.m + 1 > this.a.upvalues.length)
/*  144 */       this.a.upvalues = a(this.a.upvalues, (this.m > 0) ? (this.m << 1) : 1); 
/*  145 */     this.a.upvalues[this.m] = new Upvaldesc(paramLuaString, (paramexpdesc.a == 7), paramexpdesc.b.d);
/*  146 */     this.m = (short)(this.m + 1); return this.m;
/*      */   }
/*      */ 
/*      */   
/*      */   private int c(LuaString paramLuaString) {
/*  151 */     for (int i = this.l - 1; i >= 0; i--) {
/*  152 */       if (paramLuaString.eq_b((LuaValue)(a(i)).varname))
/*  153 */         return i; 
/*      */     } 
/*  155 */     return -1;
/*      */   }
/*      */   
/*      */   private void g(int paramInt) {
/*  159 */     BlockCnt blockCnt = this.d;
/*  160 */     while (blockCnt.d > paramInt)
/*  161 */       blockCnt = blockCnt.a; 
/*  162 */     blockCnt.e = true;
/*      */   }
/*      */   
/*      */   static int a(FuncState paramFuncState, LuaString paramLuaString, LexState.expdesc paramexpdesc, int paramInt) {
/*  166 */     if (paramFuncState == null)
/*  167 */       return 0; 
/*      */     int i;
/*  169 */     if ((i = paramFuncState.c(paramLuaString)) >= 0) {
/*  170 */       paramexpdesc.a(7, i);
/*  171 */       if (paramInt == 0)
/*  172 */         paramFuncState.g(i); 
/*  173 */       return 7;
/*      */     } 
/*      */     
/*  176 */     if ((paramInt = paramFuncState.b(paramLuaString)) < 0) {
/*  177 */       if (a(paramFuncState.b, paramLuaString, paramexpdesc, 0) == 0) {
/*  178 */         return 0;
/*      */       }
/*  180 */       paramInt = paramFuncState.a(paramLuaString, paramexpdesc);
/*      */     } 
/*  182 */     paramexpdesc.a(8, paramInt);
/*  183 */     return 8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(BlockCnt paramBlockCnt) {
/*  194 */     short s = paramBlockCnt.c;
/*  195 */     LexState.Labeldesc[] arrayOfLabeldesc = this.c.d.c;
/*      */ 
/*      */     
/*  198 */     while (s < this.c.d.d) {
/*      */       LexState.Labeldesc labeldesc;
/*  200 */       if ((labeldesc = arrayOfLabeldesc[s]).d > paramBlockCnt.d) {
/*  201 */         if (paramBlockCnt.e)
/*  202 */           e(labeldesc.b, paramBlockCnt.d); 
/*  203 */         labeldesc.d = paramBlockCnt.d;
/*      */       } 
/*  205 */       if (!this.c.a(s))
/*  206 */         s++; 
/*      */     } 
/*      */   }
/*      */   
/*      */   final void a(BlockCnt paramBlockCnt, boolean paramBoolean) {
/*  211 */     paramBlockCnt.f = paramBoolean;
/*  212 */     paramBlockCnt.d = this.l;
/*  213 */     paramBlockCnt.b = (short)this.c.d.f;
/*  214 */     paramBlockCnt.c = (short)this.c.d.d;
/*  215 */     paramBlockCnt.e = false;
/*  216 */     paramBlockCnt.a = this.d;
/*  217 */     this.d = paramBlockCnt;
/*  218 */     a((this.n == this.l));
/*      */   }
/*      */   
/*      */   final void a() {
/*      */     BlockCnt blockCnt;
/*  223 */     if ((blockCnt = this.d).a != null && blockCnt.e) {
/*      */       
/*  225 */       int i = b();
/*  226 */       e(i, blockCnt.d);
/*  227 */       b(i);
/*      */     } 
/*  229 */     if (blockCnt.f)
/*  230 */       this.c.a(); 
/*  231 */     this.d = blockCnt.a;
/*  232 */     f(blockCnt.d);
/*  233 */     a((blockCnt.d == this.l));
/*  234 */     this.n = this.l;
/*  235 */     this.c.d.f = blockCnt.b;
/*  236 */     if (blockCnt.a != null) {
/*  237 */       a(blockCnt); return;
/*  238 */     }  if (blockCnt.c < this.c.d.d)
/*  239 */       this.c.a(this.c.d.c[blockCnt.c]); 
/*      */   }
/*      */   
/*      */   final void a(LexState.ConsControl paramConsControl) {
/*  243 */     if (paramConsControl.a.a == 0)
/*      */       return; 
/*  245 */     f(paramConsControl.a);
/*  246 */     paramConsControl.a.a = 0;
/*  247 */     if (paramConsControl.e == 50) {
/*  248 */       e(paramConsControl.b.b.d, paramConsControl.d, paramConsControl.e);
/*  249 */       paramConsControl.e = 0;
/*      */     } 
/*      */   }
/*      */   
/*      */   private static boolean h(int paramInt) {
/*  254 */     return (paramInt == 12 || paramInt == 13);
/*      */   }
/*      */   
/*      */   final void b(LexState.ConsControl paramConsControl) {
/*  258 */     if (paramConsControl.e == 0)
/*  259 */       return;  if (h(paramConsControl.a.a)) {
/*  260 */       c(paramConsControl.a);
/*  261 */       e(paramConsControl.b.b.d, paramConsControl.d, -1);
/*  262 */       paramConsControl.d--;
/*      */       return;
/*      */     } 
/*  265 */     if (paramConsControl.a.a != 0)
/*  266 */       f(paramConsControl.a); 
/*  267 */     e(paramConsControl.b.b.d, paramConsControl.d, paramConsControl.e);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void b(int paramInt1, int paramInt2) {
/*      */     InstructionPtr instructionPtr;
/*  278 */     int i = paramInt1 + paramInt2 - 1; int j;
/*  279 */     if (this.e > this.f && this.e > 0 && 
/*      */       
/*  281 */       GET_OPCODE(j = this.a.code[this.e - 1]) == 4) {
/*      */       int k;
/*  283 */       j = (k = GETARG_A(j)) + GETARG_B(j);
/*  284 */       if ((k <= paramInt1 && paramInt1 <= j + 1) || (paramInt1 <= k && k <= i + 1)) {
/*      */         
/*  286 */         if (k < paramInt1)
/*  287 */           paramInt1 = k; 
/*  288 */         if (j > i) {
/*  289 */           i = j;
/*      */         }
/*  291 */         b(instructionPtr = new InstructionPtr(this.a.code, this.e - 1), paramInt1);
/*  292 */         c(instructionPtr, i - paramInt1);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*  297 */     b(4, paramInt1, instructionPtr - 1, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   final int b() {
/*  302 */     int i = this.g.a;
/*  303 */     this.g.a = -1;
/*  304 */     IntPtr intPtr = new IntPtr(b(23, 0, -1));
/*  305 */     a(intPtr, i);
/*  306 */     return intPtr.a;
/*      */   }
/*      */   
/*      */   final void c(int paramInt1, int paramInt2) {
/*  310 */     b(31, paramInt1, paramInt2 + 1, 0);
/*      */   }
/*      */   
/*      */   private int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  314 */     b(paramInt1, paramInt2, paramInt3, paramInt4);
/*  315 */     return b();
/*      */   }
/*      */   
/*      */   private void g(int paramInt1, int paramInt2) {
/*  319 */     InstructionPtr instructionPtr = new InstructionPtr(this.a.code, paramInt1);
/*  320 */     paramInt1 = paramInt2 - paramInt1 + 1;
/*  321 */     a((paramInt2 != -1));
/*  322 */     if (Math.abs(paramInt1) > 131071)
/*  323 */       this.c.a("control structure too long"); 
/*  324 */     e(instructionPtr, paramInt1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int c() {
/*  333 */     this.f = this.e;
/*  334 */     return this.e;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private int i(int paramInt) {
/*      */     int i;
/*  341 */     if ((i = GETARG_sBx(this.a.code[paramInt])) == -1)
/*      */     {
/*  343 */       return -1;
/*      */     }
/*      */     
/*  346 */     return paramInt + 1 + i;
/*      */   }
/*      */ 
/*      */   
/*      */   private InstructionPtr j(int paramInt) {
/*  351 */     InstructionPtr instructionPtr = new InstructionPtr(this.a.code, paramInt);
/*  352 */     if (paramInt > 0 && testTMode(GET_OPCODE(instructionPtr.a[instructionPtr.b - 1]))) {
/*  353 */       return new InstructionPtr(instructionPtr.a, instructionPtr.b - 1);
/*      */     }
/*  355 */     return instructionPtr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean k(int paramInt) {
/*  364 */     for (; paramInt != -1; paramInt = i(paramInt)) {
/*      */       int i;
/*  366 */       if (GET_OPCODE(i = j(paramInt).a()) != 28)
/*  367 */         return true; 
/*      */     } 
/*  369 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean h(int paramInt1, int paramInt2) {
/*      */     InstructionPtr instructionPtr;
/*  375 */     if (GET_OPCODE((instructionPtr = j(paramInt1)).a()) != 28)
/*      */     {
/*  377 */       return false; } 
/*  378 */     if (paramInt2 != 255 && paramInt2 != GETARG_B(instructionPtr.a())) {
/*  379 */       b(instructionPtr, paramInt2);
/*      */     } else {
/*      */       
/*  382 */       instructionPtr.a(a(27, GETARG_B(instructionPtr.a()), 0, Lua.GETARG_C(instructionPtr.a())));
/*      */     } 
/*  384 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private void l(int paramInt) {
/*  389 */     for (; paramInt != -1; paramInt = i(paramInt))
/*  390 */       h(paramInt, 255); 
/*      */   }
/*      */   
/*      */   private void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  394 */     while (paramInt1 != -1) {
/*  395 */       int i = i(paramInt1);
/*  396 */       if (h(paramInt1, paramInt3)) {
/*  397 */         g(paramInt1, paramInt2);
/*      */       } else {
/*  399 */         g(paramInt1, paramInt4);
/*  400 */       }  paramInt1 = i;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void d() {
/*  405 */     d(this.g.a, this.e, 255, this.e);
/*  406 */     this.g.a = -1;
/*      */   }
/*      */   
/*      */   final void d(int paramInt1, int paramInt2) {
/*  410 */     if (paramInt2 == this.e) {
/*  411 */       b(paramInt1); return;
/*      */     } 
/*  413 */     a((paramInt2 < this.e));
/*  414 */     d(paramInt1, paramInt2, 255, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   final void e(int paramInt1, int paramInt2) {
/*  419 */     paramInt2++;
/*  420 */     while (paramInt1 != -1) {
/*  421 */       int i = i(paramInt1);
/*  422 */       a((GET_OPCODE(this.a.code[paramInt1]) == 23 && (
/*  423 */           GETARG_A(this.a.code[paramInt1]) == 0 || GETARG_A(this.a.code[paramInt1]) >= paramInt2)));
/*  424 */       a(this.a.code, paramInt1, paramInt2);
/*  425 */       paramInt1 = i;
/*      */     } 
/*      */   }
/*      */   
/*      */   final void b(int paramInt) {
/*  430 */     c();
/*  431 */     a(this.g, paramInt);
/*      */   }
/*      */   
/*      */   final void a(IntPtr paramIntPtr, int paramInt) {
/*  435 */     if (paramInt == -1)
/*      */       return; 
/*  437 */     if (paramIntPtr.a == -1) {
/*  438 */       paramIntPtr.a = paramInt; return;
/*      */     } 
/*  440 */     int i = paramIntPtr.a;
/*      */     int j;
/*  442 */     while ((j = i(i)) != -1)
/*      */     {
/*  444 */       i = j; } 
/*  445 */     g(i, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   final void c(int paramInt) {
/*  451 */     if ((paramInt = this.n + paramInt) > this.a.maxstacksize) {
/*  452 */       if (paramInt >= 150)
/*  453 */         this.c.a("function or expression too complex"); 
/*  454 */       this.a.maxstacksize = paramInt;
/*      */     } 
/*      */   }
/*      */   
/*      */   final void d(int paramInt) {
/*  459 */     c(paramInt);
/*  460 */     this.n = (short)(this.n + paramInt);
/*      */   }
/*      */   
/*      */   private void m(int paramInt) {
/*  464 */     if (!ISK(paramInt) && paramInt >= this.l) {
/*  465 */       this.n = (short)(this.n - 1);
/*  466 */       a((paramInt == this.n));
/*      */     } 
/*      */   }
/*      */   
/*      */   private void m(LexState.expdesc paramexpdesc) {
/*  471 */     if (paramexpdesc.a == 6)
/*  472 */       m(paramexpdesc.b.d); 
/*      */   }
/*      */   private int b(LuaValue paramLuaValue) {
/*  475 */     if (this.o == null) {
/*  476 */       this.o = new Hashtable<>();
/*  477 */     } else if (this.o.containsKey(paramLuaValue)) {
/*  478 */       return ((Integer)this.o.get(paramLuaValue)).intValue();
/*      */     } 
/*  480 */     int i = this.h;
/*  481 */     this.o.put(paramLuaValue, Integer.valueOf(i));
/*      */     Prototype prototype;
/*  483 */     if ((prototype = this.a).k == null || this.h + 1 >= prototype.k.length)
/*  484 */       prototype.k = a(prototype.k, (this.h << 1) + 1); 
/*  485 */     prototype.k[this.h++] = paramLuaValue;
/*  486 */     return i;
/*      */   }
/*      */   
/*      */   final int a(LuaString paramLuaString) {
/*  490 */     return b((LuaValue)paramLuaString);
/*      */   }
/*      */   
/*      */   final int a(LuaValue paramLuaValue) {
/*      */     LuaNumber luaNumber;
/*      */     double d;
/*  496 */     int i = (int)(d = paramLuaValue.todouble());
/*  497 */     if (paramLuaValue instanceof LuaNumber && d == i) {
/*  498 */       luaNumber = LuaNumber.valueOf(i);
/*      */     }
/*  500 */     return b((LuaValue)luaNumber);
/*      */   }
/*      */   
/*      */   private int b(boolean paramBoolean) {
/*  504 */     return b(paramBoolean ? (LuaValue)LuaValue.TRUE : (LuaValue)LuaValue.FALSE);
/*      */   }
/*      */   
/*      */   private int e() {
/*  508 */     return b(LuaValue.NIL);
/*      */   }
/*      */   
/*      */   final void a(LexState.expdesc paramexpdesc, int paramInt) {
/*  512 */     if (paramexpdesc.a == 12) {
/*  513 */       d(a(paramexpdesc), paramInt + 1); return;
/*  514 */     }  if (paramexpdesc.a == 13) {
/*  515 */       c(a(paramexpdesc), paramInt + 1);
/*  516 */       b(a(paramexpdesc), this.n);
/*  517 */       d(1);
/*      */     } 
/*      */   }
/*      */   
/*      */   final void d(LexState.expdesc paramexpdesc) {
/*  522 */     if (paramexpdesc.a == 12) {
/*  523 */       paramexpdesc.a = 6;
/*  524 */       paramexpdesc.b.d = GETARG_A(b(paramexpdesc)); return;
/*  525 */     }  if (paramexpdesc.a == 13) {
/*  526 */       c(a(paramexpdesc), 2);
/*  527 */       paramexpdesc.a = 11;
/*      */     } 
/*      */   }
/*      */   final void e(LexState.expdesc paramexpdesc) {
/*      */     byte b;
/*  532 */     switch (paramexpdesc.a) {
/*      */       case 7:
/*  534 */         paramexpdesc.a = 6;
/*      */         return;
/*      */       
/*      */       case 8:
/*  538 */         paramexpdesc.b.d = b(5, 0, paramexpdesc.b.d, 0);
/*  539 */         paramexpdesc.a = 11;
/*      */         return;
/*      */       
/*      */       case 9:
/*  543 */         b = 6;
/*  544 */         m(paramexpdesc.b.a);
/*  545 */         if (paramexpdesc.b.c == 7) {
/*  546 */           m(paramexpdesc.b.b);
/*  547 */           b = 7;
/*      */         } 
/*  549 */         paramexpdesc.b.d = b(b, 0, paramexpdesc.b.b, paramexpdesc.b.a);
/*  550 */         paramexpdesc.a = 11;
/*      */         return;
/*      */       
/*      */       case 12:
/*      */       case 13:
/*  555 */         d(paramexpdesc);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int d(int paramInt1, int paramInt2, int paramInt3) {
/*  564 */     c();
/*  565 */     return b(3, paramInt1, paramInt2, paramInt3);
/*      */   }
/*      */   private void b(LexState.expdesc paramexpdesc, int paramInt) {
/*      */     InstructionPtr instructionPtr;
/*  569 */     e(paramexpdesc);
/*  570 */     switch (paramexpdesc.a) {
/*      */       case 1:
/*  572 */         b(paramInt, 1);
/*      */         break;
/*      */       
/*      */       case 2:
/*      */       case 3:
/*  577 */         b(3, paramInt, (paramexpdesc.a == 2) ? 1 : 0, 0);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 4:
/*  582 */         f(paramInt, paramexpdesc.b.d);
/*      */         break;
/*      */       
/*      */       case 5:
/*  586 */         f(paramInt, a(paramexpdesc.b.nval()));
/*      */         break;
/*      */ 
/*      */       
/*      */       case 11:
/*  591 */         b(instructionPtr = a(paramexpdesc), paramInt);
/*      */         break;
/*      */       
/*      */       case 6:
/*  595 */         if (paramInt != paramexpdesc.b.d) {
/*  596 */           b(0, paramInt, paramexpdesc.b.d, 0);
/*      */         }
/*      */         break;
/*      */       default:
/*  600 */         a((paramexpdesc.a == 0 || paramexpdesc.a == 10));
/*      */         return;
/*      */     } 
/*      */     
/*  604 */     paramexpdesc.b.d = paramInt;
/*  605 */     paramexpdesc.a = 6;
/*      */   }
/*      */   
/*      */   private void n(LexState.expdesc paramexpdesc) {
/*  609 */     if (paramexpdesc.a != 6) {
/*  610 */       d(1);
/*  611 */       b(paramexpdesc, this.n - 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c(LexState.expdesc paramexpdesc, int paramInt) {
/*  616 */     b(paramexpdesc, paramInt);
/*  617 */     if (paramexpdesc.a == 10)
/*  618 */       a(paramexpdesc.c, paramexpdesc.b.d); 
/*  619 */     if (paramexpdesc.a()) {
/*      */       
/*  621 */       int j = -1;
/*  622 */       int k = -1;
/*  623 */       if (k(paramexpdesc.c.a) || k(paramexpdesc.d.a)) {
/*      */         
/*  625 */         boolean bool = (paramexpdesc.a == 10) ? true : b();
/*  626 */         j = d(paramInt, 0, 1);
/*  627 */         k = d(paramInt, 1, 0);
/*  628 */         b(bool);
/*      */       } 
/*  630 */       int i = c();
/*  631 */       d(paramexpdesc.d.a, i, paramInt, j);
/*  632 */       d(paramexpdesc.c.a, i, paramInt, k);
/*      */     } 
/*  634 */     paramexpdesc.c.a = -1;
/*  635 */     paramexpdesc.b.d = paramInt;
/*  636 */     paramexpdesc.a = 6;
/*      */   }
/*      */   
/*      */   final void f(LexState.expdesc paramexpdesc) {
/*  640 */     e(paramexpdesc);
/*  641 */     m(paramexpdesc);
/*  642 */     d(1);
/*  643 */     c(paramexpdesc, this.n - 1);
/*      */   }
/*      */   
/*      */   final int g(LexState.expdesc paramexpdesc) {
/*  647 */     e(paramexpdesc);
/*  648 */     if (paramexpdesc.a == 6) {
/*  649 */       if (!paramexpdesc.a())
/*  650 */         return paramexpdesc.b.d; 
/*  651 */       if (paramexpdesc.b.d >= this.l) {
/*  652 */         c(paramexpdesc, paramexpdesc.b.d);
/*  653 */         return paramexpdesc.b.d;
/*      */       } 
/*      */     } 
/*  656 */     f(paramexpdesc);
/*  657 */     return paramexpdesc.b.d;
/*      */   }
/*      */   
/*      */   final void h(LexState.expdesc paramexpdesc) {
/*  661 */     if (paramexpdesc.a != 8 || paramexpdesc.a())
/*  662 */       g(paramexpdesc); 
/*      */   }
/*      */   
/*      */   final void i(LexState.expdesc paramexpdesc) {
/*  666 */     if (paramexpdesc.a()) {
/*  667 */       g(paramexpdesc); return;
/*      */     } 
/*  669 */     e(paramexpdesc);
/*      */   }
/*      */   
/*      */   final int j(LexState.expdesc paramexpdesc) {
/*  673 */     i(paramexpdesc);
/*  674 */     switch (paramexpdesc.a) {
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*  678 */         if (this.h <= 255) {
/*  679 */           paramexpdesc.b
/*  680 */             .d = (paramexpdesc.a == 1) ? e() : b((paramexpdesc.a == 2));
/*  681 */           paramexpdesc.a = 4;
/*  682 */           return RKASK(paramexpdesc.b.d);
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 5:
/*  687 */         paramexpdesc.b.d = a(paramexpdesc.b.nval());
/*  688 */         paramexpdesc.a = 4;
/*      */ 
/*      */       
/*      */       case 4:
/*  692 */         if (paramexpdesc.b.d <= 255) {
/*  693 */           return RKASK(paramexpdesc.b.d);
/*      */         }
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  701 */     return g(paramexpdesc);
/*      */   }
/*      */   final void a(LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2) {
/*      */     int i, j;
/*  705 */     switch (paramexpdesc1.a) {
/*      */       case 7:
/*  707 */         m(paramexpdesc2);
/*  708 */         c(paramexpdesc2, paramexpdesc1.b.d);
/*      */         return;
/*      */       
/*      */       case 8:
/*  712 */         i = g(paramexpdesc2);
/*  713 */         b(9, i, paramexpdesc1.b.d, 0);
/*      */         break;
/*      */       
/*      */       case 9:
/*  717 */         i = (paramexpdesc1.b.c == 7) ? 10 : 8;
/*  718 */         j = j(paramexpdesc2);
/*  719 */         b(i, paramexpdesc1.b.b, paramexpdesc1.b.a, j);
/*      */         break;
/*      */       
/*      */       default:
/*  723 */         a(false);
/*      */         break;
/*      */     } 
/*      */     
/*  727 */     m(paramexpdesc2);
/*      */   }
/*      */ 
/*      */   
/*      */   final void b(LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2) {
/*  732 */     g(paramexpdesc1);
/*  733 */     m(paramexpdesc1);
/*  734 */     short s = this.n;
/*  735 */     d(2);
/*  736 */     b(12, s, paramexpdesc1.b.d, j(paramexpdesc2));
/*  737 */     m(paramexpdesc2);
/*  738 */     paramexpdesc1.b.d = s;
/*  739 */     paramexpdesc1.a = 6;
/*      */   }
/*      */   
/*      */   private void o(LexState.expdesc paramexpdesc) {
/*      */     InstructionPtr instructionPtr;
/*  744 */     a((testTMode(GET_OPCODE((instructionPtr = j(paramexpdesc.b.d)).a())) && 
/*  745 */         GET_OPCODE(instructionPtr.a()) != 28 && 
/*  746 */         Lua.GET_OPCODE(instructionPtr.a()) != 27));
/*      */ 
/*      */     
/*  749 */     int i = ((i = GETARG_A(instructionPtr.a())) != 0) ? 0 : 1;
/*  750 */     b(instructionPtr, i);
/*      */   }
/*      */   private int d(LexState.expdesc paramexpdesc, int paramInt) {
/*      */     int i;
/*  754 */     if (paramexpdesc.a == 11 && 
/*      */       
/*  756 */       GET_OPCODE(i = b(paramexpdesc)) == 20) {
/*  757 */       this.e--;
/*  758 */       return c(27, GETARG_B(i), 0, (paramInt != 0) ? 0 : 1);
/*      */     } 
/*      */ 
/*      */     
/*  762 */     n(paramexpdesc);
/*  763 */     m(paramexpdesc);
/*  764 */     return c(28, 255, paramexpdesc.b.d, paramInt);
/*      */   }
/*      */   
/*      */   final void k(LexState.expdesc paramexpdesc) {
/*      */     int i;
/*  769 */     e(paramexpdesc);
/*  770 */     switch (paramexpdesc.a) {
/*      */       case 10:
/*  772 */         o(paramexpdesc);
/*  773 */         i = paramexpdesc.b.d;
/*      */         break;
/*      */       
/*      */       case 2:
/*      */       case 4:
/*      */       case 5:
/*  779 */         i = -1;
/*      */         break;
/*      */       
/*      */       default:
/*  783 */         i = d(paramexpdesc, 0);
/*      */         break;
/*      */     } 
/*      */     
/*  787 */     a(paramexpdesc.d, i);
/*  788 */     b(paramexpdesc.c.a);
/*  789 */     paramexpdesc.c.a = -1;
/*      */   }
/*      */   
/*      */   final void l(LexState.expdesc paramexpdesc) {
/*      */     int i;
/*  794 */     e(paramexpdesc);
/*  795 */     switch (paramexpdesc.a) {
/*      */       case 10:
/*  797 */         i = paramexpdesc.b.d;
/*      */         break;
/*      */       
/*      */       case 1:
/*      */       case 3:
/*  802 */         i = -1;
/*      */         break;
/*      */       
/*      */       default:
/*  806 */         i = d(paramexpdesc, 1);
/*      */         break;
/*      */     } 
/*      */     
/*  810 */     a(paramexpdesc.c, i);
/*  811 */     b(paramexpdesc.d.a);
/*  812 */     paramexpdesc.d.a = -1;
/*      */   }
/*      */   
/*      */   private void p(LexState.expdesc paramexpdesc) {
/*  816 */     e(paramexpdesc);
/*  817 */     switch (paramexpdesc.a) {
/*      */       case 1:
/*      */       case 3:
/*  820 */         paramexpdesc.a = 2;
/*      */         break;
/*      */       
/*      */       case 2:
/*      */       case 4:
/*      */       case 5:
/*  826 */         paramexpdesc.a = 3;
/*      */         break;
/*      */       
/*      */       case 10:
/*  830 */         o(paramexpdesc);
/*      */         break;
/*      */       
/*      */       case 6:
/*      */       case 11:
/*  835 */         n(paramexpdesc);
/*  836 */         m(paramexpdesc);
/*  837 */         paramexpdesc.b.d = b(20, 0, paramexpdesc.b.d, 0);
/*  838 */         paramexpdesc.a = 11;
/*      */         break;
/*      */       
/*      */       default:
/*  842 */         a(false);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  848 */     int i = paramexpdesc.d.a;
/*  849 */     paramexpdesc.d.a = paramexpdesc.c.a;
/*  850 */     paramexpdesc.c.a = i;
/*      */     
/*  852 */     l(paramexpdesc.d.a);
/*  853 */     l(paramexpdesc.c.a);
/*      */   }
/*      */   
/*      */   private static boolean n(int paramInt) {
/*  857 */     return (paramInt == 6 || paramInt == 7);
/*      */   }
/*      */   
/*      */   final void c(LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2) {
/*  861 */     paramexpdesc1.b.b = (short)paramexpdesc1.b.d;
/*  862 */     paramexpdesc1.b.a = (short)j(paramexpdesc2);
/*  863 */     LuaC.a((paramexpdesc1.a == 8 || n(paramexpdesc1.a)));
/*  864 */     paramexpdesc1.b.c = (short)((paramexpdesc1.a == 8) ? 8 : 7);
/*  865 */     paramexpdesc1.a = 9;
/*      */   }
/*      */   
/*      */   private static boolean a(int paramInt, LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2) {
/*      */     LuaValue luaValue1;
/*  870 */     if (!paramexpdesc1.b() || !paramexpdesc2.b())
/*  871 */       return false; 
/*  872 */     if ((paramInt == 16 || paramInt == 17) && paramexpdesc2.b.nval().eq_b((LuaValue)LuaValue.ZERO))
/*  873 */       return false; 
/*  874 */     LuaValue luaValue3 = paramexpdesc1.b.nval();
/*  875 */     LuaValue luaValue2 = paramexpdesc2.b.nval();
/*  876 */     switch (paramInt) {
/*      */       case 13:
/*  878 */         luaValue1 = luaValue3.add(luaValue2);
/*      */         break;
/*      */       case 14:
/*  881 */         luaValue1 = luaValue3.sub(luaValue2);
/*      */         break;
/*      */       case 15:
/*  884 */         luaValue1 = luaValue3.mul(luaValue2);
/*      */         break;
/*      */       case 16:
/*  887 */         luaValue1 = luaValue3.div(luaValue2);
/*      */         break;
/*      */       case 17:
/*  890 */         luaValue1 = luaValue3.mod(luaValue2);
/*      */         break;
/*      */       case 18:
/*  893 */         luaValue1 = luaValue3.pow(luaValue2);
/*      */         break;
/*      */       case 19:
/*  896 */         luaValue1 = luaValue3.neg();
/*      */         break;
/*      */ 
/*      */       
/*      */       case 21:
/*  901 */         return false;
/*      */       default:
/*  903 */         a(false);
/*  904 */         luaValue1 = null;
/*      */         break;
/*      */     } 
/*  907 */     if (Double.isNaN(luaValue1.todouble()))
/*  908 */       return false; 
/*  909 */     paramexpdesc1.b.setNval(luaValue1);
/*  910 */     return true;
/*      */   }
/*      */   
/*      */   private void b(int paramInt1, LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2, int paramInt2) {
/*  914 */     if (a(paramInt1, paramexpdesc1, paramexpdesc2)) {
/*      */       return;
/*      */     }
/*      */     
/*  918 */     byte b = (paramInt1 != 19 && paramInt1 != 21) ? j(paramexpdesc2) : 0;
/*      */     int i;
/*  920 */     if ((i = j(paramexpdesc1)) > b) {
/*  921 */       m(paramexpdesc1);
/*  922 */       m(paramexpdesc2);
/*      */     } else {
/*  924 */       m(paramexpdesc2);
/*  925 */       m(paramexpdesc1);
/*      */     } 
/*  927 */     paramexpdesc1.b.d = b(paramInt1, 0, i, b);
/*  928 */     paramexpdesc1.a = 11;
/*  929 */     e(paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   private void a(int paramInt1, int paramInt2, LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2) {
/*  934 */     int i = j(paramexpdesc1);
/*  935 */     int j = j(paramexpdesc2);
/*  936 */     m(paramexpdesc2);
/*  937 */     m(paramexpdesc1);
/*  938 */     if (paramInt2 == 0 && paramInt1 != 24) {
/*      */       
/*  940 */       paramInt2 = i;
/*  941 */       i = j;
/*  942 */       j = paramInt2;
/*  943 */       paramInt2 = 1;
/*      */     } 
/*  945 */     paramexpdesc1.b.d = c(paramInt1, paramInt2, i, j);
/*  946 */     paramexpdesc1.a = 10;
/*      */   }
/*      */   
/*      */   final void a(int paramInt1, LexState.expdesc paramexpdesc, int paramInt2) {
/*      */     LexState.expdesc expdesc1;
/*  951 */     (expdesc1 = new LexState.expdesc()).a(5, 0);
/*  952 */     switch (paramInt1) {
/*      */       case 0:
/*  954 */         if (paramexpdesc.b()) {
/*  955 */           paramexpdesc.b.setNval(paramexpdesc.b.nval().neg()); return;
/*      */         } 
/*  957 */         g(paramexpdesc);
/*  958 */         b(19, paramexpdesc, expdesc1, paramInt2);
/*      */         return;
/*      */ 
/*      */       
/*      */       case 1:
/*  963 */         p(paramexpdesc);
/*      */         return;
/*      */       case 2:
/*  966 */         g(paramexpdesc);
/*  967 */         b(21, paramexpdesc, expdesc1, paramInt2);
/*      */         return;
/*      */     } 
/*      */     
/*  971 */     a(false);
/*      */   }
/*      */ 
/*      */   
/*      */   final void a(int paramInt, LexState.expdesc paramexpdesc) {
/*  976 */     switch (paramInt) {
/*      */       case 13:
/*  978 */         k(paramexpdesc);
/*      */         return;
/*      */       
/*      */       case 14:
/*  982 */         l(paramexpdesc);
/*      */         return;
/*      */       
/*      */       case 6:
/*  986 */         f(paramexpdesc);
/*      */         return;
/*      */       
/*      */       case 0:
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*      */       case 4:
/*      */       case 5:
/*  995 */         if (!paramexpdesc.b()) {
/*  996 */           j(paramexpdesc); return;
/*      */         } 
/*      */         return;
/*      */     } 
/* 1000 */     j(paramexpdesc);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void a(int paramInt1, LexState.expdesc paramexpdesc1, LexState.expdesc paramexpdesc2, int paramInt2) {
/* 1008 */     switch (paramInt1) {
/*      */       case 13:
/* 1010 */         a((paramexpdesc1.c.a == -1));
/* 1011 */         e(paramexpdesc2);
/* 1012 */         a(paramexpdesc2.d, paramexpdesc1.d.a);
/*      */         
/* 1014 */         paramexpdesc1.setvalue(paramexpdesc2);
/*      */         return;
/*      */       
/*      */       case 14:
/* 1018 */         a((paramexpdesc1.d.a == -1));
/* 1019 */         e(paramexpdesc2);
/* 1020 */         a(paramexpdesc2.c, paramexpdesc1.c.a);
/*      */         
/* 1022 */         paramexpdesc1.setvalue(paramexpdesc2);
/*      */         return;
/*      */       
/*      */       case 6:
/* 1026 */         i(paramexpdesc2);
/* 1027 */         if (paramexpdesc2.a == 11 && 
/* 1028 */           GET_OPCODE(b(paramexpdesc2)) == 22) {
/* 1029 */           a((paramexpdesc1.b.d == GETARG_B(b(paramexpdesc2)) - 1));
/* 1030 */           m(paramexpdesc1);
/* 1031 */           c(a(paramexpdesc2), paramexpdesc1.b.d);
/* 1032 */           paramexpdesc1.a = 11;
/* 1033 */           paramexpdesc1.b.d = paramexpdesc2.b.d; return;
/*      */         } 
/* 1035 */         f(paramexpdesc2);
/* 1036 */         b(22, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */ 
/*      */       
/*      */       case 0:
/* 1041 */         b(13, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */       case 1:
/* 1044 */         b(14, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */       case 2:
/* 1047 */         b(15, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */       case 3:
/* 1050 */         b(16, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */       case 4:
/* 1053 */         b(17, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */       case 5:
/* 1056 */         b(18, paramexpdesc1, paramexpdesc2, paramInt2);
/*      */         return;
/*      */       case 8:
/* 1059 */         a(24, 1, paramexpdesc1, paramexpdesc2);
/*      */         return;
/*      */       case 7:
/* 1062 */         a(24, 0, paramexpdesc1, paramexpdesc2);
/*      */         return;
/*      */       case 9:
/* 1065 */         a(25, 1, paramexpdesc1, paramexpdesc2);
/*      */         return;
/*      */       case 10:
/* 1068 */         a(26, 1, paramexpdesc1, paramexpdesc2);
/*      */         return;
/*      */       case 11:
/* 1071 */         a(25, 0, paramexpdesc1, paramexpdesc2);
/*      */         return;
/*      */       case 12:
/* 1074 */         a(26, 0, paramexpdesc1, paramexpdesc2);
/*      */         return;
/*      */     } 
/* 1077 */     a(false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   final void e(int paramInt) {
/* 1083 */     this.a.lineinfo[this.e - 1] = paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private int i(int paramInt1, int paramInt2) {
/* 1088 */     Prototype prototype = this.a;
/* 1089 */     d();
/*      */     
/* 1091 */     if (prototype.code == null || this.e + 1 > prototype.code.length)
/* 1092 */       prototype.code = LuaC.a(prototype.code, (this.e << 1) + 1); 
/* 1093 */     prototype.code[this.e] = paramInt1;
/*      */     
/* 1095 */     if (prototype.lineinfo == null || this.e + 1 > prototype.lineinfo.length) {
/* 1096 */       prototype.lineinfo = LuaC.a(prototype.lineinfo, (this.e << 1) + 1);
/*      */     }
/* 1098 */     prototype.lineinfo[this.e] = paramInt2;
/* 1099 */     return this.e++;
/*      */   }
/*      */ 
/*      */   
/*      */   final int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 1104 */     a((getOpMode(paramInt1) == 0));
/* 1105 */     a((getBMode(paramInt1) != 0 || paramInt3 == 0));
/* 1106 */     a((getCMode(paramInt1) != 0 || paramInt4 == 0));
/* 1107 */     return i(a(paramInt1, paramInt2, paramInt3, paramInt4), this.c.a);
/*      */   }
/*      */ 
/*      */   
/*      */   final int c(int paramInt1, int paramInt2, int paramInt3) {
/* 1112 */     a((getOpMode(paramInt1) == 1 || getOpMode(paramInt1) == 2));
/* 1113 */     a((getCMode(paramInt1) == 0));
/* 1114 */     a((paramInt3 >= 0 && paramInt3 <= 262143));
/* 1115 */     return i(a(paramInt1, paramInt2, paramInt3), this.c.a);
/*      */   }
/*      */   
/*      */   private int o(int paramInt) {
/* 1119 */     a((paramInt <= 67108863));
/* 1120 */     return i(a(39, paramInt), this.c.a);
/*      */   }
/*      */   
/*      */   final int f(int paramInt1, int paramInt2) {
/* 1124 */     if (paramInt2 <= 262143) {
/* 1125 */       return c(1, paramInt1, paramInt2);
/*      */     }
/* 1127 */     paramInt1 = c(2, paramInt1, 0);
/* 1128 */     o(paramInt2);
/* 1129 */     return paramInt1;
/*      */   }
/*      */ 
/*      */   
/*      */   private void e(int paramInt1, int paramInt2, int paramInt3) {
/* 1134 */     paramInt2 = (paramInt2 - 1) / 50 + 1;
/* 1135 */     boolean bool = (paramInt3 == -1) ? false : paramInt3;
/* 1136 */     a((paramInt3 != 0));
/* 1137 */     if (paramInt2 <= 511) {
/* 1138 */       b(36, paramInt1, bool, paramInt2);
/*      */     } else {
/* 1140 */       b(36, paramInt1, bool, 0);
/* 1141 */       i(paramInt2, this.c.a);
/*      */     } 
/* 1143 */     this.n = (short)(paramInt1 + 1);
/*      */   }
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\compiler\FuncState.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */