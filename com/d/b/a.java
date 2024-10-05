/*     */ package com.d.b;
/*     */ 
/*     */ import com.d.c.d.j;
/*     */ import com.d.e.l;
/*     */ import com.d.e.q;
/*     */ import com.d.e.v;
/*     */ import com.d.i.ab;
/*     */ import com.d.i.r;
/*     */ import com.d.i.s;
/*     */ import com.d.i.u;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class a
/*     */ {
/*  41 */   private final List<com.d.c.b.b> a = new ArrayList<>();
/*     */   
/*     */   public a() {
/*  44 */     this.a.add(new c((byte)0));
/*  45 */     this.a.add(new e((byte)0));
/*  46 */     this.a.add(new f((byte)0));
/*  47 */     this.a.add(new b((byte)0));
/*  48 */     this.a.add(new a((byte)0));
/*     */   }
/*     */   
/*     */   public final com.d.c.b.b a(v paramv, com.d.i.e parame) {
/*  52 */     return this.a.stream()
/*  53 */       .filter(paramb -> paramb.a(paramv, parame))
/*  54 */       .findFirst().orElse(null);
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
/*     */   static class a
/*     */     implements com.d.c.b.b
/*     */   {
/*     */     private a() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a(ab param1ab, com.d.i.e param1e, s param1s) {
/*  79 */       if (param1ab.w() >= 0)
/*  80 */         return ((j)param1e.b().get(0)).c(); 
/*  81 */       return "";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a() {
/*  87 */       return "cont";
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(v param1v, com.d.i.e param1e) {
/*  92 */       if (param1e.a().equals("-fs-if-cut-off") && param1e
/*  93 */         .b().size() == 1 && ((j)param1e
/*  94 */         .b().get(0)).a() == 19) return true;
/*     */       
/*     */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class d
/*     */     implements com.d.c.b.b
/*     */   {
/*     */     private d() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a() {
/* 111 */       return "999";
/*     */     }
/*     */     
/*     */     protected static com.d.c.a.c a(com.d.i.e param1e) {
/* 115 */       com.d.c.a.c c2 = com.d.c.a.c.v; List<?> list;
/*     */       com.d.c.a.c c1;
/*     */       j j;
/* 118 */       if ((list = param1e.b()).size() == 2 && (
/*     */ 
/*     */         
/* 121 */         c1 = com.d.c.a.c.b((j = (j)list.get(1)).c())) != null) {
/* 122 */         c2 = c1;
/*     */       }
/*     */ 
/*     */       
/* 126 */       return c2;
/*     */     }
/*     */     protected static boolean a(com.d.i.e param1e, String param1String) {
/*     */       List<?> list;
/* 130 */       if (param1e.a().equals("counter") && ((
/*     */         
/* 132 */         list = param1e.b()).size() == 1 || list.size() == 2)) {
/*     */         j j;
/* 134 */         if ((j = (j)list.get(0)).a() != 21 || 
/* 135 */           !j.c().equals(param1String)) {
/* 136 */           return false;
/*     */         }
/*     */         
/* 139 */         if (list.size() == 2)
/*     */         {
/* 141 */           return ((j = (j)list.get(1)).a() == 21);
/*     */         }
/*     */         
/* 144 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 148 */       return false;
/*     */     } }
/*     */   
/*     */   static class c extends d { private c() {
/* 152 */       super((byte)0);
/*     */     }
/*     */     public final String a(ab param1ab, com.d.i.e param1e, s param1s) {
/* 155 */       int i = param1ab.u().c(param1ab) + 1;
/* 156 */       return l.a(a(param1e), i);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(v param1v, com.d.i.e param1e) {
/* 161 */       return (param1v.r() && a(param1e, "page"));
/*     */     } }
/*     */   
/*     */   static class e extends d { private e() {
/* 165 */       super((byte)0);
/*     */     }
/*     */     public final String a(ab param1ab, com.d.i.e param1e, s param1s) {
/* 168 */       int i = param1ab.u().d(param1ab);
/* 169 */       return l.a(a(param1e), i);
/*     */     }
/*     */ 
/*     */     
/*     */     public final boolean a(v param1v, com.d.i.e param1e) {
/* 174 */       return (param1v.r() && a(param1e, "pages"));
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class f
/*     */     implements com.d.c.b.b
/*     */   {
/*     */     private f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a(ab param1ab, com.d.i.e param1e, s param1s) {
/* 192 */       String str = str.substring(1);
/*     */       com.d.i.f f1;
/* 194 */       if ((str = param1s.g().ai().getAttribute("href")) != null && str.startsWith("#") && (f1 = param1ab.a(str)) != null) {
/* 195 */         int i = param1ab.u().a(param1ab, f1.aa());
/* 196 */         return l.a(com.d.c.a.c.v, i + 1);
/*     */       } 
/*     */       
/* 199 */       return "";
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a() {
/* 209 */       return "999";
/*     */     }
/*     */     
/*     */     public final boolean a(v param1v, com.d.i.e param1e) {
/*     */       List<?> list;
/* 214 */       if (param1v.r() && param1e.a().equals("target-counter") && ((
/*     */         
/* 216 */         list = param1e.b()).size() == 2 || list.size() == 3)) {
/*     */         
/* 218 */         if ((param1e = ((j)list.get(0)).n()) == null || param1e
/* 219 */           .b().size() != 1 || ((j)param1e
/* 220 */           .b().get(0)).a() != 21 || 
/* 221 */           !((j)param1e.b().get(0)).c().equals("href")) {
/* 222 */           return false;
/*     */         }
/*     */         
/*     */         j j;
/* 226 */         if ((j = (j)list.get(1)).a() == 21 && j
/* 227 */           .c().equals("page")) return true;
/*     */         
/*     */         return false;
/*     */       } 
/* 231 */       return false;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class b
/*     */     implements com.d.c.b.b
/*     */   {
/*     */     private b() {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a(ab param1ab, com.d.i.e param1e, s param1s) {
/*     */       r r;
/* 248 */       u u = (r = param1s.g()).k();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 253 */       byte b1 = 0;
/* 254 */       Iterator<com.d.i.f> iterator = u.W();
/* 255 */       while (iterator.hasNext()) {
/*     */         com.d.i.f f1;
/* 257 */         if ((f1 = iterator.next()) == r) {
/* 258 */           b1 = 1; continue;
/* 259 */         }  if (b1 && f1 instanceof r) {
/* 260 */           ((r)f1).d(param1ab);
/*     */         }
/*     */       } 
/* 263 */       if (b1) {
/* 264 */         int m = q.a((com.d.c.f.d)param1ab, (com.d.i.f)u, 0);
/* 265 */         u.u(m);
/*     */       } 
/*     */       
/*     */       j j1;
/*     */       
/* 270 */       String str1 = (j1 = param1e.b().get(0)).c();
/* 271 */       if (j1.a() == 21) {
/* 272 */         if (str1.equals("dotted")) {
/* 273 */           str1 = ". ";
/* 274 */         } else if (str1.equals("solid")) {
/* 275 */           str1 = "_";
/* 276 */         } else if (str1.equals("space")) {
/* 277 */           str1 = " ";
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 284 */       StringBuilder stringBuilder1 = new StringBuilder(100 * str1.length());
/* 285 */       for (b1 = 0; b1 < 100; b1++) {
/* 286 */         stringBuilder1.append(str1);
/*     */       }
/* 288 */       param1ab.q(); float f = param1ab.f().a(r
/* 289 */           .a().d((com.d.c.f.d)param1ab), stringBuilder1.toString()) / 100.0F;
/* 290 */       param1ab.q(); int k = param1ab.f().a(r
/* 291 */           .a().d((com.d.c.f.d)param1ab), " ");
/*     */       
/*     */       int j;
/*     */       
/* 295 */       k = (int)(((j = r.aj() - r.k().Q() + param1s.f()) - 2 * k) / f);
/*     */       
/*     */       StringBuilder stringBuilder2;
/*     */       
/* 299 */       (stringBuilder2 = new StringBuilder(k * str1.length() + 2)).append(' ');
/* 300 */       for (byte b2 = 0; b2 < k; b2++) {
/* 301 */         stringBuilder2.append(str1);
/*     */       }
/* 303 */       stringBuilder2.append(' ');
/* 304 */       String str2 = stringBuilder2.toString();
/*     */ 
/*     */       
/* 307 */       param1ab.q(); int i = param1ab.f().a(r
/* 308 */           .a().d((com.d.c.f.d)param1ab), str2);
/* 309 */       r.e((com.d.c.f.d)param1ab, j - i);
/*     */       
/* 311 */       return str2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String a() {
/* 321 */       return " . ";
/*     */     }
/*     */     
/*     */     public final boolean a(v param1v, com.d.i.e param1e) {
/*     */       List<?> list;
/* 326 */       if (param1v.r() && param1e.a().equals("leader") && (
/*     */         
/* 328 */         list = param1e.b()).size() == 1) {
/*     */         j j;
/* 330 */         if ((j = (j)list.get(0)).a() == 19 || (j
/* 331 */           .a() == 21 && (j
/* 332 */           .c().equals("dotted") || j
/* 333 */           .c().equals("solid") || j
/* 334 */           .c().equals("space")))) return true;
/*     */         
/*     */         return false;
/*     */       } 
/* 338 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\b\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */