/*     */ package com.a.a.c.c.a;
/*     */ 
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.c.b.aj;
/*     */ import com.a.a.c.c.v;
/*     */ import com.a.a.c.c.x;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.n;
/*     */ import com.a.a.c.f.o;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.q;
/*     */ import java.lang.reflect.Member;
/*     */ import java.util.HashMap;
/*     */ 
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
/*  32 */   private static String[] a = new String[] { "default", "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   private o[] e = new o[11];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  63 */   private int f = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g = false;
/*     */ 
/*     */   
/*     */   private v[] h;
/*     */ 
/*     */   
/*     */   private v[] i;
/*     */ 
/*     */   
/*     */   private v[] j;
/*     */ 
/*     */ 
/*     */   
/*     */   public e(b paramb, q<?> paramq) {
/*  81 */     this.b = paramb;
/*  82 */     this.c = paramq.g();
/*  83 */     this
/*  84 */       .d = paramq.a(q.o);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final x a(g paramg) {
/*  90 */     paramg.c();
/*  91 */     j j2 = a(paramg, this.e[8], this.h);
/*     */     
/*  93 */     j j1 = a(paramg, this.e[10], this.i);
/*     */     
/*  95 */     j j3 = this.b.a();
/*     */     
/*     */     aj aj;
/*  98 */     (aj = new aj(j3)).a(this.e[0], this.e[8], j2, this.h, this.e[9], this.j);
/*     */ 
/*     */     
/* 101 */     aj.a(this.e[10], j1, this.i);
/*     */     
/* 103 */     aj.a(this.e[1]);
/* 104 */     aj.b(this.e[2]);
/* 105 */     aj.c(this.e[3]);
/* 106 */     aj.d(this.e[4]);
/* 107 */     aj.e(this.e[5]);
/* 108 */     aj.f(this.e[6]);
/* 109 */     aj.g(this.e[7]);
/* 110 */     return (x)aj;
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
/*     */   public final void a(o paramo) {
/* 130 */     this.e[0] = a(paramo);
/*     */   }
/*     */   
/*     */   public final void a(o paramo, boolean paramBoolean) {
/* 134 */     a(paramo, 1, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void b(o paramo, boolean paramBoolean) {
/* 138 */     a(paramo, 2, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void c(o paramo, boolean paramBoolean) {
/* 142 */     a(paramo, 3, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void d(o paramo, boolean paramBoolean) {
/* 146 */     a(paramo, 4, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void e(o paramo, boolean paramBoolean) {
/* 150 */     a(paramo, 5, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void f(o paramo, boolean paramBoolean) {
/* 154 */     a(paramo, 6, paramBoolean);
/*     */   }
/*     */   
/*     */   public final void g(o paramo, boolean paramBoolean) {
/* 158 */     a(paramo, 7, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o paramo, boolean paramBoolean, v[] paramArrayOfv, int paramInt) {
/* 165 */     if (paramo.b(paramInt).o()) {
/* 166 */       if (a(paramo, 10, paramBoolean)) {
/* 167 */         this.i = paramArrayOfv;
/*     */         return;
/*     */       } 
/* 170 */     } else if (a(paramo, 8, paramBoolean)) {
/* 171 */       this.h = paramArrayOfv;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(o paramo, boolean paramBoolean, v[] paramArrayOfv) {
/* 179 */     if (a(paramo, 9, paramBoolean)) {
/*     */       
/* 181 */       if (paramArrayOfv.length > 1) {
/* 182 */         HashMap<Object, Object> hashMap = new HashMap<>(); int i;
/* 183 */         for (paramBoolean = false, i = paramArrayOfv.length; paramBoolean < i; paramBoolean++) {
/*     */           String str;
/*     */ 
/*     */           
/* 187 */           if (!(str = paramArrayOfv[paramBoolean].a()).isEmpty() || paramArrayOfv[paramBoolean].i() == null) {
/*     */             Integer integer;
/*     */ 
/*     */             
/* 191 */             if ((integer = (Integer)hashMap.put(str, Integer.valueOf(paramBoolean))) != null)
/* 192 */               throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", new Object[] { str, integer, 
/*     */                       
/* 194 */                       Integer.valueOf(paramBoolean), i.g(this.b.b()) })); 
/*     */           } 
/*     */         } 
/*     */       } 
/* 198 */       this.j = paramArrayOfv;
/*     */     } 
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
/*     */   public final boolean a() {
/* 212 */     return (this.e[0] != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean b() {
/* 219 */     return (this.e[8] != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/* 226 */     return (this.e[9] != null);
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
/*     */   private j a(g paramg, o paramo, v[] paramArrayOfv) {
/* 239 */     if (!this.g || paramo == null) {
/* 240 */       return null;
/*     */     }
/*     */     
/* 243 */     byte b1 = 0;
/* 244 */     if (paramArrayOfv != null) {
/* 245 */       byte b2; int i; for (b2 = 0, i = paramArrayOfv.length; b2 < i; b2++) {
/* 246 */         if (paramArrayOfv[b2] == null) {
/* 247 */           b1 = b2;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 252 */     f f = paramg.c();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 257 */     j j = paramo.b(b1);
/*     */     a a;
/* 259 */     if ((a = f.j()) != null) {
/* 260 */       n n = paramo.c(b1);
/*     */       
/*     */       Object object;
/*     */       
/* 264 */       if ((object = a.z((b)n)) != null) {
/* 265 */         k k = paramg.b((b)n, object);
/* 266 */         j = j.c(k);
/*     */       } else {
/*     */         
/* 269 */         j = a.b((q)f, (b)n, j);
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     return j;
/*     */   }
/*     */   
/*     */   private <T extends com.a.a.c.f.j> T a(T paramT) {
/* 277 */     if (paramT != null && this.c) {
/* 278 */       i.a((Member)paramT.a(), this.d);
/*     */     }
/*     */     
/* 281 */     return paramT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean a(o paramo, int paramInt, boolean paramBoolean) {
/* 289 */     int i = 1 << paramInt;
/* 290 */     this.g = true;
/*     */     
/*     */     o o1;
/* 293 */     if ((o1 = this.e[paramInt]) != null) {
/*     */ 
/*     */ 
/*     */       
/* 297 */       if (!paramBoolean) {
/* 298 */         return false;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       boolean bool;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 311 */       if ((bool = ((this.f & i) != 0) ? true : (!paramBoolean ? true : false)) && o1.getClass() == paramo.getClass()) {
/*     */         
/* 313 */         Class<?> clazz1 = o1.a(0);
/* 314 */         Class<?> clazz2 = paramo.a(0);
/*     */         
/* 316 */         if (clazz1 == clazz2) {
/*     */ 
/*     */ 
/*     */           
/* 320 */           if (b(paramo)) {
/* 321 */             return false;
/*     */           }
/* 323 */           if (!b(o1))
/*     */           {
/*     */             
/* 326 */             a(paramInt, paramBoolean, o1, paramo);
/*     */           }
/*     */         } else {
/*     */           
/* 330 */           if (clazz2.isAssignableFrom(clazz1))
/*     */           {
/* 332 */             return false; } 
/* 333 */           if (!clazz1.isAssignableFrom(clazz2))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 341 */             if (clazz1.isPrimitive() != clazz2.isPrimitive()) {
/*     */               
/* 343 */               if (clazz1.isPrimitive()) {
/* 344 */                 return false;
/*     */               
/*     */               }
/*     */             }
/*     */             else {
/*     */               
/* 350 */               a(paramInt, paramBoolean, o1, paramo);
/*     */             }  } 
/*     */         } 
/*     */       } 
/* 354 */     }  if (paramBoolean) {
/* 355 */       this.f |= i;
/*     */     }
/* 357 */     this.e[paramInt] = a(paramo);
/* 358 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void a(int paramInt, boolean paramBoolean, o paramo1, o paramo2) {
/* 364 */     throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", new Object[] { a[paramInt], paramBoolean ? "explicitly marked" : "implicitly discovered", paramo1, paramo2 }));
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
/*     */   private static boolean b(o paramo) {
/* 378 */     if (i.k(paramo.h()) && "valueOf"
/* 379 */       .equals(paramo.b())) return true; 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */