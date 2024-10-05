/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class l
/*     */   extends u
/*     */ {
/*     */   private final t.a d;
/*     */   private final boolean e;
/*     */   
/*     */   private l(com.a.a.c.a parama, t.a parama1, boolean paramBoolean) {
/*  27 */     super(parama);
/*  28 */     this.d = (parama == null) ? null : parama1;
/*  29 */     this.e = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static m a(com.a.a.c.a parama, an paraman, t.a parama1, o paramo, j paramj, List<j> paramList, Class<?> paramClass, boolean paramBoolean) {
/*  39 */     return (new l(parama, parama1, paramBoolean))
/*  40 */       .a(paramo, paraman, paramj, paramList, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private m a(o paramo, an paraman, j paramj, List<j> paramList, Class<?> paramClass) {
/*  46 */     LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<>();
/*     */ 
/*     */     
/*  49 */     a(paraman, paramj.b(), (Map)linkedHashMap2, paramClass);
/*     */ 
/*     */     
/*  52 */     for (j j1 : paramList) {
/*  53 */       Class<?> clazz = (this.d == null) ? null : this.d.i(j1.b());
/*  54 */       a(new an.a(paramo, j1
/*  55 */             .x()), j1
/*  56 */           .b(), (Map)linkedHashMap2, clazz);
/*     */     } 
/*     */     
/*  59 */     boolean bool = false;
/*  60 */     if (this.d != null && (
/*     */       
/*  62 */       paramClass = this.d.i(Object.class)) != null) {
/*  63 */       b(paraman, paramj.b(), (Map)linkedHashMap2, paramClass);
/*  64 */       bool = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     if (bool && this.c != null && !linkedHashMap2.isEmpty())
/*     */     {
/*  74 */       for (Iterator<Map.Entry> iterator1 = linkedHashMap2.entrySet().iterator(); iterator1.hasNext(); ) {
/*  75 */         Map.Entry<z, ?> entry; z z = (entry = iterator1.next()).getKey();
/*  76 */         if ("hashCode".equals(z.a()) && 0 == z.b()) {
/*     */           try {
/*     */             Method method;
/*     */ 
/*     */ 
/*     */             
/*  82 */             if ((method = Object.class.getDeclaredMethod(z.a(), new Class[0])) != null) {
/*     */               a a1;
/*  84 */               (a1 = (a)entry.getValue()).c = b(a1.c, method
/*  85 */                   .getDeclaredAnnotations());
/*  86 */               a1.b = method;
/*     */             } 
/*  88 */           } catch (Exception exception) {}
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  93 */     if (linkedHashMap2.isEmpty()) {
/*  94 */       return new m();
/*     */     }
/*  96 */     LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<>(linkedHashMap2.size());
/*  97 */     for (Iterator<Map.Entry> iterator = linkedHashMap2.entrySet().iterator(); iterator.hasNext();) {
/*     */       
/*  99 */       if ((k = ((a)(entry = iterator.next()).getValue()).a()) != null) {
/* 100 */         linkedHashMap1.put(entry.getKey(), k);
/*     */       }
/*     */     } 
/* 103 */     return new m((Map)linkedHashMap1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(an paraman, Class<?> paramClass1, Map<z, a> paramMap, Class<?> paramClass2) {
/* 110 */     if (paramClass2 != null) {
/* 111 */       b(paraman, paramClass1, paramMap, paramClass2);
/*     */     }
/* 113 */     if (paramClass1 == null)
/*     */       return;  Method[] arrayOfMethod;
/*     */     int i;
/*     */     byte b;
/* 117 */     for (i = (arrayOfMethod = i.p(paramClass1)).length, b = 0; b < i; b++) {
/* 118 */       Method method; if (a(method = arrayOfMethod[b])) {
/*     */ 
/*     */         
/* 121 */         z z = new z(method);
/*     */         a a1;
/* 123 */         if ((a1 = paramMap.get(z)) == null) {
/*     */           
/* 125 */           p p = (this.c == null) ? p.b() : a(method.getDeclaredAnnotations());
/* 126 */           paramMap.put(z, new a(paraman, method, p));
/*     */         } else {
/* 128 */           if (this.e) {
/* 129 */             a1.c = b(a1.c, method.getDeclaredAnnotations());
/*     */           }
/*     */           Method method1;
/* 132 */           if ((method1 = a1.b) == null) {
/* 133 */             a1.b = method;
/*     */           }
/* 135 */           else if (Modifier.isAbstract(method1.getModifiers()) && 
/* 136 */             !Modifier.isAbstract(method.getModifiers())) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 143 */             a1.b = method;
/*     */ 
/*     */             
/* 146 */             a1.a = paraman;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void b(an paraman, Class<?> paramClass1, Map<z, a> paramMap, Class<?> paramClass2) {
/* 155 */     if (this.c == null) {
/*     */       return;
/*     */     }
/* 158 */     for (Iterator<Class<?>> iterator = i.a(paramClass2, paramClass1, true).iterator(); iterator.hasNext();) {
/* 159 */       for (i = (arrayOfMethod = (paramClass2 = iterator.next()).getDeclaredMethods()).length, b = 0; b < i; b++) {
/* 160 */         Method method; if (a(method = arrayOfMethod[b])) {
/*     */ 
/*     */           
/* 163 */           z z = new z(method);
/* 164 */           a a1 = paramMap.get(z);
/* 165 */           Annotation[] arrayOfAnnotation = method.getDeclaredAnnotations();
/* 166 */           if (a1 == null) {
/*     */ 
/*     */             
/* 169 */             paramMap.put(z, new a(paraman, null, a(arrayOfAnnotation)));
/*     */           } else {
/* 171 */             a1.c = b(a1.c, arrayOfAnnotation);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean a(Method paramMethod) {
/* 179 */     if (Modifier.isStatic(paramMethod.getModifiers()) || paramMethod
/*     */ 
/*     */       
/* 182 */       .isSynthetic() || paramMethod.isBridge()) {
/* 183 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 187 */     return (paramMethod.getParameterCount() <= 2);
/*     */   }
/*     */ 
/*     */   
/*     */   static final class a
/*     */   {
/*     */     public an a;
/*     */     
/*     */     public Method b;
/*     */     public p c;
/*     */     
/*     */     public a(an param1an, Method param1Method, p param1p) {
/* 199 */       this.a = param1an;
/* 200 */       this.b = param1Method;
/* 201 */       this.c = param1p;
/*     */     }
/*     */     
/*     */     public final k a() {
/* 205 */       if (this.b == null) {
/* 206 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 210 */       return new k(this.a, this.b, this.c.d(), null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */