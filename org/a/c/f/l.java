/*     */ package org.a.c.f;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.n;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class l
/*     */ {
/*     */   private static class b
/*     */   {
/*  64 */     protected d a = null;
/*     */     
/*     */     private l.a b;
/*     */     
/*  68 */     private final Map<n, Long> c = new HashMap<n, Long>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private b() {
/*  75 */       this.b = l.a.a;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void a() {
/*  80 */       this.c.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum a
/*     */   {
/*  92 */     a,
/*     */ 
/*     */ 
/*     */     
/*  96 */     b;
/*     */   }
/*     */   
/*  99 */   private final Map<Long, b> a = new HashMap<Long, b>();
/* 100 */   private b b = null;
/* 101 */   private b c = null;
/*     */ 
/*     */   
/* 104 */   private static final org.a.a.a.a d = c.a(l.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong, a parama) {
/* 155 */     this.a.put(Long.valueOf(paramLong), this.b = new b((byte)0));
/* 156 */     b.a(this.b, parama);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/* 166 */     return (this.c == null) ? null : b.a(this.c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(n paramn, long paramLong) {
/* 177 */     if (this.b == null) {
/*     */ 
/*     */       
/* 180 */       (new StringBuilder("Cannot add XRef entry for '")).append(paramn.b()).append("' because XRef start was not signalled.");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 185 */     if (!b.b(this.b).containsKey(paramn))
/*     */     {
/* 187 */       b.b(this.b).put(paramn, Long.valueOf(paramLong));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(d paramd) {
/* 198 */     if (this.b == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 204 */     this.b.a = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d b() {
/* 215 */     return this.b.a;
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
/*     */   public final void a(long paramLong) {
/* 234 */     if (this.c != null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 240 */     this.c = new b((byte)0);
/* 241 */     this.c.a = new d();
/*     */     
/* 243 */     b b1 = this.a.get(Long.valueOf(paramLong));
/* 244 */     ArrayList<Comparable> arrayList = new ArrayList();
/*     */     
/* 246 */     if (b1 == null) {
/*     */ 
/*     */       
/* 249 */       (new StringBuilder("Did not found XRef object at specified startxref position ")).append(paramLong);
/*     */ 
/*     */       
/* 252 */       arrayList.addAll(this.a.keySet());
/* 253 */       Collections.sort(arrayList);
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 258 */       b.a(this.c, b.a(b1));
/*     */ 
/*     */       
/* 261 */       arrayList.add(Long.valueOf(paramLong));
/* 262 */       while (b1.a != null) {
/*     */         long l1;
/*     */         
/* 265 */         if ((l1 = b1.a.b(j.cU, -1L)) != -1L) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 271 */           if ((b1 = this.a.get(Long.valueOf(l1))) == null) {
/*     */             
/* 273 */             (new StringBuilder("Did not found XRef object pointed to by 'Prev' key at position ")).append(l1);
/*     */             break;
/*     */           } 
/* 276 */           arrayList.add(Long.valueOf(l1));
/*     */ 
/*     */           
/* 279 */           if (arrayList.size() < this.a.size());
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 285 */       Collections.reverse(arrayList);
/*     */     } 
/*     */ 
/*     */     
/* 289 */     for (Long long_ : arrayList) {
/*     */ 
/*     */       
/* 292 */       if ((b1 = this.a.get(long_)).a != null)
/*     */       {
/* 294 */         this.c.a.a(b1.a);
/*     */       }
/* 296 */       b.b(this.c).putAll(b.b(b1));
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
/*     */   public final d c() {
/* 309 */     return (this.c == null) ? null : this.c.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<n, Long> d() {
/* 320 */     return (this.c == null) ? null : b.b(this.c);
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
/*     */   protected final void e() {
/* 361 */     for (Iterator<b> iterator = this.a.values().iterator(); iterator.hasNext();)
/*     */     {
/* 363 */       (b1 = iterator.next()).a();
/*     */     }
/* 365 */     this.b = null;
/* 366 */     this.c = null;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\f\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */