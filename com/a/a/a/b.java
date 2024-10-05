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
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface b
/*     */ {
/*     */   String a() default "";
/*     */   
/*     */   ao b() default ao.DEFAULT;
/*     */   
/*     */   public static class a
/*     */     implements Serializable
/*     */   {
/*  66 */     private static a a = new a(null, null);
/*     */ 
/*     */     
/*     */     private Object b;
/*     */ 
/*     */     
/*     */     private Boolean c;
/*     */ 
/*     */ 
/*     */     
/*     */     private a(Object param1Object, Boolean param1Boolean) {
/*  77 */       this.b = param1Object;
/*  78 */       this.c = param1Boolean;
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
/*     */     private static a a(Object param1Object, Boolean param1Boolean) {
/*  97 */       if ("".equals(param1Object)) {
/*  98 */         param1Object = null;
/*     */       }
/* 100 */       if (b(param1Object, param1Boolean)) {
/* 101 */         return a;
/*     */       }
/* 103 */       return new a(param1Object, param1Boolean);
/*     */     }
/*     */     
/*     */     public static a a(b param1b) {
/* 107 */       if (param1b == null) {
/* 108 */         return a;
/*     */       }
/* 110 */       return a(param1b.a(), param1b.b().a());
/*     */     }
/*     */     
/*     */     public static a a(Object param1Object) {
/* 114 */       return a(param1Object, null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a b(Object param1Object) {
/* 124 */       if (param1Object == null) {
/* 125 */         if (this.b == null) {
/* 126 */           return this;
/*     */         }
/* 128 */       } else if (param1Object.equals(this.b)) {
/* 129 */         return this;
/*     */       } 
/* 131 */       return new a(param1Object, this.c);
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
/*     */     public final Object a() {
/* 151 */       return this.b;
/*     */     }
/*     */     
/*     */     public final boolean b() {
/* 155 */       return (this.b != null);
/*     */     }
/*     */     
/*     */     public final boolean a(boolean param1Boolean) {
/* 159 */       return (this.c == null) ? true : this.c.booleanValue();
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
/* 170 */       return String.format("JacksonInject.Value(id=%s,useInput=%s)", new Object[] { this.b, this.c });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 176 */       int i = 1;
/* 177 */       if (this.b != null) {
/* 178 */         i = 1 + this.b.hashCode();
/*     */       }
/* 180 */       if (this.c != null) {
/* 181 */         i += this.c.hashCode();
/*     */       }
/* 183 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 188 */       if (param1Object == this) return true; 
/* 189 */       if (param1Object == null) return false; 
/* 190 */       if (param1Object.getClass() == getClass()) {
/* 191 */         param1Object = param1Object;
/* 192 */         if (ao.a(this.c, ((a)param1Object).c)) {
/* 193 */           if (this.b == null) {
/* 194 */             return (((a)param1Object).b == null);
/*     */           }
/* 196 */           return this.b.equals(((a)param1Object).b);
/*     */         } 
/*     */       } 
/* 199 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static boolean b(Object param1Object, Boolean param1Boolean) {
/* 209 */       return (param1Object == null && param1Boolean == null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */