/*     */ package com.a.a.c.k.b;
/*     */ 
/*     */ import com.a.a.a.l;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.c.a;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.k.j;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.z;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class ac
/*     */   extends a<Object[]>
/*     */ {
/*     */   private boolean a;
/*     */   private j d;
/*     */   private i e;
/*     */   private o<Object> f;
/*     */   private k g;
/*     */   
/*     */   public ac(j paramj, boolean paramBoolean, i parami, o<Object> paramo) {
/*  65 */     super(Object[].class);
/*  66 */     this.d = paramj;
/*  67 */     this.a = paramBoolean;
/*  68 */     this.e = parami;
/*  69 */     this.g = k.a();
/*  70 */     this.f = paramo;
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
/*     */   private ac(ac paramac, c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/*  90 */     super(paramac, paramc, paramBoolean);
/*  91 */     this.d = paramac.d;
/*  92 */     this.e = parami;
/*  93 */     this.a = paramac.a;
/*     */     
/*  95 */     this.g = k.a();
/*  96 */     this.f = (o)paramo;
/*     */   }
/*     */ 
/*     */   
/*     */   public final o<?> a(c paramc, Boolean paramBoolean) {
/* 101 */     return (o<?>)new ac(this, paramc, this.e, this.f, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final j<?> b(i parami) {
/* 107 */     return new ac(this.d, this.a, parami, this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   private ac a(c paramc, i parami, o<?> paramo, Boolean paramBoolean) {
/* 112 */     if (this.b == paramc && paramo == this.f && this.e == parami && 
/* 113 */       Objects.equals(this.c, paramBoolean)) {
/* 114 */       return this;
/*     */     }
/* 116 */     return new ac(this, paramc, parami, paramo, paramBoolean);
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
/*     */   public final o<?> a(aa paramaa, c paramc) {
/*     */     i i1;
/* 131 */     if ((i1 = this.e) != null) {
/* 132 */       i1 = i1.a(paramc);
/*     */     }
/* 134 */     o<Object> o1 = null;
/* 135 */     Boolean bool = null;
/*     */ 
/*     */     
/* 138 */     if (paramc != null) {
/* 139 */       j j1 = paramc.e();
/* 140 */       a a1 = paramaa.d(); Object object;
/* 141 */       if (j1 != null && (
/*     */         
/* 143 */         object = a1.p((b)j1)) != null) {
/* 144 */         o1 = paramaa.b((b)j1, object);
/*     */       }
/*     */     } 
/*     */     
/*     */     l.d d;
/* 149 */     if ((d = a(paramaa, paramc, a())) != null) {
/* 150 */       bool = d.a(l.a.c);
/*     */     }
/* 152 */     if (o1 == null) {
/* 153 */       o1 = this.f;
/*     */     }
/*     */ 
/*     */     
/* 157 */     if ((o1 = a(paramaa, paramc, o1)) == null)
/*     */     {
/*     */       
/* 160 */       if (this.d != null && 
/* 161 */         this.a && !this.d.q()) {
/* 162 */         o1 = paramaa.c(this.d, paramc);
/*     */       }
/*     */     }
/*     */     
/* 166 */     return (o<?>)a(paramc, i1, o1, bool);
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
/*     */   private static boolean a(Object[] paramArrayOfObject) {
/* 187 */     return (paramArrayOfObject.length == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean b(Object[] paramArrayOfObject) {
/* 192 */     return (paramArrayOfObject.length == 1);
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
/*     */   private void a(Object[] paramArrayOfObject, h paramh, aa paramaa) {
/*     */     int m;
/* 205 */     if ((m = paramArrayOfObject.length) == 1 && ((
/* 206 */       this.c == null && paramaa
/* 207 */       .a(z.r)) || this.c == Boolean.TRUE)) {
/*     */       
/* 209 */       b(paramArrayOfObject, paramh, paramaa);
/*     */       
/*     */       return;
/*     */     } 
/* 213 */     paramh.a(paramArrayOfObject, m);
/* 214 */     b(paramArrayOfObject, paramh, paramaa);
/* 215 */     paramh.h();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(Object[] paramArrayOfObject, h paramh, aa paramaa) {
/*     */     int m;
/* 222 */     if ((m = paramArrayOfObject.length) == 0) {
/*     */       return;
/*     */     }
/* 225 */     if (this.f != null) {
/* 226 */       a(paramArrayOfObject, paramh, paramaa, this.f);
/*     */       return;
/*     */     } 
/* 229 */     if (this.e != null) {
/* 230 */       c(paramArrayOfObject, paramh, paramaa);
/*     */       return;
/*     */     } 
/* 233 */     byte b = 0;
/* 234 */     Object object = null;
/*     */     try {
/* 236 */       k k1 = this.g;
/* 237 */       for (; b < m; b++) {
/*     */         
/* 239 */         if ((object = paramArrayOfObject[b]) == null)
/* 240 */         { paramaa.a(paramh); }
/*     */         else
/*     */         
/* 243 */         { Class<?> clazz = object.getClass();
/*     */           o<Object> o1;
/* 245 */           if ((o1 = k1.a(clazz)) == null) {
/* 246 */             if (this.d.s()) {
/* 247 */               o1 = a(k1, paramaa
/* 248 */                   .a(this.d, clazz), paramaa);
/*     */             } else {
/* 250 */               o1 = a(k1, clazz, paramaa);
/*     */             } 
/*     */           }
/* 253 */           o1.a(object, paramh, paramaa); } 
/*     */       }  return;
/* 255 */     } catch (Exception exception) {
/* 256 */       a(paramaa, exception, object, b);
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Object[] paramArrayOfObject, h paramh, aa paramaa, o<Object> paramo) {
/* 263 */     int m = paramArrayOfObject.length;
/* 264 */     i i1 = this.e;
/*     */     
/* 266 */     byte b = 0;
/* 267 */     Object object = null;
/*     */     try {
/* 269 */       for (; b < m; b++) {
/*     */         
/* 271 */         if ((object = paramArrayOfObject[b]) == null) {
/* 272 */           paramaa.a(paramh);
/*     */         
/*     */         }
/* 275 */         else if (i1 == null) {
/* 276 */           paramo.a(object, paramh, paramaa);
/*     */         } else {
/* 278 */           paramo.a(object, paramh, paramaa, i1);
/*     */         } 
/*     */       }  return;
/* 281 */     } catch (Exception exception) {
/* 282 */       a(paramaa, exception, object, b);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(Object[] paramArrayOfObject, h paramh, aa paramaa) {
/* 288 */     int m = paramArrayOfObject.length;
/* 289 */     i i1 = this.e;
/* 290 */     byte b = 0;
/* 291 */     Object object = null;
/*     */     try {
/* 293 */       k k1 = this.g;
/* 294 */       for (; b < m; b++) {
/*     */         
/* 296 */         if ((object = paramArrayOfObject[b]) == null)
/* 297 */         { paramaa.a(paramh); }
/*     */         else
/*     */         
/* 300 */         { Class<?> clazz = object.getClass();
/*     */           o<Object> o1;
/* 302 */           if ((o1 = k1.a(clazz)) == null) {
/* 303 */             o1 = a(k1, clazz, paramaa);
/*     */           }
/* 305 */           o1.a(object, paramh, paramaa, i1); } 
/*     */       }  return;
/* 307 */     } catch (Exception exception) {
/* 308 */       a(paramaa, exception, object, b);
/*     */       return;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private o<Object> a(k paramk, Class<?> paramClass, aa paramaa) {
/* 340 */     k.d d = paramk.b(paramClass, paramaa, this.b);
/*     */     
/* 342 */     if (paramk != d.b) {
/* 343 */       this.g = d.b;
/*     */     }
/* 345 */     return d.a;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private o<Object> a(k paramk, j paramj, aa paramaa) {
/* 351 */     k.d d = paramk.b(paramj, paramaa, this.b);
/*     */     
/* 353 */     if (paramk != d.b) {
/* 354 */       this.g = d.b;
/*     */     }
/* 356 */     return d.a;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\b\ac.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */