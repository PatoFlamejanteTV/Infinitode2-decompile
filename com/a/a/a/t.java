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
/*     */ @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
/*     */ @Retention(RetentionPolicy.RUNTIME)
/*     */ public @interface t
/*     */ {
/*     */   String[] a() default {};
/*     */   
/*     */   public static class a
/*     */     implements Serializable
/*     */   {
/*  57 */     private static a a = new a(null);
/*     */ 
/*     */ 
/*     */     
/*     */     private Set<String> b;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(Set<String> param1Set) {
/*  67 */       this.b = param1Set;
/*     */     }
/*     */ 
/*     */     
/*     */     public static a a(t param1t) {
/*  72 */       if (param1t == null) {
/*  73 */         return a;
/*     */       }
/*  75 */       return new a(a(param1t.a()));
/*     */     }
/*     */ 
/*     */     
/*     */     public static a a() {
/*  80 */       return a;
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
/*     */     public final Set<String> b() {
/*  94 */       return this.b;
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
/*     */     public final String toString() {
/* 129 */       return String.format("JsonIncludeProperties.Value(included=%s)", new Object[] { this.b });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int hashCode() {
/* 135 */       return (this.b == null) ? 0 : this.b.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean equals(Object param1Object) {
/* 140 */       if (param1Object == this) return true; 
/* 141 */       if (param1Object == null) return false; 
/* 142 */       return (param1Object.getClass() == getClass() && a(this.b, ((a)param1Object).b));
/*     */     }
/*     */ 
/*     */     
/*     */     private static boolean a(Set<String> param1Set1, Set<String> param1Set2) {
/* 147 */       return (param1Set1 == null) ? ((param1Set2 == null)) : param1Set1
/*     */         
/* 149 */         .equals(param1Set2);
/*     */     }
/*     */ 
/*     */     
/*     */     private static Set<String> a(String[] param1ArrayOfString) {
/* 154 */       if (param1ArrayOfString == null || param1ArrayOfString.length == 0) {
/* 155 */         return Collections.emptySet();
/*     */       }
/* 157 */       HashSet<String> hashSet = new HashSet(param1ArrayOfString.length); int i; byte b;
/* 158 */       for (i = (param1ArrayOfString = param1ArrayOfString).length, b = 0; b < i; ) { String str = param1ArrayOfString[b];
/* 159 */         hashSet.add(str); b++; }
/*     */       
/* 161 */       return hashSet;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\a\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */