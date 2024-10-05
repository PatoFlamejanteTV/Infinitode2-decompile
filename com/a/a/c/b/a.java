/*     */ package com.a.a.c.b;
/*     */ 
/*     */ import com.a.a.c.f.t;
/*     */ import com.a.a.c.i.c;
/*     */ import com.a.a.c.i.h;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.x;
/*     */ import java.io.Serializable;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
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
/*     */ public final class a
/*     */   implements Serializable
/*     */ {
/*  38 */   private static final TimeZone a = TimeZone.getTimeZone("UTC");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private t c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.a.a.c.a d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private x e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.a.a.c.f.a.a f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private h<?> g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private c h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DateFormat i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Locale k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TimeZone l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private com.a.a.b.a m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(t paramt, com.a.a.c.a parama, x paramx, o paramo, h<?> paramh, DateFormat paramDateFormat, d paramd, Locale paramLocale, TimeZone paramTimeZone, com.a.a.b.a parama1, c paramc, com.a.a.c.f.a.a parama2) {
/* 161 */     this.c = paramt;
/* 162 */     this.d = parama;
/* 163 */     this.e = paramx;
/* 164 */     this.b = paramo;
/* 165 */     this.g = paramh;
/* 166 */     this.i = paramDateFormat;
/* 167 */     this.j = paramd;
/* 168 */     this.k = paramLocale;
/* 169 */     this.l = paramTimeZone;
/* 170 */     this.m = parama1;
/* 171 */     this.h = paramc;
/* 172 */     this.f = parama2;
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
/*     */   public final a a(t paramt) {
/* 214 */     if (this.c == paramt) {
/* 215 */       return this;
/*     */     }
/* 217 */     return new a(paramt, this.d, this.e, this.b, this.g, this.i, this.j, this.k, this.l, this.m, this.h, this.f);
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
/*     */   public final t a() {
/* 374 */     return this.c;
/*     */   }
/*     */   
/*     */   public final com.a.a.c.a b() {
/* 378 */     return this.d;
/*     */   }
/*     */   
/*     */   public final x c() {
/* 382 */     return this.e;
/*     */   }
/*     */   
/*     */   public final com.a.a.c.f.a.a d() {
/* 386 */     return this.f;
/*     */   }
/*     */   
/*     */   public final o e() {
/* 390 */     return this.b;
/*     */   }
/*     */   
/*     */   public final h<?> f() {
/* 394 */     return this.g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c g() {
/* 401 */     return this.h;
/*     */   }
/*     */   
/*     */   public final DateFormat h() {
/* 405 */     return this.i;
/*     */   }
/*     */   
/*     */   public final d i() {
/* 409 */     return this.j;
/*     */   }
/*     */   
/*     */   public final Locale j() {
/* 413 */     return this.k;
/*     */   }
/*     */   
/*     */   public final TimeZone k() {
/*     */     TimeZone timeZone;
/* 418 */     return ((timeZone = this.l) == null) ? a : timeZone;
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
/*     */   public final com.a.a.b.a l() {
/* 433 */     return this.m;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */