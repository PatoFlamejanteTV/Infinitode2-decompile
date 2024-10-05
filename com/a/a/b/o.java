/*     */ package com.a.a.b;
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
/*     */ public enum o
/*     */ {
/*  31 */   a(null, -1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   b("{", 1),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  43 */   c("}", 2),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  49 */   d("[", 3),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   e("]", 4),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   f(null, 5),
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
/*  73 */   g(null, 12),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   h(null, 6),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   i(null, 7),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  99 */   j(null, 8),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 105 */   k("true", 9),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 111 */   l("false", 10),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 117 */   m("null", 11);
/*     */ 
/*     */   
/*     */   private String n;
/*     */ 
/*     */   
/*     */   private char[] o;
/*     */ 
/*     */   
/*     */   private byte[] p;
/*     */ 
/*     */   
/*     */   private int q;
/*     */ 
/*     */   
/*     */   private boolean r;
/*     */ 
/*     */   
/*     */   private boolean s;
/*     */   
/*     */   private boolean t;
/*     */   
/*     */   private boolean u;
/*     */ 
/*     */   
/*     */   o(String paramString1, int paramInt1) {
/* 143 */     if (paramString1 == null) {
/* 144 */       this.n = null;
/* 145 */       this.o = null;
/* 146 */       this.p = null;
/*     */     } else {
/* 148 */       this.n = paramString1;
/* 149 */       this.o = paramString1.toCharArray();
/*     */       
/* 151 */       int i = this.o.length;
/* 152 */       this.p = new byte[i];
/* 153 */       for (this$enum$index = 0; this$enum$index < i; this$enum$index++) {
/* 154 */         this.p[this$enum$index] = (byte)this.o[this$enum$index];
/*     */       }
/*     */     } 
/* 157 */     this.q = paramInt1;
/*     */ 
/*     */     
/* 160 */     this.t = (paramInt1 == 7 || paramInt1 == 8);
/*     */     
/* 162 */     this.r = (paramInt1 == 1 || paramInt1 == 3);
/* 163 */     this.s = (paramInt1 == 2 || paramInt1 == 4);
/*     */     
/* 165 */     this.u = (!this.r && !this.s && paramInt1 != 5 && paramInt1 != -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int a() {
/* 170 */     return this.q;
/*     */   }
/* 172 */   public final String b() { return this.n; } public final char[] c() {
/* 173 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean d() {
/* 180 */     return this.t;
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
/*     */   public final boolean e() {
/* 193 */     return this.r;
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
/*     */   public final boolean f() {
/* 206 */     return this.s;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean g() {
/* 217 */     return this.u;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\b\o.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */