/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class p
/*     */ {
/*  18 */   protected static final com.a.a.c.m.b a = new c();
/*     */ 
/*     */   
/*     */   protected final Object b;
/*     */ 
/*     */ 
/*     */   
/*     */   protected p(Object paramObject) {
/*  26 */     this.b = paramObject;
/*     */   }
/*     */   public static com.a.a.c.m.b a() {
/*  29 */     return a;
/*     */   }
/*     */   public static p b() {
/*  32 */     return a.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract com.a.a.c.m.b c();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract aa d();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean a(Annotation paramAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract p b(Annotation paramAnnotation);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class a
/*     */     extends p
/*     */   {
/*  64 */     public static final a c = new a(null);
/*     */     private a(Object param1Object) {
/*  66 */       super(param1Object);
/*     */     }
/*     */     
/*     */     public final com.a.a.c.m.b c() {
/*  70 */       return a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final aa d() {
/*  75 */       return new aa();
/*     */     }
/*     */     
/*     */     public final boolean a(Annotation param1Annotation) {
/*  79 */       return false;
/*     */     }
/*     */     
/*     */     public final p b(Annotation param1Annotation) {
/*  83 */       return new p.e(this.b, param1Annotation.annotationType(), param1Annotation);
/*     */     }
/*     */   }
/*     */   
/*     */   static class e
/*     */     extends p
/*     */   {
/*     */     private Class<?> c;
/*     */     private Annotation d;
/*     */     
/*     */     public e(Object param1Object, Class<?> param1Class, Annotation param1Annotation) {
/*  94 */       super(param1Object);
/*  95 */       this.c = param1Class;
/*  96 */       this.d = param1Annotation;
/*     */     }
/*     */ 
/*     */     
/*     */     public final com.a.a.c.m.b c() {
/* 101 */       return new p.d(this.c, this.d);
/*     */     }
/*     */ 
/*     */     
/*     */     public final aa d() {
/* 106 */       return aa.a(this.c, this.d);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(Annotation param1Annotation) {
/* 111 */       return (param1Annotation.annotationType() == this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public final p b(Annotation param1Annotation) {
/* 116 */       Class<? extends Annotation> clazz = param1Annotation.annotationType();
/*     */       
/* 118 */       if (this.c == clazz) {
/* 119 */         this.d = param1Annotation;
/* 120 */         return this;
/*     */       } 
/* 122 */       return new p.b(this.b, this.c, this.d, clazz, param1Annotation);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class b
/*     */     extends p
/*     */   {
/*     */     private HashMap<Class<?>, Annotation> c;
/*     */     
/*     */     public b(Object param1Object, Class<?> param1Class1, Annotation param1Annotation1, Class<?> param1Class2, Annotation param1Annotation2) {
/* 133 */       super(param1Object);
/* 134 */       this.c = new HashMap<>();
/* 135 */       this.c.put(param1Class1, param1Annotation1);
/* 136 */       this.c.put(param1Class2, param1Annotation2);
/*     */     }
/*     */ 
/*     */     
/*     */     public final com.a.a.c.m.b c() {
/* 141 */       if (this.c.size() == 2) {
/*     */         Iterator<Map.Entry> iterator;
/* 143 */         Map.Entry entry2 = (iterator = this.c.entrySet().iterator()).next(), entry1 = iterator.next();
/* 144 */         return new p.f((Class)entry2.getKey(), (Annotation)entry2.getValue(), (Class)entry1
/* 145 */             .getKey(), (Annotation)entry1.getValue());
/*     */       } 
/* 147 */       return new aa(this.c);
/*     */     }
/*     */ 
/*     */     
/*     */     public final aa d() {
/* 152 */       aa aa = new aa();
/* 153 */       for (Annotation annotation : this.c.values()) {
/* 154 */         aa.a(annotation);
/*     */       }
/* 156 */       return aa;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(Annotation param1Annotation) {
/* 161 */       return this.c.containsKey(param1Annotation.annotationType());
/*     */     }
/*     */ 
/*     */     
/*     */     public final p b(Annotation param1Annotation) {
/* 166 */       this.c.put(param1Annotation.annotationType(), param1Annotation);
/* 167 */       return this;
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
/*     */   public static class c
/*     */     implements com.a.a.c.m.b, Serializable
/*     */   {
/*     */     public final <A extends Annotation> A a(Class<A> param1Class) {
/* 192 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean b(Class<?> param1Class) {
/* 197 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(Class<? extends Annotation>[] param1ArrayOfClass) {
/* 202 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int a() {
/* 207 */       return 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class d
/*     */     implements com.a.a.c.m.b, Serializable
/*     */   {
/*     */     private final Class<?> a;
/*     */     
/*     */     private final Annotation b;
/*     */     
/*     */     public d(Class<?> param1Class, Annotation param1Annotation) {
/* 220 */       this.a = param1Class;
/* 221 */       this.b = param1Annotation;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final <A extends Annotation> A a(Class<A> param1Class) {
/* 227 */       if (this.a == param1Class) {
/* 228 */         return (A)this.b;
/*     */       }
/* 230 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean b(Class<?> param1Class) {
/* 235 */       return (this.a == param1Class);
/*     */     }
/*     */     public final boolean a(Class<? extends Annotation>[] param1ArrayOfClass) {
/*     */       int i;
/*     */       byte b1;
/* 240 */       for (i = (param1ArrayOfClass = param1ArrayOfClass).length, b1 = 0; b1 < i; b1++) {
/* 241 */         Class<? extends Annotation> clazz; if ((clazz = param1ArrayOfClass[b1]) == this.a) {
/* 242 */           return true;
/*     */         }
/*     */       } 
/* 245 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int a() {
/* 250 */       return 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class f
/*     */     implements com.a.a.c.m.b, Serializable
/*     */   {
/*     */     private final Class<?> a;
/*     */     private final Class<?> b;
/*     */     private final Annotation c;
/*     */     private final Annotation d;
/*     */     
/*     */     public f(Class<?> param1Class1, Annotation param1Annotation1, Class<?> param1Class2, Annotation param1Annotation2) {
/* 264 */       this.a = param1Class1;
/* 265 */       this.c = param1Annotation1;
/* 266 */       this.b = param1Class2;
/* 267 */       this.d = param1Annotation2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final <A extends Annotation> A a(Class<A> param1Class) {
/* 273 */       if (this.a == param1Class) {
/* 274 */         return (A)this.c;
/*     */       }
/* 276 */       if (this.b == param1Class) {
/* 277 */         return (A)this.d;
/*     */       }
/* 279 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean b(Class<?> param1Class) {
/* 284 */       return (this.a == param1Class || this.b == param1Class);
/*     */     }
/*     */     public final boolean a(Class<? extends Annotation>[] param1ArrayOfClass) {
/*     */       int i;
/*     */       byte b1;
/* 289 */       for (i = (param1ArrayOfClass = param1ArrayOfClass).length, b1 = 0; b1 < i; ) {
/* 290 */         Class<? extends Annotation> clazz; if ((clazz = param1ArrayOfClass[b1]) == this.a || clazz == this.b)
/* 291 */           return true; 
/*     */         b1++;
/*     */       } 
/* 294 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public final int a() {
/* 299 */       return 2;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\p.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */