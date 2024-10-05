/*     */ package com.a.a.a;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface q
/*     */ {
/*     */   String[] a() default {};
/*     */   
/*     */   boolean b() default false;
/*     */   
/*     */   boolean c() default false;
/*     */   
/*     */   boolean d() default false;
/*     */   
/*     */   public static class a
/*     */     implements Serializable
/*     */   {
/* 118 */     private static a a = new a(Collections.emptySet(), false, false, false, true);
/*     */ 
/*     */     
/*     */     private Set<String> b;
/*     */ 
/*     */     
/*     */     private boolean c;
/*     */ 
/*     */     
/*     */     private boolean d;
/*     */ 
/*     */     
/*     */     private boolean e;
/*     */     
/*     */     private boolean f;
/*     */ 
/*     */     
/*     */     private a(Set<String> param1Set, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
/* 136 */       if (param1Set == null) {
/* 137 */         this.b = Collections.emptySet();
/*     */       } else {
/* 139 */         this.b = param1Set;
/*     */       } 
/* 141 */       this.c = param1Boolean1;
/* 142 */       this.d = param1Boolean2;
/* 143 */       this.e = param1Boolean3;
/* 144 */       this.f = param1Boolean4;
/*     */     }
/*     */     
/*     */     public static a a(q param1q) {
/* 148 */       if (param1q == null) {
/* 149 */         return a;
/*     */       }
/* 151 */       return a(a(param1q.a()), param1q
/* 152 */           .b(), param1q.c(), param1q.d(), false);
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
/*     */     private static a a(Set<String> param1Set, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
/* 169 */       if (b(param1Set, param1Boolean1, param1Boolean2, param1Boolean3, param1Boolean4)) {
/* 170 */         return a;
/*     */       }
/* 172 */       return new a(param1Set, param1Boolean1, param1Boolean2, param1Boolean3, param1Boolean4);
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
/*     */     public static a a() {
/* 192 */       return a;
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
/*     */     public static a a(a param1a1, a param1a2) {
/* 206 */       return (param1a1 == null) ? param1a2 : param1a1
/* 207 */         .a(param1a2);
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
/*     */     private a a(a param1a) {
/* 247 */       if (param1a == null || param1a == a) {
/* 248 */         return this;
/*     */       }
/*     */ 
/*     */       
/* 252 */       if (!param1a.f) {
/* 253 */         return param1a;
/*     */       }
/* 255 */       if (b(this, param1a)) {
/* 256 */         return this;
/*     */       }
/*     */ 
/*     */       
/* 260 */       Set<String> set = a(this.b, param1a.b);
/* 261 */       boolean bool2 = (this.c || param1a.c) ? true : false;
/* 262 */       boolean bool3 = (this.d || param1a.d) ? true : false;
/* 263 */       boolean bool1 = (this.e || param1a.e) ? true : false;
/*     */ 
/*     */       
/* 266 */       return a(set, bool2, bool3, bool1, true);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Set<String> b() {
/* 343 */       if (this.d) {
/* 344 */         return Collections.emptySet();
/*     */       }
/* 346 */       return this.b;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Set<String> c() {
/* 357 */       if (this.e) {
/* 358 */         return Collections.emptySet();
/*     */       }
/* 360 */       return this.b;
/*     */     }
/*     */     
/*     */     public final boolean d() {
/* 364 */       return this.c;
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
/*     */     public final String toString() {
/* 381 */       return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", new Object[] { this.b, 
/* 382 */             Boolean.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), Boolean.valueOf(this.f) });
/*     */     }
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 387 */       return this.b.size() + (this.c ? 1 : -3) + (this.d ? 3 : -7) + (this.e ? 7 : -11) + (this.f ? 11 : -13);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 397 */       if (param1Object == this) return true; 
/* 398 */       if (param1Object == null) return false; 
/* 399 */       if (param1Object.getClass() == getClass() && 
/* 400 */         b(this, (a)param1Object)) return true; 
/*     */       return false;
/*     */     }
/*     */     
/*     */     private static boolean b(a param1a1, a param1a2) {
/* 405 */       if (param1a1.c == param1a2.c && param1a1.f == param1a2.f && param1a1.d == param1a2.d && param1a1.e == param1a2.e && param1a1.b
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 410 */         .equals(param1a2.b)) return true; 
/*     */       return false;
/*     */     }
/*     */     
/*     */     private static Set<String> a(String[] param1ArrayOfString) {
/* 415 */       if (param1ArrayOfString == null || param1ArrayOfString.length == 0) {
/* 416 */         return Collections.emptySet();
/*     */       }
/* 418 */       HashSet<String> hashSet = new HashSet(param1ArrayOfString.length); int i; byte b;
/* 419 */       for (i = (param1ArrayOfString = param1ArrayOfString).length, b = 0; b < i; ) { String str = param1ArrayOfString[b];
/* 420 */         hashSet.add(str); b++; }
/*     */       
/* 422 */       return hashSet;
/*     */     }
/*     */ 
/*     */     
/*     */     private static Set<String> a(Set<String> param1Set1, Set<String> param1Set2) {
/* 427 */       if (param1Set1.isEmpty())
/* 428 */         return param1Set2; 
/* 429 */       if (param1Set2.isEmpty()) {
/* 430 */         return param1Set1;
/*     */       }
/*     */       HashSet<String> hashSet;
/* 433 */       (hashSet = new HashSet<String>(param1Set1.size() + param1Set2.size())).addAll(param1Set1);
/* 434 */       hashSet.addAll(param1Set2);
/* 435 */       return hashSet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static boolean b(Set<String> param1Set, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3, boolean param1Boolean4) {
/* 441 */       if (param1Boolean1 == a.c && param1Boolean2 == a.d && param1Boolean3 == a.e && param1Boolean4 == a.f)
/*     */       {
/*     */ 
/*     */         
/* 445 */         return (param1Set == null || param1Set.size() == 0);
/*     */       }
/* 447 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */