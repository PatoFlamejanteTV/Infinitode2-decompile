/*     */ package org.a.d.b;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.a.d.a.a;
/*     */ import org.a.d.a.b;
/*     */ import org.a.d.a.c;
/*     */ import org.a.d.a.d;
/*     */ import org.a.d.a.e;
/*     */ import org.a.d.a.f;
/*     */ import org.a.d.a.g;
/*     */ import org.a.d.a.h;
/*     */ import org.a.d.a.i;
/*     */ import org.a.d.a.j;
/*     */ import org.a.d.a.k;
/*     */ import org.a.d.a.l;
/*     */ import org.a.d.a.m;
/*     */ import org.a.d.a.n;
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
/*     */ public final class ao
/*     */ {
/*     */   private Map<ap, ae> a;
/*     */   private Map<String, ap> b;
/*     */   private final b c;
/*     */   private Map<String, m> d;
/*     */   
/*     */   public ao(b paramb) {
/*  71 */     this.c = paramb;
/*  72 */     a();
/*     */   }
/*     */   
/*  75 */   private static final Class<?>[] e = new Class[] { b.class, String.class, String.class, String.class, Object.class };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a() {
/*  81 */     this.a = new EnumMap<ap, ae>(ap.class);
/*  82 */     this.b = new HashMap<String, ap>(); ap[] arrayOfAp; int i; byte b1;
/*  83 */     for (i = (arrayOfAp = ap.values()).length, b1 = 0; b1 < i; b1++) {
/*     */       ap ap;
/*  85 */       if ((ap = arrayOfAp[b1]).a()) {
/*     */         Class<? extends d> clazz;
/*     */         
/*     */         al al;
/*     */         
/*  90 */         String str = (al = (clazz = ap.b().asSubclass(d.class)).<Annotation>getAnnotation(al.class)).a();
/*  91 */         ae ae = b(clazz);
/*  92 */         this.b.put(str, ap);
/*  93 */         this.a.put(ap, ae);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     this.d = new HashMap<String, m>();
/* 103 */     a((Class)i.class);
/* 104 */     a((Class)b.class);
/* 105 */     a((Class)d.class);
/* 106 */     a((Class)j.class);
/* 107 */     a((Class)a.class);
/* 108 */     a((Class)e.class);
/* 109 */     a((Class)k.class);
/* 110 */     a((Class)f.class);
/* 111 */     a((Class)h.class);
/* 112 */     a((Class)c.class);
/* 113 */     a((Class)g.class);
/* 114 */     a((Class)n.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final c a(String paramString1, String paramString2, String paramString3, Object paramObject, ap paramap) {
/* 177 */     Object[] arrayOfObject = { this.c, paramString1, paramString2, paramString3, paramObject };
/*     */ 
/*     */     
/* 180 */     Class<? extends c> clazz = paramap.b().asSubclass(c.class);
/*     */     
/*     */     try {
/*     */       Constructor<? extends c> constructor;
/* 184 */       return (constructor = clazz.getDeclaredConstructor(e)).newInstance(arrayOfObject);
/*     */     }
/* 186 */     catch (NoSuchMethodError noSuchMethodError) {
/*     */       
/* 188 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, noSuchMethodError);
/*     */     }
/* 190 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 192 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, illegalArgumentException);
/*     */     }
/* 194 */     catch (InstantiationException instantiationException) {
/*     */       
/* 196 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, instantiationException);
/*     */     }
/* 198 */     catch (IllegalAccessException illegalAccessException) {
/*     */       
/* 200 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, illegalAccessException);
/*     */     }
/* 202 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/* 204 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, invocationTargetException);
/*     */     }
/* 206 */     catch (SecurityException securityException) {
/*     */       
/* 208 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, securityException);
/*     */     }
/* 210 */     catch (NoSuchMethodException noSuchMethodException) {
/*     */       
/* 212 */       throw new IllegalArgumentException("Failed to instanciate " + clazz.getSimpleName() + " property with value " + paramObject, noSuchMethodException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final c a(Class<?> paramClass, String paramString1, String paramString2, String paramString3, Object paramObject) {
/*     */     ae ae;
/*     */     af af;
/* 221 */     ap ap = (af = (ae = b(paramClass)).a(paramString3)).a();
/* 222 */     return a(paramString1, paramString2, paramString3, paramObject, ap);
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
/*     */   private void a(Class<? extends l> paramClass) {
/*     */     al al;
/* 250 */     String str = (al = paramClass.<Annotation>getAnnotation(al.class)).a();
/* 251 */     this.d.put(str, new m(str, paramClass, b(paramClass)));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ae b(Class<?> paramClass) {
/* 358 */     ae ae = new ae();
/* 359 */     Field[] arrayOfField = paramClass.getFields();
/* 360 */     String str = null; int i; byte b1;
/* 361 */     for (i = (arrayOfField = arrayOfField).length, b1 = 0; b1 < i; b1++) {
/*     */       Field field;
/* 363 */       if ((field = arrayOfField[b1]).isAnnotationPresent((Class)af.class)) {
/*     */ 
/*     */         
/*     */         try {
/* 367 */           str = (String)field.get(str);
/*     */         }
/* 369 */         catch (Exception exception) {
/*     */           
/* 371 */           throw new IllegalArgumentException("couldn't read one type declaration, please check accessibility and declaration of fields annoted in " + paramClass
/*     */               
/* 373 */               .getName(), exception);
/*     */         } 
/* 375 */         af af = exception.<af>getAnnotation(af.class);
/* 376 */         ae.a(str, af);
/*     */       } 
/*     */     } 
/* 379 */     return ae;
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
/*     */   public final am a(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 404 */     return new am(this.c, paramString1, paramString2, paramString3, paramString4);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final f a(String paramString1, String paramString2, String paramString3, k paramk) {
/* 464 */     return new f(this.c, paramString1, paramString2, paramString3, paramk);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\d\b\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */