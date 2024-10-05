/*     */ package org.a.c.h;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.SequenceInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import org.a.a.a.a;
/*     */ import org.a.a.a.c;
/*     */ import org.a.c.a.a;
/*     */ import org.a.c.b.a;
/*     */ import org.a.c.b.b;
/*     */ import org.a.c.b.d;
/*     */ import org.a.c.b.g;
/*     */ import org.a.c.b.j;
/*     */ import org.a.c.b.l;
/*     */ import org.a.c.b.p;
/*     */ import org.a.c.h.a.a;
/*     */ import org.a.c.h.a.c;
/*     */ import org.a.c.h.a.h;
/*     */ import org.a.c.h.a.i;
/*     */ import org.a.c.h.g.b.a;
/*     */ import org.a.c.h.g.b.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements a, c
/*     */ {
/*  60 */   private static final a a = c.a(e.class);
/*     */   
/*     */   private final d b;
/*     */   
/*     */   private j c;
/*     */   
/*     */   private k d;
/*     */   
/*     */   private h e;
/*     */ 
/*     */   
/*     */   public e() {
/*  72 */     this(h.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(h paramh) {
/*  82 */     this.b = new d();
/*  83 */     this.b.a(j.dN, (b)j.cK);
/*  84 */     this.b.a(j.ci, (c)paramh);
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
/*     */   e(d paramd, k paramk) {
/* 104 */     this.b = paramd;
/* 105 */     this.d = paramk;
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
/* 116 */     return this.b;
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
/*     */   public final InputStream a() {
/*     */     b b;
/* 155 */     if (b = this.b.a(j.af) instanceof p)
/*     */     {
/* 157 */       return (InputStream)((p)b).k();
/*     */     }
/* 159 */     if (b instanceof a && ((a)b).b() > 0) {
/*     */       
/* 161 */       a a1 = (a)b;
/* 162 */       byte[] arrayOfByte = { 10 };
/* 163 */       ArrayList<g> arrayList = new ArrayList();
/* 164 */       for (byte b1 = 0; b1 < a1.b(); b1++) {
/*     */         b b2;
/*     */         
/* 167 */         if (b2 = a1.a(b1) instanceof p) {
/*     */           
/* 169 */           p p = (p)b2;
/* 170 */           arrayList.add(p.k());
/* 171 */           arrayList.add(new ByteArrayInputStream(arrayOfByte));
/*     */         } 
/*     */       } 
/* 174 */       return new SequenceInputStream((Enumeration)Collections.enumeration(arrayList));
/*     */     } 
/* 176 */     return new ByteArrayInputStream(new byte[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean c() {
/*     */     b b;
/* 185 */     if (b = this.b.a(j.af) instanceof p)
/*     */     {
/* 187 */       return (((p)b).a() > 0);
/*     */     }
/* 189 */     if (b instanceof a)
/*     */     {
/* 191 */       return (((a)b).b() > 0);
/*     */     }
/* 193 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final j d() {
/* 202 */     if (this.c == null) {
/*     */       b b;
/*     */ 
/*     */ 
/*     */       
/* 207 */       if (b = h.a(this.b, j.dg) instanceof d)
/*     */       {
/* 209 */         this.c = new j((d)b, this.d);
/*     */       }
/*     */     } 
/* 212 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(j paramj) {
/* 222 */     this.c = paramj;
/* 223 */     if (paramj != null) {
/*     */       
/* 225 */       this.b.a(j.dg, paramj);
/*     */       
/*     */       return;
/*     */     } 
/* 229 */     this.b.m(j.dg);
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
/*     */   public final h e() {
/* 275 */     if (this.e == null) {
/*     */       b b;
/*     */       
/* 278 */       if (b = h.a(this.b, j.ci) instanceof a)
/*     */       {
/* 280 */         this.e = new h((a)b);
/*     */       }
/*     */     } 
/* 283 */     if (this.e == null)
/*     */     {
/*     */       
/* 286 */       this.e = h.a;
/*     */     }
/* 288 */     return this.e;
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
/*     */   public final h g() {
/*     */     b b;
/* 318 */     if (b = h.a(this.b, j.aj) instanceof a)
/*     */     {
/* 320 */       return a(new h((a)b));
/*     */     }
/*     */ 
/*     */     
/* 324 */     return e();
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
/*     */   private h a(h paramh) {
/* 460 */     h h1 = e();
/*     */     h h2;
/* 462 */     (h2 = new h()).a(Math.max(h1.c(), paramh.c()));
/* 463 */     h2.b(Math.max(h1.d(), paramh.d()));
/* 464 */     h2.c(Math.min(h1.e(), paramh.e()));
/* 465 */     h2.d(Math.min(h1.g(), paramh.g()));
/* 466 */     return h2;
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
/*     */   public final int h() {
/*     */     b b;
/* 480 */     if (b = h.a(this.b, j.dj) instanceof l) {
/*     */       int i;
/*     */       
/* 483 */       if ((i = ((l)b).c()) % 90 == 0)
/*     */       {
/* 485 */         return (i % 360 + 360) % 360;
/*     */       }
/*     */     } 
/* 488 */     return 0;
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
/*     */   public final void a(i parami) {
/* 508 */     this.b.a(j.af, (c)parami);
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
/*     */   public final List<b> i() {
/* 663 */     return a(new f(this));
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
/*     */   private List<b> a(a parama) {
/*     */     b b;
/* 685 */     if (b = this.b.a(j.i) instanceof a) {
/*     */       
/* 687 */       a a1 = (a)b;
/* 688 */       ArrayList<b> arrayList = new ArrayList();
/* 689 */       for (byte b1 = 0; b1 < a1.b(); b1++) {
/*     */         b b2;
/*     */         
/* 692 */         if ((b2 = a1.a(b1)) != null) {
/*     */ 
/*     */ 
/*     */           
/* 696 */           b b3 = b.a(b2);
/*     */ 
/*     */           
/* 699 */           arrayList.add(b3);
/*     */         } 
/*     */       } 
/* 702 */       return (List<b>)new a(arrayList, a1);
/*     */     } 
/* 704 */     return (List<b>)new a(this.b, j.i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(List<b> paramList) {
/* 714 */     this.b.a(j.i, (b)a.b(paramList));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 720 */     return (paramObject instanceof e && ((e)paramObject).b() == b());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 726 */     return this.b.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Program Files (x86)\Steam\steamapps\common\Infinitode 2\infinitode-2.jar!\org\a\c\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */