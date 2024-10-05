/*     */ package com.d.c.c;
/*     */ 
/*     */ import com.d.c.b.d;
/*     */ import com.d.c.e.b;
/*     */ import com.d.c.e.d;
/*     */ import com.d.i.a.r;
/*     */ import com.d.i.v;
/*     */ import com.d.m.k;
/*     */ import com.d.m.l;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */ {
/*     */   private a a;
/*     */   private com.d.c.b.a b;
/*     */   private d c;
/*     */   private com.d.c.b.c d;
/*     */   private Map<Object, a> e;
/*     */   private Set<Object> f;
/*     */   private Set<Object> g;
/*     */   private Set<Object> h;
/*     */   private Set<Object> i;
/*  59 */   private final List<com.d.c.e.c> j = new ArrayList<>();
/*  60 */   private final List<com.d.c.e.a> k = new ArrayList<>();
/*     */ 
/*     */   
/*     */   public c(d paramd, com.d.c.b.a parama, com.d.c.b.c paramc, List<r> paramList, String paramString) {
/*  64 */     b();
/*  65 */     this.c = paramd;
/*  66 */     this.b = parama;
/*  67 */     this.d = paramc;
/*     */     
/*  69 */     this.a = a(paramList, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a(Object paramObject, boolean paramBoolean) {
/*     */     a a1;
/*  78 */     if (!paramBoolean) {
/*  79 */       a1 = b(paramObject);
/*     */     } else {
/*  81 */       a1 = a(paramObject);
/*     */     } 
/*  83 */     return a1.b(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a(Object paramObject, String paramString) {
/*  93 */     return (paramObject = b(paramObject)).a(paramString);
/*     */   }
/*     */   
/*     */   public final e a(String paramString1, String paramString2) {
/*     */     a a1;
/*  98 */     ArrayList<v> arrayList = new ArrayList();
/*  99 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 101 */     for (Iterator<com.d.c.e.c> iterator = this.j.iterator(); iterator.hasNext();) {
/* 102 */       if ((c1 = iterator.next()).a(paramString1, paramString2)) {
/* 103 */         arrayList.addAll(c1.b().a());
/* 104 */         hashMap.putAll(c1.c());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 109 */     if (arrayList.isEmpty()) {
/* 110 */       a1 = a.a;
/*     */     } else {
/* 112 */       a1 = new a(arrayList.iterator());
/*     */     } 
/*     */     
/* 115 */     return new e(arrayList, a1, (Map)hashMap);
/*     */   }
/*     */   
/*     */   public final List<com.d.c.e.a> a() {
/* 119 */     return this.k;
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
/*     */   private a a(Object paramObject) {
/*     */     Object object;
/* 141 */     if ((object = this.c.a(paramObject)) != null) {
/*     */       
/* 143 */       paramObject = (object = b(object)).a(paramObject);
/*     */     } else {
/* 145 */       paramObject = this.a.a(paramObject);
/*     */     } 
/* 147 */     return (a)paramObject;
/*     */   }
/*     */   
/*     */   private a a(List<r> paramList, String paramString) {
/* 151 */     TreeMap<Object, Object> treeMap = new TreeMap<>();
/* 152 */     a(paramList, (TreeMap)treeMap, paramString);
/* 153 */     l.f("Matcher created with " + treeMap.size() + " selectors");
/* 154 */     return new a(this, treeMap.values());
/*     */   }
/*     */   
/*     */   private void a(List<r> paramList, TreeMap<String, f> paramTreeMap, String paramString) {
/* 158 */     byte b1 = 0;
/* 159 */     byte b2 = 0;
/* 160 */     for (Iterator<r> iterator = paramList.iterator(); iterator.hasNext(); ) {
/* 161 */       r r; for (Iterator<Object> iterator1 = (r = iterator.next()).c().iterator(); iterator1.hasNext(); ) {
/* 162 */         Iterator<f> iterator2; if (iterator2 = (Iterator<f>)iterator1.next() instanceof d) {
/* 163 */           for (iterator2 = ((d)iterator2).b().iterator(); iterator2.hasNext(); ) {
/* 164 */             f f; (f = iterator2.next()).c(++b1);
/* 165 */             paramTreeMap.put(f.m(), f);
/*     */           }  continue;
/* 167 */         }  if (iterator2 instanceof com.d.c.e.c) {
/* 168 */           ((com.d.c.e.c)iterator2).a(++b2);
/* 169 */           this.j.add((com.d.c.e.c)iterator2); continue;
/* 170 */         }  b b; if (iterator2 instanceof b && (
/*     */           
/* 172 */           b = (b)iterator2).b(paramString)) {
/* 173 */           for (Iterator<b> iterator3 = b.b().iterator(); iterator3.hasNext();) {
/*     */             
/* 175 */             for (Iterator<Object> iterator4 = (d1 = (d)(b = iterator3.next())).b().iterator(); iterator4.hasNext(); ) {
/*     */               f f;
/* 177 */               (f = (f)(f = (f)iterator4.next())).c(++b1);
/* 178 */               paramTreeMap.put(f.m(), f);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 185 */       this.k.addAll(r.e());
/*     */     } 
/*     */     
/* 188 */     Collections.sort(this.j, new d(this));
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
/*     */   private void a(Object paramObject, a parama) {
/* 202 */     this.e.put(paramObject, parama);
/*     */   }
/*     */   
/*     */   private void b() {
/* 206 */     this.e = new HashMap<>();
/* 207 */     this.f = new HashSet();
/* 208 */     this.g = new HashSet();
/* 209 */     this.h = new HashSet();
/* 210 */     this.i = new HashSet();
/*     */   }
/*     */   
/*     */   private a b(Object paramObject) {
/*     */     a a1;
/* 215 */     if ((a1 = this.e.get(paramObject)) != null) {
/* 216 */       return a1;
/*     */     }
/*     */     
/* 219 */     return a1 = a(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   private d c(Object paramObject) {
/* 224 */     if (this.b == null || this.d == null) {
/* 225 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 229 */     if (k.a((String)(paramObject = this.b.d(paramObject)))) {
/* 230 */       return null;
/*     */     }
/*     */     
/* 233 */     return this.d.a(2, (String)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private d d(Object paramObject) {
/* 239 */     if (this.b == null || this.d == null) {
/* 240 */       return null;
/*     */     }
/*     */     
/* 243 */     if (k.a((String)(paramObject = this.b.c(paramObject)))) {
/* 244 */       return null;
/*     */     }
/* 246 */     return this.d.a(2, (String)paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   class a
/*     */   {
/*     */     private List<f> a;
/*     */     
/*     */     private HashMap<String, List<f>> b;
/*     */     
/*     */     private List<f> c;
/*     */     
/*     */     private Map<String, a> d;
/*     */ 
/*     */     
/*     */     a(c this$0, Collection<f> param1Collection) {
/* 263 */       this.a = new ArrayList<>(param1Collection);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private a(c this$0) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final a a(Object param1Object) {
/* 278 */       ArrayList<f> arrayList1 = new ArrayList(this.a.size() + 10);
/* 279 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 280 */       ArrayList<f> arrayList2 = new ArrayList();
/* 281 */       StringBuilder stringBuilder = new StringBuilder();
/* 282 */       for (Iterator<f> iterator = this.a.iterator(); iterator.hasNext(); ) {
/* 283 */         f f; if ((f = iterator.next()).i() == 0) {
/*     */           
/* 285 */           arrayList1.add(f);
/* 286 */         } else if (f.i() == 2) {
/* 287 */           throw new RuntimeException();
/*     */         } 
/* 289 */         if (f.a(param1Object, c.a(this.e), c.b(this.e))) {
/*     */           String str;
/*     */ 
/*     */ 
/*     */           
/* 294 */           if ((str = f.f()) != null) {
/*     */             List<f> list;
/* 296 */             if ((list = (List)hashMap.get(str)) == null) {
/* 297 */               list = new ArrayList();
/* 298 */               hashMap.put(str, list);
/*     */             } 
/* 300 */             list.add(f);
/* 301 */             stringBuilder.append(f.n()).append(":");
/*     */             continue;
/*     */           } 
/* 304 */           if (f.b(2)) {
/* 305 */             c.c(this.e).add(param1Object);
/*     */           }
/* 307 */           if (f.b(8)) {
/* 308 */             c.d(this.e).add(param1Object);
/*     */           }
/* 310 */           if (f.b(4)) {
/* 311 */             c.e(this.e).add(param1Object);
/*     */           }
/* 313 */           if (f.b(16)) {
/* 314 */             c.f(this.e).add(param1Object);
/*     */           }
/* 316 */           if (f.b(param1Object, c.a(this.e), c.b(this.e))) {
/*     */ 
/*     */             
/* 319 */             stringBuilder.append(f.n()).append(":");
/*     */             f f1;
/* 321 */             if ((f1 = f.g()) == null) {
/* 322 */               arrayList2.add(f); continue;
/* 323 */             }  if (f1.i() == 2) {
/* 324 */               throw new RuntimeException();
/*     */             }
/* 326 */             arrayList1.add(f1);
/*     */           } 
/*     */         } 
/* 329 */       }  if (this.d == null) this.d = new HashMap<>(); 
/*     */       a a1;
/* 331 */       if ((a1 = this.d.get(stringBuilder.toString())) == null) {
/*     */         
/* 333 */         (a1 = new a(this.e)).a = arrayList1;
/* 334 */         a1.b = (HashMap)hashMap;
/* 335 */         a1.c = arrayList2;
/* 336 */         this.d.put(stringBuilder.toString(), a1);
/*     */       } 
/* 338 */       c.a(this.e, param1Object, a1);
/* 339 */       return a1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     final a b(Object<f> param1Object) {
/* 346 */       d d = c.a(this.e, param1Object);
/* 347 */       param1Object = (Object<f>)c.b(this.e, param1Object);
/* 348 */       ArrayList<v> arrayList = new ArrayList();
/*     */       
/* 350 */       if (param1Object != null) {
/* 351 */         arrayList.addAll(param1Object.a());
/*     */       }
/*     */       
/* 354 */       for (param1Object = (Object<f>)this.c.iterator(); param1Object.hasNext(); ) { f f = param1Object.next();
/* 355 */         arrayList.addAll(f.h().a()); }
/*     */ 
/*     */       
/* 358 */       if (d != null) {
/* 359 */         arrayList.addAll(d.a());
/*     */       }
/* 361 */       if (arrayList.size() == 0) {
/* 362 */         param1Object = (Object<f>)a.a;
/*     */       } else {
/* 364 */         param1Object = (Object<f>)new a(arrayList.iterator());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 369 */       return (a)(param1Object = param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final a a(String param1String) {
/*     */       a a1;
/*     */       Iterator<?> iterator;
/* 378 */       if (!(iterator = this.b.entrySet().iterator()).hasNext()) {
/* 379 */         return null;
/*     */       }
/*     */       
/*     */       List list;
/* 383 */       if ((list = this.b.get(param1String)) == null) return null;
/*     */       
/* 385 */       ArrayList<v> arrayList = new ArrayList();
/* 386 */       for (f f : list) {
/* 387 */         arrayList.addAll(f.h().a());
/*     */       }
/* 389 */       if (arrayList.size() == 0) {
/* 390 */         a1 = a.a;
/*     */       } else {
/* 392 */         a1 = new a(arrayList.iterator());
/*     */       } 
/* 394 */       return a1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\com\d\c\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */