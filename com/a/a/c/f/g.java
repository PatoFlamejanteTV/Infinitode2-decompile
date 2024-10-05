/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.AnnotatedElement;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class g
/*     */   extends u
/*     */ {
/*     */   private final an d;
/*     */   private final boolean e;
/*     */   private f f;
/*     */   
/*     */   private g(a parama, an paraman, boolean paramBoolean) {
/*  43 */     super(parama);
/*  44 */     this.d = paraman;
/*  45 */     this.e = paramBoolean;
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
/*     */   public static d.a a(a parama, o paramo, an paraman, j paramj, Class<?> paramClass, boolean paramBoolean) {
/*  57 */     int i = paramBoolean | ((paramClass != null) ? 1 : 0);
/*     */ 
/*     */     
/*  60 */     return (new g(parama, paraman, i))
/*  61 */       .a(paramo, paramj, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d.a a(o paramo, j paramj, Class<?> paramClass) {
/*  70 */     List<f> list1 = a(paramj, paramClass);
/*  71 */     List<k> list = b(paramo, paramj, paramClass);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     if (this.e) {
/*  78 */       if (this.f != null && 
/*  79 */         this.c.d(this.f)) {
/*  80 */         this.f = null;
/*     */       }
/*     */       
/*     */       int i;
/*  84 */       for (i = list1.size(); --i >= 0;) {
/*  85 */         if (this.c.d(list1.get(i))) {
/*  86 */           list1.remove(i);
/*     */         }
/*     */       } 
/*  89 */       for (i = list.size(); --i >= 0;) {
/*  90 */         if (this.c.d(list.get(i))) {
/*  91 */           list.remove(i);
/*     */         }
/*     */       } 
/*     */     } 
/*  95 */     return new d.a(this.f, list1, list);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<f> a(j paramj, Class<?> paramClass) {
/*     */     List<?> list;
/*     */     int i;
/* 106 */     i.a a = null;
/* 107 */     ArrayList<i.a> arrayList = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     if (!paramj.h()) {
/*     */       i.a[] arrayOfA1; i.a[] arrayOfA2; int k; byte b1;
/* 116 */       for (k = (arrayOfA2 = arrayOfA1 = i.q(paramj.b())).length, b1 = 0; b1 < k; b1++) {
/* 117 */         i.a a1; if (a((a1 = arrayOfA2[b1]).a()))
/*     */         {
/*     */           
/* 120 */           if (a1.b() == 0) {
/* 121 */             a = a1;
/*     */           } else {
/* 123 */             if (arrayList == null) {
/* 124 */               arrayList = new ArrayList();
/*     */             }
/* 126 */             arrayList.add(a1);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     if (arrayList == null) {
/* 133 */       list = Collections.emptyList();
/*     */       
/* 135 */       if (a == null) {
/* 136 */         return (List)list;
/*     */       }
/* 138 */       i = 0;
/*     */     } else {
/* 140 */       i = arrayList.size();
/* 141 */       list = new ArrayList(i);
/* 142 */       for (byte b1 = 0; b1 < i; b1++) {
/* 143 */         list.add(null);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 148 */     if (paramClass != null) {
/* 149 */       z[] arrayOfZ = null; byte b1; i.a[] arrayOfA; int k;
/* 150 */       for (k = (arrayOfA = i.q(paramClass)).length, b1 = 0; b1 < k; b1++) {
/* 151 */         i.a a1; if ((a1 = arrayOfA[b1]).b() == 0) {
/* 152 */           if (a != null) {
/* 153 */             this.f = a(a, a1);
/* 154 */             a = null;
/*     */           }
/*     */         
/*     */         }
/* 158 */         else if (arrayList != null) {
/* 159 */           if (arrayOfZ == null) {
/* 160 */             arrayOfZ = new z[i];
/* 161 */             for (byte b3 = 0; b3 < i; b3++) {
/* 162 */               arrayOfZ[b3] = new z(((i.a)arrayList.get(b3)).a());
/*     */             }
/*     */           } 
/* 165 */           z z = new z(a1.a());
/*     */           
/* 167 */           for (byte b2 = 0; b2 < i; b2++) {
/* 168 */             if (z.equals(arrayOfZ[b2])) {
/* 169 */               list.set(b2, 
/* 170 */                   b(arrayList.get(b2), a1));
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 178 */     if (a != null) {
/* 179 */       this.f = a(a, (i.a)null);
/*     */     }
/* 181 */     for (byte b = 0; b < i; b++) {
/*     */       f f1;
/* 183 */       if ((f1 = (f)list.get(b)) == null) {
/* 184 */         list.set(b, 
/* 185 */             b(arrayList.get(b), (i.a)null));
/*     */       }
/*     */     } 
/* 188 */     return (List)list;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<k> b(o paramo, j paramj, Class<?> paramClass) {
/* 194 */     ArrayList<Method> arrayList = null; Method[] arrayOfMethod;
/*     */     int i;
/*     */     byte b1;
/* 197 */     for (i = (arrayOfMethod = i.p(paramj.b())).length, b1 = 0; b1 < i; b1++) {
/* 198 */       Method method; if (a(method = arrayOfMethod[b1])) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 203 */         if (arrayList == null) {
/* 204 */           arrayList = new ArrayList();
/*     */         }
/* 206 */         arrayList.add(method);
/*     */       } 
/*     */     } 
/* 209 */     if (arrayList == null) {
/* 210 */       return Collections.emptyList();
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
/* 229 */     an an1 = this.d;
/*     */     
/* 231 */     i = arrayList.size();
/* 232 */     ArrayList<k> arrayList1 = new ArrayList(i); byte b2;
/* 233 */     for (b2 = 0; b2 < i; b2++) {
/* 234 */       arrayList1.add(null);
/*     */     }
/*     */     
/* 237 */     if (paramClass != null) {
/* 238 */       z[] arrayOfZ = null; Method[] arrayOfMethod1; int k; byte b;
/* 239 */       for (k = (arrayOfMethod1 = paramClass.getDeclaredMethods()).length, b = 0; b < k; b++) {
/* 240 */         Method method; if (a(method = arrayOfMethod1[b])) {
/*     */ 
/*     */           
/* 243 */           if (arrayOfZ == null) {
/* 244 */             arrayOfZ = new z[i];
/* 245 */             for (byte b4 = 0; b4 < i; b4++) {
/* 246 */               arrayOfZ[b4] = new z(arrayList.get(b4));
/*     */             }
/*     */           } 
/* 249 */           z z = new z(method);
/* 250 */           for (byte b3 = 0; b3 < i; b3++) {
/* 251 */             if (z.equals(arrayOfZ[b3])) {
/* 252 */               arrayList1.set(b3, 
/* 253 */                   a(arrayList.get(b3), an1, method));
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 261 */     for (b2 = 0; b2 < i; b2++) {
/*     */       k k;
/* 263 */       if ((k = arrayList1.get(b2)) == null) {
/*     */         Method method;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 269 */         an an2 = aa.a(method = arrayList.get(b2), paramj, paramo, an1);
/*     */         
/* 271 */         arrayList1.set(b2, 
/* 272 */             a(method, an2, (Method)null));
/*     */       } 
/*     */     } 
/* 275 */     return arrayList1;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(Method paramMethod) {
/* 280 */     if (Modifier.isStatic(paramMethod.getModifiers()) && 
/*     */ 
/*     */       
/* 283 */       !paramMethod.isSynthetic()) return true;
/*     */     
/*     */     return false;
/*     */   }
/*     */   
/*     */   private f a(i.a parama1, i.a parama2) {
/* 289 */     return new f(this.d, parama1.a(), 
/* 290 */         c(parama1, parama2), a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private f b(i.a parama1, i.a parama2) {
/*     */     aa[] arrayOfAa;
/* 298 */     int i = parama1.b();
/* 299 */     if (this.c == null) {
/* 300 */       return new f(this.d, parama1.a(), 
/* 301 */           a(), a(i));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 308 */     if (i == 0) {
/* 309 */       return new f(this.d, parama1.a(), 
/* 310 */           c(parama1, parama2), a);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 315 */     Annotation[][] arrayOfAnnotation = parama1.e();
/* 316 */     if (i != arrayOfAnnotation.length) {
/*     */ 
/*     */ 
/*     */       
/* 320 */       Annotation[][] arrayOfAnnotation1 = null;
/*     */       
/*     */       Class clazz;
/* 323 */       if (i.k(clazz = parama1.c()) && i == arrayOfAnnotation.length + 2) {
/*     */         
/* 325 */         arrayOfAnnotation = new Annotation[(arrayOfAnnotation1 = arrayOfAnnotation).length + 2][];
/* 326 */         System.arraycopy(arrayOfAnnotation1, 0, arrayOfAnnotation, 2, arrayOfAnnotation1.length);
/* 327 */         arrayOfAa = a(arrayOfAnnotation, (Annotation[][])null);
/* 328 */       } else if (clazz.isMemberClass()) {
/*     */         
/* 330 */         if (i == arrayOfAnnotation.length + 1) {
/*     */ 
/*     */           
/* 333 */           arrayOfAnnotation = new Annotation[(arrayOfAnnotation1 = arrayOfAnnotation).length + 1][];
/* 334 */           System.arraycopy(arrayOfAnnotation1, 0, arrayOfAnnotation, 1, arrayOfAnnotation1.length);
/* 335 */           arrayOfAnnotation[0] = b;
/* 336 */           arrayOfAa = a(arrayOfAnnotation, (Annotation[][])null);
/*     */         } 
/*     */       } 
/* 339 */       if (arrayOfAa == null) {
/* 340 */         throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", new Object[] { parama1
/*     */                 
/* 342 */                 .c().getName(), Integer.valueOf(i), Integer.valueOf(arrayOfAnnotation.length) }));
/*     */       }
/*     */     } else {
/* 345 */       arrayOfAa = a(arrayOfAnnotation, (parama2 == null) ? (Annotation[][])null : parama2
/* 346 */           .e());
/*     */     } 
/* 348 */     return new f(this.d, parama1.a(), 
/* 349 */         c(parama1, parama2), arrayOfAa);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private k a(Method paramMethod1, an paraman, Method paramMethod2) {
/* 355 */     int i = paramMethod1.getParameterCount();
/* 356 */     if (this.c == null) {
/* 357 */       return new k(paraman, paramMethod1, a(), 
/* 358 */           a(i));
/*     */     }
/* 360 */     if (i == 0) {
/* 361 */       return new k(paraman, paramMethod1, a(paramMethod1, paramMethod2), a);
/*     */     }
/*     */     
/* 364 */     return new k(paraman, paramMethod1, a(paramMethod1, paramMethod2), 
/* 365 */         a(paramMethod1.getParameterAnnotations(), (paramMethod2 == null) ? (Annotation[][])null : paramMethod2
/* 366 */           .getParameterAnnotations()));
/*     */   }
/*     */   
/*     */   private aa[] a(Annotation[][] paramArrayOfAnnotation1, Annotation[][] paramArrayOfAnnotation2) {
/* 370 */     if (this.e) {
/*     */       int i;
/* 372 */       aa[] arrayOfAa = new aa[i = paramArrayOfAnnotation1.length];
/* 373 */       for (byte b = 0; b < i; b++) {
/* 374 */         p p = a(p.b(), paramArrayOfAnnotation1[b]);
/*     */         
/* 376 */         if (paramArrayOfAnnotation2 != null) {
/* 377 */           p = a(p, paramArrayOfAnnotation2[b]);
/*     */         }
/* 379 */         arrayOfAa[b] = p.d();
/*     */       } 
/* 381 */       return arrayOfAa;
/*     */     } 
/* 383 */     return a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private aa c(i.a parama1, i.a parama2) {
/* 389 */     if (this.e) {
/* 390 */       p p = a(parama1.d());
/* 391 */       if (parama2 != null) {
/* 392 */         p = a(p, parama2.d());
/*     */       }
/* 394 */       return p.d();
/*     */     } 
/* 396 */     return a();
/*     */   }
/*     */   
/*     */   private final aa a(AnnotatedElement paramAnnotatedElement1, AnnotatedElement paramAnnotatedElement2) {
/* 400 */     p p = a(paramAnnotatedElement1.getDeclaredAnnotations());
/* 401 */     if (paramAnnotatedElement2 != null) {
/* 402 */       p = a(p, paramAnnotatedElement2.getDeclaredAnnotations());
/*     */     }
/* 404 */     return p.d();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean a(Constructor<?> paramConstructor) {
/* 409 */     return !paramConstructor.isSynthetic();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */