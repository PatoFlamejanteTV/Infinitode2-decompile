/*     */ package com.a.a.c.k;
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.c.a.f;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.b;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.y;
/*     */ import com.a.a.c.z;
/*     */ 
/*     */ public final class m {
/*  18 */   private static final Object a = Boolean.FALSE;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private y b;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b c;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private a d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object e;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private s.b f;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m(y paramy, b paramb) {
/*  54 */     this.b = paramy;
/*  55 */     this.c = paramb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  66 */     s.b b1 = s.b.a(paramb
/*  67 */         .a(s.b.a()), paramy
/*  68 */         .a(paramb.b(), 
/*  69 */           s.b.a()));
/*  70 */     this.f = s.b.a(paramy.A(), b1);
/*     */     
/*  72 */     this.g = (b1.b() == s.a.e);
/*  73 */     this.d = this.b.j();
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
/*     */   protected final e a(aa paramaa, s params, j paramj, o<?> paramo, i parami1, i parami2, j paramj1, boolean paramBoolean) {
/*     */     j j1;
/*     */     z z;
/*     */     try {
/* 100 */       j1 = a((b)paramj1, paramBoolean, paramj);
/* 101 */     } catch (l l) {
/* 102 */       if (params == null) {
/* 103 */         return (e)paramaa.a(paramj, i.g((Throwable)l));
/*     */       }
/* 105 */       return (e)paramaa.a(this.c, params, i.g((Throwable)l), new Object[0]);
/*     */     } 
/*     */ 
/*     */     
/* 109 */     if (parami2 != null) {
/*     */ 
/*     */ 
/*     */       
/* 113 */       if (j1 == null)
/*     */       {
/* 115 */         j1 = paramj;
/*     */       }
/*     */       
/*     */       j j4;
/* 119 */       if ((j4 = j1.u()) == null) {
/* 120 */         paramaa.a(this.c, params, "serialization type " + j1 + " has no content", new Object[0]);
/*     */       }
/*     */ 
/*     */       
/* 124 */       (j1 = j1.b(parami2)).u();
/*     */     } 
/*     */     
/* 127 */     Object object2 = null;
/* 128 */     boolean bool = false;
/*     */ 
/*     */     
/* 131 */     j j2 = (j1 == null) ? paramj : j1;
/*     */     
/*     */     j j3;
/*     */     
/* 135 */     if ((j3 = params.s()) == null)
/*     */     {
/* 137 */       return (e)paramaa.a(this.c, params, "could not determine property type", new Object[0]);
/*     */     }
/*     */     
/* 140 */     Class clazz = j3.d();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     s.b b1;
/*     */ 
/*     */ 
/*     */     
/*     */     s.a a1;
/*     */ 
/*     */ 
/*     */     
/* 153 */     if ((a1 = (b1 = (b1 = this.b.a(j2.b(), clazz, this.f)).a(params.B())).b()) == s.a.g) {
/* 154 */       a1 = s.a.a;
/*     */     }
/* 156 */     switch (n.a[a1.ordinal()]) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/* 169 */         if (this.g && (object3 = a()) != null) {
/*     */           
/* 171 */           if (paramaa.a(q.n)) {
/* 172 */             paramj1.a(this.b.a(q.o));
/*     */           }
/*     */           try {
/* 175 */             object2 = paramj1.b(object3);
/* 176 */           } catch (Exception exception) {
/* 177 */             a((Exception)(a1 = null), params.a(), object3);
/*     */           } 
/*     */         } else {
/* 180 */           object2 = f.a(j2);
/* 181 */           bool = true;
/*     */         } 
/* 183 */         if (object2 == null) {
/* 184 */           bool = true; break;
/*     */         } 
/* 186 */         if (object2.getClass().isArray()) {
/* 187 */           object2 = c.a(object2);
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case 2:
/* 193 */         bool = true;
/*     */         
/* 195 */         if (j2.F()) {
/* 196 */           object2 = e.b;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 201 */         bool = true;
/*     */         
/* 203 */         object2 = e.b;
/*     */         break;
/*     */       case 4:
/* 206 */         object2 = paramaa.a(params, object3.d());
/*     */         break;
/*     */       case 5:
/* 209 */         bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       default:
/* 215 */         z = z.q;
/* 216 */         if (j2.n() && !this.b.a(z)) {
/* 217 */           object2 = e.b;
/*     */         }
/*     */         break;
/*     */     } 
/*     */     Object object3;
/* 222 */     if ((object3 = params.w()) == null) {
/* 223 */       object3 = this.c.y();
/*     */     }
/* 225 */     e e = a(params, paramj1, this.c
/* 226 */         .g(), paramj, paramo, parami1, j1, bool, object2, (Class<?>[])object3);
/*     */ 
/*     */     
/*     */     Object object1;
/*     */     
/* 231 */     if ((object1 = this.d.q((b)paramj1)) != null) {
/* 232 */       e.b(paramaa.b((b)paramj1, object1));
/*     */     }
/*     */     
/*     */     r r;
/* 236 */     if ((r = this.d.c(paramj1)) != null) {
/* 237 */       e = e.b(r);
/*     */     }
/* 239 */     return e;
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
/*     */   private static e a(s params, j paramj, b paramb, j paramj1, o<?> paramo, i parami, j paramj2, boolean paramBoolean, Object paramObject, Class<?>[] paramArrayOfClass) {
/* 256 */     return new e(params, paramj, paramb, paramj1, paramo, parami, paramj2, paramBoolean, paramObject, paramArrayOfClass);
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
/*     */   private j a(b paramb, boolean paramBoolean, j paramj) {
/*     */     j j1;
/* 280 */     if ((j1 = this.d.a((q)this.b, paramb, paramj)) != paramj) {
/* 281 */       Class<?> clazz2 = j1.b();
/*     */       
/* 283 */       Class<?> clazz1 = paramj.b();
/* 284 */       if (!clazz2.isAssignableFrom(clazz1))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 293 */         if (!clazz1.isAssignableFrom(clazz2)) {
/* 294 */           throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + paramb.b() + "': class " + clazz2.getName() + " not a super-type of (declared) class " + clazz1.getName());
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 301 */       boolean bool = true;
/* 302 */       paramj = j1;
/*     */     } 
/*     */     
/*     */     f.b b1;
/* 306 */     if ((b1 = this.d.r(paramb)) != null && b1 != f.b.c) {
/* 307 */       paramBoolean = (b1 == f.b.b);
/*     */     }
/* 309 */     if (paramBoolean)
/*     */     {
/* 311 */       return paramj.a();
/*     */     }
/*     */     
/* 314 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object a() {
/*     */     Object object;
/* 326 */     if ((object = this.e) == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 331 */       if ((object = this.c.a(this.b.g())) == null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 339 */         object = a;
/*     */       }
/* 341 */       this.e = object;
/*     */     } 
/* 343 */     return (object == a) ? null : this.e;
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
/*     */   private static Object a(Exception paramException, String paramString, Object paramObject) {
/*     */     Throwable throwable;
/* 392 */     paramException = paramException;
/* 393 */     while (paramException.getCause() != null) {
/* 394 */       throwable = paramException.getCause();
/*     */     }
/* 396 */     i.a(throwable);
/* 397 */     i.b(throwable);
/* 398 */     throw new IllegalArgumentException("Failed to get property '" + paramString + "' of default " + paramObject.getClass().getName() + " instance");
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */