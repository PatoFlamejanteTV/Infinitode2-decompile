/*     */ package com.a.a.a;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface s
/*     */ {
/*     */   a a() default a.ALWAYS;
/*     */   
/*     */   a b() default a.ALWAYS;
/*     */   
/*     */   Class<?> c() default Void.class;
/*     */   
/*     */   Class<?> d() default Void.class;
/*     */   
/*     */   public enum a
/*     */   {
/* 119 */     a,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     b,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 140 */     c,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 187 */     d,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 210 */     e,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 228 */     f,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 239 */     g;
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
/*     */   public static class b
/*     */     implements Serializable
/*     */   {
/* 261 */     private static b a = new b(s.a.g, s.a.g, null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private s.a b;
/*     */ 
/*     */ 
/*     */     
/*     */     private s.a c;
/*     */ 
/*     */ 
/*     */     
/*     */     private Class<?> d;
/*     */ 
/*     */ 
/*     */     
/*     */     private Class<?> e;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(s.a param1a1, s.a param1a2, Class<?> param1Class1, Class<?> param1Class2) {
/* 284 */       this.b = (param1a1 == null) ? s.a.g : param1a1;
/* 285 */       this.c = (param1a2 == null) ? s.a.g : param1a2;
/* 286 */       this.d = (param1Class1 == Void.class) ? null : param1Class1;
/* 287 */       this.e = (param1Class2 == Void.class) ? null : param1Class2;
/*     */     }
/*     */     
/*     */     public static b a() {
/* 291 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static b a(b param1b1, b param1b2) {
/* 307 */       return (param1b1 == null) ? param1b2 : param1b1
/* 308 */         .a(param1b2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static b a(b... param1VarArgs) {
/* 316 */       b b1 = null; byte b2;
/* 317 */       for (param1VarArgs = param1VarArgs, b2 = 0; b2 < 3; b2++) {
/* 318 */         b b3; if ((b3 = param1VarArgs[b2]) != null) {
/* 319 */           b1 = (b1 == null) ? b3 : b1.a(b3);
/*     */         }
/*     */       } 
/* 322 */       return b1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final b a(b param1b) {
/* 344 */       if (param1b == null || param1b == a) {
/* 345 */         return this;
/*     */       }
/* 347 */       s.a a1 = param1b.b;
/* 348 */       s.a a2 = param1b.c;
/* 349 */       Class<?> clazz2 = param1b.d;
/* 350 */       Class<?> clazz1 = param1b.e;
/*     */       
/* 352 */       boolean bool1 = (a1 != this.b && a1 != s.a.g) ? true : false;
/* 353 */       boolean bool2 = (a2 != this.c && a2 != s.a.g) ? true : false;
/* 354 */       boolean bool3 = (clazz2 != this.d || clazz1 != this.d) ? true : false;
/*     */       
/* 356 */       if (bool1) {
/* 357 */         if (bool2) {
/* 358 */           return new b(a1, a2, clazz2, clazz1);
/*     */         }
/* 360 */         return new b(a1, this.c, clazz2, clazz1);
/* 361 */       }  if (bool2)
/* 362 */         return new b(this.b, a2, clazz2, clazz1); 
/* 363 */       if (bool3) {
/* 364 */         return new b(this.b, this.c, clazz2, clazz1);
/*     */       }
/* 366 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static b a(s.a param1a1, s.a param1a2) {
/* 373 */       if ((param1a1 == s.a.g || param1a1 == null) && (param1a2 == s.a.g || param1a2 == null))
/*     */       {
/* 375 */         return a;
/*     */       }
/* 377 */       return new b(param1a1, param1a2, null, null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static b a(s.a param1a1, s.a param1a2, Class<?> param1Class1, Class<?> param1Class2) {
/* 388 */       if (param1Class1 == Void.class) {
/* 389 */         param1Class1 = null;
/*     */       }
/* 391 */       if (param1Class2 == Void.class) {
/* 392 */         param1Class2 = null;
/*     */       }
/* 394 */       if ((param1a1 == s.a.g || param1a1 == null) && (param1a2 == s.a.g || param1a2 == null) && param1Class1 == null && param1Class2 == null)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 399 */         return a;
/*     */       }
/* 401 */       return new b(param1a1, param1a2, param1Class1, param1Class2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static b a(s param1s) {
/* 409 */       if (param1s == null) {
/* 410 */         return a;
/*     */       }
/* 412 */       s.a a1 = param1s.a();
/* 413 */       s.a a2 = param1s.b();
/*     */       
/* 415 */       if (a1 == s.a.g && a2 == s.a.g) {
/* 416 */         return a;
/*     */       }
/*     */       Class<?> clazz2;
/* 419 */       if ((clazz2 = param1s.c()) == Void.class) {
/* 420 */         clazz2 = null;
/*     */       }
/*     */       Class<?> clazz1;
/* 423 */       if ((clazz1 = param1s.d()) == Void.class) {
/* 424 */         clazz1 = null;
/*     */       }
/* 426 */       return new b(a1, a2, clazz2, clazz1);
/*     */     }
/*     */     
/*     */     public final b a(s.a param1a) {
/* 430 */       return (param1a == this.b) ? this : new b(param1a, this.c, this.d, this.e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final b a(Class<?> param1Class) {
/*     */       s.a a1;
/* 471 */       if (param1Class == null || param1Class == Void.class) {
/* 472 */         a1 = s.a.g;
/* 473 */         param1Class = null;
/*     */       } else {
/* 475 */         a1 = s.a.f;
/*     */       } 
/* 477 */       return a(this.b, a1, this.d, param1Class);
/*     */     }
/*     */     
/*     */     public final b b(s.a param1a) {
/* 481 */       return (param1a == this.c) ? this : new b(this.b, param1a, this.d, this.e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final s.a b() {
/* 491 */       return this.b;
/*     */     }
/*     */     
/*     */     public final s.a c() {
/* 495 */       return this.c;
/*     */     }
/*     */     
/*     */     public final Class<?> d() {
/* 499 */       return this.d;
/*     */     }
/*     */     
/*     */     public final Class<?> e() {
/* 503 */       return this.e;
/*     */     }
/*     */ 
/*     */     
/*     */     public final String toString() {
/*     */       StringBuilder stringBuilder;
/* 509 */       (stringBuilder = new StringBuilder(80)).append("JsonInclude.Value(value=")
/* 510 */         .append(this.b)
/* 511 */         .append(",content=")
/* 512 */         .append(this.c);
/* 513 */       if (this.d != null) {
/* 514 */         stringBuilder.append(",valueFilter=").append(this.d.getName()).append(".class");
/*     */       }
/* 516 */       if (this.e != null) {
/* 517 */         stringBuilder.append(",contentFilter=").append(this.e.getName()).append(".class");
/*     */       }
/* 519 */       return stringBuilder.append(')').toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 524 */       return (this.b.hashCode() << 2) + this.c
/* 525 */         .hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 530 */       if (param1Object == this) return true; 
/* 531 */       if (param1Object == null) return false; 
/* 532 */       if (param1Object.getClass() != getClass()) return false;
/*     */ 
/*     */       
/* 535 */       if (((b)(param1Object = param1Object)).b == this.b && ((b)param1Object).c == this.c && ((b)param1Object).d == this.d && ((b)param1Object).e == this.e) return true;  return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */