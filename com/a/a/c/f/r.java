/*     */ package com.a.a.c.f;
/*     */ 
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.b.q;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l.l;
/*     */ import com.a.a.c.m;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.y;
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
/*     */ 
/*     */ public final class r
/*     */   extends t implements Serializable {
/*  17 */   private static final Class<?> a = Object.class;
/*  18 */   private static final Class<?> b = String.class;
/*  19 */   private static final Class<?> c = m.class;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  31 */   private static q d = q.a(null, (j)l.e(String.class), 
/*  32 */       e.a(b));
/*     */ 
/*     */ 
/*     */   
/*  36 */   private static q e = q.a(null, (j)l.e(boolean.class), 
/*  37 */       e.a(boolean.class));
/*     */ 
/*     */ 
/*     */   
/*  41 */   private static q f = q.a(null, (j)l.e(int.class), 
/*  42 */       e.a(int.class));
/*     */ 
/*     */ 
/*     */   
/*  46 */   private static q g = q.a(null, (j)l.e(long.class), 
/*  47 */       e.a(long.class));
/*     */ 
/*     */ 
/*     */   
/*  51 */   private static q h = q.a(null, (j)l.e(Object.class), 
/*  52 */       e.a(a));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q b(y paramy, j paramj, t.a parama) {
/*     */     q q1;
/*  81 */     if ((q1 = a((q<?>)paramy, paramj)) == null)
/*     */     {
/*     */ 
/*     */       
/*  85 */       if ((q1 = b((q<?>)paramy, paramj)) == null) {
/*  86 */         q1 = q.b(a((q<?>)paramy, paramj, parama, true));
/*     */       }
/*     */     }
/*     */     
/*  90 */     return q1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q c(f paramf, j paramj, t.a parama) {
/*     */     q q1;
/*  99 */     if ((q1 = a((q<?>)paramf, paramj)) == null)
/*     */     {
/*     */ 
/*     */       
/* 103 */       if ((q1 = b((q<?>)paramf, paramj)) == null) {
/* 104 */         q1 = q.a(a((q<?>)paramf, paramj, parama, false));
/*     */       }
/*     */     }
/*     */     
/* 108 */     return q1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q b(f paramf, j paramj, t.a parama, b paramb) {
/* 116 */     return q.a(a((q<?>)paramf, paramj, parama, paramb, false));
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
/*     */   private q d(f paramf, j paramj, t.a parama) {
/*     */     q q1;
/* 135 */     if ((q1 = a((q<?>)paramf, paramj)) == null)
/*     */     {
/*     */ 
/*     */       
/* 139 */       if ((q1 = b((q<?>)paramf, paramj)) == null) {
/* 140 */         q1 = q.a(
/* 141 */             a((q<?>)paramf, paramj, parama, false));
/*     */       }
/*     */     }
/* 144 */     return q1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q b(q<?> paramq, j paramj, t.a parama) {
/*     */     q q1;
/* 152 */     if ((q1 = a(paramq, paramj)) == null) {
/* 153 */       q1 = q.a(paramq, paramj, 
/* 154 */           c(paramq, paramj, parama));
/*     */     }
/* 156 */     return q1;
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
/*     */   private ae a(q<?> paramq, j paramj, t.a parama, boolean paramBoolean) {
/* 183 */     d d = c(paramq, paramj, parama);
/*     */ 
/*     */     
/* 186 */     a a1 = paramj.j() ? paramq.l().c(paramq, d) : paramq.l().a(paramq, d);
/* 187 */     return a(paramq, d, paramj, paramBoolean, a1);
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
/*     */   private ae a(q<?> paramq, j paramj, t.a parama, b paramb, boolean paramBoolean) {
/* 207 */     d d = c(paramq, paramj, parama);
/*     */     
/* 209 */     a a1 = paramq.l().b(paramq, d);
/* 210 */     return a(paramq, d, paramj, false, a1);
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
/*     */   private static ae a(q<?> paramq, d paramd, j paramj, boolean paramBoolean, a parama) {
/* 230 */     return new ae(paramq, paramBoolean, paramj, paramd, parama);
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
/*     */   private static q a(q<?> paramq, j paramj) {
/*     */     Class<?> clazz;
/* 248 */     if ((clazz = paramj.b()).isPrimitive()) {
/* 249 */       if (clazz == int.class) {
/* 250 */         return f;
/*     */       }
/* 252 */       if (clazz == long.class) {
/* 253 */         return g;
/*     */       }
/* 255 */       if (clazz == boolean.class) {
/* 256 */         return e;
/*     */       }
/* 258 */     } else if (i.m(clazz)) {
/* 259 */       if (clazz == a) {
/* 260 */         return h;
/*     */       }
/* 262 */       if (clazz == b) {
/* 263 */         return d;
/*     */       }
/* 265 */       if (clazz == Integer.class) {
/* 266 */         return f;
/*     */       }
/* 268 */       if (clazz == Long.class) {
/* 269 */         return g;
/*     */       }
/* 271 */       if (clazz == Boolean.class) {
/* 272 */         return e;
/*     */       }
/* 274 */     } else if (c.isAssignableFrom(clazz)) {
/* 275 */       return q.a(paramq, paramj, 
/* 276 */           e.a(clazz));
/*     */     } 
/* 278 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean a(j paramj) {
/* 288 */     if (!paramj.n() || paramj.g()) {
/* 289 */       return false;
/*     */     }
/*     */     Class<?> clazz;
/* 292 */     if (i.m(clazz = paramj.b()))
/*     */     {
/*     */       
/* 295 */       if (Collection.class.isAssignableFrom(clazz) || Map.class
/* 296 */         .isAssignableFrom(clazz)) {
/* 297 */         return true;
/*     */       }
/*     */     }
/* 300 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private q b(q<?> paramq, j paramj) {
/* 305 */     if (a(paramj)) {
/* 306 */       return q.a(paramq, paramj, 
/* 307 */           c(paramq, paramj, (t.a)paramq));
/*     */     }
/* 309 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static d c(q<?> paramq, j paramj, t.a parama) {
/* 317 */     return e.a(paramq, paramj, parama);
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\f\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */