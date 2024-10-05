/*     */ package com.prineside.luaj;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Varargs
/*     */ {
/*     */   public abstract LuaValue arg(int paramInt);
/*     */   
/*     */   public abstract int narg();
/*     */   
/*     */   public abstract LuaValue arg1();
/*     */   
/*     */   public Varargs eval() {
/*  70 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTailcall() {
/*  77 */     return false;
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
/*     */   public int type(int paramInt) {
/*  96 */     return arg(paramInt).type();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isnil(int paramInt) {
/* 103 */     return arg(paramInt).isnil();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isfunction(int paramInt) {
/* 110 */     return arg(paramInt).isfunction();
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
/*     */   public boolean isnumber(int paramInt) {
/* 122 */     return arg(paramInt).isnumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isstring(int paramInt) {
/* 132 */     return arg(paramInt).isstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean istable(int paramInt) {
/* 139 */     return arg(paramInt).istable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isuserdata(int paramInt) {
/* 146 */     return arg(paramInt).isuserdata();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isvalue(int paramInt) {
/* 152 */     return (paramInt > 0 && paramInt <= narg());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean optboolean(int paramInt, boolean paramBoolean) {
/* 159 */     return arg(paramInt).optboolean(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaClosure optclosure(int paramInt, LuaClosure paramLuaClosure) {
/* 166 */     return arg(paramInt).optclosure(paramLuaClosure);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double optdouble(int paramInt, double paramDouble) {
/* 173 */     return arg(paramInt).optdouble(paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaFunction optfunction(int paramInt, LuaFunction paramLuaFunction) {
/* 180 */     return arg(paramInt).optfunction(paramLuaFunction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int optint(int paramInt1, int paramInt2) {
/* 187 */     return arg(paramInt1).optint(paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long optlong(int paramInt, long paramLong) {
/* 194 */     return arg(paramInt).optlong(paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaNumber optnumber(int paramInt, LuaNumber paramLuaNumber) {
/* 201 */     return arg(paramInt).optnumber(paramLuaNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String optjstring(int paramInt, String paramString) {
/* 208 */     return arg(paramInt).optjstring(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaString optstring(int paramInt, LuaString paramLuaString) {
/* 215 */     return arg(paramInt).optstring(paramLuaString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaTable opttable(int paramInt, LuaTable paramLuaTable) {
/* 222 */     return arg(paramInt).opttable(paramLuaTable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object optuserdata(int paramInt, Object paramObject) {
/* 229 */     return arg(paramInt).optuserdata(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object optuserdata(int paramInt, Class paramClass, Object paramObject) {
/* 238 */     return arg(paramInt).optuserdata(paramClass, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue optvalue(int paramInt, LuaValue paramLuaValue) {
/* 245 */     return (paramInt > 0 && paramInt <= narg()) ? arg(paramInt) : paramLuaValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean checkboolean(int paramInt) {
/* 252 */     return arg(paramInt).checkboolean();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaClosure checkclosure(int paramInt) {
/* 259 */     return arg(paramInt).checkclosure();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double checkdouble(int paramInt) {
/* 266 */     return arg(paramInt).checkdouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaFunction checkfunction(int paramInt) {
/* 273 */     return arg(paramInt).checkfunction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int checkint(int paramInt) {
/* 280 */     return arg(paramInt).checkint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long checklong(int paramInt) {
/* 287 */     return arg(paramInt).checklong();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaNumber checknumber(int paramInt) {
/* 294 */     return arg(paramInt).checknumber();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String checkjstring(int paramInt) {
/* 301 */     return arg(paramInt).checkjstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaString checkstring(int paramInt) {
/* 308 */     return arg(paramInt).checkstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaTable checktable(int paramInt) {
/* 315 */     return arg(paramInt).checktable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object checkuserdata(int paramInt) {
/* 322 */     return arg(paramInt).checkuserdata();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object checkuserdata(int paramInt, Class paramClass) {
/* 331 */     return arg(paramInt).checkuserdata(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue checkvalue(int paramInt) {
/* 338 */     return (paramInt <= narg()) ? arg(paramInt) : LuaValue.argerror(paramInt, "value expected");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LuaValue checknotnil(int paramInt) {
/* 345 */     return arg(paramInt).checknotnil();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void argcheck(boolean paramBoolean, int paramInt, String paramString) {
/* 355 */     if (!paramBoolean) LuaValue.argerror(paramInt, paramString);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isnoneornil(int paramInt) {
/* 362 */     return (paramInt > narg() || arg(paramInt).isnil());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean toboolean(int paramInt) {
/* 369 */     return arg(paramInt).toboolean();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte tobyte(int paramInt) {
/* 376 */     return arg(paramInt).tobyte();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char tochar(int paramInt) {
/* 383 */     return arg(paramInt).tochar();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double todouble(int paramInt) {
/* 389 */     return arg(paramInt).todouble();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float tofloat(int paramInt) {
/* 396 */     return arg(paramInt).tofloat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int toint(int paramInt) {
/* 403 */     return arg(paramInt).toint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long tolong(int paramInt) {
/* 410 */     return arg(paramInt).tolong();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String tojstring(int paramInt) {
/* 416 */     return arg(paramInt).tojstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short toshort(int paramInt) {
/* 423 */     return arg(paramInt).toshort();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object touserdata(int paramInt) {
/* 429 */     return arg(paramInt).touserdata();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T touserdata(int paramInt, Class<T> paramClass) {
/* 436 */     return arg(paramInt).touserdata(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String tojstring() {
/*     */     Buffer buffer;
/* 443 */     (buffer = new Buffer()).append("("); byte b; int i;
/* 444 */     for (b = 1, i = narg(); b <= i; b++) {
/* 445 */       if (b > 1) buffer.append(","); 
/* 446 */       buffer.append(arg(b).getClass().getSimpleName()).append(" ").append(arg(b).tojstring());
/*     */     } 
/* 448 */     buffer.append(")");
/* 449 */     return buffer.tojstring();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 456 */     return tojstring();
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract Varargs subargs(int paramInt);
/*     */ 
/*     */   
/*     */   static class SubVarargs
/*     */     extends Varargs
/*     */   {
/*     */     private final Varargs a;
/*     */     
/*     */     private final int b;
/*     */     
/*     */     private final int c;
/*     */ 
/*     */     
/*     */     public SubVarargs(Varargs param1Varargs, int param1Int1, int param1Int2) {
/* 474 */       this.a = param1Varargs;
/* 475 */       this.b = param1Int1;
/* 476 */       this.c = param1Int2;
/*     */     }
/*     */     
/*     */     public LuaValue arg(int param1Int) {
/* 480 */       if ((param1Int = param1Int + this.b - 1) >= this.b && param1Int <= this.c) return this.a.arg(param1Int);  return LuaValue.NIL;
/*     */     }
/*     */     public LuaValue arg1() {
/* 483 */       return this.a.arg(this.b);
/*     */     }
/*     */     public int narg() {
/* 486 */       return this.c + 1 - this.b;
/*     */     }
/*     */     public Varargs subargs(int param1Int) {
/* 489 */       if (param1Int == 1)
/* 490 */         return this; 
/* 491 */       int i = this.b + param1Int - 1;
/* 492 */       if (param1Int > 0) {
/* 493 */         if (i >= this.c)
/* 494 */           return LuaValue.NONE; 
/* 495 */         if (i == this.c)
/* 496 */           return this.a.arg(this.c); 
/* 497 */         if (i == this.c - 1)
/* 498 */           return new Varargs.PairVarargs(this.a.arg(this.c - 1), this.a.arg(this.c)); 
/* 499 */         return new SubVarargs(this.a, i, this.c);
/*     */       } 
/* 501 */       return new SubVarargs(this.a, i, this.c);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class PairVarargs
/*     */     extends Varargs
/*     */   {
/*     */     private final LuaValue a;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Varargs b;
/*     */ 
/*     */ 
/*     */     
/*     */     PairVarargs(LuaValue param1LuaValue, Varargs param1Varargs) {
/* 520 */       this.a = param1LuaValue;
/* 521 */       this.b = param1Varargs;
/*     */     }
/*     */     public final LuaValue arg(int param1Int) {
/* 524 */       return (param1Int == 1) ? this.a : this.b.arg(param1Int - 1);
/*     */     }
/*     */     public final int narg() {
/* 527 */       return 1 + this.b.narg();
/*     */     }
/*     */     public final LuaValue arg1() {
/* 530 */       return this.a;
/*     */     }
/*     */     public final Varargs subargs(int param1Int) {
/* 533 */       if (param1Int == 1)
/* 534 */         return this; 
/* 535 */       if (param1Int == 2)
/* 536 */         return this.b; 
/* 537 */       if (param1Int > 2)
/* 538 */         return this.b.subargs(param1Int - 1); 
/* 539 */       return LuaValue.argerror(1, "start must be > 0");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class ArrayVarargs
/*     */     extends Varargs
/*     */   {
/*     */     private final LuaValue[] a;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Varargs b;
/*     */ 
/*     */ 
/*     */     
/*     */     ArrayVarargs(LuaValue[] param1ArrayOfLuaValue, Varargs param1Varargs) {
/* 558 */       this.a = param1ArrayOfLuaValue;
/* 559 */       this.b = param1Varargs;
/*     */     }
/*     */     public final LuaValue arg(int param1Int) {
/* 562 */       return (param1Int <= 0) ? LuaValue.NIL : ((param1Int <= this.a.length) ? this.a[param1Int - 1] : this.b.arg(param1Int - this.a.length));
/*     */     }
/*     */     public final int narg() {
/* 565 */       return this.a.length + this.b.narg();
/*     */     } public final LuaValue arg1() {
/* 567 */       return (this.a.length > 0) ? this.a[0] : this.b.arg1();
/*     */     } public final Varargs subargs(int param1Int) {
/* 569 */       if (param1Int <= 0)
/* 570 */         LuaValue.argerror(1, "start must be > 0"); 
/* 571 */       if (param1Int == 1)
/* 572 */         return this; 
/* 573 */       if (param1Int > this.a.length)
/* 574 */         return this.b.subargs(param1Int - this.a.length); 
/* 575 */       return LuaValue.varargsOf(this.a, param1Int - 1, this.a.length - param1Int - 1, this.b);
/*     */     }
/*     */     final void a(LuaValue[] param1ArrayOfLuaValue, int param1Int1, int param1Int2) {
/* 578 */       int i = Math.min(this.a.length, param1Int2);
/* 579 */       System.arraycopy(this.a, 0, param1ArrayOfLuaValue, param1Int1, i);
/* 580 */       this.b.a(param1ArrayOfLuaValue, param1Int1 + i, param1Int2 - i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class ArrayPartVarargs
/*     */     extends Varargs
/*     */   {
/*     */     private final int a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final LuaValue[] b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int c;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Varargs d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArrayPartVarargs(LuaValue[] param1ArrayOfLuaValue, int param1Int1, int param1Int2, Varargs param1Varargs) {
/* 611 */       this.b = param1ArrayOfLuaValue;
/* 612 */       this.a = param1Int1;
/* 613 */       this.c = param1Int2;
/* 614 */       this.d = param1Varargs;
/*     */     }
/*     */     public final LuaValue arg(int param1Int) {
/* 617 */       return (param1Int <= 0) ? LuaValue.NIL : ((param1Int <= this.c) ? this.b[this.a + param1Int - 1] : this.d.arg(param1Int - this.c));
/*     */     }
/*     */     public final int narg() {
/* 620 */       return this.c + this.d.narg();
/*     */     }
/*     */     public final LuaValue arg1() {
/* 623 */       return (this.c > 0) ? this.b[this.a] : this.d.arg1();
/*     */     }
/*     */     public final Varargs subargs(int param1Int) {
/* 626 */       if (param1Int <= 0)
/* 627 */         LuaValue.argerror(1, "start must be > 0"); 
/* 628 */       if (param1Int == 1)
/* 629 */         return this; 
/* 630 */       if (param1Int > this.c)
/* 631 */         return this.d.subargs(param1Int - this.c); 
/* 632 */       return LuaValue.varargsOf(this.b, this.a + param1Int - 1, this.c - param1Int - 1, this.d);
/*     */     }
/*     */     final void a(LuaValue[] param1ArrayOfLuaValue, int param1Int1, int param1Int2) {
/* 635 */       int i = Math.min(this.c, param1Int2);
/* 636 */       System.arraycopy(this.b, this.a, param1ArrayOfLuaValue, param1Int1, i);
/* 637 */       this.d.a(param1ArrayOfLuaValue, param1Int1 + i, param1Int2 - i);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void a(LuaValue[] paramArrayOfLuaValue, int paramInt1, int paramInt2) {
/* 646 */     for (byte b = 0; b < paramInt2; b++) {
/* 647 */       paramArrayOfLuaValue[paramInt1 + b] = arg(b + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Varargs dealias() {
/*     */     int i;
/* 658 */     switch (i = narg()) { case 0:
/* 659 */         return LuaValue.NONE;
/* 660 */       case 1: return arg1();
/* 661 */       case 2: return new PairVarargs(arg1(), arg(2)); }
/*     */     
/* 663 */     LuaValue[] arrayOfLuaValue = new LuaValue[i];
/* 664 */     a(arrayOfLuaValue, 0, i);
/* 665 */     return new ArrayVarargs(arrayOfLuaValue, LuaValue.NONE);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\Varargs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */