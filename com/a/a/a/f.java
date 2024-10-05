/*     */ package com.a.a.a;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.ElementType;
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.lang.annotation.Target;
/*     */ import java.lang.reflect.Member;
/*     */ import java.lang.reflect.Modifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface f
/*     */ {
/*     */   b a() default b.DEFAULT;
/*     */   
/*     */   b b() default b.DEFAULT;
/*     */   
/*     */   b c() default b.DEFAULT;
/*     */   
/*     */   b d() default b.DEFAULT;
/*     */   
/*     */   b e() default b.DEFAULT;
/*     */   
/*     */   public enum b
/*     */   {
/*  43 */     a,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     b,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     c,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     d,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  65 */     e,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     f;
/*     */     
/*     */     public final boolean a(Member param1Member) {
/*  75 */       switch (g.a[ordinal()]) {
/*     */         case 1:
/*  77 */           return true;
/*     */         case 2:
/*  79 */           return false;
/*     */         case 3:
/*  81 */           return !Modifier.isPrivate(param1Member.getModifiers());
/*     */         case 4:
/*  83 */           if (Modifier.isProtected(param1Member.getModifiers())) {
/*  84 */             return true;
/*     */           }
/*     */         
/*     */         case 5:
/*  88 */           return Modifier.isPublic(param1Member.getModifiers());
/*     */       } 
/*  90 */       return false;
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
/*     */   public static class a
/*     */     implements Serializable
/*     */   {
/* 141 */     private static final f.b a = f.b.d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private f.b b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private f.b c;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private f.b d;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private f.b e;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private f.b f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(f.b param1b1, f.b param1b2, f.b param1b3, f.b param1b4, f.b param1b5) {
/* 173 */       this.b = param1b1;
/* 174 */       this.c = param1b2;
/* 175 */       this.d = param1b3;
/* 176 */       this.e = param1b4;
/* 177 */       this.f = param1b5;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final f.b a() {
/* 308 */       return this.b;
/* 309 */     } public final f.b b() { return this.c; }
/* 310 */     public final f.b c() { return this.d; }
/* 311 */     public final f.b d() { return this.e; } public final f.b e() {
/* 312 */       return this.f;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String toString() {
/* 323 */       return String.format("JsonAutoDetect.Value(fields=%s,getters=%s,isGetters=%s,setters=%s,creators=%s)", new Object[] { this.b, this.c, this.d, this.e, this.f });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 331 */       return 1 + this.b.ordinal() ^ 3 * this.c
/* 332 */         .ordinal() - 7 * this.d
/* 333 */         .ordinal() + 11 * this.e
/* 334 */         .ordinal() ^ 13 * this.f
/* 335 */         .ordinal();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 341 */       if (param1Object == this) return true; 
/* 342 */       if (param1Object == null) return false; 
/* 343 */       return (param1Object.getClass() == getClass() && a(this, (a)param1Object));
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
/*     */     private static boolean a(a param1a1, a param1a2) {
/* 370 */       return (param1a1.b == param1a2.b && param1a1.c == param1a2.c && param1a1.d == param1a2.d && param1a1.e == param1a2.e && param1a1.f == param1a2.f);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */