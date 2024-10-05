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
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface ac
/*     */ {
/*     */   String a() default "";
/*     */   
/*     */   ak b() default ak.DEFAULT;
/*     */   
/*     */   ak c() default ak.DEFAULT;
/*     */   
/*     */   public static class a
/*     */     implements Serializable
/*     */   {
/*     */     private final ak a;
/*     */     private final ak b;
/*  75 */     private static a c = new a(ak.d, ak.d);
/*     */     
/*     */     private a(ak param1ak1, ak param1ak2) {
/*  78 */       this.a = param1ak1;
/*  79 */       this.b = param1ak2;
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
/*     */     public static a a(ac param1ac) {
/*  96 */       if (param1ac == null) {
/*  97 */         return c;
/*     */       }
/*  99 */       return a(param1ac.b(), param1ac.c());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static a a(ak param1ak1, ak param1ak2) {
/* 110 */       if (param1ak1 == null) {
/* 111 */         param1ak1 = ak.d;
/*     */       }
/* 113 */       if (param1ak2 == null) {
/* 114 */         param1ak2 = ak.d;
/*     */       }
/* 116 */       if (b(param1ak1, param1ak2)) {
/* 117 */         return c;
/*     */       }
/* 119 */       return new a(param1ak1, param1ak2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static a a() {
/* 130 */       return c;
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
/*     */     public final ak b() {
/* 220 */       return this.b;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ak c() {
/* 227 */       return (this.a == ak.d) ? null : this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ak d() {
/* 235 */       return (this.b == ak.d) ? null : this.b;
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
/* 246 */       return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[] { this.a, this.b });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 252 */       return this.a.ordinal() + (this.b.ordinal() << 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 257 */       if (param1Object == this) return true; 
/* 258 */       if (param1Object == null) return false; 
/* 259 */       if (param1Object.getClass() == getClass()) {
/*     */         
/* 261 */         if (((a)(param1Object = param1Object)).a == this.a && ((a)param1Object).b == this.b) return true;  return false;
/*     */       } 
/*     */       
/* 264 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static boolean b(ak param1ak1, ak param1ak2) {
/* 274 */       return (param1ak1 == ak.d && param1ak2 == ak.d);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */