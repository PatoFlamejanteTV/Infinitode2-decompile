/*     */ package com.a.a.c.l;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class g
/*     */   extends m
/*     */ {
/*     */   protected final j e;
/*     */   protected final j f;
/*     */   
/*     */   protected g(Class<?> paramClass, n paramn, j paramj1, j[] paramArrayOfj, j paramj2, j paramj3, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  39 */     super(paramClass, paramn, paramj1, paramArrayOfj, paramj2.hashCode() ^ paramj3
/*  40 */         .hashCode(), paramObject1, paramObject2, paramBoolean);
/*  41 */     this.e = paramj2;
/*  42 */     this.f = paramj3;
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
/*     */   public g e(j paramj) {
/* 102 */     if (paramj == this.e) {
/* 103 */       return this;
/*     */     }
/* 105 */     return new g(this.a, this.i, this.g, this.h, paramj, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(j paramj) {
/* 112 */     if (this.f == paramj) {
/* 113 */       return this;
/*     */     }
/* 115 */     return new g(this.a, this.i, this.g, this.h, this.e, paramj, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g e(Object paramObject) {
/* 122 */     return new g(this.a, this.i, this.g, this.h, this.e, this.f, this.b, paramObject, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g f(Object paramObject) {
/* 129 */     return new g(this.a, this.i, this.g, this.h, this.e, this.f
/* 130 */         .a(paramObject), this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public g g(Object paramObject) {
/* 136 */     return new g(this.a, this.i, this.g, this.h, this.e, this.f, paramObject, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g h(Object paramObject) {
/* 143 */     return new g(this.a, this.i, this.g, this.h, this.e, this.f
/* 144 */         .c(paramObject), this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final j b(j paramj) {
/* 150 */     j j1 = super.b(paramj);
/* 151 */     j j2 = paramj.t();
/*     */     
/* 153 */     if (j1 instanceof g && 
/* 154 */       j2 != null && (
/*     */       
/* 156 */       j2 = this.e.b(j2)) != this.e) {
/* 157 */       j1 = ((g)j1).e(j2);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 162 */     if ((j2 = paramj.u()) != null && (
/*     */       
/* 164 */       paramj = this.f.b(j2)) != this.f) {
/* 165 */       j1 = j1.a(paramj);
/*     */     }
/*     */     
/* 168 */     return j1;
/*     */   }
/*     */ 
/*     */   
/*     */   public g H() {
/* 173 */     if (this.d) {
/* 174 */       return this;
/*     */     }
/* 176 */     return new g(this.a, this.i, this.g, this.h, this.e, this.f
/* 177 */         .a(), this.b, this.c, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 184 */     return new g(paramClass, paramn, paramj, paramArrayOfj, this.e, this.f, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String I() {
/*     */     StringBuilder stringBuilder;
/* 191 */     (stringBuilder = new StringBuilder()).append(this.a.getName());
/*     */ 
/*     */     
/* 194 */     if (this.e != null && c(2)) {
/* 195 */       stringBuilder.append('<');
/* 196 */       stringBuilder.append(this.e.G());
/* 197 */       stringBuilder.append(',');
/* 198 */       stringBuilder.append(this.f.G());
/* 199 */       stringBuilder.append('>');
/*     */     } 
/* 201 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean n() {
/* 212 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean p() {
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j t() {
/* 222 */     return this.e;
/*     */   }
/*     */ 
/*     */   
/*     */   public final j u() {
/* 227 */     return this.f;
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
/*     */   public final boolean C() {
/* 242 */     if (super.C() || this.f.C() || this.e
/* 243 */       .C()) return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public final StringBuilder b(StringBuilder paramStringBuilder) {
/* 248 */     return a(this.a, paramStringBuilder, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder) {
/* 253 */     a(this.a, paramStringBuilder, false);
/* 254 */     paramStringBuilder.append('<');
/* 255 */     this.e.a(paramStringBuilder);
/* 256 */     this.f.a(paramStringBuilder);
/* 257 */     paramStringBuilder.append(">;");
/* 258 */     return paramStringBuilder;
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
/*     */   public g i(Object paramObject) {
/* 274 */     return new g(this.a, this.i, this.g, this.h, this.e
/* 275 */         .c(paramObject), this.f, this.b, this.c, this.d);
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
/*     */   public String toString() {
/* 299 */     return String.format("[map-like type; class %s, %s -> %s]", new Object[] { this.a
/* 300 */           .getName(), this.e, this.f });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 305 */     if (paramObject == this) return true; 
/* 306 */     if (paramObject == null) return false; 
/* 307 */     if (paramObject.getClass() != getClass()) return false;
/*     */     
/* 309 */     paramObject = paramObject;
/* 310 */     if (this.a == ((g)paramObject).a && this.e.equals(((g)paramObject).e) && this.f
/* 311 */       .equals(((g)paramObject).f)) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */