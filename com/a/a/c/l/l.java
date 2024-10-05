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
/*     */ public class l
/*     */   extends m
/*     */ {
/*     */   protected l(Class<?> paramClass) {
/*  33 */     this(paramClass, n.a(), (j)null, (j[])null);
/*     */   }
/*     */ 
/*     */   
/*     */   protected l(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/*  38 */     this(paramClass, paramn, paramj, paramArrayOfj, (Object)null, (Object)null, false);
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
/*     */   private l(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  55 */     super(paramClass, paramn, paramj, paramArrayOfj, 0, paramObject1, paramObject2, paramBoolean);
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
/*     */   protected l(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj, int paramInt, Object paramObject1, Object paramObject2, boolean paramBoolean) {
/*  68 */     super(paramClass, paramn, paramj, paramArrayOfj, paramInt, paramObject1, paramObject2, paramBoolean);
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
/*     */   public static l e(Class<?> paramClass) {
/*  82 */     return new l(paramClass, null, null, null, null, null, false);
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
/*     */   public j a(j paramj) {
/* 171 */     throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
/*     */   }
/*     */ 
/*     */   
/*     */   public l g(Object paramObject) {
/* 176 */     if (this.c == paramObject) {
/* 177 */       return this;
/*     */     }
/* 179 */     return new l(this.a, this.i, this.g, this.h, this.b, paramObject, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public j b(Object paramObject) {
/* 185 */     throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
/*     */   }
/*     */ 
/*     */   
/*     */   public l f(Object paramObject) {
/* 190 */     if (paramObject == this.b) {
/* 191 */       return this;
/*     */     }
/* 193 */     return new l(this.a, this.i, this.g, this.h, paramObject, this.c, this.d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public l e(Object paramObject) {
/* 199 */     throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
/*     */   }
/*     */ 
/*     */   
/*     */   public l H() {
/* 204 */     return this.d ? this : new l(this.a, this.i, this.g, this.h, this.b, this.c, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j a(Class<?> paramClass, n paramn, j paramj, j[] paramArrayOfj) {
/* 212 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String I() {
/*     */     StringBuilder stringBuilder;
/* 219 */     (stringBuilder = new StringBuilder()).append(this.a.getName());
/*     */ 
/*     */     
/*     */     int i;
/*     */ 
/*     */     
/* 225 */     if ((i = this.i.c()) > 0 && c(i)) {
/* 226 */       stringBuilder.append('<');
/* 227 */       for (byte b = 0; b < i; b++) {
/* 228 */         j j = a(b);
/* 229 */         if (b > 0) {
/* 230 */           stringBuilder.append(',');
/*     */         }
/* 232 */         stringBuilder.append(j.G());
/*     */       } 
/* 234 */       stringBuilder.append('>');
/*     */     } 
/* 236 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean n() {
/* 246 */     return false;
/*     */   }
/*     */   public boolean c() {
/* 249 */     return false;
/*     */   }
/*     */   
/*     */   public StringBuilder b(StringBuilder paramStringBuilder) {
/* 253 */     return a(this.a, paramStringBuilder, true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuilder a(StringBuilder paramStringBuilder) {
/* 259 */     a(this.a, paramStringBuilder, false);
/*     */     
/*     */     int i;
/* 262 */     if ((i = this.i.c()) > 0) {
/* 263 */       paramStringBuilder.append('<');
/* 264 */       for (byte b = 0; b < i; b++) {
/* 265 */         paramStringBuilder = a(b).a(paramStringBuilder);
/*     */       }
/* 267 */       paramStringBuilder.append('>');
/*     */     } 
/* 269 */     paramStringBuilder.append(';');
/* 270 */     return paramStringBuilder;
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
/*     */   public String toString() {
/*     */     StringBuilder stringBuilder;
/* 308 */     (stringBuilder = new StringBuilder(40)).append("[simple type, class ").append(I()).append(']');
/* 309 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 315 */     if (paramObject == this) return true; 
/* 316 */     if (paramObject == null) return false; 
/* 317 */     if (paramObject.getClass() != getClass()) return false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 322 */     if (((l)(paramObject = paramObject)).a != this.a) return false;
/*     */ 
/*     */     
/* 325 */     n n = this.i;
/* 326 */     paramObject = ((l)paramObject).i;
/* 327 */     return n.equals(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\l\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */