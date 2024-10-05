/*     */ package org.a.b.g;
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
/*     */ final class b
/*     */ {
/*     */   enum a
/*     */   {
/*  35 */     m, a, b, c, d, e,
/*  36 */     f, g,
/*  37 */     h, i,
/*  38 */     j, k,
/*  39 */     l;
/*     */   }
/*     */ 
/*     */   
/*  43 */   static final a a = a.a;
/*  44 */   static final a b = a.b;
/*  45 */   static final a c = a.c;
/*  46 */   static final a d = a.d;
/*  47 */   static final a e = a.e;
/*  48 */   static final a f = a.f;
/*  49 */   static final a g = a.g;
/*  50 */   static final a h = a.h;
/*  51 */   static final a i = a.i;
/*  52 */   static final a j = a.l;
/*  53 */   static final a k = a.j;
/*  54 */   static final a l = a.k;
/*     */ 
/*     */   
/*     */   private String m;
/*     */ 
/*     */   
/*     */   private byte[] n;
/*     */ 
/*     */   
/*     */   private final a o;
/*     */ 
/*     */   
/*     */   b(String paramString, a parama) {
/*  67 */     this.m = paramString;
/*  68 */     this.o = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b(char paramChar, a parama) {
/*  78 */     this.m = Character.toString(paramChar);
/*  79 */     this.o = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   b(byte[] paramArrayOfbyte, a parama) {
/*  90 */     this.n = paramArrayOfbyte;
/*  91 */     this.o = parama;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String a() {
/*  96 */     return this.m;
/*     */   }
/*     */ 
/*     */   
/*     */   public final a b() {
/* 101 */     return this.o;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final int c() {
/* 107 */     return (int)Float.parseFloat(this.m);
/*     */   }
/*     */ 
/*     */   
/*     */   public final float d() {
/* 112 */     return Float.parseFloat(this.m);
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean e() {
/* 117 */     return this.m.equals("true");
/*     */   }
/*     */ 
/*     */   
/*     */   public final byte[] f() {
/* 122 */     return this.n;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String toString() {
/* 131 */     if (this.o == j)
/*     */     {
/* 133 */       return "Token[kind=CHARSTRING, data=" + this.n.length + " bytes]";
/*     */     }
/*     */ 
/*     */     
/* 137 */     return "Token[kind=" + this.o + ", text=" + this.m + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\b\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */