/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.i;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.m.ac;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class g
/*     */ {
/*     */   private final j a;
/*     */   private final b[] b;
/*     */   private final Map<String, Object> c;
/*     */   private final String[] d;
/*     */   private final ac[] e;
/*     */   
/*     */   protected g(j paramj, b[] paramArrayOfb, Map<String, Object> paramMap, String[] paramArrayOfString, ac[] paramArrayOfac) {
/*  41 */     this.a = paramj;
/*  42 */     this.b = paramArrayOfb;
/*  43 */     this.c = paramMap;
/*  44 */     this.d = paramArrayOfString;
/*  45 */     this.e = paramArrayOfac;
/*     */   }
/*     */ 
/*     */   
/*     */   private g(g paramg) {
/*  50 */     this.a = paramg.a;
/*  51 */     this.b = paramg.b;
/*  52 */     this.c = paramg.c;
/*  53 */     int i = this.b.length;
/*  54 */     this.d = new String[i];
/*  55 */     this.e = new ac[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(j paramj) {
/*  62 */     return new a(paramj);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final g a() {
/*  70 */     return new g(this);
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
/*     */   public final boolean a(l paraml, com.a.a.c.g paramg, String paramString, Object paramObject) {
/*     */     Object object;
/*  86 */     if ((object = this.c.get(paramString)) == null) {
/*  87 */       return false;
/*     */     }
/*  89 */     String str = paraml.w();
/*     */     
/*  91 */     if (object instanceof List) {
/*  92 */       boolean bool = false;
/*  93 */       for (Integer integer : object) {
/*  94 */         if (a(paraml, paramg, paramString, paramObject, str, integer
/*  95 */             .intValue())) {
/*  96 */           bool = true;
/*     */         }
/*     */       } 
/*  99 */       return bool;
/*     */     } 
/* 101 */     return a(paraml, paramg, paramString, paramObject, str, ((Integer)object)
/* 102 */         .intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean a(l paraml, com.a.a.c.g paramg, String paramString1, Object paramObject, String paramString2, int paramInt) {
/*     */     b b1;
/* 110 */     if (!(b1 = this.b[paramInt]).a(paramString1)) {
/* 111 */       return false;
/*     */     }
/*     */     
/*     */     boolean bool;
/*     */     
/* 116 */     if (bool = (paramObject != null && this.e[paramInt] != null) ? true : false) {
/* 117 */       a(paraml, paramg, paramObject, paramInt, paramString2);
/*     */       
/* 119 */       this.e[paramInt] = null;
/*     */     } else {
/* 121 */       this.d[paramInt] = paramString2;
/*     */     } 
/* 123 */     return true;
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
/*     */   public final boolean b(l paraml, com.a.a.c.g paramg, String paramString, Object paramObject) {
/*     */     ac ac1;
/*     */     boolean bool;
/*     */     Object object;
/* 139 */     if ((object = this.c.get(paramString)) == null) {
/* 140 */       return false;
/*     */     }
/*     */     
/* 143 */     if (object instanceof List) {
/*     */       
/* 145 */       Integer integer = (object = ((List)object).iterator()).next();
/*     */ 
/*     */       
/*     */       b b2;
/*     */       
/* 150 */       if ((b2 = this.b[integer.intValue()]).a(paramString)) {
/* 151 */         paramString = paraml.w();
/* 152 */         paraml.j();
/* 153 */         this.d[integer.intValue()] = paramString;
/* 154 */         while (object.hasNext()) {
/* 155 */           this.d[((Integer)object.next()).intValue()] = paramString;
/*     */         }
/*     */       } else {
/* 158 */         ac1 = paramg.b(paraml);
/* 159 */         this.e[integer.intValue()] = ac1;
/* 160 */         while (object.hasNext()) {
/* 161 */           this.e[((Integer)object.next()).intValue()] = ac1;
/*     */         }
/*     */       } 
/* 164 */       return true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 169 */     int i = ((Integer)object).intValue();
/*     */     
/*     */     b b1;
/* 172 */     if ((b1 = this.b[i]).a((String)ac1)) {
/*     */ 
/*     */       
/* 175 */       this.d[i] = paraml.R();
/* 176 */       paraml.j();
/* 177 */       bool = (paramObject != null && this.e[i] != null) ? true : false;
/*     */     } else {
/*     */       
/* 180 */       ac1 = paramg.b(paraml);
/* 181 */       this.e[i] = ac1;
/* 182 */       bool = (paramObject != null && this.d[i] != null) ? true : false;
/*     */     } 
/*     */ 
/*     */     
/* 186 */     if (bool) {
/* 187 */       String str = this.d[i];
/*     */       
/* 189 */       this.d[i] = null;
/* 190 */       a(paraml, paramg, paramObject, i, str);
/* 191 */       this.e[i] = null;
/*     */     } 
/* 193 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, com.a.a.c.g paramg, Object paramObject) {
/*     */     byte b1;
/*     */     int i;
/* 204 */     for (b1 = 0, i = this.b.length; b1 < i; b1++) {
/* 205 */       String str = this.d[b1];
/* 206 */       b b2 = this.b[b1];
/* 207 */       if (str == null)
/*     */       { ac ac1;
/*     */ 
/*     */         
/* 211 */         if ((ac1 = this.e[b1]) != null)
/*     */         { l l1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 219 */           (l1 = ac1.c(paraml)).g();
/* 220 */           v v = b2.d(); Object object;
/*     */           o o;
/* 222 */           if ((o = ac1.q()).g() && (object = e.a(l1, paramg, v.c())) != null)
/* 223 */           { v.a(paramObject, object);
/*     */              }
/*     */           
/*     */           else
/*     */           
/* 228 */           { if (!b2.a()) {
/* 229 */               paramg.a(this.a, b2.d().a(), "Missing external type id property '%s' (and no 'defaultImpl' specified)", new Object[] { b2
/*     */                     
/* 231 */                     .c() });
/*     */             
/*     */             }
/* 234 */             else if ((str = b2.b()) == null) {
/* 235 */               paramg.a(this.a, b2.d().a(), "Invalid default type id for property '%s': `null` returned by TypeIdResolver", new Object[] { b2
/*     */                     
/* 237 */                     .c() });
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 251 */             a(paraml, paramg, paramObject, b1, str); }  }  } else { if (this.e[b1] == null) { v v; if ((v = b2.d()).t() || paramg.a(i.m)) paramg.c(paramObject.getClass(), v.a(), "Missing property '%s' for external type id '%s'", new Object[] { v.a(), b2.c() });  return paramObject; }  a(paraml, paramg, paramObject, b1, str); }
/*     */     
/* 253 */     }  return paramObject;
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
/*     */   public final Object a(l paraml, com.a.a.c.g paramg, y paramy, v paramv) {
/*     */     int i;
/* 266 */     Object[] arrayOfObject = new Object[i = this.b.length];
/* 267 */     for (byte b1 = 0; b1 < i; b1++) {
/* 268 */       String str = this.d[b1];
/* 269 */       b b3 = this.b[b1];
/* 270 */       if (str == null) {
/*     */         ac ac1;
/*     */         
/* 273 */         if ((ac1 = this.e[b1]) != null && ac1
/*     */ 
/*     */           
/* 276 */           .q() != o.m)
/*     */         
/*     */         { 
/*     */ 
/*     */ 
/*     */           
/* 282 */           if (!b3.a()) {
/* 283 */             paramg.a(this.a, b3.d().a(), "Missing external type id property '%s'", new Object[] { b3
/*     */                   
/* 285 */                   .c() });
/*     */           } else {
/* 287 */             str = b3.b();
/*     */           }  }
/*     */         else { continue; }
/*     */       
/* 291 */       }  if (this.e[b1] != null) {
/* 292 */         arrayOfObject[b1] = a(paraml, paramg, b1, str);
/*     */       } else {
/* 294 */         if (paramg.a(i.m)) {
/* 295 */           v v3 = b3.d();
/* 296 */           paramg.a(this.a, v3.a(), "Missing property '%s' for external type id '%s'", new Object[] { v3
/*     */                 
/* 298 */                 .a(), this.b[b1].c() });
/*     */         } 
/*     */ 
/*     */         
/* 302 */         arrayOfObject[b1] = b(paraml, paramg, b1, str);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 308 */       paramy.a(v2, arrayOfObject[b1]);
/*     */ 
/*     */       
/*     */       v v1, v2;
/*     */       
/* 313 */       if ((v2 = b3.d()).h() >= 0 && (v1 = b3.e()) != null && v1.h() >= 0) {
/*     */         Object object1;
/*     */ 
/*     */         
/* 317 */         if (v1.c().a(String.class)) {
/* 318 */           str = str;
/*     */         } else {
/*     */           ac ac1;
/* 321 */           (ac1 = paramg.a(paraml)).b(str);
/* 322 */           object1 = v1.p().a(ac1.p(), paramg);
/* 323 */           ac1.close();
/*     */         } 
/* 325 */         paramy.a(v1, object1);
/*     */       } 
/*     */       continue;
/*     */     } 
/* 329 */     Object object = paramv.a(paramg, paramy);
/*     */     
/* 331 */     for (byte b2 = 0; b2 < i; b2++) {
/*     */       v v1;
/* 333 */       if ((v1 = this.b[b2].d()).h() < 0) {
/* 334 */         v1.a(object, arrayOfObject[b2]);
/*     */       }
/*     */     } 
/* 337 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a(l paraml, com.a.a.c.g paramg, int paramInt, String paramString) {
/*     */     l l1;
/*     */     o o;
/* 347 */     if ((o = (l1 = this.e[paramInt].c(paraml)).g()) == o.m) {
/* 348 */       return null;
/*     */     }
/*     */     ac ac1;
/* 351 */     (ac1 = paramg.a(paraml)).g();
/* 352 */     ac1.b(paramString);
/* 353 */     ac1.b(l1);
/* 354 */     ac1.h();
/*     */ 
/*     */ 
/*     */     
/* 358 */     (paraml = ac1.c(paraml)).g();
/* 359 */     return this.b[paramInt].d().a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object b(l paraml, com.a.a.c.g paramg, int paramInt, String paramString) {
/*     */     ac ac1;
/* 368 */     (ac1 = paramg.a(paraml)).g();
/* 369 */     ac1.b(paramString);
/* 370 */     ac1.h();
/*     */ 
/*     */ 
/*     */     
/* 374 */     (paraml = ac1.c(paraml)).g();
/* 375 */     return this.b[paramInt].d().a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(l paraml, com.a.a.c.g paramg, Object paramObject, int paramInt, String paramString) {
/* 383 */     if (paramString == null) {
/* 384 */       paramg.a(this.a, "Internal error in external Type Id handling: `null` type id passed", new Object[0]);
/*     */     }
/*     */ 
/*     */     
/*     */     l l1;
/*     */     
/*     */     o o;
/*     */     
/* 392 */     if ((o = (l1 = this.e[paramInt].c(paraml)).g()) == o.m) {
/* 393 */       this.b[paramInt].d().a(paramObject, null);
/*     */       return;
/*     */     } 
/*     */     ac ac1;
/* 397 */     (ac1 = paramg.a(paraml)).g();
/* 398 */     ac1.b(paramString);
/*     */     
/* 400 */     ac1.b(l1);
/* 401 */     ac1.h();
/*     */ 
/*     */     
/* 404 */     (paraml = ac1.c(paraml)).g();
/* 405 */     this.b[paramInt].d().a(paraml, paramg, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*     */     private final j a;
/*     */ 
/*     */ 
/*     */     
/* 418 */     private final List<g.b> b = new ArrayList<>();
/* 419 */     private final Map<String, Object> c = new HashMap<>();
/*     */     
/*     */     protected a(j param1j) {
/* 422 */       this.a = param1j;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(v param1v, e param1e) {
/* 427 */       Integer integer = Integer.valueOf(this.b.size());
/* 428 */       this.b.add(new g.b(param1v, param1e));
/* 429 */       a(param1v.a(), integer);
/* 430 */       a(param1e.b(), integer);
/*     */     }
/*     */     
/*     */     private void a(String param1String, Integer param1Integer) {
/*     */       Object object;
/* 435 */       if ((object = this.c.get(param1String)) == null) {
/* 436 */         this.c.put(param1String, param1Integer); return;
/* 437 */       }  if (object instanceof List) {
/*     */         List<Integer> list;
/*     */         
/* 440 */         (list = (List<Integer>)object).add(param1Integer); return;
/*     */       } 
/*     */       LinkedList<Object> linkedList;
/* 443 */       (linkedList = new LinkedList()).add(object);
/* 444 */       linkedList.add(param1Integer);
/* 445 */       this.c.put(param1String, linkedList);
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
/*     */     public final g a(c param1c) {
/*     */       int i;
/* 459 */       g.b[] arrayOfB = new g.b[i = this.b.size()];
/* 460 */       for (byte b = 0; b < i; b++) {
/*     */         g.b b1;
/* 462 */         String str = (b1 = this.b.get(b)).c();
/*     */         v v;
/* 464 */         if ((v = param1c.a(str)) != null) {
/* 465 */           b1.a(v);
/*     */         }
/* 467 */         arrayOfB[b] = b1;
/*     */       } 
/* 469 */       return new g(this.a, arrayOfB, this.c, null, null);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class b
/*     */   {
/*     */     private final v a;
/*     */     
/*     */     private final e b;
/*     */     
/*     */     private final String c;
/*     */     
/*     */     private v d;
/*     */ 
/*     */     
/*     */     public b(v param1v, e param1e) {
/* 487 */       this.a = param1v;
/* 488 */       this.b = param1e;
/* 489 */       this.c = param1e.b();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(v param1v) {
/* 496 */       this.d = param1v;
/*     */     }
/*     */     
/*     */     public final boolean a(String param1String) {
/* 500 */       return param1String.equals(this.c);
/*     */     }
/*     */     
/*     */     public final boolean a() {
/* 504 */       return this.b.e();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final String b() {
/*     */       Class clazz;
/* 514 */       if ((clazz = this.b.d()) == null) {
/* 515 */         return null;
/*     */       }
/* 517 */       return this.b.c().a(null, clazz);
/*     */     }
/*     */     public final String c() {
/* 520 */       return this.c;
/*     */     }
/*     */     public final v d() {
/* 523 */       return this.a;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final v e() {
/* 530 */       return this.d;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */