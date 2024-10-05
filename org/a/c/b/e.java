/*     */ package org.a.c.b;
/*     */ 
/*     */ import com.a.a.a.am;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.d.g;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends b
/*     */   implements Closeable
/*     */ {
/*  47 */   private static final a a = c.a(e.class);
/*     */   
/*  49 */   private float b = 1.4F;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private final Map<n, m> c = new HashMap<n, m>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   private final Map<n, Long> d = new HashMap<n, Long>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  67 */   private final List<p> e = new ArrayList<p>();
/*     */ 
/*     */ 
/*     */   
/*     */   private d f;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g = true;
/*     */ 
/*     */ 
/*     */   
/*     */   private long h;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean i = false;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean j;
/*     */ 
/*     */ 
/*     */   
/*     */   private g k;
/*     */ 
/*     */   
/*     */   private long l;
/*     */ 
/*     */ 
/*     */   
/*     */   public e() {
/*  99 */     this(g.a());
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
/*     */   public e(g paramg) {
/* 111 */     this.k = paramg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final p a() {
/* 121 */     p p = new p(this.k);
/*     */ 
/*     */ 
/*     */     
/* 125 */     this.e.add(p);
/* 126 */     return p;
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
/*     */   public final p a(d paramd) {
/* 138 */     p p = new p(this.k);
/* 139 */     for (Map.Entry<j, b> entry : paramd.e())
/*     */     {
/* 141 */       p.a((j)entry.getKey(), (b)entry.getValue());
/*     */     }
/* 143 */     return p;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(float paramFloat) {
/* 279 */     this.b = paramFloat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float b() {
/* 289 */     return this.b;
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
/*     */   public final boolean c() {
/* 317 */     boolean bool = false;
/* 318 */     if (this.f != null)
/*     */     {
/* 320 */       bool = this.f.a(j.aS) instanceof d;
/*     */     }
/* 322 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d d() {
/* 333 */     return this.f.d(j.aS);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(d paramd) {
/* 344 */     this.f.a(j.aS, paramd);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a e() {
/* 354 */     return h().f(j.bA);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(a parama) {
/* 364 */     h().a(j.bA, parama);
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
/*     */   private List<m> n() {
/* 393 */     return new ArrayList<m>(this.c.values());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final d h() {
/* 403 */     return this.f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void c(d paramd) {
/* 414 */     this.f = paramd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long i() {
/* 425 */     return this.l;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong) {
/* 436 */     this.l = paramLong;
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
/*     */   public final Object a(u paramu) {
/* 449 */     return paramu.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 460 */     if (!this.i) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 468 */       IOException iOException = null;
/*     */       
/*     */       Iterator<m> iterator;
/* 471 */       for (iterator = n().iterator(); iterator.hasNext();) {
/*     */ 
/*     */         
/* 474 */         if (b1 = (m = iterator.next()).a() instanceof p)
/*     */         {
/* 476 */           iOException = am.a((p)b1, a, "COSStream", iOException);
/*     */         }
/*     */       } 
/* 479 */       for (iterator = (Iterator)this.e.iterator(); iterator.hasNext();)
/*     */       {
/* 481 */         iOException = am.a(p = (p)iterator.next(), a, "COSStream", iOException);
/*     */       }
/* 483 */       if (this.k != null)
/*     */       {
/* 485 */         iOException = am.a((Closeable)this.k, a, "ScratchFile", iOException);
/*     */       }
/* 487 */       this.i = true;
/*     */ 
/*     */       
/* 490 */       if (iOException != null)
/*     */       {
/* 492 */         throw iOException;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean j() {
/* 504 */     return this.i;
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
/*     */   protected void finalize() {
/* 516 */     if (!this.i)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 522 */       close();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final m a(n paramn) {
/* 577 */     m m = null;
/* 578 */     if (paramn != null)
/*     */     {
/* 580 */       m = this.c.get(paramn);
/*     */     }
/* 582 */     if (m == null) {
/*     */ 
/*     */       
/* 585 */       m = new m(null);
/* 586 */       if (paramn != null) {
/*     */         
/* 588 */         m.a(paramn.b());
/* 589 */         m.a(paramn.a());
/* 590 */         this.c.put(paramn, m);
/*     */       } 
/*     */     } 
/* 593 */     return m;
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
/*     */   public final void a(Map<n, Long> paramMap) {
/* 613 */     this.d.putAll(paramMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Map<n, Long> k() {
/* 623 */     return this.d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(long paramLong) {
/* 634 */     this.h = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final long l() {
/* 644 */     return this.h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean m() {
/* 654 */     return this.j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(boolean paramBoolean) {
/* 665 */     this.j = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */