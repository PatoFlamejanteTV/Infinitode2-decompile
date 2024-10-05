/*     */ package com.a.a.c.k.a;
/*     */ 
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.o;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class k
/*     */ {
/*     */   protected final boolean a;
/*     */   
/*     */   protected k(boolean paramBoolean) {
/*  36 */     this.a = paramBoolean;
/*     */   }
/*     */   
/*     */   protected k(k paramk) {
/*  40 */     this.a = paramk.a;
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
/*     */   public abstract o<Object> a(Class<?> paramClass);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(Class<?> paramClass, aa paramaa, com.a.a.c.c paramc) {
/*  64 */     o<Object> o = paramaa.b(paramClass, paramc);
/*  65 */     return new d(o, b(paramClass, o));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(j paramj, aa paramaa, com.a.a.c.c paramc) {
/*  72 */     o<Object> o = paramaa.b(paramj, paramc);
/*  73 */     return new d(o, b(paramj.b(), o));
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
/*     */   public final d b(Class<?> paramClass, aa paramaa, com.a.a.c.c paramc) {
/*  90 */     o<Object> o = paramaa.c(paramClass, paramc);
/*  91 */     return new d(o, b(paramClass, o));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d b(j paramj, aa paramaa, com.a.a.c.c paramc) {
/*  98 */     o<Object> o = paramaa.c(paramj, paramc);
/*  99 */     return new d(o, b(paramj.b(), o));
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
/*     */   public final d c(Class<?> paramClass, aa paramaa, com.a.a.c.c paramc) {
/* 144 */     o<Object> o = paramaa.d(paramClass, paramc);
/* 145 */     return new d(o, b(paramClass, o));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(Class<?> paramClass, o<Object> paramo) {
/* 155 */     return new d(paramo, b(paramClass, paramo));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d a(j paramj, o<Object> paramo) {
/* 162 */     return new d(paramo, b(paramj.b(), paramo));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract k b(Class<?> paramClass, o<Object> paramo);
/*     */ 
/*     */   
/*     */   public static k a() {
/* 171 */     return b.b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class d
/*     */   {
/*     */     public final o<Object> a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final k b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public d(o<Object> param1o, k param1k) {
/* 199 */       this.a = param1o;
/* 200 */       this.b = param1k;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static final class f
/*     */   {
/*     */     public final Class<?> a;
/*     */     
/*     */     public final o<Object> b;
/*     */ 
/*     */     
/*     */     public f(Class<?> param1Class, o<Object> param1o) {
/* 213 */       this.a = param1Class;
/* 214 */       this.b = param1o;
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
/*     */   static final class b
/*     */     extends k
/*     */   {
/* 231 */     public static final b b = new b(false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b(boolean param1Boolean) {
/* 237 */       super(param1Boolean);
/*     */     }
/*     */ 
/*     */     
/*     */     public final o<Object> a(Class<?> param1Class) {
/* 242 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final k b(Class<?> param1Class, o<Object> param1o) {
/* 247 */       return new k.e(this, param1Class, param1o);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static final class e
/*     */     extends k
/*     */   {
/*     */     private final Class<?> b;
/*     */ 
/*     */     
/*     */     private final o<Object> c;
/*     */ 
/*     */     
/*     */     public e(k param1k, Class<?> param1Class, o<Object> param1o) {
/* 263 */       super(param1k);
/* 264 */       this.b = param1Class;
/* 265 */       this.c = param1o;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final o<Object> a(Class<?> param1Class) {
/* 271 */       if (param1Class == this.b) {
/* 272 */         return this.c;
/*     */       }
/* 274 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public final k b(Class<?> param1Class, o<Object> param1o) {
/* 279 */       return new k.a(this, this.b, this.c, param1Class, param1o);
/*     */     }
/*     */   }
/*     */   
/*     */   static final class a
/*     */     extends k
/*     */   {
/*     */     private final Class<?> b;
/*     */     private final Class<?> c;
/*     */     private final o<Object> d;
/*     */     private final o<Object> e;
/*     */     
/*     */     public a(k param1k, Class<?> param1Class1, o<Object> param1o1, Class<?> param1Class2, o<Object> param1o2) {
/* 292 */       super(param1k);
/* 293 */       this.b = param1Class1;
/* 294 */       this.d = param1o1;
/* 295 */       this.c = param1Class2;
/* 296 */       this.e = param1o2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final o<Object> a(Class<?> param1Class) {
/* 302 */       if (param1Class == this.b) {
/* 303 */         return this.d;
/*     */       }
/* 305 */       if (param1Class == this.c) {
/* 306 */         return this.e;
/*     */       }
/* 308 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final k b(Class<?> param1Class, o<Object> param1o) {
/*     */       k.f[] arrayOfF;
/* 315 */       (arrayOfF = new k.f[3])[0] = new k.f(this.b, this.d);
/* 316 */       arrayOfF[1] = new k.f(this.c, this.e);
/* 317 */       arrayOfF[2] = new k.f(param1Class, param1o);
/* 318 */       return new k.c(this, arrayOfF);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class c
/*     */     extends k
/*     */   {
/*     */     private final k.f[] b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public c(k param1k, k.f[] param1ArrayOff) {
/* 337 */       super(param1k);
/* 338 */       this.b = param1ArrayOff;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final o<Object> a(Class<?> param1Class) {
/*     */       k.f f1;
/* 347 */       if ((f1 = this.b[0]).a == param1Class) return f1.b;
/*     */       
/* 349 */       if ((f1 = this.b[1]).a == param1Class) return f1.b;
/*     */       
/* 351 */       if ((f1 = this.b[2]).a == param1Class) return f1.b;
/*     */       
/* 353 */       switch (this.b.length) {
/*     */         
/*     */         case 8:
/* 356 */           if ((f1 = this.b[7]).a == param1Class) return f1.b;
/*     */         
/*     */         case 7:
/* 359 */           if ((f1 = this.b[6]).a == param1Class) return f1.b;
/*     */         
/*     */         case 6:
/* 362 */           if ((f1 = this.b[5]).a == param1Class) return f1.b;
/*     */         
/*     */         case 5:
/* 365 */           if ((f1 = this.b[4]).a == param1Class) return f1.b;
/*     */         
/*     */         case 4:
/* 368 */           if ((f1 = this.b[3]).a == param1Class) return f1.b; 
/*     */           break;
/*     */       } 
/* 371 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final k b(Class<?> param1Class, o<Object> param1o) {
/*     */       int i;
/* 380 */       if ((i = this.b.length) == 8) {
/* 381 */         if (this.a) {
/* 382 */           return new k.e(this, param1Class, param1o);
/*     */         }
/* 384 */         return this;
/*     */       } 
/*     */       k.f[] arrayOfF;
/* 387 */       (arrayOfF = Arrays.<k.f>copyOf(this.b, i + 1))[i] = new k.f(param1Class, param1o);
/* 388 */       return new c(this, arrayOfF);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\a\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */