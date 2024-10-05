/*     */ package com.a.a.c.c;
/*     */ 
/*     */ import com.a.a.a.al;
/*     */ import com.a.a.a.an;
/*     */ import com.a.a.b.l;
/*     */ import com.a.a.b.o;
/*     */ import com.a.a.c.c.a.z;
/*     */ import com.a.a.c.f;
/*     */ import com.a.a.c.f.b;
/*     */ import com.a.a.c.g;
/*     */ import com.a.a.c.j;
/*     */ import com.a.a.c.k;
/*     */ import com.a.a.c.k.a.d;
/*     */ import com.a.a.c.m.i;
/*     */ import com.a.a.c.p;
/*     */ import com.a.a.c.w;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class n
/*     */   extends g
/*     */   implements Serializable
/*     */ {
/*     */   private transient LinkedHashMap<al.a, z> b;
/*     */   private List<an> c;
/*     */   
/*     */   protected n(q paramq, p paramp) {
/*  45 */     super(paramq, paramp);
/*     */   }
/*     */ 
/*     */   
/*     */   protected n(n paramn, f paramf, l paraml, d paramd) {
/*  50 */     super(paramn, paramf, paraml, paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected n(n paramn, f paramf) {
/*  56 */     super(paramn, paramf);
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
/*     */   public final z a(Object paramObject, al<?> paramal, an paraman) {
/*     */     an an1;
/*  94 */     if (paramObject == null) {
/*  95 */       return null;
/*     */     }
/*     */     
/*  98 */     paramObject = paramal.a(paramObject);
/*     */     
/* 100 */     if (this.b == null) {
/* 101 */       this.b = new LinkedHashMap<>();
/*     */     } else {
/*     */       z z1;
/* 104 */       if ((z1 = this.b.get(paramObject)) != null) {
/* 105 */         return z1;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 110 */     paramal = null;
/*     */     
/* 112 */     if (this.c == null) {
/* 113 */       this.c = new ArrayList<>(8);
/*     */     } else {
/* 115 */       for (Iterator<an> iterator = this.c.iterator(); iterator.hasNext();) {
/* 116 */         if ((an2 = iterator.next()).a(paraman)) {
/* 117 */           an1 = an2;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 123 */     if (an1 == null) {
/* 124 */       an1 = paraman.a();
/* 125 */       this.c.add(an1);
/*     */     } 
/*     */     
/*     */     z z;
/* 129 */     (z = a((al.a)paramObject)).a(an1);
/* 130 */     this.b.put(paramObject, z);
/* 131 */     return z;
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
/*     */   private static z a(al.a parama) {
/* 147 */     return new z(parama);
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
/*     */   public final k<Object> b(b paramb, Object paramObject) {
/*     */     k<Object> k;
/* 211 */     if (paramObject == null) {
/* 212 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 216 */     if (paramObject instanceof k) {
/* 217 */       k = (k)paramObject;
/*     */     }
/*     */     else {
/*     */       
/* 221 */       if (!(paramObject instanceof Class)) {
/* 222 */         throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + paramObject.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
/*     */       }
/*     */ 
/*     */       
/* 226 */       if ((paramObject = paramObject) == k.a.class || i.e((Class)paramObject)) {
/* 227 */         return null;
/*     */       }
/* 229 */       if (!k.class.isAssignableFrom((Class<?>)paramObject)) {
/* 230 */         throw new IllegalStateException("AnnotationIntrospector returned Class " + paramObject.getName() + "; expected Class<JsonDeserializer>");
/*     */       }
/*     */       
/*     */       d d;
/* 234 */       if ((k = (k<Object>)(((d = this.a.m()) == null) ? null : d.d())) == null) {
/* 235 */         k = (k)i.b((Class)paramObject, this.a
/* 236 */             .g());
/*     */       }
/*     */     } 
/*     */     
/* 240 */     if (k instanceof t) {
/* 241 */       ((t)k).d(this);
/*     */     }
/* 243 */     return k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final p c(b paramb, Object paramObject) {
/*     */     p p;
/* 250 */     if (paramObject == null) {
/* 251 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 256 */     if (paramObject instanceof p) {
/* 257 */       p = (p)paramObject;
/*     */     } else {
/* 259 */       if (!(paramObject instanceof Class)) {
/* 260 */         throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + paramObject
/* 261 */             .getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 266 */       if ((paramObject = paramObject) == p.a.class || i.e((Class)paramObject)) {
/* 267 */         return null;
/*     */       }
/* 269 */       if (!p.class.isAssignableFrom((Class<?>)paramObject)) {
/* 270 */         throw new IllegalStateException("AnnotationIntrospector returned Class " + paramObject.getName() + "; expected Class<KeyDeserializer>");
/*     */       }
/*     */       
/*     */       d d;
/*     */       
/* 275 */       if ((p = (p)(((d = this.a.m()) == null) ? null : d.e())) == null) {
/* 276 */         p = (p)i.b((Class)paramObject, this.a
/* 277 */             .g());
/*     */       }
/*     */     } 
/*     */     
/* 281 */     if (p instanceof t) {
/* 282 */       ((t)p).d(this);
/*     */     }
/* 284 */     return p;
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
/*     */   public abstract n a(f paramf, l paraml, d paramd);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract n a(f paramf);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Object a(l paraml, j paramj, k<Object> paramk, Object paramObject) {
/* 319 */     if (this.a.a()) {
/* 320 */       return b(paraml, paramj, paramk, paramObject);
/*     */     }
/* 322 */     if (paramObject == null) {
/* 323 */       return paramk.a(paraml, this);
/*     */     }
/* 325 */     return paramk.a(paraml, this, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object b(l paraml, j paramj, k<Object> paramk, Object paramObject) {
/*     */     Object object;
/*     */     w w;
/* 335 */     String str1 = (w = this.a.e(paramj)).b();
/* 336 */     if (paraml.k() != o.b)
/* 337 */       a(paramj, o.b, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", new Object[] {
/*     */             
/* 339 */             i.b(str1), paraml.k()
/*     */           }); 
/* 341 */     if (paraml.g() != o.f)
/* 342 */       a(paramj, o.f, "Current token not FIELD_NAME (to contain expected root name %s), but %s", new Object[] {
/*     */             
/* 344 */             i.b(str1), paraml.k()
/*     */           }); 
/* 346 */     String str2 = paraml.v();
/* 347 */     if (!str1.equals(str2)) {
/* 348 */       a(paramj, str2, "Root name (%s) does not match expected (%s) for type %s", new Object[] {
/*     */             
/* 350 */             i.b(str2), i.b(str1), i.b(paramj)
/*     */           });
/*     */     }
/* 353 */     paraml.g();
/*     */     
/* 355 */     if (paramObject == null) {
/* 356 */       object = paramk.a(paraml, this);
/*     */     } else {
/* 358 */       object = object.a(paraml, this, paramObject);
/*     */     } 
/*     */     
/* 361 */     if (paraml.g() != o.c)
/* 362 */       a(paramj, o.c, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", new Object[] {
/*     */             
/* 364 */             i.b(str1), paraml.k()
/*     */           }); 
/* 366 */     return object;
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
/*     */   public static final class a
/*     */     extends n
/*     */   {
/*     */     public a(q param1q) {
/* 387 */       super(param1q, (p)null);
/*     */     }
/*     */ 
/*     */     
/*     */     private a(a param1a, f param1f, l param1l, d param1d) {
/* 392 */       super(param1a, param1f, param1l, param1d);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(a param1a, f param1f) {
/* 402 */       super(param1a, param1f);
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
/*     */     public final n a(f param1f, l param1l, d param1d) {
/* 414 */       return new a(this, param1f, param1l, param1d);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final n a(f param1f) {
/* 420 */       return new a(this, param1f);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\a\a\c\c\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */