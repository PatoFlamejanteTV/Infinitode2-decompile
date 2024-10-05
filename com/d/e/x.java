/*     */ package com.d.e;
/*     */ 
/*     */ import org.w3c.dom.Text;
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
/*     */ public final class x
/*     */ {
/*     */   private String a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private boolean e;
/*     */   private boolean f;
/*     */   private int g;
/*     */   private Text h;
/*     */   
/*     */   public final int a() {
/*  41 */     return this.a.length();
/*     */   }
/*     */   
/*     */   public final void b() {
/*  45 */     this.g = 0;
/*  46 */     this.e = false;
/*  47 */     this.f = false;
/*     */   }
/*     */   
/*     */   public final int c() {
/*  51 */     return this.c;
/*     */   }
/*     */   
/*     */   public final void a(int paramInt) {
/*  55 */     this.c = paramInt;
/*     */   }
/*     */   
/*     */   public final String d() {
/*  59 */     return this.a;
/*     */   }
/*     */   
/*     */   public final void a(String paramString) {
/*  63 */     this.a = paramString;
/*     */   }
/*     */   
/*     */   public final int e() {
/*  67 */     return this.b;
/*     */   }
/*     */   
/*     */   public final void b(int paramInt) {
/*  71 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public final String f() {
/*  75 */     return this.a.substring(this.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String g() {
/*  83 */     if (this.c > 0 && this.a.charAt(this.c - 1) == '\n') {
/*  84 */       return this.a.substring(this.b, this.c - 1);
/*     */     }
/*  86 */     return this.a.substring(this.b, this.c);
/*     */   }
/*     */   
/*     */   public final boolean h() {
/*  90 */     return this.e;
/*     */   }
/*     */   
/*     */   public final void a(boolean paramBoolean) {
/*  94 */     this.e = true;
/*     */   }
/*     */   
/*     */   public final boolean i() {
/*  98 */     return this.f;
/*     */   }
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 102 */     this.f = true;
/*     */   }
/*     */   
/*     */   public final int j() {
/* 106 */     return this.g;
/*     */   }
/*     */   
/*     */   public final void c(int paramInt) {
/* 110 */     this.g = paramInt;
/*     */   }
/*     */   
/*     */   public final boolean k() {
/* 114 */     return (this.c == d().length());
/*     */   }
/*     */   
/*     */   public final void l() {
/* 118 */     this.c = this.d;
/*     */   }
/*     */   
/*     */   public final void m() {
/* 122 */     this.d = this.c;
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
/*     */   public final Text n() {
/* 134 */     return this.h;
/*     */   }
/*     */   
/*     */   public final void a(Text paramText) {
/* 138 */     this.h = paramText;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\e\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */