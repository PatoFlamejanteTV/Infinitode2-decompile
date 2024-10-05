/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.a.k;
/*     */ import com.a.a.c.c.a.z;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.h;
/*     */ import com.a.a.c.f.j;
/*     */ import com.a.a.c.f.k;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.i.e;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.j.l;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.l;
/*     */ import com.a.a.c.m;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.p;
/*     */ import com.a.a.c.q;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.LinkedHashMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class u
/*     */   implements Serializable
/*     */ {
/*     */   protected final com.a.a.c.c a;
/*     */   protected final j b;
/*     */   protected final j c;
/*     */   protected k<Object> d;
/*     */   protected final e e;
/*     */   protected final p f;
/*     */   
/*     */   public u(com.a.a.c.c paramc, j paramj, j paramj1, p paramp, k<Object> paramk, e parame) {
/*  66 */     this.a = paramc;
/*  67 */     this.b = paramj;
/*  68 */     this.c = paramj1;
/*  69 */     this.d = paramk;
/*  70 */     this.e = parame;
/*  71 */     this.f = paramp;
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
/*     */   public static u a(com.a.a.c.c paramc, j paramj, j paramj1, p paramp, k<Object> paramk, e parame) {
/*  83 */     return new d(paramc, paramj, paramj1, paramp, paramk, parame);
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
/*     */   public static u a(g paramg, com.a.a.c.c paramc, j paramj, j paramj1, p paramp, k<Object> paramk, e parame) {
/*     */     Class<LinkedHashMap> clazz;
/*     */     Class<Map> clazz1;
/* 100 */     if ((clazz1 = paramj.d()) == Map.class) {
/* 101 */       clazz = LinkedHashMap.class;
/*     */     }
/* 103 */     paramg.c(); x x = k.b(clazz);
/* 104 */     return new c(paramc, paramj, paramj1, paramp, paramk, parame, x);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static u a(g paramg, com.a.a.c.c paramc, j paramj, j paramj1, k<Object> paramk) {
/* 115 */     return new b(paramc, paramj, paramj1, paramk, paramg
/*     */         
/* 117 */         .l());
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract u a(k<Object> paramk);
/*     */   
/*     */   public final void a(f paramf) {
/* 124 */     this.b.a(paramf
/* 125 */         .a(q.o));
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
/*     */   public final com.a.a.c.c a() {
/* 151 */     return this.a;
/*     */   } public final boolean b() {
/* 153 */     return (this.d != null);
/*     */   } public final j c() {
/* 155 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public final String d() {
/* 160 */     return this.a.a();
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
/*     */   public void a(l paraml, g paramg, Object paramObject, String paramString) {
/*     */     try {
/* 178 */       Object object = (this.f == null) ? paramString : this.f.a(paramString, paramg);
/* 179 */       a(paramObject, object, a(paraml, paramg)); return;
/* 180 */     } catch (w w) {
/* 181 */       if (this.d.f() == null) {
/* 182 */         throw l.a(paraml, "Unresolved forward reference but no identity info.", w);
/*     */       }
/*     */       
/* 185 */       a a = new a(this, w, this.c.b(), paramObject, paramString);
/* 186 */       w.d().a(a);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object a(l paraml, g paramg) {
/* 192 */     if (paraml.a(o.m)) {
/* 193 */       return this.d.a(paramg);
/*     */     }
/* 195 */     if (this.e != null) {
/* 196 */       return this.d.a(paraml, paramg, this.e);
/*     */     }
/* 198 */     return this.d.a(paraml, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Object paramObject1, Object paramObject2, Object paramObject3) {
/*     */     try {
/* 205 */       b(paramObject1, paramObject2, paramObject3); return;
/* 206 */     } catch (IOException iOException) {
/* 207 */       throw paramObject1 = null;
/* 208 */     } catch (Exception exception) {
/* 209 */       a(exception, paramObject2, paramObject3);
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
/*     */   protected abstract void b(Object paramObject1, Object paramObject2, Object paramObject3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Exception paramException, Object paramObject1, Object paramObject2) {
/* 229 */     if (paramException instanceof IllegalArgumentException) {
/* 230 */       paramObject2 = i.d(paramObject2);
/*     */       
/* 232 */       (paramObject1 = (new StringBuilder("Problem deserializing \"any-property\" '")).append(paramObject1)).append("' of class " + e() + " (expected type: ").append(this.c);
/* 233 */       paramObject1.append("; actual type: ").append((String)paramObject2).append(")");
/*     */       
/* 235 */       if ((paramObject2 = i.g(paramException)) != null) {
/* 236 */         paramObject1.append(", problem: ").append((String)paramObject2);
/*     */       } else {
/* 238 */         paramObject1.append(" (no error message provided)");
/*     */       } 
/* 240 */       throw new l(null, paramObject1.toString(), paramException);
/*     */     } 
/* 242 */     i.c(paramException);
/* 243 */     i.b(paramException);
/*     */     
/* 245 */     paramObject2 = i.d(paramException);
/* 246 */     throw new l(null, i.g(paramObject2), paramObject2);
/*     */   }
/*     */   private String e() {
/* 249 */     return i.g(this.b.h());
/*     */   } public String toString() {
/* 251 */     return "[any property on class " + e() + "]";
/*     */   }
/*     */   
/*     */   static class a
/*     */     extends z.a {
/*     */     private final u a;
/*     */     private final Object b;
/*     */     private final String c;
/*     */     
/*     */     public a(u param1u, w param1w, Class<?> param1Class, Object param1Object, String param1String) {
/* 261 */       super(param1w, param1Class);
/* 262 */       this.a = param1u;
/* 263 */       this.b = param1Object;
/* 264 */       this.c = param1String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(Object param1Object1, Object param1Object2) {
/* 271 */       if (!b(param1Object1)) {
/* 272 */         throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + param1Object1.toString() + "] that wasn't previously registered.");
/*     */       }
/*     */       
/* 275 */       this.a.a(this.b, this.c, param1Object2);
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
/*     */   public static class d
/*     */     extends u
/*     */     implements Serializable
/*     */   {
/*     */     public d(com.a.a.c.c param1c, j param1j, j param1j1, p param1p, k<Object> param1k, e param1e) {
/* 297 */       super(param1c, param1j, param1j1, param1p, param1k, param1e);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final void b(Object param1Object1, Object param1Object2, Object param1Object3) {
/* 305 */       ((k)this.b).a(param1Object1, new Object[] { param1Object2, param1Object3 });
/*     */     }
/*     */ 
/*     */     
/*     */     public final u a(k<Object> param1k) {
/* 310 */       return new d(this.a, this.b, this.c, this.f, param1k, this.e);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class c
/*     */     extends u
/*     */     implements Serializable
/*     */   {
/*     */     private x g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public c(com.a.a.c.c param1c, j param1j, j param1j1, p param1p, k<Object> param1k, e param1e, x param1x) {
/* 330 */       super(param1c, param1j, param1j1, param1p, param1k, param1e);
/*     */       
/* 332 */       this.g = param1x;
/*     */     }
/*     */ 
/*     */     
/*     */     public final u a(k<Object> param1k) {
/* 337 */       return new c(this.a, this.b, this.c, this.f, param1k, this.e, this.g);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected final void b(Object param1Object1, Object param1Object2, Object param1Object3) {
/*     */       h h;
/*     */       Map<Object, Object> map;
/* 350 */       if ((map = (Map)(h = (h)this.b).b(param1Object1)) == null) {
/* 351 */         map = a((g)null, h, param1Object1);
/*     */       }
/*     */       
/* 354 */       map.put(param1Object2, param1Object3);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Map<Object, Object> a(g param1g, h param1h, Object param1Object) {
/* 362 */       if (this.g == null)
/* 363 */         throw l.a(param1g, String.format("Cannot create an instance of %s for use as \"any-setter\" '%s'", new Object[] {
/*     */                 
/* 365 */                 i.g(this.c.b()), this.a.a()
/*     */               })); 
/* 367 */       Map<Object, Object> map = (Map)this.g.a(param1g);
/* 368 */       param1h.a(param1Object, map);
/* 369 */       return map;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class b
/*     */     extends u
/*     */     implements Serializable
/*     */   {
/*     */     private l g;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b(com.a.a.c.c param1c, j param1j, j param1j1, k<Object> param1k, l param1l) {
/* 387 */       super(param1c, param1j, param1j1, null, param1k, null);
/* 388 */       this.g = param1l;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final void a(l param1l, g param1g, Object param1Object, String param1String) {
/* 397 */       a(param1Object, param1String, (m)a(param1l, param1g));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final Object a(l param1l, g param1g) {
/* 404 */       return this.d.a(param1l, param1g);
/*     */     }
/*     */ 
/*     */     
/*     */     protected final void b(Object param1Object1, Object param1Object2, Object param1Object3) {
/* 409 */       a(param1Object1, (String)param1Object2, (m)param1Object3);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void a(Object param1Object, String param1String, m param1m) {
/*     */       h h;
/*     */       Object object;
/* 419 */       if ((object = (h = (h)this.b).b(param1Object)) == null)
/* 420 */       { object = this.g.d();
/* 421 */         h.a(param1Object, object); }
/* 422 */       else { if (!(object instanceof com.a.a.c.j.r))
/* 423 */           throw l.a((g)null, String.format("Value \"any-setter\" '%s' not `ObjectNode` but %s", new Object[] {
/*     */                   
/* 425 */                   d(), 
/* 426 */                   i.g(object.getClass())
/*     */                 })); 
/* 428 */         object = object; }
/*     */ 
/*     */       
/* 431 */       object.a(param1String, param1m);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final u a(k<Object> param1k) {
/* 437 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\\\u.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */