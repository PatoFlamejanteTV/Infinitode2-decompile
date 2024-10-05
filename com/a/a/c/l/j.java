/*     */ package com.a.a.c.l;
/*     */ 
/*     */ import com.a.a.c.c.a.l;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */   extends l
/*     */ {
/*     */   private com.a.a.c.j e;
/*     */   private com.a.a.c.j f;
/*     */   
/*     */   private j(Class<?> paramClass, n paramn, com.a.a.c.j paramj1, com.a.a.c.j[] paramArrayOfj, com.a.a.c.j paramj2, com.a.a.c.j paramj3, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  36 */     super(paramClass, paramn, paramj1, paramArrayOfj, Objects.hashCode(paramj2), paramObject1, paramObject2, paramBoolean);
/*     */     
/*  38 */     this.e = paramj2;
/*  39 */     this.f = (paramj3 == null) ? this : paramj3;
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
/*     */   public static j a(Class<?> paramClass, n paramn, com.a.a.c.j paramj1, com.a.a.c.j[] paramArrayOfj, com.a.a.c.j paramj2) {
/*  84 */     return new j(paramClass, paramn, paramj1, paramArrayOfj, paramj2, null, null, null, false);
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
/*     */   public final com.a.a.c.j a(com.a.a.c.j paramj) {
/*  97 */     if (this.e == paramj) {
/*  98 */       return this;
/*     */     }
/* 100 */     return new j(this.a, this.i, this.g, this.h, paramj, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j h(Object paramObject) {
/* 107 */     if (paramObject == this.c) {
/* 108 */       return this;
/*     */     }
/* 110 */     return new j(this.a, this.i, this.g, this.h, this.e, this.f, this.b, paramObject, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j i(Object paramObject) {
/* 117 */     if (paramObject == this.e.B()) {
/* 118 */       return this;
/*     */     }
/* 120 */     return new j(this.a, this.i, this.g, this.h, this.e
/* 121 */         .a(paramObject), this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private j j(Object paramObject) {
/* 127 */     if (paramObject == this.b) {
/* 128 */       return this;
/*     */     }
/* 130 */     return new j(this.a, this.i, this.g, this.h, this.e, this.f, paramObject, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j k(Object paramObject) {
/* 137 */     if (paramObject == this.e.A()) {
/* 138 */       return this;
/*     */     }
/* 140 */     paramObject = this.e.c(paramObject);
/* 141 */     return new j(this.a, this.i, this.g, this.h, (com.a.a.c.j)paramObject, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j J() {
/* 148 */     if (this.d) {
/* 149 */       return this;
/*     */     }
/* 151 */     return new j(this.a, this.i, this.g, this.h, this.e
/* 152 */         .a(), this.f, this.b, this.c, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final com.a.a.c.j a(Class<?> paramClass, n paramn, com.a.a.c.j paramj, com.a.a.c.j[] paramArrayOfj) {
/* 159 */     return new j(paramClass, this.i, paramj, paramArrayOfj, this.e, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String I() {
/*     */     StringBuilder stringBuilder;
/* 168 */     (stringBuilder = new StringBuilder()).append(this.a.getName());
/* 169 */     if (this.e != null && c(1)) {
/* 170 */       stringBuilder.append('<');
/* 171 */       stringBuilder.append(this.e.G());
/* 172 */       stringBuilder.append('>');
/*     */     } 
/* 174 */     return stringBuilder.toString();
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
/*     */   public final com.a.a.c.j u() {
/* 201 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final com.a.a.c.j v() {
/* 206 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 211 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean F() {
/* 216 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder b(StringBuilder paramStringBuilder) {
/* 221 */     return a(this.a, paramStringBuilder, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder) {
/* 227 */     a(this.a, paramStringBuilder, false);
/* 228 */     paramStringBuilder.append('<');
/*     */     
/* 230 */     (paramStringBuilder = this.e.a(paramStringBuilder)).append(">;");
/* 231 */     return paramStringBuilder;
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
/*     */   public final String toString() {
/* 261 */     return (new StringBuilder(40))
/* 262 */       .append("[reference type, class ")
/* 263 */       .append(I())
/* 264 */       .append('<')
/* 265 */       .append(this.e)
/* 266 */       .append('>')
/* 267 */       .append(']')
/* 268 */       .toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 274 */     if (paramObject == this) return true; 
/* 275 */     if (paramObject == null) return false; 
/* 276 */     if (paramObject.getClass() != getClass()) return false;
/*     */ 
/*     */ 
/*     */     
/* 280 */     if (((j)(paramObject = paramObject)).a != this.a) return false;
/*     */ 
/*     */     
/* 283 */     return this.e.equals(((j)paramObject).e);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */