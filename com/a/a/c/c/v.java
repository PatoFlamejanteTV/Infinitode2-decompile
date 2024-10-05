/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c;
/*     */ import com.a.a.c.c.a.h;
/*     */ import com.a.a.c.c.a.q;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.ad;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.s;
/*     */ import com.a.a.c.f.v;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m.af;
/*     */ import com.a.a.c.m.b;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.w;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class v
/*     */   extends v
/*     */   implements Serializable
/*     */ {
/*  36 */   private static k<Object> g = (k<Object>)new h("No _valueDeserializer assigned");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w h;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final j b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private w i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient b j;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final k<Object> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final e d;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final s e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String k;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected ad f;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private af l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected v(s params, j paramj, e parame, b paramb) {
/* 136 */     this(params.b(), paramj, params.c(), parame, paramb, params
/* 137 */         .h());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected v(w paramw1, j paramj, w paramw2, e parame, b paramb, com.a.a.c.v paramv) {
/* 144 */     super(paramv);
/*     */ 
/*     */     
/*     */     this.m = -1;
/*     */ 
/*     */     
/* 150 */     if (paramw1 == null) {
/* 151 */       this.h = w.b;
/*     */     } else {
/* 153 */       this.h = paramw1.a();
/*     */     } 
/* 155 */     this.b = paramj;
/* 156 */     this.i = paramw2;
/* 157 */     this.j = paramb;
/* 158 */     this.l = null;
/*     */ 
/*     */     
/* 161 */     if (parame != null) {
/* 162 */       parame = parame.a((c)this);
/*     */     }
/* 164 */     this.d = parame;
/* 165 */     this.c = g;
/* 166 */     this.e = (s)g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected v(w paramw, j paramj, com.a.a.c.v paramv, k<Object> paramk) {
/* 177 */     super(paramv);
/*     */     this.m = -1;
/* 179 */     if (paramw == null) {
/* 180 */       this.h = w.b;
/*     */     } else {
/* 182 */       this.h = paramw.a();
/*     */     } 
/* 184 */     this.b = paramj;
/* 185 */     this.i = null;
/* 186 */     this.j = null;
/* 187 */     this.l = null;
/* 188 */     this.d = null;
/* 189 */     this.c = paramk;
/*     */     
/* 191 */     this.e = (s)paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected v(v paramv) {
/* 199 */     super(paramv); this.m = -1;
/* 200 */     this.h = paramv.h;
/* 201 */     this.b = paramv.b;
/* 202 */     this.i = paramv.i;
/* 203 */     this.j = paramv.j;
/* 204 */     this.c = paramv.c;
/* 205 */     this.d = paramv.d;
/* 206 */     this.k = paramv.k;
/* 207 */     this.m = paramv.m;
/* 208 */     this.l = paramv.l;
/* 209 */     this.e = paramv.e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected v(v paramv, k<?> paramk, s params) {
/* 219 */     super(paramv); k<Object> k1; this.m = -1;
/* 220 */     this.h = paramv.h;
/* 221 */     this.b = paramv.b;
/* 222 */     this.i = paramv.i;
/* 223 */     this.j = paramv.j;
/* 224 */     this.d = paramv.d;
/* 225 */     this.k = paramv.k;
/* 226 */     this.m = paramv.m;
/*     */     
/* 228 */     if (paramk == null) {
/* 229 */       this.c = g;
/*     */     } else {
/* 231 */       this.c = (k)paramk;
/*     */     } 
/* 233 */     this.l = paramv.l;
/*     */     
/* 235 */     if (params == g) {
/* 236 */       k1 = this.c;
/*     */     }
/* 238 */     this.e = (s)k1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected v(v paramv, w paramw) {
/* 246 */     super(paramv); this.m = -1;
/* 247 */     this.h = paramw;
/* 248 */     this.b = paramv.b;
/* 249 */     this.i = paramv.i;
/* 250 */     this.j = paramv.j;
/* 251 */     this.c = paramv.c;
/* 252 */     this.d = paramv.d;
/* 253 */     this.k = paramv.k;
/* 254 */     this.m = paramv.m;
/* 255 */     this.l = paramv.l;
/* 256 */     this.e = paramv.e;
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
/*     */   public abstract v a(k<?> paramk);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract v a(w paramw);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final v a(String paramString) {
/*     */     w w1;
/* 289 */     return ((w1 = (this.h == null) ? new w(paramString) : this.h.b(paramString)) == this.h) ? this : a(w1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract v a(s params);
/*     */ 
/*     */   
/*     */   public final void b(String paramString) {
/* 298 */     this.k = paramString;
/*     */   }
/*     */   
/*     */   public final void a(ad paramad) {
/* 302 */     this.f = paramad;
/*     */   }
/*     */   
/*     */   public final void a(Class<?>[] paramArrayOfClass) {
/* 306 */     if (paramArrayOfClass == null) {
/* 307 */       this.l = null; return;
/*     */     } 
/* 309 */     this.l = af.a(paramArrayOfClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int paramInt) {
/* 317 */     if (this.m != -1) {
/* 318 */       throw new IllegalStateException("Property '" + a() + "' already had index (" + this.m + "), trying to assign " + paramInt);
/*     */     }
/* 320 */     this.m = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(f paramf) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void f() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean g() {
/* 342 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String a() {
/* 352 */     return this.h.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public final w b() {
/* 357 */     return this.h;
/*     */   }
/*     */   
/*     */   public final j c() {
/* 361 */     return this.b;
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
/*     */   public abstract j e();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Class<?> k() {
/* 398 */     return e().h();
/*     */   }
/*     */   public String l() {
/* 401 */     return this.k;
/*     */   } public ad m() {
/* 403 */     return this.f;
/*     */   }
/*     */   public boolean n() {
/* 406 */     return (this.c != null && this.c != g);
/*     */   }
/*     */   public boolean o() {
/* 409 */     return (this.d != null);
/*     */   }
/*     */   public k<Object> p() {
/*     */     k<Object> k1;
/* 413 */     if ((k1 = this.c) == g) {
/* 414 */       return null;
/*     */     }
/* 416 */     return k1;
/*     */   }
/*     */   public e q() {
/* 419 */     return this.d;
/*     */   }
/*     */ 
/*     */   
/*     */   public final s r() {
/* 424 */     return this.e;
/*     */   }
/*     */   public boolean a(Class<?> paramClass) {
/* 427 */     return (this.l == null || this.l.a(paramClass));
/*     */   }
/*     */   public boolean s() {
/* 430 */     return (this.l != null);
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
/*     */   public int h() {
/* 449 */     throw new IllegalStateException(String.format("Internal error: no creator index for property '%s' (of type %s)", new Object[] {
/*     */             
/* 451 */             a(), getClass().getName()
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object i() {
/* 458 */     return null;
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
/*     */   public boolean j() {
/* 470 */     return false;
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
/*     */   public abstract void a(l paraml, g paramg, Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object b(l paraml, g paramg, Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void a(Object paramObject1, Object paramObject2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract Object b(Object paramObject1, Object paramObject2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, g paramg) {
/* 535 */     if (paraml.a(o.m)) {
/* 536 */       return this.e.a(paramg);
/*     */     }
/* 538 */     if (this.d != null) {
/* 539 */       return this.c.a(paraml, paramg, this.d);
/*     */     }
/*     */     
/*     */     Object object;
/* 543 */     if ((object = this.c.a(paraml, paramg)) == null) {
/* 544 */       object = this.e.a(paramg);
/*     */     }
/* 546 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object c(l paraml, g paramg, Object paramObject) {
/* 557 */     if (paraml.a(o.m)) {
/*     */       
/* 559 */       if (q.a(this.e)) {
/* 560 */         return paramObject;
/*     */       }
/* 562 */       return this.e.a(paramg);
/*     */     } 
/* 564 */     if (this.d != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 571 */       j j1 = paramg.b().a(paramObject.getClass());
/*     */       k k1;
/* 573 */       return (k1 = paramg.a(j1, (c)this)).a(paraml, paramg, paramObject);
/*     */     } 
/*     */     
/*     */     Object object;
/* 577 */     if ((object = this.c.a(paraml, paramg, paramObject)) == null) {
/* 578 */       if (q.a(this.e)) {
/* 579 */         return paramObject;
/*     */       }
/* 581 */       object = this.e.a(paramg);
/*     */     } 
/* 583 */     return object;
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
/*     */   protected final void a(l paraml, Exception paramException, Object paramObject) {
/* 598 */     if (paramException instanceof IllegalArgumentException) {
/* 599 */       paramObject = i.d(paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 605 */       paramObject = (new StringBuilder("Problem deserializing property '")).append(a()).append("' (expected type: ").append(c()).append("; actual type: ").append((String)paramObject).append(")");
/*     */       String str;
/* 607 */       if ((str = i.g(paramException)) != null) {
/* 608 */         paramObject.append(", problem: ")
/* 609 */           .append(str);
/*     */       } else {
/* 611 */         paramObject.append(" (no error message provided)");
/*     */       } 
/* 613 */       throw l.a(paraml, paramObject.toString(), paramException);
/*     */     } 
/* 615 */     a(paraml, paramException);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static IOException a(l paraml, Exception paramException) {
/* 623 */     i.c(paramException);
/* 624 */     i.b(paramException);
/*     */     
/* 626 */     Throwable throwable = i.d(paramException);
/* 627 */     throw l.a(paraml, i.g(throwable), throwable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void a(Exception paramException, Object paramObject) {
/* 638 */     a((l)null, paramException, paramObject);
/*     */   }
/*     */   public String toString() {
/* 641 */     return "[property '" + a() + "']";
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
/*     */   public static abstract class a
/*     */     extends v
/*     */   {
/*     */     protected final v g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected a(v param1v) {
/* 665 */       super(param1v);
/* 666 */       this.g = param1v;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected abstract v a(v param1v);
/*     */ 
/*     */ 
/*     */     
/*     */     private v b(v param1v) {
/* 676 */       if (param1v == this.g) {
/* 677 */         return this;
/*     */       }
/* 679 */       return a(param1v);
/*     */     }
/*     */ 
/*     */     
/*     */     public final v a(k<?> param1k) {
/* 684 */       return b(this.g.a(param1k));
/*     */     }
/*     */ 
/*     */     
/*     */     public final v a(w param1w) {
/* 689 */       return b(this.g.a(param1w));
/*     */     }
/*     */ 
/*     */     
/*     */     public final v a(s param1s) {
/* 694 */       return b(this.g.a(param1s));
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a(int param1Int) {
/* 699 */       this.g.a(param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(f param1f) {
/* 704 */       this.g.a(param1f);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final Class<?> k() {
/* 714 */       return this.g.k();
/*     */     }
/*     */     public final String l() {
/* 717 */       return this.g.l();
/*     */     }
/*     */     public final ad m() {
/* 720 */       return this.g.m();
/*     */     }
/*     */     public final boolean n() {
/* 723 */       return this.g.n();
/*     */     }
/*     */     public final boolean o() {
/* 726 */       return this.g.o();
/*     */     }
/*     */     public final k<Object> p() {
/* 729 */       return this.g.p();
/*     */     }
/*     */     public final e q() {
/* 732 */       return this.g.q();
/*     */     }
/*     */     public final boolean a(Class<?> param1Class) {
/* 735 */       return this.g.a(param1Class);
/*     */     }
/*     */     public final boolean s() {
/* 738 */       return this.g.s();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final int h() {
/* 744 */       return this.g.h();
/*     */     }
/*     */     public final Object i() {
/* 747 */       return this.g.i();
/*     */     }
/*     */     public final boolean j() {
/* 750 */       return this.g.j();
/*     */     }
/*     */     
/*     */     public final j e() {
/* 754 */       return this.g.e();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(l param1l, g param1g, Object param1Object) {
/* 781 */       this.g.a(param1l, param1g, param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object b(l param1l, g param1g, Object param1Object) {
/* 788 */       return this.g.b(param1l, param1g, param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public void a(Object param1Object1, Object param1Object2) {
/* 793 */       this.g.a(param1Object1, param1Object2);
/*     */     }
/*     */ 
/*     */     
/*     */     public Object b(Object param1Object1, Object param1Object2) {
/* 798 */       return this.g.b(param1Object1, param1Object2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\v.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */