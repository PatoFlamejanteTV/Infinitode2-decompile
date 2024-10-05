/*     */ package org.a.c.h;
/*     */ 
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.m;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.e.u;
/*     */ import org.a.c.h.e.w;
/*     */ import org.a.c.h.f.a.f;
/*     */ import org.a.c.h.f.c.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */   implements c
/*     */ {
/*     */   private final d a;
/*     */   private final k b;
/*  57 */   private final Map<org.a.c.b.j, SoftReference<u>> c = new HashMap<org.a.c.b.j, SoftReference<u>>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j() {
/*  65 */     this.a = new d();
/*  66 */     this.b = null;
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
/*     */   public j(d paramd, k paramk) {
/*  92 */     if (paramd == null)
/*     */     {
/*  94 */       throw new IllegalArgumentException("resourceDictionary is null");
/*     */     }
/*  96 */     this.a = paramd;
/*  97 */     this.b = paramk;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private d c() {
/* 106 */     return this.a;
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
/*     */   public final u a(org.a.c.b.j paramj) {
/* 120 */     m m = a(org.a.c.b.j.be, paramj);
/* 121 */     if (this.b != null && m != null) {
/*     */       u u1;
/*     */       
/* 124 */       if ((u1 = this.b.a(m)) != null)
/*     */       {
/* 126 */         return u1;
/*     */       }
/*     */     }
/* 129 */     else if (m == null) {
/*     */       SoftReference<u> softReference;
/*     */       
/* 132 */       if ((softReference = this.c.get(paramj)) != null) {
/*     */         u u1;
/*     */         
/* 135 */         if ((u1 = softReference.get()) != null)
/*     */         {
/* 137 */           return u1;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     u u = null;
/*     */     d d1;
/* 144 */     if ((d1 = (d)b(org.a.c.b.j.be, paramj)) != null)
/*     */     {
/* 146 */       u = w.a(d1, this.b);
/*     */     }
/*     */     
/* 149 */     if (this.b != null && m != null) {
/*     */       
/* 151 */       this.b.a(m, u);
/*     */     }
/* 153 */     else if (m == null) {
/*     */       
/* 155 */       this.c.put(paramj, new SoftReference<u>(u));
/*     */     } 
/* 157 */     return u;
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
/*     */   public final f b(org.a.c.b.j paramj) {
/* 169 */     return a(paramj, false);
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
/*     */   public final f a(org.a.c.b.j paramj, boolean paramBoolean) {
/*     */     f f;
/* 184 */     m m = a(org.a.c.b.j.ac, paramj);
/* 185 */     if (this.b != null && m != null)
/*     */     {
/*     */       
/* 188 */       if ((f = this.b.b(m)) != null)
/*     */       {
/* 190 */         return f;
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     b b;
/*     */     
/* 197 */     if ((b = b(org.a.c.b.j.ac, paramj)) != null) {
/*     */       
/* 199 */       f = f.a(b, this, paramBoolean);
/*     */     }
/*     */     else {
/*     */       
/* 203 */       f = f.a((b)paramj, this, paramBoolean);
/*     */     } 
/*     */ 
/*     */     
/* 207 */     if (this.b != null && !(f instanceof org.a.c.h.f.a.t))
/*     */     {
/* 209 */       this.b.a(m, f);
/*     */     }
/* 211 */     return f;
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
/*     */   public final boolean c(org.a.c.b.j paramj) {
/* 223 */     return (b(org.a.c.b.j.ac, paramj) != null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private m a(org.a.c.b.j paramj1, org.a.c.b.j paramj2) {
/*     */     d d1;
/* 471 */     if ((d1 = (d)this.a.a(paramj1)) == null)
/*     */     {
/* 473 */       return null;
/*     */     }
/*     */     b b;
/* 476 */     if (b = d1.n(paramj2) instanceof m)
/*     */     {
/* 478 */       return (m)b;
/*     */     }
/*     */     
/* 481 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private b b(org.a.c.b.j paramj1, org.a.c.b.j paramj2) {
/*     */     d d1;
/* 490 */     if ((d1 = (d)this.a.a(paramj1)) == null)
/*     */     {
/* 492 */       return null;
/*     */     }
/* 494 */     return d1.a(paramj2);
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
/*     */   public final Iterable<org.a.c.b.j> a() {
/* 524 */     return d(org.a.c.b.j.be);
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
/*     */   private Iterable<org.a.c.b.j> d(org.a.c.b.j paramj) {
/*     */     d d1;
/* 575 */     if ((d1 = (d)this.a.a(paramj)) == null)
/*     */     {
/* 577 */       return Collections.emptySet();
/*     */     }
/* 579 */     return d1.d();
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
/*     */   public final org.a.c.b.j a(u paramu) {
/* 591 */     return a(org.a.c.b.j.be, "F", (c)paramu);
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
/*     */   public final org.a.c.b.j a(f paramf) {
/* 603 */     return a(org.a.c.b.j.ac, "cs", (c)paramf);
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
/*     */   public final org.a.c.b.j a(b paramb) {
/* 670 */     return a(org.a.c.b.j.ee, "Im", (c)paramb);
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
/*     */   private org.a.c.b.j a(org.a.c.b.j paramj, String paramString, c paramc) {
/*     */     d d1;
/* 705 */     if ((d1 = (d)this.a.a(paramj)) != null && d1.a(paramc.f()))
/*     */     {
/* 707 */       return d1.b(paramc.f());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 712 */     if (d1 != null && org.a.c.b.j.be.equals(paramj))
/*     */     {
/* 714 */       for (Iterator<Map.Entry> iterator = d1.e().iterator(); iterator.hasNext();) {
/*     */         
/* 716 */         if ((entry = iterator.next()).getValue() instanceof m && paramc
/* 717 */           .f() == ((m)entry.getValue()).a())
/*     */         {
/* 719 */           return (org.a.c.b.j)entry.getKey();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 725 */     org.a.c.b.j j1 = a(paramj, paramString);
/* 726 */     a(paramj, j1, paramc);
/* 727 */     return j1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private org.a.c.b.j a(org.a.c.b.j paramj, String paramString) {
/*     */     d d1;
/* 736 */     if ((d1 = (d)this.a.a(paramj)) == null)
/*     */     {
/* 738 */       return org.a.c.b.j.a(paramString + '\001');
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 743 */     int i = d1.d().size();
/*     */     
/*     */     while (true) {
/* 746 */       i++;
/* 747 */       String str = paramString + i;
/*     */       
/* 749 */       if (!d1.b(str)) {
/* 750 */         return org.a.c.b.j.a(str);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(org.a.c.b.j paramj1, org.a.c.b.j paramj2, c paramc) {
/*     */     d d1;
/* 759 */     if ((d1 = (d)this.a.a(paramj1)) == null) {
/*     */       
/* 761 */       d1 = new d();
/* 762 */       this.a.a(paramj1, (b)d1);
/*     */     } 
/* 764 */     d1.a(paramj2, paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(org.a.c.b.j paramj, u paramu) {
/* 775 */     a(org.a.c.b.j.be, paramj, (c)paramu);
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
/*     */   public final k b() {
/* 851 */     return this.b;
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */