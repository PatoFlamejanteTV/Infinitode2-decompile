/*     */ package com.d.c.c;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.regex.Matcher;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class b
/*     */ {
/*     */   static b a(String paramString1, String paramString2) {
/*  48 */     return new c(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b a(String paramString1, String paramString2, String paramString3) {
/*  55 */     return new f(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b b(String paramString1, String paramString2, String paramString3) {
/*  62 */     return new h(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b c(String paramString1, String paramString2, String paramString3) {
/*  69 */     return new g(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b d(String paramString1, String paramString2, String paramString3) {
/*  76 */     return new b(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b e(String paramString1, String paramString2, String paramString3) {
/*  87 */     return new e(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b f(String paramString1, String paramString2, String paramString3) {
/*  98 */     return new d(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b a(String paramString) {
/* 108 */     return new i(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b b(String paramString) {
/* 118 */     return new l(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b c(String paramString) {
/* 128 */     return new m(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b a() {
/* 137 */     return new k();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b b() {
/* 146 */     return new n();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b d(String paramString) {
/* 156 */     return p.e(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b c() {
/* 165 */     return new j();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b d() {
/* 174 */     return new q();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b e() {
/* 183 */     return new o();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static b f() {
/* 192 */     return new r();
/*     */   }
/*     */   
/*     */   static abstract class a extends b {
/*     */     protected String a;
/*     */     protected String b;
/*     */     private String c;
/*     */     
/*     */     protected abstract boolean b(String param1String1, String param1String2);
/*     */     
/*     */     a(String param1String1, String param1String2, String param1String3) {
/* 203 */       this.a = param1String1;
/* 204 */       this.b = param1String2;
/* 205 */       this.c = param1String3;
/*     */     }
/*     */     
/*     */     boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 209 */       if (param1a == null) {
/* 210 */         return false;
/*     */       }
/*     */       
/* 213 */       if ((param1Object = param1a.a(param1Object, this.a, this.b)) == null) {
/* 214 */         return false;
/*     */       }
/*     */       
/* 217 */       return b((String)param1Object, this.c);
/*     */     }
/*     */   }
/*     */   
/*     */   static class c extends a {
/*     */     c(String param1String1, String param1String2) {
/* 223 */       super(param1String1, param1String2, null);
/*     */     }
/*     */ 
/*     */     
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 228 */       if (param1a == null) {
/* 229 */         return false;
/*     */       }
/*     */       
/* 232 */       if ((param1Object = param1a.a(param1Object, this.a, this.b)) == null) {
/* 233 */         return false;
/*     */       }
/*     */       
/* 236 */       return true;
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 240 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   static class b extends a {
/*     */     b(String param1String1, String param1String2, String param1String3) {
/* 246 */       super(param1String1, param1String2, param1String3);
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 250 */       return param1String1.equals(param1String2);
/*     */     }
/*     */   }
/*     */   
/*     */   static class f extends a {
/*     */     f(String param1String1, String param1String2, String param1String3) {
/* 256 */       super(param1String1, param1String2, param1String3);
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 260 */       return param1String1.startsWith(param1String2);
/*     */     }
/*     */   }
/*     */   
/*     */   static class h extends a {
/*     */     h(String param1String1, String param1String2, String param1String3) {
/* 266 */       super(param1String1, param1String2, param1String3);
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 270 */       return param1String1.endsWith(param1String2);
/*     */     }
/*     */   }
/*     */   
/*     */   static class g extends a {
/*     */     g(String param1String1, String param1String2, String param1String3) {
/* 276 */       super(param1String1, param1String2, param1String3);
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 280 */       return (param1String1.indexOf(param1String2) >= 0);
/*     */     }
/*     */   }
/*     */   
/*     */   static class e extends a {
/*     */     e(String param1String1, String param1String2, String param1String3) {
/* 286 */       super(param1String1, param1String2, param1String3);
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 290 */       String[] arrayOfString = b.a(param1String1, ' ');
/* 291 */       boolean bool = false;
/* 292 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 293 */         if (param1String2.equals(arrayOfString[b])) {
/* 294 */           bool = true;
/*     */         }
/*     */       } 
/* 297 */       return bool;
/*     */     }
/*     */   }
/*     */   
/*     */   static class d extends a {
/*     */     d(String param1String1, String param1String2, String param1String3) {
/* 303 */       super(param1String1, param1String2, param1String3);
/*     */     }
/*     */     
/*     */     protected final boolean b(String param1String1, String param1String2) {
/* 307 */       String[] arrayOfString = b.a(param1String1, '-');
/* 308 */       if (param1String2.equals(arrayOfString[0])) {
/* 309 */         return true;
/*     */       }
/* 311 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   static class i
/*     */     extends b {
/*     */     private String a;
/*     */     
/*     */     i(String param1String) {
/* 320 */       this.a = " " + param1String + " ";
/*     */     }
/*     */     
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 324 */       if (param1a == null) {
/* 325 */         return false;
/*     */       }
/*     */       
/* 328 */       if ((param1Object = param1a.a(param1Object)) == null) {
/* 329 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 335 */       return ((" " + param1Object + " ").indexOf(this.a) != -1);
/*     */     }
/*     */   }
/*     */   
/*     */   static class l
/*     */     extends b {
/*     */     private String a;
/*     */     
/*     */     l(String param1String) {
/* 344 */       this.a = param1String;
/*     */     }
/*     */     
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 348 */       if (param1a == null) {
/* 349 */         return false;
/*     */       }
/* 351 */       if (!this.a.equals(param1a.b(param1Object))) {
/* 352 */         return false;
/*     */       }
/* 354 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   static class m extends b {
/*     */     private String a;
/*     */     
/*     */     m(String param1String) {
/* 362 */       this.a = param1String;
/*     */     }
/*     */     
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 366 */       if (param1a == null) {
/* 367 */         return false;
/*     */       }
/*     */       
/* 370 */       if ((param1Object = param1a.e(param1Object)) == null) {
/* 371 */         return false;
/*     */       }
/* 373 */       if (this.a.equalsIgnoreCase((String)param1Object)) {
/* 374 */         return true;
/*     */       }
/* 376 */       param1Object = b.a((String)param1Object, '-');
/* 377 */       if (this.a.equalsIgnoreCase((String)param1Object[0])) {
/* 378 */         return true;
/*     */       }
/* 380 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class k
/*     */     extends b
/*     */   {
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 390 */       return param1d.c(param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class n
/*     */     extends b
/*     */   {
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 400 */       return param1d.d(param1Object);
/*     */     }
/*     */   }
/*     */   
/*     */   static class p
/*     */     extends b {
/* 406 */     private static final Pattern a = Pattern.compile("([-+]?)(\\d*)n(\\s*([-+])\\s*(\\d+))?");
/*     */     
/*     */     private final int b;
/*     */     private final int c;
/*     */     
/*     */     private p(int param1Int1, int param1Int2) {
/* 412 */       this.b = param1Int1;
/* 413 */       this.c = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 420 */       int i = (i = param1d.e(param1Object) + 1) - this.c;
/*     */       
/* 422 */       if (this.b == 0)
/* 423 */         return (i == 0); 
/* 424 */       if (this.b < 0 && i > 0) {
/* 425 */         return false;
/*     */       }
/* 427 */       return (i % this.b == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     static p e(String param1String) {
/* 432 */       param1String = param1String.trim().toLowerCase();
/*     */       
/* 434 */       if ("even".equals(param1String))
/* 435 */         return new p(2, 0); 
/* 436 */       if ("odd".equals(param1String)) {
/* 437 */         return new p(2, 1);
/*     */       }
/*     */       try {
/* 440 */         return new p(0, Integer.parseInt(param1String));
/* 441 */       } catch (NumberFormatException numberFormatException) {
/*     */         Matcher matcher;
/*     */         
/* 444 */         if (!(matcher = a.matcher(param1String)).matches()) {
/* 445 */           throw new com.d.c.d.b("Invalid nth-child selector: " + param1String, -1);
/*     */         }
/* 447 */         byte b1 = matcher.group(2).equals("") ? 1 : Integer.parseInt(matcher.group(2));
/* 448 */         byte b2 = (matcher.group(5) == null) ? 0 : Integer.parseInt(matcher.group(5));
/* 449 */         if ("-".equals(matcher.group(1))) {
/* 450 */           b1 = -b1;
/*     */         }
/* 452 */         if ("-".equals(matcher.group(4))) {
/* 453 */           b2 = -b2;
/*     */         }
/*     */         
/* 456 */         return new p(b1, b2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class j
/*     */     extends b
/*     */   {
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/*     */       int i;
/* 470 */       if ((i = param1d.e(param1Object)) >= 0 && i % 2 == 0) return true;  return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class q
/*     */     extends b
/*     */   {
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/*     */       int i;
/* 481 */       if ((i = param1d.e(param1Object)) >= 0 && i % 2 == 1) return true;  return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static class o
/*     */     extends b
/*     */   {
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 491 */       return param1a.f(param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class r
/*     */     extends b
/*     */   {
/*     */     final boolean a(Object param1Object, com.d.c.b.a param1a, com.d.c.b.d param1d) {
/* 504 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private static String[] b(String paramString, char paramChar) {
/* 509 */     if (paramString.indexOf(paramChar) == -1) {
/* 510 */       return new String[] { paramString };
/*     */     }
/* 512 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/* 514 */     int i = 0;
/*     */     
/*     */     int j;
/* 517 */     while ((j = paramString.indexOf(paramChar, i)) != -1) {
/* 518 */       if (j != i) {
/* 519 */         arrayList.add(paramString.substring(i, j));
/*     */       }
/* 521 */       i = j + 1;
/*     */     } 
/*     */     
/* 524 */     if (i != paramString.length()) {
/* 525 */       arrayList.add(paramString.substring(i));
/*     */     }
/*     */     
/* 528 */     return arrayList.<String>toArray(new String[arrayList.size()]);
/*     */   }
/*     */   
/*     */   abstract boolean a(Object paramObject, com.d.c.b.a parama, com.d.c.b.d paramd);
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\c\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */