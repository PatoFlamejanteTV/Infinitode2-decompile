/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.annotation.Annotation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class u
/*     */ {
/*  13 */   protected static final aa[] a = new aa[0];
/*  14 */   protected static final Annotation[] b = new Annotation[0];
/*     */   
/*     */   protected final a c;
/*     */   
/*     */   protected u(a parama) {
/*  19 */     this.c = parama;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final p a(Annotation[] paramArrayOfAnnotation) {
/*  25 */     p p = p.b(); byte b; int i;
/*  26 */     for (b = 0, i = paramArrayOfAnnotation.length; b < i; b++) {
/*  27 */       Annotation annotation = paramArrayOfAnnotation[b];
/*  28 */       p = p.b(annotation);
/*  29 */       if (this.c.a(annotation)) {
/*  30 */         p = a(p, annotation);
/*     */       }
/*     */     } 
/*  33 */     return p;
/*     */   } protected final p a(p paramp, Annotation[] paramArrayOfAnnotation) {
/*     */     byte b;
/*     */     int i;
/*  37 */     for (b = 0, i = paramArrayOfAnnotation.length; b < i; b++) {
/*  38 */       Annotation annotation = paramArrayOfAnnotation[b];
/*  39 */       paramp = paramp.b(annotation);
/*  40 */       if (this.c.a(annotation)) {
/*  41 */         paramp = a(paramp, annotation);
/*     */       }
/*     */     } 
/*  44 */     return paramp;
/*     */   }
/*     */   
/*     */   private p a(p paramp, Annotation paramAnnotation) {
/*  48 */     Annotation[] arrayOfAnnotation = i.o(paramAnnotation.annotationType()); byte b; int i;
/*  49 */     for (b = 0, i = arrayOfAnnotation.length; b < i; b++) {
/*     */       Annotation annotation;
/*     */       
/*  52 */       if (!a(annotation = arrayOfAnnotation[b]))
/*     */       {
/*     */         
/*  55 */         if (this.c.a(annotation)) {
/*     */           
/*  57 */           if (!paramp.a(annotation)) {
/*  58 */             paramp = paramp.b(annotation);
/*  59 */             paramp = a(paramp, annotation);
/*     */           } 
/*     */         } else {
/*  62 */           paramp = paramp.b(annotation);
/*     */         }  } 
/*     */     } 
/*  65 */     return paramp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected final p b(p paramp, Annotation[] paramArrayOfAnnotation) {
/*     */     byte b;
/*     */     int i;
/*  73 */     for (b = 0, i = paramArrayOfAnnotation.length; b < i; b++) {
/*  74 */       Annotation annotation = paramArrayOfAnnotation[b];
/*  75 */       if (!paramp.a(annotation)) {
/*  76 */         paramp = paramp.b(annotation);
/*  77 */         if (this.c.a(annotation)) {
/*  78 */           paramp = b(paramp, annotation);
/*     */         }
/*     */       } 
/*     */     } 
/*  82 */     return paramp;
/*     */   }
/*     */ 
/*     */   
/*     */   private p b(p paramp, Annotation paramAnnotation) {
/*  87 */     Annotation[] arrayOfAnnotation = i.o(paramAnnotation.annotationType()); byte b; int i;
/*  88 */     for (b = 0, i = arrayOfAnnotation.length; b < i; b++) {
/*     */       Annotation annotation;
/*     */       
/*  91 */       if (!a(annotation = arrayOfAnnotation[b]))
/*     */       {
/*     */ 
/*     */         
/*  95 */         if (!paramp.a(annotation)) {
/*  96 */           paramp = paramp.b(annotation);
/*  97 */           if (this.c.a(annotation))
/*  98 */             paramp = a(paramp, annotation); 
/*     */         } 
/*     */       }
/*     */     } 
/* 102 */     return paramp;
/*     */   }
/*     */   
/*     */   private static boolean a(Annotation paramAnnotation) {
/* 106 */     return (paramAnnotation instanceof java.lang.annotation.Target || paramAnnotation instanceof java.lang.annotation.Retention);
/*     */   }
/*     */   
/*     */   static aa a() {
/* 110 */     return new aa();
/*     */   }
/*     */   
/*     */   static aa[] a(int paramInt) {
/* 114 */     if (paramInt == 0) {
/* 115 */       return a;
/*     */     }
/* 117 */     aa[] arrayOfAa = new aa[paramInt];
/* 118 */     for (byte b = 0; b < paramInt; b++) {
/* 119 */       arrayOfAa[b] = a();
/*     */     }
/* 121 */     return arrayOfAa;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */