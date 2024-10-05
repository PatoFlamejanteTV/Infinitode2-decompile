/*     */ package com.a.a.c.k;
/*     */ 
/*     */ import com.a.a.a.s;
/*     */ import com.a.a.b.c.k;
/*     */ import com.a.a.b.h;
/*     */ import com.a.a.b.r;
/*     */ import com.a.a.c.a.a;
/*     */ import com.a.a.c.aa;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.i.i;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k.a.k;
/*     */ import com.a.a.c.k.a.t;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.m.r;
/*     */ import com.a.a.c.o;
/*     */ import com.a.a.c.q;
/*     */ import com.a.a.c.v;
/*     */ import com.a.a.c.w;
/*     */ import com.a.a.c.y;
/*     */ import com.a.a.c.z;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public class e
/*     */   extends p
/*     */   implements Serializable
/*     */ {
/*  49 */   public static final Object b = s.a.d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final k c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected j d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient b m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private j n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Method o;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient Field p;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected o<Object> e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected o<Object> f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected i g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected transient k h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean q;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Object i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?>[] r;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient HashMap<Object, Object> s;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(s params, j paramj, b paramb, j paramj1, o<?> paramo, i parami, j paramj2, boolean paramBoolean, Object paramObject, Class<?>[] paramArrayOfClass) {
/* 217 */     super(params);
/* 218 */     this.n = paramj;
/* 219 */     this.m = paramb;
/*     */     
/* 221 */     this.c = new k(params.a());
/* 222 */     this.j = params.c();
/*     */     
/* 224 */     this.k = paramj1;
/* 225 */     this.e = (o)paramo;
/* 226 */     this
/* 227 */       .h = (paramo == null) ? k.a() : null;
/* 228 */     this.g = parami;
/* 229 */     this.l = paramj2;
/*     */     
/* 231 */     if (paramj instanceof com.a.a.c.f.h) {
/* 232 */       this.o = null;
/* 233 */       this.p = (Field)paramj.i();
/* 234 */     } else if (paramj instanceof com.a.a.c.f.k) {
/* 235 */       this.o = (Method)paramj.i();
/* 236 */       this.p = null;
/*     */     }
/*     */     else {
/*     */       
/* 240 */       this.o = null;
/* 241 */       this.p = null;
/*     */     } 
/* 243 */     this.q = paramBoolean;
/* 244 */     this.i = paramObject;
/*     */ 
/*     */     
/* 247 */     this.f = null;
/* 248 */     this.r = paramArrayOfClass;
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
/*     */   protected e() {
/* 271 */     super(v.c);
/* 272 */     this.n = null;
/* 273 */     this.m = null;
/*     */     
/* 275 */     this.c = null;
/* 276 */     this.j = null;
/* 277 */     this.r = null;
/*     */     
/* 279 */     this.k = null;
/* 280 */     this.e = null;
/* 281 */     this.h = null;
/* 282 */     this.g = null;
/* 283 */     this.l = null;
/*     */     
/* 285 */     this.o = null;
/* 286 */     this.p = null;
/* 287 */     this.q = false;
/* 288 */     this.i = null;
/*     */     
/* 290 */     this.f = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected e(e parame) {
/* 297 */     this(parame, parame.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e(e parame, w paramw) {
/* 304 */     super(parame);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 311 */     this.c = new k(paramw.b());
/* 312 */     this.j = parame.j;
/*     */     
/* 314 */     this.m = parame.m;
/* 315 */     this.k = parame.k;
/*     */     
/* 317 */     this.n = parame.n;
/* 318 */     this.o = parame.o;
/* 319 */     this.p = parame.p;
/*     */     
/* 321 */     this.e = parame.e;
/* 322 */     this.f = parame.f;
/*     */     
/* 324 */     if (parame.s != null) {
/* 325 */       this.s = new HashMap<>(parame.s);
/*     */     }
/*     */     
/* 328 */     this.l = parame.l;
/* 329 */     this.h = parame.h;
/* 330 */     this.q = parame.q;
/* 331 */     this.i = parame.i;
/* 332 */     this.r = parame.r;
/* 333 */     this.g = parame.g;
/* 334 */     this.d = parame.d;
/*     */   }
/*     */   
/*     */   protected e(e parame, k paramk) {
/* 338 */     super(parame);
/* 339 */     this.c = paramk;
/* 340 */     this.j = parame.j;
/*     */     
/* 342 */     this.n = parame.n;
/* 343 */     this.m = parame.m;
/* 344 */     this.k = parame.k;
/* 345 */     this.o = parame.o;
/* 346 */     this.p = parame.p;
/* 347 */     this.e = parame.e;
/* 348 */     this.f = parame.f;
/* 349 */     if (parame.s != null) {
/* 350 */       this.s = new HashMap<>(parame.s);
/*     */     }
/*     */     
/* 353 */     this.l = parame.l;
/* 354 */     this.h = parame.h;
/* 355 */     this.q = parame.q;
/* 356 */     this.i = parame.i;
/* 357 */     this.r = parame.r;
/* 358 */     this.g = parame.g;
/* 359 */     this.d = parame.d;
/*     */   }
/*     */   
/*     */   public e a(r paramr) {
/*     */     String str;
/* 364 */     if ((str = paramr.a(this.c.a())).equals(this.c.toString())) {
/* 365 */       return this;
/*     */     }
/* 367 */     return b(w.a(str));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e b(w paramw) {
/* 376 */     return new e(this, paramw);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(i parami) {
/* 386 */     this.g = parami;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(o<Object> paramo) {
/* 394 */     if (this.e != null && this.e != paramo)
/* 395 */       throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", new Object[] {
/*     */               
/* 397 */               i.d(this.e), i.d(paramo)
/*     */             })); 
/* 399 */     this.e = paramo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(o<Object> paramo) {
/* 407 */     if (this.f != null && this.f != paramo)
/* 408 */       throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", new Object[] {
/*     */               
/* 410 */               i.d(this.f), i.d(paramo)
/*     */             })); 
/* 412 */     this.f = paramo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final e b(r paramr) {
/* 420 */     return (e)new t(this, paramr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(j paramj) {
/* 429 */     this.d = paramj;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(y paramy) {
/* 440 */     this.n.a(paramy.a(q.o));
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
/*     */   public final String a() {
/* 477 */     return this.c.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final w b() {
/* 483 */     return new w(this.c.a());
/*     */   }
/*     */ 
/*     */   
/*     */   public final j c() {
/* 488 */     return this.k;
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
/*     */   public final j e() {
/* 511 */     return this.n;
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
/*     */   public final boolean f() {
/* 576 */     return (this.e != null);
/*     */   }
/*     */   
/*     */   public final boolean g() {
/* 580 */     return (this.f != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final i h() {
/* 587 */     return this.g;
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
/*     */   public final boolean i() {
/* 605 */     return this.q;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean a(w paramw) {
/* 615 */     if (this.j != null) {
/* 616 */       return this.j.equals(paramw);
/*     */     }
/*     */     
/* 619 */     return (paramw.c(this.c.a()) && !paramw.d());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j j() {
/* 628 */     return this.l;
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
/*     */   public final Class<?>[] k() {
/* 670 */     return this.r;
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
/*     */   public void a(Object paramObject, h paramh, aa paramaa) {
/*     */     Object object;
/* 692 */     if ((object = (this.o == null) ? this.p.get(paramObject) : this.o.invoke(paramObject, (Object[])null)) == null) {
/*     */       
/* 694 */       if (this.i != null && paramaa
/* 695 */         .b(this.i)) {
/*     */         return;
/*     */       }
/* 698 */       if (this.f != null) {
/* 699 */         paramh.b((r)this.c);
/* 700 */         this.f.a(null, paramh, paramaa);
/*     */       } 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 707 */     Class<?> clazz = object.getClass();
/*     */     o<Object> o1;
/*     */     k k1;
/* 710 */     if ((o1 = this.e) == null && (o1 = (k1 = this.h).a(clazz)) == null) {
/* 711 */       o1 = a(k1, clazz, paramaa);
/*     */     }
/*     */ 
/*     */     
/* 715 */     if (this.i != null) {
/* 716 */       if (b == this.i) {
/* 717 */         if (o1.a(paramaa, object)) {
/*     */           return;
/*     */         }
/* 720 */       } else if (this.i.equals(object)) {
/*     */         return;
/*     */       } 
/*     */     }
/*     */     
/* 725 */     if (object == paramObject)
/*     */     {
/* 727 */       if (a(paramh, paramaa, o1)) {
/*     */         return;
/*     */       }
/*     */     }
/* 731 */     paramh.b((r)this.c);
/* 732 */     if (this.g == null) {
/* 733 */       o1.a(object, paramh, paramaa); return;
/*     */     } 
/* 735 */     o1.a(object, paramh, paramaa, this.g);
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
/*     */   public final void a(h paramh) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b(Object paramObject, h paramh, aa paramaa) {
/*     */     Object object;
/* 767 */     if ((object = (this.o == null) ? this.p.get(paramObject) : this.o.invoke(paramObject, (Object[])null)) == null) {
/* 768 */       if (this.f != null) {
/* 769 */         this.f.a(null, paramh, paramaa); return;
/*     */       } 
/* 771 */       paramh.k();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 778 */     Class<?> clazz = object.getClass();
/*     */     o<Object> o1;
/*     */     k k1;
/* 781 */     if ((o1 = this.e) == null && (o1 = (k1 = this.h).a(clazz)) == null) {
/* 782 */       o1 = a(k1, clazz, paramaa);
/*     */     }
/*     */ 
/*     */     
/* 786 */     if (this.i != null) {
/* 787 */       if (b == this.i) {
/* 788 */         if (o1.a(paramaa, object)) {
/*     */           
/* 790 */           a(paramh, paramaa);
/*     */           return;
/*     */         } 
/* 793 */       } else if (this.i.equals(object)) {
/*     */         
/* 795 */         a(paramh, paramaa);
/*     */         
/*     */         return;
/*     */       } 
/*     */     }
/* 800 */     if (object == paramObject && 
/* 801 */       a(paramh, paramaa, o1)) {
/*     */       return;
/*     */     }
/*     */     
/* 805 */     if (this.g == null) {
/* 806 */       o1.a(object, paramh, paramaa); return;
/*     */     } 
/* 808 */     o1.a(object, paramh, paramaa, this.g);
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
/*     */   public final void a(h paramh, aa paramaa) {
/* 823 */     if (this.f != null) {
/* 824 */       this.f.a(null, paramh, paramaa); return;
/*     */     } 
/* 826 */     paramh.k();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected o<Object> a(k paramk, Class<?> paramClass, aa paramaa) {
/*     */     k.d d;
/* 897 */     if (this.d != null) {
/* 898 */       j j1 = paramaa.a(this.d, paramClass);
/*     */       
/* 900 */       d = paramk.a(j1, paramaa, (c)this);
/*     */     } else {
/* 902 */       d = paramk.a((Class)d, paramaa, (c)this);
/*     */     } 
/*     */     
/* 905 */     if (paramk != d.b) {
/* 906 */       this.h = d.b;
/*     */     }
/* 908 */     return d.a;
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
/*     */   public final Object a(Object paramObject) {
/* 920 */     return (this.o == null) ? this.p.get(paramObject) : this.o
/* 921 */       .invoke(paramObject, (Object[])null);
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
/*     */   protected final boolean a(h paramh, aa paramaa, o<?> paramo) {
/* 942 */     if (!paramo.b()) {
/* 943 */       if (paramaa.a(z.d)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 948 */         if (paramo instanceof com.a.a.c.k.b.d) {
/* 949 */           paramaa.a(c(), "Direct self-reference leading to cycle");
/*     */         }
/* 951 */       } else if (paramaa.a(z.g)) {
/* 952 */         if (this.f != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 958 */           if (!paramh.a().b()) {
/* 959 */             paramh.b((r)this.c);
/*     */           }
/* 961 */           this.f.a(null, paramh, paramaa);
/*     */         } 
/* 963 */         return true;
/*     */       } 
/*     */     }
/* 966 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*     */     StringBuilder stringBuilder;
/* 972 */     (stringBuilder = new StringBuilder(40)).append("property '").append(a()).append("' (");
/* 973 */     if (this.o != null) {
/* 974 */       stringBuilder.append("via method ")
/* 975 */         .append(this.o.getDeclaringClass().getName())
/* 976 */         .append("#").append(this.o.getName());
/* 977 */     } else if (this.p != null) {
/* 978 */       stringBuilder.append("field \"").append(this.p.getDeclaringClass().getName())
/* 979 */         .append("#").append(this.p.getName());
/*     */     } else {
/* 981 */       stringBuilder.append("virtual");
/*     */     } 
/* 983 */     if (this.e == null) {
/* 984 */       stringBuilder.append(", no static serializer");
/*     */     } else {
/* 986 */       stringBuilder.append(", static serializer of type " + this.e
/* 987 */           .getClass().getName());
/*     */     } 
/* 989 */     stringBuilder.append(')');
/* 990 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\k\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */