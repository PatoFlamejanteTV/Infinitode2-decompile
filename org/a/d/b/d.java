/*     */ package org.a.d.b;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import org.a.d.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class d
/*     */   extends a
/*     */ {
/*     */   private String a;
/*     */   private String b;
/*     */   private String c;
/*     */   
/*     */   public d(b paramb, String paramString1, String paramString2, String paramString3) {
/*  63 */     super(paramb, paramString3);
/*     */     al al;
/*  65 */     if ((al = getClass().<Annotation>getAnnotation(al.class)) != null) {
/*     */ 
/*     */       
/*  68 */       this.a = al.a();
/*  69 */       this.b = al.b();
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  74 */       if (paramString1 == null)
/*     */       {
/*  76 */         throw new IllegalArgumentException("Both StructuredType annotation and namespace parameter cannot be null");
/*     */       }
/*     */       
/*  79 */       this.a = paramString1;
/*  80 */       this.b = paramString2;
/*     */     } 
/*  82 */     this.c = (paramString2 == null) ? this.b : paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String h() {
/*  92 */     return this.a;
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
/*     */   public final String i() {
/* 107 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final void f(String paramString) {
/* 112 */     this.c = paramString;
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
/*     */   public final am d(String paramString1, String paramString2) {
/* 155 */     return g().b().a(h(), i(), paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public final f a(String paramString, k paramk) {
/* 160 */     return g().b().a(h(), i(), paramString, paramk);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */