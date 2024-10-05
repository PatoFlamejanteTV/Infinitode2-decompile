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
/*     */ public class d
/*     */   extends m
/*     */ {
/*     */   protected final j e;
/*     */   
/*     */   protected d(Class<?> paramClass, n paramn, j paramj1, j[] paramArrayOfj, j paramj2, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  34 */     super(paramClass, paramn, paramj1, paramArrayOfj, paramj2
/*  35 */         .hashCode(), paramObject1, paramObject2, paramBoolean);
/*  36 */     this.e = paramj2;
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
/*     */   public j a(j paramj) {
/* 102 */     if (this.e == paramj) {
/* 103 */       return this;
/*     */     }
/* 105 */     return new d(this.a, this.i, this.g, this.h, paramj, this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public d e(Object paramObject) {
/* 111 */     return new d(this.a, this.i, this.g, this.h, this.e, this.b, paramObject, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d f(Object paramObject) {
/* 118 */     return new d(this.a, this.i, this.g, this.h, this.e
/* 119 */         .a(paramObject), this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public d g(Object paramObject) {
/* 125 */     return new d(this.a, this.i, this.g, this.h, this.e, paramObject, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public d h(Object paramObject) {
/* 131 */     return new d(this.a, this.i, this.g, this.h, this.e
/* 132 */         .c(paramObject), this.b, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final j b(j paramj) {
/* 138 */     j j1 = super.b(paramj);
/*     */     
/* 140 */     if ((paramj = paramj.u()) != null && (
/*     */       
/* 142 */       paramj = this.e.b(paramj)) != this.e) {
/* 143 */       j1 = j1.a(paramj);
/*     */     }
/*     */     
/* 146 */     return j1;
/*     */   }
/*     */ 
/*     */   
/*     */   public d H() {
/* 151 */     if (this.d) {
/* 152 */       return this;
/*     */     }
/* 154 */     return new d(this.a, this.i, this.g, this.h, this.e
/* 155 */         .a(), this.b, this.c, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 162 */     return new d(paramClass, paramn, paramj, paramArrayOfj, this.e, this.b, this.c, this.d);
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
/*     */   public final boolean n() {
/* 174 */     return true;
/*     */   }
/*     */   public final boolean o() {
/* 177 */     return true;
/*     */   }
/*     */   public final j u() {
/* 180 */     return this.e;
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
/*     */   public final boolean C() {
/* 194 */     return (super.C() || this.e.C());
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder b(StringBuilder paramStringBuilder) {
/* 199 */     return a(this.a, paramStringBuilder, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final StringBuilder a(StringBuilder paramStringBuilder) {
/* 204 */     a(this.a, paramStringBuilder, false);
/* 205 */     paramStringBuilder.append('<');
/* 206 */     this.e.a(paramStringBuilder);
/* 207 */     paramStringBuilder.append(">;");
/* 208 */     return paramStringBuilder;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final String I() {
/*     */     StringBuilder stringBuilder;
/* 214 */     (stringBuilder = new StringBuilder()).append(this.a.getName());
/*     */ 
/*     */     
/* 217 */     if (this.e != null && c(1)) {
/* 218 */       stringBuilder.append('<');
/* 219 */       stringBuilder.append(this.e.G());
/* 220 */       stringBuilder.append('>');
/*     */     } 
/* 222 */     return stringBuilder.toString();
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
/*     */   public boolean equals(Object paramObject) {
/* 253 */     if (paramObject == this) return true; 
/* 254 */     if (paramObject == null) return false; 
/* 255 */     if (paramObject.getClass() != getClass()) return false;
/*     */     
/* 257 */     paramObject = paramObject;
/* 258 */     return (this.a == ((d)paramObject).a && this.e.equals(((d)paramObject).e));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 264 */     return "[collection-like type; class " + this.a.getName() + ", contains " + this.e + "]";
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */