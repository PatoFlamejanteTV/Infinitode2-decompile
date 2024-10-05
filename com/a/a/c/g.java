/*      */ package com.a.a.c;
/*      */ 
/*      */ import com.a.a.a.al;
/*      */ import com.a.a.a.an;
/*      */ import com.a.a.a.l;
/*      */ import com.a.a.b.a;
/*      */ import com.a.a.b.g.h;
/*      */ import com.a.a.b.g.i;
/*      */ import com.a.a.b.l;
/*      */ import com.a.a.b.o;
/*      */ import com.a.a.b.s;
/*      */ import com.a.a.c.b.b;
/*      */ import com.a.a.c.b.f;
/*      */ import com.a.a.c.b.k;
/*      */ import com.a.a.c.b.q;
/*      */ import com.a.a.c.c.a.ab;
/*      */ import com.a.a.c.c.a.s;
/*      */ import com.a.a.c.c.a.z;
/*      */ import com.a.a.c.c.k;
/*      */ import com.a.a.c.c.l;
/*      */ import com.a.a.c.c.o;
/*      */ import com.a.a.c.c.p;
/*      */ import com.a.a.c.c.q;
/*      */ import com.a.a.c.c.x;
/*      */ import com.a.a.c.d.b;
/*      */ import com.a.a.c.d.c;
/*      */ import com.a.a.c.d.e;
/*      */ import com.a.a.c.d.f;
/*      */ import com.a.a.c.d.h;
/*      */ import com.a.a.c.d.i;
/*      */ import com.a.a.c.f.b;
/*      */ import com.a.a.c.f.j;
/*      */ import com.a.a.c.f.s;
/*      */ import com.a.a.c.i.e;
/*      */ import com.a.a.c.i.g;
/*      */ import com.a.a.c.j.l;
/*      */ import com.a.a.c.k.a.d;
/*      */ import com.a.a.c.l.f;
/*      */ import com.a.a.c.l.o;
/*      */ import com.a.a.c.m.ac;
/*      */ import com.a.a.c.m.c;
/*      */ import com.a.a.c.m.f;
/*      */ import com.a.a.c.m.i;
/*      */ import com.a.a.c.m.p;
/*      */ import com.a.a.c.m.v;
/*      */ import java.io.Serializable;
/*      */ import java.text.DateFormat;
/*      */ import java.text.ParseException;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.Date;
/*      */ import java.util.Locale;
/*      */ import java.util.TimeZone;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class g
/*      */   extends d
/*      */   implements Serializable
/*      */ {
/*      */   private p b;
/*      */   private q c;
/*      */   protected final f a;
/*      */   private int d;
/*      */   private i<s> e;
/*      */   private Class<?> f;
/*      */   private transient l g;
/*      */   private d h;
/*      */   private transient c i;
/*      */   private transient f j;
/*      */   private transient DateFormat k;
/*      */   private p<j> l;
/*      */   
/*      */   protected g(q paramq, p paramp) {
/*  170 */     if (paramq == null) {
/*  171 */       throw new NullPointerException("Cannot pass null DeserializerFactory");
/*      */     }
/*  173 */     this.c = paramq;
/*  174 */     if (paramp == null) {
/*  175 */       paramp = new p();
/*      */     }
/*  177 */     this.b = paramp;
/*  178 */     this.d = 0;
/*  179 */     this.e = null;
/*  180 */     this.a = null;
/*  181 */     this.h = null;
/*  182 */     this.f = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected g(g paramg, f paramf, l paraml, d paramd) {
/*  208 */     this.b = paramg.b;
/*  209 */     this.c = paramg.c;
/*      */ 
/*      */ 
/*      */     
/*  213 */     this.e = (paraml == null) ? null : paraml.c();
/*      */     
/*  215 */     this.a = paramf;
/*  216 */     this.d = paramf.b();
/*  217 */     this.f = paramf.y();
/*  218 */     this.g = paraml;
/*  219 */     this.h = paramd;
/*  220 */     paramf.z();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected g(g paramg, f paramf) {
/*  232 */     this.b = paramg.b;
/*  233 */     this.c = paramg.c;
/*  234 */     this.e = null;
/*      */     
/*  236 */     this.a = paramf;
/*  237 */     this.d = paramf.b();
/*  238 */     this.f = null;
/*  239 */     this.g = null;
/*  240 */     this.h = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final f c() {
/*  265 */     return this.a;
/*      */   }
/*      */   public final Class<?> d() {
/*  268 */     return this.f;
/*      */   }
/*      */   
/*      */   public final boolean e() {
/*  272 */     return this.a.g();
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean a(q paramq) {
/*  277 */     return this.a.a(paramq);
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean a(k paramk) {
/*  282 */     return this.a.a(paramk);
/*      */   }
/*      */ 
/*      */   
/*      */   public final l.d a(Class<?> paramClass) {
/*  287 */     return this.a.f(paramClass);
/*      */   }
/*      */ 
/*      */   
/*      */   public final a f() {
/*  292 */     return this.a.j();
/*      */   }
/*      */ 
/*      */   
/*      */   public final o b() {
/*  297 */     return this.a.p();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j a(j paramj, Class<?> paramClass) {
/*  304 */     if (paramj.a(paramClass)) {
/*  305 */       return paramj;
/*      */     }
/*      */ 
/*      */     
/*  309 */     return c().p().a(paramj, paramClass, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Locale g() {
/*  320 */     return this.a.t();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final TimeZone h() {
/*  331 */     return this.a.u();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(i parami) {
/*  390 */     return ((this.d & parami.b()) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(s params) {
/*  402 */     return this.e.b((h)params);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final int i() {
/*  412 */     return this.d;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(int paramInt) {
/*  432 */     return ((this.d & paramInt) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l j() {
/*  443 */     return this.g;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Object paramObject1, c paramc, Object paramObject2) {
/*  449 */     if (this.h == null) {
/*  450 */       return a(i.a(paramObject1), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", new Object[] { paramObject1 }));
/*      */     }
/*      */     
/*  453 */     return this.h.c();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final a k() {
/*  465 */     return this.a.v();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l l() {
/*  475 */     return this.a.d();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final b a(f paramf, Class<?> paramClass, f paramf1) {
/*  499 */     return this.a.a(paramf, paramClass, paramf1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final b a(f paramf, Class<?> paramClass, b paramb) {
/*  522 */     return this.a.a(paramf, paramClass, paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ac a(l paraml) {
/*  541 */     return new ac(paraml, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ac m() {
/*  551 */     return a(j());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final ac b(l paraml) {
/*      */     ac ac;
/*  571 */     (ac = a(paraml)).b(paraml);
/*  572 */     return ac;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<Object> a(j paramj, c paramc) {
/*      */     k<?> k;
/*  616 */     if ((k = this.b.a(this, this.c, paramj)) != null) {
/*  617 */       k = b(k, paramc, paramj);
/*      */     }
/*  619 */     return (k)k;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<Object> a(j paramj) {
/*  638 */     return this.b.a(this, this.c, paramj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<Object> b(j paramj) {
/*      */     k<?> k;
/*  650 */     if ((k = this.b.a(this, this.c, paramj)) == null) {
/*  651 */       return null;
/*      */     }
/*  653 */     k = b(k, (c)null, paramj);
/*      */     e e;
/*  655 */     if ((e = this.c.b(this.a, paramj)) != null) {
/*      */       
/*  657 */       e = e.a(null);
/*  658 */       return (k<Object>)new ab(e, k);
/*      */     } 
/*  660 */     return (k)k;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final p b(j paramj, c paramc) {
/*      */     p p1;
/*      */     try {
/*  675 */       p1 = this.b.b(this, this.c, paramj);
/*  676 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */       
/*  679 */       a(paramj, i.g(illegalArgumentException));
/*  680 */       illegalArgumentException = null;
/*      */     } 
/*      */     
/*  683 */     if (illegalArgumentException instanceof l) {
/*  684 */       p1 = ((l)illegalArgumentException).a();
/*      */     }
/*  686 */     return p1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j b(Class<?> paramClass) {
/*  723 */     return (paramClass == null) ? null : this.a.b(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Class<?> b(String paramString) {
/*  737 */     return b().a(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final f n() {
/*      */     f f1;
/*  755 */     if ((f1 = this.j) == null) {
/*  756 */       f1 = new f();
/*      */     } else {
/*  758 */       this.j = null;
/*      */     } 
/*  760 */     return f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(f paramf) {
/*  773 */     if (this.j == null || paramf
/*  774 */       .b() >= this.j.b()) {
/*  775 */       this.j = paramf;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final c o() {
/*  785 */     if (this.i == null) {
/*  786 */       this.i = new c();
/*      */     }
/*  788 */     return this.i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<?> a(k<?> paramk, c paramc, j paramj) {
/*  827 */     if (paramk instanceof k) {
/*  828 */       this.l = new p(paramj, this.l);
/*      */       try {
/*  830 */         paramk = ((k)paramk).a(this, paramc);
/*      */       } finally {
/*  832 */         this.l = this.l.a();
/*      */       } 
/*      */     } 
/*  835 */     return paramk;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final k<?> b(k<?> paramk, c paramc, j paramj) {
/*  858 */     if (paramk instanceof k) {
/*  859 */       this.l = new p(paramj, this.l);
/*      */       try {
/*  861 */         paramk = ((k)paramk).a(this, paramc);
/*      */       } finally {
/*  863 */         this.l = this.l.a();
/*      */       } 
/*      */     } 
/*  866 */     return paramk;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Date c(String paramString) {
/*      */     try {
/*      */       DateFormat dateFormat;
/*  889 */       return (dateFormat = p()).parse(paramString);
/*  890 */     } catch (ParseException parseException) {
/*  891 */       throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", new Object[] { paramString, 
/*      */               
/*  893 */               i.g(parseException) }));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Calendar a(Date paramDate) {
/*      */     Calendar calendar;
/*  904 */     (calendar = Calendar.getInstance(h())).setTime(paramDate);
/*  905 */     return calendar;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final String a(l paraml, Class<?> paramClass) {
/*  937 */     return (String)a(paramClass, paraml);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T b(l paraml, Class<T> paramClass) {
/*  958 */     return a(paraml, b().a(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private <T> T a(l paraml, j paramj) {
/*      */     k<Object> k;
/*  967 */     if ((k = b(paramj)) == null) {
/*  968 */       return a(paramj, "Could not find JsonDeserializer for type " + 
/*  969 */           i.b(paramj));
/*      */     }
/*  971 */     return (T)k.a(paraml, this);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final boolean a(l paraml, k<?> paramk, Object paramObject, String paramString) {
/* 1117 */     p<o> p1 = this.a.c();
/* 1118 */     while (p1 != null) {
/*      */       
/* 1120 */       p1.b();
/*      */ 
/*      */       
/* 1123 */       p1 = p1.a();
/*      */     } 
/*      */     
/* 1126 */     if (!a(i.e)) {
/* 1127 */       paraml.j();
/* 1128 */       return true;
/*      */     } 
/*      */     
/* 1131 */     Collection collection = paramk.d();
/* 1132 */     throw h.a(this.g, paramObject, paramString, collection);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Class<?> paramClass, String paramString1, String paramString2, Object... paramVarArgs) {
/* 1160 */     paramString2 = a(paramString2, paramVarArgs);
/* 1161 */     p<o> p1 = this.a.c();
/* 1162 */     while (p1 != null) {
/*      */       
/* 1164 */       p1.b(); Object object;
/* 1165 */       if ((object = o.a()) != o.a) {
/*      */         
/* 1167 */         if (object == null || paramClass.isInstance(object)) {
/* 1168 */           return object;
/*      */         }
/* 1170 */         throw a(paramString1, paramClass, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1172 */                 i.c(paramClass), 
/* 1173 */                 i.c(object)
/*      */               }));
/*      */       } 
/* 1176 */       p1 = p1.a();
/*      */     } 
/* 1178 */     throw a(paramClass, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object b(Class<?> paramClass, String paramString1, String paramString2, Object... paramVarArgs) {
/* 1206 */     paramString2 = a(paramString2, paramVarArgs);
/* 1207 */     p<o> p1 = this.a.c();
/* 1208 */     while (p1 != null) {
/*      */       
/* 1210 */       p1.b(); Object object;
/* 1211 */       if ((object = o.b()) != o.a) {
/*      */         
/* 1213 */         if (a(paramClass, object)) {
/* 1214 */           return object;
/*      */         }
/* 1216 */         throw a(paramString1, paramClass, String.format("DeserializationProblemHandler.handleWeirdStringValue() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1218 */                 i.c(paramClass), 
/* 1219 */                 i.c(object)
/*      */               }));
/*      */       } 
/* 1222 */       p1 = p1.a();
/*      */     } 
/* 1224 */     throw a(paramString1, paramClass, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Class<?> paramClass, Number paramNumber, String paramString, Object... paramVarArgs) {
/* 1251 */     paramString = a(paramString, paramVarArgs);
/* 1252 */     p<o> p1 = this.a.c();
/* 1253 */     while (p1 != null) {
/*      */       
/* 1255 */       p1.b(); Object object;
/* 1256 */       if ((object = o.c()) != o.a) {
/*      */         
/* 1258 */         if (a(paramClass, object)) {
/* 1259 */           return object;
/*      */         }
/* 1261 */         throw a(paramNumber, paramClass, a("DeserializationProblemHandler.handleWeirdNumberValue() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1263 */                 i.c(paramClass), 
/* 1264 */                 i.c(object)
/*      */               }));
/*      */       } 
/* 1267 */       p1 = p1.a();
/*      */     } 
/* 1269 */     throw a(paramNumber, paramClass, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(j paramj, Object paramObject, l paraml) {
/* 1276 */     p<o> p1 = this.a.c();
/* 1277 */     Class<?> clazz = paramj.b();
/* 1278 */     for (; p1 != null; p1 = p1.a()) {
/*      */       
/* 1280 */       p1.b(); Object object;
/* 1281 */       if ((object = o.d()) != o.a) {
/*      */         
/* 1283 */         if (object == null || clazz.isInstance(object)) {
/* 1284 */           return object;
/*      */         }
/* 1286 */         throw l.a(paraml, a("DeserializationProblemHandler.handleWeirdNativeValue() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1288 */                 i.c(paramj), 
/* 1289 */                 i.c(object)
/*      */               }));
/*      */       } 
/*      */     } 
/* 1293 */     throw a(paramObject, clazz);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Class<?> paramClass, x paramx, l paraml, String paramString, Object... paramVarArgs) {
/* 1318 */     if (paraml == null) {
/* 1319 */       paraml = j();
/*      */     }
/* 1321 */     paramString = a(paramString, paramVarArgs);
/* 1322 */     p<o> p1 = this.a.c();
/* 1323 */     while (p1 != null) {
/*      */       Object object;
/*      */ 
/*      */       
/* 1327 */       if ((object = ((o)p1.b()).a(this, paramClass, paraml, paramString)) != o.a) {
/*      */         
/* 1329 */         if (a(paramClass, object)) {
/* 1330 */           return object;
/*      */         }
/* 1332 */         a(b(paramClass), String.format("DeserializationProblemHandler.handleMissingInstantiator() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1334 */                 i.c(paramClass), 
/* 1335 */                 i.c(object)
/*      */               }));
/*      */       } 
/* 1338 */       p1 = p1.a();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1346 */     if (paramx == null) {
/* 1347 */       paramString = String.format("Cannot construct instance of %s: %s", new Object[] {
/* 1348 */             i.g(paramClass), paramString });
/* 1349 */       return a(paramClass, paramString);
/*      */     } 
/* 1351 */     if (!paramx.d()) {
/* 1352 */       paramString = String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", new Object[] {
/* 1353 */             i.g(paramClass), paramString });
/* 1354 */       return a(paramClass, paramString);
/*      */     } 
/* 1356 */     paramString = String.format("Cannot construct instance of %s (although at least one Creator exists): %s", new Object[] {
/* 1357 */           i.g(paramClass), paramString });
/* 1358 */     return a(paramClass, paramString, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Class<?> paramClass, Object<o> paramObject, Throwable paramThrowable) {
/* 1382 */     paramObject = (Object<o>)this.a.c();
/* 1383 */     while (paramObject != null) {
/*      */       
/* 1385 */       paramObject.b(); Object object;
/* 1386 */       if ((object = o.e()) != o.a) {
/*      */         
/* 1388 */         if (a(paramClass, object)) {
/* 1389 */           return object;
/*      */         }
/* 1391 */         a(b(paramClass), String.format("DeserializationProblemHandler.handleInstantiationProblem() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1393 */                 i.c(paramClass), 
/* 1394 */                 i.d(object)
/*      */               }));
/*      */       } 
/* 1397 */       p p1 = paramObject.a();
/*      */     } 
/*      */     
/* 1400 */     i.c(paramThrowable);
/*      */     
/* 1402 */     if (!a(i.o)) {
/* 1403 */       i.b(paramThrowable);
/*      */     }
/* 1405 */     throw a(paramClass, paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Class<?> paramClass, l paraml) {
/* 1425 */     return a(b(paramClass), paraml.k(), paraml, (String)null, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(Class<?> paramClass, o paramo, l paraml, String paramString, Object... paramVarArgs) {
/* 1447 */     return a(b(paramClass), paramo, paraml, paramString, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(j paramj, l paraml) {
/* 1467 */     return a(paramj, paraml.k(), paraml, (String)null, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Object a(j paramj, o paramo, l paraml, String paramString, Object... paramVarArgs) {
/* 1489 */     paramString = a(paramString, paramVarArgs);
/* 1490 */     p<o> p1 = this.a.c();
/* 1491 */     while (p1 != null) {
/*      */       Object object;
/*      */       
/* 1494 */       if ((object = ((o)p1.b()).a(this, paramj, paramo, paraml, paramString)) != o.a) {
/* 1495 */         if (a(paramj.b(), object)) {
/* 1496 */           return object;
/*      */         }
/* 1498 */         a(paramj, String.format("DeserializationProblemHandler.handleUnexpectedToken() for type %s returned value of type %s", new Object[] {
/*      */                 
/* 1500 */                 i.b(paramj), 
/* 1501 */                 i.d(object)
/*      */               }));
/*      */       } 
/* 1504 */       p1 = p1.a();
/*      */     } 
/* 1506 */     if (paramString == null) {
/* 1507 */       String str = i.b(paramj);
/* 1508 */       if (paramo == null) {
/* 1509 */         paramString = String.format("Unexpected end-of-input when trying read value of type %s", new Object[] { str });
/*      */       } else {
/*      */         
/* 1512 */         paramString = String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", new Object[] { str, 
/* 1513 */               a(paramo), paramo });
/*      */       } 
/*      */     } 
/*      */     
/* 1517 */     if (paramo != null && paramo.g()) {
/* 1518 */       paraml.w();
/*      */     }
/* 1520 */     a(paramj, paramString, new Object[0]);
/* 1521 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j a(j paramj, String paramString1, g paramg, String paramString2) {
/* 1547 */     p<o> p1 = this.a.c();
/* 1548 */     while (p1 != null) {
/*      */       
/* 1550 */       p1.b(); j j1;
/* 1551 */       if ((j1 = o.f()) != null) {
/* 1552 */         if (j1.a(Void.class)) {
/* 1553 */           return null;
/*      */         }
/*      */         
/* 1556 */         if (j1.b(paramj.b())) {
/* 1557 */           return j1;
/*      */         }
/* 1559 */         throw a(paramj, paramString1, "problem handler tried to resolve into non-subtype: " + 
/*      */             
/* 1561 */             i.b(j1));
/*      */       } 
/* 1563 */       p1 = p1.a();
/*      */     } 
/*      */     
/* 1566 */     if (!a(i.h)) {
/* 1567 */       return null;
/*      */     }
/* 1569 */     throw a(paramj, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final j a(j paramj, g paramg, String paramString) {
/* 1578 */     p<o> p1 = this.a.c();
/* 1579 */     while (p1 != null) {
/*      */       
/* 1581 */       p1.b(); j j1;
/* 1582 */       if ((j1 = o.g()) != null) {
/* 1583 */         if (j1.a(Void.class)) {
/* 1584 */           return null;
/*      */         }
/*      */         
/* 1587 */         if (j1.b(paramj.b())) {
/* 1588 */           return j1;
/*      */         }
/* 1590 */         throw a(paramj, null, "problem handler tried to resolve into non-subtype: " + 
/*      */             
/* 1592 */             i.b(j1));
/*      */       } 
/* 1594 */       p1 = p1.a();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1601 */     throw b(paramj, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(k<?> paramk) {
/* 1617 */     if (!a(q.D)) {
/* 1618 */       j j = b(paramk.a());
/* 1619 */       String str = String.format("Invalid configuration: values of type %s cannot be merged", new Object[] {
/* 1620 */             i.b(j) });
/* 1621 */       throw b.a(j(), str, j);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean a(Class<?> paramClass, Object paramObject) {
/* 1630 */     if (paramObject == null || paramClass.isInstance(paramObject)) {
/* 1631 */       return true;
/*      */     }
/*      */     
/* 1634 */     if (paramClass.isPrimitive() && 
/* 1635 */       i.i(paramClass).isInstance(paramObject)) return true;
/*      */     
/*      */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(k<?> paramk, o paramo, String paramString, Object... paramVarArgs) {
/* 1659 */     paramString = a(paramString, paramVarArgs);
/* 1660 */     throw a(j(), paramk.a(), paramo, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(j paramj, o paramo, String paramString, Object... paramVarArgs) {
/* 1677 */     paramString = a(paramString, paramVarArgs);
/* 1678 */     throw a(j(), paramj, paramo, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final void a(Class<?> paramClass, o paramo, String paramString, Object... paramVarArgs) {
/* 1695 */     paramString = a(paramString, paramVarArgs);
/* 1696 */     throw a(j(), paramClass, paramo, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(s params, Object paramObject) {
/* 1705 */     paramObject = String.format("No Object Id found for an instance of %s, to assign to property '%s'", new Object[] {
/* 1706 */           i.d(paramObject), params.a });
/* 1707 */     return a((c)params.d, (String)paramObject, new Object[0]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(k<?> paramk, String paramString, Object... paramVarArgs) {
/* 1719 */     paramString = a(paramString, paramVarArgs);
/* 1720 */     throw f.a(j(), paramk.a(), paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(Class<?> paramClass, String paramString, Object... paramVarArgs) {
/* 1732 */     paramString = a(paramString, paramVarArgs);
/* 1733 */     throw f.a(j(), paramClass, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(j paramj, String paramString, Object... paramVarArgs) {
/* 1745 */     paramString = a(paramString, paramVarArgs);
/* 1746 */     throw f.a(j(), paramj, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(c paramc, String paramString, Object... paramVarArgs) {
/* 1758 */     paramString = a(paramString, paramVarArgs);
/* 1759 */     j j1 = (paramc == null) ? null : paramc.c();
/* 1760 */     f f1 = f.a(j(), j1, paramString);
/*      */     j j;
/* 1762 */     if (paramc != null && (
/*      */       
/* 1764 */       j = paramc.e()) != null) {
/* 1765 */       f1.a(j.h(), paramc.a());
/*      */     }
/*      */     
/* 1768 */     throw f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T c(Class<?> paramClass, String paramString1, String paramString2, Object... paramVarArgs) {
/* 1780 */     paramString2 = a(paramString2, paramVarArgs);
/* 1781 */     f f1 = f.a(j(), paramClass, paramString2);
/* 1782 */     if (paramString1 != null) {
/* 1783 */       f1.a(paramClass, paramString1);
/*      */     }
/* 1785 */     throw f1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(j paramj, String paramString1, String paramString2, Object... paramVarArgs) {
/* 1797 */     return c(paramj.b(), paramString1, paramString2, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(Class<?> paramClass, Object paramObject, String paramString, Object... paramVarArgs) {
/* 1810 */     paramString = a(paramString, paramVarArgs);
/*      */     
/*      */     c c1;
/* 1813 */     throw c1 = c.a(j(), paramString, paramObject, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> T a(Class<?> paramClass, l paraml, o paramo) {
/* 1819 */     throw f.a(paraml, paramClass, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", new Object[] { paramo, 
/*      */             
/* 1821 */             i.g(paramClass) }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(b paramb, String paramString, Object... paramVarArgs) {
/* 1884 */     paramString = a(paramString, paramVarArgs);
/* 1885 */     String str = i.g(paramb.b());
/* 1886 */     paramString = String.format("Invalid type definition for type %s: %s", new Object[] { str, paramString });
/* 1887 */     throw b.a(this.g, paramString, paramb, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final <T> T a(b paramb, s params, String paramString, Object... paramVarArgs) {
/* 1899 */     paramString = a(paramString, paramVarArgs);
/* 1900 */     String str1 = i.a((v)params);
/* 1901 */     String str2 = i.g(paramb.b());
/* 1902 */     paramString = String.format("Invalid definition for property %s (of type %s): %s", new Object[] { str1, str2, paramString });
/*      */     
/* 1904 */     throw b.a(this.g, paramString, paramb, params);
/*      */   }
/*      */ 
/*      */   
/*      */   public final <T> T a(j paramj, String paramString) {
/* 1909 */     throw b.a(this.g, paramString, paramj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l a(l paraml, j paramj, o paramo, String paramString) {
/* 1943 */     String str = a(str = String.format("Unexpected token (%s), expected %s", new Object[] { paraml.k(), paramo }), paramString);
/* 1944 */     return (l)f.a(paraml, paramj, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l a(l paraml, Class<?> paramClass, o paramo, String paramString) {
/* 1952 */     String str = a(str = String.format("Unexpected token (%s), expected %s", new Object[] { paraml.k(), paramo }), paramString);
/* 1953 */     return (l)f.a(paraml, paramClass, str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l a(Class<?> paramClass, String paramString1, String paramString2) {
/* 1973 */     return (l)c.a(this.g, 
/* 1974 */         String.format("Cannot deserialize Map key of type %s from String %s: %s", new Object[] {
/* 1975 */             i.g(paramClass), a(paramString1), paramString2
/*      */           }), paramString1, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l a(String paramString1, Class<?> paramClass, String paramString2) {
/* 1994 */     paramString2 = String.format("Cannot deserialize value of type %s from String %s: %s", new Object[] {
/* 1995 */           i.g(paramClass), a(paramString1), paramString2 });
/* 1996 */     return (l)c.a(this.g, paramString2, paramString1, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l a(Number paramNumber, Class<?> paramClass, String paramString) {
/* 2008 */     return (l)c.a(this.g, 
/* 2009 */         String.format("Cannot deserialize value of type %s from number %s: %s", new Object[] {
/* 2010 */             i.g(paramClass), String.valueOf(paramNumber), paramString
/*      */           }), paramNumber, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l a(Object paramObject, Class<?> paramClass) {
/* 2026 */     return (l)c.a(this.g, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", new Object[] {
/*      */             
/* 2028 */             i.g(paramClass), i.d(paramObject)
/*      */           }), paramObject, paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l a(Class<?> paramClass, Throwable paramThrowable) {
/* 2043 */     if (paramThrowable == null) {
/* 2044 */       str = "N/A";
/* 2045 */     } else if ((str = i.g(paramThrowable)) == null) {
/* 2046 */       str = i.g(paramThrowable.getClass());
/*      */     } 
/* 2048 */     String str = String.format("Cannot construct instance of %s, problem: %s", new Object[] {
/* 2049 */           i.g(paramClass), str
/*      */         });
/*      */     
/* 2052 */     return (l)i.a(this.g, str, b(paramClass), paramThrowable);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final l a(j paramj, String paramString1, String paramString2) {
/* 2076 */     String str = String.format("Could not resolve type id '%s' as a subtype of %s", new Object[] { paramString1, 
/* 2077 */           i.b(paramj) });
/* 2078 */     return (l)e.a(this.g, a(str, paramString2), paramj, paramString1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private l b(j paramj, String paramString) {
/* 2086 */     String str = String.format("Could not resolve subtype of %s", new Object[] { paramj });
/*      */     
/* 2088 */     return (l)e.a(this.g, a(str, paramString), paramj, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private DateFormat p() {
/* 2212 */     if (this.k != null) {
/* 2213 */       return this.k;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2220 */     DateFormat dateFormat = this.a.s();
/* 2221 */     this.k = dateFormat = (DateFormat)dateFormat.clone();
/* 2222 */     return dateFormat;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String a(o paramo) {
/* 2231 */     if (paramo != null) {
/* 2232 */       switch (h.a[paramo.ordinal()]) {
/*      */         
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/* 2237 */           return "Object value";
/*      */ 
/*      */         
/*      */         case 4:
/*      */         case 5:
/* 2242 */           return "Array value";
/*      */         
/*      */         case 6:
/*      */         case 7:
/* 2246 */           return "Boolean value";
/*      */         
/*      */         case 8:
/* 2249 */           return "Embedded Object";
/*      */         
/*      */         case 9:
/* 2252 */           return "Floating-point value";
/*      */         case 10:
/* 2254 */           return "Integer value";
/*      */         case 11:
/* 2256 */           return "String value";
/*      */         
/*      */         case 12:
/* 2259 */           return "Null value";
/*      */       } 
/*      */ 
/*      */       
/* 2263 */       return "[Unavailable value]";
/*      */     } 
/*      */     
/* 2266 */     return "<end of input>";
/*      */   }
/*      */   
/*      */   public abstract z a(Object paramObject, al<?> paramal, an paraman);
/*      */   
/*      */   public abstract k<Object> b(b paramb, Object paramObject);
/*      */   
/*      */   public abstract p c(b paramb, Object paramObject);
/*      */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */