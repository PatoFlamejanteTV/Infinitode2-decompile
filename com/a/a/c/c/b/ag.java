/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.c.h;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.ac;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.l;
/*     */ import com.a.a.c.p;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.util.Calendar;
/*     */ import java.util.Currency;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.UUID;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public class ag
/*     */   extends p
/*     */   implements Serializable
/*     */ {
/*     */   private int b;
/*     */   protected final Class<?> a;
/*     */   private q<?> c;
/*     */   
/*     */   protected ag(int paramInt, Class<?> paramClass) {
/*  62 */     this(paramInt, paramClass, null);
/*     */   }
/*     */   
/*     */   private ag(int paramInt, Class<?> paramClass, q<?> paramq) {
/*  66 */     this.b = paramInt;
/*  67 */     this.a = paramClass;
/*  68 */     this.c = paramq;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ag a(Class<?> paramClass) {
/*     */     byte b;
/*  76 */     if (paramClass == String.class || paramClass == Object.class || paramClass == CharSequence.class || paramClass == Serializable.class)
/*     */     {
/*     */ 
/*     */       
/*  80 */       return e.b(paramClass);
/*     */     }
/*  82 */     if (paramClass == UUID.class)
/*  83 */     { b = 12; }
/*  84 */     else if (paramClass == Integer.class)
/*  85 */     { b = 5; }
/*  86 */     else if (paramClass == Long.class)
/*  87 */     { b = 6; }
/*  88 */     else if (paramClass == Date.class)
/*  89 */     { b = 10; }
/*  90 */     else if (paramClass == Calendar.class)
/*  91 */     { b = 11; }
/*     */     
/*  93 */     else if (paramClass == Boolean.class)
/*  94 */     { b = 1; }
/*  95 */     else if (paramClass == Byte.class)
/*  96 */     { b = 2; }
/*  97 */     else if (paramClass == Character.class)
/*  98 */     { b = 4; }
/*  99 */     else if (paramClass == Short.class)
/* 100 */     { b = 3; }
/* 101 */     else if (paramClass == Float.class)
/* 102 */     { b = 7; }
/* 103 */     else if (paramClass == Double.class)
/* 104 */     { b = 8; }
/* 105 */     else if (paramClass == URI.class)
/* 106 */     { b = 13; }
/* 107 */     else if (paramClass == URL.class)
/* 108 */     { b = 14; }
/* 109 */     else if (paramClass == Class.class)
/* 110 */     { b = 15; }
/* 111 */     else { if (paramClass == Locale.class) {
/* 112 */         q<?> q1 = q.a(Locale.class);
/* 113 */         return new ag(9, paramClass, q1);
/* 114 */       }  if (paramClass == Currency.class) {
/* 115 */         q<?> q1 = q.a(Currency.class);
/* 116 */         return new ag(16, paramClass, q1);
/* 117 */       }  if (paramClass == byte[].class) {
/* 118 */         b = 17;
/*     */       } else {
/* 120 */         return null;
/*     */       }  }
/* 122 */      return new ag(b, paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object a(String paramString, g paramg) {
/* 129 */     if (paramString == null) {
/* 130 */       return null;
/*     */     }
/*     */     try {
/*     */       Object object;
/* 134 */       if ((object = b(paramString, paramg)) != null) {
/* 135 */         return object;
/*     */       }
/* 137 */     } catch (Exception exception) {
/* 138 */       return paramg.a(this.a, paramString, "not a valid representation, problem: (%s) %s", new Object[] { exception
/* 139 */             .getClass().getName(), 
/* 140 */             i.g(exception) });
/*     */     } 
/* 142 */     if (i.k(this.a) && paramg
/* 143 */       .c().a(i.w)) {
/* 144 */       return null;
/*     */     }
/* 146 */     return paramg.a(this.a, paramString, "not a valid representation", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object b(String paramString, g paramg) {
/*     */     int i;
/* 153 */     switch (this.b) {
/*     */       case 1:
/* 155 */         if ("true".equals(paramString)) {
/* 156 */           return Boolean.TRUE;
/*     */         }
/* 158 */         if ("false".equals(paramString)) {
/* 159 */           return Boolean.FALSE;
/*     */         }
/* 161 */         return paramg.a(this.a, paramString, "value not 'true' or 'false'", new Object[0]);
/*     */ 
/*     */ 
/*     */       
/*     */       case 2:
/* 166 */         if ((i = a(paramString)) < -128 || i > 255) {
/* 167 */           return paramg.a(this.a, paramString, "overflow, value cannot be represented as 8-bit value", new Object[0]);
/*     */         }
/* 169 */         return Byte.valueOf((byte)i);
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 174 */         if ((i = a(paramString)) < -32768 || i > 32767) {
/* 175 */           return paramg.a(this.a, paramString, "overflow, value cannot be represented as 16-bit value", new Object[0]);
/*     */         }
/*     */         
/* 178 */         return Short.valueOf((short)i);
/*     */       
/*     */       case 4:
/* 181 */         if (paramString.length() == 1) {
/* 182 */           return Character.valueOf(paramString.charAt(0));
/*     */         }
/* 184 */         return paramg.a(this.a, paramString, "can only convert 1-character Strings", new Object[0]);
/*     */       case 5:
/* 186 */         return Integer.valueOf(a(paramString));
/*     */       
/*     */       case 6:
/* 189 */         return Long.valueOf(b(paramString));
/*     */ 
/*     */       
/*     */       case 7:
/* 193 */         return Float.valueOf((float)c(paramString));
/*     */       case 8:
/* 195 */         return Double.valueOf(c(paramString));
/*     */       case 9:
/*     */         try {
/* 198 */           return this.c.a(paramString, paramg);
/* 199 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 200 */           return a(paramg, paramString, illegalArgumentException);
/*     */         } 
/*     */       case 16:
/*     */         try {
/* 204 */           return this.c.a(paramString, paramg);
/* 205 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 206 */           return a(paramg, paramString, illegalArgumentException);
/*     */         } 
/*     */       case 10:
/* 209 */         return paramg.c(paramString);
/*     */       case 11:
/* 211 */         return paramg.a(paramg.c(paramString));
/*     */       case 12:
/*     */         try {
/* 214 */           return UUID.fromString(paramString);
/* 215 */         } catch (Exception exception) {
/* 216 */           return a(paramg, paramString, exception);
/*     */         } 
/*     */       case 13:
/*     */         try {
/* 220 */           return URI.create(paramString);
/* 221 */         } catch (Exception exception) {
/* 222 */           return a(paramg, paramString, exception);
/*     */         } 
/*     */       case 14:
/*     */         try {
/* 226 */           return new URL(paramString);
/* 227 */         } catch (MalformedURLException malformedURLException) {
/* 228 */           return a(paramg, paramString, malformedURLException);
/*     */         } 
/*     */       case 15:
/*     */         try {
/* 232 */           return paramg.b(paramString);
/* 233 */         } catch (Exception exception) {
/* 234 */           return paramg.a(this.a, paramString, "unable to parse key as Class", new Object[0]);
/*     */         } 
/*     */       case 17:
/*     */         try {
/* 238 */           return paramg.c().v().a(paramString);
/* 239 */         } catch (IllegalArgumentException illegalArgumentException) {
/* 240 */           return a(paramg, paramString, illegalArgumentException);
/*     */         } 
/*     */     } 
/* 243 */     throw new IllegalStateException("Internal error: unknown key type " + this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int a(String paramString) {
/* 254 */     return h.a(paramString);
/*     */   }
/*     */   
/*     */   private static long b(String paramString) {
/* 258 */     return h.b(paramString);
/*     */   }
/*     */   
/*     */   private static double c(String paramString) {
/* 262 */     return h.c(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private Object a(g paramg, String paramString, Exception paramException) {
/* 267 */     return paramg.a(this.a, paramString, "problem: %s", new Object[] {
/* 268 */           i.g(paramException)
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   static final class e
/*     */     extends ag
/*     */   {
/* 281 */     private static final e b = new e(String.class);
/* 282 */     private static final e c = new e(Object.class);
/*     */     private e(Class<?> param1Class) {
/* 284 */       super(-1, param1Class);
/*     */     }
/*     */     
/*     */     public static e b(Class<?> param1Class) {
/* 288 */       if (param1Class == String.class) {
/* 289 */         return b;
/*     */       }
/* 291 */       if (param1Class == Object.class) {
/* 292 */         return c;
/*     */       }
/* 294 */       return new e(param1Class);
/*     */     }
/*     */ 
/*     */     
/*     */     public final Object a(String param1String, g param1g) {
/* 299 */       return param1String;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class a
/*     */     extends p
/*     */     implements Serializable
/*     */   {
/*     */     private Class<?> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private k<?> b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected a(Class<?> param1Class, k<?> param1k) {
/* 325 */       this.a = param1Class;
/* 326 */       this.b = param1k;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object a(String param1String, g param1g) {
/* 334 */       if (param1String == null) {
/* 335 */         return null;
/*     */       }
/*     */       ac ac;
/* 338 */       (ac = param1g.m()).b(param1String);
/*     */       
/*     */       try {
/*     */         l l;
/* 342 */         (l = ac.o()).g();
/*     */         Object object;
/* 344 */         if ((object = this.b.a(l, param1g)) != null) {
/* 345 */           return object;
/*     */         }
/* 347 */         return param1g.a(this.a, param1String, "not a valid representation", new Object[0]);
/* 348 */       } catch (Exception exception) {
/* 349 */         return param1g.a(this.a, param1String, "not a valid representation: %s", new Object[] { exception.getMessage() });
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   static final class b
/*     */     extends ag
/*     */   {
/*     */     private l b;
/*     */ 
/*     */ 
/*     */     
/*     */     private k c;
/*     */ 
/*     */     
/*     */     private l d;
/*     */ 
/*     */     
/*     */     private Enum<?> e;
/*     */ 
/*     */ 
/*     */     
/*     */     protected b(l param1l, k param1k) {
/* 376 */       super(-1, param1l.e());
/* 377 */       this.b = param1l;
/* 378 */       this.c = param1k;
/* 379 */       this.e = param1l.b();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object b(String param1String, g param1g) {
/* 385 */       if (this.c != null) {
/*     */         try {
/* 387 */           return this.c.a(param1String);
/* 388 */         } catch (Exception exception2) {
/* 389 */           Exception exception1; i.f(exception1 = null);
/*     */         } 
/*     */       }
/*     */       
/*     */       l l1;
/*     */       Enum<?> enum_;
/* 395 */       if ((enum_ = (l1 = param1g.a(i.v) ? a(param1g) : this.b).a(param1String)) == null) {
/* 396 */         if (this.e != null && param1g
/* 397 */           .a(i.x)) {
/* 398 */           enum_ = this.e;
/* 399 */         } else if (!param1g.a(i.w)) {
/* 400 */           return param1g.a(this.a, param1String, "not one of the values accepted for Enum class: %s", new Object[] { l1
/* 401 */                 .d() });
/*     */         } 
/*     */       }
/*     */       
/* 405 */       return enum_;
/*     */     }
/*     */ 
/*     */     
/*     */     private l a(g param1g) {
/*     */       l l1;
/* 411 */       if ((l1 = this.d) == null) {
/* 412 */         synchronized (this) {
/* 413 */           l1 = l.b(param1g.c(), this.b
/* 414 */               .e());
/* 415 */           this.d = l1;
/*     */         } 
/*     */       }
/* 418 */       return l1;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class c
/*     */     extends ag
/*     */   {
/*     */     private Constructor<?> b;
/*     */ 
/*     */ 
/*     */     
/*     */     public c(Constructor<?> param1Constructor) {
/* 433 */       super(-1, param1Constructor.getDeclaringClass());
/* 434 */       this.b = param1Constructor;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object b(String param1String, g param1g) {
/* 440 */       return this.b.newInstance(new Object[] { param1String });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class d
/*     */     extends ag
/*     */   {
/*     */     private Method b;
/*     */ 
/*     */ 
/*     */     
/*     */     public d(Method param1Method) {
/* 455 */       super(-1, param1Method.getDeclaringClass());
/* 456 */       this.b = param1Method;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object b(String param1String, g param1g) {
/* 462 */       return this.b.invoke(null, new Object[] { param1String });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\ag.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */