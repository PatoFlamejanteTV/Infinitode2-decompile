/*     */ package com.prineside.luaj;
/*     */ 
/*     */ import com.prineside.tdi2.utils.logging.TLog;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TailcallVarargs
/*     */   extends Varargs
/*     */ {
/*  45 */   private static final TLog a = TLog.forClass(TailcallVarargs.class);
/*     */   
/*     */   private LuaValue b;
/*     */   
/*     */   private Varargs c;
/*     */   
/*     */   private Varargs d;
/*     */ 
/*     */   
/*     */   public TailcallVarargs(LuaValue paramLuaValue, Varargs paramVarargs) {
/*  55 */     this.b = paramLuaValue;
/*  56 */     this.c = paramVarargs;
/*     */   }
/*     */   
/*     */   public final boolean isTailcall() {
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public final Varargs eval() {
/*  64 */     byte b = 0;
/*  65 */     while (this.d == null) {
/*     */       Varargs varargs;
/*  67 */       if ((varargs = this.b.onInvoke(this.c)).isTailcall()) {
/*  68 */         varargs = varargs;
/*  69 */         this.b = ((TailcallVarargs)varargs).b;
/*  70 */         this.c = ((TailcallVarargs)varargs).c;
/*  71 */         b++;
/*  72 */         if (b == 5000000) {
/*  73 */           a.e("Tail call failed after 5,000,000 attempts", new Object[0]);
/*  74 */           return LuaValue.NIL;
/*     */         } 
/*     */         continue;
/*     */       } 
/*  78 */       this.d = varargs;
/*  79 */       this.b = null;
/*  80 */       this.c = null;
/*     */     } 
/*     */     
/*  83 */     return this.d;
/*     */   }
/*     */   
/*     */   public final LuaValue arg(int paramInt) {
/*  87 */     if (this.d == null)
/*  88 */       eval(); 
/*  89 */     return this.d.arg(paramInt);
/*     */   }
/*     */   
/*     */   public final LuaValue arg1() {
/*  93 */     if (this.d == null)
/*  94 */       eval(); 
/*  95 */     return this.d.arg1();
/*     */   }
/*     */   
/*     */   public final int narg() {
/*  99 */     if (this.d == null)
/* 100 */       eval(); 
/* 101 */     return this.d.narg();
/*     */   }
/*     */   
/*     */   public final Varargs subargs(int paramInt) {
/* 105 */     if (paramInt <= 1) LuaValue.argerror(1, "start must be > 1");
/*     */     
/* 107 */     if (this.d == null)
/* 108 */       eval(); 
/* 109 */     return this.d.subargs(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\prineside\luaj\TailcallVarargs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */