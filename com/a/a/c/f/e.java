/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.n;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class e
/*     */ {
/*  27 */   private static final b a = p.a();
/*     */   
/*  29 */   private static final Class<?> b = Object.class;
/*  30 */   private static final Class<?> c = Enum.class;
/*     */   
/*  32 */   private static final Class<?> d = List.class;
/*  33 */   private static final Class<?> e = Map.class;
/*     */   
/*     */   private final q<?> f;
/*     */   
/*     */   private final a g;
/*     */   
/*     */   private final t.a h;
/*     */   
/*     */   private final n i;
/*     */   
/*     */   private final j j;
/*     */   
/*     */   private final Class<?> k;
/*     */   private final Class<?> l;
/*     */   private final boolean m;
/*     */   
/*     */   private e(q<?> paramq, j paramj, t.a parama) {
/*  50 */     this.f = paramq;
/*  51 */     this.j = paramj;
/*  52 */     this.k = paramj.b();
/*  53 */     this.h = parama;
/*  54 */     this.i = paramj.x();
/*  55 */     this
/*  56 */       .g = paramq.f() ? paramq.j() : null;
/*  57 */     this.l = (parama == null) ? null : parama.i(this.k);
/*     */ 
/*     */ 
/*     */     
/*  61 */     this
/*  62 */       .m = (this.g != null && (!i.m(this.k) || !this.j.n()));
/*     */   }
/*     */   
/*     */   private e(q<?> paramq, Class<?> paramClass, t.a parama) {
/*  66 */     this.f = paramq;
/*  67 */     this.j = null;
/*  68 */     this.k = paramClass;
/*  69 */     this.h = parama;
/*  70 */     this.i = n.a();
/*     */     
/*  72 */     this.g = null;
/*     */ 
/*     */     
/*  75 */     this
/*  76 */       .g = paramq.f() ? paramq.j() : null;
/*  77 */     this.l = (paramq == null) ? null : ((parama == null) ? null : parama.i(this.k));
/*     */ 
/*     */     
/*  80 */     this.m = (this.g != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static d a(q<?> paramq, j paramj, t.a parama) {
/*  86 */     if (paramj.g() && b(paramq, paramj.b())) {
/*  87 */       return b(paramj.b());
/*     */     }
/*  89 */     return (new e(paramq, paramj, parama)).a();
/*     */   }
/*     */   
/*     */   public static d a(q<?> paramq, Class<?> paramClass) {
/*  93 */     return a(paramq, paramClass, (t.a)paramq);
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
/*     */   private static d a(q<?> paramq, Class<?> paramClass, t.a parama) {
/* 108 */     if (paramClass.isArray() && b(paramq, paramClass)) {
/* 109 */       return b(paramClass);
/*     */     }
/* 111 */     return (new e(paramq, paramClass, parama)).b();
/*     */   }
/*     */   
/*     */   private static boolean b(q<?> paramq, Class<?> paramClass) {
/* 115 */     return (paramq == null || paramq.i(paramClass) == null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static d a(Class<?> paramClass) {
/* 123 */     return new d(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static d b(Class<?> paramClass) {
/* 131 */     return new d(paramClass);
/*     */   }
/*     */   
/*     */   private d a() {
/* 135 */     ArrayList<j> arrayList = new ArrayList(8);
/* 136 */     if (!this.j.a(Object.class)) {
/* 137 */       if (this.j.k()) {
/* 138 */         b(this.j, arrayList, false);
/*     */       } else {
/* 140 */         a(this.j, arrayList, false);
/*     */       } 
/*     */     }
/*     */     
/* 144 */     return new d(this.j, this.k, arrayList, this.l, 
/* 145 */         a(arrayList), this.i, this.g, this.h, this.f
/* 146 */         .p(), this.m);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private d b() {
/* 152 */     List<?> list = Collections.emptyList();
/* 153 */     return new d(null, this.k, (List)list, this.l, 
/* 154 */         a((List)list), this.i, this.g, this.h, this.f
/* 155 */         .p(), this.m);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(j paramj, List<j> paramList, boolean paramBoolean) {
/*     */     Class<?> clazz;
/* 165 */     if ((clazz = paramj.b()) == b || clazz == c) {
/*     */       return;
/*     */     }
/* 168 */     if (paramBoolean) {
/* 169 */       if (a(paramList, clazz)) {
/*     */         return;
/*     */       }
/* 172 */       paramList.add(paramj);
/*     */     } 
/* 174 */     for (Iterator<j> iterator = paramj.z().iterator(); iterator.hasNext();) {
/* 175 */       b(j2 = iterator.next(), paramList, true);
/*     */     }
/*     */     j j1;
/* 178 */     if ((j1 = paramj.y()) != null) {
/* 179 */       a(j1, paramList, true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void b(j paramj, List<j> paramList, boolean paramBoolean) {
/* 186 */     Class<?> clazz = paramj.b();
/* 187 */     if (paramBoolean) {
/* 188 */       if (a(paramList, clazz)) {
/*     */         return;
/*     */       }
/* 191 */       paramList.add(paramj);
/*     */       
/* 193 */       if (clazz == d || clazz == e) {
/*     */         return;
/*     */       }
/*     */     } 
/* 197 */     for (Iterator<j> iterator = paramj.z().iterator(); iterator.hasNext();)
/* 198 */       b(j1 = iterator.next(), paramList, true); 
/*     */   }
/*     */   private static boolean a(List<j> paramList, Class<?> paramClass) {
/*     */     byte b1;
/*     */     int i;
/* 203 */     for (b1 = 0, i = paramList.size(); b1 < i; b1++) {
/* 204 */       if (((j)paramList.get(b1)).b() == paramClass) {
/* 205 */         return true;
/*     */       }
/*     */     } 
/* 208 */     return false;
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
/*     */   private b a(List<j> paramList) {
/* 225 */     if (this.g == null) {
/* 226 */       return a;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     boolean bool;
/*     */ 
/*     */     
/* 234 */     if (!(bool = (this.h != null && (!(this.h instanceof am) || ((am)this.h).a())) ? true : false) && !this.m) {
/* 235 */       return a;
/*     */     }
/*     */     
/* 238 */     p p = p.b();
/*     */     
/* 240 */     if (this.l != null) {
/* 241 */       p = a(p, this.k, this.l);
/*     */     }
/*     */ 
/*     */     
/* 245 */     if (this.m) {
/* 246 */       p = a(p, 
/* 247 */           i.o(this.k));
/*     */     }
/*     */ 
/*     */     
/* 251 */     for (j j1 : paramList) {
/*     */       
/* 253 */       if (bool) {
/* 254 */         Class<?> clazz = j1.b();
/* 255 */         p = a(p, clazz, this.h
/* 256 */             .i(clazz));
/*     */       } 
/* 258 */       if (this.m) {
/* 259 */         p = a(p, 
/* 260 */             i.o(j1.b()));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 269 */     if (bool) {
/* 270 */       p = a(p, Object.class, this.h
/* 271 */           .i(Object.class));
/*     */     }
/* 273 */     return p.c();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private p a(p paramp, Class<?> paramClass1, Class<?> paramClass2) {
/* 279 */     if (paramClass2 != null) {
/*     */       
/* 281 */       paramp = a(paramp, i.o(paramClass2));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 288 */       for (Class<?> paramClass2 : (Iterable<Class<?>>)i.b(paramClass2, paramClass1, false)) {
/* 289 */         paramp = a(paramp, i.o(paramClass2));
/*     */       }
/*     */     } 
/* 292 */     return paramp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private p a(p paramp, Annotation[] paramArrayOfAnnotation) {
/* 298 */     if (paramArrayOfAnnotation != null) {
/* 299 */       int i; byte b1; for (i = (paramArrayOfAnnotation = paramArrayOfAnnotation).length, b1 = 0; b1 < i; ) { Annotation annotation = paramArrayOfAnnotation[b1];
/*     */         
/* 301 */         if (!paramp.a(annotation)) {
/* 302 */           paramp = paramp.b(annotation);
/* 303 */           if (this.g.a(annotation))
/* 304 */             paramp = a(paramp, annotation); 
/*     */         } 
/*     */         b1++; }
/*     */     
/*     */     } 
/* 309 */     return paramp;
/*     */   }
/*     */   private p a(p paramp, Annotation paramAnnotation) {
/*     */     Annotation[] arrayOfAnnotation;
/*     */     int i;
/*     */     byte b1;
/* 315 */     for (i = (arrayOfAnnotation = i.o(paramAnnotation.annotationType())).length, b1 = 0; b1 < i; ) {
/*     */       Annotation annotation;
/* 317 */       if (!(annotation = arrayOfAnnotation[b1] instanceof java.lang.annotation.Target) && !(annotation instanceof java.lang.annotation.Retention))
/*     */       {
/*     */         
/* 320 */         if (!paramp.a(annotation)) {
/* 321 */           paramp = paramp.b(annotation);
/* 322 */           if (this.g.a(annotation))
/* 323 */             paramp = a(paramp, annotation); 
/*     */         }  } 
/*     */       b1++;
/*     */     } 
/* 327 */     return paramp;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */