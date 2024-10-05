/*     */ package com.a.a.c.c.b;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.b.f;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.f;
/*     */ import com.a.a.c.m.i;
/*     */ import java.io.File;
/*     */ import java.net.InetAddress;
/*     */ import java.net.InetSocketAddress;
/*     */ import java.net.URI;
/*     */ import java.net.URL;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Currency;
/*     */ import java.util.IllformedLocaleException;
/*     */ import java.util.Locale;
/*     */ import java.util.TimeZone;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class q<T>
/*     */   extends ai<T>
/*     */ {
/*     */   public static Class<?>[] g() {
/*  61 */     return new Class[] { File.class, URL.class, URI.class, Class.class, j.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class, StringBuffer.class };
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
/*     */   protected q(Class<?> paramClass) {
/*  88 */     super(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static q<?> a(Class<?> paramClass) {
/*     */     byte b;
/*  98 */     if (paramClass == File.class)
/*  99 */     { b = 1; }
/* 100 */     else if (paramClass == URL.class)
/* 101 */     { b = 2; }
/* 102 */     else if (paramClass == URI.class)
/* 103 */     { b = 3; }
/* 104 */     else if (paramClass == Class.class)
/* 105 */     { b = 4; }
/* 106 */     else if (paramClass == j.class)
/* 107 */     { b = 5; }
/* 108 */     else if (paramClass == Currency.class)
/* 109 */     { b = 6; }
/* 110 */     else if (paramClass == Pattern.class)
/* 111 */     { b = 7; }
/* 112 */     else if (paramClass == Locale.class)
/* 113 */     { b = 8; }
/* 114 */     else if (paramClass == Charset.class)
/* 115 */     { b = 9; }
/* 116 */     else if (paramClass == TimeZone.class)
/* 117 */     { b = 10; }
/* 118 */     else if (paramClass == InetAddress.class)
/* 119 */     { b = 11; }
/* 120 */     else if (paramClass == InetSocketAddress.class)
/* 121 */     { b = 12; }
/* 122 */     else { if (paramClass == StringBuilder.class)
/* 123 */         return new c(); 
/* 124 */       if (paramClass == StringBuffer.class) {
/* 125 */         return new b();
/*     */       }
/* 127 */       return null; }
/*     */     
/* 129 */     return new a(paramClass, b);
/*     */   }
/*     */ 
/*     */   
/*     */   public f b() {
/* 134 */     return f.m;
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
/*     */   public T a(l paraml, g paramg) {
/*     */     String str1;
/* 149 */     if ((str1 = paraml.R()) == null) {
/*     */       o o;
/* 151 */       if ((o = paraml.k()) != o.b) {
/* 152 */         return (T)a(paraml, paramg, o);
/*     */       }
/*     */       
/* 155 */       str1 = paramg.a(paraml, this.s);
/*     */     } 
/* 157 */     if (str1.isEmpty())
/*     */     {
/* 159 */       return (T)k(paramg);
/*     */     }
/*     */     
/* 162 */     String str2 = str1;
/*     */     
/* 164 */     if (j() && (str1 = str1.trim()) != str2 && 
/* 165 */       str1.isEmpty()) {
/* 166 */       return (T)k(paramg);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 175 */       return a(str1, paramg);
/* 176 */     } catch (IllegalArgumentException|java.net.MalformedURLException illegalArgumentException) {
/* 177 */       l l1 = paraml = null;
/*     */ 
/*     */       
/* 180 */       String str3 = "not a valid textual representation";
/*     */       String str4;
/* 182 */       if ((str4 = l1.getMessage()) != null) {
/* 183 */         str3 = str3 + ", problem: " + str4;
/*     */       }
/*     */       
/* 186 */       throw paramg.a(str1, this.s, str3)
/* 187 */         .a(l1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract T a(String paramString, g paramg);
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean j() {
/* 198 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(l paraml, g paramg, o paramo) {
/*     */     Object object;
/* 206 */     if (paramo == o.d) {
/* 207 */       return d(paraml, paramg);
/*     */     }
/* 209 */     if (paramo == o.g) {
/*     */ 
/*     */       
/* 212 */       if ((object = paraml.N()) == null) {
/* 213 */         return null;
/*     */       }
/* 215 */       if (this.s.isAssignableFrom(object.getClass())) {
/* 216 */         return object;
/*     */       }
/* 218 */       return a(object, paramg);
/*     */     } 
/* 220 */     return paramg.a(this.s, (l)object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected T a(Object paramObject, g paramg) {
/* 230 */     paramg.a(this, "Don't know how to convert embedded Object of type %s into %s", new Object[] { paramObject
/*     */           
/* 232 */           .getClass().getName(), this.s.getName() });
/* 233 */     return null;
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
/*     */   private Object k(g paramg) {
/*     */     com.a.a.c.b.b b;
/* 247 */     if ((b = paramg.a(b(), this.s, f.f)) == com.a.a.c.b.b.a)
/* 248 */       paramg.a(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", new Object[] {
/*     */             
/* 250 */             k()
/*     */           }); 
/* 252 */     if (b == com.a.a.c.b.b.c) {
/* 253 */       return a(paramg);
/*     */     }
/* 255 */     if (b == com.a.a.c.b.b.d) {
/* 256 */       return c(paramg);
/*     */     }
/*     */ 
/*     */     
/* 260 */     return d(paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object d(g paramg) {
/* 268 */     return a(paramg);
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
/*     */   public static class a
/*     */     extends q<Object>
/*     */   {
/*     */     private int a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected a(Class<?> param1Class, int param1Int) {
/* 307 */       super(param1Class);
/* 308 */       this.a = param1Int;
/*     */     }
/*     */ 
/*     */     
/*     */     protected final Object a(String param1String, g param1g) {
/*     */       int i;
/* 314 */       switch (this.a) {
/*     */         case 1:
/* 316 */           return new File(param1String);
/*     */         case 2:
/* 318 */           return new URL(param1String);
/*     */         case 3:
/* 320 */           return URI.create(param1String);
/*     */         case 4:
/*     */           try {
/* 323 */             return param1g.b(param1String);
/* 324 */           } catch (Exception exception) {
/* 325 */             return param1g.a(this.s, param1String, 
/* 326 */                 i.d(exception));
/*     */           } 
/*     */         case 5:
/* 329 */           return param1g.b().b(param1String);
/*     */         
/*     */         case 6:
/* 332 */           return Currency.getInstance(param1String);
/*     */         
/*     */         case 7:
/* 335 */           return Pattern.compile(param1String);
/*     */         case 8:
/* 337 */           return k(param1String);
/*     */         case 9:
/* 339 */           return Charset.forName(param1String);
/*     */         case 10:
/* 341 */           return TimeZone.getTimeZone(param1String);
/*     */         case 11:
/* 343 */           return InetAddress.getByName(param1String);
/*     */         case 12:
/* 345 */           if (param1String.startsWith("[")) {
/*     */             int k;
/*     */ 
/*     */             
/* 349 */             if ((k = param1String.lastIndexOf(']')) == -1) {
/* 350 */               throw new com.a.a.c.d.c(param1g.j(), "Bracketed IPv6 address must contain closing bracket", param1String, InetSocketAddress.class);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 356 */             int j = ((j = param1String.indexOf(':', k)) >= 0) ? Integer.parseInt(param1String.substring(j + 1)) : 0;
/* 357 */             return new InetSocketAddress(param1String.substring(0, k + 1), j);
/*     */           } 
/*     */           
/* 360 */           if ((i = param1String.indexOf(':')) >= 0 && param1String.indexOf(':', i + 1) < 0) {
/*     */             
/* 362 */             int j = Integer.parseInt(param1String.substring(i + 1));
/* 363 */             return new InetSocketAddress(param1String.substring(0, i), j);
/*     */           } 
/*     */           
/* 366 */           return new InetSocketAddress(param1String, 0);
/*     */       } 
/* 368 */       com.a.a.b.g.q.a();
/* 369 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object c(g param1g) {
/* 376 */       switch (this.a) {
/*     */         
/*     */         case 3:
/* 379 */           return URI.create("");
/*     */         
/*     */         case 8:
/* 382 */           return Locale.ROOT;
/*     */       } 
/* 384 */       return super.c(param1g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final Object d(g param1g) {
/* 392 */       return c(param1g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final boolean j() {
/* 399 */       return (this.a != 7);
/*     */     }
/*     */     private static int j(String param1String) {
/*     */       byte b;
/*     */       int i;
/* 404 */       for (b = 0, i = param1String.length(); b < i; b++) {
/*     */         char c;
/* 406 */         if ((c = param1String.charAt(b)) == '_' || c == '-') {
/* 407 */           return b;
/*     */         }
/*     */       } 
/* 410 */       return -1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private Locale k(String param1String) {
/*     */       int i;
/* 417 */       if ((i = j(param1String)) < 0) {
/* 418 */         return new Locale(param1String);
/*     */       }
/* 420 */       String str1 = param1String.substring(0, i);
/*     */ 
/*     */       
/* 423 */       if ((i = j(param1String = param1String.substring(i + 1))) < 0) {
/* 424 */         return new Locale(str1, param1String);
/*     */       }
/* 426 */       String str2 = param1String.substring(0, i);
/*     */       
/*     */       int j;
/* 429 */       if ((j = param1String.indexOf("_#")) < 0) {
/* 430 */         return new Locale(str1, str2, param1String.substring(i + 1));
/*     */       }
/* 432 */       return a(param1String, i, str1, str2, j);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static Locale a(String param1String1, int param1Int1, String param1String2, String param1String3, int param1Int2) {
/* 438 */       String str = "";
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 443 */         if (param1Int2 > 0 && param1Int2 > param1Int1) {
/* 444 */           str = param1String1.substring(param1Int1 + 1, param1Int2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 449 */         if ((param1Int1 = (param1String1 = param1String1.substring(param1Int2 + 2)).indexOf('_')) < 0) {
/*     */           
/* 451 */           if ((param1Int2 = param1String1.indexOf('-')) < 0) {
/* 452 */             return (new Locale.Builder()).setLanguage(param1String2)
/* 453 */               .setRegion(param1String3)
/* 454 */               .setVariant(str)
/* 455 */               .setScript(param1String1)
/* 456 */               .build();
/*     */           }
/* 458 */           return (new Locale.Builder()).setLanguage(param1String2)
/* 459 */             .setRegion(param1String3).setVariant(str)
/* 460 */             .setExtension(param1String1.charAt(0), param1String1.substring(param1Int2 + 1))
/* 461 */             .build();
/*     */         } 
/* 463 */         param1Int2 = param1String1.length();
/*     */ 
/*     */ 
/*     */         
/* 467 */         Locale.Builder builder = (new Locale.Builder()).setLanguage(param1String2).setRegion(param1String3).setVariant(str).setScript(param1String1.substring(0, param1Int1));
/* 468 */         if (param1Int1 + 1 < param1Int2) {
/* 469 */           builder = builder.setExtension(param1String1.charAt(param1Int1 + 1), param1String1
/* 470 */               .substring(Math.min(param1Int2, param1Int1 + 3)));
/*     */         }
/* 472 */         return builder.build();
/* 473 */       } catch (IllformedLocaleException illformedLocaleException) {
/*     */         
/* 475 */         return new Locale(param1String2, param1String3, str);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   static class c
/*     */     extends q<Object>
/*     */   {
/*     */     public c() {
/* 484 */       super(StringBuilder.class);
/*     */     }
/*     */ 
/*     */     
/*     */     public final f b() {
/* 489 */       return f.j;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object c(g param1g) {
/* 496 */       return new StringBuilder();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object a(l param1l, g param1g) {
/*     */       String str;
/* 503 */       if ((str = param1l.R()) != null) {
/* 504 */         return a(str, param1g);
/*     */       }
/* 506 */       return super.a(param1l, param1g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final Object a(String param1String, g param1g) {
/* 513 */       return new StringBuilder(param1String);
/*     */     }
/*     */   }
/*     */   
/*     */   static class b
/*     */     extends q<Object> {
/*     */     public b() {
/* 520 */       super(StringBuffer.class);
/*     */     }
/*     */     public final f b() {
/* 523 */       return f.j;
/*     */     }
/*     */     
/*     */     public final Object c(g param1g) {
/* 527 */       return new StringBuffer();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object a(l param1l, g param1g) {
/*     */       String str;
/* 534 */       if ((str = param1l.R()) != null) {
/* 535 */         return a(str, param1g);
/*     */       }
/* 537 */       return super.a(param1l, param1g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final Object a(String param1String, g param1g) {
/* 544 */       return new StringBuffer(param1String);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\b\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */