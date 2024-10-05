/*     */ package com.a.a.c;
/*     */ 
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.a.an;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.f.ad;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.i.c;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.l.o;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.k;
/*     */ import java.lang.reflect.Type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*     */   public abstract q<?> a();
/*     */   
/*     */   public final j a(Type paramType) {
/* 156 */     if (paramType == null) {
/* 157 */       return null;
/*     */     }
/* 159 */     return b().a(paramType);
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
/*     */   public final j a(j paramj, String paramString, c paramc) {
/*     */     int i;
/* 225 */     if ((i = paramString.indexOf('<')) > 0) {
/* 226 */       return a(paramj, paramString, paramc, i);
/*     */     }
/* 228 */     q<?> q = a();
/*     */     c.b b;
/* 230 */     if ((b = paramc.a()) == c.b.b) {
/* 231 */       return b(paramj, paramString, paramc);
/*     */     }
/*     */     
/*     */     try {
/* 235 */       Class clazz = b().a(paramString);
/* 236 */     } catch (ClassNotFoundException classNotFoundException) {
/* 237 */       return null;
/* 238 */     } catch (Exception exception) {
/* 239 */       throw a(paramj, paramString, String.format("problem: (%s) %s", new Object[] { exception
/*     */               
/* 241 */               .getClass().getName(), 
/* 242 */               i.g(exception) }));
/*     */     } 
/* 244 */     if (!paramj.c((Class<?>)exception)) {
/* 245 */       return b(paramj, paramString);
/*     */     }
/* 247 */     j j1 = q.p().a(paramj, (Class)exception);
/*     */     
/* 249 */     if (b == c.b.c && (
/*     */       
/* 251 */       b = paramc.a(q, paramj, j1)) != c.b.a) {
/* 252 */       return c(paramj, paramString, paramc);
/*     */     }
/*     */     
/* 255 */     return j1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j a(j paramj, String paramString, c paramc, int paramInt) {
/* 262 */     q<?> q = a();
/*     */ 
/*     */ 
/*     */     
/* 266 */     paramString.substring(0, paramInt); c.b b;
/* 267 */     if ((b = paramc.a()) == c.b.b) {
/* 268 */       return b(paramj, paramString, paramc);
/*     */     }
/*     */     j j1;
/* 271 */     if (!(j1 = b().b(paramString)).b(paramj.b())) {
/* 272 */       return b(paramj, paramString);
/*     */     }
/*     */     
/* 275 */     if (b != c.b.a && 
/* 276 */       paramc.a(q, paramj, j1) != c.b.a) {
/* 277 */       return c(paramj, paramString, paramc);
/*     */     }
/*     */     
/* 280 */     return j1;
/*     */   }
/*     */   
/*     */   private <T> T b(j paramj, String paramString) {
/* 284 */     throw a(paramj, paramString, "Not a subtype");
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> T b(j paramj, String paramString, c paramc) {
/* 289 */     throw a(paramj, paramString, "Configured `PolymorphicTypeValidator` (of type " + 
/* 290 */         i.d(paramc) + ") denied resolution");
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> T c(j paramj, String paramString, c paramc) {
/* 295 */     throw a(paramj, paramString, "Configured `PolymorphicTypeValidator` (of type " + 
/* 296 */         i.d(paramc) + ") denied resolution");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract l a(j paramj, String paramString1, String paramString2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract o b();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final al<?> a(b paramb, ad paramad) {
/* 325 */     Class clazz = paramad.d();
/*     */     q<?> q;
/*     */     d d1;
/*     */     al al;
/* 329 */     if ((al = (al)(((d1 = (q = a()).m()) == null) ? null : d.j())) == null) {
/* 330 */       al = (al)i.b(clazz, q
/* 331 */           .g());
/*     */     }
/* 333 */     return al.a(paramad.c());
/*     */   }
/*     */ 
/*     */   
/*     */   public final an b(b paramb, ad paramad) {
/* 338 */     Class clazz = paramad.e();
/*     */     q<?> q;
/*     */     an an;
/*     */     d d1;
/* 342 */     if ((an = (an)(((d1 = (q = a()).m()) == null) ? null : d.k())) == null) {
/* 343 */       an = (an)i.b(clazz, q.g());
/*     */     }
/*     */     
/* 346 */     return an;
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
/*     */   public final k<Object, Object> a(b paramb, Object<?> paramObject) {
/* 360 */     if (paramObject == null) {
/* 361 */       return null;
/*     */     }
/* 363 */     if (paramObject instanceof k) {
/* 364 */       return (k<Object, Object>)paramObject;
/*     */     }
/* 366 */     if (!(paramObject instanceof Class)) {
/* 367 */       throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + paramObject
/* 368 */           .getClass().getName() + "; expected type Converter or Class<Converter> instead");
/*     */     }
/*     */     
/*     */     Class<k.a> clazz;
/* 372 */     if ((clazz = (Class<k.a>)paramObject) == k.a.class || i.e(clazz)) {
/* 373 */       return null;
/*     */     }
/* 375 */     if (!k.class.isAssignableFrom(clazz)) {
/* 376 */       throw new IllegalStateException("AnnotationIntrospector returned Class " + clazz
/* 377 */           .getName() + "; expected Class<Converter>");
/*     */     }
/*     */     
/*     */     d d1;
/*     */     k<Object, Object> k;
/* 382 */     if ((k = (k<Object, Object>)(((d1 = (paramObject = (Object<?>)a()).m()) == null) ? null : d.m())) == null) {
/* 383 */       k = (k)i.b(clazz, paramObject
/* 384 */           .g());
/*     */     }
/* 386 */     return k;
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
/*     */   public abstract <T> T a(j paramj, String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final <T> T a(Class<?> paramClass, String paramString) {
/* 408 */     return a(a(paramClass), paramString);
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
/*     */   protected static String a(String paramString, Object... paramVarArgs) {
/* 421 */     if (paramVarArgs.length > 0) {
/* 422 */       return String.format(paramString, paramVarArgs);
/*     */     }
/* 424 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String b(String paramString) {
/* 431 */     if (paramString == null) {
/* 432 */       return "";
/*     */     }
/* 434 */     if (paramString.length() <= 500) {
/* 435 */       return paramString;
/*     */     }
/* 437 */     return paramString.substring(0, 500) + "]...[" + paramString.substring(paramString.length() - 500);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String a(String paramString) {
/* 444 */     if (paramString == null) {
/* 445 */       return "[N/A]";
/*     */     }
/*     */     
/* 448 */     return String.format("\"%s\"", new Object[] { b(paramString) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String a(String paramString1, String paramString2) {
/* 455 */     if (paramString2 == null) {
/* 456 */       return paramString1;
/*     */     }
/* 458 */     return paramString1 + ": " + paramString2;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */