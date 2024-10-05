/*     */ package com.a.a.c;
/*     */ 
/*     */ import com.a.a.a.ak;
/*     */ import com.a.a.c.f.j;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class v
/*     */   implements Serializable
/*     */ {
/*  19 */   public static final v a = new v(Boolean.TRUE, null, null, null, null, null, null);
/*     */ 
/*     */   
/*  22 */   public static final v b = new v(Boolean.FALSE, null, null, null, null, null, null);
/*     */ 
/*     */   
/*  25 */   public static final v c = new v(null, null, null, null, null, null, null);
/*     */   
/*     */   private Boolean d;
/*     */   
/*     */   private String e;
/*     */   
/*     */   private Integer f;
/*     */   
/*     */   private String g;
/*     */   
/*     */   private transient a h;
/*     */   
/*     */   private ak i;
/*     */   
/*     */   private ak j;
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     public final j a;
/*     */     public final boolean b;
/*     */     
/*     */     private a(j param1j, boolean param1Boolean) {
/*  47 */       this.a = param1j;
/*  48 */       this.b = param1Boolean;
/*     */     }
/*     */     
/*     */     public static a a(j param1j) {
/*  52 */       return new a(param1j, true);
/*     */     }
/*     */     
/*     */     public static a b(j param1j) {
/*  56 */       return new a(param1j, false);
/*     */     }
/*     */     
/*     */     public static a c(j param1j) {
/*  60 */       return new a(param1j, false);
/*     */     }
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
/*     */   private v(Boolean paramBoolean, String paramString1, Integer paramInteger, String paramString2, a parama, ak paramak1, ak paramak2) {
/* 123 */     this.d = paramBoolean;
/* 124 */     this.e = paramString1;
/* 125 */     this.f = paramInteger;
/* 126 */     this.g = (paramString2 == null || paramString2.isEmpty()) ? null : paramString2;
/* 127 */     this.h = parama;
/* 128 */     this.i = paramak1;
/* 129 */     this.j = paramak2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static v a(Boolean paramBoolean, String paramString1, Integer paramInteger, String paramString2) {
/* 137 */     if (paramString1 != null || paramInteger != null || paramString2 != null) {
/* 138 */       return new v(paramBoolean, paramString1, paramInteger, paramString2, null, null, null);
/*     */     }
/*     */     
/* 141 */     if (paramBoolean == null) {
/* 142 */       return c;
/*     */     }
/* 144 */     return paramBoolean.booleanValue() ? a : b;
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
/*     */   public final v a(String paramString) {
/* 175 */     return new v(this.d, paramString, this.f, this.g, this.h, this.i, this.j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v a(a parama) {
/* 183 */     return new v(this.d, this.e, this.f, this.g, parama, this.i, this.j);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v a(ak paramak1, ak paramak2) {
/* 192 */     return new v(this.d, this.e, this.f, this.g, this.h, paramak1, paramak2);
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
/*     */   public final boolean a() {
/* 247 */     return (this.d != null && this.d.booleanValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Integer b() {
/* 254 */     return this.f;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 259 */     return (this.f != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public final a d() {
/* 264 */     return this.h;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ak e() {
/* 269 */     return this.i;
/*     */   }
/*     */ 
/*     */   
/*     */   public final ak f() {
/* 274 */     return this.j;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */